package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.api.service.ITranslateService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class UrlTranslateUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranslateService f416636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.translate.service.impl.a f416637b;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final f5b.b r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        HashMap r101 = new HashMap();
        r101.put(r100.getId(), r100);
        HashMap r102 = new HashMap();
        HashMap r103 = new HashMap();
        h0.g(r101, r100.getTranslateInfo().getLanguage(), r102, r103);
        this.f416636a.W4(true, r102, r103, new UrlTranslateUtils$loadUrlTranslation$1(r100, this));
    }

    public UrlTranslateUtils(ITranslateService r100, com.ss.android.lark.translate.service.impl.a r101) {
        Intrinsics.checkNotNullParameter(r100, "translateService");
        Intrinsics.checkNotNullParameter(r101, "translatePush");
        this.f416636a = r100;
        this.f416637b = r101;
    }
}
