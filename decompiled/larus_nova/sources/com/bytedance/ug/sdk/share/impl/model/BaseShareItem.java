package com.bytedance.ug.sdk.share.impl.model;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseShareItem implements IPanelItem {
    protected int mItemIconId;
    protected String mItemTextStr;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f272354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f272355b;

        public a(View r100, float r101) {
            this.f272354a = r100;
            this.f272355b = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            this.f272354a.setAlpha(this.f272355b * 0.5f);
            return false;
        L5:
            if (r102 != 1) goto L7;
        L9:
            this.f272354a.setAlpha(this.f272355b);
            return false;
        L7:
            if (r102 == 3) goto L9;
            return false;
        }
    }

    public BaseShareItem() {
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public abstract /* synthetic */ int getIconId();

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public abstract /* synthetic */ String getIconUrl();

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public abstract /* synthetic */ ln7.a getItemType();

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public abstract /* synthetic */ int getTextId();

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public abstract /* synthetic */ String getTextStr();

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public abstract /* synthetic */ void onItemClick(Context r100, View r101, ShareContent r102);

    public void setItemIconId(int r100) {
        this.mItemIconId = r100;
    }

    public void setItemTextStr(String r100) {
        this.mItemTextStr = r100;
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public void setItemView(View r100, ImageView r101, TextView r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setOnTouchListener(new a(r100, r100.getAlpha()));
    }
}
