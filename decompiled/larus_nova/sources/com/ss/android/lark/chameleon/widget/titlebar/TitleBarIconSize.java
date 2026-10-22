package com.ss.android.lark.chameleon.widget.titlebar;

import android.content.Context;
import com.ss.android.lark.chameleon.util.UiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleon/widget/titlebar/TitleBarIconSize;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "leftIconSize", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "rightActionSize", "Lkotlin/Pair;", EffectConstants.NORMAL, "SMALL", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum TitleBarIconSize extends Enum<TitleBarIconSize> {
    private static final /* synthetic */ TitleBarIconSize[] $VALUES = null;
    public static final TitleBarIconSize NORMAL = null;
    public static final TitleBarIconSize SMALL = null;
    private final int value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
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

    public static TitleBarIconSize valueOf(String r100) {
        return (TitleBarIconSize) a.a(TitleBarIconSize.class, r100);
    }

    public static TitleBarIconSize[] values() {
        return (TitleBarIconSize[]) $VALUES.clone();
    }

    static {
        NORMAL = new TitleBarIconSize(EffectConstants.NORMAL, 0, 0);
        SMALL = new TitleBarIconSize("SMALL", 1, 1);
        $VALUES = $values();
    }

    public final int getValue() {
        return this.value;
    }

    public final int leftIconSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] != 1) goto L6;
        return UiUtils.dp2px(r100, CommonTitleBarConstants.ICON_SIZE_BOTTOM_SHEET);
    L6:
        return UiUtils.dp2px(r100, CommonTitleBarConstants.ICON_SIZE_FULL_SCREEN);
    }

    public final Pair<Integer, Integer> rightActionSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] != 1) goto L6;
        return TuplesKt.to(Integer.valueOf(UiUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_WIDTH_SIZE_SMALL)), Integer.valueOf(UiUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_HEIGHT_SIZE_SMALL)));
    L6:
        return TuplesKt.to(Integer.valueOf(UiUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_WIDTH_SIZE_NORMAL)), Integer.valueOf(UiUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_HEIGHT_SIZE_NORMAL)));
    }

    private TitleBarIconSize(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
