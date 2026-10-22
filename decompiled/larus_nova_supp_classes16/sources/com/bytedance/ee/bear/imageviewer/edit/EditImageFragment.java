package com.bytedance.ee.bear.imageviewer.edit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.RotateLoadingView;
import olb.d;
import uw4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditImageFragment extends BaseFragment implements sw4.a, l {
    public olb.a e;
    public FrameLayout f;
    public AppCompatImageView g;
    public RelativeLayout h;
    public e i;

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        e r0 = this.i;
        if (r0 == null) goto L7;
        r0.close();
        return true;
    L7:
        return true;
    }

    public final void onResume() {
        super.onResume();
        Context r0 = this.f.getContext();
        if (this.f == null) goto L11;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.e != null) goto L9;
        View r1 = new RotateLoadingView(getContext());
        int r2 = UIUtils.dp2px(r0, 42.0f);
        this.f.addView(r1, 0, new FrameLayout.LayoutParams(r2, r2, 17));
        this.e = new olb.a(r1);
    L9:
        olb.a r3 = this.e;
        r3.getClass();
        Log.i("LazyLoadingHelper", "showLoading");
        d.a(r3.b);
        d.a(r3.c);
        Runnable r4 = r3.b;
        d.a.postDelayed(r4, 250);
        return;
    }

    public final void onStop() {
        super.onStop();
        olb.a r0 = this.e;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        FrameLayout r1 = this.f;
        if (r1 == null) goto L11;
        View r2 = r1.getChildAt(0);
        if ((r2 instanceof RotateLoadingView) == false) goto L12;
        this.f.removeView(r2);
        return;
    L12:
        return;
    }

    public EditImageFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        FrameLayout r5 = (FrameLayout) r2.inflate(2131561071, r3, false);
        this.f = r5;
        this.g = r5.findViewById(2131371410);
        this.h = (RelativeLayout) this.f.findViewById(2131371411);
        return this.f;
    }
}
