package com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.SelectFieldViewHolder;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0003,-.B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011J\u001d\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140&J\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/ViewSettingSelectFieldListAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/SelectFieldViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "showDivider", "", "<init>", "(Landroid/content/Context;Z)V", "getContext", "()Landroid/content/Context;", "getShowDivider", "()Z", "onLeftIconClickListerner", "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/ViewSettingSelectFieldListAdapter$OnLeftIconClickListerner;", "onRightIconClickListerner", "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/ViewSettingSelectFieldListAdapter$OnRightIconClickListerner;", "dataSource", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dividerHeight", "", "setOnLeftIconClickListener", "", "onIconClickListerner", "setOnRightIconClickListerner", "onBindViewHolder", "holder", "position", "(Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/SelectFieldViewHolder;I)V", "getItemCount", "onDetachedFromRecyclerView", "onAttachedToRecyclerView", "setFieldData", SlcCommonAction.KEY_PARAMS, "", "onItemMove", "from", RemoteMessageConst.TO, "getDataSourceIds", "", "Companion", "OnLeftIconClickListerner", "OnRightIconClickListerner", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ViewSettingSelectFieldListAdapter<T extends SelectFieldViewHolder> extends RecyclerView.Adapter<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f209242g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f209243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f209244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f209245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<FilterFieldOption> f209246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f209247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f209248f;

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f209246d).size();
    }

    public final Context getContext() {
        return this.f209243a;
    }

    public ViewSettingSelectFieldListAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f209243a = r100;
        this.f209244b = false;
        this.f209246d = new ArrayList();
        this.f209248f = n.e(r100, 0.5f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f209247e = r100;
        if (this.f209244b == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        r100.addItemDecoration(new AnonymousClass1(this));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        this.f209247e = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SelectFieldViewHolder r102 = (SelectFieldViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        FilterFieldOption r103 = (FilterFieldOption) ListProtector.get(this.f209246d, r101);
        r102.f209240f.setOnClickListener(new com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.a(this, r101, r103));
        r102.f209239e.setOnClickListener(new uq4.a(this, r101, r103));
        r102.T3();
        r102.f209235a.setImageResource(r103.getFieldCompositeType().getIcon());
        r102.f209235a.setSyncIconVisible(r103.isSync());
        r102.f209238d.setText(r103.getName());
    }
}
