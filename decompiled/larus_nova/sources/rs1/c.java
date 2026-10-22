package rs1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lrs1/c;", "", "", "degradeEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "hotCommentDegradeLevel", "I", "c", "()I", "flowLikeDegradeLevel", "b", "tapLikeDegradeLevel", "d", "userEcomAnimLevel", "e", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("live_ecom_degrade_enable")
    private final boolean degradeEnable;

    @SerializedName("live_ecom_degrade_flow_like_level")
    private final int flowLikeDegradeLevel;

    @SerializedName("live_ecom_degrade_hot_comment_level")
    private final int hotCommentDegradeLevel;

    @SerializedName("live_ecom_degrade_tap_like_level")
    private final int tapLikeDegradeLevel;

    @SerializedName("live_ecom_degrade_user_ecom_anim_level")
    private final int userEcomAnimLevel;

    public c() {
        this.hotCommentDegradeLevel = 2;
        this.flowLikeDegradeLevel = 3;
        this.tapLikeDegradeLevel = 2;
        this.userEcomAnimLevel = 3;
    }

    public final boolean a() {
        return this.degradeEnable;
    }

    public final int b() {
        return this.flowLikeDegradeLevel;
    }

    public final int c() {
        return this.hotCommentDegradeLevel;
    }

    public final int d() {
        return this.tapLikeDegradeLevel;
    }

    public final int e() {
        return this.userEcomAnimLevel;
    }
}
