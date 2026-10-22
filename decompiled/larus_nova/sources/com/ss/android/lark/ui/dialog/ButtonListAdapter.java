package com.ss.android.lark.ui.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import y9c.d;

/* JADX INFO: loaded from: classes38.dex */
public class ButtonListAdapter extends RecyclerView.Adapter<ButtonView> {

    public static class ButtonView extends RecyclerView.ViewHolder {
        public ButtonView() {
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ButtonView r102 = (ButtonView) r100;
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        LayoutInflater.from(null).inflate(R.layout.common_dialog_button_single, r100, false).getLayoutParams();
        d.b(null, 60.0f);
        throw null;
    }
}
