package com.bytedance.android.livesdk.live.extension.plugin.api.ttvecamera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import gg2.b;
import gg2.c;
import gg2.d;
import gg2.e;
import gg2.f;
import gg2.g;
import gg2.h;
import gg2.i;
import gg2.j;
import gg2.k;
import gg2.l;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 12\u00020\u0001:\u00012J,\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J6\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J*\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001a\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0016¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/ttvecamera/ILiveWrappedTTVECamera;", "Lcom/bytedance/android/live/base/IService;", "T", "Landroid/os/Bundle;", "bundle", "", "key", "", "getParcelableArrayList", "Lgg2/i;", "getTELogUtils", "Lgg2/c;", "getTECameraMonitor", "Lgg2/b$a;", "observer", "Lgg2/b;", "newTECameraCapture", "", "width", "height", "Lgg2/h;", "newTEFrameSizei", "size", "Lgg2/d;", "listener", "", "isPreview", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "textureOES", "Lgg2/e;", "newProviderSettings", "Lgg2/l;", "newTETaintSceneDetectParams", "Lgg2/a;", "newTECameraAlgorithmParam", "Lgg2/j;", "newTEOneKeyProcessParams", "Lgg2/k;", "newTERhythmicMotionParam", "Landroid/content/Context;", "context", LocationMonitorConst.TYPE, "Lgg2/f;", "newTECameraSettings", "min", "max", "Lgg2/g;", "newTEFrameRateRange", "Companion", "a", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedTTVECamera extends IService {
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

    <T> List<T> getParcelableArrayList(Bundle r1, String r2);

    c getTECameraMonitor();

    i getTELogUtils();

    e newProviderSettings(h r1, d r2, boolean r3, SurfaceTexture r4, int r5);

    gg2.a newTECameraAlgorithmParam();

    b newTECameraCapture(b.a r1);

    f newTECameraSettings(Context r1, int r2, int r3, int r4);

    g newTEFrameRateRange(int r1, int r2);

    h newTEFrameSizei(int r1, int r2);

    j newTEOneKeyProcessParams();

    k newTERhythmicMotionParam();

    l newTETaintSceneDetectParams();
}
