package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.Point;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.FeaturedComment;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.AnchorV4KolEvaluationBusinessMeta;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0086\b\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001YB\u0099\u0001\u0012\u0012\b\u0002\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bV\u0010WJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\n\u001a\u00020\tJ\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J¢\u0001\u0010)\u001a\u00020\u00002\u0012\b\u0002\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\u0012\b\u0002\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010%\u001a\u00020\t2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0004\b)\u0010*J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0015HÖ\u0001J\u0013\u0010/\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003R\u001d\u00105\u001a\u0004\u0018\u0001008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u00108R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b:\u0010;R\u001c\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010>R$\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b?\u00108R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010$\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010F\u001a\u0004\bG\u0010\u0017R\u001a\u0010%\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010&\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010F\u001a\u0004\bK\u0010\u0017R$\u0010'\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010(\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadVO;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/VOIdentifier;", "Ljava/io/Serializable;", "", "identifier", "productId", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/b;", "extractHeadViewNodeGroupList", "", "isLengthenedPicture", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/SlidesGroup;", "component1", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "component2", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "component3", "component4", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "component8", "component9", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component10", "Landroid/graphics/drawable/Drawable;", "component11", "tabList", "floatButtonElements", "scrollMoreText", "skuTabItems", "findSameEntryElement", "headTabBgColor", "containerSizeType", "headTabExpand", "maxTabNum", "component", "headerImagePlaceHolder", "copy", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Landroid/graphics/drawable/Drawable;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadVO;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadMeta;", "headMeta$delegate", "Lkotlin/Lazy;", "getHeadMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadMeta;", "headMeta", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getFloatButtonElements", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "getScrollMoreText", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "getSkuTabItems", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameEntryElement", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "Ljava/lang/String;", "getHeadTabBgColor", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getContainerSizeType", "Z", "getHeadTabExpand", "()Z", "getMaxTabNum", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getComponent", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "setComponent", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;)V", "Landroid/graphics/drawable/Drawable;", "getHeaderImagePlaceHolder", "()Landroid/graphics/drawable/Drawable;", "setHeaderImagePlaceHolder", "(Landroid/graphics/drawable/Drawable;)V", "<init>", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Landroid/graphics/drawable/Drawable;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadVO extends VOIdentifier implements Serializable {
    public static final a Companion = null;
    public static final int HEADER_PICTURE_STYLE_LENGTHEN = 1;
    private ComponentDTO component;

    @SerializedName("head_container_size_type")
    private final Integer containerSizeType;

    @SerializedName("find_same_entry")
    private final CommonFindSameElement findSameEntryElement;

    @SerializedName("float_button_elements")
    private final TagsScrollBoxComponent floatButtonElements;
    private final Lazy headMeta$delegate;

    @SerializedName("head_tab_bg_color")
    private final String headTabBgColor;

    @SerializedName("tab_expand")
    private final boolean headTabExpand;
    private Drawable headerImagePlaceHolder;

    @SerializedName("max_tab_num")
    private final Integer maxTabNum;

    @SerializedName("scroll_more_text")
    private final ScrollMoreText scrollMoreText;

    @SerializedName("sku_tab_items")
    private final List<SlidesGroup> skuTabItems;

    @SerializedName("tab_data_list")
    private final List<SlidesGroup> tabList;

    public static final class a {
        public a() {
        }

        public static AnchorV4HeadVO a(ComponentDTO r5) {
            Intrinsics.checkNotNullParameter(r5, "componentDTO");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            VO r2 = r5.getVo();     // Catch: Throwable -> L9
            if (r2 == null) goto L6;
            JsonObject r3 = r2.getDisplay();     // Catch: Throwable -> L9
        L7:
            Object r4 = u0.a(r3, AnchorV4HeadVO.class);     // Catch: Throwable -> L9
            AnchorV4HeadVO r6 = (AnchorV4HeadVO) r4;     // Catch: Throwable -> L9
            r6.setComponent(r5);     // Catch: Throwable -> L9
            VOIdentifier.scrollConfig$default(r6, ComponentIDs.HEAD_SLIDES.getId(), 0, 2, null);     // Catch: Throwable -> L9
            return (AnchorV4HeadVO) r4;
        L6:
            r3 = null;
        L9:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public AnchorV4HeadVO() {
        this(null, null, null, null, null, null, null, false, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4HeadVO copy$default(AnchorV4HeadVO r12, List r13, TagsScrollBoxComponent r14, ScrollMoreText r15, List r16, CommonFindSameElement r17, String r18, Integer r19, boolean r20, Integer r21, ComponentDTO r22, Drawable r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        List r2 = r12.tabList;
    L7:
        if ((r24 & 2) == 0) goto L9;
        TagsScrollBoxComponent r3 = r12.floatButtonElements;
    L11:
        if ((r24 & 4) == 0) goto L13;
        ScrollMoreText r4 = r12.scrollMoreText;
    L15:
        if ((r24 & 8) == 0) goto L17;
        List r5 = r12.skuTabItems;
    L19:
        if ((r24 & 16) == 0) goto L21;
        CommonFindSameElement r6 = r12.findSameEntryElement;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.headTabBgColor;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r8 = r12.containerSizeType;
    L31:
        if ((r24 & 128) == 0) goto L33;
        boolean r9 = r12.headTabExpand;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Integer r10 = r12.maxTabNum;
    L39:
        if ((r24 & 512) == 0) goto L41;
        ComponentDTO r11 = r12.component;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Drawable r1 = r12.headerImagePlaceHolder;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final List<SlidesGroup> component1() {
        return this.tabList;
    }

    public final ComponentDTO component10() {
        return this.component;
    }

    public final Drawable component11() {
        return this.headerImagePlaceHolder;
    }

    public final TagsScrollBoxComponent component2() {
        return this.floatButtonElements;
    }

    public final ScrollMoreText component3() {
        return this.scrollMoreText;
    }

    public final List<SlidesGroup> component4() {
        return this.skuTabItems;
    }

    public final CommonFindSameElement component5() {
        return this.findSameEntryElement;
    }

    public final String component6() {
        return this.headTabBgColor;
    }

    public final Integer component7() {
        return this.containerSizeType;
    }

    public final boolean component8() {
        return this.headTabExpand;
    }

    public final Integer component9() {
        return this.maxTabNum;
    }

    public final AnchorV4HeadVO copy(List<SlidesGroup> r14, TagsScrollBoxComponent r15, ScrollMoreText r16, List<SlidesGroup> r17, CommonFindSameElement r18, String r19, Integer r20, boolean r21, Integer r22, ComponentDTO r23, Drawable r24) {
        return new AnchorV4HeadVO(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4HeadVO) == false) goto L28;
        AnchorV4HeadVO r4 = (AnchorV4HeadVO) r3;
        if (Intrinsics.areEqual(this.tabList, r4.tabList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.floatButtonElements, r4.floatButtonElements) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.scrollMoreText, r4.scrollMoreText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skuTabItems, r4.skuTabItems) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.findSameEntryElement, r4.findSameEntryElement) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.headTabBgColor, r4.headTabBgColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.containerSizeType, r4.containerSizeType) == true) goto L20;
        return false;
    L20:
        if (this.headTabExpand == r4.headTabExpand) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.maxTabNum, r4.maxTabNum) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.component, r4.component) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.headerImagePlaceHolder, r4.headerImagePlaceHolder) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final AnchorV4HeadMeta getHeadMeta() {
        return (AnchorV4HeadMeta) this.headMeta$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v36 */
    public int hashCode() {
        List<SlidesGroup> r0 = this.tabList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TagsScrollBoxComponent r4 = this.floatButtonElements;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ScrollMoreText r7 = this.scrollMoreText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<SlidesGroup> r10 = this.skuTabItems;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        CommonFindSameElement r13 = this.findSameEntryElement;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.headTabBgColor;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.containerSizeType;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.headTabExpand;
        ?? r23 = r22;
        if (r22 == false) goto L33;
        r23 = 1;
    L33:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.maxTabNum;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        ComponentDTO r28 = this.component;
        if (r28 == null) goto L40;
        int r29 = r28.hashCode();
    L41:
        int r30 = (r27 + r29) * 31;
        Drawable r31 = this.headerImagePlaceHolder;
        if (r31 == null) goto L45;
        r1 = r31.hashCode();
    L45:
        return r30 + r1;
    L40:
        r29 = 0;
        goto L41
    L36:
        r26 = 0;
        goto L37
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
        return "AnchorV4HeadVO(tabList=" + this.tabList + ", floatButtonElements=" + this.floatButtonElements + ", scrollMoreText=" + this.scrollMoreText + ", skuTabItems=" + this.skuTabItems + ", findSameEntryElement=" + this.findSameEntryElement + ", headTabBgColor=" + this.headTabBgColor + ", containerSizeType=" + this.containerSizeType + ", headTabExpand=" + this.headTabExpand + ", maxTabNum=" + this.maxTabNum + ", component=" + this.component + ", headerImagePlaceHolder=" + this.headerImagePlaceHolder + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public String identifier() {
        ComponentDTO r0 = this.component;
        if (r0 == null) goto L5;
        String r1 = r0.getComponentId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isLengthenedPicture() {
        Integer r0 = this.containerSizeType;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public final ComponentDTO getComponent() {
        return this.component;
    }

    public final Integer getContainerSizeType() {
        return this.containerSizeType;
    }

    public final CommonFindSameElement getFindSameEntryElement() {
        return this.findSameEntryElement;
    }

    public final TagsScrollBoxComponent getFloatButtonElements() {
        return this.floatButtonElements;
    }

    public final String getHeadTabBgColor() {
        return this.headTabBgColor;
    }

    public final boolean getHeadTabExpand() {
        return this.headTabExpand;
    }

    public final Drawable getHeaderImagePlaceHolder() {
        return this.headerImagePlaceHolder;
    }

    public final Integer getMaxTabNum() {
        return this.maxTabNum;
    }

    public final ScrollMoreText getScrollMoreText() {
        return this.scrollMoreText;
    }

    public final List<SlidesGroup> getSkuTabItems() {
        return this.skuTabItems;
    }

    public final List<SlidesGroup> getTabList() {
        return this.tabList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.util.ArrayList] */
    public final List<b> extractHeadViewNodeGroupList(String r55) {
        List<SlidesGroup> r0 = this.tabList;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r8 = CollectionsKt.filterNotNull(r0);
        LinkedHashMap r9 = new LinkedHashMap();
        List r1 = r8;
        Iterator r2 = r1.iterator();
    L6:
        int r10 = 1;
        int r11 = 0;
        if (r2.hasNext() == false) goto L12;
        SlidesGroup r3 = (SlidesGroup) r2.next();
        Integer r4 = Integer.valueOf(r3.getType());
        Integer r5 = (Integer) r9.get(Integer.valueOf(r3.getType()));
        if (r5 == null) goto L11;
        r11 = r5.intValue();
    L11:
        r9.put(r4, Integer.valueOf(r11 + 1));
        goto L6
    L12:
        ArrayList r12 = new ArrayList();
        HashMap<Integer, String> r6 = c.J;
        List<SlidesGroup> r7 = this.skuTabItems;
        if (r7 != null) goto L15;
        c r41 = null;
    L51:
        if (r41 == null) goto L59;
        String r17 = String.valueOf(8);
        int r13 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.a;
        int r44 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.a(HeadViewType.SKU.getType(), null);
        List<SlidesGroup> r14 = this.skuTabItems;
        if (r14 == null) goto L57;
        SlidesGroup r15 = (SlidesGroup) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L57;
        int r16 = r15.getType();
    L58:
        b r18 = new b(null, r17, CollectionsKt.listOf(c.a(r41, null, String.valueOf(r16), r44, null, null, null, this.scrollMoreText, false, null, null, -536577, 7)), true, null, 17);
    L60:
        List<SlidesGroup> r19 = this.skuTabItems;
        if (r19 == null) goto L65;
        SlidesGroup r20 = (SlidesGroup) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L65;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.b.put(String.valueOf(r20.getType()), "");
    L65:
        List r110 = CollectionsKt.listOfNotNull(r18);
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r111 = r1.iterator();
        int r22 = 0;
    L67:
        if (r111.hasNext() == false) goto L109;
        Object r23 = r111.next();
        int r112 = r22 + 1;
        if (r22 >= 0) goto L71;
        CollectionsKt.throwIndexOverflow();
    L71:
        SlidesGroup r113 = (SlidesGroup) r23;
        TextElement r24 = r113.getTitle();
        if (r24 == null) goto L74;
        String r25 = r24.getText();
    L75:
        if (r25 != null) goto L77;
        String r26 = null;
    L89:
        TextElement r27 = r113.getTitle();
        if (r27 == null) goto L92;
        String r28 = r27.getText();
    L93:
        TextElement r29 = r113.getTitle();
        if (r29 == null) goto L96;
        String r30 = r29.getText();
    L97:
        if (r26 != null) goto L99;
        String r31 = "";
    L101:
        if (r110.isEmpty() == true) goto L103;
    L107:
        boolean r32 = false;
    L108:
        ArrayList r114 = r21;
        r114.add(new b(r28, r26, a(r113, r30, r31, r32, r55, r113.getTabTypeName()), false, r113.getTabTypeName(), 8));
        r21 = r114;
        r22 = r112;
        r10 = 1;
        goto L67
    L103:
        if (this.scrollMoreText == null) goto L107;
        if (r22 != (r8.size() - r10)) goto L107;
        r32 = true;
        goto L108
    L99:
        r31 = r26;
        goto L101
    L96:
        r30 = null;
        goto L97
    L92:
        r28 = null;
        goto L93
    L77:
        Integer r33 = (Integer) r9.get(Integer.valueOf(r113.getType()));
        if (r33 == null) goto L80;
        int r34 = r33.intValue();
    L81:
        if (r34 <= r10) goto L87;
        StringBuilder r35 = new StringBuilder();
        r35.append(r113.getType());
        r35.append('_');
        TextElement r36 = r113.getTitle();
        if (r36 == null) goto L85;
        String r37 = r36.getText();
    L86:
        r35.append(r37);
        String r38 = r35.toString();
    L88:
        r26 = r38;
        goto L89
    L85:
        r37 = null;
        goto L86
    L87:
        r38 = String.valueOf(r113.getType());
        goto L88
    L80:
        r34 = 0;
        goto L81
    L74:
        r25 = null;
        goto L75
    L109:
        r12.addAll(r21);
        r12.addAll(r110);
        return r12;
    L57:
        r16 = 0;
        goto L58
    L59:
        r18 = null;
        goto L60
    L15:
        String r115 = HeadViewType.SKU.getType();
        ArrayList r39 = new ArrayList();
        List<SlidesGroup> r40 = r7;
        Iterator r42 = r40.iterator();
    L17:
        if (r42.hasNext() == false) goto L30;
        SlidesGroup r43 = (SlidesGroup) r42.next();
        if (r43 == null) goto L28;
        List<ImageModel> r45 = r43.getImages();
        if (r45 == null) goto L28;
        List r46 = new ArrayList();
        Iterator r47 = r45.iterator();
    L24:
        if (r47.hasNext() == false) goto L29;
        ECUrlModel r116 = ((ImageModel) r47.next()).getRemote();
        if (r116 == null) goto L24;
        r46.add(r116);
    L29:
        r39.addAll(r46);
    L28:
        r46 = CollectionsKt.emptyList();
        goto L29
    L30:
        Unit r48 = Unit.INSTANCE;
        ArrayList r49 = new ArrayList();
        Iterator r50 = r40.iterator();
    L32:
        if (r50.hasNext() == false) goto L42;
        SlidesGroup r51 = (SlidesGroup) r50.next();
        if (r51 == null) goto L38;
        TextElement r52 = r51.getTitle();
        if (r52 == null) goto L38;
        String r53 = r52.getText();
    L39:
        if (r53 != null) goto L41;
        r53 = "";
    L41:
        r49.add(r53);
    L38:
        r53 = null;
        goto L39
    L42:
        Unit r54 = Unit.INSTANCE;
        ArrayList r56 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator r57 = r40.iterator();
    L44:
        if (r57.hasNext() == false) goto L50;
        SlidesGroup r58 = (SlidesGroup) r57.next();
        if (r58 == null) goto L48;
        String r59 = r58.getFindSameGoodsSchema();
    L49:
        r56.add(r59);
        goto L44
    L48:
        r59 = null;
        goto L49
    L50:
        r41 = new c(r115, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r39, r49, r56, null, null, null, false, null, -58720258, 7);
        goto L51
    }

    public final void setComponent(ComponentDTO r1) {
        this.component = r1;
    }

    public final void setHeaderImagePlaceHolder(Drawable r1) {
        this.headerImagePlaceHolder = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<c> a(SlidesGroup r59, String r60, String r61, boolean r62, String r63, String r64) {
        if (r60 == null) goto L6;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.b.put(r61, r60);
    L6:
        Drawable r14 = null;
        int r3 = 0;
        int r13 = 1;
        switch(r59.getType()) {
            case 0: goto L231;
            case 1: goto L216;
            case 2: goto L191;
            case 3: goto L167;
            case 4: goto L98;
            case 5: goto L51;
            case 6: goto L27;
            case 7: goto L18;
            case 8: goto L8;
            case 9: goto L9;
            default: goto L8;
        };
    L8:
        List r1 = CollectionsKt.emptyList();
    L269:
        List r2 = r1;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L271:
        if (r4.hasNext() == false) goto L293;
        Object r5 = r4.next();
        int r16 = r3 + 1;
        if (r3 >= 0) goto L275;
        CollectionsKt.throwIndexOverflow();
    L275:
        c r6 = (c) r5;
        int r7 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.a;
        if (r59.getType() != 0) goto L278;
        Drawable r8 = this.headerImagePlaceHolder;
    L279:
        Boolean r9 = r59.getSupportPreview();
        int r10 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.a(r6.getType(), r59.getFindSameGoodsSchema());
        String r11 = r59.getFindSameGoodsSchema();
        CommonFindSameElement r15 = r59.getFindSameGoodsTab();
        if (r62 == true) goto L282;
    L284:
        ScrollMoreText r17 = r14;
    L285:
        ArrayList r57 = r12;
        Drawable r20 = r14;
        c r18 = c.a(r6, r8, r61, r10, r9, r11, r15, r17, isLengthenedPicture(), r63, r64, -1074491425, 4);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r19 = r18.i;
        if (r19 == null) goto L291;
        String r21 = a2.d(r18.H);
        if (r21 != null) goto L290;
        r21 = c.J.get(Integer.valueOf(c.a.a(r18.m)));
    L290:
        r19.a = r21;
    L291:
        r57.add(r18);
        r12 = r57;
        r3 = r16;
        r14 = r20;
        r13 = 1;
        goto L271
    L282:
        if (r3 != (r1.size() - r13)) goto L284;
        r17 = this.scrollMoreText;
        goto L285
    L278:
        r8 = r14;
        goto L279
    L293:
        return r12;
    L9:
        HashMap<Integer, String> r22 = c.J;
        List<KolReviewElement> r35 = r59.getPioneerElement();
        AnchorV4HeadMeta r23 = getHeadMeta();
        if (r23 == null) goto L16;
        HeadBusinessMeta r24 = r23.getBusinessMeta();
        if (r24 == null) goto L16;
        Map<String, String> r25 = r24.getAccessLabel();
        if (r25 == null) goto L16;
        String r30 = r25.get(String.valueOf(9));
    L17:
        r1 = CollectionsKt.listOf(new c(HeadViewType.PIONEER.getType(), null, null, null, null, null, null, null, null, null, null, null, null, r30, null, null, null, null, r35, null, null, false, null, -68157442, 7));
    L16:
        r30 = null;
        goto L17
    L18:
        HashMap<Integer, String> r26 = c.J;
        CommonFindSameElement r29 = r59.getFindSameGoodsTab();
        AnchorV4HeadMeta r27 = getHeadMeta();
        if (r27 == null) goto L25;
        HeadBusinessMeta r28 = r27.getBusinessMeta();
        if (r28 == null) goto L25;
        Map<String, String> r31 = r28.getAccessLabel();
        if (r31 == null) goto L25;
        String r32 = r31.get(String.valueOf(7));
    L26:
        r1 = CollectionsKt.listOf(new c(HeadViewType.FIND_SAME.getType(), null, null, null, null, null, null, null, null, null, null, null, r29, r32, null, null, null, null, null, null, null, false, null, -1179650, 7));
    L25:
        r32 = null;
        goto L26
    L27:
        HashMap<Integer, String> r33 = c.J;
        i r34 = r59.getHeadCommentInfo();
        List<ImageModel> r36 = r59.getImages();
        AnchorV4HeadMeta r37 = getHeadMeta();
        if (r37 == null) goto L34;
        HeadBusinessMeta r38 = r37.getBusinessMeta();
        if (r38 == null) goto L34;
        Map<String, String> r39 = r38.getAccessLabel();
        if (r39 == null) goto L34;
        String r40 = r39.get(String.valueOf(6));
    L35:
        ArrayList r41 = new ArrayList();
        if (r34 == null) goto L46;
        FeaturedComment r210 = r34.a();
        if (r210 == null) goto L46;
        String r110 = HeadViewType.COMMENT.getType();
        if (r36 == null) goto L44;
        ImageModel r42 = (ImageModel) CollectionsKt.firstOrNull(r36);
        if (r42 == null) goto L44;
        ECUrlModel r111 = r42.getRemote();
    L45:
        r41.add(new c(r110, r111, null, null, null, null, null, null, null, r210, null, null, null, r40, null, null, null, null, null, null, null, false, null, -1050628, 7));
    L44:
        r111 = null;
    L46:
        if (r34 == null) goto L50;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r211 = r34.b();
        if (r211 == null) goto L50;
        r41.add(new c(HeadViewType.SHOW.getType(), null, null, null, null, null, null, null, r211, null, null, null, null, r40, null, null, null, null, null, null, null, false, null, -1049602, 7));
    L50:
        r1 = r41;
    L34:
        r40 = null;
        goto L35
    L51:
        HashMap<Integer, String> r43 = c.J;
        h r44 = r59.getGoodGoodsComment();
        CommentVideoInfo r45 = r59.getKolAuthorInfo();
        AnchorV4HeadMeta r46 = getHeadMeta();
        if (r46 == null) goto L58;
        HeadBusinessMeta r47 = r46.getBusinessMeta();
        if (r47 == null) goto L58;
        AnchorV4KolEvaluationBusinessMeta r48 = r47.getKolMeta();
        if (r48 == null) goto L58;
        String r49 = r48.getKolVideoPlaySchema();
    L59:
        AnchorV4HeadMeta r50 = getHeadMeta();
        if (r50 == null) goto L66;
        HeadBusinessMeta r51 = r50.getBusinessMeta();
        if (r51 == null) goto L66;
        Map<String, String> r52 = r51.getAccessLabel();
        if (r52 == null) goto L66;
        String r310 = r52.get(String.valueOf(5));
    L67:
        if (r44 == null) goto L97;
        VideoModel r53 = r44.b();
        if (r53 == null) goto L97;
        String r112 = HeadViewType.GOOD_COMMENT.getType();
        z73.a r54 = PlayAbilityUtil.a;
        int r55 = com.bytedance.android.shopping.anchorv4.video.float.e.a;
        if (r55 == 1) goto L76;
        if (r55 == 3) goto L76;
        boolean r56 = false;
    L77:
        if (r56 == false) goto L79;
        PlayerViewScene r58 = PlayerViewScene.SCENE_PRODUCT_VIDEO;
    L80:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r212 = PlayAbilityUtil.a(r53, null, r58);
        ImageModel r65 = r53.getPosterImage();
        if (r65 == null) goto L83;
        ECUrlModel r213 = r65.getRemote();
    L84:
        GaussianBlurConfig r311 = r44.a();
        int r66 = h83.a.c;
        if (r45 == null) goto L95;
        if (r49 != null) goto L88;
    L91:
        boolean r67 = true;
    L92:
        if (r67 == true) goto L95;
        h83.a r312 = new h83.a(r45, r49);
    L96:
        r1 = CollectionsKt.listOf(new c(r112, null, null, null, null, r213, r212, null, null, null, null, null, null, r310, r311, null, null, null, null, r312, new m(), com.bytedance.android.ec.core.opt.ab.c.d(), null, -944767362, 7));
        goto L269
    L88:
        if (r49.length() == 0) goto L91;
        r67 = false;
    L95:
        r312 = null;
        goto L96
    L83:
        r213 = null;
        goto L84
    L79:
        r58 = PlayerViewScene.SCENE_OTHERS;
    L76:
        r56 = true;
    L97:
        r1 = CollectionsKt.emptyList();
    L66:
        r310 = null;
    L58:
        r49 = null;
        goto L59
    L98:
        HashMap<Integer, String> r68 = c.J;
        CombinationElement r69 = r59.getCombinationElement();
        List<ImageModel> r70 = r59.getImages();
        AnchorV4HeadMeta r71 = getHeadMeta();
        AnchorV4HeadMeta r72 = getHeadMeta();
        if (r72 == null) goto L105;
        HeadBusinessMeta r73 = r72.getBusinessMeta();
        if (r73 == null) goto L105;
        Map<String, String> r74 = r73.getAccessLabel();
        if (r74 == null) goto L105;
        String r313 = r74.get(String.valueOf(4));
    L106:
        p r314 = r59.getSlice();
        String r113 = HeadViewType.COMBINATION.getType();
        if (r70 == null) goto L111;
        ImageModel r75 = (ImageModel) CollectionsKt.firstOrNull(r70);
        if (r75 == null) goto L111;
        ECUrlModel r114 = r75.getRemote();
    L113:
        if (r69 == null) goto L165;
        if (r70 == null) goto L120;
        ImageModel r76 = (ImageModel) CollectionsKt.firstOrNull(r70);
        if (r76 == null) goto L120;
        ECUrlModel r77 = r76.getRemote();
        if (r77 == null) goto L120;
        Integer r78 = Integer.valueOf(r77.getHeight());
    L121:
        int r214 = com.bytedance.android.shopping.extensions.k.f(r78);
        Intrinsics.checkNotNullParameter(r69, "$this$toCombinationVO");
        List<CombinationTagElement> r79 = r69.getTags();
        if (r79 != null) goto L124;
        r79 = CollectionsKt.emptyList();
    L124:
        List<CombinationTagElement> r80 = r79;
        ArrayList r81 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r80, 10));
        Iterator<T> r82 = r80.iterator();
    L126:
        if (r82.hasNext() == false) goto L140;
        CombinationTagElement r84 = (CombinationTagElement) r82.next();
        ECUrlModel r215 = r84.getIcon();
        String r115 = r84.getTitle();
        if (r115 != null) goto L130;
        String r216 = "";
    L131:
        String r116 = r84.getSubTitle();
        if (r116 != null) goto L134;
        String r217 = "";
    L135:
        String r117 = r84.getSchema();
        if (r117 != null) goto L138;
        String r218 = "";
    L139:
        r81.add(new p63.c(r215, r216, r217, r218, r84.getProductId(), d63.m.a(r84.getOrientation())));
        goto L126
    L138:
        r218 = r117;
        goto L139
    L134:
        r217 = r116;
        goto L135
    L130:
        r216 = r115;
        goto L131
    L140:
        List<CombinationTagElement> r85 = r69.getTags();
        if (r85 != null) goto L143;
        r85 = CollectionsKt.emptyList();
    L143:
        ArrayList r86 = new ArrayList();
        Iterator<T> r87 = r85.iterator();
    L145:
        if (r87.hasNext() == false) goto L150;
        Point r88 = ((CombinationTagElement) r87.next()).getPosition();
        if (r88 == null) goto L145;
        r86.add(r88);
        goto L145
    L150:
        if (r71 == null) goto L156;
        HeadBusinessMeta r89 = r71.getBusinessMeta();
        if (r89 == null) goto L156;
        f r90 = r89.getCombinationMeta();
        if (r90 == null) goto L156;
        String r91 = r90.a();
    L157:
        if (r71 == null) goto L163;
        HeadBusinessMeta r92 = r71.getBusinessMeta();
        if (r92 == null) goto L163;
        f r94 = r92.getCombinationMeta();
        if (r94 == null) goto L163;
        String r95 = r94.b();
    L164:
        CombinationVO r219 = new CombinationVO(r214, r81, r86, new p63.d(r91, r95), false, true, 16, null);
    L166:
        r1 = CollectionsKt.listOf(new c(r113, r114, null, null, r219, null, null, null, null, null, null, null, null, r313, null, null, null, null, null, null, null, false, r314, -1048644, 3));
    L163:
        r95 = null;
    L156:
        r91 = null;
    L120:
        r78 = null;
        goto L121
    L165:
        r219 = null;
    L111:
        r114 = null;
    L105:
        r313 = null;
        goto L106
    L167:
        HashMap<Integer, String> r96 = c.J;
        List<ImageModel> r97 = r59.getImages();
        ImageModel r98 = r59.getEntryIcon();
        AnchorV4HeadMeta r99 = getHeadMeta();
        if (r99 == null) goto L172;
        HeadBusinessMeta r100 = r99.getBusinessMeta();
        if (r100 == null) goto L172;
        Link r101 = r100.getLinkAR();
    L173:
        AnchorV4HeadMeta r102 = getHeadMeta();
        if (r102 == null) goto L180;
        HeadBusinessMeta r103 = r102.getBusinessMeta();
        if (r103 == null) goto L180;
        Map<String, String> r104 = r103.getAccessLabel();
        if (r104 == null) goto L180;
        String r105 = r104.get(String.valueOf(3));
    L181:
        if (r97 != null) goto L183;
        r97 = CollectionsKt.emptyList();
    L183:
        List<ImageModel> r106 = r97;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L185:
        if (r108.hasNext() == false) goto L215;
        ImageModel r109 = (ImageModel) r108.next();
        String r118 = HeadViewType.SIMPLE_LINK.getType();
        ECUrlModel r119 = r109.getRemote();
        if (r98 == null) goto L189;
        ECUrlModel r120 = r98.getRemote();
    L190:
        r107.add(new c(r118, r119, r120, r101, null, null, null, null, null, null, null, "ar", null, r105, null, null, null, null, null, null, null, false, null, -1081372, 7));
        goto L185
    L189:
        r120 = null;
    L215:
        r1 = r107;
    L180:
        r105 = null;
    L172:
        r101 = null;
        goto L173
    L191:
        HashMap<Integer, String> r121 = c.J;
        List<ImageModel> r122 = r59.getImages();
        ImageModel r123 = r59.getEntryIcon();
        AnchorV4HeadMeta r124 = getHeadMeta();
        if (r124 == null) goto L196;
        HeadBusinessMeta r125 = r124.getBusinessMeta();
        if (r125 == null) goto L196;
        Link r126 = r125.getLink3D();
    L197:
        AnchorV4HeadMeta r127 = getHeadMeta();
        if (r127 == null) goto L204;
        HeadBusinessMeta r128 = r127.getBusinessMeta();
        if (r128 == null) goto L204;
        Map<String, String> r129 = r128.getAccessLabel();
        if (r129 == null) goto L204;
        String r130 = r129.get(String.valueOf(2));
    L205:
        if (r122 != null) goto L207;
        r122 = CollectionsKt.emptyList();
    L207:
        List<ImageModel> r131 = r122;
        r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r131, 10));
        Iterator<T> r132 = r131.iterator();
    L209:
        if (r132.hasNext() == false) goto L215;
        ImageModel r133 = (ImageModel) r132.next();
        String r134 = HeadViewType.SIMPLE_LINK.getType();
        ECUrlModel r135 = r133.getRemote();
        if (r123 == null) goto L213;
        ECUrlModel r136 = r123.getRemote();
    L214:
        r107.add(new c(r134, r135, r136, r126, null, null, null, null, null, null, null, "3d", null, r130, null, null, null, null, null, null, null, false, null, -1081372, 7));
        goto L209
    L213:
        r136 = null;
    L204:
        r130 = null;
    L196:
        r126 = null;
        goto L197
    L216:
        HashMap<Integer, String> r137 = c.J;
        List<ImageModel> r138 = r59.getImages();
        AnchorV4HeadMeta r139 = getHeadMeta();
        if (r139 == null) goto L223;
        HeadBusinessMeta r140 = r139.getBusinessMeta();
        if (r140 == null) goto L223;
        Map<String, String> r141 = r140.getAccessLabel();
        if (r141 == null) goto L223;
        String r142 = r141.get(String.valueOf(1));
    L224:
        if (r138 != null) goto L226;
        r138 = CollectionsKt.emptyList();
    L226:
        List<ImageModel> r143 = r138;
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator<T> r145 = r143.iterator();
    L228:
        if (r145.hasNext() == false) goto L230;
        r144.add(new c(HeadViewType.SIZE.getType(), ((ImageModel) r145.next()).getRemote(), null, null, null, null, null, null, null, null, null, "size", null, r142, null, null, null, null, null, null, null, false, null, -1081348, 7));
        goto L228
    L230:
        r1 = r144;
    L223:
        r142 = null;
        goto L224
    L231:
        HashMap<Integer, String> r146 = c.J;
        VideoModel r147 = r59.getVideo();
        h r148 = r59.getGoodGoodsComment();
        List<ImageModel> r149 = r59.getImages();
        AnchorV4HeadMeta r150 = getHeadMeta();
        if (r150 == null) goto L238;
        HeadBusinessMeta r151 = r150.getBusinessMeta();
        if (r151 == null) goto L238;
        Map<String, String> r152 = r151.getAccessLabel();
        if (r152 == null) goto L238;
        String r315 = r152.get(String.valueOf(0));
    L239:
        boolean r153 = isLengthenedPicture();
        GaussianBlurConfig r154 = r59.getBackgroundControl();
        if (r149 != null) goto L242;
        r149 = CollectionsKt.emptyList();
    L242:
        List<ImageModel> r155 = r149;
        ArrayList r156 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r155, 10));
        Iterator<T> r157 = r155.iterator();
    L244:
        if (r157.hasNext() == false) goto L246;
        r156.add(new c(HeadViewType.PICTURE.getType(), ((ImageModel) r157.next()).getRemote(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -4, 7));
        goto L244
    L246:
        if (r147 != null) goto L250;
        if (r148 == null) goto L249;
        VideoModel r158 = r148.b();
    L251:
        if (r158 != null) goto L253;
        r1 = r156;
        goto L269
    L253:
        String r159 = HeadViewType.VIDEO.getType();
        z73.a r160 = PlayAbilityUtil.a;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r220 = PlayAbilityUtil.a(r158, null, PlayerViewScene.SCENE_PRODUCT_VIDEO);
        ImageModel r161 = r158.getPosterImage();
        if (r161 == null) goto L256;
        ECUrlModel r221 = r161.getRemote();
    L258:
        if (r147 != null) goto L261;
        if (r148 == null) goto L263;
        GaussianBlurConfig r162 = r148.a();
    L264:
        GaussianBlurConfig r316 = r162;
    L265:
        if (r147 != null) goto L267;
        String r163 = "celebrity";
    L268:
        r1 = CollectionsKt.plus(CollectionsKt.listOf(new c(r159, null, null, null, null, r221, r220, r163, null, null, null, null, null, r315, r316, null, null, null, null, null, null, false, null, -5243778, 7)), r156);
        goto L269
    L267:
        r163 = "shop";
    L263:
        r162 = null;
        goto L264
    L261:
        if (r153 == false) goto L263;
        r316 = r154;
        goto L265
    L256:
        r221 = null;
        goto L258
    L249:
        r158 = null;
        goto L251
    L250:
        r158 = r147;
    L238:
        r315 = null;
        goto L239
    }

    public static /* synthetic */ List buildNodeListWithExtraInfo$default(AnchorV4HeadVO r7, SlidesGroup r8, String r9, String r10, boolean r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L6;
        r13 = null;
    L6:
        return r7.a(r8, r9, r10, r11, r12, r13);
    }

    public AnchorV4HeadVO(List<SlidesGroup> r1, TagsScrollBoxComponent r2, ScrollMoreText r3, List<SlidesGroup> r4, CommonFindSameElement r5, String r6, Integer r7, boolean r8, Integer r9, ComponentDTO r10, Drawable r11) {
        this.tabList = r1;
        this.floatButtonElements = r2;
        this.scrollMoreText = r3;
        this.skuTabItems = r4;
        this.findSameEntryElement = r5;
        this.headTabBgColor = r6;
        this.containerSizeType = r7;
        this.headTabExpand = r8;
        this.maxTabNum = r9;
        this.component = r10;
        this.headerImagePlaceHolder = r11;
        this.headMeta$delegate = LazyKt.lazy(new AnchorV4HeadVO$headMeta$2(this));
    }

    public /* synthetic */ AnchorV4HeadVO(List r13, TagsScrollBoxComponent r14, ScrollMoreText r15, List r16, CommonFindSameElement r17, String r18, Integer r19, boolean r20, Integer r21, ComponentDTO r22, Drawable r23, int r24, DefaultConstructorMarker r25) {
        Drawable r2 = null;
        if ((r24 & 1) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        TagsScrollBoxComponent r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        ScrollMoreText r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        CommonFindSameElement r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        boolean r9 = false;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        ComponentDTO r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
