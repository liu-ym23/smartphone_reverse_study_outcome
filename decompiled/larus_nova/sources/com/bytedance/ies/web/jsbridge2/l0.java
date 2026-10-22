package com.bytedance.ies.web.jsbridge2;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class l0 extends com.bytedance.android.annie.card.web.e implements d47.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, l47.a<JSONObject>> f249388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f249389c;

    public static final class a {
    }

    static {
    }

    public l0() {
        super(null);
        this.f249388b = new ConcurrentHashMap();
    }

    public final void D(JSONObject r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(JSONObjectProtectorUtils.getString(r100, "__callback_id"));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r102) != null) goto L20;
        String r103 = (String) r102;
        JSONObject r104 = r100.optJSONObject("__params");
        if (r104 != null) goto L11;
        r104 = new JSONObject();
        r104.put("code", -4);
        r104.put("msg", "[GLUE] invalid result format!");
    L14:
        l47.a<JSONObject> r105 = this.f249388b.remove(r103);
        if (r105 == null) goto L21;
        r105.accept(r104);
        return;
    L21:
        return;
    L11:
        if (r104.has("__data") == false) goto L14;
        r104.put("data", r104.get("__data"));
        goto L14
    L20:
        return;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void E(String r100) {
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (StringsKt.contains$default(r100, "._handleMessageFromToutiao(", false, 2, null) != true) goto L7;
    L8:
        if (r101 == true) goto L11;
        return;
    L11:
        if (StringsKt.contains$default(r100, "__pia_jsb2_glue__", false, 2, null) == true) goto L19;
        return;
    L19:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        D(new JSONObject(StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(r100, "._handleMessageFromToutiao(", null, 2, null), ")", null, 2, null)));     // Catch: Throwable -> L15
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Result.m9455isFailureimpl(r103);
        return;
    L15:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void f(String r100, ValueCallback<String> r101) {
        E(r100);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void s(WebView r100, String r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L10;
        E(r101);
        return;
    L10:
        return;
    L5:
        if (StringsKt.startsWith$default(r101, "javascript", false, 2, null) != true) goto L7;
        r102 = true;
        goto L7
    }

    @Override // d47.b
    public final void a(String r100, JSONObject r101, com.bytedance.pia.core.plugins.a r110) {
        b r102 = null;
        if (r101 != null) goto L22;
        c0 r103 = null;
    L13:
        d0 r104 = this.f249389c;
        if (r104 == null) goto L16;
        r102 = r104.f249341a;
    L16:
        if (r102 == null) goto L20;
        if (r103 == null) goto L20;
        this.f249388b.put(r103.f249321f, r110);
        r102.o(r103);
        return;
    L20:
        JSONObject r105 = new JSONObject();
        r105.put("code", -2);
        r110.accept(r105);
        return;
    L22:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L7
        String r107 = JSONObjectProtectorUtils.getString(r101, "func");     // Catch: Throwable -> L7
        String r108 = JSONObjectProtectorUtils.getString(r101, "params");     // Catch: Throwable -> L7
        String r109 = JSONObjectProtectorUtils.getString(r101, "JSSDK");     // Catch: Throwable -> L7
        String r111 = JSONObjectProtectorUtils.getString(r101, "__msg_type");     // Catch: Throwable -> L7
        String r112 = "__pia_jsb2_glue__" + r101.optString("__callback_id");     // Catch: Throwable -> L7
        String r113 = r101.optString("namespace");     // Catch: Throwable -> L7
        c0.a r114 = new c0.a();     // Catch: Throwable -> L7
        r114.f249329c = r107;     // Catch: Throwable -> L7
        r114.f249330d = r108;     // Catch: Throwable -> L7
        r114.f249327a = r109;     // Catch: Throwable -> L7
        r114.f249328b = r111;     // Catch: Throwable -> L7
        r114.f249331e = r112;     // Catch: Throwable -> L7
        r114.f249332f = r113;     // Catch: Throwable -> L7
        Object r115 = Result.m9449constructorimpl(new c0(r114));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r115) == false) goto L12;
        r115 = null;
    L12:
        r103 = (c0) r115;
    L7:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
