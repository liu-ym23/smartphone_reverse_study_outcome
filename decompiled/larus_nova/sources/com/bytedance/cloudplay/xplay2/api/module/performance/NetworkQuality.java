package com.bytedance.cloudplay.xplay2.api.module.performance;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/module/performance/NetworkQuality;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GREAT", "GOOD", "MEDIUM", "BAD", "TERRIBLE", "UNKNOWN", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum NetworkQuality extends Enum<NetworkQuality> {
    public static final NetworkQuality BAD = null;
    public static final a Companion = null;
    public static final NetworkQuality GOOD = null;
    public static final NetworkQuality GREAT = null;
    public static final NetworkQuality MEDIUM = null;
    public static final NetworkQuality TERRIBLE = null;
    public static final NetworkQuality UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkQuality[] f202800a = null;
    private final String desc;

    public static NetworkQuality valueOf(String r100) {
        return (NetworkQuality) r27.a.a(NetworkQuality.class, r100);
    }

    public static NetworkQuality[] values() {
        return (NetworkQuality[]) f202800a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.cloudplay.xplay2.api.module.performance.NetworkQuality$a] */
    static {
        NetworkQuality r100 = new NetworkQuality("GREAT", 0, "网络极佳");
        GREAT = r100;
        NetworkQuality r101 = new NetworkQuality("GOOD", 1, "网络良好");
        GOOD = r101;
        NetworkQuality r102 = new NetworkQuality("MEDIUM", 2, "网络一般");
        MEDIUM = r102;
        NetworkQuality r103 = new NetworkQuality("BAD", 3, "网络差");
        BAD = r103;
        NetworkQuality r104 = new NetworkQuality("TERRIBLE", 4, "网络极差");
        TERRIBLE = r104;
        NetworkQuality r105 = new NetworkQuality("UNKNOWN", 5, PlayerResolution.NAME.UNKNOWN);
        UNKNOWN = r105;
        f202800a = new NetworkQuality[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public final String getDesc() {
        return this.desc;
    }

    public NetworkQuality(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
