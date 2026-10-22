package com.bytedance.livesdk.preview.base;

import android.util.Log;
import com.bytedance.android.live.core.utils.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/livesdk/preview/base/NoPriority;", "", "Lcom/bytedance/livesdk/preview/base/d;", "Lcom/bytedance/livesdk/preview/base/VHWidgetGroup;", "getGroup", "other", "", "compareWith", "NO_PRIORITY", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NoPriority extends Enum<NoPriority> implements d {
    public static final NoPriority NO_PRIORITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoPriority[] f256403a = null;

    static {
        NoPriority r100 = new NoPriority();
        NO_PRIORITY = r100;
        f256403a = new NoPriority[]{r100};
    }

    public static NoPriority valueOf(String r100) {
        return (NoPriority) r27.a.a(NoPriority.class, r100);
    }

    public static NoPriority[] values() {
        return (NoPriority[]) f256403a.clone();
    }

    public NoPriority() {
        super("NO_PRIORITY", 0);
    }

    public VHWidgetGroup getGroup() {
        return VHWidgetGroup.NO_GROUP_ID;
    }

    public int compareWith(d r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = VHWidgetManager.f256412l;
        if (v.a() == true) goto L7;
        return 0;
    L7:
        throw new Exception("NO_PRIORITY 不允许做比较  " + Log.getStackTraceString(new Throwable()));
    }
}
