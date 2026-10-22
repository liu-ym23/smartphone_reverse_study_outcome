package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJJ\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\u0010\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0-H\u0016J\t\u0010.\u001a\u00020\u000bHÖ\u0001J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010+H\u0016J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R(\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSendMessageParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", PickerReporterConstants.KEY.TARGET, "", "targetId", "targetType", "content", "Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;Ljava/lang/Integer;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;)V", "getTarget", "()Ljava/lang/String;", "setTarget", "(Ljava/lang/String;)V", "getTargetId", "setTargetId", "getTargetType", "setTargetType", "getVersion$annotations", "()V", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeSendMessageParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeSendMessageParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<OfficeSendMessageParams> CREATOR = null;
    private OfficeMessageContent content;
    private String target;
    private String targetId;
    private String targetType;
    Integer version;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<OfficeSendMessageParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeSendMessageParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            OfficeMessageContent r104 = null;
        L6:
            OfficeSendMessageParams r105 = new OfficeSendMessageParams(r101, r102, r103, r104, null, 16, null);
            int r106 = Math.min(r100, 1);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L7:
            if (r108 > r106) goto L13;
            if (r108 != 1) goto L12;
            Object r109 = joa.a.c(r110, r107);
            if (r109 == null) goto L12;
            r105.version = (Integer) r109;
        L12:
            r108 = r108 + 1;
        L13:
            if (r108 > r100) goto L15;
            joa.a.d(r110, r107);
            r108 = r108 + 1;
            goto L13
        L15:
            return r105;
        L5:
            r104 = OfficeMessageContent.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeSendMessageParams[] newArray(int r100) {
            return new OfficeSendMessageParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OfficeSendMessageParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OfficeSendMessageParams copy$default(OfficeSendMessageParams r100, String r101, String r102, String r103, OfficeMessageContent r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.targetId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.targetType;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.content;
    L14:
        OfficeMessageContent r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.version;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.target;
    }

    public final String component2() {
        return this.targetId;
    }

    public final String component3() {
        return this.targetType;
    }

    public final OfficeMessageContent component4() {
        return this.content;
    }

    public final Integer component5() {
        return this.version;
    }

    public final OfficeSendMessageParams copy(String r100, String r101, String r110, OfficeMessageContent r111, Integer r112) {
        return new OfficeSendMessageParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSendMessageParams) == true) goto L8;
        return false;
    L8:
        OfficeSendMessageParams r101 = (OfficeSendMessageParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetId, r101.targetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetType, r101.targetType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.targetId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.targetType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        OfficeMessageContent r110 = this.content;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.version;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "OfficeSendMessageParams(target=" + this.target + ", targetId=" + this.targetId + ", targetType=" + this.targetType + ", content=" + this.content + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.target);
        r100.writeString(this.targetId);
        r100.writeString(this.targetType);
        OfficeMessageContent r102 = this.content;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeValue(this.version);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.content);
    }

    public final OfficeMessageContent getContent() {
        return this.content;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof OfficeSendMessageParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.target;
        if (r101 != null) goto L8;
        r101 = ((OfficeSendMessageParams) r100).target;
    L8:
        String r102 = r101;
        String r103 = this.targetId;
        if (r103 != null) goto L11;
        r103 = ((OfficeSendMessageParams) r100).targetId;
    L11:
        String r104 = r103;
        String r105 = this.targetType;
        if (r105 != null) goto L14;
        r105 = ((OfficeSendMessageParams) r100).targetType;
    L14:
        String r106 = r105;
        OfficeMessageContent r107 = this.content;
        if (r107 != null) goto L17;
        r107 = ((OfficeSendMessageParams) r100).content;
    L17:
        OfficeMessageContent r108 = r107;
        Integer r109 = this.version;
        if (r109 != null) goto L20;
        Integer r110 = ((OfficeSendMessageParams) r100).version;
    L22:
        return new OfficeSendMessageParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setContent(OfficeMessageContent r100) {
        this.content = r100;
    }

    public final void setTarget(String r100) {
        this.target = r100;
    }

    public final void setTargetId(String r100) {
        this.targetId = r100;
    }

    public final void setTargetType(String r100) {
        this.targetType = r100;
    }

    public final void setVersion(Integer r100) {
        this.version = r100;
    }

    public OfficeSendMessageParams(String r100, String r101, String r102, OfficeMessageContent r103, Integer r104) {
        this.target = r100;
        this.targetId = r101;
        this.targetType = r102;
        this.content = r103;
        this.version = r104;
    }

    public /* synthetic */ OfficeSendMessageParams(String r100, String r101, String r102, OfficeMessageContent r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        OfficeMessageContent r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
