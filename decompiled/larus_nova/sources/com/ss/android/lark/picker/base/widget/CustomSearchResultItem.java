package com.ss.android.lark.picker.base.widget;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J$\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "matcher", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "query", "", "insertPosition", "", "<init>", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)V", "getItem", "()Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getMatcher", "()Lkotlin/jvm/functions/Function1;", "getInsertPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)Lcom/ss/android/lark/picker/base/widget/CustomSearchResultItem;", "equals", "other", "hashCode", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomSearchResultItem {
    private final Integer insertPosition;
    private final SearchBaseInfo item;
    private final Function1<String, Boolean> matcher;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomSearchResultItem copy$default(CustomSearchResultItem r100, SearchBaseInfo r101, Function1 r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.item;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.matcher;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.insertPosition;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final SearchBaseInfo component1() {
        return this.item;
    }

    public final Function1<String, Boolean> component2() {
        return this.matcher;
    }

    public final Integer component3() {
        return this.insertPosition;
    }

    public final CustomSearchResultItem copy(SearchBaseInfo r100, Function1<? super String, Boolean> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "matcher");
        return new CustomSearchResultItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomSearchResultItem) == true) goto L8;
        return false;
    L8:
        CustomSearchResultItem r101 = (CustomSearchResultItem) r100;
        if (Intrinsics.areEqual(this.item, r101.item) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.matcher, r101.matcher) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.insertPosition, r101.insertPosition) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.item.hashCode() * 31) + this.matcher.hashCode()) * 31;
        Integer r101 = this.insertPosition;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CustomSearchResultItem(item=" + this.item + ", matcher=" + this.matcher + ", insertPosition=" + this.insertPosition + ')';
    }

    public final Integer getInsertPosition() {
        return this.insertPosition;
    }

    public final SearchBaseInfo getItem() {
        return this.item;
    }

    public final Function1<String, Boolean> getMatcher() {
        return this.matcher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomSearchResultItem(SearchBaseInfo r100, Function1<? super String, Boolean> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "matcher");
        this.item = r100;
        this.matcher = r101;
        this.insertPosition = r102;
    }

    public /* synthetic */ CustomSearchResultItem(SearchBaseInfo r100, Function1 r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = AnonymousClass1.INSTANCE;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
