package kq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/model/album/CreationResourceAccessOptConfig;", "", "silentUpload", "", "enablePreprocessFallBack", "minSizeToCompress", "", "enableAlbumSelectionPrewarm", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getSilentUpload", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnablePreprocessFallBack", "getMinSizeToCompress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableAlbumSelectionPrewarm", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("enable_album_selection_prewarm")
    private final Boolean enableAlbumSelectionPrewarm;

    @SerializedName("enable_preprocess_fall_back")
    private final Boolean enablePreprocessFallBack;

    @SerializedName("min_size_to_compress")
    private final Integer minSizeToCompress;

    @SerializedName("silent_upload")
    private final Boolean silentUpload;

    public k() {
        this(0);
    }

    public final Boolean a() {
        return this.enableAlbumSelectionPrewarm;
    }

    public final Boolean b() {
        return this.enablePreprocessFallBack;
    }

    public final Integer c() {
        return this.minSizeToCompress;
    }

    public final Boolean d() {
        return this.silentUpload;
    }

    public k(int r100) {
        Boolean r101 = Boolean.FALSE;
        this.silentUpload = r101;
        this.enablePreprocessFallBack = r101;
        this.minSizeToCompress = null;
        this.enableAlbumSelectionPrewarm = r101;
    }
}
