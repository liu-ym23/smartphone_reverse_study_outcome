package f98;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/e/model/DoraUploadFileResponse;", "", "<init>", "()V", "contents", "", "Lcom/larus/avlink/e/model/RespFileContent;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "prefInfo", "Lcom/larus/avlink/e/model/UploadPrefInfo;", "getPrefInfo", "()Lcom/larus/avlink/e/model/UploadPrefInfo;", "setPrefInfo", "(Lcom/larus/avlink/e/model/UploadPrefInfo;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("contents")
    private List<o> contents;

    @SerializedName("pref_info")
    private q prefInfo;

    public h() {
    }

    public final List<o> a() {
        return this.contents;
    }

    public final q b() {
        return this.prefInfo;
    }
}
