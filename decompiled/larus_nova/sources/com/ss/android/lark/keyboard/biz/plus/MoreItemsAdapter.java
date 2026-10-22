package com.ss.android.lark.keyboard.biz.plus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class MoreItemsAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, d5b.a> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(10745)
        ImageView mIconIv;

        @BindView(10754)
        TextView mNameTv;

        @BindView(10746)
        ImageView mRedDot;

        public ViewHolder(View r100) {
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewHolder f428478a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            ViewHolder r100 = this.f428478a;
            if (r100 == null) goto L7;
            this.f428478a = null;
            r100.mIconIv = null;
            r100.mNameTv = null;
            r100.mRedDot = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r100, View r101) {
            this.f428478a = r100;
            r100.mIconIv = (ImageView) Utils.findRequiredViewAsType(r101, R.id.item_icon, "field 'mIconIv'", ImageView.class);
            r100.mNameTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.item_name, "field 'mNameTv'", TextView.class);
            r100.mRedDot = (ImageView) Utils.findRequiredViewAsType(r101, R.id.item_icon_red_dot, "field 'mRedDot'", ImageView.class);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        d5b.a r103 = getItem(r101);
        if (r103.isVisible() == false) goto L9;
        r102.itemView.setVisibility(0);
        r102.mNameTv.setText(r103.getName());
        SquircleImageView r104 = (SquircleImageView) r102.mIconIv;
        r104.setBackgroundColor(UDColorUtils.getColor(null, R.color.imtoken_keyboard_plus_item_background));
        r104.setBackgroundTintList(UDColorUtils.getColorStateList(null, R.color.kb_more_item_bg_color_selector));
        UIHelper.dp2px(52.0f);
        if (r103.getIconId() == (-1)) goto L7;
        r104.setImageResource(r103.getIconId());
        r104.setImageTintList(null);
        r104.setRadius(UIHelper.dp2px(12.0f));
        r104.setBorderWidth(UIHelper.dp2px(0.0f));
        r104.setBorderColor(j08.b.b(ContextCompat.getColor(r104.getContext(), R.color.lkui_N900), 0.1f));
    L8:
        ImageView r105 = r102.mRedDot;
        r103.showRedDot();
        r105.setVisibility(8);
        r102.itemView.setOnClickListener(new b(this, r103, r102));
        return;
    L7:
        r103.b();
        r102.itemView.setVisibility(8);
        goto L8
    L9:
        r102.itemView.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new ViewHolder(LayoutInflater.from(null).inflate(R.layout.kb_keyboard_more_item_layout_assembler, r100, false));
    }
}
