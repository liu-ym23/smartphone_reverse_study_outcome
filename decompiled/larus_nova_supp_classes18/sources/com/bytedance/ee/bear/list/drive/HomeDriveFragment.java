package com.bytedance.ee.bear.list.drive;

import ad5.e;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.lazy.LazyFragment;
import com.bytedance.ee.bear.list.folder.HomePersonalFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.bear.list.share.HomeSharedFragment;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.p;
import net.lucode.hackware.magicindicator.MagicIndicator;
import sc5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0002J \u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u0015H\u0014J\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0)H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/list/drive/HomeDriveFragment;", "Lcom/bytedance/ee/bear/facade/common/lazy/LazyFragment;", "<init>", "()V", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "getMViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setMViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "mCurrentItem", "", "getMCurrentItem", "()I", "setMCurrentItem", "(I)V", "mHomeTabAdapter", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabAdapter;", "createButton", "Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "onCreateViewLazy", "", "savedInstanceState", "Landroid/os/Bundle;", "getLayoutResId", "initViewPager", "getIndicator", "Lcom/bytedance/ee/bear/list/homepage/indicator/IndicatorAdapter;", "magicIndicator", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "tabInfoList", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "provideHomeTabs", "onClickSwitchTab", "index", "reportHomePageClick", "updateCreateButton", "isPersonalTabSelected", "", "getMenuNameResId", "Lkotlin/Pair;", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HomeDriveFragment extends LazyFragment {
    public HomeViewPager n;
    public int o;
    public CommonCreateButton p;

    public static final class a {
    }

    static {
    }

    public int ba0() {
        return 2131563492;
    }

    public List<e> ea0() {
        ArrayList r0 = new ArrayList();
        r0.add(new e(HomeTabEnum.MY_SPACE.id, ((Number) ca0().getFirst()).intValue(), HomePersonalFragment.class.getName()));
        r0.add(new e(HomeTabEnum.SHARED_SPACE.id, ((Number) ca0().getSecond()).intValue(), HomeSharedFragment.class.getName()));
        return r0;
    }

    public Pair<Integer, Integer> ca0() {
        if (qc5.a.d() == false) goto L6;
        return new Pair(2131887935, 2131887981);
    L6:
        return new Pair(2131887935, 2131887300);
    }

    public HomeDriveFragment() {
    }

    public void V90(Bundle r6) {
        Z90(ba0());
        FragmentActivity r7 = getActivity();
        MagicIndicator r0 = null;
        if (r7 == null) goto L13;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L13;
        View r9 = r8.getDecorView();
        if (c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == c.a) goto L11;
        c.a(r1, "getDecorView");
    L11:
        if (r9 == null) goto L13;
        CommonCreateButton r10 = (CommonCreateButton) r9.findViewById(2131367552);
    L14:
        this.p = r10;
        Object r11 = findViewById(2131374451);
        if ((r11 instanceof HomeViewPager) == false) goto L17;
        HomeViewPager r12 = (HomeViewPager) r11;
    L18:
        this.n = r12;
        List<e> r13 = ea0();
        HomeTabAdapter r2 = new HomeTabAdapter(getChildFragmentManager(), getContext(), r13, getArguments());
        HomeViewPager r3 = this.n;
        if (r3 == null) goto L21;
        r3.setAdapter(r2);
    L21:
        HomeViewPager r4 = this.n;
        if (r4 == null) goto L24;
        r4.setCurrentItem(this.o);
    L24:
        HomeViewPager r5 = this.n;
        if (r5 == null) goto L27;
        r5.setOffscreenPageLimit(1);
    L27:
        View r14 = findViewById(2131374450);
        if ((r14 instanceof MagicIndicator) == false) goto L30;
        r0 = (MagicIndicator) r14;
    L30:
        wuc.a r15 = new wuc.a(getContext());
        r15.setAdjustMode(true);
        r15.setAdapter(new sc5.a(r0, r13, getContext(), new b(this)));
        if (r0 == null) goto L33;
        r0.setNavigator(r15);
    L33:
        if (r0 == null) goto L36;
        r0.b(this.o);
        return;
    L36:
        return;
    L17:
        r12 = null;
    L13:
        r10 = null;
        goto L14
    }

    public void da0(int r10) {
        CommonCreateButton r0 = this.p;
        if (r0 != null) goto L5;
    L9:
        f.a r1 = f.a;
        if (r10 != 0) goto L12;
        String r2 = WikiSpaceType.PERSONAL;
    L13:
        String r4 = r2;
        if (r10 != 0) goto L16;
        String r11 = "ccm_space_personal_page_view";
    L17:
        p r8 = new p("home", "", r4, r11, "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r8, "param");
        r1.I(r8);
        return;
    L16:
        r11 = "ccm_space_shared_page_view";
        goto L17
    L12:
        r2 = "shared";
        goto L13
    L5:
        if (this.o != 0) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        goto L9
    L7:
        r3 = 8;
        goto L8
    }
}
