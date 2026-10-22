package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.v6;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00060\u0001j\u0002`\u0002:\u0002\u001f B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "scene", "Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainScene;", "<init>", "(Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainScene;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OmniFetchCmdChainScene;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getScene$annotations", "()V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniFetchCmdChainRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final OmniFetchCmdChainScene scene;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniFetchCmdChainRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniFetchCmdChainRequest> serializer() {
            return OmniFetchCmdChainRequest$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OmniFetchCmdChainRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniFetchCmdChainScene.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniFetchCmdChainRequest copy$default(OmniFetchCmdChainRequest r100, OmniFetchCmdChainScene r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        return r100.copy(r101);
    }

    @SerialName("scene")
    public static /* synthetic */ void getScene$annotations() {
    }

    public final OmniFetchCmdChainScene component1() {
        return this.scene;
    }

    public final OmniFetchCmdChainRequest copy(OmniFetchCmdChainScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return new OmniFetchCmdChainRequest(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniFetchCmdChainRequest) == true) goto L9;
        return false;
    L9:
        if (this.scene == ((OmniFetchCmdChainRequest) r100).scene) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.scene.hashCode();
    }

    public String toString() {
        return "OmniFetchCmdChainRequest(scene=" + this.scene + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new v6())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OmniFetchCmdChainRequest(OmniFetchCmdChainScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.scene = r100;
    }

    public /* synthetic */ OmniFetchCmdChainRequest(int r100, OmniFetchCmdChainScene r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniFetchCmdChainRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.scene = OmniFetchCmdChainScene.COLD_LAUNCH;
        return;
    L7:
        this.scene = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniFetchCmdChainRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r104 == false) goto L12;
        r101.encodeSerializableElement(r102, 0, r103[0].getValue(), r100.scene);
        return;
    L12:
        return;
    L6:
        if (r100.scene != OmniFetchCmdChainScene.COLD_LAUNCH) goto L9;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniFetchCmdChainRequest(OmniFetchCmdChainScene r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = OmniFetchCmdChainScene.COLD_LAUNCH;
    L5:
        this(r100);
    }
}
