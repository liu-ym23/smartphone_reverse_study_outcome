package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002%&B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB3\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniLikeInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "showLikeButton", "", "likeStatus", "likeCount", "", "<init>", "(ZZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShowLikeButton$annotations", "()V", "getLikeStatus$annotations", "getLikeCount$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniLikeInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long likeCount;
    public final boolean likeStatus;
    public final boolean showLikeButton;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniLikeInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniLikeInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniLikeInfo> serializer() {
            return OmniLikeInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniLikeInfo() {
        this(false, false, 0, 7, null);
    }

    public static /* synthetic */ OmniLikeInfo copy$default(OmniLikeInfo r100, boolean r101, boolean r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.showLikeButton;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.likeStatus;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.likeCount;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("like_count")
    public static /* synthetic */ void getLikeCount$annotations() {
    }

    @SerialName("like_status")
    public static /* synthetic */ void getLikeStatus$annotations() {
    }

    @SerialName("show_like_button")
    public static /* synthetic */ void getShowLikeButton$annotations() {
    }

    public final boolean component1() {
        return this.showLikeButton;
    }

    public final boolean component2() {
        return this.likeStatus;
    }

    public final long component3() {
        return this.likeCount;
    }

    public final OmniLikeInfo copy(boolean r100, boolean r101, long r102) {
        return new OmniLikeInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniLikeInfo) == true) goto L8;
        return false;
    L8:
        OmniLikeInfo r101 = (OmniLikeInfo) r100;
        if (this.showLikeButton == r101.showLikeButton) goto L12;
        return false;
    L12:
        if (this.likeStatus == r101.likeStatus) goto L15;
        return false;
    L15:
        if (this.likeCount == r101.likeCount) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.showLikeButton == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.likeStatus == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.likeCount;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniLikeInfo(showLikeButton=" + this.showLikeButton + ", likeStatus=" + this.likeStatus + ", likeCount=" + this.likeCount + ')';
    }

    public OmniLikeInfo(boolean r100, boolean r101, long r102) {
        this.showLikeButton = r100;
        this.likeStatus = r101;
        this.likeCount = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniLikeInfo r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeBooleanElement(r110, 0, r100.showLikeButton);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeBooleanElement(r110, 1, r100.likeStatus);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        r102 = true;
    L26:
        if (r102 == false) goto L29;
        r101.encodeLongElement(r110, 2, r100.likeCount);
        return;
    L29:
        return;
    L24:
        if (r100.likeCount == 0) goto L26;
    L15:
        if (r100.likeStatus == true) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.showLikeButton == true) goto L4;
        r103 = false;
        goto L9
    }

    public /* synthetic */ OmniLikeInfo(int r100, boolean r101, boolean r102, long r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniLikeInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.showLikeButton = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.likeStatus = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.likeCount = 0;
        return;
    L15:
        this.likeCount = r103;
        return;
    L11:
        this.likeStatus = r102;
        goto L13
    L7:
        this.showLikeButton = r101;
        goto L9
    }

    public /* synthetic */ OmniLikeInfo(boolean r100, boolean r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
