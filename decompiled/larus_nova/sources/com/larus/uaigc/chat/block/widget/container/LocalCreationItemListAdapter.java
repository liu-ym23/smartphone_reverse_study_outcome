package com.larus.uaigc.chat.block.widget.container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.uaigc.chat.block.create.horizontal.n;
import com.larus.uaigc.chat.block.create.horizontal.o;
import com.larus.uaigc.chat.block.create.horizontal.p;
import com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder;
import com.larus.uaigc.chat.block.widget.video.LocalVideoItemViewHolder;
import com.larus.uaigc.chat.markdown.image.component.k;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.larus.uaigc.impl.databinding.LarusWidgetCreationBlockVideoItemBinding;
import cz9.l;
import java.util.List;
import java.util.Map;
import kc8.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:Bê\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012/\u0010\u000b\u001a+\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0015\u0012\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u0015\u0012\u001e\u0010\u0018\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019\u00122\u0010\u001d\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0015¢\u0006\u0004\b \u0010!J\u0014\u0010)\u001a\u00020\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0%J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,H\u0016J\u0018\u00102\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020,H\u0016J\u0018\u00107\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016J&\u00107\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001c09H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a+\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R<\u0010\u001d\u001a.\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R*\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0%2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "imageEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;", "videoEditorDepend", "Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;", "createBlockConfig", "Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;", "clickListener", "Lkotlin/Function3;", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "Lcom/larus/uaigc/bean/chat/VideoPlayParams;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "longClickListenerBinder", "Lkotlin/Function2;", "onExpose", "", "messageGetter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/larus/im/bean/message/Message;", "", "commonParamGetter", "", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/larus/uaigc/chat/markdown/image/component/ImageEditorDependency;Lcom/larus/uaigc/chat/markdown/image/component/VideoEditorDependency;Lcom/larus/bmhome/chat/block/base/config/CreateBlockConfig;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "refreshData", "data", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "reportItemExposure", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "onViewRecycled", "holder", "getItemCount", "onBindViewHolder", "payloads", "", "DiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalCreationItemListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f370596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.uaigc.chat.markdown.image.component.a f370597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f370598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f370599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<cz9.b, iy9.b, View, Unit> f370600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<cz9.b, View, Unit> f370601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<cz9.b, Float, Unit> f370602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Continuation<? super Message>, Object> f370603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> f370604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends cz9.b> f370605j;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/chat/block/widget/container/LocalCreationItemListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/uaigc/chat/block/widget/CreationItemData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<cz9.b> f370606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<cz9.b> f370607b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f370607b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f370606a.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DiffCallback(List<? extends cz9.b> r100, List<? extends cz9.b> r101) {
            Intrinsics.checkNotNullParameter(r100, "oldItems");
            Intrinsics.checkNotNullParameter(r101, "newItems");
            this.f370606a = r100;
            this.f370607b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            return ((cz9.b) ListProtector.get(this.f370606a, r100)).d((cz9.b) ListProtector.get(this.f370607b, r101));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            if (r100 == r101) goto L4;
        L6:
            return false;
        L4:
            if (((cz9.b) ListProtector.get(this.f370606a, r100)).getViewType() != ((cz9.b) ListProtector.get(this.f370607b, r101)).getViewType()) goto L6;
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            return ((cz9.b) ListProtector.get(this.f370606a, r100)).c((cz9.b) ListProtector.get(this.f370607b, r101));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f370605j.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        cz9.b r101 = (cz9.b) CollectionsKt.getOrNull(this.f370605j, r100);
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewRecycled(r100);
        ExposureTrackerExtKt.c(r100.itemView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        cz9.b r102 = (cz9.b) CollectionsKt.getOrNull(this.f370605j, r101);
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof cz9.g) == false) goto L8;
        cz9.g r103 = (cz9.g) r100;
    L9:
        if (r103 == null) goto L12;
        r103.p2(r102);
        return;
    L12:
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        if (r111 != 2) goto L5;
        final LarusWidgetCreationBlockVideoItemBinding r100 = LarusWidgetCreationBlockVideoItemBinding.a(LayoutInflater.from(r110.getContext()), r110);
        LocalVideoItemViewHolder r112 = new LocalVideoItemViewHolder(r100, this.f370596a, this.f370599d, new e(this, r100), new f(this));
        l.a(r112.itemView, r112, LocalCreationItemListAdapter$onCreateViewHolder$3$1.INSTANCE, this, LocalCreationItemListAdapter$onCreateViewHolder$3$2.INSTANCE);
        return r112;
    L5:
        final LarusItemMarkdownCreationImageScrollBinding r101 = LarusItemMarkdownCreationImageScrollBinding.a(LayoutInflater.from(r110.getContext()), r110);
        LocalImageItemViewHolder r113 = new LocalImageItemViewHolder(r101, this.f370596a, this.f370597b, this.f370598c, this.f370599d, this.f370603h, this.f370604i, new g(this, r101), new h(this));
        l.a(r113.itemView, r113, LocalCreationItemListAdapter$onCreateViewHolder$6$1.INSTANCE, this, LocalCreationItemListAdapter$onCreateViewHolder$6$2.INSTANCE);
        return r113;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        Object r103 = CollectionsKt.firstOrNull(r102);
        cz9.g r104 = null;
        if ((r103 instanceof cz9.a) == false) goto L5;
        cz9.a r105 = (cz9.a) r103;
    L6:
        if (r105 != null) goto L8;
        super.onBindViewHolder(r100, r101, r102);
        return;
    L8:
        if ((r100 instanceof cz9.g) == false) goto L10;
        r104 = (cz9.g) r100;
    L10:
        if (r104 == null) goto L15;
        r104.updateSize(r105.f466075a, r105.f466076b);
        return;
    L15:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public LocalCreationItemListAdapter(LifecycleCoroutineScope r100, com.larus.uaigc.chat.markdown.image.component.a r101, k r102, q r103, n r104, o r105, p r106, Function1 r107, Function2 r110) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r104, "clickListener");
        Intrinsics.checkNotNullParameter(r105, "longClickListenerBinder");
        Intrinsics.checkNotNullParameter(r106, "onExpose");
        Intrinsics.checkNotNullParameter(r107, "messageGetter");
        Intrinsics.checkNotNullParameter(r110, "commonParamGetter");
        this.f370596a = r100;
        this.f370597b = r101;
        this.f370598c = r102;
        this.f370599d = r103;
        this.f370600e = r104;
        this.f370601f = r105;
        this.f370602g = r106;
        this.f370603h = r107;
        this.f370604i = r110;
        this.f370605j = CollectionsKt.emptyList();
    }
}
