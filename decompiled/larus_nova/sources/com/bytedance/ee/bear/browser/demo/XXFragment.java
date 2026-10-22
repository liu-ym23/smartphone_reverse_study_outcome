package com.bytedance.ee.bear.browser.demo;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.q;
import xv4.a;

/* JADX INFO: loaded from: classes16.dex */
public class XXFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f216608d = 0;

    public XXFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((XXViewModel) q.a(this, XXViewModel.class)).getWebData().observe(this, new a(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
    }
}
