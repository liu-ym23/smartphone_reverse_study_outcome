package com.larus.uaigc.instruction.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageListPlaceHolderBinding;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageSelectorHolderBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vz9.d;
import vz9.h;
import vz9.i;
import vz9.j;
import vz9.k;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004*+,-B,\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0010J\u001e\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J&\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "headerViewDsl", "Lkotlin/Function1;", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter$HeaderComponentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "headerComponentBuilder", "headerComponent", "Lcom/larus/uaigc/instruction/widget/HeaderComponent;", "offset", "", "dataList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getItemCount", "getItem", "position", "refreshData", "data", "calDiff", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "isForceDisableGifAnim", "onBindViewHolder", "holder", "payloads", "", "", "getItemViewType", "Companion", "HeaderComponentBuilder", "DiffCallback", "ChangePayload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSelectorWithMoreWidgetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<JSONObject> f373457e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f373458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.uaigc.instruction.widget.b f373459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f373460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<w> f373461d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "newItems", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<w> f373462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<w> f373463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageSelectorWithMoreWidgetAdapter f373464c;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f373463b.size() + this.f373464c.f373460c;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f373462a.size() + this.f373464c.f373460c;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            int r102 = this.f373464c.f373460c;
            if (r100 < r102) goto L24;
            if (r101 < r102) goto L24;
            int r103 = r100 - r102;
            int r104 = r101 - r102;
            g1 r105 = ((w) ListProtector.get(this.f373462a, r103)).f295515f;
            String r106 = null;
            if (r105 == null) goto L9;
            String r107 = r105.f295156b;
        L10:
            g1 r108 = ((w) ListProtector.get(this.f373463b, r104)).f295515f;
            if (r108 == null) goto L14;
            r106 = r108.f295156b;
        L14:
            if (Intrinsics.areEqual(r107, r106) == true) goto L16;
        L22:
            return false;
        L16:
            if (Intrinsics.areEqual(((w) ListProtector.get(this.f373462a, r103)).f295511b, ((w) ListProtector.get(this.f373463b, r104)).f295511b) == false) goto L22;
            if (Intrinsics.areEqual(((w) ListProtector.get(this.f373462a, r103)).f295513d, ((w) ListProtector.get(this.f373463b, r104)).f295513d) == false) goto L22;
            if (Intrinsics.areEqual(((w) ListProtector.get(this.f373462a, r103)).f295528s, ((w) ListProtector.get(this.f373463b, r104)).f295528s) == false) goto L22;
            return true;
        L9:
            r107 = null;
        L24:
            if (r100 == r101) goto L29;
            return false;
        L29:
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            int r102 = this.f373464c.f373460c;
            if (r100 >= r102) goto L9;
            if (r101 >= r102) goto L9;
            if (r100 == r101) goto L17;
            return false;
        L17:
            return true;
        L9:
            if (r100 < r102) goto L16;
            if (r101 < r102) goto L16;
            if (((w) ListProtector.get(this.f373462a, r100 - r102)).getType() == ((w) ListProtector.get(this.f373463b, r101 - this.f373464c.f373460c)).getType()) goto L18;
            return false;
        L18:
            return true;
        L16:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            int r102 = this.f373464c.f373460c;
            if (r100 < r102) goto L22;
            if (r101 < r102) goto L22;
            w r103 = (w) ListProtector.get(this.f373463b, r101 - r102);
            w r104 = (w) ListProtector.get(this.f373462a, r100 - this.f373464c.f373460c);
            g1 r105 = r104.f295515f;
            if (r105 == null) goto L9;
            String r106 = r105.f295156b;
        L10:
            g1 r107 = r103.f295515f;
            if (r107 == null) goto L13;
            String r108 = r107.f295156b;
        L15:
            if (Intrinsics.areEqual(r106, r108) == false) goto L22;
            if (Intrinsics.areEqual(r104.f295511b, r103.f295511b) == false) goto L22;
            if (Intrinsics.areEqual(r104.f295513d, r103.f295513d) == false) goto L22;
            return new i();
        L13:
            r108 = null;
            goto L15
        L9:
            r106 = null;
        L22:
            return null;
        }

        public DiffCallback(ImageSelectorWithMoreWidgetAdapter r100, List<w> r101, List<w> r102) {
            Intrinsics.checkNotNullParameter(r101, "oldItems");
            Intrinsics.checkNotNullParameter(r102, "newItems");
            this.f373464c = r100;
            this.f373462a = r101;
            this.f373463b = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super ViewGroup, ? extends View> f373465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f373466b;

        public b() {
            this.f373465a = new j();
            this.f373466b = new k();
        }
    }

    static {
        f373457e = LazyKt.lazy(new h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f373461d.size() + this.f373460c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int r101 = this.f373460c;
        if (r100 >= r101) goto L6;
        return 1;
    L6:
        if (((w) ListProtector.get(this.f373461d, r100 - r101)).getType() != 4) goto L8;
        return 2;
    L8:
        return 0;
    }

    public ImageSelectorWithMoreWidgetAdapter(d r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f373458a = r100;
        b r102 = new b();
        this.f373461d = CollectionsKt.emptyList();
        if (r101 == null) goto L6;
        r101.invoke(r102);
        this.f373459b = new com.larus.uaigc.instruction.widget.b(r102);
    L6:
        if (this.f373459b == null) goto L8;
        int r103 = 1;
    L9:
        this.f373460c = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof HeaderViewHolder) == false) goto L8;
        com.larus.uaigc.instruction.widget.b r102 = this.f373459b;
        if (r102 == null) goto L11;
        HeaderViewHolder r103 = (HeaderViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        r102.f373468a.f373466b.invoke(r103);
        return;
    L11:
        return;
    L8:
        if ((r100 instanceof ImageSelectorHolder) == false) goto L13;
        ((ImageSelectorHolder) r100).T3((w) ListProtector.get(this.f373461d, r101 - this.f373460c));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        boolean r102 = true;
        if (r101 != 1) goto L5;
        com.larus.uaigc.instruction.widget.b r103 = this.f373459b;
        if (r103 == null) goto L37;
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r104 = r103.f373468a.f373465a.invoke(r100);
        if (r104 == null) goto L37;
    L39:
        return new HeaderViewHolder(r104);
    L37:
        r104 = new View(r100.getContext());
        goto L39
    L5:
        if (r101 != 2) goto L40;
        View r105 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_uaigc_item_actionbar_image_list_place_holder, r100, false);
        View r106 = ViewBindings.findChildViewById(r105, R.id.light);
        if (r106 == null) goto L32;
        return new ImagePlaceHolder(new LarusUaigcItemActionbarImageListPlaceHolderBinding((RoundFrameLayout) r105, r106));
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(R.id.light)));
    L40:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r108 = f373457e.getValue();     // Catch: Throwable -> L13
        if (r108 == null) goto L10;
        double r109 = r108.optDouble("cpu_score");     // Catch: Throwable -> L13
    L11:
        Object r110 = Result.m9449constructorimpl(Double.valueOf(r109));     // Catch: Throwable -> L13
    L16:
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L19;
        r110 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L19:
        double r111 = ((Number) r110).doubleValue();
        Double r112 = z2.f365865a.getVideoStyleAnimConfig().a();
        if (r112 == null) goto L22;
        double r113 = r112.doubleValue();
    L24:
        if (r111 < r113) goto L42;
        r102 = false;
    L42:
        return new ImageSelectorHolder(LarusUaigcItemActionbarImageSelectorHolderBinding.a(LayoutInflater.from(r100.getContext()), r100).f373259a, this.f373458a, r102);
    L22:
        r113 = 8.0d;
        goto L24
    L10:
        r109 = 0.0d;
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void y2(List<w> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        List<w> r112 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r113 = r112.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        r100.add(w.a((w) r113.next(), null, null, null, null, null, null, 8388607));
        goto L4
    L6:
        if (r111 == false) goto L8;
        DiffUtil.DiffResult r114 = DiffUtil.calculateDiff(new DiffCallback(this, this.f373461d, r100), false);
        this.f373461d = r100;
        r114.dispatchUpdatesTo(this);
        return;
    L8:
        this.f373461d = r100;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        onBindViewHolder(r100, r101);
    }
}
