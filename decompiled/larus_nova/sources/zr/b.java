package zr;

import com.bytedance.android.gamecp.host_api.model.introducecard.s;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lzr/b;", "", "", "introduceType", "I", "", "lynxUrl", "Ljava/lang/String;", "introduceCard", "", "hasIntroduce", "Z", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "displayInfo", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "<init>", "()V", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f573363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f573364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f573365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f573366d;

    @SerializedName("card_display_info")
    public s displayInfo;

    @SerializedName("has_introduce_card")
    public boolean hasIntroduce;

    @SerializedName("introduce_card_data")
    public String introduceCard;

    @SerializedName("introduce_type")
    public int introduceType;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    public String lynxUrl;

    public b() {
        this.lynxUrl = "";
    }
}
