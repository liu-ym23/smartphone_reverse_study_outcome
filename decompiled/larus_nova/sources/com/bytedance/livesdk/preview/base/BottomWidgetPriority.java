package com.bytedance.livesdk.preview.base;

import android.util.Log;
import com.bytedance.android.live.core.utils.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/livesdk/preview/base/BottomWidgetPriority;", "", "Lcom/bytedance/livesdk/preview/base/d;", "Lcom/bytedance/livesdk/preview/base/VHWidgetGroup;", "getGroup", "other", "", "compareWith", "EXTEND_AREA_WIDGET", "BOTTOM_GUIDE_WIDGET", "LIVE_LITE_INNER_PRODUCT_WIDGET", "PREVIEW_EXTEND_OPT_WIDGET_CONTENT", "ACTIVITIES_WIDGET", "BOTTOM_FOLLOW_WIDGET", "PREVIEW_EXTEND_OPT_WIDGET_ENTER_INTERACTION", "MANNOR_PINNED_WIDGET", "LIVE_TAB_GUIDE_WIDGET", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BottomWidgetPriority extends Enum<BottomWidgetPriority> implements d {
    public static final BottomWidgetPriority ACTIVITIES_WIDGET = null;
    public static final BottomWidgetPriority BOTTOM_FOLLOW_WIDGET = null;
    public static final BottomWidgetPriority BOTTOM_GUIDE_WIDGET = null;
    public static final BottomWidgetPriority EXTEND_AREA_WIDGET = null;
    public static final BottomWidgetPriority LIVE_LITE_INNER_PRODUCT_WIDGET = null;
    public static final BottomWidgetPriority LIVE_TAB_GUIDE_WIDGET = null;
    public static final BottomWidgetPriority MANNOR_PINNED_WIDGET = null;
    public static final BottomWidgetPriority PREVIEW_EXTEND_OPT_WIDGET_CONTENT = null;
    public static final BottomWidgetPriority PREVIEW_EXTEND_OPT_WIDGET_ENTER_INTERACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomWidgetPriority[] f256402a = null;

    static {
        BottomWidgetPriority r100 = new BottomWidgetPriority("EXTEND_AREA_WIDGET", 0);
        EXTEND_AREA_WIDGET = r100;
        BottomWidgetPriority r101 = new BottomWidgetPriority("BOTTOM_GUIDE_WIDGET", 1);
        BOTTOM_GUIDE_WIDGET = r101;
        BottomWidgetPriority r102 = new BottomWidgetPriority("LIVE_LITE_INNER_PRODUCT_WIDGET", 2);
        LIVE_LITE_INNER_PRODUCT_WIDGET = r102;
        BottomWidgetPriority r103 = new BottomWidgetPriority("PREVIEW_EXTEND_OPT_WIDGET_CONTENT", 3);
        PREVIEW_EXTEND_OPT_WIDGET_CONTENT = r103;
        BottomWidgetPriority r104 = new BottomWidgetPriority("ACTIVITIES_WIDGET", 4);
        ACTIVITIES_WIDGET = r104;
        BottomWidgetPriority r105 = new BottomWidgetPriority("BOTTOM_FOLLOW_WIDGET", 5);
        BOTTOM_FOLLOW_WIDGET = r105;
        BottomWidgetPriority r106 = new BottomWidgetPriority("PREVIEW_EXTEND_OPT_WIDGET_ENTER_INTERACTION", 6);
        PREVIEW_EXTEND_OPT_WIDGET_ENTER_INTERACTION = r106;
        BottomWidgetPriority r107 = new BottomWidgetPriority("MANNOR_PINNED_WIDGET", 7);
        MANNOR_PINNED_WIDGET = r107;
        BottomWidgetPriority r108 = new BottomWidgetPriority("LIVE_TAB_GUIDE_WIDGET", 8);
        LIVE_TAB_GUIDE_WIDGET = r108;
        f256402a = new BottomWidgetPriority[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static BottomWidgetPriority valueOf(String r100) {
        return (BottomWidgetPriority) r27.a.a(BottomWidgetPriority.class, r100);
    }

    public static BottomWidgetPriority[] values() {
        return (BottomWidgetPriority[]) f256402a.clone();
    }

    public VHWidgetGroup getGroup() {
        return VHWidgetGroup.EXTEND_BOTTOM_AREA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int compareWith(d r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof BottomWidgetPriority) == true) goto L5;
        int r101 = VHWidgetManager.f256412l;
        if (v.a() == true) goto L11;
        return 0;
    L11:
        throw new Exception("不相同的VHWidgetPriority不允许做比较  " + Log.getStackTraceString(new Throwable()));
    L5:
        return compareTo((Enum) r100);
    }

    public BottomWidgetPriority(String r100, int r101) {
        super(r100, r101);
    }
}
