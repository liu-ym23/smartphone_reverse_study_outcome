package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ \u0010\u0010\u001a\u00020\u000b2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/ReplySuggestList;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setSuggestList", "", "suggestList", "", "", "getCurrentSuggestList", "setItemClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function2;", "setImmerseMode", "onSizeChanged", "w", "h", "oldw", "oldh", "SuggestAdapter", "SuggestHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplySuggestList extends RecyclerView {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u001c\u0010\u0014\u001a\u00020\u000e2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0014\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J \u0010\u001a\u001a\u00020\u000e2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0006\u0010\u001b\u001a\u00020\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/ReplySuggestList$SuggestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/view/ReplySuggestList$SuggestHolder;", "Lcom/larus/bmhome/view/ReplySuggestList;", "<init>", "(Lcom/larus/bmhome/view/ReplySuggestList;)V", "suggestList", "", "", "immerseMode", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function2;", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "updateSuggest", "list", "getCurrentSuggestList", "setClickListener", "setImmerseMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SuggestAdapter extends RecyclerView.Adapter<SuggestHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f315586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f315587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function2<? super String, ? super Integer, Unit> f315588c;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f315586a.size();
        }

        public SuggestAdapter(ReplySuggestList r100) {
            this.f315586a = CollectionsKt.emptyList();
            this.f315588c = new a4();
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bmhome.view.z3, java.lang.Object] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
            SuggestHolder r102 = (SuggestHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            List<String> r103 = this.f315586a;
            if (r101 >= 0) goto L5;
        L7:
            boolean r104 = false;
        L8:
            if (r104 == false) goto L10;
            Object r105 = ListProtector.get(r103, r101);
        L11:
            final String r106 = (String) r105;
            boolean r107 = this.f315587b;
            final ?? r108 = new z3(this, r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r106, "text");
            Intrinsics.checkNotNullParameter(r108, SendEventContainerMethodParamModel.EventKinds.onClick);
            if (r107 == false) goto L19;
            TextView r109 = (TextView) r102.itemView.findViewById(R.id.text);
            if (r109 == null) goto L16;
            r109.setTextColor(ve8.d.a(R.color.larus_static_white, AppHost.f326268a.getApplication()));
        L16:
            ImageView r110 = (ImageView) r102.itemView.findViewById(R.id.icon);
            if (r110 == null) goto L19;
            r110.setImageResource(R.drawable.larus_ic_suggest_reply_immerse);
        L19:
            TextView r111 = (TextView) r102.itemView.findViewById(R.id.text);
            if (r111 == null) goto L22;
            r111.setText(r106);
        L22:
            r102.itemView.setOnClickListener(new b4(r108, r106));
            return;
        L10:
            r105 = "";
            goto L11
        L5:
            if (r101 >= r103.size()) goto L7;
            r104 = true;
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_suggest_reply_item_view, r100, false);
            int r103 = R.id.divider;
            if (ViewBindings.findChildViewById(r102, R.id.divider) == null) goto L11;
            r103 = R.id.icon;
            if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.icon)) == null) goto L11;
            r103 = R.id.text;
            if (((TextView) ViewBindings.findChildViewById(r102, R.id.text)) == null) goto L11;
            return new SuggestHolder((ConstraintLayout) r102);
        L11:
            throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/view/ReplySuggestList$SuggestHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/view/ReplySuggestList;Landroid/view/View;)V", "setTextAndClickListener", "", "text", "", "immerseMode", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SuggestHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f315589a = 0;

        public SuggestHolder(ConstraintLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public ReplySuggestList(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReplySuggestList(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final List<String> getCurrentSuggestList() {
        RecyclerView.Adapter r100 = getAdapter();
        if ((r100 instanceof SuggestAdapter) == false) goto L5;
        SuggestAdapter r101 = (SuggestAdapter) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f315586a;
    L5:
        r101 = null;
        goto L6
    }

    public final void setItemClickListener(Function2<? super String, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        RecyclerView.Adapter r101 = getAdapter();
        if ((r101 instanceof SuggestAdapter) == false) goto L5;
        SuggestAdapter r102 = (SuggestAdapter) r101;
    L6:
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        r102.f315588c = r100;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setSuggestList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "suggestList");
        RecyclerView.Adapter r101 = getAdapter();
        if ((r101 instanceof SuggestAdapter) == false) goto L5;
        SuggestAdapter r102 = (SuggestAdapter) r101;
    L6:
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "list");
        r102.f315586a = r100;
        r102.notifyDataSetChanged();
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public ReplySuggestList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutManager(new LinearLayoutManager(r100));
        setAdapter(new SuggestAdapter(this));
    }

    public /* synthetic */ ReplySuggestList(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Lazy r104 = i5.f552509h1;
        if (r101 <= ((Number) r104.getValue()).intValue()) goto L6;
        ViewGroup.LayoutParams r105 = getLayoutParams();
        r105.height = ((Number) r104.getValue()).intValue();
        setLayoutParams(r105);
        return;
    }
}
