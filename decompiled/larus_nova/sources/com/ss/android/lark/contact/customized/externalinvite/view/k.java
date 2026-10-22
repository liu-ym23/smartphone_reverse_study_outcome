package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.widget.recyclerview.item.ItemViewHolder;

/* JADX INFO: loaded from: classes35.dex */
public final class k extends bec.a<k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f419279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f419280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f419281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CharSequence f419282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View.OnClickListener f419283i;

    @Override // bec.a
    public final void a(ItemViewHolder r100, int r101) {
        ImageView r102 = (ImageView) r100.T3(R.id.ieiIv);
        TextView r103 = (TextView) r100.T3(R.id.ieiTv);
        TextView r104 = (TextView) r100.T3(R.id.ieiSubTv);
        View r105 = r100.itemView;
        View.OnClickListener r106 = this.f419283i;
        if (r106 == null) goto L8;
        if (r105 == null) goto L8;
        r105.setOnClickListener(new com.ss.android.lark.inv.export.util.a(r106));
    L8:
        r102.setImageResource(this.f419279e);
        if (this.f419280f == 0) goto L11;
        r102.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r100.itemView.getContext(), this.f419280f)));
    L12:
        r103.setText(this.f419281g);
        CharSequence r107 = this.f419282h;
        if (r107 != null) goto L15;
    L18:
        r104.setVisibility(8);
        return;
    L15:
        if (r107.length() == 0) goto L18;
        r104.setVisibility(0);
        r104.setText(this.f419282h);
        return;
    L11:
        r102.setImageTintList(null);
        goto L12
    }

    public k(CharSequence r100, CharSequence r101, a r102) {
        super(R.layout.contact_db_invite_external_item_view);
        this.f419279e = R.drawable.contact_db_icon_scan;
        this.f419280f = 0;
        this.f419281g = r100;
        this.f419282h = r101;
        this.f419283i = r102;
    }
}
