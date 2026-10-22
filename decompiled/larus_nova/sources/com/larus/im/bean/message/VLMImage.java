package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
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
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import yc9.o1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 r2\u00060\u0001j\u0002`\u0002:\u0002qrBñ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cBß\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010 J\u0010\u0010O\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010P\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010]\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010^\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010GJ\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jø\u0001\u0010b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020\u00172\b\u0010e\u001a\u0004\u0018\u00010fHÖ\u0003J\t\u0010g\u001a\u00020\fHÖ\u0001J\t\u0010h\u001a\u00020\u0006HÖ\u0001J%\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020oH\u0001¢\u0006\u0002\bpR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\"\u001a\u0004\b'\u0010(R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\"\u001a\u0004\b*\u0010(R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010-R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010(R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\b0\u0010\"\u001a\u0004\b1\u00102R \u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u00102R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\"\u001a\u0004\b7\u0010(R \u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\b8\u0010\"\u001a\u0004\b9\u00102R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\"\u001a\u0004\b;\u0010(R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\"\u001a\u0004\b=\u0010(R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\"\u001a\u0004\b?\u0010(R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\"\u001a\u0004\bA\u0010(R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\bB\u0010\"\u001a\u0004\bC\u00102R \u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\bD\u0010\"\u001a\u0004\bE\u00102R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010H\u0012\u0004\bF\u0010\"\u001a\u0004\b\u0016\u0010GR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\"\u001a\u0004\bJ\u0010(R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010\"\u001a\u0004\bL\u0010(R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010\"\u001a\u0004\bN\u0010(¨\u0006s"}, d2 = {"Lcom/larus/im/bean/message/VLMImage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "cardId", "", "uri", "", "thumbUrl", "fullSizeUrl", "", "mainSiteUrl", "height", "", "width", "authorShortId", "sourceFrom", "sourceAppName", "sourceAppIcon", "imgCaption", "originThumbUrl", "originWidth", "originHeight", "isBlurBackground", "", "imageSource", "docId", "searchId", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardId$annotations", "()V", "getCardId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUri$annotations", "getUri", "()Ljava/lang/String;", "getThumbUrl$annotations", "getThumbUrl", "getFullSizeUrl$annotations", "getFullSizeUrl", "()Ljava/util/List;", "getMainSiteUrl$annotations", "getMainSiteUrl", "getHeight$annotations", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth$annotations", "getWidth", "getAuthorShortId$annotations", "getAuthorShortId", "getSourceFrom$annotations", "getSourceFrom", "getSourceAppName$annotations", "getSourceAppName", "getSourceAppIcon$annotations", "getSourceAppIcon", "getImgCaption$annotations", "getImgCaption", "getOriginThumbUrl$annotations", "getOriginThumbUrl", "getOriginWidth$annotations", "getOriginWidth", "getOriginHeight$annotations", "getOriginHeight", "isBlurBackground$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageSource$annotations", "getImageSource", "getDocId$annotations", "getDocId", "getSearchId$annotations", "getSearchId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/bean/message/VLMImage;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class VLMImage implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final String authorShortId;
    private final Long cardId;
    private final String docId;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> fullSizeUrl;
    private final Integer height;
    private final String imageSource;
    private final String imgCaption;
    private final Boolean isBlurBackground;
    private final String mainSiteUrl;
    private final Integer originHeight;
    private final String originThumbUrl;
    private final Integer originWidth;
    private final String searchId;
    private final String sourceAppIcon;
    private final String sourceAppName;
    private final Integer sourceFrom;
    private final String thumbUrl;
    private final String uri;
    private final Integer width;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VLMImage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346747a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346748b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346748b;
        }

        static {
            a r100 = new a();
            f346747a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.VLMImage", r100, 19);
            r101.j("id", true);
            r101.j("uri", true);
            r101.j("thumb_url", true);
            r101.j("full_size_url", true);
            r101.j("main_site_url", true);
            r101.j("height", true);
            r101.j("width", true);
            r101.j("author_short_id", true);
            r101.j("source_from", true);
            r101.j("source_app_name", true);
            r101.j("source_app_icon", true);
            r101.j("img_caption", true);
            r101.j("origin_thumb_url", true);
            r101.j("origin_width", true);
            r101.j("origin_height", true);
            r101.j("is_blur_background", true);
            r101.j("image_source", true);
            r101.j("doc_id", true);
            r101.j("search_id", true);
            f346748b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = VLMImage.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{kuc.a.d(g1.f520681a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[3].getValue()), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(i.f520705a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r410) {
            Intrinsics.checkNotNullParameter(r410, "decoder");
            g2 r100 = f346748b;
            muc.c r101 = r410.beginStructure(r100);
            Lazy[] r102 = VLMImage.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            Long r103 = (Long) r101.decodeNullableSerializableElement(r100, 0, g1.f520681a, null);
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            List r106 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            w0 r111 = w0.f520792a;
            Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r111, null);
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r111, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 7, r104, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r111, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 9, r104, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 10, r104, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 11, r104, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 12, r104, null);
            Integer r118 = (Integer) r101.decodeNullableSerializableElement(r100, 13, r111, null);
            Integer r119 = (Integer) r101.decodeNullableSerializableElement(r100, 14, r111, null);
            Boolean r120 = (Boolean) r101.decodeNullableSerializableElement(r100, 15, i.f520705a, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 16, r104, null);
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 17, r104, null);
            String r310 = (String) r101.decodeNullableSerializableElement(r100, 18, r104, null);
            String r211 = r121;
            Integer r122 = r113;
            Boolean r212 = r120;
            Integer r213 = r119;
            Integer r214 = r118;
            String r215 = r117;
            Long r123 = r103;
            String r216 = r109;
            Integer r217 = r108;
            String r124 = r110;
            Integer r125 = r112;
            String r126 = r114;
            String r127 = r105;
            List r128 = r106;
            int r129 = 524287;
            String r130 = r107;
            String r218 = r116;
            String r219 = r115;
        L48:
            r101.endStructure(r100);
            return new VLMImage(r129, r123, r127, r124, r128, r130, r125, r122, r126, r217, r216, r219, r218, r215, r214, r213, r212, r211, r210, r310, null);
        L5:
            Integer r131 = null;
            String r132 = null;
            Integer r133 = null;
            String r134 = null;
            String r135 = null;
            Integer r136 = null;
            String r137 = null;
            Integer r138 = null;
            Integer r139 = null;
            String r140 = null;
            String r141 = null;
            Long r220 = null;
            String r221 = null;
            String r311 = null;
            Boolean r312 = null;
            String r313 = null;
            String r314 = null;
            String r315 = null;
            List r316 = null;
            int r142 = 0;
            boolean r317 = true;
        L6:
            if (r317 == false) goto L47;
            int r143 = r101.decodeElementIndex(r100);
            switch(r143) {
                case -1: goto L46;
                case 0: goto L43;
                case 1: goto L41;
                case 2: goto L40;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L30;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L25;
                case 11: goto L23;
                case 12: goto L20;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L15;
                case 16: goto L13;
                case 17: goto L12;
                case 18: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r143);
        L46:
            r135 = r135;
            r131 = r131;
            r317 = false;
            r220 = r220;
            r132 = r132;
            goto L6
        L11:
            r141 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r141);
            int r144 = 262144;
        L14:
            r315 = r315;
        L16:
            int r145 = r144 | r142;
            Boolean r146 = r312;
        L22:
            Boolean r147 = r146;
            r311 = r311;
            r313 = r313;
        L39:
            Boolean r148 = r147;
            r131 = r131;
            r142 = r145;
            r135 = r135;
            String r149 = r221;
            String r150 = r314;
            List r222 = r316;
        L45:
            r221 = r149;
            r312 = r148;
            r314 = r150;
            r315 = r315;
            r131 = r131;
            r316 = r222;
            r311 = r311;
            r313 = r313;
            r102 = r102;
            goto L6
        L12:
            int r151 = 131072 | r142;
            r135 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r135);
        L24:
            int r152 = r151;
            r311 = r311;
            r313 = r313;
        L38:
            r131 = r131;
            Boolean r318 = r312;
            r145 = r152;
            r147 = r318;
            goto L39
        L13:
            r315 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r315);
            r144 = 65536;
            goto L14
        L15:
            r102 = r102;
            r135 = r135;
            r315 = r315;
            r312 = (Boolean) r101.decodeNullableSerializableElement(r100, 15, i.f520705a, r312);
            r144 = 32768;
            goto L16
        L17:
            r133 = (Integer) r101.decodeNullableSerializableElement(r100, 14, w0.f520792a, r133);
            int r153 = r142 | 16384;
        L21:
            int r319 = r153;
            r146 = r312;
            r145 = r319;
            goto L22
        L18:
            r131 = (Integer) r101.decodeNullableSerializableElement(r100, 13, w0.f520792a, r131);
            r153 = r142 | 8192;
            goto L21
        L20:
            r102 = r102;
            r135 = r135;
            r312 = r312;
            r315 = r315;
            r132 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r132);
            r153 = r142 | 4096;
            goto L21
        L23:
            r135 = r135;
            r313 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r313);
            r151 = r142 | 2048;
            goto L24
        L25:
            r102 = r102;
            r131 = r131;
            r135 = r135;
            r312 = r312;
            r313 = r313;
            r315 = r315;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r140);
            int r154 = r142 | 1024;
        L26:
            r313 = r313;
        L35:
            r152 = r154;
            r311 = r311;
            goto L38
        L27:
            r137 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r137);
            r154 = r142 | 512;
            goto L26
        L28:
            r138 = (Integer) r101.decodeNullableSerializableElement(r100, 8, w0.f520792a, r138);
            r154 = r142 | 256;
            goto L26
        L30:
            r102 = r102;
            r131 = r131;
            r135 = r135;
            r312 = r312;
            r313 = r313;
            r315 = r315;
            r134 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r134);
            r154 = r142 | 128;
            goto L26
        L32:
            r102 = r102;
            r131 = r131;
            r135 = r135;
            r312 = r312;
            r313 = r313;
            r315 = r315;
            r139 = (Integer) r101.decodeNullableSerializableElement(r100, 6, w0.f520792a, r139);
            r154 = r142 | 64;
            goto L26
        L33:
            r102 = r102;
            r131 = r131;
            r135 = r135;
            r312 = r312;
            r313 = r313;
            r315 = r315;
            r136 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r136);
            r154 = r142 | 32;
            goto L26
        L34:
            r102 = r102;
            r131 = r131;
            r135 = r135;
            r312 = r312;
            r315 = r315;
            r313 = r313;
            r311 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r311);
            r154 = r142 | 16;
            goto L35
        L37:
            r102 = r102;
            r131 = r131;
            r135 = r135;
            r312 = r312;
            r313 = r313;
            r315 = r315;
            r311 = r311;
            r316 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r316);
            r152 = r142 | 8;
            goto L38
        L40:
            r222 = r316;
            int r155 = r142 | 4;
            String r156 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r314);
        L42:
            String r157 = r221;
        L44:
            r142 = r155;
            r149 = r157;
            r132 = r132;
            String r320 = r156;
            r148 = r312;
            r135 = r135;
            r150 = r320;
            goto L45
        L41:
            r156 = r314;
            r222 = r316;
            r221 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r221);
            r155 = r142 | 2;
            goto L42
        L43:
            r102 = r102;
            r131 = r131;
            r132 = r132;
            r135 = r135;
            r311 = r311;
            r312 = r312;
            r313 = r313;
            r156 = r314;
            r315 = r315;
            r222 = r316;
            r220 = (Long) r101.decodeNullableSerializableElement(r100, 0, g1.f520681a, r220);
            r155 = r142 | 1;
            r157 = r221;
            goto L44
        L47:
            String r223 = r132;
            Long r158 = r220;
            String r224 = r221;
            String r225 = r311;
            r126 = r134;
            r216 = r137;
            r217 = r138;
            r310 = r141;
            r210 = r135;
            r214 = r131;
            r128 = r316;
            r130 = r225;
            r123 = r158;
            r213 = r133;
            r212 = r312;
            r125 = r136;
            r129 = r142;
            r219 = r140;
            r124 = r314;
            r122 = r139;
            r127 = r224;
            r215 = r223;
            r218 = r313;
            r211 = r315;
            goto L48
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            VLMImage r102 = (VLMImage) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346748b;
            muc.d r104 = r100.beginStructure(r103);
            VLMImage.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<VLMImage> serializer() {
            return a.f346747a;
        }
    }

    public VLMImage() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VLMImage copy$default(VLMImage r110, Long r111, String r112, String r210, List r211, String r212, Integer r213, Integer r214, String r215, Integer r216, String r217, String r218, String r219, String r310, Integer r311, Integer r312, Boolean r313, String r314, String r315, String r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        Long r100 = r110.cardId;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = r110.uri;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.thumbUrl;
    L15:
        if ((r317 & 8) == 0) goto L17;
        List r103 = r110.fullSizeUrl;
    L19:
        if ((r317 & 16) == 0) goto L21;
        String r104 = r110.mainSiteUrl;
    L23:
        if ((r317 & 32) == 0) goto L25;
        Integer r105 = r110.height;
    L27:
        if ((r317 & 64) == 0) goto L29;
        Integer r106 = r110.width;
    L31:
        if ((r317 & 128) == 0) goto L33;
        String r107 = r110.authorShortId;
    L35:
        if ((r317 & 256) == 0) goto L37;
        Integer r113 = r110.sourceFrom;
    L39:
        if ((r317 & 512) == 0) goto L41;
        String r114 = r110.sourceAppName;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r115 = r110.sourceAppIcon;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        String r116 = r110.imgCaption;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        String r117 = r110.originThumbUrl;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        Integer r118 = r110.originWidth;
    L58:
        Integer r319 = r118;
        if ((r317 & 16384) == 0) goto L61;
        Integer r119 = r110.originHeight;
    L62:
        Integer r320 = r119;
        if ((r317 & 32768) == 0) goto L65;
        Boolean r120 = r110.isBlurBackground;
    L66:
        Boolean r321 = r120;
        if ((r317 & 65536) == 0) goto L69;
        String r121 = r110.imageSource;
    L70:
        String r322 = r121;
        if ((r317 & 131072) == 0) goto L73;
        String r122 = r110.docId;
    L75:
        if ((r317 & 262144) == 0) goto L77;
        String r108 = r110.searchId;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
    L77:
        r108 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L75
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

    @SerialName("author_short_id")
    public static /* synthetic */ void getAuthorShortId$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getCardId$annotations() {
    }

    @SerialName("doc_id")
    public static /* synthetic */ void getDocId$annotations() {
    }

    @SerialName("full_size_url")
    public static /* synthetic */ void getFullSizeUrl$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("image_source")
    public static /* synthetic */ void getImageSource$annotations() {
    }

    @SerialName("img_caption")
    public static /* synthetic */ void getImgCaption$annotations() {
    }

    @SerialName("main_site_url")
    public static /* synthetic */ void getMainSiteUrl$annotations() {
    }

    @SerialName("origin_height")
    public static /* synthetic */ void getOriginHeight$annotations() {
    }

    @SerialName("origin_thumb_url")
    public static /* synthetic */ void getOriginThumbUrl$annotations() {
    }

    @SerialName("origin_width")
    public static /* synthetic */ void getOriginWidth$annotations() {
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

    @SerialName("thumb_url")
    public static /* synthetic */ void getThumbUrl$annotations() {
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    @SerialName("is_blur_background")
    public static /* synthetic */ void isBlurBackground$annotations() {
    }

    public final Long component1() {
        return this.cardId;
    }

    public final String component10() {
        return this.sourceAppName;
    }

    public final String component11() {
        return this.sourceAppIcon;
    }

    public final String component12() {
        return this.imgCaption;
    }

    public final String component13() {
        return this.originThumbUrl;
    }

    public final Integer component14() {
        return this.originWidth;
    }

    public final Integer component15() {
        return this.originHeight;
    }

    public final Boolean component16() {
        return this.isBlurBackground;
    }

    public final String component17() {
        return this.imageSource;
    }

    public final String component18() {
        return this.docId;
    }

    public final String component19() {
        return this.searchId;
    }

    public final String component2() {
        return this.uri;
    }

    public final String component3() {
        return this.thumbUrl;
    }

    public final List<String> component4() {
        return this.fullSizeUrl;
    }

    public final String component5() {
        return this.mainSiteUrl;
    }

    public final Integer component6() {
        return this.height;
    }

    public final Integer component7() {
        return this.width;
    }

    public final String component8() {
        return this.authorShortId;
    }

    public final Integer component9() {
        return this.sourceFrom;
    }

    public final VLMImage copy(Long r210, String r211, String r212, List<String> r213, String r214, Integer r215, Integer r216, String r217, Integer r310, String r311, String r312, String r313, String r314, Integer r315, Integer r316, Boolean r317, String r318, String r319, String r410) {
        return new VLMImage(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VLMImage) == true) goto L8;
        return false;
    L8:
        VLMImage r101 = (VLMImage) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.thumbUrl, r101.thumbUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fullSizeUrl, r101.fullSizeUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mainSiteUrl, r101.mainSiteUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.authorShortId, r101.authorShortId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceAppName, r101.sourceAppName) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sourceAppIcon, r101.sourceAppIcon) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.imgCaption, r101.imgCaption) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.originThumbUrl, r101.originThumbUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.originWidth, r101.originWidth) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.originHeight, r101.originHeight) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.isBlurBackground, r101.isBlurBackground) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.imageSource, r101.imageSource) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.docId, r101.docId) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        Long r100 = this.cardId;
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
        String r107 = this.thumbUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.fullSizeUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mainSiteUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.height;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.width;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.authorShortId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.sourceFrom;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.sourceAppName;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.sourceAppIcon;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.imgCaption;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.originThumbUrl;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.originWidth;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.originHeight;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.isBlurBackground;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.imageSource;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.docId;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.searchId;
        if (r155 == null) goto L79;
        r101 = r155.hashCode();
    L79:
        return r154 + r101;
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
        return "VLMImage(cardId=" + this.cardId + ", uri=" + this.uri + ", thumbUrl=" + this.thumbUrl + ", fullSizeUrl=" + this.fullSizeUrl + ", mainSiteUrl=" + this.mainSiteUrl + ", height=" + this.height + ", width=" + this.width + ", authorShortId=" + this.authorShortId + ", sourceFrom=" + this.sourceFrom + ", sourceAppName=" + this.sourceAppName + ", sourceAppIcon=" + this.sourceAppIcon + ", imgCaption=" + this.imgCaption + ", originThumbUrl=" + this.originThumbUrl + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", isBlurBackground=" + this.isBlurBackground + ", imageSource=" + this.imageSource + ", docId=" + this.docId + ", searchId=" + this.searchId + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new o1()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getAuthorShortId() {
        return this.authorShortId;
    }

    public final Long getCardId() {
        return this.cardId;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final List<String> getFullSizeUrl() {
        return this.fullSizeUrl;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getImageSource() {
        return this.imageSource;
    }

    public final String getImgCaption() {
        return this.imgCaption;
    }

    public final String getMainSiteUrl() {
        return this.mainSiteUrl;
    }

    public final Integer getOriginHeight() {
        return this.originHeight;
    }

    public final String getOriginThumbUrl() {
        return this.originThumbUrl;
    }

    public final Integer getOriginWidth() {
        return this.originWidth;
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

    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean isBlurBackground() {
        return this.isBlurBackground;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(VLMImage r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, g1.f520681a, r100.cardId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.uri);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.thumbUrl);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.fullSizeUrl);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.mainSiteUrl);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.height);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.width);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.authorShortId);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, w0.f520792a, r100.sourceFrom);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.sourceAppName);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.sourceAppIcon);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, v2.f520790a, r100.imgCaption);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, v2.f520790a, r100.originThumbUrl);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r101.encodeNullableSerializableElement(r102, 13, w0.f520792a, r100.originWidth);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r101.encodeNullableSerializableElement(r102, 14, w0.f520792a, r100.originHeight);
    L138:
        if (r101.shouldEncodeElementDefault(r102, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r101.encodeNullableSerializableElement(r102, 15, i.f520705a, r100.isBlurBackground);
    L147:
        if (r101.shouldEncodeElementDefault(r102, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r101.encodeNullableSerializableElement(r102, 16, v2.f520790a, r100.imageSource);
    L156:
        if (r101.shouldEncodeElementDefault(r102, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r101.encodeNullableSerializableElement(r102, 17, v2.f520790a, r100.docId);
    L165:
        if (r101.shouldEncodeElementDefault(r102, 18) == false) goto L168;
    L166:
        r104 = true;
    L170:
        if (r104 == false) goto L173;
        r101.encodeNullableSerializableElement(r102, 18, v2.f520790a, r100.searchId);
        return;
    L173:
        return;
    L168:
        if (r100.searchId == null) goto L170;
    L159:
        if (r100.docId != null) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r100.imageSource != null) goto L148;
        r121 = false;
        goto L153
    L141:
        if (Intrinsics.areEqual(r100.isBlurBackground, Boolean.FALSE) == false) goto L139;
        r120 = false;
        goto L144
    L132:
        if (r100.originHeight != null) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.originWidth != null) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.originThumbUrl != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (Intrinsics.areEqual(r100.imgCaption, "") == false) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.sourceAppIcon != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.sourceAppName != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.sourceFrom != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.authorShortId != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.width != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.height != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.mainSiteUrl != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.fullSizeUrl != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.thumbUrl != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.uri != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.cardId != null) goto L4;
        r105 = false;
        goto L9
    }

    public VLMImage(Long r100, String r101, String r102, List<String> r103, String r104, Integer r105, Integer r106, String r110, Integer r111, String r112, String r113, String r114, String r115, Integer r116, Integer r117, Boolean r118, String r119, String r210, String r211) {
        this.cardId = r100;
        this.uri = r101;
        this.thumbUrl = r102;
        this.fullSizeUrl = r103;
        this.mainSiteUrl = r104;
        this.height = r105;
        this.width = r106;
        this.authorShortId = r110;
        this.sourceFrom = r111;
        this.sourceAppName = r112;
        this.sourceAppIcon = r113;
        this.imgCaption = r114;
        this.originThumbUrl = r115;
        this.originWidth = r116;
        this.originHeight = r117;
        this.isBlurBackground = r118;
        this.imageSource = r119;
        this.docId = r210;
        this.searchId = r211;
    }

    public VLMImage(int r100, Long r101, String r102, String r103, List r110, String r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117, String r118, String r119, Integer r210, Integer r211, Boolean r212, String r213, String r214, String r215, q2 r216) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346748b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.cardId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.uri = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.thumbUrl = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.fullSizeUrl = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.mainSiteUrl = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.height = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.width = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.authorShortId = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.sourceFrom = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.sourceAppName = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.sourceAppIcon = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        String r104 = "";
    L52:
        this.imgCaption = r104;
        if ((r100 & 4096) != 0) goto L55;
        this.originThumbUrl = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.originWidth = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.originHeight = null;
    L65:
        if ((32768 & r100) != 0) goto L67;
        Boolean r105 = Boolean.FALSE;
    L68:
        this.isBlurBackground = r105;
        if ((65536 & r100) != 0) goto L71;
        this.imageSource = null;
    L73:
        if ((131072 & r100) != 0) goto L75;
        this.docId = null;
    L77:
        if ((r100 & 262144) != 0) goto L79;
        this.searchId = null;
        return;
    L79:
        this.searchId = r215;
        return;
    L75:
        this.docId = r214;
        goto L77
    L71:
        this.imageSource = r213;
        goto L73
    L67:
        r105 = r212;
        goto L68
    L63:
        this.originHeight = r211;
        goto L65
    L59:
        this.originWidth = r210;
        goto L61
    L55:
        this.originThumbUrl = r119;
        goto L57
    L51:
        r104 = r118;
        goto L52
    L47:
        this.sourceAppIcon = r117;
        goto L49
    L43:
        this.sourceAppName = r116;
        goto L45
    L39:
        this.sourceFrom = r115;
        goto L41
    L35:
        this.authorShortId = r114;
        goto L37
    L31:
        this.width = r113;
        goto L33
    L27:
        this.height = r112;
        goto L29
    L23:
        this.mainSiteUrl = r111;
        goto L25
    L19:
        this.fullSizeUrl = r110;
        goto L21
    L15:
        this.thumbUrl = r103;
        goto L17
    L11:
        this.uri = r102;
        goto L13
    L7:
        this.cardId = r101;
        goto L9
    }

    public /* synthetic */ VLMImage(Long r210, String r211, String r212, List r213, String r214, Integer r215, Integer r216, String r217, Integer r218, String r310, String r311, String r312, String r313, Integer r314, Integer r315, Boolean r316, String r317, String r318, String r319, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        Integer r115 = null;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        Boolean r116 = Boolean.FALSE;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r410 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r410 & 262144) == 0) goto L77;
        String r109 = null;
    L78:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r109);
        return;
    L77:
        r109 = r319;
        goto L78
    L73:
        r118 = r318;
        goto L75
    L69:
        r117 = r317;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r115 = r314;
        goto L59
    L53:
        r114 = r313;
        goto L55
    L49:
        r113 = r312;
        goto L51
    L45:
        r112 = r311;
        goto L47
    L41:
        r111 = r310;
        goto L43
    L37:
        r110 = r218;
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
