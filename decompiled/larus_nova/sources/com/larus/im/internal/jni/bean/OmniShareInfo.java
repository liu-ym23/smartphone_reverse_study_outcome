package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\rHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniShareInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "shareStatus", "", "shareUrl", "qrCodeUrl", "isShowShareTab", "", "isShowMessageShare", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShareStatus$annotations", "()V", "getShareUrl$annotations", "getQrCodeUrl$annotations", "isShowShareTab$annotations", "isShowMessageShare$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniShareInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean isShowMessageShare;
    public final boolean isShowShareTab;
    public final String qrCodeUrl;
    public final String shareStatus;
    public final String shareUrl;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniShareInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniShareInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniShareInfo> serializer() {
            return OmniShareInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniShareInfo() {
        this(null, null, null, false, false, 31, null);
    }

    public static /* synthetic */ OmniShareInfo copy$default(OmniShareInfo r100, String r101, String r102, String r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.shareStatus;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.shareUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.qrCodeUrl;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isShowShareTab;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isShowMessageShare;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("qr_code_url")
    public static /* synthetic */ void getQrCodeUrl$annotations() {
    }

    @SerialName("share_status")
    public static /* synthetic */ void getShareStatus$annotations() {
    }

    @SerialName("share_url")
    public static /* synthetic */ void getShareUrl$annotations() {
    }

    @SerialName("is_show_message_share")
    public static /* synthetic */ void isShowMessageShare$annotations() {
    }

    @SerialName("is_show_share_tab")
    public static /* synthetic */ void isShowShareTab$annotations() {
    }

    public final String component1() {
        return this.shareStatus;
    }

    public final String component2() {
        return this.shareUrl;
    }

    public final String component3() {
        return this.qrCodeUrl;
    }

    public final boolean component4() {
        return this.isShowShareTab;
    }

    public final boolean component5() {
        return this.isShowMessageShare;
    }

    public final OmniShareInfo copy(String r100, String r101, String r110, boolean r111, boolean r112) {
        return new OmniShareInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniShareInfo) == true) goto L8;
        return false;
    L8:
        OmniShareInfo r101 = (OmniShareInfo) r100;
        if (Intrinsics.areEqual(this.shareStatus, r101.shareStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shareUrl, r101.shareUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.qrCodeUrl, r101.qrCodeUrl) == true) goto L18;
        return false;
    L18:
        if (this.isShowShareTab == r101.isShowShareTab) goto L21;
        return false;
    L21:
        if (this.isShowMessageShare == r101.isShowMessageShare) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.shareStatus;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.shareUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.qrCodeUrl;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        int r109 = 1231;
        if (this.isShowShareTab == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r108 + r110) * 31;
        if (this.isShowMessageShare == true) goto L23;
        r109 = 1237;
    L23:
        return r111 + r109;
    L17:
        r110 = 1237;
        goto L18
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniShareInfo(shareStatus=" + this.shareStatus + ", shareUrl=" + this.shareUrl + ", qrCodeUrl=" + this.qrCodeUrl + ", isShowShareTab=" + this.isShowShareTab + ", isShowMessageShare=" + this.isShowMessageShare + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniShareInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.shareStatus);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.shareUrl);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.qrCodeUrl);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.isShowShareTab);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeBooleanElement(r102, 4, r100.isShowMessageShare);
        return;
    L47:
        return;
    L42:
        if (r100.isShowMessageShare == false) goto L44;
    L33:
        if (r100.isShowShareTab == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.qrCodeUrl != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.shareUrl != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.shareStatus != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniShareInfo(String r100, String r101, String r102, boolean r103, boolean r104) {
        this.shareStatus = r100;
        this.shareUrl = r101;
        this.qrCodeUrl = r102;
        this.isShowShareTab = r103;
        this.isShowMessageShare = r104;
    }

    public /* synthetic */ OmniShareInfo(int r100, String r101, String r102, String r103, boolean r104, boolean r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniShareInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.shareStatus = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.shareUrl = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.qrCodeUrl = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.isShowShareTab = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.isShowMessageShare = false;
        return;
    L23:
        this.isShowMessageShare = r105;
        return;
    L19:
        this.isShowShareTab = r104;
        goto L21
    L15:
        this.qrCodeUrl = r103;
        goto L17
    L11:
        this.shareUrl = r102;
        goto L13
    L7:
        this.shareStatus = r101;
        goto L9
    }

    public /* synthetic */ OmniShareInfo(String r100, String r101, String r102, boolean r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        boolean r108 = false;
    L19:
        if ((r105 & 16) == 0) goto L21;
        boolean r109 = false;
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
