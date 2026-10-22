package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.flexbox.FlexboxLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0006\u001b\u001c\u001d\u001e\u001f B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nJ\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aR\u0018\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "conditionSource", "", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionConfig;", "adapter", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionAdapter;", "onConditionListener", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$OnConditionListener;", "getOnConditionListener", "()Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$OnConditionListener;", "setOnConditionListener", "(Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$OnConditionListener;)V", "bindConditionList", "", "conditionList", "updateConditionList", "updateConditionByIndex", "index", "", "ConditionAdapter", "ConditionItemViewHolder", "ConditionConfig", "ConditionLifeCycle", "ConditionItem", "OnConditionListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConditionListView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends a> f209904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConditionAdapter f209905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f209906c;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItemViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ConditionAdapter extends RecyclerView.Adapter<ConditionItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionListView f209908a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<? extends a> r100 = this.f209908a.f209904a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public ConditionAdapter(ConditionListView r100) {
            this.f209908a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            ConditionItemViewHolder r112 = (ConditionItemViewHolder) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            List<? extends a> r100 = this.f209908a.f209904a;
            if (r100 == null) goto L36;
            a r113 = (a) ListProtector.get(r100, r111);
            if (r113 == null) goto L37;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r113, "conditionConfig");
            ConditionView r101 = r112.f209909a;
            r101.f209912b.removeAllViews();
            r101.f209912b.setVisibility(8);
            List<b> r102 = r113.e();
            if (r102 == null) goto L29;
            ConditionListView r103 = r112.f209910b;
            int r104 = r102.size();
            int r105 = 0;
        L9:
            if (r105 >= r104) goto L29;
            b r106 = (b) ListProtector.get(r102, r105);
            ConditionView r107 = r112.f209909a;
            r107.getClass();
            Intrinsics.checkNotNullParameter(r106, "conditionItem");
            r107.f209912b.setVisibility(0);
            Intrinsics.checkNotNullParameter(r106, "conditionItem");
            ConditionCellView r108 = new ConditionCellView(r107.getContext());
            CharSequence r109 = r106.getTitle();
            if (r109 == null) goto L13;
            r108.setCellText(r109);
        L14:
            Integer r114 = r106.getIconRes();
            if (r114 == null) goto L17;
            ConditionCellView.a(r108, r114.intValue(), r106.isSync(), 2);
        L17:
            Integer r115 = r106.getRightIconRes();
            if (r115 == null) goto L20;
            ConditionCellView.b(r108, r115.intValue());
        L21:
            FlexboxLayout r116 = r107.f209912b;
            FlexboxLayout.LayoutParams r117 = new FlexboxLayout.LayoutParams(-2, -2);
            r117.setMargins(0, 0, n.d(8), n.d(8));
            Unit r118 = Unit.INSTANCE;
            r116.addView(r108, r117);
            r108.setOnClickListener(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.c(r103, r113, r105));
            if ((r113 instanceof c) == false) goto L25;
            ((c) r113).d(r108, r105, r106);
        L25:
            if (r106.isChecked() == null) goto L27;
            r108.setOnCheckBoxListener(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.b(r103, r106));
        L27:
            r105 = r105 + 1;
            goto L9
        L20:
            r108.setRightIconVisible(false);
            goto L21
        L13:
            r108.setCellHintText(r106.getHintTitle());
            Unit r119 = Unit.INSTANCE;
        L29:
            if ((r113 instanceof c) == false) goto L31;
            ((c) r113).a(r112.f209909a);
        L31:
            r112.f209909a.setOnCardRemoveListener(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.d(r112.f209910b, r113));
            r112.f209909a.setOnClickListener(new e(r112.f209910b, r113));
            return;
        L37:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            ConditionListView r102 = this.f209908a;
            ConditionView r103 = new ConditionView(this.f209908a.getContext());
            r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return new ConditionItemViewHolder(r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "conditionGroupView", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView;)V", "getConditionGroupView", "()Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView;", "setConditionGroupView", "(Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView;)V", "applyConditionGroup", "", "conditionConfig", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionConfig;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ConditionItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConditionView f209909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConditionListView f209910b;

        public ConditionItemViewHolder(ConditionListView r100, ConditionView r101) {
            Intrinsics.checkNotNullParameter(r101, "conditionGroupView");
            this.f209910b = r100;
            super(r101);
            this.f209909a = r101;
        }
    }

    public interface a {
        List<b> e();

        String getCallbackId();
    }

    public interface b {
        String getCallbackId();

        CharSequence getHintTitle();

        Integer getIconRes();

        Integer getRightIconRes();

        CharSequence getTitle();

        Boolean isChecked();

        boolean isSync();
    }

    public interface c {
        void a(ConditionView r100);

        void d(ConditionCellView r100, int r101, b r102);
    }

    public interface d {
        void Cj(b r100);

        void Fi(a r100, int r101);

        void YS(a r100);

        void ys(a r100);
    }

    public final d getOnConditionListener() {
        return this.f209906c;
    }

    public ConditionListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void r(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionList");
        this.f209904a = r100;
        this.f209905b.notifyDataSetChanged();
    }

    public final void setOnConditionListener(d r100) {
        this.f209906c = r100;
    }

    public final void t(int r100) {
        List<? extends a> r101 = this.f209904a;
        if (r101 == null) goto L12;
        boolean r102 = false;
        if (r100 >= 0) goto L7;
    L9:
        if (r102 == false) goto L13;
        this.f209905b.notifyItemChanged(r100);
        return;
    L13:
        return;
    L7:
        if (r100 >= r101.size()) goto L9;
        r102 = true;
        goto L9
    }

    public ConditionListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ConditionAdapter r102 = new ConditionAdapter(this);
        this.f209905b = r102;
        setAdapter(r102);
        setLayoutManager(new LinearLayoutManager(r100, 1, false));
        addItemDecoration(new AnonymousClass1(this));
    }
}
