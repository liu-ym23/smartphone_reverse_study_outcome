package com.bytedance.ee.bear.drive.biz.versions.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.drive.biz.versions.model.DriveVersionHistoryRecord;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class VersionOperationRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f223976f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f223977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.drive.biz.versions.model.a> f223978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, DriveVersionHistoryRecord.UserBean> f223979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f223980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f223981e;

    public static class RecordViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f223982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f223983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f223984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f223985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f223986e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f223987f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LinearLayout f223988g;

        public RecordViewHolder(View r100) {
            super(r100);
            this.f223982a = (TextView) r100.findViewById(R.id.user_name_tv);
            this.f223983b = (TextView) r100.findViewById(R.id.operation_description_tv);
            this.f223984c = (ImageView) r100.findViewById(R.id.file_type_img);
            this.f223985d = (TextView) r100.findViewById(R.id.file_name_tv);
            this.f223986e = (TextView) r100.findViewById(R.id.opt_date_tv);
            this.f223987f = (TextView) r100.findViewById(R.id.file_tag_tv);
            this.f223988g = (LinearLayout) r100.findViewById(R.id.file_info_content_ll);
        }
    }

    public class a extends RecyclerView.ViewHolder {
        public a(View r100) {
            super(r100);
        }
    }

    public interface b {
        void u(DriveVersionHistoryRecord.RecordBean r100);
    }

    static {
        f223976f = n.d(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f223978b).size();
    }

    public VersionOperationRecordAdapter(Context r100) {
        this.f223978b = new ArrayList();
        this.f223979c = new HashMap();
        this.f223977a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((com.bytedance.ee.bear.drive.biz.versions.model.a) ListProtector.get(this.f223978b, r100)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        if (getItemViewType(r111) != 0) goto L51;
        RecordViewHolder r112 = (RecordViewHolder) r110;
        final DriveVersionHistoryRecord.RecordBean r113 = ((com.bytedance.ee.bear.drive.biz.versions.model.a.b) ListProtector.get(this.f223978b, r111)).f223999a;
        if (r113.getType() != 2) goto L7;
    L13:
        ViewGroup.LayoutParams r100 = r112.itemView.getLayoutParams();
        r100.height = this.f223977a.getResources().getDimensionPixelSize(R.dimen.drive_history_record_item_unclick_height);
        r112.itemView.setLayoutParams(r100);
        r112.itemView.setOnClickListener(null);
        r112.itemView.setClickable(false);
        r112.f223988g.setVisibility(8);
    L14:
        int r101 = r113.getType();
        if (r101 == 1) goto L34;
        if (r101 == 2) goto L28;
        if (r101 != 3) goto L20;
        HashMap r102 = new HashMap();
        r102.put("tag", String.valueOf(r113.getSourceTag()));
        if (TextUtils.isEmpty(r113.getSourceName()) == false) goto L26;
        String r103 = "";
    L27:
        r102.put("name", r103);
        String r104 = xo5.a.d(this.f223977a, R.string.Drive_Drive_HistoryRecordDeleteVersion, r102);
    L37:
        r112.f223983b.setText(r104);
        if (r113.isDeleted() == false) goto L40;
        r112.f223985d.setAlpha(0.3f);
        TextView r105 = r112.f223985d;
        r105.setPaintFlags(r105.getPaintFlags() | 16);
        r112.f223987f.setVisibility(0);
    L42:
        if (r113.isCipherDeleted() == false) goto L44;
        r112.f223985d.setText(this.f223977a.getResources().getString(R.string.CreationDoc_Docs_KeyInvalid));
    L45:
        int r106 = ua5.a.h(com.bytedance.ee.util.io.a.c(r113.getName()));
        r112.f223984c.setImageResource(r106);
        DriveVersionHistoryRecord.UserBean r107 = this.f223979c.get(r113.getEditUid());
        if (r107 == null) goto L48;
        r112.f223982a.setText(r107.getCname());
    L49:
        long r108 = r113.getEditTime();
        r112.f223986e.setText(zu5.a.b(this.f223977a, r108));
        return;
    L48:
        r112.f223982a.setText("");
        goto L49
    L44:
        r112.f223985d.setText(r113.getName());
        goto L45
    L40:
        r112.f223985d.setAlpha(1.0f);
        TextView r109 = r112.f223985d;
        r109.setPaintFlags(r109.getPaintFlags() & (-17));
        r112.f223987f.setVisibility(8);
        goto L42
    L26:
        r103 = r113.getSourceName();
        goto L27
    L20:
        if (r101 == 4) goto L22;
        r104 = "";
        goto L37
    L22:
        HashMap r114 = new HashMap();
        r114.put("oldTag", String.valueOf(r113.getSourceTag()));
        r114.put("newTag", String.valueOf(r113.getTag()));
        r104 = xo5.a.d(this.f223977a, R.string.Drive_Drive_HistoryRecordRevertVersion, r114);
        goto L37
    L28:
        HashMap r115 = new HashMap();
        r115.put("tag", String.valueOf(r113.getSourceTag()));
        if (TextUtils.isEmpty(r113.getName()) == false) goto L31;
        String r116 = "";
    L32:
        r115.put("name", r116);
        r104 = xo5.a.d(this.f223977a, R.string.Drive_Drive_HistoryRecordRename, r115);
        goto L37
    L31:
        r116 = r113.getName();
        goto L32
    L34:
        if (r113.getTag() != 1) goto L36;
        r104 = xo5.a.c(this.f223977a, R.string.Drive_Drive_HistoryRecordUploadNewVersion, "tag", String.valueOf(r113.getTag()));
        goto L37
    L36:
        r104 = xo5.a.c(this.f223977a, R.string.Drive_Drive_HistoryRecordUploadedTag, "tag", String.valueOf(r113.getTag()));
        goto L37
    L7:
        if (r113.getType() == 3) goto L13;
        ViewGroup.LayoutParams r117 = r112.itemView.getLayoutParams();
        r117.height = this.f223977a.getResources().getDimensionPixelSize(R.dimen.drive_history_record_item_normal_height);
        r112.itemView.setLayoutParams(r117);
        r112.f223988g.setVisibility(0);
        if (r113.isDeleted() == false) goto L12;
        r112.itemView.setOnClickListener(null);
        r112.itemView.setClickable(false);
        goto L14
    L12:
        r112.itemView.setOnClickListener(new e75.a(this, r113));
        r112.itemView.setClickable(true);
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 == 0) goto L6;
        View r102 = new View(this.f223977a);
        r102.setBackgroundColor(this.f223977a.getResources().getColor(R.color.bg_base));
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, f223976f));
        return new a(r102);
    L6:
        return new RecordViewHolder(LayoutInflater.from(this.f223977a).inflate(R.layout.drive_item_record, r100, false));
    }
}
