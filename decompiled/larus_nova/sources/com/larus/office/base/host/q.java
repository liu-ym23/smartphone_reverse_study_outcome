package com.larus.office.base.host;

import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import com.ss.android.lark.officesdk.api.init.IOfficeSdkLanguageProvider;
import java.util.Locale;

/* JADX INFO: loaded from: classes29.dex */
public final class q implements IOfficeSdkLanguageProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f360537a = null;

    static {
        f360537a = new q();
    }

    public q() {
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSdkLanguageProvider
    public final String getLanguage() {
        String r100 = b0.f375362a;
        return b0.e(getLocale().getLanguage());
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSdkLanguageProvider
    public final Locale getLocale() {
        AppLocaleUtils.f375332a.getClass();
        return AppLocaleUtils.c();
    }
}
