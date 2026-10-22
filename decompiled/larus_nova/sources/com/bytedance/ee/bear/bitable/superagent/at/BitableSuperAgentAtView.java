package com.bytedance.ee.bear.bitable.superagent.at;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.supercharge.shimmerlayout.ShimmerLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 32\u00020\u0001:\b,-./0123B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001dH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00122\u0006\u0010$\u001a\u00020\u000fH\u0002J\u001c\u0010%\u001a\u00020\u001d2\n\u0010&\u001a\u00060'j\u0002`(2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0014\u0010*\u001a\u00020\u001d2\n\u0010&\u001a\u00060'j\u0002`(H\u0002J\b\u0010+\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "list", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtView$ItemAdapter;", "boundViewModel", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel;", "usersObserver", "Landroidx/lifecycle/Observer;", "", "Lcom/bytedance/ee/bear/at/AtObject;", "tablesObserver", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$TableItem;", "usersLoadingObserver", "", "tablesLoadingObserver", "viewModeObserver", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$ViewMode;", "Lcom/bytedance/ee/bear/bitable/superagent/at/ViewMode;", "setViewModel", "", "viewModel", "owner", "Landroidx/lifecycle/LifecycleOwner;", "rebuild", "buildItems", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtView$Item;", "vm", "onItemClick", "section", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$Section;", "Lcom/bytedance/ee/bear/bitable/superagent/at/Section;", "index", "onMoreClick", "onBackClick", "Item", "ItemAdapter", "SimpleViewHolder", "HeaderViewHolder", "UserRowViewHolder", "TableRowViewHolder", "EmptyViewHolder", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentAtView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f215782h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f215783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BitableSuperAgentAtViewModel f215784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f215785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f215786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f215787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f215788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f215789g;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f215790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f215791b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f215792a = null;

            static {
                int[] r100 = new int[BitableSuperAgentAtViewModel.Section.values().length];
                r100[BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[BitableSuperAgentAtViewModel.Section.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f215792a = r100;
            }
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f215790a = (TextView) r100.findViewById(R.id.bitable_superagent_at_empty_label);
            this.f215791b = (TextView) r100.findViewById(R.id.bitable_superagent_at_empty_text);
        }
    }

    public final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f215793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f215794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f215795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215796d;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f215797a = null;

            static {
                int[] r100 = new int[BitableSuperAgentAtViewModel.Section.values().length];
                r100[BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[BitableSuperAgentAtViewModel.Section.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f215797a = r100;
            }
        }

        public c(BitableSuperAgentAtView r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f215796d = r100;
            super(r101);
            this.f215793a = r101.findViewById(R.id.bitable_superagent_at_header_back);
            this.f215794b = (TextView) r101.findViewById(R.id.bitable_superagent_at_header_title);
            this.f215795c = r101.findViewById(R.id.bitable_superagent_at_header_more);
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f215798a = null;

            static {
                f215798a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final BitableSuperAgentAtViewModel.Section f215799a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (this.f215799a == ((b) r100).f215799a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                BitableSuperAgentAtViewModel.Section r100 = this.f215799a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "Empty(section=" + this.f215799a + ')';
            }

            public b(BitableSuperAgentAtViewModel.Section r100) {
                this.f215799a = r100;
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final BitableSuperAgentAtViewModel.Section f215800a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f215801b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f215802c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (this.f215800a == r101.f215800a) goto L12;
                return false;
            L12:
                if (this.f215801b == r101.f215801b) goto L15;
                return false;
            L15:
                if (this.f215802c == r101.f215802c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f215800a.hashCode() * 31;
                int r101 = 1231;
                if (this.f215801b == false) goto L5;
                int r102 = 1231;
            L6:
                int r103 = (r100 + r102) * 31;
                if (this.f215802c == true) goto L11;
                r101 = 1237;
            L11:
                return r103 + r101;
            L5:
                r102 = 1237;
                goto L6
            }

            public final String toString() {
                return "Header(section=" + this.f215800a + ", showBack=" + this.f215801b + ", showMore=" + this.f215802c + ')';
            }

            public c(BitableSuperAgentAtViewModel.Section r100, boolean r101, boolean r102) {
                Intrinsics.checkNotNullParameter(r100, "section");
                this.f215800a = r100;
                this.f215801b = r101;
                this.f215802c = r102;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.superagent.at.BitableSuperAgentAtView$d$d, reason: collision with other inner class name */
        public static final class C3081d extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f215803a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3081d) == true) goto L9;
                return false;
            L9:
                if (this.f215803a == ((C3081d) r100).f215803a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f215803a;
            }

            public final String toString() {
                return "Skeleton(index=" + this.f215803a + ')';
            }

            public C3081d(int r100) {
                this.f215803a = r100;
            }
        }

        public static final class e extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f215804a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final BitableSuperAgentAtViewModel.b f215805b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L8;
                return false;
            L8:
                e r101 = (e) r100;
                if (this.f215804a == r101.f215804a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f215805b, r101.f215805b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f215804a * 31) + this.f215805b.hashCode();
            }

            public final String toString() {
                return "TableRow(index=" + this.f215804a + ", item=" + this.f215805b + ')';
            }

            public e(int r100, BitableSuperAgentAtViewModel.b r101) {
                Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
                this.f215804a = r100;
                this.f215805b = r101;
            }
        }

        public static final class f extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f215806a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtObject f215807b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L8;
                return false;
            L8:
                f r101 = (f) r100;
                if (this.f215806a == r101.f215806a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f215807b, r101.f215807b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f215806a * 31) + this.f215807b.hashCode();
            }

            public final String toString() {
                return "UserRow(index=" + this.f215806a + ", obj=" + this.f215807b + ')';
            }

            public f(int r100, AtObject r101) {
                Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                this.f215806a = r100;
                this.f215807b = r101;
            }
        }

        public d() {
        }
    }

    public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d> f215808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215809b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f215808a).size();
        }

        public e(BitableSuperAgentAtView r100) {
            this.f215809b = r100;
            this.f215808a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            d r101 = (d) ListProtector.get(this.f215808a, r100);
            if ((r101 instanceof d.c) == false) goto L6;
            return 0;
        L6:
            if ((r101 instanceof d.f) == false) goto L9;
            return 1;
        L9:
            if ((r101 instanceof d.e) == false) goto L12;
            return 2;
        L12:
            if ((r101 instanceof d.C3081d) == false) goto L15;
            return 3;
        L15:
            if ((r101 instanceof d.b) == false) goto L18;
            return 4;
        L18:
            if (Intrinsics.areEqual(r101, d.a.f215798a) == false) goto L22;
            return 5;
        L22:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            View r101 = r100.itemView;
            if ((r101 instanceof ShimmerLayout) == false) goto L5;
            ShimmerLayout r102 = (ShimmerLayout) r101;
        L6:
            if (r102 == null) goto L9;
            r102.c();
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            View r101 = r100.itemView;
            if ((r101 instanceof ShimmerLayout) == false) goto L5;
            ShimmerLayout r102 = (ShimmerLayout) r101;
        L6:
            if (r102 == null) goto L9;
            r102.d();
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "holder");
            d r112 = (d) ListProtector.get(this.f215808a, r111);
            int r100 = 8;
            if ((r112 instanceof d.c) == false) goto L20;
            c r113 = (c) r110;
            d.c r114 = (d.c) r112;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r114, MapController.ITEM_LAYER_TAG);
            TextView r101 = r113.f215794b;
            int r102 = c.a.f215797a[r114.f215800a.ordinal()];
            if (r102 == 1) goto L10;
            if (r102 != 2) goto L9;
            String r103 = r113.f215796d.getContext().getString(R.string.Bitable_AISidebar_InChat_ReferenceValues_Tables_Title);
        L11:
            r101.setText(r103);
            View r104 = r113.f215793a;
            if (r114.f215801b == false) goto L14;
            int r105 = 0;
        L15:
            r104.setVisibility(r105);
            View r106 = r113.f215795c;
            if (r114.f215802c == false) goto L18;
            r100 = 0;
        L18:
            r106.setVisibility(r100);
            r113.f215793a.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.a(r113.f215796d));
            r113.f215795c.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.b(r113.f215796d, r114));
            return;
        L14:
            r105 = 8;
            goto L15
        L9:
            throw new NoWhenBranchMatchedException();
        L10:
            r103 = r113.f215796d.getContext().getString(R.string.Bitable_AISidebar_InChat_ReferenceValues_UsersAndGroups_Title);
            goto L11
        L20:
            if ((r112 instanceof d.f) == false) goto L38;
            h r115 = (h) r110;
            d.f r116 = (d.f) r112;
            r115.getClass();
            Intrinsics.checkNotNullParameter(r116, MapController.ITEM_LAYER_TAG);
            TextView r107 = r115.f215814b;
            AtObject r108 = r116.f215807b;
            if (r108.getType() != 0) goto L24;
            String r109 = ou5.a.a(r108.getLanguage(), r108.getDisplay_name(), r108.getCn_name(), r108.getEn_name());
        L27:
            r107.setText(r109);
            r115.f215813a.setBackground(null);
            ImageViewCompat.setImageTintList(r115.f215813a, null);
            r115.f215813a.setPadding(0, 0, 0, 0);
            AppCompatImageView r117 = r115.f215813a;
            AtObject r118 = r116.f215807b;
            int r119 = r118.getType();
            if (r119 != 0) goto L30;
            r115.T3(r117, r118.getAvatar_url(), kac.a.b(R.drawable.facade_common_avatar_place_holder));
        L36:
            r115.itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.d(r115.f215815c, r116));
            return;
        L30:
            if (r119 != 5) goto L32;
        L34:
            r115.T3(r117, r118.getUrl(), kac.a.b(R.drawable.at_atfinder_default_icon));
            goto L36
        L32:
            if (r119 == 6) goto L34;
            mbb.c.d(r117, r118.getToken(), r118.getType(), r118.getIconInfo(), IconShape.CIRCLE, new obb.a(IconScene.DOCUMENT));
            goto L36
        L24:
            r109 = r108.getContent();
            if (r109 != null) goto L27;
            r109 = "";
            goto L27
        L38:
            if ((r112 instanceof d.e) == false) goto L41;
            g r120 = (g) r110;
            d.e r121 = (d.e) r112;
            r120.getClass();
            Intrinsics.checkNotNullParameter(r121, MapController.ITEM_LAYER_TAG);
            r120.f215811b.setText(r121.f215805b.f215846b);
            r120.f215810a.setBackgroundResource(R.drawable.bitable_superagent_at_table_tile_bg);
            int r122 = n.e(r120.f215812c.getContext(), 6.0f);
            r120.f215810a.setPadding(r122, r122, r122, r122);
            r120.f215810a.setImageResource(kac.a.b(R.drawable.ud_icon_base_agent_table_outlined));
            ImageViewCompat.setImageTintList(r120.f215810a, ColorStateList.valueOf(r120.f215812c.getContext().getResources().getColor(R.color.icon_n2)));
            r120.itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.c(r120.f215812c, r121));
            return;
        L41:
            if ((r112 instanceof d.b) == false) goto L57;
            b r123 = (b) r110;
            d.b r124 = (d.b) r112;
            r123.getClass();
            Intrinsics.checkNotNullParameter(r124, MapController.ITEM_LAYER_TAG);
            Context r125 = r123.itemView.getContext();
            BitableSuperAgentAtViewModel.Section r126 = r124.f215799a;
            if (r126 != null) goto L45;
            int r127 = -1;
        L46:
            if (r127 != (-1)) goto L48;
            r123.f215790a.setVisibility(8);
        L55:
            r123.f215791b.setText(r125.getString(R.string.Bitable_AISidebar_NoMatchingResults_Desc_Mob));
            return;
        L48:
            if (r127 == 1) goto L53;
            if (r127 != 2) goto L52;
            r123.f215790a.setVisibility(0);
            r123.f215790a.setText(r125.getString(R.string.Bitable_AISidebar_InChat_ReferenceValues_Tables_Title) + ": ");
            goto L55
        L52:
            throw new NoWhenBranchMatchedException();
        L53:
            r123.f215790a.setVisibility(0);
            r123.f215790a.setText(r125.getString(R.string.Bitable_AISidebar_InChat_ReferenceValues_UsersAndGroups_Title) + ": ");
            goto L55
        L45:
            r127 = b.a.f215792a[r126.ordinal()];
            goto L46
        L57:
            if ((r112 instanceof d.C3081d) == false) goto L59;
            return;
        L59:
            if (Intrinsics.areEqual(r112, d.a.f215798a) == false) goto L62;
            return;
        L62:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            LayoutInflater r102 = LayoutInflater.from(r100.getContext());
            if (r101 == 0) goto L22;
            if (r101 == 1) goto L27;
            if (r101 == 2) goto L26;
            if (r101 != 3) goto L11;
            View r103 = r102.inflate(R.layout.bitable_superagent_at_skeleton_row, r100, false);
            ShimmerLayout r104 = new ShimmerLayout(r103.getContext());
            r104.setShimmerAngle(20);
            r104.setShimmerColor(r104.getResources().getColor(R.color.ud_N00_60));
            r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r104.addView(r103);
            return new f(r104);
        L11:
            if (r101 == 4) goto L24;
            if (r101 != 5) goto L16;
            return new f(r102.inflate(R.layout.bitable_superagent_at_divider, r100, false));
        L16:
            throw new IllegalStateException(("Unknown viewType=" + r101).toString());
        L24:
            return new b(r102.inflate(R.layout.bitable_superagent_at_empty, r100, false));
        L26:
            return new g(this.f215809b, r102.inflate(R.layout.bitable_superagent_at_row, r100, false));
        L27:
            return new h(this.f215809b, r102.inflate(R.layout.bitable_superagent_at_row, r100, false));
        L22:
            return new c(this.f215809b, r102.inflate(R.layout.bitable_superagent_at_header, r100, false));
        }
    }

    public static final class f extends RecyclerView.ViewHolder {
        public f(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public final class g extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f215810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f215811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215812c;

        public g(BitableSuperAgentAtView r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f215812c = r100;
            super(r101);
            this.f215810a = (AppCompatImageView) r101.findViewById(R.id.bitable_superagent_at_row_icon);
            this.f215811b = (TextView) r101.findViewById(R.id.bitable_superagent_at_row_name);
        }
    }

    public final class h extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f215813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f215814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215815c;

        public h(BitableSuperAgentAtView r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f215815c = r100;
            super(r101);
            this.f215813a = (AppCompatImageView) r101.findViewById(R.id.bitable_superagent_at_row_icon);
            this.f215814b = (TextView) r101.findViewById(R.id.bitable_superagent_at_row_name);
        }

        public final void T3(AppCompatImageView r100, String r101, int r102) {
            if (r101 != null) goto L4;
        L7:
            boolean r103 = true;
        L8:
            if (r103 == false) goto L11;
            r100.setImageResource(r102);
            return;
        L11:
            Glide.with(this.f215815c.getContext()).load(new BearGlideUrl(r101)).transform(new CircleCrop()).placeholder(r102).error(r102).fallback(r102).into(r100);
            return;
        L4:
            if (r101.length() == 0) goto L7;
            r103 = false;
            goto L8
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215816a;

        public i(BitableSuperAgentAtView r100) {
            this.f215816a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ((Boolean) r100).booleanValue();
            BitableSuperAgentAtView r101 = this.f215816a;
            int r102 = BitableSuperAgentAtView.f215782h;
            r101.b();
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215817a;

        public j(BitableSuperAgentAtView r100) {
            this.f215817a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((List) r100, "it");
            BitableSuperAgentAtView r101 = this.f215817a;
            int r102 = BitableSuperAgentAtView.f215782h;
            r101.b();
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215818a;

        public k(BitableSuperAgentAtView r100) {
            this.f215818a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ((Boolean) r100).booleanValue();
            BitableSuperAgentAtView r101 = this.f215818a;
            int r102 = BitableSuperAgentAtView.f215782h;
            r101.b();
        }
    }

    public static final class l<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215819a;

        public l(BitableSuperAgentAtView r100) {
            this.f215819a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((List) r100, "it");
            BitableSuperAgentAtView r101 = this.f215819a;
            int r102 = BitableSuperAgentAtView.f215782h;
            r101.b();
        }
    }

    public static final class m<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentAtView f215820a;

        public m(BitableSuperAgentAtView r100) {
            this.f215820a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((BitableSuperAgentAtViewModel.ViewMode) r100, "it");
            BitableSuperAgentAtView r101 = this.f215820a;
            int r102 = BitableSuperAgentAtView.f215782h;
            r101.b();
        }
    }

    static {
    }

    public BitableSuperAgentAtView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableSuperAgentAtView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    public final void b() {
        BitableSuperAgentAtViewModel r100 = this.f215784b;
        if (r100 != null) goto L5;
        return;
    L5:
        e r101 = this.f215783a;
        BitableSuperAgentAtViewModel.ViewMode r102 = (BitableSuperAgentAtViewModel.ViewMode) r100.f215836p.getValue();
        if (r102 != null) goto L8;
        r102 = BitableSuperAgentAtViewModel.ViewMode.DEFAULT;
    L8:
        Object r103 = r100.f215832l.getValue();
        Boolean r104 = Boolean.TRUE;
        boolean r105 = Intrinsics.areEqual(r103, r104);
        boolean r106 = Intrinsics.areEqual(r100.f215834n.getValue(), r104);
        List r107 = (List) r100.f215828h.getValue();
        if (r107 != null) goto L11;
        r107 = CollectionsKt.emptyList();
    L11:
        List r108 = (List) r100.f215830j.getValue();
        if (r108 != null) goto L14;
        r108 = CollectionsKt.emptyList();
    L14:
        ?? r109 = new ArrayList();
        BitableSuperAgentAtViewModel.ViewMode r110 = BitableSuperAgentAtViewModel.ViewMode.DEFAULT;
        int r111 = 0;
        if (r102 != r110) goto L17;
    L20:
        boolean r112 = true;
    L21:
        if (r102 != r110) goto L23;
    L26:
        boolean r113 = true;
    L27:
        if (r102 != r110) goto L35;
        if (r105 == true) goto L35;
        if (r106 == true) goto L35;
        if (r107.isEmpty() == false) goto L35;
        if (r108.isEmpty() == false) goto L35;
        r109 = CollectionsKt.listOf(new d.b(null));
    L103:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r109, "newItems");
        ((ArrayList) r101.f215808a).clear();
        ArrayList r114 = (ArrayList) r101.f215808a;
        r114.addAll((Collection) r109);
        r101.notifyDataSetChanged();
        return;
    L35:
        if (r112 == true) goto L37;
    L71:
        if (r112 == false) goto L74;
        if (r113 == false) goto L74;
        r109.add(d.a.f215798a);
    L74:
        if (r113 == false) goto L103;
        if (r102 != BitableSuperAgentAtViewModel.ViewMode.TABLES_ONLY) goto L78;
        boolean r115 = true;
    L79:
        if (r106 == false) goto L81;
    L83:
        boolean r116 = false;
    L84:
        if (r116 == false) goto L86;
        r109.add(new d.b(BitableSuperAgentAtViewModel.Section.TABLE));
        goto L103
    L86:
        BitableSuperAgentAtViewModel.Section r117 = BitableSuperAgentAtViewModel.Section.TABLE;
        if (r102 == BitableSuperAgentAtViewModel.ViewMode.DEFAULT) goto L89;
    L91:
        boolean r118 = false;
    L92:
        r109.add(new d.c(r117, r115, r118));
        if (r115 == true) goto L96;
        r108 = CollectionsKt.take(r108, 5);
    L96:
        Iterator r119 = r108.iterator();
    L98:
        if (r119.hasNext() == false) goto L103;
        Object r120 = r119.next();
        int r121 = r111 + 1;
        if (r111 >= 0) goto L102;
        CollectionsKt.throwIndexOverflow();
    L102:
        r109.add(new d.e(r111, (BitableSuperAgentAtViewModel.b) r120));
        r111 = r121;
        goto L98
    L89:
        if (r108.size() <= 5) goto L91;
        r118 = true;
        goto L92
    L81:
        if (r108.isEmpty() == false) goto L83;
        r116 = true;
        goto L84
    L78:
        r115 = false;
        goto L79
    L37:
        if (r102 != BitableSuperAgentAtViewModel.ViewMode.USERS_ONLY) goto L39;
        boolean r122 = true;
    L40:
        if (r105 == false) goto L42;
    L44:
        boolean r123 = false;
    L45:
        if (r123 == false) goto L47;
        r109.add(new d.b(BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS));
        goto L71
    L47:
        BitableSuperAgentAtViewModel.Section r124 = BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS;
        if (r102 == r110) goto L50;
    L53:
        boolean r125 = false;
    L54:
        r109.add(new d.c(r124, r122, r125));
        if (r105 == false) goto L60;
        int r126 = 0;
    L57:
        if (r126 >= 3) goto L71;
        r109.add(new d.C3081d(r126));
        r126 = r126 + 1;
        goto L57
    L60:
        if (r107.isEmpty() == true) goto L71;
        if (r122 == true) goto L64;
        r107 = CollectionsKt.take(r107, 3);
    L64:
        Iterator r127 = r107.iterator();
        int r128 = 0;
    L66:
        if (r127.hasNext() == false) goto L71;
        Object r129 = r127.next();
        int r130 = r128 + 1;
        if (r128 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        r109.add(new d.f(r128, (AtObject) r129));
        r128 = r130;
        goto L66
    L50:
        if (r107.size() <= 3) goto L53;
        if (r105 == true) goto L53;
        r125 = true;
        goto L54
    L42:
        if (r107.isEmpty() == false) goto L44;
        r123 = true;
        goto L45
    L39:
        r122 = false;
        goto L40
    L23:
        if (r102 == BitableSuperAgentAtViewModel.ViewMode.TABLES_ONLY) goto L26;
        r113 = false;
        goto L27
    L17:
        if (r102 == BitableSuperAgentAtViewModel.ViewMode.USERS_ONLY) goto L20;
        r112 = false;
        goto L21
    }

    public final void c(BitableSuperAgentAtViewModel r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r101, "owner");
        BitableSuperAgentAtViewModel r102 = this.f215784b;
        if (r102 == null) goto L5;
        r102.f215828h.removeObserver(this.f215785c);
        r102.f215830j.removeObserver(this.f215786d);
        r102.f215832l.removeObserver(this.f215787e);
        r102.f215834n.removeObserver(this.f215788f);
        r102.f215836p.removeObserver(this.f215789g);
    L5:
        this.f215784b = r100;
        if (r100 != null) goto L9;
        e r103 = this.f215783a;
        List r104 = CollectionsKt.emptyList();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "newItems");
        ((ArrayList) r103.f215808a).clear();
        ArrayList r105 = (ArrayList) r103.f215808a;
        r105.addAll(r104);
        r103.notifyDataSetChanged();
        return;
    L9:
        r100.f215828h.observe(r101, this.f215785c);
        r100.f215830j.observe(r101, this.f215786d);
        r100.f215832l.observe(r101, this.f215787e);
        r100.f215834n.observe(r101, this.f215788f);
        r100.f215836p.observe(r101, this.f215789g);
        b();
    }

    public BitableSuperAgentAtView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        e r103 = new e(this);
        this.f215783a = r103;
        this.f215785c = new l(this);
        this.f215786d = new j(this);
        this.f215787e = new k(this);
        this.f215788f = new i(this);
        this.f215789g = new m(this);
        LayoutInflater.from(r100).inflate(R.layout.bitable_superagent_at_view, this, true);
        RecyclerView r104 = (RecyclerView) findViewById(R.id.bitable_superagent_at_list);
        r104.setLayoutManager(new LinearLayoutManager(r100));
        r104.setAdapter(r103);
        r104.setItemAnimator(null);
    }

    public static final void a(BitableSuperAgentAtView r210, BitableSuperAgentAtViewModel.Section r310, int r311) {
        r210.getClass();
        tt5.a.h("BitableSuperAgentAtView", "onItemClick: section=" + r310 + ", index=" + r311);
        BitableSuperAgentAtViewModel r100 = r210.f215784b;
        if (r100 == null) goto L40;
        Intrinsics.checkNotNullParameter(r310, "section");
        int r101 = BitableSuperAgentAtViewModel.c.f215847a[r310.ordinal()];
        if (r101 != 1) goto L7;
        List<AtObject> r102 = r100.f215827g.getValue();
        if (r102 != null) goto L21;
        r102 = CollectionsKt.emptyList();
    L21:
        if (r311 >= 0) goto L23;
    L33:
        bo4.a r103 = null;
    L34:
        if (r103 == null) goto L42;
        Function1<? super bo4.a, Unit> r104 = r100.f215839s;
        if (r104 == null) goto L41;
        r104.invoke(r103);
        return;
    L41:
        return;
    L42:
        return;
    L23:
        if (r311 >= r102.size()) goto L33;
        AtObject r105 = (AtObject) ListProtector.get(r102, r311);
        String r106 = r105.getContent();
        if (r106 != null) goto L28;
        r106 = "";
    L28:
        String r110 = r106;
        if (r105.getType() != 5) goto L31;
        int r107 = 6;
    L32:
        int r108 = r110.length();
        int r109 = r105.getSub_type();
        String r111 = r105.getToken();
        String r112 = r105.getUrl();
        String r113 = r105.getName();
        String r114 = r105.getEn_name();
        String r115 = r105.getCn_name();
        r105.getDisplay_name();
        HashMap<String, String> r116 = r105.getI18n_user_name();
        r105.getSequenceNum();
        int r117 = r105.getIcon_type();
        r103 = new bo4.a(0, r108, r107, r109, r111, r112, r110, r113, r114, r115, r116, r105.getIconInfo(), r105.getIcon_fsunit(), r105.getIcon_key(), r117, false, null, r105.isNot_notify(), r105.isExternal(), r105.getUnion_id(), r105.getDepartment(), null, null, r105.getAvatar_url(), r105.getUserType());
        goto L34
    L31:
        r107 = r105.getType();
        goto L32
    L7:
        if (r101 != 2) goto L17;
        List<BitableSuperAgentAtViewModel.b> r118 = r100.f215829i.getValue();
        if (r118 != null) goto L11;
        r118 = CollectionsKt.emptyList();
    L11:
        if (r311 < 0) goto L33;
        if (r311 >= r118.size()) goto L33;
        BitableSuperAgentAtViewModel.b r119 = (BitableSuperAgentAtViewModel.b) ListProtector.get(r118, r311);
        int r120 = r119.f215846b.length();
        String r121 = r119.f215845a;
        String r122 = r119.f215846b;
        r103 = new bo4.a(0, r120, 9, -1, r121, null, r122, r122, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0);
        goto L34
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ BitableSuperAgentAtView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
