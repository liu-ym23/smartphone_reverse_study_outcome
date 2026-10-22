package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ~2\u00060\u0001j\u0002`\u0002:\u0002}~BÑ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!BÃ\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010^\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010b\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010HJ\u0010\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001fHÆ\u0003JØ\u0001\u0010i\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010jJ\u0006\u0010k\u001a\u00020\u0006J\u0013\u0010l\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010nHÖ\u0003J\t\u0010o\u001a\u00020\u0006HÖ\u0001J\t\u0010p\u001a\u00020\u0004HÖ\u0001J\u0016\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0006J%\u0010v\u001a\u00020r2\u0006\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0001¢\u0006\u0002\b|R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\b1\u0010'\u001a\u0004\b2\u0010/R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010'\u001a\u0004\b4\u00105R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00109\u0012\u0004\b6\u0010'\u001a\u0004\b7\u00108R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010'\u001a\u0004\b;\u0010<R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010'\u001a\u0004\b>\u0010?R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010'\u001a\u0004\bA\u0010)R \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\bB\u0010'\u001a\u0004\bC\u0010/R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010'\u001a\u0004\bE\u0010FR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bG\u0010'\u001a\u0004\b\u0015\u0010HR \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00109\u0012\u0004\bJ\u0010'\u001a\u0004\bK\u00108R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010'\u001a\u0004\bM\u0010NR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010'\u001a\u0004\bP\u0010QR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010'\u001a\u0004\bS\u0010TR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010'\u001a\u0004\bV\u0010W¨\u0006\u007f"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "creationId", "", "userCreationType", "", "status", "privateStatus", "content", "Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;", "usageCount", "", "authorInfo", "Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;", "dynamicInfo", "Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;", "creationTraceInfo", "contentSource", "communityInfo", "Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;", Keys.API_EVENT_KEY_IS_FAVORITE, "", "createTime", "clientTrackParams", "Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;", "refContent", "Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;", "publishExtra", "Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;", "awemeAnchor", "Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationId$annotations", "()V", "getCreationId", "()Ljava/lang/String;", "getUserCreationType$annotations", "getUserCreationType", "()I", "getStatus$annotations", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivateStatus$annotations", "getPrivateStatus", "getContent$annotations", "getContent", "()Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;", "getUsageCount$annotations", "getUsageCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAuthorInfo$annotations", "getAuthorInfo", "()Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;", "getDynamicInfo$annotations", "getDynamicInfo", "()Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;", "getCreationTraceInfo$annotations", "getCreationTraceInfo", "getContentSource$annotations", "getContentSource", "getCommunityInfo$annotations", "getCommunityInfo", "()Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;", "isFavorite$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreateTime$annotations", "getCreateTime", "getClientTrackParams$annotations", "getClientTrackParams", "()Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;", "getRefContent$annotations", "getRefContent", "()Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;", "getPublishExtra$annotations", "getPublishExtra", "()Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;", "getAwemeAnchor$annotations", "getAwemeAnchor", "()Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;)Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UserCreationKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationKmp> CREATOR = null;
    public static final b Companion = null;
    private final AuthorInfoKmp authorInfo;
    private final AwemeAnchorKmp awemeAnchor;
    private final UserCreationTrackParamsKmp clientTrackParams;
    private final CreationCommunityInfoKmp communityInfo;
    private final UserCreationContentKmp content;
    private final Integer contentSource;
    private final Long createTime;
    private final String creationId;
    private final String creationTraceInfo;
    private final CreationDynamicInfoKmp dynamicInfo;
    private final Boolean isFavorite;
    private final Integer privateStatus;
    private final CreationPublishExtraKmp publishExtra;
    private final UserCreationRefContentKmp refContent;
    private final Integer status;
    private final Long usageCount;
    private final int userCreationType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationKmp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f374356a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f374357b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f374357b;
        }

        static {
            a r100 = new a();
            f374356a = r100;
            g2 r101 = new g2("com.larus.ugc.feed.api.model.UserCreationKmp", r100, 17);
            r101.j("creation_id", true);
            r101.j("creation_type", true);
            r101.j("status", true);
            r101.j("private_status", true);
            r101.j("content", true);
            r101.j("usage_count", true);
            r101.j("author_info", true);
            r101.j("dynamic_info", true);
            r101.j("creation_trace_info", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, true);
            r101.j("community_info", true);
            r101.j("is_favorite", true);
            r101.j("create_time", true);
            r101.j("client_track_params", true);
            r101.j("ref_content", true);
            r101.j("publish_extra", true);
            r101.j("aweme_anchor", true);
            f374357b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            g1 r102 = g1.f520681a;
            return new d[]{kuc.a.d(r100), r101, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(UserCreationContentKmp.a.f374352a), kuc.a.d(r102), kuc.a.d(AuthorInfoKmp.a.f374306a), kuc.a.d(CreationDynamicInfoKmp.a.f374316a), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(CreationCommunityInfoKmp.a.f374314a), kuc.a.d(i.f520705a), kuc.a.d(r102), kuc.a.d(UserCreationTrackParamsKmp.a.f374364a), kuc.a.d(UserCreationRefContentKmp.a.f374362a), kuc.a.d(CreationPublishExtraKmp.a.f374326a), kuc.a.d(AwemeAnchorKmp.a.f374308a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f374357b;
            muc.c r101 = r310.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            int r104 = r101.decodeIntElement(r100, 1);
            w0 r105 = w0.f520792a;
            Integer r110 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            Integer r111 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            UserCreationContentKmp r106 = (UserCreationContentKmp) r101.decodeNullableSerializableElement(r100, 4, UserCreationContentKmp.a.f374352a, null);
            g1 r112 = g1.f520681a;
            Long r113 = (Long) r101.decodeNullableSerializableElement(r100, 5, r112, null);
            AuthorInfoKmp r107 = (AuthorInfoKmp) r101.decodeNullableSerializableElement(r100, 6, AuthorInfoKmp.a.f374306a, null);
            CreationDynamicInfoKmp r114 = (CreationDynamicInfoKmp) r101.decodeNullableSerializableElement(r100, 7, CreationDynamicInfoKmp.a.f374316a, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 8, r102, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            CreationCommunityInfoKmp r115 = (CreationCommunityInfoKmp) r101.decodeNullableSerializableElement(r100, 10, CreationCommunityInfoKmp.a.f374314a, null);
            Boolean r116 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, i.f520705a, null);
            Long r117 = (Long) r101.decodeNullableSerializableElement(r100, 12, r112, null);
            Boolean r118 = r116;
            UserCreationTrackParamsKmp r119 = (UserCreationTrackParamsKmp) r101.decodeNullableSerializableElement(r100, 13, UserCreationTrackParamsKmp.a.f374364a, null);
            UserCreationRefContentKmp r120 = (UserCreationRefContentKmp) r101.decodeNullableSerializableElement(r100, 14, UserCreationRefContentKmp.a.f374362a, null);
            CreationPublishExtraKmp r210 = (CreationPublishExtraKmp) r101.decodeNullableSerializableElement(r100, 15, CreationPublishExtraKmp.a.f374326a, null);
            AwemeAnchorKmp r211 = (AwemeAnchorKmp) r101.decodeNullableSerializableElement(r100, 16, AwemeAnchorKmp.a.f374308a, null);
            AuthorInfoKmp r121 = r107;
            Long r212 = r117;
            Integer r122 = r110;
            UserCreationRefContentKmp r213 = r120;
            Integer r123 = r109;
            int r124 = r104;
            CreationDynamicInfoKmp r125 = r114;
            Long r126 = r113;
            UserCreationContentKmp r127 = r106;
            String r128 = r103;
            String r129 = r108;
            UserCreationTrackParamsKmp r214 = r119;
            CreationCommunityInfoKmp r130 = r115;
            int r131 = 131071;
        L43:
            r101.endStructure(r100);
            return new UserCreationKmp(r131, r128, r124, r122, r111, r127, r126, r121, r125, r129, r123, r130, r118, r212, r214, r213, r210, r211, null);
        L5:
            AuthorInfoKmp r132 = null;
            Integer r133 = null;
            Long r134 = null;
            UserCreationRefContentKmp r135 = null;
            UserCreationContentKmp r136 = null;
            CreationDynamicInfoKmp r137 = null;
            Long r138 = null;
            AwemeAnchorKmp r139 = null;
            CreationCommunityInfoKmp r140 = null;
            Boolean r141 = null;
            CreationPublishExtraKmp r142 = null;
            UserCreationTrackParamsKmp r143 = null;
            String r215 = null;
            Integer r216 = null;
            Integer r217 = null;
            String r311 = null;
            int r144 = 0;
            int r312 = 0;
            boolean r313 = true;
        L6:
            if (r313 == false) goto L42;
            int r145 = r101.decodeElementIndex(r100);
            switch(r145) {
                case -1: goto L40;
                case 0: goto L38;
                case 1: goto L35;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L25;
                case 8: goto L22;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L16;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                default: goto L10;
            };
        L11:
            int r146 = 65536 | r312;
            AwemeAnchorKmp r314 = (AwemeAnchorKmp) r101.decodeNullableSerializableElement(r100, 16, AwemeAnchorKmp.a.f374308a, r139);
        L17:
            r133 = r133;
            int r147 = r146;
            Integer r218 = r217;
            String r219 = r311;
            r139 = r314;
        L37:
            AuthorInfoKmp r220 = r132;
            r312 = r147;
            Integer r148 = r216;
            r133 = r133;
            r144 = r144;
            String r221 = r219;
        L39:
            r216 = r148;
            r217 = r218;
            r132 = r220;
            r311 = r221;
            goto L6
        L12:
            r142 = (CreationPublishExtraKmp) r101.decodeNullableSerializableElement(r100, 15, CreationPublishExtraKmp.a.f374326a, r142);
            int r149 = 32768 | r312;
        L21:
            r133 = r133;
        L23:
            r311 = r311;
        L30:
            r147 = r149;
            r218 = r217;
        L36:
            r219 = r311;
            r139 = r139;
            goto L37
        L13:
            int r150 = r312;
            r314 = r139;
            r135 = (UserCreationRefContentKmp) r101.decodeNullableSerializableElement(r100, 14, UserCreationRefContentKmp.a.f374362a, r135);
            r146 = r150 | 16384;
            goto L17
        L14:
            int r151 = r312;
            r314 = r139;
            r143 = (UserCreationTrackParamsKmp) r101.decodeNullableSerializableElement(r100, 13, UserCreationTrackParamsKmp.a.f374364a, r143);
            r146 = r151 | 8192;
            goto L17
        L16:
            r144 = r144;
            int r152 = r312;
            r314 = r139;
            r138 = (Long) r101.decodeNullableSerializableElement(r100, 12, g1.f520681a, r138);
            r146 = r152 | 4096;
            goto L17
        L18:
            r141 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, i.f520705a, r141);
            r149 = r312 | 2048;
            goto L21
        L19:
            r140 = (CreationCommunityInfoKmp) r101.decodeNullableSerializableElement(r100, 10, CreationCommunityInfoKmp.a.f374314a, r140);
            r149 = r312 | 1024;
            goto L21
        L20:
            r133 = (Integer) r101.decodeNullableSerializableElement(r100, 9, w0.f520792a, r133);
            r149 = r312 | 512;
            goto L21
        L22:
            r144 = r144;
            int r153 = r312;
            r139 = r139;
            r133 = r133;
            r311 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r311);
            r149 = r153 | 256;
            goto L23
        L25:
            r137 = (CreationDynamicInfoKmp) r101.decodeNullableSerializableElement(r100, 7, CreationDynamicInfoKmp.a.f374316a, r137);
            int r154 = r312 | 128;
        L26:
            r218 = r217;
        L33:
            r147 = r154;
            r132 = r132;
            goto L36
        L27:
            r133 = r133;
            r144 = r144;
            int r155 = r312;
            r139 = r139;
            r311 = r311;
            r132 = (AuthorInfoKmp) r101.decodeNullableSerializableElement(r100, 6, AuthorInfoKmp.a.f374306a, r132);
            r149 = r155 | 64;
            goto L30
        L28:
            r134 = (Long) r101.decodeNullableSerializableElement(r100, 5, g1.f520681a, r134);
            r154 = r312 | 32;
            goto L26
        L29:
            r133 = r133;
            r144 = r144;
            int r156 = r312;
            r139 = r139;
            r311 = r311;
            r136 = (UserCreationContentKmp) r101.decodeNullableSerializableElement(r100, 4, UserCreationContentKmp.a.f374352a, r136);
            r149 = r156 | 16;
            goto L30
        L31:
            r217 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r217);
            r154 = r312 | 8;
            goto L26
        L32:
            r132 = r132;
            r133 = r133;
            r144 = r144;
            int r157 = r312;
            r139 = r139;
            r311 = r311;
            r218 = r217;
            r216 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r216);
            r154 = r157 | 4;
            goto L33
        L35:
            r133 = r133;
            r218 = r217;
            int r158 = r312;
            r139 = r139;
            r311 = r311;
            r147 = r158 | 2;
            r144 = r101.decodeIntElement(r100, 1);
            r132 = r132;
            goto L36
        L38:
            r220 = r132;
            Integer r222 = r133;
            int r315 = r144;
            r218 = r217;
            int r159 = r312;
            int r160 = r159 | 1;
            r144 = r315;
            r215 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r215);
            r133 = r222;
            r221 = r311;
            r139 = r139;
            r312 = r160;
            r148 = r216;
            goto L39
        L40:
            int r316 = r144;
            r132 = r132;
            r139 = r139;
            r313 = false;
            r215 = r215;
            r312 = r312;
            r144 = r316;
            goto L6
        L10:
            throw new UnknownFieldException(r145);
        L42:
            int r317 = r144;
            String r161 = r215;
            int r162 = r312;
            AwemeAnchorKmp r318 = r139;
            r213 = r135;
            r212 = r138;
            r129 = r311;
            r130 = r140;
            r118 = r141;
            r210 = r142;
            r214 = r143;
            r122 = r216;
            r111 = r217;
            r121 = r132;
            r123 = r133;
            r211 = r318;
            r126 = r134;
            r131 = r162;
            r127 = r136;
            r125 = r137;
            r124 = r317;
            r128 = r161;
            goto L43
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UserCreationKmp r102 = (UserCreationKmp) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f374357b;
            muc.d r104 = r100.beginStructure(r103);
            UserCreationKmp.write$Self$feed_kmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationKmp> serializer() {
            return a.f374356a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationKmp createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            int r101 = r210.readInt();
            AwemeAnchorKmp r102 = null;
            if (r210.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            if (r210.readInt() != 0) goto L9;
            Integer r104 = null;
        L11:
            if (r210.readInt() != 0) goto L13;
            UserCreationContentKmp r105 = null;
        L14:
            UserCreationContentKmp r106 = r105;
            if (r210.readInt() != 0) goto L17;
            Long r107 = null;
        L19:
            if (r210.readInt() != 0) goto L21;
            AuthorInfoKmp r108 = null;
        L22:
            AuthorInfoKmp r110 = r108;
            if (r210.readInt() != 0) goto L25;
            CreationDynamicInfoKmp r109 = null;
        L26:
            CreationDynamicInfoKmp r111 = r109;
            String r112 = r210.readString();
            if (r210.readInt() != 0) goto L29;
            Integer r113 = null;
        L31:
            if (r210.readInt() != 0) goto L33;
            CreationCommunityInfoKmp r114 = null;
        L34:
            CreationCommunityInfoKmp r115 = r114;
            if (r210.readInt() != 0) goto L38;
            Boolean r116 = null;
        L43:
            if (r210.readInt() != 0) goto L45;
            Long r117 = null;
        L47:
            if (r210.readInt() != 0) goto L49;
            UserCreationTrackParamsKmp r118 = null;
        L50:
            UserCreationTrackParamsKmp r119 = r118;
            if (r210.readInt() != 0) goto L53;
            UserCreationRefContentKmp r120 = null;
        L54:
            UserCreationRefContentKmp r121 = r120;
            if (r210.readInt() != 0) goto L57;
            CreationPublishExtraKmp r122 = null;
        L58:
            CreationPublishExtraKmp r211 = r122;
            if (r210.readInt() == 0) goto L63;
            r102 = AwemeAnchorKmp.CREATOR.createFromParcel(r210);
        L63:
            return new UserCreationKmp(r100, r101, r103, r104, r106, r107, r110, r111, r112, r113, r115, r116, r117, r119, r121, r211, r102);
        L57:
            r122 = CreationPublishExtraKmp.CREATOR.createFromParcel(r210);
            goto L58
        L53:
            r120 = UserCreationRefContentKmp.CREATOR.createFromParcel(r210);
            goto L54
        L49:
            r118 = UserCreationTrackParamsKmp.CREATOR.createFromParcel(r210);
            goto L50
        L45:
            r117 = Long.valueOf(r210.readLong());
            goto L47
        L38:
            if (r210.readInt() == 0) goto L40;
            boolean r123 = true;
        L41:
            r116 = Boolean.valueOf(r123);
            goto L43
        L40:
            r123 = false;
            goto L41
        L33:
            r114 = CreationCommunityInfoKmp.CREATOR.createFromParcel(r210);
            goto L34
        L29:
            r113 = Integer.valueOf(r210.readInt());
            goto L31
        L25:
            r109 = CreationDynamicInfoKmp.CREATOR.createFromParcel(r210);
            goto L26
        L21:
            r108 = AuthorInfoKmp.CREATOR.createFromParcel(r210);
            goto L22
        L17:
            r107 = Long.valueOf(r210.readLong());
            goto L19
        L13:
            r105 = UserCreationContentKmp.CREATOR.createFromParcel(r210);
            goto L14
        L9:
            r104 = Integer.valueOf(r210.readInt());
            goto L11
        L5:
            r103 = Integer.valueOf(r210.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationKmp[] newArray(int r100) {
            return new UserCreationKmp[r100];
        }
    }

    public UserCreationKmp() {
        this(null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ UserCreationKmp copy$default(UserCreationKmp r110, String r111, int r112, Integer r210, Integer r211, UserCreationContentKmp r212, Long r213, AuthorInfoKmp r214, CreationDynamicInfoKmp r215, String r216, Integer r217, CreationCommunityInfoKmp r218, Boolean r219, Long r310, UserCreationTrackParamsKmp r311, UserCreationRefContentKmp r312, CreationPublishExtraKmp r313, AwemeAnchorKmp r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.creationId;
    L7:
        if ((r315 & 2) == 0) goto L9;
        int r101 = r110.userCreationType;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Integer r102 = r110.status;
    L15:
        if ((r315 & 8) == 0) goto L17;
        Integer r103 = r110.privateStatus;
    L19:
        if ((r315 & 16) == 0) goto L21;
        UserCreationContentKmp r104 = r110.content;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Long r105 = r110.usageCount;
    L27:
        if ((r315 & 64) == 0) goto L29;
        AuthorInfoKmp r106 = r110.authorInfo;
    L31:
        if ((r315 & 128) == 0) goto L33;
        CreationDynamicInfoKmp r107 = r110.dynamicInfo;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.creationTraceInfo;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Integer r114 = r110.contentSource;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        CreationCommunityInfoKmp r115 = r110.communityInfo;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Boolean r116 = r110.isFavorite;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Long r117 = r110.createTime;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        UserCreationTrackParamsKmp r118 = r110.clientTrackParams;
    L58:
        UserCreationTrackParamsKmp r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        UserCreationRefContentKmp r119 = r110.refContent;
    L62:
        UserCreationRefContentKmp r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        CreationPublishExtraKmp r120 = r110.publishExtra;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        AwemeAnchorKmp r108 = r110.awemeAnchor;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
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

    @SerialName("author_info")
    public static /* synthetic */ void getAuthorInfo$annotations() {
    }

    @SerialName("aweme_anchor")
    public static /* synthetic */ void getAwemeAnchor$annotations() {
    }

    @SerialName("client_track_params")
    public static /* synthetic */ void getClientTrackParams$annotations() {
    }

    @SerialName("community_info")
    public static /* synthetic */ void getCommunityInfo$annotations() {
    }

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE)
    public static /* synthetic */ void getContentSource$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("creation_id")
    public static /* synthetic */ void getCreationId$annotations() {
    }

    @SerialName("creation_trace_info")
    public static /* synthetic */ void getCreationTraceInfo$annotations() {
    }

    @SerialName("dynamic_info")
    public static /* synthetic */ void getDynamicInfo$annotations() {
    }

    @SerialName("private_status")
    public static /* synthetic */ void getPrivateStatus$annotations() {
    }

    @SerialName("publish_extra")
    public static /* synthetic */ void getPublishExtra$annotations() {
    }

    @SerialName("ref_content")
    public static /* synthetic */ void getRefContent$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("usage_count")
    public static /* synthetic */ void getUsageCount$annotations() {
    }

    @SerialName("creation_type")
    public static /* synthetic */ void getUserCreationType$annotations() {
    }

    @SerialName("is_favorite")
    public static /* synthetic */ void isFavorite$annotations() {
    }

    public final String component1() {
        return this.creationId;
    }

    public final Integer component10() {
        return this.contentSource;
    }

    public final CreationCommunityInfoKmp component11() {
        return this.communityInfo;
    }

    public final Boolean component12() {
        return this.isFavorite;
    }

    public final Long component13() {
        return this.createTime;
    }

    public final UserCreationTrackParamsKmp component14() {
        return this.clientTrackParams;
    }

    public final UserCreationRefContentKmp component15() {
        return this.refContent;
    }

    public final CreationPublishExtraKmp component16() {
        return this.publishExtra;
    }

    public final AwemeAnchorKmp component17() {
        return this.awemeAnchor;
    }

    public final int component2() {
        return this.userCreationType;
    }

    public final Integer component3() {
        return this.status;
    }

    public final Integer component4() {
        return this.privateStatus;
    }

    public final UserCreationContentKmp component5() {
        return this.content;
    }

    public final Long component6() {
        return this.usageCount;
    }

    public final AuthorInfoKmp component7() {
        return this.authorInfo;
    }

    public final CreationDynamicInfoKmp component8() {
        return this.dynamicInfo;
    }

    public final String component9() {
        return this.creationTraceInfo;
    }

    public final UserCreationKmp copy(String r210, int r211, Integer r212, Integer r213, UserCreationContentKmp r214, Long r215, AuthorInfoKmp r216, CreationDynamicInfoKmp r217, String r218, Integer r219, CreationCommunityInfoKmp r310, Boolean r311, Long r312, UserCreationTrackParamsKmp r313, UserCreationRefContentKmp r314, CreationPublishExtraKmp r315, AwemeAnchorKmp r316) {
        return new UserCreationKmp(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCreationKmp) == true) goto L8;
        return false;
    L8:
        UserCreationKmp r101 = (UserCreationKmp) r100;
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L12;
        return false;
    L12:
        if (this.userCreationType == r101.userCreationType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.usageCount, r101.usageCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.authorInfo, r101.authorInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dynamicInfo, r101.dynamicInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.creationTraceInfo, r101.creationTraceInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.contentSource, r101.contentSource) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.communityInfo, r101.communityInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isFavorite, r101.isFavorite) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.clientTrackParams, r101.clientTrackParams) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.refContent, r101.refContent) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.publishExtra, r101.publishExtra) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.awemeAnchor, r101.awemeAnchor) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.userCreationType) * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.privateStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UserCreationContentKmp r110 = this.content;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.usageCount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        AuthorInfoKmp r116 = this.authorInfo;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CreationDynamicInfoKmp r119 = this.dynamicInfo;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.creationTraceInfo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.contentSource;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        CreationCommunityInfoKmp r128 = this.communityInfo;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.isFavorite;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.createTime;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        UserCreationTrackParamsKmp r137 = this.clientTrackParams;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        UserCreationRefContentKmp r140 = this.refContent;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        CreationPublishExtraKmp r143 = this.publishExtra;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        AwemeAnchorKmp r146 = this.awemeAnchor;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
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
        return "UserCreationKmp(creationId=" + this.creationId + ", userCreationType=" + this.userCreationType + ", status=" + this.status + ", privateStatus=" + this.privateStatus + ", content=" + this.content + ", usageCount=" + this.usageCount + ", authorInfo=" + this.authorInfo + ", dynamicInfo=" + this.dynamicInfo + ", creationTraceInfo=" + this.creationTraceInfo + ", contentSource=" + this.contentSource + ", communityInfo=" + this.communityInfo + ", isFavorite=" + this.isFavorite + ", createTime=" + this.createTime + ", clientTrackParams=" + this.clientTrackParams + ", refContent=" + this.refContent + ", publishExtra=" + this.publishExtra + ", awemeAnchor=" + this.awemeAnchor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.creationId);
        r100.writeInt(this.userCreationType);
        Integer r102 = this.status;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.privateStatus;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        UserCreationContentKmp r104 = this.content;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Long r105 = this.usageCount;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        AuthorInfoKmp r106 = this.authorInfo;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        CreationDynamicInfoKmp r107 = this.dynamicInfo;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        r100.writeString(this.creationTraceInfo);
        Integer r108 = this.contentSource;
        if (r108 != null) goto L29;
        r100.writeInt(0);
    L30:
        CreationCommunityInfoKmp r109 = this.communityInfo;
        if (r109 != null) goto L33;
        r100.writeInt(0);
    L34:
        Boolean r110 = this.isFavorite;
        if (r110 != null) goto L37;
        r100.writeInt(0);
    L38:
        Long r111 = this.createTime;
        if (r111 != null) goto L41;
        r100.writeInt(0);
    L42:
        UserCreationTrackParamsKmp r112 = this.clientTrackParams;
        if (r112 != null) goto L45;
        r100.writeInt(0);
    L46:
        UserCreationRefContentKmp r113 = this.refContent;
        if (r113 != null) goto L49;
        r100.writeInt(0);
    L50:
        CreationPublishExtraKmp r114 = this.publishExtra;
        if (r114 != null) goto L53;
        r100.writeInt(0);
    L54:
        AwemeAnchorKmp r115 = this.awemeAnchor;
        if (r115 != null) goto L57;
        r100.writeInt(0);
        return;
    L57:
        r100.writeInt(1);
        r115.writeToParcel(r100, r101);
        return;
    L53:
        r100.writeInt(1);
        r114.writeToParcel(r100, r101);
        goto L54
    L49:
        r100.writeInt(1);
        r113.writeToParcel(r100, r101);
        goto L50
    L45:
        r100.writeInt(1);
        r112.writeToParcel(r100, r101);
        goto L46
    L41:
        r100.writeInt(1);
        r100.writeLong(r111.longValue());
        goto L42
    L37:
        r100.writeInt(1);
        r100.writeInt(r110.booleanValue() ? 1 : 0);
        goto L38
    L33:
        r100.writeInt(1);
        r109.writeToParcel(r100, r101);
        goto L34
    L29:
        r100.writeInt(1);
        r100.writeInt(r108.intValue());
        goto L30
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
        r100.writeLong(r105.longValue());
        goto L18
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
    }

    public final AuthorInfoKmp getAuthorInfo() {
        return this.authorInfo;
    }

    public final AwemeAnchorKmp getAwemeAnchor() {
        return this.awemeAnchor;
    }

    public final UserCreationTrackParamsKmp getClientTrackParams() {
        return this.clientTrackParams;
    }

    public final CreationCommunityInfoKmp getCommunityInfo() {
        return this.communityInfo;
    }

    public final UserCreationContentKmp getContent() {
        return this.content;
    }

    public final Integer getContentSource() {
        return this.contentSource;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final String getCreationTraceInfo() {
        return this.creationTraceInfo;
    }

    public final CreationDynamicInfoKmp getDynamicInfo() {
        return this.dynamicInfo;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public final CreationPublishExtraKmp getPublishExtra() {
        return this.publishExtra;
    }

    public final UserCreationRefContentKmp getRefContent() {
        return this.refContent;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getUsageCount() {
        return this.usageCount;
    }

    public final int getUserCreationType() {
        return this.userCreationType;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationKmp r110, muc.d r111, f r210) {
        boolean r100 = true;
        if (r111.shouldEncodeElementDefault(r210, 0) == false) goto L6;
    L4:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        r111.encodeNullableSerializableElement(r210, 0, v2.f520790a, r110.creationId);
    L12:
        if (r111.shouldEncodeElementDefault(r210, 1) == false) goto L15;
    L13:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L21;
        r111.encodeIntElement(r210, 1, r110.userCreationType);
    L21:
        if (r111.shouldEncodeElementDefault(r210, 2) == false) goto L23;
    L22:
        boolean r103 = true;
    L30:
        if (r103 == false) goto L33;
        r111.encodeNullableSerializableElement(r210, 2, w0.f520792a, r110.status);
    L33:
        if (r111.shouldEncodeElementDefault(r210, 3) == false) goto L35;
    L34:
        boolean r104 = true;
    L42:
        if (r104 == false) goto L45;
        r111.encodeNullableSerializableElement(r210, 3, w0.f520792a, r110.privateStatus);
    L45:
        if (r111.shouldEncodeElementDefault(r210, 4) == false) goto L48;
    L46:
        boolean r105 = true;
    L51:
        if (r105 == false) goto L54;
        r111.encodeNullableSerializableElement(r210, 4, UserCreationContentKmp.a.f374352a, r110.content);
    L54:
        if (r111.shouldEncodeElementDefault(r210, 5) == false) goto L57;
    L55:
        boolean r106 = true;
    L60:
        if (r106 == false) goto L63;
        r111.encodeNullableSerializableElement(r210, 5, g1.f520681a, r110.usageCount);
    L63:
        if (r111.shouldEncodeElementDefault(r210, 6) == false) goto L66;
    L64:
        boolean r107 = true;
    L69:
        if (r107 == false) goto L72;
        r111.encodeNullableSerializableElement(r210, 6, AuthorInfoKmp.a.f374306a, r110.authorInfo);
    L72:
        if (r111.shouldEncodeElementDefault(r210, 7) == false) goto L75;
    L73:
        boolean r108 = true;
    L78:
        if (r108 == false) goto L81;
        r111.encodeNullableSerializableElement(r210, 7, CreationDynamicInfoKmp.a.f374316a, r110.dynamicInfo);
    L81:
        if (r111.shouldEncodeElementDefault(r210, 8) == false) goto L84;
    L82:
        boolean r109 = true;
    L87:
        if (r109 == false) goto L90;
        r111.encodeNullableSerializableElement(r210, 8, v2.f520790a, r110.creationTraceInfo);
    L90:
        if (r111.shouldEncodeElementDefault(r210, 9) == false) goto L93;
    L91:
        boolean r112 = true;
    L96:
        if (r112 == false) goto L99;
        r111.encodeNullableSerializableElement(r210, 9, w0.f520792a, r110.contentSource);
    L99:
        if (r111.shouldEncodeElementDefault(r210, 10) == false) goto L102;
    L100:
        boolean r113 = true;
    L105:
        if (r113 == false) goto L108;
        r111.encodeNullableSerializableElement(r210, 10, CreationCommunityInfoKmp.a.f374314a, r110.communityInfo);
    L108:
        if (r111.shouldEncodeElementDefault(r210, 11) == false) goto L111;
    L109:
        boolean r114 = true;
    L114:
        if (r114 == false) goto L117;
        r111.encodeNullableSerializableElement(r210, 11, i.f520705a, r110.isFavorite);
    L117:
        if (r111.shouldEncodeElementDefault(r210, 12) == false) goto L120;
    L118:
        boolean r115 = true;
    L123:
        if (r115 == false) goto L126;
        r111.encodeNullableSerializableElement(r210, 12, g1.f520681a, r110.createTime);
    L126:
        if (r111.shouldEncodeElementDefault(r210, 13) == false) goto L129;
    L127:
        boolean r116 = true;
    L132:
        if (r116 == false) goto L135;
        r111.encodeNullableSerializableElement(r210, 13, UserCreationTrackParamsKmp.a.f374364a, r110.clientTrackParams);
    L135:
        if (r111.shouldEncodeElementDefault(r210, 14) == false) goto L138;
    L136:
        boolean r117 = true;
    L141:
        if (r117 == false) goto L144;
        r111.encodeNullableSerializableElement(r210, 14, UserCreationRefContentKmp.a.f374362a, r110.refContent);
    L144:
        if (r111.shouldEncodeElementDefault(r210, 15) == false) goto L147;
    L145:
        boolean r118 = true;
    L150:
        if (r118 == false) goto L153;
        r111.encodeNullableSerializableElement(r210, 15, CreationPublishExtraKmp.a.f374326a, r110.publishExtra);
    L153:
        if (r111.shouldEncodeElementDefault(r210, 16) == false) goto L156;
    L159:
        if (r100 == false) goto L162;
        r111.encodeNullableSerializableElement(r210, 16, AwemeAnchorKmp.a.f374308a, r110.awemeAnchor);
        return;
    L162:
        return;
    L156:
        if (r110.awemeAnchor != null) goto L159;
        r100 = false;
        goto L159
    L147:
        if (r110.publishExtra != null) goto L145;
        r118 = false;
        goto L150
    L138:
        if (r110.refContent != null) goto L136;
        r117 = false;
        goto L141
    L129:
        if (Intrinsics.areEqual(r110.clientTrackParams, new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null)) == false) goto L127;
        r116 = false;
        goto L132
    L120:
        if (r110.createTime != null) goto L118;
        r115 = false;
        goto L123
    L111:
        if (r110.isFavorite != null) goto L109;
        r114 = false;
        goto L114
    L102:
        if (r110.communityInfo != null) goto L100;
        r113 = false;
        goto L105
    L93:
        if (r110.contentSource != null) goto L91;
        r112 = false;
        goto L96
    L84:
        if (r110.creationTraceInfo != null) goto L82;
        r109 = false;
        goto L87
    L75:
        if (r110.dynamicInfo != null) goto L73;
        r108 = false;
        goto L78
    L66:
        if (r110.authorInfo != null) goto L64;
        r107 = false;
        goto L69
    L57:
        if (r110.usageCount != null) goto L55;
        r106 = false;
        goto L60
    L48:
        if (r110.content != null) goto L46;
        r105 = false;
        goto L51
    L35:
        Integer r119 = r110.privateStatus;
        if (r119 == null) goto L34;
        if (r119.intValue() != 0) goto L34;
        r104 = false;
        goto L42
    L23:
        Integer r120 = r110.status;
        if (r120 == null) goto L22;
        if (r120.intValue() != 0) goto L22;
        r103 = false;
        goto L30
    L15:
        if (r110.userCreationType != 0) goto L13;
        r102 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r110.creationId, "") == false) goto L4;
        r101 = false;
        goto L9
    }

    public UserCreationKmp(String r100, int r101, Integer r102, Integer r103, UserCreationContentKmp r104, Long r105, AuthorInfoKmp r106, CreationDynamicInfoKmp r110, String r111, Integer r112, CreationCommunityInfoKmp r113, Boolean r114, Long r115, UserCreationTrackParamsKmp r116, UserCreationRefContentKmp r117, CreationPublishExtraKmp r118, AwemeAnchorKmp r119) {
        this.creationId = r100;
        this.userCreationType = r101;
        this.status = r102;
        this.privateStatus = r103;
        this.content = r104;
        this.usageCount = r105;
        this.authorInfo = r106;
        this.dynamicInfo = r110;
        this.creationTraceInfo = r111;
        this.contentSource = r112;
        this.communityInfo = r113;
        this.isFavorite = r114;
        this.createTime = r115;
        this.clientTrackParams = r116;
        this.refContent = r117;
        this.publishExtra = r118;
        this.awemeAnchor = r119;
    }

    public UserCreationKmp(int r110, String r111, int r112, Integer r113, Integer r114, UserCreationContentKmp r115, Long r210, AuthorInfoKmp r211, CreationDynamicInfoKmp r212, String r213, Integer r214, CreationCommunityInfoKmp r215, Boolean r216, Long r217, UserCreationTrackParamsKmp r218, UserCreationRefContentKmp r219, CreationPublishExtraKmp r310, AwemeAnchorKmp r311, q2 r312) {
        if ((r110 & 0) == 0) goto L5;
        b2.b(r110, 0, a.f374357b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        String r100 = "";
    L8:
        this.creationId = r100;
        if ((r110 & 2) != 0) goto L11;
        this.userCreationType = 0;
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.status = 0;
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.privateStatus = 0;
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.content = null;
    L25:
        if ((r110 & 32) != 0) goto L27;
        this.usageCount = null;
    L29:
        if ((r110 & 64) != 0) goto L31;
        this.authorInfo = null;
    L33:
        if ((r110 & 128) != 0) goto L35;
        this.dynamicInfo = null;
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.creationTraceInfo = null;
    L41:
        if ((r110 & 512) != 0) goto L43;
        this.contentSource = null;
    L45:
        if ((r110 & 1024) != 0) goto L47;
        this.communityInfo = null;
    L49:
        if ((r110 & 2048) != 0) goto L51;
        this.isFavorite = null;
    L53:
        if ((r110 & 4096) != 0) goto L55;
        this.createTime = null;
    L57:
        if ((r110 & 8192) != 0) goto L59;
        UserCreationTrackParamsKmp r101 = new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null);
    L60:
        this.clientTrackParams = r101;
        if ((r110 & 16384) != 0) goto L63;
        this.refContent = null;
    L65:
        if ((32768 & r110) != 0) goto L67;
        this.publishExtra = null;
    L69:
        if ((r110 & 65536) != 0) goto L71;
        this.awemeAnchor = null;
        return;
    L71:
        this.awemeAnchor = r311;
        return;
    L67:
        this.publishExtra = r310;
        goto L69
    L63:
        this.refContent = r219;
        goto L65
    L59:
        r101 = r218;
        goto L60
    L55:
        this.createTime = r217;
        goto L57
    L51:
        this.isFavorite = r216;
        goto L53
    L47:
        this.communityInfo = r215;
        goto L49
    L43:
        this.contentSource = r214;
        goto L45
    L39:
        this.creationTraceInfo = r213;
        goto L41
    L35:
        this.dynamicInfo = r212;
        goto L37
    L31:
        this.authorInfo = r211;
        goto L33
    L27:
        this.usageCount = r210;
        goto L29
    L23:
        this.content = r115;
        goto L25
    L19:
        this.privateStatus = r114;
        goto L21
    L15:
        this.status = r113;
        goto L17
    L11:
        this.userCreationType = r112;
        goto L13
    L7:
        r100 = r111;
        goto L8
    }

    public /* synthetic */ UserCreationKmp(String r210, int r211, Integer r212, Integer r213, UserCreationContentKmp r310, Long r311, AuthorInfoKmp r312, CreationDynamicInfoKmp r313, String r314, Integer r315, CreationCommunityInfoKmp r316, Boolean r317, Long r318, UserCreationTrackParamsKmp r319, UserCreationRefContentKmp r410, CreationPublishExtraKmp r411, AwemeAnchorKmp r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r413 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r413 & 4) == 0) goto L13;
        Integer r102 = 0;
    L15:
        if ((r413 & 8) == 0) goto L17;
        Integer r103 = 0;
    L19:
        if ((r413 & 16) == 0) goto L21;
        UserCreationContentKmp r104 = null;
    L23:
        if ((r413 & 32) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r413 & 64) == 0) goto L29;
        AuthorInfoKmp r106 = null;
    L31:
        if ((r413 & 128) == 0) goto L33;
        CreationDynamicInfoKmp r107 = null;
    L35:
        if ((r413 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r413 & 512) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r413 & 1024) == 0) goto L45;
        CreationCommunityInfoKmp r112 = null;
    L47:
        if ((r413 & 2048) == 0) goto L49;
        Boolean r113 = null;
    L51:
        if ((r413 & 4096) == 0) goto L53;
        Long r114 = null;
    L55:
        if ((r413 & 8192) == 0) goto L57;
        UserCreationTrackParamsKmp r115 = new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null);
    L59:
        if ((r413 & 16384) == 0) goto L61;
        UserCreationRefContentKmp r108 = null;
    L63:
        if ((r413 & 32768) == 0) goto L65;
        CreationPublishExtraKmp r116 = null;
    L67:
        if ((r413 & 65536) == 0) goto L69;
        AwemeAnchorKmp r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r109);
        return;
    L69:
        r109 = r412;
        goto L70
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L63
    L57:
        r115 = r319;
        goto L59
    L53:
        r114 = r318;
        goto L55
    L49:
        r113 = r317;
        goto L51
    L45:
        r112 = r316;
        goto L47
    L41:
        r111 = r315;
        goto L43
    L37:
        r110 = r314;
        goto L39
    L33:
        r107 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
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
