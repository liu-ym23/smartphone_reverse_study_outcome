package com.github.alexzhirkevich.customqrgenerator.dsl;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/dsl/Efficiency;", "", "Memory", "Time", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
public final enum Efficiency extends Enum<Efficiency> {
    public static final Efficiency Memory = null;
    public static final Efficiency Time = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Efficiency[] f274250a = null;

    public static Efficiency valueOf(String r100) {
        return (Efficiency) a.a(Efficiency.class, r100);
    }

    public static Efficiency[] values() {
        return (Efficiency[]) f274250a.clone();
    }

    static {
        Efficiency r100 = new Efficiency("Memory", 0);
        Memory = r100;
        Efficiency r101 = new Efficiency("Time", 1);
        Time = r101;
        f274250a = new Efficiency[]{r100, r101};
    }

    public Efficiency(String r100, int r101) {
        super(r100, r101);
    }
}
