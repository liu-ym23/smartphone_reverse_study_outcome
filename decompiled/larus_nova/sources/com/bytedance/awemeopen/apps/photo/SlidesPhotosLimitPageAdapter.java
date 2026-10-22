package com.bytedance.awemeopen.apps.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/SlidesPhotosLimitPageAdapter;", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/MultiTypePagerAdapter;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class SlidesPhotosLimitPageAdapter extends MultiTypePagerAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f197778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lz3.b f197779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<PhotoModel> f197780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<Integer, g<PhotoModel>> f197781e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final int f(int r100) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "any");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return ((ArrayList) this.f197780d).size();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final List<Integer> h() {
        return new ArrayList();
    }

    public final Context getContext() {
        return this.f197778b;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final int g(View r100) {
        if (r100 == null) goto L4;
        Object r101 = r100.getTag(R.id.feed_pager_adapter_tag_type);
    L6:
        if ((r101 instanceof Integer) == true) goto L10;
        return 0;
    L10:
        return ((Number) r101).intValue();
    L4:
        r101 = null;
        goto L6
    }

    public SlidesPhotosLimitPageAdapter(Context r100, lz3.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f197778b = r100;
        this.f197779c = r101;
        this.f197780d = new ArrayList();
        this.f197781e = new HashMap();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final void j(View r100, int r101) {
        g r102 = null;
        if ((r100 instanceof View) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        Object r103 = r100.getTag(R.id.feed_pager_adapter_tag_holder);
    L10:
        if ((r103 instanceof g) == false) goto L12;
        r102 = (g) r103;
    L12:
        this.f197781e.remove(Integer.valueOf(r101));
        if (r102 == null) goto L16;
        r102.k();
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final View i(int r100, View r101, ViewGroup r102) {
        if (((ArrayList) this.f197780d).size() <= 0) goto L6;
        int r103 = r100 % ((ArrayList) this.f197780d).size();
    L6:
        if (new ArrayList().contains(0) == true) goto L14;
        if (r101 == null) goto L14;
        Object r104 = r101.getTag(R.id.feed_pager_adapter_tag_holder);
        if ((r104 instanceof g) == false) goto L12;
        g<PhotoModel> r105 = (g) r104;
    L13:
        Intrinsics.checkNotNull(r105);
    L15:
        r105.f197058a.setTag(R.id.common_feed_core_holder_id, r105);
        List<PhotoModel> r106 = this.f197780d;
        if (((ArrayList) r106).size() <= 0) goto L18;
        int r107 = r100 % ((ArrayList) this.f197780d).size();
    L19:
        PhotoModel r108 = (PhotoModel) ListProtector.get(r106, r107);
        Integer r109 = Integer.valueOf(r100);
        this.f197781e.put(r109, r105);
        r105.c(r108, r100);
        return r101;
    L18:
        r107 = r100;
        goto L19
    L12:
        r105 = null;
    L14:
        Intrinsics.checkNotNull(r102);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d r110 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.d(LayoutInflater.from(r102.getContext()).inflate(R.layout.aos_familiar_item_slides_photo_for_picture_dtail, r102, false), this.f197779c);
        View r111 = r110.f197058a;
        r111.setTag(R.id.feed_pager_adapter_tag_type, 0);
        r111.setTag(R.id.feed_pager_adapter_tag_holder, r110);
        r105 = r110;
        r101 = r111;
        goto L15
    }
}
