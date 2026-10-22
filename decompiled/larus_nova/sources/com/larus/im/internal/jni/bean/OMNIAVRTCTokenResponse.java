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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00060\u0001j\u0002`\u0002:\u0002#$B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "tokenInfo", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenInfo;", "meta", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenMeta;", "<init>", "(Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenInfo;Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenMeta;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OMNIAVRTCTokenInfo;Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenMeta;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTokenInfo$annotations", "()V", "getMeta$annotations", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVRTCTokenResponse implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OMNIAVRTCTokenMeta meta;
    public final OMNIAVRTCTokenInfo tokenInfo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVRTCTokenResponse;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVRTCTokenResponse> serializer() {
            return OMNIAVRTCTokenResponse$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OMNIAVRTCTokenResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OMNIAVRTCTokenResponse copy$default(OMNIAVRTCTokenResponse r100, OMNIAVRTCTokenInfo r101, OMNIAVRTCTokenMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tokenInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.meta;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("meta")
    public static /* synthetic */ void getMeta$annotations() {
    }

    @SerialName("tokenInfo")
    public static /* synthetic */ void getTokenInfo$annotations() {
    }

    public final OMNIAVRTCTokenInfo component1() {
        return this.tokenInfo;
    }

    public final OMNIAVRTCTokenMeta component2() {
        return this.meta;
    }

    public final OMNIAVRTCTokenResponse copy(OMNIAVRTCTokenInfo r100, OMNIAVRTCTokenMeta r101) {
        return new OMNIAVRTCTokenResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVRTCTokenResponse) == true) goto L8;
        return false;
    L8:
        OMNIAVRTCTokenResponse r101 = (OMNIAVRTCTokenResponse) r100;
        if (Intrinsics.areEqual(this.tokenInfo, r101.tokenInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        OMNIAVRTCTokenInfo r100 = this.tokenInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OMNIAVRTCTokenMeta r104 = this.meta;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVRTCTokenResponse(tokenInfo=" + this.tokenInfo + ", meta=" + this.meta + ')';
    }

    public OMNIAVRTCTokenResponse(OMNIAVRTCTokenInfo r100, OMNIAVRTCTokenMeta r101) {
        this.tokenInfo = r100;
        this.meta = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVRTCTokenResponse r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, OMNIAVRTCTokenInfo$$serializer.INSTANCE, r100.tokenInfo);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, OMNIAVRTCTokenMeta$$serializer.INSTANCE, r100.meta);
        return;
    L20:
        return;
    L15:
        if (r100.meta == null) goto L17;
    L6:
        if (r100.tokenInfo != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OMNIAVRTCTokenResponse(int r100, OMNIAVRTCTokenInfo r101, OMNIAVRTCTokenMeta r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVRTCTokenResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.tokenInfo = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.meta = null;
        return;
    L11:
        this.meta = r102;
        return;
    L7:
        this.tokenInfo = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVRTCTokenResponse(OMNIAVRTCTokenInfo r100, OMNIAVRTCTokenMeta r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
