package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 _2\u00060\u0001j\u0002`\u0002:\u0002^_B\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\u007f\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\b\u0010D\u001a\u00020\u0004H\u0016J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010@J\u0086\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\bHÖ\u0001J%\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0001¢\u0006\u0002\b]R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010)\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010/\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR&\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0019\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u0019\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR&\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u0019\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR(\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010C\u0012\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006`"}, d2 = {"Lcom/larus/im/bean/message/UplinkFileInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "fileName", "", "tosKey", "md5", "fileType", "", "size", "", "resourceId", "video", "Lcom/larus/im/bean/message/VideoExtension;", DBDefinition.MIME_TYPE, "localResPath", "duration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/message/VideoExtension;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/message/VideoExtension;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFileName$annotations", "()V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getTosKey$annotations", "getTosKey", "setTosKey", "getMd5$annotations", "getMd5", "setMd5", "getFileType$annotations", "getFileType", "()Ljava/lang/Integer;", "setFileType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSize$annotations", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getResourceId$annotations", "getResourceId", "setResourceId", "getVideo$annotations", "getVideo", "()Lcom/larus/im/bean/message/VideoExtension;", "setVideo", "(Lcom/larus/im/bean/message/VideoExtension;)V", "getMimeType$annotations", "getMimeType", "setMimeType", "getLocalResPath$annotations", "getLocalResPath", "setLocalResPath", "getDuration$annotations", "getDuration", "()Ljava/lang/Float;", "setDuration", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/message/VideoExtension;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)Lcom/larus/im/bean/message/UplinkFileInfo;", "equals", "", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UplinkFileInfo implements java.io.Serializable {
    public static final b Companion = null;
    private Float duration;
    private String fileName;
    private Integer fileType;
    private String localResPath;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f346740md5;
    private String mimeType;
    private String resourceId;
    private Long size;
    private String tosKey;
    private VideoExtension video;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UplinkFileInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346741a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346742b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346742b;
        }

        static {
            a r100 = new a();
            f346741a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.UplinkFileInfo", r100, 10);
            r101.j("file_name", true);
            r101.j("key", true);
            r101.j("md5", true);
            r101.j("file_type", true);
            r101.j("size", true);
            r101.j("resource_id", true);
            r101.j("video", true);
            r101.j("mime_type", true);
            r101.j("local_res_path", true);
            r101.j("duration", true);
            f346742b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(w0.f520792a), kuc.a.d(g1.f520681a), kuc.a.d(r100), kuc.a.d(VideoExtension.a.f346760a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(l0.f520731a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346742b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 8;
            int r103 = 6;
            int r104 = 7;
            String r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r105 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, null);
            Long r113 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 5, r105, null);
            VideoExtension r109 = (VideoExtension) r101.decodeNullableSerializableElement(r100, 6, VideoExtension.a.f346760a, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 7, r105, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 8, r105, null);
            Float r116 = (Float) r101.decodeNullableSerializableElement(r100, 9, l0.f520731a, null);
            String r117 = r108;
            VideoExtension r118 = r109;
            String r119 = r114;
            String r120 = r111;
            int r121 = 1023;
            Integer r122 = r107;
            String r123 = r106;
            String r124 = r112;
            Long r125 = r113;
        L27:
            r101.endStructure(r100);
            return new UplinkFileInfo(r121, r120, r124, r123, r122, r125, r117, r118, r119, r115, r116, null);
        L5:
            Float r126 = null;
            String r127 = null;
            String r128 = null;
            String r129 = null;
            VideoExtension r130 = null;
            Integer r131 = null;
            Long r132 = null;
            String r133 = null;
            String r211 = null;
            int r134 = 0;
            boolean r212 = true;
        L6:
            if (r212 == false) goto L26;
            int r135 = r101.decodeElementIndex(r100);
            switch(r135) {
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
            throw new UnknownFieldException(r135);
        L25:
            r102 = 8;
            r103 = 6;
            r104 = 7;
            r212 = false;
            goto L6
        L11:
            r126 = (Float) r101.decodeNullableSerializableElement(r100, 9, l0.f520731a, r126);
            r134 = r134 | 512;
        L20:
            String r136 = r133;
        L22:
            String r137 = r211;
        L24:
            r133 = r136;
            r211 = r137;
            r102 = 8;
            r103 = 6;
            r104 = 7;
            goto L6
        L12:
            r127 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r127);
            r134 = r134 | 256;
            goto L20
        L13:
            r128 = (String) r101.decodeNullableSerializableElement(r100, r104, v2.f520790a, r128);
            r134 = r134 | 128;
            goto L20
        L14:
            r130 = (VideoExtension) r101.decodeNullableSerializableElement(r100, r103, VideoExtension.a.f346760a, r130);
            r134 = r134 | 64;
            goto L20
        L16:
            r129 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r129);
            r134 = r134 | 32;
            goto L20
        L17:
            r132 = (Long) r101.decodeNullableSerializableElement(r100, 4, g1.f520681a, r132);
            r134 = r134 | 16;
            goto L20
        L18:
            r131 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r131);
            r134 = r134 | 8;
            goto L20
        L19:
            r133 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r133);
            r134 = r134 | 4;
            goto L20
        L21:
            r136 = r133;
            r211 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r211);
            r134 = r134 | 2;
            goto L22
        L23:
            r136 = r133;
            r137 = r211;
            r134 = r134 | 1;
            r110 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r110);
            goto L24
        L26:
            r121 = r134;
            r116 = r126;
            r115 = r127;
            r120 = r110;
            r124 = r211;
            r117 = r129;
            r122 = r131;
            r118 = r130;
            r125 = r132;
            r119 = r128;
            r123 = r133;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UplinkFileInfo r102 = (UplinkFileInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346742b;
            muc.d r104 = r100.beginStructure(r103);
            UplinkFileInfo.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UplinkFileInfo> serializer() {
            return a.f346741a;
        }
    }

    public UplinkFileInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ UplinkFileInfo copy$default(UplinkFileInfo r110, String r111, String r112, String r113, Integer r114, Long r115, String r116, VideoExtension r117, String r118, String r210, Float r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.fileName;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.tosKey;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.f346740md5;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r103 = r110.fileType;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Long r104 = r110.size;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.resourceId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        VideoExtension r106 = r110.video;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.mimeType;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.localResPath;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Float r108 = r110.duration;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
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

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("file_name")
    public static /* synthetic */ void getFileName$annotations() {
    }

    @SerialName("file_type")
    public static /* synthetic */ void getFileType$annotations() {
    }

    @SerialName("local_res_path")
    public static /* synthetic */ void getLocalResPath$annotations() {
    }

    @SerialName("md5")
    public static /* synthetic */ void getMd5$annotations() {
    }

    @SerialName("mime_type")
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @SerialName("resource_id")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("size")
    public static /* synthetic */ void getSize$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getTosKey$annotations() {
    }

    @SerialName("video")
    public static /* synthetic */ void getVideo$annotations() {
    }

    public final String component1() {
        return this.fileName;
    }

    public final Float component10() {
        return this.duration;
    }

    public final String component2() {
        return this.tosKey;
    }

    public final String component3() {
        return this.f346740md5;
    }

    public final Integer component4() {
        return this.fileType;
    }

    public final Long component5() {
        return this.size;
    }

    public final String component6() {
        return this.resourceId;
    }

    public final VideoExtension component7() {
        return this.video;
    }

    public final String component8() {
        return this.mimeType;
    }

    public final String component9() {
        return this.localResPath;
    }

    public final UplinkFileInfo copy(String r110, String r111, String r112, Integer r113, Long r114, String r115, VideoExtension r116, String r210, String r211, Float r212) {
        return new UplinkFileInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UplinkFileInfo) == true) goto L8;
        return false;
    L8:
        UplinkFileInfo r101 = (UplinkFileInfo) r100;
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tosKey, r101.tosKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f346740md5, r101.f346740md5) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileType, r101.fileType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.localResPath, r101.localResPath) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.fileName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tosKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f346740md5;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.fileType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.size;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.resourceId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        VideoExtension r119 = this.video;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.mimeType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.localResPath;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Float r128 = this.duration;
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

    static {
        Companion = new b();
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(xt7.d.f565073b.a(Companion.serializer(), this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Float getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Integer getFileType() {
        return this.fileType;
    }

    public final String getLocalResPath() {
        return this.localResPath;
    }

    public final String getMd5() {
        return this.f346740md5;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final VideoExtension getVideo() {
        return this.video;
    }

    public final void setDuration(Float r100) {
        this.duration = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setFileType(Integer r100) {
        this.fileType = r100;
    }

    public final void setLocalResPath(String r100) {
        this.localResPath = r100;
    }

    public final void setMd5(String r100) {
        this.f346740md5 = r100;
    }

    public final void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public final void setResourceId(String r100) {
        this.resourceId = r100;
    }

    public final void setSize(Long r100) {
        this.size = r100;
    }

    public final void setTosKey(String r100) {
        this.tosKey = r100;
    }

    public final void setVideo(VideoExtension r100) {
        this.video = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(UplinkFileInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.fileName);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.tosKey);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.f346740md5);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.fileType);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, g1.f520681a, r100.size);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.resourceId);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, VideoExtension.a.f346760a, r100.video);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.mimeType);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.localResPath);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        r103 = true;
    L89:
        if (r103 == false) goto L92;
        r101.encodeNullableSerializableElement(r102, 9, l0.f520731a, r100.duration);
        return;
    L92:
        return;
    L87:
        if (r100.duration == null) goto L89;
    L78:
        if (r100.localResPath != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.mimeType != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.video != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.resourceId != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.size != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.fileType != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.f346740md5 != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.tosKey != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.fileName != null) goto L4;
        r104 = false;
        goto L9
    }

    public UplinkFileInfo(String r100, String r101, String r102, Integer r103, Long r104, String r105, VideoExtension r106, String r107, String r108, Float r110) {
        this.fileName = r100;
        this.tosKey = r101;
        this.f346740md5 = r102;
        this.fileType = r103;
        this.size = r104;
        this.resourceId = r105;
        this.video = r106;
        this.mimeType = r107;
        this.localResPath = r108;
        this.duration = r110;
    }

    public UplinkFileInfo(int r100, String r101, String r102, String r103, Integer r104, Long r105, String r106, VideoExtension r107, String r110, String r111, Float r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346742b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.fileName = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.tosKey = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f346740md5 = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.fileType = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.size = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.resourceId = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.video = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.mimeType = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.localResPath = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.duration = null;
        return;
    L43:
        this.duration = r112;
        return;
    L39:
        this.localResPath = r111;
        goto L41
    L35:
        this.mimeType = r110;
        goto L37
    L31:
        this.video = r107;
        goto L33
    L27:
        this.resourceId = r106;
        goto L29
    L23:
        this.size = r105;
        goto L25
    L19:
        this.fileType = r104;
        goto L21
    L15:
        this.f346740md5 = r103;
        goto L17
    L11:
        this.tosKey = r102;
        goto L13
    L7:
        this.fileName = r101;
        goto L9
    }

    public /* synthetic */ UplinkFileInfo(String r110, String r111, String r112, Integer r113, Long r114, String r115, VideoExtension r116, String r117, String r210, Float r211, int r212, DefaultConstructorMarker r213) {
        Float r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        VideoExtension r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
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
