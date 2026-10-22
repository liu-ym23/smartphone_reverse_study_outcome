package z3c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;

/* JADX INFO: loaded from: classes38.dex */
public interface a {
    void onLoadMore(String r100, SearchContext r101);

    void onLoadMore(String r100, SearchContext r101, IGetDataCallback<SearchResponse> r102);

    void onSearch(String r100, SearchContext r101, IGetDataCallback<SearchResponse> r102);
}
