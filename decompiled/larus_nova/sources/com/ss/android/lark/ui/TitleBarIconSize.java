package com.ss.android.lark.ui;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/ui/TitleBarIconSize;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "SMALL", "leftIconSize", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "rightActionSize", "Lkotlin/Pair;", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleBarIconSize extends Enum<TitleBarIconSize> {
    public static final TitleBarIconSize NORMAL = null;
    public static final TitleBarIconSize SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBarIconSize[] f444566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444567b = null;
    private final int value;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444568a = null;

        static {
            int[] r100 = new int[TitleBarIconSize.values().length];
            r100[TitleBarIconSize.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f444568a = r100;
        }
    }

    public static EnumEntries<TitleBarIconSize> getEntries() {
        return f444567b;
    }

    static {
        TitleBarIconSize r100 = new TitleBarIconSize(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        TitleBarIconSize r101 = new TitleBarIconSize("SMALL", 1, 1);
        SMALL = r101;
        TitleBarIconSize[] r102 = {r100, r101};
        f444566a = r102;
        f444567b = EnumEntriesKt.enumEntries(r102);
    }

    public static TitleBarIconSize[] values() {
        return (TitleBarIconSize[]) f444566a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TitleBarIconSize valueOf(String r100) {
        return (TitleBarIconSize) r27.a.a(TitleBarIconSize.class, r100);
    }

    public final int leftIconSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a.f444568a[ordinal()] != 1) goto L6;
        return UIUtils.dp2px(r100, CommonTitleBarConstants.ICON_SIZE_BOTTOM_SHEET);
    L6:
        return UIUtils.dp2px(r100, CommonTitleBarConstants.ICON_SIZE_FULL_SCREEN);
    }

    public final Pair<Integer, Integer> rightActionSize(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a.f444568a[ordinal()] != 1) goto L6;
        return TuplesKt.to(Integer.valueOf(UIUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_WIDTH_SIZE_SMALL)), Integer.valueOf(UIUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_HEIGHT_SIZE_SMALL)));
    L6:
        return TuplesKt.to(Integer.valueOf(UIUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_WIDTH_SIZE_NORMAL)), Integer.valueOf(UIUtils.dp2px(r100, CommonTitleBarConstants.ICON_ACTION_HEIGHT_SIZE_NORMAL)));
    }

    public TitleBarIconSize(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
