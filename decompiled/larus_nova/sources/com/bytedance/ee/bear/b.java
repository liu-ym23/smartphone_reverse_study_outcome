package com.bytedance.ee.bear;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public interface b {

    public interface a {
        void a();
    }

    void hide();

    void setBackIcon(Drawable r100);

    void setBackIconVisible(boolean r100);

    void setBackListener(View.OnClickListener r100);

    void setDelegate(a r100);

    void setReportCommonParams(HashMap<String, Object> r100);

    void setTitleBarVisible(boolean r100);

    void show();

    void show(String r100, int r101);
}
