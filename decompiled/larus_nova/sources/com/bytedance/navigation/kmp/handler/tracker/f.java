package com.bytedance.navigation.kmp.handler.tracker;

import com.bytedance.navigation.kmp.data.NavigationTraceLevel;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f265906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f265907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f265908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f265909d;

    public /* synthetic */ f(g r100, String r101, boolean r102, Map r103) {
        this.f265906a = r100;
        this.f265907b = r101;
        this.f265908c = r102;
        this.f265909d = r103;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        g r100 = this.f265906a;
        String r101 = this.f265907b;
        boolean r102 = this.f265908c;
        Map r103 = this.f265909d;
        g.c r104 = r100.f(r101);
        if (r104 != null) goto L5;
        return null;
    L5:
        e37.j r105 = r104.f265917a.getContext();
        if (r102 == false) goto L8;
        NavigationTraceLevel r106 = NavigationTraceLevel.INFO;
    L10:
        return new g.b(r105, new b37.k("lbs_client_navi_route_change", r106, r103, 4));
    L8:
        r106 = NavigationTraceLevel.ERROR;
        goto L10
    }
}
