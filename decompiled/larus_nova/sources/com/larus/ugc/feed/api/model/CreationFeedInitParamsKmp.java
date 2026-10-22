package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
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
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bV\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008b\u00012\u00060\u0001j\u0002`\u0002:\u0004\u008a\u0001\u008b\u0001B\u0091\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!Bù\u0001\b\u0010\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\t\u0010^\u001a\u00020\u0004HÆ\u0003J\t\u0010_\u001a\u00020\u0004HÆ\u0003J\t\u0010`\u001a\u00020\u0007HÆ\u0003J\t\u0010a\u001a\u00020\u0004HÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\t\u0010f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\t\u0010i\u001a\u00020\u0004HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010k\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010l\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\t\u0010m\u001a\u00020\u0004HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010o\u001a\u00020\u0004HÆ\u0003J\t\u0010p\u001a\u00020\u0004HÆ\u0003J\t\u0010q\u001a\u00020\u0004HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010s\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010XJ\u0010\u0010t\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010u\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010XJ\u0098\u0002\u0010v\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010wJ\u0006\u0010x\u001a\u00020\fJ\u0013\u0010y\u001a\u00020\u00042\b\u0010z\u001a\u0004\u0018\u00010{HÖ\u0003J\t\u0010|\u001a\u00020\fHÖ\u0001J\t\u0010}\u001a\u00020\u0007HÖ\u0001J\u0019\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\fJ,\u0010\u0083\u0001\u001a\u00020\u007f2\u0007\u0010\u0084\u0001\u001a\u00020\u00002\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0001¢\u0006\u0003\b\u0089\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010)R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010'\u001a\u0004\b0\u0010)R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010'\u001a\u0004\b2\u00103R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b4\u0010'\u001a\u0004\b5\u00106R \u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b8\u0010'\u001a\u0004\b9\u00106R \u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b:\u0010'\u001a\u0004\b;\u00106R\u001c\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010'\u001a\u0004\b=\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010'\u001a\u0004\b?\u0010@R \u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bA\u0010'\u001a\u0004\bB\u00106R\u001c\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010'\u001a\u0004\b\u0013\u0010)R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bD\u0010'\u001a\u0004\bE\u00106R \u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bF\u0010'\u001a\u0004\bG\u00106R \u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bH\u0010'\u001a\u0004\bI\u00106R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010'\u001a\u0004\bK\u0010)R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010'\u001a\u0004\bM\u0010.R\u001c\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010'\u001a\u0004\bO\u0010)R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010'\u001a\u0004\bQ\u0010)R\u001c\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010'\u001a\u0004\bS\u0010)R \u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bT\u0010'\u001a\u0004\bU\u00106R \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010Y\u0012\u0004\bV\u0010'\u001a\u0004\bW\u0010XR \u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bZ\u0010'\u001a\u0004\b[\u00106R \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010Y\u0012\u0004\b\\\u0010'\u001a\u0004\b]\u0010X¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationFeedInitParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "forceRefreshIgnoreCache", "", "disableInitialAutoRefreshOnce", "fpsTrackerTag", "", "disablePullRefresh", "trackParams", "Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "creationFeedType", "", "bottomPadding", "topPadding", "disableEndView", "currentTabItemInfo", "Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "forceSpanCount", "isGridLayoutManager", "itemGapSpacing", "marginLeft", "marginRight", "showUserInfo", "creationRecommendType", "openNewChatPageOnSend", "needFocusHelper", "enableGapHandling", "loadMoreDistance", "needAddReplicaEntrance", "creationDoSameLandingType", "creationSendMessageFromDetail", "<init>", "(ZZLjava/lang/String;ZLcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/ugc/feed/api/model/TabItemInfoKmp;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLjava/lang/String;ZLcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/ugc/feed/api/model/TabItemInfoKmp;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getForceRefreshIgnoreCache$annotations", "()V", "getForceRefreshIgnoreCache", "()Z", "getDisableInitialAutoRefreshOnce$annotations", "getDisableInitialAutoRefreshOnce", "getFpsTrackerTag$annotations", "getFpsTrackerTag", "()Ljava/lang/String;", "getDisablePullRefresh$annotations", "getDisablePullRefresh", "getTrackParams$annotations", "getTrackParams", "()Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "getCreationFeedType$annotations", "getCreationFeedType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomPadding$annotations", "getBottomPadding", "getTopPadding$annotations", "getTopPadding", "getDisableEndView$annotations", "getDisableEndView", "getCurrentTabItemInfo$annotations", "getCurrentTabItemInfo", "()Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "getForceSpanCount$annotations", "getForceSpanCount", "isGridLayoutManager$annotations", "getItemGapSpacing$annotations", "getItemGapSpacing", "getMarginLeft$annotations", "getMarginLeft", "getMarginRight$annotations", "getMarginRight", "getShowUserInfo$annotations", "getShowUserInfo", "getCreationRecommendType$annotations", "getCreationRecommendType", "getOpenNewChatPageOnSend$annotations", "getOpenNewChatPageOnSend", "getNeedFocusHelper$annotations", "getNeedFocusHelper", "getEnableGapHandling$annotations", "getEnableGapHandling", "getLoadMoreDistance$annotations", "getLoadMoreDistance", "getNeedAddReplicaEntrance$annotations", "getNeedAddReplicaEntrance", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreationDoSameLandingType$annotations", "getCreationDoSameLandingType", "getCreationSendMessageFromDetail$annotations", "getCreationSendMessageFromDetail", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(ZZLjava/lang/String;ZLcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/ugc/feed/api/model/TabItemInfoKmp;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/ugc/feed/api/model/CreationFeedInitParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CreationFeedInitParamsKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationFeedInitParamsKmp> CREATOR = null;
    public static final b Companion = null;
    private final Integer bottomPadding;
    private final Integer creationDoSameLandingType;
    private final Integer creationFeedType;
    private final String creationRecommendType;
    private final Boolean creationSendMessageFromDetail;
    private final TabItemInfoKmp currentTabItemInfo;
    private final boolean disableEndView;
    private final boolean disableInitialAutoRefreshOnce;
    private final boolean disablePullRefresh;
    private final boolean enableGapHandling;
    private final boolean forceRefreshIgnoreCache;
    private final Integer forceSpanCount;
    private final String fpsTrackerTag;
    private final boolean isGridLayoutManager;
    private final Integer itemGapSpacing;
    private final Integer loadMoreDistance;
    private final Integer marginLeft;
    private final Integer marginRight;
    private final Boolean needAddReplicaEntrance;
    private final boolean needFocusHelper;
    private final boolean openNewChatPageOnSend;
    private final boolean showUserInfo;
    private final Integer topPadding;
    private final CreationFeedTrackParamsKmp trackParams;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationFeedInitParamsKmp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f374320a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f374321b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f374321b;
        }

        static {
            a r100 = new a();
            f374320a = r100;
            g2 r101 = new g2("com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp", r100, 24);
            r101.j("force_refresh_ignore_cache", true);
            r101.j("disable_initial_auto_refresh_once", true);
            r101.j("fps_tracker_tag", true);
            r101.j("disable_pull_refresh", true);
            r101.j("track_params", true);
            r101.j("creation_feed_type", true);
            r101.j("bottom_padding", true);
            r101.j("top_padding", true);
            r101.j("disable_end_view", true);
            r101.j("current_tab_item_info", true);
            r101.j("force_span_count", true);
            r101.j("is_grid_layout_manager", true);
            r101.j("item_gap_spacing", true);
            r101.j("margin_left", true);
            r101.j("margin_right", true);
            r101.j("show_user_info", true);
            r101.j("creation_recommend_type", true);
            r101.j("open_new_chat_page_on_send", true);
            r101.j("need_focus_helper", true);
            r101.j("enable_gap_handling", true);
            r101.j("load_more_distance", true);
            r101.j("need_add_replica_entrance", true);
            r101.j("creation_do_same_landing_type", true);
            r101.j("creation_send_message_from_detail", true);
            f374321b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            i r100 = i.f520705a;
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{r100, r100, r101, r100, CreationFeedTrackParamsKmp.a.f374322a, kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), r100, kuc.a.d(TabItemInfoKmp.a.f374344a), kuc.a.d(r102), r100, kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), r100, kuc.a.d(r101), r100, r100, r100, kuc.a.d(r102), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f374321b;
            muc.c r101 = r510.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            boolean r102 = r101.decodeBooleanElement(r100, 0);
            boolean r103 = r101.decodeBooleanElement(r100, 1);
            String r110 = r101.decodeStringElement(r100, 2);
            boolean r111 = r101.decodeBooleanElement(r100, 3);
            CreationFeedTrackParamsKmp r104 = (CreationFeedTrackParamsKmp) r101.decodeSerializableElement(r100, 4, CreationFeedTrackParamsKmp.a.f374322a, null);
            w0 r112 = w0.f520792a;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r112, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r112, null);
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 7, r112, null);
            boolean r106 = r101.decodeBooleanElement(r100, 8);
            TabItemInfoKmp r107 = (TabItemInfoKmp) r101.decodeNullableSerializableElement(r100, 9, TabItemInfoKmp.a.f374344a, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r112, null);
            boolean r115 = r101.decodeBooleanElement(r100, 11);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 12, r112, null);
            Integer r116 = (Integer) r101.decodeNullableSerializableElement(r100, 13, r112, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 14, r112, null);
            boolean r118 = r101.decodeBooleanElement(r100, 15);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, null);
            boolean r120 = r101.decodeBooleanElement(r100, 17);
            boolean r121 = r101.decodeBooleanElement(r100, 18);
            boolean r122 = r101.decodeBooleanElement(r100, 19);
            Integer r123 = (Integer) r101.decodeNullableSerializableElement(r100, 20, r112, null);
            i r124 = i.f520705a;
            Boolean r125 = (Boolean) r101.decodeNullableSerializableElement(r100, 21, r124, null);
            Integer r126 = (Integer) r101.decodeNullableSerializableElement(r100, 22, r112, null);
            Boolean r310 = (Boolean) r101.decodeNullableSerializableElement(r100, 23, r124, null);
            Integer r311 = r126;
            boolean r312 = r118;
            boolean r313 = r121;
            boolean r210 = r115;
            boolean r314 = r122;
            String r315 = r119;
            Integer r316 = r123;
            String r127 = r110;
            Integer r317 = r117;
            Integer r211 = r116;
            Integer r212 = r109;
            boolean r128 = r102;
            boolean r318 = r120;
            Boolean r319 = r125;
            boolean r129 = r103;
            TabItemInfoKmp r213 = r107;
            Integer r214 = r108;
            CreationFeedTrackParamsKmp r215 = r104;
            boolean r216 = r106;
            boolean r130 = r111;
            Integer r217 = r114;
            Integer r218 = r105;
            int r131 = 16777215;
            Integer r219 = r113;
        L47:
            r101.endStructure(r100);
            return new CreationFeedInitParamsKmp(r131, r128, r129, r127, r130, r215, r219, r217, r218, r216, r213, r214, r210, r212, r211, r317, r312, r315, r318, r313, r314, r316, r319, r311, r310, null);
        L5:
            String r132 = null;
            Boolean r133 = null;
            Integer r134 = null;
            Integer r135 = null;
            Integer r136 = null;
            TabItemInfoKmp r137 = null;
            Integer r138 = null;
            Integer r139 = null;
            Integer r140 = null;
            Boolean r141 = null;
            Integer r142 = null;
            Integer r143 = null;
            Integer r144 = null;
            CreationFeedTrackParamsKmp r220 = null;
            String r320 = null;
            int r145 = 0;
            boolean r321 = false;
            boolean r322 = false;
            boolean r410 = false;
            boolean r411 = false;
            boolean r412 = false;
            boolean r413 = false;
            boolean r414 = false;
            boolean r415 = false;
            boolean r416 = false;
            boolean r417 = true;
        L6:
            if (r417 == false) goto L46;
            Integer r418 = r142;
            int r146 = r101.decodeElementIndex(r100);
            switch(r146) {
                case -1: goto L44;
                case 0: goto L42;
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L38;
                case 4: goto L37;
                case 5: goto L35;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L28;
                case 11: goto L27;
                case 12: goto L26;
                case 13: goto L25;
                case 14: goto L24;
                case 15: goto L23;
                case 16: goto L21;
                case 17: goto L18;
                case 18: goto L17;
                case 19: goto L16;
                case 20: goto L14;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r146);
        L35:
            r133 = r133;
            r134 = r134;
            r145 = r145 | 32;
            r220 = r220;
            r418 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r418);
        L43:
            r142 = r418;
            r133 = r133;
        L45:
            r220 = r220;
            r134 = r134;
            goto L6
        L37:
            r133 = r133;
            r134 = r134;
            CreationFeedTrackParamsKmp r147 = r220;
            r418 = r418;
            r220 = (CreationFeedTrackParamsKmp) r101.decodeSerializableElement(r100, 4, CreationFeedTrackParamsKmp.a.f374322a, r147);
            r145 = r145 | 16;
            goto L43
        L38:
            r416 = r101.decodeBooleanElement(r100, 3);
            r145 = r145 | 8;
            goto L43
        L39:
            r320 = r101.decodeStringElement(r100, 2);
            r145 = r145 | 4;
            goto L43
        L41:
            r133 = r133;
            r134 = r134;
            r220 = r220;
            r418 = r418;
            r413 = r101.decodeBooleanElement(r100, 1);
            r145 = r145 | 2;
            goto L43
        L42:
            r133 = r133;
            r134 = r134;
            r220 = r220;
            r418 = r418;
            r145 = r145 | 1;
            r410 = r101.decodeBooleanElement(r100, 0);
            goto L43
        L44:
            r134 = r134;
            r220 = r220;
            r142 = r418;
            r133 = r133;
            r417 = false;
            goto L45
        L11:
            r133 = (Boolean) r101.decodeNullableSerializableElement(r100, 23, i.f520705a, r133);
            int r148 = 8388608;
        L22:
            r145 = r145 | r148;
        L31:
            Boolean r323 = r133;
            r143 = r143;
        L34:
            r133 = r323;
            r142 = r418;
            goto L6
        L12:
            r136 = (Integer) r101.decodeNullableSerializableElement(r100, 22, w0.f520792a, r136);
            r148 = 4194304;
            goto L22
        L13:
            r141 = (Boolean) r101.decodeNullableSerializableElement(r100, 21, i.f520705a, r141);
            r148 = 2097152;
            goto L22
        L14:
            r139 = (Integer) r101.decodeNullableSerializableElement(r100, 20, w0.f520792a, r139);
            r148 = 1048576;
            goto L22
        L16:
            r321 = r101.decodeBooleanElement(r100, 19);
            int r149 = 524288;
        L19:
            r145 = r145 | r149;
            goto L31
        L17:
            r414 = r101.decodeBooleanElement(r100, 18);
            r149 = 262144;
            goto L19
        L18:
            r412 = r101.decodeBooleanElement(r100, 17);
            r149 = 131072;
            goto L19
        L21:
            r143 = r143;
            r132 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r132);
            r148 = 65536;
            goto L22
        L23:
            r143 = r143;
            r322 = r101.decodeBooleanElement(r100, 15);
            r145 = r145 | 32768;
            goto L31
        L24:
            r143 = r143;
            r140 = (Integer) r101.decodeNullableSerializableElement(r100, 14, w0.f520792a, r140);
            r145 = r145 | 16384;
            goto L31
        L25:
            r143 = r143;
            r144 = (Integer) r101.decodeNullableSerializableElement(r100, 13, w0.f520792a, r144);
            r145 = r145 | 8192;
            goto L31
        L26:
            r143 = r143;
            r134 = (Integer) r101.decodeNullableSerializableElement(r100, 12, w0.f520792a, r134);
            r145 = r145 | 4096;
            goto L31
        L27:
            r143 = r143;
            r415 = r101.decodeBooleanElement(r100, 11);
            r145 = r145 | 2048;
            goto L31
        L28:
            r143 = r143;
            r135 = (Integer) r101.decodeNullableSerializableElement(r100, 10, w0.f520792a, r135);
            r145 = r145 | 1024;
            goto L31
        L29:
            r143 = r143;
            r137 = (TabItemInfoKmp) r101.decodeNullableSerializableElement(r100, 9, TabItemInfoKmp.a.f374344a, r137);
            r145 = r145 | 512;
            goto L31
        L30:
            r143 = r143;
            r411 = r101.decodeBooleanElement(r100, 8);
            r145 = r145 | 256;
            goto L31
        L32:
            r143 = r143;
            r138 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, r138);
            r145 = r145 | 128;
            goto L31
        L33:
            r323 = r133;
            r143 = (Integer) r101.decodeNullableSerializableElement(r100, 6, w0.f520792a, r143);
            r145 = r145 | 64;
            goto L34
        L46:
            Integer r324 = r134;
            r215 = r220;
            r214 = r135;
            r213 = r137;
            r218 = r138;
            r316 = r139;
            r317 = r140;
            r217 = r143;
            r219 = r142;
            r212 = r324;
            r314 = r321;
            r312 = r322;
            r127 = r320;
            r128 = r410;
            r216 = r411;
            r318 = r412;
            r129 = r413;
            r313 = r414;
            r210 = r415;
            r130 = r416;
            r311 = r136;
            r319 = r141;
            r211 = r144;
            r310 = r133;
            r315 = r132;
            r131 = r145;
            goto L47
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            CreationFeedInitParamsKmp r102 = (CreationFeedInitParamsKmp) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f374321b;
            muc.d r104 = r100.beginStructure(r103);
            CreationFeedInitParamsKmp.write$Self$feed_kmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationFeedInitParamsKmp> serializer() {
            return a.f374320a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationFeedInitParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedInitParamsKmp createFromParcel(Parcel r310) {
            Intrinsics.checkNotNullParameter(r310, "parcel");
            boolean r100 = false;
            if (r310.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r310.readInt() == 0) goto L9;
            boolean r102 = true;
        L10:
            String r103 = r310.readString();
            if (r310.readInt() == 0) goto L13;
            boolean r104 = true;
        L14:
            CreationFeedTrackParamsKmp r105 = CreationFeedTrackParamsKmp.CREATOR.createFromParcel(r310);
            if (r310.readInt() != 0) goto L17;
            Integer r110 = null;
        L19:
            if (r310.readInt() != 0) goto L21;
            Integer r111 = null;
        L23:
            if (r310.readInt() != 0) goto L25;
            Integer r112 = null;
        L27:
            if (r310.readInt() == 0) goto L29;
            boolean r113 = true;
        L31:
            if (r310.readInt() != 0) goto L33;
            TabItemInfoKmp r106 = null;
        L34:
            TabItemInfoKmp r114 = r106;
            if (r310.readInt() != 0) goto L37;
            Integer r115 = null;
        L39:
            if (r310.readInt() == 0) goto L41;
            boolean r116 = true;
        L43:
            if (r310.readInt() != 0) goto L45;
            Integer r117 = null;
        L47:
            if (r310.readInt() != 0) goto L49;
            Integer r118 = null;
        L51:
            if (r310.readInt() != 0) goto L53;
            Integer r210 = null;
        L55:
            if (r310.readInt() == 0) goto L57;
            boolean r211 = true;
        L58:
            String r212 = r310.readString();
            if (r310.readInt() == 0) goto L61;
            boolean r213 = true;
        L63:
            if (r310.readInt() == 0) goto L65;
            boolean r214 = true;
        L67:
            if (r310.readInt() == 0) goto L69;
            boolean r215 = true;
        L71:
            if (r310.readInt() != 0) goto L73;
            Integer r216 = null;
        L75:
            if (r310.readInt() != 0) goto L78;
            Boolean r217 = null;
        L83:
            if (r310.readInt() != 0) goto L85;
            Integer r218 = null;
        L87:
            if (r310.readInt() != 0) goto L90;
            Boolean r107 = null;
        L94:
            return new CreationFeedInitParamsKmp(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r107);
        L90:
            if (r310.readInt() == 0) goto L92;
            r100 = true;
        L92:
            r107 = Boolean.valueOf(r100);
            goto L94
        L85:
            r218 = Integer.valueOf(r310.readInt());
            goto L87
        L78:
            if (r310.readInt() == 0) goto L80;
            boolean r108 = true;
        L81:
            r217 = Boolean.valueOf(r108);
            goto L83
        L80:
            r108 = false;
            goto L81
        L73:
            r216 = Integer.valueOf(r310.readInt());
            goto L75
        L69:
            r215 = false;
            goto L71
        L65:
            r214 = false;
            goto L67
        L61:
            r213 = false;
            goto L63
        L57:
            r211 = false;
            goto L58
        L53:
            r210 = Integer.valueOf(r310.readInt());
            goto L55
        L49:
            r118 = Integer.valueOf(r310.readInt());
            goto L51
        L45:
            r117 = Integer.valueOf(r310.readInt());
            goto L47
        L41:
            r116 = false;
            goto L43
        L37:
            r115 = Integer.valueOf(r310.readInt());
            goto L39
        L33:
            r106 = TabItemInfoKmp.CREATOR.createFromParcel(r310);
            goto L34
        L29:
            r113 = false;
            goto L31
        L25:
            r112 = Integer.valueOf(r310.readInt());
            goto L27
        L21:
            r111 = Integer.valueOf(r310.readInt());
            goto L23
        L17:
            r110 = Integer.valueOf(r310.readInt());
            goto L19
        L13:
            r104 = false;
            goto L14
        L9:
            r102 = false;
            goto L10
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedInitParamsKmp[] newArray(int r100) {
            return new CreationFeedInitParamsKmp[r100];
        }
    }

    public CreationFeedInitParamsKmp() {
        this(false, false, null, false, null, null, null, null, false, null, null, false, null, null, null, false, null, false, false, false, null, null, null, null, 16777215, null);
    }

    public static /* synthetic */ CreationFeedInitParamsKmp copy$default(CreationFeedInitParamsKmp r110, boolean r111, boolean r112, String r210, boolean r211, CreationFeedTrackParamsKmp r212, Integer r213, Integer r214, Integer r215, boolean r216, TabItemInfoKmp r217, Integer r218, boolean r219, Integer r310, Integer r311, Integer r312, boolean r313, String r314, boolean r315, boolean r316, boolean r317, Integer r318, Boolean r319, Integer r410, Boolean r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        boolean r100 = r110.forceRefreshIgnoreCache;
    L7:
        if ((r412 & 2) == 0) goto L9;
        boolean r101 = r110.disableInitialAutoRefreshOnce;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = r110.fpsTrackerTag;
    L15:
        if ((r412 & 8) == 0) goto L17;
        boolean r103 = r110.disablePullRefresh;
    L19:
        if ((r412 & 16) == 0) goto L21;
        CreationFeedTrackParamsKmp r104 = r110.trackParams;
    L23:
        if ((r412 & 32) == 0) goto L25;
        Integer r105 = r110.creationFeedType;
    L27:
        if ((r412 & 64) == 0) goto L29;
        Integer r106 = r110.bottomPadding;
    L31:
        if ((r412 & 128) == 0) goto L33;
        Integer r107 = r110.topPadding;
    L35:
        if ((r412 & 256) == 0) goto L37;
        boolean r113 = r110.disableEndView;
    L39:
        if ((r412 & 512) == 0) goto L41;
        TabItemInfoKmp r114 = r110.currentTabItemInfo;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        Integer r115 = r110.forceSpanCount;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        boolean r116 = r110.isGridLayoutManager;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        Integer r117 = r110.itemGapSpacing;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        Integer r118 = r110.marginLeft;
    L58:
        Integer r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        Integer r119 = r110.marginRight;
    L62:
        Integer r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        boolean r120 = r110.showUserInfo;
    L66:
        boolean r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        String r121 = r110.creationRecommendType;
    L70:
        String r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        boolean r122 = r110.openNewChatPageOnSend;
    L74:
        boolean r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        boolean r123 = r110.needFocusHelper;
    L78:
        boolean r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        boolean r124 = r110.enableGapHandling;
    L82:
        boolean r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        Integer r125 = r110.loadMoreDistance;
    L86:
        Integer r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        Boolean r126 = r110.needAddReplicaEntrance;
    L90:
        Boolean r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        Integer r127 = r110.creationDoSameLandingType;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        Boolean r108 = r110.creationSendMessageFromDetail;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
    L97:
        r108 = r411;
        goto L99
    L93:
        r127 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
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

    @SerialName("bottom_padding")
    public static /* synthetic */ void getBottomPadding$annotations() {
    }

    @SerialName("creation_do_same_landing_type")
    public static /* synthetic */ void getCreationDoSameLandingType$annotations() {
    }

    @SerialName("creation_feed_type")
    public static /* synthetic */ void getCreationFeedType$annotations() {
    }

    @SerialName("creation_recommend_type")
    public static /* synthetic */ void getCreationRecommendType$annotations() {
    }

    @SerialName("creation_send_message_from_detail")
    public static /* synthetic */ void getCreationSendMessageFromDetail$annotations() {
    }

    @SerialName("current_tab_item_info")
    public static /* synthetic */ void getCurrentTabItemInfo$annotations() {
    }

    @SerialName("disable_end_view")
    public static /* synthetic */ void getDisableEndView$annotations() {
    }

    @SerialName("disable_initial_auto_refresh_once")
    public static /* synthetic */ void getDisableInitialAutoRefreshOnce$annotations() {
    }

    @SerialName("disable_pull_refresh")
    public static /* synthetic */ void getDisablePullRefresh$annotations() {
    }

    @SerialName("enable_gap_handling")
    public static /* synthetic */ void getEnableGapHandling$annotations() {
    }

    @SerialName("force_refresh_ignore_cache")
    public static /* synthetic */ void getForceRefreshIgnoreCache$annotations() {
    }

    @SerialName("force_span_count")
    public static /* synthetic */ void getForceSpanCount$annotations() {
    }

    @SerialName("fps_tracker_tag")
    public static /* synthetic */ void getFpsTrackerTag$annotations() {
    }

    @SerialName("item_gap_spacing")
    public static /* synthetic */ void getItemGapSpacing$annotations() {
    }

    @SerialName("load_more_distance")
    public static /* synthetic */ void getLoadMoreDistance$annotations() {
    }

    @SerialName("margin_left")
    public static /* synthetic */ void getMarginLeft$annotations() {
    }

    @SerialName("margin_right")
    public static /* synthetic */ void getMarginRight$annotations() {
    }

    @SerialName("need_add_replica_entrance")
    public static /* synthetic */ void getNeedAddReplicaEntrance$annotations() {
    }

    @SerialName("need_focus_helper")
    public static /* synthetic */ void getNeedFocusHelper$annotations() {
    }

    @SerialName("open_new_chat_page_on_send")
    public static /* synthetic */ void getOpenNewChatPageOnSend$annotations() {
    }

    @SerialName("show_user_info")
    public static /* synthetic */ void getShowUserInfo$annotations() {
    }

    @SerialName("top_padding")
    public static /* synthetic */ void getTopPadding$annotations() {
    }

    @SerialName("track_params")
    public static /* synthetic */ void getTrackParams$annotations() {
    }

    @SerialName("is_grid_layout_manager")
    public static /* synthetic */ void isGridLayoutManager$annotations() {
    }

    public final boolean component1() {
        return this.forceRefreshIgnoreCache;
    }

    public final TabItemInfoKmp component10() {
        return this.currentTabItemInfo;
    }

    public final Integer component11() {
        return this.forceSpanCount;
    }

    public final boolean component12() {
        return this.isGridLayoutManager;
    }

    public final Integer component13() {
        return this.itemGapSpacing;
    }

    public final Integer component14() {
        return this.marginLeft;
    }

    public final Integer component15() {
        return this.marginRight;
    }

    public final boolean component16() {
        return this.showUserInfo;
    }

    public final String component17() {
        return this.creationRecommendType;
    }

    public final boolean component18() {
        return this.openNewChatPageOnSend;
    }

    public final boolean component19() {
        return this.needFocusHelper;
    }

    public final boolean component2() {
        return this.disableInitialAutoRefreshOnce;
    }

    public final boolean component20() {
        return this.enableGapHandling;
    }

    public final Integer component21() {
        return this.loadMoreDistance;
    }

    public final Boolean component22() {
        return this.needAddReplicaEntrance;
    }

    public final Integer component23() {
        return this.creationDoSameLandingType;
    }

    public final Boolean component24() {
        return this.creationSendMessageFromDetail;
    }

    public final String component3() {
        return this.fpsTrackerTag;
    }

    public final boolean component4() {
        return this.disablePullRefresh;
    }

    public final CreationFeedTrackParamsKmp component5() {
        return this.trackParams;
    }

    public final Integer component6() {
        return this.creationFeedType;
    }

    public final Integer component7() {
        return this.bottomPadding;
    }

    public final Integer component8() {
        return this.topPadding;
    }

    public final boolean component9() {
        return this.disableEndView;
    }

    public final CreationFeedInitParamsKmp copy(boolean r210, boolean r211, String r212, boolean r310, CreationFeedTrackParamsKmp r311, Integer r312, Integer r313, Integer r314, boolean r315, TabItemInfoKmp r316, Integer r317, boolean r318, Integer r319, Integer r410, Integer r411, boolean r412, String r413, boolean r414, boolean r415, boolean r416, Integer r417, Boolean r418, Integer r419, Boolean r510) {
        Intrinsics.checkNotNullParameter(r212, "fpsTrackerTag");
        Intrinsics.checkNotNullParameter(r311, "trackParams");
        return new CreationFeedInitParamsKmp(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationFeedInitParamsKmp) == true) goto L8;
        return false;
    L8:
        CreationFeedInitParamsKmp r101 = (CreationFeedInitParamsKmp) r100;
        if (this.forceRefreshIgnoreCache == r101.forceRefreshIgnoreCache) goto L12;
        return false;
    L12:
        if (this.disableInitialAutoRefreshOnce == r101.disableInitialAutoRefreshOnce) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fpsTrackerTag, r101.fpsTrackerTag) == true) goto L18;
        return false;
    L18:
        if (this.disablePullRefresh == r101.disablePullRefresh) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.creationFeedType, r101.creationFeedType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.bottomPadding, r101.bottomPadding) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topPadding, r101.topPadding) == true) goto L33;
        return false;
    L33:
        if (this.disableEndView == r101.disableEndView) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.currentTabItemInfo, r101.currentTabItemInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.forceSpanCount, r101.forceSpanCount) == true) goto L42;
        return false;
    L42:
        if (this.isGridLayoutManager == r101.isGridLayoutManager) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.itemGapSpacing, r101.itemGapSpacing) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.marginLeft, r101.marginLeft) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.marginRight, r101.marginRight) == true) goto L54;
        return false;
    L54:
        if (this.showUserInfo == r101.showUserInfo) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.creationRecommendType, r101.creationRecommendType) == true) goto L60;
        return false;
    L60:
        if (this.openNewChatPageOnSend == r101.openNewChatPageOnSend) goto L63;
        return false;
    L63:
        if (this.needFocusHelper == r101.needFocusHelper) goto L66;
        return false;
    L66:
        if (this.enableGapHandling == r101.enableGapHandling) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.loadMoreDistance, r101.loadMoreDistance) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.needAddReplicaEntrance, r101.needAddReplicaEntrance) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.creationDoSameLandingType, r101.creationDoSameLandingType) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.creationSendMessageFromDetail, r101.creationSendMessageFromDetail) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.forceRefreshIgnoreCache == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.disableInitialAutoRefreshOnce == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.fpsTrackerTag.hashCode()) * 31;
        if (this.disablePullRefresh == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.trackParams.hashCode()) * 31;
        Integer r107 = this.creationFeedType;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        Integer r111 = this.bottomPadding;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.topPadding;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        if (this.disableEndView == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        TabItemInfoKmp r119 = this.currentTabItemInfo;
        if (r119 != null) goto L33;
        int r120 = 0;
    L34:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.forceSpanCount;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        if (this.isGridLayoutManager == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (r124 + r125) * 31;
        Integer r127 = this.itemGapSpacing;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (r126 + r128) * 31;
        Integer r130 = this.marginLeft;
        if (r130 != null) goto L49;
        int r131 = 0;
    L50:
        int r132 = (r129 + r131) * 31;
        Integer r133 = this.marginRight;
        if (r133 != null) goto L53;
        int r134 = 0;
    L54:
        int r135 = (r132 + r134) * 31;
        if (this.showUserInfo == false) goto L57;
        int r136 = 1231;
    L58:
        int r137 = (r135 + r136) * 31;
        String r138 = this.creationRecommendType;
        if (r138 != null) goto L61;
        int r139 = 0;
    L62:
        int r140 = (r137 + r139) * 31;
        if (this.openNewChatPageOnSend == false) goto L65;
        int r141 = 1231;
    L66:
        int r142 = (r140 + r141) * 31;
        if (this.needFocusHelper == false) goto L69;
        int r143 = 1231;
    L70:
        int r144 = (r142 + r143) * 31;
        if (this.enableGapHandling == true) goto L74;
        r100 = 1237;
    L74:
        int r145 = (r144 + r100) * 31;
        Integer r146 = this.loadMoreDistance;
        if (r146 != null) goto L77;
        int r147 = 0;
    L78:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.needAddReplicaEntrance;
        if (r149 != null) goto L81;
        int r150 = 0;
    L82:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.creationDoSameLandingType;
        if (r152 != null) goto L85;
        int r153 = 0;
    L86:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.creationSendMessageFromDetail;
        if (r155 == null) goto L91;
        r108 = r155.hashCode();
    L91:
        return r154 + r108;
    L85:
        r153 = r152.hashCode();
        goto L86
    L81:
        r150 = r149.hashCode();
        goto L82
    L77:
        r147 = r146.hashCode();
        goto L78
    L69:
        r143 = 1237;
        goto L70
    L65:
        r141 = 1237;
        goto L66
    L61:
        r139 = r138.hashCode();
        goto L62
    L57:
        r136 = 1237;
        goto L58
    L53:
        r134 = r133.hashCode();
        goto L54
    L49:
        r131 = r130.hashCode();
        goto L50
    L45:
        r128 = r127.hashCode();
        goto L46
    L41:
        r125 = 1237;
        goto L42
    L37:
        r123 = r122.hashCode();
        goto L38
    L33:
        r120 = r119.hashCode();
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CreationFeedInitParamsKmp(forceRefreshIgnoreCache=" + this.forceRefreshIgnoreCache + ", disableInitialAutoRefreshOnce=" + this.disableInitialAutoRefreshOnce + ", fpsTrackerTag=" + this.fpsTrackerTag + ", disablePullRefresh=" + this.disablePullRefresh + ", trackParams=" + this.trackParams + ", creationFeedType=" + this.creationFeedType + ", bottomPadding=" + this.bottomPadding + ", topPadding=" + this.topPadding + ", disableEndView=" + this.disableEndView + ", currentTabItemInfo=" + this.currentTabItemInfo + ", forceSpanCount=" + this.forceSpanCount + ", isGridLayoutManager=" + this.isGridLayoutManager + ", itemGapSpacing=" + this.itemGapSpacing + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", showUserInfo=" + this.showUserInfo + ", creationRecommendType=" + this.creationRecommendType + ", openNewChatPageOnSend=" + this.openNewChatPageOnSend + ", needFocusHelper=" + this.needFocusHelper + ", enableGapHandling=" + this.enableGapHandling + ", loadMoreDistance=" + this.loadMoreDistance + ", needAddReplicaEntrance=" + this.needAddReplicaEntrance + ", creationDoSameLandingType=" + this.creationDoSameLandingType + ", creationSendMessageFromDetail=" + this.creationSendMessageFromDetail + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.forceRefreshIgnoreCache ? 1 : 0);
        r100.writeInt(this.disableInitialAutoRefreshOnce ? 1 : 0);
        r100.writeString(this.fpsTrackerTag);
        r100.writeInt(this.disablePullRefresh ? 1 : 0);
        this.trackParams.writeToParcel(r100, r101);
        Integer r102 = this.creationFeedType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.bottomPadding;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r104 = this.topPadding;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeInt(this.disableEndView ? 1 : 0);
        TabItemInfoKmp r105 = this.currentTabItemInfo;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Integer r106 = this.forceSpanCount;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        r100.writeInt(this.isGridLayoutManager ? 1 : 0);
        Integer r107 = this.itemGapSpacing;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        Integer r108 = this.marginLeft;
        if (r108 != null) goto L29;
        r100.writeInt(0);
    L30:
        Integer r109 = this.marginRight;
        if (r109 != null) goto L33;
        r100.writeInt(0);
    L34:
        r100.writeInt(this.showUserInfo ? 1 : 0);
        r100.writeString(this.creationRecommendType);
        r100.writeInt(this.openNewChatPageOnSend ? 1 : 0);
        r100.writeInt(this.needFocusHelper ? 1 : 0);
        r100.writeInt(this.enableGapHandling ? 1 : 0);
        Integer r110 = this.loadMoreDistance;
        if (r110 != null) goto L37;
        r100.writeInt(0);
    L38:
        Boolean r111 = this.needAddReplicaEntrance;
        if (r111 != null) goto L41;
        r100.writeInt(0);
    L42:
        Integer r112 = this.creationDoSameLandingType;
        if (r112 != null) goto L45;
        r100.writeInt(0);
    L46:
        Boolean r113 = this.creationSendMessageFromDetail;
        if (r113 != null) goto L49;
        r100.writeInt(0);
        return;
    L49:
        r100.writeInt(1);
        r100.writeInt(r113.booleanValue() ? 1 : 0);
        return;
    L45:
        r100.writeInt(1);
        r100.writeInt(r112.intValue());
        goto L46
    L41:
        r100.writeInt(1);
        r100.writeInt(r111.booleanValue() ? 1 : 0);
        goto L42
    L37:
        r100.writeInt(1);
        r100.writeInt(r110.intValue());
        goto L38
    L33:
        r100.writeInt(1);
        r100.writeInt(r109.intValue());
        goto L34
    L29:
        r100.writeInt(1);
        r100.writeInt(r108.intValue());
        goto L30
    L25:
        r100.writeInt(1);
        r100.writeInt(r107.intValue());
        goto L26
    L21:
        r100.writeInt(1);
        r100.writeInt(r106.intValue());
        goto L22
    L17:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
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

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final Integer getCreationDoSameLandingType() {
        return this.creationDoSameLandingType;
    }

    public final Integer getCreationFeedType() {
        return this.creationFeedType;
    }

    public final String getCreationRecommendType() {
        return this.creationRecommendType;
    }

    public final Boolean getCreationSendMessageFromDetail() {
        return this.creationSendMessageFromDetail;
    }

    public final TabItemInfoKmp getCurrentTabItemInfo() {
        return this.currentTabItemInfo;
    }

    public final boolean getDisableEndView() {
        return this.disableEndView;
    }

    public final boolean getDisableInitialAutoRefreshOnce() {
        return this.disableInitialAutoRefreshOnce;
    }

    public final boolean getDisablePullRefresh() {
        return this.disablePullRefresh;
    }

    public final boolean getEnableGapHandling() {
        return this.enableGapHandling;
    }

    public final boolean getForceRefreshIgnoreCache() {
        return this.forceRefreshIgnoreCache;
    }

    public final Integer getForceSpanCount() {
        return this.forceSpanCount;
    }

    public final String getFpsTrackerTag() {
        return this.fpsTrackerTag;
    }

    public final Integer getItemGapSpacing() {
        return this.itemGapSpacing;
    }

    public final Integer getLoadMoreDistance() {
        return this.loadMoreDistance;
    }

    public final Integer getMarginLeft() {
        return this.marginLeft;
    }

    public final Integer getMarginRight() {
        return this.marginRight;
    }

    public final Boolean getNeedAddReplicaEntrance() {
        return this.needAddReplicaEntrance;
    }

    public final boolean getNeedFocusHelper() {
        return this.needFocusHelper;
    }

    public final boolean getOpenNewChatPageOnSend() {
        return this.openNewChatPageOnSend;
    }

    public final boolean getShowUserInfo() {
        return this.showUserInfo;
    }

    public final Integer getTopPadding() {
        return this.topPadding;
    }

    public final CreationFeedTrackParamsKmp getTrackParams() {
        return this.trackParams;
    }

    public final boolean isGridLayoutManager() {
        return this.isGridLayoutManager;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationFeedInitParamsKmp r310, muc.d r311, f r312) {
        if (r311.shouldEncodeElementDefault(r312, 0) == false) goto L6;
    L4:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        r311.encodeBooleanElement(r312, 0, r310.forceRefreshIgnoreCache);
    L12:
        if (r311.shouldEncodeElementDefault(r312, 1) == false) goto L15;
    L13:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L21;
        r311.encodeBooleanElement(r312, 1, r310.disableInitialAutoRefreshOnce);
    L21:
        if (r311.shouldEncodeElementDefault(r312, 2) == false) goto L24;
    L22:
        boolean r102 = true;
    L27:
        if (r102 == false) goto L30;
        r311.encodeStringElement(r312, 2, r310.fpsTrackerTag);
    L30:
        if (r311.shouldEncodeElementDefault(r312, 3) == false) goto L33;
    L31:
        boolean r103 = true;
    L36:
        if (r103 == false) goto L39;
        r311.encodeBooleanElement(r312, 3, r310.disablePullRefresh);
    L39:
        if (r311.shouldEncodeElementDefault(r312, 4) == false) goto L41;
    L40:
        boolean r104 = true;
    L45:
        if (r104 == false) goto L48;
        r311.encodeSerializableElement(r312, 4, CreationFeedTrackParamsKmp.a.f374322a, r310.trackParams);
    L48:
        if (r311.shouldEncodeElementDefault(r312, 5) == false) goto L51;
    L49:
        boolean r105 = true;
    L54:
        if (r105 == false) goto L57;
        r311.encodeNullableSerializableElement(r312, 5, w0.f520792a, r310.creationFeedType);
    L57:
        if (r311.shouldEncodeElementDefault(r312, 6) == false) goto L60;
    L58:
        boolean r106 = true;
    L63:
        if (r106 == false) goto L66;
        r311.encodeNullableSerializableElement(r312, 6, w0.f520792a, r310.bottomPadding);
    L66:
        if (r311.shouldEncodeElementDefault(r312, 7) == false) goto L69;
    L67:
        boolean r107 = true;
    L72:
        if (r107 == false) goto L75;
        r311.encodeNullableSerializableElement(r312, 7, w0.f520792a, r310.topPadding);
    L75:
        if (r311.shouldEncodeElementDefault(r312, 8) == false) goto L78;
    L76:
        boolean r108 = true;
    L81:
        if (r108 == false) goto L84;
        r311.encodeBooleanElement(r312, 8, r310.disableEndView);
    L84:
        if (r311.shouldEncodeElementDefault(r312, 9) == false) goto L87;
    L85:
        boolean r109 = true;
    L90:
        if (r109 == false) goto L93;
        r311.encodeNullableSerializableElement(r312, 9, TabItemInfoKmp.a.f374344a, r310.currentTabItemInfo);
    L93:
        if (r311.shouldEncodeElementDefault(r312, 10) == false) goto L96;
    L94:
        boolean r110 = true;
    L99:
        if (r110 == false) goto L102;
        r311.encodeNullableSerializableElement(r312, 10, w0.f520792a, r310.forceSpanCount);
    L102:
        if (r311.shouldEncodeElementDefault(r312, 11) == false) goto L105;
    L103:
        boolean r111 = true;
    L108:
        if (r111 == false) goto L111;
        r311.encodeBooleanElement(r312, 11, r310.isGridLayoutManager);
    L111:
        if (r311.shouldEncodeElementDefault(r312, 12) == false) goto L114;
    L112:
        boolean r112 = true;
    L117:
        if (r112 == false) goto L120;
        r311.encodeNullableSerializableElement(r312, 12, w0.f520792a, r310.itemGapSpacing);
    L120:
        if (r311.shouldEncodeElementDefault(r312, 13) == false) goto L123;
    L121:
        boolean r113 = true;
    L126:
        if (r113 == false) goto L129;
        r311.encodeNullableSerializableElement(r312, 13, w0.f520792a, r310.marginLeft);
    L129:
        if (r311.shouldEncodeElementDefault(r312, 14) == false) goto L132;
    L130:
        boolean r114 = true;
    L135:
        if (r114 == false) goto L138;
        r311.encodeNullableSerializableElement(r312, 14, w0.f520792a, r310.marginRight);
    L138:
        if (r311.shouldEncodeElementDefault(r312, 15) == false) goto L141;
    L139:
        boolean r115 = true;
    L144:
        if (r115 == false) goto L147;
        r311.encodeBooleanElement(r312, 15, r310.showUserInfo);
    L147:
        if (r311.shouldEncodeElementDefault(r312, 16) == false) goto L150;
    L148:
        boolean r116 = true;
    L153:
        if (r116 == false) goto L156;
        r311.encodeNullableSerializableElement(r312, 16, v2.f520790a, r310.creationRecommendType);
    L156:
        if (r311.shouldEncodeElementDefault(r312, 17) == false) goto L159;
    L157:
        boolean r117 = true;
    L162:
        if (r117 == false) goto L165;
        r311.encodeBooleanElement(r312, 17, r310.openNewChatPageOnSend);
    L165:
        if (r311.shouldEncodeElementDefault(r312, 18) == false) goto L168;
    L166:
        boolean r118 = true;
    L171:
        if (r118 == false) goto L174;
        r311.encodeBooleanElement(r312, 18, r310.needFocusHelper);
    L174:
        if (r311.shouldEncodeElementDefault(r312, 19) == false) goto L177;
    L175:
        boolean r119 = true;
    L180:
        if (r119 == false) goto L183;
        r311.encodeBooleanElement(r312, 19, r310.enableGapHandling);
    L183:
        if (r311.shouldEncodeElementDefault(r312, 20) == false) goto L186;
    L184:
        boolean r120 = true;
    L189:
        if (r120 == false) goto L192;
        r311.encodeNullableSerializableElement(r312, 20, w0.f520792a, r310.loadMoreDistance);
    L192:
        if (r311.shouldEncodeElementDefault(r312, 21) == false) goto L195;
    L193:
        boolean r121 = true;
    L198:
        if (r121 == false) goto L201;
        r311.encodeNullableSerializableElement(r312, 21, i.f520705a, r310.needAddReplicaEntrance);
    L201:
        if (r311.shouldEncodeElementDefault(r312, 22) == false) goto L204;
    L202:
        boolean r122 = true;
    L207:
        if (r122 == false) goto L210;
        r311.encodeNullableSerializableElement(r312, 22, w0.f520792a, r310.creationDoSameLandingType);
    L210:
        if (r311.shouldEncodeElementDefault(r312, 23) == false) goto L213;
    L211:
        boolean r123 = true;
    L216:
        if (r123 == false) goto L219;
        r311.encodeNullableSerializableElement(r312, 23, i.f520705a, r310.creationSendMessageFromDetail);
        return;
    L219:
        return;
    L213:
        if (Intrinsics.areEqual(r310.creationSendMessageFromDetail, Boolean.FALSE) == false) goto L211;
        r123 = false;
        goto L216
    L204:
        if (r310.creationDoSameLandingType != null) goto L202;
        r122 = false;
        goto L207
    L195:
        if (Intrinsics.areEqual(r310.needAddReplicaEntrance, Boolean.FALSE) == false) goto L193;
        r121 = false;
        goto L198
    L186:
        if (r310.loadMoreDistance != null) goto L184;
        r120 = false;
        goto L189
    L177:
        if (r310.enableGapHandling == true) goto L175;
        r119 = false;
        goto L180
    L168:
        if (r310.needFocusHelper == true) goto L166;
        r118 = false;
        goto L171
    L159:
        if (r310.openNewChatPageOnSend != true) goto L157;
        r117 = false;
        goto L162
    L150:
        if (r310.creationRecommendType != null) goto L148;
        r116 = false;
        goto L153
    L141:
        if (r310.showUserInfo != true) goto L139;
        r115 = false;
        goto L144
    L132:
        if (r310.marginRight != null) goto L130;
        r114 = false;
        goto L135
    L123:
        if (r310.marginLeft != null) goto L121;
        r113 = false;
        goto L126
    L114:
        if (r310.itemGapSpacing != null) goto L112;
        r112 = false;
        goto L117
    L105:
        if (r310.isGridLayoutManager == true) goto L103;
        r111 = false;
        goto L108
    L96:
        if (r310.forceSpanCount != null) goto L94;
        r110 = false;
        goto L99
    L87:
        if (r310.currentTabItemInfo != null) goto L85;
        r109 = false;
        goto L90
    L78:
        if (r310.disableEndView == true) goto L76;
        r108 = false;
        goto L81
    L69:
        if (r310.topPadding != null) goto L67;
        r107 = false;
        goto L72
    L60:
        if (r310.bottomPadding != null) goto L58;
        r106 = false;
        goto L63
    L51:
        if (r310.creationFeedType != null) goto L49;
        r105 = false;
        goto L54
    L41:
        String r124 = null;
        if (Intrinsics.areEqual(r310.trackParams, new CreationFeedTrackParamsKmp("", null, null, null, null, null, null, r124, r124, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194302, null)) == false) goto L40;
        r104 = false;
        goto L45
    L33:
        if (r310.disablePullRefresh == true) goto L31;
        r103 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r310.fpsTrackerTag, "") == false) goto L22;
        r102 = false;
        goto L27
    L15:
        if (r310.disableInitialAutoRefreshOnce == true) goto L13;
        r101 = false;
        goto L18
    L6:
        if (r310.forceRefreshIgnoreCache == true) goto L4;
        r100 = false;
        goto L9
    }

    public CreationFeedInitParamsKmp(boolean r100, boolean r101, String r102, boolean r103, CreationFeedTrackParamsKmp r104, Integer r110, Integer r111, Integer r112, boolean r113, TabItemInfoKmp r114, Integer r115, boolean r116, Integer r117, Integer r118, Integer r119, boolean r210, String r211, boolean r212, boolean r213, boolean r214, Integer r215, Boolean r216, Integer r217, Boolean r218) {
        Intrinsics.checkNotNullParameter(r102, "fpsTrackerTag");
        Intrinsics.checkNotNullParameter(r104, "trackParams");
        this.forceRefreshIgnoreCache = r100;
        this.disableInitialAutoRefreshOnce = r101;
        this.fpsTrackerTag = r102;
        this.disablePullRefresh = r103;
        this.trackParams = r104;
        this.creationFeedType = r110;
        this.bottomPadding = r111;
        this.topPadding = r112;
        this.disableEndView = r113;
        this.currentTabItemInfo = r114;
        this.forceSpanCount = r115;
        this.isGridLayoutManager = r116;
        this.itemGapSpacing = r117;
        this.marginLeft = r118;
        this.marginRight = r119;
        this.showUserInfo = r210;
        this.creationRecommendType = r211;
        this.openNewChatPageOnSend = r212;
        this.needFocusHelper = r213;
        this.enableGapHandling = r214;
        this.loadMoreDistance = r215;
        this.needAddReplicaEntrance = r216;
        this.creationDoSameLandingType = r217;
        this.creationSendMessageFromDetail = r218;
    }

    public CreationFeedInitParamsKmp(int r310, boolean r311, boolean r312, String r313, boolean r314, CreationFeedTrackParamsKmp r315, Integer r316, Integer r317, Integer r318, boolean r410, TabItemInfoKmp r411, Integer r412, boolean r413, Integer r414, Integer r415, Integer r416, boolean r417, String r418, boolean r419, boolean r510, boolean r511, Integer r512, Boolean r513, Integer r514, Boolean r515, q2 r516) {
        if ((r310 & 0) == 0) goto L5;
        b2.b(r310, 0, a.f374321b);
        throw null;
    L5:
        if ((r310 & 1) != 0) goto L7;
        this.forceRefreshIgnoreCache = false;
    L9:
        if ((r310 & 2) != 0) goto L11;
        this.disableInitialAutoRefreshOnce = false;
    L13:
        if ((r310 & 4) != 0) goto L15;
        String r100 = "";
    L16:
        this.fpsTrackerTag = r100;
        if ((r310 & 8) != 0) goto L19;
        this.disablePullRefresh = false;
    L21:
        if ((r310 & 16) != 0) goto L23;
        CreationFeedTrackParamsKmp r101 = new CreationFeedTrackParamsKmp("", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194302, null);
    L24:
        this.trackParams = r101;
        if ((r310 & 32) != 0) goto L27;
        this.creationFeedType = null;
    L29:
        if ((r310 & 64) != 0) goto L31;
        this.bottomPadding = null;
    L33:
        if ((r310 & 128) != 0) goto L35;
        this.topPadding = null;
    L37:
        if ((r310 & 256) != 0) goto L39;
        this.disableEndView = false;
    L41:
        if ((r310 & 512) != 0) goto L43;
        this.currentTabItemInfo = null;
    L45:
        if ((r310 & 1024) != 0) goto L47;
        this.forceSpanCount = null;
    L49:
        if ((r310 & 2048) != 0) goto L51;
        this.isGridLayoutManager = false;
    L53:
        if ((r310 & 4096) != 0) goto L55;
        this.itemGapSpacing = null;
    L57:
        if ((r310 & 8192) != 0) goto L59;
        this.marginLeft = null;
    L61:
        if ((r310 & 16384) != 0) goto L63;
        this.marginRight = null;
    L65:
        if ((32768 & r310) != 0) goto L67;
        this.showUserInfo = true;
    L69:
        if ((65536 & r310) != 0) goto L71;
        this.creationRecommendType = null;
    L73:
        if ((131072 & r310) != 0) goto L75;
        this.openNewChatPageOnSend = true;
    L77:
        if ((262144 & r310) != 0) goto L79;
        this.needFocusHelper = false;
    L81:
        if ((524288 & r310) != 0) goto L83;
        this.enableGapHandling = false;
    L85:
        if ((1048576 & r310) != 0) goto L87;
        this.loadMoreDistance = null;
    L89:
        if ((2097152 & r310) != 0) goto L91;
        Boolean r102 = Boolean.FALSE;
    L92:
        this.needAddReplicaEntrance = r102;
        if ((4194304 & r310) != 0) goto L95;
        this.creationDoSameLandingType = null;
    L97:
        if ((r310 & 8388608) != 0) goto L99;
        Boolean r103 = Boolean.FALSE;
    L100:
        this.creationSendMessageFromDetail = r103;
        return;
    L99:
        r103 = r515;
        goto L100
    L95:
        this.creationDoSameLandingType = r514;
        goto L97
    L91:
        r102 = r513;
        goto L92
    L87:
        this.loadMoreDistance = r512;
        goto L89
    L83:
        this.enableGapHandling = r511;
        goto L85
    L79:
        this.needFocusHelper = r510;
        goto L81
    L75:
        this.openNewChatPageOnSend = r419;
        goto L77
    L71:
        this.creationRecommendType = r418;
        goto L73
    L67:
        this.showUserInfo = r417;
        goto L69
    L63:
        this.marginRight = r416;
        goto L65
    L59:
        this.marginLeft = r415;
        goto L61
    L55:
        this.itemGapSpacing = r414;
        goto L57
    L51:
        this.isGridLayoutManager = r413;
        goto L53
    L47:
        this.forceSpanCount = r412;
        goto L49
    L43:
        this.currentTabItemInfo = r411;
        goto L45
    L39:
        this.disableEndView = r410;
        goto L41
    L35:
        this.topPadding = r318;
        goto L37
    L31:
        this.bottomPadding = r317;
        goto L33
    L27:
        this.creationFeedType = r316;
        goto L29
    L23:
        r101 = r315;
        goto L24
    L19:
        this.disablePullRefresh = r314;
        goto L21
    L15:
        r100 = r313;
        goto L16
    L11:
        this.disableInitialAutoRefreshOnce = r312;
        goto L13
    L7:
        this.forceRefreshIgnoreCache = r311;
        goto L9
    }

    public /* synthetic */ CreationFeedInitParamsKmp(boolean r310, boolean r311, String r312, boolean r313, CreationFeedTrackParamsKmp r314, Integer r315, Integer r316, Integer r410, boolean r411, TabItemInfoKmp r412, Integer r413, boolean r414, Integer r415, Integer r416, Integer r417, boolean r418, String r419, boolean r510, boolean r511, boolean r512, Integer r513, Boolean r514, Integer r515, Boolean r516, int r517, DefaultConstructorMarker r518) {
        if ((r517 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r517 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r517 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r517 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r517 & 16) == 0) goto L21;
        CreationFeedTrackParamsKmp r104 = new CreationFeedTrackParamsKmp("", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194302, null);
    L23:
        if ((r517 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r517 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r517 & 128) == 0) goto L33;
        Integer r110 = null;
    L35:
        if ((r517 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r517 & 512) == 0) goto L41;
        TabItemInfoKmp r112 = null;
    L43:
        if ((r517 & 1024) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r517 & 2048) == 0) goto L49;
        boolean r114 = false;
    L51:
        if ((r517 & 4096) == 0) goto L53;
        Integer r115 = null;
    L55:
        if ((r517 & 8192) == 0) goto L57;
        Integer r107 = null;
    L59:
        if ((r517 & 16384) == 0) goto L61;
        Integer r108 = null;
    L62:
        boolean r116 = true;
        if ((r517 & 32768) == 0) goto L65;
        boolean r117 = true;
    L67:
        if ((r517 & 65536) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r517 & 131072) != 0) goto L75;
        r116 = r510;
    L75:
        if ((r517 & 262144) == 0) goto L77;
        boolean r119 = false;
    L79:
        if ((r517 & 524288) == 0) goto L81;
        boolean r210 = false;
    L83:
        if ((r517 & 1048576) == 0) goto L85;
        Integer r211 = null;
    L87:
        if ((r517 & 2097152) == 0) goto L89;
        Boolean r212 = Boolean.FALSE;
    L91:
        if ((r517 & 4194304) == 0) goto L93;
        Integer r213 = null;
    L95:
        if ((r517 & 8388608) == 0) goto L97;
        Boolean r109 = Boolean.FALSE;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r117, r118, r116, r119, r210, r211, r212, r213, r109);
        return;
    L97:
        r109 = r516;
        goto L98
    L93:
        r213 = r515;
        goto L95
    L89:
        r212 = r514;
        goto L91
    L85:
        r211 = r513;
        goto L87
    L81:
        r210 = r512;
        goto L83
    L77:
        r119 = r511;
        goto L79
    L69:
        r118 = r419;
        goto L71
    L65:
        r117 = r418;
        goto L67
    L61:
        r108 = r417;
        goto L62
    L57:
        r107 = r416;
        goto L59
    L53:
        r115 = r415;
        goto L55
    L49:
        r114 = r414;
        goto L51
    L45:
        r113 = r413;
        goto L47
    L41:
        r112 = r412;
        goto L43
    L37:
        r111 = r411;
        goto L39
    L33:
        r110 = r410;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
