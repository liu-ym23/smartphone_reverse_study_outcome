package com.bytedance.ug.sdk.share.api.panel;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import java.io.Serializable;
import ln7.a;

/* JADX INFO: loaded from: classes3.dex */
public interface IPanelItem extends Serializable {
    int getIconId();

    String getIconUrl();

    a getItemType();

    int getTextId();

    String getTextStr();

    void onItemClick(Context r100, View r101, ShareContent r102);

    void setItemView(View r100, ImageView r101, TextView r102);
}
