package com.larus.init.task.experiment;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.flowsdk.common.experiment.FlowABValueType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import ft9.k;
import ga9.c;
import ga9.f;
import ha9.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowClientExperimentSettingsRuntime implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowClientExperimentSettingsRuntime f351218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f351219b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<String> f351220c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f351221d = null;

    public FlowClientExperimentSettingsRuntime() {
    }

    static {
        f351218a = new FlowClientExperimentSettingsRuntime();
        f351219b = new d(new ha9.a());
        f351220c = new AtomicReference(null);
        f351221d = new AtomicBoolean(false);
    }

    public static String h() {
        String r100 = AccountService.f365697a.getUserId();
        if (StringsKt.isBlank(r100) == false) goto L5;
        r100 = "anonymous";
    L5:
        i(r100, "read");
        return "doubao_main/".concat(r100);
    }

    @Override // ga9.c
    public final <T> void c(f<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        d r101 = f351219b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "info");
        ha9.a r102 = r101.f484417a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "info");
        if ((!StringsKt.isBlank(r100.f480601a)) == false) goto L13;
        f<?> r103 = r102.f484413c.putIfAbsent(r100.f480601a, r100);
        if (r103 == null) goto L14;
        r102.f484411a.a(r100.f480601a, r103, r100);
        if (r102.f484412b == true) goto L11;
        return;
    L11:
        throw new IllegalStateException(("Duplicate Flow experiment registration: " + r100.f480601a).toString());
    L14:
        return;
    L13:
        throw new IllegalArgumentException("Flow experiment key must not be blank.".toString());
    }

    public static void i(String r100, String r101) {
        String r102 = f351220c.getAndSet(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r102, r100) == true) goto L10;
        f351219b.f484418b.f484423b.clear();
        FLogger.f375446a.i("FlowClientExperiment", "clearStableCache: scene=" + r101 + ", cacheScopeChanged=true");
        return;
    }

    @Override // ga9.c
    public final JSONArray a(String r100, JSONArray r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "defaultValue");
        d r101 = f351219b;
        String r102 = h();
        FlowClientExperimentSettingsRuntime$array$1 r103 = new FlowClientExperimentSettingsRuntime$array$1(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "namespace");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "defaultValue");
        Intrinsics.checkNotNullParameter(r103, "loadValue");
        Object r104 = r101.a(r102, r100, FlowABValueType.ARRAY, r110, r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type org.json.JSONArray");
        return (JSONArray) r104;
    }

    @Override // ga9.c
    public final int b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d r102 = f351219b;
        String r103 = h();
        FlowClientExperimentSettingsRuntime$int$1 r104 = new FlowClientExperimentSettingsRuntime$int$1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "namespace");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r104, "loadValue");
        Object r105 = r102.a(r103, r100, FlowABValueType.INT, Integer.valueOf(r101), r104);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r105).intValue();
    }

    @Override // ga9.c
    public final String d(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "defaultValue");
        d r101 = f351219b;
        String r102 = h();
        FlowClientExperimentSettingsRuntime$string$1 r103 = new FlowClientExperimentSettingsRuntime$string$1(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "namespace");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "defaultValue");
        Intrinsics.checkNotNullParameter(r103, "loadValue");
        Object r104 = r101.a(r102, r100, FlowABValueType.STRING, r110, r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");
        return (String) r104;
    }

    @Override // ga9.c
    public final boolean e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d r102 = f351219b;
        String r103 = h();
        FlowClientExperimentSettingsRuntime$bool$1 r104 = new FlowClientExperimentSettingsRuntime$bool$1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "namespace");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r104, "loadValue");
        Object r105 = r102.a(r103, r100, FlowABValueType.BOOL, Boolean.valueOf(r101), r104);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) r105).booleanValue();
    }

    @Override // ga9.c
    public final JSONObject f(String r100, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "defaultValue");
        d r101 = f351219b;
        String r102 = h();
        FlowClientExperimentSettingsRuntime$dict$1 r103 = new FlowClientExperimentSettingsRuntime$dict$1(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "namespace");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "defaultValue");
        Intrinsics.checkNotNullParameter(r103, "loadValue");
        Object r104 = r101.a(r102, r100, FlowABValueType.DICT, r110, r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type org.json.JSONObject");
        return (JSONObject) r104;
    }

    public static final Object g(FlowClientExperimentSettingsRuntime r100, String r101, f r102) {
        r100.getClass();
        k r103 = k.f478804a;
        Application r104 = AppHost.f326268a.getApplication();
        r103.getClass();
        JSONObject r105 = k.c(r104);
        if (r105 == null) goto L7;
        JSONObject r106 = r105.optJSONObject("doubao");
        if (r106 == null) goto L7;
        Object r107 = r106.opt(r101);
    L8:
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("loadValue: key=");
        r109.append(r101);
        r109.append(", type=");
        r109.append(r102.f480603c.getWireValue());
        r109.append(", hit=");
        if (r107 == null) goto L11;
        boolean r110 = true;
    L12:
        r109.append(r110);
        r108.i("FlowClientExperiment", r109.toString());
        return r107;
    L11:
        r110 = false;
    L7:
        r107 = null;
        goto L8
    }
}
