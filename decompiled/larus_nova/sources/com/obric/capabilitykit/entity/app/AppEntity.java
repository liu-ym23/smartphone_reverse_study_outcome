package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xia.b0;
import xia.c;
import xia.p;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b'\u0018\u0000 b2\u00020\u0001:\u0001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010A\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020'J\u0006\u0010C\u001a\u00020BJ\b\u0010D\u001a\u00020\u000bH\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u0004\u0018\u00010\u0006J\b\u0010H\u001a\u0004\u0018\u00010\u0006J\u0010\u0010I\u001a\u0004\u0018\u00010'2\u0006\u0010J\u001a\u00020\u0006J\u0006\u0010K\u001a\u00020\u0006J\b\u0010L\u001a\u00020\u000bH\u0016J\"\u0010M\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020\u000bH&J\u0015\u0010Q\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bRJ%\u0010S\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000bH\u0000¢\u0006\u0002\bVJ\u0010\u0010W\u001a\u00020B2\b\u0010X\u001a\u0004\u0018\u00010\u0006J\u0010\u0010Y\u001a\u00020B2\b\u0010Z\u001a\u0004\u0018\u00010\u0006J\b\u0010[\u001a\u00020\u0006H\u0016J\u0015\u0010\\\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b_J\u0018\u0010`\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u000bH\u0016R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001e\u00104\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010:\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u001c\u0010>\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011¨\u0006c"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "lastModifiedTime", "type", "", "(Ljava/lang/String;JJI)V", "_packageName", "get_packageName", "()Ljava/lang/String;", "set_packageName", "(Ljava/lang/String;)V", "contentHash", "getContentHash", "setContentHash", "getCreateTime", "()J", "setCreateTime", "(J)V", "ecaId", "ecaRawContent", "value", "", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", ControlRule.KEY_EXTRA_DATA, "getExtraData", "setExtraData", "extras", "", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "getExtras", "()Ljava/util/List;", "setExtras", "(Ljava/util/List;)V", "<set-?>", "hashCodeValue", "getHashCodeValue", "()I", "getId", "setId", "getLastModifiedTime", "setLastModifiedTime", "poisonLabel", "getPoisonLabel", "()Ljava/lang/Integer;", "setPoisonLabel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "poisonLabelVersion", "getPoisonLabelVersion", "setPoisonLabelVersion", "getType", ST.UUID_DEVICE, "getUuid", "setUuid", "addExtraEntity", "", "countHashCode", "describeContents", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getEcaId", "getEcaRawContent", "getExtraEntity", "key", "getPackageName", "hashCode", "onReadSubClassExtensionField", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$capabilitykitcommon_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "theirVersion", "readSubClassExtensionFieldFromParcel$capabilitykitcommon_release", "setEcaId", "uniqueId", "setEcaRawContent", "rawContent", "toString", "writeBaseFieldToParcel", "writeBaseFieldToParcel$capabilitykitcommon_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AppEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 9;
    private static final int RELATED_VERSION = 0;
    private String _packageName;
    private String contentHash;
    private long createTime;
    private String ecaId;
    private String ecaRawContent;
    private transient Object extra;
    private String extraData;
    private List<ExtraEntity> extras;
    private int hashCodeValue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396205id;
    private long lastModifiedTime;
    private Integer poisonLabel;
    private Integer poisonLabelVersion;
    private final int type;
    private String uuid;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "json", "", "fromJsonKeepTimeStamp", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            EntityClassData<? extends AppEntity> r102 = EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r101));
            if (r102 == null) goto L9;
            Function1<Parcel, T> r103 = r102.getParcelConstructor();
            if (r103 == 0) goto L9;
            return (AppEntity) r103.invoke(r100);
        L9:
            throw new UnsupportedOperationException("failed to construct AppEntity for type " + r101);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final AppEntity fromJson(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            return (AppEntity) GsonProtectorUtils.fromJson(EntityExtKt.a(), r100, AppEntity.class);
        }

        public final AppEntity fromJsonKeepTimeStamp(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            int r101 = GsonProtectorUtils.parse(new JsonParser(), r100).getAsJsonObject().get("type").getAsInt();
            EntityClassData<? extends AppEntity> r102 = EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r101));
            if (r102 == null) goto L9;
            Class<T> r103 = r102.getClazz();
            if (r103 == 0) goto L9;
            return (AppEntity) GsonProtectorUtils.fromJson(EntityExtKt.b(), r100, r103);
        L9:
            throw new IllegalArgumentException("Unknown entity type: " + r101);
        }

        public final int getVersion() {
            return 9;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity[] newArray(int r100) {
            return new AppEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppEntity(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(EntityExtKt.e(r100), r100.readLong(), r100.readLong(), r100.readInt());
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public AppEntity(String r100, long r101, long r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f396205id = r100;
        this.createTime = r101;
        this.lastModifiedTime = r102;
        this.type = r103;
        this._packageName = "";
        String r104 = EntityContextHolder.INSTANCE.getPackageName();
        if (PackageUtils.INSTANCE.isMemoryPackageName(r104) == false) goto L13;
        if ((this instanceof ContactEntity) == false) goto L7;
    L16:
        r104 = "com.android.contacts";
    L17:
        this._packageName = r104;
        return;
    L7:
        if ((this instanceof CallHistoryEntity) == true) goto L16;
        if ((this instanceof MessageEntity) == false) goto L17;
        this._packageName = "com.android.mms";
        return;
    L13:
        if (Intrinsics.areEqual("com.android.mms", r104) == false) goto L17;
        if ((this instanceof ContactEntity) == false) goto L17;
        goto L16
    }

    public final void addExtraEntity(ExtraEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        if (this.extras != null) goto L5;
        this.extras = new ArrayList();
    L5:
        List<ExtraEntity> r101 = this.extras;
        Intrinsics.checkNotNull(r101);
        r101.add(r100);
    }

    public final void countHashCode() {
        this.hashCodeValue = hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContentHash() {
        return this.contentHash;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public DisplayRepresentation getDisplayRepresentation() {
        throw new UnsupportedOperationException("entity not implementation getDisplayRepresentation method");
    }

    public final String getEcaId() {
        return this.ecaId;
    }

    public final String getEcaRawContent() {
        return this.ecaRawContent;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final ExtraEntity getExtraEntity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List<ExtraEntity> r101 = this.extras;
        Object r102 = null;
        if (r101 == null) goto L15;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((ExtraEntity) r104).getKey(), r100) == false) goto L6;
        r102 = r104;
    L11:
        return (ExtraEntity) r102;
    L15:
        return null;
    }

    public final List<ExtraEntity> getExtras() {
        return this.extras;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getId() {
        return this.f396205id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getPackageName() {
        return this._packageName;
    }

    public final Integer getPoisonLabel() {
        return this.poisonLabel;
    }

    public final Integer getPoisonLabelVersion() {
        return this.poisonLabelVersion;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String get_packageName() {
        return this._packageName;
    }

    public abstract void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102);

    public final void readExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r101 = r100.readInt();
        this._packageName = EntityExtKt.e(r100);
        this.extras = r100.createTypedArrayList(ExtraEntity.CREATOR);
        int r102 = 9;
        if (r101 > 9) goto L6;
        r102 = r101;
    L6:
        ClassLoader r103 = AppEntity.class.getClassLoader();
        int r104 = 1;
    L7:
        if (r104 > r102) goto L42;
        String r105 = null;
        String r106 = null;
        Integer r107 = null;
        Integer r108 = null;
        String r109 = null;
        String r110 = null;
        String r111 = null;
        switch(r104) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L15;
            case 9: goto L11;
            default: goto L41;
        };
    L11:
        Object r112 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r112 instanceof String) == false) goto L14;
        r106 = (String) r112;
    L14:
        this.contentHash = r106;
        goto L41
    L15:
        Object r113 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r113 instanceof Integer) == false) goto L18;
        r107 = (Integer) r113;
    L18:
        this.poisonLabelVersion = r107;
        goto L41
    L19:
        Object r114 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r114 instanceof Integer) == false) goto L22;
        r108 = (Integer) r114;
    L22:
        this.poisonLabel = r108;
        goto L41
    L23:
        Object r115 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r115 instanceof String) == false) goto L26;
        r109 = (String) r115;
    L26:
        this.uuid = r109;
        goto L41
    L27:
        Object r116 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r116 instanceof String) == false) goto L30;
        r110 = (String) r116;
    L30:
        this.ecaRawContent = r110;
        goto L41
    L31:
        Object r117 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r117 instanceof String) == false) goto L34;
        r111 = (String) r117;
    L34:
        this.ecaId = r111;
        goto L41
    L35:
        Object r118 = ParcelUtils.INSTANCE.readValueSafely(r100, r103);
        if ((r118 instanceof String) == false) goto L38;
        r105 = (String) r118;
    L38:
        this.extraData = r105;
        goto L41
    L39:
        Object r119 = r100.readValue(r103);
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.Int");
        this.hashCodeValue = ((Integer) r119).intValue();
        goto L41
    L40:
        setExtra(ParcelUtils.INSTANCE.readValueSafely(r100, r103));
    L41:
        r104 = r104 + 1;
    L42:
        if (r104 > r101) goto L44;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r103);
        r104 = r104 + 1;
        goto L42
    }

    public final void readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 > r101) goto L6;
        r101 = r102;
    L6:
        ClassLoader r103 = AppEntity.class.getClassLoader();
        int r104 = 1;
    L7:
        if (r104 > r101) goto L9;
        onReadSubClassExtensionField(r100, r103, r104);
        r104 = r104 + 1;
    L9:
        if (r104 > r102) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r103);
        r104 = r104 + 1;
        goto L9
    }

    public final void setContentHash(String r100) {
        this.contentHash = r100;
    }

    public final void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public final void setEcaId(String r100) {
        this.ecaId = r100;
    }

    public final void setEcaRawContent(String r100) {
        this.ecaRawContent = r100;
    }

    public final void setExtra(Object r100) {
        if (EntityExtKt.c(r100) == false) goto L6;
        this.extra = r100;
        return;
    L6:
        StringBuilder r101 = new StringBuilder("extra value type ");
        Intrinsics.checkNotNull(r100);
        r101.append(r100.getClass().getName());
        r101.append(" is not supported");
        throw new IllegalArgumentException(r101.toString());
    }

    public final void setExtraData(String r100) {
        this.extraData = r100;
    }

    public final void setExtras(List<ExtraEntity> r100) {
        this.extras = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f396205id = r100;
    }

    public final void setLastModifiedTime(long r100) {
        this.lastModifiedTime = r100;
    }

    public final void setPoisonLabel(Integer r100) {
        this.poisonLabel = r100;
    }

    public final void setPoisonLabelVersion(Integer r100) {
        this.poisonLabelVersion = r100;
    }

    public final void setUuid(String r100) {
        this.uuid = r100;
    }

    public final void set_packageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._packageName = r100;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    public final void writeBaseFieldToParcel$capabilitykitcommon_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.type);
        r100.writeString(this.f396205id);
        r100.writeLong(this.createTime);
        r100.writeLong(this.lastModifiedTime);
    }

    public final void writeExtensionFieldToParcel$capabilitykitcommon_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(9);
        r100.writeString(this._packageName);
        r100.writeTypedList(this.extras);
        r100.writeValue(this.extra);
        r100.writeValue(Integer.valueOf(this.hashCodeValue));
        r100.writeValue(this.extraData);
        r100.writeValue(this.ecaId);
        r100.writeValue(this.ecaRawContent);
        r100.writeValue(this.uuid);
        r100.writeValue(this.poisonLabel);
        r100.writeValue(this.poisonLabelVersion);
        r100.writeValue(this.contentHash);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public int hashCode() {
        Map<String, c> r100 = b0.f563980a;
        Map<String, c> r101 = b0.f563980a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        c r103 = (c) r102.get(getClass().getName());
        if (r103 == null) goto L7;
        return (r103.a(this) * 31) + p.f563995a.a(this);
    L7:
        throw new IllegalStateException("not found entity generatorHashCode function, entityName: ".concat(getClass().getName()));
    }
}
