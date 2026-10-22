package rj5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.icon.IconSize;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 extends com.bytedance.ee.bear.more.protocol3.g {

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ h0 a;

        public b(h0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r24) {
            h0 r1 = this.a;
            oj5.c r2 = r1.c();
            if (r2 == null) goto L41;
            Fragment r3 = r1.getHost().getHostFragment();
            Map<String, String> r4 = r2.M();
            if (r4 == null) goto L8;
            String r5 = r4.get(com.bytedance.ee.bear.more.protocol3.f.i0.c.a);
        L9:
            if (r5 == null) goto L14;
            Context r6 = r3.getContext();
            if (r6 == null) goto L13;
            Toast.showFailureText(r6, r5, 0);
        L13:
            tt5.a.h("TransferApplyItem", "block disabled transfer owner operation.");
            return;
        L14:
            FragmentActivity r7 = r3.getActivity();
            if (r7 != null) goto L18;
            return;
        L18:
            if (com.bytedance.ee.util.ui.b.a(r7) == false) goto L43;
            String r9 = r2.getToken();
            int r8 = r2.getType();
            String r11 = r2.getTitle();
            String r12 = r2.getUrl();
            oj5.c r10 = r1.c();
            if (r10 != null) goto L24;
            int r13 = sbb.e.e.b;
            IconSize r14 = IconSize.SIZE_24;
            int r15 = ua5.a.i(r13);
        L38:
            ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).a(r7, new i0(new TransferApplyInfo(r8, r9, null, r11, r12, r15, null, false, false, false, 0, false, r2.isShareFolder(), 4036, null), r7, r3, r1), r3);
            return;
        L24:
            int r16 = r10.getType();
            if (r16 != sbb.e.n.b) goto L28;
            int r17 = r10.i();
            String r18 = r10.getTitle();
            IconSize r19 = IconSize.SIZE_24;
            r15 = ua5.a.k(r17, r18);
            goto L38
        L28:
            if (r16 != sbb.e.l.b) goto L31;
            String r20 = r10.b();
            IconSize r21 = IconSize.SIZE_24;
            r15 = ua5.a.h(r20);
            goto L38
        L31:
            if (r16 == sbb.e.f.b) goto L33;
        L37:
            IconSize r22 = IconSize.SIZE_24;
            r15 = ua5.a.i(r16);
            goto L38
        L33:
            if (r10.E() == true) goto L36;
            FolderVersion.a r110 = FolderVersion.Companion;
            int r111 = r10.C();
            boolean r23 = r10.isShareFolder();
            r110.getClass();
            if (FolderVersion.a.b(r111, r23) == false) goto L37;
        L36:
            r15 = rbb.b.g();
            goto L38
        L43:
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        oj5.c r0 = c();
        if (r0 != null) goto L5;
        return null;
    L5:
        com.bytedance.ee.bear.more.protocol3.f.i0 r3 = com.bytedance.ee.bear.more.protocol3.f.i0.c;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r1 = jg5.e.a.a;
        int r2 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r4 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.docs.all.transfer_ownership");
        tt5.a.h("PermFGUtils", "enableTransferOwnerShip()...enable = " + r4);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r3, null, CollectionsKt.listOf(new BizChecker[]{new BizChecker(r0.isOwner()), new BizChecker(r4)}), null, new b(this), 10);
    }

    public h0() {
    }
}
