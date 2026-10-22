package com.bytedance.ee.bear.bitable.card.view.stage.step;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageType;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.d;
import com.bytedance.ee.bear.bitable.card.view.stage.StageStepView;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lq4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\fH\u0016J$\u0010\u0017\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageDataStepAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageDataStepViewHolder;", "fieldPresenter", "Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageStepDep;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageStepDep;)V", "options", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "visibleOptions", "stepDataIndex", "", "stepViewIndex", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "setData", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageDataStepAdapter extends RecyclerView.Adapter<StageDataStepViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f208764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<d> f208765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<d> f208766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f208767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f208768e;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f208766c.size();
    }

    public StageDataStepAdapter(b r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldPresenter");
        this.f208764a = r100;
        this.f208765b = CollectionsKt.emptyList();
        this.f208766c = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        StageDataStepViewHolder r112 = (StageDataStepViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        d r100 = (d) ListProtector.get(this.f208766c, r111);
        d r101 = (d) ListProtector.get(this.f208765b, this.f208767d);
        View r113 = r112.itemView;
        ((TextView) r113.findViewById(R.id.text)).setText(r100.f207142b);
        boolean r102 = true;
        if (r111 != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r111 == (getItemCount() - 1)) goto L10;
        r102 = false;
    L10:
        StageStepView r104 = (StageStepView) r113.findViewById(R.id.stepView);
        r104.f208710r = r103;
        r104.f208711s = r102;
        r104.requestLayout();
        RingView r105 = (RingView) r113.findViewById(R.id.ring);
        ViewGroup.LayoutParams r106 = ((RingView) r113.findViewById(R.id.ring)).getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r103 == false) goto L13;
        int r108 = UIHelper.dp2px(16.0f);
    L14:
        r107.setMarginStart(r108);
        r105.setLayoutParams(r107);
        TextView r109 = (TextView) r113.findViewById(R.id.text);
        ViewGroup.LayoutParams r114 = ((TextView) r113.findViewById(R.id.text)).getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        if (r102 == false) goto L17;
        int r116 = UIHelper.dp2px(16.0f);
    L18:
        r115.setMarginEnd(r116);
        r109.setLayoutParams(r115);
        if (r101.getType() == StageType.EndCancel) goto L33;
        int r117 = this.f208767d;
        if (r111 > r117) goto L33;
        if (r111 != r117) goto L32;
        ((RingView) r113.findViewById(R.id.ring)).a(UIHelper.getColor(R.color.ud_O350), UIHelper.getColor(R.color.ud_O200));
        ((TextView) r113.findViewById(R.id.text)).setTextColor(UIHelper.getColor(R.color.text_title));
        int r118 = ColorUtils.h(r100.f207144d);     // Catch: Exception -> L27
    L29:
        if (r118 != 0) goto L31;
        r118 = UIHelper.getColor(R.color.ud_B300);
    L31:
        ((StageStepView) r113.findViewById(R.id.stepView)).setContentColor(r118);
    L35:
        if (r111 != this.f208768e) goto L37;
        ((StageStepView) r113.findViewById(R.id.stepView)).setBorderColor(UIHelper.getColor(R.color.ud_B500));
    L38:
        ((StageStepView) r113.findViewById(R.id.stepView)).setOnClickListener(new lq4.a(this, r111));
        return;
    L37:
        ((StageStepView) r113.findViewById(R.id.stepView)).setBorderColor(0);
    L27:
        e = move-exception;
        tt5.a.f("StageDataStepAdapter", e, false);
        r118 = 0;
        goto L29
    L32:
        ((RingView) r113.findViewById(R.id.ring)).a(UIHelper.getColor(R.color.ud_G500), UIHelper.getColor(R.color.ud_G300));
        ((TextView) r113.findViewById(R.id.text)).setTextColor(UIHelper.getColor(R.color.static_white));
        ((StageStepView) r113.findViewById(R.id.stepView)).setContentColor(UIHelper.getColor(R.color.function_success_400));
    L33:
        ((RingView) r113.findViewById(R.id.ring)).a(UIHelper.getColor(R.color.ud_N500), UIHelper.getColor(R.color.ud_N350));
        ((TextView) r113.findViewById(R.id.text)).setTextColor(UIHelper.getColor(R.color.text_title));
        ((StageStepView) r113.findViewById(R.id.stepView)).setContentColor(UIHelper.getColor(R.color.ud_N200));
        goto L35
    L17:
        r116 = UIHelper.dp2px(20.0f);
        goto L18
    L13:
        r108 = UIHelper.dp2px(20.0f);
        goto L14
    L5:
        r103 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_stage_step_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new StageDataStepViewHolder(r102);
    }

    public final void y2(List<d> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "options");
        this.f208765b = r100;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (((d) r105).getType() != StageType.Default) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r106 = false;
        goto L9
    L11:
        this.f208766c = r103;
        this.f208767d = r101;
        this.f208768e = r102;
        notifyDataSetChanged();
    }
}
