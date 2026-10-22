package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.ttvideoengine.model.SubInfo;
import de9.x0;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002&'B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006("}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVImageBaseInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", SubInfo.KEY_FORMAT, "Lcom/larus/im/internal/jni/bean/OMNIAVImageFormat;", "width", "", "height", "<init>", "(Lcom/larus/im/internal/jni/bean/OMNIAVImageFormat;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OMNIAVImageFormat;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFormat$annotations", "()V", "getWidth$annotations", "getHeight$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVImageBaseInfo implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final OMNIAVImageFormat format;
    public final long height;
    public final long width;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVImageBaseInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVImageBaseInfo;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVImageBaseInfo> serializer() {
            return OMNIAVImageBaseInfo$$serializer.INSTANCE;
        }
    }

    public OMNIAVImageBaseInfo() {
        this(null, 0, 0, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OMNIAVImageFormat.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OMNIAVImageBaseInfo copy$default(OMNIAVImageBaseInfo r100, OMNIAVImageFormat r101, long r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.format;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        long r106 = r102;
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.height;
    L11:
        OMNIAVImageFormat r107 = r101;
        return r100.copy(r107, r106, r103);
    }

    @SerialName(SubInfo.KEY_FORMAT)
    public static /* synthetic */ void getFormat$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final OMNIAVImageFormat component1() {
        return this.format;
    }

    public final long component2() {
        return this.width;
    }

    public final long component3() {
        return this.height;
    }

    public final OMNIAVImageBaseInfo copy(OMNIAVImageFormat r100, long r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        return new OMNIAVImageBaseInfo(r100, r101, r110);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVImageBaseInfo) == true) goto L8;
        return false;
    L8:
        OMNIAVImageBaseInfo r101 = (OMNIAVImageBaseInfo) r100;
        if (this.format == r101.format) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L15;
        return false;
    L15:
        if (this.height == r101.height) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.format.hashCode() * 31;
        long r101 = this.width;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.height;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public String toString() {
        return "OMNIAVImageBaseInfo(format=" + this.format + ", width=" + this.width + ", height=" + this.height + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new x0()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OMNIAVImageBaseInfo(OMNIAVImageFormat r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        this.format = r100;
        this.width = r101;
        this.height = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVImageBaseInfo r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeSerializableElement(r110, 0, r102[0].getValue(), r100.format);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.width);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeLongElement(r110, 2, r100.height);
        return;
    L29:
        return;
    L24:
        if (r100.height == 0) goto L26;
    L15:
        if (r100.width != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.format != OMNIAVImageFormat.FILE_FORMAT_UNSPECIFIED) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OMNIAVImageBaseInfo(int r100, OMNIAVImageFormat r101, long r102, long r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVImageBaseInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = OMNIAVImageFormat.FILE_FORMAT_UNSPECIFIED;
    L7:
        this.format = r101;
        if ((r100 & 2) != 0) goto L10;
        this.width = 0;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.height = 0;
        return;
    L14:
        this.height = r103;
        return;
    L10:
        this.width = r102;
        goto L12
    }

    public /* synthetic */ OMNIAVImageBaseInfo(OMNIAVImageFormat r100, long r101, long r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = OMNIAVImageFormat.FILE_FORMAT_UNSPECIFIED;
    L6:
        if ((r110 & 2) == 0) goto L8;
        long r103 = 0;
    L10:
        if ((r110 & 4) == 0) goto L12;
        long r112 = 0;
    L13:
        this(r100, r103, r112);
        return;
    L12:
        r112 = r102;
        goto L13
    L8:
        r103 = r101;
        goto L10
    }
}
