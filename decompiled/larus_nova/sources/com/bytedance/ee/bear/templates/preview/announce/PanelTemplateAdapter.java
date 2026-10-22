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
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003\u001f !B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0014\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter$CardViewHolder;", "Lcom/bytedance/ee/util/ui/RecyclerItemsDiff$ItemComparable;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "<init>", "()V", "hasReports", "", "", "templateList", "", "templateClickListener", "Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter$TemplateClickListener;", "setOnItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "updateTemplate", "templates", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "Companion", "CardViewHolder", "TemplateClickListener", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelTemplateAdapter extends RecyclerView.Adapter<CardViewHolder> implements RecyclerItemsDiff.b<AnnounceTemplate> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f239152d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f239153e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Integer> f239154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<AnnounceTemplate> f239155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f239156c;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/PanelTemplateAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "thumbnailImg", "Landroid/widget/ImageView;", "getThumbnailImg", "()Landroid/widget/ImageView;", "templateName", "Landroid/widget/TextView;", "getTemplateName", "()Landroid/widget/TextView;", "displayThumbnail", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "loadThumbnail", "objToken", "", "type", "", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/preview/announce/ThumbnailExtra;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CardViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f239157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f239158b;

        public CardViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f239157a = (ImageView) r100.findViewById(R.id.thumbnail_img);
            this.f239158b = (TextView) r100.findViewById(R.id.template_name);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(int r100, AnnounceTemplate r101);
    }

    static {
        f239152d = cu5.c.b(128);
        f239153e = cu5.c.b(76);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f239155b.size();
    }

    public PanelTemplateAdapter() {
        this.f239154a = new LinkedHashSet();
        this.f239155b = new ArrayList();
    }

    @Override // com.bytedance.ee.util.ui.RecyclerItemsDiff.b
    public final boolean areContentsTheSame(AnnounceTemplate r100, AnnounceTemplate r101) {
        return Objects.equals(r100, r101);
    }

    @Override // com.bytedance.ee.util.ui.RecyclerItemsDiff.b
    public final boolean areItemsTheSame(AnnounceTemplate r100, AnnounceTemplate r101) {
        return Objects.equals(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        CardViewHolder r100 = (CardViewHolder) r110;
        Intrinsics.checkNotNullParameter(r100, "holder");
        r100.f239158b.setText(((AnnounceTemplate) ListProtector.get(this.f239155b, r111)).getName());
        AnnounceTemplate r101 = (AnnounceTemplate) ListProtector.get(this.f239155b, r111);
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        r101.getObjToken();
        int r102 = r101.getObjType();
        ThumbnailExtra r103 = r101.getThumbnailExtra();
        ThumbGlideUrl r112 = new ThumbGlideUrl("", r103.getThumbnail(), r102, r103.getType(), r103.getDecrypt_key(), "", ThumbGlideUrl.SOURCE_TEMPLATE, true, "v4.1", r100.f239157a);
        r100.f239157a.setTag(R.id.thumbnail_tag, r101.getObjToken());
        Glide.with(r100.f239157a.getContext()).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCropForView(f239153e, f239152d)).error(R.drawable.template_load_fail).load(r112).into(r100.f239157a);
        r100.itemView.setOnClickListener(new e(this, r111));
        if (this.f239154a.contains(Integer.valueOf(r111)) == true) goto L6;
        Lazy r104 = AnnounceTemplateAnalytic.f239132a;
        String r105 = ((AnnounceTemplate) ListProtector.get(this.f239155b, r111)).getName();
        String r106 = ((AnnounceTemplate) ListProtector.get(this.f239155b, r111)).getObjToken();
        Intrinsics.checkNotNullParameter(r106, "token");
        JSONObject r107 = AnnounceTemplateAnalytic.f239133b;
        r107.put("token_new", r106);
        r107.put("template_name", r105);
        r107.put("template_type", "set");
        r107.put("exposure_type", "from_im_chat_announcement");
        ((com.bytedance.ee.bear.contract.d) AnnounceTemplateAnalytic.f239132a.getValue()).n("docs_singletemplate_exposure", r107);
        this.f239154a.add(Integer.valueOf(r111));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.announce_template_card_item_new, r100, false);
        Intrinsics.checkNotNull(r102);
        return new CardViewHolder(r102);
    }
}
