package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.text.TextUtils;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class AttachmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AttachmentEntity> f207381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f207382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AttachmentMenuEnum[] f207383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f207384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f207385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActionMode f207386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f207387g;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f207388e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f207389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AttachmentCoverView f207390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f207391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AttachmentAdapter f207392d;

        public ViewHolder(AttachmentAdapter r100, View r101) {
            this.f207392d = r100;
            super(r101);
            this.f207389a = r101;
            this.f207391c = r101.findViewById(R.id.highlight_border);
            AttachmentCoverView r102 = (AttachmentCoverView) r101.findViewById(R.id.attachment_cover_view);
            this.f207390b = r102;
            r102.setAttachmentViewDelegate(r100.f207382b);
            r102.setSrcObjToken(r100.f207384d);
        }
    }

    public interface a {
        void a(AttachmentMenuEnum r100, AttachmentEntity r101);

        void b(UploadAttachmentEntity r100);
    }

    public int getLayoutId() {
        return R.layout.bitable_card_attachment_rv_item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ((ArrayList) this.f207381a).size();
    }

    public AttachmentAdapter() {
        this.f207381a = new ArrayList();
        int r100 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("bitable.performance.item_view.complex_cell.enable", "key");
        this.f207387g = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.performance.item_view.complex_cell.enable");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        if (r100 < 0) goto L16;
        if (r100 >= getItemCount()) goto L16;
        AttachmentEntity r101 = (AttachmentEntity) ListProtector.get(this.f207381a, r100);
        if ((r101 instanceof UploadAttachmentEntity) == false) goto L12;
        String r102 = ((UploadAttachmentEntity) r101).getUploadTaskKey();
        if (TextUtils.isEmpty(r102) == true) goto L16;
        int r103 = r102.hashCode();
    L11:
        return r103;
    L12:
        String r104 = ((AttachmentEntity) ListProtector.get(this.f207381a, r100)).getId();
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r103 = r104.hashCode();
    L16:
        return r100;
    }

    public final void y2(List<AttachmentEntity> r100) {
        if (this.f207387g == false) goto L7;
        ((ArrayList) this.f207381a).clear();
        if (hu5.a.f(r100) == false) goto L11;
        ((ArrayList) this.f207381a).addAll(r100);
        return;
    L11:
        return;
    L7:
        ((ArrayList) this.f207381a).clear();
        if (hu5.a.f(r100) == false) goto L13;
        ((ArrayList) this.f207381a).addAll(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        if ((r100 instanceof ViewHolder) == false) goto L6;
        final ViewHolder r102 = (ViewHolder) r100;
        final AttachmentEntity r103 = (AttachmentEntity) ListProtector.get(this.f207381a, r101);
        r102.f207390b.b(r103, r102.f207392d.getItemCount() - ((ArrayList) r102.f207392d.f207381a).indexOf(r103));
        r102.f207389a.setOnClickListener(new b(r102, r103, r101));
        r102.f207389a.setOnLongClickListener(new c(r102, r103));
        r102.f207389a.findViewById(R.id.cancel_upload).setVisibility(0);
        r102.f207389a.findViewById(R.id.cancel_upload).setOnClickListener(new d(r102, r103));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new ViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(getLayoutId(), r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        super.onBindViewHolder(r100, r101, r102);
        if ((r100 instanceof ViewHolder) == false) goto L8;
        AttachmentEntity r103 = (AttachmentEntity) ListProtector.get(this.f207381a, r101);
        if ((r103 instanceof UploadAttachmentEntity) == false) goto L9;
        ((ViewHolder) r100).f207390b.a(((UploadAttachmentEntity) r103).getUploadProgress());
        return;
    L9:
        return;
    }
}
