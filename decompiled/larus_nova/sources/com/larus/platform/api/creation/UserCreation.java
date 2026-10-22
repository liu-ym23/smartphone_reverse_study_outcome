package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.UserCreationPrivateStatus;
import com.larus.platform.api.UserCreationStatus;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u009d\u00012\u00060\u0001j\u0002`\u0002:\u0004\u009c\u0001\u009d\u0001BÑ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!BÃ\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\u0006\u0010e\u001a\u00020\u0016J\u0006\u0010f\u001a\u00020\u0016J\u0006\u0010g\u001a\u00020\u0016J\u0006\u0010h\u001a\u00020\u0016J\b\u0010i\u001a\u0004\u0018\u00010\u0004J\u0006\u0010j\u001a\u00020\u0004J\u0006\u0010k\u001a\u00020\u0004J\u0006\u0010l\u001a\u00020\u0004J\u0006\u0010m\u001a\u00020\u0004J\u0006\u0010n\u001a\u00020\u0004J\b\u0010o\u001a\u0004\u0018\u00010pJ\u0006\u0010q\u001a\u00020\u0004J\u0006\u0010r\u001a\u00020\u0004J\b\u0010s\u001a\u0004\u0018\u00010pJ\u0006\u0010t\u001a\u00020\u0016J\u0010\u0010u\u001a\u0004\u0018\u00010\u00042\u0006\u0010v\u001a\u00020\u0016J\u000b\u0010w\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010x\u001a\u00020\u0006HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010z\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010{\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010}\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010/J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010OJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010=J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003JÚ\u0001\u0010\u0088\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0003\u0010\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0016\u0010\u008b\u0001\u001a\u00020\u00162\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001HÖ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010\u008f\u0001\u001a\u00020\u0004HÖ\u0001J\u001b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0006J-\u0010\u0095\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0001¢\u0006\u0003\b\u009b\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00102\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00102\u0012\u0004\b3\u0010'\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010'\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\b;\u0010'\u001a\u0004\b<\u0010=R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010'\u001a\u0004\b@\u0010AR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010'\u001a\u0004\bC\u0010DR&\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bE\u0010'\u001a\u0004\bF\u0010)\"\u0004\bG\u0010HR \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00102\u0012\u0004\bI\u0010'\u001a\u0004\bJ\u0010/R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010'\u001a\u0004\bL\u0010MR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010P\u0012\u0004\bN\u0010'\u001a\u0004\b\u0015\u0010OR \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\bQ\u0010'\u001a\u0004\bR\u0010=R&\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bS\u0010'\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010'\u001a\u0004\bY\u0010ZR&\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b[\u0010'\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R&\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b`\u0010'\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006\u009e\u0001"}, d2 = {"Lcom/larus/platform/api/creation/UserCreation;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "creationId", "", "userCreationType", "", "status", "privateStatus", "content", "Lcom/larus/platform/api/creation/UserCreationContent;", "usageCount", "", "authorInfo", "Lcom/larus/platform/api/creation/AuthorInfo;", "dynamicInfo", "Lcom/larus/platform/api/creation/CreationDynamicInfo;", "creationTraceInfo", "contentSource", "communityInfo", "Lcom/larus/platform/api/creation/CreationCommunityInfo;", Keys.API_EVENT_KEY_IS_FAVORITE, "", "createTime", "clientTrackParams", "Lcom/larus/platform/api/creation/UserCreationTrackParams;", "refContent", "Lcom/larus/platform/api/creation/UserCreationRefContent;", "publishExtra", "Lcom/larus/platform/api/creation/CreationPublishExtra;", "awemeAnchor", "Lcom/larus/platform/api/creation/AwemeAnchor;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationContent;Ljava/lang/Long;Lcom/larus/platform/api/creation/AuthorInfo;Lcom/larus/platform/api/creation/CreationDynamicInfo;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/CreationCommunityInfo;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/platform/api/creation/UserCreationTrackParams;Lcom/larus/platform/api/creation/UserCreationRefContent;Lcom/larus/platform/api/creation/CreationPublishExtra;Lcom/larus/platform/api/creation/AwemeAnchor;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationContent;Ljava/lang/Long;Lcom/larus/platform/api/creation/AuthorInfo;Lcom/larus/platform/api/creation/CreationDynamicInfo;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/CreationCommunityInfo;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/platform/api/creation/UserCreationTrackParams;Lcom/larus/platform/api/creation/UserCreationRefContent;Lcom/larus/platform/api/creation/CreationPublishExtra;Lcom/larus/platform/api/creation/AwemeAnchor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationId$annotations", "()V", "getCreationId", "()Ljava/lang/String;", "getUserCreationType$annotations", "getUserCreationType", "()I", "getStatus$annotations", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrivateStatus$annotations", "getPrivateStatus", "setPrivateStatus", "getContent$annotations", "getContent", "()Lcom/larus/platform/api/creation/UserCreationContent;", "setContent", "(Lcom/larus/platform/api/creation/UserCreationContent;)V", "getUsageCount$annotations", "getUsageCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAuthorInfo$annotations", "getAuthorInfo", "()Lcom/larus/platform/api/creation/AuthorInfo;", "getDynamicInfo$annotations", "getDynamicInfo", "()Lcom/larus/platform/api/creation/CreationDynamicInfo;", "getCreationTraceInfo$annotations", "getCreationTraceInfo", "setCreationTraceInfo", "(Ljava/lang/String;)V", "getContentSource$annotations", "getContentSource", "getCommunityInfo$annotations", "getCommunityInfo", "()Lcom/larus/platform/api/creation/CreationCommunityInfo;", "isFavorite$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreateTime$annotations", "getCreateTime", "getClientTrackParams$annotations", "getClientTrackParams", "()Lcom/larus/platform/api/creation/UserCreationTrackParams;", "setClientTrackParams", "(Lcom/larus/platform/api/creation/UserCreationTrackParams;)V", "getRefContent$annotations", "getRefContent", "()Lcom/larus/platform/api/creation/UserCreationRefContent;", "getPublishExtra$annotations", "getPublishExtra", "()Lcom/larus/platform/api/creation/CreationPublishExtra;", "setPublishExtra", "(Lcom/larus/platform/api/creation/CreationPublishExtra;)V", "getAwemeAnchor$annotations", "getAwemeAnchor", "()Lcom/larus/platform/api/creation/AwemeAnchor;", "setAwemeAnchor", "(Lcom/larus/platform/api/creation/AwemeAnchor;)V", "isPublicReference", "isHasCaption", "checkCustomPositionValid", "hasMultiRefImage", "getRefImageUrl", "getPrompt", "getImageUrl", "getThumbImageUrl", "getThumbRawImageUrl", "getOriginImageUrl", "getOriginImage", "Lcom/larus/platform/api/Image;", "getPreviewImageUrl", "getDisplayContent", "getPreviewImageInfo", "canShowQuickMenu", "getTagType", "hasAvatar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationContent;Ljava/lang/Long;Lcom/larus/platform/api/creation/AuthorInfo;Lcom/larus/platform/api/creation/CreationDynamicInfo;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/CreationCommunityInfo;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/larus/platform/api/creation/UserCreationTrackParams;Lcom/larus/platform/api/creation/UserCreationRefContent;Lcom/larus/platform/api/creation/CreationPublishExtra;Lcom/larus/platform/api/creation/AwemeAnchor;)Lcom/larus/platform/api/creation/UserCreation;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UserCreation implements Parcelable {
    public static final Parcelable.Creator<UserCreation> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f364987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f364988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f364989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f364990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UserCreationContent f364991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f364992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AuthorInfo f364993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CreationDynamicInfo f364994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f364995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f364996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CreationCommunityInfo f364997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f364998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f364999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UserCreationTrackParams f365000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final UserCreationRefContent f365001o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CreationPublishExtra f365002p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AwemeAnchor f365003q;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreation> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f365004a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f365005b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f365005b;
        }

        static {
            a r100 = new a();
            f365004a = r100;
            g2 r101 = new g2("com.larus.platform.api.creation.UserCreation", r100, 17);
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
            f365005b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            g1 r102 = g1.f520681a;
            return new d[]{kuc.a.d(r100), r101, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(UserCreationContent.a.f365012a), kuc.a.d(r102), kuc.a.d(AuthorInfo.a.f364899a), kuc.a.d(CreationDynamicInfo.a.f364916a), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(CreationCommunityInfo.a.f364909a), kuc.a.d(i.f520705a), kuc.a.d(r102), kuc.a.d(UserCreationTrackParams.a.f365047a), kuc.a.d(UserCreationRefContent.a.f365038a), kuc.a.d(CreationPublishExtra.a.f364926a), kuc.a.d(AwemeAnchor.a.f364903a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f365005b;
            muc.c r101 = r310.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            int r104 = r101.decodeIntElement(r100, 1);
            w0 r105 = w0.f520792a;
            Integer r110 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            Integer r111 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            UserCreationContent r106 = (UserCreationContent) r101.decodeNullableSerializableElement(r100, 4, UserCreationContent.a.f365012a, null);
            g1 r112 = g1.f520681a;
            Long r113 = (Long) r101.decodeNullableSerializableElement(r100, 5, r112, null);
            AuthorInfo r107 = (AuthorInfo) r101.decodeNullableSerializableElement(r100, 6, AuthorInfo.a.f364899a, null);
            CreationDynamicInfo r114 = (CreationDynamicInfo) r101.decodeNullableSerializableElement(r100, 7, CreationDynamicInfo.a.f364916a, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 8, r102, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            CreationCommunityInfo r115 = (CreationCommunityInfo) r101.decodeNullableSerializableElement(r100, 10, CreationCommunityInfo.a.f364909a, null);
            Boolean r116 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, i.f520705a, null);
            Long r117 = (Long) r101.decodeNullableSerializableElement(r100, 12, r112, null);
            Boolean r118 = r116;
            UserCreationTrackParams r119 = (UserCreationTrackParams) r101.decodeNullableSerializableElement(r100, 13, UserCreationTrackParams.a.f365047a, null);
            UserCreationRefContent r120 = (UserCreationRefContent) r101.decodeNullableSerializableElement(r100, 14, UserCreationRefContent.a.f365038a, null);
            CreationPublishExtra r210 = (CreationPublishExtra) r101.decodeNullableSerializableElement(r100, 15, CreationPublishExtra.a.f364926a, null);
            AwemeAnchor r211 = (AwemeAnchor) r101.decodeNullableSerializableElement(r100, 16, AwemeAnchor.a.f364903a, null);
            AuthorInfo r121 = r107;
            Long r212 = r117;
            Integer r122 = r110;
            UserCreationRefContent r213 = r120;
            Integer r123 = r109;
            int r124 = r104;
            CreationDynamicInfo r125 = r114;
            Long r126 = r113;
            UserCreationContent r127 = r106;
            String r128 = r103;
            String r129 = r108;
            UserCreationTrackParams r214 = r119;
            CreationCommunityInfo r130 = r115;
            int r131 = 131071;
        L43:
            r101.endStructure(r100);
            return new UserCreation(r131, r128, r124, r122, r111, r127, r126, r121, r125, r129, r123, r130, r118, r212, r214, r213, r210, r211);
        L5:
            AuthorInfo r132 = null;
            Integer r133 = null;
            Long r134 = null;
            UserCreationRefContent r135 = null;
            UserCreationContent r136 = null;
            CreationDynamicInfo r137 = null;
            Long r138 = null;
            AwemeAnchor r139 = null;
            CreationCommunityInfo r140 = null;
            Boolean r141 = null;
            CreationPublishExtra r142 = null;
            UserCreationTrackParams r143 = null;
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
            AwemeAnchor r314 = (AwemeAnchor) r101.decodeNullableSerializableElement(r100, 16, AwemeAnchor.a.f364903a, r139);
        L17:
            r133 = r133;
            int r147 = r146;
            Integer r218 = r217;
            String r219 = r311;
            r139 = r314;
        L37:
            AuthorInfo r220 = r132;
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
            r142 = (CreationPublishExtra) r101.decodeNullableSerializableElement(r100, 15, CreationPublishExtra.a.f364926a, r142);
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
            r135 = (UserCreationRefContent) r101.decodeNullableSerializableElement(r100, 14, UserCreationRefContent.a.f365038a, r135);
            r146 = r150 | 16384;
            goto L17
        L14:
            int r151 = r312;
            r314 = r139;
            r143 = (UserCreationTrackParams) r101.decodeNullableSerializableElement(r100, 13, UserCreationTrackParams.a.f365047a, r143);
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
            r140 = (CreationCommunityInfo) r101.decodeNullableSerializableElement(r100, 10, CreationCommunityInfo.a.f364909a, r140);
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
            r137 = (CreationDynamicInfo) r101.decodeNullableSerializableElement(r100, 7, CreationDynamicInfo.a.f364916a, r137);
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
            r132 = (AuthorInfo) r101.decodeNullableSerializableElement(r100, 6, AuthorInfo.a.f364899a, r132);
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
            r136 = (UserCreationContent) r101.decodeNullableSerializableElement(r100, 4, UserCreationContent.a.f365012a, r136);
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
            AwemeAnchor r318 = r139;
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            UserCreation r111 = (UserCreation) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f365005b;
            muc.d r102 = r100.beginStructure(r101);
            b r103 = UserCreation.Companion;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeNullableSerializableElement(r101, 0, v2.f520790a, r111.f364987a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeIntElement(r101, 1, r111.f364988b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == true) goto L28;
            Integer r107 = r111.f364989c;
            if (r107 == null) goto L28;
            if (r107.intValue() != 0) goto L28;
            boolean r108 = false;
        L30:
            if (r108 == false) goto L33;
            r102.encodeNullableSerializableElement(r101, 2, w0.f520792a, r111.f364989c);
        L33:
            if (r102.shouldEncodeElementDefault(r101, 3) == true) goto L40;
            Integer r109 = r111.f364990d;
            if (r109 == null) goto L40;
            if (r109.intValue() != 0) goto L40;
            boolean r112 = false;
        L42:
            if (r112 == false) goto L45;
            r102.encodeNullableSerializableElement(r101, 3, w0.f520792a, r111.f364990d);
        L45:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L48;
        L49:
            boolean r113 = true;
        L51:
            if (r113 == false) goto L54;
            r102.encodeNullableSerializableElement(r101, 4, UserCreationContent.a.f365012a, r111.f364991e);
        L54:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L57;
        L58:
            boolean r114 = true;
        L60:
            if (r114 == false) goto L63;
            r102.encodeNullableSerializableElement(r101, 5, g1.f520681a, r111.f364992f);
        L63:
            if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L66;
        L67:
            boolean r115 = true;
        L69:
            if (r115 == false) goto L72;
            r102.encodeNullableSerializableElement(r101, 6, AuthorInfo.a.f364899a, r111.f364993g);
        L72:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L75;
        L76:
            boolean r116 = true;
        L78:
            if (r116 == false) goto L81;
            r102.encodeNullableSerializableElement(r101, 7, CreationDynamicInfo.a.f364916a, r111.f364994h);
        L81:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L84;
        L85:
            boolean r117 = true;
        L87:
            if (r117 == false) goto L90;
            r102.encodeNullableSerializableElement(r101, 8, v2.f520790a, r111.f364995i);
        L90:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L93;
        L94:
            boolean r118 = true;
        L96:
            if (r118 == false) goto L99;
            r102.encodeNullableSerializableElement(r101, 9, w0.f520792a, r111.f364996j);
        L99:
            if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L102;
        L103:
            boolean r119 = true;
        L105:
            if (r119 == false) goto L108;
            r102.encodeNullableSerializableElement(r101, 10, CreationCommunityInfo.a.f364909a, r111.f364997k);
        L108:
            if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L111;
        L112:
            boolean r120 = true;
        L114:
            if (r120 == false) goto L117;
            r102.encodeNullableSerializableElement(r101, 11, i.f520705a, r111.f364998l);
        L117:
            if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L120;
        L121:
            boolean r121 = true;
        L123:
            if (r121 == false) goto L126;
            r102.encodeNullableSerializableElement(r101, 12, g1.f520681a, r111.f364999m);
        L126:
            if (r102.shouldEncodeElementDefault(r101, 13) == true) goto L130;
            UserCreationTrackParams r122 = r111.f365000n;
            String r123 = null;
            Object[] r124 = 0 == true ? 1 : 0;
            if (Intrinsics.areEqual(r122, new UserCreationTrackParams(r123, r124, 127)) == false) goto L130;
            boolean r125 = false;
        L132:
            if (r125 == false) goto L135;
            r102.encodeNullableSerializableElement(r101, 13, UserCreationTrackParams.a.f365047a, r111.f365000n);
        L135:
            if (r102.shouldEncodeElementDefault(r101, 14) == false) goto L138;
        L139:
            boolean r126 = true;
        L141:
            if (r126 == false) goto L144;
            r102.encodeNullableSerializableElement(r101, 14, UserCreationRefContent.a.f365038a, r111.f365001o);
        L144:
            if (r102.shouldEncodeElementDefault(r101, 15) == false) goto L147;
        L148:
            boolean r127 = true;
        L150:
            if (r127 == false) goto L153;
            r102.encodeNullableSerializableElement(r101, 15, CreationPublishExtra.a.f364926a, r111.f365002p);
        L153:
            if (r102.shouldEncodeElementDefault(r101, 16) == false) goto L156;
        L157:
            r104 = true;
        L158:
            if (r104 == false) goto L160;
            r102.encodeNullableSerializableElement(r101, 16, AwemeAnchor.a.f364903a, r111.f365003q);
        L160:
            r102.endStructure(r101);
            return;
        L156:
            if (r111.f365003q == null) goto L158;
        L147:
            if (r111.f365002p != null) goto L148;
            r127 = false;
            goto L150
        L138:
            if (r111.f365001o != null) goto L139;
            r126 = false;
        L130:
            r125 = true;
            goto L132
        L120:
            if (r111.f364999m != null) goto L121;
            r121 = false;
            goto L123
        L111:
            if (r111.f364998l != null) goto L112;
            r120 = false;
            goto L114
        L102:
            if (r111.f364997k != null) goto L103;
            r119 = false;
            goto L105
        L93:
            if (r111.f364996j != null) goto L94;
            r118 = false;
            goto L96
        L84:
            if (r111.f364995i != null) goto L85;
            r117 = false;
            goto L87
        L75:
            if (r111.f364994h != null) goto L76;
            r116 = false;
            goto L78
        L66:
            if (r111.f364993g != null) goto L67;
            r115 = false;
            goto L69
        L57:
            if (r111.f364992f != null) goto L58;
            r114 = false;
            goto L60
        L48:
            if (r111.f364991e != null) goto L49;
            r113 = false;
        L40:
            r112 = true;
        L28:
            r108 = true;
            goto L30
        L15:
            if (r111.f364988b != 0) goto L16;
            r106 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r111.f364987a, "") == false) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreation> serializer() {
            return a.f365004a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreation> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreation createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            int r101 = r210.readInt();
            AwemeAnchor r102 = null;
            if (r210.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            if (r210.readInt() != 0) goto L9;
            Integer r104 = null;
        L11:
            if (r210.readInt() != 0) goto L13;
            UserCreationContent r105 = null;
        L14:
            UserCreationContent r106 = r105;
            if (r210.readInt() != 0) goto L17;
            Long r107 = null;
        L19:
            if (r210.readInt() != 0) goto L21;
            AuthorInfo r108 = null;
        L22:
            AuthorInfo r110 = r108;
            if (r210.readInt() != 0) goto L25;
            CreationDynamicInfo r109 = null;
        L26:
            CreationDynamicInfo r111 = r109;
            String r112 = r210.readString();
            if (r210.readInt() != 0) goto L29;
            Integer r113 = null;
        L31:
            if (r210.readInt() != 0) goto L33;
            CreationCommunityInfo r114 = null;
        L34:
            CreationCommunityInfo r115 = r114;
            if (r210.readInt() != 0) goto L38;
            Boolean r116 = null;
        L43:
            if (r210.readInt() != 0) goto L45;
            Long r117 = null;
        L47:
            if (r210.readInt() != 0) goto L49;
            UserCreationTrackParams r118 = null;
        L50:
            UserCreationTrackParams r119 = r118;
            if (r210.readInt() != 0) goto L53;
            UserCreationRefContent r120 = null;
        L54:
            UserCreationRefContent r121 = r120;
            if (r210.readInt() != 0) goto L57;
            CreationPublishExtra r122 = null;
        L58:
            CreationPublishExtra r211 = r122;
            if (r210.readInt() == 0) goto L63;
            r102 = AwemeAnchor.CREATOR.createFromParcel(r210);
        L63:
            return new UserCreation(r100, r101, r103, r104, r106, r107, r110, r111, r112, r113, r115, r116, r117, r119, r121, r211, r102);
        L57:
            r122 = CreationPublishExtra.CREATOR.createFromParcel(r210);
            goto L58
        L53:
            r120 = UserCreationRefContent.CREATOR.createFromParcel(r210);
            goto L54
        L49:
            r118 = UserCreationTrackParams.CREATOR.createFromParcel(r210);
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
            r114 = CreationCommunityInfo.CREATOR.createFromParcel(r210);
            goto L34
        L29:
            r113 = Integer.valueOf(r210.readInt());
            goto L31
        L25:
            r109 = CreationDynamicInfo.CREATOR.createFromParcel(r210);
            goto L26
        L21:
            r108 = AuthorInfo.CREATOR.createFromParcel(r210);
            goto L22
        L17:
            r107 = Long.valueOf(r210.readLong());
            goto L19
        L13:
            r105 = UserCreationContent.CREATOR.createFromParcel(r210);
            goto L14
        L9:
            r104 = Integer.valueOf(r210.readInt());
            goto L11
        L5:
            r103 = Integer.valueOf(r210.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreation[] newArray(int r100) {
            return new UserCreation[r100];
        }
    }

    public UserCreation() {
        this(null, 0, null, null, 131071);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCreation) == true) goto L8;
        return false;
    L8:
        UserCreation r101 = (UserCreation) r100;
        if (Intrinsics.areEqual(this.f364987a, r101.f364987a) == true) goto L12;
        return false;
    L12:
        if (this.f364988b == r101.f364988b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f364989c, r101.f364989c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f364990d, r101.f364990d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f364991e, r101.f364991e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f364992f, r101.f364992f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f364993g, r101.f364993g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f364994h, r101.f364994h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f364995i, r101.f364995i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f364996j, r101.f364996j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f364997k, r101.f364997k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f364998l, r101.f364998l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f364999m, r101.f364999m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f365000n, r101.f365000n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f365001o, r101.f365001o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f365002p, r101.f365002p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f365003q, r101.f365003q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f364987a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f364988b) * 31;
        Integer r104 = this.f364989c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f364990d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UserCreationContent r110 = this.f364991e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f364992f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        AuthorInfo r116 = this.f364993g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CreationDynamicInfo r119 = this.f364994h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f364995i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f364996j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        CreationCommunityInfo r128 = this.f364997k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.f364998l;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Long r134 = this.f364999m;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        UserCreationTrackParams r137 = this.f365000n;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        UserCreationRefContent r140 = this.f365001o;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        CreationPublishExtra r143 = this.f365002p;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        AwemeAnchor r146 = this.f365003q;
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

    public final String toString() {
        return "UserCreation(creationId=" + this.f364987a + ", userCreationType=" + this.f364988b + ", status=" + this.f364989c + ", privateStatus=" + this.f364990d + ", content=" + this.f364991e + ", usageCount=" + this.f364992f + ", authorInfo=" + this.f364993g + ", dynamicInfo=" + this.f364994h + ", creationTraceInfo=" + this.f364995i + ", contentSource=" + this.f364996j + ", communityInfo=" + this.f364997k + ", isFavorite=" + this.f364998l + ", createTime=" + this.f364999m + ", clientTrackParams=" + this.f365000n + ", refContent=" + this.f365001o + ", publishExtra=" + this.f365002p + ", awemeAnchor=" + this.f365003q + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f364987a);
        r100.writeInt(this.f364988b);
        Integer r102 = this.f364989c;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.f364990d;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        UserCreationContent r104 = this.f364991e;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Long r105 = this.f364992f;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        AuthorInfo r106 = this.f364993g;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        CreationDynamicInfo r107 = this.f364994h;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        r100.writeString(this.f364995i);
        Integer r108 = this.f364996j;
        if (r108 != null) goto L29;
        r100.writeInt(0);
    L30:
        CreationCommunityInfo r109 = this.f364997k;
        if (r109 != null) goto L33;
        r100.writeInt(0);
    L34:
        Boolean r110 = this.f364998l;
        if (r110 != null) goto L37;
        r100.writeInt(0);
    L38:
        Long r111 = this.f364999m;
        if (r111 != null) goto L41;
        r100.writeInt(0);
    L42:
        UserCreationTrackParams r112 = this.f365000n;
        if (r112 != null) goto L45;
        r100.writeInt(0);
    L46:
        UserCreationRefContent r113 = this.f365001o;
        if (r113 != null) goto L49;
        r100.writeInt(0);
    L50:
        CreationPublishExtra r114 = this.f365002p;
        if (r114 != null) goto L53;
        r100.writeInt(0);
    L54:
        AwemeAnchor r115 = this.f365003q;
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
        CREATOR = new c();
    }

    public final boolean D() {
        CreationPublishExtra r100 = this.f365002p;
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.f364924b, Boolean.TRUE);
    }

    public final boolean a() {
        CreationDynamicInfo r100 = this.f364994h;
        if (r100 == null) goto L7;
        TplInfo r101 = r100.f364915e;
        if (r101 == null) goto L7;
        String r102 = r101.f364972a;
    L9:
        return Intrinsics.areEqual(r102, TplType.MENU);
    L7:
        r102 = null;
        goto L9
    }

    public final boolean b() {
        CreationDynamicInfo r100 = this.f364994h;
        if (r100 == null) goto L28;
        Integer r101 = r100.f364912b;
        if (r101 == null) goto L28;
        if (r100.f364911a == null) goto L28;
        if (r101 == null) goto L10;
        int r102 = r101.intValue();
    L11:
        if (r102 < 0) goto L28;
        Integer r103 = r100.f364911a;
        if (r103 == null) goto L15;
        int r104 = r103.intValue();
    L16:
        if (r104 < 0) goto L28;
        Integer r105 = r100.f364912b;
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
    L21:
        Integer r107 = r100.f364911a;
        if (r107 == null) goto L24;
        int r108 = r107.intValue();
    L25:
        if (r106 < r108) goto L28;
        return true;
    L24:
        r108 = 0;
        goto L25
    L20:
        r106 = 0;
        goto L21
    L15:
        r104 = 0;
        goto L16
    L10:
        r102 = 0;
    L28:
        return false;
    }

    public final String d() {
        String r100 = null;
        switch(this.f364988b) {
            case 1: goto L29;
            case 2: goto L22;
            case 3: goto L4;
            case 4: goto L14;
            case 5: goto L22;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        UserCreationContent r101 = this.f364991e;
        if (r101 != null) goto L37;
        return "";
    L37:
        UserCreationUserAvatar r102 = r101.f365008c;
        if (r102 == null) goto L48;
        String r103 = r102.f365051b;
        if (r103 != null) goto L47;
        return "";
    L47:
        return r103;
    L48:
        return "";
    L7:
        UserCreationContent r104 = this.f364991e;
        if (r104 == null) goto L12;
        VideoUserContent r105 = r104.f365010e;
        if (r105 == null) goto L12;
        r100 = r105.f365081c;
    L12:
        if (r100 != null) goto L42;
        return "";
    L42:
        return r100;
    L14:
        UserCreationContent r106 = this.f364991e;
        if (r106 == null) goto L19;
        AiBeautifyUserContent r107 = r106.f365009d;
        if (r107 == null) goto L19;
        r100 = r107.f364884c;
    L19:
        if (r100 != null) goto L42;
        return "";
    L22:
        UserCreationContent r108 = this.f364991e;
        if (r108 == null) goto L43;
        UserCreationImage r109 = r108.f365006a;
        if (r109 == null) goto L44;
        r103 = r109.f365015b;
        if (r103 != null) goto L47;
        return "";
    L44:
        return "";
    L43:
        return "";
    L29:
        UserCreationContent r110 = this.f364991e;
        if (r110 == null) goto L45;
        UserCreationMusic r111 = r110.f365007b;
        if (r111 == null) goto L46;
        r103 = r111.f365024c;
        if (r103 != null) goto L47;
        return "";
    L46:
        return "";
    L45:
        return "";
    }

    public final String e() {
        switch(this.f364988b) {
            case 1: goto L51;
            case 2: goto L38;
            case 3: goto L27;
            case 4: goto L16;
            case 5: goto L38;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            default: goto L51;
        };
    L5:
        UserCreationContent r100 = this.f364991e;
        if (r100 == null) goto L52;
        VideoUserContent r101 = r100.f365010e;
        if (r101 == null) goto L53;
        ImageInfo r102 = r101.f365080b;
        if (r102 == null) goto L54;
        Image r103 = r102.f364800c;
        if (r103 == null) goto L55;
        String r104 = r103.f364791a;
        if (r104 != null) goto L50;
        return "";
    L50:
        return r104;
    L55:
        return "";
    L54:
        return "";
    L53:
        return "";
    L52:
        return "";
    L16:
        UserCreationContent r105 = this.f364991e;
        if (r105 == null) goto L56;
        AiBeautifyUserContent r106 = r105.f365009d;
        if (r106 == null) goto L57;
        ImageInfo r107 = r106.f364882a;
        if (r107 == null) goto L58;
        Image r108 = r107.f364800c;
        if (r108 == null) goto L59;
        r104 = r108.f364791a;
        if (r104 != null) goto L50;
        return "";
    L59:
        return "";
    L58:
        return "";
    L57:
        return "";
    L56:
        return "";
    L27:
        UserCreationContent r109 = this.f364991e;
        if (r109 == null) goto L60;
        UserCreationUserAvatar r110 = r109.f365008c;
        if (r110 == null) goto L61;
        ImageInfo r111 = r110.f365050a;
        if (r111 == null) goto L62;
        Image r112 = r111.f364800c;
        if (r112 == null) goto L63;
        r104 = r112.f364791a;
        if (r104 != null) goto L50;
        return "";
    L63:
        return "";
    L62:
        return "";
    L61:
        return "";
    L60:
        return "";
    L38:
        UserCreationContent r113 = this.f364991e;
        if (r113 == null) goto L64;
        UserCreationImage r114 = r113.f365006a;
        if (r114 == null) goto L65;
        ImageInfo r115 = r114.f365014a;
        if (r115 == null) goto L66;
        Image r116 = r115.f364800c;
        if (r116 == null) goto L67;
        r104 = r116.f364791a;
        if (r104 != null) goto L50;
        return "";
    L67:
        return "";
    L66:
        return "";
    L65:
        return "";
    L64:
        return "";
    L51:
        return "";
    }

    public final Image g() {
        int r100 = this.f364988b;
        if (r100 != 2) goto L5;
    L25:
        UserCreationContent r101 = this.f364991e;
        if (r101 == null) goto L41;
        UserCreationImage r102 = r101.f365006a;
        if (r102 == null) goto L42;
        ImageInfo r103 = r102.f365014a;
        if (r103 != null) goto L32;
        return null;
    L32:
        return r103.f364798a;
    L42:
        return null;
    L41:
        return null;
    L5:
        if (r100 != 3) goto L7;
        UserCreationContent r104 = this.f364991e;
        if (r104 == null) goto L37;
        UserCreationUserAvatar r105 = r104.f365008c;
        if (r105 == null) goto L38;
        ImageInfo r106 = r105.f365050a;
        if (r106 != null) goto L40;
        return null;
    L40:
        return r106.f364798a;
    L38:
        return null;
    L37:
        return null;
    L7:
        if (r100 != 4) goto L9;
        UserCreationContent r107 = this.f364991e;
        if (r107 == null) goto L33;
        AiBeautifyUserContent r108 = r107.f365009d;
        if (r108 == null) goto L34;
        ImageInfo r109 = r108.f364882a;
        if (r109 != null) goto L36;
        return null;
    L36:
        return r109.f364798a;
    L34:
        return null;
    L33:
        return null;
    L9:
        if (r100 == 5) goto L25;
        return null;
    }

    public final String h() {
        int r100 = this.f364988b;
        if (r100 != 2) goto L5;
    L33:
        UserCreationContent r101 = this.f364991e;
        if (r101 == null) goto L54;
        UserCreationImage r102 = r101.f365006a;
        if (r102 == null) goto L55;
        ImageInfo r103 = r102.f365014a;
        if (r103 == null) goto L56;
        Image r104 = r103.f364798a;
        if (r104 == null) goto L57;
        String r105 = r104.f364791a;
        if (r105 != null) goto L45;
        return "";
    L45:
        return r105;
    L57:
        return "";
    L56:
        return "";
    L55:
        return "";
    L54:
        return "";
    L5:
        if (r100 != 3) goto L7;
        UserCreationContent r106 = this.f364991e;
        if (r106 == null) goto L50;
        UserCreationUserAvatar r107 = r106.f365008c;
        if (r107 == null) goto L51;
        ImageInfo r108 = r107.f365050a;
        if (r108 == null) goto L52;
        Image r109 = r108.f364798a;
        if (r109 == null) goto L53;
        r105 = r109.f364791a;
        if (r105 != null) goto L45;
        return "";
    L53:
        return "";
    L52:
        return "";
    L51:
        return "";
    L50:
        return "";
    L7:
        if (r100 != 4) goto L9;
        UserCreationContent r110 = this.f364991e;
        if (r110 == null) goto L46;
        AiBeautifyUserContent r111 = r110.f365009d;
        if (r111 == null) goto L47;
        ImageInfo r112 = r111.f364882a;
        if (r112 == null) goto L48;
        Image r113 = r112.f364798a;
        if (r113 == null) goto L49;
        r105 = r113.f364791a;
        if (r105 != null) goto L45;
        return "";
    L49:
        return "";
    L48:
        return "";
    L47:
        return "";
    L46:
        return "";
    L9:
        if (r100 == 5) goto L33;
        return "";
    }

    public final Image i() {
        int r100 = this.f364988b;
        if (r100 != 2) goto L5;
    L22:
        UserCreationContent r101 = this.f364991e;
        if (r101 == null) goto L38;
        UserCreationImage r102 = r101.f365006a;
        if (r102 == null) goto L39;
        ImageInfo r103 = r102.f365014a;
        if (r103 != null) goto L29;
        return null;
    L29:
        return r103.f364800c;
    L39:
        return null;
    L38:
        return null;
    L5:
        if (r100 != 4) goto L7;
        UserCreationContent r104 = this.f364991e;
        if (r104 == null) goto L34;
        AiBeautifyUserContent r105 = r104.f365009d;
        if (r105 == null) goto L35;
        ImageInfo r106 = r105.f364882a;
        if (r106 != null) goto L37;
        return null;
    L37:
        return r106.f364800c;
    L35:
        return null;
    L34:
        return null;
    L7:
        if (r100 == 5) goto L22;
        UserCreationContent r107 = this.f364991e;
        if (r107 == null) goto L30;
        UserCreationUserAvatar r108 = r107.f365008c;
        if (r108 == null) goto L31;
        ImageInfo r109 = r108.f365050a;
        if (r109 != null) goto L33;
        return null;
    L33:
        return r109.f364800c;
    L31:
        return null;
    L30:
        return null;
    }

    public final String j() {
        int r100 = this.f364988b;
        boolean r101 = false;
        String r102 = null;
        if (r100 != 2) goto L5;
    L83:
        UserCreationContent r103 = this.f364991e;
        if (r103 == null) goto L92;
        UserCreationImage r104 = r103.f365006a;
        if (r104 == null) goto L92;
        ImageInfo r105 = r104.f365014a;
        if (r105 == null) goto L92;
        Image r106 = r105.f364800c;
        if (r106 == null) goto L92;
        r102 = r106.f364791a;
    L92:
        if (r102 != null) goto L94;
    L95:
        r101 = true;
    L96:
        if (r101 == true) goto L108;
        UserCreationContent r107 = this.f364991e;
        if (r107 == null) goto L137;
        UserCreationImage r108 = r107.f365006a;
        if (r108 == null) goto L138;
        ImageInfo r109 = r108.f365014a;
        if (r109 == null) goto L139;
        Image r110 = r109.f364800c;
        if (r110 == null) goto L140;
        String r111 = r110.f364791a;
        if (r111 != null) goto L120;
        return "";
    L120:
        return r111;
    L140:
        return "";
    L139:
        return "";
    L138:
        return "";
    L137:
        return "";
    L108:
        UserCreationContent r112 = this.f364991e;
        if (r112 == null) goto L141;
        UserCreationImage r113 = r112.f365006a;
        if (r113 == null) goto L142;
        ImageInfo r114 = r113.f365014a;
        if (r114 == null) goto L143;
        Image r115 = r114.f364798a;
        if (r115 == null) goto L144;
        r111 = r115.f364791a;
        if (r111 != null) goto L120;
        return "";
    L144:
        return "";
    L143:
        return "";
    L142:
        return "";
    L141:
        return "";
    L94:
        if (r102.length() != 0) goto L96;
    L5:
        if (r100 != 3) goto L7;
        UserCreationContent r116 = this.f364991e;
        if (r116 == null) goto L56;
        UserCreationUserAvatar r117 = r116.f365008c;
        if (r117 == null) goto L56;
        ImageInfo r118 = r117.f365050a;
        if (r118 == null) goto L56;
        Image r119 = r118.f364800c;
        if (r119 == null) goto L56;
        r102 = r119.f364791a;
    L56:
        if (r102 != null) goto L58;
    L59:
        r101 = true;
    L60:
        if (r101 == true) goto L72;
        UserCreationContent r120 = this.f364991e;
        if (r120 == null) goto L129;
        UserCreationUserAvatar r121 = r120.f365008c;
        if (r121 == null) goto L130;
        ImageInfo r122 = r121.f365050a;
        if (r122 == null) goto L131;
        Image r123 = r122.f364800c;
        if (r123 == null) goto L132;
        r111 = r123.f364791a;
        if (r111 != null) goto L120;
        return "";
    L132:
        return "";
    L131:
        return "";
    L130:
        return "";
    L129:
        return "";
    L72:
        UserCreationContent r124 = this.f364991e;
        if (r124 == null) goto L133;
        UserCreationUserAvatar r125 = r124.f365008c;
        if (r125 == null) goto L134;
        ImageInfo r126 = r125.f365050a;
        if (r126 == null) goto L135;
        Image r127 = r126.f364798a;
        if (r127 == null) goto L136;
        r111 = r127.f364791a;
        if (r111 != null) goto L120;
        return "";
    L136:
        return "";
    L135:
        return "";
    L134:
        return "";
    L133:
        return "";
    L58:
        if (r102.length() != 0) goto L60;
    L7:
        if (r100 != 4) goto L9;
        UserCreationContent r128 = this.f364991e;
        if (r128 == null) goto L20;
        AiBeautifyUserContent r129 = r128.f365009d;
        if (r129 == null) goto L20;
        ImageInfo r130 = r129.f364882a;
        if (r130 == null) goto L20;
        Image r131 = r130.f364800c;
        if (r131 == null) goto L20;
        r102 = r131.f364791a;
    L20:
        if (r102 != null) goto L22;
    L23:
        r101 = true;
    L24:
        if (r101 == true) goto L36;
        UserCreationContent r132 = this.f364991e;
        if (r132 == null) goto L121;
        AiBeautifyUserContent r133 = r132.f365009d;
        if (r133 == null) goto L122;
        ImageInfo r134 = r133.f364882a;
        if (r134 == null) goto L123;
        Image r135 = r134.f364800c;
        if (r135 == null) goto L124;
        r111 = r135.f364791a;
        if (r111 != null) goto L120;
        return "";
    L124:
        return "";
    L123:
        return "";
    L122:
        return "";
    L121:
        return "";
    L36:
        UserCreationContent r136 = this.f364991e;
        if (r136 == null) goto L125;
        AiBeautifyUserContent r137 = r136.f365009d;
        if (r137 == null) goto L126;
        ImageInfo r138 = r137.f364882a;
        if (r138 == null) goto L127;
        Image r139 = r138.f364798a;
        if (r139 == null) goto L128;
        r111 = r139.f364791a;
        if (r111 != null) goto L120;
        return "";
    L128:
        return "";
    L127:
        return "";
    L126:
        return "";
    L125:
        return "";
    L22:
        if (r102.length() != 0) goto L24;
    L9:
        if (r100 == 5) goto L83;
        return "";
    }

    public final String k() {
        switch(this.f364988b) {
            case 1: goto L35;
            case 2: goto L26;
            case 3: goto L19;
            case 4: goto L12;
            case 5: goto L26;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            default: goto L35;
        };
    L5:
        UserCreationContent r100 = this.f364991e;
        if (r100 == null) goto L36;
        VideoUserContent r101 = r100.f365010e;
        if (r101 == null) goto L37;
        String r102 = r101.f365082d;
        if (r102 != null) goto L34;
        return "";
    L34:
        return r102;
    L37:
        return "";
    L36:
        return "";
    L12:
        UserCreationContent r103 = this.f364991e;
        if (r103 == null) goto L38;
        AiBeautifyUserContent r104 = r103.f365009d;
        if (r104 == null) goto L39;
        r102 = r104.f364885d;
        if (r102 != null) goto L34;
        return "";
    L39:
        return "";
    L38:
        return "";
    L19:
        UserCreationContent r105 = this.f364991e;
        if (r105 == null) goto L40;
        UserCreationUserAvatar r106 = r105.f365008c;
        if (r106 == null) goto L41;
        r102 = r106.f365052c;
        if (r102 != null) goto L34;
        return "";
    L41:
        return "";
    L40:
        return "";
    L26:
        UserCreationContent r107 = this.f364991e;
        if (r107 == null) goto L42;
        UserCreationImage r108 = r107.f365006a;
        if (r108 == null) goto L43;
        r102 = r108.f365016c;
        if (r102 != null) goto L34;
        return "";
    L43:
        return "";
    L42:
        return "";
    L35:
        return "";
    }

    public final String o() {
        UserCreationRefContent r100 = this.f365001o;
        if (r100 == null) goto L10;
        List<ImageInfo> r101 = r100.a();
        if (r101 == null) goto L10;
        ImageInfo r102 = (ImageInfo) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L10;
        Image r103 = r102.f364800c;
        if (r103 == null) goto L10;
    L18:
        if (r103 != null) goto L20;
        return null;
    L20:
        return r103.f364791a;
    L10:
        UserCreationRefContent r104 = this.f365001o;
        if (r104 == null) goto L17;
        List<ImageInfo> r105 = r104.a();
        if (r105 == null) goto L17;
        ImageInfo r106 = (ImageInfo) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L17;
        r103 = r106.f364798a;
    L17:
        r103 = null;
        goto L18
    }

    public final String r() {
        int r100 = this.f364988b;
        if (r100 != 2) goto L5;
    L30:
        UserCreationContent r101 = this.f364991e;
        if (r101 == null) goto L51;
        UserCreationImage r102 = r101.f365006a;
        if (r102 == null) goto L52;
        ImageInfo r103 = r102.f365014a;
        if (r103 == null) goto L53;
        Image r104 = r103.f364799b;
        if (r104 == null) goto L54;
        String r105 = r104.f364791a;
        if (r105 != null) goto L42;
        return "";
    L42:
        return r105;
    L54:
        return "";
    L53:
        return "";
    L52:
        return "";
    L51:
        return "";
    L5:
        if (r100 != 4) goto L7;
        UserCreationContent r106 = this.f364991e;
        if (r106 == null) goto L47;
        AiBeautifyUserContent r107 = r106.f365009d;
        if (r107 == null) goto L48;
        ImageInfo r108 = r107.f364882a;
        if (r108 == null) goto L49;
        Image r109 = r108.f364799b;
        if (r109 == null) goto L50;
        r105 = r109.f364791a;
        if (r105 != null) goto L42;
        return "";
    L50:
        return "";
    L49:
        return "";
    L48:
        return "";
    L47:
        return "";
    L7:
        if (r100 == 5) goto L30;
        UserCreationContent r110 = this.f364991e;
        if (r110 == null) goto L43;
        UserCreationUserAvatar r111 = r110.f365008c;
        if (r111 == null) goto L44;
        ImageInfo r112 = r111.f365050a;
        if (r112 == null) goto L45;
        Image r113 = r112.f364799b;
        if (r113 == null) goto L46;
        r105 = r113.f364791a;
        if (r105 != null) goto L42;
        return "";
    L46:
        return "";
    L45:
        return "";
    L44:
        return "";
    L43:
        return "";
    }

    public final String s() {
        int r100 = this.f364988b;
        if (r100 != 2) goto L5;
    L30:
        UserCreationContent r101 = this.f364991e;
        if (r101 == null) goto L51;
        UserCreationImage r102 = r101.f365006a;
        if (r102 == null) goto L52;
        ImageInfo r103 = r102.f365014a;
        if (r103 == null) goto L53;
        Image r104 = r103.f364807j;
        if (r104 == null) goto L54;
        String r105 = r104.f364791a;
        if (r105 != null) goto L42;
        return "";
    L42:
        return r105;
    L54:
        return "";
    L53:
        return "";
    L52:
        return "";
    L51:
        return "";
    L5:
        if (r100 != 4) goto L7;
        UserCreationContent r106 = this.f364991e;
        if (r106 == null) goto L47;
        AiBeautifyUserContent r107 = r106.f365009d;
        if (r107 == null) goto L48;
        ImageInfo r108 = r107.f364882a;
        if (r108 == null) goto L49;
        Image r109 = r108.f364807j;
        if (r109 == null) goto L50;
        r105 = r109.f364791a;
        if (r105 != null) goto L42;
        return "";
    L50:
        return "";
    L49:
        return "";
    L48:
        return "";
    L47:
        return "";
    L7:
        if (r100 == 5) goto L30;
        UserCreationContent r110 = this.f364991e;
        if (r110 == null) goto L43;
        UserCreationUserAvatar r111 = r110.f365008c;
        if (r111 == null) goto L44;
        ImageInfo r112 = r111.f365050a;
        if (r112 == null) goto L45;
        Image r113 = r112.f364807j;
        if (r113 == null) goto L46;
        r105 = r113.f364791a;
        if (r105 != null) goto L42;
        return "";
    L46:
        return "";
    L45:
        return "";
    L44:
        return "";
    L43:
        return "";
    }

    public final boolean t() {
        UserCreationRefContent r100 = this.f365001o;
        if (r100 == null) goto L10;
        List<ImageInfo> r101 = r100.a();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.size() <= 1) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean z() {
        CreationPublishExtra r100 = this.f365002p;
        if (r100 == null) goto L13;
        String r101 = r100.f364925c;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    L13:
        return false;
    }

    public final String q(boolean r100) {
        if (r100 == false) goto L11;
        CreationDynamicInfo r101 = this.f364994h;
        if (r101 == null) goto L19;
        TplInfo r102 = r101.f364915e;
        if (r102 == null) goto L20;
        TplDetail r103 = r102.f364974c;
        if (r103 != null) goto L22;
        return null;
    L22:
        return r103.f364960b;
    L20:
        return null;
    L19:
        return null;
    L11:
        CreationDynamicInfo r104 = this.f364994h;
        if (r104 == null) goto L23;
        TplInfo r105 = r104.f364915e;
        if (r105 == null) goto L24;
        TplDetail r106 = r105.f364973b;
        if (r106 != null) goto L18;
        return null;
    L18:
        return r106.f364960b;
    L24:
        return null;
    L23:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ UserCreation(String r210, int r211, Integer r212, UserCreationContent r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Integer r102 = 0;
    L14:
        String r103 = null;
        if ((r214 & 8) == 0) goto L17;
        Integer r104 = 0;
    L19:
        if ((r214 & 16) == 0) goto L21;
        UserCreationContent r105 = null;
    L23:
        if ((r214 & 8192) == 0) goto L25;
        UserCreationTrackParams r110 = new UserCreationTrackParams(r103, null == true ? 1 : 0, 127);
    L26:
        this(r100, r101, r102, r104, r105, null, null, null, null, null, null, null, null, r110, null, null, null);
        return;
    L25:
        r110 = null;
        goto L26
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r102 = r212;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static UserCreation c(UserCreation r210, Integer r211, UserCreationContent r212, Long r213, String r214, CreationCommunityInfo r215, UserCreationTrackParams r216, int r217) {
        AwemeAnchor r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = r210.f364987a;
    L7:
        if ((r217 & 2) == 0) goto L9;
        int r102 = r210.f364988b;
    L11:
        if ((r217 & 4) == 0) goto L13;
        Integer r103 = r210.f364989c;
    L15:
        if ((r217 & 8) == 0) goto L17;
        Integer r104 = r210.f364990d;
    L19:
        if ((r217 & 16) == 0) goto L21;
        UserCreationContent r105 = r210.f364991e;
    L23:
        if ((r217 & 32) == 0) goto L25;
        Long r110 = r210.f364992f;
    L27:
        if ((r217 & 64) == 0) goto L29;
        AuthorInfo r111 = r210.f364993g;
    L31:
        if ((r217 & 128) == 0) goto L33;
        CreationDynamicInfo r112 = r210.f364994h;
    L35:
        if ((r217 & 256) == 0) goto L37;
        String r113 = r210.f364995i;
    L39:
        if ((r217 & 512) == 0) goto L41;
        Integer r114 = r210.f364996j;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        CreationCommunityInfo r115 = r210.f364997k;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        Boolean r116 = r210.f364998l;
    L51:
        if ((r217 & 4096) == 0) goto L53;
        Long r117 = r210.f364999m;
    L55:
        if ((r217 & 8192) == 0) goto L57;
        UserCreationTrackParams r118 = r210.f365000n;
    L59:
        if ((r217 & 16384) == 0) goto L61;
        UserCreationRefContent r119 = r210.f365001o;
    L63:
        if ((32768 & r217) == 0) goto L65;
        CreationPublishExtra r218 = r210.f365002p;
    L67:
        if ((r217 & 65536) == 0) goto L69;
        r100 = r210.f365003q;
    L69:
        r210.getClass();
        return new UserCreation(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r218, r100);
    L65:
        r218 = null;
        goto L67
    L61:
        r119 = null;
        goto L63
    L57:
        r118 = r216;
        goto L59
    L53:
        r117 = null;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = r215;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = r214;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public UserCreation(String r100, @UserCreationType int r101, @UserCreationStatus Integer r102, @UserCreationPrivateStatus Integer r103, UserCreationContent r104, Long r105, AuthorInfo r106, CreationDynamicInfo r110, String r111, @CreateCreationSource Integer r112, CreationCommunityInfo r113, Boolean r114, Long r115, UserCreationTrackParams r116, UserCreationRefContent r117, CreationPublishExtra r118, AwemeAnchor r119) {
        this.f364987a = r100;
        this.f364988b = r101;
        this.f364989c = r102;
        this.f364990d = r103;
        this.f364991e = r104;
        this.f364992f = r105;
        this.f364993g = r106;
        this.f364994h = r110;
        this.f364995i = r111;
        this.f364996j = r112;
        this.f364997k = r113;
        this.f364998l = r114;
        this.f364999m = r115;
        this.f365000n = r116;
        this.f365001o = r117;
        this.f365002p = r118;
        this.f365003q = r119;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserCreation(int r100, String r101, int r102, Integer r110, Integer r111, UserCreationContent r112, Long r113, AuthorInfo r114, CreationDynamicInfo r115, String r116, Integer r117, CreationCommunityInfo r118, Boolean r119, Long r210, UserCreationTrackParams r211, UserCreationRefContent r212, CreationPublishExtra r213, AwemeAnchor r214) {
        String r103 = null;
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f365005b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        String r104 = "";
    L8:
        this.f364987a = r104;
        if ((r100 & 2) != 0) goto L11;
        this.f364988b = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f364989c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f364990d = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f364991e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f364992f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f364993g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f364994h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f364995i = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f364996j = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f364997k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f364998l = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f364999m = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        Object[] r105 = null == true ? 1 : 0;
        UserCreationTrackParams r106 = new UserCreationTrackParams(r103, r105, 127);
    L60:
        this.f365000n = r106;
        if ((r100 & 16384) != 0) goto L63;
        this.f365001o = null;
    L65:
        if ((32768 & r100) != 0) goto L67;
        this.f365002p = null;
    L69:
        if ((r100 & 65536) != 0) goto L71;
        this.f365003q = null;
        return;
    L71:
        this.f365003q = r214;
        return;
    L67:
        this.f365002p = r213;
        goto L69
    L63:
        this.f365001o = r212;
        goto L65
    L59:
        r106 = r211;
        goto L60
    L55:
        this.f364999m = r210;
        goto L57
    L51:
        this.f364998l = r119;
        goto L53
    L47:
        this.f364997k = r118;
        goto L49
    L43:
        this.f364996j = r117;
        goto L45
    L39:
        this.f364995i = r116;
        goto L41
    L35:
        this.f364994h = r115;
        goto L37
    L31:
        this.f364993g = r114;
        goto L33
    L27:
        this.f364992f = r113;
        goto L29
    L23:
        this.f364991e = r112;
        goto L25
    L19:
        this.f364990d = r111;
        goto L21
    L15:
        this.f364989c = r110;
        goto L17
    L11:
        this.f364988b = r102;
        goto L13
    L7:
        r104 = r101;
        goto L8
    }
}
