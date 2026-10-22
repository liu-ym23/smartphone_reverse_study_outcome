package com.bytedance.ee.bear.document.imageviewer.areacomment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.doc.follow.event.KeyboardStateChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final Context a;
    public final IImageViewer b;
    public final CommentPlugin c;
    public final View d;
    public final CommentRectLayout e;
    public final TextView f;
    public final BaseUnspecifiedOrientationPlugin<?> g;
    public final f h;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r3.getAction() != 0) goto L9;
            CommentRectF r4 = this.a.e.o(r3.getX(), r3.getY());
            if (r4 == null) goto L10;
            tt5.a.h("ImageCommentAreaView", "click comment: " + r4);
            this.a.c.switchComment(r4.b);
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            tt5.a.h("ImageCommentAreaView", "onViewAttachedToWindow");
            e r5 = this.a;
            TextView r0 = r5.f;
            if (r5.c.canComment() == false) goto L5;
            int r6 = 0;
        L6:
            r0.setVisibility(r6);
            e r7 = this.a;
            BaseUnspecifiedOrientationPlugin<?> r1 = r7.g;
            if (r1 == null) goto L9;
            r1.onOrientationSupportPanelShowing(r7.h);
        L9:
            FollowPlugin r8 = (FollowPlugin) this.a.c.getHost().findPlugin(FollowPlugin.class);
            if (r8 == null) goto L15;
            BaseFollowImpl r9 = r8.getDocumentFollow();
            if (r9 == null) goto L16;
            r9.processContentEvent(new KeyboardStateChangedEvent(false, true));
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r6 = 8;
            goto L6
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            tt5.a.h("ImageCommentAreaView", "onViewDetachedFromWindow");
            CommentRectLayout r4 = this.a.e;
            r4.B = null;
            r4.J.invalidate();
            e r5 = this.a;
            BaseUnspecifiedOrientationPlugin<?> r0 = r5.g;
            if (r0 == null) goto L5;
            r0.onOrientationSupportPanelDismiss(r5.h);
        L5:
            FollowPlugin r6 = (FollowPlugin) this.a.c.getHost().findPlugin(FollowPlugin.class);
            if (r6 == null) goto L11;
            BaseFollowImpl r7 = r6.getDocumentFollow();
            if (r7 == null) goto L12;
            r7.processContentEvent(new KeyboardStateChangedEvent(false, false));
            return;
        L12:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.c.closeCommentCards();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            e r3 = this.a;
            CommentPlugin r0 = r3.c;
            ImageData.Image r4 = r3.b.c7();
            if (r4 == null) goto L5;
            String r5 = r4.getUuid();
        L6:
            if (r5 != null) goto L8;
            r5 = "";
        L8:
            r0.addImageComment(r5);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.imageviewer.areacomment.e$e, reason: collision with other inner class name */
    public static final class C0080e {
    }

    public static final class f implements p {
        public final /* synthetic */ e a;

        @Override // com.bytedance.ee.bear.document.orientation.p
        public final boolean shouldDisableLandscape() {
            return !ku5.c.k(this.a.getContext());
        }

        public f(e r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public e(Context r2, IImageViewer r3, CommentPlugin r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageViewer");
        Intrinsics.checkNotNullParameter(r4, "commentPlugin");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.h = new f(this);
        this.g = (BaseUnspecifiedOrientationPlugin) r4.getHost().findPlugin(BaseUnspecifiedOrientationPlugin.class);
        View r5 = LayoutInflater.from(r2).inflate(2131559847, null);
        this.d = r5;
        CommentRectLayout r6 = r5.findViewById(2131367305);
        this.e = r6;
        TextView r7 = (TextView) r5.findViewById(2131363802);
        TextView r8 = (TextView) r5.findViewById(2131362225);
        this.f = r8;
        r6.setCommentRectVisible(true);
        r6.setOnTouchListener(new a(this));
        r6.addOnAttachStateChangeListener(new b(this));
        r7.setOnClickListener(new c(this));
        r8.setOnClickListener(new d(this));
    }
}
