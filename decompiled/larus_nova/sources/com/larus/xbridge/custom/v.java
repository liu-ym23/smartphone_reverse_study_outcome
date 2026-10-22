package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class v implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f379796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f379797b;

    public /* synthetic */ v(w r100, ux7.d.C7943d r101) {
        this.f379796a = r100;
        this.f379797b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        w r101 = this.f379796a;
        IvyBridgeMethod.a r102 = this.f379797b;
        List r103 = (List) r100;
        Intrinsics.checkNotNullParameter(r103, "list");
        FLogger r104 = FLogger.f375446a;
        r101.getClass();
        r104.d("app.openChatPage", "Chat history-handle onSuccess list=" + r103);
        JSONArray r105 = new JSONArray();
        Iterator r106 = r103.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Pair r107 = (Pair) r106.next();
        JSONObject r108 = new JSONObject();
        r108.put("messageId", r107.getFirst());
        r108.put("userId", r107.getSecond());
        r105.put(r108);
        goto L4
    L6:
        FLogger.f375446a.d("app.openChatPage", "Chat history-handle onSuccess jsonArray=" + r105);
        bx7.c.d(r101, r102, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("messages", r105)}));
        return Unit.INSTANCE;
    }
}
