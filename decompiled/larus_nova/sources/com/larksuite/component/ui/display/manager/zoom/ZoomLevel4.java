package com.larksuite.component.ui.display.manager.zoom;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/ui/display/manager/zoom/ZoomLevel4;", "", "level", "", "multiplier", "", "<init>", "(Ljava/lang/String;IIF)V", "getLevel", "()I", "getMultiplier", "()F", "SMALL", EffectConstants.NORMAL, "LARGE1", "LARGE2", "LARGE3", "LARGE4", "display-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomLevel4 extends Enum<ZoomLevel4> {
    public static final ZoomLevel4 LARGE1 = null;
    public static final ZoomLevel4 LARGE2 = null;
    public static final ZoomLevel4 LARGE3 = null;
    public static final ZoomLevel4 LARGE4 = null;
    public static final ZoomLevel4 NORMAL = null;
    public static final ZoomLevel4 SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ZoomLevel4[] f284141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284142b = null;
    private final int level;
    private final float multiplier;

    public static EnumEntries<ZoomLevel4> getEntries() {
        return f284142b;
    }

    static {
        ZoomLevel4 r100 = new ZoomLevel4("SMALL", 0, -1, 0.92f);
        SMALL = r100;
        ZoomLevel4 r101 = new ZoomLevel4(EffectConstants.NORMAL, 1, 0, 1.0f);
        NORMAL = r101;
        ZoomLevel4 r102 = new ZoomLevel4("LARGE1", 2, 1, 1.08f);
        LARGE1 = r102;
        ZoomLevel4 r103 = new ZoomLevel4("LARGE2", 3, 2, 1.08f);
        LARGE2 = r103;
        ZoomLevel4 r104 = new ZoomLevel4("LARGE3", 4, 3, 1.17f);
        LARGE3 = r104;
        ZoomLevel4 r105 = new ZoomLevel4("LARGE4", 5, 4, 1.17f);
        LARGE4 = r105;
        ZoomLevel4[] r110 = {r100, r101, r102, r103, r104, r105};
        f284141a = r110;
        f284142b = EnumEntriesKt.enumEntries(r110);
    }

    public static ZoomLevel4[] values() {
        return (ZoomLevel4[]) f284141a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public static ZoomLevel4 valueOf(String r100) {
        return (ZoomLevel4) a.a(ZoomLevel4.class, r100);
    }

    public ZoomLevel4(String r100, int r101, int r102, float r103) {
        super(r100, r101);
        this.level = r102;
        this.multiplier = r103;
    }
}
