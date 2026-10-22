package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.obric.trace.ObricActionBarTrackType;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0080\u00012\u00060\u0001j\u0002`\u0002:\u0003\u007f\u0080\u0001B\u008b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dB÷\u0001\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010!J\t\u0010U\u001a\u00020\u0004HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0094\u0002\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010lJ\u0006\u0010m\u001a\u00020\tJ\u0013\u0010n\u001a\u00020\u00102\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020\tHÖ\u0001J\t\u0010r\u001a\u00020\u0004HÖ\u0001J\u0016\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\tJ%\u0010x\u001a\u00020t2\u0006\u0010y\u001a\u00020\u00002\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0001¢\u0006\u0002\b~R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010#\u001a\u0004\b+\u0010%R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\b,\u0010#\u001a\u0004\b-\u0010.R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010#\u001a\u0004\b1\u0010%R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010#\u001a\u0004\b3\u0010%R&\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010#\u001a\u0004\b5\u0010%\"\u0004\b6\u00107R&\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010#\u001a\u0004\b9\u0010%\"\u0004\b:\u00107R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010#\u001a\u0004\b<\u0010%R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010?\u0012\u0004\b=\u0010#\u001a\u0004\b\u000f\u0010>R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010#\u001a\u0004\bA\u0010%R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010#\u001a\u0004\bC\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010#\u001a\u0004\bE\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010#\u001a\u0004\bG\u0010%R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010?\u0012\u0004\bH\u0010#\u001a\u0004\b\u0015\u0010>R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010#\u001a\u0004\bJ\u0010%R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010#\u001a\u0004\bL\u0010%R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010#\u001a\u0004\bN\u0010%R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010#\u001a\u0004\bP\u0010%R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010#\u001a\u0004\bR\u0010%R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010#\u001a\u0004\bT\u0010%¨\u0006\u0081\u0001"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "currentPage", "", "recommendFrom", "botId", "conversationId", "actionBarTemplateId", "", "chatType", "enterFrom", "previousPage", "enterMethod", "aiCreationRecommendFrom", "isChatDoublePage", "", "currentPageKey", "templatePageType", "anchorCreationId", "douyinGid", "isFromAnchor", "promptType", "promptFrom", "visualSize", "tagCode", "wcbItemId", "recoRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCurrentPage$annotations", "()V", "getCurrentPage", "()Ljava/lang/String;", "getRecommendFrom$annotations", "getRecommendFrom", "getBotId$annotations", "getBotId", "getConversationId$annotations", "getConversationId", "getActionBarTemplateId$annotations", "getActionBarTemplateId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChatType$annotations", "getChatType", "getEnterFrom$annotations", "getEnterFrom", "getPreviousPage$annotations", "getPreviousPage", "setPreviousPage", "(Ljava/lang/String;)V", "getEnterMethod$annotations", "getEnterMethod", "setEnterMethod", "getAiCreationRecommendFrom$annotations", "getAiCreationRecommendFrom", "isChatDoublePage$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCurrentPageKey$annotations", "getCurrentPageKey", "getTemplatePageType$annotations", "getTemplatePageType", "getAnchorCreationId$annotations", "getAnchorCreationId", "getDouyinGid$annotations", "getDouyinGid", "isFromAnchor$annotations", "getPromptType$annotations", "getPromptType", "getPromptFrom$annotations", "getPromptFrom", "getVisualSize$annotations", "getVisualSize", "getTagCode$annotations", "getTagCode", "getWcbItemId$annotations", "getWcbItemId", "getRecoRequestId$annotations", "getRecoRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/ugc/feed/api/model/CreationFeedTrackParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CreationFeedTrackParamsKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationFeedTrackParamsKmp> CREATOR = null;
    public static final b Companion = null;
    private final Integer actionBarTemplateId;
    private final String aiCreationRecommendFrom;
    private final String anchorCreationId;
    private final String botId;
    private final String chatType;
    private final String conversationId;
    private final String currentPage;
    private final String currentPageKey;
    private final String douyinGid;
    private final String enterFrom;
    private String enterMethod;
    private final Boolean isChatDoublePage;
    private final Boolean isFromAnchor;
    private String previousPage;
    private final String promptFrom;
    private final String promptType;
    private final String recoRequestId;
    private final String recommendFrom;
    private final String tagCode;
    private final String templatePageType;
    private final String visualSize;
    private final String wcbItemId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationFeedTrackParamsKmp> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f374322a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f374323b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f374323b;
        }

        static {
            a r100 = new a();
            f374322a = r100;
            g2 r101 = new g2("com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp", r100, 22);
            r101.j("current_page", false);
            r101.j("recommend_from", true);
            r101.j("bot_id", true);
            r101.j("conversation_id", true);
            r101.j(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, true);
            r101.j("chat_type", true);
            r101.j("enter_from", true);
            r101.j("previous_page", true);
            r101.j("enter_method", true);
            r101.j("ai_creation_recommend_from", true);
            r101.j("is_chat_double_page", true);
            r101.j("current_page_key", true);
            r101.j("template_page_type", true);
            r101.j("anchor_creation_id", true);
            r101.j("douyin_gid", true);
            r101.j("is_from_anchor", true);
            r101.j("prompt_type", true);
            r101.j("prompt_from", true);
            r101.j("visual_size", true);
            r101.j("tag_code", true);
            r101.j("wcb_item_id", true);
            r101.j("reco_request_id", true);
            f374323b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            i r101 = i.f520705a;
            return new d[]{r100, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(w0.f520792a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f374323b;
            muc.c r101 = r510.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 7, r103, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 8, r103, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 9, r103, null);
            i r114 = i.f520705a;
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 10, r114, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 13, r103, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 14, r103, null);
            Boolean r119 = (Boolean) r101.decodeNullableSerializableElement(r100, 15, r114, null);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 16, r103, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 17, r103, null);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 18, r103, null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 19, r103, null);
            String r310 = (String) r101.decodeNullableSerializableElement(r100, 20, r103, null);
            String r210 = r107;
            String r311 = (String) r101.decodeNullableSerializableElement(r100, 21, r103, null);
            String r211 = r120;
            String r312 = r123;
            String r313 = r122;
            String r314 = r121;
            Boolean r212 = r119;
            String r213 = r118;
            String r124 = r105;
            String r214 = r106;
            String r215 = r108;
            String r125 = r104;
            Integer r126 = r112;
            String r127 = r113;
            String r128 = r102;
            int r129 = 4194303;
            String r216 = r117;
            Boolean r217 = r109;
            String r130 = r111;
            String r131 = r110;
            String r218 = r116;
            String r219 = r115;
        L53:
            r101.endStructure(r100);
            return new CreationFeedTrackParamsKmp(r129, r128, r131, r125, r130, r126, r127, r124, r214, r210, r215, r217, r219, r218, r216, r213, r212, r211, r314, r313, r312, r310, r311, null);
        L5:
            String r132 = null;
            String r133 = null;
            String r134 = null;
            String r135 = null;
            String r136 = null;
            Integer r410 = null;
            String r137 = null;
            String r138 = null;
            Boolean r139 = null;
            Boolean r140 = null;
            String r141 = null;
            String r142 = null;
            String r220 = null;
            String r221 = null;
            String r315 = null;
            String r316 = null;
            String r317 = null;
            String r411 = null;
            String r412 = null;
            String r413 = null;
            String r414 = null;
            String r415 = null;
            int r143 = 0;
            boolean r416 = true;
        L6:
            if (r416 == false) goto L52;
            int r144 = r101.decodeElementIndex(r100);
            switch(r144) {
                case -1: goto L50;
                case 0: goto L48;
                case 1: goto L46;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L41;
                case 5: goto L38;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L31;
                case 11: goto L28;
                case 12: goto L26;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L21;
                case 16: goto L19;
                case 17: goto L17;
                case 18: goto L15;
                case 19: goto L14;
                case 20: goto L12;
                case 21: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r144);
        L33:
            int r145 = r143 | 512;
            r412 = r412;
            String r146 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r414);
            r415 = r415;
        L40:
            String r147 = r146;
            r317 = r317;
        L42:
            r143 = r145;
            r221 = r221;
            r315 = r315;
            Integer r318 = r410;
            r414 = r147;
        L51:
            r414 = r414;
            r411 = r411;
            r135 = r135;
            r221 = r221;
            r410 = r318;
            r317 = r317;
            r412 = r412;
            r415 = r415;
            r316 = r316;
            r133 = r133;
            r132 = r132;
            r315 = r315;
            goto L6
        L34:
            r143 = r143 | 256;
            r316 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r316);
            r318 = r410;
        L49:
            r220 = r220;
            goto L51
        L35:
            r316 = r316;
            int r148 = r143 | 128;
            r412 = r412;
            r415 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r415);
        L39:
            r145 = r148;
            r146 = r414;
            goto L40
        L36:
            r415 = r415;
            r146 = r414;
            r412 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r412);
            r145 = r143 | 64;
            goto L40
        L38:
            r316 = r316;
            r415 = r415;
            r412 = r412;
            r317 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r317);
            r148 = r143 | 32;
            goto L39
        L41:
            r132 = r132;
            r133 = r133;
            r135 = r135;
            Integer r417 = r410;
            r316 = r316;
            r411 = r411;
            r412 = r412;
            r415 = r415;
            r317 = r317;
            r410 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r417);
            r147 = r414;
            r145 = r143 | 16;
            goto L42
        L43:
            String r149 = r315;
            r318 = r410;
            int r150 = r143 | 8;
            r315 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r149);
        L45:
            r221 = r221;
        L47:
            r143 = r150;
            goto L51
        L44:
            String r151 = r315;
            r318 = r410;
            r315 = r151;
            r221 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r221);
            r150 = r143 | 4;
            goto L45
        L46:
            r132 = r132;
            r133 = r133;
            r135 = r135;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r412 = r412;
            r414 = r414;
            r415 = r415;
            r318 = r410;
            r411 = r411;
            r221 = r221;
            r220 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r220);
            r150 = r143 | 2;
            goto L47
        L48:
            r316 = r316;
            r318 = r410;
            r413 = r101.decodeStringElement(r100, 0);
            r143 = r143 | 1;
            goto L49
        L50:
            r132 = r132;
            r133 = r133;
            r135 = r135;
            r221 = r221;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r412 = r412;
            r414 = r414;
            r415 = r415;
            r318 = r410;
            r411 = r411;
            r416 = false;
            goto L51
        L11:
            int r152 = 2097152;
            r135 = (String) r101.decodeNullableSerializableElement(r100, 21, v2.f520790a, r135);
        L13:
            int r153 = r152 | r143;
            String r154 = r411;
        L30:
            r143 = r153;
            String r155 = r154;
        L32:
            r411 = r155;
            r135 = r135;
            r410 = r410;
            goto L6
        L12:
            r135 = r135;
            r411 = (String) r101.decodeNullableSerializableElement(r100, 20, v2.f520790a, r411);
            r152 = 1048576;
            goto L13
        L14:
            r138 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r138);
            int r156 = 524288;
        L22:
            int r157 = r156 | r143;
        L29:
            int r418 = r157;
            r154 = r411;
            r153 = r418;
            goto L30
        L15:
            r136 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r136);
            r156 = 262144;
            goto L22
        L17:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r132 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r132);
            r156 = 131072;
            goto L22
        L19:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r141 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r141);
            r156 = 65536;
            goto L22
        L21:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r140 = (Boolean) r101.decodeNullableSerializableElement(r100, 15, i.f520705a, r140);
            r156 = 32768;
            goto L22
        L23:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r133 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r133);
            r157 = r143 | 16384;
            goto L29
        L24:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r142 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r142);
            r157 = r143 | 8192;
            goto L29
        L26:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r134 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r134);
            r157 = r143 | 4096;
            goto L29
        L28:
            r135 = r135;
            r410 = r410;
            r411 = r411;
            r137 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r137);
            r157 = r143 | 2048;
            goto L29
        L31:
            r135 = r135;
            r410 = r410;
            r155 = r411;
            r143 = r143 | 1024;
            r139 = (Boolean) r101.decodeNullableSerializableElement(r100, 10, i.f520705a, r139);
            goto L32
        L52:
            String r319 = r133;
            String r158 = r220;
            String r222 = r221;
            String r223 = r315;
            r218 = r134;
            r215 = r414;
            r313 = r136;
            r219 = r137;
            r217 = r139;
            r212 = r140;
            r211 = r141;
            r126 = r410;
            r127 = r317;
            r124 = r412;
            r214 = r415;
            r210 = r316;
            r314 = r132;
            r128 = r413;
            r131 = r158;
            r310 = r411;
            r312 = r138;
            r129 = r143;
            r311 = r135;
            r130 = r223;
            r213 = r319;
            r216 = r142;
            r125 = r222;
            goto L53
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            CreationFeedTrackParamsKmp r102 = (CreationFeedTrackParamsKmp) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f374323b;
            muc.d r104 = r100.beginStructure(r103);
            CreationFeedTrackParamsKmp.write$Self$feed_kmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationFeedTrackParamsKmp> serializer() {
            return a.f374322a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationFeedTrackParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedTrackParamsKmp createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            String r101 = r210.readString();
            String r102 = r210.readString();
            String r103 = r210.readString();
            if (r210.readInt() != 0) goto L5;
            Integer r104 = null;
        L6:
            String r105 = r210.readString();
            String r110 = r210.readString();
            String r111 = r210.readString();
            String r112 = r210.readString();
            String r113 = r210.readString();
            boolean r114 = false;
            if (r210.readInt() != 0) goto L10;
            Boolean r115 = null;
        L14:
            String r116 = r210.readString();
            String r117 = r210.readString();
            String r211 = r210.readString();
            String r212 = r210.readString();
            if (r210.readInt() != 0) goto L18;
            Boolean r213 = null;
        L22:
            return new CreationFeedTrackParamsKmp(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r115, r116, r117, r211, r212, r213, r210.readString(), r210.readString(), r210.readString(), r210.readString(), r210.readString(), r210.readString());
        L18:
            if (r210.readInt() == 0) goto L20;
            r114 = true;
        L20:
            r213 = Boolean.valueOf(r114);
            goto L22
        L10:
            if (r210.readInt() == 0) goto L12;
            boolean r106 = true;
        L13:
            r115 = Boolean.valueOf(r106);
            goto L14
        L12:
            r106 = false;
            goto L13
        L5:
            r104 = Integer.valueOf(r210.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedTrackParamsKmp[] newArray(int r100) {
            return new CreationFeedTrackParamsKmp[r100];
        }
    }

    public static /* synthetic */ CreationFeedTrackParamsKmp copy$default(CreationFeedTrackParamsKmp r110, String r111, String r112, String r210, String r211, Integer r212, String r213, String r214, String r215, String r216, String r217, Boolean r218, String r219, String r310, String r311, String r312, Boolean r313, String r314, String r315, String r316, String r317, String r318, String r319, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = r110.currentPage;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = r110.recommendFrom;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = r110.botId;
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = r110.conversationId;
    L19:
        if ((r410 & 16) == 0) goto L21;
        Integer r104 = r110.actionBarTemplateId;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = r110.chatType;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r106 = r110.enterFrom;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r107 = r110.previousPage;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r113 = r110.enterMethod;
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r114 = r110.aiCreationRecommendFrom;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Boolean r115 = r110.isChatDoublePage;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r116 = r110.currentPageKey;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r117 = r110.templatePageType;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r118 = r110.anchorCreationId;
    L58:
        String r320 = r118;
        if ((r410 & 16384) == 0) goto L61;
        String r119 = r110.douyinGid;
    L62:
        String r321 = r119;
        if ((r410 & 32768) == 0) goto L65;
        Boolean r120 = r110.isFromAnchor;
    L66:
        Boolean r322 = r120;
        if ((r410 & 65536) == 0) goto L69;
        String r121 = r110.promptType;
    L70:
        String r323 = r121;
        if ((r410 & 131072) == 0) goto L73;
        String r122 = r110.promptFrom;
    L74:
        String r324 = r122;
        if ((r410 & 262144) == 0) goto L77;
        String r123 = r110.visualSize;
    L78:
        String r325 = r123;
        if ((r410 & 524288) == 0) goto L81;
        String r124 = r110.tagCode;
    L82:
        String r326 = r124;
        if ((r410 & 1048576) == 0) goto L85;
        String r125 = r110.wcbItemId;
    L87:
        if ((r410 & 2097152) == 0) goto L89;
        String r108 = r110.recoRequestId;
    L91:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r125, r108);
    L89:
        r108 = r319;
        goto L91
    L85:
        r125 = r318;
        goto L87
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

    @SerialName(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID)
    public static /* synthetic */ void getActionBarTemplateId$annotations() {
    }

    @SerialName("ai_creation_recommend_from")
    public static /* synthetic */ void getAiCreationRecommendFrom$annotations() {
    }

    @SerialName("anchor_creation_id")
    public static /* synthetic */ void getAnchorCreationId$annotations() {
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("chat_type")
    public static /* synthetic */ void getChatType$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("current_page")
    public static /* synthetic */ void getCurrentPage$annotations() {
    }

    @SerialName("current_page_key")
    public static /* synthetic */ void getCurrentPageKey$annotations() {
    }

    @SerialName("douyin_gid")
    public static /* synthetic */ void getDouyinGid$annotations() {
    }

    @SerialName("enter_from")
    public static /* synthetic */ void getEnterFrom$annotations() {
    }

    @SerialName("enter_method")
    public static /* synthetic */ void getEnterMethod$annotations() {
    }

    @SerialName("previous_page")
    public static /* synthetic */ void getPreviousPage$annotations() {
    }

    @SerialName("prompt_from")
    public static /* synthetic */ void getPromptFrom$annotations() {
    }

    @SerialName("prompt_type")
    public static /* synthetic */ void getPromptType$annotations() {
    }

    @SerialName("reco_request_id")
    public static /* synthetic */ void getRecoRequestId$annotations() {
    }

    @SerialName("recommend_from")
    public static /* synthetic */ void getRecommendFrom$annotations() {
    }

    @SerialName("tag_code")
    public static /* synthetic */ void getTagCode$annotations() {
    }

    @SerialName("template_page_type")
    public static /* synthetic */ void getTemplatePageType$annotations() {
    }

    @SerialName("visual_size")
    public static /* synthetic */ void getVisualSize$annotations() {
    }

    @SerialName("wcb_item_id")
    public static /* synthetic */ void getWcbItemId$annotations() {
    }

    @SerialName("is_chat_double_page")
    public static /* synthetic */ void isChatDoublePage$annotations() {
    }

    @SerialName("is_from_anchor")
    public static /* synthetic */ void isFromAnchor$annotations() {
    }

    public final String component1() {
        return this.currentPage;
    }

    public final String component10() {
        return this.aiCreationRecommendFrom;
    }

    public final Boolean component11() {
        return this.isChatDoublePage;
    }

    public final String component12() {
        return this.currentPageKey;
    }

    public final String component13() {
        return this.templatePageType;
    }

    public final String component14() {
        return this.anchorCreationId;
    }

    public final String component15() {
        return this.douyinGid;
    }

    public final Boolean component16() {
        return this.isFromAnchor;
    }

    public final String component17() {
        return this.promptType;
    }

    public final String component18() {
        return this.promptFrom;
    }

    public final String component19() {
        return this.visualSize;
    }

    public final String component2() {
        return this.recommendFrom;
    }

    public final String component20() {
        return this.tagCode;
    }

    public final String component21() {
        return this.wcbItemId;
    }

    public final String component22() {
        return this.recoRequestId;
    }

    public final String component3() {
        return this.botId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final Integer component5() {
        return this.actionBarTemplateId;
    }

    public final String component6() {
        return this.chatType;
    }

    public final String component7() {
        return this.enterFrom;
    }

    public final String component8() {
        return this.previousPage;
    }

    public final String component9() {
        return this.enterMethod;
    }

    public final CreationFeedTrackParamsKmp copy(String r210, String r211, String r212, String r213, Integer r310, String r311, String r312, String r313, String r314, String r315, Boolean r316, String r317, String r318, String r319, String r410, Boolean r411, String r412, String r413, String r414, String r415, String r416, String r417) {
        Intrinsics.checkNotNullParameter(r210, "currentPage");
        return new CreationFeedTrackParamsKmp(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationFeedTrackParamsKmp) == true) goto L8;
        return false;
    L8:
        CreationFeedTrackParamsKmp r101 = (CreationFeedTrackParamsKmp) r100;
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recommendFrom, r101.recommendFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionBarTemplateId, r101.actionBarTemplateId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chatType, r101.chatType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.aiCreationRecommendFrom, r101.aiCreationRecommendFrom) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isChatDoublePage, r101.isChatDoublePage) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.currentPageKey, r101.currentPageKey) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.templatePageType, r101.templatePageType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.anchorCreationId, r101.anchorCreationId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.douyinGid, r101.douyinGid) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.isFromAnchor, r101.isFromAnchor) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.promptType, r101.promptType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.promptFrom, r101.promptFrom) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.visualSize, r101.visualSize) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.tagCode, r101.tagCode) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.wcbItemId, r101.wcbItemId) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.recoRequestId, r101.recoRequestId) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        int r100 = this.currentPage.hashCode() * 31;
        String r101 = this.recommendFrom;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.botId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.conversationId;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.actionBarTemplateId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.chatType;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.enterFrom;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.previousPage;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.enterMethod;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.aiCreationRecommendFrom;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Boolean r129 = this.isChatDoublePage;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.currentPageKey;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.templatePageType;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        String r138 = this.anchorCreationId;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        String r141 = this.douyinGid;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        Boolean r144 = this.isFromAnchor;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        String r147 = this.promptType;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        String r150 = this.promptFrom;
        if (r150 != null) goto L69;
        int r151 = 0;
    L70:
        int r152 = (r149 + r151) * 31;
        String r153 = this.visualSize;
        if (r153 != null) goto L73;
        int r154 = 0;
    L74:
        int r155 = (r152 + r154) * 31;
        String r156 = this.tagCode;
        if (r156 != null) goto L77;
        int r157 = 0;
    L78:
        int r158 = (r155 + r157) * 31;
        String r159 = this.wcbItemId;
        if (r159 != null) goto L81;
        int r160 = 0;
    L82:
        int r161 = (r158 + r160) * 31;
        String r162 = this.recoRequestId;
        if (r162 == null) goto L87;
        r102 = r162.hashCode();
    L87:
        return r161 + r102;
    L81:
        r160 = r159.hashCode();
        goto L82
    L77:
        r157 = r156.hashCode();
        goto L78
    L73:
        r154 = r153.hashCode();
        goto L74
    L69:
        r151 = r150.hashCode();
        goto L70
    L65:
        r148 = r147.hashCode();
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationFeedTrackParamsKmp(currentPage=" + this.currentPage + ", recommendFrom=" + this.recommendFrom + ", botId=" + this.botId + ", conversationId=" + this.conversationId + ", actionBarTemplateId=" + this.actionBarTemplateId + ", chatType=" + this.chatType + ", enterFrom=" + this.enterFrom + ", previousPage=" + this.previousPage + ", enterMethod=" + this.enterMethod + ", aiCreationRecommendFrom=" + this.aiCreationRecommendFrom + ", isChatDoublePage=" + this.isChatDoublePage + ", currentPageKey=" + this.currentPageKey + ", templatePageType=" + this.templatePageType + ", anchorCreationId=" + this.anchorCreationId + ", douyinGid=" + this.douyinGid + ", isFromAnchor=" + this.isFromAnchor + ", promptType=" + this.promptType + ", promptFrom=" + this.promptFrom + ", visualSize=" + this.visualSize + ", tagCode=" + this.tagCode + ", wcbItemId=" + this.wcbItemId + ", recoRequestId=" + this.recoRequestId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.currentPage);
        r100.writeString(this.recommendFrom);
        r100.writeString(this.botId);
        r100.writeString(this.conversationId);
        Integer r102 = this.actionBarTemplateId;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.chatType);
        r100.writeString(this.enterFrom);
        r100.writeString(this.previousPage);
        r100.writeString(this.enterMethod);
        r100.writeString(this.aiCreationRecommendFrom);
        Boolean r103 = this.isChatDoublePage;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.currentPageKey);
        r100.writeString(this.templatePageType);
        r100.writeString(this.anchorCreationId);
        r100.writeString(this.douyinGid);
        Boolean r104 = this.isFromAnchor;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeString(this.promptType);
        r100.writeString(this.promptFrom);
        r100.writeString(this.visualSize);
        r100.writeString(this.tagCode);
        r100.writeString(this.wcbItemId);
        r100.writeString(this.recoRequestId);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
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

    public final Integer getActionBarTemplateId() {
        return this.actionBarTemplateId;
    }

    public final String getAiCreationRecommendFrom() {
        return this.aiCreationRecommendFrom;
    }

    public final String getAnchorCreationId() {
        return this.anchorCreationId;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getChatType() {
        return this.chatType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final String getCurrentPageKey() {
        return this.currentPageKey;
    }

    public final String getDouyinGid() {
        return this.douyinGid;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getPromptFrom() {
        return this.promptFrom;
    }

    public final String getPromptType() {
        return this.promptType;
    }

    public final String getRecoRequestId() {
        return this.recoRequestId;
    }

    public final String getRecommendFrom() {
        return this.recommendFrom;
    }

    public final String getTagCode() {
        return this.tagCode;
    }

    public final String getTemplatePageType() {
        return this.templatePageType;
    }

    public final String getVisualSize() {
        return this.visualSize;
    }

    public final String getWcbItemId() {
        return this.wcbItemId;
    }

    public final Boolean isChatDoublePage() {
        return this.isChatDoublePage;
    }

    public final Boolean isFromAnchor() {
        return this.isFromAnchor;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationFeedTrackParamsKmp r100, muc.d r101, f r102) {
        boolean r103 = false;
        r101.encodeStringElement(r102, 0, r100.currentPage);
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.recommendFrom);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.botId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.conversationId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.actionBarTemplateId);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.chatType);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.enterFrom);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.previousPage);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 8, v2.f520790a, r100.enterMethod);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.aiCreationRecommendFrom);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 10, i.f520705a, r100.isChatDoublePage);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 11, v2.f520790a, r100.currentPageKey);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 12, v2.f520790a, r100.templatePageType);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 13, v2.f520790a, r100.anchorCreationId);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r101.encodeNullableSerializableElement(r102, 14, v2.f520790a, r100.douyinGid);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 15) == false) goto L132;
    L130:
        boolean r118 = true;
    L135:
        if (r118 == false) goto L138;
        r101.encodeNullableSerializableElement(r102, 15, i.f520705a, r100.isFromAnchor);
    L138:
        if (r101.shouldEncodeElementDefault(r102, 16) == false) goto L141;
    L139:
        boolean r119 = true;
    L144:
        if (r119 == false) goto L147;
        r101.encodeNullableSerializableElement(r102, 16, v2.f520790a, r100.promptType);
    L147:
        if (r101.shouldEncodeElementDefault(r102, 17) == false) goto L150;
    L148:
        boolean r120 = true;
    L153:
        if (r120 == false) goto L156;
        r101.encodeNullableSerializableElement(r102, 17, v2.f520790a, r100.promptFrom);
    L156:
        if (r101.shouldEncodeElementDefault(r102, 18) == false) goto L159;
    L157:
        boolean r121 = true;
    L162:
        if (r121 == false) goto L165;
        r101.encodeNullableSerializableElement(r102, 18, v2.f520790a, r100.visualSize);
    L165:
        if (r101.shouldEncodeElementDefault(r102, 19) == false) goto L168;
    L166:
        boolean r122 = true;
    L171:
        if (r122 == false) goto L174;
        r101.encodeNullableSerializableElement(r102, 19, v2.f520790a, r100.tagCode);
    L174:
        if (r101.shouldEncodeElementDefault(r102, 20) == false) goto L177;
    L175:
        boolean r123 = true;
    L180:
        if (r123 == false) goto L183;
        r101.encodeNullableSerializableElement(r102, 20, v2.f520790a, r100.wcbItemId);
    L183:
        if (r101.shouldEncodeElementDefault(r102, 21) == false) goto L186;
    L184:
        r103 = true;
    L188:
        if (r103 == false) goto L191;
        r101.encodeNullableSerializableElement(r102, 21, v2.f520790a, r100.recoRequestId);
        return;
    L191:
        return;
    L186:
        if (r100.recoRequestId == null) goto L188;
    L177:
        if (r100.wcbItemId != null) goto L175;
        r123 = false;
        goto L180
    L168:
        if (r100.tagCode != null) goto L166;
        r122 = false;
        goto L171
    L159:
        if (r100.visualSize != null) goto L157;
        r121 = false;
        goto L162
    L150:
        if (r100.promptFrom != null) goto L148;
        r120 = false;
        goto L153
    L141:
        if (r100.promptType != null) goto L139;
        r119 = false;
        goto L144
    L132:
        if (Intrinsics.areEqual(r100.isFromAnchor, Boolean.FALSE) == false) goto L130;
        r118 = false;
        goto L135
    L123:
        if (r100.douyinGid != null) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r100.anchorCreationId != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.templatePageType != null) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.currentPageKey != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (Intrinsics.areEqual(r100.isChatDoublePage, Boolean.FALSE) == false) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.aiCreationRecommendFrom != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.enterMethod != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.previousPage != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.enterFrom != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.chatType != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.actionBarTemplateId != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.conversationId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.botId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.recommendFrom != null) goto L4;
        r104 = false;
        goto L9
    }

    public CreationFeedTrackParamsKmp(String r100, String r101, String r102, String r103, Integer r104, String r105, String r110, String r111, String r112, String r113, Boolean r114, String r115, String r116, String r117, String r118, Boolean r119, String r210, String r211, String r212, String r213, String r214, String r215) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        this.currentPage = r100;
        this.recommendFrom = r101;
        this.botId = r102;
        this.conversationId = r103;
        this.actionBarTemplateId = r104;
        this.chatType = r105;
        this.enterFrom = r110;
        this.previousPage = r111;
        this.enterMethod = r112;
        this.aiCreationRecommendFrom = r113;
        this.isChatDoublePage = r114;
        this.currentPageKey = r115;
        this.templatePageType = r116;
        this.anchorCreationId = r117;
        this.douyinGid = r118;
        this.isFromAnchor = r119;
        this.promptType = r210;
        this.promptFrom = r211;
        this.visualSize = r212;
        this.tagCode = r213;
        this.wcbItemId = r214;
        this.recoRequestId = r215;
    }

    public CreationFeedTrackParamsKmp(int r100, String r101, String r102, String r103, String r110, Integer r111, String r112, String r113, String r114, String r115, String r116, Boolean r117, String r118, String r119, String r210, String r211, Boolean r212, String r213, String r214, String r215, String r216, String r217, String r218, q2 r219) {
        if (1 != (r100 & 1)) goto L89;
        this.currentPage = r101;
        if ((r100 & 2) != 0) goto L7;
        this.recommendFrom = null;
    L9:
        if ((r100 & 4) != 0) goto L11;
        this.botId = null;
    L13:
        if ((r100 & 8) != 0) goto L15;
        this.conversationId = null;
    L17:
        if ((r100 & 16) != 0) goto L19;
        this.actionBarTemplateId = null;
    L21:
        if ((r100 & 32) != 0) goto L23;
        this.chatType = null;
    L25:
        if ((r100 & 64) != 0) goto L27;
        this.enterFrom = null;
    L29:
        if ((r100 & 128) != 0) goto L31;
        this.previousPage = null;
    L33:
        if ((r100 & 256) != 0) goto L35;
        this.enterMethod = null;
    L37:
        if ((r100 & 512) != 0) goto L39;
        this.aiCreationRecommendFrom = null;
    L41:
        if ((r100 & 1024) != 0) goto L43;
        Boolean r104 = Boolean.FALSE;
    L44:
        this.isChatDoublePage = r104;
        if ((r100 & 2048) != 0) goto L47;
        this.currentPageKey = null;
    L49:
        if ((r100 & 4096) != 0) goto L51;
        this.templatePageType = null;
    L53:
        if ((r100 & 8192) != 0) goto L55;
        this.anchorCreationId = null;
    L57:
        if ((r100 & 16384) != 0) goto L59;
        this.douyinGid = null;
    L61:
        if ((32768 & r100) != 0) goto L63;
        Boolean r105 = Boolean.FALSE;
    L64:
        this.isFromAnchor = r105;
        if ((65536 & r100) != 0) goto L67;
        this.promptType = null;
    L69:
        if ((131072 & r100) != 0) goto L71;
        this.promptFrom = null;
    L73:
        if ((262144 & r100) != 0) goto L75;
        this.visualSize = null;
    L77:
        if ((524288 & r100) != 0) goto L79;
        this.tagCode = null;
    L81:
        if ((1048576 & r100) != 0) goto L83;
        this.wcbItemId = null;
    L85:
        if ((r100 & 2097152) != 0) goto L87;
        this.recoRequestId = null;
        return;
    L87:
        this.recoRequestId = r218;
        return;
    L83:
        this.wcbItemId = r217;
        goto L85
    L79:
        this.tagCode = r216;
        goto L81
    L75:
        this.visualSize = r215;
        goto L77
    L71:
        this.promptFrom = r214;
        goto L73
    L67:
        this.promptType = r213;
        goto L69
    L63:
        r105 = r212;
        goto L64
    L59:
        this.douyinGid = r211;
        goto L61
    L55:
        this.anchorCreationId = r210;
        goto L57
    L51:
        this.templatePageType = r119;
        goto L53
    L47:
        this.currentPageKey = r118;
        goto L49
    L43:
        r104 = r117;
        goto L44
    L39:
        this.aiCreationRecommendFrom = r116;
        goto L41
    L35:
        this.enterMethod = r115;
        goto L37
    L31:
        this.previousPage = r114;
        goto L33
    L27:
        this.enterFrom = r113;
        goto L29
    L23:
        this.chatType = r112;
        goto L25
    L19:
        this.actionBarTemplateId = r111;
        goto L21
    L15:
        this.conversationId = r110;
        goto L17
    L11:
        this.botId = r103;
        goto L13
    L7:
        this.recommendFrom = r102;
        goto L9
    L89:
        b2.b(r100, 1, a.f374323b);
        throw null;
    }

    public /* synthetic */ CreationFeedTrackParamsKmp(String r210, String r211, String r212, String r213, Integer r214, String r215, String r310, String r311, String r312, String r313, Boolean r314, String r315, String r316, String r317, String r318, Boolean r319, String r410, String r411, String r412, String r413, String r414, String r415, int r416, DefaultConstructorMarker r417) {
        String r100 = null;
        if ((r416 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r416 & 4) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r416 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r416 & 16) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r416 & 32) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r416 & 64) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r416 & 128) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r416 & 256) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r416 & 512) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r416 & 1024) == 0) goto L41;
        Boolean r111 = Boolean.FALSE;
    L43:
        if ((r416 & 2048) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r416 & 4096) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r416 & 8192) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r416 & 16384) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r416 & 32768) == 0) goto L61;
        Boolean r116 = Boolean.FALSE;
    L63:
        if ((r416 & 65536) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r416 & 131072) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r416 & 262144) == 0) goto L73;
        String r119 = null;
    L75:
        if ((r416 & 524288) == 0) goto L77;
        String r216 = null;
    L79:
        if ((r416 & 1048576) == 0) goto L81;
        String r217 = null;
    L83:
        if ((r416 & 2097152) != 0) goto L86;
        r100 = r415;
    L86:
        this(r210, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217, r100);
        return;
    L81:
        r217 = r414;
        goto L83
    L77:
        r216 = r413;
        goto L79
    L73:
        r119 = r412;
        goto L75
    L69:
        r118 = r411;
        goto L71
    L65:
        r117 = r410;
        goto L67
    L61:
        r116 = r319;
        goto L63
    L57:
        r115 = r318;
        goto L59
    L53:
        r114 = r317;
        goto L55
    L49:
        r113 = r316;
        goto L51
    L45:
        r112 = r315;
        goto L47
    L41:
        r111 = r314;
        goto L43
    L37:
        r110 = r313;
        goto L39
    L33:
        r108 = r312;
        goto L35
    L29:
        r107 = r311;
        goto L31
    L25:
        r106 = r310;
        goto L27
    L21:
        r105 = r215;
        goto L23
    L17:
        r104 = r214;
        goto L19
    L13:
        r103 = r213;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
