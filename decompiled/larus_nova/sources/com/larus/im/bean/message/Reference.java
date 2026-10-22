package com.larus.im.bean.message;

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
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/larus/im/bean/message/Reference;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "textCard", "Lcom/larus/im/bean/message/TextCard;", "videoCard", "Lcom/larus/im/bean/message/VideoCard;", "imageCard", "Lcom/larus/im/bean/message/VLMImage;", "<init>", "(Lcom/larus/im/bean/message/TextCard;Lcom/larus/im/bean/message/VideoCard;Lcom/larus/im/bean/message/VLMImage;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/bean/message/TextCard;Lcom/larus/im/bean/message/VideoCard;Lcom/larus/im/bean/message/VLMImage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTextCard$annotations", "()V", "getTextCard", "()Lcom/larus/im/bean/message/TextCard;", "getVideoCard$annotations", "getVideoCard", "()Lcom/larus/im/bean/message/VideoCard;", "getImageCard$annotations", "getImageCard", "()Lcom/larus/im/bean/message/VLMImage;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Reference implements java.io.Serializable {
    public static final b Companion = null;
    private final VLMImage imageCard;
    private final TextCard textCard;
    private final VideoCard videoCard;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Reference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346696a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346697b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(TextCard.a.f346726a), kuc.a.d(VideoCard.a.f346754a), kuc.a.d(VLMImage.a.f346747a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346697b;
        }

        static {
            a r100 = new a();
            f346696a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.Reference", r100, 3);
            r101.j("text_card", true);
            r101.j("video_card", true);
            r101.j("image_card", true);
            f346697b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346697b;
            muc.c r101 = r110.beginStructure(r100);
            TextCard r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            TextCard r103 = (TextCard) r101.decodeNullableSerializableElement(r100, 0, TextCard.a.f346726a, null);
            VideoCard r104 = (VideoCard) r101.decodeNullableSerializableElement(r100, 1, VideoCard.a.f346754a, null);
            TextCard r111 = r103;
            VLMImage r112 = (VLMImage) r101.decodeNullableSerializableElement(r100, 2, VLMImage.a.f346747a, null);
            VideoCard r113 = r104;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new Reference(r114, r111, r113, r112, null);
        L5:
            VideoCard r105 = null;
            VLMImage r106 = null;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r102 = (TextCard) r101.decodeNullableSerializableElement(r100, 0, TextCard.a.f346726a, r102);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r105 = (VideoCard) r101.decodeNullableSerializableElement(r100, 1, VideoCard.a.f346754a, r105);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r106 = (VLMImage) r101.decodeNullableSerializableElement(r100, 2, VLMImage.a.f346747a, r106);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r114 = r107;
            r111 = r102;
            r113 = r105;
            r112 = r106;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            Reference r102 = (Reference) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346697b;
            muc.d r104 = r100.beginStructure(r103);
            Reference.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<Reference> serializer() {
            return a.f346696a;
        }
    }

    public Reference() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Reference copy$default(Reference r100, TextCard r101, VideoCard r102, VLMImage r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.textCard;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.videoCard;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.imageCard;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("image_card")
    public static /* synthetic */ void getImageCard$annotations() {
    }

    @SerialName("text_card")
    public static /* synthetic */ void getTextCard$annotations() {
    }

    @SerialName("video_card")
    public static /* synthetic */ void getVideoCard$annotations() {
    }

    public final TextCard component1() {
        return this.textCard;
    }

    public final VideoCard component2() {
        return this.videoCard;
    }

    public final VLMImage component3() {
        return this.imageCard;
    }

    public final Reference copy(TextCard r100, VideoCard r101, VLMImage r102) {
        return new Reference(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Reference) == true) goto L8;
        return false;
    L8:
        Reference r101 = (Reference) r100;
        if (Intrinsics.areEqual(this.textCard, r101.textCard) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoCard, r101.videoCard) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageCard, r101.imageCard) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        TextCard r100 = this.textCard;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        VideoCard r104 = this.videoCard;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        VLMImage r107 = this.imageCard;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Reference(textCard=" + this.textCard + ", videoCard=" + this.videoCard + ", imageCard=" + this.imageCard + ')';
    }

    static {
        Companion = new b();
    }

    public final VLMImage getImageCard() {
        return this.imageCard;
    }

    public final TextCard getTextCard() {
        return this.textCard;
    }

    public final VideoCard getVideoCard() {
        return this.videoCard;
    }

    public Reference(TextCard r100, VideoCard r101, VLMImage r102) {
        this.textCard = r100;
        this.videoCard = r101;
        this.imageCard = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(Reference r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, TextCard.a.f346726a, r100.textCard);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, VideoCard.a.f346754a, r100.videoCard);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, VLMImage.a.f346747a, r100.imageCard);
        return;
    L29:
        return;
    L24:
        if (r100.imageCard == null) goto L26;
    L15:
        if (r100.videoCard != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.textCard != null) goto L4;
        r104 = false;
        goto L9
    }

    public Reference(int r100, TextCard r101, VideoCard r102, VLMImage r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346697b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.textCard = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.videoCard = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imageCard = null;
        return;
    L15:
        this.imageCard = r103;
        return;
    L11:
        this.videoCard = r102;
        goto L13
    L7:
        this.textCard = r101;
        goto L9
    }

    public /* synthetic */ Reference(TextCard r100, VideoCard r101, VLMImage r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
