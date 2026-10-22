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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class AttachmentListAdapter extends RecyclerView.Adapter<AttachmentViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AttachmentModelList.AttachmentModel> f237313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f237314b;

    public class AttachmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f237317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f237318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f237319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AttachmentListAdapter f237320d;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AttachmentListAdapter r101 = this.f237320d;
            a r102 = r101.f237314b;
            if (r102 == null) goto L6;
            r102.a((AttachmentModelList.AttachmentModel) ListProtector.get(r101.f237313a, getLayoutPosition()));
            return;
        }

        public AttachmentViewHolder(AttachmentListAdapter r100, View r101) {
            this.f237320d = r100;
            super(r101);
            this.f237317a = (ImageView) r101.findViewById(R.id.attachment_item_icon);
            this.f237318b = (TextView) r101.findViewById(R.id.attachment_item_name);
            this.f237319c = (TextView) r101.findViewById(R.id.attachment_item_size);
            r101.setOnClickListener(this);
        }
    }

    public interface a {
        void a(AttachmentModelList.AttachmentModel r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f237313a.size();
    }

    public AttachmentListAdapter() {
        this.f237313a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final AttachmentViewHolder r102 = (AttachmentViewHolder) r100;
        AttachmentModelList.AttachmentModel r103 = (AttachmentModelList.AttachmentModel) ListProtector.get(this.f237313a, r101);
        int r104 = 0;
        r102.f237318b.setSingleLine(false);
        r102.f237318b.setMaxLines(1);
        if (AttachmentModelList.AttachmentType.ATTACHMENT.getType().equals(r103.getType()) == false) goto L18;
        String r105 = r103.getName();
        int r106 = r105.lastIndexOf(".");
        if (r106 <= 0) goto L9;
        int r107 = r106 + 1;
        if (r107 >= r105.length()) goto L9;
        String r108 = r105.substring(r107);
    L10:
        r102.f237317a.setImageResource(ua5.a.h(r108));
        r102.f237318b.setText(r103.getName());
        String[] r109 = {"B", "KB", "MB", "GB"};
        long r110 = r103.getSize();
    L12:
        if (r110 <= 1024) goto L16;
        if (r104 >= 3) goto L16;
        r110 = r110 / 1024;
        r104 = r104 + 1;
    L16:
        r102.f237319c.setText(r110 + r109[r104]);
        return;
    L9:
        r108 = (String) ((HashMap) FileUtils.f243140b).get(r103.getMimeType());
        goto L10
    L18:
        if (AttachmentModelList.AttachmentType.MENTION.getType().equals(r103.getType()) == false) goto L32;
        int r111 = 12;
        if (r103.getMentionType() == 16) goto L26;
        if (r103.getMentionType() == 12) goto L26;
        ImageView r112 = r102.f237317a;
        int r113 = r103.getMentionType();
        IconSize r114 = IconSize.SIZE_24;
        r112.setImageResource(ua5.a.i(r113));
    L30:
        r102.f237318b.setText(r103.getName());
        r102.f237319c.setText("");
        return;
    L26:
        if (r103.getMentionType() == 12) goto L29;
        r111 = 2;
    L29:
        ImageView r115 = r102.f237317a;
        String r116 = r103.getName();
        IconSize r117 = IconSize.SIZE_24;
        r115.setImageResource(ua5.a.k(r111, r116));
        goto L30
    L32:
        if (AttachmentModelList.AttachmentType.URL.getType().equals(r103.getType()) == false) goto L34;
    L35:
        r102.f237317a.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_link_colorful));
        if (TextUtils.isEmpty(r103.getName()) == false) goto L38;
        final String r118 = r103.getLink();
    L39:
        SpannableStringBuilder r119 = new SpannableStringBuilder(r118);
        r119.setSpan(new AnonymousClass1(r118, r102, r118), 0, r118.length(), 33);
        r102.f237318b.setText(r119);
        r102.f237319c.setText("");
        return;
    L38:
        r118 = r103.getName();
        goto L39
    L34:
        if (AttachmentModelList.AttachmentType.CELL_POSITION.getType().equals(r103.getType()) == true) goto L35;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new AttachmentViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_attachment_item, r100, false));
    }
}
