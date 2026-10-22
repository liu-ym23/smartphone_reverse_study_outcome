package com.bytedance.ee.bear.templates.horizontal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.templates.ITemplateViewHolder;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateShowCardType;
import com.bytedance.ee.bear.templates.TemplateViewHolder2;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateAdapter;", "Lcom/bytedance/ee/bear/templates/TemplateAdapter;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", DocumentType.BITABLE_FORM_NAME, "", ResourceData.KEY_TYPE, "", "categoryName", "uniqueID", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/bytedance/ee/bear/templates/LayoutType;Ljava/lang/String;ILjava/lang/String;J)V", "moreClickListener", "Lcom/bytedance/ee/bear/templates/horizontal/MoreTemplateClickListener;", "onCreateViewHolder", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "setMoreClickListener", "templateClickListener", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalTemplateAdapter extends TemplateAdapter {
    public final LifecycleOwner i;
    public final LayoutType j;
    public j k;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HorizontalTemplateAdapter a;

        public a(HorizontalTemplateAdapter r1, int r2) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            j r2 = this.a.k;
            if (r2 == null) goto L6;
            r2.o();
            return;
        }
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        ITemplateViewHolder r3 = (ITemplateViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(null);
    }

    public HorizontalTemplateAdapter(LifecycleOwner r9, LayoutType r10) {
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "layoutType");
        super(r9, r10, null, 0, null, 0);
        this.i = r9;
        this.j = r10;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((ITemplateViewHolder) r1, r2);
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter
    public final void y2(ITemplateViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.y2(r3, r4);
        if (getItemViewType(r4) != TemplateShowCardType.SHOW_CARD_TYPE_MORE_TEMPLATE.ordinal()) goto L6;
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new a(this, r4));
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter
    public final ITemplateViewHolder z2(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != TemplateShowCardType.SHOW_CARD_TYPE_MORE_TEMPLATE.ordinal()) goto L6;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561520, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ITemplateViewHolder(r5);
    L6:
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131561521, r3, false);
        Intrinsics.checkNotNull(r6);
        return new TemplateViewHolder2(r6, this.j);
    }
}
