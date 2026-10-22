package iib;

import android.content.Context;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface a extends IModel {
    void L1(boolean r100, List r101, UIGetDataCallback r102);

    void L6(Context r100, List<ForwardTarget> r101, IGetDataCallback<com.ss.android.lark.forwardv2.impl.model.b> r102);

    void Y4(SearchBaseInfo r100, boolean r101);

    void a3();

    String getSource();

    CallbackManager m3();

    List<SearchBaseInfo> z7();
}
