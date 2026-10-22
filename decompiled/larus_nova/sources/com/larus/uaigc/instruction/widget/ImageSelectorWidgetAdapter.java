package com.larus.uaigc.instruction.widget;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageSelectorHolderBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vz9.d;
import vz9.e;
import vz9.f;
import vz9.g;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004()*+B,\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J&\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;", "headerViewDsl", "Lkotlin/Function1;", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter$HeaderComponentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorHolderCallback;Lkotlin/jvm/functions/Function1;)V", "headerComponentBuilder", "headerComponent", "Lcom/larus/uaigc/instruction/widget/HeaderComponent;", "dataList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "offset", "", "getItemCount", "currentList", "getCurrentList", "()Ljava/util/List;", "submitList", "data", "getItem", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "getItemViewType", "Companion", "HeaderComponentBuilder", "DiffCallback", "ChangePayload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSelectorWidgetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f373447e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f373448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.uaigc.instruction.widget.a f373449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<w> f373450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f373451d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "newItems", "<init>", "(Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<w> f373452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<w> f373453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageSelectorWidgetAdapter f373454c;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f373453b.size() + this.f373454c.f373451d;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f373452a.size() + this.f373454c.f373451d;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            int r102 = this.f373454c.f373451d;
            boolean r103 = true;
            if (r100 < r102) goto L25;
            if (r101 < r102) goto L25;
            int r104 = ImageSelectorWidgetAdapter.f373447e;
            w r105 = (w) ListProtector.get(this.f373452a, r100 - r102);
            w r106 = (w) ListProtector.get(this.f373453b, r101 - this.f373454c.f373451d);
            if (Intrinsics.areEqual(r105.f295511b, r106.f295511b) == true) goto L9;
        L22:
            r103 = false;
        L23:
            FLogger.f375446a.i("ImageSelectorWidgetAdapter", "result is " + r103 + " , oldItem is " + r105.f295511b + " newItem is " + r106.f295511b);
            return r103;
        L9:
            if (Intrinsics.areEqual(r105.f295513d, r106.f295513d) == false) goto L22;
            g1 r107 = r105.f295515f;
            String r108 = null;
            if (r107 == null) goto L13;
            String r109 = r107.f295156b;
        L14:
            g1 r110 = r106.f295515f;
            if (r110 == null) goto L18;
            r108 = r110.f295156b;
        L18:
            if (Intrinsics.areEqual(r109, r108) == false) goto L22;
            if (Intrinsics.areEqual(r105.f295528s, r106.f295528s) == false) goto L22;
        L13:
            r109 = null;
        L25:
            if (r100 == r101) goto L29;
            return false;
        L29:
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            int r102 = this.f373454c.f373451d;
            if (r100 >= r102) goto L8;
            if (r101 >= r102) goto L8;
            if (r100 != r101) goto L13;
            return true;
        L13:
            return false;
        L8:
            if (r100 < r102) goto L12;
            if (r101 < r102) goto L12;
            int r103 = ImageSelectorWidgetAdapter.f373447e;
            w r104 = (w) ListProtector.get(this.f373452a, r100 - r102);
            w r105 = (w) ListProtector.get(this.f373453b, r101 - this.f373454c.f373451d);
            return Intrinsics.areEqual(r104.f295510a, r105.f295510a);
        L12:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            int r102 = this.f373454c.f373451d;
            if (r100 < r102) goto L24;
            if (r101 < r102) goto L29;
            int r103 = ImageSelectorWidgetAdapter.f373447e;
            w r104 = (w) ListProtector.get(this.f373452a, r100 - r102);
            w r105 = (w) ListProtector.get(this.f373453b, r101 - this.f373454c.f373451d);
            if (Intrinsics.areEqual(r104.f295511b, r105.f295511b) == true) goto L9;
            return null;
        L9:
            if (Intrinsics.areEqual(r104.f295513d, r105.f295513d) == false) goto L26;
            g1 r106 = r104.f295515f;
            if (r106 == null) goto L13;
            String r107 = r106.f295156b;
        L14:
            g1 r108 = r105.f295515f;
            if (r108 == null) goto L17;
            String r109 = r108.f295156b;
        L19:
            if (Intrinsics.areEqual(r107, r109) == true) goto L21;
            return null;
        L21:
            if (Intrinsics.areEqual(r104.f295528s, r105.f295528s) == false) goto L23;
            return null;
        L23:
            return new e(r105.f295528s);
        L17:
            r109 = null;
            goto L19
        L13:
            r107 = null;
            goto L14
        L26:
            return null;
        L29:
            return null;
        L24:
            return null;
        }

        public DiffCallback(ImageSelectorWidgetAdapter r100, List<w> r101, List<w> r102) {
            Intrinsics.checkNotNullParameter(r101, "oldItems");
            Intrinsics.checkNotNullParameter(r102, "newItems");
            this.f373454c = r100;
            this.f373452a = r101;
            this.f373453b = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function1<? super ViewGroup, ? extends View> f373455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super HeaderViewHolder, Unit> f373456b;

        public b() {
            this.f373455a = new f();
            this.f373456b = new g();
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f373450c.size() + this.f373451d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= this.f373451d) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        if ((r100 instanceof ImageSelectorHolder) == false) goto L5;
        ImageSelectorHolder r101 = (ImageSelectorHolder) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f373441c == false) goto L11;
        return;
    L11:
        if (r101.U3() == true) goto L13;
        return;
    L13:
        if (r101.f373441c == true) goto L23;
        Animatable r102 = r101.f373445g;
        if (r102 == null) goto L21;
        r102.start();
        return;
    L21:
        return;
    L23:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewDetachedFromWindow(r100);
        if ((r100 instanceof ImageSelectorHolder) == false) goto L5;
        ImageSelectorHolder r101 = (ImageSelectorHolder) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f373441c == true) goto L13;
        r101.V3();
        return;
    L13:
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, java.util.List<com.larus.bmhome.actionbar.model.w>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    public final void submitList(List<w> r110) {
        if (r110 == null) goto L7;
        List<w> r111 = r110;
        ?? r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L5:
        if (r112.hasNext() == false) goto L8;
        r100.add(w.a((w) r112.next(), null, null, null, null, null, null, 8388607));
    L8:
        DiffUtil.DiffResult r113 = DiffUtil.calculateDiff(new DiffCallback(this, this.f373450c, r100), false);
        this.f373450c = r100;
        r113.dispatchUpdatesTo(this);
        return;
    L7:
        r100 = CollectionsKt.emptyList();
        goto L8
    }

    public ImageSelectorWidgetAdapter(d r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f373448a = r100;
        b r102 = new b();
        this.f373450c = CollectionsKt.emptyList();
        if (r101 == null) goto L6;
        r101.invoke(r102);
        this.f373449b = new com.larus.uaigc.instruction.widget.a(r102);
    L6:
        if (this.f373449b == null) goto L8;
        int r103 = 1;
    L9:
        this.f373451d = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof HeaderViewHolder) == false) goto L8;
        com.larus.uaigc.instruction.widget.a r102 = this.f373449b;
        if (r102 == null) goto L11;
        HeaderViewHolder r103 = (HeaderViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        r102.f373467a.f373456b.invoke(r103);
        return;
    L11:
        return;
    L8:
        if ((r100 instanceof ImageSelectorHolder) == false) goto L13;
        ((ImageSelectorHolder) r100).T3((w) ListProtector.get(this.f373450c, r101 - this.f373451d));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L11;
        com.larus.uaigc.instruction.widget.a r102 = this.f373449b;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r103 = r102.f373467a.f373455a.invoke(r100);
        if (r103 == null) goto L8;
    L12:
        return new HeaderViewHolder(r103);
    L8:
        r103 = new View(r100.getContext());
        goto L12
    L11:
        return new ImageSelectorHolder(LarusUaigcItemActionbarImageSelectorHolderBinding.a(LayoutInflater.from(r100.getContext()), r100).f373259a, this.f373448a, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        Object r103 = CollectionsKt.firstOrNull(r102);
        if ((r103 instanceof e) == false) goto L5;
        e r104 = (e) r103;
    L7:
        if ((r100 instanceof ImageSelectorHolder) == false) goto L21;
        if (r104 == null) goto L21;
        ImageSelectorHolder r105 = (ImageSelectorHolder) r100;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, WsConstants.KEY_PAYLOAD);
        Integer r106 = r104.f557755a;
        if (r106 != null) goto L13;
    L15:
        if (r106 != null) goto L18;
        return;
    L18:
        if (r106.intValue() != 1) goto L24;
        e1.x(r105.f373444f);
        return;
    L24:
        return;
    L13:
        if (r106.intValue() != 0) goto L15;
        e1.o(r105.f373444f);
        return;
    L21:
        onBindViewHolder(r100, r101);
        return;
    L5:
        r104 = null;
        goto L7
    }
}
