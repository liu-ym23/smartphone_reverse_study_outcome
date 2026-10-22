package com.bytedance.bdp.appbase.base.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import j94.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\r"}, d2 = {"Lcom/bytedance/bdp/appbase/base/ui/titlebar/BdpAppTitleBar;", "Landroid/widget/FrameLayout;", "", "Lj94/a;", "listener", "", "setTitleBarActionListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bdp-appbase_release"}, k = 1, mv = {1, 4, 0})
public abstract class BdpAppTitleBar extends FrameLayout {
    public abstract /* synthetic */ void setCloseBtnStatus(boolean r100);

    public abstract /* synthetic */ void setHomeBtnStatus(boolean r100);

    public abstract /* synthetic */ void setNavigationBarAlpha(float r100);

    public abstract /* synthetic */ void setNavigationBarBackgroundColor(String r100);

    public abstract /* synthetic */ void setNavigationBarLoading(boolean r100);

    public abstract /* synthetic */ void setNavigationBarTextStyle(String r100);

    public abstract /* synthetic */ void setNavigationBarTitleText(String r100);

    public abstract /* synthetic */ void setNavigationBarTopPadding(int r100);

    public abstract /* synthetic */ void setNavigationStyle(String r100);

    public abstract /* synthetic */ void setTitleVisible(boolean r100);

    public final void setTitleBarActionListener(a r100) {
        if (r100 == null) goto L5;
        r100.a();
        return;
    }

    public BdpAppTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
