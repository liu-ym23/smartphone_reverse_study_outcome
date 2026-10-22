package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010=\u001a\u00020>H\u0016J\"\u0010?\u001a\u00020@2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0011H\u0016J\u0018\u0010D\u001a\u00020@2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0011H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\"\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.¨\u0006G"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "telephones", "", "contacts", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "callType", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "duration", "", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;I)V", "getCallType", "()Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "setCallType", "(Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;)V", "carriers", "getCarriers", "()Ljava/util/List;", "setCarriers", "(Ljava/util/List;)V", "getContacts", "setContacts", "getDuration", "()I", "setDuration", "(I)V", "hasTranscript", "", "getHasTranscript", "()Z", "setHasTranscript", "(Z)V", "isAIPickup", "setAIPickup", "sourceNumber", "getSourceNumber", "()Ljava/lang/String;", "setSourceNumber", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "getTelephones", "setTelephones", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "transcriptTitle", "getTranscriptTitle", "setTranscriptTitle", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallHistoryEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 4;
    private static final int RELATED_VERSION = 1;
    private CallTypeEnum callType;
    private List<String> carriers;
    private List<ContactEntity> contacts;
    private int duration;
    private boolean hasTranscript;
    private boolean isAIPickup;
    private String sourceNumber;
    private String tag;
    private List<String> telephones;
    private List<String> todoList;
    private String transcript;
    private String transcriptTitle;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CallHistoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallHistoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CallHistoryEntity");
            return (CallHistoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallHistoryEntity[] newArray(int r100) {
            return new CallHistoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CallHistoryEntity(String r110, long r111, long r112, List<String> r113, List<ContactEntity> r114, CallTypeEnum r115, int r116) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "telephones");
        Intrinsics.checkNotNullParameter(r115, "callType");
        super(r110, r111, r112, 202);
        this.telephones = r113;
        this.contacts = r114;
        this.callType = r115;
        this.duration = r116;
    }

    public /* synthetic */ CallHistoryEntity(String r110, long r111, long r112, List r113, List r114, CallTypeEnum r115, int r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 16) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r211 & 64) == 0) goto L9;
        int r116 = 0;
    L10:
        this(r110, r111, r112, r113, r100, r115, r116);
        return;
    L9:
        r116 = r210;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }

    public final CallTypeEnum getCallType() {
        return this.callType;
    }

    public final List<String> getCarriers() {
        return this.carriers;
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<ContactEntity> r100 = this.contacts;
        if (r100 == null) goto L8;
        ContactEntity r101 = (ContactEntity) CollectionsKt.getOrNull(r100, 0);
        if (r101 == null) goto L8;
        String r102 = r101.getName();
        if (r102 == null) goto L8;
    L9:
        String r103 = r102;
        List<String> r104 = this.carriers;
        if (r104 == null) goto L12;
        String r105 = (String) CollectionsKt.getOrNull(r104, 0);
    L14:
        return new DisplayRepresentation(null, r103, r105, getLastModifiedTime());
    L12:
        r105 = null;
    L8:
        r102 = (String) ListProtector.get(this.telephones, 0);
        goto L9
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getHasTranscript() {
        return this.hasTranscript;
    }

    public final String getSourceNumber() {
        return this.sourceNumber;
    }

    public final String getTag() {
        return this.tag;
    }

    public final List<String> getTelephones() {
        return this.telephones;
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final String getTranscript() {
        return this.transcript;
    }

    public final String getTranscriptTitle() {
        return this.transcriptTitle;
    }

    public final boolean isAIPickup() {
        return this.isAIPickup;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L5;
        this.carriers = (List) r100.readValue(r101);
        return;
    L5:
        if (r102 == 2) goto L19;
        String r103 = null;
        if (r102 != 3) goto L9;
        Object r104 = r100.readValue(r101);
        if ((r104 instanceof String) == false) goto L18;
        r103 = (String) r104;
    L18:
        this.transcriptTitle = r103;
        return;
    L9:
        if (r102 != 4) goto L25;
        Object r105 = r100.readValue(r101);
        if ((r105 instanceof String) == false) goto L14;
        r103 = (String) r105;
    L14:
        this.sourceNumber = r103;
        return;
    L25:
        return;
    L19:
        this.todoList = (List) r100.readValue(r101);
    }

    public final void setAIPickup(boolean r100) {
        this.isAIPickup = r100;
    }

    public final void setCallType(CallTypeEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.callType = r100;
    }

    public final void setCarriers(List<String> r100) {
        this.carriers = r100;
    }

    public final void setContacts(List<ContactEntity> r100) {
        this.contacts = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setHasTranscript(boolean r100) {
        this.hasTranscript = r100;
    }

    public final void setSourceNumber(String r100) {
        this.sourceNumber = r100;
    }

    public final void setTag(String r100) {
        this.tag = r100;
    }

    public final void setTelephones(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.telephones = r100;
    }

    public final void setTodoList(List<String> r100) {
        this.todoList = r100;
    }

    public final void setTranscript(String r100) {
        this.transcript = r100;
    }

    public final void setTranscriptTitle(String r100) {
        this.transcriptTitle = r100;
    }

    public CallHistoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        ArrayList<String> r103 = r110.createStringArrayList();
        if (r103 != null) goto L5;
        r103 = new ArrayList();
    L5:
        ArrayList<String> r104 = r103;
        ArrayList r105 = r110.createTypedArrayList(ContactEntity.CREATOR);
        CallTypeEnum.a r106 = CallTypeEnum.Companion;
        String r107 = r110.readString();
        r106.getClass();
        if (r107 != null) goto L16;
    L11:
        CallTypeEnum r108 = null;
    L12:
        if (r108 != null) goto L14;
        r108 = CallTypeEnum.INCOMING_CALL_ANSWERED;
    L14:
        this(r100, r101, r102, r104, r105, r108, r110.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r109 = r110.readInt();
        this.tag = r110.readString();
        this.isAIPickup = EntityExtKt.d(r110);
        this.hasTranscript = EntityExtKt.d(r110);
        this.transcript = r110.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 4, r109);
        return;
    L16:
        r108 = CallTypeEnum.valueOf(r107);     // Catch: IllegalArgumentException -> L10
    L10:
        Reflection.getOrCreateKotlinClass(CallTypeEnum.class).getSimpleName();
        goto L11
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeStringList(this.telephones);
        r100.writeTypedList(this.contacts);
        r100.writeString(this.callType.name());
        r100.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(4);
        r100.writeString(this.tag);
        boolean r102 = this.isAIPickup;
        Gson r103 = EntityExtKt.f396198a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r102 ? 1 : 0);
        boolean r104 = this.hasTranscript;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r104 ? 1 : 0);
        r100.writeString(this.transcript);
        r100.writeValue(this.carriers);
        r100.writeValue(this.todoList);
        r100.writeValue(this.transcriptTitle);
        r100.writeValue(this.sourceNumber);
    }
}
