package com.bytedance.ee.bear.drive.test.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveBusinessTestButtonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context a;
    public final List<z85.a> b;

    public static class TestButtonViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final View b;

        public TestButtonViewHolder(View r2) {
            super(r2);
            this.b = r2;
            this.a = (TextView) r2.findViewById(2131364857);
        }
    }

    public final int getItemViewType(int r1) {
        return 0;
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public DriveBusinessTestButtonAdapter(Context r1, List<z85.a> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        TestButtonViewHolder r5 = (TestButtonViewHolder) r3;
        r5.a.setText(((z85.a) ListProtector.get(this.b, r4)).getButtonName());
        r5.a.setAlpha(1.0f);
        r5.b.setOnClickListener(new a(this, r4));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new TestButtonViewHolder(LayoutInflater.from(this.a).inflate(2131560236, r4, false));
    }
}
