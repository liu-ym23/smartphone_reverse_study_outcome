package com.bytedance.dpop;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f204780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, Object> f204781b;

    public final Object a() {
        c r100 = this.f204780a;
        LinkedHashMap<String, Object> r101 = this.f204781b;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        String r102 = GsonProtectorUtils.toJson(j.f204794a, r101);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        int r104 = a.f204774a;     // Catch: Throwable -> L5
        Charset r105 = Charsets.UTF_8;     // Catch: Throwable -> L5
        String r106 = a.a(r102.getBytes(r105));     // Catch: Throwable -> L5
        return Result.m9449constructorimpl(r100.f204778c + '.' + r106 + '.' + r100.b((r100.f204778c + '.' + r106).getBytes(r105)));
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public d(c r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "generator");
        this.f204780a = r100;
        LinkedHashMap<String, Object> r103 = new LinkedHashMap();
        this.f204781b = r103;
        if (r101 == null) goto L5;
        r103.put("jti", r101);
    L5:
        if (r102 == null) goto L8;
        r103.put("iat", Long.valueOf(r102.longValue()));
        return;
    }
}
