package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB5\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/GetWebpageRequestPayload;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "url", "", "useCookie", "", "maxBytes", "", "<init>", "(Ljava/lang/String;ZI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUseCookie$annotations", "getMaxBytes$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class GetWebpageRequestPayload implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int maxBytes;
    public final String url;
    public final boolean useCookie;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/GetWebpageRequestPayload$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/GetWebpageRequestPayload;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<GetWebpageRequestPayload> serializer() {
            return GetWebpageRequestPayload$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GetWebpageRequestPayload() {
        this(null, false, 0, 7, null);
    }

    public static /* synthetic */ GetWebpageRequestPayload copy$default(GetWebpageRequestPayload r100, String r101, boolean r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.useCookie;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.maxBytes;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName(DownloadSettingKeys.DownloadTaskParam.MAX_BYTES)
    public static /* synthetic */ void getMaxBytes$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("use_cookie")
    public static /* synthetic */ void getUseCookie$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final boolean component2() {
        return this.useCookie;
    }

    public final int component3() {
        return this.maxBytes;
    }

    public final GetWebpageRequestPayload copy(String r100, boolean r101, int r102) {
        return new GetWebpageRequestPayload(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetWebpageRequestPayload) == true) goto L8;
        return false;
    L8:
        GetWebpageRequestPayload r101 = (GetWebpageRequestPayload) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.useCookie == r101.useCookie) goto L15;
        return false;
    L15:
        if (this.maxBytes == r101.maxBytes) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.useCookie == false) goto L9;
        int r103 = 1231;
    L11:
        return ((r102 + r103) * 31) + this.maxBytes;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetWebpageRequestPayload(url=" + this.url + ", useCookie=" + this.useCookie + ", maxBytes=" + this.maxBytes + ')';
    }

    public GetWebpageRequestPayload(String r100, boolean r101, int r102) {
        this.url = r100;
        this.useCookie = r101;
        this.maxBytes = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(GetWebpageRequestPayload r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.url);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.useCookie);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeIntElement(r102, 2, r100.maxBytes);
        return;
    L29:
        return;
    L24:
        if (r100.maxBytes == 0) goto L26;
    L15:
        if (r100.useCookie == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.url != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ GetWebpageRequestPayload(int r100, String r101, boolean r102, int r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, GetWebpageRequestPayload$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.url = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.useCookie = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.maxBytes = 0;
        return;
    L15:
        this.maxBytes = r103;
        return;
    L11:
        this.useCookie = r102;
        goto L13
    L7:
        this.url = r101;
        goto L9
    }

    public /* synthetic */ GetWebpageRequestPayload(String r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
