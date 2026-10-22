package com.bytedance.ee.bear.document.editionmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.larus.nova.R;
import z05.a;

/* JADX INFO: loaded from: classes16.dex */
public class EditionLoadingFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f219612e = 0;

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        return true;
    }

    public EditionLoadingFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        EditionViewModel r102 = (EditionViewModel) q.a(this, EditionViewModel.class);
        AppCompatImageView r103 = (AppCompatImageView) r100.findViewById(R.id.title_bar_back);
        r103.setVisibility(0);
        r103.setOnClickListener(new a(this));
        LoadingLayout r104 = (LoadingLayout) r100.findViewById(R.id.edition_loading);
        r104.setVisibility(0);
        if (getArguments() != null) goto L5;
        return;
    L5:
        if (getArguments().getBoolean("showNotFound") == false) goto L9;
        r104.a(-58, "");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.document_edition_loading_layout, r101, false);
    }
}
