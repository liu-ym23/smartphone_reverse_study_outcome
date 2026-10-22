package com.larus.im.bean.message;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.dypay.api.DyPayConstant;
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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 q2\u00020\u0001:\u0002pqB÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aBã\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001eJ\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010S\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jþ\u0001\u0010a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010bJ\u0013\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\bHÖ\u0001J\t\u0010g\u001a\u00020\u0003HÖ\u0001J%\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020nH\u0001¢\u0006\u0002\boR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b)\u0010 \u001a\u0004\b*\u0010+R \u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b-\u0010 \u001a\u0004\b.\u0010+R \u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b/\u0010 \u001a\u0004\b0\u0010+R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010 \u001a\u0004\b2\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010 \u001a\u0004\b4\u0010\"R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010 \u001a\u0004\b6\u0010\"R \u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b7\u0010 \u001a\u0004\b8\u0010+R \u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b9\u0010 \u001a\u0004\b:\u0010+R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010 \u001a\u0004\b<\u0010\"R \u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b=\u0010 \u001a\u0004\b>\u0010+R \u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b?\u0010 \u001a\u0004\b@\u0010+R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010 \u001a\u0004\bB\u0010\"R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010 \u001a\u0004\bD\u0010\"R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010 \u001a\u0004\bF\u0010\"R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010J\u0012\u0004\bG\u0010 \u001a\u0004\bH\u0010IR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010 \u001a\u0004\bL\u0010\"¨\u0006r"}, d2 = {"Lcom/larus/im/bean/message/MixerMedia;", "", "cardId", "", "itemId", "description", "imageUrl", "albumImageHeight", "", "albumImageWidth", "sourceFrom", "sourceAppName", "sourceAppIcon", "albumImageUri", "width", "height", "videoFirstFrameImage", "videoFirstFrameImageWidth", "videoFirstFrameImageHeight", "hostPageUrl", "mediaType", "searchId", DyPayConstant.KEY_START_TIME, "", "appJumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardId$annotations", "()V", "getCardId", "()Ljava/lang/String;", "getItemId$annotations", "getItemId", "getDescription$annotations", "getDescription", "getImageUrl$annotations", "getImageUrl", "getAlbumImageHeight$annotations", "getAlbumImageHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAlbumImageWidth$annotations", "getAlbumImageWidth", "getSourceFrom$annotations", "getSourceFrom", "getSourceAppName$annotations", "getSourceAppName", "getSourceAppIcon$annotations", "getSourceAppIcon", "getAlbumImageUri$annotations", "getAlbumImageUri", "getWidth$annotations", "getWidth", "getHeight$annotations", "getHeight", "getVideoFirstFrameImage$annotations", "getVideoFirstFrameImage", "getVideoFirstFrameImageWidth$annotations", "getVideoFirstFrameImageWidth", "getVideoFirstFrameImageHeight$annotations", "getVideoFirstFrameImageHeight", "getHostPageUrl$annotations", "getHostPageUrl", "getMediaType$annotations", "getMediaType", "getSearchId$annotations", "getSearchId", "getStartTime$annotations", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAppJumpUrl$annotations", "getAppJumpUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/im/bean/message/MixerMedia;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class MixerMedia {
    public static final b Companion = null;
    private final Integer albumImageHeight;
    private final String albumImageUri;
    private final Integer albumImageWidth;
    private final String appJumpUrl;
    private final String cardId;
    private final String description;
    private final Integer height;
    private final String hostPageUrl;
    private final String imageUrl;
    private final String itemId;
    private final String mediaType;
    private final String searchId;
    private final String sourceAppIcon;
    private final String sourceAppName;
    private final Integer sourceFrom;
    private final Long startTime;
    private final String videoFirstFrameImage;
    private final Integer videoFirstFrameImageHeight;
    private final Integer videoFirstFrameImageWidth;
    private final Integer width;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MixerMedia> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346682a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346683b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346683b;
        }

        static {
            a r100 = new a();
            f346682a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.MixerMedia", r100, 20);
            r101.j("id", true);
            r101.j("item_id", true);
            r101.j("video_captions", true);
            r101.j("album_image", true);
            r101.j("album_image_height", true);
            r101.j("album_image_width", true);
            r101.j("source_from", true);
            r101.j("source_app_name", true);
            r101.j("source_app_icon", true);
            r101.j("album_image_uri", true);
            r101.j("width", true);
            r101.j("height", true);
            r101.j("video_first_frame_image", true);
            r101.j("video_first_frame_image_width", true);
            r101.j("video_first_frame_image_height", true);
            r101.j("host_page_url", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, true);
            r101.j("search_id", true);
            r101.j(ILoadStallMonitor.START_TIME, true);
            r101.j("app_jump_url", true);
            f346683b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(g1.f520681a), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r410) {
            Intrinsics.checkNotNullParameter(r410, "decoder");
            g2 r100 = f346683b;
            muc.c r101 = r410.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r102, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r102, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 3, r102, null);
            w0 r111 = w0.f520792a;
            Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r111, null);
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r111, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r111, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 7, r102, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 8, r102, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 9, r102, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r111, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 11, r111, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 12, r102, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 13, r111, null);
            Integer r118 = (Integer) r101.decodeNullableSerializableElement(r100, 14, r111, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 15, r102, null);
            Integer r120 = r118;
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 16, r102, null);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 17, r102, null);
            Long r123 = (Long) r101.decodeNullableSerializableElement(r100, 18, g1.f520681a, null);
            int r124 = 1048575;
            Integer r125 = r112;
            Integer r126 = r114;
            Integer r127 = r109;
            String r128 = r107;
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 19, r102, null);
            Long r211 = r123;
            String r129 = r105;
            String r130 = r103;
            String r131 = r106;
            String r132 = r104;
            String r133 = r110;
            String r134 = r115;
            Integer r135 = r108;
            String r212 = r119;
            Integer r136 = r113;
            String r213 = r122;
            String r137 = r116;
            String r214 = r121;
            Integer r138 = r117;
        L48:
            r101.endStructure(r100);
            return new MixerMedia(r124, r130, r132, r129, r133, r125, r136, r126, r134, r131, r128, r135, r127, r137, r138, r120, r212, r214, r213, r211, r210, null);
        L5:
            String r139 = null;
            String r140 = null;
            Integer r141 = null;
            Integer r142 = null;
            Integer r143 = null;
            String r144 = null;
            String r145 = null;
            String r146 = null;
            r134 = null;
            r131 = null;
            Integer r147 = null;
            Integer r148 = null;
            String r215 = null;
            String r216 = null;
            String r310 = null;
            String r311 = null;
            Integer r312 = null;
            String r313 = null;
            Long r314 = null;
            Integer r315 = null;
            int r149 = 0;
            boolean r316 = true;
        L6:
            if (r316 == false) goto L47;
            int r150 = r101.decodeElementIndex(r100);
            switch(r150) {
                case -1: goto L46;
                case 0: goto L44;
                case 1: goto L42;
                case 2: goto L40;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L28;
                case 9: goto L26;
                case 10: goto L24;
                case 11: goto L22;
                case 12: goto L21;
                case 13: goto L20;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L12;
                case 19: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r150);
        L46:
            r144 = r144;
            r143 = r143;
            r140 = r140;
            r316 = false;
            r215 = r215;
            r139 = r139;
            goto L6
        L11:
            int r151 = 524288;
            String r152 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r144);
        L13:
            Long r153 = r314;
        L18:
            int r154 = r151 | r149;
            r140 = r140;
            Long r155 = r153;
            r144 = r152;
            String r156 = r311;
        L25:
            Long r157 = r155;
            Integer r158 = r312;
        L29:
            r139 = r139;
            Integer r317 = r158;
            String r159 = r140;
            String r160 = r156;
        L33:
            r143 = r143;
        L39:
            String r318 = r159;
            String r161 = r139;
            String r217 = r313;
        L41:
            String r218 = r161;
            String r219 = r310;
            String r162 = r318;
        L43:
            String r319 = r162;
            r139 = r218;
            Long r220 = r157;
            String r163 = r160;
            r149 = r154;
            String r164 = r216;
        L45:
            r216 = r164;
            r311 = r163;
            r314 = r220;
            r310 = r219;
            r313 = r217;
            r315 = r315;
            r312 = r317;
            r140 = r319;
            goto L6
        L12:
            r152 = r144;
            r314 = (Long) r101.decodeNullableSerializableElement(r100, 18, g1.f520681a, r314);
            r151 = 262144;
            goto L13
        L14:
            r143 = r143;
            r152 = r144;
            r153 = r314;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r140);
            r151 = 131072;
            goto L18
        L15:
            r143 = r143;
            r152 = r144;
            r153 = r314;
            r145 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r145);
            r151 = 65536;
            goto L18
        L17:
            r143 = r143;
            r152 = r144;
            r153 = r314;
            r139 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r139);
            r151 = 32768;
            goto L18
        L19:
            r143 = r143;
            r147 = (Integer) r101.decodeNullableSerializableElement(r100, 14, w0.f520792a, r147);
            r140 = r140;
            r154 = r149 | 16384;
            r144 = r144;
            r155 = r314;
            r156 = r311;
            goto L25
        L20:
            r143 = r143;
            Integer r165 = (Integer) r101.decodeNullableSerializableElement(r100, 13, w0.f520792a, r142);
            int r166 = r149 | 8192;
            r140 = r140;
            r155 = r314;
            r144 = r144;
            r156 = r311;
            r142 = r165;
            r154 = r166;
            goto L25
        L21:
            int r167 = r149 | 4096;
            r155 = r314;
            r139 = r139;
            r156 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r311);
            r154 = r167;
        L23:
            r144 = r144;
            goto L25
        L22:
            r148 = (Integer) r101.decodeNullableSerializableElement(r100, 11, w0.f520792a, r148);
            r154 = r149 | 2048;
            r139 = r139;
            r155 = r314;
            r156 = r311;
            goto L23
        L24:
            r143 = r143;
            r140 = r140;
            r312 = (Integer) r101.decodeNullableSerializableElement(r100, 10, w0.f520792a, r312);
            r154 = r149 | 1024;
            r155 = r314;
            r156 = r311;
            r144 = r144;
            r139 = r139;
            goto L25
        L26:
            r140 = r140;
            r143 = r143;
            r146 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r146);
            r154 = r149 | 512;
            r158 = r312;
            r139 = r139;
            r157 = r314;
            r156 = r311;
            r144 = r144;
            goto L29
        L28:
            r140 = r140;
            r143 = r143;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r131);
            r154 = r149 | 256;
            r158 = r312;
            r139 = r139;
            r157 = r314;
            r156 = r311;
            r144 = r144;
            goto L29
        L30:
            r134 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r134);
            r154 = r149 | 128;
        L32:
            r317 = r312;
            r160 = r311;
            r144 = r144;
            r159 = r140;
            r157 = r314;
            goto L33
        L31:
            r141 = (Integer) r101.decodeNullableSerializableElement(r100, 6, w0.f520792a, r141);
            r154 = r149 | 64;
            goto L32
        L34:
            r317 = r312;
            Integer r221 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r143);
            r154 = r149 | 32;
        L36:
            r315 = r315;
        L38:
            r160 = r311;
            r144 = r144;
            r159 = r140;
            r157 = r314;
            r143 = r221;
            goto L39
        L35:
            r317 = r312;
            r221 = r143;
            r315 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r315);
            r154 = r149 | 16;
            goto L36
        L37:
            r139 = r139;
            r140 = r140;
            r221 = r143;
            r144 = r144;
            r311 = r311;
            r317 = r312;
            r314 = r314;
            r315 = r315;
            r313 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r313);
            r154 = r149 | 8;
            goto L38
        L40:
            r318 = r140;
            r317 = r312;
            r315 = r315;
            r217 = r313;
            r310 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r310);
            r154 = r149 | 4;
            r160 = r311;
            r144 = r144;
            r161 = r139;
            r157 = r314;
            r143 = r143;
            goto L41
        L42:
            r218 = r139;
            r317 = r312;
            r217 = r313;
            r315 = r315;
            r219 = r310;
            r216 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r216);
            r154 = r149 | 2;
            r160 = r311;
            r144 = r144;
            r162 = r140;
            r157 = r314;
            r143 = r143;
            goto L43
        L44:
            r319 = r140;
            r219 = r310;
            r317 = r312;
            r217 = r313;
            r315 = r315;
            r149 = r149 | 1;
            r139 = r139;
            r220 = r314;
            r143 = r143;
            r215 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r215);
            r164 = r216;
            r163 = r311;
            r144 = r144;
            goto L45
        L47:
            String r222 = r139;
            String r320 = r140;
            Integer r223 = r143;
            String r168 = r144;
            r138 = r142;
            r211 = r314;
            r137 = r311;
            r124 = r149;
            r214 = r145;
            r120 = r147;
            r212 = r222;
            r129 = r310;
            r132 = r216;
            r133 = r313;
            r125 = r315;
            r136 = r223;
            r213 = r320;
            r128 = r146;
            r210 = r168;
            r126 = r141;
            r127 = r148;
            r135 = r312;
            r130 = r215;
            goto L48
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MixerMedia r102 = (MixerMedia) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346683b;
            muc.d r104 = r100.beginStructure(r103);
            MixerMedia.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<MixerMedia> serializer() {
            return a.f346682a;
        }
    }

    public MixerMedia() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public static /* synthetic */ MixerMedia copy$default(MixerMedia r110, String r111, String r112, String r210, String r211, Integer r212, Integer r213, Integer r214, String r215, String r216, String r217, Integer r218, Integer r219, String r310, Integer r311, Integer r312, String r313, String r314, String r315, Long r316, String r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = r110.cardId;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.itemId;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r110.description;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = r110.imageUrl;
    L19:
        if ((r318 & 16) == 0) goto L21;
        Integer r104 = r110.albumImageHeight;
    L23:
        if ((r318 & 32) == 0) goto L25;
        Integer r105 = r110.albumImageWidth;
    L27:
        if ((r318 & 64) == 0) goto L29;
        Integer r106 = r110.sourceFrom;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r107 = r110.sourceAppName;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r113 = r110.sourceAppIcon;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r114 = r110.albumImageUri;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        Integer r115 = r110.width;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        Integer r116 = r110.height;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r117 = r110.videoFirstFrameImage;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        Integer r118 = r110.videoFirstFrameImageWidth;
    L58:
        Integer r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        Integer r119 = r110.videoFirstFrameImageHeight;
    L62:
        Integer r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        String r120 = r110.hostPageUrl;
    L66:
        String r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        String r121 = r110.mediaType;
    L70:
        String r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        String r122 = r110.searchId;
    L74:
        String r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        Long r123 = r110.startTime;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        String r108 = r110.appJumpUrl;
    L83:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r108);
    L81:
        r108 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("album_image_height")
    public static /* synthetic */ void getAlbumImageHeight$annotations() {
    }

    @SerialName("album_image_uri")
    public static /* synthetic */ void getAlbumImageUri$annotations() {
    }

    @SerialName("album_image_width")
    public static /* synthetic */ void getAlbumImageWidth$annotations() {
    }

    @SerialName("app_jump_url")
    public static /* synthetic */ void getAppJumpUrl$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getCardId$annotations() {
    }

    @SerialName("video_captions")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("host_page_url")
    public static /* synthetic */ void getHostPageUrl$annotations() {
    }

    @SerialName("album_image")
    public static /* synthetic */ void getImageUrl$annotations() {
    }

    @SerialName("item_id")
    public static /* synthetic */ void getItemId$annotations() {
    }

    @SerialName(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE)
    public static /* synthetic */ void getMediaType$annotations() {
    }

    @SerialName("search_id")
    public static /* synthetic */ void getSearchId$annotations() {
    }

    @SerialName("source_app_icon")
    public static /* synthetic */ void getSourceAppIcon$annotations() {
    }

    @SerialName("source_app_name")
    public static /* synthetic */ void getSourceAppName$annotations() {
    }

    @SerialName("source_from")
    public static /* synthetic */ void getSourceFrom$annotations() {
    }

    @SerialName(ILoadStallMonitor.START_TIME)
    public static /* synthetic */ void getStartTime$annotations() {
    }

    @SerialName("video_first_frame_image")
    public static /* synthetic */ void getVideoFirstFrameImage$annotations() {
    }

    @SerialName("video_first_frame_image_height")
    public static /* synthetic */ void getVideoFirstFrameImageHeight$annotations() {
    }

    @SerialName("video_first_frame_image_width")
    public static /* synthetic */ void getVideoFirstFrameImageWidth$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final String component1() {
        return this.cardId;
    }

    public final String component10() {
        return this.albumImageUri;
    }

    public final Integer component11() {
        return this.width;
    }

    public final Integer component12() {
        return this.height;
    }

    public final String component13() {
        return this.videoFirstFrameImage;
    }

    public final Integer component14() {
        return this.videoFirstFrameImageWidth;
    }

    public final Integer component15() {
        return this.videoFirstFrameImageHeight;
    }

    public final String component16() {
        return this.hostPageUrl;
    }

    public final String component17() {
        return this.mediaType;
    }

    public final String component18() {
        return this.searchId;
    }

    public final Long component19() {
        return this.startTime;
    }

    public final String component2() {
        return this.itemId;
    }

    public final String component20() {
        return this.appJumpUrl;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final Integer component5() {
        return this.albumImageHeight;
    }

    public final Integer component6() {
        return this.albumImageWidth;
    }

    public final Integer component7() {
        return this.sourceFrom;
    }

    public final String component8() {
        return this.sourceAppName;
    }

    public final String component9() {
        return this.sourceAppIcon;
    }

    public final MixerMedia copy(String r210, String r211, String r212, String r213, Integer r214, Integer r215, Integer r216, String r310, String r311, String r312, Integer r313, Integer r314, String r315, Integer r316, Integer r317, String r318, String r319, String r410, Long r411, String r412) {
        return new MixerMedia(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MixerMedia) == true) goto L8;
        return false;
    L8:
        MixerMedia r101 = (MixerMedia) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.albumImageHeight, r101.albumImageHeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.albumImageWidth, r101.albumImageWidth) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sourceAppName, r101.sourceAppName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceAppIcon, r101.sourceAppIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.albumImageUri, r101.albumImageUri) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.videoFirstFrameImage, r101.videoFirstFrameImage) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.videoFirstFrameImageWidth, r101.videoFirstFrameImageWidth) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.videoFirstFrameImageHeight, r101.videoFirstFrameImageHeight) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.hostPageUrl, r101.hostPageUrl) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.mediaType, r101.mediaType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.appJumpUrl, r101.appJumpUrl) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        String r100 = this.cardId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.itemId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.description;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imageUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.albumImageHeight;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.albumImageWidth;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.sourceFrom;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.sourceAppName;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.sourceAppIcon;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.albumImageUri;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.width;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.height;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.videoFirstFrameImage;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.videoFirstFrameImageWidth;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.videoFirstFrameImageHeight;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.hostPageUrl;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.mediaType;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.searchId;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Long r155 = this.startTime;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.appJumpUrl;
        if (r158 == null) goto L83;
        r101 = r158.hashCode();
    L83:
        return r157 + r101;
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
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
        return "MixerMedia(cardId=" + this.cardId + ", itemId=" + this.itemId + ", description=" + this.description + ", imageUrl=" + this.imageUrl + ", albumImageHeight=" + this.albumImageHeight + ", albumImageWidth=" + this.albumImageWidth + ", sourceFrom=" + this.sourceFrom + ", sourceAppName=" + this.sourceAppName + ", sourceAppIcon=" + this.sourceAppIcon + ", albumImageUri=" + this.albumImageUri + ", width=" + this.width + ", height=" + this.height + ", videoFirstFrameImage=" + this.videoFirstFrameImage + ", videoFirstFrameImageWidth=" + this.videoFirstFrameImageWidth + ", videoFirstFrameImageHeight=" + this.videoFirstFrameImageHeight + ", hostPageUrl=" + this.hostPageUrl + ", mediaType=" + this.mediaType + ", searchId=" + this.searchId + ", startTime=" + this.startTime + ", appJumpUrl=" + this.appJumpUrl + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer getAlbumImageHeight() {
        return this.albumImageHeight;
    }

    public final String getAlbumImageUri() {
        return this.albumImageUri;
    }

    public final Integer getAlbumImageWidth() {
        return this.albumImageWidth;
    }

    public final String getAppJumpUrl() {
        return this.appJumpUrl;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getHostPageUrl() {
        return this.hostPageUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSourceAppIcon() {
        return this.sourceAppIcon;
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final Integer getSourceFrom() {
        return this.sourceFrom;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getVideoFirstFrameImage() {
        return this.videoFirstFrameImage;
    }

    public final Integer getVideoFirstFrameImageHeight() {
        return this.videoFirstFrameImageHeight;
    }

    public final Integer getVideoFirstFrameImageWidth() {
        return this.videoFirstFrameImageWidth;
    }

    public final Integer getWidth() {
        return this.width;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(MixerMedia r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.cardId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.itemId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.description);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.imageUrl);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.albumImageHeight);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.albumImageWidth);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.sourceFrom);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.sourceAppName);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.sourceAppIcon);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.albumImageUri);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, w0.f520792a, r100.width);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, w0.f520792a, r100.height);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, v2.f520790a, r100.videoFirstFrameImage);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r101.encodeNullableSerializableElement(r102, 13, w0.f520792a, r100.videoFirstFrameImageWidth);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L132;
    L130:
        boolean r118 = true;
    L135:
        if (r118 == false) goto L138;
        r101.encodeNullableSerializableElement(r102, 14, w0.f520792a, r100.videoFirstFrameImageHeight);
    L138:
        if (r101.shouldEncodeElementDefault(r102, 15) == false) goto L141;
    L139:
        boolean r119 = true;
    L144:
        if (r119 == false) goto L147;
        r101.encodeNullableSerializableElement(r102, 15, v2.f520790a, r100.hostPageUrl);
    L147:
        if (r101.shouldEncodeElementDefault(r102, 16) == false) goto L150;
    L148:
        boolean r120 = true;
    L153:
        if (r120 == false) goto L156;
        r101.encodeNullableSerializableElement(r102, 16, v2.f520790a, r100.mediaType);
    L156:
        if (r101.shouldEncodeElementDefault(r102, 17) == false) goto L159;
    L157:
        boolean r121 = true;
    L162:
        if (r121 == false) goto L165;
        r101.encodeNullableSerializableElement(r102, 17, v2.f520790a, r100.searchId);
    L165:
        if (r101.shouldEncodeElementDefault(r102, 18) == false) goto L168;
    L166:
        boolean r122 = true;
    L171:
        if (r122 == false) goto L174;
        r101.encodeNullableSerializableElement(r102, 18, g1.f520681a, r100.startTime);
    L174:
        if (r101.shouldEncodeElementDefault(r102, 19) == false) goto L177;
    L175:
        r103 = true;
    L179:
        if (r103 == false) goto L182;
        r101.encodeNullableSerializableElement(r102, 19, v2.f520790a, r100.appJumpUrl);
        return;
    L182:
        return;
    L177:
        if (r100.appJumpUrl == null) goto L179;
    L168:
        if (r100.startTime != null) goto L166;
        r122 = false;
        goto L171
    L159:
        if (r100.searchId != null) goto L157;
        r121 = false;
        goto L162
    L150:
        if (r100.mediaType != null) goto L148;
        r120 = false;
        goto L153
    L141:
        if (r100.hostPageUrl != null) goto L139;
        r119 = false;
        goto L144
    L132:
        if (r100.videoFirstFrameImageHeight != null) goto L130;
        r118 = false;
        goto L135
    L123:
        if (r100.videoFirstFrameImageWidth != null) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r100.videoFirstFrameImage != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.height != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.width != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.albumImageUri != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.sourceAppIcon != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.sourceAppName != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.sourceFrom != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.albumImageWidth != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.albumImageHeight != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.imageUrl != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.description != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.itemId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.cardId != null) goto L4;
        r104 = false;
        goto L9
    }

    public MixerMedia(String r100, String r101, String r102, String r103, Integer r104, Integer r105, Integer r106, String r110, String r111, String r112, Integer r113, Integer r114, String r115, Integer r116, Integer r117, String r118, String r119, String r210, Long r211, String r212) {
        this.cardId = r100;
        this.itemId = r101;
        this.description = r102;
        this.imageUrl = r103;
        this.albumImageHeight = r104;
        this.albumImageWidth = r105;
        this.sourceFrom = r106;
        this.sourceAppName = r110;
        this.sourceAppIcon = r111;
        this.albumImageUri = r112;
        this.width = r113;
        this.height = r114;
        this.videoFirstFrameImage = r115;
        this.videoFirstFrameImageWidth = r116;
        this.videoFirstFrameImageHeight = r117;
        this.hostPageUrl = r118;
        this.mediaType = r119;
        this.searchId = r210;
        this.startTime = r211;
        this.appJumpUrl = r212;
    }

    public MixerMedia(int r100, String r101, String r102, String r103, String r110, Integer r111, Integer r112, Integer r113, String r114, String r115, String r116, Integer r117, Integer r118, String r119, Integer r210, Integer r211, String r212, String r213, String r214, Long r215, String r216, q2 r217) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346683b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.cardId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.itemId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.description = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.imageUrl = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.albumImageHeight = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.albumImageWidth = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.sourceFrom = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.sourceAppName = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.sourceAppIcon = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.albumImageUri = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.width = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.height = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.videoFirstFrameImage = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.videoFirstFrameImageWidth = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.videoFirstFrameImageHeight = null;
    L65:
        if ((32768 & r100) != 0) goto L67;
        this.hostPageUrl = null;
    L69:
        if ((65536 & r100) != 0) goto L71;
        this.mediaType = null;
    L73:
        if ((131072 & r100) != 0) goto L75;
        this.searchId = null;
    L77:
        if ((262144 & r100) != 0) goto L79;
        this.startTime = null;
    L81:
        if ((r100 & 524288) != 0) goto L83;
        this.appJumpUrl = null;
        return;
    L83:
        this.appJumpUrl = r216;
        return;
    L79:
        this.startTime = r215;
        goto L81
    L75:
        this.searchId = r214;
        goto L77
    L71:
        this.mediaType = r213;
        goto L73
    L67:
        this.hostPageUrl = r212;
        goto L69
    L63:
        this.videoFirstFrameImageHeight = r211;
        goto L65
    L59:
        this.videoFirstFrameImageWidth = r210;
        goto L61
    L55:
        this.videoFirstFrameImage = r119;
        goto L57
    L51:
        this.height = r118;
        goto L53
    L47:
        this.width = r117;
        goto L49
    L43:
        this.albumImageUri = r116;
        goto L45
    L39:
        this.sourceAppIcon = r115;
        goto L41
    L35:
        this.sourceAppName = r114;
        goto L37
    L31:
        this.sourceFrom = r113;
        goto L33
    L27:
        this.albumImageWidth = r112;
        goto L29
    L23:
        this.albumImageHeight = r111;
        goto L25
    L19:
        this.imageUrl = r110;
        goto L21
    L15:
        this.description = r103;
        goto L17
    L11:
        this.itemId = r102;
        goto L13
    L7:
        this.cardId = r101;
        goto L9
    }

    public /* synthetic */ MixerMedia(String r210, String r211, String r212, String r213, Integer r214, Integer r215, Integer r216, String r217, String r310, String r311, Integer r312, Integer r313, String r314, Integer r315, Integer r316, String r317, String r318, String r319, Long r410, String r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r412 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        Integer r112 = null;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        Integer r115 = null;
    L59:
        if ((r412 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r412 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r412 & 262144) == 0) goto L77;
        Long r119 = null;
    L79:
        if ((r412 & 524288) == 0) goto L81;
        String r109 = null;
    L82:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r118 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L59
    L53:
        r114 = r314;
        goto L55
    L49:
        r113 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r111 = r311;
        goto L43
    L37:
        r110 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
