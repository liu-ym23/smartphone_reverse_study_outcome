package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.ha;
import java.util.List;
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
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002\"#B#\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB3\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J%\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010¨\u0006$"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRegenMsgGroup;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "msgIdList", "", "", "isVisible", "", "<init>", "(Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMsgIdList$annotations", "()V", "isVisible$annotations", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniRegenMsgGroup implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final boolean isVisible;
    public final List<String> msgIdList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRegenMsgGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniRegenMsgGroup;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniRegenMsgGroup> serializer() {
            return OmniRegenMsgGroup$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OmniRegenMsgGroup() {
        List r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniRegenMsgGroup copy$default(OmniRegenMsgGroup r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.msgIdList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isVisible;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("msg_id_list")
    public static /* synthetic */ void getMsgIdList$annotations() {
    }

    @SerialName("is_visible")
    public static /* synthetic */ void isVisible$annotations() {
    }

    public final List<String> component1() {
        return this.msgIdList;
    }

    public final boolean component2() {
        return this.isVisible;
    }

    public final OmniRegenMsgGroup copy(List<String> r100, boolean r101) {
        return new OmniRegenMsgGroup(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniRegenMsgGroup) == true) goto L8;
        return false;
    L8:
        OmniRegenMsgGroup r101 = (OmniRegenMsgGroup) r100;
        if (Intrinsics.areEqual(this.msgIdList, r101.msgIdList) == true) goto L12;
        return false;
    L12:
        if (this.isVisible == r101.isVisible) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.msgIdList;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.isVisible == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniRegenMsgGroup(msgIdList=" + this.msgIdList + ", isVisible=" + this.isVisible + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ha()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OmniRegenMsgGroup(List<String> r100, boolean r101) {
        this.msgIdList = r100;
        this.isVisible = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniRegenMsgGroup r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.msgIdList);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r104 = true;
    L17:
        if (r104 == false) goto L20;
        r101.encodeBooleanElement(r102, 1, r100.isVisible);
        return;
    L20:
        return;
    L15:
        if (r100.isVisible == false) goto L17;
    L6:
        if (r100.msgIdList != null) goto L4;
        r105 = false;
        goto L9
    }

    public /* synthetic */ OmniRegenMsgGroup(int r100, List r101, boolean r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniRegenMsgGroup$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.msgIdList = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.isVisible = false;
        return;
    L11:
        this.isVisible = r102;
        return;
    L7:
        this.msgIdList = r101;
        goto L9
    }

    public /* synthetic */ OmniRegenMsgGroup(List r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
