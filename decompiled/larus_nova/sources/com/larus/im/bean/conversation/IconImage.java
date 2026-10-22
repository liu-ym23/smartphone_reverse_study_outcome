package com.larus.im.bean.conversation;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.bean.message.ImageObj;
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
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002%&B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/bean/conversation/IconImage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "key", "", "imageThumb", "Lcom/larus/im/bean/message/ImageObj;", "imageOri", "<init>", "(Ljava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getImageThumb$annotations", "getImageOri$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class IconImage implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public final ImageObj imageOri;
    public ImageObj imageThumb;
    public final String key;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<IconImage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346537a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346538b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            ImageObj.a r100 = ImageObj.a.f346651a;
            return new d[]{kuc.a.d(v2.f520790a), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346538b;
        }

        static {
            a r100 = new a();
            f346537a = r100;
            g2 r101 = new g2("com.larus.im.bean.conversation.IconImage", r100, 3);
            r101.j("key", true);
            r101.j("image_thumb", true);
            r101.j("image_ori", true);
            f346538b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346538b;
            c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            ImageObj.a r104 = ImageObj.a.f346651a;
            ImageObj r105 = (ImageObj) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r111 = r103;
            ImageObj r112 = (ImageObj) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            ImageObj r113 = r105;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new IconImage(r114, r111, r113, r112, null);
        L5:
            ImageObj r106 = null;
            ImageObj r107 = null;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r106 = (ImageObj) r101.decodeNullableSerializableElement(r100, 1, ImageObj.a.f346651a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r107 = (ImageObj) r101.decodeNullableSerializableElement(r100, 2, ImageObj.a.f346651a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r114 = r108;
            r111 = r102;
            r113 = r106;
            r112 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            IconImage r102 = (IconImage) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346538b;
            muc.d r104 = r100.beginStructure(r103);
            IconImage.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<IconImage> serializer() {
            return a.f346537a;
        }
    }

    public IconImage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ IconImage copy$default(IconImage r100, String r101, ImageObj r102, ImageObj r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.imageThumb;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.imageOri;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("image_ori")
    public static /* synthetic */ void getImageOri$annotations() {
    }

    @SerialName("image_thumb")
    public static /* synthetic */ void getImageThumb$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getKey$annotations() {
    }

    public final String component1() {
        return this.key;
    }

    public final ImageObj component2() {
        return this.imageThumb;
    }

    public final ImageObj component3() {
        return this.imageOri;
    }

    public final IconImage copy(String r100, ImageObj r101, ImageObj r102) {
        return new IconImage(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IconImage) == true) goto L8;
        return false;
    L8:
        IconImage r101 = (IconImage) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ImageObj r104 = this.imageThumb;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ImageObj r107 = this.imageOri;
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
        return "IconImage(key=" + this.key + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ')';
    }

    static {
        Companion = new b();
    }

    public IconImage(String r100, ImageObj r101, ImageObj r102) {
        this.key = r100;
        this.imageThumb = r101;
        this.imageOri = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(IconImage r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.key);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, ImageObj.a.f346651a, r100.imageThumb);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, ImageObj.a.f346651a, r100.imageOri);
        return;
    L29:
        return;
    L24:
        if (r100.imageOri == null) goto L26;
    L15:
        if (r100.imageThumb != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.key != null) goto L4;
        r104 = false;
        goto L9
    }

    public IconImage(int r100, String r101, ImageObj r102, ImageObj r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346538b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.key = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.imageThumb = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imageOri = null;
        return;
    L15:
        this.imageOri = r103;
        return;
    L11:
        this.imageThumb = r102;
        goto L13
    L7:
        this.key = r101;
        goto L9
    }

    public /* synthetic */ IconImage(String r100, ImageObj r101, ImageObj r102, int r103, DefaultConstructorMarker r104) {
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
