package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantModel;", "Ljava/io/Serializable;", "pendantType", "", "id", "", "config", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "slice", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "native", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "lynx", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;)V", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "getId", "()Ljava/lang/String;", "getLynx", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "getNative", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "getPendantType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantModel;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPendantModel implements Serializable {

    @SerializedName("config")
    private final ConfigMode config;

    @SerializedName("id")
    private final String id;

    @SerializedName("lynx")
    private final HeaderPendantLynx lynx;

    /* JADX INFO: renamed from: native, reason: not valid java name */
    @SerializedName("native")
    private final HeaderPendantNative f0native;

    @SerializedName("pendant_type")
    private final Integer pendantType;

    @SerializedName("slice")
    private final HeaderSliceModel slice;

    public HeaderPendantModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ HeaderPendantModel copy$default(HeaderPendantModel r4, Integer r5, String r6, ConfigMode r7, HeaderSliceModel r8, HeaderPendantNative r9, HeaderPendantLynx r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.pendantType;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.id;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.config;
    L11:
        ConfigMode r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.slice;
    L14:
        HeaderSliceModel r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.f0native;
    L17:
        HeaderPendantNative r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.lynx;
    L20:
        Integer r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Integer component1() {
        return this.pendantType;
    }

    public final String component2() {
        return this.id;
    }

    public final ConfigMode component3() {
        return this.config;
    }

    public final HeaderSliceModel component4() {
        return this.slice;
    }

    public final HeaderPendantNative component5() {
        return this.f0native;
    }

    public final HeaderPendantLynx component6() {
        return this.lynx;
    }

    public final HeaderPendantModel copy(Integer r9, String r10, ConfigMode r11, HeaderSliceModel r12, HeaderPendantNative r13, HeaderPendantLynx r14) {
        return new HeaderPendantModel(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderPendantModel) == false) goto L18;
        HeaderPendantModel r4 = (HeaderPendantModel) r3;
        if (Intrinsics.areEqual(this.pendantType, r4.pendantType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.config, r4.config) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.slice, r4.slice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f0native, r4.f0native) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lynx, r4.lynx) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.pendantType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ConfigMode r7 = this.config;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        HeaderSliceModel r10 = this.slice;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        HeaderPendantNative r13 = this.f0native;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        HeaderPendantLynx r16 = this.lynx;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderPendantModel(pendantType=" + this.pendantType + ", id=" + this.id + ", config=" + this.config + ", slice=" + this.slice + ", native=" + this.f0native + ", lynx=" + this.lynx + ")";
    }

    public final ConfigMode getConfig() {
        return this.config;
    }

    public final String getId() {
        return this.id;
    }

    public final HeaderPendantLynx getLynx() {
        return this.lynx;
    }

    public final HeaderPendantNative getNative() {
        return this.f0native;
    }

    public final Integer getPendantType() {
        return this.pendantType;
    }

    public final HeaderSliceModel getSlice() {
        return this.slice;
    }

    public HeaderPendantModel(Integer r1, String r2, ConfigMode r3, HeaderSliceModel r4, HeaderPendantNative r5, HeaderPendantLynx r6) {
        this.pendantType = r1;
        this.id = r2;
        this.config = r3;
        this.slice = r4;
        this.f0native = r5;
        this.lynx = r6;
    }

    public /* synthetic */ HeaderPendantModel(Integer r6, String r7, ConfigMode r8, HeaderSliceModel r9, HeaderPendantNative r10, HeaderPendantLynx r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Integer r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        ConfigMode r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        HeaderSliceModel r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        HeaderPendantNative r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        HeaderPendantLynx r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
