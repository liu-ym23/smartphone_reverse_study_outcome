package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bO\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010+J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010e\u001a\u00020%HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jé\u0002\u0010r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010s\u001a\u00020%2\b\u0010t\u001a\u0004\u0018\u00010uHÖ\u0003J\t\u0010v\u001a\u00020wHÖ\u0001J\t\u0010x\u001a\u00020yHÖ\u0001R\u0018\u0010&\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00101R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0018\u0010(\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0018\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00105R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00101R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0018\u0010)\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010:R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00103R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u0016\u0010$\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006z"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreDisplay;", "Ljava/io/Serializable;", "shopAvatar", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "shopInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "jumpButton", "trustPics", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "ratingScore", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "peersExceeded", "recommendInfo", "shopPromotionInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "shopProfile", "shopRecommendTitle", "shopBackground", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "storeReputation", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;", "shopSalesText", "shopSlogan", "followAndSellInfo", "", "shopIcon", "shopAvatarIcon", "rankBanner", "reputationIconsAndFans", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "iconList", "shopDistanceText", "shopAmbient", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;", "shopDetailMainInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;", "shopStructOptimize", "", "basicInfoBg", "shopAvatarBorder", "shopAvatarTag", "shopScoreIcons", "shopScoreText", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;ZLcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getBasicInfoBg", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getFollowAndSellInfo", "()Ljava/util/List;", "getIconList", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getJumpButton", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getPeersExceeded", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getRankBanner", "getRatingScore", "getRecommendInfo", "getReputationIconsAndFans", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getShopAmbient", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;", "getShopAvatar", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "getShopAvatarBorder", "getShopAvatarIcon", "getShopAvatarTag", "getShopBackground", "getShopDetailMainInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;", "getShopDistanceText", "getShopIcon", "getShopInfo", "getShopProfile", "getShopPromotionInfo", "getShopRecommendTitle", "getShopSalesText", "getShopScoreIcons", "getShopScoreText", "getShopSlogan", "getShopStructOptimize", "()Z", "getStoreReputation", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;", "getTrustPics", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreDisplay implements Serializable {

    @SerializedName("basic_info_bg")
    private final Background basicInfoBg;

    @SerializedName("follow_and_sell")
    private final List<TextElement> followAndSellInfo;

    @SerializedName("icon_list")
    private final LongContentLabelComponent iconList;

    @SerializedName("jump_button")
    private final TextWithOneIconElement jumpButton;

    @SerializedName("peers_exceeded")
    private final TextElement peersExceeded;

    @SerializedName("rank_banner")
    private final LongContentLabelComponent rankBanner;

    @SerializedName("rating_score")
    private final TextElement ratingScore;

    @SerializedName("recommend_info")
    private final TextElement recommendInfo;

    @SerializedName("reputation_icons_and_fans")
    private final TagsScrollBoxComponent reputationIconsAndFans;

    @SerializedName("shop_ambient")
    private final AnchorV4ShopAmbient shopAmbient;

    @SerializedName("shop_avatar")
    private final MediaBoxElement shopAvatar;

    @SerializedName("shop_avatar_border")
    private final MediaBoxElement shopAvatarBorder;

    @SerializedName("shop_avatar_icon")
    private final TextWithOneIconElement shopAvatarIcon;

    @SerializedName("shop_avatar_tag")
    private final TextWithOneIconElement shopAvatarTag;

    @SerializedName("shop_background")
    private final Background shopBackground;

    @SerializedName("shop_detail_main_info")
    private final AnchorV4ShopDetailMainInfo shopDetailMainInfo;

    @SerializedName("shop_distance")
    private final TextElement shopDistanceText;

    @SerializedName("shop_icon")
    private final TextWithOneIconElement shopIcon;

    @SerializedName("shop_info")
    private final TextWithOneIconElement shopInfo;

    @SerializedName("shop_profile")
    private final LongContentLabelComponent shopProfile;

    @SerializedName("shop_promotion_info")
    private final LongContentLabelComponent shopPromotionInfo;

    @SerializedName("shop_recommend_title")
    private final LongContentLabelComponent shopRecommendTitle;

    @SerializedName("shop_sales")
    private final TextElement shopSalesText;

    @SerializedName("shop_score_icons")
    private final TagsScrollBoxComponent shopScoreIcons;

    @SerializedName("shop_score_text")
    private final TextWithOneIconElement shopScoreText;

    @SerializedName("shop_slogan")
    private final TextWithOneIconElement shopSlogan;

    @SerializedName("shop_struct_optimize")
    private final boolean shopStructOptimize;

    @SerializedName("store_reputation")
    private final AnchorV4ShopAndStoreReputation storeReputation;

    @SerializedName("trust_pics")
    private final IconsWithSpaceElement trustPics;

    public AnchorV4ShopAndStoreDisplay() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreDisplay copy$default(AnchorV4ShopAndStoreDisplay r17, MediaBoxElement r18, TextWithOneIconElement r19, TextWithOneIconElement r20, IconsWithSpaceElement r21, TextElement r22, TextElement r23, TextElement r24, LongContentLabelComponent r25, LongContentLabelComponent r26, LongContentLabelComponent r27, Background r28, AnchorV4ShopAndStoreReputation r29, TextElement r30, TextWithOneIconElement r31, List r32, TextWithOneIconElement r33, TextWithOneIconElement r34, LongContentLabelComponent r35, TagsScrollBoxComponent r36, LongContentLabelComponent r37, TextElement r38, AnchorV4ShopAmbient r39, AnchorV4ShopDetailMainInfo r40, boolean r41, Background r42, MediaBoxElement r43, TextWithOneIconElement r44, TagsScrollBoxComponent r45, TextWithOneIconElement r46, int r47, Object r48) {
        if ((r47 & 1) == 0) goto L5;
        MediaBoxElement r2 = r17.shopAvatar;
    L7:
        if ((r47 & 2) == 0) goto L9;
        TextWithOneIconElement r3 = r17.shopInfo;
    L11:
        if ((r47 & 4) == 0) goto L13;
        TextWithOneIconElement r4 = r17.jumpButton;
    L15:
        if ((r47 & 8) == 0) goto L17;
        IconsWithSpaceElement r5 = r17.trustPics;
    L19:
        if ((r47 & 16) == 0) goto L21;
        TextElement r6 = r17.ratingScore;
    L23:
        if ((r47 & 32) == 0) goto L25;
        TextElement r7 = r17.peersExceeded;
    L27:
        if ((r47 & 64) == 0) goto L29;
        TextElement r8 = r17.recommendInfo;
    L31:
        if ((r47 & 128) == 0) goto L33;
        LongContentLabelComponent r9 = r17.shopPromotionInfo;
    L35:
        if ((r47 & 256) == 0) goto L37;
        LongContentLabelComponent r10 = r17.shopProfile;
    L39:
        if ((r47 & 512) == 0) goto L41;
        LongContentLabelComponent r11 = r17.shopRecommendTitle;
    L43:
        if ((r47 & 1024) == 0) goto L45;
        Background r12 = r17.shopBackground;
    L47:
        if ((r47 & 2048) == 0) goto L49;
        AnchorV4ShopAndStoreReputation r13 = r17.storeReputation;
    L51:
        if ((r47 & 4096) == 0) goto L53;
        TextElement r14 = r17.shopSalesText;
    L55:
        if ((r47 & 8192) == 0) goto L57;
        TextWithOneIconElement r15 = r17.shopSlogan;
    L58:
        TextWithOneIconElement r310 = r15;
        if ((r47 & 16384) == 0) goto L61;
        List r16 = r17.followAndSellInfo;
    L62:
        List r311 = r16;
        if ((r47 & 32768) == 0) goto L65;
        TextWithOneIconElement r110 = r17.shopIcon;
    L66:
        TextWithOneIconElement r312 = r110;
        if ((r47 & 65536) == 0) goto L69;
        TextWithOneIconElement r111 = r17.shopAvatarIcon;
    L70:
        TextWithOneIconElement r313 = r111;
        if ((r47 & 131072) == 0) goto L73;
        LongContentLabelComponent r112 = r17.rankBanner;
    L74:
        LongContentLabelComponent r314 = r112;
        if ((r47 & 262144) == 0) goto L77;
        TagsScrollBoxComponent r113 = r17.reputationIconsAndFans;
    L78:
        TagsScrollBoxComponent r315 = r113;
        if ((r47 & 524288) == 0) goto L81;
        LongContentLabelComponent r114 = r17.iconList;
    L82:
        LongContentLabelComponent r316 = r114;
        if ((r47 & 1048576) == 0) goto L85;
        TextElement r115 = r17.shopDistanceText;
    L86:
        TextElement r317 = r115;
        if ((r47 & 2097152) == 0) goto L89;
        AnchorV4ShopAmbient r116 = r17.shopAmbient;
    L90:
        AnchorV4ShopAmbient r318 = r116;
        if ((r47 & 4194304) == 0) goto L93;
        AnchorV4ShopDetailMainInfo r117 = r17.shopDetailMainInfo;
    L94:
        AnchorV4ShopDetailMainInfo r49 = r117;
        if ((r47 & 8388608) == 0) goto L97;
        boolean r118 = r17.shopStructOptimize;
    L98:
        boolean r410 = r118;
        if ((r47 & 16777216) == 0) goto L101;
        Background r119 = r17.basicInfoBg;
    L102:
        Background r411 = r119;
        if ((r47 & 33554432) == 0) goto L105;
        MediaBoxElement r120 = r17.shopAvatarBorder;
    L106:
        MediaBoxElement r412 = r120;
        if ((r47 & 67108864) == 0) goto L109;
        TextWithOneIconElement r121 = r17.shopAvatarTag;
    L110:
        TextWithOneIconElement r413 = r121;
        if ((r47 & 134217728) == 0) goto L113;
        TagsScrollBoxComponent r122 = r17.shopScoreIcons;
    L115:
        if ((r47 & 268435456) == 0) goto L117;
        TextWithOneIconElement r1 = r17.shopScoreText;
    L119:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r49, r410, r411, r412, r413, r122, r1);
    L117:
        r1 = r46;
        goto L119
    L113:
        r122 = r45;
        goto L115
    L109:
        r121 = r44;
        goto L110
    L105:
        r120 = r43;
        goto L106
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
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

    public final MediaBoxElement component1() {
        return this.shopAvatar;
    }

    public final LongContentLabelComponent component10() {
        return this.shopRecommendTitle;
    }

    public final Background component11() {
        return this.shopBackground;
    }

    public final AnchorV4ShopAndStoreReputation component12() {
        return this.storeReputation;
    }

    public final TextElement component13() {
        return this.shopSalesText;
    }

    public final TextWithOneIconElement component14() {
        return this.shopSlogan;
    }

    public final List<TextElement> component15() {
        return this.followAndSellInfo;
    }

    public final TextWithOneIconElement component16() {
        return this.shopIcon;
    }

    public final TextWithOneIconElement component17() {
        return this.shopAvatarIcon;
    }

    public final LongContentLabelComponent component18() {
        return this.rankBanner;
    }

    public final TagsScrollBoxComponent component19() {
        return this.reputationIconsAndFans;
    }

    public final TextWithOneIconElement component2() {
        return this.shopInfo;
    }

    public final LongContentLabelComponent component20() {
        return this.iconList;
    }

    public final TextElement component21() {
        return this.shopDistanceText;
    }

    public final AnchorV4ShopAmbient component22() {
        return this.shopAmbient;
    }

    public final AnchorV4ShopDetailMainInfo component23() {
        return this.shopDetailMainInfo;
    }

    public final boolean component24() {
        return this.shopStructOptimize;
    }

    public final Background component25() {
        return this.basicInfoBg;
    }

    public final MediaBoxElement component26() {
        return this.shopAvatarBorder;
    }

    public final TextWithOneIconElement component27() {
        return this.shopAvatarTag;
    }

    public final TagsScrollBoxComponent component28() {
        return this.shopScoreIcons;
    }

    public final TextWithOneIconElement component29() {
        return this.shopScoreText;
    }

    public final TextWithOneIconElement component3() {
        return this.jumpButton;
    }

    public final IconsWithSpaceElement component4() {
        return this.trustPics;
    }

    public final TextElement component5() {
        return this.ratingScore;
    }

    public final TextElement component6() {
        return this.peersExceeded;
    }

    public final TextElement component7() {
        return this.recommendInfo;
    }

    public final LongContentLabelComponent component8() {
        return this.shopPromotionInfo;
    }

    public final LongContentLabelComponent component9() {
        return this.shopProfile;
    }

    public final AnchorV4ShopAndStoreDisplay copy(MediaBoxElement r32, TextWithOneIconElement r33, TextWithOneIconElement r34, IconsWithSpaceElement r35, TextElement r36, TextElement r37, TextElement r38, LongContentLabelComponent r39, LongContentLabelComponent r40, LongContentLabelComponent r41, Background r42, AnchorV4ShopAndStoreReputation r43, TextElement r44, TextWithOneIconElement r45, List<TextElement> r46, TextWithOneIconElement r47, TextWithOneIconElement r48, LongContentLabelComponent r49, TagsScrollBoxComponent r50, LongContentLabelComponent r51, TextElement r52, AnchorV4ShopAmbient r53, AnchorV4ShopDetailMainInfo r54, boolean r55, Background r56, MediaBoxElement r57, TextWithOneIconElement r58, TagsScrollBoxComponent r59, TextWithOneIconElement r60) {
        return new AnchorV4ShopAndStoreDisplay(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4ShopAndStoreDisplay) == false) goto L64;
        AnchorV4ShopAndStoreDisplay r4 = (AnchorV4ShopAndStoreDisplay) r3;
        if (Intrinsics.areEqual(this.shopAvatar, r4.shopAvatar) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopInfo, r4.shopInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpButton, r4.jumpButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trustPics, r4.trustPics) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ratingScore, r4.ratingScore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.peersExceeded, r4.peersExceeded) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendInfo, r4.recommendInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.shopPromotionInfo, r4.shopPromotionInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopProfile, r4.shopProfile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopRecommendTitle, r4.shopRecommendTitle) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shopBackground, r4.shopBackground) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.storeReputation, r4.storeReputation) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shopSalesText, r4.shopSalesText) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.shopSlogan, r4.shopSlogan) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.followAndSellInfo, r4.followAndSellInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.shopIcon, r4.shopIcon) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.shopAvatarIcon, r4.shopAvatarIcon) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.rankBanner, r4.rankBanner) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.reputationIconsAndFans, r4.reputationIconsAndFans) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.iconList, r4.iconList) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.shopDistanceText, r4.shopDistanceText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.shopAmbient, r4.shopAmbient) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.shopDetailMainInfo, r4.shopDetailMainInfo) == true) goto L52;
        return false;
    L52:
        if (this.shopStructOptimize == r4.shopStructOptimize) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.basicInfoBg, r4.basicInfoBg) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.shopAvatarBorder, r4.shopAvatarBorder) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.shopAvatarTag, r4.shopAvatarTag) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.shopScoreIcons, r4.shopScoreIcons) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.shopScoreText, r4.shopScoreText) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v67, types: [int] */
    /* JADX WARN: Type inference failed for: r2v85 */
    public int hashCode() {
        MediaBoxElement r0 = this.shopAvatar;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TextWithOneIconElement r4 = this.shopInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextWithOneIconElement r7 = this.jumpButton;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        IconsWithSpaceElement r10 = this.trustPics;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        TextElement r13 = this.ratingScore;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        TextElement r16 = this.peersExceeded;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        TextElement r19 = this.recommendInfo;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        LongContentLabelComponent r22 = this.shopPromotionInfo;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        LongContentLabelComponent r25 = this.shopProfile;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        LongContentLabelComponent r28 = this.shopRecommendTitle;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Background r31 = this.shopBackground;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        AnchorV4ShopAndStoreReputation r34 = this.storeReputation;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        TextElement r37 = this.shopSalesText;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        TextWithOneIconElement r40 = this.shopSlogan;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        List<TextElement> r43 = this.followAndSellInfo;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        TextWithOneIconElement r46 = this.shopIcon;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        TextWithOneIconElement r49 = this.shopAvatarIcon;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        LongContentLabelComponent r52 = this.rankBanner;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        TagsScrollBoxComponent r55 = this.reputationIconsAndFans;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        LongContentLabelComponent r58 = this.iconList;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        TextElement r61 = this.shopDistanceText;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        AnchorV4ShopAmbient r64 = this.shopAmbient;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        AnchorV4ShopDetailMainInfo r67 = this.shopDetailMainInfo;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        boolean r70 = this.shopStructOptimize;
        ?? r71 = r70;
        if (r70 == false) goto L97;
        r71 = 1;
    L97:
        int r72 = (r69 + r71) * 31;
        Background r73 = this.basicInfoBg;
        if (r73 == null) goto L100;
        int r74 = r73.hashCode();
    L101:
        int r75 = (r72 + r74) * 31;
        MediaBoxElement r76 = this.shopAvatarBorder;
        if (r76 == null) goto L104;
        int r77 = r76.hashCode();
    L105:
        int r78 = (r75 + r77) * 31;
        TextWithOneIconElement r79 = this.shopAvatarTag;
        if (r79 == null) goto L108;
        int r80 = r79.hashCode();
    L109:
        int r81 = (r78 + r80) * 31;
        TagsScrollBoxComponent r82 = this.shopScoreIcons;
        if (r82 == null) goto L112;
        int r84 = r82.hashCode();
    L113:
        int r85 = (r81 + r84) * 31;
        TextWithOneIconElement r86 = this.shopScoreText;
        if (r86 == null) goto L117;
        r1 = r86.hashCode();
    L117:
        return r85 + r1;
    L112:
        r84 = 0;
        goto L113
    L108:
        r80 = 0;
        goto L109
    L104:
        r77 = 0;
        goto L105
    L100:
        r74 = 0;
        goto L101
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
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
        return "AnchorV4ShopAndStoreDisplay(shopAvatar=" + this.shopAvatar + ", shopInfo=" + this.shopInfo + ", jumpButton=" + this.jumpButton + ", trustPics=" + this.trustPics + ", ratingScore=" + this.ratingScore + ", peersExceeded=" + this.peersExceeded + ", recommendInfo=" + this.recommendInfo + ", shopPromotionInfo=" + this.shopPromotionInfo + ", shopProfile=" + this.shopProfile + ", shopRecommendTitle=" + this.shopRecommendTitle + ", shopBackground=" + this.shopBackground + ", storeReputation=" + this.storeReputation + ", shopSalesText=" + this.shopSalesText + ", shopSlogan=" + this.shopSlogan + ", followAndSellInfo=" + this.followAndSellInfo + ", shopIcon=" + this.shopIcon + ", shopAvatarIcon=" + this.shopAvatarIcon + ", rankBanner=" + this.rankBanner + ", reputationIconsAndFans=" + this.reputationIconsAndFans + ", iconList=" + this.iconList + ", shopDistanceText=" + this.shopDistanceText + ", shopAmbient=" + this.shopAmbient + ", shopDetailMainInfo=" + this.shopDetailMainInfo + ", shopStructOptimize=" + this.shopStructOptimize + ", basicInfoBg=" + this.basicInfoBg + ", shopAvatarBorder=" + this.shopAvatarBorder + ", shopAvatarTag=" + this.shopAvatarTag + ", shopScoreIcons=" + this.shopScoreIcons + ", shopScoreText=" + this.shopScoreText + ")";
    }

    public final Background getBasicInfoBg() {
        return this.basicInfoBg;
    }

    public final List<TextElement> getFollowAndSellInfo() {
        return this.followAndSellInfo;
    }

    public final LongContentLabelComponent getIconList() {
        return this.iconList;
    }

    public final TextWithOneIconElement getJumpButton() {
        return this.jumpButton;
    }

    public final TextElement getPeersExceeded() {
        return this.peersExceeded;
    }

    public final LongContentLabelComponent getRankBanner() {
        return this.rankBanner;
    }

    public final TextElement getRatingScore() {
        return this.ratingScore;
    }

    public final TextElement getRecommendInfo() {
        return this.recommendInfo;
    }

    public final TagsScrollBoxComponent getReputationIconsAndFans() {
        return this.reputationIconsAndFans;
    }

    public final AnchorV4ShopAmbient getShopAmbient() {
        return this.shopAmbient;
    }

    public final MediaBoxElement getShopAvatar() {
        return this.shopAvatar;
    }

    public final MediaBoxElement getShopAvatarBorder() {
        return this.shopAvatarBorder;
    }

    public final TextWithOneIconElement getShopAvatarIcon() {
        return this.shopAvatarIcon;
    }

    public final TextWithOneIconElement getShopAvatarTag() {
        return this.shopAvatarTag;
    }

    public final Background getShopBackground() {
        return this.shopBackground;
    }

    public final AnchorV4ShopDetailMainInfo getShopDetailMainInfo() {
        return this.shopDetailMainInfo;
    }

    public final TextElement getShopDistanceText() {
        return this.shopDistanceText;
    }

    public final TextWithOneIconElement getShopIcon() {
        return this.shopIcon;
    }

    public final TextWithOneIconElement getShopInfo() {
        return this.shopInfo;
    }

    public final LongContentLabelComponent getShopProfile() {
        return this.shopProfile;
    }

    public final LongContentLabelComponent getShopPromotionInfo() {
        return this.shopPromotionInfo;
    }

    public final LongContentLabelComponent getShopRecommendTitle() {
        return this.shopRecommendTitle;
    }

    public final TextElement getShopSalesText() {
        return this.shopSalesText;
    }

    public final TagsScrollBoxComponent getShopScoreIcons() {
        return this.shopScoreIcons;
    }

    public final TextWithOneIconElement getShopScoreText() {
        return this.shopScoreText;
    }

    public final TextWithOneIconElement getShopSlogan() {
        return this.shopSlogan;
    }

    public final boolean getShopStructOptimize() {
        return this.shopStructOptimize;
    }

    public final AnchorV4ShopAndStoreReputation getStoreReputation() {
        return this.storeReputation;
    }

    public final IconsWithSpaceElement getTrustPics() {
        return this.trustPics;
    }

    public AnchorV4ShopAndStoreDisplay(MediaBoxElement r3, TextWithOneIconElement r4, TextWithOneIconElement r5, IconsWithSpaceElement r6, TextElement r7, TextElement r8, TextElement r9, LongContentLabelComponent r10, LongContentLabelComponent r11, LongContentLabelComponent r12, Background r13, AnchorV4ShopAndStoreReputation r14, TextElement r15, TextWithOneIconElement r16, List<TextElement> r17, TextWithOneIconElement r18, TextWithOneIconElement r19, LongContentLabelComponent r20, TagsScrollBoxComponent r21, LongContentLabelComponent r22, TextElement r23, AnchorV4ShopAmbient r24, AnchorV4ShopDetailMainInfo r25, boolean r26, Background r27, MediaBoxElement r28, TextWithOneIconElement r29, TagsScrollBoxComponent r30, TextWithOneIconElement r31) {
        this.shopAvatar = r3;
        this.shopInfo = r4;
        this.jumpButton = r5;
        this.trustPics = r6;
        this.ratingScore = r7;
        this.peersExceeded = r8;
        this.recommendInfo = r9;
        this.shopPromotionInfo = r10;
        this.shopProfile = r11;
        this.shopRecommendTitle = r12;
        this.shopBackground = r13;
        this.storeReputation = r14;
        this.shopSalesText = r15;
        this.shopSlogan = r16;
        this.followAndSellInfo = r17;
        this.shopIcon = r18;
        this.shopAvatarIcon = r19;
        this.rankBanner = r20;
        this.reputationIconsAndFans = r21;
        this.iconList = r22;
        this.shopDistanceText = r23;
        this.shopAmbient = r24;
        this.shopDetailMainInfo = r25;
        this.shopStructOptimize = r26;
        this.basicInfoBg = r27;
        this.shopAvatarBorder = r28;
        this.shopAvatarTag = r29;
        this.shopScoreIcons = r30;
        this.shopScoreText = r31;
    }

    public /* synthetic */ AnchorV4ShopAndStoreDisplay(MediaBoxElement r31, TextWithOneIconElement r32, TextWithOneIconElement r33, IconsWithSpaceElement r34, TextElement r35, TextElement r36, TextElement r37, LongContentLabelComponent r38, LongContentLabelComponent r39, LongContentLabelComponent r40, Background r41, AnchorV4ShopAndStoreReputation r42, TextElement r43, TextWithOneIconElement r44, List r45, TextWithOneIconElement r46, TextWithOneIconElement r47, LongContentLabelComponent r48, TagsScrollBoxComponent r49, LongContentLabelComponent r50, TextElement r51, AnchorV4ShopAmbient r52, AnchorV4ShopDetailMainInfo r53, boolean r54, Background r55, MediaBoxElement r56, TextWithOneIconElement r57, TagsScrollBoxComponent r58, TextWithOneIconElement r59, int r60, DefaultConstructorMarker r61) {
        if ((r60 & 1) == 0) goto L5;
        MediaBoxElement r1 = null;
    L7:
        if ((r60 & 2) == 0) goto L9;
        TextWithOneIconElement r3 = null;
    L11:
        if ((r60 & 4) == 0) goto L13;
        TextWithOneIconElement r4 = null;
    L15:
        if ((r60 & 8) == 0) goto L17;
        IconsWithSpaceElement r5 = null;
    L19:
        if ((r60 & 16) == 0) goto L21;
        TextElement r6 = null;
    L23:
        if ((r60 & 32) == 0) goto L25;
        TextElement r7 = null;
    L27:
        if ((r60 & 64) == 0) goto L29;
        TextElement r8 = null;
    L31:
        if ((r60 & 128) == 0) goto L33;
        LongContentLabelComponent r9 = null;
    L35:
        if ((r60 & 256) == 0) goto L37;
        LongContentLabelComponent r10 = null;
    L39:
        if ((r60 & 512) == 0) goto L41;
        LongContentLabelComponent r11 = null;
    L43:
        if ((r60 & 1024) == 0) goto L45;
        Background r12 = null;
    L47:
        if ((r60 & 2048) == 0) goto L49;
        AnchorV4ShopAndStoreReputation r13 = null;
    L51:
        if ((r60 & 4096) == 0) goto L53;
        TextElement r14 = null;
    L55:
        if ((r60 & 8192) == 0) goto L57;
        TextWithOneIconElement r15 = null;
    L59:
        if ((r60 & 16384) == 0) goto L61;
        List r2 = null;
    L63:
        if ((r60 & 32768) == 0) goto L65;
        TextWithOneIconElement r16 = null;
    L67:
        if ((r60 & 65536) == 0) goto L69;
        TextWithOneIconElement r17 = null;
    L71:
        if ((r60 & 131072) == 0) goto L73;
        LongContentLabelComponent r18 = null;
    L75:
        if ((r60 & 262144) == 0) goto L77;
        TagsScrollBoxComponent r19 = null;
    L79:
        if ((r60 & 524288) == 0) goto L81;
        LongContentLabelComponent r20 = null;
    L83:
        if ((r60 & 1048576) == 0) goto L85;
        TextElement r21 = null;
    L87:
        if ((r60 & 2097152) == 0) goto L89;
        AnchorV4ShopAmbient r22 = null;
    L91:
        if ((r60 & 4194304) == 0) goto L93;
        AnchorV4ShopDetailMainInfo r23 = null;
    L95:
        if ((r60 & 8388608) == 0) goto L97;
        boolean r24 = false;
    L99:
        if ((r60 & 16777216) == 0) goto L101;
        Background r25 = null;
    L103:
        if ((r60 & 33554432) == 0) goto L105;
        MediaBoxElement r26 = null;
    L107:
        if ((r60 & 67108864) == 0) goto L109;
        TextWithOneIconElement r27 = null;
    L111:
        if ((r60 & 134217728) == 0) goto L113;
        TagsScrollBoxComponent r28 = null;
    L115:
        if ((r60 & 268435456) == 0) goto L117;
        TextWithOneIconElement r0 = null;
    L118:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r0);
        return;
    L117:
        r0 = r59;
        goto L118
    L113:
        r28 = r58;
        goto L115
    L109:
        r27 = r57;
        goto L111
    L105:
        r26 = r56;
        goto L107
    L101:
        r25 = r55;
        goto L103
    L97:
        r24 = r54;
        goto L99
    L93:
        r23 = r53;
        goto L95
    L89:
        r22 = r52;
        goto L91
    L85:
        r21 = r51;
        goto L87
    L81:
        r20 = r50;
        goto L83
    L77:
        r19 = r49;
        goto L79
    L73:
        r18 = r48;
        goto L75
    L69:
        r17 = r47;
        goto L71
    L65:
        r16 = r46;
        goto L67
    L61:
        r2 = r45;
        goto L63
    L57:
        r15 = r44;
        goto L59
    L53:
        r14 = r43;
        goto L55
    L49:
        r13 = r42;
        goto L51
    L45:
        r12 = r41;
        goto L47
    L41:
        r11 = r40;
        goto L43
    L37:
        r10 = r39;
        goto L39
    L33:
        r9 = r38;
        goto L35
    L29:
        r8 = r37;
        goto L31
    L25:
        r7 = r36;
        goto L27
    L21:
        r6 = r35;
        goto L23
    L17:
        r5 = r34;
        goto L19
    L13:
        r4 = r33;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r31;
        goto L7
    }
}
