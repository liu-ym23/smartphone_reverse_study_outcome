package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailCombinePropertyPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailCombinePropertyPagerAdapter extends FragmentPagerAdapter {
    public final List<AnchorV4DetailSkuVO> a;
    public final List<Fragment> b;

    public final int getCount() {
        return this.b.size();
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(this.b, r2);
    }

    public final CharSequence getPageTitle(int r3) {
        if (this.a.size() <= r3) goto L10;
        AnchorV4DetailSkuVO r4 = (AnchorV4DetailSkuVO) ListProtector.get(this.a, r3);
        if (r4 == null) goto L11;
        String r5 = r4.getName();
        if (r5 != null) goto L9;
        return "";
    L9:
        return r5;
    L11:
        return "";
    L10:
        return "";
    }

    public AnchorV4DetailCombinePropertyPagerAdapter(List<AnchorV4DetailSkuVO> r2, List<? extends Fragment> r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r2, "skuvos");
        Intrinsics.checkNotNullParameter(r3, "fragments");
        Intrinsics.checkNotNullParameter(r4, "fm");
        super(r4);
        this.a = r2;
        this.b = r3;
    }
}
