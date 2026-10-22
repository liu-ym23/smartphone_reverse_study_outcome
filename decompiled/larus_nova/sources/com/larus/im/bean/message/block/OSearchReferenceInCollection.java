package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00060\u0001j\u0002`\u0002:\u0002'(B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/larus/im/bean/message/block/OSearchReferenceInCollection;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "oEntityImage", "Lcom/larus/im/bean/message/block/OSearchEntityImage;", "oEntityVideo", "Lcom/larus/im/bean/message/block/OSearchEntityVideo;", "<init>", "(Lcom/larus/im/bean/message/block/OSearchEntityImage;Lcom/larus/im/bean/message/block/OSearchEntityVideo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/bean/message/block/OSearchEntityImage;Lcom/larus/im/bean/message/block/OSearchEntityVideo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOEntityImage$annotations", "()V", "getOEntityImage", "()Lcom/larus/im/bean/message/block/OSearchEntityImage;", "getOEntityVideo$annotations", "getOEntityVideo", "()Lcom/larus/im/bean/message/block/OSearchEntityVideo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OSearchReferenceInCollection implements java.io.Serializable {
    public static final b Companion = null;
    private final OSearchEntityImage oEntityImage;
    private final OSearchEntityVideo oEntityVideo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<OSearchReferenceInCollection> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346994a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346995b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(OSearchEntityImage.a.f346984a), kuc.a.d(OSearchEntityVideo.a.f346988a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346995b;
        }

        static {
            a r100 = new a();
            f346994a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.OSearchReferenceInCollection", r100, 2);
            r101.j("o_entity_image", true);
            r101.j("o_entity_video", true);
            f346995b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346995b;
            c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            OSearchEntityImage r101 = (OSearchEntityImage) r111.decodeNullableSerializableElement(r100, 0, OSearchEntityImage.a.f346984a, null);
            OSearchEntityVideo r102 = (OSearchEntityVideo) r111.decodeNullableSerializableElement(r100, 1, OSearchEntityVideo.a.f346988a, null);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new OSearchReferenceInCollection(r103, r101, r102, null);
        L5:
            r101 = null;
            OSearchEntityVideo r104 = null;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = (OSearchEntityImage) r111.decodeNullableSerializableElement(r100, 0, OSearchEntityImage.a.f346984a, r101);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = (OSearchEntityVideo) r111.decodeNullableSerializableElement(r100, 1, OSearchEntityVideo.a.f346988a, r104);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            OSearchReferenceInCollection r102 = (OSearchReferenceInCollection) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346995b;
            muc.d r104 = r100.beginStructure(r103);
            OSearchReferenceInCollection.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<OSearchReferenceInCollection> serializer() {
            return a.f346994a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchReferenceInCollection() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OSearchReferenceInCollection copy$default(OSearchReferenceInCollection r100, OSearchEntityImage r101, OSearchEntityVideo r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.oEntityImage;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.oEntityVideo;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("o_entity_image")
    public static /* synthetic */ void getOEntityImage$annotations() {
    }

    @SerialName("o_entity_video")
    public static /* synthetic */ void getOEntityVideo$annotations() {
    }

    public final OSearchEntityImage component1() {
        return this.oEntityImage;
    }

    public final OSearchEntityVideo component2() {
        return this.oEntityVideo;
    }

    public final OSearchReferenceInCollection copy(OSearchEntityImage r100, OSearchEntityVideo r101) {
        return new OSearchReferenceInCollection(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OSearchReferenceInCollection) == true) goto L8;
        return false;
    L8:
        OSearchReferenceInCollection r101 = (OSearchReferenceInCollection) r100;
        if (Intrinsics.areEqual(this.oEntityImage, r101.oEntityImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.oEntityVideo, r101.oEntityVideo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        OSearchEntityImage r100 = this.oEntityImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OSearchEntityVideo r104 = this.oEntityVideo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OSearchReferenceInCollection(oEntityImage=" + this.oEntityImage + ", oEntityVideo=" + this.oEntityVideo + ')';
    }

    static {
        Companion = new b();
    }

    public final OSearchEntityImage getOEntityImage() {
        return this.oEntityImage;
    }

    public final OSearchEntityVideo getOEntityVideo() {
        return this.oEntityVideo;
    }

    public OSearchReferenceInCollection(OSearchEntityImage r100, OSearchEntityVideo r101) {
        this.oEntityImage = r100;
        this.oEntityVideo = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(OSearchReferenceInCollection r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, OSearchEntityImage.a.f346984a, r100.oEntityImage);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, OSearchEntityVideo.a.f346988a, r100.oEntityVideo);
        return;
    L20:
        return;
    L15:
        if (r100.oEntityVideo == null) goto L17;
    L6:
        if (r100.oEntityImage != null) goto L4;
        r104 = false;
        goto L9
    }

    public OSearchReferenceInCollection(int r100, OSearchEntityImage r101, OSearchEntityVideo r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346995b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.oEntityImage = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.oEntityVideo = null;
        return;
    L11:
        this.oEntityVideo = r102;
        return;
    L7:
        this.oEntityImage = r101;
        goto L9
    }

    public /* synthetic */ OSearchReferenceInCollection(OSearchEntityImage r100, OSearchEntityVideo r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
