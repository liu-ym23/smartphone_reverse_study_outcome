package com.larus.avlink.simulInterpret.page.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/SliderLevel;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM", "MIDDLE", "TOP", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SliderLevel extends Enum<SliderLevel> {
    public static final SliderLevel BOTTOM = null;
    public static final SliderLevel MIDDLE = null;
    public static final SliderLevel TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SliderLevel[] f294487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294488b = null;

    public static EnumEntries<SliderLevel> getEntries() {
        return f294488b;
    }

    static {
        SliderLevel r100 = new SliderLevel("BOTTOM", 0);
        BOTTOM = r100;
        SliderLevel r101 = new SliderLevel("MIDDLE", 1);
        MIDDLE = r101;
        SliderLevel r102 = new SliderLevel("TOP", 2);
        TOP = r102;
        SliderLevel[] r103 = {r100, r101, r102};
        f294487a = r103;
        f294488b = EnumEntriesKt.enumEntries(r103);
    }

    public static SliderLevel[] values() {
        return (SliderLevel[]) f294487a.clone();
    }

    public static SliderLevel valueOf(String r100) {
        return (SliderLevel) r27.a.a(SliderLevel.class, r100);
    }

    public SliderLevel(String r100, int r101) {
        super(r100, r101);
    }
}
