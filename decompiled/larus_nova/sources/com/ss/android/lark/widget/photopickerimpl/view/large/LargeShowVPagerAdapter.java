package com.ss.android.lark.widget.photopickerimpl.view.large;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001/B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001cH\u0016J\u0016\u0010\"\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020 J\u001c\u0010(\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020 J\u0006\u0010-\u001a\u00020\u0011J\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0016j\b\u0012\u0004\u0012\u00028\u0000`\u0017R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0014\u001a*\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0010j\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0016j\b\u0012\u0004\u0012\u00028\u0000`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/widget/photopickerimpl/view/large/LargeShowVPagerAdapter;", "DATA", "Lcom/ss/android/lark/widget/photopickerimpl/bean/Photo;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "mFactory", "Lcom/ss/android/lark/widget/photopickerimpl/view/base/IShowPluginFactory;", "Lcom/ss/android/lark/widget/photopickerimpl/view/large/LargeShowPlugin;", "mLargeShowPluginContext", "Lcom/ss/android/lark/widget/photopickerimpl/view/large/LargeShowPlugin$ILargeShowPluginContext;", "mFuncSupport", "Lcom/ss/android/lark/widget/photopickerimpl/view/large/LargeShowVPagerAdapter$IFuncSupport;", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/ss/android/lark/widget/photopickerimpl/view/base/IShowPluginFactory;Lcom/ss/android/lark/widget/photopickerimpl/view/large/LargeShowPlugin$ILargeShowPluginContext;Lcom/ss/android/lark/widget/photopickerimpl/view/large/LargeShowVPagerAdapter$IFuncSupport;)V", "mFragmentMap", "Ljava/util/HashMap;", "", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/HashMap;", "mFragToPlugin", "mData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "position", "getCount", "instantiateItem", "", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "destroyItem", "", "any", "onPageScrolled", "positionOffsetPixels", "", "onPageSelected", "onPageFinish", "onGotoPhotoEdit", "notifyDataChanged", "data", "", "append", "refreshExistingFragment", "getDataSize", "getData", "IFuncSupport", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LargeShowVPagerAdapter<DATA extends Photo> extends FragmentStatePagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final odc.b<DATA, e<DATA>> f447842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a f447843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f447844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, Fragment> f447845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<Fragment, e<DATA>> f447846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<DATA> f447847f;

    public interface a {
        void a(int r100);

        int getCurrentItem();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f447847f.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public final Fragment getItem(int r100) {
        odc.b<DATA, e<DATA>> r101 = this.f447842a;
        e<DATA> r102 = (e) r101.a(r101.getType(r100, (Photo) ListProtector.get(this.f447847f, r100)));
        e.a r103 = this.f447843b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102.getClass();
        r102.a((Photo) ListProtector.get(this.f447847f, r100));
        Fragment r104 = r102.b();
        this.f447846e.put(r104, r102);
        return r104;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Object r102 = super.instantiateItem(r100, r101);
        this.f447845d.put(Integer.valueOf(r101), (Fragment) r102);
        return r102;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "any");
        super.destroyItem(r100, r101, r102);
        Fragment r103 = this.f447845d.remove(Integer.valueOf(r101));
        if (r103 == null) goto L6;
        this.f447846e.remove(r103);
        return;
    }

    public LargeShowVPagerAdapter(FragmentManager r100, odc.b r101, c r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "mFactory");
        Intrinsics.checkNotNullParameter(r102, "mLargeShowPluginContext");
        Intrinsics.checkNotNullParameter(r103, "mFuncSupport");
        super(r100);
        this.f447842a = r101;
        this.f447843b = r102;
        this.f447844c = r103;
        this.f447845d = new HashMap();
        this.f447846e = new HashMap();
        this.f447847f = new ArrayList();
    }
}
