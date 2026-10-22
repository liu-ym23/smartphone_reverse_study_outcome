package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAlternateImageFillMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamLayoutRegionType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamMediaType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamRenderMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import zf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public double i;
    public double j;
    public LiveWrappedMixedStreamMediaType k;
    public LiveWrappedMixedStreamRenderMode l;
    public boolean m;
    public LiveWrappedMixedStreamVideoType n;
    public final LiveWrappedMixedStreamAlternateImageFillMode o;
    public final String p;
    public boolean q;
    public u r;
    public boolean s;
    public int t;
    public boolean u;

    public g() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.f = 360;
        this.g = 640;
        this.i = 1.0d;
        this.k = LiveWrappedMixedStreamMediaType.MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO;
        this.l = LiveWrappedMixedStreamRenderMode.MIXED_STREAM_RENDER_MODE_HIDDEN;
        this.n = LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN;
        LiveWrappedMixedStreamLayoutRegionType r1 = LiveWrappedMixedStreamLayoutRegionType.MIXED_STREAM_LAYOUT_REGION_TYPE_VIDEO_STREAM;
        this.o = LiveWrappedMixedStreamAlternateImageFillMode.FIT;
        this.p = "";
        new d0();
        this.q = true;
        this.r = new u();
    }
}
