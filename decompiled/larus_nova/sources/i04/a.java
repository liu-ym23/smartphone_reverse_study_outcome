package i04;

import com.bytedance.android.livesdkapi.auth.AuthReportEvent;
import com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog;
import com.bytedance.awemeopen.domain.user.login.onekey.OneKeyLogin$login$handler$1;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements PhoneNumberLoginDialog.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c24.a f487874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f487875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f487876c;

    @Override // com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog.b
    public final void a() {
        this.f487874a.a();
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        int r102 = com.bytedance.awemeopen.bizmodels.user.a.f198216a;
        String r103 = com.bytedance.awemeopen.bizmodels.user.a.a(this.f487875b);
        Map<String, String> r104 = this.f487876c;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L10;
    L12:
        r101.X0(r103, BdpAppEventConstant.NO, AuthReportEvent.BTN_DOUYIN, r105);
        return;
    L10:
        if (Intrinsics.areEqual(this.f487876c.get("is_card_mode"), "1") == false) goto L12;
        r105 = true;
        goto L12
    L5:
        if (r104.containsKey("is_card_mode") != true) goto L7;
        r106 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog.b
    public final void onCancel() {
        this.f487874a.cancel();
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        int r102 = com.bytedance.awemeopen.bizmodels.user.a.f198216a;
        String r103 = com.bytedance.awemeopen.bizmodels.user.a.a(this.f487875b);
        Map<String, String> r104 = this.f487876c;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L10;
    L12:
        r101.X0(r103, "mix", "cancel", r105);
        return;
    L10:
        if (Intrinsics.areEqual(this.f487876c.get("is_card_mode"), "1") == false) goto L12;
        r105 = true;
        goto L12
    L5:
        if (r104.containsKey("is_card_mode") != true) goto L7;
        r106 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog.b
    public final void onConfirm() {
        this.f487874a.confirm();
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        int r102 = com.bytedance.awemeopen.bizmodels.user.a.f198216a;
        String r103 = com.bytedance.awemeopen.bizmodels.user.a.a(this.f487875b);
        Map<String, String> r104 = this.f487876c;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L10;
    L12:
        r101.X0(r103, BdpAppEventConstant.YES, AuthReportEvent.BTN_CONFIRM, r105);
        return;
    L10:
        if (Intrinsics.areEqual(this.f487876c.get("is_card_mode"), "1") == false) goto L12;
        r105 = true;
        goto L12
    L5:
        if (r104.containsKey("is_card_mode") != true) goto L7;
        r106 = true;
        goto L8
    }

    public a(OneKeyLogin$login$handler$1.a r100, String r101, Map r102) {
        this.f487874a = r100;
        this.f487875b = r101;
        this.f487876c = r102;
    }
}
