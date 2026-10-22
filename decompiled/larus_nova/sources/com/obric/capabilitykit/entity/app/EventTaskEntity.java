package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0002\u0010\u0011J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020&H\u0016R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "conditionString", "taskQuery", "periodString", "isDeleted", "", "conditionList", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getConditionList", "()Ljava/util/List;", "setConditionList", "(Ljava/util/List;)V", "getConditionString", "()Ljava/lang/String;", "setConditionString", "(Ljava/lang/String;)V", "()Z", "setDeleted", "(Z)V", "getPeriodString", "setPeriodString", "getTaskQuery", "setTaskQuery", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private List<String> conditionList;
    private String conditionString;
    private boolean isDeleted;
    private String periodString;
    private String taskQuery;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EventTaskEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<EventTaskEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTaskEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.EventTaskEntity");
            return (EventTaskEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTaskEntity[] newArray(int r100) {
            return new EventTaskEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventTaskEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        String r103 = EntityExtKt.e(r110);
        String r104 = EntityExtKt.e(r110);
        String r105 = EntityExtKt.e(r110);
        boolean r111 = EntityExtKt.d(r110);
        ArrayList<String> r106 = r110.createStringArrayList();
        if (r106 == null) goto L6;
        List r107 = CollectionsKt.toList(r106);
        if (r107 == null) goto L6;
    L7:
        this(r100, r101, r102, r103, r104, r105, r111, r107);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
        return;
    L6:
        r107 = new ArrayList();
        goto L7
    }

    public EventTaskEntity(String r110, long r111, long r112, String r113, String r114, String r210, boolean r211, List<String> r212) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "conditionString");
        Intrinsics.checkNotNullParameter(r114, "taskQuery");
        Intrinsics.checkNotNullParameter(r210, "periodString");
        Intrinsics.checkNotNullParameter(r212, "conditionList");
        super(r110, r111, r112, 1601);
        this.conditionString = r113;
        this.taskQuery = r114;
        this.periodString = r210;
        this.isDeleted = r211;
        this.conditionList = r212;
    }

    public final List<String> getConditionList() {
        return this.conditionList;
    }

    public final String getConditionString() {
        return this.conditionString;
    }

    public final String getPeriodString() {
        return this.periodString;
    }

    public final String getTaskQuery() {
        return this.taskQuery;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setConditionList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.conditionList = r100;
    }

    public final void setConditionString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.conditionString = r100;
    }

    public final void setDeleted(boolean r100) {
        this.isDeleted = r100;
    }

    public final void setPeriodString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.periodString = r100;
    }

    public final void setTaskQuery(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskQuery = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.conditionString);
        r100.writeString(this.taskQuery);
        r100.writeString(this.periodString);
        boolean r102 = this.isDeleted;
        Gson r103 = EntityExtKt.f396198a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r102 ? 1 : 0);
        r100.writeStringList(this.conditionList);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(0);
    }
}
