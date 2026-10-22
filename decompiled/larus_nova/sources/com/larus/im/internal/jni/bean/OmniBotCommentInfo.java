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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002\"#B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB+\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000f¨\u0006$"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotCommentInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "showCommentButton", "", "commentCount", "", "<init>", "(ZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShowCommentButton$annotations", "()V", "getCommentCount$annotations", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotCommentInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long commentCount;
    public final boolean showCommentButton;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotCommentInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotCommentInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotCommentInfo> serializer() {
            return OmniBotCommentInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniBotCommentInfo() {
        this(false, 0, 3, null);
    }

    public static /* synthetic */ OmniBotCommentInfo copy$default(OmniBotCommentInfo r100, boolean r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.showCommentButton;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.commentCount;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("comment_count")
    public static /* synthetic */ void getCommentCount$annotations() {
    }

    @SerialName("show_comment_button")
    public static /* synthetic */ void getShowCommentButton$annotations() {
    }

    public final boolean component1() {
        return this.showCommentButton;
    }

    public final long component2() {
        return this.commentCount;
    }

    public final OmniBotCommentInfo copy(boolean r100, long r101) {
        return new OmniBotCommentInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotCommentInfo) == true) goto L8;
        return false;
    L8:
        OmniBotCommentInfo r101 = (OmniBotCommentInfo) r100;
        if (this.showCommentButton == r101.showCommentButton) goto L12;
        return false;
    L12:
        if (this.commentCount == r101.commentCount) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.showCommentButton == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.commentCount;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniBotCommentInfo(showCommentButton=" + this.showCommentButton + ", commentCount=" + this.commentCount + ')';
    }

    public OmniBotCommentInfo(boolean r100, long r101) {
        this.showCommentButton = r100;
        this.commentCount = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotCommentInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.showCommentButton);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeLongElement(r102, 1, r100.commentCount);
        return;
    L20:
        return;
    L15:
        if (r100.commentCount == 0) goto L17;
    L6:
        if (r100.showCommentButton == true) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniBotCommentInfo(int r100, boolean r101, long r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotCommentInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.showCommentButton = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.commentCount = 0;
        return;
    L11:
        this.commentCount = r102;
        return;
    L7:
        this.showCommentButton = r101;
        goto L9
    }

    public /* synthetic */ OmniBotCommentInfo(boolean r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
