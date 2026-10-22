package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002-.B\u0019\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\"¨\u0006/"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO;", "Lcom/bytedance/android/window/shop/repository/compat/WindowTabInfoProvider;", "", "hasMore", "", "Lcom/bytedance/android/window/shop/repository/dto/p;", "categories", "subCategories", "", "getWindowStatusCode", "", "msg", "cardCount", "getTargetSelectCategoryId", "getTargetSelectSubCategoryId", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "getWindowLayoutType", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", AosPagerListViewModel.API_TYPE_FEED, "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getFeed", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO$a;", "baseInfo", "Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO$a;", "getBaseInfo", "()Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO$a;", "categoryData", "Ljava/lang/String;", "getCategoryData", "()Ljava/lang/String;", "categoryList$delegate", "Lkotlin/Lazy;", "getCategoryList", "()Ljava/util/List;", "categoryList", "subCategoryList$delegate", "getSubCategoryList", "subCategoryList", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListSectionDTO;", "topCards", "Ljava/util/List;", "getTopCards", "<init>", "(Ljava/util/List;)V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHybridTabDataListResponseDTO extends WindowTabInfoProvider {

    @SerializedName("base_info")
    private final a baseInfo;

    @SerializedName("category_data")
    private final String categoryData;
    private final Lazy categoryList$delegate;

    @SerializedName(AosPagerListViewModel.API_TYPE_FEED)
    private final ECHybridListDTO feed;
    private final Lazy subCategoryList$delegate;

    @SerializedName("top_card_list")
    private final List<ECHybridListSectionDTO> topCards;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO$a;", "", "", "commonPassThrough", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "selectedCategoryId", "e", "selectedSubCategoryId", "f", "", "Lcom/bytedance/android/window/shop/repository/dto/ProductTabLayout;", "layout", "I", "c", "()I", "nextApi", "d", "", "Lnq3/a;", "dynamicViews", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("common_pass_through")
        private final String commonPassThrough;

        @SerializedName("dynamic_views")
        private final List<nq3.a> dynamicViews;

        @SerializedName("layout")
        private final int layout;

        @SerializedName("next_api")
        private final String nextApi;

        @SerializedName("select_category")
        private final String selectedCategoryId;

        @SerializedName("select_sub_category")
        private final String selectedSubCategoryId;

        public a() {
            this.layout = -1;
        }

        public final String a() {
            return this.commonPassThrough;
        }

        public final List<nq3.a> b() {
            return this.dynamicViews;
        }

        public final int c() {
            return this.layout;
        }

        public final String d() {
            return this.nextApi;
        }

        public final String e() {
            return this.selectedCategoryId;
        }

        public final String f() {
            return this.selectedSubCategoryId;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO$b;", "", "", "Lcom/bytedance/android/window/shop/repository/dto/p;", "categories", "Ljava/util/List;", "a", "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("category_list")
        private final List<p> categories;

        public b() {
            this.categories = null;
        }

        public final List<p> a() {
            return this.categories;
        }
    }

    public WindowHybridTabDataListResponseDTO() {
        List r0 = null;
        this(r0, 1, r0);
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public int cardCount() {
        ECHybridListDTO r0 = this.feed;
        if (r0 == null) goto L19;
        List r1 = r0.getSections();
        if (r1 == null) goto L20;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L15;
        ArrayList r4 = ((ECHybridListSectionDTO) r2.next()).getItems();
        if (r4 == null) goto L12;
        int r5 = r4.size();
    L13:
        r3 = r3 + r5;
        goto L8
    L12:
        r5 = 0;
        goto L13
    L15:
        return r3;
    L20:
        return 0;
    L19:
        return 0;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public List<p> categories() {
        return (List) this.categoryList$delegate.getValue();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String getTargetSelectCategoryId() {
        a r0 = this.baseInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String getTargetSelectSubCategoryId() {
        a r0 = this.baseInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public WindowLayoutType getWindowLayoutType() {
        WindowLayoutType.a r0 = WindowLayoutType.Companion;
        a r1 = this.baseInfo;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.c());
    L6:
        r0.getClass();
        WindowLayoutType r3 = WindowLayoutType.a.b(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return WindowLayoutType.SINGLECOLUMN;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean hasMore() {
        ECHybridListDTO r0 = this.feed;
        if (r0 != null) goto L5;
    L6:
        a r1 = this.baseInfo;
        if (r1 == null) goto L13;
        String r2 = r1.d();
        if (r2 == null) goto L13;
        if ((!StringsKt.isBlank(r2)) != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.getHasMore() != true) goto L6;
        return true;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public List<p> subCategories() {
        return (List) this.subCategoryList$delegate.getValue();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public int getWindowStatusCode() {
        return getStatusCode();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String msg() {
        String r0 = getMessage();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final a getBaseInfo() {
        return this.baseInfo;
    }

    public final String getCategoryData() {
        return this.categoryData;
    }

    public final ECHybridListDTO getFeed() {
        return this.feed;
    }

    public final List<ECHybridListSectionDTO> getTopCards() {
        return this.topCards;
    }

    public WindowHybridTabDataListResponseDTO(List<ECHybridListSectionDTO> r1) {
        this.topCards = r1;
        this.categoryList$delegate = LazyKt.lazy(new WindowHybridTabDataListResponseDTO$categoryList$2(this));
        this.subCategoryList$delegate = LazyKt.lazy(new WindowHybridTabDataListResponseDTO$subCategoryList$2(this));
    }

    public /* synthetic */ WindowHybridTabDataListResponseDTO(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
