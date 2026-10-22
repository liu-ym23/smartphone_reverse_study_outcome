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
import com.ss.android.lark.image.ImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShareItemAdapter extends RecyclerView.Adapter<b> {
    public List<ShareItemModel> a;
    public a b;
    public int c;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {
        public final Context a;
        public final View b;
        public final ImageView c;
        public final UDBadgeView d;
        public final TextView e;
        public final /* synthetic */ ShareItemAdapter f;

        public b(ShareItemAdapter r1, View r2) {
            this.f = r1;
            super(r2);
            this.b = r2;
            this.a = r2.getContext();
            this.c = (ImageView) r2.findViewById(2131386080);
            this.e = (TextView) r2.findViewById(2131386141);
            this.d = r2.findViewById(2131386058);
        }
    }

    public final int getItemCount() {
        List<ShareItemModel> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public ShareItemAdapter() {
        this.a = new ArrayList();
        this.c = -1;
    }

    public final void y2(List<ShareItemModel> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List<ShareItemModel> r0 = this.a;
        this.a = new ArrayList();
        Iterator<ShareItemModel> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ShareItemModel r2 = r1.next();
        ShareState r3 = ShareState.NOT_SHOW;
        if (r3.equals(r2.itemStateLiveData().getValue()) == true) goto L6;
        r2.itemStateLiveData().setValue(r3);
        goto L6
    L10:
        Iterator<ShareItemModel> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L25;
        ShareItemModel r4 = r6.next();
        ShareType r7 = r4.getType();
        if (AppInfoUtils.e().booleanValue() == false) goto L21;
        if (r7 == ShareType.QQ) goto L12;
        if (r7 == ShareType.Weibo) goto L12;
    L21:
        if (r4.getState() == ShareState.NOT_SHOW) goto L12;
        this.a.add(r4);
        ShareState r8 = ShareState.SHOW;
        if (r8.equals(r4.itemStateLiveData().getValue()) == true) goto L12;
        r4.itemStateLiveData().setValue(r8);
        goto L12
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        b r10 = (b) r8;
        ShareItemModel r0 = (ShareItemModel) ListProtector.get(this.a, r9);
        if (r10.f.c == (-1)) goto L7;
        ViewGroup.LayoutParams r1 = r10.c.getLayoutParams();
        if (r1 == null) goto L7;
        int r2 = r10.f.c;
        r1.height = r2;
        r1.width = r2;
        r10.c.setLayoutParams(r1);
    L7:
        int r3 = 0;
        if (r0.getShareIconStyle() != ShareItemModel.ShareIconStyle.FILL) goto L10;
        int r4 = 0;
    L11:
        r10.c.setPadding(r4, r4, r4, r4);
        r10.c.setScaleType(r0.getScaleType());
        r10.c.setImageDrawable(null);
        r10.c.setVisibility(0);
        if (TextUtils.isEmpty(r0.getIconUrl()) == true) goto L15;
        ImageLoader.with(r10.a).load(new BearGlideUrl(r0.getIconUrl())).into(r10.c);
    L24:
        if (r0.getSrcTint() == Integer.MIN_VALUE) goto L26;
        r10.c.setImageTintList(ColorStateList.valueOf(r0.getSrcTint()));
    L27:
        r10.c.setBackgroundColor(r0.getShareItemBackground());
        UDBadgeView r5 = r10.d;
        if (r0.getState() == ShareState.SHOW_NEW) goto L31;
        r3 = 8;
    L31:
        r5.setVisibility(r3);
        r10.e.setText(r0.getDescription());
        ViewPropertyAnimator r6 = r10.b.animate();
        if (r0.isClickable() == false) goto L34;
        float r7 = 1.0f;
    L35:
        r6.alpha(r7).setDuration(150).start();
        r10.b.setOnClickListener(new c(this, r9));
        return;
    L34:
        r7 = 0.3f;
        goto L35
    L26:
        r10.c.setImageTintList(null);
        goto L27
    L15:
        if (TextUtils.isEmpty(r0.getIconKey()) == true) goto L19;
        int r11 = r10.a.getResources().getIdentifier(r0.getIconKey(), "drawable", r10.a.getPackageName());
        if (r11 <= 0) goto L19;
    L20:
        if (r11 <= 0) goto L22;
        r10.c.setImageResource(r11);
        goto L24
    L22:
        r10.c.setVisibility(4);
    L19:
        r11 = r0.getIconResId();
        goto L20
    L10:
        r4 = r10.a.getResources().getDimensionPixelSize(2131168310);
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new b(this, LayoutInflater.from(r3.getContext()).inflate(2131564520, r3, false));
    }
}
