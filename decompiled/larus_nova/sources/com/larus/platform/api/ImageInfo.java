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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00060\u0001j\u0002`\u0002:\u0002KLB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0081\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u00108\u001a\u00020\u0012J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0012HÖ\u0001J\t\u0010>\u001a\u00020\tHÖ\u0001J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0012J%\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019¨\u0006M"}, d2 = {"Lcom/larus/platform/api/ImageInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "imageOrigin", "Lcom/larus/platform/api/Image;", "imageThumb", "imagePre", "imageRef", "key", "", "requestId", "imageTips", "privateImage", "rawImage", "rawThumbImage", "<init>", "(Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageOrigin$annotations", "()V", "getImageOrigin", "()Lcom/larus/platform/api/Image;", "getImageThumb$annotations", "getImageThumb", "getImagePre$annotations", "getImagePre", "getImageRef$annotations", "getImageRef", "getKey$annotations", "getKey", "()Ljava/lang/String;", "getRequestId$annotations", "getRequestId", "getImageTips$annotations", "getImageTips", "getPrivateImage$annotations", "getPrivateImage", "getRawImage$annotations", "getRawImage", "getRawThumbImage$annotations", "getRawThumbImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Image f364798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Image f364799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Image f364800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Image f364801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f364802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f364803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f364804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Image f364805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Image f364806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Image f364807j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f364808a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final nuc.g2 f364809b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f364809b;
        }

        static {
            a r100 = new a();
            f364808a = r100;
            nuc.g2 r101 = new nuc.g2("com.larus.platform.api.ImageInfo", r100, 10);
            r101.j("image_ori", true);
            r101.j("image_thumb", true);
            r101.j("preview_img", true);
            r101.j("ref_image", true);
            r101.j("key", true);
            r101.j("request_id", true);
            r101.j("tips", true);
            r101.j("private_img", true);
            r101.j("raw_image", true);
            r101.j("raw_thumb_image", true);
            f364809b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Image.a r100 = Image.a.f364796a;
            nuc.v2 r101 = nuc.v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            nuc.g2 r100 = f364809b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 8;
            int r103 = 6;
            int r104 = 7;
            Image r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Image.a r105 = Image.a.f364796a;
            Image r111 = (Image) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            Image r112 = (Image) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            Image r106 = (Image) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            Image r107 = (Image) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            nuc.v2 r113 = nuc.v2.f520790a;
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 4, r113, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 5, r113, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 6, r113, null);
            Image r115 = (Image) r101.decodeNullableSerializableElement(r100, 7, r105, null);
            Image r116 = (Image) r101.decodeNullableSerializableElement(r100, 8, r105, null);
            Image r117 = (Image) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            Image r118 = r116;
            String r119 = r108;
            String r120 = r109;
            Image r121 = r115;
            Image r122 = r111;
            int r123 = 1023;
            Image r124 = r107;
            Image r125 = r106;
            Image r126 = r112;
            String r127 = r114;
        L27:
            r101.endStructure(r100);
            return new ImageInfo(r123, r122, r126, r125, r124, r127, r119, r120, r121, r118, r117);
        L5:
            Image r128 = null;
            Image r129 = null;
            Image r130 = null;
            String r131 = null;
            String r132 = null;
            Image r133 = null;
            String r134 = null;
            Image r135 = null;
            Image r136 = null;
            int r137 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L26;
            int r138 = r101.decodeElementIndex(r100);
            switch(r138) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r138);
        L25:
            r102 = 8;
            r103 = 6;
            r104 = 7;
            r211 = false;
            goto L6
        L11:
            r128 = (Image) r101.decodeNullableSerializableElement(r100, 9, Image.a.f364796a, r128);
            r137 = r137 | 512;
        L20:
            Image r139 = r135;
        L22:
            Image r140 = r136;
        L24:
            r135 = r139;
            r136 = r140;
            r102 = 8;
            r103 = 6;
            r104 = 7;
            goto L6
        L12:
            r129 = (Image) r101.decodeNullableSerializableElement(r100, r102, Image.a.f364796a, r129);
            r137 = r137 | 256;
            goto L20
        L13:
            r130 = (Image) r101.decodeNullableSerializableElement(r100, r104, Image.a.f364796a, r130);
            r137 = r137 | 128;
            goto L20
        L14:
            r132 = (String) r101.decodeNullableSerializableElement(r100, r103, nuc.v2.f520790a, r132);
            r137 = r137 | 64;
            goto L20
        L16:
            r131 = (String) r101.decodeNullableSerializableElement(r100, 5, nuc.v2.f520790a, r131);
            r137 = r137 | 32;
            goto L20
        L17:
            r134 = (String) r101.decodeNullableSerializableElement(r100, 4, nuc.v2.f520790a, r134);
            r137 = r137 | 16;
            goto L20
        L18:
            r133 = (Image) r101.decodeNullableSerializableElement(r100, 3, Image.a.f364796a, r133);
            r137 = r137 | 8;
            goto L20
        L19:
            r135 = (Image) r101.decodeNullableSerializableElement(r100, 2, Image.a.f364796a, r135);
            r137 = r137 | 4;
            goto L20
        L21:
            r139 = r135;
            r136 = (Image) r101.decodeNullableSerializableElement(r100, 1, Image.a.f364796a, r136);
            r137 = r137 | 2;
            goto L22
        L23:
            r139 = r135;
            r140 = r136;
            r137 = r137 | 1;
            r110 = (Image) r101.decodeNullableSerializableElement(r100, 0, Image.a.f364796a, r110);
            goto L24
        L26:
            r123 = r137;
            r117 = r128;
            r118 = r129;
            r122 = r110;
            r126 = r136;
            r119 = r131;
            r124 = r133;
            r120 = r132;
            r127 = r134;
            r121 = r130;
            r125 = r135;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ImageInfo r102 = (ImageInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            nuc.g2 r103 = f364809b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = ImageInfo.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, Image.a.f364796a, r102.f364798a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, Image.a.f364796a, r102.f364799b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, Image.a.f364796a, r102.f364800c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, Image.a.f364796a, r102.f364801d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, nuc.v2.f520790a, r102.f364802e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, nuc.v2.f520790a, r102.f364803f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, nuc.v2.f520790a, r102.f364804g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeNullableSerializableElement(r103, 7, Image.a.f364796a, r102.f364805h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeNullableSerializableElement(r103, 8, Image.a.f364796a, r102.f364806i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            r106 = true;
        L89:
            if (r106 == false) goto L91;
            r104.encodeNullableSerializableElement(r103, 9, Image.a.f364796a, r102.f364807j);
        L91:
            r104.endStructure(r103);
            return;
        L87:
            if (r102.f364807j == null) goto L89;
        L78:
            if (r102.f364806i != null) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r102.f364805h != null) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r102.f364804g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f364803f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f364802e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f364801d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f364800c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f364799b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f364798a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<ImageInfo> serializer() {
            return a.f364808a;
        }
    }

    public static final class c implements Parcelable.Creator<ImageInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Image r100 = null;
            if (r110.readInt() != 0) goto L5;
            Image r101 = null;
        L6:
            Image r102 = r101;
            if (r110.readInt() != 0) goto L9;
            Image r103 = null;
        L10:
            Image r104 = r103;
            if (r110.readInt() != 0) goto L13;
            Image r105 = null;
        L14:
            Image r106 = r105;
            if (r110.readInt() != 0) goto L17;
            Image r107 = null;
        L18:
            Image r108 = r107;
            String r109 = r110.readString();
            String r111 = r110.readString();
            String r112 = r110.readString();
            if (r110.readInt() != 0) goto L21;
            Image r113 = null;
        L22:
            Image r114 = r113;
            if (r110.readInt() != 0) goto L25;
            Image r115 = null;
        L26:
            Image r116 = r115;
            if (r110.readInt() == 0) goto L31;
            r100 = Image.CREATOR.createFromParcel(r110);
        L31:
            return new ImageInfo(r102, r104, r106, r108, r109, r111, r112, r114, r116, r100);
        L25:
            r115 = Image.CREATOR.createFromParcel(r110);
            goto L26
        L21:
            r113 = Image.CREATOR.createFromParcel(r110);
            goto L22
        L17:
            r107 = Image.CREATOR.createFromParcel(r110);
            goto L18
        L13:
            r105 = Image.CREATOR.createFromParcel(r110);
            goto L14
        L9:
            r103 = Image.CREATOR.createFromParcel(r110);
            goto L10
        L5:
            r101 = Image.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ImageInfo[] newArray(int r100) {
            return new ImageInfo[r100];
        }
    }

    public ImageInfo() {
        this(null, null, null, null, null, null, null, null, null, 1023);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageInfo) == true) goto L8;
        return false;
    L8:
        ImageInfo r101 = (ImageInfo) r100;
        if (Intrinsics.areEqual(this.f364798a, r101.f364798a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f364799b, r101.f364799b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f364800c, r101.f364800c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f364801d, r101.f364801d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f364802e, r101.f364802e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f364803f, r101.f364803f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f364804g, r101.f364804g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f364805h, r101.f364805h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f364806i, r101.f364806i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f364807j, r101.f364807j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Image r100 = this.f364798a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Image r104 = this.f364799b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Image r107 = this.f364800c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Image r110 = this.f364801d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f364802e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f364803f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f364804g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Image r122 = this.f364805h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Image r125 = this.f364806i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Image r128 = this.f364807j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public final String toString() {
        return "ImageInfo(imageOrigin=" + this.f364798a + ", imageThumb=" + this.f364799b + ", imagePre=" + this.f364800c + ", imageRef=" + this.f364801d + ", key=" + this.f364802e + ", requestId=" + this.f364803f + ", imageTips=" + this.f364804g + ", privateImage=" + this.f364805h + ", rawImage=" + this.f364806i + ", rawThumbImage=" + this.f364807j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Image r102 = this.f364798a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Image r103 = this.f364799b;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Image r104 = this.f364800c;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Image r105 = this.f364801d;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        r100.writeString(this.f364802e);
        r100.writeString(this.f364803f);
        r100.writeString(this.f364804g);
        Image r106 = this.f364805h;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        Image r107 = this.f364806i;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        Image r108 = this.f364807j;
        if (r108 != null) goto L29;
        r100.writeInt(0);
        return;
    L29:
        r100.writeInt(1);
        r108.writeToParcel(r100, r101);
        return;
    L25:
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L26
    L21:
        r100.writeInt(1);
        r106.writeToParcel(r100, r101);
        goto L22
    L17:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L18
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public static ImageInfo a(ImageInfo r110, Image r111, Image r112, Image r113, Image r114, Image r115, int r210) {
        if ((r210 & 1) == 0) goto L5;
        Image r100 = r110.f364798a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Image r101 = r110.f364799b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Image r102 = r110.f364800c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Image r103 = r110.f364801d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.f364802e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.f364803f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r116 = r110.f364804g;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Image r117 = r110.f364805h;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Image r118 = r110.f364806i;
    L39:
        if ((r210 & 512) == 0) goto L41;
        Image r119 = r110.f364807j;
    L42:
        r110.getClass();
        return new ImageInfo(r100, r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L41:
        r119 = r115;
        goto L42
    L37:
        r118 = r114;
        goto L39
    L33:
        r117 = null;
        goto L35
    L29:
        r116 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ ImageInfo(Image r110, Image r111, Image r112, Image r113, String r114, String r210, String r211, Image r212, Image r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        Image r100 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Image r101 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Image r102 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Image r103 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r115 = null;
    L31:
        if ((r214 & 256) == 0) goto L33;
        Image r116 = null;
    L35:
        if ((r214 & 512) == 0) goto L37;
        Image r117 = null;
    L38:
        this(r100, r101, r102, r103, r104, r105, r115, null, r116, r117);
        return;
    L37:
        r117 = r213;
        goto L38
    L33:
        r116 = r212;
        goto L35
    L29:
        r115 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
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

    public ImageInfo(Image r100, Image r101, Image r102, Image r103, String r104, String r105, String r106, Image r107, Image r108, Image r110) {
        this.f364798a = r100;
        this.f364799b = r101;
        this.f364800c = r102;
        this.f364801d = r103;
        this.f364802e = r104;
        this.f364803f = r105;
        this.f364804g = r106;
        this.f364805h = r107;
        this.f364806i = r108;
        this.f364807j = r110;
    }

    public ImageInfo(int r100, Image r101, Image r102, Image r103, Image r104, String r105, String r106, String r110, Image r111, Image r112, Image r113) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f364809b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f364798a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f364799b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f364800c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f364801d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f364802e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f364803f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f364804g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f364805h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f364806i = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f364807j = null;
        return;
    L43:
        this.f364807j = r113;
        return;
    L39:
        this.f364806i = r112;
        goto L41
    L35:
        this.f364805h = r111;
        goto L37
    L31:
        this.f364804g = r110;
        goto L33
    L27:
        this.f364803f = r106;
        goto L29
    L23:
        this.f364802e = r105;
        goto L25
    L19:
        this.f364801d = r104;
        goto L21
    L15:
        this.f364800c = r103;
        goto L17
    L11:
        this.f364799b = r102;
        goto L13
    L7:
        this.f364798a = r101;
        goto L9
    }
}
