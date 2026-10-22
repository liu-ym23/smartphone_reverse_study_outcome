package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\fJ\b\u0010#\u001a\u00020$H\u0016J\u001f\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\r\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SelectedChatterAdapter;", "D", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SelectedChatterViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "language", "", "enableMultipleSelect", "", "onSelectedChattersChangeListener", "Lkotlin/Function2;", "", "", "getOnSelectedChattersChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectedChattersChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "onChatterClickListener", "Lkotlin/Function1;", "getOnChatterClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnChatterClickListener", "(Lkotlin/jvm/functions/Function1;)V", "enableItemClickDelete", "getEnableItemClickDelete", "()Z", "setEnableItemClickDelete", "(Z)V", "setLanguage", "setEnableMultiSelect", "enable", "getItemCount", "", "convert", "holder", MapController.ITEM_LAYER_TAG, "(Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SelectedChatterViewHolder;Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;)V", "deleteItem", "chatter", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedChatterAdapter<D extends IChatterEntity> extends BaseQuickAdapter<D, SelectedChatterViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f207539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f207540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super List<? extends D>, ? super D, Unit> f207541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super D, Unit> f207542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f207543e;

    public SelectedChatterAdapter() {
        this(null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getData().size();
    }

    public SelectedChatterAdapter(List<D> r100) {
        super(R.layout.bitable_selected_user_list_item, r100);
    }

    public final void y2(D r100) {
        Intrinsics.checkNotNullParameter(r100, "chatter");
        ArrayList r101 = new ArrayList();
        r101.addAll(getData());
        r101.remove(r100);
        Function2<? super List<? extends D>, ? super D, Unit> r102 = this.f207541c;
        if (r102 == null) goto L6;
        r102.invoke(r101, r100);
        return;
    }

    public final void z2(boolean r100) {
        if (this.f207540b == r100) goto L15;
        this.f207540b = r100;
        if (r100 == false) goto L7;
        return;
    L7:
        if (getData().size() <= 1) goto L17;
        IChatterEntity r101 = (IChatterEntity) ListProtector.get(getData(), 0);
        List<D> r102 = getData();
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        List<D> r103 = getData();
        if (r103 == null) goto L18;
        r103.addAll(CollectionsKt.listOf(r101));
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Object r101) {
        SelectedChatterViewHolder r102 = (SelectedChatterViewHolder) r100;
        IChatterEntity r103 = (IChatterEntity) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.f207546c.setOnClickListener(new t(this));
        r102.itemView.setOnClickListener(new u(this));
        String r104 = this.f207539a;
        if (r104 != null) goto L5;
        r104 = Locale.getDefault().getLanguage();
    L5:
        this.f207539a = r104;
        r102.itemView.setTag(r103);
        r102.f207546c.setTag(r103);
        TextView r105 = r102.f207545b;
        String r106 = null;
        if (r103 == null) goto L8;
        String r107 = r103.getLocalName(this.f207539a);
    L9:
        r105.setText(r107);
        Context r108 = r102.itemView.getContext();
        if (r103 == null) goto L12;
        String r109 = r103.getAvatarUrl();
    L13:
        if (r103 == null) goto L15;
        r106 = r103.getAvatarKey();
    L15:
        com.bytedance.ee.bear.bitable.common.h.a(r108, r109, r106, r102.f207544a);
        return;
    L12:
        r109 = null;
        goto L13
    L8:
        r107 = null;
        goto L9
    }
}
