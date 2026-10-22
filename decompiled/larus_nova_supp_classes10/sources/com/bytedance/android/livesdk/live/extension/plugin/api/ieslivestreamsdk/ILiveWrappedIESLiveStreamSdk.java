package com.bytedance.android.livesdk.live.extension.plugin.api.ieslivestreamsdk;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/ieslivestreamsdk/ILiveWrappedIESLiveStreamSdk;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/ieslivestreamsdk/ILiveWrappedIESLiveJNITools;", "getIESLiveJNITools", "Lqf2/a;", "getLiveStreamPrinter", "Companion", "a", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedIESLiveStreamSdk extends IService {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    ILiveWrappedIESLiveJNITools getIESLiveJNITools();

    qf2.a getLiveStreamPrinter();
}
