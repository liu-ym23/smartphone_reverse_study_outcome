package com.bytedance.awemeopen.apps.framework.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements com.bytedance.awemeopen.infra.base.event.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f197691c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r14.c f197692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.awemeopen.infra.base.event.d f197693b;

    public static final class a {
        public static Map a(r14.c r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            if (r100 == null) goto L8;
            String r102 = r100.r().f535654f;     // Catch: Throwable -> L11
            if (r102 == null) goto L8;
            JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L11
        L9:
            Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r104) == false) goto L16;
            r104 = null;
        L16:
            JSONObject r105 = (JSONObject) r104;
            if (r105 != null) goto L19;
            return null;
        L19:
            Iterator<String> r106 = r105.keys();
            LinkedHashMap r107 = new LinkedHashMap();
        L21:
            if (r106.hasNext() == false) goto L26;
            String r108 = r106.next();
            Object r109 = r105.opt(r108);
            if (r109 == null) goto L21;
            r107.put(r108, r109);
            goto L21
        L26:
            return r107;
        L8:
            r103 = null;
        L11:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.infra.base.event.d
    public final JSONObject getParams() {
        r14.c r100 = this.f197692a;
        JSONObject r101 = null;
        if (r100 == null) goto L25;
        String r102 = r100.r().f535654f;
        if (r102 == null) goto L25;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(new JSONObject(r102));     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L15;
        r104 = new JSONObject();
    L15:
        JSONObject r105 = (JSONObject) r104;
        com.bytedance.awemeopen.infra.base.event.d r106 = this.f197693b;
        if (r106 == null) goto L18;
        r101 = r106.getParams();
    L18:
        if (r101 != null) goto L20;
        return r105;
    L20:
        Iterator<String> r107 = r101.keys();
    L22:
        if (r107.hasNext() == false) goto L24;
        String r108 = r107.next();
        r105.put(r108, r101.opt(r108));
        goto L22
    L24:
        return r105;
    L9:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        com.bytedance.awemeopen.infra.base.event.d r110 = this.f197693b;
        if (r110 != null) goto L28;
        return null;
    L28:
        return r110.getParams();
    }

    public e(r14.c r100) {
        this.f197692a = r100;
        this.f197693b = null;
    }
}
