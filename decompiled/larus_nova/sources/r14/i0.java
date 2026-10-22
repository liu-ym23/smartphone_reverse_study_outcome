package r14;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lr14/i0;", "", "", "isMute", "Z", "()Z", "setMute", "(Z)V", "", "muteDesc", "Ljava/lang/String;", "getMuteDesc", "()Ljava/lang/String;", "setMuteDesc", "(Ljava/lang/String;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class i0 {

    @SerializedName("is_mute")
    private boolean isMute;

    @SerializedName("mute_desc")
    private String muteDesc;

    public i0() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.isMute), this.muteDesc});
    }

    public final String toString() {
        return "VideoMuteInfo{isMute=" + this.isMute + ", muteDesc='" + this.muteDesc + "'}";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (this.isMute == r101.isMute) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.muteDesc, r101.muteDesc) == false) goto L13;
        return true;
    }
}
