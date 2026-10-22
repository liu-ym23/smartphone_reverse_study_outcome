package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B=\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 H\u0016R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "countdownSeconds", "label", "status", "Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;", "(Ljava/lang/String;JJJLjava/lang/String;Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;)V", "getCountdownSeconds", "()J", "setCountdownSeconds", "(J)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getStatus", "()Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;", "setStatus", "(Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;)V", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CountdownEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 1;
    private long countdownSeconds;
    private String label;
    private CountdownStatusEnum status;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CountdownEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CountdownEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CountdownEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CountdownEntity");
            return (CountdownEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CountdownEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CountdownEntity[] newArray(int r100) {
            return new CountdownEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CountdownEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CountdownEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readLong(), r110.readString(), null, 32, null);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 1, r110.readInt());
    }

    public CountdownEntity(String r100, long r110, long r111, long r112, String r113, CountdownStatusEnum r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        super(r100, r110, r111, 702);
        this.countdownSeconds = r112;
        this.label = r113;
        this.status = r114;
    }

    public /* synthetic */ CountdownEntity(String r110, long r111, long r112, long r113, String r210, CountdownStatusEnum r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 16) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r212 & 32) == 0) goto L9;
        CountdownStatusEnum r115 = null;
    L10:
        this(r110, r111, r112, r113, r114, r115);
        return;
    L9:
        r115 = r211;
        goto L10
    L5:
        r114 = r210;
        goto L7
    }

    public final long getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final String getLabel() {
        return this.label;
    }

    public final CountdownStatusEnum getStatus() {
        return this.status;
    }

    public final void setCountdownSeconds(long r100) {
        this.countdownSeconds = r100;
    }

    public final void setLabel(String r100) {
        this.label = r100;
    }

    public final void setStatus(CountdownStatusEnum r100) {
        this.status = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeLong(this.countdownSeconds);
        r100.writeString(this.label);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(1);
        CountdownStatusEnum r102 = this.status;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeValue(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L15;
        CountdownStatusEnum.a r103 = CountdownStatusEnum.Companion;
        String r104 = (String) r100.readValue(r101);
        r103.getClass();
        if (r104 != null) goto L13;
    L10:
        CountdownStatusEnum r105 = null;
    L11:
        this.status = r105;
        return;
    L13:
        r105 = CountdownStatusEnum.valueOf(r104);     // Catch: IllegalArgumentException -> L9
    L9:
        Reflection.getOrCreateKotlinClass(CountdownStatusEnum.class).getSimpleName();
        goto L10
    }
}
