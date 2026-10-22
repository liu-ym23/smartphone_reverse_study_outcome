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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00060\u0001j\u0002`\u0002:\u0002\u001f B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetThreadResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "thread", "Lcom/larus/im/internal/jni/bean/OmniThread;", "<init>", "(Lcom/larus/im/internal/jni/bean/OmniThread;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OmniThread;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThread$annotations", "()V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetThreadResponse implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OmniThread thread;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetThreadResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetThreadResponse;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetThreadResponse> serializer() {
            return OmniGetThreadResponse$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OmniGetThreadResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OmniGetThreadResponse copy$default(OmniGetThreadResponse r100, OmniThread r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.thread;
    L6:
        return r100.copy(r101);
    }

    @SerialName("thread")
    public static /* synthetic */ void getThread$annotations() {
    }

    public final OmniThread component1() {
        return this.thread;
    }

    public final OmniGetThreadResponse copy(OmniThread r100) {
        return new OmniGetThreadResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetThreadResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.thread, ((OmniGetThreadResponse) r100).thread) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        OmniThread r100 = this.thread;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "OmniGetThreadResponse(thread=" + this.thread + ')';
    }

    public OmniGetThreadResponse(OmniThread r100) {
        this.thread = r100;
    }

    public /* synthetic */ OmniGetThreadResponse(int r100, OmniThread r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetThreadResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.thread = null;
        return;
    L7:
        this.thread = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetThreadResponse r100, muc.d r101, f r102) {
        boolean r103 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, OmniThread$$serializer.INSTANCE, r100.thread);
        return;
    L12:
        return;
    L6:
        if (r100.thread != null) goto L9;
        r103 = false;
        goto L9
    }

    public /* synthetic */ OmniGetThreadResponse(OmniThread r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
