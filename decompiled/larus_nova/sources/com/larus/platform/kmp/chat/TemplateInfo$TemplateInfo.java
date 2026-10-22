package com.larus.platform.kmp.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.cert.manager.constants.EventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 `2\u00060\u0001j\u0002`\u0002:\u0002_`Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013Bw\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010A\u001a\u00020\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jy\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0006\u0010L\u001a\u00020\u0015J\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0015HÖ\u0001J\t\u0010R\u001a\u00020\bHÖ\u0001J\u0016\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0015J%\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0001¢\u0006\u0002\b^R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R&\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR$\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR$\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006a"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "id", "", "type", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;", EventConstant.Key.RETAIN_PROMPT, "", "imageThumb", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;", "imageOri", "imagePreview", "ratioId", "styleId", "templatePrimaryId", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "<init>", "(JLcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;Ljava/lang/String;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;JJJLcom/larus/platform/api/creation/UserCreation;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;Ljava/lang/String;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;JJJLcom/larus/platform/api/creation/UserCreation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "setId", "(J)V", "getType$annotations", "getType", "()Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;", "setType", "(Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;)V", "getPrompt$annotations", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "getImageThumb$annotations", "getImageThumb", "()Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;", "setImageThumb", "(Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;)V", "getImageOri$annotations", "getImageOri", "setImageOri", "getImagePreview$annotations", "getImagePreview", "setImagePreview", "getRatioId$annotations", "getRatioId", "setRatioId", "getStyleId$annotations", "getStyleId", "setStyleId", "getTemplatePrimaryId$annotations", "getTemplatePrimaryId", "setTemplatePrimaryId", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "setUserCreation", "(Lcom/larus/platform/api/creation/UserCreation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class TemplateInfo$TemplateInfo implements Parcelable {
    public static final Parcelable.Creator<TemplateInfo$TemplateInfo> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f365415k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f365416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TemplateInfo$TemplateType f365417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TemplateInfo$TemplateImage f365419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TemplateInfo$TemplateImage f365420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TemplateInfo$TemplateImage f365421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f365422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f365423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f365424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final UserCreation f365425j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TemplateInfo$TemplateInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f365426a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f365427b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f365427b;
        }

        static {
            a r100 = new a();
            f365426a = r100;
            g2 r101 = new g2("com.larus.platform.kmp.chat.TemplateInfo.TemplateInfo", r100, 10);
            r101.j("id", true);
            r101.j("type", true);
            r101.j(EventConstant.Key.RETAIN_PROMPT, true);
            r101.j("image_thumb", true);
            r101.j("image_ori", true);
            r101.j("image_preview", true);
            r101.j("ratio_id", true);
            r101.j("style_id", true);
            r101.j("template_primary_key", true);
            r101.j("userCreation", true);
            f365427b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy<d<Object>>[] r100 = TemplateInfo$TemplateInfo.f365415k;
            g1 r101 = g1.f520681a;
            TemplateInfo$TemplateImage.a r102 = TemplateInfo$TemplateImage.a.f365413a;
            return new d[]{r101, kuc.a.d(r100[1].getValue()), kuc.a.d(v2.f520790a), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), r101, r101, r101, kuc.a.d(UserCreation.a.f365004a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f365427b;
            muc.c r101 = r310.beginStructure(r100);
            Lazy<d<Object>>[] r102 = TemplateInfo$TemplateInfo.f365415k;
            int r103 = 8;
            TemplateInfo$TemplateType r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            long r111 = r101.decodeLongElement(r100, 0);
            TemplateInfo$TemplateType r104 = (TemplateInfo$TemplateType) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, null);
            TemplateInfo$TemplateImage.a r106 = TemplateInfo$TemplateImage.a.f365413a;
            TemplateInfo$TemplateImage r107 = (TemplateInfo$TemplateImage) r101.decodeNullableSerializableElement(r100, 3, r106, null);
            TemplateInfo$TemplateImage r108 = (TemplateInfo$TemplateImage) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            TemplateInfo$TemplateImage r109 = (TemplateInfo$TemplateImage) r101.decodeNullableSerializableElement(r100, 5, r106, null);
            long r112 = r101.decodeLongElement(r100, 6);
            long r113 = r101.decodeLongElement(r100, 7);
            long r114 = r101.decodeLongElement(r100, 8);
            UserCreation r210 = (UserCreation) r101.decodeNullableSerializableElement(r100, 9, UserCreation.a.f365004a, null);
            TemplateInfo$TemplateImage r115 = r108;
            long r211 = r114;
            int r116 = 1023;
            long r117 = r113;
            String r118 = r105;
            TemplateInfo$TemplateImage r119 = r107;
            TemplateInfo$TemplateType r120 = r104;
            long r121 = r111;
            TemplateInfo$TemplateImage r122 = r109;
            long r123 = r112;
        L27:
            r101.endStructure(r100);
            return new TemplateInfo$TemplateInfo(r116, r121, r120, r118, r119, r115, r122, r123, r117, r211, r210);
        L5:
            long r124 = 0;
            UserCreation r125 = null;
            TemplateInfo$TemplateImage r126 = null;
            TemplateInfo$TemplateImage r127 = null;
            String r128 = null;
            TemplateInfo$TemplateImage r129 = null;
            long r130 = 0;
            long r212 = 0;
            long r213 = 0;
            int r131 = 0;
            boolean r214 = true;
        L6:
            if (r214 == false) goto L26;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r132);
        L25:
            r103 = 8;
            r214 = false;
            goto L6
        L11:
            r125 = (UserCreation) r101.decodeNullableSerializableElement(r100, 9, UserCreation.a.f365004a, r125);
            r131 = r131 | 512;
        L24:
            r103 = 8;
            goto L6
        L12:
            r213 = r101.decodeLongElement(r100, r103);
            r131 = r131 | 256;
            goto L24
        L13:
            r130 = r101.decodeLongElement(r100, 7);
            r131 = r131 | 128;
            goto L24
        L14:
            r124 = r101.decodeLongElement(r100, 6);
            r131 = r131 | 64;
            goto L24
        L15:
            r127 = (TemplateInfo$TemplateImage) r101.decodeNullableSerializableElement(r100, 5, TemplateInfo$TemplateImage.a.f365413a, r127);
            r131 = r131 | 32;
            goto L24
        L16:
            r126 = (TemplateInfo$TemplateImage) r101.decodeNullableSerializableElement(r100, 4, TemplateInfo$TemplateImage.a.f365413a, r126);
            r131 = r131 | 16;
            goto L24
        L17:
            r129 = (TemplateInfo$TemplateImage) r101.decodeNullableSerializableElement(r100, 3, TemplateInfo$TemplateImage.a.f365413a, r129);
            r131 = r131 | 8;
            goto L24
        L19:
            r128 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r128);
            r131 = r131 | 4;
            goto L24
        L21:
            r110 = (TemplateInfo$TemplateType) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r110);
            r131 = r131 | 2;
            goto L24
        L23:
            r212 = r101.decodeLongElement(r100, 0);
            r131 = r131 | 1;
            goto L24
        L26:
            r210 = r125;
            r118 = r128;
            r119 = r129;
            r120 = r110;
            r117 = r130;
            r211 = r213;
            r115 = r126;
            r123 = r124;
            r116 = r131;
            r122 = r127;
            r121 = r212;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            TemplateInfo$TemplateInfo r112 = (TemplateInfo$TemplateInfo) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f365427b;
            muc.d r113 = r110.beginStructure(r100);
            Lazy<d<Object>>[] r101 = TemplateInfo$TemplateInfo.f365415k;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeLongElement(r100, 0, r112.f365416a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeNullableSerializableElement(r100, 1, r101[1].getValue(), r112.f365417b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeNullableSerializableElement(r100, 2, v2.f520790a, r112.f365418c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeNullableSerializableElement(r100, 3, TemplateInfo$TemplateImage.a.f365413a, r112.f365419d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeNullableSerializableElement(r100, 4, TemplateInfo$TemplateImage.a.f365413a, r112.f365420e);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeNullableSerializableElement(r100, 5, TemplateInfo$TemplateImage.a.f365413a, r112.f365421f);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            boolean r109 = true;
        L63:
            if (r109 == false) goto L66;
            r113.encodeLongElement(r100, 6, r112.f365422g);
        L66:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r113.encodeLongElement(r100, 7, r112.f365423h);
        L75:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r113.encodeLongElement(r100, 8, r112.f365424i);
        L84:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
        L88:
            r102 = true;
        L89:
            if (r102 == false) goto L91;
            r113.encodeNullableSerializableElement(r100, 9, UserCreation.a.f365004a, r112.f365425j);
        L91:
            r113.endStructure(r100);
            return;
        L87:
            if (r112.f365425j == null) goto L89;
        L78:
            if (r112.f365424i != 0) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r112.f365423h != (-1)) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r112.f365422g != (-1)) goto L61;
            r109 = false;
            goto L63
        L51:
            if (r112.f365421f != null) goto L52;
            r108 = false;
            goto L54
        L42:
            if (r112.f365420e != null) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f365419d != null) goto L34;
            r106 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r112.f365418c, "") == false) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f365417b != null) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f365416a != 0) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TemplateInfo$TemplateInfo> serializer() {
            return a.f365426a;
        }
    }

    public static final class c implements Parcelable.Creator<TemplateInfo$TemplateInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r100 = r110.readLong();
            UserCreation r101 = null;
            if (r110.readInt() != 0) goto L5;
            TemplateInfo$TemplateType r102 = null;
        L6:
            String r103 = r110.readString();
            if (r110.readInt() != 0) goto L9;
            TemplateInfo$TemplateImage r104 = null;
        L10:
            TemplateInfo$TemplateImage r105 = r104;
            if (r110.readInt() != 0) goto L13;
            TemplateInfo$TemplateImage r106 = null;
        L14:
            TemplateInfo$TemplateImage r107 = r106;
            if (r110.readInt() != 0) goto L17;
            TemplateInfo$TemplateImage r108 = null;
        L18:
            TemplateInfo$TemplateImage r111 = r108;
            long r112 = r110.readLong();
            long r113 = r110.readLong();
            long r114 = r110.readLong();
            if (r110.readInt() == 0) goto L23;
            r101 = UserCreation.CREATOR.createFromParcel(r110);
        L23:
            return new TemplateInfo$TemplateInfo(r100, r102, r103, r105, r107, r111, r112, r113, r114, r101);
        L17:
            r108 = TemplateInfo$TemplateImage.CREATOR.createFromParcel(r110);
            goto L18
        L13:
            r106 = TemplateInfo$TemplateImage.CREATOR.createFromParcel(r110);
            goto L14
        L9:
            r104 = TemplateInfo$TemplateImage.CREATOR.createFromParcel(r110);
            goto L10
        L5:
            r102 = TemplateInfo$TemplateType.valueOf(r110.readString());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateInfo[] newArray(int r100) {
            return new TemplateInfo$TemplateInfo[r100];
        }
    }

    public TemplateInfo$TemplateInfo() {
        this(0, null, null, null, null, 0, 0, 0, null, 1023);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TemplateInfo$TemplateInfo) == true) goto L8;
        return false;
    L8:
        TemplateInfo$TemplateInfo r101 = (TemplateInfo$TemplateInfo) r100;
        if (this.f365416a == r101.f365416a) goto L12;
        return false;
    L12:
        if (this.f365417b == r101.f365417b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365418c, r101.f365418c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365419d, r101.f365419d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365420e, r101.f365420e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365421f, r101.f365421f) == true) goto L27;
        return false;
    L27:
        if (this.f365422g == r101.f365422g) goto L30;
        return false;
    L30:
        if (this.f365423h == r101.f365423h) goto L33;
        return false;
    L33:
        if (this.f365424i == r101.f365424i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f365425j, r101.f365425j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f365416a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        TemplateInfo$TemplateType r102 = this.f365417b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f365418c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        TemplateInfo$TemplateImage r109 = this.f365419d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        TemplateInfo$TemplateImage r112 = this.f365420e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        TemplateInfo$TemplateImage r115 = this.f365421f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        long r117 = this.f365422g;
        int r118 = (((r114 + r116) * 31) + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.f365423h;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.f365424i;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        UserCreation r123 = this.f365425j;
        if (r123 == null) goto L27;
        r103 = r123.hashCode();
    L27:
        return r122 + r103;
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateInfo(id=" + this.f365416a + ", type=" + this.f365417b + ", prompt=" + this.f365418c + ", imageThumb=" + this.f365419d + ", imageOri=" + this.f365420e + ", imagePreview=" + this.f365421f + ", ratioId=" + this.f365422g + ", styleId=" + this.f365423h + ", templatePrimaryId=" + this.f365424i + ", userCreation=" + this.f365425j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f365416a);
        TemplateInfo$TemplateType r102 = this.f365417b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.f365418c);
        TemplateInfo$TemplateImage r103 = this.f365419d;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        TemplateInfo$TemplateImage r104 = this.f365420e;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        TemplateInfo$TemplateImage r105 = this.f365421f;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        r100.writeLong(this.f365422g);
        r100.writeLong(this.f365423h);
        r100.writeLong(this.f365424i);
        UserCreation r106 = this.f365425j;
        if (r106 != null) goto L21;
        r100.writeInt(0);
        return;
    L21:
        r100.writeInt(1);
        r106.writeToParcel(r100, r101);
        return;
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
        r100.writeString(r102.name());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
        f365415k = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new eq9.a()), null, null, null, null, null, null, null, null};
    }

    public final TemplateInfo$TemplateType getType() {
        return this.f365417b;
    }

    public /* synthetic */ TemplateInfo$TemplateInfo(long r210, String r211, TemplateInfo$TemplateImage r212, TemplateInfo$TemplateImage r213, TemplateInfo$TemplateImage r214, long r215, long r216, long r310, UserCreation r311, int r312) {
        long r100 = 0;
        if ((r312 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r312 & 4) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r312 & 8) == 0) goto L13;
        TemplateInfo$TemplateImage r103 = null;
    L15:
        if ((r312 & 16) == 0) goto L17;
        TemplateInfo$TemplateImage r110 = null;
    L19:
        if ((r312 & 32) == 0) goto L21;
        TemplateInfo$TemplateImage r111 = null;
    L23:
        if ((r312 & 64) == 0) goto L25;
        long r112 = -1;
    L27:
        if ((r312 & 128) == 0) goto L29;
        long r113 = -1;
    L31:
        if ((r312 & 256) != 0) goto L35;
        r100 = r310;
    L35:
        if ((r312 & 512) == 0) goto L37;
        UserCreation r114 = null;
    L38:
        this(r101, null, r102, r103, r110, r111, r112, r113, r100, r114);
        return;
    L37:
        r114 = r311;
        goto L38
    L29:
        r113 = r216;
        goto L31
    L25:
        r112 = r215;
        goto L27
    L21:
        r111 = r214;
        goto L23
    L17:
        r110 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }

    public TemplateInfo$TemplateInfo(long r100, TemplateInfo$TemplateType r101, String r102, TemplateInfo$TemplateImage r103, TemplateInfo$TemplateImage r104, TemplateInfo$TemplateImage r105, long r106, long r110, long r111, UserCreation r112) {
        this.f365416a = r100;
        this.f365417b = r101;
        this.f365418c = r102;
        this.f365419d = r103;
        this.f365420e = r104;
        this.f365421f = r105;
        this.f365422g = r106;
        this.f365423h = r110;
        this.f365424i = r111;
        this.f365425j = r112;
    }

    public TemplateInfo$TemplateInfo(int r110, long r111, TemplateInfo$TemplateType r112, String r113, TemplateInfo$TemplateImage r114, TemplateInfo$TemplateImage r115, TemplateInfo$TemplateImage r116, long r117, long r210, long r211, UserCreation r212) {
        if ((r110 & 0) != 0) goto L45;
        long r100 = 0;
        if ((r110 & 1) != 0) goto L7;
        this.f365416a = 0;
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.f365417b = null;
    L13:
        if ((r110 & 4) != 0) goto L15;
        String r101 = "";
    L16:
        this.f365418c = r101;
        if ((r110 & 8) != 0) goto L19;
        this.f365419d = null;
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.f365420e = null;
    L25:
        if ((r110 & 32) != 0) goto L27;
        this.f365421f = null;
    L28:
        long r102 = -1;
        if ((r110 & 64) != 0) goto L31;
        this.f365422g = -1;
    L33:
        if ((r110 & 128) == 0) goto L36;
        r102 = r210;
    L36:
        this.f365423h = r102;
        if ((r110 & 256) == 0) goto L40;
        r100 = r211;
    L40:
        this.f365424i = r100;
        if ((r110 & 512) != 0) goto L43;
        this.f365425j = null;
        return;
    L43:
        this.f365425j = r212;
        return;
    L31:
        this.f365422g = r117;
        goto L33
    L27:
        this.f365421f = r116;
        goto L28
    L23:
        this.f365420e = r115;
        goto L25
    L19:
        this.f365419d = r114;
        goto L21
    L15:
        r101 = r113;
        goto L16
    L11:
        this.f365417b = r112;
        goto L13
    L7:
        this.f365416a = r111;
        goto L9
    L45:
        b2.b(r110, 0, a.f365427b);
        throw null;
    }
}
