package com.ss.android.lark.contact.impl.group;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q9b.f;
import q9b.g;
import q9b.h;
import q9b.i;
import q9b.j;
import q9b.l;

/* JADX INFO: loaded from: classes35.dex */
public class ContactsMyGroupView implements IView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f419471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f419472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f419473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.ss.android.lark.base.fragment.a> f419474d;

    @BindView(8939)
    UDTabLayout mIndicator;

    @BindView(8854)
    ViewPager mMyGroupVP;

    @BindView(9526)
    CommonTitleBar mTitleBar;

    public interface a {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f419472b = null;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ButterKnife.bind(this, ((ContactsMyGroupFragment.a) this.f419472b).f419468a.f419465f);
        this.f419471a = this.mTitleBar.getContext();
        this.mTitleBar.setTitle(R.string.Lark_Legacy_MyGroup);
        this.mTitleBar.setDividerVisible(false);
        this.mTitleBar.setVisibility(0);
        this.mTitleBar.setImmersive(true);
        this.mTitleBar.setLeftClickListener(new c(this));
        int r100 = com.ss.android.lark.contact.base.service.a.f418904a;
        Intrinsics.checkNotNullParameter("contact.mygroup.redesign", "featureName");
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isEnable("contact.mygroup.redesign");
        if (((ContactsMyGroupFragment.a) this.f419472b).f419468a.f419463d == false) goto L6;
        if (r101 == false) goto L6;
        this.mTitleBar.addAction(new h(this, UIHelper.getString(R.string.Lark_Legacy_Groupchat)));
        this.mTitleBar.getRightText().setPadding(0, 0, UIUtils.dp2px(this.f419471a, 16.0f), 0);
    L6:
        this.mMyGroupVP.setAdapter(new i(this, this.f419473c));
        this.mMyGroupVP.addOnPageChangeListener(new j());
        new UDTabLayoutCoordinator(this.mIndicator, this.mMyGroupVP).attach();
        this.mIndicator.getTabAt(0).f285296e.setOnClickListener(new f(this));
        this.mIndicator.getTabAt(1).f285296e.setOnClickListener(new g(this));
    }

    @Override // com.larksuite.framework.mvp.IView
    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r100) {
        l r101 = (l) r100;
    }

    public ContactsMyGroupView(List r100, ContactsMyGroupFragment.a r101, FragmentManager r102) {
        this.f419472b = r101;
        this.f419474d = r100;
        this.f419473c = r102;
    }
}
