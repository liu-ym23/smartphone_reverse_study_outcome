package com.bytedance.livesdk.preview.base;

import android.util.Log;
import com.bytedance.android.live.core.utils.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/livesdk/preview/base/TopWidgetPriority;", "", "Lcom/bytedance/livesdk/preview/base/d;", "Lcom/bytedance/livesdk/preview/base/VHWidgetGroup;", "getGroup", "other", "", "compareWith", "USER_INFO", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TopWidgetPriority extends Enum<TopWidgetPriority> implements d {
    public static final TopWidgetPriority USER_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TopWidgetPriority[] f256406a = null;

    static {
        TopWidgetPriority r100 = new TopWidgetPriority();
        USER_INFO = r100;
        f256406a = new TopWidgetPriority[]{r100};
    }

    public static TopWidgetPriority valueOf(String r100) {
        return (TopWidgetPriority) r27.a.a(TopWidgetPriority.class, r100);
    }

    public static TopWidgetPriority[] values() {
        return (TopWidgetPriority[]) f256406a.clone();
    }

    public TopWidgetPriority() {
        super("USER_INFO", 0);
    }

    public VHWidgetGroup getGroup() {
        return VHWidgetGroup.EXTEND_TOP_AREA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int compareWith(d r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof TopWidgetPriority) == true) goto L5;
        int r101 = VHWidgetManager.f256412l;
        if (v.a() == true) goto L11;
        return 0;
    L11:
        throw new Exception("不相同的VHWidgetPriority不允许做比较  " + Log.getStackTraceString(new Throwable()));
    L5:
        return compareTo((Enum) r100);
    }
}
