package com.larus.im.bean.message;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.w0;
import yc9.b1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0002:;B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBI\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003JD\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R,\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006<"}, d2 = {"Lcom/larus/im/bean/message/RichMediaMeta;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "media", "", "Lcom/larus/im/bean/message/block/RichMediaItem;", "containerAttribute", "Lcom/larus/im/bean/message/ContainerAttribute;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/ContainerAttribute;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/ContainerAttribute;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPos$annotations", "()V", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSceneType$annotations", "getSceneType", "setSceneType", "getMedia$annotations", "getMedia", "()Ljava/util/List;", "setMedia", "(Ljava/util/List;)V", "getContainerAttribute$annotations", "getContainerAttribute", "()Lcom/larus/im/bean/message/ContainerAttribute;", "setContainerAttribute", "(Lcom/larus/im/bean/message/ContainerAttribute;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/ContainerAttribute;)Lcom/larus/im/bean/message/RichMediaMeta;", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class RichMediaMeta implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private ContainerAttribute containerAttribute;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<RichMediaItem> media;
    private Integer pos;
    private Integer sceneType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<RichMediaMeta> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346705a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346706b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346706b;
        }

        static {
            a r100 = new a();
            f346705a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.RichMediaMeta", r100, 4);
            r101.j(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, true);
            r101.j("scene_type", true);
            r101.j("media", true);
            r101.j("container_attribute", true);
            f346706b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = RichMediaMeta.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[2].getValue()), kuc.a.d(ContainerAttribute.a.f346604a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346706b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = RichMediaMeta.access$get$childSerializers$cp();
            Integer r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            w0 r104 = w0.f520792a;
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            List r110 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), null);
            Integer r111 = r106;
            ContainerAttribute r112 = (ContainerAttribute) r101.decodeNullableSerializableElement(r100, 3, ContainerAttribute.a.f346604a, null);
            Integer r113 = r105;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new RichMediaMeta(r114, r113, r111, r110, r112, null);
        L5:
            Integer r107 = null;
            List r115 = null;
            ContainerAttribute r116 = null;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r103 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r103);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r107);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), r115);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (ContainerAttribute) r101.decodeNullableSerializableElement(r100, 3, ContainerAttribute.a.f346604a, r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r114 = r108;
            r113 = r103;
            r111 = r107;
            r110 = r115;
            r112 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            RichMediaMeta r102 = (RichMediaMeta) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346706b;
            muc.d r104 = r100.beginStructure(r103);
            RichMediaMeta.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<RichMediaMeta> serializer() {
            return a.f346705a;
        }
    }

    public RichMediaMeta() {
        this(null, null, null, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(RichMediaItem.a.f347035a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RichMediaMeta copy$default(RichMediaMeta r100, Integer r101, Integer r102, List r103, ContainerAttribute r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.pos;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.sceneType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.media;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.containerAttribute;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("container_attribute")
    public static /* synthetic */ void getContainerAttribute$annotations() {
    }

    @SerialName("media")
    public static /* synthetic */ void getMedia$annotations() {
    }

    @SerialName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    public static /* synthetic */ void getPos$annotations() {
    }

    @SerialName("scene_type")
    public static /* synthetic */ void getSceneType$annotations() {
    }

    public final Integer component1() {
        return this.pos;
    }

    public final Integer component2() {
        return this.sceneType;
    }

    public final List<RichMediaItem> component3() {
        return this.media;
    }

    public final ContainerAttribute component4() {
        return this.containerAttribute;
    }

    public final RichMediaMeta copy(Integer r100, Integer r101, List<RichMediaItem> r102, ContainerAttribute r103) {
        return new RichMediaMeta(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichMediaMeta) == true) goto L8;
        return false;
    L8:
        RichMediaMeta r101 = (RichMediaMeta) r100;
        if (Intrinsics.areEqual(this.pos, r101.pos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.media, r101.media) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.containerAttribute, r101.containerAttribute) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.pos;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.sceneType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<RichMediaItem> r107 = this.media;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ContainerAttribute r110 = this.containerAttribute;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RichMediaMeta(pos=" + this.pos + ", sceneType=" + this.sceneType + ", media=" + this.media + ", containerAttribute=" + this.containerAttribute + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b1()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final ContainerAttribute getContainerAttribute() {
        return this.containerAttribute;
    }

    public final List<RichMediaItem> getMedia() {
        return this.media;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final Integer getSceneType() {
        return this.sceneType;
    }

    public final void setContainerAttribute(ContainerAttribute r100) {
        this.containerAttribute = r100;
    }

    public final void setMedia(List<RichMediaItem> r100) {
        this.media = r100;
    }

    public final void setPos(Integer r100) {
        this.pos = r100;
    }

    public final void setSceneType(Integer r100) {
        this.sceneType = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(RichMediaMeta r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L5;
    L4:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.pos);
    L15:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L18;
    L16:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L24;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.sceneType);
    L24:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L27;
    L25:
        boolean r107 = true;
    L30:
        if (r107 == false) goto L33;
        r101.encodeNullableSerializableElement(r102, 2, r103[2].getValue(), r100.media);
    L33:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L36;
    L34:
        r104 = true;
    L38:
        if (r104 == false) goto L41;
        r101.encodeNullableSerializableElement(r102, 3, ContainerAttribute.a.f346604a, r100.containerAttribute);
        return;
    L41:
        return;
    L36:
        if (r100.containerAttribute == null) goto L38;
    L27:
        if (r100.media != null) goto L25;
        r107 = false;
        goto L30
    L18:
        if (r100.sceneType != null) goto L16;
        r106 = false;
        goto L21
    L5:
        Integer r108 = r100.pos;
        if (r108 == null) goto L4;
        if (r108.intValue() != 0) goto L4;
        r105 = false;
        goto L12
    }

    public RichMediaMeta(Integer r100, Integer r101, List<RichMediaItem> r102, ContainerAttribute r103) {
        this.pos = r100;
        this.sceneType = r101;
        this.media = r102;
        this.containerAttribute = r103;
    }

    public RichMediaMeta(int r100, Integer r101, Integer r102, List r103, ContainerAttribute r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346706b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 0;
    L7:
        this.pos = r101;
        if ((r100 & 2) != 0) goto L10;
        this.sceneType = null;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.media = null;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.containerAttribute = null;
        return;
    L18:
        this.containerAttribute = r104;
        return;
    L14:
        this.media = r103;
        goto L16
    L10:
        this.sceneType = r102;
        goto L12
    }

    public /* synthetic */ RichMediaMeta(Integer r100, Integer r101, List r102, ContainerAttribute r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
