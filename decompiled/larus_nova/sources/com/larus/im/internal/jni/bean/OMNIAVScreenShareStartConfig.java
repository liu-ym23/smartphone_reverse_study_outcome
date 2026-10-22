package com.larus.im.internal.jni.bean;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.keyframes.model.KFImage;
import de9.l1;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u000256B[\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011Ba\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J]\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\t\u0010,\u001a\u00020\nHÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0017R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0017¨\u00067"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVScreenShareStartConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "width", "", "height", "frameRate", "needSwitchCallMode", "", "groupId", "", "bundleId", "mediaType", "Lcom/larus/im/internal/jni/bean/OMNIAVScreenShareMediaType;", "intentContext", "", "<init>", "(IIIZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVScreenShareMediaType;J)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIZLjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVScreenShareMediaType;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidth$annotations", "()V", "getHeight$annotations", "getFrameRate$annotations", "getNeedSwitchCallMode$annotations", "getGroupId$annotations", "getBundleId$annotations", "getMediaType$annotations", "getIntentContext$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVScreenShareStartConfig implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String bundleId;
    public final int frameRate;
    public final String groupId;
    public final int height;
    public final long intentContext;
    public final OMNIAVScreenShareMediaType mediaType;
    public final boolean needSwitchCallMode;
    public final int width;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVScreenShareStartConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVScreenShareStartConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVScreenShareStartConfig> serializer() {
            return OMNIAVScreenShareStartConfig$$serializer.INSTANCE;
        }
    }

    public OMNIAVScreenShareStartConfig() {
        this(0, 0, 0, false, null, null, null, 0, 255, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OMNIAVScreenShareMediaType.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OMNIAVScreenShareStartConfig copy$default(OMNIAVScreenShareStartConfig r110, int r111, int r112, int r113, boolean r114, String r115, String r116, OMNIAVScreenShareMediaType r117, long r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.width;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.height;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.frameRate;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.needSwitchCallMode;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.groupId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.bundleId;
    L27:
        if ((r210 & 64) == 0) goto L29;
        OMNIAVScreenShareMediaType r106 = r110.mediaType;
    L31:
        if ((r210 & 128) == 0) goto L33;
        long r107 = r110.intentContext;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("bundle_id")
    public static /* synthetic */ void getBundleId$annotations() {
    }

    @SerialName(KFImage.FRAME_RATE_JSON_FIELD)
    public static /* synthetic */ void getFrameRate$annotations() {
    }

    @SerialName("group_id")
    public static /* synthetic */ void getGroupId$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("intentContext")
    public static /* synthetic */ void getIntentContext$annotations() {
    }

    @SerialName(a.KEY_MEDIA_TYPE)
    public static /* synthetic */ void getMediaType$annotations() {
    }

    @SerialName("needSwitchCallMode")
    public static /* synthetic */ void getNeedSwitchCallMode$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.frameRate;
    }

    public final boolean component4() {
        return this.needSwitchCallMode;
    }

    public final String component5() {
        return this.groupId;
    }

    public final String component6() {
        return this.bundleId;
    }

    public final OMNIAVScreenShareMediaType component7() {
        return this.mediaType;
    }

    public final long component8() {
        return this.intentContext;
    }

    public final OMNIAVScreenShareStartConfig copy(int r110, int r111, int r112, boolean r113, String r114, String r115, OMNIAVScreenShareMediaType r116, long r117) {
        Intrinsics.checkNotNullParameter(r116, "mediaType");
        return new OMNIAVScreenShareStartConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVScreenShareStartConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVScreenShareStartConfig r101 = (OMNIAVScreenShareStartConfig) r100;
        if (this.width == r101.width) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L15;
        return false;
    L15:
        if (this.frameRate == r101.frameRate) goto L18;
        return false;
    L18:
        if (this.needSwitchCallMode == r101.needSwitchCallMode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bundleId, r101.bundleId) == true) goto L27;
        return false;
    L27:
        if (this.mediaType == r101.mediaType) goto L30;
        return false;
    L30:
        if (this.intentContext == r101.intentContext) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.width * 31) + this.height) * 31) + this.frameRate) * 31;
        if (this.needSwitchCallMode == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.groupId;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.bundleId;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (((r106 + r104) * 31) + this.mediaType.hashCode()) * 31;
        long r109 = this.intentContext;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OMNIAVScreenShareStartConfig(width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + ", needSwitchCallMode=" + this.needSwitchCallMode + ", groupId=" + this.groupId + ", bundleId=" + this.bundleId + ", mediaType=" + this.mediaType + ", intentContext=" + this.intentContext + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new l1()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVScreenShareStartConfig r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r110, 0, r100.width);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r110, 1, r100.height);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeIntElement(r110, 2, r100.frameRate);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r110, 3, r100.needSwitchCallMode);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r110, 4, v2.f520790a, r100.groupId);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r110, 5, v2.f520790a, r100.bundleId);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeSerializableElement(r110, 6, r102[6].getValue(), r100.mediaType);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeLongElement(r110, 7, r100.intentContext);
        return;
    L74:
        return;
    L69:
        if (r100.intentContext == 0) goto L71;
    L60:
        if (r100.mediaType != OMNIAVScreenShareMediaType.VIDEO_ONLY) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.bundleId != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.groupId != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.needSwitchCallMode == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.frameRate != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.height != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.width != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVScreenShareStartConfig(int r100, int r101, int r102, boolean r103, String r104, String r105, OMNIAVScreenShareMediaType r106, long r107) {
        Intrinsics.checkNotNullParameter(r106, "mediaType");
        this.width = r100;
        this.height = r101;
        this.frameRate = r102;
        this.needSwitchCallMode = r103;
        this.groupId = r104;
        this.bundleId = r105;
        this.mediaType = r106;
        this.intentContext = r107;
    }

    public /* synthetic */ OMNIAVScreenShareStartConfig(int r100, int r101, int r102, int r103, boolean r104, String r105, String r106, OMNIAVScreenShareMediaType r110, long r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVScreenShareStartConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.width = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.height = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.frameRate = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.needSwitchCallMode = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.groupId = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.bundleId = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.mediaType = OMNIAVScreenShareMediaType.VIDEO_ONLY;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.intentContext = 0;
        return;
    L35:
        this.intentContext = r111;
        return;
    L31:
        this.mediaType = r110;
        goto L33
    L27:
        this.bundleId = r106;
        goto L29
    L23:
        this.groupId = r105;
        goto L25
    L19:
        this.needSwitchCallMode = r104;
        goto L21
    L15:
        this.frameRate = r103;
        goto L17
    L11:
        this.height = r102;
        goto L13
    L7:
        this.width = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVScreenShareStartConfig(int r110, int r111, int r112, boolean r113, String r114, String r115, OMNIAVScreenShareMediaType r116, long r117, int r210, DefaultConstructorMarker r211) {
        boolean r100 = false;
        if ((r210 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r210 & 8) != 0) goto L18;
        r100 = r113;
    L18:
        String r104 = null;
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) != 0) goto L27;
        r104 = r115;
    L27:
        if ((r210 & 64) == 0) goto L29;
        OMNIAVScreenShareMediaType r106 = OMNIAVScreenShareMediaType.VIDEO_ONLY;
    L31:
        if ((r210 & 128) == 0) goto L33;
        long r107 = 0;
    L34:
        this(r101, r102, r103, r100, r105, r104, r106, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L21:
        r105 = r114;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
