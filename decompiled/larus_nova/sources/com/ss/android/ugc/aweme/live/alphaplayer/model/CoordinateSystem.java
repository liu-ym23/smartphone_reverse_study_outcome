package com.ss.android.ugc.aweme.live.alphaplayer.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/model/CoordinateSystem;", "", "GL", "Texture", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final enum CoordinateSystem extends Enum<CoordinateSystem> {
    public static final CoordinateSystem GL = null;
    public static final CoordinateSystem Texture = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoordinateSystem[] f451123a = null;

    static {
        CoordinateSystem r100 = new CoordinateSystem("GL", 0);
        GL = r100;
        CoordinateSystem r101 = new CoordinateSystem("Texture", 1);
        Texture = r101;
        f451123a = new CoordinateSystem[]{r100, r101};
    }

    public static CoordinateSystem valueOf(String r100) {
        return (CoordinateSystem) a.a(CoordinateSystem.class, r100);
    }

    public static CoordinateSystem[] values() {
        return (CoordinateSystem[]) f451123a.clone();
    }

    public CoordinateSystem(String r100, int r101) {
        super(r100, r101);
    }
}
