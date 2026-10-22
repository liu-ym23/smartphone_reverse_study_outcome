package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l93.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\bH\b\u0087\b\u0018\u00002\u00020\u0001:\u0005rstuvB\u0083\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010/¢\u0006\u0004\bp\u0010qJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b)\u0010*J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003J\u0012\u00100\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0004\b0\u00101J\u008c\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010/HÆ\u0001¢\u0006\u0004\bG\u0010HJ\t\u0010I\u001a\u00020\nHÖ\u0001J\t\u0010J\u001a\u00020\bHÖ\u0001J\u0013\u0010L\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u00102\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010M\u001a\u0004\bN\u0010OR\u001c\u00103\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010P\u001a\u0004\bQ\u0010RR\u001c\u00104\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010S\u001a\u0004\bT\u0010UR\u001c\u00105\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010V\u001a\u0004\bW\u0010XR\u001c\u00106\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010V\u001a\u0004\bY\u0010XR\u001c\u00107\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010V\u001a\u0004\bZ\u0010XR\u001c\u00108\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010V\u001a\u0004\b[\u0010XR\u001c\u00109\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010V\u001a\u0004\b\\\u0010XR\u001c\u0010:\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010P\u001a\u0004\b]\u0010RR\u001c\u0010;\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010V\u001a\u0004\b^\u0010XR\u001c\u0010<\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010V\u001a\u0004\b_\u0010XR\u001c\u0010=\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010V\u001a\u0004\b`\u0010XR\u001c\u0010>\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010V\u001a\u0004\ba\u0010XR\u001c\u0010?\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010V\u001a\u0004\bb\u0010XR\u001c\u0010@\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010P\u001a\u0004\bc\u0010RR\u001c\u0010A\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010V\u001a\u0004\bd\u0010XR\u001c\u0010B\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010V\u001a\u0004\be\u0010XR\u001c\u0010C\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010f\u001a\u0004\bg\u0010*R\u001c\u0010D\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010E\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010k\u001a\u0004\bl\u0010mR\u001c\u0010F\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010n\u001a\u0004\bo\u00101¨\u0006w"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "getChannelLives", "", "isChannelStatic", "()Ljava/lang/Boolean;", "", "index", "", "getNoticeName", "getItemImageUrl", "getTitleImgUrl", "showItemPrice", "getItemPrice", "getItemPriceOrTag", "showItemTag", "getItemTag", "getDisplayType", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$a;", "getCouponAnimation", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "component1", "component2", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "component19", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "component20", "", "component21", "()Ljava/lang/Long;", "layout", "extra", "logExtra", "componentId", "moduleId", "name", "title", "subtitle", "icon", "link", "resourceId", "bgUrl", "bgUrl1", "bgUrl2", "fgUrl", "tagUrl", "tagUrl2", "originChannelCardFIndex", "data", "bcm", "leftTime", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;Ljava/lang/Object;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;Ljava/lang/Long;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "toString", "hashCode", "other", "equals", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "getLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/Object;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "getLogExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "Ljava/lang/String;", "getComponentId", "()Ljava/lang/String;", "getModuleId", "getName", "getTitle", "getSubtitle", "getIcon", "getLink", "getResourceId", "getBgUrl", "getBgUrl1", "getBgUrl2", "getFgUrl", "getTagUrl", "getTagUrl2", "Ljava/lang/Integer;", "getOriginChannelCardFIndex", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "getData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "getBcm", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "Ljava/lang/Long;", "getLeftTime", "<init>", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;Ljava/lang/Object;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;Ljava/lang/Long;)V", "Animation", "a", "Data", "Layout", "LogExtra", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelVO {

    @SerializedName("bcm")
    private final Bcm bcm;

    @SerializedName("bgUrl")
    private final String bgUrl;

    @SerializedName("bg_url_1")
    private final String bgUrl1;

    @SerializedName("bg_url_2")
    private final String bgUrl2;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("data")
    private final Data data;

    @SerializedName("extra")
    private final Object extra;

    @SerializedName("fgUrl")
    private final Object fgUrl;

    @SerializedName("icon")
    private final Object icon;

    @SerializedName("layout")
    private final Layout layout;

    @SerializedName("left_time")
    private final Long leftTime;

    @SerializedName("link")
    private final String link;

    @SerializedName("log_extra")
    private final LogExtra logExtra;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("name")
    private final String name;

    @SerializedName("originChannelCardFIndex")
    private final Integer originChannelCardFIndex;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName("tag_url")
    private final String tagUrl;

    @SerializedName("tag_url_2")
    private final String tagUrl2;

    @SerializedName("title")
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J¶\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b$\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "", "animationType", "", "animationStartTime", "", "animationEndTime", "dayRange", "carouselPeriod", "tagProductInterval", "tagUrl", "", "carouselTimes", "lottieUrl", "lottieUrl1", "startCustomLottieFrame", "endCustomLottieFrame", "extra", "", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)V", "getAnimationEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAnimationStartTime", "getAnimationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCarouselPeriod", "getCarouselTimes", "getDayRange", "getEndCustomLottieFrame", "getExtra", "()Ljava/util/Map;", "getLottieUrl", "()Ljava/lang/String;", "getLottieUrl1", "getStartCustomLottieFrame", "getTagProductInterval", "getTagUrl", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Animation {

        @SerializedName("animation_end_time")
        private final Long animationEndTime;

        @SerializedName("animation_start_time")
        private final Long animationStartTime;

        @SerializedName("animation_type")
        private final Integer animationType;

        @SerializedName("carousel_period")
        private final Long carouselPeriod;

        @SerializedName("carousel_times")
        private final Long carouselTimes;

        @SerializedName("day_range")
        private final Long dayRange;

        @SerializedName("end_custom_lottie_frame")
        private final Integer endCustomLottieFrame;

        @SerializedName("extra")
        private final Map<String, String> extra;

        @SerializedName("lottie_url")
        private final String lottieUrl;

        @SerializedName("lottie_url_1")
        private final String lottieUrl1;

        @SerializedName("start_custom_lottie_frame")
        private final Integer startCustomLottieFrame;

        @SerializedName("tag_product_interval")
        private final Long tagProductInterval;

        @SerializedName("tag_url")
        private final String tagUrl;

        public Animation() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Animation copy$default(Animation r14, Integer r15, Long r16, Long r17, Long r18, Long r19, Long r20, String r21, Long r22, String r23, String r24, Integer r25, Integer r26, Map r27, int r28, Object r29) {
            if ((r28 & 1) == 0) goto L5;
            Integer r2 = r14.animationType;
        L7:
            if ((r28 & 2) == 0) goto L9;
            Long r3 = r14.animationStartTime;
        L11:
            if ((r28 & 4) == 0) goto L13;
            Long r4 = r14.animationEndTime;
        L15:
            if ((r28 & 8) == 0) goto L17;
            Long r5 = r14.dayRange;
        L19:
            if ((r28 & 16) == 0) goto L21;
            Long r6 = r14.carouselPeriod;
        L23:
            if ((r28 & 32) == 0) goto L25;
            Long r7 = r14.tagProductInterval;
        L27:
            if ((r28 & 64) == 0) goto L29;
            String r8 = r14.tagUrl;
        L31:
            if ((r28 & 128) == 0) goto L33;
            Long r9 = r14.carouselTimes;
        L35:
            if ((r28 & 256) == 0) goto L37;
            String r10 = r14.lottieUrl;
        L39:
            if ((r28 & 512) == 0) goto L41;
            String r11 = r14.lottieUrl1;
        L43:
            if ((r28 & 1024) == 0) goto L45;
            Integer r12 = r14.startCustomLottieFrame;
        L47:
            if ((r28 & 2048) == 0) goto L49;
            Integer r13 = r14.endCustomLottieFrame;
        L51:
            if ((r28 & 4096) == 0) goto L53;
            Map r1 = r14.extra;
        L55:
            return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
        L53:
            r1 = r27;
            goto L55
        L49:
            r13 = r26;
            goto L51
        L45:
            r12 = r25;
            goto L47
        L41:
            r11 = r24;
            goto L43
        L37:
            r10 = r23;
            goto L39
        L33:
            r9 = r22;
            goto L35
        L29:
            r8 = r21;
            goto L31
        L25:
            r7 = r20;
            goto L27
        L21:
            r6 = r19;
            goto L23
        L17:
            r5 = r18;
            goto L19
        L13:
            r4 = r17;
            goto L15
        L9:
            r3 = r16;
            goto L11
        L5:
            r2 = r15;
            goto L7
        }

        public final Integer component1() {
            return this.animationType;
        }

        public final String component10() {
            return this.lottieUrl1;
        }

        public final Integer component11() {
            return this.startCustomLottieFrame;
        }

        public final Integer component12() {
            return this.endCustomLottieFrame;
        }

        public final Map<String, String> component13() {
            return this.extra;
        }

        public final Long component2() {
            return this.animationStartTime;
        }

        public final Long component3() {
            return this.animationEndTime;
        }

        public final Long component4() {
            return this.dayRange;
        }

        public final Long component5() {
            return this.carouselPeriod;
        }

        public final Long component6() {
            return this.tagProductInterval;
        }

        public final String component7() {
            return this.tagUrl;
        }

        public final Long component8() {
            return this.carouselTimes;
        }

        public final String component9() {
            return this.lottieUrl;
        }

        public final Animation copy(Integer r16, Long r17, Long r18, Long r19, Long r20, Long r21, String r22, Long r23, String r24, String r25, Integer r26, Integer r27, Map<String, String> r28) {
            return new Animation(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Animation) == false) goto L32;
            Animation r4 = (Animation) r3;
            if (Intrinsics.areEqual(this.animationType, r4.animationType) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.animationStartTime, r4.animationStartTime) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.animationEndTime, r4.animationEndTime) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.dayRange, r4.dayRange) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.carouselPeriod, r4.carouselPeriod) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.tagProductInterval, r4.tagProductInterval) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.tagUrl, r4.tagUrl) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.carouselTimes, r4.carouselTimes) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.lottieUrl, r4.lottieUrl) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.lottieUrl1, r4.lottieUrl1) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.startCustomLottieFrame, r4.startCustomLottieFrame) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.endCustomLottieFrame, r4.endCustomLottieFrame) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L49;
            return false;
        L49:
            return true;
        L32:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.animationType;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Long r4 = this.animationStartTime;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Long r7 = this.animationEndTime;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.dayRange;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Long r13 = this.carouselPeriod;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Long r16 = this.tagProductInterval;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.tagUrl;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            Long r22 = this.carouselTimes;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            String r25 = this.lottieUrl;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            String r28 = this.lottieUrl1;
            if (r28 == null) goto L41;
            int r29 = r28.hashCode();
        L42:
            int r30 = (r27 + r29) * 31;
            Integer r31 = this.startCustomLottieFrame;
            if (r31 == null) goto L45;
            int r32 = r31.hashCode();
        L46:
            int r33 = (r30 + r32) * 31;
            Integer r34 = this.endCustomLottieFrame;
            if (r34 == null) goto L49;
            int r35 = r34.hashCode();
        L50:
            int r36 = (r33 + r35) * 31;
            Map<String, String> r37 = this.extra;
            if (r37 == null) goto L54;
            r1 = r37.hashCode();
        L54:
            return r36 + r1;
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Animation(animationType=" + this.animationType + ", animationStartTime=" + this.animationStartTime + ", animationEndTime=" + this.animationEndTime + ", dayRange=" + this.dayRange + ", carouselPeriod=" + this.carouselPeriod + ", tagProductInterval=" + this.tagProductInterval + ", tagUrl=" + this.tagUrl + ", carouselTimes=" + this.carouselTimes + ", lottieUrl=" + this.lottieUrl + ", lottieUrl1=" + this.lottieUrl1 + ", startCustomLottieFrame=" + this.startCustomLottieFrame + ", endCustomLottieFrame=" + this.endCustomLottieFrame + ", extra=" + this.extra + ")";
        }

        public final Long getAnimationEndTime() {
            return this.animationEndTime;
        }

        public final Long getAnimationStartTime() {
            return this.animationStartTime;
        }

        public final Integer getAnimationType() {
            return this.animationType;
        }

        public final Long getCarouselPeriod() {
            return this.carouselPeriod;
        }

        public final Long getCarouselTimes() {
            return this.carouselTimes;
        }

        public final Long getDayRange() {
            return this.dayRange;
        }

        public final Integer getEndCustomLottieFrame() {
            return this.endCustomLottieFrame;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final String getLottieUrl() {
            return this.lottieUrl;
        }

        public final String getLottieUrl1() {
            return this.lottieUrl1;
        }

        public final Integer getStartCustomLottieFrame() {
            return this.startCustomLottieFrame;
        }

        public final Long getTagProductInterval() {
            return this.tagProductInterval;
        }

        public final String getTagUrl() {
            return this.tagUrl;
        }

        public Animation(Integer r1, Long r2, Long r3, Long r4, Long r5, Long r6, String r7, Long r8, String r9, String r10, Integer r11, Integer r12, Map<String, String> r13) {
            this.animationType = r1;
            this.animationStartTime = r2;
            this.animationEndTime = r3;
            this.dayRange = r4;
            this.carouselPeriod = r5;
            this.tagProductInterval = r6;
            this.tagUrl = r7;
            this.carouselTimes = r8;
            this.lottieUrl = r9;
            this.lottieUrl1 = r10;
            this.startCustomLottieFrame = r11;
            this.endCustomLottieFrame = r12;
            this.extra = r13;
        }

        public /* synthetic */ Animation(Integer r15, Long r16, Long r17, Long r18, Long r19, Long r20, String r21, Long r22, String r23, String r24, Integer r25, Integer r26, Map r27, int r28, DefaultConstructorMarker r29) {
            Map r2 = null;
            if ((r28 & 1) == 0) goto L5;
            Integer r1 = null;
        L7:
            if ((r28 & 2) == 0) goto L9;
            Long r3 = null;
        L11:
            if ((r28 & 4) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r28 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r28 & 16) == 0) goto L21;
            Long r6 = null;
        L23:
            if ((r28 & 32) == 0) goto L25;
            Long r7 = null;
        L27:
            if ((r28 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r28 & 128) == 0) goto L33;
            Long r9 = null;
        L35:
            if ((r28 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r28 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r28 & 1024) == 0) goto L45;
            Integer r12 = null;
        L47:
            if ((r28 & 2048) == 0) goto L49;
            Integer r13 = null;
        L51:
            if ((r28 & 4096) != 0) goto L54;
            r2 = r27;
        L54:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2);
            return;
        L49:
            r13 = r26;
            goto L51
        L45:
            r12 = r25;
            goto L47
        L41:
            r11 = r24;
            goto L43
        L37:
            r10 = r23;
            goto L39
        L33:
            r9 = r22;
            goto L35
        L29:
            r8 = r21;
            goto L31
        L25:
            r7 = r20;
            goto L27
        L21:
            r6 = r19;
            goto L23
        L17:
            r5 = r18;
            goto L19
        L13:
            r4 = r17;
            goto L15
        L9:
            r3 = r16;
            goto L11
        L5:
            r1 = r15;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\"#BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nHÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nHÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data;", "", "entrance", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "items", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCard;", "animation", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "marketingItems", "", "subItems", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;Ljava/util/List;Ljava/util/List;)V", "getAnimation", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Animation;", "getEntrance", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "getItems", "()Ljava/util/List;", "getMarketingItems", "getSubItems", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Entrance", "EntrancePit", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Data {

        @SerializedName("animation")
        private final Animation animation;

        @SerializedName("entrance")
        private final Entrance entrance;

        @SerializedName("items")
        private final List<ECCommonCard> items;

        @SerializedName("marketing_items")
        private final List<ECCommonCard> marketingItems;

        @SerializedName("sub_items")
        private final List<ECCommonCard> subItems;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "", "entranceDisplayType", "", "entranceContentFormat", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "(Ljava/lang/Integer;Ljava/util/List;)V", "getEntranceContentFormat", "()Ljava/util/List;", "getEntranceDisplayType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$Entrance;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Entrance {

            @SerializedName("entrance_content_format")
            private final List<EntrancePit> entranceContentFormat;

            @SerializedName("entrance_display_type")
            private final Integer entranceDisplayType;

            /* JADX WARN: Multi-variable type inference failed */
            public Entrance() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Entrance copy$default(Entrance r0, Integer r1, List r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.entranceDisplayType;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.entranceContentFormat;
            L9:
                return r0.copy(r1, r2);
            }

            public final Integer component1() {
                return this.entranceDisplayType;
            }

            public final List<EntrancePit> component2() {
                return this.entranceContentFormat;
            }

            public final Entrance copy(Integer r2, List<EntrancePit> r3) {
                return new Entrance(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Entrance) == false) goto L10;
                Entrance r4 = (Entrance) r3;
                if (Intrinsics.areEqual(this.entranceDisplayType, r4.entranceDisplayType) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.entranceContentFormat, r4.entranceContentFormat) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.entranceDisplayType;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<EntrancePit> r4 = this.entranceContentFormat;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "Entrance(entranceDisplayType=" + this.entranceDisplayType + ", entranceContentFormat=" + this.entranceContentFormat + ")";
            }

            public final List<EntrancePit> getEntranceContentFormat() {
                return this.entranceContentFormat;
            }

            public final Integer getEntranceDisplayType() {
                return this.entranceDisplayType;
            }

            public Entrance(Integer r1, List<EntrancePit> r2) {
                this.entranceDisplayType = r1;
                this.entranceContentFormat = r2;
            }

            public /* synthetic */ Entrance(Integer r2, List r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "", "targetIdx", "", "tagType", "content", "", "subTagType", "subContent", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getSubContent", "getSubTagType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagType", "getTargetIdx", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Data$EntrancePit;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class EntrancePit {

            @SerializedName("content")
            private final String content;

            @SerializedName("sub_content")
            private final String subContent;

            @SerializedName("sub_tag_type")
            private final Integer subTagType;

            @SerializedName("tag_type")
            private final Integer tagType;

            @SerializedName("target_idx")
            private final Integer targetIdx;

            public EntrancePit() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ EntrancePit copy$default(EntrancePit r3, Integer r4, Integer r5, String r6, Integer r7, String r8, int r9, Object r10) {
                if ((r9 & 1) == 0) goto L6;
                r4 = r3.targetIdx;
            L6:
                if ((r9 & 2) == 0) goto L8;
                r5 = r3.tagType;
            L8:
                Integer r11 = r5;
                if ((r9 & 4) == 0) goto L11;
                r6 = r3.content;
            L11:
                String r0 = r6;
                if ((r9 & 8) == 0) goto L14;
                r7 = r3.subTagType;
            L14:
                Integer r1 = r7;
                if ((r9 & 16) == 0) goto L17;
                r8 = r3.subContent;
            L17:
                Integer r12 = r4;
                return r3.copy(r12, r11, r0, r1, r8);
            }

            public final Integer component1() {
                return this.targetIdx;
            }

            public final Integer component2() {
                return this.tagType;
            }

            public final String component3() {
                return this.content;
            }

            public final Integer component4() {
                return this.subTagType;
            }

            public final String component5() {
                return this.subContent;
            }

            public final EntrancePit copy(Integer r8, Integer r9, String r10, Integer r11, String r12) {
                return new EntrancePit(r8, r9, r10, r11, r12);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof EntrancePit) == false) goto L16;
                EntrancePit r4 = (EntrancePit) r3;
                if (Intrinsics.areEqual(this.targetIdx, r4.targetIdx) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.tagType, r4.tagType) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.content, r4.content) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.subTagType, r4.subTagType) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.subContent, r4.subContent) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.targetIdx;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Integer r4 = this.tagType;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.content;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.subTagType;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.subContent;
                if (r13 == null) goto L22;
                r1 = r13.hashCode();
            L22:
                return r12 + r1;
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "EntrancePit(targetIdx=" + this.targetIdx + ", tagType=" + this.tagType + ", content=" + this.content + ", subTagType=" + this.subTagType + ", subContent=" + this.subContent + ")";
            }

            public final String getContent() {
                return this.content;
            }

            public final String getSubContent() {
                return this.subContent;
            }

            public final Integer getSubTagType() {
                return this.subTagType;
            }

            public final Integer getTagType() {
                return this.tagType;
            }

            public final Integer getTargetIdx() {
                return this.targetIdx;
            }

            public EntrancePit(Integer r1, Integer r2, String r3, Integer r4, String r5) {
                this.targetIdx = r1;
                this.tagType = r2;
                this.content = r3;
                this.subTagType = r4;
                this.subContent = r5;
            }

            public /* synthetic */ EntrancePit(Integer r5, Integer r6, String r7, Integer r8, String r9, int r10, DefaultConstructorMarker r11) {
                if ((r10 & 1) == 0) goto L5;
                Integer r12 = null;
            L7:
                if ((r10 & 2) == 0) goto L9;
                Integer r1 = null;
            L11:
                if ((r10 & 4) == 0) goto L13;
                String r2 = null;
            L15:
                if ((r10 & 8) == 0) goto L17;
                Integer r3 = null;
            L19:
                if ((r10 & 16) == 0) goto L21;
                String r13 = null;
            L22:
                this(r12, r1, r2, r3, r13);
                return;
            L21:
                r13 = r9;
                goto L22
            L17:
                r3 = r8;
                goto L19
            L13:
                r2 = r7;
                goto L15
            L9:
                r1 = r6;
                goto L11
            L5:
                r12 = r5;
                goto L7
            }
        }

        public Data() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data r3, Entrance r4, List r5, Animation r6, List r7, List r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.entrance;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.items;
        L8:
            List r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.animation;
        L11:
            Animation r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.marketingItems;
        L14:
            List r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.subItems;
        L17:
            Entrance r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final Entrance component1() {
            return this.entrance;
        }

        public final List<ECCommonCard> component2() {
            return this.items;
        }

        public final Animation component3() {
            return this.animation;
        }

        public final List<ECCommonCard> component4() {
            return this.marketingItems;
        }

        public final List<ECCommonCard> component5() {
            return this.subItems;
        }

        public final Data copy(Entrance r8, List<ECCommonCard> r9, Animation r10, List<ECCommonCard> r11, List<ECCommonCard> r12) {
            return new Data(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Data) == false) goto L16;
            Data r4 = (Data) r3;
            if (Intrinsics.areEqual(this.entrance, r4.entrance) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.items, r4.items) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.animation, r4.animation) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.marketingItems, r4.marketingItems) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.subItems, r4.subItems) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            Entrance r0 = this.entrance;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<ECCommonCard> r4 = this.items;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Animation r7 = this.animation;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            List<ECCommonCard> r10 = this.marketingItems;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            List<ECCommonCard> r13 = this.subItems;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Data(entrance=" + this.entrance + ", items=" + this.items + ", animation=" + this.animation + ", marketingItems=" + this.marketingItems + ", subItems=" + this.subItems + ")";
        }

        public final Animation getAnimation() {
            return this.animation;
        }

        public final Entrance getEntrance() {
            return this.entrance;
        }

        public final List<ECCommonCard> getItems() {
            return this.items;
        }

        public final List<ECCommonCard> getMarketingItems() {
            return this.marketingItems;
        }

        public final List<ECCommonCard> getSubItems() {
            return this.subItems;
        }

        public Data(Entrance r1, List<ECCommonCard> r2, Animation r3, List<ECCommonCard> r4, List<ECCommonCard> r5) {
            this.entrance = r1;
            this.items = r2;
            this.animation = r3;
            this.marketingItems = r4;
            this.subItems = r5;
        }

        public /* synthetic */ Data(Entrance r5, List r6, Animation r7, List r8, List r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            Entrance r12 = null;
        L7:
            if ((r10 & 2) == 0) goto L9;
            List r1 = null;
        L11:
            if ((r10 & 4) == 0) goto L13;
            Animation r2 = null;
        L15:
            if ((r10 & 8) == 0) goto L17;
            List r3 = null;
        L19:
            if ((r10 & 16) == 0) goto L21;
            List r13 = null;
        L22:
            this(r12, r1, r2, r3, r13);
            return;
        L21:
            r13 = r9;
            goto L22
        L17:
            r3 = r8;
            goto L19
        L13:
            r2 = r7;
            goto L15
        L9:
            r1 = r6;
            goto L11
        L5:
            r12 = r5;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "", "vSpan", "", "hSpan", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHSpan", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVSpan", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$Layout;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Layout {

        @SerializedName("hSpan")
        private final Integer hSpan;

        @SerializedName("vSpan")
        private final Integer vSpan;

        public Layout() {
            Integer r0 = null;
            this(r0, r0, 3, r0);
        }

        public static /* synthetic */ Layout copy$default(Layout r0, Integer r1, Integer r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.vSpan;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.hSpan;
        L9:
            return r0.copy(r1, r2);
        }

        public final Integer component1() {
            return this.vSpan;
        }

        public final Integer component2() {
            return this.hSpan;
        }

        public final Layout copy(Integer r2, Integer r3) {
            return new Layout(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Layout) == false) goto L10;
            Layout r4 = (Layout) r3;
            if (Intrinsics.areEqual(this.vSpan, r4.vSpan) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.hSpan, r4.hSpan) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.vSpan;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.hSpan;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Layout(vSpan=" + this.vSpan + ", hSpan=" + this.hSpan + ")";
        }

        public final Integer getHSpan() {
            return this.hSpan;
        }

        public final Integer getVSpan() {
            return this.vSpan;
        }

        public Layout(Integer r1, Integer r2) {
            this.vSpan = r1;
            this.hSpan = r2;
        }

        public /* synthetic */ Layout(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO$LogExtra;", "", "requestId", "", "(Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LogExtra {

        @SerializedName("request_id")
        private final String requestId;

        public LogExtra() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ LogExtra copy$default(LogExtra r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.requestId;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.requestId;
        }

        public final LogExtra copy(String r2) {
            return new LogExtra(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof LogExtra) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.requestId, ((LogExtra) r2).requestId) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.requestId;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "LogExtra(requestId=" + this.requestId + ")";
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public LogExtra(String r1) {
            this.requestId = r1;
        }

        public /* synthetic */ LogExtra(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public static final class a {
        public final int a;
        public final int b;
        public final Coupon4Activity c;
        public final String d;
        public final String e;
        public final C0021a f;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO$a$a, reason: collision with other inner class name */
        public static final class C0021a {
            public final long a;
            public final int b;
            public final int c;

            public C0021a(long r1, int r3, int r4) {
                this.a = r1;
                this.b = r3;
                this.c = r4;
            }
        }

        public a(int r2, int r3, Coupon4Activity r4, String r5, String r6, C0021a r7) {
            Intrinsics.checkNotNullParameter(r4, "coupon");
            Intrinsics.checkNotNullParameter(r5, "lottieImg");
            Intrinsics.checkNotNullParameter(r6, "staticImg");
            Intrinsics.checkNotNullParameter(r7, "animConfig");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public ChannelVO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public static /* synthetic */ ChannelVO copy$default(ChannelVO r17, Layout r18, Object r19, LogExtra r20, String r21, String r22, String r23, String r24, String r25, Object r26, String r27, String r28, String r29, String r30, String r31, Object r32, String r33, String r34, Integer r35, Data r36, Bcm r37, Long r38, int r39, Object r40) {
        if ((r39 & 1) == 0) goto L5;
        Layout r2 = r17.layout;
    L7:
        if ((r39 & 2) == 0) goto L9;
        Object r3 = r17.extra;
    L11:
        if ((r39 & 4) == 0) goto L13;
        LogExtra r4 = r17.logExtra;
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r5 = r17.componentId;
    L19:
        if ((r39 & 16) == 0) goto L21;
        String r6 = r17.moduleId;
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r7 = r17.name;
    L27:
        if ((r39 & 64) == 0) goto L29;
        String r8 = r17.title;
    L31:
        if ((r39 & 128) == 0) goto L33;
        String r9 = r17.subtitle;
    L35:
        if ((r39 & 256) == 0) goto L37;
        Object r10 = r17.icon;
    L39:
        if ((r39 & 512) == 0) goto L41;
        String r11 = r17.link;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        String r12 = r17.resourceId;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        String r13 = r17.bgUrl;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        String r14 = r17.bgUrl1;
    L55:
        if ((r39 & 8192) == 0) goto L57;
        String r15 = r17.bgUrl2;
    L58:
        String r310 = r15;
        if ((r39 & 16384) == 0) goto L61;
        Object r16 = r17.fgUrl;
    L62:
        Object r311 = r16;
        if ((r39 & 32768) == 0) goto L65;
        String r110 = r17.tagUrl;
    L66:
        String r312 = r110;
        if ((r39 & 65536) == 0) goto L69;
        String r111 = r17.tagUrl2;
    L70:
        String r313 = r111;
        if ((r39 & 131072) == 0) goto L73;
        Integer r112 = r17.originChannelCardFIndex;
    L74:
        Integer r314 = r112;
        if ((r39 & 262144) == 0) goto L77;
        Data r113 = r17.data;
    L78:
        Data r315 = r113;
        if ((r39 & 524288) == 0) goto L81;
        Bcm r114 = r17.bcm;
    L83:
        if ((r39 & 1048576) == 0) goto L85;
        Long r1 = r17.leftTime;
    L87:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r114, r1);
    L85:
        r1 = r38;
        goto L87
    L81:
        r114 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Layout component1() {
        return this.layout;
    }

    public final String component10() {
        return this.link;
    }

    public final String component11() {
        return this.resourceId;
    }

    public final String component12() {
        return this.bgUrl;
    }

    public final String component13() {
        return this.bgUrl1;
    }

    public final String component14() {
        return this.bgUrl2;
    }

    public final Object component15() {
        return this.fgUrl;
    }

    public final String component16() {
        return this.tagUrl;
    }

    public final String component17() {
        return this.tagUrl2;
    }

    public final Integer component18() {
        return this.originChannelCardFIndex;
    }

    public final Data component19() {
        return this.data;
    }

    public final Object component2() {
        return this.extra;
    }

    public final Bcm component20() {
        return this.bcm;
    }

    public final Long component21() {
        return this.leftTime;
    }

    public final LogExtra component3() {
        return this.logExtra;
    }

    public final String component4() {
        return this.componentId;
    }

    public final String component5() {
        return this.moduleId;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.subtitle;
    }

    public final Object component9() {
        return this.icon;
    }

    public final ChannelVO copy(Layout r24, Object r25, LogExtra r26, String r27, String r28, String r29, String r30, String r31, Object r32, String r33, String r34, String r35, String r36, String r37, Object r38, String r39, String r40, Integer r41, Data r42, Bcm r43, Long r44) {
        return new ChannelVO(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ChannelVO) == false) goto L48;
        ChannelVO r4 = (ChannelVO) r3;
        if (Intrinsics.areEqual(this.layout, r4.layout) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logExtra, r4.logExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentId, r4.componentId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.moduleId, r4.moduleId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.subtitle, r4.subtitle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.link, r4.link) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.resourceId, r4.resourceId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.bgUrl, r4.bgUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bgUrl1, r4.bgUrl1) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.bgUrl2, r4.bgUrl2) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.fgUrl, r4.fgUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagUrl, r4.tagUrl) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.tagUrl2, r4.tagUrl2) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.originChannelCardFIndex, r4.originChannelCardFIndex) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.bcm, r4.bcm) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.leftTime, r4.leftTime) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public int hashCode() {
        Layout r0 = this.layout;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.extra;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        LogExtra r7 = this.logExtra;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.componentId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.moduleId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.name;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.title;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.subtitle;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Object r25 = this.icon;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.link;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.resourceId;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.bgUrl;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.bgUrl1;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.bgUrl2;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Object r43 = this.fgUrl;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.tagUrl;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.tagUrl2;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        Integer r52 = this.originChannelCardFIndex;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        Data r55 = this.data;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        Bcm r58 = this.bcm;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        Long r61 = this.leftTime;
        if (r61 == null) goto L86;
        r1 = r61.hashCode();
    L86:
        return r60 + r1;
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ChannelVO(layout=" + this.layout + ", extra=" + this.extra + ", logExtra=" + this.logExtra + ", componentId=" + this.componentId + ", moduleId=" + this.moduleId + ", name=" + this.name + ", title=" + this.title + ", subtitle=" + this.subtitle + ", icon=" + this.icon + ", link=" + this.link + ", resourceId=" + this.resourceId + ", bgUrl=" + this.bgUrl + ", bgUrl1=" + this.bgUrl1 + ", bgUrl2=" + this.bgUrl2 + ", fgUrl=" + this.fgUrl + ", tagUrl=" + this.tagUrl + ", tagUrl2=" + this.tagUrl2 + ", originChannelCardFIndex=" + this.originChannelCardFIndex + ", data=" + this.data + ", bcm=" + this.bcm + ", leftTime=" + this.leftTime + ")";
    }

    public final List<ECLiveStruct> getChannelLives() {
        ArrayList r0 = new ArrayList();
        Data r1 = this.data;
        if (r1 == null) goto L18;
        List<ECCommonCard> r2 = r1.getItems();
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        ECCommonCard r4 = (ECCommonCard) r3.next();
        if (r4 == null) goto L8;
        ECLiveStruct r5 = r4.getLive();
        if (r5 == null) goto L8;
        String r6 = r5.getRoomId();
        String r7 = r5.getStreamData();
        String r8 = r5.getUid();
        String r9 = r5.getTitle();
        Integer r10 = r5.getStatus();
        WysiwygParam r11 = r4.getWysiwygParam();
        if (r11 == null) goto L16;
        String r12 = r11.getItems();
    L17:
        r0.add(new ECLiveStruct(r6, r7, r8, r9, r10, r12));
        goto L8
    L16:
        r12 = null;
    L18:
        return r0;
    }

    public final a getCouponAnimation() {
        Data r0 = this.data;
        a r1 = null;
        if (r0 == null) goto L9;
        List<ECCommonCard> r2 = r0.getMarketingItems();
        if (r2 == null) goto L9;
        ECCommonCard r3 = (ECCommonCard) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L9;
        Coupon4Activity r5 = r3.getCoupon();
    L10:
        Data r4 = this.data;
        if (r4 == null) goto L13;
        Animation r6 = r4.getAnimation();
    L14:
        if (r6 == null) goto L16;
        Integer r7 = r6.getAnimationType();
    L17:
        int r8 = AnimationType.LOTTIE_WITH_INFO.getValue();
        if (r7 != null) goto L21;
    L62:
        return r1;
    L21:
        if (r7.intValue() != r8) goto L62;
        if (r5 == null) goto L62;
        Map<String, String> r9 = r5.getExtra();
        int r10 = 0;
        if (r9 == null) goto L30;
        String r11 = r9.get("coupon_number");
        if (r11 == null) goto L30;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L30;
        int r13 = r12.intValue();
    L32:
        if (r13 <= 1) goto L36;
        String r14 = r6.getLottieUrl1();
        if (r14 == null) goto L38;
    L39:
        String r15 = r14;
    L40:
        Integer r16 = r5.getAmount();
        if (r16 == null) goto L43;
        r10 = r16.intValue();
    L43:
        int r17 = r10 / 100;
        String r18 = b.a(this.fgUrl);
        if (r18 != null) goto L46;
        String r19 = "";
    L47:
        Long r20 = r6.getCarouselPeriod();
        if (r20 == null) goto L50;
        r20.longValue();
    L50:
        Long r21 = r6.getCarouselTimes();
        if (r21 == null) goto L53;
        long r22 = r21.longValue();
    L54:
        Integer r110 = r6.getStartCustomLottieFrame();
        int r111 = -1;
        if (r110 == null) goto L57;
        int r112 = r110.intValue();
    L58:
        Integer r23 = r6.getEndCustomLottieFrame();
        if (r23 == null) goto L61;
        r111 = r23.intValue();
    L61:
        r1 = new a(r17, r13, r5, r15, r19, new a.C0021a(r22, r112, r111));
        goto L62
    L57:
        r112 = -1;
        goto L58
    L53:
        r22 = 1;
        goto L54
    L46:
        r19 = r18;
    L38:
        r15 = "";
        goto L40
    L36:
        r14 = r6.getLottieUrl();
        if (r14 != null) goto L39;
    L30:
        r13 = 0;
        goto L32
    L16:
        r7 = null;
        goto L17
    L13:
        r6 = null;
    L9:
        r5 = null;
        goto L10
    }

    public final int getDisplayType() {
        Data r0 = this.data;
        if (r0 == null) goto L10;
        Data.Entrance r1 = r0.getEntrance();
        if (r1 == null) goto L10;
        Integer r2 = r1.getEntranceDisplayType();
        if (r2 == null) goto L10;
        return r2.intValue();
    L10:
        return EntranceDisplayType.None.getValue();
    }

    public final String getTitleImgUrl() {
        Layout r0 = this.layout;
        if (r0 == null) goto L5;
        Integer r1 = r0.getHSpan();
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 == null) goto L17;
        if (r1.intValue() != 2) goto L17;
        return this.tagUrl;
    L17:
        return this.tagUrl2;
    L9:
        if (r1.intValue() != 4) goto L11;
        return this.bgUrl2;
    L5:
        r1 = null;
        goto L6
    }

    public final Boolean isChannelStatic() {
        String r0 = this.componentId;
        if (r0 == null) goto L15;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L17;
        int r2 = r1.intValue();
        if (200 <= r2) goto L10;
    L12:
        boolean r3 = false;
    L14:
        return Boolean.valueOf(r3);
    L10:
        if (299 < r2) goto L12;
        r3 = true;
        goto L14
    L17:
        return null;
    L15:
        return null;
    }

    public final Bcm getBcm() {
        return this.bcm;
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getBgUrl1() {
        return this.bgUrl1;
    }

    public final String getBgUrl2() {
        return this.bgUrl2;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final Data getData() {
        return this.data;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final Object getFgUrl() {
        return this.fgUrl;
    }

    public final Object getIcon() {
        return this.icon;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final Long getLeftTime() {
        return this.leftTime;
    }

    public final String getLink() {
        return this.link;
    }

    public final LogExtra getLogExtra() {
        return this.logExtra;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOriginChannelCardFIndex() {
        return this.originChannelCardFIndex;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTagUrl() {
        return this.tagUrl;
    }

    public final String getTagUrl2() {
        return this.tagUrl2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getItemImageUrl(int r5) {
        if (r5 >= 0) goto L6;
        return null;
    L6:
        if (getDisplayType() != EntranceDisplayType.StaticEntrance.getValue()) goto L16;
        if (r5 != 0) goto L9;
        Object r6 = this.icon;
        if (r6 != null) goto L15;
        return null;
    L15:
        return b.a(r6);
    L9:
        if (r5 == 1) goto L43;
        return null;
    L43:
        return this.bgUrl2;
    L16:
        Data r1 = this.data;
        if (r1 == null) goto L21;
        List<ECCommonCard> r2 = r1.getItems();
        if (r2 == null) goto L21;
        ECCommonCard r7 = (ECCommonCard) CollectionsKt.getOrNull(r2, r5);
    L22:
        if (r7 == null) goto L24;
        Integer r3 = r7.getType();
    L25:
        int r4 = ECCommonCardType.PRODUCT.getValue();
        if (r3 != null) goto L29;
    L33:
        int r8 = ECCommonCardType.LIVE.getValue();
        if (r3 == null) goto L42;
        if (r3.intValue() != r8) goto L42;
        ECUserStruct r9 = r7.getUser();
        if (r9 != null) goto L49;
        return null;
    L49:
        return r9.getAvatarUrl();
    L42:
        return b.a(this.icon);
    L29:
        if (r3.intValue() != r4) goto L33;
        ECProductStruct r10 = r7.getProduct();
        if (r10 != null) goto L47;
        return null;
    L47:
        return r10.getCoverUrl();
    L24:
        r3 = null;
    L21:
        r7 = null;
        goto L22
    }

    public final String getItemPrice(int r3) {
        if (showItemPrice(r3) == false) goto L14;
        Data r0 = this.data;
        if (r0 == null) goto L15;
        Data.Entrance r1 = r0.getEntrance();
        if (r1 == null) goto L16;
        List<Data.EntrancePit> r2 = r1.getEntranceContentFormat();
        if (r2 == null) goto L17;
        Data.EntrancePit r4 = (Data.EntrancePit) CollectionsKt.getOrNull(r2, r3);
        if (r4 != null) goto L13;
        return null;
    L13:
        return r4.getContent();
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public final String getItemPriceOrTag(int r2) {
        Data r0 = this.data;
        if (r0 == null) goto L11;
        Data.Entrance r1 = r0.getEntrance();
        if (r1 == null) goto L11;
        List<Data.EntrancePit> r3 = r1.getEntranceContentFormat();
        if (r3 == null) goto L11;
        Data.EntrancePit r4 = (Data.EntrancePit) CollectionsKt.getOrNull(r3, r2);
        if (r4 == null) goto L11;
        return r4.getContent();
    L11:
        return null;
    }

    public final String getItemTag(int r3) {
        if (showItemTag(r3) == false) goto L14;
        Data r0 = this.data;
        if (r0 == null) goto L15;
        Data.Entrance r1 = r0.getEntrance();
        if (r1 == null) goto L16;
        List<Data.EntrancePit> r2 = r1.getEntranceContentFormat();
        if (r2 == null) goto L17;
        Data.EntrancePit r4 = (Data.EntrancePit) CollectionsKt.getOrNull(r2, r3);
        if (r4 != null) goto L13;
        return null;
    L13:
        return r4.getContent();
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }

    public final String getNoticeName(int r5) {
        Data r0 = this.data;
        Integer r1 = null;
        if (r0 == null) goto L5;
        Data.Entrance r2 = r0.getEntrance();
    L6:
        if (r2 == null) goto L10;
        List<Data.EntrancePit> r3 = r2.getEntranceContentFormat();
        if (r3 == null) goto L10;
        Data.EntrancePit r6 = (Data.EntrancePit) CollectionsKt.getOrNull(r3, r5);
    L12:
        if (Intrinsics.areEqual(this.componentId, ChannelCID.LIVE_SQUARE.getValue()) == true) goto L34;
        if (r6 == null) goto L16;
        r1 = r6.getTagType();
    L16:
        int r4 = EntranceTagType.PlainText.getValue();
        if (r1 != null) goto L20;
    L25:
        int r7 = EntranceTagType.Price.getValue();
        if (r1 != null) goto L29;
        return "";
    L29:
        if (r1.intValue() == r7) goto L31;
        return "";
    L31:
        return "¥" + r6.getContent();
    L20:
        if (r1.intValue() != r4) goto L25;
        String r8 = r6.getContent();
        if (r8 != null) goto L32;
        return "";
    L32:
        return r8;
    L34:
        return "";
    L10:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final boolean showItemPrice(int r2) {
        Data r0 = this.data;
        if (r0 == null) goto L11;
        Data.Entrance r1 = r0.getEntrance();
        if (r1 == null) goto L11;
        List<Data.EntrancePit> r3 = r1.getEntranceContentFormat();
        if (r3 == null) goto L11;
        Data.EntrancePit r4 = (Data.EntrancePit) CollectionsKt.getOrNull(r3, r2);
        if (r4 == null) goto L11;
        Integer r5 = r4.getTagType();
    L12:
        int r6 = EntranceTagType.Price.getValue();
        if (r5 != null) goto L16;
    L18:
        return false;
    L16:
        if (r5.intValue() != r6) goto L18;
        return true;
    L11:
        r5 = null;
        goto L12
    }

    public final boolean showItemTag(int r2) {
        Data r0 = this.data;
        if (r0 == null) goto L11;
        Data.Entrance r1 = r0.getEntrance();
        if (r1 == null) goto L11;
        List<Data.EntrancePit> r3 = r1.getEntranceContentFormat();
        if (r3 == null) goto L11;
        Data.EntrancePit r4 = (Data.EntrancePit) CollectionsKt.getOrNull(r3, r2);
        if (r4 == null) goto L11;
        Integer r5 = r4.getTagType();
    L12:
        int r6 = EntranceTagType.PlainText.getValue();
        if (r5 != null) goto L16;
    L18:
        return false;
    L16:
        if (r5.intValue() != r6) goto L18;
        return true;
    L11:
        r5 = null;
        goto L12
    }

    public ChannelVO(Layout r3, Object r4, LogExtra r5, String r6, String r7, String r8, String r9, String r10, Object r11, String r12, String r13, String r14, String r15, String r16, Object r17, String r18, String r19, Integer r20, Data r21, Bcm r22, Long r23) {
        this.layout = r3;
        this.extra = r4;
        this.logExtra = r5;
        this.componentId = r6;
        this.moduleId = r7;
        this.name = r8;
        this.title = r9;
        this.subtitle = r10;
        this.icon = r11;
        this.link = r12;
        this.resourceId = r13;
        this.bgUrl = r14;
        this.bgUrl1 = r15;
        this.bgUrl2 = r16;
        this.fgUrl = r17;
        this.tagUrl = r18;
        this.tagUrl2 = r19;
        this.originChannelCardFIndex = r20;
        this.data = r21;
        this.bcm = r22;
        this.leftTime = r23;
    }

    public /* synthetic */ ChannelVO(Layout r23, Object r24, LogExtra r25, String r26, String r27, String r28, String r29, String r30, Object r31, String r32, String r33, String r34, String r35, String r36, Object r37, String r38, String r39, Integer r40, Data r41, Bcm r42, Long r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        Layout r1 = null;
    L7:
        if ((r44 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r44 & 4) == 0) goto L13;
        LogExtra r4 = null;
    L15:
        if ((r44 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r44 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r44 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r44 & 256) == 0) goto L37;
        Object r10 = null;
    L39:
        if ((r44 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r44 & 16384) == 0) goto L61;
        Object r2 = null;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r44 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r44 & 131072) == 0) goto L73;
        Integer r18 = null;
    L75:
        if ((r44 & 262144) == 0) goto L77;
        Data r19 = null;
    L79:
        if ((r44 & 524288) == 0) goto L81;
        Bcm r20 = null;
    L83:
        if ((r44 & 1048576) == 0) goto L85;
        Long r0 = null;
    L86:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r0);
        return;
    L85:
        r0 = r43;
        goto L86
    L81:
        r20 = r42;
        goto L83
    L77:
        r19 = r41;
        goto L79
    L73:
        r18 = r40;
        goto L75
    L69:
        r17 = r39;
        goto L71
    L65:
        r16 = r38;
        goto L67
    L61:
        r2 = r37;
        goto L63
    L57:
        r15 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L55
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }
}
