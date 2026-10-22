package com.ss.android.ugc.aweme.live.alphaplayer.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/model/Axis;", "", "X", "Y", "Longer", "Shorter", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final enum Axis extends Enum<Axis> {
    public static final Axis Longer = null;
    public static final Axis Shorter = null;
    public static final Axis X = null;
    public static final Axis Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Axis[] f451122a = null;

    static {
        Axis r100 = new Axis("X", 0);
        X = r100;
        Axis r101 = new Axis("Y", 1);
        Y = r101;
        Axis r102 = new Axis("Longer", 2);
        Longer = r102;
        Axis r103 = new Axis("Shorter", 3);
        Shorter = r103;
        f451122a = new Axis[]{r100, r101, r102, r103};
    }

    public static Axis valueOf(String r100) {
        return (Axis) a.a(Axis.class, r100);
    }

    public static Axis[] values() {
        return (Axis[]) f451122a.clone();
    }

    public Axis(String r100, int r101) {
        super(r100, r101);
    }
}
