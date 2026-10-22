package sn;

import com.bytedance.android.livesdk.chatroom.event.VSUserProfileEvent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lsn/a;", "", "", "topLeft", "Ljava/lang/Float;", "getTopLeft", "()Ljava/lang/Float;", "topRight", "getTopRight", "bottomRight", "getBottomRight", "bottomLeft", "getBottomLeft", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("bottom_left")
    private final Float bottomLeft;

    @SerializedName(VSUserProfileEvent.CLICK_POS_RIGHT)
    private final Float bottomRight;

    @SerializedName("top_left")
    private final Float topLeft;

    @SerializedName("top_right")
    private final Float topRight;

    public a() {
        this.topLeft = null;
        this.topRight = null;
        this.bottomRight = null;
        this.bottomLeft = null;
    }
}
