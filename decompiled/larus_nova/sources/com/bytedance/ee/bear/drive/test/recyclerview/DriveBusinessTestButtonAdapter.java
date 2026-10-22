package com.bytedance.ee.bear.drive.test.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class DriveBusinessTestButtonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f224697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<z85.a> f224698b;

    public static class TestButtonViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f224699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f224700b;

        public TestButtonViewHolder(View r100) {
            super(r100);
            this.f224700b = r100;
            this.f224699a = (TextView) r100.findViewById(R.id.btn_test_business);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f224698b.size();
    }

    public DriveBusinessTestButtonAdapter(Context r100, List<z85.a> r101) {
        this.f224697a = r100;
        this.f224698b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TestButtonViewHolder r102 = (TestButtonViewHolder) r100;
        r102.f224699a.setText(((z85.a) ListProtector.get(this.f224698b, r101)).getButtonName());
        r102.f224699a.setAlpha(1.0f);
        r102.f224700b.setOnClickListener(new a(this, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new TestButtonViewHolder(LayoutInflater.from(this.f224697a).inflate(R.layout.drive_test_item, r100, false));
    }
}
