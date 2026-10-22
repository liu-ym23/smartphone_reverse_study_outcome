package com.larksuite.component.universe_design.menu;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/menu/PositionAlign;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "CENTER", GXAnimation.STATE_END, "universe-ui-menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PositionAlign extends Enum<PositionAlign> {
    public static final PositionAlign CENTER = null;
    public static final PositionAlign END = null;
    public static final PositionAlign START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PositionAlign[] f285065a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285066b = null;

    public static EnumEntries<PositionAlign> getEntries() {
        return f285066b;
    }

    static {
        PositionAlign r100 = new PositionAlign(GXAnimation.STATE_START, 0);
        START = r100;
        PositionAlign r101 = new PositionAlign("CENTER", 1);
        CENTER = r101;
        PositionAlign r102 = new PositionAlign(GXAnimation.STATE_END, 2);
        END = r102;
        PositionAlign[] r103 = {r100, r101, r102};
        f285065a = r103;
        f285066b = EnumEntriesKt.enumEntries(r103);
    }

    public static PositionAlign[] values() {
        return (PositionAlign[]) f285065a.clone();
    }

    public static PositionAlign valueOf(String r100) {
        return (PositionAlign) r27.a.a(PositionAlign.class, r100);
    }

    public PositionAlign(String r100, int r101) {
        super(r100, r101);
    }
}
