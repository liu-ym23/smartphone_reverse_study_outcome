package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.net.Uri;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BitableShareCardV2FragmentDelegate extends com.bytedance.ee.bear.bitable.share.sharepanel.a implements CompoundButton.OnCheckedChangeListener {
    public final String f;
    public String g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BitableShareCardV2FragmentDelegate a;

        public b(BitableShareCardV2FragmentDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IShareMeta r5 = (IShareMeta) r4;
            String r0 = r5.getRecordShareToken();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            BitableShareCardV2FragmentDelegate r2 = this.a;
            r2.g = r5.getRecordShareToken();
            BitableShareParams r6 = this.a.o();
            BitableShareCardV2FragmentDelegate r3 = this.a;
            r6.setUrl(r3.n(r3.g));
            this.a.y(true);
            return;
        L12:
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e("BitableShareCardV2FragmentDelegate", "fetchShareRecordToken error", (Throwable) r4, false);
        }
    }

    static {
    }

    public final com.bytedance.ee.bear.share.export.f w1() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public String g() {
        if (r().getShareType() != EShareType.Record) goto L7;
        return "";
    L7:
        return super.g();
    }

    public final String i() {
        return mu4.b.b(p().requireContext(), r().getShareType(), o());
    }

    public void initData() {
        if (o().getBitableShareMeta().getShareToken().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
    L8:
        int r1 = mu4.f.a;
        mu4.f.g(r().getShareType(), o().getBitableShareMeta().isOpen());
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public void onResume() {
        super.onResume();
        if (r().getShareType() != EShareType.Record) goto L6;
        Disposable r0 = ((com.bytedance.ee.bear.share.b) org.koin.java.a.c(com.bytedance.ee.bear.share.b.class, null, null, 6)).f(o().getToken(), o().getTableId(), this.f).subscribe(new b(this), c.a);
        this.c.add(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public void onViewCreated() {
        super.onViewCreated();
        p().AB(mu4.b.c(p().requireContext(), r().getShareType()));
        y(false);
        mu4.f.i();
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void w() {
        if (r().isOpen() == false) goto L6;
        Toast.makeText(p().requireContext(), 2131886836, 0).show();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final boolean k(String r3) {
        if (v() == true) goto L7;
        tt5.a.h("BitableShareCardV2FragmentDelegate", "onQRCode failed due to shareHost unInitialized");
        return false;
    L7:
        if (super.k(r3) == false) goto L9;
        return false;
    L9:
        z(r3);
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public String n(String r4) {
        Intrinsics.checkNotNullParameter(r4, "shareToken");
        Uri.Builder r0 = new Uri.Builder().scheme("https").authority(q());
        StringBuilder r1 = new StringBuilder();
        if (s45.a.c() == false) goto L5;
        String r2 = "/share/base/record/";
    L6:
        r1.append(r2);
        r1.append(r4);
        Uri.Builder r5 = r0.path(r1.toString());
        Iterator<Map.Entry<String, String>> r3 = s().entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        Map.Entry<String, String> r6 = r3.next();
        r5.appendQueryParameter(r6.getKey(), r6.getValue());
        goto L8
    L11:
        return r5.build().toString();
    L5:
        r2 = "/record/";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public void y(boolean r6) {
        if (v() == true) goto L6;
        tt5.a.h("BitableShareCardV2FragmentDelegate", "updateExternalShareView failed due to shareHost unInitialized");
        return;
    L6:
        this.e = r6;
        List r0 = p().ul();
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.h("base.record.share_opt.enable");
        boolean r2 = AppInfoUtils.f().booleanValue();
        BitableShareCardV2FragmentDelegate$updateExternalShareView$config$1 r3 = BitableShareCardV2FragmentDelegate$updateExternalShareView$config$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "externalConfig");
        Intrinsics.checkNotNullParameter(r3, "qrCodeItemProvider");
        List r4 = com.bytedance.ee.bear.bitable.share.sharepanel.a.C0018a.a(r0, r1, r2, r3);
        if (r6 == true) goto L12;
        Iterator r7 = r4.iterator();
    L10:
        if (r7.hasNext() == false) goto L16;
        ((ShareItemModel) r7.next()).setState(ShareState.NOT_CLICK);
    L16:
        p().L30(r4);
        p().YH();
        return;
    L12:
        Iterator r8 = r4.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        ((ShareItemModel) r8.next()).setState(ShareState.SHOW);
        goto L14
    }

    public void z(String r10) {
        int r0 = mu4.f.a;
        mu4.f.h("share_qrcode", EShareType.Record);
        if (r10 == null) goto L23;
        String r3 = UriProtector.parse(r10).buildUpon().appendQueryParameter("ccm_open_type", "record_qrcode").appendQueryParameter(DocRedirectToDocxPlugin.FROM, "record_qrcode").build().toString();
        int r11 = e.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.oldform.support.qrcode") == false) goto L11;
        int r12 = FormsQRCodePanelFragmentV2.u;
        FormsQRCodePanelFragmentV2 r13 = FormsQRCodePanelFragmentV2.c.a(o().getDocName(), o().getBannerURL(), null, r3, o().getToken(), UIHelper.mustacheFormat(2131886817, "APP_DISPLAY_NAME", UIHelper.getAppName()));
        BitableShareCardV2FragmentDelegate$showQRCodeFragment$1$1$1 r1 = BitableShareCardV2FragmentDelegate$showQRCodeFragment$1$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r13.q = r1;
        FragmentManager r2 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "BitableShareCardV2FragmentDelegate", r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r13, r4) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L10:
        r13.show(r2, "BitableShareCardV2FragmentDelegate");
        return;
    L25:
        return;
    L11:
        int r14 = FormsQRCodePanelFragment.o;
        FormsQRCodePanelFragment r16 = FormsQRCodePanelFragment.a.a(o().getDocName(), o().getBannerURL(), r3, o().getToken(), UIHelper.mustacheFormat(2131886817, "APP_DISPLAY_NAME", UIHelper.getAppName()));
        BitableShareCardV2FragmentDelegate$showQRCodeFragment$1$2$1 r5 = BitableShareCardV2FragmentDelegate$showQRCodeFragment$1$2$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "listener");
        r16.m = r5;
        FragmentManager r6 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, "BitableShareCardV2FragmentDelegate", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r16, r7) == true) goto L26;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L15:
        r16.show(r6, "BitableShareCardV2FragmentDelegate");
        return;
    L26:
        return;
    }

    public BitableShareCardV2FragmentDelegate(com.bytedance.ee.bear.share.export.e r1, String r2) {
        super(r1);
        this.f = r2;
        this.g = "";
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        y(r3);
    }
}
