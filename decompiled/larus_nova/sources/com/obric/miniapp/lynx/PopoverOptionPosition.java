package com.obric.miniapp.lynx;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/lynx/PopoverOptionPosition;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum PopoverOptionPosition extends Enum<PopoverOptionPosition> {
    public static final PopoverOptionPosition LEFT = null;
    public static final PopoverOptionPosition RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopoverOptionPosition[] f398022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f398023b = null;

    public static EnumEntries<PopoverOptionPosition> getEntries() {
        return f398023b;
    }

    static {
        PopoverOptionPosition r100 = new PopoverOptionPosition("LEFT", 0);
        LEFT = r100;
        PopoverOptionPosition r101 = new PopoverOptionPosition("RIGHT", 1);
        RIGHT = r101;
        PopoverOptionPosition[] r102 = {r100, r101};
        f398022a = r102;
        f398023b = EnumEntriesKt.enumEntries(r102);
    }

    public static PopoverOptionPosition[] values() {
        return (PopoverOptionPosition[]) f398022a.clone();
    }

    public static PopoverOptionPosition valueOf(String r100) {
        return (PopoverOptionPosition) r27.a.a(PopoverOptionPosition.class, r100);
    }

    public PopoverOptionPosition(String r100, int r101) {
        super(r100, r101);
    }
}
