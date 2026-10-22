package yf2;

import android.view.Surface;
import android.view.View;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoRotation;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f567437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f567438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f567439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveWrappedVideoRotation f567440d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("VideoCanvas{, textureView=");
        r100.append(this.f567437a);
        r100.append(", surface=");
        r100.append(this.f567438b);
        r100.append(", renderMode=");
        r100.append(this.f567439c);
        r100.append(", background_color=0, renderRotation=");
        LiveWrappedVideoRotation r101 = this.f567440d;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.value());
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public f() {
        this.f567437a = null;
        this.f567438b = null;
        this.f567439c = 1;
        this.f567440d = LiveWrappedVideoRotation.VIDEO_ROTATION_0;
    }
}
