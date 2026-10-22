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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VersionOperationRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int f = 0;
    public final Context a;
    public final List<com.bytedance.ee.bear.drive.biz.versions.model.a> b;
    public Map<String, DriveVersionHistoryRecord.UserBean> c;
    public b d;
    public long e;

    public static class RecordViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final TextView d;
        public final TextView e;
        public final TextView f;
        public final LinearLayout g;

        public RecordViewHolder(View r2) {
            super(r2);
            this.a = (TextView) r2.findViewById(2131392055);
            this.b = (TextView) r2.findViewById(2131381560);
            this.c = (ImageView) r2.findViewById(2131372461);
            this.d = (TextView) r2.findViewById(2131372416);
            this.e = (TextView) r2.findViewById(2131381577);
            this.f = (TextView) r2.findViewById(2131372455);
            this.g = (LinearLayout) r2.findViewById(2131372411);
        }
    }

    public class a extends RecyclerView.ViewHolder {
        public a(View r1) {
            super(r1);
        }
    }

    public interface b {
        void u(DriveVersionHistoryRecord.RecordBean r1);
    }

    static {
        f = n.d(8);
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public VersionOperationRecordAdapter(Context r2) {
        this.b = new ArrayList();
        this.c = new HashMap();
        this.a = r2;
    }

    public final int getItemViewType(int r2) {
        return ((com.bytedance.ee.bear.drive.biz.versions.model.a) ListProtector.get(this.b, r2)).getType();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        if (getItemViewType(r11) != 0) goto L51;
        RecordViewHolder r12 = (RecordViewHolder) r10;
        final DriveVersionHistoryRecord.RecordBean r13 = ((com.bytedance.ee.bear.drive.biz.versions.model.a.b) ListProtector.get(this.b, r11)).a;
        if (r13.getType() != 2) goto L7;
    L13:
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) r12).itemView.getLayoutParams();
        r0.height = this.a.getResources().getDimensionPixelSize(2131166313);
        ((RecyclerView.ViewHolder) r12).itemView.setLayoutParams(r0);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(null);
        ((RecyclerView.ViewHolder) r12).itemView.setClickable(false);
        r12.g.setVisibility(8);
    L14:
        int r1 = r13.getType();
        if (r1 == 1) goto L34;
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L20;
        HashMap r2 = new HashMap();
        r2.put("tag", String.valueOf(r13.getSourceTag()));
        if (TextUtils.isEmpty(r13.getSourceName()) == false) goto L26;
        String r3 = "";
    L27:
        r2.put("name", r3);
        String r4 = xo5.a.d(this.a, 2131888400, r2);
    L37:
        r12.b.setText(r4);
        if (r13.isDeleted() == false) goto L40;
        r12.d.setAlpha(0.3f);
        TextView r5 = r12.d;
        r5.setPaintFlags(r5.getPaintFlags() | 16);
        r12.f.setVisibility(0);
    L42:
        if (r13.isCipherDeleted() == false) goto L44;
        r12.d.setText(this.a.getResources().getString(2131887103));
    L45:
        int r6 = ua5.a.h(com.bytedance.ee.util.io.a.c(r13.getName()));
        r12.c.setImageResource(r6);
        DriveVersionHistoryRecord.UserBean r7 = this.c.get(r13.getEditUid());
        if (r7 == null) goto L48;
        r12.a.setText(r7.getCname());
    L49:
        long r8 = r13.getEditTime();
        r12.e.setText(zu5.a.b(this.a, r8));
        return;
    L48:
        r12.a.setText("");
        goto L49
    L44:
        r12.d.setText(r13.getName());
        goto L45
    L40:
        r12.d.setAlpha(1.0f);
        TextView r9 = r12.d;
        r9.setPaintFlags(r9.getPaintFlags() & (-17));
        r12.f.setVisibility(8);
        goto L42
    L26:
        r3 = r13.getSourceName();
        goto L27
    L20:
        if (r1 == 4) goto L22;
        r4 = "";
        goto L37
    L22:
        HashMap r14 = new HashMap();
        r14.put("oldTag", String.valueOf(r13.getSourceTag()));
        r14.put("newTag", String.valueOf(r13.getTag()));
        r4 = xo5.a.d(this.a, 2131888404, r14);
        goto L37
    L28:
        HashMap r16 = new HashMap();
        r16.put("tag", String.valueOf(r13.getSourceTag()));
        if (TextUtils.isEmpty(r13.getName()) == false) goto L31;
        String r17 = "";
    L32:
        r16.put("name", r17);
        r4 = xo5.a.d(this.a, 2131888403, r16);
        goto L37
    L31:
        r17 = r13.getName();
        goto L32
    L34:
        if (r13.getTag() != 1) goto L36;
        r4 = xo5.a.c(this.a, 2131888405, "tag", String.valueOf(r13.getTag()));
        goto L37
    L36:
        r4 = xo5.a.c(this.a, 2131888406, "tag", String.valueOf(r13.getTag()));
        goto L37
    L7:
        if (r13.getType() == 3) goto L13;
        ViewGroup.LayoutParams r18 = ((RecyclerView.ViewHolder) r12).itemView.getLayoutParams();
        r18.height = this.a.getResources().getDimensionPixelSize(2131166312);
        ((RecyclerView.ViewHolder) r12).itemView.setLayoutParams(r18);
        r12.g.setVisibility(0);
        if (r13.isDeleted() == false) goto L12;
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(null);
        ((RecyclerView.ViewHolder) r12).itemView.setClickable(false);
        goto L14
    L12:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new e75.a(this, r13));
        ((RecyclerView.ViewHolder) r12).itemView.setClickable(true);
        goto L14
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        if (r5 == 0) goto L6;
        View r6 = new View(this.a);
        r6.setBackgroundColor(this.a.getResources().getColor(2131100545));
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, f));
        return new a(r6);
    L6:
        return new RecordViewHolder(LayoutInflater.from(this.a).inflate(2131560201, r4, false));
    }
}
