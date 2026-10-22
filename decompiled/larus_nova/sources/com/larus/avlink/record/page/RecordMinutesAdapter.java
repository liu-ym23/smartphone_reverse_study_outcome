package com.larus.avlink.record.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.impl.databinding.LayoutRecordHistoryItemBinding;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/record/page/RecordMinutesAdapter$RecordMinutesViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "", "onItemDeleteClick", "onItemUploadClick", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "recordHistoryList", "", "currentDeleteLayoutHolder", "hideCurrentDeleteLayout", "", "hasDeleteLayoutShowing", "updateRecordMinutesResult", MapController.ITEM_LAYER_TAG, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "onViewRecycled", "RecordMinutesViewHolder", "RecordMinutesDiffCallback", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesAdapter extends RecyclerView.Adapter<RecordMinutesViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f294149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<i0, Unit> f294150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<i0, Unit> f294151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<i0, Unit> f294152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<i0> f294153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecordMinutesViewHolder f294154f;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesAdapter$RecordMinutesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordHistoryItemBinding;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "", "onItemDeleteClick", "onItemUploadClick", "<init>", "(Landroid/content/Context;Lcom/larus/avlink/impl/databinding/LayoutRecordHistoryItemBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "currentPopup", "Lcom/larus/avlink/record/page/RecordDeletePopupWindow;", "bindView", MapController.ITEM_LAYER_TAG, "bindUploadView", "hideDeleteLayout", "isFullyVisible", "", "view", "Landroid/view/View;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordMinutesViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f294155g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f294156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutRecordHistoryItemBinding f294157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<i0, Unit> f294158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<i0, Unit> f294159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<i0, Unit> f294160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g f294161f;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f294162a = null;

            static {
                int[] r100 = new int[TagType.values().length];
                r100[TagType.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[TagType.OFFLINE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[TagType.CONVERTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[TagType.OFFLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f294162a = r100;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RecordMinutesViewHolder(Context r100, LayoutRecordHistoryItemBinding r101, Function1<? super i0, Unit> r102, Function1<? super i0, Unit> r103, Function1<? super i0, Unit> r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "binding");
            Intrinsics.checkNotNullParameter(r102, "onItemClick");
            Intrinsics.checkNotNullParameter(r103, "onItemDeleteClick");
            Intrinsics.checkNotNullParameter(r104, "onItemUploadClick");
            super(r101.f293326a);
            this.f294156a = r100;
            this.f294157b = r101;
            this.f294158c = r102;
            this.f294159d = r103;
            this.f294160e = r104;
        }
    }

    public static final class a extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<i0> f294163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<i0> f294164b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f294164b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f294163a.size();
        }

        public a(List<i0> r100, List<i0> r101) {
            Intrinsics.checkNotNullParameter(r100, "oldList");
            Intrinsics.checkNotNullParameter(r101, "newList");
            this.f294163a = r100;
            this.f294164b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            return Intrinsics.areEqual(ListProtector.get(this.f294163a, r100), ListProtector.get(this.f294164b, r101));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            return Intrinsics.areEqual(((i0) ListProtector.get(this.f294163a, r100)).f294246a, ((i0) ListProtector.get(this.f294164b, r101)).f294246a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f294153e.size();
    }

    public final void y2() {
        RecordMinutesViewHolder r100 = this.f294154f;
        if (r100 == null) goto L12;
        g r101 = r100.f294161f;
        if (r101 == null) goto L10;
        PopupWindow r102 = r101.f294235e;
        if (r102 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
    L9:
        r101.f294235e = null;
    L10:
        r100.f294161f = null;
        this.f294154f = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        RecordMinutesViewHolder r101 = (RecordMinutesViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        if (Intrinsics.areEqual(r101, this.f294154f) == false) goto L12;
        g r102 = r101.f294161f;
        if (r102 == null) goto L10;
        PopupWindow r103 = r102.f294235e;
        if (r103 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
    L9:
        r102.f294235e = null;
    L10:
        r101.f294161f = null;
        this.f294154f = null;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final RecordMinutesViewHolder r101 = (RecordMinutesViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (Intrinsics.areEqual(r101, this.f294154f) == false) goto L5;
        this.f294154f = null;
    L5:
        final i0 r111 = (i0) ListProtector.get(this.f294153e, r110);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        g r102 = r101.f294161f;
        if (r102 == null) goto L11;
        PopupWindow r103 = r102.f294235e;
        if (r103 == null) goto L10;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
    L10:
        r102.f294235e = null;
    L11:
        r101.f294161f = null;
        r101.f294157b.f293331f.setText(r111.f294247b);
        TagType r104 = r111.f294249d;
        boolean r105 = true;
        if (r104 == null) goto L27;
        r101.f294157b.f293329d.setVisibility(0);
        int r106 = RecordMinutesViewHolder.a.f294162a[r104.ordinal()];
        if (r106 != 1) goto L16;
        r101.f294157b.f293329d.setTextColor(r101.f294156a.getResources().getColor(R.color.danger_50));
        r101.f294157b.f293329d.setBackground(AppCompatResources.getDrawable(r101.f294156a, R.drawable.bg_recording));
        r101.f294157b.f293329d.setText(r101.f294156a.getString(R.string.larus_dora_g_record_minutes_status_recording_cn));
    L29:
        if (r111.f294249d == TagType.OFFLINE) goto L31;
    L45:
        r101.f294157b.f293332g.setVisibility(8);
    L46:
        String r107 = r111.f294248c;
        if (r107 != null) goto L49;
    L52:
        boolean r108 = true;
    L53:
        if (r108 == false) goto L55;
        r101.f294157b.f293328c.setVisibility(8);
    L56:
        String r109 = r111.f294250e;
        if (r109 != null) goto L59;
    L62:
        if (r105 == false) goto L64;
        r101.f294157b.f293330e.setVisibility(8);
    L65:
        r101.f294157b.f293326a.setOnClickListener(new h(r101, r111));
        r101.f294157b.f293326a.setOnLongClickListener(new i(r101, r111));
        return;
    L64:
        r101.f294157b.f293330e.setVisibility(0);
        r101.f294157b.f293330e.setText(r111.f294250e);
        goto L65
    L59:
        if (r109.length() == 0) goto L62;
        r105 = false;
        goto L62
    L55:
        r101.f294157b.f293328c.setVisibility(0);
        r101.f294157b.f293328c.setText(r111.f294248c);
        goto L56
    L49:
        if (r107.length() == 0) goto L52;
        r108 = false;
        goto L53
    L31:
        if (Intrinsics.areEqual(r111.f294253h, 1.0f) == true) goto L45;
        r101.f294157b.f293332g.setVisibility(0);
        if (r111.f294253h == null) goto L36;
        boolean r112 = true;
    L37:
        if (r112 == false) goto L43;
        r101.f294157b.f293333h.setVisibility(8);
        r101.f294157b.f293334i.setVisibility(0);
        UploadProgressView r113 = r101.f294157b.f293334i;
        Float r114 = r111.f294253h;
        if (r114 == null) goto L41;
        float r115 = r114.floatValue();
    L42:
        r113.setProgress(r115);
    L44:
        r101.f294157b.f293332g.setOnClickListener(new j(r111, r101));
        goto L46
    L41:
        r115 = 0.0f;
        goto L42
    L43:
        r101.f294157b.f293334i.setVisibility(8);
        r101.f294157b.f293333h.setVisibility(0);
        goto L44
    L36:
        r112 = false;
        goto L37
    L16:
        if (r106 != 2) goto L18;
        r101.f294157b.f293329d.setTextColor(r101.f294156a.getResources().getColor(R.color.danger_50));
        r101.f294157b.f293329d.setBackground(AppCompatResources.getDrawable(r101.f294156a, R.drawable.bg_recording));
        r101.f294157b.f293329d.setText(r101.f294156a.getString(R.string.larus_dora_g_record_minutes_status_recording_cn));
        goto L29
    L18:
        if (r106 != 3) goto L20;
        r101.f294157b.f293329d.setTextColor(r101.f294156a.getResources().getColor(R.color.neutral_100));
        r101.f294157b.f293329d.setBackground(AppCompatResources.getDrawable(r101.f294156a, R.drawable.bg_converting));
        r101.f294157b.f293329d.setText(r101.f294156a.getString(R.string.larus_dora_g_record_minutes_status_processing_cn));
        goto L29
    L20:
        if (r106 != 4) goto L23;
        r101.f294157b.f293329d.setTextColor(r101.f294156a.getResources().getColor(R.color.neutral_100));
        r101.f294157b.f293329d.setBackground(AppCompatResources.getDrawable(r101.f294156a, R.drawable.bg_converting));
        r101.f294157b.f293329d.setText(r101.f294156a.getString(R.string.larus_dora_ai_active_record_upload_pending_cn));
        goto L29
    L23:
        throw new NoWhenBranchMatchedException();
    L27:
        r101.f294157b.f293329d.setVisibility(8);
        goto L29
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r100 = LayoutInflater.from(this.f294149a).inflate(R.layout.layout_record_history_item, r210, false);
        int r101 = R.id.bottom_divider;
        View r102 = ViewBindings.findChildViewById(r100, R.id.bottom_divider);
        if (r102 == null) goto L21;
        r101 = R.id.content_summary;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.content_summary);
        if (r103 == null) goto L21;
        r101 = R.id.tag;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.tag);
        if (r104 == null) goto L21;
        r101 = R.id.time_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.time_text);
        if (r105 == null) goto L21;
        r101 = R.id.title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r106 == null) goto L21;
        r101 = R.id.upload_container;
        FrameLayout r110 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.upload_container);
        if (r110 == null) goto L21;
        r101 = R.id.upload_icon;
        ImageView r111 = (ImageView) ViewBindings.findChildViewById(r100, R.id.upload_icon);
        if (r111 == null) goto L21;
        r101 = R.id.upload_progress;
        UploadProgressView r112 = (UploadProgressView) ViewBindings.findChildViewById(r100, R.id.upload_progress);
        if (r112 == null) goto L21;
        LayoutRecordHistoryItemBinding r113 = new LayoutRecordHistoryItemBinding((ConstraintLayout) r100, r102, r103, r104, r105, r106, r110, r111, r112);
        return new RecordMinutesViewHolder(this.f294149a, r113, this.f294150b, this.f294151c, this.f294152d);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public RecordMinutesAdapter(Context r100, p r101, q r102, r r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onItemClick");
        Intrinsics.checkNotNullParameter(r102, "onItemDeleteClick");
        Intrinsics.checkNotNullParameter(r103, "onItemUploadClick");
        this.f294149a = r100;
        this.f294150b = r101;
        this.f294151c = r102;
        this.f294152d = r103;
        this.f294153e = CollectionsKt.emptyList();
    }
}
