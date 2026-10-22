package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import java.util.Locale;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements ntb.m {
    public m() {
    }

    @Override // ntb.m
    public final Locale getCurrentLocale() {
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        return com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
    }

    @Override // ntb.m
    public final String t() {
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        return com.ss.android.lark.language.service.impl.a.b.f431098a.getCacheLanguageSetting().toLanguageTag();
    }
}
