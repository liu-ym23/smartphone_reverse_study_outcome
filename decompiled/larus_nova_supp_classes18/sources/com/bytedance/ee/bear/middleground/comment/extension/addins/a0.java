package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    public static final class a {
    }

    public final class b extends ff5.a<ef5.a0> {
        public final /* synthetic */ a0 a;

        public b(a0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.a0 r7 = (ef5.a0) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            kf5.b r0 = this.a.getContext().d();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isShowing() != true) goto L7;
        L8:
            String r2 = "Comment#PrivateIconHandleAddin" + r7.hashCode();
            if (r1 == false) goto L13;
            kf5.b r3 = this.a.getContext().d();
            if (r3 == null) goto L13;
            r3.a(r2);
        L13:
            tt5.a.h("Comment#PrivateIconHandleAddin", "onHandle PrivateIconClickEvent... isWhole = " + r7.a + ", isInputShowing = " + r1);
            sbb.e r4 = this.a.b().a().getConfig().k;
            UDDialogBuilder r5 = new UDDialogBuilder(this.a.getContext().getConfig().getActivity()).title(2131889224);
            int r8 = com.bytedance.ee.bear.middleground.comment.card.e.a;
            if (Intrinsics.areEqual(r4, sbb.e.i) == false) goto L17;
            int r9 = 2131889707;
        L23:
            r5.message(r9).addActionButton(2131391777, 2131889222, null).onDismissListener(new b0(r1, this.a, r2)).show();
            return;
        L17:
            if (com.bytedance.ee.bear.middleground.comment.card.e.b(r4) == false) goto L20;
            r9 = 2131889710;
            goto L23
        L20:
            if (r7.a == false) goto L22;
            r9 = 2131889071;
            goto L23
        L22:
            r9 = 2131889226;
        L7:
            r1 = false;
            goto L8
        }
    }

    static {
    }

    public a0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.a0.class, new b(this));
    }
}
