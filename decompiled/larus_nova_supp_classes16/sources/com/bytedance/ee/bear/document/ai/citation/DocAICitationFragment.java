package com.bytedance.ee.bear.document.ai.citation;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 02\u00020\u0001:\u0003012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0011J\u0012\u0010#\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel;", "callbackBridgeViewModel", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationCallbackBridgeViewModel;", "adapter", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationAdapter;", "titleView", "Landroid/widget/TextView;", "deleteBtn", "Landroid/widget/ImageView;", "recyclerView", "Lcom/bytedance/ee/bear/document/ai/citation/MaxHeightRecyclerView;", "currentData", "Lcom/bytedance/ee/bear/document/ai/citation/ShowCitationData;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCreate", "onStart", "initView", "initViewModel", "updateCitationData", "data", "updateView", "handleUiEvent", "event", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel$UiEvent;", "showDeleteDialog", "context", "Landroid/content/Context;", "dismissStateLoss", "onDestroyView", "emitCallbackResult", "type", "", "id", "Companion", "CitationAdapter", "CitationViewHolder", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAICitationFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int r = 0;
    public DocAICitationViewModel k;
    public DocAICitationCallbackBridgeViewModel l;
    public CitationAdapter m;
    public TextView n;
    public ImageView o;
    public MaxHeightRecyclerView p;
    public ShowCitationData q;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationViewHolder;", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;", "<init>", "(Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "Lkotlin/collections/ArrayList;", "setData", "", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CitationAdapter extends RecyclerView.Adapter<CitationViewHolder> {
        public final ArrayList<Citation> a;
        public final /* synthetic */ DocAICitationFragment b;

        public final int getItemCount() {
            return this.a.size();
        }

        public CitationAdapter(DocAICitationFragment r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
            CitationViewHolder r13 = (CitationViewHolder) r11;
            Intrinsics.checkNotNullParameter(r13, "holder");
            Citation r0 = (Citation) ListProtector.get(this.a, r12);
            int r3 = 0;
            if (r12 != (this.a.size() - 1)) goto L5;
            boolean r14 = true;
        L6:
            r13.getClass();
            Intrinsics.checkNotNullParameter(r0, "citation");
            r13.b.setText(r0.getTitle());
            DocCitationRefType.a r1 = DocCitationRefType.Companion;
            int r4 = r0.getUrlType();
            r1.getClass();
            DocCitationRefType[] r2 = DocCitationRefType.values();
            int r5 = r2.length;
            int r6 = 0;
        L7:
            Drawable r7 = null;
            if (r6 >= r5) goto L16;
            DocCitationRefType r8 = r2[r6];
            if (r8.getValue() != r4) goto L12;
            boolean r9 = true;
        L13:
            if (r9 == true) goto L17;
            r6 = r6 + 1;
        L17:
            if (r8 != null) goto L20;
            r8 = DocCitationRefType.UNKNOWN;
        L20:
            if (r8 != DocCitationRefType.HELPDESK) goto L22;
            int r10 = ((Number) r13.e.getValue()).intValue();
        L23:
            ViewGroup.LayoutParams r16 = r13.a.getLayoutParams();
            if (r16.width == r10) goto L26;
        L27:
            r16.width = r10;
            r16.height = r10;
            r13.a.setLayoutParams(r16);
        L28:
            int r17 = CitationViewHolder.a.a[r8.ordinal()];
            if (r17 != 1) goto L31;
            r7 = r13.T3(2131254087, 2131254094);
        L35:
            if (r7 == null) goto L37;
            r13.a.setImageDrawable(r7);
            r13.a.clearColorFilter();
        L38:
            if (r7 == null) goto L40;
        L42:
            r13.a.clearColorFilter();
        L43:
            ((RecyclerView.ViewHolder) r13).itemView.setOnClickListener(new com.bytedance.ee.bear.document.ai.citation.a(r0, r13.f));
            View r18 = r13.c;
            if (r14 == false) goto L46;
            r3 = 4;
        L46:
            r18.setVisibility(r3);
            return;
        L40:
            if (r8.getColorFilter() == (-1)) goto L42;
            r13.a.setColorFilter(ContextCompat.getColor(((RecyclerView.ViewHolder) r13).itemView.getContext(), r8.getColorFilter()));
            goto L43
        L37:
            r13.a.setImageResource(kac.a.b(r8.getResId()));
            goto L38
        L31:
            if (r17 != 2) goto L35;
            r7 = r13.T3(2131253537, 2131253538);
            goto L35
        L26:
            if (r16.height == r10) goto L28;
        L22:
            r10 = ((Number) r13.d.getValue()).intValue();
            goto L23
        L12:
            r9 = false;
            goto L13
        L16:
            r8 = null;
            goto L17
        L5:
            r14 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131559357, r3, false);
            DocAICitationFragment r0 = this.b;
            Intrinsics.checkNotNull(r5);
            return new CitationViewHolder(r0, r5);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;Landroid/view/View;)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "titleView", "Landroid/widget/TextView;", "dividerView", "defaultIconSize", "", "getDefaultIconSize", "()I", "defaultIconSize$delegate", "Lkotlin/Lazy;", "helpdeskIconSize", "getHelpdeskIconSize", "helpdeskIconSize$delegate", "bind", "", "citation", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "isLastItem", "", "updateIconSize", "citationRefType", "Lcom/bytedance/ee/bear/document/ai/citation/DocCitationRefType;", "createSpecialCitationIcon", "Landroid/graphics/drawable/Drawable;", "createTwoToneIconDrawable", "showIconResId", "bgIconResId", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CitationViewHolder extends RecyclerView.ViewHolder {
        public final AppCompatImageView a;
        public final TextView b;
        public final View c;
        public final Lazy d;
        public final Lazy e;
        public final /* synthetic */ DocAICitationFragment f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DocCitationRefType.values().length];
                r0[DocCitationRefType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[DocCitationRefType.COMMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public CitationViewHolder(DocAICitationFragment r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.f = r2;
            super(r3);
            this.a = r3.findViewById(2131365730);
            this.b = (TextView) r3.findViewById(2131365732);
            this.c = r3.findViewById(2131365729);
            this.d = LazyKt.lazy(new DocAICitationFragment$CitationViewHolder$defaultIconSize$2(r3));
            this.e = LazyKt.lazy(new DocAICitationFragment$CitationViewHolder$helpdeskIconSize$2(r3));
        }

        public final Drawable T3(int r4, int r5) {
            Context r0 = ((RecyclerView.ViewHolder) this).itemView.getContext();
            Drawable r6 = AppCompatResources.getDrawable(r0, kac.a.b(r4));
            if (r6 == null) goto L15;
            Drawable r7 = r6.mutate();
            if (r7 == null) goto L17;
            DrawableCompat.setTint(r7, ContextCompat.getColor(r0, 2131101111));
            Drawable r8 = AppCompatResources.getDrawable(r0, kac.a.b(r5));
            if (r8 == null) goto L14;
            Drawable r9 = r8.mutate();
            if (r9 == null) goto L14;
            DrawableCompat.setTint(r9, ContextCompat.getColor(r0, 2131106521));
            return new LayerDrawable(new Drawable[]{r9, r7});
        L14:
            return r7;
        L17:
            return null;
        L15:
            return null;
        }
    }

    public static final class a {
    }

    static {
    }

    public final void ea0() {
    L13:
        th = move-exception;
        Log.e("DocAICitationFragment", "dismissStateLoss: " + th);
        iu5.d.a("DocAICitationFragment_dismissIgnoreErr()", th);
        return;
    L4:
        if (isAdded() == true) goto L19;
        Log.e("DocAICitationFragment", "fragment is not add");     // Catch: Throwable -> L13
    L16:
        return;
    L19:
        dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L13
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L16
    }

    public final void onDestroyView() {
        Log.i("DocAICitationFragment", "onDestroyView");
        ShowCitationData r0 = this.q;
        if (r0 == null) goto L8;
        String r1 = DocAICitationClickType.Close.getType();
        String r2 = r0.getId();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        fa0(r1, r2);
    L8:
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void da0() {
        super.onStart();
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ku5.c.k(r0) == false) goto L21;
        Dialog r1 = getDialog();
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L11;
        r2.setLayout(-2, -2);
        r2.setGravity(17);
    L11:
        Dialog r3 = getDialog();
        if (r3 == null) goto L16;
        View r4 = r3.findViewById(2131368870);
        if (r4 == null) goto L16;
        r4.setBackground(new ColorDrawable(0));
    L16:
        View r5 = getView();
        if (r5 == null) goto L31;
        View r6 = r5.findViewById(2131370206);
        if (r6 == null) goto L32;
        r6.setVisibility(8);
        return;
    L32:
        return;
    L31:
        return;
    L21:
        View r7 = getView();
        if (r7 == null) goto L27;
        View r8 = r7.findViewById(2131370206);
        if (r8 == null) goto L27;
        r8.setVisibility(0);
    L27:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L34;
        BottomSheetDialog r9 = getDialog();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior r10 = r9.getBehavior();
        r10.setState(3);
        r10.setSkipCollapsed(true);
        r10.setHideable(true);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        da0();
    }

    public DocAICitationFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L7;
        ShowCitationData r4 = (ShowCitationData) r3.getParcelable("extra_data");
        if (r4 == null) goto L7;
        this.q = r4;
    L7:
        setStyle(0, getTheme());
    }

    public final void fa0(String r3, String r4) {
        DocAICitationViewModel r0 = this.k;
        DocAICitationCallbackBridgeViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        Pair<String, String> r5 = r0.buildCallbackEvent(r3, r4);
        if (r5 == null) goto L13;
        Log.i("DocAICitationFragment", "emitCallbackResult: " + r5);
        DocAICitationCallbackBridgeViewModel r6 = this.l;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("callbackBridgeViewModel");
    L11:
        r1.emit((String) r5.getFirst(), (String) r5.getSecond());
        return;
    L10:
        r1 = r6;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Context r6 = getContext();
        if (r6 != null) goto L5;
    L8:
        this.n = (TextView) r4.findViewById(2131391606);
        this.o = (ImageView) r4.findViewById(2131364702);
        this.p = (MaxHeightRecyclerView) r4.findViewById(2131384927);
        Context r7 = getContext();
        if (r7 == null) goto L13;
        Resources r8 = r7.getResources();
        int r9 = (WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).heightPixels / 2) - getResources().getDimensionPixelSize(2131166214);
        MaxHeightRecyclerView r10 = this.p;
        if (r10 == null) goto L13;
        r10.setMaxHeight(r9);
    L13:
        this.m = new CitationAdapter(this);
        MaxHeightRecyclerView r11 = this.p;
        if (r11 == null) goto L16;
        r11.setLayoutManager(new LinearLayoutManager(getContext()));
    L16:
        MaxHeightRecyclerView r12 = this.p;
        DocAICitationViewModel r13 = null;
        if (r12 == null) goto L22;
        CitationAdapter r0 = this.m;
        if (r0 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L21:
        r12.setAdapter(r0);
    L22:
        ImageView r14 = this.o;
        if (r14 == null) goto L25;
        r14.setOnClickListener(new b(this));
    L25:
        this.k = (DocAICitationViewModel) new ViewModelProvider(this).get(DocAICitationViewModel.class);
        this.l = (DocAICitationCallbackBridgeViewModel) new ViewModelProvider(requireActivity()).get(DocAICitationCallbackBridgeViewModel.class);
        DocAICitationViewModel r16 = this.k;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r16 = null;
    L28:
        r16.getCitationData().observe(getViewLifecycleOwner(), new c(this));
        DocAICitationViewModel r17 = this.k;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r17 = null;
    L31:
        r17.getUiEvent().observe(getViewLifecycleOwner(), new d(this));
        ShowCitationData r18 = this.q;
        if (r18 == null) goto L39;
        DocAICitationViewModel r1 = this.k;
        if (r1 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r13.updateData(r18);
        return;
    L36:
        r13 = r1;
        goto L37
    L39:
        return;
    L5:
        if (ku5.c.k(r6) == false) goto L7;
        r4.setBackground(ContextCompat.getDrawable(r6, 2131233903));
        goto L8
    L7:
        r4.setBackground(ContextCompat.getDrawable(r6, 2131233907));
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559356, r3, false);
    }
}
