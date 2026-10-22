package com.obric.assistant.card.layout.viewholder.abs;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.utils.e1;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pca.b;
import pca.c;
import qca.a;
import qca.d;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ@\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0007J5\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H$¢\u0006\u0002\u00105J.\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0004J\u0010\u0010;\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010:J\u0010\u0010?\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010>J\b\u0010@\u001a\u00020+H\u0016J\b\u0010A\u001a\u00020+H\u0016R\u0016\u0010\u0005\u001a\u00028\u0001X\u0084\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "autoSetClickListener", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Z)V", "getViewBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "hasSetGray", "getHasSetGray", "()Z", "setHasSetGray", "(Z)V", "value", "", "", "currentEntityGroup", "getCurrentEntityGroup", "()Ljava/util/List;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "pageType", "Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;", "getPageType", "()Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;", "setPageType", "(Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;)V", "bind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entityGroup", "entity", "position", "", "isDeleted", "isRefreshed", "onBind", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "setEventListener", "view", "Landroid/view/View;", "itemClickListener", "Lcom/obric/assistant/card/layout/listener/OnItemClickListener;", "setOnItemClickListener", "listener", "itemLongClickListener", "Lcom/obric/assistant/card/layout/listener/OnItemLongClickListener;", "setOnLongClickListener", "onViewDetached", "onViewAttached", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemViewHolder<T, V extends ViewBinding> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f386390i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f386391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f386392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f386393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends Object> f386394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f386395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppEntityListAdapter.PageType f386396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f386397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f386398h;

    public abstract void T3(MessageExtraForViewHolder r100, T r101, int r102, boolean r103, boolean r104);

    public void U3() {
    }

    public void V3() {
    }

    public final Context getContext() {
        return (Context) this.f386393c.getValue();
    }

    public AbsCardItemViewHolder(V r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewBinding");
        super(r100.getRoot());
        this.f386391a = r100;
        this.f386392b = r101;
        this.f386393c = LazyKt.lazy(new qca.c(this));
        this.f386394d = CollectionsKt.emptyList();
        this.f386395e = LazyKt.lazy(new d(this));
    }

    public final void W3(View r100, final List<? extends Object> r101, final Object r102, final int r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "entityGroup");
        Intrinsics.checkNotNullParameter(r102, "entity");
        final b r104 = this.f386397g;
        if (r104 == null) goto L5;
        e1.d(r100, new a(r104, r101, r102, r103));
    L5:
        final c r105 = this.f386398h;
        if (r105 == null) goto L9;
        r100.setOnLongClickListener(new qca.b(r105));
        return;
    }
}
