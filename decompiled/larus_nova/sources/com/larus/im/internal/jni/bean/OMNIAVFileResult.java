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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVFileResult;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "uploadId", "", "uri", "url", "bizInfo", "Lcom/larus/im/internal/jni/bean/OMNIAVFileResultBizInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVFileResultBizInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVFileResultBizInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUploadId$annotations", "()V", "getUri$annotations", "getUrl$annotations", "getBizInfo$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVFileResult implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OMNIAVFileResultBizInfo bizInfo;
    public final String uploadId;
    public final String uri;
    public final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVFileResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVFileResult;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVFileResult> serializer() {
            return OMNIAVFileResult$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVFileResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OMNIAVFileResult copy$default(OMNIAVFileResult r100, String r101, String r102, String r103, OMNIAVFileResultBizInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.uploadId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.uri;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.url;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bizInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("biz_info")
    public static /* synthetic */ void getBizInfo$annotations() {
    }

    @SerialName("upload_id")
    public static /* synthetic */ void getUploadId$annotations() {
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.uploadId;
    }

    public final String component2() {
        return this.uri;
    }

    public final String component3() {
        return this.url;
    }

    public final OMNIAVFileResultBizInfo component4() {
        return this.bizInfo;
    }

    public final OMNIAVFileResult copy(String r100, String r101, String r102, OMNIAVFileResultBizInfo r103) {
        return new OMNIAVFileResult(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVFileResult) == true) goto L8;
        return false;
    L8:
        OMNIAVFileResult r101 = (OMNIAVFileResult) r100;
        if (Intrinsics.areEqual(this.uploadId, r101.uploadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bizInfo, r101.bizInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.uploadId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.url;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        OMNIAVFileResultBizInfo r110 = this.bizInfo;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "OMNIAVFileResult(uploadId=" + this.uploadId + ", uri=" + this.uri + ", url=" + this.url + ", bizInfo=" + this.bizInfo + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVFileResult r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.uploadId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.uri);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.url);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, OMNIAVFileResultBizInfo$$serializer.INSTANCE, r100.bizInfo);
        return;
    L38:
        return;
    L33:
        if (r100.bizInfo == null) goto L35;
    L24:
        if (r100.url != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.uri != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.uploadId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVFileResult(String r100, String r101, String r102, OMNIAVFileResultBizInfo r103) {
        this.uploadId = r100;
        this.uri = r101;
        this.url = r102;
        this.bizInfo = r103;
    }

    public /* synthetic */ OMNIAVFileResult(int r100, String r101, String r102, String r103, OMNIAVFileResultBizInfo r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVFileResult$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.uploadId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.uri = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.url = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.bizInfo = null;
        return;
    L19:
        this.bizInfo = r104;
        return;
    L15:
        this.url = r103;
        goto L17
    L11:
        this.uri = r102;
        goto L13
    L7:
        this.uploadId = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVFileResult(String r100, String r101, String r102, OMNIAVFileResultBizInfo r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
