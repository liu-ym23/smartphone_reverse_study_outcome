package o72;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lo72/d;", "", "", "showEnable", "Z", "d", "()Z", "setShowEnable", "(Z)V", "", "needShowDuration", "J", "b", "()J", "setNeedShowDuration", "(J)V", "canPin", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCanPin", "", "pinShowStyle", "I", "getPinShowStyle", "()I", "setPinShowStyle", "(I)V", "pinShowDuration", "c", "setPinShowDuration", "pinDismissType", "getPinDismissType", "setPinDismissType", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f522256a = null;

    @SerializedName("can_pin")
    private boolean canPin;

    @SerializedName("need_show_duration")
    private long needShowDuration;

    @SerializedName("pin_dismiss_type")
    private int pinDismissType;

    @SerializedName("pin_show_duration")
    private long pinShowDuration;

    @SerializedName("pin_show_style")
    private int pinShowStyle;

    @SerializedName("show_enable")
    private boolean showEnable;

    public static final class a {
        public a() {
        }
    }

    static {
        f522256a = new a();
    }

    public d() {
        this.showEnable = true;
        this.needShowDuration = 10000;
        this.pinShowDuration = 3000;
    }

    public final boolean a() {
        return this.canPin;
    }

    public final long b() {
        return this.needShowDuration;
    }

    public final long c() {
        return this.pinShowDuration;
    }

    public final boolean d() {
        return this.showEnable;
    }
}
