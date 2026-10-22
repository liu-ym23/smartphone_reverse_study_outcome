package com.bytedance.android.window.shop.holder;

import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.window.shop.repository.tab.entity.f0;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowPlayableProductHolder$productGroupPresenter$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public WindowPlayableProductHolder$productGroupPresenter$1(WindowPlayableProductHolder.a r8) {
        super(1, r8, WindowPlayableProductHolder.a.class, "editDetailUrlByVideoStatus", "editDetailUrlByVideoStatus(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String r10) {
        Intrinsics.checkNotNullParameter(r10, "p1");
        WindowPlayableProductHolder.a r0 = (WindowPlayableProductHolder.a) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "detailUrl");
        f0 r1 = r0.i;
        if (r1 != null) goto L5;
    L7:
        o0 r2 = new o0(r10);
        boolean r3 = WindowPlayableProductHolder.A;
        String r4 = r2.e("chain_info");
        boolean r5 = false;
        if (r4 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L33;
        JSONObject r7 = new JSONObject(URLDecoder.decode(r4));     // Catch: JSONException -> L27
        String r8 = r7.optString("header_config");
        if (r8 != null) goto L20;
    L21:
        r5 = true;
    L22:
        if (r5 == true) goto L34;
        long r9 = r0.j.x.F();
        JSONObject r11 = new JSONObject(r8);     // Catch: JSONException -> L27
        r11.put("start_time", r9);     // Catch: JSONException -> L27
        r7.put("header_config", r11);
        r2.a("chain_info", URLEncoder.encode(r7.toString()));
        return r2.c();
    L34:
        return r10;
    L20:
        if (StringsKt.isBlank(r8) == false) goto L22;
    L27:
        return "";
    L33:
        return r10;
    L10:
        if (StringsKt.isBlank(r4) == true) goto L13;
        r6 = false;
        goto L14
    L5:
        if (r1.m == true) goto L7;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
