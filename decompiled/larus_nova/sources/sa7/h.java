package sa7;

import ua7.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<T extends ua7.b> extends ua7.a<T> {
    public String getCaptchaInfo(T r100) {
        return null;
    }

    public boolean needShowCaptcha(T r100) {
        return false;
    }

    public boolean needShowPicCaptcha(T r100) {
        return false;
    }

    public boolean needShowSecureCaptcha(T r100) {
        return false;
    }

    public abstract void onError(T r100, int r101);

    public void onNeedCaptcha(T r100, String r101) {
    }

    public void onNeedSecureCaptcha(T r100) {
    }

    public abstract void onSuccess(T r100);

    public h() {
    }

    @Override // ua7.a
    public void onResponse(T r100) {
        if (r100.f549249c == false) goto L6;
        onSuccess(r100);
        return;
    L6:
        if (needShowCaptcha(r100) == true) goto L8;
        onError(r100, r100.f549253g);
        return;
    L8:
        if (needShowPicCaptcha(r100) == false) goto L10;
        onNeedCaptcha(r100, getCaptchaInfo(r100));
        return;
    L10:
        onError(r100, r100.f549253g);
    }
}
