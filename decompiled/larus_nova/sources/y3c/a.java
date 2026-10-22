package y3c;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface a {
    boolean canLoadMore();

    void loadData(IGetDataCallback<List<SearchBaseInfo>> r100);

    boolean needHeader();

    void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r100);
}
