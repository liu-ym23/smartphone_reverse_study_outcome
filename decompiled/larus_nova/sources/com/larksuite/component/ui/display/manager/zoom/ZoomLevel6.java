package com.larksuite.component.ui.display.manager.zoom;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/ui/display/manager/zoom/ZoomLevel6;", "", "level", "", "multiplier", "", "<init>", "(Ljava/lang/String;IIF)V", "getLevel", "()I", "getMultiplier", "()F", "SMALL", EffectConstants.NORMAL, "LARGE1", "LARGE2", "LARGE3", "LARGE4", "Companion", "display-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomLevel6 extends Enum<ZoomLevel6> {
    public static final a Companion = null;
    public static final ZoomLevel6 LARGE1 = null;
    public static final ZoomLevel6 LARGE2 = null;
    public static final ZoomLevel6 LARGE3 = null;
    public static final ZoomLevel6 LARGE4 = null;
    public static final ZoomLevel6 NORMAL = null;
    public static final ZoomLevel6 SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ZoomLevel6[] f284143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284144b = null;
    private final int level;
    private final float multiplier;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ZoomLevel6> getEntries() {
        return f284144b;
    }

    static {
        ZoomLevel6 r100 = new ZoomLevel6("SMALL", 0, -1, 0.92f);
        SMALL = r100;
        ZoomLevel6 r101 = new ZoomLevel6(EffectConstants.NORMAL, 1, 0, 1.0f);
        NORMAL = r101;
        ZoomLevel6 r102 = new ZoomLevel6("LARGE1", 2, 1, 1.08f);
        LARGE1 = r102;
        ZoomLevel6 r103 = new ZoomLevel6("LARGE2", 3, 2, 1.17f);
        LARGE2 = r103;
        ZoomLevel6 r104 = new ZoomLevel6("LARGE3", 4, 3, 1.28f);
        LARGE3 = r104;
        ZoomLevel6 r105 = new ZoomLevel6("LARGE4", 5, 4, 1.38f);
        LARGE4 = r105;
        ZoomLevel6[] r110 = {r100, r101, r102, r103, r104, r105};
        f284143a = r110;
        f284144b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static ZoomLevel6[] values() {
        return (ZoomLevel6[]) f284143a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public static ZoomLevel6 valueOf(String r100) {
        return (ZoomLevel6) r27.a.a(ZoomLevel6.class, r100);
    }

    public ZoomLevel6(String r100, int r101, int r102, float r103) {
        super(r100, r101);
        this.level = r102;
        this.multiplier = r103;
    }
}
