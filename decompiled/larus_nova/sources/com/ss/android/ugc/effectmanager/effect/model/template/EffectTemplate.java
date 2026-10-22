package com.ss.android.ugc.effectmanager.effect.model.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.effectmanager.common.model.UrlModel;
import com.ss.ugc.effectplatform.model.Effect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001gB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\b\u0010a\u001a\u00020%H\u0016J\u0018\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020%H\u0016R&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR6\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR&\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR&\u0010\"\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR&\u0010&\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020%8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010,\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020+8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR&\u00104\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020+8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R&\u00107\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020%8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R&\u0010:\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020+8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R&\u0010=\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020+8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010.\"\u0004\b?\u00100R&\u0010@\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\n\"\u0004\bB\u0010\fR&\u0010D\u001a\u00020C2\u0006\u0010\u0006\u001a\u00020C8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR&\u0010H\u001a\u00020C2\u0006\u0010\u0006\u001a\u00020C8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010E\"\u0004\bI\u0010GR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR*\u0010L\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\n\"\u0004\bN\u0010\fR*\u0010O\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\n\"\u0004\bQ\u0010\fR&\u0010S\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020R8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010\fR&\u0010[\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\n\"\u0004\b]\u0010\fR&\u0010^\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\n\"\u0004\b`\u0010\f¨\u0006h"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectTemplate;", "Lcom/ss/ugc/effectplatform/model/Effect;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "kEffect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "value", "", "adRawData", "getAdRawData", "()Ljava/lang/String;", "setAdRawData", "(Ljava/lang/String;)V", "", "bindIds", "getBindIds", "()Ljava/util/List;", "setBindIds", "(Ljava/util/List;)V", "childEffects_Own", "getChildEffects_Own", "setChildEffects_Own", "composerParams", "getComposerParams", "setComposerParams", "designerEncryptedId", "getDesignerEncryptedId", "setDesignerEncryptedId", "designerId", "getDesignerId", "setDesignerId", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "effectId", "getEffectId", "setEffectId", "", "effectType", "getEffectType", "()I", "setEffectType", "(I)V", "Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;", "fileUrl", "getFileUrl", "()Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;", "setFileUrl", "(Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;)V", "gradeKey", "getGradeKey", "setGradeKey", "hintFile", "getHintFile", "setHintFile", "hintFileFormat", "getHintFileFormat", "setHintFileFormat", "hintIcon", "getHintIcon", "setHintIcon", "iconUrl", "getIconUrl", "setIconUrl", "iopId", "getIopId", "setIopId", "", "isBusiness", "()Z", "setBusiness", "(Z)V", "isIsIop", "setIsIop", "getKEffect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "modelNames", "getModelNames", "setModelNames", "parentId", "getParentId", "setParentId", "", "publishTime", "getPublishTime", "()J", "setPublishTime", "(J)V", "resourceId", "getResourceId", "setResourceId", "sdkExtra", "getSdkExtra", "setSdkExtra", "tagsUpdatedAt", "getTagsUpdatedAt", "setTagsUpdatedAt", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectTemplate extends Effect implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;
    private String adRawData;
    private List<String> bindIds;
    private List<? extends EffectTemplate> childEffects_Own;
    private String composerParams;
    private String designerEncryptedId;
    private String designerId;
    private String devicePlatform;
    private String effectId;
    private int effectType;
    private UrlModel fileUrl;
    private String gradeKey;
    private UrlModel hintFile;
    private int hintFileFormat;
    private UrlModel hintIcon;
    private UrlModel iconUrl;
    private String iopId;
    private boolean isBusiness;
    private boolean isIsIop;
    private final transient Effect kEffect;
    private String modelNames;
    private String parentId;
    private long publishTime;
    private String resourceId;
    private String sdkExtra;
    private String tagsUpdatedAt;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectTemplate$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectTemplate;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectTemplate;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class CREATOR implements Parcelable.Creator<EffectTemplate> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EffectTemplate createFromParcel(Parcel r100) {
            Effect r101 = null;
            Object r102 = Effect.class.getField("CREATOR").get(null);     // Catch: Exception -> L17
            if ((r102 instanceof Parcelable.Creator) == true) goto L6;
            r102 = null;
        L6:
            Parcelable.Creator r103 = (Parcelable.Creator) r102;     // Catch: Exception -> L17
            if (r103 == null) goto L9;
            Object r104 = r103.createFromParcel(r100);     // Catch: Exception -> L17
        L11:
            if ((r104 instanceof Effect) == true) goto L13;
            r104 = null;
        L13:
            r101 = (Effect) r104;     // Catch: Exception -> L17
            goto L16
        L9:
            r104 = null;
        L16:
            return new EffectTemplate(r101);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EffectTemplate[] newArray(int r100) {
            return newArray(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EffectTemplate createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EffectTemplate[] newArray(int r100) {
            return new EffectTemplate[r100];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdRawData() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getAd_raw_data();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getAd_raw_data();
    }

    public List<String> getBindIds() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getBind_ids();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getBind_ids();
    }

    public String getComposerParams() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getComposer_params();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getComposer_params();
    }

    public String getDesignerEncryptedId() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDesigner_encrypted_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDesigner_encrypted_id();
    }

    public String getDesignerId() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDesigner_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDesigner_id();
    }

    public String getDevicePlatform() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getDevice_platform();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getDevice_platform();
    }

    public String getEffectId() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getEffect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getEffect_id();
    }

    public int getEffectType() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getEffect_type();
    L6:
        return super.getEffect_type();
    }

    public UrlModel getFileUrl() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.UrlModel r101 = r100.getFile_url();
        if (r101 == null) goto L7;
    L9:
        if ((r101 instanceof UrlModel) == true) goto L16;
        UrlModel r102 = new UrlModel(r101);
        Effect r103 = getKEffect();
        if (r103 == null) goto L14;
        r103.setFile_url(r102);
    L14:
        super.setFile_url(r102);
        return r102;
    L16:
        return (UrlModel) r101;
    L7:
        r101 = super.getFile_url();
        goto L9
    }

    public String getGradeKey() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getGrade_key();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getGrade_key();
    }

    public UrlModel getHintFile() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.UrlModel r101 = r100.getHint_file();
        if (r101 == null) goto L7;
    L9:
        if ((r101 instanceof UrlModel) == true) goto L16;
        UrlModel r102 = new UrlModel(r101);
        Effect r103 = getKEffect();
        if (r103 == null) goto L14;
        r103.setHint_file(r102);
    L14:
        super.setHint_file(r102);
        return r102;
    L16:
        return (UrlModel) r101;
    L7:
        r101 = super.getHint_file();
        goto L9
    }

    public int getHintFileFormat() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getHint_file_format();
    L6:
        return super.getHint_file_format();
    }

    public UrlModel getHintIcon() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.UrlModel r101 = r100.getHint_icon();
        if (r101 == null) goto L7;
    L9:
        if ((r101 instanceof UrlModel) == true) goto L16;
        UrlModel r102 = new UrlModel(r101);
        Effect r103 = getKEffect();
        if (r103 == null) goto L14;
        r103.setHint_icon(r102);
    L14:
        super.setHint_icon(r102);
        return r102;
    L16:
        return (UrlModel) r101;
    L7:
        r101 = super.getHint_icon();
        goto L9
    }

    public UrlModel getIconUrl() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.UrlModel r101 = r100.getIcon_url();
        if (r101 == null) goto L7;
    L9:
        if ((r101 instanceof UrlModel) == true) goto L16;
        UrlModel r102 = new UrlModel(r101);
        Effect r103 = getKEffect();
        if (r103 == null) goto L14;
        r103.setIcon_url(r102);
    L14:
        super.setIcon_url(r102);
        return r102;
    L16:
        return (UrlModel) r101;
    L7:
        r101 = super.getIcon_url();
        goto L9
    }

    public String getIopId() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getIop_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIop_id();
    }

    public String getModelNames() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getModel_names();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getModel_names();
    }

    public String getParentId() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getParent();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getParent();
    }

    public long getPublishTime() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.getPtime();
    L6:
        return super.getPtime();
    }

    public String getResourceId() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getResource_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getResource_id();
    }

    public String getSdkExtra() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getSdk_extra();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSdk_extra();
    }

    public String getTagsUpdatedAt() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_updated_at();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_updated_at();
    }

    public boolean isBusiness() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.is_busi();
    L6:
        return super.is_busi();
    }

    public boolean isIsIop() {
        Effect r100 = getKEffect();
        if (r100 == null) goto L6;
        return r100.is_iop();
    L6:
        return super.is_iop();
    }

    public final List<EffectTemplate> getChildEffects_Own() {
        return this.childEffects_Own;
    }

    public Effect getKEffect() {
        return this.kEffect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectTemplate(Effect r810) {
        Object[] r110 = 0 == true ? 1 : 0;
        super(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, r110, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
        this.kEffect = r810;
        this.effectId = "";
        int r100 = 1;
        this.fileUrl = new UrlModel(0 == true ? 1 : 0, r100, 0 == true ? 1 : 0);
        this.iconUrl = new UrlModel(0 == true ? 1 : 0, r100, 0 == true ? 1 : 0);
        this.hintIcon = new UrlModel(0 == true ? 1 : 0, r100, 0 == true ? 1 : 0);
        this.hintFile = new UrlModel(0 == true ? 1 : 0, r100, 0 == true ? 1 : 0);
        this.tagsUpdatedAt = "";
        this.childEffects_Own = new ArrayList();
        this.designerId = "";
        this.designerEncryptedId = "";
        this.sdkExtra = "";
        this.adRawData = "";
        this.iopId = "";
        this.resourceId = "";
        this.gradeKey = "";
        this.devicePlatform = "";
        this.composerParams = "";
    }

    public void setAdRawData(String r100) {
        this.adRawData = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setAd_raw_data(r100);
        return;
    L9:
        return;
    L7:
        super.setAd_raw_data(r100);
    }

    public void setBindIds(List<String> r100) {
        this.bindIds = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setBind_ids(r100);
        return;
    L9:
        return;
    L7:
        super.setBind_ids(r100);
    }

    public void setBusiness(boolean r100) {
        this.isBusiness = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.set_busi(r100);
        return;
    L9:
        return;
    L7:
        super.set_busi(r100);
    }

    public final void setChildEffects_Own(List<? extends EffectTemplate> r100) {
        this.childEffects_Own = r100;
    }

    public void setComposerParams(String r100) {
        this.composerParams = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setComposer_params(r100);
        return;
    L9:
        return;
    L7:
        super.setComposer_params(r100);
    }

    public void setDesignerEncryptedId(String r100) {
        this.designerEncryptedId = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setDesigner_encrypted_id(r100);
        return;
    L9:
        return;
    L7:
        super.setDesigner_encrypted_id(r100);
    }

    public void setDesignerId(String r100) {
        this.designerId = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setDesigner_id(r100);
        return;
    L9:
        return;
    L7:
        super.setDesigner_id(r100);
    }

    public void setDevicePlatform(String r100) {
        this.devicePlatform = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setDevice_platform(r100);
        return;
    L9:
        return;
    L7:
        super.setDevice_platform(r100);
    }

    public void setEffectId(String r100) {
        this.effectId = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setEffect_id(r100);
        return;
    L9:
        return;
    L7:
        super.setEffect_id(r100);
    }

    public void setEffectType(int r100) {
        this.effectType = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setEffect_type(r100);
        return;
    L9:
        return;
    L7:
        super.setEffect_type(r100);
    }

    public void setFileUrl(UrlModel r100) {
        this.fileUrl = r100;
        Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setFile_url(r100);
    L5:
        super.setFile_url(r100);
    }

    public void setGradeKey(String r100) {
        this.gradeKey = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setGrade_key(r100);
        return;
    L9:
        return;
    L7:
        super.setGrade_key(r100);
    }

    public void setHintFile(UrlModel r100) {
        this.hintFile = r100;
        Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setHint_file(r100);
    L5:
        super.setHint_file(r100);
    }

    public void setHintFileFormat(int r100) {
        this.hintFileFormat = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setHint_file_format(r100);
        return;
    L9:
        return;
    L7:
        super.setHint_file_format(r100);
    }

    public void setHintIcon(UrlModel r100) {
        this.hintIcon = r100;
        Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setHint_icon(r100);
    L5:
        super.setHint_icon(r100);
    }

    public void setIconUrl(UrlModel r100) {
        this.iconUrl = r100;
        Effect r101 = getKEffect();
        if (r101 == null) goto L5;
        r101.setIcon_url(r100);
    L5:
        super.setIcon_url(r100);
    }

    public void setIopId(String r100) {
        this.iopId = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setIop_id(r100);
        return;
    L9:
        return;
    L7:
        super.setIop_id(r100);
    }

    public void setIsIop(boolean r100) {
        this.isIsIop = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.set_iop(r100);
        return;
    L9:
        return;
    L7:
        super.set_iop(r100);
    }

    public void setModelNames(String r100) {
        this.modelNames = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setModel_names(r100);
        return;
    L9:
        return;
    L7:
        super.setModel_names(r100);
    }

    public void setParentId(String r100) {
        this.parentId = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setParent(r100);
        return;
    L9:
        return;
    L7:
        super.setParent(r100);
    }

    public void setPublishTime(long r100) {
        this.publishTime = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setPtime(r100);
        return;
    L9:
        return;
    L7:
        super.setPtime(r100);
    }

    public void setResourceId(String r100) {
        this.resourceId = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setResource_id(r100);
        return;
    L9:
        return;
    L7:
        super.setResource_id(r100);
    }

    public void setSdkExtra(String r100) {
        this.sdkExtra = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setSdk_extra(r100);
        return;
    L9:
        return;
    L7:
        super.setSdk_extra(r100);
    }

    public void setTagsUpdatedAt(String r100) {
        this.tagsUpdatedAt = r100;
        if (getKEffect() == null) goto L7;
        Effect r101 = getKEffect();
        if (r101 == null) goto L9;
        r101.setTags_updated_at(r100);
        return;
    L9:
        return;
    L7:
        super.setTags_updated_at(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.Effect, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (getKEffect() == null) goto L7;
        Effect r102 = getKEffect();
        if (r102 == null) goto L9;
        r102.writeToParcel(r100, r101);
        return;
    L9:
        return;
    L7:
        super.writeToParcel(r100, r101);
    }

    public /* synthetic */ EffectTemplate(Effect r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
