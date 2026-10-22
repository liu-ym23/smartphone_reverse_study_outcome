package vqb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    void addFavoriteTab(com.ss.android.lark.maintab.export.a r100, IGetDataCallback<Unit> r101, boolean r102);

    void addVisitRecord(com.ss.android.lark.maintab.export.a r100);

    void deleteFavoriteTab(String r100, TabAppInfo.BizType r101, IGetDataCallback<Unit> r102);

    void deleteFavoriteTab(String r100, String r101, TabAppInfo.BizType r102, IGetDataCallback<Unit> r103);

    boolean enableFgMainTabContainer();

    void getAllTabs(IGetDataCallback<List<TabAppInfo>> r100);

    String getConversationTabKey();

    void isExistFavoriteTab(String r100, TabAppInfo.BizType r101, IGetDataCallback<Boolean> r102);

    void isExistFavoriteTab(String r100, String r101, TabAppInfo.BizType r102, IGetDataCallback<Boolean> r103);
}
