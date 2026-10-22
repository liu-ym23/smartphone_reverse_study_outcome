package com.obric.miniapp.sheet;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_HEIGHT", "WRAP_CONTENT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MiniAppSheetHeightMode extends Enum<MiniAppSheetHeightMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MiniAppSheetHeightMode[] $VALUES = null;
    public static final Companion Companion = null;
    public static final MiniAppSheetHeightMode FULL_HEIGHT = null;
    public static final MiniAppSheetHeightMode WRAP_CONTENT = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode$Companion;", "", "<init>", "()V", "from", "Lcom/obric/miniapp/sheet/MiniAppSheetHeightMode;", "rawValue", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final MiniAppSheetHeightMode from(String r100) {
            if (r100 == null) goto L7;
            String r101 = StringsKt.trim(r100).toString();
            if (r101 == null) goto L7;
            String r102 = r101.toUpperCase(Locale.ROOT);
        L9:
            if (Intrinsics.areEqual(r102, "FULL_HEIGHT") == false) goto L12;
            return MiniAppSheetHeightMode.FULL_HEIGHT;
        L12:
            if (Intrinsics.areEqual(r102, "WRAP_CONTENT") == true) goto L14;
            return null;
        L14:
            return MiniAppSheetHeightMode.WRAP_CONTENT;
        L7:
            r102 = null;
            goto L9
        }
    }

    private static final /* synthetic */ MiniAppSheetHeightMode[] $values() {
        return new MiniAppSheetHeightMode[]{FULL_HEIGHT, WRAP_CONTENT};
    }

    public static EnumEntries<MiniAppSheetHeightMode> getEntries() {
        return $ENTRIES;
    }

    static {
        FULL_HEIGHT = new MiniAppSheetHeightMode("FULL_HEIGHT", 0);
        WRAP_CONTENT = new MiniAppSheetHeightMode("WRAP_CONTENT", 1);
        MiniAppSheetHeightMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static MiniAppSheetHeightMode[] values() {
        return (MiniAppSheetHeightMode[]) $VALUES.clone();
    }

    public static MiniAppSheetHeightMode valueOf(String r100) {
        return (MiniAppSheetHeightMode) r27.a.a(MiniAppSheetHeightMode.class, r100);
    }

    private MiniAppSheetHeightMode(String r100, int r101) {
        super(r100, r101);
    }
}
