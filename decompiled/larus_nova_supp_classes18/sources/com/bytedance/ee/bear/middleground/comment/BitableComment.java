package com.bytedance.ee.bear.middleground.comment;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.comment.bitablediscuss.BitableDiscussFunction;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.t;
import com.bytedance.ee.bear.middleground.comment.export.v;
import com.bytedance.ee.bear.middleground.comment.input.t1;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BitableComment extends Comment {
    public static final /* synthetic */ int B0 = 0;
    public final ye5.a A0;

    public static final class a {
    }

    public static final class b extends bb5.i {
        public final /* synthetic */ BitableComment a;

        public b(BitableComment r1) {
            this.a = r1;
        }

        public final void a(Dialog r4) {
            Intrinsics.checkNotNullParameter(r4, "dialog");
            BitableComment r0 = this.a;
            if (r0.r.V == false) goto L14;
            p1 r1 = r0.o;
            boolean r2 = false;
            if (r1 != null) goto L7;
        L9:
            if (r2 == false) goto L15;
            Window r5 = r4.getWindow();
            if (r5 == null) goto L16;
            WindowManager.LayoutParams r3 = r5.getAttributes();
            r3.type = 2;
            r5.setAttributes(r3);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            if (r1.isShowing() != true) goto L9;
            r2 = true;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.Comment
    public final y w1() {
        return new BitableDiscussFunction(this.r, this.x, this.w, new com.bytedance.ee.bear.middleground.comment.bitablediscuss.b(new BitableComment$createNewCardUIFunction$1(this)));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.Comment
    public final p1 x1() {
        if (this.o != null) goto L6;
        this.o = new com.bytedance.ee.bear.middleground.comment.bitablediscuss.g(this.r, this.x, this.w, this.y);
    L6:
        return super.x1();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.Comment
    public final boolean z1() {
        p1 r0 = this.o;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        if ((this.o instanceof com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) == false) goto L12;
        return true;
    L12:
        return super.z1();
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.Comment
    public final kf5.b y1(CommentInputRequest r14) {
        Intrinsics.checkNotNullParameter(r14, "arg");
        return t1.a(this.r, this.x, this.w, new BitableComment$initInputComment$1(this), r14, new BitableComment$initInputComment$2(this), new BitableComment$initInputComment$3(this), z1(), new BitableComment$initInputComment$4(this), new b(this), null, 5120);
    }

    public BitableComment(FragmentActivity r40, FrameLayout r41, FrameLayout r42, FrameLayout r43, FragmentManager r44, String r45, String r46, sbb.e r47, boolean r48, String r49, long r50, long r52, com.bytedance.ee.bear.middleground.comment.export.o r54, boolean r55, boolean r56, boolean r57, pcb.a r58, CommentStyle r59, boolean r60, boolean r61, v r62, boolean r63, com.bytedance.ee.bear.middleground.comment.export.g r64, Function1 r65, com.bytedance.ee.bear.middleground.comment.export.m r66, boolean r67, t r68, bf5.a r69, boolean r70, Fragment r71, boolean r72, com.bytedance.ee.bear.middleground.comment.export.k r73, ye5.a r74) {
        Intrinsics.checkNotNullParameter(r40, "activity");
        Intrinsics.checkNotNullParameter(r41, "viewParent");
        Intrinsics.checkNotNullParameter(r42, "imageViewerParent");
        Intrinsics.checkNotNullParameter(r43, "reactionAnimationParent");
        Intrinsics.checkNotNullParameter(r44, "fragmentManager");
        Intrinsics.checkNotNullParameter(r45, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r46, "docUrl");
        Intrinsics.checkNotNullParameter(r47, "pageType");
        Intrinsics.checkNotNullParameter(r49, "subFileType");
        Intrinsics.checkNotNullParameter(r54, "per");
        Intrinsics.checkNotNullParameter(r58, "keyboardHeightProvider");
        Intrinsics.checkNotNullParameter(r59, "commentStyle");
        Intrinsics.checkNotNullParameter(r65, "readMessage");
        Intrinsics.checkNotNullParameter(r73, "commentHostDelegate");
        super(r40, r41, null, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, false, r71, r72, r73, null);
        this.A0 = r74;
    }
}
