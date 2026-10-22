package com.bytedance.android.livesdk.live.extension.plugin.api.rtc;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import va1.b;
import zf2.g0;
import zf2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0013\u001a\u00020\u0004H&J\b\u0010\u0014\u001a\u00020\u0004H&J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\nH&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/ILiveWrappedRtcService;", "Lcom/bytedance/android/live/base/IService;", "Lcg2/a;", "rtcNativeLibraryLoader", "", "setRtcNativeLibraryLoader", "Lzf2/q;", "configWrapper", "Lag2/a;", "handlerWrapper", "Lyf2/a;", "createRTCEngine", "createRTCEngineMulti", "config", "handler", "Lag2/b;", "handlerEx", "Lyf2/b;", "createRTCEngineEx", "destroyRTCEngine", "destroyRTCEngineEx", "wrappedRTCEngine", "destroyRTCEngineMulti", "", "getSDKVersion", "Lzf2/g0;", "logConfig", "", "setLogConfig", "Companion", "a", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedRtcService extends IService {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static ILiveWrappedRtcService a() {
            return (ILiveWrappedRtcService) b.a.a.a(ILiveWrappedRtcService.class);
        }
    }

    static {
        Companion = a.a;
    }

    yf2.a createRTCEngine(q r1, ag2.a r2);

    yf2.b createRTCEngineEx(q r1, ag2.a r2, ag2.b r3);

    yf2.a createRTCEngineMulti(q r1, ag2.a r2);

    void destroyRTCEngine();

    void destroyRTCEngineEx();

    void destroyRTCEngineMulti(yf2.a r1);

    String getSDKVersion();

    int setLogConfig(g0 r1);

    void setRtcNativeLibraryLoader(cg2.a r1);
}
