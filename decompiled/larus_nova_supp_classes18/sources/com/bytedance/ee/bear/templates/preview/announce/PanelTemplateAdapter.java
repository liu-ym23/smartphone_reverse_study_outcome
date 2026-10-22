package com.bytedance.ee.bear.templates.preview.announce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.thumbnail.LeftCropForView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003\u001f !B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0014\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter$CardViewHolder;", "Lcom/bytedance/ee/util/ui/RecyclerItemsDiff$ItemComparable;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "<init>", "()V", "hasReports", "", "", "templateList", "", "templateClickListener", "Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter$TemplateClickListener;", "setOnItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "updateTemplate", "templates", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "Companion", "CardViewHolder", "TemplateClickListener", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelTemplateAdapter extends RecyclerView.Adapter<CardViewHolder> implements RecyclerItemsDiff.b<AnnounceTemplate> {
    public static final int d = 0;
    public static final int e = 0;
    public final Set<Integer> a;
    public List<AnnounceTemplate> b;
    public b c;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "thumbnailImg", "Landroid/widget/ImageView;", "getThumbnailImg", "()Landroid/widget/ImageView;", "templateName", "Landroid/widget/TextView;", "getTemplateName", "()Landroid/widget/TextView;", "displayThumbnail", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "loadThumbnail", "objToken", "", ResourceData.KEY_TYPE, "", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CardViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;

        public CardViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131388626);
            this.b = (TextView) r2.findViewById(2131388333);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(int r1, AnnounceTemplate r2);
    }

    static {
        d = cu5.c.b(128);
        e = cu5.c.b(76);
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public PanelTemplateAdapter() {
        this.a = new LinkedHashSet();
        this.b = new ArrayList();
    }

    public final boolean areContentsTheSame(Object r1, Object r2) {
        return Objects.equals((AnnounceTemplate) r1, (AnnounceTemplate) r2);
    }

    public final boolean areItemsTheSame(Object r1, Object r2) {
        return Objects.equals((AnnounceTemplate) r1, (AnnounceTemplate) r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        CardViewHolder r2 = (CardViewHolder) r17;
        Intrinsics.checkNotNullParameter(r2, "holder");
        r2.b.setText(((AnnounceTemplate) ListProtector.get(this.b, r18)).getName());
        AnnounceTemplate r3 = (AnnounceTemplate) ListProtector.get(this.b, r18);
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        r3.getObjToken();
        int r8 = r3.getObjType();
        ThumbnailExtra r4 = r3.getThumbnailExtra();
        ThumbGlideUrl r15 = new ThumbGlideUrl("", r4.getThumbnail(), r8, r4.getType(), r4.getDecrypt_key(), "", ThumbGlideUrl.SOURCE_TEMPLATE, true, "v4.1", r2.a);
        r2.a.setTag(2131388628, r3.getObjToken());
        Glide.with(r2.a.getContext()).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCropForView(e, d)).error(2131248373).load(r15).into(r2.a);
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new e(this, r18));
        if (this.a.contains(Integer.valueOf(r18)) == true) goto L6;
        Lazy r0 = AnnounceTemplateAnalytic.a;
        String r1 = ((AnnounceTemplate) ListProtector.get(this.b, r18)).getName();
        String r5 = ((AnnounceTemplate) ListProtector.get(this.b, r18)).getObjToken();
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        JSONObject r6 = AnnounceTemplateAnalytic.b;
        r6.put("token_new", r5);
        r6.put("template_name", r1);
        r6.put("template_type", "set");
        r6.put("exposure_type", "from_im_chat_announcement");
        ((com.bytedance.ee.bear.contract.d) AnnounceTemplateAnalytic.a.getValue()).n("docs_singletemplate_exposure", r6);
        this.a.add(Integer.valueOf(r18));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131558571, r3, false);
        Intrinsics.checkNotNull(r5);
        return new CardViewHolder(r5);
    }
}
