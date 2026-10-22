package com.bytedance.ee.bear.wikiv2.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/DemoWikiTitleBar;", "Lcom/bytedance/ee/bear/list/homepage/title/HomeMainTitleBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "getTitleBarHeight", "setCreateViewEnable", "enable", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DemoWikiTitleBar extends HomeMainTitleBar {
    @Override // com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar
    public void setCreateViewEnable(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar
    public /* bridge */ /* synthetic */ void setMoreViewClickListener(View.OnClickListener r100) {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar, com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.wiki_title_bar_height_min);
    }

    public DemoWikiTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public DemoWikiTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
