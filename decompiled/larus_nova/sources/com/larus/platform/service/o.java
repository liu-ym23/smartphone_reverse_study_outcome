package com.larus.platform.service;

import android.os.Bundle;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements com.larus.platform.api.q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f365780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365781b = null;

    public o() {
    }

    static {
        f365780a = new o();
        f365781b = LazyKt.lazy(new n());
    }

    public static com.larus.platform.api.q1 f() {
        return (com.larus.platform.api.q1) f365781b.getValue();
    }

    @Override // com.larus.platform.api.q1
    public final String getClientDid() {
        com.larus.platform.api.q1 r100 = f();
        if (r100 == null) goto L6;
        String r101 = r100.getClientDid();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.q1
    public final String getDeviceId() {
        com.larus.platform.api.q1 r100 = f();
        if (r100 == null) goto L6;
        String r101 = r100.getDeviceId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.q1
    public final String getInstallId() {
        com.larus.platform.api.q1 r100 = f();
        if (r100 == null) goto L6;
        String r101 = r100.getInstallId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.q1
    public final String getUserID() {
        com.larus.platform.api.q1 r100 = f();
        if (r100 == null) goto L6;
        String r101 = r100.getUserID();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.q1
    public final String getUserUniqueID() {
        com.larus.platform.api.q1 r100 = f();
        if (r100 == null) goto L6;
        String r101 = r100.getUserUniqueID();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.q1
    public final void d(boolean r100) {
        com.larus.platform.api.q1 r101 = f();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.larus.platform.api.q1
    public final void e(com.larus.platform.api.y r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        com.larus.platform.api.q1 r101 = f();
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // com.larus.platform.api.q1
    public final void putCommonParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.platform.api.q1 r101 = f();
        if (r101 == null) goto L6;
        r101.putCommonParams(r100);
        return;
    }

    @Override // com.larus.platform.api.q1
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        com.larus.platform.api.q1 r102 = f();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.q1
    public final void b(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.platform.api.q1 r102 = f();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.q1
    public final void c(String r100, Function0<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueGenerator");
        com.larus.platform.api.q1 r102 = f();
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.q1
    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.platform.api.q1 r102 = f();
        if (r102 == null) goto L6;
        r102.reportEvent(r100, r101);
        return;
    }
}
