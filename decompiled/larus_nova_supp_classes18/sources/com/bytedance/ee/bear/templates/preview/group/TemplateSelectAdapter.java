package com.bytedance.ee.bear.templates.preview.group;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import co5.b;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.templates.f;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/group/TemplateSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/preview/group/TemplateSelectViewHolder;", "datas", "", "Lcom/bytedance/ee/bear/templates/bean/SceneTemplateData$Scene;", "collectionId", "", "templateCenterSource", "templateType", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "selectIndex", "", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "hasReports", "", "getHasReports", "()Ljava/util/Set;", "setHasReports", "(Ljava/util/Set;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateSelectAdapter extends RecyclerView.Adapter<TemplateSelectViewHolder> {
    public final List<SceneTemplateData.Scene> a;
    public final String b;
    public final String c;
    public final String d;
    public int e;
    public final Set<Integer> f;

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19) {
        TemplateSelectViewHolder r2 = (TemplateSelectViewHolder) r18;
        Intrinsics.checkNotNullParameter(r2, "holder");
        SceneTemplateData.Scene r3 = (SceneTemplateData.Scene) ListProtector.get(this.a, r19);
        r2.c.setText(r3.name);
        View r4 = r2.a;
        Resources r5 = r4.getContext().getResources();
        int r6 = r3.obj_type;
        if (r6 != e.g.b) goto L6;
    L14:
        int r7 = 2131105550;
    L15:
        r4.setBackgroundColor(r5.getColor(r7));
        if (r3.display_type != 2) goto L18;
        String r8 = r3.cover_download_url;
        SceneTemplateData.Extra r9 = r3.thumbnail_extra;
        ThumbGlideUrl r10 = new ThumbGlideUrl(r8, r9.thumbnail, r3.obj_type, r9.type, r9.decrypt_key, "", ThumbGlideUrl.SOURCE_TEMPLATE, false, "v4.1", r2.b);
        Intrinsics.checkNotNull(Glide.with(r2.b.getContext()).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).error(2131248373).load(r10).into(r2.b));
    L19:
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new b(this, r19, r3));
        if (r19 != this.e) goto L22;
        View r11 = ((RecyclerView.ViewHolder) r2).itemView;
        r11.setBackgroundColor(r11.getResources().getColor(2131105548));
    L24:
        if (this.f.contains(Integer.valueOf(r19)) == true) goto L27;
        f r12 = new f(r3.obj_token, r3.name, 12);
        TemplateReportV2.l(TemplateReportV2.a, "ccm_set_template_preview_view", null, this.c, r12, 2);
        this.f.add(Integer.valueOf(r19));
        return;
    L27:
        return;
    L22:
        View r13 = ((RecyclerView.ViewHolder) r2).itemView;
        r13.setBackgroundColor(r13.getResources().getColor(2131101106));
        goto L24
    L18:
        Intrinsics.checkNotNull(Glide.with(((RecyclerView.ViewHolder) r2).itemView).load(new BearGlideUrl(r3.cover_download_url)).into(r2.b));
        goto L19
    L6:
        if (r6 != e.h.b) goto L9;
        r7 = 2131102159;
        goto L15
    L9:
        if (r6 != e.k.b) goto L12;
        r7 = 2131108845;
        goto L15
    L12:
        if (r6 != 8) goto L14;
        r7 = 2131108807;
        goto L15
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131564969, r3, false);
        Intrinsics.checkNotNull(r5);
        return new TemplateSelectViewHolder(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateSelectAdapter(List<? extends SceneTemplateData.Scene> r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "datas");
        Intrinsics.checkNotNullParameter(r3, "collectionId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = new LinkedHashSet();
    }
}
