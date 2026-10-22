package com.larus.bmhome.actionbar.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 d2\u00060\u0001j\u0002`\u0002:\u0002cdB\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014BW\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0013\u0010\u0019J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010DJ\u009e\u0001\u0010T\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00122\b\u0010W\u001a\u0004\u0018\u00010XHÖ\u0003J\t\u0010Y\u001a\u00020\u0016HÖ\u0001J\t\u0010Z\u001a\u00020\u0004HÖ\u0001J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR&\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR&\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u001b\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR&\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR&\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR&\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR&\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u001b\u001a\u0004\b@\u0010\u001d\"\u0004\bA\u0010\u001fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010G\u0012\u0004\bB\u0010\u001b\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006e"}, d2 = {"Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "url", "", "uri", "imageUploadInfo", "Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "videoUploadInfo", "Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;", "localFilePath", LocationMonitorConst.IDENTIFIER, "resourceId", "localMessageId", "originUrl", "previewUrl", "maskUri", "aiCreationImage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUri$annotations", "getUri", "setUri", "getImageUploadInfo$annotations", "getImageUploadInfo", "()Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "setImageUploadInfo", "(Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;)V", "getVideoUploadInfo$annotations", "getVideoUploadInfo", "()Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;", "setVideoUploadInfo", "(Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;)V", "getLocalFilePath$annotations", "getLocalFilePath", "setLocalFilePath", "getIdentifier$annotations", "getIdentifier", "setIdentifier", "getResourceId$annotations", "getResourceId", "setResourceId", "getLocalMessageId$annotations", "getLocalMessageId", "setLocalMessageId", "getOriginUrl$annotations", "getOriginUrl", "setOriginUrl", "getPreviewUrl$annotations", "getPreviewUrl", "setPreviewUrl", "getMaskUri$annotations", "getMaskUri", "setMaskUri", "getAiCreationImage$annotations", "getAiCreationImage", "()Ljava/lang/Boolean;", "setAiCreationImage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$instruction_core_api_release", "$serializer", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class MediaAttachment implements java.io.Serializable {
    public static final b Companion = null;
    private Boolean aiCreationImage;
    private String identifier;
    private ImageUploadInfo imageUploadInfo;
    private String localFilePath;
    private String localMessageId;
    private String maskUri;
    private String originUrl;
    private String previewUrl;
    private String resourceId;
    private String uri;
    private String url;
    private VideoUploadInfo videoUploadInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<MediaAttachment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f294940a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f294941b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(ImageUploadInfo.a.f294938a), kuc.a.d(VideoUploadInfo.a.f294943a), kuc.a.d(r100), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f294941b;
        }

        static {
            a r100 = new a();
            f294940a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.MediaAttachment", r100, 6);
            r101.j("url", true);
            r101.j("uri", true);
            r101.j("image_upload_info", true);
            r101.j("video_upload_info", true);
            r101.j("mask_uri", true);
            r101.j("ai_creation_image", true);
            f294941b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f294941b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            Boolean r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            ImageUploadInfo r107 = (ImageUploadInfo) r101.decodeNullableSerializableElement(r100, 2, ImageUploadInfo.a.f294938a, null);
            VideoUploadInfo r108 = (VideoUploadInfo) r101.decodeNullableSerializableElement(r100, 3, VideoUploadInfo.a.f294943a, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            ImageUploadInfo r112 = r107;
            Boolean r113 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, null);
            String r114 = r106;
            String r115 = r105;
            VideoUploadInfo r116 = r108;
            int r109 = 63;
        L21:
            r101.endStructure(r100);
            return new MediaAttachment(r109, r115, r114, r112, r116, r111, r113, null);
        L5:
            r115 = null;
            VideoUploadInfo r117 = null;
            r112 = null;
            String r118 = null;
            r111 = null;
            int r119 = 0;
            boolean r120 = true;
        L6:
            if (r120 == false) goto L20;
            int r121 = r101.decodeElementIndex(r100);
            switch(r121) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r121);
        L19:
            r102 = 2;
            r120 = false;
            goto L6
        L11:
            r103 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, r103);
            r119 = r119 | 32;
        L18:
            r102 = 2;
            goto L6
        L12:
            r111 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r111);
            r119 = r119 | 16;
            goto L18
        L13:
            r117 = (VideoUploadInfo) r101.decodeNullableSerializableElement(r100, 3, VideoUploadInfo.a.f294943a, r117);
            r119 = r119 | 8;
            goto L18
        L14:
            r112 = (ImageUploadInfo) r101.decodeNullableSerializableElement(r100, r102, ImageUploadInfo.a.f294938a, r112);
            r119 = r119 | 4;
            goto L18
        L15:
            r118 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r118);
            r119 = r119 | 2;
            goto L18
        L17:
            r119 = r119 | 1;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r115);
            goto L18
        L20:
            r113 = r103;
            r109 = r119;
            String r122 = r118;
            r116 = r117;
            r114 = r122;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MediaAttachment r102 = (MediaAttachment) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f294941b;
            muc.d r104 = r100.beginStructure(r103);
            MediaAttachment.write$Self$instruction_core_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<MediaAttachment> serializer() {
            return a.f294940a;
        }
    }

    public MediaAttachment() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ MediaAttachment copy$default(MediaAttachment r110, String r111, String r112, ImageUploadInfo r113, VideoUploadInfo r114, String r115, String r116, String r210, String r211, String r212, String r213, String r214, Boolean r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.url;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.uri;
    L11:
        if ((r216 & 4) == 0) goto L13;
        ImageUploadInfo r102 = r110.imageUploadInfo;
    L15:
        if ((r216 & 8) == 0) goto L17;
        VideoUploadInfo r103 = r110.videoUploadInfo;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.localFilePath;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.identifier;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.resourceId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.localMessageId;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.originUrl;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.previewUrl;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r119 = r110.maskUri;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Boolean r108 = r110.aiCreationImage;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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

    @SerialName("ai_creation_image")
    public static /* synthetic */ void getAiCreationImage$annotations() {
    }

    @Transient
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @SerialName("image_upload_info")
    public static /* synthetic */ void getImageUploadInfo$annotations() {
    }

    @Transient
    public static /* synthetic */ void getLocalFilePath$annotations() {
    }

    @Transient
    public static /* synthetic */ void getLocalMessageId$annotations() {
    }

    @SerialName("mask_uri")
    public static /* synthetic */ void getMaskUri$annotations() {
    }

    @Transient
    public static /* synthetic */ void getOriginUrl$annotations() {
    }

    @Transient
    public static /* synthetic */ void getPreviewUrl$annotations() {
    }

    @Transient
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("video_upload_info")
    public static /* synthetic */ void getVideoUploadInfo$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final String component10() {
        return this.previewUrl;
    }

    public final String component11() {
        return this.maskUri;
    }

    public final Boolean component12() {
        return this.aiCreationImage;
    }

    public final String component2() {
        return this.uri;
    }

    public final ImageUploadInfo component3() {
        return this.imageUploadInfo;
    }

    public final VideoUploadInfo component4() {
        return this.videoUploadInfo;
    }

    public final String component5() {
        return this.localFilePath;
    }

    public final String component6() {
        return this.identifier;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.localMessageId;
    }

    public final String component9() {
        return this.originUrl;
    }

    public final MediaAttachment copy(String r110, String r111, ImageUploadInfo r112, VideoUploadInfo r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, Boolean r216) {
        return new MediaAttachment(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaAttachment) == true) goto L8;
        return false;
    L8:
        MediaAttachment r101 = (MediaAttachment) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUploadInfo, r101.imageUploadInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoUploadInfo, r101.videoUploadInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.localFilePath, r101.localFilePath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.originUrl, r101.originUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.previewUrl, r101.previewUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.maskUri, r101.maskUri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.aiCreationImage, r101.aiCreationImage) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ImageUploadInfo r107 = this.imageUploadInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        VideoUploadInfo r110 = this.videoUploadInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.localFilePath;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.identifier;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.resourceId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.localMessageId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.originUrl;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.previewUrl;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.maskUri;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.aiCreationImage;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
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
        return "MediaAttachment(url=" + this.url + ", uri=" + this.uri + ", imageUploadInfo=" + this.imageUploadInfo + ", videoUploadInfo=" + this.videoUploadInfo + ", localFilePath=" + this.localFilePath + ", identifier=" + this.identifier + ", resourceId=" + this.resourceId + ", localMessageId=" + this.localMessageId + ", originUrl=" + this.originUrl + ", previewUrl=" + this.previewUrl + ", maskUri=" + this.maskUri + ", aiCreationImage=" + this.aiCreationImage + ')';
    }

    static {
        Companion = new b();
    }

    public final Boolean getAiCreationImage() {
        return this.aiCreationImage;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ImageUploadInfo getImageUploadInfo() {
        return this.imageUploadInfo;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMaskUri() {
        return this.maskUri;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final VideoUploadInfo getVideoUploadInfo() {
        return this.videoUploadInfo;
    }

    public final void setAiCreationImage(Boolean r100) {
        this.aiCreationImage = r100;
    }

    public final void setIdentifier(String r100) {
        this.identifier = r100;
    }

    public final void setImageUploadInfo(ImageUploadInfo r100) {
        this.imageUploadInfo = r100;
    }

    public final void setLocalFilePath(String r100) {
        this.localFilePath = r100;
    }

    public final void setLocalMessageId(String r100) {
        this.localMessageId = r100;
    }

    public final void setMaskUri(String r100) {
        this.maskUri = r100;
    }

    public final void setOriginUrl(String r100) {
        this.originUrl = r100;
    }

    public final void setPreviewUrl(String r100) {
        this.previewUrl = r100;
    }

    public final void setResourceId(String r100) {
        this.resourceId = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setVideoUploadInfo(VideoUploadInfo r100) {
        this.videoUploadInfo = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$instruction_core_api_release(MediaAttachment r100, muc.d r101, luc.f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.url);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.uri);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, ImageUploadInfo.a.f294938a, r100.imageUploadInfo);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, VideoUploadInfo.a.f294943a, r100.videoUploadInfo);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.maskUri);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r103 = true;
    L53:
        if (r103 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, nuc.i.f520705a, r100.aiCreationImage);
        return;
    L56:
        return;
    L51:
        if (r100.aiCreationImage == null) goto L53;
    L42:
        if (r100.maskUri != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.videoUploadInfo != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.imageUploadInfo != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.uri != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.url != null) goto L4;
        r104 = false;
        goto L9
    }

    public MediaAttachment(int r100, String r101, String r102, ImageUploadInfo r103, VideoUploadInfo r104, String r105, Boolean r106, q2 r107) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f294941b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.url = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.uri = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imageUploadInfo = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.videoUploadInfo = null;
    L20:
        this.localFilePath = null;
        this.identifier = null;
        this.resourceId = null;
        this.localMessageId = null;
        this.originUrl = null;
        this.previewUrl = null;
        if ((r100 & 16) != 0) goto L23;
        this.maskUri = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.aiCreationImage = null;
        return;
    L27:
        this.aiCreationImage = r106;
        return;
    L23:
        this.maskUri = r105;
        goto L25
    L19:
        this.videoUploadInfo = r104;
        goto L20
    L15:
        this.imageUploadInfo = r103;
        goto L17
    L11:
        this.uri = r102;
        goto L13
    L7:
        this.url = r101;
        goto L9
    }

    public MediaAttachment(String r100, String r101, ImageUploadInfo r102, VideoUploadInfo r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, Boolean r112) {
        this.url = r100;
        this.uri = r101;
        this.imageUploadInfo = r102;
        this.videoUploadInfo = r103;
        this.localFilePath = r104;
        this.identifier = r105;
        this.resourceId = r106;
        this.localMessageId = r107;
        this.originUrl = r108;
        this.previewUrl = r110;
        this.maskUri = r111;
        this.aiCreationImage = r112;
    }

    public /* synthetic */ MediaAttachment(String r110, String r111, ImageUploadInfo r112, VideoUploadInfo r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214, Boolean r215, int r216, DefaultConstructorMarker r217) {
        Boolean r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        ImageUploadInfo r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        VideoUploadInfo r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
