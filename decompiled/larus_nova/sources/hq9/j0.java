package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/CognitiveConfig;", "", "cameraFirstFrameDelay", "", "albumFirstFrameDelay", "sendMessageRenderDelay", "<init>", "(JJJ)V", "getCameraFirstFrameDelay", "()J", "getAlbumFirstFrameDelay", "getSendMessageRenderDelay", "enableCameraFirstFrameDelay", "", "enableAlbumFirstFrameDelay", "enableSendMessageRenderDelay", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j0 {

    @SerializedName("album_first_frame_delay")
    private final long albumFirstFrameDelay;

    @SerializedName("camera_first_frame_delay")
    private final long cameraFirstFrameDelay;

    @SerializedName("send_message_render_delay")
    private final long sendMessageRenderDelay;

    public j0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (this.cameraFirstFrameDelay == r101.cameraFirstFrameDelay) goto L12;
        return false;
    L12:
        if (this.albumFirstFrameDelay == r101.albumFirstFrameDelay) goto L15;
        return false;
    L15:
        if (this.sendMessageRenderDelay == r101.sendMessageRenderDelay) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.cameraFirstFrameDelay;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.albumFirstFrameDelay;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.sendMessageRenderDelay;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "CognitiveConfig(cameraFirstFrameDelay=" + this.cameraFirstFrameDelay + ", albumFirstFrameDelay=" + this.albumFirstFrameDelay + ", sendMessageRenderDelay=" + this.sendMessageRenderDelay + ')';
    }

    public final boolean a() {
        if (this.albumFirstFrameDelay <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.cameraFirstFrameDelay <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        if (this.sendMessageRenderDelay <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long d() {
        return this.albumFirstFrameDelay;
    }

    public final long e() {
        return this.cameraFirstFrameDelay;
    }

    public final long f() {
        return this.sendMessageRenderDelay;
    }

    public /* synthetic */ j0(int r100) {
        this(0, 0, 0);
    }

    public j0(long r100, long r101, long r102) {
        this.cameraFirstFrameDelay = r100;
        this.albumFirstFrameDelay = r101;
        this.sendMessageRenderDelay = r102;
    }
}
