package sq9;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/larus/platform/model/creation/CreationEditControlConfig;", "", "editFunctionArea", "Lcom/larus/platform/model/creation/EditFunctionArea;", "videoEditOnImage", "Lcom/larus/platform/model/creation/VideoEditOnImageConfig;", "sendImageEditFunctionConfig", "Lcom/larus/platform/model/creation/SendImageEditConfig;", "imgEditHalfScreen", "", "<init>", "(Lcom/larus/platform/model/creation/EditFunctionArea;Lcom/larus/platform/model/creation/VideoEditOnImageConfig;Lcom/larus/platform/model/creation/SendImageEditConfig;Ljava/lang/Boolean;)V", "getEditFunctionArea", "()Lcom/larus/platform/model/creation/EditFunctionArea;", "getVideoEditOnImage", "()Lcom/larus/platform/model/creation/VideoEditOnImageConfig;", "getSendImageEditFunctionConfig", "()Lcom/larus/platform/model/creation/SendImageEditConfig;", "getImgEditHalfScreen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/platform/model/creation/EditFunctionArea;Lcom/larus/platform/model/creation/VideoEditOnImageConfig;Lcom/larus/platform/model/creation/SendImageEditConfig;Ljava/lang/Boolean;)Lcom/larus/platform/model/creation/CreationEditControlConfig;", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f543095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f543096b = null;

    @SerializedName("edit_function_area")
    private final r editFunctionArea;

    @SerializedName("img_edit_half_screen")
    private final Boolean imgEditHalfScreen;

    @SerializedName("send_image_edit_config")
    private final y sendImageEditFunctionConfig;

    @SerializedName("video_edit_on_image")
    private final c0 videoEditOnImage;

    public static final class a {
    }

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
        if (Intrinsics.areEqual(this.editFunctionArea, r101.editFunctionArea) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoEditOnImage, r101.videoEditOnImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sendImageEditFunctionConfig, r101.sendImageEditFunctionConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imgEditHalfScreen, r101.imgEditHalfScreen) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        r r100 = this.editFunctionArea;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c0 r104 = this.videoEditOnImage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        y r107 = this.sendImageEditFunctionConfig;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.imgEditHalfScreen;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationEditControlConfig(editFunctionArea=" + this.editFunctionArea + ", videoEditOnImage=" + this.videoEditOnImage + ", sendImageEditFunctionConfig=" + this.sendImageEditFunctionConfig + ", imgEditHalfScreen=" + this.imgEditHalfScreen + ')';
    }

    static {
        r r100 = new r(1, CollectionsKt.listOf(new s[]{new s("to_video", 0), new s("image_edit", 0), new s("sharpness", 0), new s(BitableAnalytic.LinkSceneClickType.EXPAND, 0), new s("erase", 0)}));
        Boolean r101 = Boolean.TRUE;
        c0 r102 = new c0(r101, r101);
        Boolean r103 = Boolean.FALSE;
        f543095a = new f(r100, r102, new y(r103, r101), r103);
        f543096b = new f(0);
    }

    public final r a() {
        return this.editFunctionArea;
    }

    public final Boolean b() {
        return this.imgEditHalfScreen;
    }

    public final y c() {
        return this.sendImageEditFunctionConfig;
    }

    public final c0 d() {
        return this.videoEditOnImage;
    }

    public /* synthetic */ f(int r100) {
        this(null, null, null, Boolean.FALSE);
    }

    public f(r r100, c0 r101, y r102, Boolean r103) {
        this.editFunctionArea = r100;
        this.videoEditOnImage = r101;
        this.sendImageEditFunctionConfig = r102;
        this.imgEditHalfScreen = r103;
    }
}
