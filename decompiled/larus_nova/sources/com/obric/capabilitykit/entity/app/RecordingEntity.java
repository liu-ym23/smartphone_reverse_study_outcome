package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u001aH\u0016J\"\u0010=\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0018\u0010B\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u000fH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010&\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010/\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001c\u00102\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001c\u00108\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018¨\u0006E"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "duration", "", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;I)V", "getDuration", "()I", "setDuration", "(I)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "markers", "", "getMarkers", "()Ljava/util/List;", "setMarkers", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "recordStatus", "getRecordStatus", "setRecordStatus", "recordType", "getRecordType", "setRecordType", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceAppPackage", "getSourceAppPackage", "setSourceAppPackage", "sourceDevice", "getSourceDevice", "setSourceDevice", "summary", "getSummary", "setSummary", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecordingEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 1;
    private int duration;
    private FileEntity file;
    private List<Integer> markers;
    private String name;
    private String recordStatus;
    private String recordType;
    private String sourceAppName;
    private String sourceAppPackage;
    private String sourceDevice;
    private String summary;
    private List<String> todoList;
    private FileEntity transcript;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "requireFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "parcelable", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<RecordingEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ FileEntity access$requireFileEntity(CREATOR r100, FileEntity r101) {
            return r100.requireFileEntity(r101);
        }

        private final FileEntity requireFileEntity(FileEntity r100) {
            if (r100 == null) goto L5;
            return r100;
        L5:
            throw new IllegalArgumentException("RecordingEntity.file must not be null".toString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.RecordingEntity");
            return (RecordingEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingEntity[] newArray(int r100) {
            return new RecordingEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public RecordingEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), CREATOR.access$requireFileEntity(CREATOR, (FileEntity) r110.readParcelable(FileEntity.class.getClassLoader())), r110.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r100 = r110.readInt();
        this.transcript = (FileEntity) r110.readParcelable(FileEntity.class.getClassLoader());
        this.summary = r110.readString();
        ArrayList r101 = new ArrayList();
        r110.readList(r101, String.class.getClassLoader());
        this.todoList = r101;
        ArrayList r102 = new ArrayList();
        r110.readList(r102, Integer.TYPE.getClassLoader());
        this.markers = r102;
        this.sourceAppName = r110.readString();
        this.sourceAppPackage = r110.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 3, r100);
    }

    public RecordingEntity(String r110, long r111, long r112, String r113, FileEntity r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "name");
        Intrinsics.checkNotNullParameter(r114, "file");
        super(r110, r111, r112, 501);
        this.name = r113;
        this.file = r114;
        this.duration = r115;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final FileEntity getFile() {
        return this.file;
    }

    public final List<Integer> getMarkers() {
        return this.markers;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRecordStatus() {
        return this.recordStatus;
    }

    public final String getRecordType() {
        return this.recordType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return this.file.getSharedUris();
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceAppPackage() {
        return this.sourceAppPackage;
    }

    public final String getSourceDevice() {
        return this.sourceDevice;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final FileEntity getTranscript() {
        return this.transcript;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r103 = null;
        if (r102 != 1) goto L5;
        Object r104 = r100.readValue(r101);
        if ((r104 instanceof String) == false) goto L20;
        r103 = (String) r104;
    L20:
        this.recordType = r103;
        return;
    L5:
        if (r102 != 2) goto L7;
        Object r105 = r100.readValue(r101);
        if ((r105 instanceof String) == false) goto L16;
        r103 = (String) r105;
    L16:
        this.recordStatus = r103;
        return;
    L7:
        if (r102 != 3) goto L24;
        Object r106 = r100.readValue(r101);
        if ((r106 instanceof String) == false) goto L12;
        r103 = (String) r106;
    L12:
        this.sourceDevice = r103;
        return;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setFile(FileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.file = r100;
    }

    public final void setMarkers(List<Integer> r100) {
        this.markers = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setRecordStatus(String r100) {
        this.recordStatus = r100;
    }

    public final void setRecordType(String r100) {
        this.recordType = r100;
    }

    public final void setSourceAppName(String r100) {
        this.sourceAppName = r100;
    }

    public final void setSourceAppPackage(String r100) {
        this.sourceAppPackage = r100;
    }

    public final void setSourceDevice(String r100) {
        this.sourceDevice = r100;
    }

    public final void setSummary(String r100) {
        this.summary = r100;
    }

    public final void setTodoList(List<String> r100) {
        this.todoList = r100;
    }

    public final void setTranscript(FileEntity r100) {
        this.transcript = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeParcelable(this.file, r101);
        r100.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(3);
        r100.writeParcelable(this.transcript, r101);
        r100.writeString(this.summary);
        r100.writeList(this.todoList);
        r100.writeList(this.markers);
        r100.writeString(this.sourceAppName);
        r100.writeString(this.sourceAppPackage);
        r100.writeValue(this.recordType);
        r100.writeValue(this.recordStatus);
        r100.writeValue(this.sourceDevice);
    }
}
