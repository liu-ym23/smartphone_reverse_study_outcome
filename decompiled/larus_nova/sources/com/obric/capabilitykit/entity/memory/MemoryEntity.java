package com.obric.capabilitykit.entity.memory;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b'\u0018\u0000 R2\u00020\u0001:\u0001RB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010D\u001a\u00020EH&J\u0018\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0004J\u0015\u0010I\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ\u001d\u0010N\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u000bH\u0000¢\u0006\u0002\bPJ\u0018\u0010Q\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001c\u00105\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R\u001c\u00108\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\u001c\u0010;\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006S"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "type", "", "productType", "(Ljava/lang/String;JJII)V", "confidence", "", "getConfidence", "()F", "setConfidence", "(F)V", "detail", "getDetail", "()Ljava/lang/String;", "setDetail", "(Ljava/lang/String;)V", "detailStatus", "getDetailStatus", "()I", "setDetailStatus", "(I)V", "evidenceCount", "getEvidenceCount", "setEvidenceCount", "logId", "getLogId", "setLogId", "getProductType", "setProductType", IHostShare.ShareType.SCREENSHOT, "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getScreenshot", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setScreenshot", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceLink", "getSourceLink", "setSourceLink", "sourceLinkType", "getSourceLinkType", "setSourceLinkType", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", "sourceQuery", "getSourceQuery", "setSourceQuery", "sourceText", "getSourceText", "setSourceText", "userEdit", "", "getUserEdit", "()Z", "setUserEdit", "(Z)V", "convertToModelInput", "Lorg/json/JSONObject;", "makeModelInputValue", SocialConstants.PARAM_APP_DESC, "value", "readMemoryExtensionFieldFromParcel", "", "readMemoryExtensionFieldFromParcel$capabilitykitcommon_release", "writeMemoryBaseFieldToParcel", "writeMemoryBaseFieldToParcel$capabilitykitcommon_release", "writeMemoryExtensionFieldToParcel", "flags", "writeMemoryExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MemoryEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 10;
    private static final int RELATED_VERSION = 0;
    private float confidence;
    private String detail;
    private int detailStatus;
    private int evidenceCount;
    private String logId;
    private int productType;
    private FileEntity screenshot;
    private String sourceAppName;
    private String sourceLink;
    private String sourceLinkType;
    private String sourcePackageName;
    private String sourceQuery;
    private String sourceText;
    private boolean userEdit;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.MemoryEntity");
            return (MemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemoryEntity[] newArray(int r100) {
            return new MemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), r110.readInt());
        throw new UnsupportedOperationException("Don't construct MemoryEntity Directly, use subclass instead");
    }

    public MemoryEntity(String r100, long r101, long r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        super(r100, r101, r102, r103);
        this.productType = r104;
    }

    public abstract JSONObject convertToModelInput();

    public final float getConfidence() {
        return this.confidence;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final int getDetailStatus() {
        return this.detailStatus;
    }

    public final int getEvidenceCount() {
        return this.evidenceCount;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final FileEntity getScreenshot() {
        return this.screenshot;
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceLink() {
        return this.sourceLink;
    }

    public final String getSourceLinkType() {
        return this.sourceLinkType;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getSourceQuery() {
        return this.sourceQuery;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final boolean getUserEdit() {
        return this.userEdit;
    }

    public final JSONObject makeModelInputValue(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r101, "value");
        JSONObject r102 = new JSONObject();
        r102.put(SocialConstants.PARAM_APP_DESC, r100);
        r102.put("value", r101);
        return r102;
    }

    public final void readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        readExtensionFieldFromParcel$capabilitykitcommon_release(r100);
        int r101 = r100.readInt();
        this.sourceLinkType = r100.readString();
        this.sourceLink = r100.readString();
        this.screenshot = (FileEntity) r100.readParcelable(FileEntity.class.getClassLoader());
        int r102 = 10;
        if (r101 > 10) goto L6;
        r102 = r101;
    L6:
        ClassLoader r103 = MemoryEntity.class.getClassLoader();
        int r104 = 1;
    L7:
        if (r104 > r102) goto L46;
        int r105 = 0;
        int r106 = 0;
        boolean r107 = false;
        String r108 = null;
        Float r109 = null;
        Integer r110 = null;
        Boolean r111 = null;
        Integer r112 = null;
        switch(r104) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L30;
            case 8: goto L24;
            case 9: goto L18;
            case 10: goto L11;
            default: goto L45;
        };
    L11:
        Object r113 = r100.readValue(r103);
        if ((r113 instanceof Float) == false) goto L14;
        r109 = (Float) r113;
    L14:
        if (r109 == null) goto L16;
        float r114 = r109.floatValue();
    L17:
        this.confidence = r114;
        goto L45
    L16:
        r114 = 0.0f;
        goto L17
    L18:
        Object r115 = r100.readValue(r103);
        if ((r115 instanceof Integer) == false) goto L21;
        r110 = (Integer) r115;
    L21:
        if (r110 == null) goto L23;
        r106 = r110.intValue();
    L23:
        this.evidenceCount = r106;
        goto L45
    L24:
        Object r116 = r100.readValue(r103);
        if ((r116 instanceof Boolean) == false) goto L27;
        r111 = (Boolean) r116;
    L27:
        if (r111 == null) goto L29;
        r107 = r111.booleanValue();
    L29:
        this.userEdit = r107;
        goto L45
    L30:
        Object r117 = r100.readValue(r103);
        if ((r117 instanceof Integer) == false) goto L33;
        r112 = (Integer) r117;
    L33:
        if (r112 == null) goto L35;
        r105 = r112.intValue();
    L35:
        this.detailStatus = r105;
        goto L45
    L36:
        this.detail = (String) r100.readValue(r103);
        goto L45
    L37:
        this.sourceQuery = (String) r100.readValue(r103);
        goto L45
    L38:
        this.logId = (String) r100.readValue(r103);
        goto L45
    L39:
        this.sourceAppName = (String) r100.readValue(r103);
        goto L45
    L40:
        this.sourcePackageName = (String) r100.readValue(r103);
        goto L45
    L41:
        Object r118 = r100.readValue(r103);
        if ((r118 instanceof String) == false) goto L44;
        r108 = (String) r118;
    L44:
        this.sourceText = r108;
    L45:
        r104 = r104 + 1;
    L46:
        if (r104 > r101) goto L48;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r103);
        r104 = r104 + 1;
        goto L46
    }

    public final void setConfidence(float r100) {
        this.confidence = r100;
    }

    public final void setDetail(String r100) {
        this.detail = r100;
    }

    public final void setDetailStatus(int r100) {
        this.detailStatus = r100;
    }

    public final void setEvidenceCount(int r100) {
        this.evidenceCount = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setProductType(int r100) {
        this.productType = r100;
    }

    public final void setScreenshot(FileEntity r100) {
        this.screenshot = r100;
    }

    public final void setSourceAppName(String r100) {
        this.sourceAppName = r100;
    }

    public final void setSourceLink(String r100) {
        this.sourceLink = r100;
    }

    public final void setSourceLinkType(String r100) {
        this.sourceLinkType = r100;
    }

    public final void setSourcePackageName(String r100) {
        this.sourcePackageName = r100;
    }

    public final void setSourceQuery(String r100) {
        this.sourceQuery = r100;
    }

    public final void setSourceText(String r100) {
        this.sourceText = r100;
    }

    public final void setUserEdit(boolean r100) {
        this.userEdit = r100;
    }

    public final void writeMemoryBaseFieldToParcel$capabilitykitcommon_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(this.productType);
    }

    public final void writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(10);
        r100.writeString(this.sourceLinkType);
        r100.writeString(this.sourceLink);
        r100.writeParcelable(this.screenshot, r101);
        r100.writeValue(this.sourceText);
        r100.writeValue(this.sourcePackageName);
        r100.writeValue(this.sourceAppName);
        r100.writeValue(this.logId);
        r100.writeValue(this.sourceQuery);
        r100.writeValue(this.detail);
        r100.writeValue(Integer.valueOf(this.detailStatus));
        r100.writeValue(Boolean.valueOf(this.userEdit));
        r100.writeValue(Integer.valueOf(this.evidenceCount));
        r100.writeValue(Float.valueOf(this.confidence));
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        throw new UnsupportedOperationException("Don't construct MemoryEntity Directly, use subclass instead");
    }
}
