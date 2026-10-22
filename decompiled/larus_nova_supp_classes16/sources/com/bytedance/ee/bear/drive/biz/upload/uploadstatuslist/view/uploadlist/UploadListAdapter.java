package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.uploadlist;

import a75.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter.w;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.UploadListFragment;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import i75.i;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import sbb.e;
import z65.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadListAdapter extends RecyclerView.Adapter<UploadListViewHolder> {
    public List<b> a;
    public Context b;
    public a c;
    public UploadListStatusLayout.a d;
    public String e;
    public final HashSet<String> f;
    public String g;

    public class UploadListViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int i = 0;
        public final SwipeMenuLayout a;
        public final FrameLayout b;
        public final ImageView c;
        public final TextView d;
        public final TextView e;
        public final UploadListStatusLayout f;
        public final ImageView g;
        public final /* synthetic */ UploadListAdapter h;

        public class a extends t {
            public final /* synthetic */ UploadListViewHolder c;

            public a(UploadListViewHolder r1) {
                this.c = r1;
            }

            public final void a(View r6) {
                int r7 = this.c.getAdapterPosition();
                if (r7 >= 0) goto L5;
                return;
            L5:
                if (r7 >= this.c.h.a.size()) goto L11;
                b r8 = (b) ListProtector.get(this.c.h.a, r7);
                UploadListFragment r0 = ((a75.b) this.c.h.d).a;
                int r1 = UploadListFragment.n;
                r0.getClass();
                o75.b.a().Ke().o("retry", "none", r0.m);
                f r2 = (f) r0.f;
                String r9 = r8.g;
                w r3 = r2.e;
                if (r3 == null) goto L12;
                r3.b(r9);
                return;
            L12:
                return;
            }
        }

        public UploadListViewHolder(UploadListAdapter r2, View r3) {
            this.h = r2;
            super(r3);
            SwipeMenuLayout r4 = (SwipeMenuLayout) r3;
            this.a = r4;
            this.b = (FrameLayout) r4.findViewById(2131375780);
            this.c = (ImageView) r4.findViewById(2131375773);
            this.d = (TextView) r4.findViewById(2131375880);
            this.e = (TextView) r4.findViewById(2131375881);
            UploadListStatusLayout r5 = (UploadListStatusLayout) r4.findViewById(2131391942);
            this.f = r5;
            ImageView r6 = (ImageView) r3.findViewById(2131387819);
            this.g = r6;
            r6.setOnClickListener(new c75.b(this));
            r5.c.setOnClickListener(new a(this));
        }
    }

    public interface a {
    }

    public final int getItemCount() {
        List<b> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public UploadListAdapter() {
        this.e = "";
        this.f = new HashSet();
    }

    public static String y2(String r2, String r3) {
        return r2 + String.format(" / %s", new Object[]{r3});
    }

    public static void z2(b r1, UploadListViewHolder r2) {
        r2.c.setImageResource(kac.a.b(r1.a));
        r2.c.setColorFilter(null);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        UploadListViewHolder r14 = (UploadListViewHolder) r12;
        final b r16 = (b) ListProtector.get(this.a, r13);
        ((RecyclerView.ViewHolder) r14).itemView.setAlpha(1.0f);
        ImageView r0 = r14.g;
        Resources r1 = this.b.getResources();
        int r2 = this.b.getResources().getColor(2131106521);
        String r4 = null;
        VectorDrawableCompat r3 = VectorDrawableCompat.create(r1, 2131254201, null);
        if (r3 == null) goto L5;
        r3.setTint(r2);
        r0.setImageDrawable(r3);
    L6:
        String r5 = r16.f;
        if (TextUtils.isEmpty(r5) == false) goto L9;
        String r6 = "";
    L11:
        if (TextUtils.equals(this.g, FileInfoPuller.CALLER_WIKI) == false) goto L13;
        int r7 = ua5.a.j(e.l.b, r16.b);
    L14:
        r16.a = r7;
        r14.d.setText(r16.b);
        String r8 = wu5.a.a(Double.valueOf(r16.c), "0B", new DecimalFormat("#.##"));
        String r9 = wu5.a.a(Double.valueOf(r16.d), "0B", new DecimalFormat("#.##"));
        int r10 = r16.e;
        if (r10 == 1) goto L23;
        if (r10 == 2) goto L22;
        if (r10 == 3) goto L21;
        if (r10 != 4) goto L46;
        z2(r16, r14);
        r14.e.setText(y2(r8, r9));
        tt5.a.h("UpdateListTAG", "delete upload finish item key = " + r16.g + " " + r16.e + " " + r16.h);
        r14.f.c(r16.e, r16.h, this.f.add(r16.g));
    L46:
        r16.i = r16.e;
        if (r16.j == false) goto L55;
        SwipeMenuLayout r11 = r14.a;
        r11.getClass();
        SwipeMenuLayout.t = r11;
        DocsLinearLayoutManager r17 = r11.o;
        if (r17 == null) goto L51;
        r17.a = false;
    L51:
        View r18 = r11.f;
        if (r18 == null) goto L54;
        r18.setLongClickable(false);
    L54:
        r11.a();
        r11.scrollTo(Math.max(r11.r, r11.d), 0);
        r11.k = true;
        r11.d(true);
    L56:
        r14.a.setOnUserSwipeMenuListener(new c75.a(this, r16));
        return;
    L55:
        r14.a.f();
        goto L56
    L21:
        z2(r16, r14);
        r14.e.setText(y2(r8, r9));
        r14.f.c(r16.e, r16.h, false);
        goto L46
    L22:
        z2(r16, r14);
        r14.e.setText(y2(r8, r9));
        r14.f.c(r16.e, r16.h, false);
        goto L46
    L23:
        ColorMatrix r19 = new ColorMatrix();
        r19.setSaturation(0.0f);
        ColorMatrixColorFilter r20 = new ColorMatrixColorFilter(r19);
        r14.c.setImageResource(kac.a.b(r16.a));
        r14.c.setColorFilter(r20);
        TextView r21 = r14.e;
        int r22 = r16.e;
        if (r22 == 1) goto L58;
        if (r22 == 2) goto L31;
        if (r22 == 3) goto L30;
        if (r22 != 4) goto L41;
        r4 = this.b.getResources().getString(2131888453);
    L41:
        r21.setText(y2(r4, r9));
        r14.f.c(r16.e, r16.h, false);
        UploadListStatusLayout r23 = r14.f;
        boolean r24 = i.a(CastIntegerProtector.valueOf(r16.k).intValue());
    L45:
        r23.setRetryStatus(r24);
    L44:
        tt5.a.d("UpdateListTAG", "errorCode invalid format");
        r24 = true;
        goto L45
    L30:
        r4 = this.b.getResources().getString(2131888457);
        goto L41
    L31:
        r4 = this.b.getResources().getString(2131888466);
        goto L41
    L58:
        int r26 = CastIntegerProtector.valueOf(r16.k).intValue();     // Catch: Exception -> L35
    L36:
        switch(r26) {
            case 1001: goto L40;
            case 90003041: goto L39;
            case 90003043: goto L38;
            case 90003044: goto L39;
            default: goto L37;
        };
    L37:
        r4 = this.b.getResources().getString(2131888455);
        goto L41
    L38:
        r4 = this.b.getResources().getString(2131887243);
        goto L41
    L39:
        r4 = this.b.getResources().getString(2131888451);
        goto L41
    L40:
        r4 = this.b.getResources().getString(2131888421);
    L35:
        tt5.a.d("UpdateListTAG", "errorCode invalid format");
        r26 = 0;
        goto L36
    L13:
        r7 = ua5.a.h(r6);
        goto L14
    L9:
        r6 = r5.toLowerCase();
        goto L11
    L5:
        tt5.a.d("VectorDrawableUtils", "initSearchIcon VectorDrawableCompat is null !!");
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Context r6 = r4.getContext();
        this.b = r6;
        UploadListViewHolder r0 = new UploadListViewHolder(this, LayoutInflater.from(r6).inflate(2131560243, r4, false));
        r0.a.setDefaultMenuWidths(this.b.getResources().getDimensionPixelSize(2131166338));
        return r0;
    }
}
