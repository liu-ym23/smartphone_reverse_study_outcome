package com.bytedance.pythia.predict;

import com.bytedance.keva.Keva;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PowerSubScorePredictManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f267102g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f267103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f267104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f267105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<Float> f267106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f267107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f267108f;

    public static final class a {
    }

    static {
    }

    public final Keva a() {
        return (Keva) this.f267104b.getValue();
    }

    public PowerSubScorePredictManager() {
        this.f267104b = LazyKt.lazy(PowerSubScorePredictManager$repo$2.INSTANCE);
        this.f267106d = new LinkedList();
    }
}
