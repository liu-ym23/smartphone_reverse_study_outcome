package mq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/avatar/GuideInfoConfigV2;", "", "guideTitle", "", "guideDes", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "guideTitleKey", "guideDesKey", "getGuideTitle", "()Ljava/lang/String;", "getGuideDes", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("guide_des")
    private final String guideDesKey;

    @SerializedName("guide_title")
    private final String guideTitleKey;

    public g() {
        this(null, null);
    }

    public final String a() {
        return e.a(this.guideDesKey);
    }

    public final String b() {
        return e.a(this.guideTitleKey);
    }

    public g(String r100, String r101) {
        this.guideTitleKey = r100;
        this.guideDesKey = r101;
    }
}
