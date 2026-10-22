package qc1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f532433a = null;

    static {
        f532433a = new a();
    }

    public a() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_anchor_exposure_log", "主播曝光变更日志开关", r100, r100);
    }
}
