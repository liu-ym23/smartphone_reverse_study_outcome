package com.bytedance.ee.bear.debug.fgpreview;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/bear/debug/fgpreview/FGConfigModel;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGConfigModel;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "getItemViewType", "BoolTitleViewHolder", "TextTitleViewHolder", "MultiTitleViewHolder", "BoolViewHolder", "TextViewHolder", "MultiViewHolder", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FGPreviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ox4.a f217382a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$BoolTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", MapController.ITEM_LAYER_TAG, "Landroid/widget/LinearLayout;", "empty", "Landroid/widget/TextView;", "showEmpty", "", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BoolTitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f217383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f217384b;

        public BoolTitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217383a = (LinearLayout) r100.findViewById(R.id.item_preview_title_bool_root);
            this.f217384b = (TextView) r100.findViewById(R.id.item_fg_title_bool_empty);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$BoolViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "rcIcon", "Landroid/widget/ImageView;", "gaIcon", "setInfo", "", "fgName", "", "rc", "", "ga", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BoolViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f217385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f217386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f217387c;

        public BoolViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217385a = (TextView) r100.findViewById(R.id.item_fg_bool_name);
            this.f217386b = (ImageView) r100.findViewById(R.id.item_fg_bool_rc);
            this.f217387c = (ImageView) r100.findViewById(R.id.item_fg_bool_ga);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$MultiTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MultiTitleViewHolder extends RecyclerView.ViewHolder {
        public MultiTitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$MultiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "arrowIcon", "Landroid/widget/ImageView;", "content", "Landroidx/recyclerview/widget/RecyclerView;", "setInfo", "", "fgName", "", "rcJsonObj", "Lorg/json/JSONObject;", "gaJsonObj", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MultiViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f217388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f217389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RecyclerView f217390c;

        public MultiViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217388a = (TextView) r100.findViewById(R.id.item_fg_multi_name);
            this.f217389b = (ImageView) r100.findViewById(R.id.item_fg_multi_arrow);
            this.f217390c = (RecyclerView) r100.findViewById(R.id.item_fg_multi_content);
            r100.setOnClickListener(new b(this));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$TextTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", MapController.ITEM_LAYER_TAG, "Landroid/widget/LinearLayout;", "empty", "Landroid/widget/TextView;", "showEmpty", "", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TextTitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f217391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f217392b;

        public TextTitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217391a = (LinearLayout) r100.findViewById(R.id.item_fg_text_root);
            this.f217392b = (TextView) r100.findViewById(R.id.item_fg_title_text_empty);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$TextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "rcText", "gaText", "setInfo", "", "fgName", "", "rc", "ga", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TextViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f217393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f217394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f217395c;

        public TextViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f217393a = (TextView) r100.findViewById(R.id.item_fg_text_name);
            this.f217394b = (TextView) r100.findViewById(R.id.item_fg_text_rc);
            this.f217395c = (TextView) r100.findViewById(R.id.item_fg_text_ga);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f217382a.f527082c.size() + 3;
    }

    public FGPreviewAdapter(ox4.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f217382a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = this.f217382a.f527084e.size();
        int r102 = this.f217382a.f527085f.size();
        boolean r103 = false;
        if (r100 != 0) goto L6;
        return 0;
    L6:
        if (1 > r100) goto L9;
        if (r100 > r101) goto L9;
        r103 = true;
    L9:
        if (r103 == false) goto L11;
        return 1;
    L11:
        int r104 = r101 + 1;
        if (r100 != r104) goto L14;
        return 2;
    L14:
        if (r100 <= r104) goto L19;
        if (r100 >= ((r101 + r102) + 2)) goto L19;
        return 3;
    L19:
        if (r100 != ((r101 + r102) + 2)) goto L21;
        return 4;
    L21:
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        int r100 = getItemViewType(r111);
        if (r100 == 0) goto L73;
        if (r100 != 1) goto L7;
        int r112 = r111 - 1;
        if (r112 >= 0) goto L57;
        return;
    L57:
        if ((r110 instanceof BoolViewHolder) == false) goto L82;
        Pair r101 = (Pair) ListProtector.get(this.f217382a.f527084e, r112);
        Pair r113 = (Pair) ListProtector.get(this.f217382a.f527087h, r112);
        if (TextUtils.equals((CharSequence) r101.getFirst(), (CharSequence) r113.getFirst()) == false) goto L70;
        BoolViewHolder r114 = (BoolViewHolder) r110;
        String r102 = (String) r101.getFirst();
        boolean r103 = ((Boolean) r101.getSecond()).booleanValue();
        boolean r115 = ((Boolean) r113.getSecond()).booleanValue();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r102, "fgName");
        r114.f217385a.setText(r102);
        ImageView r104 = r114.f217386b;
        int r105 = R.drawable.ic_fg_preview_check;
        if (r103 == false) goto L64;
        int r106 = R.drawable.ic_fg_preview_check;
    L65:
        r104.setImageResource(r106);
        ImageView r116 = r114.f217387c;
        if (r115 == true) goto L69;
        r105 = R.drawable.ic_fg_preview_uncheck;
    L69:
        r116.setImageResource(r105);
        return;
    L64:
        r106 = R.drawable.ic_fg_preview_uncheck;
        goto L65
    L70:
        tt5.a.d("FGPreviewAdapter", "pair were not equals: " + r101 + ',' + r113);
        r110.itemView.setVisibility(8);
        return;
    L82:
        return;
    L7:
        if (r100 == 2) goto L50;
        if (r100 != 3) goto L11;
        int r117 = (r111 - this.f217382a.f527084e.size()) - 2;
        if (r117 >= 0) goto L40;
        return;
    L40:
        if ((r110 instanceof TextViewHolder) == false) goto L81;
        Pair r107 = (Pair) ListProtector.get(this.f217382a.f527085f, r117);
        Pair r118 = (Pair) ListProtector.get(this.f217382a.f527088i, r117);
        if (TextUtils.isEmpty((CharSequence) r107.getFirst()) == false) goto L45;
    L47:
        tt5.a.d("FGPreviewAdapter", "pair were not equals: " + r107 + ',' + r118);
        r110.itemView.setVisibility(8);
        return;
    L45:
        if (TextUtils.equals((CharSequence) r107.getFirst(), (CharSequence) r118.getFirst()) == false) goto L47;
        TextViewHolder r119 = (TextViewHolder) r110;
        String r108 = (String) r107.getFirst();
        String r109 = (String) r107.getSecond();
        String r120 = (String) r118.getSecond();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r108, "fgName");
        Intrinsics.checkNotNullParameter(r109, "rc");
        Intrinsics.checkNotNullParameter(r120, "ga");
        r119.f217393a.setText(r108);
        r119.f217394b.setText(r109);
        r119.f217395c.setText(r120);
        return;
    L81:
        return;
    L11:
        if (r100 == 4) goto L35;
        if (r100 != 5) goto L97;
        int r121 = ((r111 - this.f217382a.f527084e.size()) - this.f217382a.f527085f.size()) - 3;
        if (r121 >= 0) goto L18;
        return;
    L18:
        if ((r110 instanceof MultiViewHolder) == false) goto L80;
        Pair r122 = (Pair) ListProtector.get(this.f217382a.f527086g, r121);
        Pair r123 = (Pair) ListProtector.get(this.f217382a.f527089j, r121);
        if (TextUtils.isEmpty((CharSequence) r122.getFirst()) == false) goto L23;
    L32:
        tt5.a.d("FGPreviewAdapter", "pair were not equals: " + r122 + ',' + r123);
        r110.itemView.setVisibility(8);
        return;
    L23:
        if (TextUtils.equals((CharSequence) r122.getFirst(), (CharSequence) r123.getFirst()) == false) goto L32;
        MultiViewHolder r124 = (MultiViewHolder) r110;
        String r125 = (String) r122.getFirst();
        ox4.a r126 = this.f217382a;
        JSONObject r127 = r126.f527080a;
        JSONObject r128 = r126.f527081b;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "fgName");
        r124.f217388a.setText(r125);
        if (r127 == null) goto L83;
        if (r128 == null) goto L98;
        JSONObject r129 = r127.optJSONObject(r125);     // Catch: Exception -> L30
        JSONObject r130 = r128.optJSONObject(r125);     // Catch: Exception -> L30
        r124.f217390c.setAdapter(new FGPreviewAdapter(new ox4.a(r129, r130, ox4.b.a(r129), ox4.b.a(r130))));     // Catch: Exception -> L30
        r124.f217390c.setLayoutManager(new LinearLayoutManager(r124.itemView.getContext()));     // Catch: Exception -> L30
        r124.f217390c.addItemDecoration(new DividerItemDecoration(r124.itemView.getContext(), 1));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        tt5.a.f("FGPreviewAdapter", e, false);
        r124.f217390c.setVisibility(8);
        r124.f217389b.animate().rotationBy(-180.0f).setDuration(200).withEndAction(new c(r124)).start();
        return;
    L98:
        return;
    L83:
        return;
    L80:
        return;
    L97:
        return;
    L35:
        if (this.f217382a.f527086g.isEmpty() == false) goto L86;
        boolean r131 = r110 instanceof MultiViewHolder;
        return;
    L86:
        return;
    L50:
        if (this.f217382a.f527085f.isEmpty() == true) goto L52;
        return;
    L52:
        if ((r110 instanceof TextTitleViewHolder) == false) goto L91;
        TextTitleViewHolder r132 = (TextTitleViewHolder) r110;
        r132.f217391a.setVisibility(8);
        r132.f217392b.setVisibility(0);
        return;
    L91:
        return;
    L73:
        if (this.f217382a.f527084e.isEmpty() == true) goto L75;
        return;
    L75:
        if ((r110 instanceof BoolTitleViewHolder) == false) goto L96;
        BoolTitleViewHolder r133 = (BoolTitleViewHolder) r110;
        r133.f217383a.setVisibility(8);
        r133.f217384b.setVisibility(0);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 0) goto L5;
        View r103 = r102.inflate(R.layout.item_fg_preview_title_bool, r100, false);
        Intrinsics.checkNotNull(r103);
        return new BoolTitleViewHolder(r103);
    L5:
        if (r101 != 1) goto L7;
        View r104 = r102.inflate(R.layout.item_fg_preview_simple_boolean, r100, false);
        Intrinsics.checkNotNull(r104);
        return new BoolViewHolder(r104);
    L7:
        if (r101 != 2) goto L9;
        View r105 = r102.inflate(R.layout.item_fg_preview_title_text, r100, false);
        Intrinsics.checkNotNull(r105);
        return new TextTitleViewHolder(r105);
    L9:
        if (r101 != 3) goto L11;
        View r106 = r102.inflate(R.layout.item_fg_preview_simple_text, r100, false);
        Intrinsics.checkNotNull(r106);
        return new TextViewHolder(r106);
    L11:
        if (r101 == 4) goto L13;
        View r107 = r102.inflate(R.layout.item_fg_preview_multi, r100, false);
        Intrinsics.checkNotNull(r107);
        return new MultiViewHolder(r107);
    L13:
        View r108 = r102.inflate(R.layout.item_fg_preview_title_multi, r100, false);
        Intrinsics.checkNotNull(r108);
        return new MultiTitleViewHolder(r108);
    }
}
