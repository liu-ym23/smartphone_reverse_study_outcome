package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.list.homepage.banner.BannerMoreView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceCover;
import com.bytedance.ee.bear.wikiv2.home.banner.WikiHomePageSpaceSnapHelper;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0003-./B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020#2\u0006\u0010 \u001a\u00020!J\u001a\u0010(\u001a\u00020#2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dJ\b\u0010)\u001a\u00020#H\u0007J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listBannerTvTitleFromXml", "Landroid/widget/TextView;", "getListBannerTvTitleFromXml", "()Landroid/widget/TextView;", "setListBannerTvTitleFromXml", "(Landroid/widget/TextView;)V", "listBannerMoreFromXml", "Lcom/bytedance/ee/bear/list/homepage/banner/BannerMoreView;", "getListBannerMoreFromXml", "()Lcom/bytedance/ee/bear/list/homepage/banner/BannerMoreView;", "setListBannerMoreFromXml", "(Lcom/bytedance/ee/bear/list/homepage/banner/BannerMoreView;)V", "listBannerRvListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getListBannerRvListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setListBannerRvListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "wikiTopSpaceAdapter", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView$WikiTopSpaceAdapter;", "enableChecker", "Lio/reactivex/functions/Function;", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "", "delegate", "Lcom/bytedance/ee/bear/wikiv2/home2/WikiHomeTopSpaceView$ViewDelegate;", "initView", "", "setData", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceUIList;", "setDelegate", "setItemEnableChecker", "notifyDataSetChanged", "smoothScrollToPosition", "pos", "", "WikiTopSpaceAdapter", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiHomeTopSpaceView extends FrameLayout {
    public TextView a;
    public BannerMoreView b;
    public RecyclerView c;
    public final c d;
    public Function<SpaceBean, Boolean> e;
    public b f;

    public static final class a {
    }

    public interface b {
        void a(String r1);
    }

    public final class c extends BaseQuickAdapter<SpaceBean, BaseViewHolder> {
        public final /* synthetic */ WikiHomeTopSpaceView a;

        public final int y2() {
            List r0 = ((BaseQuickAdapter) this).mData;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public c(WikiHomeTopSpaceView r1) {
            this.a = r1;
            super(2131568240);
        }

        public final void convert(BaseViewHolder r12, Object r13) {
            SpaceBean r14 = (SpaceBean) r13;
            Intrinsics.checkNotNullParameter(r12, "viewHolder");
            Intrinsics.checkNotNullParameter(r14, "item");
            RecyclerView.LayoutParams r0 = ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131393222).getLayoutParams();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams r1 = r0;
            int r3 = 0;
            boolean r4 = true;
            if (r12.getAdapterPosition() != 0) goto L5;
            int[] r2 = {com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(16)};
        L6:
            r1.setMargins(r2[0], r2[1], r2[2], r2[3]);
            ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131393222).setCardElevation(com.bytedance.ee.util.ui.n.d(10));
            ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131390214)).setText(r14.space_name);
            ((ImageView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131376043)).setVisibility(8);
            SpaceCover r5 = r14.space_cover;
            TextView r6 = (TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131390214);
            if (r5 == null) goto L13;
            Resources r7 = ((RecyclerView.ViewHolder) r12).itemView.getResources();
            if (r5.is_graph_dark == false) goto L11;
            int r8 = r7.getColor(2131106521);
        L12:
            r6.setTextColor(r8);
            goto L13
        L11:
            r8 = r7.getColor(2131106500);
        L13:
            SpaceCover r9 = r14.space_cover;
            ImageView r10 = (ImageView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131393221);
            String r11 = null;
            if (r9 == null) goto L41;
            boolean r15 = r9.is_graph_dark;
            String r16 = r9.color_value;
            if (r15 == false) goto L18;
            int r17 = ((RecyclerView.ViewHolder) r12).itemView.getResources().getColor(2131103467);
        L20:
            if (TextUtils.isEmpty(r16) == true) goto L37;
            if (r16 != null) goto L89;
        L29:
            boolean r18 = true;
        L30:
            if (r18 == false) goto L32;
        L34:
            r17 = Color.parseColor(r16);     // Catch: Exception -> L27
        L27:
            e = move-exception;
            tt5.a.e("WikiHomeTopSpaceView", "parseColor err", e, false);
            goto L37
        L32:
            if (StringsKt.startsWith$default(r16, "#", false, 2, null) == true) goto L34;
            r16 = "#" + r16;     // Catch: Exception -> L27
            goto L34
        L89:
            if (r16.length() == 0) goto L29;
            r18 = false;
        L37:
            GradientDrawable r19 = new GradientDrawable();
            r19.setColor(r17);
            if (TextUtils.isEmpty(r9.origin) == false) goto L40;
            tt5.a.h("WikiHomeTopSpaceView", "bindImage spaceCover.thumbnail is empty");
            r10.setImageDrawable(r19);
            goto L41
        L40:
            Intrinsics.checkNotNull(Glide.with(((RecyclerView.ViewHolder) r12).itemView.getContext()).load(new BearGlideUrl(r9.origin)).placeholder(r19).error(r19).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new v()).into(r10));
            goto L41
        L18:
            r17 = ((RecyclerView.ViewHolder) r12).itemView.getResources().getColor(2131106521);
        L41:
            Function<SpaceBean, Boolean> r20 = this.a.e;
            if (r20 == null) goto L46;
            Boolean r21 = (Boolean) r20.apply(r14);
            if (r21 == null) goto L46;
            boolean r22 = r21.booleanValue();
        L47:
            ((RecyclerView.ViewHolder) r12).itemView.setEnabled(r22);
            View r23 = ((RecyclerView.ViewHolder) r12).itemView;
            if (r22 == false) goto L50;
            float r24 = 1.0f;
        L51:
            r23.setAlpha(r24);
            View r25 = r12.getView(2131385171);
            TextView r26 = (TextView) r12.getView(2131391345);
            boolean r27 = r14.isOpenSharing();
            boolean r28 = r14.isPublicScope();
            boolean r29 = up5.i.a(r14.tenant_id);
            DisplayTag r30 = r14.display_tag;
            if (r30 != null) goto L54;
            if (r29 == false) goto L71;
            if (r27 == true) goto L72;
            if (r28 == false) goto L71;
        L72:
            if (r4 == true) goto L75;
            r3 = 8;
        L75:
            r25.setVisibility(r3);
            if (r4 == false) goto L87;
            DisplayTag r31 = r14.display_tag;
            if (r31 == null) goto L84;
            String r32 = r31.getTag_value();
            if (r32 != null) goto L83;
            r32 = "";
        L83:
            r26.setText(r32);
            goto L87
        L84:
            if (r27 == false) goto L86;
            r26.setText(2131889830);
            goto L87
        L86:
            r26.setText(2131889822);
        L87:
            ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new w(r14, this.a));
            return;
        L71:
            r4 = false;
            goto L72
        L54:
            if (r30.isValidInSameTenant() != true) goto L56;
            boolean r33 = true;
        L57:
            if (r33 == true) goto L60;
            r29 = true;
        L60:
            if (r29 == false) goto L71;
            DisplayTag r34 = r14.display_tag;
            if (r34 == null) goto L65;
            r11 = r34.getTag_value();
        L65:
            if (TextUtils.isEmpty(r11) == true) goto L71;
        L56:
            r33 = false;
            goto L57
        L50:
            r24 = 0.3f;
        L46:
            r22 = true;
            goto L47
        L5:
            r2 = new int[]{0, com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(16)};
            goto L6
        }
    }

    static {
    }

    public final BannerMoreView getListBannerMoreFromXml() {
        AppCompatTextView r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131378070);
        this.b = (BannerMoreView) r0;
    L6:
        return (BannerMoreView) r0;
    }

    public final RecyclerView getListBannerRvListFromXml() {
        RecyclerView r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131378071);
        this.c = r0;
    L6:
        return r0;
    }

    public final TextView getListBannerTvTitleFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131378073);
        this.a = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final void setData(com.bytedance.ee.bear.wikiv2.home2.model.l r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        this.d.setNewDiffData(new WikiSpaceDiffCallback(r3.a));
    }

    public final void setDelegate(b r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.f = r2;
    }

    public final void setItemEnableChecker(Function<SpaceBean, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "enableChecker");
        this.e = r2;
    }

    public final void setListBannerMoreFromXml(BannerMoreView r1) {
        this.b = r1;
    }

    public final void setListBannerRvListFromXml(RecyclerView r1) {
        this.c = r1;
    }

    public final void setListBannerTvTitleFromXml(TextView r1) {
        this.a = r1;
    }

    public WikiHomeTopSpaceView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        c r6 = new c(this);
        this.d = r6;
        LayoutInflater.from(r4).inflate(2131568238, this);
        getListBannerTvTitleFromXml().setText(getResources().getString(2131889643));
        getListBannerMoreFromXml().setVisibility(8);
        int r2 = 0;
        getListBannerRvListFromXml().setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getListBannerRvListFromXml().setItemAnimator(null);
        getListBannerRvListFromXml().setAdapter(r6);
        aq5.a r7 = new aq5.a();
        WikiHomePageSpaceSnapHelper r8 = new WikiHomePageSpaceSnapHelper();
        r8.b = (int) r7.e;
        r8.c = 1;
        r8.attachToRecyclerView(getListBannerRvListFromXml());
        ArrayList r9 = new ArrayList();
    L4:
        if (r2 >= 4) goto L6;
        r9.add(new SpaceBean());
        r2 = r2 + 1;
        goto L4
    L6:
        this.d.setNewData(r9);
        this.d.setEmptyView(2131568239, this);
    }
}
