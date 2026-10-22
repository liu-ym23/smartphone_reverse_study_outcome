package com.bytedance.livesdk.preview.base;

import android.util.Log;
import com.bytedance.android.live.core.utils.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/livesdk/preview/base/BottomBarAreaPriority;", "", "Lcom/bytedance/livesdk/preview/base/d;", "Lcom/bytedance/livesdk/preview/base/VHWidgetGroup;", "getGroup", "other", "", "compareWith", "LIVE_NEW_EXTEND_COMPONENT_WIDGET", "UNIVERSAL_SEARCH_WIDGET", "BROADCAST_START_LIVE_WIDGET", "MULTI_LINK_GAME_BROADCAST_START_LIVE_WIDGET", "SIMILAR_COLLECTION_WIDGET", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BottomBarAreaPriority extends Enum<BottomBarAreaPriority> implements d {
    public static final BottomBarAreaPriority BROADCAST_START_LIVE_WIDGET = null;
    public static final BottomBarAreaPriority LIVE_NEW_EXTEND_COMPONENT_WIDGET = null;
    public static final BottomBarAreaPriority MULTI_LINK_GAME_BROADCAST_START_LIVE_WIDGET = null;
    public static final BottomBarAreaPriority SIMILAR_COLLECTION_WIDGET = null;
    public static final BottomBarAreaPriority UNIVERSAL_SEARCH_WIDGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomBarAreaPriority[] f256401a = null;

    static {
        BottomBarAreaPriority r100 = new BottomBarAreaPriority("LIVE_NEW_EXTEND_COMPONENT_WIDGET", 0);
        LIVE_NEW_EXTEND_COMPONENT_WIDGET = r100;
        BottomBarAreaPriority r101 = new BottomBarAreaPriority("UNIVERSAL_SEARCH_WIDGET", 1);
        UNIVERSAL_SEARCH_WIDGET = r101;
        BottomBarAreaPriority r102 = new BottomBarAreaPriority("BROADCAST_START_LIVE_WIDGET", 2);
        BROADCAST_START_LIVE_WIDGET = r102;
        BottomBarAreaPriority r103 = new BottomBarAreaPriority("MULTI_LINK_GAME_BROADCAST_START_LIVE_WIDGET", 3);
        MULTI_LINK_GAME_BROADCAST_START_LIVE_WIDGET = r103;
        BottomBarAreaPriority r104 = new BottomBarAreaPriority("SIMILAR_COLLECTION_WIDGET", 4);
        SIMILAR_COLLECTION_WIDGET = r104;
        f256401a = new BottomBarAreaPriority[]{r100, r101, r102, r103, r104};
    }

    public static BottomBarAreaPriority valueOf(String r100) {
        return (BottomBarAreaPriority) r27.a.a(BottomBarAreaPriority.class, r100);
    }

    public static BottomBarAreaPriority[] values() {
        return (BottomBarAreaPriority[]) f256401a.clone();
    }

    public VHWidgetGroup getGroup() {
        return VHWidgetGroup.BOTTOM_BAR_AREA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int compareWith(d r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof BottomBarAreaPriority) == true) goto L5;
        int r101 = VHWidgetManager.f256412l;
        if (v.a() == true) goto L11;
        return 0;
    L11:
        throw new Exception("不相同的VHWidgetPriority不允许做比较  " + Log.getStackTraceString(new Throwable()));
    L5:
        return compareTo((Enum) r100);
    }

    public BottomBarAreaPriority(String r100, int r101) {
        super(r100, r101);
    }
}
