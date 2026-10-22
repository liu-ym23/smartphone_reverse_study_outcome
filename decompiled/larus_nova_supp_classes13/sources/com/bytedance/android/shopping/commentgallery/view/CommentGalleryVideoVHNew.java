package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cc3.b;
import cc3.d;
import cc3.e;
import cc3.f;
import cc3.g;
import cc3.k;
import cc3.l;
import cc3.m;
import cc3.n;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.model.response.ECCommentVideo;
import com.bytedance.android.ec.sdk.helper.c;
import com.bytedance.android.shopping.anchorv3.comment.widget.j;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentGalleryVideoVHNew;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lcc3/m;", "Lcc3/l;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryVideoVHNew extends TransitionViewHolder implements m, l {
    public static final /* synthetic */ int p = 0;
    public final String a;
    public b b;
    public final ECVideoPlayerView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final SeekBar g;
    public final ImageView h;
    public final View i;
    public boolean j;
    public boolean k;
    public boolean l;
    public n m;
    public final f n;
    public final boolean o;

    @Override // cc3.m
    public final void J() {
        this.c.x();
        this.c.s();
    }

    @Override // cc3.m
    public final void Q3() {
        if (this.l == true) goto L5;
    L7:
        this.l = false;
        return;
    L5:
        if (this.j == false) goto L7;
        play();
        goto L7
    }

    public final void T3() {
        if (this.c.g() == true) goto L6;
        this.c.m();
        this.h.setVisibility(0);
        return;
    }

    @Override // cc3.m
    public final void k0() {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        this.j = true ^ this.c.g();
        T3();
    }

    public final void play() {
        this.c.n();
        this.h.setVisibility(8);
    }

    @Override // cc3.m
    public final void u0() {
        T3();
    }

    @Override // cc3.m
    public final void z3() {
        play();
    }

    public CommentGalleryVideoVHNew(View r9) {
        Intrinsics.checkNotNullParameter(r9, "itemView");
        super(r9);
        this.o = true;
        this.a = "DJJ, CommentGalleryVideoVHNew[" + hashCode() + ']';
        this.c = (ECVideoPlayerView) r9.findViewById(2131370741);
        TextView r0 = (TextView) r9.findViewById(2131373423);
        this.d = r0;
        TextView r1 = (TextView) r9.findViewById(2131373422);
        this.e = r1;
        TextView r2 = (TextView) r9.findViewById(2131370712);
        this.f = r2;
        SeekBar r3 = (SeekBar) r9.findViewById(2131373414);
        this.g = r3;
        this.h = (ImageView) r9.findViewById(2131373408);
        View r4 = r9.findViewById(2131373420);
        this.i = r4;
        ECStatusView r5 = r9.findViewById(2131373412);
        com.bytedance.android.shopping.extensions.f.e(r0, 600);
        com.bytedance.android.shopping.extensions.f.e(r1, 600);
        if (r2 == null) goto L5;
        com.bytedance.android.shopping.extensions.f.e(r2, 100);
    L5:
        this.n = new f(r9);
        g r6 = new g(this);
        r5.b(r9.getContext(), null, null);
        r3.setOnTouchListener(d.a);
        r3.setOnSeekBarChangeListener(r6);
        r4.setOnClickListener(new e(this));
        getTransitionLayout().setSingleTagDismissEnabled(false);
        getTransitionLayout().setDragTransitionEnabled(false);
    }

    @Override // cc3.m
    public final void B2(b r23) {
        Intrinsics.checkNotNullParameter(r23, "galleryMediaModel");
        if ((r23 instanceof ee3.b) == true) goto L5;
        b r2 = null;
    L6:
        ee3.b r3 = (ee3.b) r2;
        if (r3 == null) goto L9;
        ECCommentVideo r4 = r3.q;
    L10:
        k r5 = r23.o;
        if (r5 == null) goto L13;
        String r6 = r5.f;
    L14:
        if (r4 == null) goto L16;
        String r7 = r4.getVideoId();
    L17:
        if (r6 == null) goto L28;
        if (r7 == null) goto L28;
        if (this.c.b != null) goto L28;
        int r8 = j.a;
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r7, "id");
        c r9 = c.a;
        r9.b("CommentVideoPlayerHelper", "getExternalPlayer, " + r6 + ", null, " + r7 + ", null");
        if (Intrinsics.areEqual(r6, null) == false) goto L26;
        Intrinsics.areEqual(null, r7);
    L26:
        this.c.c();
        r9.b(this.a, "ensureUseSharedPlayer, init player");
    L28:
        if (this.k == true) goto L30;
        this.c.r(this.n);
        this.k = true;
    L30:
        this.b = r23;
        Integer r10 = ((com.bytedance.android.ec.model.k) r23).g;
        int r11 = 0;
        if (r10 == null) goto L33;
        int r12 = r10.intValue();
    L34:
        Integer r13 = ((com.bytedance.android.ec.model.k) r23).h;
        if (r13 == null) goto L37;
        r11 = r13.intValue();
    L37:
        if (r12 <= r11) goto L39;
        this.c.w(ScaleType.FIT_CENTER);
    L40:
        com.bytedance.android.shopping.api.video.d r14 = new com.bytedance.android.shopping.api.video.d(false, !this.o, 0, 0, false, 509);
        if (r4 == null) goto L43;
        com.bytedance.android.shopping.api.video.e r1 = com.bytedance.android.shopping.api.video.m.b(r4, r14);
    L71:
        this.c.b(r1);
        return;
    L43:
        com.bytedance.android.shopping.api.video.k r15 = new com.bytedance.android.shopping.api.video.k();
        String r16 = ((com.bytedance.android.ec.model.k) r23).e;
        if (r16 != null) goto L46;
        r16 = "";
    L46:
        Intrinsics.checkNotNullParameter(r16, "videoKey");
        r15.a = r16;
        String r17 = ((com.bytedance.android.ec.model.k) r23).e;
        if (r17 != null) goto L49;
        r17 = "";
    L49:
        Intrinsics.checkNotNullParameter(r17, "key");
        r15.b = r17;
        String r18 = ((com.bytedance.android.ec.model.k) r23).b;
        if (r18 != null) goto L52;
        r18 = "";
    L52:
        r15.a(r18);
        String r19 = ((com.bytedance.android.ec.model.k) r23).d;
        if (r19 != null) goto L55;
        r19 = "";
    L55:
        r15.a(r19);
        com.bytedance.android.shopping.api.video.b r20 = r15.b();
        if (r20 != null) goto L58;
        return;
    L58:
        Intrinsics.checkNotNullParameter(r20, "playItem");
        ArrayList r110 = new ArrayList();
        r110.add(r20);
        Integer r21 = ((com.bytedance.android.ec.model.k) r23).h;
        if (r21 == null) goto L61;
        int r111 = r21.intValue();
    L62:
        Integer r22 = ((com.bytedance.android.ec.model.k) r23).g;
        if (r22 == null) goto L65;
        int r112 = r22.intValue();
    L66:
        String r24 = ((com.bytedance.android.ec.model.k) r23).e;
        if (r24 != null) goto L69;
        String r25 = "";
    L70:
        Intrinsics.checkNotNullParameter(r25, "newVid");
        Intrinsics.checkNotNullParameter(r14, "options");
        r1 = new com.bytedance.android.shopping.api.video.e(r25, 0, null, r110, null, r14, -1, 0.0f, null, r111, r112, null, null);
        goto L71
    L69:
        r25 = r24;
        goto L70
    L65:
        r112 = -1;
        goto L66
    L61:
        r111 = -1;
        goto L62
    L39:
        this.c.w(ScaleType.CENTER_CROP);
        goto L40
    L33:
        r12 = 0;
        goto L34
    L16:
        r7 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = r23;
        goto L6
    }

    @Override // cc3.m
    public final void V2(n r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m = r2;
    }

    @Override // cc3.l
    public final void onPageSelected(int r4) {
        b r0 = this.b;
        if (r0 == null) goto L11;
        k r1 = r0.o;
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r1.e, "pic") == false) goto L9;
        r1.h = r4;
    L9:
        t53.b r5 = t53.b.a;
        Context r2 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        r5.getClass();
        t53.b.d(r2, r1);
        return;
    }
}
