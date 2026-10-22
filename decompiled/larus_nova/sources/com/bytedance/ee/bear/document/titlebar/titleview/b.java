package com.bytedance.ee.bear.document.titlebar.titleview;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes16.dex */
public interface b {
    ImageView getIconView();

    boolean getTitleVisible();

    View getView();

    void setExternalTag(String r100);

    void setExternalTagEnabled(boolean r100);

    void setExternalVisible(boolean r100);

    void setGravity(int r100);

    void setSpaceTagTitleBarEnabled(boolean r100);

    void setTemplateTagVisible(boolean r100);

    void setTitle(CharSequence r100);

    void setTitleTextBold(boolean r100);

    void setTitleTextColor(int r100);

    void setTitleTextColorInt(int r100);

    void setTitleTextSize(int r100);

    void setTitleVisible(boolean r100);
}
