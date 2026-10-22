package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BG\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010)\u001a\u00020'H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "fileName", "fileSize", "contentUrl", "Landroid/net/Uri;", "fileType", "Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", DBDefinition.MIME_TYPE, "(Ljava/lang/String;JJLjava/lang/String;JLandroid/net/Uri;Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;Ljava/lang/String;)V", "getContentUrl", "()Landroid/net/Uri;", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getFileSize", "()J", "setFileSize", "(J)V", "getFileType", "()Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", "getMimeType", "getSharedUris", "", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private final Uri contentUrl;
    private String fileName;
    private long fileSize;
    private final FileTypeEnum fileType;
    private final String mimeType;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "create", "file", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/FileEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<FileEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ FileEntity create$default(CREATOR r100, File r101, Uri r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = Uri.fromFile(r101);
        L6:
            return r100.create(r101, r102);
        }

        public final FileEntity create(File r110, Uri r111) {
            Intrinsics.checkNotNullParameter(r110, "file");
            Intrinsics.checkNotNullParameter(r111, "uri");
            String r112 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(r110));
            if (r110.isDirectory() == false) goto L5;
            FileTypeEnum r100 = FileTypeEnum.DIRECTORY;
        L6:
            String r101 = String.valueOf(r110.lastModified());
            long r102 = r110.lastModified();
            long r103 = r110.lastModified();
            String r104 = r110.getName();
            long r105 = r110.length();
            return new FileEntity(r101, r102, r103, r104, r105, r111, r100, r112);
        L5:
            r100 = FileTypeEnum.FILE;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.FileEntity");
            return (FileEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileEntity[] newArray(int r100) {
            return new FileEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public FileEntity(String r110, long r111, long r112, String r113, long r114, Uri r210, FileTypeEnum r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "fileName");
        Intrinsics.checkNotNullParameter(r210, "contentUrl");
        Intrinsics.checkNotNullParameter(r211, "fileType");
        super(r110, r111, r112, 801);
        this.fileName = r113;
        this.fileSize = r114;
        this.contentUrl = r210;
        this.fileType = r211;
        this.mimeType = r212;
    }

    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final FileTypeEnum getFileType() {
        return this.fileType;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return CollectionsKt.listOf(this.contentUrl);
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setFileName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileName = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.fileName);
        r100.writeLong(this.fileSize);
        r100.writeParcelable(this.contentUrl, r101);
        r100.writeString(this.fileType.name());
        r100.writeString(this.mimeType);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(0);
    }

    public FileEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        String r103 = EntityExtKt.e(r110);
        long r104 = r110.readLong();
        Parcelable r105 = r110.readParcelable(Uri.class.getClassLoader());
        Intrinsics.checkNotNull(r105);
        Uri r111 = (Uri) r105;
        FileTypeEnum.a r106 = FileTypeEnum.Companion;
        String r107 = r110.readString();
        r106.getClass();
        if (r107 != null) goto L13;
    L8:
        FileTypeEnum r108 = null;
    L9:
        if (r108 != null) goto L11;
        r108 = FileTypeEnum.FILE;
    L11:
        this(r100, r101, r102, r103, r104, r111, r108, r110.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
        return;
    L13:
        r108 = FileTypeEnum.valueOf(r107);     // Catch: IllegalArgumentException -> L7
    L7:
        Reflection.getOrCreateKotlinClass(FileTypeEnum.class).getSimpleName();
        goto L8
    }
}
