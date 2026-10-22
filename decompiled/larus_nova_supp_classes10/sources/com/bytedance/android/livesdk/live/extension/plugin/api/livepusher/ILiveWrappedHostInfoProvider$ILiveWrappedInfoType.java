package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedHostInfoProvider$ILiveWrappedInfoType", "", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedHostInfoProvider$ILiveWrappedInfoType;", "COMMON_PARAMS", "PERFORMANCE_PARAMS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ILiveWrappedHostInfoProvider$ILiveWrappedInfoType extends Enum<ILiveWrappedHostInfoProvider$ILiveWrappedInfoType> {
    public static final ILiveWrappedHostInfoProvider$ILiveWrappedInfoType COMMON_PARAMS = null;
    public static final ILiveWrappedHostInfoProvider$ILiveWrappedInfoType PERFORMANCE_PARAMS = null;
    public static final /* synthetic */ ILiveWrappedHostInfoProvider$ILiveWrappedInfoType[] a = null;

    static {
        ILiveWrappedHostInfoProvider$ILiveWrappedInfoType r1 = new ILiveWrappedHostInfoProvider$ILiveWrappedInfoType("COMMON_PARAMS", 0);
        COMMON_PARAMS = r1;
        ILiveWrappedHostInfoProvider$ILiveWrappedInfoType r2 = new ILiveWrappedHostInfoProvider$ILiveWrappedInfoType("PERFORMANCE_PARAMS", 1);
        PERFORMANCE_PARAMS = r2;
        a = new ILiveWrappedHostInfoProvider$ILiveWrappedInfoType[]{r1, r2};
    }

    public static ILiveWrappedHostInfoProvider$ILiveWrappedInfoType valueOf(String r1) {
        return (ILiveWrappedHostInfoProvider$ILiveWrappedInfoType) a.a(ILiveWrappedHostInfoProvider$ILiveWrappedInfoType.class, r1);
    }

    public static ILiveWrappedHostInfoProvider$ILiveWrappedInfoType[] values() {
        return (ILiveWrappedHostInfoProvider$ILiveWrappedInfoType[]) a.clone();
    }

    public ILiveWrappedHostInfoProvider$ILiveWrappedInfoType(String r1, int r2) {
        super(r1, r2);
    }
}
