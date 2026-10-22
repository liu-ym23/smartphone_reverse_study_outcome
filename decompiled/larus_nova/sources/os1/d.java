package os1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Los1/d;", "", "", "enableGestureConfig", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableGestureConfig", "(Z)V", "enableLeftScrollConfig", "b", "setEnableLeftScrollConfig", "enableRightScrollConfig", "d", "setEnableRightScrollConfig", "enableUpDownScrollConfig", "e", "setEnableUpDownScrollConfig", "enableLongPressConfig", "c", "setEnableLongPressConfig", "enableZoomConfig", "f", "setEnableZoomConfig", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("enable_gesture_config")
    private boolean enableGestureConfig;

    @SerializedName("enable_left_scroll_config")
    private boolean enableLeftScrollConfig;

    @SerializedName("enable_long_press_config")
    private boolean enableLongPressConfig;

    @SerializedName("enable_right_scroll_config")
    private boolean enableRightScrollConfig;

    @SerializedName("enable_up_down_scroll_config")
    private boolean enableUpDownScrollConfig;

    @SerializedName("enable_zoom_config")
    private boolean enableZoomConfig;

    public d() {
    }

    public final boolean a() {
        return this.enableGestureConfig;
    }

    public final boolean b() {
        return this.enableLeftScrollConfig;
    }

    public final boolean c() {
        return this.enableLongPressConfig;
    }

    public final boolean d() {
        return this.enableRightScrollConfig;
    }

    public final boolean e() {
        return this.enableUpDownScrollConfig;
    }

    public final boolean f() {
        return this.enableZoomConfig;
    }
}
