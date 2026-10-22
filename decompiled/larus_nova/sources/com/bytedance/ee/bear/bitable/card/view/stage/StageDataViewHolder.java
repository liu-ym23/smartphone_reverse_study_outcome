package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepAdapter;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepItemDecoration;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepLayoutManager;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J&\u0010\u001f\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/StageDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fieldPresenter", "Lcom/bytedance/ee/bear/bitable/card/view/stage/IStageFieldPresenter;", "rootView", "Landroid/view/ViewGroup;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/stage/IStageFieldPresenter;Landroid/view/ViewGroup;)V", "stepAdapter", "Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageDataStepAdapter;", "setData", "", "initStepMoreMenu", "stepMoreIcon", "Landroid/view/View;", "initStepList", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateStepMoreMenu", "option", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "isEditable", "", "updateDataStep", "updateViewStep", "viewOption", "dataOption", "diff", "", "bindCurrentStateAction", "currentStateAction", "updateStepList", "options", "", "stepDataIndex", "stepViewIndex", "markStepDone", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageDataViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.card.view.stage.a f208670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f208671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StageDataStepAdapter f208672c;

    public static final class a {
    }

    static {
    }

    public StageDataViewHolder(com.bytedance.ee.bear.bitable.card.view.stage.a r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldPresenter");
        Intrinsics.checkNotNullParameter(r101, "rootView");
        super(r101);
        this.f208670a = r100;
        this.f208671b = r101;
        StageDataStepAdapter r102 = new StageDataStepAdapter(r100);
        this.f208672c = r102;
        View r103 = r101.findViewById(R.id.stepMoreIcon);
        r103.post(new f(r103));
        RecyclerView r104 = (RecyclerView) r101.findViewById(R.id.stepRecyclerView);
        r104.setLayoutManager(new StageDataStepLayoutManager(r101.getContext()));
        r104.setAdapter(r102);
        r104.addItemDecoration(new StageDataStepItemDecoration());
    }
}
