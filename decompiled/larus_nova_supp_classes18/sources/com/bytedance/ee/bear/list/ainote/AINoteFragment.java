package com.bytedance.ee.bear.list.ainote;

import ad5.e;
import android.os.Bundle;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.lazy.LazyFragment;
import com.bytedance.ee.bear.list.ainote.my_involved.MyInvolvedTabFragment;
import com.bytedance.ee.bear.list.ainote.owned_by_me.OwnedByMeTabFragment;
import com.bytedance.ee.bear.list.ainote.share_with_me.AIShareWithMeTabFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.insets.WindowInsetsUtils;
import gc5.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.p;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u000bH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/list/ainote/AINoteFragment;", "Lcom/bytedance/ee/bear/facade/common/lazy/LazyFragment;", "<init>", "()V", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "getMViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setMViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "mCurrentItem", "", "getMCurrentItem", "()I", "setMCurrentItem", "(I)V", "mHomeTabAdapter", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabAdapter;", "mOpenSource", "", "getMOpenSource", "()Ljava/lang/String;", "setMOpenSource", "(Ljava/lang/String;)V", "onCreateViewLazy", "", "savedInstanceState", "Landroid/os/Bundle;", "initStatusBar", "getLayoutResId", "initViewPager", "initOpenSource", "getIndicator", "Lcom/bytedance/ee/bear/list/homepage/indicator/IndicatorAdapter;", "magicIndicator", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "tabInfoList", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideHomeTabs", "onClickSwitchTab", "index", "reportHomePageClick", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AINoteFragment extends LazyFragment {
    public HomeViewPager n;
    public int o;
    public String p;

    public static final class a {
    }

    static {
    }

    public int ba0() {
        return 2131563492;
    }

    public AINoteFragment() {
        this.p = "other";
    }

    public void V90(Bundle r23) {
        Z90(ba0());
        Bundle r1 = getArguments();
        if (r1 != null) goto L6;
        r1 = new Bundle();
    L6:
        if (Intrinsics.areEqual(r1.getString("extra_from"), "vc_tab") == true) goto L8;
    L14:
        Object r2 = findViewById(2131374451);
        if ((r2 instanceof HomeViewPager) == false) goto L17;
        HomeViewPager r3 = (HomeViewPager) r2;
    L18:
        this.n = r3;
        ArrayList r4 = new ArrayList();
        r4.add(new e(HomeTabEnum.OWNED_BY_ME.id, 2131888707, OwnedByMeTabFragment.class.getName()));
        r4.add(new e(HomeTabEnum.MY_INVOLVED.id, 2131894005, MyInvolvedTabFragment.class.getName()));
        r4.add(new e(HomeTabEnum.SHARE_WITH_ME.id, 2131887929, AIShareWithMeTabFragment.class.getName()));
        HomeTabAdapter r5 = new HomeTabAdapter(getChildFragmentManager(), getContext(), r4, getArguments());
        HomeViewPager r6 = this.n;
        if (r6 == null) goto L21;
        r6.setAdapter(r5);
    L21:
        HomeViewPager r7 = this.n;
        if (r7 == null) goto L24;
        r7.setCurrentItem(this.o);
    L24:
        HomeViewPager r8 = this.n;
        if (r8 == null) goto L27;
        r8.setOffscreenPageLimit(1);
    L27:
        MagicIndicator r9 = findViewById(2131374450);
        if ((r9 instanceof MagicIndicator) == false) goto L30;
        MagicIndicator r10 = r9;
    L31:
        wuc.a r11 = new wuc.a(getContext());
        r11.setAdjustMode(true);
        r11.setAdapter(new gc5.a(r10, r4, getContext(), new b(this)));
        if (r10 == null) goto L34;
        r10.setNavigator(r11);
    L34:
        if (r10 == null) goto L36;
        r10.b(this.o);
    L36:
        Bundle r12 = getArguments();
        String r13 = "other";
        if (r12 == null) goto L42;
        String r14 = r12.getString("extra_from", "other");
        if (r14 == null) goto L42;
        r13 = r14;
    L42:
        this.p = r13;
        f.a.l(new p("ccm_space_ai_notes_view", "", "none", "", "", "", sbb.e.o.b, "", "", false, false, false, 0, null, "", null), null, null, this.p);
        return;
    L30:
        r10 = null;
        goto L31
    L17:
        r3 = null;
        goto L18
    L8:
        if (ForsetiHelper.g(getParentFragment()) == null) goto L14;
        int r15 = n.h(getActivity(), 2131100548);
        AINoteFragment r16 = ForsetiHelper.g(getParentFragment());
        if (r16 != null) goto L13;
        r16 = this;
    L13:
        WindowInsetsUtils.b(r16).b(r15);
        goto L14
    }
}
