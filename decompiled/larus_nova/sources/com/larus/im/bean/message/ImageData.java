package com.larus.im.bean.message;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00060\u0001j\u0002`\u0002:\u0002JKB¯\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016B§\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00103J\u000b\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J¶\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\rHÖ\u0001J\t\u0010A\u001a\u00020\u0004HÖ\u0001J%\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u0012\u0004\b#\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001cR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001cR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001c¨\u0006L"}, d2 = {"Lcom/larus/im/bean/message/ImageData;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "key", "", "imageThumb", "Lcom/larus/im/bean/message/ImageObj;", "imageOrigin", "imagePreview", "imageThumbRaw", "imageOriRaw", "imagePreviewResize", "status", "", GXTemplateKey.GAIAX_PLACEHOLDER, "Lcom/larus/im/bean/message/ImagePlaceHolder;", "tips", "feedback", "requestId", DBDefinition.TASK_ID, "imageUri", "<init>", "(Ljava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/Integer;Lcom/larus/im/bean/message/ImagePlaceHolder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/Integer;Lcom/larus/im/bean/message/ImagePlaceHolder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getImageThumb$annotations", "getImageOrigin$annotations", "getImagePreview$annotations", "getImageThumbRaw$annotations", "getImageOriRaw$annotations", "getImagePreviewResize$annotations", "getStatus$annotations", "Ljava/lang/Integer;", "getPlaceholder$annotations", "getTips$annotations", "getFeedback$annotations", "getRequestId$annotations", "getTaskId$annotations", "getImageUri$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "()Ljava/lang/Integer;", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/Integer;Lcom/larus/im/bean/message/ImagePlaceHolder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/bean/message/ImageData;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ImageData implements java.io.Serializable {
    public static final b Companion = null;
    public final String feedback;
    public final ImageObj imageOriRaw;
    public final ImageObj imageOrigin;
    public final ImageObj imagePreview;
    public final ImageObj imagePreviewResize;
    public final ImageObj imageThumb;
    public final ImageObj imageThumbRaw;
    public final String imageUri;
    public final String key;
    public final ImagePlaceHolder placeholder;
    public final String requestId;
    public final Integer status;
    public final String taskId;
    public final String tips;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ImageData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346648b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346648b;
        }

        static {
            a r100 = new a();
            f346647a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ImageData", r100, 14);
            r101.j("key", true);
            r101.j("image_thumb", true);
            r101.j("image_ori", true);
            r101.j("image_preview", true);
            r101.j("image_thumb_raw", true);
            r101.j("image_ori_raw", true);
            r101.j("image_preview_resize", true);
            r101.j("status", true);
            r101.j(GXTemplateKey.GAIAX_PLACEHOLDER, true);
            r101.j("tips", true);
            r101.j("feedback", true);
            r101.j("request_id", true);
            r101.j("task_id", true);
            r101.j("image_uri", true);
            f346648b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            ImageObj.a r101 = ImageObj.a.f346651a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(w0.f520792a), kuc.a.d(ImagePlaceHolder.a.f346653a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346648b;
            muc.c r101 = r310.beginStructure(r100);
            int r110 = 10;
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            ImageObj.a r104 = ImageObj.a.f346651a;
            ImageObj r105 = (ImageObj) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            ImageObj r112 = (ImageObj) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            ImageObj r106 = (ImageObj) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            ImageObj r113 = (ImageObj) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            ImageObj r107 = (ImageObj) r101.decodeNullableSerializableElement(r100, 5, r104, null);
            ImageObj r108 = (ImageObj) r101.decodeNullableSerializableElement(r100, 6, r104, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, null);
            ImagePlaceHolder r114 = (ImagePlaceHolder) r101.decodeNullableSerializableElement(r100, 8, ImagePlaceHolder.a.f346653a, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 9, r103, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 10, r103, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 13, r103, null);
            String r211 = r118;
            ImageObj r119 = r108;
            ImageObj r120 = r107;
            Integer r212 = r109;
            ImagePlaceHolder r213 = r114;
            String r214 = r115;
            String r215 = r116;
            ImageObj r121 = r112;
            String r216 = r117;
            ImageObj r122 = r105;
            int r123 = 16383;
            ImageObj r124 = r113;
            String r125 = r111;
            ImageObj r126 = r106;
        L35:
            r101.endStructure(r100);
            return new ImageData(r123, r125, r122, r121, r126, r124, r120, r119, r212, r213, r214, r215, r216, r211, r210, null);
        L5:
            int r127 = 13;
            ImageObj r128 = null;
            ImageObj r129 = null;
            String r130 = null;
            ImageObj r131 = null;
            String r132 = null;
            Integer r133 = null;
            String r134 = null;
            ImageObj r135 = null;
            ImageObj r136 = null;
            String r137 = null;
            ImageObj r217 = null;
            String r218 = null;
            ImagePlaceHolder r219 = null;
            int r138 = 0;
            boolean r311 = true;
        L6:
            if (r311 == false) goto L34;
            int r139 = r101.decodeElementIndex(r100);
            switch(r139) {
                case -1: goto L32;
                case 0: goto L31;
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r139);
        L31:
            String r140 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r137);
            r138 = r138 | 1;
        L33:
            r217 = r217;
            r218 = r218;
            r219 = r219;
            r129 = r129;
            r102 = r102;
            r110 = 10;
            r127 = 13;
            r137 = r140;
            r128 = r128;
            goto L6
        L32:
            r140 = r137;
            r311 = false;
            goto L33
        L11:
            int r141 = r138 | 8192;
            r102 = (String) r101.decodeNullableSerializableElement(r100, r127, v2.f520790a, r102);
            r218 = r218;
            ImagePlaceHolder r142 = r219;
        L28:
            ImageObj r143 = r128;
            r138 = r141;
            r102 = r102;
        L30:
            r218 = r218;
            r219 = r142;
            r128 = r143;
            r110 = 10;
            r127 = 13;
            goto L6
        L13:
            r130 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r130);
            r141 = r138 | 4096;
        L19:
            r142 = r219;
            goto L28
        L14:
            r134 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r134);
            r141 = r138 | 2048;
            goto L19
        L15:
            r132 = (String) r101.decodeNullableSerializableElement(r100, r110, v2.f520790a, r132);
            r141 = r138 | 1024;
            goto L19
        L17:
            r102 = r102;
            r142 = r219;
            r218 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r218);
            r141 = r138 | 512;
            goto L28
        L18:
            r219 = (ImagePlaceHolder) r101.decodeNullableSerializableElement(r100, 8, ImagePlaceHolder.a.f346653a, r219);
            r141 = r138 | 256;
            goto L19
        L20:
            r102 = r102;
            r218 = r218;
            r142 = r219;
            r133 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, r133);
            r141 = r138 | 128;
            goto L28
        L22:
            r102 = r102;
            r218 = r218;
            r142 = r219;
            r135 = (ImageObj) r101.decodeNullableSerializableElement(r100, 6, ImageObj.a.f346651a, r135);
            r141 = r138 | 64;
            goto L28
        L23:
            r102 = r102;
            r218 = r218;
            r142 = r219;
            r136 = (ImageObj) r101.decodeNullableSerializableElement(r100, 5, ImageObj.a.f346651a, r136);
            r141 = r138 | 32;
            goto L28
        L24:
            r102 = r102;
            r218 = r218;
            r142 = r219;
            r131 = (ImageObj) r101.decodeNullableSerializableElement(r100, 4, ImageObj.a.f346651a, r131);
            r141 = r138 | 16;
            goto L28
        L26:
            r102 = r102;
            r218 = r218;
            r142 = r219;
            r128 = (ImageObj) r101.decodeNullableSerializableElement(r100, 3, ImageObj.a.f346651a, r128);
            r141 = r138 | 8;
            goto L28
        L27:
            r102 = r102;
            r218 = r218;
            r142 = r219;
            r129 = (ImageObj) r101.decodeNullableSerializableElement(r100, 2, ImageObj.a.f346651a, r129);
            r141 = r138 | 4;
            goto L28
        L29:
            String r220 = r102;
            r218 = r218;
            r142 = r219;
            r143 = r128;
            r217 = (ImageObj) r101.decodeNullableSerializableElement(r100, 1, ImageObj.a.f346651a, r217);
            r138 = r138 | 2;
            r102 = r220;
            goto L30
        L34:
            ImageObj r144 = r128;
            String r221 = r102;
            String r145 = r137;
            ImageObj r146 = r217;
            r211 = r130;
            r124 = r131;
            r215 = r132;
            r212 = r133;
            r216 = r134;
            r214 = r218;
            r213 = r219;
            r121 = r129;
            r126 = r144;
            r210 = r221;
            r119 = r135;
            r120 = r136;
            r123 = r138;
            r125 = r145;
            r122 = r146;
            goto L35
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ImageData r102 = (ImageData) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346648b;
            muc.d r104 = r100.beginStructure(r103);
            ImageData.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ImageData> serializer() {
            return a.f346647a;
        }
    }

    public ImageData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ ImageData copy$default(ImageData r110, String r111, ImageObj r112, ImageObj r113, ImageObj r114, ImageObj r210, ImageObj r211, ImageObj r212, Integer r213, ImagePlaceHolder r214, String r215, String r216, String r217, String r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r310 & 2) == 0) goto L9;
        ImageObj r101 = r110.imageThumb;
    L11:
        if ((r310 & 4) == 0) goto L13;
        ImageObj r102 = r110.imageOrigin;
    L15:
        if ((r310 & 8) == 0) goto L17;
        ImageObj r103 = r110.imagePreview;
    L19:
        if ((r310 & 16) == 0) goto L21;
        ImageObj r104 = r110.imageThumbRaw;
    L23:
        if ((r310 & 32) == 0) goto L25;
        ImageObj r105 = r110.imageOriRaw;
    L27:
        if ((r310 & 64) == 0) goto L29;
        ImageObj r106 = r110.imagePreviewResize;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r107 = r110.status;
    L35:
        if ((r310 & 256) == 0) goto L37;
        ImagePlaceHolder r115 = r110.placeholder;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.tips;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.feedback;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.requestId;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r119 = r110.taskId;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.imageUri;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
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

    @SerialName("feedback")
    public static /* synthetic */ void getFeedback$annotations() {
    }

    @SerialName("image_ori_raw")
    public static /* synthetic */ void getImageOriRaw$annotations() {
    }

    @SerialName("image_ori")
    public static /* synthetic */ void getImageOrigin$annotations() {
    }

    @SerialName("image_preview")
    public static /* synthetic */ void getImagePreview$annotations() {
    }

    @SerialName("image_preview_resize")
    public static /* synthetic */ void getImagePreviewResize$annotations() {
    }

    @SerialName("image_thumb")
    public static /* synthetic */ void getImageThumb$annotations() {
    }

    @SerialName("image_thumb_raw")
    public static /* synthetic */ void getImageThumbRaw$annotations() {
    }

    @SerialName("image_uri")
    public static /* synthetic */ void getImageUri$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName(GXTemplateKey.GAIAX_PLACEHOLDER)
    public static /* synthetic */ void getPlaceholder$annotations() {
    }

    @SerialName("request_id")
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("task_id")
    public static /* synthetic */ void getTaskId$annotations() {
    }

    @SerialName("tips")
    public static /* synthetic */ void getTips$annotations() {
    }

    public final String component1() {
        return this.key;
    }

    public final String component10() {
        return this.tips;
    }

    public final String component11() {
        return this.feedback;
    }

    public final String component12() {
        return this.requestId;
    }

    public final String component13() {
        return this.taskId;
    }

    public final String component14() {
        return this.imageUri;
    }

    public final ImageObj component2() {
        return this.imageThumb;
    }

    public final ImageObj component3() {
        return this.imageOrigin;
    }

    public final ImageObj component4() {
        return this.imagePreview;
    }

    public final ImageObj component5() {
        return this.imageThumbRaw;
    }

    public final ImageObj component6() {
        return this.imageOriRaw;
    }

    public final ImageObj component7() {
        return this.imagePreviewResize;
    }

    public final Integer component8() {
        return this.status;
    }

    public final ImagePlaceHolder component9() {
        return this.placeholder;
    }

    public final ImageData copy(String r110, ImageObj r111, ImageObj r112, ImageObj r210, ImageObj r211, ImageObj r212, ImageObj r213, @ImageStatus Integer r214, ImagePlaceHolder r215, String r216, String r217, String r218, String r219, String r310) {
        return new ImageData(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageData) == true) goto L8;
        return false;
    L8:
        ImageData r101 = (ImageData) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageOrigin, r101.imageOrigin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imagePreview, r101.imagePreview) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageThumbRaw, r101.imageThumbRaw) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageOriRaw, r101.imageOriRaw) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imagePreviewResize, r101.imagePreviewResize) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.placeholder, r101.placeholder) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.feedback, r101.feedback) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.imageUri, r101.imageUri) == true) goto L50;
        return false;
    L50:
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
        ImageObj r107 = this.imageOrigin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ImageObj r110 = this.imagePreview;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ImageObj r113 = this.imageThumbRaw;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ImageObj r116 = this.imageOriRaw;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ImageObj r119 = this.imagePreviewResize;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.status;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ImagePlaceHolder r125 = this.placeholder;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.tips;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.feedback;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.requestId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.taskId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.imageUri;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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

    public String toString() {
        return "ImageData(key=" + this.key + ", imageThumb=" + this.imageThumb + ", imageOrigin=" + this.imageOrigin + ", imagePreview=" + this.imagePreview + ", imageThumbRaw=" + this.imageThumbRaw + ", imageOriRaw=" + this.imageOriRaw + ", imagePreviewResize=" + this.imagePreviewResize + ", status=" + this.status + ", placeholder=" + this.placeholder + ", tips=" + this.tips + ", feedback=" + this.feedback + ", requestId=" + this.requestId + ", taskId=" + this.taskId + ", imageUri=" + this.imageUri + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ImageData r100, muc.d r101, f r102) {
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
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, ImageObj.a.f346651a, r100.imageOrigin);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, ImageObj.a.f346651a, r100.imagePreview);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, ImageObj.a.f346651a, r100.imageThumbRaw);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, ImageObj.a.f346651a, r100.imageOriRaw);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, ImageObj.a.f346651a, r100.imagePreviewResize);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, w0.f520792a, r100.status);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, ImagePlaceHolder.a.f346653a, r100.placeholder);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.tips);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.feedback);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, v2.f520790a, r100.requestId);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, v2.f520790a, r100.taskId);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        r103 = true;
    L125:
        if (r103 == false) goto L128;
        r101.encodeNullableSerializableElement(r102, 13, v2.f520790a, r100.imageUri);
        return;
    L128:
        return;
    L123:
        if (r100.imageUri == null) goto L125;
    L114:
        if (r100.taskId != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.requestId != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.feedback != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.tips != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.placeholder != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.status != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.imagePreviewResize != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.imageOriRaw != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.imageThumbRaw != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.imagePreview != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.imageOrigin != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.imageThumb != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.key != null) goto L4;
        r104 = false;
        goto L9
    }

    public ImageData(String r100, ImageObj r101, ImageObj r102, ImageObj r103, ImageObj r104, ImageObj r105, ImageObj r106, @ImageStatus Integer r107, ImagePlaceHolder r108, String r110, String r111, String r112, String r113, String r114) {
        this.key = r100;
        this.imageThumb = r101;
        this.imageOrigin = r102;
        this.imagePreview = r103;
        this.imageThumbRaw = r104;
        this.imageOriRaw = r105;
        this.imagePreviewResize = r106;
        this.status = r107;
        this.placeholder = r108;
        this.tips = r110;
        this.feedback = r111;
        this.requestId = r112;
        this.taskId = r113;
        this.imageUri = r114;
    }

    public ImageData(int r100, String r101, ImageObj r102, ImageObj r103, ImageObj r110, ImageObj r111, ImageObj r112, ImageObj r113, Integer r114, ImagePlaceHolder r115, String r116, String r117, String r118, String r119, String r210, q2 r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346648b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.key = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.imageThumb = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imageOrigin = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.imagePreview = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.imageThumbRaw = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.imageOriRaw = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.imagePreviewResize = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.status = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.placeholder = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.tips = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.feedback = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.requestId = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.taskId = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.imageUri = null;
        return;
    L59:
        this.imageUri = r210;
        return;
    L55:
        this.taskId = r119;
        goto L57
    L51:
        this.requestId = r118;
        goto L53
    L47:
        this.feedback = r117;
        goto L49
    L43:
        this.tips = r116;
        goto L45
    L39:
        this.placeholder = r115;
        goto L41
    L35:
        this.status = r114;
        goto L37
    L31:
        this.imagePreviewResize = r113;
        goto L33
    L27:
        this.imageOriRaw = r112;
        goto L29
    L23:
        this.imageThumbRaw = r111;
        goto L25
    L19:
        this.imagePreview = r110;
        goto L21
    L15:
        this.imageOrigin = r103;
        goto L17
    L11:
        this.imageThumb = r102;
        goto L13
    L7:
        this.key = r101;
        goto L9
    }

    public /* synthetic */ ImageData(String r110, ImageObj r111, ImageObj r112, ImageObj r113, ImageObj r210, ImageObj r211, ImageObj r212, Integer r213, ImagePlaceHolder r214, String r215, String r216, String r217, String r218, String r219, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        ImageObj r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        ImageObj r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        ImageObj r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        ImageObj r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        ImageObj r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        ImageObj r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        ImagePlaceHolder r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
