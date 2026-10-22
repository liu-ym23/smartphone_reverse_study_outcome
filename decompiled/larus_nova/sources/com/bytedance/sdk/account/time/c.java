package com.bytedance.sdk.account.time;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f269510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f269511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f269512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f269513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f269514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f269515f;

    public static final class a {
    }

    static {
    }

    public c() {
        this(0);
    }

    public final Pair<String, Object>[] b() {
        return new Pair[]{TuplesKt.to("config_description", this.f269510a), TuplesKt.to("enable_real_time_manager", Boolean.valueOf(this.f269511b)), TuplesKt.to("enable_use_system_time_if_on_sync", Boolean.valueOf(this.f269512c)), TuplesKt.to("enable_use_system_time_if_on_sync_when_no_record", Boolean.valueOf(this.f269513d)), TuplesKt.to("enable_reflect_system_api", Boolean.valueOf(this.f269514e)), TuplesKt.to("enable_external_time_source", Boolean.valueOf(this.f269515f))};
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L35:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L34;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f269510a, r101.f269510a) == false) goto L34;
        if (this.f269511b != r101.f269511b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L34;
        if (this.f269512c != r101.f269512c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L34;
        if (this.f269513d != r101.f269513d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L34;
        if (this.f269514e != r101.f269514e) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L34;
        if (this.f269515f != r101.f269515f) goto L31;
        boolean r106 = true;
    L32:
        if (r106 == false) goto L34;
    L31:
        r106 = false;
        goto L32
    L26:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r100 = this.f269510a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f269511b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f269512c;
        ?? r108 = r107;
        if (r107 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f269513d;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f269514e;
        ?? r114 = r113;
        if (r113 == false) goto L18;
        r114 = 1;
    L18:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f269515f;
        if (r116 == true) goto L23;
        r104 = r116;
    L23:
        return r115 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "RealTimeManagerConfig(configDescription=" + this.f269510a + ", enableRealTimeManager=" + this.f269511b + ", enableUseSystemTimeIfOnSync=" + this.f269512c + ", enableUseSystemTimeIfOnSyncWhenNoRecord=" + this.f269513d + ", enableReflectSystemApi=" + this.f269514e + ", enableExternalTimeSource=" + this.f269515f + ")";
    }

    public /* synthetic */ c(int r100) {
        this("Default", true, true, true, false, true);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.sdk.account.time.RealTimeManagerConfig$Companion$parseFromJson$1] */
    @JvmStatic
    public static final c a(final JSONObject r100, c r110) {
        if (r100 == null) goto L6;
        tb7.a.a("RealTimeManagerConfig", "parseFromJson: " + r100);
        ?? r101 = new RealTimeManagerConfig$Companion$parseFromJson$1(r100);
        return new c(r100.optString("config_description", r110.f269510a), r101.invoke("enable_real_time_manager", r110.f269511b), r101.invoke("enable_use_system_time_if_on_sync", r110.f269512c), r101.invoke("enable_use_system_time_if_on_sync_when_no_record", r110.f269513d), r101.invoke("enable_reflect_system_api", r110.f269514e), r101.invoke("enable_external_time_source", r110.f269515f));
    L6:
        return r110;
    }

    public c(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.f269510a = r100;
        this.f269511b = r101;
        this.f269512c = r102;
        this.f269513d = r103;
        this.f269514e = r104;
        this.f269515f = r105;
    }
}
