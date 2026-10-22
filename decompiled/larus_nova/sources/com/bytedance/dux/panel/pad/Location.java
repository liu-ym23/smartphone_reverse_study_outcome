package com.bytedance.dux.panel.pad;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dux/panel/pad/Location;", "", "BOTTOM", "CORNER", "CENTER", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum Location extends Enum<Location> {
    public static final Location BOTTOM = null;
    public static final Location CENTER = null;
    public static final Location CORNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Location[] f205394a = null;

    public static Location valueOf(String r100) {
        return (Location) a.a(Location.class, r100);
    }

    public static Location[] values() {
        return (Location[]) f205394a.clone();
    }

    static {
        Location r100 = new Location("BOTTOM", 0);
        BOTTOM = r100;
        Location r101 = new Location("CORNER", 1);
        CORNER = r101;
        Location r102 = new Location("CENTER", 2);
        CENTER = r102;
        f205394a = new Location[]{r100, r101, r102};
    }

    public Location(String r100, int r101) {
        super(r100, r101);
    }
}
