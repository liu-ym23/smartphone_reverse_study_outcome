package com.larus.camera.api.params;

import com.larus.bmhome.chat.bean.SuggestActionType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010D\u001a\u00020\u0017J\u0006\u0010E\u001a\u00020\u0017J\u0006\u0010F\u001a\u00020\u0017J\u0006\u0010G\u001a\u00020\u0005J\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020\u0000J\u0013\u0010K\u001a\u00020\u00172\b\u0010L\u001a\u0004\u0018\u00010MH\u0096\u0002J\b\u0010N\u001a\u00020\u0011H\u0016J\b\u0010O\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR6\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010+\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001a\u00100\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006R"}, d2 = {"Lcom/larus/camera/api/params/OutputParam;", "Ljava/io/Serializable;", "<init>", "()V", "fromScene", "", "getFromScene", "()Ljava/lang/String;", "setFromScene", "(Ljava/lang/String;)V", "camera", "getCamera", "setCamera", "leavingMode", "getLeavingMode", "setLeavingMode", "dataSource", "", "getDataSource", "()I", "setDataSource", "(I)V", "shouldNotify", "", "getShouldNotify", "()Z", "setShouldNotify", "(Z)V", "ext", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExt", "()Ljava/util/HashMap;", "setExt", "(Ljava/util/HashMap;)V", "inputContent", "Lkotlin/Pair;", "getInputContent", "()Lkotlin/Pair;", "setInputContent", "(Lkotlin/Pair;)V", "isSelected", "setSelected", "isFromAlbum", "setFromAlbum", "srcAlbumUri", "getSrcAlbumUri", "setSrcAlbumUri", "isOriginalImageChecked", "setOriginalImageChecked", "resultType", "Lcom/larus/camera/api/params/OutputParam$ResultType;", "getResultType", "()Lcom/larus/camera/api/params/OutputParam$ResultType;", "setResultType", "(Lcom/larus/camera/api/params/OutputParam$ResultType;)V", "imageParam", "Lcom/larus/camera/api/params/ImageParam;", "getImageParam", "()Lcom/larus/camera/api/params/ImageParam;", "setImageParam", "(Lcom/larus/camera/api/params/ImageParam;)V", "videoParam", "Lcom/larus/camera/api/params/VideoParam;", "getVideoParam", "()Lcom/larus/camera/api/params/VideoParam;", "setVideoParam", "(Lcom/larus/camera/api/params/VideoParam;)V", "isVideo", "isImageMarked", "isImageCropped", "getPath", "getCreateTime", "", "clone", "equals", "other", "", "hashCode", "toString", "Companion", "ResultType", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutputParam implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String camera;
    private int dataSource;
    private HashMap<String, String> ext;
    private String fromScene;
    private ImageParam imageParam;
    private Pair<String, Integer> inputContent;
    private boolean isFromAlbum;
    private boolean isOriginalImageChecked;
    private boolean isSelected;
    private String leavingMode;
    private ResultType resultType;
    private boolean shouldNotify;
    private String srcAlbumUri;
    private VideoParam videoParam;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/camera/api/params/OutputParam$ResultType;", "", "<init>", "(Ljava/lang/String;I)V", SuggestActionType.PHOTO, "VIDEO", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ResultType extends Enum<ResultType> {
        public static final ResultType PHOTO = null;
        public static final ResultType VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResultType[] f321465a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f321466b = null;

        public static EnumEntries<ResultType> getEntries() {
            return f321466b;
        }

        static {
            ResultType r100 = new ResultType(SuggestActionType.PHOTO, 0);
            PHOTO = r100;
            ResultType r101 = new ResultType("VIDEO", 1);
            VIDEO = r101;
            ResultType[] r102 = {r100, r101};
            f321465a = r102;
            f321466b = EnumEntriesKt.enumEntries(r102);
        }

        public static ResultType[] values() {
            return (ResultType[]) f321465a.clone();
        }

        public static ResultType valueOf(String r100) {
            return (ResultType) r27.a.a(ResultType.class, r100);
        }

        public ResultType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final OutputParam clone() {
        OutputParam r100 = new OutputParam();
        r100.imageParam = this.imageParam.clone();
        r100.videoParam = this.videoParam.clone();
        r100.fromScene = this.fromScene;
        r100.camera = this.camera;
        r100.leavingMode = this.leavingMode;
        r100.dataSource = this.dataSource;
        r100.resultType = this.resultType;
        r100.shouldNotify = this.shouldNotify;
        r100.ext = this.ext;
        r100.inputContent = this.inputContent;
        r100.isSelected = this.isSelected;
        r100.isFromAlbum = this.isFromAlbum;
        r100.srcAlbumUri = this.srcAlbumUri;
        r100.isOriginalImageChecked = this.isOriginalImageChecked;
        return r100;
    }

    public final boolean isVideo() {
        if (this.resultType != ResultType.VIDEO) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "fromScene=" + this.fromScene + ",camera=" + this.camera + ",dataSource=" + this.dataSource + ",leavingMode=" + this.leavingMode + ",imageParam=" + this.imageParam + ", videoParam:" + this.videoParam + ",resultType=" + this.resultType + ",ext=" + this.ext + ",isSelected=" + this.isSelected + ",isFromAlbum=" + this.isFromAlbum + ",isOriginalImageChecked=" + this.isOriginalImageChecked;
    }

    public OutputParam() {
        this.fromScene = "default";
        this.camera = "CAMERA_VE";
        this.ext = new HashMap();
        this.resultType = ResultType.PHOTO;
        this.imageParam = new ImageParam();
        this.videoParam = new VideoParam();
    }

    public final long getCreateTime() {
        if (isVideo() == false) goto L6;
        return this.videoParam.getCreatedTime();
    L6:
        return this.imageParam.getCreatedTime();
    }

    public final String getPath() {
        if (isVideo() == false) goto L6;
        return this.videoParam.getPath();
    L6:
        return this.imageParam.getPath();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final boolean isImageCropped() {
        if (isVideo() == false) goto L6;
        return false;
    L6:
        return this.imageParam.isPhotoCropped();
    }

    public final boolean isImageMarked() {
        if (isVideo() == false) goto L6;
        return false;
    L6:
        return this.imageParam.isPhotoMarked();
    }

    public final String getCamera() {
        return this.camera;
    }

    public final int getDataSource() {
        return this.dataSource;
    }

    public final HashMap<String, String> getExt() {
        return this.ext;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final ImageParam getImageParam() {
        return this.imageParam;
    }

    public final Pair<String, Integer> getInputContent() {
        return this.inputContent;
    }

    public final String getLeavingMode() {
        return this.leavingMode;
    }

    public final ResultType getResultType() {
        return this.resultType;
    }

    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    public final String getSrcAlbumUri() {
        return this.srcAlbumUri;
    }

    public final VideoParam getVideoParam() {
        return this.videoParam;
    }

    public final boolean isFromAlbum() {
        return this.isFromAlbum;
    }

    public final boolean isOriginalImageChecked() {
        return this.isOriginalImageChecked;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof OutputParam) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((OutputParam) r100).toString());
    }

    public final void setCamera(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.camera = r100;
    }

    public final void setDataSource(int r100) {
        this.dataSource = r100;
    }

    public final void setExt(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ext = r100;
    }

    public final void setFromAlbum(boolean r100) {
        this.isFromAlbum = r100;
    }

    public final void setFromScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fromScene = r100;
    }

    public final void setImageParam(ImageParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageParam = r100;
    }

    public final void setInputContent(Pair<String, Integer> r100) {
        this.inputContent = r100;
    }

    public final void setLeavingMode(String r100) {
        this.leavingMode = r100;
    }

    public final void setOriginalImageChecked(boolean r100) {
        this.isOriginalImageChecked = r100;
    }

    public final void setResultType(ResultType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultType = r100;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public final void setShouldNotify(boolean r100) {
        this.shouldNotify = r100;
    }

    public final void setSrcAlbumUri(String r100) {
        this.srcAlbumUri = r100;
    }

    public final void setVideoParam(VideoParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoParam = r100;
    }
}
