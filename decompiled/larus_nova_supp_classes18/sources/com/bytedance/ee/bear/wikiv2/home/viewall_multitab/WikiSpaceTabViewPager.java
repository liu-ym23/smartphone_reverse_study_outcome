package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tabLayoutFromXml", "Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "getTabLayoutFromXml", "()Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "setTabLayoutFromXml", "(Lcom/larksuite/component/universe_design/tab/UDTabLayout;)V", "tabPagerFromXml", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;", "getTabPagerFromXml", "()Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;", "setTabPagerFromXml", "(Lcom/bytedance/ee/bear/list/homepage/tab/HomeViewPager;)V", "tabDividerFromXml", "Landroid/view/View;", "getTabDividerFromXml", "()Landroid/view/View;", "setTabDividerFromXml", "(Landroid/view/View;)V", "init", "", "fm", "Landroidx/fragment/app/FragmentManager;", WikiFolderPushPlugin.DATA, "", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/SpaceTab;", "tab", "TabAdapter", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceTabViewPager extends LinearLayout {
    public UDTabLayout a;
    public HomeViewPager b;
    public View c;

    public static final class a {
    }

    public static final class b extends FragmentStatePagerAdapter {
        public final List<com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a> a;

        public final int getCount() {
            return this.a.size();
        }

        public final Fragment getItem(int r2) {
            return ((com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a) ListProtector.get(this.a, r2)).b;
        }

        public final CharSequence getPageTitle(int r3) {
            return eu5.b.a.getString(((com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a) ListProtector.get(this.a, r3)).a);
        }

        public b(FragmentManager r2, List<com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a> r3) {
            Intrinsics.checkNotNullParameter(r2, "fm");
            Intrinsics.checkNotNullParameter(r3, "spaceTabs");
            super(r2);
            this.a = r3;
        }
    }

    static {
    }

    public final View getTabDividerFromXml() {
        View r0 = this.c;
        if (r0 != null) goto L6;
        View r1 = findViewById(2131388013);
        this.c = r1;
        return r1;
    L6:
        return r0;
    }

    public final UDTabLayout getTabLayoutFromXml() {
        UDTabLayout r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388030);
        this.a = r0;
    L6:
        return r0;
    }

    public final HomeViewPager getTabPagerFromXml() {
        ViewPager r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388043);
        this.b = (HomeViewPager) r0;
    L6:
        return (HomeViewPager) r0;
    }

    public final void setTabDividerFromXml(View r1) {
        this.c = r1;
    }

    public final void setTabLayoutFromXml(UDTabLayout r1) {
        this.a = r1;
    }

    public final void setTabPagerFromXml(HomeViewPager r1) {
        this.b = r1;
    }

    public WikiSpaceTabViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setOrientation(1);
        LayoutInflater.from(r2).inflate(2131568263, this);
    }

    public final void a(FragmentManager r2, List<com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        if (hu5.a.d(r3) == false) goto L5;
        return;
    L5:
        b r0 = new b(r2, r3);
        getTabPagerFromXml().setAdapter(r0);
        getTabPagerFromXml().setOffscreenPageLimit(r3.size());
        new UDTabLayoutCoordinator(getTabLayoutFromXml(), getTabPagerFromXml()).attach();
    }
}
