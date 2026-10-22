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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 32\u00020\u0001:\b,-./0123B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001dH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00122\u0006\u0010$\u001a\u00020\u000fH\u0002J\u001c\u0010%\u001a\u00020\u001d2\n\u0010&\u001a\u00060'j\u0002`(2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0014\u0010*\u001a\u00020\u001d2\n\u0010&\u001a\u00060'j\u0002`(H\u0002J\b\u0010+\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "list", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtView$ItemAdapter;", "boundViewModel", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel;", "usersObserver", "Landroidx/lifecycle/Observer;", "", "Lcom/bytedance/ee/bear/at/AtObject;", "tablesObserver", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$TableItem;", "usersLoadingObserver", "", "tablesLoadingObserver", "viewModeObserver", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$ViewMode;", "Lcom/bytedance/ee/bear/bitable/superagent/at/ViewMode;", "setViewModel", "", "viewModel", "owner", "Landroidx/lifecycle/LifecycleOwner;", "rebuild", "buildItems", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtView$Item;", "vm", "onItemClick", "section", "Lcom/bytedance/ee/bear/bitable/superagent/at/BitableSuperAgentAtViewModel$Section;", "Lcom/bytedance/ee/bear/bitable/superagent/at/Section;", "index", "onMoreClick", "onBackClick", "Item", "ItemAdapter", "SimpleViewHolder", "HeaderViewHolder", "UserRowViewHolder", "TableRowViewHolder", "EmptyViewHolder", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentAtView extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public final e a;
    public BitableSuperAgentAtViewModel b;
    public final l c;
    public final j d;
    public final k e;
    public final i f;
    public final m g;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BitableSuperAgentAtViewModel.Section.values().length];
                r0[BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[BitableSuperAgentAtViewModel.Section.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131364222);
            this.b = (TextView) r2.findViewById(2131364223);
        }
    }

    public final class c extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final View c;
        public final /* synthetic */ BitableSuperAgentAtView d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BitableSuperAgentAtViewModel.Section.values().length];
                r0[BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[BitableSuperAgentAtViewModel.Section.TABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public c(BitableSuperAgentAtView r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.d = r2;
            super(r3);
            this.a = r3.findViewById(2131364224);
            this.b = (TextView) r3.findViewById(2131364226);
            this.c = r3.findViewById(2131364225);
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {
            public final BitableSuperAgentAtViewModel.Section a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (this.a == ((b) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                BitableSuperAgentAtViewModel.Section r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Empty(section=" + this.a + ')';
            }

            public b(BitableSuperAgentAtViewModel.Section r1) {
                this.a = r1;
            }
        }

        public static final class c extends d {
            public final BitableSuperAgentAtViewModel.Section a;
            public final boolean b;
            public final boolean c;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                int r2 = 1231;
                if (this.b == false) goto L5;
                int r1 = 1231;
            L6:
                int r3 = (r0 + r1) * 31;
                if (this.c == true) goto L11;
                r2 = 1237;
            L11:
                return r3 + r2;
            L5:
                r1 = 1237;
                goto L6
            }

            public final String toString() {
                return "Header(section=" + this.a + ", showBack=" + this.b + ", showMore=" + this.c + ')';
            }

            public c(BitableSuperAgentAtViewModel.Section r2, boolean r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, "section");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.superagent.at.BitableSuperAgentAtView$d$d, reason: collision with other inner class name */
        public static final class C0025d extends d {
            public final int a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0025d) == true) goto L9;
                return false;
            L9:
                if (this.a == ((C0025d) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a;
            }

            public final String toString() {
                return "Skeleton(index=" + this.a + ')';
            }

            public C0025d(int r1) {
                this.a = r1;
            }
        }

        public static final class e extends d {
            public final int a;
            public final BitableSuperAgentAtViewModel.b b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof e) == true) goto L8;
                return false;
            L8:
                e r6 = (e) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "TableRow(index=" + this.a + ", item=" + this.b + ')';
            }

            public e(int r2, BitableSuperAgentAtViewModel.b r3) {
                Intrinsics.checkNotNullParameter(r3, "item");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class f extends d {
            public final int a;
            public final AtObject b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof f) == true) goto L8;
                return false;
            L8:
                f r6 = (f) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "UserRow(index=" + this.a + ", obj=" + this.b + ')';
            }

            public f(int r2, AtObject r3) {
                Intrinsics.checkNotNullParameter(r3, "obj");
                this.a = r2;
                this.b = r3;
            }
        }

        public d() {
        }
    }

    public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final List<d> a;
        public final /* synthetic */ BitableSuperAgentAtView b;

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public e(BitableSuperAgentAtView r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final int getItemViewType(int r2) {
            d r3 = (d) ListProtector.get(this.a, r2);
            if ((r3 instanceof d.c) == false) goto L6;
            return 0;
        L6:
            if ((r3 instanceof d.f) == false) goto L9;
            return 1;
        L9:
            if ((r3 instanceof d.e) == false) goto L12;
            return 2;
        L12:
            if ((r3 instanceof d.C0025d) == false) goto L15;
            return 3;
        L15:
            if ((r3 instanceof d.b) == false) goto L18;
            return 4;
        L18:
            if (Intrinsics.areEqual(r3, d.a.a) == false) goto L22;
            return 5;
        L22:
            throw new NoWhenBranchMatchedException();
        }

        public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            ShimmerLayout r3 = r2.itemView;
            if ((r3 instanceof ShimmerLayout) == false) goto L5;
            ShimmerLayout r4 = r3;
        L6:
            if (r4 == null) goto L9;
            r4.c();
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            ShimmerLayout r3 = r2.itemView;
            if ((r3 instanceof ShimmerLayout) == false) goto L5;
            ShimmerLayout r4 = r3;
        L6:
            if (r4 == null) goto L9;
            r4.d();
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r16) {
            Intrinsics.checkNotNullParameter(r14, "holder");
            d r17 = (d) ListProtector.get(this.a, r16);
            int r5 = 8;
            if ((r17 instanceof d.c) == false) goto L20;
            c r18 = (c) r14;
            d.c r19 = (d.c) r17;
            r18.getClass();
            Intrinsics.checkNotNullParameter(r19, "item");
            TextView r0 = r18.b;
            int r7 = c.a.a[r19.a.ordinal()];
            if (r7 == 1) goto L10;
            if (r7 != 2) goto L9;
            String r1 = r18.d.getContext().getString(2131886091);
        L11:
            r0.setText(r1);
            View r2 = r18.a;
            if (r19.b == false) goto L14;
            int r3 = 0;
        L15:
            r2.setVisibility(r3);
            View r4 = r18.c;
            if (r19.c == false) goto L18;
            r5 = 0;
        L18:
            r4.setVisibility(r5);
            r18.a.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.a(r18.d));
            r18.c.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.b(r18.d, r19));
            return;
        L14:
            r3 = 8;
            goto L15
        L9:
            throw new NoWhenBranchMatchedException();
        L10:
            r1 = r18.d.getContext().getString(2131886092);
            goto L11
        L20:
            if ((r17 instanceof d.f) == false) goto L38;
            h r110 = (h) r14;
            d.f r111 = (d.f) r17;
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, "item");
            TextView r6 = r110.b;
            AtObject r8 = r111.b;
            if (r8.getType() != 0) goto L24;
            String r9 = ou5.a.a(r8.getLanguage(), r8.getDisplay_name(), r8.getCn_name(), r8.getEn_name());
        L27:
            r6.setText(r9);
            r110.a.setBackground(null);
            ImageViewCompat.setImageTintList(r110.a, null);
            r110.a.setPadding(0, 0, 0, 0);
            AppCompatImageView r10 = r110.a;
            AtObject r11 = r111.b;
            int r12 = r11.getType();
            if (r12 != 0) goto L30;
            r110.T3(r10, r11.getAvatar_url(), kac.a.b(2131235295));
        L36:
            ((RecyclerView.ViewHolder) r110).itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.d(r110.c, r111));
            return;
        L30:
            if (r12 != 5) goto L32;
        L34:
            r110.T3(r10, r11.getUrl(), kac.a.b(2131231737));
            goto L36
        L32:
            if (r12 == 6) goto L34;
            mbb.c.d(r10, r11.getToken(), r11.getType(), r11.getIconInfo(), IconShape.CIRCLE, new obb.a(IconScene.DOCUMENT));
            goto L36
        L24:
            r9 = r8.getContent();
            if (r9 != null) goto L27;
            r9 = "";
            goto L27
        L38:
            if ((r17 instanceof d.e) == false) goto L41;
            g r112 = (g) r14;
            d.e r113 = (d.e) r17;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r113, "item");
            r112.b.setText(r113.b.b);
            r112.a.setBackgroundResource(2131232375);
            int r13 = n.e(r112.c.getContext(), 6.0f);
            r112.a.setPadding(r13, r13, r13, r13);
            r112.a.setImageResource(kac.a.b(2131253750));
            ImageViewCompat.setImageTintList(r112.a, ColorStateList.valueOf(r112.c.getContext().getResources().getColor(2131102419)));
            ((RecyclerView.ViewHolder) r112).itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.superagent.at.c(r112.c, r113));
            return;
        L41:
            if ((r17 instanceof d.b) == false) goto L57;
            b r114 = (b) r14;
            d.b r115 = (d.b) r17;
            r114.getClass();
            Intrinsics.checkNotNullParameter(r115, "item");
            Context r20 = ((RecyclerView.ViewHolder) r114).itemView.getContext();
            BitableSuperAgentAtViewModel.Section r116 = r115.a;
            if (r116 != null) goto L45;
            int r117 = -1;
        L46:
            if (r117 != (-1)) goto L48;
            r114.a.setVisibility(8);
        L55:
            r114.b.setText(r20.getString(2131886095));
            return;
        L48:
            if (r117 == 1) goto L53;
            if (r117 != 2) goto L52;
            r114.a.setVisibility(0);
            r114.a.setText(r20.getString(2131886091) + ": ");
            goto L55
        L52:
            throw new NoWhenBranchMatchedException();
        L53:
            r114.a.setVisibility(0);
            r114.a.setText(r20.getString(2131886092) + ": ");
            goto L55
        L45:
            r117 = b.a.a[r116.ordinal()];
            goto L46
        L57:
            if ((r17 instanceof d.C0025d) == false) goto L59;
            return;
        L59:
            if (Intrinsics.areEqual(r17, d.a.a) == false) goto L62;
            return;
        L62:
            throw new NoWhenBranchMatchedException();
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            LayoutInflater r0 = LayoutInflater.from(r5.getContext());
            if (r6 == 0) goto L22;
            if (r6 == 1) goto L27;
            if (r6 == 2) goto L26;
            if (r6 != 3) goto L11;
            View r7 = r0.inflate(2131559165, r5, false);
            ShimmerLayout r1 = new ShimmerLayout(r7.getContext());
            r1.setShimmerAngle(20);
            r1.setShimmerColor(r1.getResources().getColor(2131108708));
            r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r1.addView(r7);
            return new f(r1);
        L11:
            if (r6 == 4) goto L24;
            if (r6 != 5) goto L16;
            return new f(r0.inflate(2131559161, r5, false));
        L16:
            throw new IllegalStateException(("Unknown viewType=" + r6).toString());
        L24:
            return new b(r0.inflate(2131559162, r5, false));
        L26:
            return new g(this.b, r0.inflate(2131559164, r5, false));
        L27:
            return new h(this.b, r0.inflate(2131559164, r5, false));
        L22:
            return new c(this.b, r0.inflate(2131559163, r5, false));
        }
    }

    public static final class f extends RecyclerView.ViewHolder {
        public f(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final class g extends RecyclerView.ViewHolder {
        public final AppCompatImageView a;
        public final TextView b;
        public final /* synthetic */ BitableSuperAgentAtView c;

        public g(BitableSuperAgentAtView r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.c = r2;
            super(r3);
            this.a = r3.findViewById(2131364228);
            this.b = (TextView) r3.findViewById(2131364229);
        }
    }

    public final class h extends RecyclerView.ViewHolder {
        public final AppCompatImageView a;
        public final TextView b;
        public final /* synthetic */ BitableSuperAgentAtView c;

        public h(BitableSuperAgentAtView r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.c = r2;
            super(r3);
            this.a = r3.findViewById(2131364228);
            this.b = (TextView) r3.findViewById(2131364229);
        }

        public final void T3(AppCompatImageView r3, String r4, int r5) {
            if (r4 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == false) goto L11;
            r3.setImageResource(r5);
            return;
        L11:
            Glide.with(this.c.getContext()).load(new BearGlideUrl(r4)).transform(new CircleCrop()).placeholder(r5).error(r5).fallback(r5).into(r3);
            return;
        L4:
            if (r4.length() == 0) goto L7;
            r0 = false;
            goto L8
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ BitableSuperAgentAtView a;

        public i(BitableSuperAgentAtView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ((Boolean) r2).booleanValue();
            BitableSuperAgentAtView r3 = this.a;
            int r0 = BitableSuperAgentAtView.h;
            r3.b();
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ BitableSuperAgentAtView a;

        public j(BitableSuperAgentAtView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((List) r2, "it");
            BitableSuperAgentAtView r3 = this.a;
            int r0 = BitableSuperAgentAtView.h;
            r3.b();
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ BitableSuperAgentAtView a;

        public k(BitableSuperAgentAtView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ((Boolean) r2).booleanValue();
            BitableSuperAgentAtView r3 = this.a;
            int r0 = BitableSuperAgentAtView.h;
            r3.b();
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ BitableSuperAgentAtView a;

        public l(BitableSuperAgentAtView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((List) r2, "it");
            BitableSuperAgentAtView r3 = this.a;
            int r0 = BitableSuperAgentAtView.h;
            r3.b();
        }
    }

    public static final class m<T> implements Observer {
        public final /* synthetic */ BitableSuperAgentAtView a;

        public m(BitableSuperAgentAtView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((BitableSuperAgentAtViewModel.ViewMode) r2, "it");
            BitableSuperAgentAtView r3 = this.a;
            int r0 = BitableSuperAgentAtView.h;
            r3.b();
        }
    }

    static {
    }

    public BitableSuperAgentAtView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BitableSuperAgentAtView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    public final void b() {
        BitableSuperAgentAtViewModel r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        e r2 = this.a;
        BitableSuperAgentAtViewModel.ViewMode r3 = (BitableSuperAgentAtViewModel.ViewMode) r1.p.getValue();
        if (r3 != null) goto L8;
        r3 = BitableSuperAgentAtViewModel.ViewMode.DEFAULT;
    L8:
        Object r4 = r1.l.getValue();
        Boolean r5 = Boolean.TRUE;
        boolean r6 = Intrinsics.areEqual(r4, r5);
        boolean r7 = Intrinsics.areEqual(r1.n.getValue(), r5);
        List r8 = (List) r1.h.getValue();
        if (r8 != null) goto L11;
        r8 = CollectionsKt.emptyList();
    L11:
        List r9 = (List) r1.j.getValue();
        if (r9 != null) goto L14;
        r9 = CollectionsKt.emptyList();
    L14:
        ?? r10 = new ArrayList();
        BitableSuperAgentAtViewModel.ViewMode r11 = BitableSuperAgentAtViewModel.ViewMode.DEFAULT;
        int r12 = 0;
        if (r3 != r11) goto L17;
    L20:
        boolean r13 = true;
    L21:
        if (r3 != r11) goto L23;
    L26:
        boolean r14 = true;
    L27:
        if (r3 != r11) goto L35;
        if (r6 == true) goto L35;
        if (r7 == true) goto L35;
        if (r8.isEmpty() == false) goto L35;
        if (r9.isEmpty() == false) goto L35;
        r10 = CollectionsKt.listOf(new d.b(null));
    L103:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "newItems");
        ((ArrayList) r2.a).clear();
        ArrayList r16 = (ArrayList) r2.a;
        r16.addAll((Collection) r10);
        r2.notifyDataSetChanged();
        return;
    L35:
        if (r13 == true) goto L37;
    L71:
        if (r13 == false) goto L74;
        if (r14 == false) goto L74;
        r10.add(d.a.a);
    L74:
        if (r14 == false) goto L103;
        if (r3 != BitableSuperAgentAtViewModel.ViewMode.TABLES_ONLY) goto L78;
        boolean r17 = true;
    L79:
        if (r7 == false) goto L81;
    L83:
        boolean r18 = false;
    L84:
        if (r18 == false) goto L86;
        r10.add(new d.b(BitableSuperAgentAtViewModel.Section.TABLE));
        goto L103
    L86:
        BitableSuperAgentAtViewModel.Section r19 = BitableSuperAgentAtViewModel.Section.TABLE;
        if (r3 == BitableSuperAgentAtViewModel.ViewMode.DEFAULT) goto L89;
    L91:
        boolean r20 = false;
    L92:
        r10.add(new d.c(r19, r17, r20));
        if (r17 == true) goto L96;
        r9 = CollectionsKt.take(r9, 5);
    L96:
        Iterator r21 = r9.iterator();
    L98:
        if (r21.hasNext() == false) goto L103;
        Object r22 = r21.next();
        int r23 = r12 + 1;
        if (r12 >= 0) goto L102;
        CollectionsKt.throwIndexOverflow();
    L102:
        r10.add(new d.e(r12, (BitableSuperAgentAtViewModel.b) r22));
        r12 = r23;
        goto L98
    L89:
        if (r9.size() <= 5) goto L91;
        r20 = true;
        goto L92
    L81:
        if (r9.isEmpty() == false) goto L83;
        r18 = true;
        goto L84
    L78:
        r17 = false;
        goto L79
    L37:
        if (r3 != BitableSuperAgentAtViewModel.ViewMode.USERS_ONLY) goto L39;
        boolean r110 = true;
    L40:
        if (r6 == false) goto L42;
    L44:
        boolean r111 = false;
    L45:
        if (r111 == false) goto L47;
        r10.add(new d.b(BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS));
        goto L71
    L47:
        BitableSuperAgentAtViewModel.Section r112 = BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS;
        if (r3 == r11) goto L50;
    L53:
        boolean r24 = false;
    L54:
        r10.add(new d.c(r112, r110, r24));
        if (r6 == false) goto L60;
        int r26 = 0;
    L57:
        if (r26 >= 3) goto L71;
        r10.add(new d.C0025d(r26));
        r26 = r26 + 1;
        goto L57
    L60:
        if (r8.isEmpty() == true) goto L71;
        if (r110 == true) goto L64;
        r8 = CollectionsKt.take(r8, 3);
    L64:
        Iterator r27 = r8.iterator();
        int r28 = 0;
    L66:
        if (r27.hasNext() == false) goto L71;
        Object r29 = r27.next();
        int r30 = r28 + 1;
        if (r28 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        r10.add(new d.f(r28, (AtObject) r29));
        r28 = r30;
        goto L66
    L50:
        if (r8.size() <= 3) goto L53;
        if (r6 == true) goto L53;
        r24 = true;
        goto L54
    L42:
        if (r8.isEmpty() == false) goto L44;
        r111 = true;
        goto L45
    L39:
        r110 = false;
        goto L40
    L23:
        if (r3 == BitableSuperAgentAtViewModel.ViewMode.TABLES_ONLY) goto L26;
        r14 = false;
        goto L27
    L17:
        if (r3 == BitableSuperAgentAtViewModel.ViewMode.USERS_ONLY) goto L20;
        r13 = false;
        goto L21
    }

    public final void c(BitableSuperAgentAtViewModel r4, FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        BitableSuperAgentAtViewModel r0 = this.b;
        if (r0 == null) goto L5;
        r0.h.removeObserver(this.c);
        r0.j.removeObserver(this.d);
        r0.l.removeObserver(this.e);
        r0.n.removeObserver(this.f);
        r0.p.removeObserver(this.g);
    L5:
        this.b = r4;
        if (r4 != null) goto L9;
        e r6 = this.a;
        List r7 = CollectionsKt.emptyList();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "newItems");
        ((ArrayList) r6.a).clear();
        ArrayList r1 = (ArrayList) r6.a;
        r1.addAll(r7);
        r6.notifyDataSetChanged();
        return;
    L9:
        r4.h.observe(r5, this.c);
        r4.j.observe(r5, this.d);
        r4.l.observe(r5, this.e);
        r4.n.observe(r5, this.f);
        r4.p.observe(r5, this.g);
        b();
    }

    public BitableSuperAgentAtView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        e r6 = new e(this);
        this.a = r6;
        this.c = new l(this);
        this.d = new j(this);
        this.e = new k(this);
        this.f = new i(this);
        this.g = new m(this);
        LayoutInflater.from(r3).inflate(2131559166, this, true);
        RecyclerView r7 = findViewById(2131364227);
        r7.setLayoutManager(new LinearLayoutManager(r3));
        r7.setAdapter(r6);
        r7.setItemAnimator(null);
    }

    public static final void a(BitableSuperAgentAtView r29, BitableSuperAgentAtViewModel.Section r30, int r31) {
        r29.getClass();
        tt5.a.h("BitableSuperAgentAtView", "onItemClick: section=" + r30 + ", index=" + r31);
        BitableSuperAgentAtViewModel r2 = r29.b;
        if (r2 == null) goto L40;
        Intrinsics.checkNotNullParameter(r30, "section");
        int r0 = BitableSuperAgentAtViewModel.c.a[r30.ordinal()];
        if (r0 != 1) goto L7;
        List r1 = (List) r2.g.getValue();
        if (r1 != null) goto L21;
        r1 = CollectionsKt.emptyList();
    L21:
        if (r31 >= 0) goto L23;
    L33:
        bo4.a r3 = null;
    L34:
        if (r3 == null) goto L42;
        Function1<? super bo4.a, Unit> r4 = r2.s;
        if (r4 == null) goto L41;
        r4.invoke(r3);
        return;
    L41:
        return;
    L42:
        return;
    L23:
        if (r31 >= r1.size()) goto L33;
        AtObject r5 = (AtObject) ListProtector.get(r1, r31);
        String r6 = r5.getContent();
        if (r6 != null) goto L28;
        r6 = "";
    L28:
        String r10 = r6;
        if (r5.getType() != 5) goto L31;
        int r7 = 6;
    L32:
        int r8 = r10.length();
        int r9 = r5.getSub_type();
        String r11 = r5.getToken();
        String r12 = r5.getUrl();
        String r13 = r5.getName();
        String r14 = r5.getEn_name();
        String r16 = r5.getCn_name();
        r5.getDisplay_name();
        HashMap r17 = r5.getI18n_user_name();
        r5.getSequenceNum();
        int r18 = r5.getIcon_type();
        r3 = new bo4.a(0, r8, r7, r9, r11, r12, r10, r13, r14, r16, r17, r5.getIconInfo(), r5.getIcon_fsunit(), r5.getIcon_key(), r18, false, null, r5.isNot_notify(), r5.isExternal(), r5.getUnion_id(), r5.getDepartment(), null, null, r5.getAvatar_url(), r5.getUserType());
        goto L34
    L31:
        r7 = r5.getType();
        goto L32
    L7:
        if (r0 != 2) goto L17;
        List r19 = (List) r2.i.getValue();
        if (r19 != null) goto L11;
        r19 = CollectionsKt.emptyList();
    L11:
        if (r31 < 0) goto L33;
        if (r31 >= r19.size()) goto L33;
        BitableSuperAgentAtViewModel.b r20 = (BitableSuperAgentAtViewModel.b) ListProtector.get(r19, r31);
        int r21 = r20.b.length();
        String r22 = r20.a;
        String r110 = r20.b;
        r3 = new bo4.a(0, r21, 9, -1, r22, null, r110, r110, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0);
        goto L34
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ BitableSuperAgentAtView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
