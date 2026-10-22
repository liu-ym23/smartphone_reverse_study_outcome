package com.bytedance.ee.bear.bitable.card.view.cell.user;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larus.nova.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes15.dex */
public class UserItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.user.a f208364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f208365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BitableAtEditText f208366c;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UserEntity f208367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UserItemView f208368d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            com.bytedance.ee.bear.bitable.card.view.cell.user.a r101 = this.f208368d.f208364a;
            if (r101 == null) goto L6;
            String r102 = this.f208367c.getUserId();
            ((com.bytedance.ee.bear.bitable.card.view.cell.immutableuser.ImmutableUserCellViewHolder) r101).f207229a.l(r102);
            return;
        }

        public a(UserItemView r100, UserEntity r101) {
            this.f208368d = r100;
            this.f208367c = r101;
        }
    }

    public class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UserEntity f208369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UserItemView f208370d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            com.bytedance.ee.bear.bitable.card.view.cell.user.a r101 = this.f208370d.f208364a;
            if (r101 == null) goto L6;
            String r102 = this.f208369c.getUserId();
            ((com.bytedance.ee.bear.bitable.card.view.cell.immutableuser.ImmutableUserCellViewHolder) r101).f207229a.l(r102);
            return;
        }

        public b(UserItemView r100, UserEntity r101) {
            this.f208370d = r100;
            this.f208369c = r101;
        }
    }

    public UserItemView(Context r100) {
        this(r100, null);
    }

    private void setDisplayName(UserEntity r100) {
        this.f208366c.setText(b(r100, this.f208364a));
    }

    public final void a(UserEntity r100) {
        setDisplayName(r100);
        String r101 = r100.getAvatarUrl();
        Glide.with(getContext()).load(new BearGlideUrl(r101)).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(R.drawable.facade_common_avatar_place_holder).into(this.f208365b);
        setOnClickListener(new a(this, r100));
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.useritemview.name.click.disable") == true) goto L6;
        this.f208366c.setOnClickListener(new b(this, r100));
        return;
    }

    public void setDelegate(com.bytedance.ee.bear.bitable.card.view.cell.user.a r100) {
        this.f208364a = r100;
        if (r100 == null) goto L8;
        BitableAtEditText r101 = this.f208366c;
        if (r101 == null) goto L9;
        com.bytedance.ee.bear.bitable.card.view.cell.immutableuser.ImmutableUserCellViewHolder r102 = (com.bytedance.ee.bear.bitable.card.view.cell.immutableuser.ImmutableUserCellViewHolder) r100;
        r102.getClass();
        r101.setIPermissionCopyChecker(r102);
        return;
    L9:
        return;
    }

    public UserItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static String b(UserEntity r100, com.bytedance.ee.bear.bitable.card.view.cell.user.a r101) {
        String r102 = Locale.getDefault().getLanguage();
        if (r101 == null) goto L6;
        r102 = ((i0) org.koin.java.a.a(i0.class)).a();
    L6:
        if (r100 == null) goto L12;
        String r103 = ou5.a.b(r102, r100.getName(), r100.getEnName());
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return "";
    L11:
        return r103;
    L12:
        return "";
    }

    public UserItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.bitable_card_user_cell_item, this, true);
        setBackground(getResources().getDrawable(R.drawable.bitable_card_user_item_bg));
        this.f208365b = (ImageView) findViewById(R.id.user_avatar);
        BitableAtEditText r103 = (BitableAtEditText) findViewById(R.id.user_name);
        this.f208366c = r103;
        r103.setTextIsSelectable(true);
        this.f208366c.setCursorVisible(false);
        this.f208366c.setKeyListener(null);
    }
}
