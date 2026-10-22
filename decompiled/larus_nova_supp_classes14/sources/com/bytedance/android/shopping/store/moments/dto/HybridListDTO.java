package com.bytedance.android.shopping.store.moments.dto;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.f;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.repository.dto.l;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopEndDTO;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopFooterDTO;
import com.bytedance.android.shopping.store.moments.dto.card.ShortVideoDTO;
import com.bytedance.android.shopping.store.repository.dto.DividingLineDTO;
import com.bytedance.android.shopping.store.repository.dto.ShopCardDTO;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import dj3.e;
import dj3.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Deprecated(message = "商城混排别用这个了,统一下数据处理 @see ECHybridListSectionDTO")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "listStyle", "Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "getListStyle", "()Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "setListStyle", "(Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;)V", "", "", "Lcom/bytedance/android/shopping/store/moments/dto/ItemConfigDTO;", "itemConfigs", "Ljava/util/Map;", "getItemConfigs", "()Ljava/util/Map;", "setItemConfigs", "(Ljava/util/Map;)V", "", "Lcom/bytedance/android/shopping/store/moments/dto/SectionDTO;", "sections", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "extra", "getExtra", "setExtra", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridListDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("item_configs")
    private Map<String, ItemConfigDTO> itemConfigs;

    @SerializedName("list_style")
    private StyleDTO listStyle;

    @SerializedName("sections")
    private List<SectionDTO> sections;

    public static final class a {
        public a() {
        }

        public static k a(HybridListDTO r14) {
            Intrinsics.checkNotNullParameter(r14, "dto");
            k r0 = new k();
            StyleDTO.a r1 = StyleDTO.Companion;
            StyleDTO r2 = r14.getListStyle();
            r1.getClass();
            r0.a = StyleDTO.a.a(r2);
            Map<String, ItemConfigDTO> r3 = r14.getItemConfigs();
            ArrayList r4 = null;
            if (r3 == null) goto L28;
            Map r5 = new LinkedHashMap(MapsKt.mapCapacity(r3.size()));
            Iterator<T> r6 = r3.entrySet().iterator();
        L6:
            if (r6.hasNext() == false) goto L29;
            Map.Entry r7 = (Map.Entry) r6.next();
            Object r8 = r7.getKey();
            k.a r9 = new k.a(null);
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L25
            Gson r11 = new Gson();     // Catch: Throwable -> L25
            ItemConfigDTO r12 = (ItemConfigDTO) r7.getValue();     // Catch: Throwable -> L25
            if (r12 == null) goto L11;
            String r13 = r12.getLynxConfig();     // Catch: Throwable -> L25
        L12:
            LynxConfigDTO r15 = (LynxConfigDTO) r11.fromJson(r13, LynxConfigDTO.class);     // Catch: Throwable -> L25
            LynxConfigDTO.Companion.getClass();     // Catch: Throwable -> L25
            f r16 = new f();     // Catch: Throwable -> L25
            if (r15 == null) goto L15;
            String r17 = r15.getLynxSchema();     // Catch: Throwable -> L25
        L16:
            r16.a = r17;     // Catch: Throwable -> L25
            if (r15 == null) goto L19;
            double r18 = r15.getPredictHeight();     // Catch: Throwable -> L25
        L20:
            r16.b = r18;     // Catch: Throwable -> L25
            if (r15 == null) goto L23;
            r15.getFixedHeight();     // Catch: Throwable -> L25
        L23:
            r9.a = r16;     // Catch: Throwable -> L25
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            r5.put(r8, r9);
            goto L6
        L19:
            r18 = 0.0d;
            goto L20
        L15:
            r17 = null;
            goto L16
        L11:
            r13 = null;
        L25:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L29:
            if (r5 != null) goto L31;
            r5 = MapsKt.emptyMap();
        L31:
            r0.b = new HashMap(r5);
            List<SectionDTO> r20 = r14.getSections();
            if (r20 == null) goto L116;
            List<SectionDTO> r21 = r20;
            ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator<T> r23 = r21.iterator();
        L35:
            if (r23.hasNext() == false) goto L115;
            SectionDTO r24 = (SectionDTO) r23.next();
            SectionDTO.Companion.getClass();
            if (r24 != null) goto L39;
            i r25 = new i();
        L114:
            r22.add(r25);
            goto L35
        L39:
            i r26 = new i();
            r26.f = r24.getLayoutColumn();
            StyleDTO.a r27 = StyleDTO.Companion;
            StyleDTO r28 = r24.getSectionStyle();
            r27.getClass();
            r26.h = StyleDTO.a.a(r28);
            ArrayList<ItemDTO> r29 = r24.getItems();
            if (r29 == null) goto L95;
            ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
            Iterator<T> r31 = r29.iterator();
        L43:
            if (r31.hasNext() == false) goto L96;
            ItemDTO r110 = (ItemDTO) r31.next();
            ItemDTO.Companion.getClass();
            if (r110 != null) goto L47;
            ECHybridListItemVO r111 = new ECHybridListItemVO();
        L94:
            r30.add(r111);
            goto L43
        L47:
            ECHybridListItemVO r112 = new ECHybridListItemVO();
            r112.l = true;
            r112.c = Integer.valueOf(r110.getItemType());
            r112.d = r110.getItemId();
            r112.a = r110.getSpanSize();
            if (ComparisonsKt.compareValues(Integer.valueOf(r110.getItemType()), Integer.valueOf(ECHybridListItemType.NATIVE_VIEW_HOLDER_MAX.getType())) <= 0) goto L119;
            r112.o(r110.getItemData());
        L93:
            r111 = r112;
            goto L94
        L119:
            int r113 = r110.getItemType();     // Catch: Exception -> L118
            if (r113 != ECHybridListItemType.SHOP_MOMENTS_SHORT_VIDEO_CARD_V2.getType()) goto L53;
            Object r114 = new Gson().fromJson(r110.getItemData(), ShortVideoDTO.class);     // Catch: Exception -> L118
        L91:
            r112.o(r114);
            goto L93
        L53:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType()) goto L55;
        L88:
            r114 = new Gson().fromJson(r110.getItemData(), l.class);     // Catch: Exception -> L118
            goto L91
        L55:
            if (r113 == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType()) goto L88;
            if (r113 == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType()) goto L88;
            if (r113 == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE.getType()) goto L88;
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_SORT_FILTER.getType()) goto L65;
            r114 = new Gson().fromJson(r110.getItemData(), g.class);     // Catch: Exception -> L118
            goto L91
        L65:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_WINDOW_ENTRANCE.getType()) goto L68;
            r114 = new Gson().fromJson(r110.getItemData(), dj3.f.class);     // Catch: Exception -> L118
            goto L91
        L68:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER.getType()) goto L71;
            r114 = new Gson().fromJson(r110.getItemData(), DividingLineDTO.class);     // Catch: Exception -> L118
            goto L91
        L71:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCTS_FOOTER.getType()) goto L74;
            r114 = new Gson().fromJson(r110.getItemData(), ECShopFooterDTO.class);     // Catch: Exception -> L118
            goto L91
        L74:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_SHOP_CARD.getType()) goto L77;
            r114 = new Gson().fromJson(r110.getItemData(), ShopCardDTO.class);     // Catch: Exception -> L118
            goto L91
        L77:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_MULTI_SHOP_CARD.getType()) goto L80;
            r114 = new Gson().fromJson(r110.getItemData(), List.class);     // Catch: Exception -> L118
            goto L91
        L80:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY.getType()) goto L83;
            r114 = new Gson().fromJson(r110.getItemData(), dj3.f.class);     // Catch: Exception -> L118
            goto L91
        L83:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY_NEW.getType()) goto L86;
            r114 = new Gson().fromJson(r110.getItemData(), e.class);     // Catch: Exception -> L118
            goto L91
        L86:
            if (r113 != ECHybridListItemType.SHOP_PRODUCT_LIST_END.getType()) goto L90;
            r114 = new Gson().fromJson(r110.getItemData(), ECShopEndDTO.class);     // Catch: Exception -> L118
        L90:
            r114 = null;
        L96:
            r26.i = r30;
            r26.g = r24.getType();
            r26.a = r24.getSectionId();
            Integer r32 = r24.getOperationType();
            if (r32 != null) goto L100;
        L102:
            if (r32 != null) goto L105;
        L107:
            if (r32 != null) goto L110;
        L112:
            ECSectionOperationType r33 = ECSectionOperationType.NONE;
        L113:
            r26.c(r33);
            r25 = r26;
            goto L114
        L110:
            if (r32.intValue() != 3) goto L112;
            r33 = ECSectionOperationType.APPEND_ITEM;
            goto L113
        L105:
            if (r32.intValue() != 2) goto L107;
            r33 = ECSectionOperationType.DELETE_SECTION;
            goto L113
        L100:
            if (r32.intValue() != 1) goto L102;
            r33 = ECSectionOperationType.INSERT_SECTION;
            goto L113
        L95:
            r30 = null;
            goto L96
        L115:
            r4 = r22;
        L116:
            r0.c = r4;
            r0.d = r14.getExtra();
            return r0;
        L28:
            r5 = null;
            goto L29
        }
    }

    static {
        Companion = new a();
    }

    public HybridListDTO() {
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Map<String, ItemConfigDTO> getItemConfigs() {
        return this.itemConfigs;
    }

    public final StyleDTO getListStyle() {
        return this.listStyle;
    }

    public final List<SectionDTO> getSections() {
        return this.sections;
    }

    public final void setExtra(Map<String, String> r1) {
        this.extra = r1;
    }

    public final void setItemConfigs(Map<String, ItemConfigDTO> r1) {
        this.itemConfigs = r1;
    }

    public final void setListStyle(StyleDTO r1) {
        this.listStyle = r1;
    }

    public final void setSections(List<SectionDTO> r1) {
        this.sections = r1;
    }
}
