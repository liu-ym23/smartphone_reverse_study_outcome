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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 02\u00020\u0001:\u0003012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0011J\u0012\u0010#\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel;", "callbackBridgeViewModel", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationCallbackBridgeViewModel;", "adapter", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationAdapter;", "titleView", "Landroid/widget/TextView;", "deleteBtn", "Landroid/widget/ImageView;", "recyclerView", "Lcom/bytedance/ee/bear/document/ai/citation/MaxHeightRecyclerView;", "currentData", "Lcom/bytedance/ee/bear/document/ai/citation/ShowCitationData;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "initView", "initViewModel", "updateCitationData", "data", "updateView", "handleUiEvent", "event", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel$UiEvent;", "showDeleteDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dismissStateLoss", "onDestroyView", "emitCallbackResult", "type", "", "id", "Companion", "CitationAdapter", "CitationViewHolder", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAICitationFragment extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f218730r = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DocAICitationViewModel f218731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DocAICitationCallbackBridgeViewModel f218732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CitationAdapter f218733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f218734n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f218735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MaxHeightRecyclerView f218736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ShowCitationData f218737q;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationViewHolder;", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;", "<init>", "(Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "Lkotlin/collections/ArrayList;", "setData", "", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CitationAdapter extends RecyclerView.Adapter<CitationViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<Citation> f218738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DocAICitationFragment f218739b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f218738a.size();
        }

        public CitationAdapter(DocAICitationFragment r100) {
            this.f218739b = r100;
            this.f218738a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            CitationViewHolder r112 = (CitationViewHolder) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            Citation r100 = (Citation) ListProtector.get(this.f218738a, r111);
            int r101 = 0;
            if (r111 != (this.f218738a.size() - 1)) goto L5;
            boolean r113 = true;
        L6:
            r112.getClass();
            Intrinsics.checkNotNullParameter(r100, "citation");
            r112.f218741b.setText(r100.getTitle());
            DocCitationRefType.a r102 = DocCitationRefType.Companion;
            int r103 = r100.getUrlType();
            r102.getClass();
            DocCitationRefType[] r104 = DocCitationRefType.values();
            int r105 = r104.length;
            int r106 = 0;
        L7:
            Drawable r107 = null;
            if (r106 >= r105) goto L16;
            DocCitationRefType r108 = r104[r106];
            if (r108.getValue() != r103) goto L12;
            boolean r109 = true;
        L13:
            if (r109 == true) goto L17;
            r106 = r106 + 1;
        L17:
            if (r108 != null) goto L20;
            r108 = DocCitationRefType.UNKNOWN;
        L20:
            if (r108 != DocCitationRefType.HELPDESK) goto L22;
            int r114 = ((Number) r112.f218744e.getValue()).intValue();
        L23:
            ViewGroup.LayoutParams r115 = r112.f218740a.getLayoutParams();
            if (r115.width == r114) goto L26;
        L27:
            r115.width = r114;
            r115.height = r114;
            r112.f218740a.setLayoutParams(r115);
        L28:
            int r116 = CitationViewHolder.a.f218746a[r108.ordinal()];
            if (r116 != 1) goto L31;
            r107 = r112.T3(R.drawable.ud_icon_chat_filled, R.drawable.ud_icon_chat_outlined);
        L35:
            if (r107 == null) goto L37;
            r112.f218740a.setImageDrawable(r107);
            r112.f218740a.clearColorFilter();
        L38:
            if (r107 == null) goto L40;
        L42:
            r112.f218740a.clearColorFilter();
        L43:
            r112.itemView.setOnClickListener(new com.bytedance.ee.bear.document.ai.citation.a(r100, r112.f218745f));
            View r117 = r112.f218742c;
            if (r113 == false) goto L46;
            r101 = 4;
        L46:
            r117.setVisibility(r101);
            return;
        L40:
            if (r108.getColorFilter() == (-1)) goto L42;
            r112.f218740a.setColorFilter(ContextCompat.getColor(r112.itemView.getContext(), r108.getColorFilter()));
            goto L43
        L37:
            r112.f218740a.setImageResource(kac.a.b(r108.getResId()));
            goto L38
        L31:
            if (r116 != 2) goto L35;
            r107 = r112.T3(R.drawable.ud_icon_add_comment_filled, R.drawable.ud_icon_add_comment_outlined);
            goto L35
        L26:
            if (r115.height == r114) goto L28;
        L22:
            r114 = ((Number) r112.f218743d.getValue()).intValue();
            goto L23
        L12:
            r109 = false;
            goto L13
        L16:
            r108 = null;
            goto L17
        L5:
            r113 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.citation_item_layout, r100, false);
            DocAICitationFragment r103 = this.f218739b;
            Intrinsics.checkNotNull(r102);
            return new CitationViewHolder(r103, r102);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment$CitationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationFragment;Landroid/view/View;)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "titleView", "Landroid/widget/TextView;", "dividerView", "defaultIconSize", "", "getDefaultIconSize", "()I", "defaultIconSize$delegate", "Lkotlin/Lazy;", "helpdeskIconSize", "getHelpdeskIconSize", "helpdeskIconSize$delegate", "bind", "", "citation", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "isLastItem", "", "updateIconSize", "citationRefType", "Lcom/bytedance/ee/bear/document/ai/citation/DocCitationRefType;", "createSpecialCitationIcon", "Landroid/graphics/drawable/Drawable;", "createTwoToneIconDrawable", "showIconResId", "bgIconResId", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CitationViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f218740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f218741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f218742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f218743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Lazy f218744e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ DocAICitationFragment f218745f;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f218746a = null;

            static {
                int[] r100 = new int[DocCitationRefType.values().length];
                r100[DocCitationRefType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[DocCitationRefType.COMMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f218746a = r100;
            }
        }

        public CitationViewHolder(DocAICitationFragment r100, final View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f218745f = r100;
            super(r101);
            this.f218740a = (AppCompatImageView) r101.findViewById(R.id.citation_iv_icon);
            this.f218741b = (TextView) r101.findViewById(R.id.citation_tv_title);
            this.f218742c = r101.findViewById(R.id.citation_item_divider);
            this.f218743d = LazyKt.lazy(new DocAICitationFragment$CitationViewHolder$defaultIconSize$2(r101));
            this.f218744e = LazyKt.lazy(new DocAICitationFragment$CitationViewHolder$helpdeskIconSize$2(r101));
        }

        public final Drawable T3(int r100, int r101) {
            Context r102 = this.itemView.getContext();
            Drawable r103 = AppCompatResources.getDrawable(r102, kac.a.b(r100));
            if (r103 == null) goto L15;
            Drawable r104 = r103.mutate();
            if (r104 == null) goto L17;
            DrawableCompat.setTint(r104, ContextCompat.getColor(r102, R.color.colorful_blue));
            Drawable r105 = AppCompatResources.getDrawable(r102, kac.a.b(r101));
            if (r105 == null) goto L14;
            Drawable r106 = r105.mutate();
            if (r106 == null) goto L14;
            DrawableCompat.setTint(r106, ContextCompat.getColor(r102, R.color.static_white));
            return new LayerDrawable(new Drawable[]{r106, r104});
        L14:
            return r104;
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
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r100 == null) goto L16;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L16
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Log.i("DocAICitationFragment", "onDestroyView");
        ShowCitationData r100 = this.f218737q;
        if (r100 == null) goto L8;
        String r101 = DocAICitationClickType.Close.getType();
        String r102 = r100.getId();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        fa0(r101, r102);
    L8:
        super.onDestroyView();
    }

    public final void da0() {
        super.onStart();
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        if (ku5.c.k(r100) == false) goto L21;
        Dialog r101 = getDialog();
        if (r101 == null) goto L11;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L11;
        r102.setLayout(-2, -2);
        r102.setGravity(17);
    L11:
        Dialog r103 = getDialog();
        if (r103 == null) goto L16;
        View r104 = r103.findViewById(R.id.design_bottom_sheet);
        if (r104 == null) goto L16;
        r104.setBackground(new ColorDrawable(0));
    L16:
        View r105 = getView();
        if (r105 == null) goto L31;
        View r106 = r105.findViewById(R.id.drag_handle);
        if (r106 == null) goto L32;
        r106.setVisibility(8);
        return;
    L32:
        return;
    L31:
        return;
    L21:
        View r107 = getView();
        if (r107 == null) goto L27;
        View r108 = r107.findViewById(R.id.drag_handle);
        if (r108 == null) goto L27;
        r108.setVisibility(0);
    L27:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L34;
        Dialog r109 = getDialog();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior r110 = ((BottomSheetDialog) r109).getBehavior();
        r110.setState(3);
        r110.setSkipCollapsed(true);
        r110.setHideable(true);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        da0();
    }

    public DocAICitationFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L7;
        ShowCitationData r102 = (ShowCitationData) r101.getParcelable("extra_data");
        if (r102 == null) goto L7;
        this.f218737q = r102;
    L7:
        setStyle(0, getTheme());
    }

    public final void fa0(String r100, String r101) {
        DocAICitationViewModel r102 = this.f218731k;
        DocAICitationCallbackBridgeViewModel r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L5:
        Pair<String, String> r104 = r102.buildCallbackEvent(r100, r101);
        if (r104 == null) goto L13;
        Log.i("DocAICitationFragment", "emitCallbackResult: " + r104);
        DocAICitationCallbackBridgeViewModel r105 = this.f218732l;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("callbackBridgeViewModel");
    L11:
        r103.emit(r104.getFirst(), r104.getSecond());
        return;
    L10:
        r103 = r105;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = getContext();
        if (r102 != null) goto L5;
    L8:
        this.f218734n = (TextView) r100.findViewById(R.id.tv_title);
        this.f218735o = (ImageView) r100.findViewById(R.id.btn_delete);
        this.f218736p = (MaxHeightRecyclerView) r100.findViewById(R.id.rv_citations);
        Context r103 = getContext();
        if (r103 == null) goto L13;
        Resources r104 = r103.getResources();
        int r105 = (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels / 2) - getResources().getDimensionPixelSize(R.dimen.dp_46);
        MaxHeightRecyclerView r106 = this.f218736p;
        if (r106 == null) goto L13;
        r106.setMaxHeight(r105);
    L13:
        this.f218733m = new CitationAdapter(this);
        MaxHeightRecyclerView r107 = this.f218736p;
        if (r107 == null) goto L16;
        r107.setLayoutManager(new LinearLayoutManager(getContext()));
    L16:
        MaxHeightRecyclerView r108 = this.f218736p;
        DocAICitationViewModel r109 = null;
        if (r108 == null) goto L22;
        CitationAdapter r110 = this.f218733m;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r110 = null;
    L21:
        r108.setAdapter(r110);
    L22:
        ImageView r111 = this.f218735o;
        if (r111 == null) goto L25;
        r111.setOnClickListener(new b(this));
    L25:
        this.f218731k = (DocAICitationViewModel) new ViewModelProvider(this).get(DocAICitationViewModel.class);
        this.f218732l = (DocAICitationCallbackBridgeViewModel) new ViewModelProvider(requireActivity()).get(DocAICitationCallbackBridgeViewModel.class);
        DocAICitationViewModel r112 = this.f218731k;
        if (r112 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r112 = null;
    L28:
        r112.getCitationData().observe(getViewLifecycleOwner(), new c(this));
        DocAICitationViewModel r113 = this.f218731k;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r113 = null;
    L31:
        r113.getUiEvent().observe(getViewLifecycleOwner(), new d(this));
        ShowCitationData r114 = this.f218737q;
        if (r114 == null) goto L39;
        DocAICitationViewModel r115 = this.f218731k;
        if (r115 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r109.updateData(r114);
        return;
    L36:
        r109 = r115;
        goto L37
    L39:
        return;
    L5:
        if (ku5.c.k(r102) == false) goto L7;
        r100.setBackground(ContextCompat.getDrawable(r102, R.drawable.docs_bg_round_conner_color_bg_float));
        goto L8
    L7:
        r100.setBackground(ContextCompat.getDrawable(r102, R.drawable.docs_citation_bg_top_round_conner_color_bg));
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.citation_fragment_layout, r101, false);
    }
}
