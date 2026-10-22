package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.eventcard.windowability.WindowAnchorAbility;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowTabCardListOperationPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowTabCardListOperationPlugin$createJsbActions$1(ECWindowTabCardListOperationPlugin r8) {
        super(1, r8, ECWindowTabCardListOperationPlugin.class, "onReceiveWindowCardInsertEvent", "onReceiveWindowCardInsertEvent(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "p1");
        ECWindowTabCardListOperationPlugin r0 = (ECWindowTabCardListOperationPlugin) ((CallableReference) this).receiver;
        int r1 = ECWindowTabCardListOperationPlugin.f;
        if (r0.h(r12) == false) goto L42;
        WindowAnchorAbility.b r2 = WindowAnchorAbility.e;
        String r13 = r12.toString();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r13, "json");
        WindowAnchorAbility.a r14 = (WindowAnchorAbility.a) u0.b(r13, WindowAnchorAbility.a.class);
        WindowAnchorAbility r3 = null;
        if (r14 == null) goto L34;
        String r4 = r14.c();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        int r5 = k.g(r14.a(), -1);
        WindowAnchorAbility.AnchorPosition r6 = r14.b();
        if (r6 != null) goto L14;
        r6 = WindowAnchorAbility.AnchorPosition.AFTER;
    L14:
        Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r7 = WindowDataMapper.a;
        JsonArray r15 = r14.d();
        if (r15 != null) goto L17;
        List r16 = CollectionsKt.emptyList();
    L33:
        r3 = new WindowAnchorAbility(r4, r5, r6, r16);
        goto L34
    L17:
        int r8 = r15.size();
        if (r8 != 0) goto L20;
        r16 = CollectionsKt.emptyList();
        goto L33
    L20:
        ArrayList r9 = new ArrayList();
        int r10 = 0;
    L21:
        if (r10 >= r8) goto L32;
        JsonElement r11 = r15.get(r10);
        if ((r11 instanceof JsonObject) == true) goto L25;
        r11 = null;
    L25:
        JsonObject r17 = (JsonObject) r11;
        if (r17 == null) goto L31;
        com.bytedance.android.window.shop.repository.dto.c r18 = (com.bytedance.android.window.shop.repository.dto.c) u0.a(r17, com.bytedance.android.window.shop.repository.dto.c.class);
        if (r18 == null) goto L31;
        r9.add(r18);
    L31:
        r10 = r10 + 1;
        goto L21
    L32:
        r16 = WindowDataMapper.c(r9);
    L34:
        if (r3 == null) goto L43;
        r0.d.invoke(r3);
        return;
    L43:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
