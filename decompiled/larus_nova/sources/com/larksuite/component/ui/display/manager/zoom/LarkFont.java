package com.larksuite.component.ui.display.manager.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/ui/display/manager/zoom/LarkFont;", "", "small", "", "normal", "large1", "large2", "large3", "large4", "<init>", "(Ljava/lang/String;IIIIIII)V", "getSmall", "()I", "getNormal", "getLarge1", "getLarge2", "getLarge3", "getLarge4", "TITLE0", "TITLE1", "TITLE2", "TITLE3", "TITLE4", "HEADLINE", "BODY0", "BODY1", "BODY2", "CAPTION0", "CAPTION1", "CAPTION2", "CAPTION3", "display-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkFont extends Enum<LarkFont> {
    public static final LarkFont BODY0 = null;
    public static final LarkFont BODY1 = null;
    public static final LarkFont BODY2 = null;
    public static final LarkFont CAPTION0 = null;
    public static final LarkFont CAPTION1 = null;
    public static final LarkFont CAPTION2 = null;
    public static final LarkFont CAPTION3 = null;
    public static final LarkFont HEADLINE = null;
    public static final LarkFont TITLE0 = null;
    public static final LarkFont TITLE1 = null;
    public static final LarkFont TITLE2 = null;
    public static final LarkFont TITLE3 = null;
    public static final LarkFont TITLE4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkFont[] f284139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284140b = null;
    private final int large1;
    private final int large2;
    private final int large3;
    private final int large4;
    private final int normal;
    private final int small;

    public static EnumEntries<LarkFont> getEntries() {
        return f284140b;
    }

    static {
        LarkFont r100 = new LarkFont("TITLE0", 0, 24, 26, 28, 30, 34, 40);
        TITLE0 = r100;
        LarkFont r101 = new LarkFont("TITLE1", 1, 22, 24, 26, 28, 32, 36);
        TITLE1 = r101;
        LarkFont r102 = new LarkFont("TITLE2", 2, 18, 20, 22, 24, 28, 32);
        TITLE2 = r102;
        LarkFont r103 = new LarkFont("TITLE3", 3, 16, 17, 18, 20, 24, 28);
        TITLE3 = r103;
        LarkFont r104 = new LarkFont("TITLE4", 4, 16, 17, 18, 20, 24, 28);
        TITLE4 = r104;
        LarkFont r105 = new LarkFont("HEADLINE", 5, 15, 16, 17, 18, 20, 24);
        HEADLINE = r105;
        LarkFont r106 = new LarkFont("BODY0", 6, 15, 16, 17, 18, 20, 24);
        BODY0 = r106;
        LarkFont r107 = new LarkFont("BODY1", 7, 13, 14, 15, 16, 18, 20);
        BODY1 = r107;
        LarkFont r108 = new LarkFont("BODY2", 8, 13, 14, 15, 16, 18, 20);
        BODY2 = r108;
        LarkFont r109 = new LarkFont("CAPTION0", 9, 11, 12, 13, 14, 15, 16);
        CAPTION0 = r109;
        LarkFont r110 = new LarkFont("CAPTION1", 10, 11, 12, 13, 14, 15, 16);
        CAPTION1 = r110;
        LarkFont r210 = new LarkFont("CAPTION2", 11, 9, 10, 11, 12, 13, 14);
        CAPTION2 = r210;
        LarkFont r111 = new LarkFont("CAPTION3", 12, 9, 10, 11, 12, 13, 14);
        CAPTION3 = r111;
        LarkFont[] r112 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r210, r111};
        f284139a = r112;
        f284140b = EnumEntriesKt.enumEntries(r112);
    }

    public static LarkFont[] values() {
        return (LarkFont[]) f284139a.clone();
    }

    public final int getLarge1() {
        return this.large1;
    }

    public final int getLarge2() {
        return this.large2;
    }

    public final int getLarge3() {
        return this.large3;
    }

    public final int getLarge4() {
        return this.large4;
    }

    public final int getNormal() {
        return this.normal;
    }

    public final int getSmall() {
        return this.small;
    }

    public static LarkFont valueOf(String r100) {
        return (LarkFont) a.a(LarkFont.class, r100);
    }

    public LarkFont(String r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        super(r100, r101);
        this.small = r102;
        this.normal = r103;
        this.large1 = r104;
        this.large2 = r105;
        this.large3 = r106;
        this.large4 = r107;
    }
}
