package com.obric.assistant.interaction.impl.window.helpers;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW", BannerBizName.ACTIVITY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OverlaySource extends Enum<OverlaySource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OverlaySource[] $VALUES = null;
    public static final OverlaySource ACTIVITY = null;
    public static final OverlaySource WINDOW = null;

    private static final /* synthetic */ OverlaySource[] $values() {
        return new OverlaySource[]{WINDOW, ACTIVITY};
    }

    public static EnumEntries<OverlaySource> getEntries() {
        return $ENTRIES;
    }

    static {
        WINDOW = new OverlaySource("WINDOW", 0);
        ACTIVITY = new OverlaySource(BannerBizName.ACTIVITY, 1);
        OverlaySource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OverlaySource[] values() {
        return (OverlaySource[]) $VALUES.clone();
    }

    public static OverlaySource valueOf(String r100) {
        return (OverlaySource) r27.a.a(OverlaySource.class, r100);
    }

    private OverlaySource(String r100, int r101) {
        super(r100, r101);
    }
}
