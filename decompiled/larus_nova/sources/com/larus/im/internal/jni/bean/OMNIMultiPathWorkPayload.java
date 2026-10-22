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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u0002:\u0002\u001e\u001fB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIMultiPathWorkPayload;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "multiPathLinkMode", "", "<init>", "(I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMultiPathLinkMode$annotations", "()V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIMultiPathWorkPayload implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int multiPathLinkMode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIMultiPathWorkPayload$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIMultiPathWorkPayload;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIMultiPathWorkPayload> serializer() {
            return OMNIMultiPathWorkPayload$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIMultiPathWorkPayload() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ OMNIMultiPathWorkPayload copy$default(OMNIMultiPathWorkPayload r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.multiPathLinkMode;
    L6:
        return r100.copy(r101);
    }

    @SerialName("multiPathLinkMode")
    public static /* synthetic */ void getMultiPathLinkMode$annotations() {
    }

    public final int component1() {
        return this.multiPathLinkMode;
    }

    public final OMNIMultiPathWorkPayload copy(int r100) {
        return new OMNIMultiPathWorkPayload(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIMultiPathWorkPayload) == true) goto L9;
        return false;
    L9:
        if (this.multiPathLinkMode == ((OMNIMultiPathWorkPayload) r100).multiPathLinkMode) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.multiPathLinkMode;
    }

    public String toString() {
        return "OMNIMultiPathWorkPayload(multiPathLinkMode=" + this.multiPathLinkMode + ')';
    }

    public OMNIMultiPathWorkPayload(int r100) {
        this.multiPathLinkMode = r100;
    }

    public /* synthetic */ OMNIMultiPathWorkPayload(int r100, int r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIMultiPathWorkPayload$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.multiPathLinkMode = 0;
        return;
    L7:
        this.multiPathLinkMode = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIMultiPathWorkPayload r100, muc.d r101, f r102) {
        boolean r103 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r103 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.multiPathLinkMode);
        return;
    L12:
        return;
    L6:
        if (r100.multiPathLinkMode != 0) goto L9;
        r103 = false;
        goto L9
    }

    public /* synthetic */ OMNIMultiPathWorkPayload(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
