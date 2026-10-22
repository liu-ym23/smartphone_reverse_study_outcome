package yf2;

import android.view.Surface;
import android.view.View;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoRotation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public View a;
    public Surface b;
    public int c;
    public final LiveWrappedVideoRotation d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("VideoCanvas{, textureView=");
        r0.append(this.a);
        r0.append(", surface=");
        r0.append(this.b);
        r0.append(", renderMode=");
        r0.append(this.c);
        r0.append(", background_color=0, renderRotation=");
        LiveWrappedVideoRotation r1 = this.d;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.value());
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public f() {
        this.a = null;
        this.b = null;
        this.c = 1;
        this.d = LiveWrappedVideoRotation.VIDEO_ROTATION_0;
    }
}
