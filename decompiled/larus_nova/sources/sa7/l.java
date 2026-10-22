package sa7;

import android.text.TextUtils;
import ua7.e;
import wb7.e;

/* JADX INFO: loaded from: classes22.dex */
public abstract class l<T extends ua7.e<K>, K extends wb7.e> extends h<T> {
    public l() {
    }

    @Override // sa7.h
    public final String getCaptchaInfo(ua7.b r100) {
        ua7.e r101 = (ua7.e) r100;
        if (r101 == null) goto L8;
        T r102 = r101.f549264p;
        if (r102 == 0) goto L8;
        return r102.f559015c;
    L8:
        return null;
    }

    @Override // sa7.h
    public final boolean needShowCaptcha(ua7.b r100) {
        ua7.e r101 = (ua7.e) r100;
        if (r101 == null) goto L12;
        T r102 = r101.f549264p;
        if (r102 == 0) goto L12;
        int r103 = r102.f559013a;
        if (r103 <= 1100) goto L12;
        if (r103 >= 1199) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // sa7.h
    public final boolean needShowPicCaptcha(ua7.b r100) {
        ua7.e r101 = (ua7.e) r100;
        if (r101 == null) goto L16;
        T r102 = r101.f549264p;
        if (r102 == 0) goto L16;
        int r103 = r102.f559013a;
        if (r103 == 1101) goto L14;
        if (r103 == 1102) goto L14;
        if (r103 != 1103) goto L16;
    L14:
        if (TextUtils.isEmpty(r102.f559015c) == true) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // sa7.h
    public final boolean needShowSecureCaptcha(ua7.b r100) {
        ua7.e r101 = (ua7.e) r100;
        if (r101 == null) goto L12;
        T r102 = r101.f549264p;
        if (r102 == 0) goto L12;
        int r103 = r102.f559013a;
        if (r103 != 1104) goto L10;
    L11:
        return true;
    L10:
        if (r103 == 1105) goto L11;
    L12:
        return false;
    }
}
