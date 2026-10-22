package oo1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;

/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f524556a = 0;

    public static boolean a() {
        float r100 = r.o().a();
        if (r100 > 0) goto L5;
    L6:
        return true;
    L5:
        if (r100 >= VSSettingKeys.LIVE_VS_INSIDE_RECORD_PERFORMANCE_LIMIT.getValue().floatValue()) goto L6;
        return false;
    }

    static {
    }
}
