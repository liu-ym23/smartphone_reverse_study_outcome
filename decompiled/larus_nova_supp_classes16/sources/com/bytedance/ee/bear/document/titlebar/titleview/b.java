package com.bytedance.ee.bear.document.titlebar.titleview;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {
    ImageView getIconView();

    boolean getTitleVisible();

    View getView();

    void setExternalTag(String r1);

    void setExternalTagEnabled(boolean r1);

    void setExternalVisible(boolean r1);

    void setGravity(int r1);

    void setSpaceTagTitleBarEnabled(boolean r1);

    void setTemplateTagVisible(boolean r1);

    void setTitle(CharSequence r1);

    void setTitleTextBold(boolean r1);

    void setTitleTextColor(int r1);

    void setTitleTextColorInt(int r1);

    void setTitleTextSize(int r1);

    void setTitleVisible(boolean r1);
}
