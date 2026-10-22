package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.ss.bduploader.BDVideoUploaderBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BY\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012J\b\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\"\u0010$\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\fH\u0016J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\fH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "infoKey", "infoValue", "observation", "relatedMemoryids", "tag", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInfoKey", "()Ljava/lang/String;", "setInfoKey", "(Ljava/lang/String;)V", "getInfoValue", "setInfoValue", "getObservation", "setObservation", "getRelatedMemoryids", "setRelatedMemoryids", "getTag", "setTag", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "InfoKeyType", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InfoCommonMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 0;
    private String infoKey;
    private String infoValue;
    private String observation;
    private String relatedMemoryids;
    private String tag;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InfoCommonMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoCommonMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity");
            return (InfoCommonMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoCommonMemoryEntity[] newArray(int r100) {
            return new InfoCommonMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity$InfoKeyType;", "", "()V", "ADDRESS", "", "ANNIVERSARY", "IDENTIFICATION", "RELATIONSHIP", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InfoKeyType {
        public static final String ADDRESS = "地址";
        public static final String ANNIVERSARY = "纪念日";
        public static final String IDENTIFICATION = "证件";
        public static final InfoKeyType INSTANCE = null;
        public static final String RELATIONSHIP = "关系";

        static {
            INSTANCE = new InfoKeyType();
        }

        private InfoKeyType() {
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InfoCommonMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), EntityExtKt.e(r110), null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 3, r110.readInt());
    }

    public InfoCommonMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r115, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "infoKey");
        Intrinsics.checkNotNullParameter(r115, "infoValue");
        super(r110, r111, r112, 10105, r113);
        this.infoKey = r114;
        this.infoValue = r115;
        this.observation = r210;
        this.relatedMemoryids = r211;
        this.tag = r212;
    }

    public /* synthetic */ InfoCommonMemoryEntity(String r110, long r111, long r112, int r210, String r211, String r212, String r213, String r214, String r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 64) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r216 & 128) == 0) goto L9;
        String r114 = null;
    L11:
        if ((r216 & 256) == 0) goto L13;
        String r115 = null;
    L14:
        this(r110, r111, r112, r210, r211, r212, r113, r114, r115);
        return;
    L13:
        r115 = r215;
        goto L14
    L9:
        r114 = r214;
        goto L11
    L5:
        r113 = r213;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("infoKey", makeModelInputValue("信息类型", this.infoKey));
        r100.put("infoValue", makeModelInputValue("信息内容", this.infoValue));
        return r100;
    }

    public final String getInfoKey() {
        return this.infoKey;
    }

    public final String getInfoValue() {
        return this.infoValue;
    }

    public final String getObservation() {
        return this.observation;
    }

    public final String getRelatedMemoryids() {
        return this.relatedMemoryids;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r100 = getScreenshot();
        if (r100 == null) goto L7;
        List<Uri> r101 = r100.getSharedUris();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public final String getTag() {
        return this.tag;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L5;
        this.observation = (String) r100.readValue(r101);
        return;
    L5:
        if (r102 != 2) goto L7;
        this.relatedMemoryids = (String) r100.readValue(r101);
        return;
    L7:
        if (r102 != 3) goto L15;
        this.tag = (String) r100.readValue(r101);
        return;
    }

    public final void setInfoKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.infoKey = r100;
    }

    public final void setInfoValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.infoValue = r100;
    }

    public final void setObservation(String r100) {
        this.observation = r100;
    }

    public final void setRelatedMemoryids(String r100) {
        this.relatedMemoryids = r100;
    }

    public final void setTag(String r100) {
        this.tag = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.infoKey);
        r100.writeString(this.infoValue);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(3);
        r100.writeValue(this.observation);
        r100.writeValue(this.relatedMemoryids);
        r100.writeValue(this.tag);
    }
}
