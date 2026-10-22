package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ShareItemAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ShareItemModel> f216522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f216523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f216524c;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f216525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f216526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f216527c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UDBadgeView f216528d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f216529e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ShareItemAdapter f216530f;

        public b(ShareItemAdapter r100, View r101) {
            this.f216530f = r100;
            super(r101);
            this.f216526b = r101;
            this.f216525a = r101.getContext();
            this.f216527c = (ImageView) r101.findViewById(R.id.share_icon);
            this.f216529e = (TextView) r101.findViewById(R.id.share_text);
            this.f216528d = (UDBadgeView) r101.findViewById(R.id.share_badge);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<ShareItemModel> r100 = this.f216522a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public ShareItemAdapter() {
        this.f216522a = new ArrayList();
        this.f216524c = -1;
    }

    public final void y2(List<ShareItemModel> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<ShareItemModel> r101 = this.f216522a;
        this.f216522a = new ArrayList();
        Iterator<ShareItemModel> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ShareItemModel r103 = r102.next();
        ShareState r104 = ShareState.NOT_SHOW;
        if (r104.equals(r103.itemStateLiveData().getValue()) == true) goto L6;
        r103.itemStateLiveData().setValue(r104);
        goto L6
    L10:
        Iterator<ShareItemModel> r105 = r100.iterator();
    L12:
        if (r105.hasNext() == false) goto L25;
        ShareItemModel r106 = r105.next();
        ShareType r107 = r106.getType();
        if (AppInfoUtils.e().booleanValue() == false) goto L21;
        if (r107 == ShareType.QQ) goto L12;
        if (r107 == ShareType.Weibo) goto L12;
    L21:
        if (r106.getState() == ShareState.NOT_SHOW) goto L12;
        this.f216522a.add(r106);
        ShareState r108 = ShareState.SHOW;
        if (r108.equals(r106.itemStateLiveData().getValue()) == true) goto L12;
        r106.itemStateLiveData().setValue(r108);
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        ShareItemModel r103 = (ShareItemModel) ListProtector.get(this.f216522a, r101);
        if (r102.f216530f.f216524c == (-1)) goto L7;
        ViewGroup.LayoutParams r104 = r102.f216527c.getLayoutParams();
        if (r104 == null) goto L7;
        int r105 = r102.f216530f.f216524c;
        r104.height = r105;
        r104.width = r105;
        r102.f216527c.setLayoutParams(r104);
    L7:
        int r106 = 0;
        if (r103.getShareIconStyle() != ShareItemModel.ShareIconStyle.FILL) goto L10;
        int r107 = 0;
    L11:
        r102.f216527c.setPadding(r107, r107, r107, r107);
        r102.f216527c.setScaleType(r103.getScaleType());
        r102.f216527c.setImageDrawable(null);
        r102.f216527c.setVisibility(0);
        if (TextUtils.isEmpty(r103.getIconUrl()) == true) goto L15;
        ImageLoader.with(r102.f216525a).load(new BearGlideUrl(r103.getIconUrl())).into(r102.f216527c);
    L24:
        if (r103.getSrcTint() == Integer.MIN_VALUE) goto L26;
        r102.f216527c.setImageTintList(ColorStateList.valueOf(r103.getSrcTint()));
    L27:
        r102.f216527c.setBackgroundColor(r103.getShareItemBackground());
        UDBadgeView r108 = r102.f216528d;
        if (r103.getState() == ShareState.SHOW_NEW) goto L31;
        r106 = 8;
    L31:
        r108.setVisibility(r106);
        r102.f216529e.setText(r103.getDescription());
        ViewPropertyAnimator r109 = r102.f216526b.animate();
        if (r103.isClickable() == false) goto L34;
        float r110 = 1.0f;
    L35:
        r109.alpha(r110).setDuration(150).start();
        r102.f216526b.setOnClickListener(new c(this, r101));
        return;
    L34:
        r110 = 0.3f;
        goto L35
    L26:
        r102.f216527c.setImageTintList(null);
        goto L27
    L15:
        if (TextUtils.isEmpty(r103.getIconKey()) == true) goto L19;
        int r111 = r102.f216525a.getResources().getIdentifier(r103.getIconKey(), "drawable", r102.f216525a.getPackageName());
        if (r111 <= 0) goto L19;
    L20:
        if (r111 <= 0) goto L22;
        r102.f216527c.setImageResource(r111);
        goto L24
    L22:
        r102.f216527c.setVisibility(4);
    L19:
        r111 = r103.getIconResId();
        goto L20
    L10:
        r107 = r102.f216525a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_14);
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new b(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.share_widget_share_item, r100, false));
    }
}
