package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import de9.da;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002%&B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPullAIJobChainResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "fetchedCount", "", "changedJobIds", "", "", EffectConfiguration.KEY_CURSOR, "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFetchedCount$annotations", "()V", "getChangedJobIds$annotations", "getCursor$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniPullAIJobChainResponse implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final List<String> changedJobIds;
    public final String cursor;
    public final int fetchedCount;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPullAIJobChainResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniPullAIJobChainResponse;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniPullAIJobChainResponse> serializer() {
            return OmniPullAIJobChainResponse$$serializer.INSTANCE;
        }
    }

    public OmniPullAIJobChainResponse() {
        this(0, null, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniPullAIJobChainResponse copy$default(OmniPullAIJobChainResponse r100, int r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.fetchedCount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.changedJobIds;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.cursor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("changed_job_ids")
    public static /* synthetic */ void getChangedJobIds$annotations() {
    }

    @SerialName(EffectConfiguration.KEY_CURSOR)
    public static /* synthetic */ void getCursor$annotations() {
    }

    @SerialName("fetched_count")
    public static /* synthetic */ void getFetchedCount$annotations() {
    }

    public final int component1() {
        return this.fetchedCount;
    }

    public final List<String> component2() {
        return this.changedJobIds;
    }

    public final String component3() {
        return this.cursor;
    }

    public final OmniPullAIJobChainResponse copy(int r100, List<String> r101, String r102) {
        return new OmniPullAIJobChainResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniPullAIJobChainResponse) == true) goto L8;
        return false;
    L8:
        OmniPullAIJobChainResponse r101 = (OmniPullAIJobChainResponse) r100;
        if (this.fetchedCount == r101.fetchedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.changedJobIds, r101.changedJobIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.fetchedCount * 31;
        List<String> r101 = this.changedJobIds;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.cursor;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniPullAIJobChainResponse(fetchedCount=" + this.fetchedCount + ", changedJobIds=" + this.changedJobIds + ", cursor=" + this.cursor + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new da()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OmniPullAIJobChainResponse(int r100, List<String> r101, String r102) {
        this.fetchedCount = r100;
        this.changedJobIds = r101;
        this.cursor = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniPullAIJobChainResponse r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.fetchedCount);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.changedJobIds);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r104 = true;
    L26:
        if (r104 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.cursor);
        return;
    L29:
        return;
    L24:
        if (r100.cursor == null) goto L26;
    L15:
        if (r100.changedJobIds != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.fetchedCount != 0) goto L4;
        r105 = false;
        goto L9
    }

    public /* synthetic */ OmniPullAIJobChainResponse(int r100, int r101, List r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniPullAIJobChainResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.fetchedCount = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.changedJobIds = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.cursor = null;
        return;
    L15:
        this.cursor = r103;
        return;
    L11:
        this.changedJobIds = r102;
        goto L13
    L7:
        this.fetchedCount = r101;
        goto L9
    }

    public /* synthetic */ OmniPullAIJobChainResponse(int r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
