package com.ss.android.lark.movable.selection;

import com.android.ttcjpaysdk.base.ui.Utils.CJPayDiscountTextUtils;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/movable/selection/HandleStyle;", "", "<init>", "(Ljava/lang/String;I)V", CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, EffectConstants.NORMAL, "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HandleStyle extends Enum<HandleStyle> {
    public static final HandleStyle LINE = null;
    public static final HandleStyle NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HandleStyle[] f432719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432720b = null;

    public static EnumEntries<HandleStyle> getEntries() {
        return f432720b;
    }

    static {
        HandleStyle r100 = new HandleStyle(CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, 0);
        LINE = r100;
        HandleStyle r101 = new HandleStyle(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        HandleStyle[] r102 = {r100, r101};
        f432719a = r102;
        f432720b = EnumEntriesKt.enumEntries(r102);
    }

    public static HandleStyle[] values() {
        return (HandleStyle[]) f432719a.clone();
    }

    public static HandleStyle valueOf(String r100) {
        return (HandleStyle) r27.a.a(HandleStyle.class, r100);
    }

    public HandleStyle(String r100, int r101) {
        super(r100, r101);
    }
}
