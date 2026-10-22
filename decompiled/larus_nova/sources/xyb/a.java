package xyb;

import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.mfa.FlowVerifyFactor;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethodList;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyListStepInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<Integer, String> f565476g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f565477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VerifyListStepInfo f565478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, AuthMethod> f565479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, VerifyBean> f565480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VerifyBean f565481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AuthMethodList f565482f;

    /* JADX INFO: renamed from: xyb.a$a, reason: collision with other inner class name */
    public static final class C8289a {
    }

    static {
        f565476g = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_PHONE.getValue()), "verify_code_mobile"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_EMAIL.getValue()), "verify_code_email"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_SPARE.getValue()), "verify_code_spare"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_OTP.getValue()), "verify_otp"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_FIDO.getValue()), "verify_fido"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_PASSWORD.getValue()), "verify_pwd"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_MO.getValue()), "verify_mo"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_B_IDP.getValue()), "verify_b_idp"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_GOOGLE.getValue()), "verify_google"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_APPLE_ID.getValue()), "verify_apple"), TuplesKt.to(Integer.valueOf(ButtonType.QR_LOGIN_SHOW.getValue()), "verify_qr"), TuplesKt.to(Integer.valueOf(ButtonType.VERIFY_DOUBAO.getValue()), "verify_dou_bao")});
    }

    public a() {
        this.f565479c = new LinkedHashMap();
        this.f565480d = new LinkedHashMap();
        this.f565481e = new VerifyBean("", "", "", Boolean.FALSE, "", null, null, null, null, null, null, null, null, null);
    }

    public final String a(int r100) {
        if (d(r100) == true) goto L5;
        return null;
    L5:
        AuthMethod r101 = (AuthMethod) ((LinkedHashMap) this.f565479c).get(Integer.valueOf(r100));
        boolean r102 = false;
        if (r101 == null) goto L18;
        String r103 = r101.getDisabledToastText();
        if (r103 == null) goto L18;
        if (r103.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L18;
        return r103;
    L12:
        r104 = false;
    L18:
        VerifyBean r105 = (VerifyBean) ((LinkedHashMap) this.f565480d).get(Integer.valueOf(r100));
        if (r105 == null) goto L29;
        String r106 = r105.getDisabledToastText();
        if (r106 != null) goto L23;
        return null;
    L23:
        if (r106.length() <= 0) goto L25;
        r102 = true;
    L25:
        if (r102 == true) goto L27;
        return null;
    L27:
        return r106;
    L29:
        return null;
    }

    public final AuthMethod b(int r100) {
        Map<Integer, AuthMethod> r101 = this.f565479c;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        return (AuthMethod) r102.get(Integer.valueOf(r100));
    }

    public final boolean d(int r100) {
        Map<Integer, AuthMethod> r101 = this.f565479c;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        AuthMethod r103 = (AuthMethod) r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L19;
        Map<Integer, VerifyBean> r105 = this.f565480d;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        VerifyBean r107 = (VerifyBean) r106.get(Integer.valueOf(r100));
        if (r107 != null) goto L12;
    L14:
        boolean r108 = false;
    L15:
        if (r108 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r107.isIntercepted() != true) goto L14;
        r108 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r103.isIntercepted() != true) goto L7;
        r104 = true;
        goto L8
    }

    public final void c(int r100, VerifyBean r101) {
        if (r101 == null) goto L7;
        FlowVerifyFactor.Companion.getClass();
        if (FlowVerifyFactor.a.b(r100) == false) goto L8;
        Integer r102 = Integer.valueOf(r100);
        this.f565480d.put(r102, r101);
        return;
    L8:
        return;
    }
}
