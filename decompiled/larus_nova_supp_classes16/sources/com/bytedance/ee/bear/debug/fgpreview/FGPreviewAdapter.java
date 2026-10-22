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
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "model", "Lcom/bytedance/ee/bear/debug/fgpreview/FGConfigModel;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGConfigModel;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "getItemViewType", "BoolTitleViewHolder", "TextTitleViewHolder", "MultiTitleViewHolder", "BoolViewHolder", "TextViewHolder", "MultiViewHolder", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FGPreviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final ox4.a a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$BoolTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "item", "Landroid/widget/LinearLayout;", CustomHeaderConfig.TitleConfig.TitleIcon.EMPTY, "Landroid/widget/TextView;", "showEmpty", "", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BoolTitleViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final TextView b;

        public BoolTitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (LinearLayout) r2.findViewById(2131375825);
            this.b = (TextView) r2.findViewById(2131375757);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$BoolViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "rcIcon", "Landroid/widget/ImageView;", "gaIcon", "setInfo", "", "fgName", "", "rc", "", "ga", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BoolViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final ImageView c;

        public BoolViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131375748);
            this.b = (ImageView) r2.findViewById(2131375749);
            this.c = (ImageView) r2.findViewById(2131375747);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$MultiTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MultiTitleViewHolder extends RecyclerView.ViewHolder {
        public MultiTitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$MultiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "arrowIcon", "Landroid/widget/ImageView;", "content", "Landroidx/recyclerview/widget/RecyclerView;", "setInfo", "", "fgName", "", "rcJsonObj", "Lorg/json/JSONObject;", "gaJsonObj", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MultiViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final RecyclerView c;

        public MultiViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131375752);
            this.b = (ImageView) r2.findViewById(2131375750);
            this.c = r2.findViewById(2131375751);
            r2.setOnClickListener(new b(this));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$TextTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "item", "Landroid/widget/LinearLayout;", CustomHeaderConfig.TitleConfig.TitleIcon.EMPTY, "Landroid/widget/TextView;", "showEmpty", "", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TextTitleViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final TextView b;

        public TextTitleViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (LinearLayout) r2.findViewById(2131375756);
            this.b = (TextView) r2.findViewById(2131375758);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter$TextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewAdapter;Landroid/view/View;)V", "nameTv", "Landroid/widget/TextView;", "rcText", "gaText", "setInfo", "", "fgName", "", "rc", "ga", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TextViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final TextView c;

        public TextViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131375754);
            this.b = (TextView) r2.findViewById(2131375755);
            this.c = (TextView) r2.findViewById(2131375753);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.c.size() + 3;
    }

    public FGPreviewAdapter(ox4.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.a = r2;
    }

    public final int getItemViewType(int r5) {
        int r0 = this.a.e.size();
        int r1 = this.a.f.size();
        boolean r2 = false;
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (1 > r5) goto L9;
        if (r5 > r0) goto L9;
        r2 = true;
    L9:
        if (r2 == false) goto L11;
        return 1;
    L11:
        int r3 = r0 + 1;
        if (r5 != r3) goto L14;
        return 2;
    L14:
        if (r5 <= r3) goto L19;
        if (r5 >= ((r0 + r1) + 2)) goto L19;
        return 3;
    L19:
        if (r5 != ((r0 + r1) + 2)) goto L21;
        return 4;
    L21:
        return 5;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        int r0 = getItemViewType(r12);
        if (r0 == 0) goto L73;
        if (r0 != 1) goto L7;
        int r13 = r12 - 1;
        if (r13 >= 0) goto L57;
        return;
    L57:
        if ((r11 instanceof BoolViewHolder) == false) goto L82;
        Pair r1 = (Pair) ListProtector.get(this.a.e, r13);
        Pair r14 = (Pair) ListProtector.get(this.a.h, r13);
        if (TextUtils.equals((CharSequence) r1.getFirst(), (CharSequence) r14.getFirst()) == false) goto L70;
        BoolViewHolder r16 = (BoolViewHolder) r11;
        String r2 = (String) r1.getFirst();
        boolean r3 = ((Boolean) r1.getSecond()).booleanValue();
        boolean r17 = ((Boolean) r14.getSecond()).booleanValue();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "fgName");
        r16.a.setText(r2);
        ImageView r4 = r16.b;
        int r5 = 2131235911;
        if (r3 == false) goto L64;
        int r6 = 2131235911;
    L65:
        r4.setImageResource(r6);
        ImageView r18 = r16.c;
        if (r17 == true) goto L69;
        r5 = 2131235912;
    L69:
        r18.setImageResource(r5);
        return;
    L64:
        r6 = 2131235912;
        goto L65
    L70:
        tt5.a.d("FGPreviewAdapter", "pair were not equals: " + r1 + ',' + r14);
        r11.itemView.setVisibility(8);
        return;
    L82:
        return;
    L7:
        if (r0 == 2) goto L50;
        if (r0 != 3) goto L11;
        int r19 = (r12 - this.a.e.size()) - 2;
        if (r19 >= 0) goto L40;
        return;
    L40:
        if ((r11 instanceof TextViewHolder) == false) goto L81;
        Pair r7 = (Pair) ListProtector.get(this.a.f, r19);
        Pair r110 = (Pair) ListProtector.get(this.a.i, r19);
        if (TextUtils.isEmpty((CharSequence) r7.getFirst()) == false) goto L45;
    L47:
        tt5.a.d("FGPreviewAdapter", "pair were not equals: " + r7 + ',' + r110);
        r11.itemView.setVisibility(8);
        return;
    L45:
        if (TextUtils.equals((CharSequence) r7.getFirst(), (CharSequence) r110.getFirst()) == false) goto L47;
        TextViewHolder r111 = (TextViewHolder) r11;
        String r8 = (String) r7.getFirst();
        String r9 = (String) r7.getSecond();
        String r112 = (String) r110.getSecond();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r8, "fgName");
        Intrinsics.checkNotNullParameter(r9, "rc");
        Intrinsics.checkNotNullParameter(r112, "ga");
        r111.a.setText(r8);
        r111.b.setText(r9);
        r111.c.setText(r112);
        return;
    L81:
        return;
    L11:
        if (r0 == 4) goto L35;
        if (r0 != 5) goto L97;
        int r113 = ((r12 - this.a.e.size()) - this.a.f.size()) - 3;
        if (r113 >= 0) goto L18;
        return;
    L18:
        if ((r11 instanceof MultiViewHolder) == false) goto L80;
        Pair r10 = (Pair) ListProtector.get(this.a.g, r113);
        Pair r114 = (Pair) ListProtector.get(this.a.j, r113);
        if (TextUtils.isEmpty((CharSequence) r10.getFirst()) == false) goto L23;
    L32:
        tt5.a.d("FGPreviewAdapter", "pair were not equals: " + r10 + ',' + r114);
        r11.itemView.setVisibility(8);
        return;
    L23:
        if (TextUtils.equals((CharSequence) r10.getFirst(), (CharSequence) r114.getFirst()) == false) goto L32;
        MultiViewHolder r115 = (MultiViewHolder) r11;
        String r116 = (String) r10.getFirst();
        ox4.a r20 = this.a;
        JSONObject r21 = r20.a;
        JSONObject r22 = r20.b;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "fgName");
        r115.a.setText(r116);
        if (r21 == null) goto L83;
        if (r22 == null) goto L98;
        JSONObject r23 = r21.optJSONObject(r116);     // Catch: Exception -> L30
        JSONObject r117 = r22.optJSONObject(r116);     // Catch: Exception -> L30
        r115.c.setAdapter(new FGPreviewAdapter(new ox4.a(r23, r117, ox4.b.a(r23), ox4.b.a(r117))));     // Catch: Exception -> L30
        r115.c.setLayoutManager(new LinearLayoutManager(((RecyclerView.ViewHolder) r115).itemView.getContext()));     // Catch: Exception -> L30
        r115.c.addItemDecoration(new DividerItemDecoration(((RecyclerView.ViewHolder) r115).itemView.getContext(), 1));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        tt5.a.f("FGPreviewAdapter", e, false);
        r115.c.setVisibility(8);
        r115.b.animate().rotationBy(-180.0f).setDuration(200).withEndAction(new c(r115)).start();
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
        if (this.a.g.isEmpty() == false) goto L86;
        boolean r118 = r11 instanceof MultiViewHolder;
        return;
    L86:
        return;
    L50:
        if (this.a.f.isEmpty() == true) goto L52;
        return;
    L52:
        if ((r11 instanceof TextTitleViewHolder) == false) goto L91;
        TextTitleViewHolder r119 = (TextTitleViewHolder) r11;
        r119.a.setVisibility(8);
        r119.b.setVisibility(0);
        return;
    L91:
        return;
    L73:
        if (this.a.e.isEmpty() == true) goto L75;
        return;
    L75:
        if ((r11 instanceof BoolTitleViewHolder) == false) goto L96;
        BoolTitleViewHolder r120 = (BoolTitleViewHolder) r11;
        r120.a.setVisibility(8);
        r120.b.setVisibility(0);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 0) goto L5;
        View r6 = r0.inflate(2131561600, r4, false);
        Intrinsics.checkNotNull(r6);
        return new BoolTitleViewHolder(r6);
    L5:
        if (r5 != 1) goto L7;
        View r7 = r0.inflate(2131561598, r4, false);
        Intrinsics.checkNotNull(r7);
        return new BoolViewHolder(r7);
    L7:
        if (r5 != 2) goto L9;
        View r8 = r0.inflate(2131561602, r4, false);
        Intrinsics.checkNotNull(r8);
        return new TextTitleViewHolder(r8);
    L9:
        if (r5 != 3) goto L11;
        View r9 = r0.inflate(2131561599, r4, false);
        Intrinsics.checkNotNull(r9);
        return new TextViewHolder(r9);
    L11:
        if (r5 == 4) goto L13;
        View r10 = r0.inflate(2131561597, r4, false);
        Intrinsics.checkNotNull(r10);
        return new MultiViewHolder(r10);
    L13:
        View r11 = r0.inflate(2131561601, r4, false);
        Intrinsics.checkNotNull(r11);
        return new MultiTitleViewHolder(r11);
    }
}
