package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/CreationShareSettings;", "", "imageShare", "Lcom/larus/platform/model/ImageShare;", "videoShare", "Lcom/larus/platform/model/VideoShare;", "useSaveFileNewLoading", "", "<init>", "(Lcom/larus/platform/model/ImageShare;Lcom/larus/platform/model/VideoShare;Z)V", "getImageShare", "()Lcom/larus/platform/model/ImageShare;", "getVideoShare", "()Lcom/larus/platform/model/VideoShare;", "getUseSaveFileNewLoading", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f486792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v0 f486793b = null;

    @SerializedName("image_share")
    private final v1 imageShare;

    @SerializedName("use_save_file_new_loading")
    private final boolean useSaveFileNewLoading;

    @SerializedName("video_share")
    private final a5 videoShare;

    public static final class a {
    }

    public v0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.imageShare, r101.imageShare) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoShare, r101.videoShare) == true) goto L15;
        return false;
    L15:
        if (this.useSaveFileNewLoading == r101.useSaveFileNewLoading) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        v1 r100 = this.imageShare;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a5 r104 = this.videoShare;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.useSaveFileNewLoading == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationShareSettings(imageShare=" + this.imageShare + ", videoShare=" + this.videoShare + ", useSaveFileNewLoading=" + this.useSaveFileNewLoading + ')';
    }

    static {
        f486792a = new v0(new v1(true, 1, true, true, false, false), new a5(true), true);
        f486793b = new v0(0);
    }

    public final v1 a() {
        return this.imageShare;
    }

    public final boolean b() {
        return this.useSaveFileNewLoading;
    }

    public final a5 c() {
        return this.videoShare;
    }

    public /* synthetic */ v0(int r100) {
        this(null, null, false);
    }

    public v0(v1 r100, a5 r101, boolean r102) {
        this.imageShare = r100;
        this.videoShare = r101;
        this.useSaveFileNewLoading = r102;
    }
}
