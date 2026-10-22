package com.bytedance.ee.bear.sheet.attachment;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.icon.IconSize;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AttachmentListAdapter extends RecyclerView.Adapter<AttachmentViewHolder> {
    public List<AttachmentModelList.AttachmentModel> a;
    public a b;

    public class AttachmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView a;
        public final TextView b;
        public final TextView c;
        public final /* synthetic */ AttachmentListAdapter d;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            AttachmentListAdapter r4 = this.d;
            a r0 = r4.b;
            if (r0 == null) goto L6;
            r0.a((AttachmentModelList.AttachmentModel) ListProtector.get(r4.a, getLayoutPosition()));
            return;
        }

        public AttachmentViewHolder(AttachmentListAdapter r1, View r2) {
            this.d = r1;
            super(r2);
            this.a = (ImageView) r2.findViewById(2131363343);
            this.b = (TextView) r2.findViewById(2131363344);
            this.c = (TextView) r2.findViewById(2131363345);
            r2.setOnClickListener(this);
        }
    }

    public interface a {
        void a(AttachmentModelList.AttachmentModel r1);
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public AttachmentListAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        final AttachmentViewHolder r9 = (AttachmentViewHolder) r7;
        AttachmentModelList.AttachmentModel r10 = (AttachmentModelList.AttachmentModel) ListProtector.get(this.a, r8);
        int r1 = 0;
        r9.b.setSingleLine(false);
        r9.b.setMaxLines(1);
        if (AttachmentModelList.AttachmentType.ATTACHMENT.getType().equals(r10.getType()) == false) goto L18;
        String r0 = r10.getName();
        int r3 = r0.lastIndexOf(".");
        if (r3 <= 0) goto L9;
        int r4 = r3 + 1;
        if (r4 >= r0.length()) goto L9;
        String r2 = r0.substring(r4);
    L10:
        r9.a.setImageResource(ua5.a.h(r2));
        r9.b.setText(r10.getName());
        String[] r5 = {"B", "KB", "MB", "GB"};
        long r6 = r10.getSize();
    L12:
        if (r6 <= 1024) goto L16;
        if (r1 >= 3) goto L16;
        r6 = r6 / 1024;
        r1 = r1 + 1;
    L16:
        r9.c.setText(r6 + r5[r1]);
        return;
    L9:
        r2 = (String) ((HashMap) FileUtils.b).get(r10.getMimeType());
        goto L10
    L18:
        if (AttachmentModelList.AttachmentType.MENTION.getType().equals(r10.getType()) == false) goto L32;
        int r11 = 12;
        if (r10.getMentionType() == 16) goto L26;
        if (r10.getMentionType() == 12) goto L26;
        ImageView r12 = r9.a;
        int r13 = r10.getMentionType();
        IconSize r14 = IconSize.SIZE_24;
        r12.setImageResource(ua5.a.i(r13));
    L30:
        r9.b.setText(r10.getName());
        r9.c.setText("");
        return;
    L26:
        if (r10.getMentionType() == 12) goto L29;
        r11 = 2;
    L29:
        ImageView r15 = r9.a;
        String r16 = r10.getName();
        IconSize r17 = IconSize.SIZE_24;
        r15.setImageResource(ua5.a.k(r11, r16));
        goto L30
    L32:
        if (AttachmentModelList.AttachmentType.URL.getType().equals(r10.getType()) == false) goto L34;
    L35:
        r9.a.setImageResource(kac.a.b(2131254651));
        if (TextUtils.isEmpty(r10.getName()) == false) goto L38;
        final String r18 = r10.getLink();
    L39:
        SpannableStringBuilder r19 = new SpannableStringBuilder(r18);
        r19.setSpan(new AnonymousClass1(r18, r9, r18), 0, r18.length(), 33);
        r9.b.setText(r19);
        r9.c.setText("");
        return;
    L38:
        r18 = r10.getName();
        goto L39
    L34:
        if (AttachmentModelList.AttachmentType.CELL_POSITION.getType().equals(r10.getType()) == true) goto L35;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new AttachmentViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(2131564523, r3, false));
    }
}
