package com.ss.android.lark.passport;

import android.content.SharedPreferences;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class OfficeTokenServiceImpl implements com.ss.android.lark.passport.dpop.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<SharedPreferences> f437639b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOfficeSDKTokenProvider f437640a;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f437639b = LazyKt.lazy(OfficeTokenServiceImpl$Companion$mPreference$2.INSTANCE);
    }

    @Override // com.ss.android.lark.passport.dpop.b
    public final boolean isDoubaoBUser() {
        return this.f437640a.isDoubaoBUser();
    }

    @Override // com.ss.android.lark.passport.dpop.b
    public final String getAccessToken() {
        if (com.ss.android.lark.passport.a.a() == false) goto L26;
        Lazy<SharedPreferences> r100 = f437639b;
        SharedPreferences r101 = r100.getValue();
        int r102 = -1;
        if (r101 == null) goto L7;
        r102 = r101.getInt("custom_env_value", -1);
    L7:
        boolean r103 = false;
        if (r102 != 2) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L26;
        SharedPreferences r105 = r100.getValue();
        if (r105 == null) goto L26;
        String r106 = r105.getString("o_access_token", "");
        if (r106 == null) goto L26;
        if (r106.length() <= 0) goto L19;
        r103 = true;
    L19:
        if (r103 == true) goto L22;
        r106 = null;
    L22:
        if (r106 == null) goto L26;
        return "Bearer ".concat(r106);
    L10:
        r104 = false;
    L26:
        return this.f437640a.getAuthSchema() + ' ' + this.f437640a.getAccessToken();
    }

    @Inject
    public OfficeTokenServiceImpl(IOfficeSDKTokenProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "tokenProvider");
        this.f437640a = r100;
    }
}
