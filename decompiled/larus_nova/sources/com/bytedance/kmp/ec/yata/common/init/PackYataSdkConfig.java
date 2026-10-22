package com.bytedance.kmp.ec.yata.common.init;

import com.bytedance.android.shopping.yata.init.AndroidYataLoader;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class PackYataSdkConfig implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f251419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f251420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f251421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Integer> f251422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f251423e;

    @Override // com.bytedance.kmp.ec.yata.common.init.a
    public final boolean b() {
        if (this.f251423e != null) goto L5;
        Function0<Boolean> r100 = new PackYataSdkConfig$isDebugOrLocalTest$1(this);
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f251423e = r100.invoke();
    L5:
        Boolean r101 = this.f251423e;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    }

    @Override // com.bytedance.kmp.ec.yata.common.init.a
    public final List<String> c() {
        if (this.f251421c.isEmpty() == false) goto L6;
        Function0<List<? extends String>> r100 = new PackYataSdkConfig$getSkipReportErrorKeys$1(this);
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f251421c = (List) r100.invoke();
    L6:
        return this.f251421c;
    }

    @Override // com.bytedance.kmp.ec.yata.common.init.a
    public final Map<String, Integer> d() {
        if (this.f251422d.isEmpty() == false) goto L6;
        Function0<Map<String, ? extends Integer>> r100 = new PackYataSdkConfig$getBizMonitorPercentConfig$1(this);
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f251422d = (Map) r100.invoke();
    L6:
        return this.f251422d;
    }

    @Override // com.bytedance.kmp.ec.yata.common.init.a
    public final String getAppVersion() {
        if (this.f251420b != null) goto L5;
        Function0<String> r100 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f251420b = r100.invoke();
    L5:
        String r101 = this.f251420b;
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public PackYataSdkConfig(AndroidYataLoader.b r100) {
        Intrinsics.checkNotNullParameter(r100, "originSdkConfig");
        this.f251419a = r100;
        this.f251421c = CollectionsKt.emptyList();
        this.f251422d = MapsKt.emptyMap();
    }

    @Override // com.bytedance.kmp.ec.yata.common.init.a
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f251419a.a(r100, r101);
    }
}
