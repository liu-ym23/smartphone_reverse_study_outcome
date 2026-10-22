package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/chat/GenImageLoadingAnimationConfig;", "", "showProgress", "", "enableAnimation", "animationResUrl", "", "<init>", "(ZZLjava/lang/String;)V", "getShowProgress", "()Z", "getEnableAnimation", "getAnimationResUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r0 {

    @SerializedName("loading_anim_res_url")
    private final String animationResUrl;

    @SerializedName("enable_anim_loading")
    private final boolean enableAnimation;

    @SerializedName("loading_view_show_progress")
    private final boolean showProgress;

    public r0() {
        this(false, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (this.showProgress == r101.showProgress) goto L12;
        return false;
    L12:
        if (this.enableAnimation == r101.enableAnimation) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.animationResUrl, r101.animationResUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.showProgress == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableAnimation == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.animationResUrl;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "GenImageLoadingAnimationConfig(showProgress=" + this.showProgress + ", enableAnimation=" + this.enableAnimation + ", animationResUrl=" + this.animationResUrl + ')';
    }

    public final String a() {
        return this.animationResUrl;
    }

    public final boolean b() {
        return this.enableAnimation;
    }

    public final boolean c() {
        return this.showProgress;
    }

    public r0(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r102 & 4) == 0) goto L11;
        String r103 = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/gen/image/resource/flow_gen_image_loading_bg_res/loading.webp";
    L12:
        this.showProgress = r100;
        this.enableAnimation = r101;
        this.animationResUrl = r103;
        return;
    L11:
        r103 = null;
        goto L12
    }
}
