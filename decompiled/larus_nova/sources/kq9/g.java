package kq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/album/CreationImageReviewOptConfig;", "", "skipPreHandleOnInstant", "", "hideLoadingWhenReviewing", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getSkipPreHandleOnInstant", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideLoadingWhenReviewing", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("hide_loading_when_reviewing")
    private final Boolean hideLoadingWhenReviewing;

    @SerializedName("skip_pre_handle_on_instant")
    private final Boolean skipPreHandleOnInstant;

    public g() {
        this(0);
    }

    public final Boolean a() {
        return this.hideLoadingWhenReviewing;
    }

    public final Boolean b() {
        return this.skipPreHandleOnInstant;
    }

    public g(int r100) {
        Boolean r101 = Boolean.FALSE;
        this.skipPreHandleOnInstant = r101;
        this.hideLoadingWhenReviewing = r101;
    }
}
