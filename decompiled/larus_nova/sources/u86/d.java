package u86;

import android.R;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> f549183a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    public d(BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> r100) {
        this.f549183a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        if (r100 == null) goto L31;
        View r101 = r100.getCustomView();
        if (r101 == null) goto L31;
        TextView r102 = (TextView) r101.findViewById(R.id.text1);
        if (r102 == null) goto L31;
        BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> r103 = this.f549183a;
        r103.N().setSelectedTextStyle(r102);
        if (r103.f250594a == false) goto L31;
        String r104 = r102.getText().toString();
        TabLayout r105 = r103.N().getMTabLayout();
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (r105 == null) goto L12;
        int r106 = r105.getTabCount();
    L13:
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L22;
        if (r105 == null) goto L21;
        TabLayout.Tab r108 = r105.getTabAt(r107);
        if (r108 == null) goto L21;
        if (r108 != r100) goto L21;
    L24:
        if (r103.f250598e == false) goto L27;
        String r109 = "";
    L30:
        r103.sendTabChangeEvent(r104, r107, r109);
        r103.f250598e = false;
        goto L31
    L27:
        if (r103.f250597d != r100) goto L29;
        r109 = "click";
        goto L30
    L29:
        r109 = "slide";
    L21:
        r107 = r107 + 1;
        goto L14
    L22:
        r107 = 0;
        goto L24
    L12:
        r106 = 0;
    L31:
        this.f549183a.f250597d = null;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
        if (r100 == null) goto L9;
        View r101 = r100.getCustomView();
        if (r101 == null) goto L10;
        TextView r102 = (TextView) r101.findViewById(R.id.text1);
        if (r102 == null) goto L11;
        this.f549183a.N().setUnSelectedTextStyle(r102);
        return;
    L11:
        return;
    L10:
        return;
    }
}
