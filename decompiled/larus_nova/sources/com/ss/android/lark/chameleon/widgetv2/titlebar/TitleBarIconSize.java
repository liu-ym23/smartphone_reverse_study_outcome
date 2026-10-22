package com.ss.android.lark.chameleon.widgetv2.titlebar;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import swb.p;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/widgetv2/titlebar/TitleBarIconSize;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "SMALL", "leftIconSize", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "rightActionSize", "Lkotlin/Pair;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleBarIconSize extends Enum<TitleBarIconSize> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TitleBarIconSize[] $VALUES = null;
    public static final TitleBarIconSize NORMAL = null;
    public static final TitleBarIconSize SMALL = null;
    private final int value;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[TitleBarIconSize.values().length];
            r100[TitleBarIconSize.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ TitleBarIconSize[] $values() {
        return new TitleBarIconSize[]{NORMAL, SMALL};
    }

    public static EnumEntries<TitleBarIconSize> getEntries() {
        return $ENTRIES;
    }

    static {
        NORMAL = new TitleBarIconSize(EffectConstants.NORMAL, 0, 0);
        SMALL = new TitleBarIconSize("SMALL", 1, 1);
        TitleBarIconSize[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TitleBarIconSize[] values() {
        return (TitleBarIconSize[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TitleBarIconSize valueOf(String r100) {
        return (TitleBarIconSize) a.a(TitleBarIconSize.class, r100);
    }

    public final int leftIconSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] != 1) goto L5;
        p.a r101 = p.f543779a;
        return p.a.a(r100, CommonTitleBarConstants.ICON_SIZE_BOTTOM_SHEET);
    L5:
        p.a r102 = p.f543779a;
        return p.a.a(r100, CommonTitleBarConstants.ICON_SIZE_FULL_SCREEN);
    }

    public final Pair<Integer, Integer> rightActionSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] != 1) goto L5;
        p.a r101 = p.f543779a;
        return TuplesKt.to(Integer.valueOf(p.a.a(r100, CommonTitleBarConstants.ICON_ACTION_WIDTH_SIZE_SMALL)), Integer.valueOf(p.a.a(r100, CommonTitleBarConstants.ICON_ACTION_HEIGHT_SIZE_SMALL)));
    L5:
        p.a r102 = p.f543779a;
        return TuplesKt.to(Integer.valueOf(p.a.a(r100, CommonTitleBarConstants.ICON_ACTION_WIDTH_SIZE_NORMAL)), Integer.valueOf(p.a.a(r100, CommonTitleBarConstants.ICON_ACTION_HEIGHT_SIZE_NORMAL)));
    }

    private TitleBarIconSize(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
