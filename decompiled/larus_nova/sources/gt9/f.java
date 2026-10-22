package gt9;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.album.FastSendFromCameraScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/album/FastSendImageInCameraConfig;", "", "isBottomControlAdapt", "", "bottomScene", "", "albumThumbConfig", "Lcom/larus/settings/album/FastSendFromCameraAlbumThumbConfig;", "<init>", "(ZILcom/larus/settings/album/FastSendFromCameraAlbumThumbConfig;)V", "()Z", "getBottomScene", "()I", "getAlbumThumbConfig", "()Lcom/larus/settings/album/FastSendFromCameraAlbumThumbConfig;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("fast_send_from_camera_album_thumb_config")
    private final c albumThumbConfig;

    @SerializedName("fast_send_from_camera_bottom_scene")
    private final int bottomScene;

    @SerializedName("fast_send_from_camera_bottom_control_adapt")
    private final boolean isBottomControlAdapt;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.isBottomControlAdapt == r101.isBottomControlAdapt) goto L12;
        return false;
    L12:
        if (this.bottomScene == r101.bottomScene) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.albumThumbConfig, r101.albumThumbConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.isBottomControlAdapt == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.bottomScene) * 31;
        c r102 = this.albumThumbConfig;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FastSendImageInCameraConfig(isBottomControlAdapt=" + this.isBottomControlAdapt + ", bottomScene=" + this.bottomScene + ", albumThumbConfig=" + this.albumThumbConfig + ')';
    }

    public final c a() {
        return this.albumThumbConfig;
    }

    public final int b() {
        return this.bottomScene;
    }

    public final boolean c() {
        return this.isBottomControlAdapt;
    }

    public f(int r100) {
        int r101 = FastSendFromCameraScene.ALL.getScene();
        c r102 = new c(0);
        this.isBottomControlAdapt = true;
        this.bottomScene = r101;
        this.albumThumbConfig = r102;
    }
}
