package com.bytedance.ug.sdk.share.impl.ui.panel;

import android.view.View;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public interface ISharePanel {

    public interface ISharePanelCallback extends Serializable {
        void onClick(View r100, boolean r101, IPanelItem r102);

        void onDismiss();
    }
}
