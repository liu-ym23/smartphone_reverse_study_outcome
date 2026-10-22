package com.bytedance.ee.bear.document.editionmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import z05.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionLoadingFragment extends BaseFragment {
    public static final /* synthetic */ int e = 0;

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        return true;
    }

    public EditionLoadingFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        EditionViewModel r5 = (EditionViewModel) q.a(this, EditionViewModel.class);
        AppCompatImageView r6 = r3.findViewById(2131388808);
        r6.setVisibility(0);
        r6.setOnClickListener(new a(this));
        LoadingLayout r7 = (LoadingLayout) r3.findViewById(2131371479);
        r7.setVisibility(0);
        if (getArguments() != null) goto L5;
        return;
    L5:
        if (getArguments().getBoolean("showNotFound") == false) goto L9;
        r7.a(-58, "");
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131560117, r3, false);
    }
}
