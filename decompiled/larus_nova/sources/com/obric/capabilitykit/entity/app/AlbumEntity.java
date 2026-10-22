package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B/\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0014H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "cover", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "getCover", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setCover", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "mediaCount", "", "getMediaCount", "()I", "setMediaCount", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlbumEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 1;
    private FileEntity cover;
    private int mediaCount;
    private String name;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlbumEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AlbumEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlbumEntity");
            return (AlbumEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlbumEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumEntity[] newArray(int r100) {
            return new AlbumEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlbumEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlbumEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), (FileEntity) r110.readParcelable(FileEntity.class.getClassLoader()));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 1, r110.readInt());
    }

    public AlbumEntity(String r100, long r110, long r111, String r112, FileEntity r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r112, "name");
        super(r100, r110, r111, 302);
        this.name = r112;
        this.cover = r113;
    }

    public final FileEntity getCover() {
        return this.cover;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        FileEntity r100 = this.cover;
        if (r100 == null) goto L5;
        Uri r101 = r100.getContentUrl();
    L7:
        return new DisplayRepresentation(r101, this.name, String.valueOf(this.mediaCount), getLastModifiedTime());
    L5:
        r101 = null;
        goto L7
    }

    public final int getMediaCount() {
        return this.mediaCount;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r100 = this.cover;
        if (r100 == null) goto L7;
        List<Uri> r101 = r100.getSharedUris();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L6;
        Object r103 = r100.readValue(r101);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
        this.mediaCount = ((Integer) r103).intValue();
        return;
    }

    public final void setCover(FileEntity r100) {
        this.cover = r100;
    }

    public final void setMediaCount(int r100) {
        this.mediaCount = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeParcelable(this.cover, r101);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(1);
        r100.writeValue(Integer.valueOf(this.mediaCount));
    }
}
