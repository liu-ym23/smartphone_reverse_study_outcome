package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bc\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0011H\u0016J\"\u0010&\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\fH\u0016J\u0018\u0010+\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\fH\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "summary", "memoryCreateTime", "title", "tagList", "", "category", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getMemoryCreateTime", "setMemoryCreateTime", "getSummary", "setSummary", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "getTitle", d.f25925o, "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonTextMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 0;
    private String category;
    private String memoryCreateTime;
    private String summary;
    private List<String> tagList;
    private String title;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CommonTextMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonTextMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity");
            return (CommonTextMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonTextMemoryEntity[] newArray(int r100) {
            return new CommonTextMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CommonTextMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), r110.readString(), null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 3, r110.readInt());
    }

    public CommonTextMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r115, String r116, List<String> r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "summary");
        super(r110, r111, r112, 10401, r113);
        this.summary = r114;
        this.memoryCreateTime = r115;
        this.title = r116;
        this.tagList = r210;
        this.category = r211;
    }

    public /* synthetic */ CommonTextMemoryEntity(String r110, long r111, long r112, int r210, String r211, String r212, String r213, List r214, String r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 32) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r216 & 64) == 0) goto L9;
        String r114 = null;
    L11:
        if ((r216 & 128) == 0) goto L13;
        List r115 = null;
    L15:
        if ((r216 & 256) == 0) goto L17;
        String r116 = null;
    L18:
        this(r110, r111, r112, r210, r211, r113, r114, r115, r116);
        return;
    L17:
        r116 = r215;
        goto L18
    L13:
        r115 = r214;
        goto L15
    L9:
        r114 = r213;
        goto L11
    L5:
        r113 = r212;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("title", this.title);
        r100.put("summary", makeModelInputValue("总结的记忆内容", this.summary));
        String r101 = this.memoryCreateTime;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("memoryCreateTime", makeModelInputValue("记忆时间", r101));
    L5:
        return r100;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getMemoryCreateTime() {
        return this.memoryCreateTime;
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

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTagList() {
        return this.tagList;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 == 1) goto L17;
        List<String> r103 = null;
        String r104 = null;
        if (r102 != 2) goto L7;
        Object r105 = r100.readValue(r101);
        if ((r105 instanceof List) == false) goto L16;
        r103 = (List) r105;
    L16:
        this.tagList = r103;
        return;
    L7:
        if (r102 != 3) goto L21;
        Object r106 = r100.readValue(r101);
        if ((r106 instanceof String) == false) goto L12;
        r104 = (String) r106;
    L12:
        this.category = r104;
        return;
    L21:
        return;
    L17:
        this.title = (String) r100.readValue(r101);
    }

    public final void setCategory(String r100) {
        this.category = r100;
    }

    public final void setMemoryCreateTime(String r100) {
        this.memoryCreateTime = r100;
    }

    public final void setSummary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.summary = r100;
    }

    public final void setTagList(List<String> r100) {
        this.tagList = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.summary);
        r100.writeString(this.memoryCreateTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(3);
        r100.writeValue(this.title);
        r100.writeValue(this.tagList);
        r100.writeValue(this.category);
    }
}
