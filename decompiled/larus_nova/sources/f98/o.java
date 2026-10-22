package f98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/e/model/RespFileContent;", "", "<init>", "()V", "contentType", "", "getContentType", "()I", "setContentType", "(I)V", "uri", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "sideType", "getSideType", "()Ljava/lang/Integer;", "setSideType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageId", "getImageId", "setImageId", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("content_type")
    private int contentType;

    @SerializedName("pic_id")
    private String imageId;

    @SerializedName("side_type")
    private Integer sideType;

    @SerializedName("uri")
    private String uri;

    @SerializedName("url")
    private String url;

    public o() {
        this.contentType = 1;
    }

    public final String a() {
        return this.url;
    }
}
