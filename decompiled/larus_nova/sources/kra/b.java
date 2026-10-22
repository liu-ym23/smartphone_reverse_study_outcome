package kra;

import com.ss.android.ad.applinksdk.constant.AppLinkSettingValues;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends t6.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f505899b = null;

    static {
        f505899b = new b();
    }

    public b() {
    }

    @Override // t6.b
    public final <T> T b(Class<T> r100, Object r101) {
        if (((Boolean) AppLinkSettingValues.f406351d.getValue()).booleanValue() == false) goto L8;
        t6.b r102 = t6.a.f544652a;
        T r103 = (T) t6.a.C7690a.a(r100, r101);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return (T) super.b(r100, r101);
    }
}
