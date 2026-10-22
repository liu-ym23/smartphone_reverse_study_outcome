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
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import i75.i;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import sbb.e;
import z65.b;

/* JADX INFO: loaded from: classes16.dex */
public class UploadListAdapter extends RecyclerView.Adapter<UploadListViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f223932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f223933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f223934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UploadListStatusLayout.a f223935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f223936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<String> f223937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f223938g;

    public class UploadListViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f223939i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SwipeMenuLayout f223940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FrameLayout f223941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f223942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f223943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f223944e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final UploadListStatusLayout f223945f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ImageView f223946g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ UploadListAdapter f223947h;

        public class a extends t {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ UploadListViewHolder f223948c;

            public a(UploadListViewHolder r100) {
                this.f223948c = r100;
            }

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r100) {
                int r101 = this.f223948c.getAdapterPosition();
                if (r101 >= 0) goto L5;
                return;
            L5:
                if (r101 >= this.f223948c.f223947h.f223932a.size()) goto L11;
                b r102 = (b) ListProtector.get(this.f223948c.f223947h.f223932a, r101);
                UploadListFragment r103 = ((a75.b) this.f223948c.f223947h.f223935d).f2017a;
                int r104 = UploadListFragment.f223919n;
                r103.getClass();
                o75.b.a().Ke().o(EventConstant.Value.RETRY, "none", r103.f223926m);
                f r105 = (f) r103.f224080f;
                String r106 = r102.f570500g;
                w r107 = r105.f2021e;
                if (r107 == null) goto L12;
                r107.b(r106);
                return;
            L12:
                return;
            }
        }

        public UploadListViewHolder(UploadListAdapter r100, View r101) {
            this.f223947h = r100;
            super(r101);
            SwipeMenuLayout r102 = (SwipeMenuLayout) r101;
            this.f223940a = r102;
            this.f223941b = (FrameLayout) r102.findViewById(R.id.item_infomation);
            this.f223942c = (ImageView) r102.findViewById(R.id.item_icon);
            this.f223943d = (TextView) r102.findViewById(R.id.item_upload_file_name);
            this.f223944e = (TextView) r102.findViewById(R.id.item_upload_file_size);
            UploadListStatusLayout r103 = (UploadListStatusLayout) r102.findViewById(R.id.uploadlist_status);
            this.f223945f = r103;
            ImageView r104 = (ImageView) r101.findViewById(R.id.swipe_menu_delete);
            this.f223946g = r104;
            r104.setOnClickListener(new c75.b(this));
            r103.f223951c.setOnClickListener(new a(this));
        }
    }

    public interface a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<b> r100 = this.f223932a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public UploadListAdapter() {
        this.f223936e = "";
        this.f223937f = new HashSet();
    }

    public static String y2(String r100, String r101) {
        return r100 + String.format(" / %s", new Object[]{r101});
    }

    public static void z2(b r100, UploadListViewHolder r101) {
        r101.f223942c.setImageResource(kac.a.b(r100.f570494a));
        r101.f223942c.setColorFilter(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        UploadListViewHolder r112 = (UploadListViewHolder) r110;
        final b r113 = (b) ListProtector.get(this.f223932a, r111);
        r112.itemView.setAlpha(1.0f);
        ImageView r100 = r112.f223946g;
        Resources r101 = this.f223933b.getResources();
        int r102 = this.f223933b.getResources().getColor(R.color.static_white);
        String r103 = null;
        VectorDrawableCompat r104 = VectorDrawableCompat.create(r101, R.drawable.ud_icon_delete_trash_outlined, null);
        if (r104 == null) goto L5;
        r104.setTint(r102);
        r100.setImageDrawable(r104);
    L6:
        String r105 = r113.f570499f;
        if (TextUtils.isEmpty(r105) == false) goto L9;
        String r106 = "";
    L11:
        if (TextUtils.equals(this.f223938g, "wiki") == false) goto L13;
        int r107 = ua5.a.j(e.f541301l.f541317b, r113.f570495b);
    L14:
        r113.f570494a = r107;
        r112.f223943d.setText(r113.f570495b);
        String r108 = wu5.a.a(Double.valueOf(r113.f570496c), "0B", new DecimalFormat("#.##"));
        String r109 = wu5.a.a(Double.valueOf(r113.f570497d), "0B", new DecimalFormat("#.##"));
        int r114 = r113.f570498e;
        if (r114 == 1) goto L23;
        if (r114 == 2) goto L22;
        if (r114 == 3) goto L21;
        if (r114 != 4) goto L46;
        z2(r113, r112);
        r112.f223944e.setText(y2(r108, r109));
        tt5.a.h("UpdateListTAG", "delete upload finish item key = " + r113.f570500g + " " + r113.f570498e + " " + r113.f570501h);
        r112.f223945f.c(r113.f570498e, r113.f570501h, this.f223937f.add(r113.f570500g));
    L46:
        r113.f570502i = r113.f570498e;
        if (r113.f570503j == false) goto L55;
        SwipeMenuLayout r115 = r112.f223940a;
        r115.getClass();
        SwipeMenuLayout.f226687t = r115;
        DocsLinearLayoutManager r116 = r115.f226702o;
        if (r116 == null) goto L51;
        r116.f226663a = false;
    L51:
        View r117 = r115.f226693f;
        if (r117 == null) goto L54;
        r117.setLongClickable(false);
    L54:
        r115.a();
        r115.scrollTo(Math.max(r115.f226705r, r115.f226691d), 0);
        r115.f226698k = true;
        r115.d(true);
    L56:
        r112.f223940a.setOnUserSwipeMenuListener(new c75.a(this, r113));
        return;
    L55:
        r112.f223940a.f();
        goto L56
    L21:
        z2(r113, r112);
        r112.f223944e.setText(y2(r108, r109));
        r112.f223945f.c(r113.f570498e, r113.f570501h, false);
        goto L46
    L22:
        z2(r113, r112);
        r112.f223944e.setText(y2(r108, r109));
        r112.f223945f.c(r113.f570498e, r113.f570501h, false);
        goto L46
    L23:
        ColorMatrix r118 = new ColorMatrix();
        r118.setSaturation(0.0f);
        ColorMatrixColorFilter r119 = new ColorMatrixColorFilter(r118);
        r112.f223942c.setImageResource(kac.a.b(r113.f570494a));
        r112.f223942c.setColorFilter(r119);
        TextView r120 = r112.f223944e;
        int r121 = r113.f570498e;
        if (r121 == 1) goto L58;
        if (r121 == 2) goto L31;
        if (r121 == 3) goto L30;
        if (r121 != 4) goto L41;
        r103 = this.f223933b.getResources().getString(R.string.Drive_Drive_UploadComplete);
    L41:
        r120.setText(y2(r103, r109));
        r112.f223945f.c(r113.f570498e, r113.f570501h, false);
        UploadListStatusLayout r122 = r112.f223945f;
        boolean r123 = i.a(CastIntegerProtector.valueOf(r113.f570504k).intValue());
    L45:
        r122.setRetryStatus(r123);
    L44:
        tt5.a.d("UpdateListTAG", "errorCode invalid format");
        r123 = true;
        goto L45
    L30:
        r103 = this.f223933b.getResources().getString(R.string.Drive_Drive_Uploading);
        goto L41
    L31:
        r103 = this.f223933b.getResources().getString(R.string.Drive_Drive_WaitingForUpload);
        goto L41
    L58:
        int r124 = CastIntegerProtector.valueOf(r113.f570504k).intValue();     // Catch: Exception -> L35
    L36:
        switch(r124) {
            case 1001: goto L40;
            case 90003041: goto L39;
            case 90003043: goto L38;
            case 90003044: goto L39;
            default: goto L37;
        };
    L37:
        r103 = this.f223933b.getResources().getString(R.string.Drive_Drive_UploadInterrupt);
        goto L41
    L38:
        r103 = this.f223933b.getResources().getString(R.string.CreationMobile_Drive_Upload_No_MaxSizeReached_var);
        goto L41
    L39:
        r103 = this.f223933b.getResources().getString(R.string.Drive_Drive_SpaceFolderIsDeleted);
        goto L41
    L40:
        r103 = this.f223933b.getResources().getString(R.string.Drive_Drive_LocalFileIsDeleted);
    L35:
        tt5.a.d("UpdateListTAG", "errorCode invalid format");
        r124 = 0;
        goto L36
    L13:
        r107 = ua5.a.h(r106);
        goto L14
    L9:
        r106 = r105.toLowerCase();
        goto L11
    L5:
        tt5.a.d("VectorDrawableUtils", "initSearchIcon VectorDrawableCompat is null !!");
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Context r102 = r100.getContext();
        this.f223933b = r102;
        UploadListViewHolder r103 = new UploadListViewHolder(this, LayoutInflater.from(r102).inflate(R.layout.drive_uploadlist_recycler_item, r100, false));
        r103.f223940a.setDefaultMenuWidths(this.f223933b.getResources().getDimensionPixelSize(R.dimen.drive_upload_list_swipe_menu_width));
        return r103;
    }
}
