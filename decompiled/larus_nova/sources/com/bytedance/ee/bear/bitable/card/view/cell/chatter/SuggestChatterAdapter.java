package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010.\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u0014\u00100\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u000e\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u000fJ\b\u00103\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020\u0011H\u0016J\u001f\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u000fH\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRD\u0010\u001c\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR*\u0010'\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SuggestChatterAdapter;", "D", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SuggestChatterViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "selectedChatters", "getSelectedChatters", "()Ljava/util/List;", "language", "", "enableMultipleSelect", "", "maxSelectedNum", "", "getMaxSelectedNum", "()Ljava/lang/Integer;", "setMaxSelectedNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "singleSelectRefactor", "getSingleSelectRefactor", "()Z", "setSingleSelectRefactor", "(Z)V", "onSelectedChattersChangeListener", "Lkotlin/Function4;", "", "", "getOnSelectedChattersChangeListener", "()Lkotlin/jvm/functions/Function4;", "setOnSelectedChattersChangeListener", "(Lkotlin/jvm/functions/Function4;)V", "canShowChatterInfoIcon", "getCanShowChatterInfoIcon", "setCanShowChatterInfoIcon", "onChatterInfoIconClickListener", "Lkotlin/Function1;", "getOnChatterInfoIconClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnChatterInfoIconClickListener", "(Lkotlin/jvm/functions/Function1;)V", "setLanguage", "setSelected", "list", "setAllSuggest", "setEnableMultiSelect", "enable", "appendSelectedChatterIfNeed", "getItemCount", "convert", "holder", MapController.ITEM_LAYER_TAG, "(Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SuggestChatterViewHolder;Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;)V", "showCheckbox", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SuggestChatterAdapter<D extends IChatterEntity> extends BaseQuickAdapter<D, SuggestChatterViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<D> f207547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f207548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f207549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f207550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f207551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function4<? super List<? extends D>, ? super D, ? super D, ? super Boolean, Unit> f207552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f207553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super D, Unit> f207554h;

    public SuggestChatterAdapter() {
        this(null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getData().size();
    }

    public void z2() {
        HashSet r100 = CollectionsKt.toHashSet(getData());
        List<D> r101 = this.f207547a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((!r100.contains((IChatterEntity) r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        List<D> r105 = getData();
        if (r105 == null) goto L17;
        r105.addAll(r102);
        return;
    }

    public static final /* synthetic */ String y2() {
        return BaseQuickAdapter.TAG;
    }

    public SuggestChatterAdapter(List<D> r100) {
        super(R.layout.bitable_suggest_user_list_item, r100);
        this.f207547a = new ArrayList();
    }

    public final void A2(List<? extends D> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        List<D> r101 = getData();
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        List<D> r102 = getData();
        if (r102 == null) goto L8;
        r102.addAll(r100);
    L8:
        z2();
        notifyDataSetChanged();
    }

    public final void B2(boolean r100) {
        if (this.f207549c == r100) goto L10;
        this.f207549c = r100;
        if (r100 == false) goto L7;
        return;
    L7:
        if (((ArrayList) this.f207547a).size() <= 1) goto L12;
        C2(CollectionsKt.listOf(ListProtector.get(this.f207547a, 0)));
        return;
    L12:
        return;
    }

    public final void C2(List<? extends D> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ((ArrayList) this.f207547a).clear();
        ArrayList r101 = (ArrayList) this.f207547a;
        r101.addAll(r100);
        z2();
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Object r101) {
        SuggestChatterViewHolder r102 = (SuggestChatterViewHolder) r100;
        IChatterEntity r103 = (IChatterEntity) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.itemView.setOnClickListener(new v(this, r102));
        r102.f207558d.setClickable(false);
        String r104 = this.f207548b;
        if (r104 != null) goto L5;
        r104 = Locale.getDefault().getLanguage();
    L5:
        this.f207548b = r104;
        r102.itemView.setTag(r103);
        if (r103 == null) goto L38;
        r102.f207556b.setTitle(r103.getLocalName(this.f207548b));
        com.bytedance.ee.bear.bitable.common.h.a(r102.itemView.getContext(), r103.getAvatarUrl(), r103.getAvatarKey(), r102.f207555a);
        String r105 = r103.getDescription();
        if (r105 == null) goto L11;
        r102.f207557c.setVisibility(0);
        r102.f207557c.setText(r105);
    L11:
        if (this.f207549c == false) goto L13;
    L16:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        r102.f207558d.setVisibility(0);
        r102.f207558d.setChecked(CollectionsKt.toSet(this.f207547a).contains(r103));
    L21:
        ViewGroup.LayoutParams r107 = r102.f207560f.getLayoutParams();
        if ((r107 instanceof RelativeLayout.LayoutParams) == false) goto L24;
        RelativeLayout.LayoutParams r108 = (RelativeLayout.LayoutParams) r107;
    L25:
        if (r108 == null) goto L32;
        if (this.f207553g == false) goto L29;
        float r109 = 12.0f;
    L30:
        r108.setMarginEnd(UIHelper.dp2px(r109));
        goto L32
    L29:
        r109 = 16.0f;
    L32:
        if (this.f207553g == true) goto L34;
    L36:
        r102.f207559e.setVisibility(8);
        return;
    L34:
        if (com.bytedance.ee.bear.bitable.c.w() == true) goto L36;
        r102.f207559e.setVisibility(0);
        r102.f207559e.setOnClickListener(new w(this, r103));
        return;
    L24:
        r108 = null;
        goto L25
    L20:
        r102.f207558d.setVisibility(8);
        goto L21
    L13:
        if (this.f207551e == false) goto L16;
        r106 = false;
        goto L18
    }
}
