package tr5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void bindContainer(ViewGroup r100);

    void bindData(yr5.a r100);

    ViewGroup getContainer();

    JSONObject getData();

    int getHeight();

    String getViewId();

    String getViewType();

    int getWidth();

    int getZIndex();

    View onCreateView(Context r100, JSONObject r101);

    void onRemove();

    void onUpdateView(View r100, JSONObject r101);

    void performAction(String r100, JSONObject r101);

    void setWidthAndHeight(int r100, int r101);

    void updateData(JSONObject r100);
}
