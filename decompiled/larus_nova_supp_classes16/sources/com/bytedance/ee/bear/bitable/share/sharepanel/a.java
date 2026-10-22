package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements com.bytedance.ee.bear.share.export.b, com.bytedance.ee.bear.share.export.c {
    public final com.bytedance.ee.bear.share.export.e a;
    public final boolean b;
    public final CompositeDisposable c;
    public com.bytedance.ee.bear.share.export.d d;
    public boolean e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.sharepanel.a$a, reason: collision with other inner class name */
    public static final class C0018a {
        public static List a(List r4, boolean r5, boolean r6, Function0 r7) {
            Intrinsics.checkNotNullParameter(r4, "externalConfig");
            Intrinsics.checkNotNullParameter(r7, "qrCodeItemProvider");
            List r8 = CollectionsKt.toMutableList(r4);
            if (r5 == true) goto L6;
        L45:
            return r8;
        L6:
            if (r6 == true) goto L11;
            if (r8.size() <= 1) goto L45;
            ListProtector.add(r8, 2, r7.invoke());
            goto L45
        L11:
            if (r8.isEmpty() == true) goto L45;
            List r9 = r8;
            if ((r9 instanceof Collection) == true) goto L15;
        L17:
            Iterator r0 = r9.iterator();
        L19:
            if (r0.hasNext() == false) goto L26;
            if (((ShareItemModel) r0.next()).getType() != ShareType.QRCode) goto L23;
            boolean r2 = true;
        L24:
            if (r2 == false) goto L19;
            boolean r1 = true;
        L27:
            if (r1 == true) goto L45;
            ShareItemModel r10 = (ShareItemModel) r7.invoke();
            Iterator r11 = r9.iterator();
        L31:
            if (r11.hasNext() == false) goto L38;
            Object r3 = r11.next();
            if (((ShareItemModel) r3).getType() != ShareType.CopyLink) goto L35;
            boolean r12 = true;
        L36:
            if (r12 == false) goto L31;
        L39:
            ShareItemModel r13 = (ShareItemModel) r3;
            if (r13 != null) goto L42;
            r13 = (ShareItemModel) CollectionsKt.firstOrNull(r8);
        L42:
            if (r13 == null) goto L44;
            r10.setShareIconStyle(r13.getShareIconStyle());
            r10.setSrcTint(r13.getSrcTint());
            r10.setShareItemBackground(r13.getShareItemBackground());
        L44:
            ListProtector.add(r8, Math.min(1, r8.size()), r10);
            goto L45
        L35:
            r12 = false;
            goto L36
        L38:
            r3 = null;
            goto L39
        L23:
            r2 = false;
        L26:
            r1 = false;
            goto L27
        L15:
            if (r9.isEmpty() == false) goto L17;
            goto L17
        }
    }

    static {
    }

    public void j() {
    }

    public void w() {
    }

    public void x1() {
    }

    public final boolean a() {
        tt5.a.h("ShareActionDelegateImpl", "onCopyLink()...");
        boolean r1 = true;
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        EShareType r2 = r().getShareType();
        Intrinsics.checkNotNullParameter(r2, "shareType");
        EShareType r3 = EShareType.BASE_ADD;
        if (r2 != r3) goto L9;
    L12:
        if (r2 == r3) goto L15;
        r1 = false;
    L15:
        mu4.f.e("copy_link", r1);
    L16:
        return false;
    L9:
        if (r2 == EShareType.BASE_ADD_SUBMIT) goto L12;
        mu4.f.c("copy_link", "none", r2);
        goto L16
    }

    public final boolean c() {
        tt5.a.h("ShareActionDelegateImpl", "onShareToWeibo()...");
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        EShareType r1 = r().getShareType();
        Intrinsics.checkNotNullParameter(r1, "shareType");
        mu4.f.c("share_weibo", "none", r1);
        return false;
    }

    public final boolean d() {
        tt5.a.h("ShareActionDelegateImpl", "onShareToLark()...");
        boolean r1 = true;
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        EShareType r2 = r().getShareType();
        Intrinsics.checkNotNullParameter(r2, "shareType");
        EShareType r3 = EShareType.BASE_ADD;
        if (r2 != r3) goto L9;
    L12:
        if (r2 == r3) goto L15;
        r1 = false;
    L15:
        mu4.f.e("share_to_feishu", r1);
    L16:
        return false;
    L9:
        if (r2 == EShareType.BASE_ADD_SUBMIT) goto L12;
        mu4.f.c("share_lark", "ccm_permission_share_lark_view", r2);
        goto L16
    }

    public final boolean e() {
        tt5.a.h("ShareActionDelegateImpl", "onShareMore()...");
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        mu4.f.c("share_more", "none", EShareType.FORM);
        return false;
    }

    public final boolean f() {
        tt5.a.h("ShareActionDelegateImpl", "onShareToWechatMoments()...");
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        EShareType r1 = r().getShareType();
        Intrinsics.checkNotNullParameter(r1, "shareType");
        mu4.f.c("share_wechat_moments", "none", r1);
        return false;
    }

    public final boolean h() {
        tt5.a.h("ShareActionDelegateImpl", "onShareToQQ()...");
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        EShareType r1 = r().getShareType();
        Intrinsics.checkNotNullParameter(r1, "shareType");
        mu4.f.c("share_qq", "none", r1);
        return false;
    }

    public final boolean l() {
        tt5.a.h("ShareActionDelegateImpl", "onShareToWechat()...");
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r0 = mu4.f.a;
        EShareType r1 = r().getShareType();
        Intrinsics.checkNotNullParameter(r1, "shareType");
        mu4.f.c("share_wechat", "none", r1);
        return false;
    }

    public void onDestory() {
        com.bytedance.ee.bear.share.export.e r0 = this.a;
        if (r0 == null) goto L5;
        r0.onDestory();
    L5:
        this.c.dispose();
    }

    public void onResume() {
        com.bytedance.ee.bear.share.export.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public void onViewCreated() {
        com.bytedance.ee.bear.share.export.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.onViewCreated();
        return;
    }

    public final com.bytedance.ee.bear.share.export.d p() {
        com.bytedance.ee.bear.share.export.d r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("shareHost");
        return null;
    }

    public final boolean v() {
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Integer y1() {
        if (this.b == true) goto L7;
        return null;
    L7:
        return 2;
    }

    public String g() {
        return o().getDocName();
    }

    public final BitableShareParams o() {
        BitableShareParams r0 = p().l80();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams");
        return r0;
    }

    public final String q() {
        String r0 = o().getUrl();
        if (TextUtils.isEmpty(r0) == true) goto L9;
        s45.l r1 = s45.p.a().m8(r0);
        if (TextUtils.isEmpty(r1.c) == true) goto L9;
        return r1.c;
    L9:
        return ((b0) org.koin.java.a.c(b0.class, null, null, 6)).o();
    }

    public final IShareMeta r() {
        return o().getBitableShareMeta();
    }

    public Map<String, String> s() {
        return MapsKt.emptyMap();
    }

    public a(com.bytedance.ee.bear.share.export.e r2) {
        this.a = r2;
        this.b = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.use_new_share_to_lark");
        this.c = new CompositeDisposable();
    }

    public static View m(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        RelativeLayout r0 = new RelativeLayout(r4);
        View r1 = new View(r4);
        r1.setBackgroundColor(r4.getResources().getColor(2131108899));
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, -1);
        r5.leftMargin = com.bytedance.ee.util.ui.n.d(16);
        r1.setLayoutParams(r5);
        r0.addView(r1);
        r0.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, 1));
        return r0;
    }

    public static SpaceSettingGroupLayout t(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        SpaceSettingGroupLayout r0 = new SpaceSettingGroupLayout(r3);
        r0.setItemBackgroundColor(2131101932);
        r0.setDividerBackgroundColor(2131100557);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
        int r1 = com.bytedance.ee.util.ui.n.d(16);
        r4.leftMargin = r1;
        r4.rightMargin = r1;
        r4.topMargin = r1;
        r0.setLayoutParams(r4);
        return r0;
    }

    public static void u(List r3) {
        Intrinsics.checkNotNullParameter(r3, "shareItems");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.base.form_hide_three_party_share.enable") == true) goto L5;
        return;
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L17;
        ShareItemModel r0 = (ShareItemModel) r4.next();
        if (r0.getType() == ShareType.Wechat) goto L16;
        if (r0.getType() == ShareType.WechatMoments) goto L16;
        if (r0.getType() == ShareType.Weibo) goto L16;
        if (r0.getType() != ShareType.QQ) goto L7;
    L16:
        r0.setState(ShareState.NOT_SHOW);
        goto L7
    }

    public final void b(com.bytedance.ee.bear.share.export.d r2) {
        Intrinsics.checkNotNullParameter(r2, "shareHost");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
        com.bytedance.ee.bear.share.export.e r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public boolean k(String r2) {
        tt5.a.h("ShareActionDelegateImpl", "onQRCode()...");
        if (this.e == true) goto L6;
        w();
        return true;
    L6:
        int r3 = mu4.f.a;
        mu4.f.h("click_qrcode", r().getShareType());
        return false;
    }

    public String n(String r4) {
        Intrinsics.checkNotNullParameter(r4, "shareToken");
        Uri.Builder r5 = new Uri.Builder().scheme("https").authority(q()).path("share/base/" + o().getBitableShareMeta().getShareType().getModule() + '/' + r4);
        Iterator<Map.Entry<String, String>> r0 = s().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r0.next();
        r5.appendQueryParameter(r1.getKey(), r1.getValue());
        goto L4
    L7:
        return r5.build().toString();
    }

    public final void x(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        if (ax4.d.b(r3, PreviewStatus.OVER_MUCH_NODES_IN_TOTAL) == false) goto L5;
    L8:
        Toast.showFailureText(p().requireContext(), 2131887321);
        return;
    L5:
        if (ax4.d.b(r3, 4) == true) goto L8;
        Toast.showFailureText(p().requireContext(), p().requireContext().getString(2131888226));
    }

    public void y(boolean r4) {
        this.e = r4;
        List r0 = p().ul();
        if (r4 == true) goto L8;
        Iterator r5 = r0.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        ((ShareItemModel) r5.next()).setState(ShareState.NOT_CLICK);
    L8:
        p().L30(r0);
        p().YH();
    }
}
