package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    public static final class a {
    }

    public final class b extends ff5.a<ef5.a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f231426a;

        public b(a0 r100) {
            this.f231426a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.a0 r101 = (ef5.a0) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            kf5.b r102 = this.f231426a.getContext().d();
            if (r102 == null) goto L7;
            boolean r103 = true;
            if (r102.isShowing() != true) goto L7;
        L8:
            String r104 = "Comment#PrivateIconHandleAddin" + r101.hashCode();
            if (r103 == false) goto L13;
            kf5.b r105 = this.f231426a.getContext().d();
            if (r105 == null) goto L13;
            r105.a(r104);
        L13:
            tt5.a.h("Comment#PrivateIconHandleAddin", "onHandle PrivateIconClickEvent... isWhole = " + r101.f472436a + ", isInputShowing = " + r103);
            sbb.e r106 = this.f231426a.b().a().getConfig().f232235k;
            UDDialogBuilder r107 = new UDDialogBuilder(this.f231426a.getContext().getConfig().getActivity()).title(R.string.LarkCCM_Docs_PrivateCmt_PrivateOn_Note_Title);
            int r108 = com.bytedance.ee.bear.middleground.comment.card.e.f230973a;
            if (Intrinsics.areEqual(r106, sbb.e.f541298i) == false) goto L17;
            int r109 = R.string.LarkCCM_PrivateCmt_Base_MobileSet_Desc;
        L23:
            r107.message(r109).addActionButton(R.id.ud_dialog_btn_primary, R.string.LarkCCM_Docs_PrivateCmt_PrivateOn_GotIt_Button, null).onDismissListener(new b0(r103, this.f231426a, r104)).show();
            return;
        L17:
            if (com.bytedance.ee.bear.middleground.comment.card.e.b(r106) == false) goto L20;
            r109 = R.string.LarkCCM_PrivateCmt_MentionsOwner_MobileSet_Desc;
            goto L23
        L20:
            if (r101.f472436a == false) goto L22;
            r109 = R.string.LarkCCM_Docs_FullText_PrivateCmt_PrivateOn_Notice;
            goto L23
        L22:
            r109 = R.string.LarkCCM_Docs_PrivateCmt_PrivateOn_VC_Stauts;
        L7:
            r103 = false;
            goto L8
        }
    }

    static {
    }

    public a0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
        r100.b(ef5.a0.class, new b(this));
    }
}
