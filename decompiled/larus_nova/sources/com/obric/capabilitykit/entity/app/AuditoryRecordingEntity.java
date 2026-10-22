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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0016J\"\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\rH\u0016J\u0018\u0010;\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\rH\u0016R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0013R\u001c\u0010+\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u00101\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "state", "", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "duration", "(Ljava/lang/String;JJLjava/lang/String;ILcom/obric/capabilitykit/entity/app/FileEntity;I)V", "getDuration", "()I", "setDuration", "(I)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "markers", "", "getMarkers", "()Ljava/util/List;", "setMarkers", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceAppPackage", "getSourceAppPackage", "setSourceAppPackage", "getState", "summary", "getSummary", "setSummary", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AuditoryRecordingEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private int duration;
    private FileEntity file;
    private List<Integer> markers;
    private String name;
    private String sourceAppName;
    private String sourceAppPackage;
    private final int state;
    private String summary;
    private List<String> todoList;
    private FileEntity transcript;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AuditoryRecordingEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditoryRecordingEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AuditoryRecordingEntity");
            return (AuditoryRecordingEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditoryRecordingEntity[] newArray(int r100) {
            return new AuditoryRecordingEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AuditoryRecordingEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        String r103 = EntityExtKt.e(r110);
        int r104 = r110.readInt();
        Parcelable r105 = r110.readParcelable(FileEntity.class.getClassLoader());
        Intrinsics.checkNotNull(r105);
        this(r100, r101, r102, r103, r104, (FileEntity) r105, r110.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r106 = r110.readInt();
        this.transcript = (FileEntity) r110.readParcelable(FileEntity.class.getClassLoader());
        this.summary = r110.readString();
        ArrayList r107 = new ArrayList();
        r110.readList(r107, String.class.getClassLoader());
        this.todoList = r107;
        ArrayList r108 = new ArrayList();
        r110.readList(r108, Integer.TYPE.getClassLoader());
        this.markers = r108;
        this.sourceAppName = r110.readString();
        this.sourceAppPackage = r110.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r106);
    }

    public AuditoryRecordingEntity(String r110, long r111, long r112, String r113, int r114, FileEntity r115, int r116) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "name");
        Intrinsics.checkNotNullParameter(r115, "file");
        super(r110, r111, r112, 502);
        this.name = r113;
        this.state = r114;
        this.file = r115;
        this.duration = r116;
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

    public final int getState() {
        return this.state;
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

    public final void setSourceAppName(String r100) {
        this.sourceAppName = r100;
    }

    public final void setSourceAppPackage(String r100) {
        this.sourceAppPackage = r100;
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
        r100.writeInt(this.state);
        r100.writeParcelable(this.file, r101);
        r100.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(0);
        r100.writeParcelable(this.transcript, r101);
        r100.writeString(this.summary);
        r100.writeList(this.todoList);
        r100.writeList(this.markers);
        r100.writeString(this.sourceAppName);
        r100.writeString(this.sourceAppPackage);
    }
}
