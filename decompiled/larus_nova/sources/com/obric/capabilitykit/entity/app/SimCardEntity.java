package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BI\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001eH\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/entity/app/SimCardEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "simSlot", "simCarrier", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "anonymizedPhoneNumber", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnonymizedPhoneNumber", "()Ljava/lang/String;", "setAnonymizedPhoneNumber", "(Ljava/lang/String;)V", "getPhoneNumber", "setPhoneNumber", "getSimCarrier", "setSimCarrier", "getSimSlot", "setSimSlot", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SimCardEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String anonymizedPhoneNumber;
    private String phoneNumber;
    private String simCarrier;
    private String simSlot;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/SimCardEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/SimCardEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/SimCardEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<SimCardEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimCardEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.SimCardEntity");
            return (SimCardEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SimCardEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimCardEntity[] newArray(int r100) {
            return new SimCardEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SimCardEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public SimCardEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), r110.readString(), r110.readString(), r110.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
    }

    public SimCardEntity(String r110, long r111, long r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "simSlot");
        super(r110, r111, r112, 204);
        this.simSlot = r113;
        this.simCarrier = r114;
        this.phoneNumber = r115;
        this.anonymizedPhoneNumber = r116;
    }

    public /* synthetic */ SimCardEntity(String r110, long r111, long r112, String r113, String r114, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r212 & 32) == 0) goto L9;
        String r115 = null;
    L11:
        if ((r212 & 64) == 0) goto L13;
        String r116 = null;
    L14:
        this(r110, r111, r112, r113, r100, r115, r116);
        return;
    L13:
        r116 = r211;
        goto L14
    L9:
        r115 = r210;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }

    public final String getAnonymizedPhoneNumber() {
        return this.anonymizedPhoneNumber;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getSimCarrier() {
        return this.simCarrier;
    }

    public final String getSimSlot() {
        return this.simSlot;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setAnonymizedPhoneNumber(String r100) {
        this.anonymizedPhoneNumber = r100;
    }

    public final void setPhoneNumber(String r100) {
        this.phoneNumber = r100;
    }

    public final void setSimCarrier(String r100) {
        this.simCarrier = r100;
    }

    public final void setSimSlot(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.simSlot = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.simSlot);
        r100.writeString(this.simCarrier);
        r100.writeString(this.phoneNumber);
        r100.writeString(this.anonymizedPhoneNumber);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(0);
    }
}
