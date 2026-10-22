package com.bytedance.ies.bullet.base.ui;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/base/ui/SimpleBulletPopupFragment;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public class SimpleBulletPopupFragment extends AbsPopupFragment {
    @Override // com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment, com.bytedance.ies.bullet.service.base.l0
    public final String getBid() {
        BulletContext r100 = getBulletContext();
        if (r100 == null) goto L7;
        String r101 = r100.f246438f;
        if (r101 == null) goto L9;
        return r101;
    L9:
        return "default_bid";
    L7:
        return "default_bid";
    }

    public SimpleBulletPopupFragment() {
    }
}
