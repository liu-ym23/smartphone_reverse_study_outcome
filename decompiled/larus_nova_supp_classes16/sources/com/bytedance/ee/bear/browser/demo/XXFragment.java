package com.bytedance.ee.bear.browser.demo;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.q;
import xv4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class XXFragment extends Fragment {
    public static final /* synthetic */ int d = 0;

    public XXFragment() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        ((XXViewModel) q.a(this, XXViewModel.class)).getWebData().observe(this, new a(this));
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
    }
}
