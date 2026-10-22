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
import kotlinx.serialization.Transient;
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
import yc9.c1;
import yc9.s;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001Bý\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bBñ\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001a\u0010!J\n\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010n\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010w\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0084\u0002\u0010z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010{J\u0013\u0010|\u001a\u00020\u001e2\b\u0010}\u001a\u0004\u0018\u00010~HÖ\u0003J\t\u0010\u007f\u001a\u00020\rHÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0005HÖ\u0001J-\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00002\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0001¢\u0006\u0003\b\u0088\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010)R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010#\u001a\u0004\b+\u0010)R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010#\u001a\u0004\b-\u0010)R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010#\u001a\u0004\b/\u0010)R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010#\u001a\u0004\b1\u00102R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010#\u001a\u0004\b4\u0010)R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b5\u0010#\u001a\u0004\b6\u00107R \u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b9\u0010#\u001a\u0004\b:\u00107R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010#\u001a\u0004\b<\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010#\u001a\u0004\b>\u0010)R \u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b?\u0010#\u001a\u0004\b@\u00107R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010#\u001a\u0004\bB\u0010)R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010#\u001a\u0004\bD\u0010)R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010#\u001a\u0004\bF\u0010)R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010#\u001a\u0004\bH\u0010)R \u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\bI\u0010#\u001a\u0004\bJ\u00107R \u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\bK\u0010#\u001a\u0004\bL\u00107R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010#\u001a\u0004\bN\u0010)R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010#\u001a\u0004\bP\u0010)R,\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bS\u0010#\u001a\u0004\bT\u00102\"\u0004\bU\u0010VR&\u0010W\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bY\u0010#\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u00020b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bc\u0010#\u001a\u0004\bd\u0010e¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/im/bean/message/SearchImageInfo;", "Lcom/larus/im/bean/message/ItemData;", "cardId", "", "itemId", "", "uri", "thumbUrl", "originThumbUrl", "fullSizeUrl", "", "mainSiteUrl", "width", "", "height", "docId", "authorShortId", "sourceFrom", "sourceAppName", "sourceAppIcon", "imgCaption", "caption", "originWidth", "originHeight", "imageSource", "searchId", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "isPlaceHolder", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardId$annotations", "()V", "getCardId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemId$annotations", "getItemId", "()Ljava/lang/String;", "getUri$annotations", "getUri", "getThumbUrl$annotations", "getThumbUrl", "getOriginThumbUrl$annotations", "getOriginThumbUrl", "getFullSizeUrl$annotations", "getFullSizeUrl", "()Ljava/util/List;", "getMainSiteUrl$annotations", "getMainSiteUrl", "getWidth$annotations", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight$annotations", "getHeight", "getDocId$annotations", "getDocId", "getAuthorShortId$annotations", "getAuthorShortId", "getSourceFrom$annotations", "getSourceFrom", "getSourceAppName$annotations", "getSourceAppName", "getSourceAppIcon$annotations", "getSourceAppIcon", "getImgCaption$annotations", "getImgCaption", "getCaption$annotations", "getCaption", "getOriginWidth$annotations", "getOriginWidth", "getOriginHeight$annotations", "getOriginHeight", "getImageSource$annotations", "getImageSource", "getSearchId$annotations", "getSearchId", "getId", "foldImageInfoList", "getFoldImageInfoList$annotations", "getFoldImageInfoList", "setFoldImageInfoList", "(Ljava/util/List;)V", "displaySetting", "Lcom/larus/im/bean/message/ImageDisplaySetting;", "getDisplaySetting$annotations", "getDisplaySetting", "()Lcom/larus/im/bean/message/ImageDisplaySetting;", "setDisplaySetting", "(Lcom/larus/im/bean/message/ImageDisplaySetting;)V", "()Z", "setPlaceHolder", "(Z)V", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType$annotations", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/im/bean/message/SearchImageInfo;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchImageInfo extends ItemData {
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346707d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<SearchImageInfo> f346708a;
    private final String authorShortId;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient s f346709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ItemType f346710c;
    private final String caption;
    private final Long cardId;
    private final String docId;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> fullSizeUrl;
    private final Integer height;
    private final String imageSource;
    private final String imgCaption;
    private boolean isPlaceHolder;
    private final String itemId;
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
    public /* synthetic */ class a implements m0<SearchImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346711a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346712b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346712b;
        }

        static {
            a r100 = new a();
            f346711a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.SearchImageInfo", r100, 21);
            r101.j("id", true);
            r101.j("item_id", true);
            r101.j("uri", true);
            r101.j("thumb_url", true);
            r101.j("origin_thumb_url", true);
            r101.j("full_size_url", true);
            r101.j("main_site_url", true);
            r101.j("width", true);
            r101.j("height", true);
            r101.j("doc_id", true);
            r101.j("author_short_id", true);
            r101.j("source_from", true);
            r101.j("source_app_name", true);
            r101.j("source_app_icon", true);
            r101.j("img_caption", true);
            r101.j("caption", true);
            r101.j("origin_width", true);
            r101.j("origin_height", true);
            r101.j("image_source", true);
            r101.j("search_id", true);
            r101.j("isPlaceHolder", true);
            f346712b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = SearchImageInfo.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new d[]{kuc.a.d(g1.f520681a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[5].getValue()), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), i.f520705a};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r410) {
            Intrinsics.checkNotNullParameter(r410, "decoder");
            g2 r100 = f346712b;
            muc.c r101 = r410.beginStructure(r100);
            Lazy[] r102 = SearchImageInfo.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            Long r103 = (Long) r101.decodeNullableSerializableElement(r100, 0, g1.f520681a, null);
            v2 r110 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r110, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 2, r110, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 3, r110, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 4, r110, null);
            List r105 = (List) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 6, r110, null);
            w0 r114 = w0.f520792a;
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 7, r114, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r114, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 9, r110, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 10, r110, null);
            Integer r116 = (Integer) r101.decodeNullableSerializableElement(r100, 11, r114, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 12, r110, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 13, r110, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 14, r110, null);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 15, r110, null);
            Integer r121 = (Integer) r101.decodeNullableSerializableElement(r100, 16, r114, null);
            Integer r122 = (Integer) r101.decodeNullableSerializableElement(r100, 17, r114, null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 18, r110, null);
            String r310 = (String) r101.decodeNullableSerializableElement(r100, 19, r110, null);
            boolean r311 = r101.decodeBooleanElement(r100, 20);
            String r124 = r111;
            String r312 = r123;
            String r125 = r113;
            Integer r313 = r122;
            Integer r314 = r121;
            String r315 = r120;
            String r210 = r119;
            String r211 = r118;
            String r212 = r117;
            Integer r213 = r116;
            List r214 = r105;
            int r126 = 2097151;
            Long r127 = r103;
            String r215 = r106;
            Integer r216 = r107;
            String r217 = r109;
            String r218 = r115;
            String r128 = r104;
            Integer r219 = r108;
            String r129 = r112;
        L53:
            r101.endStructure(r100);
            return new SearchImageInfo(r126, r127, r124, r129, r125, r128, r214, r215, r216, r219, r217, r218, r213, r212, r211, r210, r315, r314, r313, r312, r310, r311, null);
        L5:
            int r130 = 20;
            String r131 = null;
            Integer r132 = null;
            String r133 = null;
            String r134 = null;
            List r135 = null;
            Integer r136 = null;
            String r137 = null;
            String r138 = null;
            String r139 = null;
            String r140 = null;
            String r220 = null;
            Long r221 = null;
            String r222 = null;
            String r316 = null;
            Integer r317 = null;
            Integer r318 = null;
            Integer r319 = null;
            String r411 = null;
            String r412 = null;
            String r413 = null;
            int r141 = 0;
            boolean r142 = false;
            boolean r414 = true;
        L6:
            if (r414 == false) goto L52;
            boolean r415 = r142;
            int r143 = r101.decodeElementIndex(r100);
            switch(r143) {
                case -1: goto L50;
                case 0: goto L46;
                case 1: goto L44;
                case 2: goto L43;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L37;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L31;
                case 9: goto L30;
                case 10: goto L28;
                case 11: goto L26;
                case 12: goto L23;
                case 13: goto L21;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L14;
                case 18: goto L13;
                case 19: goto L12;
                case 20: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r143);
        L43:
            String r144 = r220;
            String r223 = r316;
            String r145 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r144);
            r141 = r141 | 4;
        L51:
            r317 = r317;
            r413 = r413;
            r134 = r134;
            r318 = r318;
            r412 = r412;
            r411 = r411;
            r133 = r133;
            r316 = r223;
            r222 = r222;
            r102 = r102;
            r319 = r319;
            r142 = r415;
            r220 = r145;
            r221 = r221;
            r131 = r131;
            r130 = 20;
            goto L6
        L50:
            String r224 = r220;
            r223 = r316;
            r145 = r224;
            r414 = false;
            goto L51
        L11:
            r141 = r141 | 1048576;
            r102 = r102;
            r415 = r101.decodeBooleanElement(r100, r130);
            String r225 = r220;
            String r146 = r222;
            String r226 = r316;
            Integer r147 = r317;
            r318 = r318;
            r319 = r319;
            r411 = r411;
            r412 = r412;
            String r227 = r413;
        L49:
            r222 = r146;
            r317 = r147;
            r318 = r318;
            r412 = r412;
            r411 = r411;
            r413 = r227;
            r316 = r226;
            r102 = r102;
            r319 = r319;
            r142 = r415;
            r130 = 20;
            r220 = r225;
            goto L6
        L12:
            r137 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r137);
            int r148 = r141 | 524288;
        L27:
            Integer r149 = r319;
        L32:
            r319 = r149;
        L33:
            Integer r150 = r317;
        L36:
            List r151 = r135;
            int r152 = r148;
        L38:
            Integer r153 = r150;
            r133 = r133;
            String r416 = r134;
            String r154 = r413;
            r134 = r416;
        L39:
            r102 = r102;
            r227 = r154;
            r225 = r220;
            r226 = r316;
            r147 = r153;
            String r155 = r222;
            int r417 = r152;
            r135 = r151;
            int r156 = r417;
        L48:
            String r418 = r155;
            r141 = r156;
            r146 = r418;
            goto L49
        L13:
            r134 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r134);
            int r157 = 262144;
        L15:
            int r158 = r141 | r157;
            r134 = r134;
            r411 = r411;
            r412 = r412;
        L24:
            int r419 = r158;
            String r159 = r413;
            int r160 = r419;
        L25:
            r151 = r135;
            r319 = r319;
            r152 = r160;
            r134 = r134;
            r154 = r159;
            r153 = r317;
            goto L39
        L14:
            r136 = (Integer) r101.decodeNullableSerializableElement(r100, 17, w0.f520792a, r136);
            r157 = 131072;
            goto L15
        L16:
            r160 = 65536 | r141;
            r318 = (Integer) r101.decodeNullableSerializableElement(r100, 16, w0.f520792a, r318);
        L18:
            r411 = r411;
            r412 = r412;
        L22:
            r159 = r413;
            goto L25
        L17:
            r318 = r318;
            r412 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r412);
            r160 = 32768 | r141;
            goto L18
        L19:
            r134 = r134;
            r412 = r412;
            r158 = r141 | 16384;
            r411 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r411);
            goto L24
        L21:
            r134 = r134;
            r318 = r318;
            r412 = r412;
            r411 = r411;
            r413 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r413);
            r160 = r141 | 8192;
            goto L22
        L23:
            r134 = r134;
            r318 = r318;
            r411 = r411;
            r412 = r412;
            r133 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r133);
            r158 = r141 | 4096;
            goto L24
        L26:
            r319 = (Integer) r101.decodeNullableSerializableElement(r100, 11, w0.f520792a, r319);
            r148 = r141 | 2048;
            goto L27
        L28:
            r133 = r133;
            r134 = r134;
            r318 = r318;
            r149 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r131);
            r148 = r141 | 1024;
            goto L32
        L30:
            r133 = r133;
            r134 = r134;
            r318 = r318;
            r149 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r138 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r138);
            r148 = r141 | 512;
            goto L32
        L31:
            r133 = r133;
            r134 = r134;
            r318 = r318;
            r149 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r132 = (Integer) r101.decodeNullableSerializableElement(r100, 8, w0.f520792a, r132);
            r148 = r141 | 256;
            goto L32
        L34:
            r133 = r133;
            r134 = r134;
            r318 = r318;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r319 = r319;
            r317 = (Integer) r101.decodeNullableSerializableElement(r100, 7, w0.f520792a, r317);
            r148 = r141 | 128;
            goto L33
        L35:
            r133 = r133;
            r134 = r134;
            r150 = r317;
            r318 = r318;
            r319 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r139 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r139);
            r148 = r141 | 64;
            goto L36
        L37:
            r133 = r133;
            r134 = r134;
            r150 = r317;
            r318 = r318;
            r319 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r151 = (List) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r135);
            r152 = r141 | 32;
            goto L38
        L40:
            r140 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r140);
            r156 = r141 | 16;
        L42:
            r225 = r220;
            r226 = r316;
        L45:
            String r161 = r222;
        L47:
            r155 = r161;
            r131 = r131;
            String r420 = r134;
            r147 = r317;
            r133 = r133;
            r227 = r413;
            r134 = r420;
            goto L48
        L41:
            r316 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r316);
            r156 = r141 | 8;
            goto L42
        L44:
            r102 = r102;
            r131 = r131;
            r133 = r133;
            r134 = r134;
            String r162 = r220;
            r226 = r316;
            r317 = r317;
            r318 = r318;
            r319 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r225 = r162;
            r156 = r141 | 2;
            r222 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r222);
            goto L45
        L46:
            r102 = r102;
            r131 = r131;
            r133 = r133;
            r134 = r134;
            r225 = r220;
            r226 = r316;
            r317 = r317;
            r318 = r318;
            r319 = r319;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r221 = (Long) r101.decodeNullableSerializableElement(r100, 0, g1.f520681a, r221);
            r156 = r141 | 1;
            r161 = r222;
            goto L47
        L52:
            String r320 = r131;
            String r228 = r220;
            Long r163 = r221;
            String r229 = r222;
            String r230 = r316;
            r219 = r132;
            r211 = r413;
            r313 = r136;
            r310 = r137;
            r312 = r134;
            r314 = r318;
            r210 = r411;
            r129 = r228;
            r125 = r230;
            r124 = r229;
            r218 = r320;
            r213 = r319;
            r311 = r142;
            r216 = r317;
            r214 = r135;
            r128 = r140;
            r315 = r412;
            r212 = r133;
            r127 = r163;
            r217 = r138;
            r215 = r139;
            r126 = r141;
            goto L53
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SearchImageInfo r102 = (SearchImageInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346712b;
            muc.d r104 = r100.beginStructure(r103);
            SearchImageInfo.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchImageInfo> serializer() {
            return a.f346711a;
        }
    }

    public SearchImageInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchImageInfo copy$default(SearchImageInfo r110, Long r111, String r112, String r210, String r211, String r212, List r213, String r214, Integer r215, Integer r216, String r217, String r218, Integer r219, String r310, String r311, String r312, String r313, Integer r314, Integer r315, String r316, String r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        Long r100 = r110.cardId;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.itemId;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r110.uri;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = r110.thumbUrl;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = r110.originThumbUrl;
    L23:
        if ((r318 & 32) == 0) goto L25;
        List r105 = r110.fullSizeUrl;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = r110.mainSiteUrl;
    L31:
        if ((r318 & 128) == 0) goto L33;
        Integer r107 = r110.width;
    L35:
        if ((r318 & 256) == 0) goto L37;
        Integer r113 = r110.height;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r114 = r110.docId;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r115 = r110.authorShortId;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        Integer r116 = r110.sourceFrom;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r117 = r110.sourceAppName;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r118 = r110.sourceAppIcon;
    L58:
        String r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        String r119 = r110.imgCaption;
    L62:
        String r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        String r120 = r110.caption;
    L66:
        String r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        Integer r121 = r110.originWidth;
    L70:
        Integer r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        Integer r122 = r110.originHeight;
    L74:
        Integer r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        String r123 = r110.imageSource;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        String r108 = r110.searchId;
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

    @SerialName("author_short_id")
    public static /* synthetic */ void getAuthorShortId$annotations() {
    }

    @SerialName("caption")
    public static /* synthetic */ void getCaption$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getCardId$annotations() {
    }

    @Transient
    public static /* synthetic */ void getDisplaySetting$annotations() {
    }

    @SerialName("doc_id")
    public static /* synthetic */ void getDocId$annotations() {
    }

    @Transient
    public static /* synthetic */ void getFoldImageInfoList$annotations() {
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

    @SerialName("item_id")
    public static /* synthetic */ void getItemId$annotations() {
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

    @Transient
    public static /* synthetic */ void getSearchItemType$annotations() {
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

    public final Long component1() {
        return this.cardId;
    }

    public final String component10() {
        return this.docId;
    }

    public final String component11() {
        return this.authorShortId;
    }

    public final Integer component12() {
        return this.sourceFrom;
    }

    public final String component13() {
        return this.sourceAppName;
    }

    public final String component14() {
        return this.sourceAppIcon;
    }

    public final String component15() {
        return this.imgCaption;
    }

    public final String component16() {
        return this.caption;
    }

    public final Integer component17() {
        return this.originWidth;
    }

    public final Integer component18() {
        return this.originHeight;
    }

    public final String component19() {
        return this.imageSource;
    }

    public final String component2() {
        return this.itemId;
    }

    public final String component20() {
        return this.searchId;
    }

    public final String component3() {
        return this.uri;
    }

    public final String component4() {
        return this.thumbUrl;
    }

    public final String component5() {
        return this.originThumbUrl;
    }

    public final List<String> component6() {
        return this.fullSizeUrl;
    }

    public final String component7() {
        return this.mainSiteUrl;
    }

    public final Integer component8() {
        return this.width;
    }

    public final Integer component9() {
        return this.height;
    }

    public final SearchImageInfo copy(Long r210, String r211, String r212, String r213, String r214, List<String> r215, String r216, Integer r310, Integer r311, String r312, String r313, Integer r314, String r315, String r316, String r317, String r318, Integer r319, Integer r410, String r411, String r412) {
        return new SearchImageInfo(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchImageInfo) == true) goto L8;
        return false;
    L8:
        SearchImageInfo r101 = (SearchImageInfo) r100;
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.thumbUrl, r101.thumbUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.originThumbUrl, r101.originThumbUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fullSizeUrl, r101.fullSizeUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mainSiteUrl, r101.mainSiteUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.docId, r101.docId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.authorShortId, r101.authorShortId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.sourceAppName, r101.sourceAppName) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sourceAppIcon, r101.sourceAppIcon) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.imgCaption, r101.imgCaption) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.caption, r101.caption) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.originWidth, r101.originWidth) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.originHeight, r101.originHeight) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.imageSource, r101.imageSource) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        Long r100 = this.cardId;
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
        String r107 = this.uri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.thumbUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.originThumbUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.fullSizeUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.mainSiteUrl;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.width;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.height;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.docId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.authorShortId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.sourceFrom;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.sourceAppName;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.sourceAppIcon;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.imgCaption;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.caption;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.originWidth;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.originHeight;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.imageSource;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.searchId;
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
        return "SearchImageInfo(cardId=" + this.cardId + ", itemId=" + this.itemId + ", uri=" + this.uri + ", thumbUrl=" + this.thumbUrl + ", originThumbUrl=" + this.originThumbUrl + ", fullSizeUrl=" + this.fullSizeUrl + ", mainSiteUrl=" + this.mainSiteUrl + ", width=" + this.width + ", height=" + this.height + ", docId=" + this.docId + ", authorShortId=" + this.authorShortId + ", sourceFrom=" + this.sourceFrom + ", sourceAppName=" + this.sourceAppName + ", sourceAppIcon=" + this.sourceAppIcon + ", imgCaption=" + this.imgCaption + ", caption=" + this.caption + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", imageSource=" + this.imageSource + ", searchId=" + this.searchId + ')';
    }

    static {
        Companion = new b();
        f346707d = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c1()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346707d;
    }

    public final String getAuthorShortId() {
        return this.authorShortId;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final Long getCardId() {
        return this.cardId;
    }

    public final s getDisplaySetting() {
        return this.f346709b;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final List<SearchImageInfo> getFoldImageInfoList() {
        return this.f346708a;
    }

    public final List<String> getFullSizeUrl() {
        return this.fullSizeUrl;
    }

    public final Integer getHeight() {
        return this.height;
    }

    @Override // com.larus.im.bean.message.ItemData
    public String getId() {
        return this.itemId;
    }

    public final String getImageSource() {
        return this.imageSource;
    }

    public final String getImgCaption() {
        return this.imgCaption;
    }

    public final String getItemId() {
        return this.itemId;
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

    @Override // com.larus.im.bean.message.ItemData
    public String getSearchId() {
        return this.searchId;
    }

    @Override // com.larus.im.bean.message.ItemData
    public ItemType getSearchItemType() {
        return this.f346710c;
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

    public final boolean isPlaceHolder() {
        return this.isPlaceHolder;
    }

    public final void setDisplaySetting(s r100) {
        this.f346709b = r100;
    }

    public final void setFoldImageInfoList(List<SearchImageInfo> r100) {
        this.f346708a = r100;
    }

    public final void setPlaceHolder(boolean r100) {
        this.isPlaceHolder = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(SearchImageInfo r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = f346707d;
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
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.itemId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.uri);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.thumbUrl);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.originThumbUrl);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.fullSizeUrl);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.mainSiteUrl);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, w0.f520792a, r100.width);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, w0.f520792a, r100.height);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.docId);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.authorShortId);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, w0.f520792a, r100.sourceFrom);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, v2.f520790a, r100.sourceAppName);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r101.encodeNullableSerializableElement(r102, 13, v2.f520790a, r100.sourceAppIcon);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r101.encodeNullableSerializableElement(r102, 14, v2.f520790a, r100.imgCaption);
    L138:
        if (r101.shouldEncodeElementDefault(r102, 15) == false) goto L141;
    L139:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r101.encodeNullableSerializableElement(r102, 15, v2.f520790a, r100.caption);
    L147:
        if (r101.shouldEncodeElementDefault(r102, 16) == false) goto L150;
    L148:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r101.encodeNullableSerializableElement(r102, 16, w0.f520792a, r100.originWidth);
    L156:
        if (r101.shouldEncodeElementDefault(r102, 17) == false) goto L159;
    L157:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r101.encodeNullableSerializableElement(r102, 17, w0.f520792a, r100.originHeight);
    L165:
        if (r101.shouldEncodeElementDefault(r102, 18) == false) goto L168;
    L166:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r101.encodeNullableSerializableElement(r102, 18, v2.f520790a, r100.imageSource);
    L174:
        if (r101.shouldEncodeElementDefault(r102, 19) == false) goto L177;
    L175:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r101.encodeNullableSerializableElement(r102, 19, v2.f520790a, r100.getSearchId());
    L183:
        if (r101.shouldEncodeElementDefault(r102, 20) == false) goto L186;
    L184:
        r104 = true;
    L188:
        if (r104 == false) goto L191;
        r101.encodeBooleanElement(r102, 20, r100.isPlaceHolder);
        return;
    L191:
        return;
    L186:
        if (r100.isPlaceHolder == false) goto L188;
    L177:
        if (r100.getSearchId() != null) goto L175;
        r124 = false;
        goto L180
    L168:
        if (r100.imageSource != null) goto L166;
        r123 = false;
        goto L171
    L159:
        if (r100.originHeight != null) goto L157;
        r122 = false;
        goto L162
    L150:
        if (r100.originWidth != null) goto L148;
        r121 = false;
        goto L153
    L141:
        if (Intrinsics.areEqual(r100.caption, "") == false) goto L139;
        r120 = false;
        goto L144
    L132:
        if (Intrinsics.areEqual(r100.imgCaption, "") == false) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.sourceAppIcon != null) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.sourceAppName != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.sourceFrom != null) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.authorShortId != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.docId != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.height != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.width != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.mainSiteUrl != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.fullSizeUrl != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.originThumbUrl != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.thumbUrl != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.uri != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.itemId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.cardId != null) goto L4;
        r105 = false;
        goto L9
    }

    public SearchImageInfo(Long r100, String r101, String r102, String r103, String r104, List<String> r105, String r106, Integer r110, Integer r111, String r112, String r113, Integer r114, String r115, String r116, String r117, String r118, Integer r119, Integer r210, String r211, String r212) {
        this.cardId = r100;
        this.itemId = r101;
        this.uri = r102;
        this.thumbUrl = r103;
        this.originThumbUrl = r104;
        this.fullSizeUrl = r105;
        this.mainSiteUrl = r106;
        this.width = r110;
        this.height = r111;
        this.docId = r112;
        this.authorShortId = r113;
        this.sourceFrom = r114;
        this.sourceAppName = r115;
        this.sourceAppIcon = r116;
        this.imgCaption = r117;
        this.caption = r118;
        this.originWidth = r119;
        this.originHeight = r210;
        this.imageSource = r211;
        this.searchId = r212;
        this.f346710c = ItemType.TYPE_CARD_IMAGE;
    }

    public /* synthetic */ SearchImageInfo(Long r210, String r211, String r212, String r213, String r214, List r215, String r216, Integer r217, Integer r310, String r311, String r312, Integer r313, String r314, String r315, String r316, String r317, Integer r318, Integer r319, String r410, String r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        Long r100 = null;
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
        String r104 = null;
    L23:
        if ((r412 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r412 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r115 = null;
    L58:
        String r116 = "";
        if ((r412 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r412 & 32768) != 0) goto L67;
        r116 = r317;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        Integer r118 = null;
    L75:
        if ((r412 & 262144) == 0) goto L77;
        String r119 = null;
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
    L61:
        r108 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L58
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

    public SearchImageInfo(int r100, Long r101, String r102, String r110, String r111, String r112, List r113, String r114, Integer r115, Integer r116, String r117, String r118, Integer r119, String r210, String r211, String r212, String r213, Integer r214, Integer r215, String r216, String r217, boolean r218, q2 r219) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346712b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.cardId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.itemId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.uri = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.thumbUrl = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.originThumbUrl = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.fullSizeUrl = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.mainSiteUrl = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.width = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.height = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.docId = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.authorShortId = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.sourceFrom = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.sourceAppName = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.sourceAppIcon = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.imgCaption = "";
    L65:
        if ((32768 & r100) != 0) goto L67;
        this.caption = "";
    L69:
        if ((65536 & r100) != 0) goto L71;
        this.originWidth = null;
    L73:
        if ((131072 & r100) != 0) goto L75;
        this.originHeight = null;
    L77:
        if ((262144 & r100) != 0) goto L79;
        this.imageSource = null;
    L81:
        if ((524288 & r100) != 0) goto L83;
        this.searchId = null;
    L84:
        this.f346708a = null;
        this.f346709b = null;
        if ((r100 & 1048576) != 0) goto L87;
        this.isPlaceHolder = false;
    L88:
        this.f346710c = ItemType.TYPE_CARD_IMAGE;
        return;
    L87:
        this.isPlaceHolder = r218;
        goto L88
    L83:
        this.searchId = r217;
        goto L84
    L79:
        this.imageSource = r216;
        goto L81
    L75:
        this.originHeight = r215;
        goto L77
    L71:
        this.originWidth = r214;
        goto L73
    L67:
        this.caption = r213;
        goto L69
    L63:
        this.imgCaption = r212;
        goto L65
    L59:
        this.sourceAppIcon = r211;
        goto L61
    L55:
        this.sourceAppName = r210;
        goto L57
    L51:
        this.sourceFrom = r119;
        goto L53
    L47:
        this.authorShortId = r118;
        goto L49
    L43:
        this.docId = r117;
        goto L45
    L39:
        this.height = r116;
        goto L41
    L35:
        this.width = r115;
        goto L37
    L31:
        this.mainSiteUrl = r114;
        goto L33
    L27:
        this.fullSizeUrl = r113;
        goto L29
    L23:
        this.originThumbUrl = r112;
        goto L25
    L19:
        this.thumbUrl = r111;
        goto L21
    L15:
        this.uri = r110;
        goto L17
    L11:
        this.itemId = r102;
        goto L13
    L7:
        this.cardId = r101;
        goto L9
    }
}
