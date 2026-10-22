package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.s2;
import de9.t2;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002%&B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoSessionStarted;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "screenStatus", "Lcom/larus/im/internal/jni/bean/OMNIVideoSourceStatus;", "cameraStatus", "dialogMsg", "", "<init>", "(Lcom/larus/im/internal/jni/bean/OMNIVideoSourceStatus;Lcom/larus/im/internal/jni/bean/OMNIVideoSourceStatus;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OMNIVideoSourceStatus;Lcom/larus/im/internal/jni/bean/OMNIVideoSourceStatus;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getScreenStatus$annotations", "()V", "getCameraStatus$annotations", "getDialogMsg$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVVideoSessionStarted implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final OMNIVideoSourceStatus cameraStatus;
    public final String dialogMsg;
    public final OMNIVideoSourceStatus screenStatus;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoSessionStarted$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVVideoSessionStarted;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVVideoSessionStarted> serializer() {
            return OMNIAVVideoSessionStarted$$serializer.INSTANCE;
        }
    }

    public OMNIAVVideoSessionStarted() {
        this(null, null, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OMNIVideoSourceStatus.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return OMNIVideoSourceStatus.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ OMNIAVVideoSessionStarted copy$default(OMNIAVVideoSessionStarted r100, OMNIVideoSourceStatus r101, OMNIVideoSourceStatus r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.screenStatus;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.cameraStatus;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.dialogMsg;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("camera_status")
    public static /* synthetic */ void getCameraStatus$annotations() {
    }

    @SerialName("dialog_msg")
    public static /* synthetic */ void getDialogMsg$annotations() {
    }

    @SerialName("screen_status")
    public static /* synthetic */ void getScreenStatus$annotations() {
    }

    public final OMNIVideoSourceStatus component1() {
        return this.screenStatus;
    }

    public final OMNIVideoSourceStatus component2() {
        return this.cameraStatus;
    }

    public final String component3() {
        return this.dialogMsg;
    }

    public final OMNIAVVideoSessionStarted copy(OMNIVideoSourceStatus r100, OMNIVideoSourceStatus r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "screenStatus");
        Intrinsics.checkNotNullParameter(r101, "cameraStatus");
        return new OMNIAVVideoSessionStarted(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVVideoSessionStarted) == true) goto L8;
        return false;
    L8:
        OMNIAVVideoSessionStarted r101 = (OMNIAVVideoSessionStarted) r100;
        if (this.screenStatus == r101.screenStatus) goto L12;
        return false;
    L12:
        if (this.cameraStatus == r101.cameraStatus) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dialogMsg, r101.dialogMsg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.screenStatus.hashCode() * 31) + this.cameraStatus.hashCode()) * 31;
        String r101 = this.dialogMsg;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OMNIAVVideoSessionStarted(screenStatus=" + this.screenStatus + ", cameraStatus=" + this.cameraStatus + ", dialogMsg=" + this.dialogMsg + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{LazyKt.lazy(r100, new s2()), LazyKt.lazy(r100, new t2()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OMNIAVVideoSessionStarted(OMNIVideoSourceStatus r100, OMNIVideoSourceStatus r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "screenStatus");
        Intrinsics.checkNotNullParameter(r101, "cameraStatus");
        this.screenStatus = r100;
        this.cameraStatus = r101;
        this.dialogMsg = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVVideoSessionStarted r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeSerializableElement(r102, 0, r103[0].getValue(), r100.screenStatus);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeSerializableElement(r102, 1, r103[1].getValue(), r100.cameraStatus);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r104 = true;
    L26:
        if (r104 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.dialogMsg);
        return;
    L29:
        return;
    L24:
        if (r100.dialogMsg == null) goto L26;
    L15:
        if (r100.cameraStatus != OMNIVideoSourceStatus.ENABLE) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.screenStatus != OMNIVideoSourceStatus.ENABLE) goto L4;
        r105 = false;
        goto L9
    }

    public /* synthetic */ OMNIAVVideoSessionStarted(int r100, OMNIVideoSourceStatus r101, OMNIVideoSourceStatus r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVVideoSessionStarted$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = OMNIVideoSourceStatus.ENABLE;
    L7:
        this.screenStatus = r101;
        if ((r100 & 2) != 0) goto L10;
        this.cameraStatus = OMNIVideoSourceStatus.ENABLE;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.dialogMsg = null;
        return;
    L14:
        this.dialogMsg = r103;
        return;
    L10:
        this.cameraStatus = r102;
        goto L12
    }

    public /* synthetic */ OMNIAVVideoSessionStarted(OMNIVideoSourceStatus r100, OMNIVideoSourceStatus r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = OMNIVideoSourceStatus.ENABLE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = OMNIVideoSourceStatus.ENABLE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
