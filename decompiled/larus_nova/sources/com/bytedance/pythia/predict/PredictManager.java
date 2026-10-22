package com.bytedance.pythia.predict;

import com.bytedance.keva.Keva;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PredictManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f267109h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f267110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f267111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f267112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f267113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<Float> f267114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f267115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f267116g;

    public static final class a {
    }

    static {
    }

    public final Keva a() {
        return (Keva) this.f267112c.getValue();
    }

    public PredictManager() {
        this.f267112c = LazyKt.lazy(PredictManager$repo$2.INSTANCE);
        this.f267114e = new LinkedList();
    }
}
