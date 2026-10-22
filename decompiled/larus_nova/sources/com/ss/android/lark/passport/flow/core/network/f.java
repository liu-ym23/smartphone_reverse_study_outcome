package com.ss.android.lark.passport.flow.core.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f437764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f437766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f437767d;

    public static final class a {
    }

    static {
    }

    public final void c() {
        int r100 = this.f437764a;
        if (200 <= r100) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L58;
        return;
    L58:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(a(this));     // Catch: Throwable -> L11
    L13:
        String r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
        r103 = null;
    L16:
        String r105 = (String) r103;
        if (r105 != null) goto L19;
    L31:
        JSONObject r106 = null;
    L32:
        int r107 = this.f437764a;
        String r108 = this.f437765b;
        String r109 = b(NetResponse.HEADER_KEY_LOG_ID);
        if (r106 == null) goto L35;
        Integer r110 = r106.getInteger("code");
    L36:
        if (r106 == null) goto L38;
        Integer r111 = r106.getInteger(UniContext.KEY_OF_BIZ_CODE);
    L39:
        if (r106 == null) goto L41;
        String r112 = r106.getString("message");
    L43:
        if (r106 == null) goto L50;
        JSONObject r113 = r106.getJSONObject("data");
        if (r113 == null) goto L50;
        String r114 = r113.getString("next_step");
        if (r114 == null) goto L50;
        String r115 = r114;
    L54:
        throw new PassportHttpStatusException(r107, r108, r109, r105, r110, r111, r112, r115);
    L50:
        if (r106 == null) goto L52;
        r104 = r106.getString("next_step");
    L52:
        r115 = r104;
        goto L54
    L41:
        r112 = null;
        goto L43
    L38:
        r111 = null;
        goto L39
    L35:
        r110 = null;
        goto L36
    L19:
        if ((!StringsKt.isBlank(r105)) == false) goto L21;
        String r116 = r105;
    L22:
        if (r116 == null) goto L31;
        Object r117 = Result.m9449constructorimpl(JSON.parseObject(r116));     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r117) == false) goto L30;
        r117 = null;
    L30:
        r106 = (JSONObject) r117;
    L25:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L21:
        r116 = null;
    L11:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        if (r100 >= 300) goto L7;
        r101 = true;
        goto L8
    }

    public static String a(f r100) {
        Charset r101 = Charsets.UTF_8;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new String(r100.f437767d, r101);
    }

    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Iterator r101 = ((LinkedHashMap) this.f437766c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (StringsKt.equals((String) ((Map.Entry) r102).getKey(), r100, true) == false) goto L4;
    L9:
        Map.Entry r103 = (Map.Entry) r102;
        if (r103 == null) goto L18;
        List r104 = (List) r103.getValue();
        if (r104 != null) goto L14;
        return null;
    L14:
        return (String) CollectionsKt.firstOrNull(r104);
    L18:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    public f(int r100, Map<String, ? extends List<String>> r101, byte[] r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r103, "requestId");
        this.f437764a = r100;
        this.f437765b = r103;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r105 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.put(r106.getKey(), CollectionsKt.toList((Iterable) r106.getValue()));
        goto L4
    L6:
        this.f437766c = r104;
        this.f437767d = Arrays.copyOf(r102, r102.length);
    }
}
