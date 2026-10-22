package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/SearchResultAdapter;", "", "adapt", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "items", "isFromSpotlight", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SearchResultAdapter {
    List<SearchBaseInfo> adapt(List<? extends SearchBaseInfo> r100, boolean r101);
}
