package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.bytedance.keva.KevaImpl;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BO\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010-\u001a\u00020.H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0014H\u0016J\"\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u000206H\u0016R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "title", "text", "formatMode", "Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", "noteFolder", Keys.API_EVENT_KEY_IS_FAVORITE, "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;Ljava/lang/String;Z)V", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getFiles", "()Ljava/util/List;", "setFiles", "(Ljava/util/List;)V", "getFormatMode", "()Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", "setFormatMode", "(Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;)V", "()Z", "setFavorite", "(Z)V", "getNoteFolder", "()Ljava/lang/String;", "setNoteFolder", "(Ljava/lang/String;)V", "recordings", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "getRecordings", "setRecordings", "getText", "setText", "getTitle", d.f25925o, "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NoteEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 5;
    private List<FileEntity> files;
    private FormatModeEnum formatMode;
    private boolean isFavorite;
    private String noteFolder;
    private List<RecordingEntity> recordings;
    private String text;
    private String title;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/NoteEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<NoteEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.NoteEntity");
            return (NoteEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteEntity[] newArray(int r100) {
            return new NoteEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public NoteEntity(String r110, long r111, long r112, String r113, String r114, FormatModeEnum r115, String r116, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "title");
        Intrinsics.checkNotNullParameter(r114, "text");
        super(r110, r111, r112, 601);
        this.title = r113;
        this.text = r114;
        this.formatMode = r115;
        this.noteFolder = r116;
        this.isFavorite = r210;
    }

    public /* synthetic */ NoteEntity(String r110, long r111, long r112, String r210, String r211, FormatModeEnum r212, String r213, boolean r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 32) == 0) goto L5;
        FormatModeEnum r113 = null;
    L7:
        if ((r215 & 64) == 0) goto L9;
        String r114 = null;
    L11:
        if ((r215 & 128) == 0) goto L13;
        boolean r115 = false;
    L14:
        this(r110, r111, r112, r210, r211, r113, r114, r115);
        return;
    L13:
        r115 = r214;
        goto L14
    L9:
        r114 = r213;
        goto L11
    L5:
        r113 = r212;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.title, null, getLastModifiedTime(), 5, null);
    }

    public final List<FileEntity> getFiles() {
        return this.files;
    }

    public final FormatModeEnum getFormatMode() {
        return this.formatMode;
    }

    public final String getNoteFolder() {
        return this.noteFolder;
    }

    public final List<RecordingEntity> getRecordings() {
        return this.recordings;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        List<FileEntity> r100 = this.files;
        if (r100 == null) goto L9;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        CollectionsKt.addAll(r101, ((FileEntity) r102.next()).getSharedUris());
        goto L6
    L11:
        return r101;
    L9:
        return CollectionsKt.emptyList();
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L6;
        this.recordings = (List) r100.readValue(r101);
        return;
    }

    public final void setFavorite(boolean r100) {
        this.isFavorite = r100;
    }

    public final void setFiles(List<FileEntity> r100) {
        this.files = r100;
    }

    public final void setFormatMode(FormatModeEnum r100) {
        this.formatMode = r100;
    }

    public final void setNoteFolder(String r100) {
        this.noteFolder = r100;
    }

    public final void setRecordings(List<RecordingEntity> r100) {
        this.recordings = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public NoteEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        String r103 = EntityExtKt.e(r110);
        String r104 = EntityExtKt.e(r110);
        FormatModeEnum.a r105 = FormatModeEnum.Companion;
        String r106 = r110.readString();
        r105.getClass();
        if (r106 != null) goto L11;
    L8:
        FormatModeEnum r107 = null;
    L9:
        this(r100, r101, r102, r103, r104, r107, r110.readString(), EntityExtKt.d(r110));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r108 = r110.readInt();
        this.files = r110.createTypedArrayList(FileEntity.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 1, r108);
        return;
    L11:
        r107 = FormatModeEnum.valueOf(r106);     // Catch: IllegalArgumentException -> L7
    L7:
        Reflection.getOrCreateKotlinClass(FormatModeEnum.class).getSimpleName();
        goto L8
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.title);
        r100.writeString(this.text);
        FormatModeEnum r102 = this.formatMode;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeString(r103);
        r100.writeString(this.noteFolder);
        boolean r104 = this.isFavorite;
        Gson r105 = EntityExtKt.f396198a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r104 ? 1 : 0);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(1);
        r100.writeTypedList(this.files);
        r100.writeValue(this.recordings);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
