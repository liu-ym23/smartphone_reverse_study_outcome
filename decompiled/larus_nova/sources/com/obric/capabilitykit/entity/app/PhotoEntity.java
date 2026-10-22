package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B]\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010R\u001a\u00020SH\u0016J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0011H\u0016J\"\u0010V\u001a\u00020W2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[H\u0016J\u0018\u0010\\\u001a\u00020W2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010]\u001a\u00020[H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u001c\u0010;\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001eR\"\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001c\u0010C\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010 R\u001c\u0010F\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R\u001c\u0010I\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001e\"\u0004\bK\u0010 R\"\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R\"\u0010O\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010$\"\u0004\bQ\u0010&¨\u0006_"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "assetType", "Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "inAlbum", "", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "resolution", "fileSize", Keys.API_EVENT_KEY_IS_FAVORITE, "", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;Ljava/util/List;Ljava/lang/String;JZ)V", "getAssetType", "()Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "setAssetType", "(Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;)V", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "faces", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "getFaces", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "getFileSize", "()J", "setFileSize", "(J)V", "getInAlbum", "setInAlbum", "()Z", "setFavorite", "(Z)V", "location", "Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "getLocation", "()Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "setLocation", "(Lcom/obric/capabilitykit/entity/meta/MetaLocation;)V", "getName", "ocr", "getOcr", "setOcr", "getResolution", "searchFrames", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "getSearchFrames", "setSearchFrames", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceDevice", "getSourceDevice", "setSourceDevice", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "videoFrames", "getVideoFrames", "setVideoFrames", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 2;
    private AssetTypeEnum assetType;
    private String caption;
    private List<PhotoFaceEntity> faces;
    private FileEntity file;
    private long fileSize;
    private List<AlbumEntity> inAlbum;
    private boolean isFavorite;
    private MetaLocation location;
    private final String name;
    private String ocr;
    private final String resolution;
    private List<VideoFrame> searchFrames;
    private String sourceAppName;
    private String sourceDevice;
    private String sourcePackageName;
    private List<String> tags;
    private List<VideoFrame> videoFrames;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "requireAlbumList", "", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "albums", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "requireFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "parcelable", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<PhotoEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ List access$requireAlbumList(CREATOR r100, ArrayList r101) {
            return r100.requireAlbumList(r101);
        }

        public static final /* synthetic */ FileEntity access$requireFileEntity(CREATOR r100, FileEntity r101) {
            return r100.requireFileEntity(r101);
        }

        private final List<AlbumEntity> requireAlbumList(ArrayList<AlbumEntity> r100) {
            if (r100 == null) goto L5;
            return r100;
        L5:
            throw new IllegalArgumentException("PhotoEntity.inAlbum must not be null".toString());
        }

        private final FileEntity requireFileEntity(FileEntity r100) {
            if (r100 == null) goto L5;
            return r100;
        L5:
            throw new IllegalArgumentException("PhotoEntity.file must not be null".toString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoEntity");
            return (PhotoEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoEntity[] newArray(int r100) {
            return new PhotoEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public PhotoEntity(String r110, long r111, long r112, String r113, FileEntity r210, AssetTypeEnum r211, List<AlbumEntity> r212, String r213, long r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "name");
        Intrinsics.checkNotNullParameter(r210, "file");
        Intrinsics.checkNotNullParameter(r211, "assetType");
        Intrinsics.checkNotNullParameter(r212, "inAlbum");
        Intrinsics.checkNotNullParameter(r213, "resolution");
        super(r110, r111, r112, 301);
        this.name = r113;
        this.file = r210;
        this.assetType = r211;
        this.inAlbum = r212;
        this.resolution = r213;
        this.fileSize = r214;
        this.isFavorite = r215;
    }

    public /* synthetic */ PhotoEntity(String r110, long r111, long r112, String r210, FileEntity r211, AssetTypeEnum r212, List r213, String r214, long r215, boolean r216, int r217, DefaultConstructorMarker r310) {
        if ((r217 & 512) == 0) goto L5;
        boolean r113 = false;
    L6:
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r113);
        return;
    L5:
        r113 = r216;
        goto L6
    }

    public final AssetTypeEnum getAssetType() {
        return this.assetType;
    }

    public final String getCaption() {
        return this.caption;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(this.file.getContentUrl(), this.name, null, getLastModifiedTime(), 4, null);
    }

    public final List<PhotoFaceEntity> getFaces() {
        return this.faces;
    }

    public final FileEntity getFile() {
        return this.file;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final List<AlbumEntity> getInAlbum() {
        return this.inAlbum;
    }

    public final MetaLocation getLocation() {
        return this.location;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOcr() {
        return this.ocr;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final List<VideoFrame> getSearchFrames() {
        return this.searchFrames;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return this.file.getSharedUris();
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceDevice() {
        return this.sourceDevice;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<VideoFrame> getVideoFrames() {
        return this.videoFrames;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        List<VideoFrame> r103 = null;
        String r104 = null;
        List<VideoFrame> r105 = null;
        if (r102 != 1) goto L5;
        Object r106 = ParcelUtils.INSTANCE.readValueSafely(r100, r101);
        if ((r106 instanceof List) == false) goto L20;
        r103 = (List) r106;
    L20:
        this.videoFrames = r103;
        return;
    L5:
        if (r102 != 2) goto L7;
        Object r107 = ParcelUtils.INSTANCE.readValueSafely(r100, r101);
        if ((r107 instanceof List) == false) goto L16;
        r105 = (List) r107;
    L16:
        this.searchFrames = r105;
        return;
    L7:
        if (r102 != 3) goto L24;
        Object r108 = ParcelUtils.INSTANCE.readValueSafely(r100, r101);
        if ((r108 instanceof String) == false) goto L12;
        r104 = (String) r108;
    L12:
        this.sourceDevice = r104;
        return;
    }

    public final void setAssetType(AssetTypeEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assetType = r100;
    }

    public final void setCaption(String r100) {
        this.caption = r100;
    }

    public final void setFaces(List<PhotoFaceEntity> r100) {
        this.faces = r100;
    }

    public final void setFavorite(boolean r100) {
        this.isFavorite = r100;
    }

    public final void setFile(FileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.file = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setInAlbum(List<AlbumEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.inAlbum = r100;
    }

    public final void setLocation(MetaLocation r100) {
        this.location = r100;
    }

    public final void setOcr(String r100) {
        this.ocr = r100;
    }

    public final void setSearchFrames(List<VideoFrame> r100) {
        this.searchFrames = r100;
    }

    public final void setSourceAppName(String r100) {
        this.sourceAppName = r100;
    }

    public final void setSourceDevice(String r100) {
        this.sourceDevice = r100;
    }

    public final void setSourcePackageName(String r100) {
        this.sourcePackageName = r100;
    }

    public final void setTags(List<String> r100) {
        this.tags = r100;
    }

    public final void setVideoFrames(List<VideoFrame> r100) {
        this.videoFrames = r100;
    }

    public PhotoEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        String r103 = EntityExtKt.e(r110);
        CREATOR r104 = CREATOR;
        FileEntity r105 = CREATOR.access$requireFileEntity(r104, (FileEntity) r110.readParcelable(FileEntity.class.getClassLoader()));
        AssetTypeEnum.a r106 = AssetTypeEnum.Companion;
        String r107 = r110.readString();
        r106.getClass();
        if (r107 != null) goto L13;
    L8:
        AssetTypeEnum r108 = null;
    L9:
        if (r108 != null) goto L11;
        r108 = AssetTypeEnum.PHOTO;
    L11:
        this(r100, r101, r102, r103, r105, r108, CREATOR.access$requireAlbumList(r104, r110.createTypedArrayList(AlbumEntity.CREATOR)), EntityExtKt.e(r110), r110.readLong(), EntityExtKt.d(r110));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r109 = r110.readInt();
        this.tags = r110.createStringArrayList();
        this.faces = r110.createTypedArrayList(PhotoFaceEntity.CREATOR);
        this.location = (MetaLocation) r110.readParcelable(FileEntity.class.getClassLoader());
        this.caption = r110.readString();
        this.ocr = r110.readString();
        this.sourcePackageName = r110.readString();
        this.sourceAppName = r110.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 3, r109);
        return;
    L13:
        r108 = AssetTypeEnum.valueOf(r107);     // Catch: IllegalArgumentException -> L7
    L7:
        Reflection.getOrCreateKotlinClass(AssetTypeEnum.class).getSimpleName();
        goto L8
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeParcelable(this.file, r101);
        r100.writeString(this.assetType.name());
        r100.writeTypedList(this.inAlbum);
        r100.writeString(this.resolution);
        r100.writeLong(this.fileSize);
        boolean r102 = this.isFavorite;
        Gson r103 = EntityExtKt.f396198a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r102 ? 1 : 0);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(3);
        r100.writeStringList(this.tags);
        r100.writeTypedList(this.faces);
        r100.writeParcelable(this.location, r101);
        r100.writeString(this.caption);
        r100.writeString(this.ocr);
        r100.writeString(this.sourcePackageName);
        r100.writeString(this.sourceAppName);
        r100.writeValue(this.videoFrames);
        r100.writeValue(this.searchFrames);
        r100.writeValue(this.sourceDevice);
    }
}
