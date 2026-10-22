package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import yc9.i0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/larus/im/bean/message/MessageTrackContext;", "", "businessSendStartTimestamp", "", "commonTags", "", "", "<init>", "(JLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBusinessSendStartTimestamp$annotations", "()V", "getBusinessSendStartTimestamp", "()J", "getCommonTags$annotations", "getCommonTags", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class MessageTrackContext {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final long businessSendStartTimestamp;
    private final Map<String, String> commonTags;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MessageTrackContext> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346680a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346681b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346681b;
        }

        static {
            a r100 = new a();
            f346680a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.MessageTrackContext", r100, 2);
            r101.j("business_send_start_timestamp", false);
            r101.j("common_tags", true);
            f346681b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{g1.f520681a, MessageTrackContext.access$get$childSerializers$cp()[1].getValue()};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346681b;
            muc.c r101 = r110.beginStructure(r100);
            Lazy[] r102 = MessageTrackContext.access$get$childSerializers$cp();
            Map r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            long r104 = r101.decodeLongElement(r100, 0);
            Map r111 = (Map) r101.decodeSerializableElement(r100, 1, (juc.c) r102[1].getValue(), null);
            long r112 = r104;
            int r113 = 3;
        L17:
            r101.endStructure(r100);
            return new MessageTrackContext(r113, r112, r111, null);
        L5:
            long r105 = 0;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r114 = r101.decodeElementIndex(r100);
            if (r114 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r114 != 0) goto L10;
            r105 = r101.decodeLongElement(r100, 0);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r114 != 1) goto L13;
            r103 = (Map) r101.decodeSerializableElement(r100, 1, (juc.c) r102[1].getValue(), r103);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r114);
        L16:
            r113 = r106;
            r111 = r103;
            r112 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MessageTrackContext r102 = (MessageTrackContext) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346681b;
            muc.d r104 = r100.beginStructure(r103);
            MessageTrackContext.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<MessageTrackContext> serializer() {
            return a.f346680a;
        }
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageTrackContext copy$default(MessageTrackContext r100, long r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.businessSendStartTimestamp;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.commonTags;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("business_send_start_timestamp")
    public static /* synthetic */ void getBusinessSendStartTimestamp$annotations() {
    }

    @SerialName("common_tags")
    public static /* synthetic */ void getCommonTags$annotations() {
    }

    public final long component1() {
        return this.businessSendStartTimestamp;
    }

    public final Map<String, String> component2() {
        return this.commonTags;
    }

    public final MessageTrackContext copy(long r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "commonTags");
        return new MessageTrackContext(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageTrackContext) == true) goto L8;
        return false;
    L8:
        MessageTrackContext r101 = (MessageTrackContext) r100;
        if (this.businessSendStartTimestamp == r101.businessSendStartTimestamp) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commonTags, r101.commonTags) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.businessSendStartTimestamp;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.commonTags.hashCode();
    }

    public String toString() {
        return "MessageTrackContext(businessSendStartTimestamp=" + this.businessSendStartTimestamp + ", commonTags=" + this.commonTags + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new i0())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final long getBusinessSendStartTimestamp() {
        return this.businessSendStartTimestamp;
    }

    public final Map<String, String> getCommonTags() {
        return this.commonTags;
    }

    public MessageTrackContext(long r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "commonTags");
        this.businessSendStartTimestamp = r100;
        this.commonTags = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(MessageTrackContext r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        r101.encodeLongElement(r102, 0, r100.businessSendStartTimestamp);
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L6;
    L4:
        r104 = true;
    L8:
        if (r104 == false) goto L11;
        r101.encodeSerializableElement(r102, 1, r103[1].getValue(), r100.commonTags);
        return;
    L11:
        return;
    L6:
        if (Intrinsics.areEqual(r100.commonTags, MapsKt.emptyMap()) == true) goto L8;
        goto L8
    }

    public MessageTrackContext(int r100, long r101, Map r102, q2 r103) {
        if (1 != (r100 & 1)) goto L9;
        this.businessSendStartTimestamp = r101;
        if ((r100 & 2) != 0) goto L7;
        this.commonTags = MapsKt.emptyMap();
        return;
    L7:
        this.commonTags = r102;
        return;
    L9:
        b2.b(r100, 1, a.f346681b);
        throw null;
    }

    public /* synthetic */ MessageTrackContext(long r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = MapsKt.emptyMap();
    L5:
        this(r100, r101);
    }
}
