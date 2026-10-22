package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.lynx.tasm.LynxError;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class s implements te7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f247583a;

    public s(z.d r100) {
        this.f247583a = r100;
    }

    @Override // te7.a
    public final void a(JSONObject r100, LinkedHashMap<String, String> r101, Integer r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        d.b r104 = new d.b();
        String r105 = r100.toString();
        Charset r106 = Charsets.UTF_8;
        if (r105 == null) goto L11;
        r104.f247520a = r105.getBytes(r106);
        r104.f247522c = r101;
        if (r102 == null) goto L7;
        int r107 = r102.intValue();
    L8:
        r104.f247523d = r107;
        this.f247583a.b(r104);
        return;
    L7:
        r107 = -1;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // te7.a
    public final void c(Integer r100, LinkedHashMap<String, String> r101, Throwable r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        JSONObject r104 = new JSONObject();
        r104.put("code", 0);
        JSONObject r105 = new JSONObject();
        if (r100 == null) goto L5;
        int r106 = r100.intValue();
    L6:
        r105.put("errCode", r106);
        String r107 = r102.getMessage();
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        r105.put("message", r107);
        r104.put("respone", r105);
        this.f247583a.a(new Exception(r104.toString()));
        return;
    L5:
        r106 = -408;
        goto L6
    }

    @Override // te7.a
    public final Unit b(JSONObject r100, LinkedHashMap<String, String> r101, String r102, Throwable r103, Integer r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        Intrinsics.checkNotNullParameter(r102, "rawResponse");
        Intrinsics.checkNotNullParameter(r103, LynxError.LYNX_THROWABLE);
        JSONObject r106 = new JSONObject();
        r106.put("code", 0);
        r106.put("_raw", r102);
        JSONObject r107 = new JSONObject();
        r107.put("errCode", -408);
        String r108 = r103.getMessage();
        if (r108 != null) goto L5;
        r108 = "";
    L5:
        r107.put("message", r108);
        r106.put("respone", r107);
        this.f247583a.a(new Exception(r106.toString()));
        return Unit.INSTANCE;
    }
}
