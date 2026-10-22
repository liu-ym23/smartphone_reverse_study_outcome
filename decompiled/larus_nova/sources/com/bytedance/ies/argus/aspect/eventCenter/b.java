package com.bytedance.ies.argus.aspect.eventCenter;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b<T extends View> extends BaseRuntimeContext {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<T> f245834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f245835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f245836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f245837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, Function0<Unit>> f245838i;

    @Override // com.bytedance.ies.argus.aspect.eventCenter.BaseRuntimeContext
    public final String g() {
        return "view";
    }

    public final T h() {
        WeakReference<T> r100 = this.f245834e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public b() {
        this.f245835f = "";
        this.f245838i = new ConcurrentHashMap();
    }
}
