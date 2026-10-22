package com.ss.android.ugc.aweme.live.alphaplayer.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/model/Align;", "", "Start", "End", "Center", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final enum Align extends Enum<Align> {
    public static final Align Center = null;
    public static final Align End = null;
    public static final Align Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Align[] f451121a = null;

    static {
        Align r100 = new Align("Start", 0);
        Start = r100;
        Align r101 = new Align("End", 1);
        End = r101;
        Align r102 = new Align("Center", 2);
        Center = r102;
        f451121a = new Align[]{r100, r101, r102};
    }

    public static Align valueOf(String r100) {
        return (Align) a.a(Align.class, r100);
    }

    public static Align[] values() {
        return (Align[]) f451121a.clone();
    }

    public Align(String r100, int r101) {
        super(r100, r101);
    }
}
