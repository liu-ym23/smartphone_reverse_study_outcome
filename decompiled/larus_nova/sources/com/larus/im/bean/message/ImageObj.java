package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Map;
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
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import yc9.t;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002./BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fBU\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lcom/larus/im/bean/message/ImageObj;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "url", "", "width", "", "height", "urlFormats", "", SubInfo.KEY_FORMAT, "<init>", "(Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IILjava/util/Map;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getWidth$annotations", "getHeight$annotations", "getUrlFormats$annotations", "getFormat$annotations", "heicUrl", "getHeicUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ImageObj implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public String format;
    public int height;
    public String url;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final Map<String, String> urlFormats;
    public int width;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ImageObj> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346651a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346652b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346652b;
        }

        static {
            a r100 = new a();
            f346651a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ImageObj", r100, 5);
            r101.j("url", true);
            r101.j("width", true);
            r101.j("height", true);
            r101.j("url_formats", true);
            r101.j(SubInfo.KEY_FORMAT, true);
            f346652b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = ImageObj.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{kuc.a.d(r101), r102, r102, kuc.a.d((d) r100[3].getValue()), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346652b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = ImageObj.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            int r105 = r101.decodeIntElement(r100, 1);
            int r106 = r101.decodeIntElement(r100, 2);
            Map r211 = (Map) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
            String r212 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            int r213 = r106;
            int r110 = r105;
            String r111 = r104;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new ImageObj(r112, r111, r110, r213, r211, r212, null);
        L5:
            String r113 = null;
            Map r114 = null;
            String r115 = null;
            int r107 = 0;
            int r108 = 0;
            int r116 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L24;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 == 0) goto L21;
            if (r118 == 1) goto L19;
            if (r118 == 2) goto L18;
            if (r118 == 3) goto L17;
            if (r118 != 4) goto L16;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r115);
            int r109 = r108 | 16;
        L20:
            r108 = r109;
            goto L6
        L16:
            throw new UnknownFieldException(r118);
        L17:
            r114 = (Map) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r114);
            r109 = r108 | 8;
            goto L20
        L18:
            r107 = r101.decodeIntElement(r100, 2);
            r109 = r108 | 4;
            goto L20
        L19:
            r116 = r101.decodeIntElement(r100, 1);
            r109 = r108 | 2;
            goto L20
        L21:
            r108 = r108 | 1;
            r113 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r113);
            goto L6
        L24:
            r213 = r107;
            r112 = r108;
            r110 = r116;
            r111 = r113;
            r211 = r114;
            r212 = r115;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ImageObj r102 = (ImageObj) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346652b;
            muc.d r104 = r100.beginStructure(r103);
            ImageObj.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ImageObj> serializer() {
            return a.f346651a;
        }
    }

    public ImageObj() {
        this(null, 0, 0, null, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageObj copy$default(ImageObj r100, String r101, int r102, int r103, Map r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.height;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.urlFormats;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.format;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName(SubInfo.KEY_FORMAT)
    public static /* synthetic */ void getFormat$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("url_formats")
    public static /* synthetic */ void getUrlFormats$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final Map<String, String> component4() {
        return this.urlFormats;
    }

    public final String component5() {
        return this.format;
    }

    public final ImageObj copy(String r100, int r101, int r110, Map<String, String> r111, String r112) {
        return new ImageObj(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageObj) == true) goto L8;
        return false;
    L8:
        ImageObj r101 = (ImageObj) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L15;
        return false;
    L15:
        if (this.height == r101.height) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.urlFormats, r101.urlFormats) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.width) * 31) + this.height) * 31;
        Map<String, String> r104 = this.urlFormats;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.format;
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
        return "ImageObj(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", urlFormats=" + this.urlFormats + ", format=" + this.format + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t()), null};
    }

    public final String getHeicUrl() {
        Map<String, String> r100 = this.urlFormats;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("heic");
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ImageObj r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.url);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.width);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeIntElement(r102, 2, r100.height);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.urlFormats);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r104 = true;
    L44:
        if (r104 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.format);
        return;
    L47:
        return;
    L42:
        if (r100.format == null) goto L44;
    L33:
        if (r100.urlFormats != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.height != 0) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.width != 0) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.url != null) goto L4;
        r105 = false;
        goto L9
    }

    public ImageObj(String r100, int r101, int r102, Map<String, String> r103, String r104) {
        this.url = r100;
        this.width = r101;
        this.height = r102;
        this.urlFormats = r103;
        this.format = r104;
    }

    public ImageObj(int r100, String r101, int r102, int r103, Map r104, String r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346652b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.url = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.width = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.height = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.urlFormats = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.format = null;
        return;
    L23:
        this.format = r105;
        return;
    L19:
        this.urlFormats = r104;
        goto L21
    L15:
        this.height = r103;
        goto L17
    L11:
        this.width = r102;
        goto L13
    L7:
        this.url = r101;
        goto L9
    }

    public /* synthetic */ ImageObj(String r100, int r101, int r102, Map r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L6:
        int r105 = 0;
        if ((r110 & 2) == 0) goto L9;
        int r106 = 0;
    L11:
        if ((r110 & 4) != 0) goto L15;
        r105 = r102;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Map r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r106, r105, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L6
    }
}
