package com.larus.platform.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00060\u0001j\u0002`\u0002:\u0002>?B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003JA\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010+\u001a\u00020\rJ\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\rHÖ\u0001J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\rJ%\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006@"}, d2 = {"Lcom/larus/platform/api/Image;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "url", "", "urlV2", "width", "", "height", "uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUrlV2$annotations", "getUrlV2", "setUrlV2", "getWidth$annotations", "getWidth", "()J", "setWidth", "(J)V", "getHeight$annotations", "getHeight", "setHeight", "getUri$annotations", "getUri", "setUri", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f364791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f364792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f364793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f364794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f364795e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<Image> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f364796a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final nuc.g2 f364797b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.v2 r100 = nuc.v2.f520790a;
            nuc.g1 r101 = nuc.g1.f520681a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), r101, r101, kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f364797b;
        }

        static {
            a r100 = new a();
            f364796a = r100;
            nuc.g2 r101 = new nuc.g2("com.larus.platform.api.Image", r100, 5);
            r101.j("url", true);
            r101.j("url_v2", true);
            r101.j("width", true);
            r101.j("height", true);
            r101.j("uri", true);
            f364797b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            nuc.g2 r100 = f364797b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 2;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.v2 r104 = nuc.v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            long r107 = r101.decodeLongElement(r100, 2);
            long r108 = r101.decodeLongElement(r100, 3);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            long r212 = r108;
            String r110 = r106;
            String r111 = r105;
            long r213 = r107;
            int r112 = 31;
        L26:
            r101.endStructure(r100);
            return new Image(r112, r111, r110, r213, r212, r211);
        L5:
            long r109 = 0;
            String r113 = null;
            String r114 = null;
            long r115 = 0;
            int r116 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L25;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r102 = 2;
            r117 = false;
            goto L6
        L9:
            if (r118 == 0) goto L22;
            if (r118 != 1) goto L12;
            r113 = (String) r101.decodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, r113);
            r116 = r116 | 2;
        L23:
            r102 = 2;
            goto L6
        L12:
            if (r118 == r102) goto L19;
            if (r118 == 3) goto L18;
            if (r118 != 4) goto L17;
            r114 = (String) r101.decodeNullableSerializableElement(r100, 4, nuc.v2.f520790a, r114);
            r116 = r116 | 16;
            goto L23
        L17:
            throw new UnknownFieldException(r118);
        L18:
            r109 = r101.decodeLongElement(r100, 3);
            r116 = r116 | 8;
            goto L23
        L19:
            r115 = r101.decodeLongElement(r100, r102);
            r116 = r116 | 4;
            goto L23
        L22:
            r116 = r116 | 1;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, nuc.v2.f520790a, r103);
            goto L23
        L25:
            r112 = r116;
            r111 = r103;
            r212 = r109;
            r110 = r113;
            r211 = r114;
            r213 = r115;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            Image r112 = (Image) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            nuc.g2 r100 = f364797b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = Image.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeNullableSerializableElement(r100, 0, nuc.v2.f520790a, r112.f364791a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeNullableSerializableElement(r100, 1, nuc.v2.f520790a, r112.f364792b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeLongElement(r100, 2, r112.f364793c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeLongElement(r100, 3, r112.f364794d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            r102 = true;
        L44:
            if (r102 == false) goto L46;
            r113.encodeNullableSerializableElement(r100, 4, nuc.v2.f520790a, r112.f364795e);
        L46:
            r113.endStructure(r100);
            return;
        L42:
            if (r112.f364795e == null) goto L44;
        L33:
            if (r112.f364794d != 0) goto L34;
            r106 = false;
            goto L36
        L24:
            if (r112.f364793c != 0) goto L25;
            r105 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r112.f364792b, "") == false) goto L16;
            r104 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r112.f364791a, "") == false) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<Image> serializer() {
            return a.f364796a;
        }
    }

    public static final class c implements Parcelable.Creator<Image> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final Image createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new Image(r110.readString(), r110.readString(), r110.readLong(), r110.readLong(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Image[] newArray(int r100) {
            return new Image[r100];
        }
    }

    public Image() {
        this(null, null, 0, 0, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Image) == true) goto L8;
        return false;
    L8:
        Image r101 = (Image) r100;
        if (Intrinsics.areEqual(this.f364791a, r101.f364791a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f364792b, r101.f364792b) == true) goto L15;
        return false;
    L15:
        if (this.f364793c == r101.f364793c) goto L18;
        return false;
    L18:
        if (this.f364794d == r101.f364794d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f364795e, r101.f364795e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f364791a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f364792b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f364793c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f364794d;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f364795e;
        if (r111 == null) goto L15;
        r101 = r111.hashCode();
    L15:
        return r110 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Image(url=" + this.f364791a + ", urlV2=" + this.f364792b + ", width=" + this.f364793c + ", height=" + this.f364794d + ", uri=" + this.f364795e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f364791a);
        r100.writeString(this.f364792b);
        r100.writeLong(this.f364793c);
        r100.writeLong(this.f364794d);
        r100.writeString(this.f364795e);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ Image(String r110, String r111, long r112, long r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r114 & 8) == 0) goto L17;
        long r103 = 0;
    L18:
        this(r100, r101, r102, r103, null);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static Image a(Image r110, long r111, long r112, String r113, int r114) {
        String r100 = null;
        if ((r114 & 1) == 0) goto L5;
        String r101 = r110.f364791a;
    L7:
        if ((r114 & 2) == 0) goto L9;
        r100 = r110.f364792b;
    L9:
        String r102 = r100;
        if ((r114 & 4) == 0) goto L12;
        long r103 = r110.f364793c;
    L14:
        if ((r114 & 8) == 0) goto L16;
        long r104 = r110.f364794d;
    L18:
        if ((r114 & 16) == 0) goto L20;
        String r115 = r110.f364795e;
    L22:
        return new Image(r101, r102, r103, r104, r115);
    L20:
        r115 = r113;
        goto L22
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public Image(String r100, String r101, long r102, long r103, String r104) {
        this.f364791a = r100;
        this.f364792b = r101;
        this.f364793c = r102;
        this.f364794d = r103;
        this.f364795e = r104;
    }

    public Image(int r100, String r101, String r102, long r103, long r110, String r111) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f364797b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f364791a = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f364792b = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f364793c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f364794d = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f364795e = null;
        return;
    L23:
        this.f364795e = r111;
        return;
    L19:
        this.f364794d = r110;
        goto L21
    L15:
        this.f364793c = r103;
        goto L17
    L11:
        this.f364792b = r102;
        goto L13
    L7:
        this.f364791a = r101;
        goto L9
    }
}
