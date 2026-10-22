package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/commentimage/SlidesImagePageAdapter;", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/MultiTypePagerAdapter;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class SlidesImagePageAdapter extends MultiTypePagerAdapter {
    public final Context b;
    public final py3.a c;
    public final List<o14.a> d;
    public final HashMap<Integer, g<o14.a>> e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final int f(int r1) {
        return 0;
    }

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "any");
        return -2;
    }

    public final int getCount() {
        return ((ArrayList) this.d).size();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final List<Integer> h() {
        return new ArrayList();
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final int g(View r2) {
        if (r2 == null) goto L4;
        Object r3 = r2.getTag(2131372247);
    L6:
        if ((r3 instanceof Integer) == true) goto L10;
        return 0;
    L10:
        return ((Number) r3).intValue();
    L4:
        r3 = null;
        goto L6
    }

    public SlidesImagePageAdapter(Context r2, py3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.b = r2;
        this.c = r3;
        this.d = new ArrayList();
        this.e = new HashMap();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final void j(View r3, int r4) {
        g r1 = null;
        if ((r3 instanceof View) == true) goto L6;
        r3 = null;
    L6:
        if (r3 == null) goto L8;
        Object r5 = r3.getTag(2131372246);
    L10:
        if ((r5 instanceof g) == false) goto L12;
        r1 = (g) r5;
    L12:
        this.e.remove(Integer.valueOf(r4));
        if (r1 == null) goto L16;
        r1.k();
        return;
    L16:
        return;
    L8:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
    public final View i(int r6, View r7, ViewGroup r8) {
        if (((ArrayList) this.d).size() <= 0) goto L6;
        int r0 = r6 % ((ArrayList) this.d).size();
    L6:
        if (new ArrayList().contains(0) == true) goto L14;
        if (r7 == null) goto L14;
        Object r9 = r7.getTag(2131372246);
        if ((r9 instanceof g) == false) goto L12;
        g<o14.a> r10 = (g) r9;
    L13:
        Intrinsics.checkNotNull(r10);
    L15:
        List<o14.a> r1 = this.d;
        if (((ArrayList) r1).size() <= 0) goto L18;
        int r2 = r6 % ((ArrayList) this.d).size();
    L19:
        o14.a r3 = (o14.a) ListProtector.get(r1, r2);
        Integer r4 = Integer.valueOf(r6);
        this.e.put(r4, r10);
        r10.c(r3, r6);
        return r7;
    L18:
        r2 = r6;
        goto L19
    L12:
        r10 = null;
    L14:
        Intrinsics.checkNotNull(r8);
        d r11 = new d(LayoutInflater.from(r8.getContext()).inflate(2131558597, r8, false), this.c);
        View r12 = r11.a;
        r12.setTag(2131372247, 0);
        r12.setTag(2131372246, r11);
        r10 = r11;
        r7 = r12;
        goto L15
    }
}
