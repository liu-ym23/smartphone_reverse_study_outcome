package com.bytedance.kmp.common.context;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/common/context/DevicePlatform;", "", "HARMONY", "ANDROID", "IOS", "common_service_release"}, k = 1, mv = {1, 7, 0})
public final enum DevicePlatform extends Enum<DevicePlatform> {
    public static final DevicePlatform ANDROID = null;
    public static final DevicePlatform HARMONY = null;
    public static final DevicePlatform IOS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DevicePlatform[] f251227a = null;

    public static DevicePlatform valueOf(String r100) {
        return (DevicePlatform) a.a(DevicePlatform.class, r100);
    }

    public static DevicePlatform[] values() {
        return (DevicePlatform[]) f251227a.clone();
    }

    static {
        DevicePlatform r100 = new DevicePlatform("HARMONY", 0);
        HARMONY = r100;
        DevicePlatform r101 = new DevicePlatform("ANDROID", 1);
        ANDROID = r101;
        DevicePlatform r102 = new DevicePlatform("IOS", 2);
        IOS = r102;
        f251227a = new DevicePlatform[]{r100, r101, r102};
    }

    public DevicePlatform(String r100, int r101) {
        super(r100, r101);
    }
}
