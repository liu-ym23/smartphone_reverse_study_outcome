package com.larus.im.bean.message;

import com.alibaba.gaiax.template.GXTemplateKey;
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
import nuc.b0;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001J%\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0001¢\u0006\u0002\bDR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u0012\u0004\b\u001c\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001aR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u0012\u0004\b\u001f\u0010\u001aR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u0012\u0004\b!\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u0012\u0004\b\"\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001a¨\u0006G"}, d2 = {"Lcom/larus/im/bean/message/VideoData;", "", "vid", "", "cover", "Lcom/larus/im/bean/message/Cover;", "status", "", GXTemplateKey.GAIAX_PLACEHOLDER, "Lcom/larus/im/bean/message/VideoPlaceHolder;", "width", "", "height", "duration", "", "videoType", "downloadUrl", "downloadFilehash", "videoModel", "<init>", "(Ljava/lang/String;Lcom/larus/im/bean/message/Cover;Ljava/lang/Integer;Lcom/larus/im/bean/message/VideoPlaceHolder;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/bean/message/Cover;Ljava/lang/Integer;Lcom/larus/im/bean/message/VideoPlaceHolder;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "()V", "getCover$annotations", "getStatus$annotations", "Ljava/lang/Integer;", "getPlaceholder$annotations", "getWidth$annotations", "Ljava/lang/Long;", "getHeight$annotations", "getDuration$annotations", "Ljava/lang/Double;", "getVideoType$annotations", "getDownloadUrl$annotations", "getDownloadFilehash$annotations", "getVideoModel$annotations", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "()Ljava/lang/Long;", "component6", "component7", "()Ljava/lang/Double;", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Lcom/larus/im/bean/message/Cover;Ljava/lang/Integer;Lcom/larus/im/bean/message/VideoPlaceHolder;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/bean/message/VideoData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class VideoData {
    public static final b Companion = null;
    public final Cover cover;
    public final String downloadFilehash;
    public final String downloadUrl;
    public final Double duration;
    public final Long height;
    public final VideoPlaceHolder placeholder;
    public final Integer status;
    public final String vid;
    public final String videoModel;
    public final String videoType;
    public final Long width;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346758a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346759b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346759b;
        }

        static {
            a r100 = new a();
            f346758a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.VideoData", r100, 11);
            r101.j("vid", true);
            r101.j("cover", true);
            r101.j("status", true);
            r101.j(GXTemplateKey.GAIAX_PLACEHOLDER, true);
            r101.j("width", true);
            r101.j("height", true);
            r101.j("duration", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE, true);
            r101.j("download_url", true);
            r101.j("download_filehash", true);
            r101.j("video_model", true);
            f346759b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            g1 r101 = g1.f520681a;
            return new d[]{kuc.a.d(r100), kuc.a.d(Cover.a.f346614a), kuc.a.d(w0.f520792a), kuc.a.d(VideoPlaceHolder.a.f346762a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(b0.f520644a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346759b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 7;
            int r103 = 9;
            int r104 = 10;
            int r110 = 8;
            Cover r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r105 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            Cover r113 = (Cover) r101.decodeNullableSerializableElement(r100, 1, Cover.a.f346614a, null);
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, null);
            VideoPlaceHolder r107 = (VideoPlaceHolder) r101.decodeNullableSerializableElement(r100, 3, VideoPlaceHolder.a.f346762a, null);
            g1 r114 = g1.f520681a;
            Long r115 = (Long) r101.decodeNullableSerializableElement(r100, 4, r114, null);
            Long r108 = (Long) r101.decodeNullableSerializableElement(r100, 5, r114, null);
            Double r109 = (Double) r101.decodeNullableSerializableElement(r100, 6, b0.f520644a, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 7, r105, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 8, r105, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 10, r105, null);
            Double r120 = r109;
            String r121 = r116;
            String r122 = r118;
            String r123 = r117;
            String r124 = r112;
            int r125 = 2047;
            VideoPlaceHolder r126 = r107;
            Long r127 = r115;
            Integer r128 = r106;
            Cover r129 = r113;
            Long r130 = r108;
        L29:
            r101.endStructure(r100);
            return new VideoData(r125, r124, r129, r128, r126, r127, r130, r120, r121, r123, r122, r119, null);
        L5:
            String r131 = null;
            String r132 = null;
            String r133 = null;
            String r134 = null;
            r127 = null;
            VideoPlaceHolder r135 = null;
            String r136 = null;
            Integer r137 = null;
            Double r211 = null;
            Long r212 = null;
            int r138 = 0;
            boolean r213 = true;
        L6:
            if (r213 == false) goto L28;
            int r139 = r101.decodeElementIndex(r100);
            switch(r139) {
                case -1: goto L27;
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r139);
        L27:
            r102 = 7;
            r103 = 9;
            r104 = 10;
            r110 = 8;
            r213 = false;
            goto L6
        L11:
            r134 = (String) r101.decodeNullableSerializableElement(r100, r104, v2.f520790a, r134);
            r138 = r138 | 1024;
        L15:
            Double r140 = r211;
        L18:
            Long r141 = r212;
        L20:
            Integer r142 = r137;
        L26:
            r211 = r140;
            r212 = r141;
            r137 = r142;
            r102 = 7;
            r103 = 9;
            r104 = 10;
            r110 = 8;
            goto L6
        L12:
            r131 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r131);
            r138 = r138 | 512;
            goto L15
        L13:
            r133 = (String) r101.decodeNullableSerializableElement(r100, r110, v2.f520790a, r133);
            r138 = r138 | 256;
            goto L15
        L14:
            r132 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r132);
            r138 = r138 | 128;
            goto L15
        L16:
            r138 = r138 | 64;
            r140 = (Double) r101.decodeNullableSerializableElement(r100, 6, b0.f520644a, r211);
            goto L18
        L17:
            r140 = r211;
            r212 = (Long) r101.decodeNullableSerializableElement(r100, 5, g1.f520681a, r212);
            r138 = r138 | 32;
            goto L18
        L19:
            r140 = r211;
            r141 = r212;
            r127 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, r127);
            r138 = r138 | 16;
            goto L20
        L21:
            r140 = r211;
            r141 = r212;
            r135 = (VideoPlaceHolder) r101.decodeNullableSerializableElement(r100, 3, VideoPlaceHolder.a.f346762a, r135);
            r138 = r138 | 8;
            goto L20
        L22:
            r140 = r211;
            r141 = r212;
            r137 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r137);
            r138 = r138 | 4;
            goto L20
        L23:
            r142 = r137;
            r140 = r211;
            r141 = r212;
            r111 = (Cover) r101.decodeNullableSerializableElement(r100, 1, Cover.a.f346614a, r111);
            r138 = r138 | 2;
            goto L26
        L25:
            r142 = r137;
            r140 = r211;
            r141 = r212;
            r138 = r138 | 1;
            r136 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r136);
            goto L26
        L28:
            Integer r143 = r137;
            r122 = r131;
            r123 = r133;
            r119 = r134;
            r126 = r135;
            r129 = r111;
            r120 = r211;
            r130 = r212;
            r128 = r143;
            r124 = r136;
            r125 = r138;
            r121 = r132;
            goto L29
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            VideoData r102 = (VideoData) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346759b;
            muc.d r104 = r100.beginStructure(r103);
            VideoData.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<VideoData> serializer() {
            return a.f346758a;
        }
    }

    public VideoData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ VideoData copy$default(VideoData r110, String r111, Cover r112, Integer r113, VideoPlaceHolder r114, Long r115, Long r116, Double r117, String r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.vid;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Cover r101 = r110.cover;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r102 = r110.status;
    L15:
        if ((r214 & 8) == 0) goto L17;
        VideoPlaceHolder r103 = r110.placeholder;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Long r104 = r110.width;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Long r105 = r110.height;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Double r106 = r110.duration;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.videoType;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.downloadUrl;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.downloadFilehash;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.videoModel;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
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

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("download_filehash")
    public static /* synthetic */ void getDownloadFilehash$annotations() {
    }

    @SerialName("download_url")
    public static /* synthetic */ void getDownloadUrl$annotations() {
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName(GXTemplateKey.GAIAX_PLACEHOLDER)
    public static /* synthetic */ void getPlaceholder$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    @SerialName("video_model")
    public static /* synthetic */ void getVideoModel$annotations() {
    }

    @SerialName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE)
    public static /* synthetic */ void getVideoType$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final String component1() {
        return this.vid;
    }

    public final String component10() {
        return this.downloadFilehash;
    }

    public final String component11() {
        return this.videoModel;
    }

    public final Cover component2() {
        return this.cover;
    }

    public final Integer component3() {
        return this.status;
    }

    public final VideoPlaceHolder component4() {
        return this.placeholder;
    }

    public final Long component5() {
        return this.width;
    }

    public final Long component6() {
        return this.height;
    }

    public final Double component7() {
        return this.duration;
    }

    public final String component8() {
        return this.videoType;
    }

    public final String component9() {
        return this.downloadUrl;
    }

    public final VideoData copy(String r110, Cover r111, @VideoStatus Integer r112, VideoPlaceHolder r113, Long r114, Long r115, Double r210, String r211, String r212, String r213, String r214) {
        return new VideoData(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoData) == true) goto L8;
        return false;
    L8:
        VideoData r101 = (VideoData) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.placeholder, r101.placeholder) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.videoType, r101.videoType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.downloadFilehash, r101.downloadFilehash) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.videoModel, r101.videoModel) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Cover r104 = this.cover;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.status;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        VideoPlaceHolder r110 = this.placeholder;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.width;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.height;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.duration;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.videoType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.downloadUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.downloadFilehash;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.videoModel;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "VideoData(vid=" + this.vid + ", cover=" + this.cover + ", status=" + this.status + ", placeholder=" + this.placeholder + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", videoType=" + this.videoType + ", downloadUrl=" + this.downloadUrl + ", downloadFilehash=" + this.downloadFilehash + ", videoModel=" + this.videoModel + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(VideoData r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.vid);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, Cover.a.f346614a, r100.cover);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.status);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, VideoPlaceHolder.a.f346762a, r100.placeholder);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, g1.f520681a, r100.width);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, g1.f520681a, r100.height);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, b0.f520644a, r100.duration);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.videoType);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.downloadUrl);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.downloadFilehash);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        r103 = true;
    L98:
        if (r103 == false) goto L101;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.videoModel);
        return;
    L101:
        return;
    L96:
        if (r100.videoModel == null) goto L98;
    L87:
        if (r100.downloadFilehash != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.downloadUrl != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.videoType != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.duration != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.height != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.width != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.placeholder != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.status != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.cover != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.vid != null) goto L4;
        r104 = false;
        goto L9
    }

    public VideoData(String r100, Cover r101, @VideoStatus Integer r102, VideoPlaceHolder r103, Long r104, Long r105, Double r106, String r107, String r108, String r110, String r111) {
        this.vid = r100;
        this.cover = r101;
        this.status = r102;
        this.placeholder = r103;
        this.width = r104;
        this.height = r105;
        this.duration = r106;
        this.videoType = r107;
        this.downloadUrl = r108;
        this.downloadFilehash = r110;
        this.videoModel = r111;
    }

    public VideoData(int r100, String r101, Cover r102, Integer r103, VideoPlaceHolder r104, Long r105, Long r106, Double r107, String r110, String r111, String r112, String r113, q2 r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346759b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.vid = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.cover = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.status = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.placeholder = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.width = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.height = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.duration = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.videoType = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.downloadUrl = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.downloadFilehash = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.videoModel = null;
        return;
    L47:
        this.videoModel = r113;
        return;
    L43:
        this.downloadFilehash = r112;
        goto L45
    L39:
        this.downloadUrl = r111;
        goto L41
    L35:
        this.videoType = r110;
        goto L37
    L31:
        this.duration = r107;
        goto L33
    L27:
        this.height = r106;
        goto L29
    L23:
        this.width = r105;
        goto L25
    L19:
        this.placeholder = r104;
        goto L21
    L15:
        this.status = r103;
        goto L17
    L11:
        this.cover = r102;
        goto L13
    L7:
        this.vid = r101;
        goto L9
    }

    public /* synthetic */ VideoData(String r110, Cover r111, Integer r112, VideoPlaceHolder r113, Long r114, Long r115, Double r116, String r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Cover r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        VideoPlaceHolder r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Long r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Double r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
