package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.net.Uri;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableShareBaseAddDelegate extends BitableShareCardV2FragmentDelegate {
    public final String h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BitableShareBaseAddDelegate a;

        public b(BitableShareBaseAddDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            if (r5 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            this.a.o().setUrl(this.a.n(r5));
            this.a.y(true);
            return;
        L12:
            return;
        L5:
            if (r5.length() == 0) goto L8;
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
            tt5.a.e("BitableShareBaseAddDelegate", "fetchBaseAddShareToken error", (Throwable) r4, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate, com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final String g() {
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate, com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onResume() {
        super.onResume();
        String r1 = this.h;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        Disposable r0 = ((com.bytedance.ee.bear.share.b) org.koin.java.a.c(com.bytedance.ee.bear.share.b.class, null, null, 6)).c(o().getToken(), o().getTableId()).subscribe(new b(this), c.a);
        this.c.add(r0);
        return;
    L11:
        String r3 = this.h;
        r3 = UriProtector.parse(r3).buildUpon().clearQuery().toString();     // Catch: Exception -> L14
    L16:
        BitableShareParams r4 = o();
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        r4.setUrl(r3);
        y(true);
        tt5.a.h("BitableShareBaseAddDelegate", "share url not empty ");
        return;
    L14:
        e = move-exception;
        tt5.a.e("BitableShareBaseAddDelegate", "parse share url err ", e, false);
        goto L16
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate
    public final void initData() {
        if (r().getShareType() != EShareType.BASE_ADD) goto L6;
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r0.h("bitableFormPermCommonParams");
        r0.j("bitableFormPermCommonParams", "module", "base_add");
        r0.j("bitableFormPermCommonParams", "file_type", "base_add");
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate, com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final String n(String r4) {
        Intrinsics.checkNotNullParameter(r4, "shareToken");
        Uri.Builder r0 = new Uri.Builder().scheme("https").authority(q());
        StringBuilder r1 = new StringBuilder();
        if (s45.a.c() == false) goto L5;
        String r2 = "/share/base/add/";
    L6:
        r1.append(r2);
        r1.append(r4);
        return r0.path(r1.toString()).build().toString();
    L5:
        r2 = "/base/add/";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate
    public final void z(String r10) {
        String r3 = UIHelper.mustacheFormat(2131886725, "baseName", o().getDocName());
        if (r10 == null) goto L13;
        String r6 = UriProtector.parse(r10).buildUpon().appendQueryParameter("ccm_open_type", "quickadd_qrcode").build().toString();
        int r11 = FormsQRCodePanelFragmentV2.u;
        Intrinsics.checkNotNull(r3);
        FormsQRCodePanelFragmentV2 r12 = FormsQRCodePanelFragmentV2.c.a(r3, o().getBannerURL(), null, r6, o().getToken(), UIHelper.mustacheFormat(2131886817, "APP_DISPLAY_NAME", UIHelper.getAppName()));
        Function0<Unit> r0 = new BitableShareBaseAddDelegate$showQRCodeFragment$1$1$1(this);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r12.s = r0;
        Function0<Unit> r1 = new BitableShareBaseAddDelegate$showQRCodeFragment$1$1$2(this);
        Intrinsics.checkNotNullParameter(r1, "listener");
        r12.t = r1;
        Function0<Unit> r2 = new BitableShareBaseAddDelegate$showQRCodeFragment$1$1$3(this);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r12.q = r2;
        FragmentManager r4 = p().requireActivity().getSupportFragmentManager();
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "BitableShareBaseAddDelegate", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r12, r5) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        r12.show(r4, "BitableShareBaseAddDelegate");
        return;
    L14:
        return;
    }

    public BitableShareBaseAddDelegate(com.bytedance.ee.bear.share.export.e r2, String r3) {
        super(r2, null);
        this.h = r3;
    }
}
