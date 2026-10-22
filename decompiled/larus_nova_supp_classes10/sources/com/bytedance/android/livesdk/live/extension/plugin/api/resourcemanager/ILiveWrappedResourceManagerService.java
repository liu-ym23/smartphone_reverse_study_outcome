package com.bytedance.android.livesdk.live.extension.plugin.api.resourcemanager;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import xf2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/resourcemanager/ILiveWrappedResourceManagerService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "Lwf2/a;", "getResourceManager", "Lxf2/b;", "getDownloadManager", "Lxf2/a;", "deviceIdGenerator", "", "setDeviceGenerator", "Companion", "a", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedResourceManagerService extends IService {
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

    b getDownloadManager();

    wf2.a getResourceManager(Context r1);

    void setDeviceGenerator(xf2.a r1);
}
