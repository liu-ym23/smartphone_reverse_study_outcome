package com.bytedance.ee.bear.bitable.card.view.cell.link;

import android.graphics.Typeface;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.bytedance.ee.bear.bitable.card.view.title.BitableCardTitleView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 82\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003678B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0016\u0010 \u001a\u00020!2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\nJ\u0014\u0010%\u001a\u00020!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u001c\u0010'\u001a\u00020!2\n\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020\u001eH\u0016J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0017J\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0015J \u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u00020!J\b\u00105\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkRecordAdapter$ViewHolder;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;)V", "mLinkField", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/LinkField;", "mCurrentRecord", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/STRecord;", "mLinkRecordList", "", "getMLinkRecordList", "()Ljava/util/List;", "setMLinkRecordList", "(Ljava/util/List;)V", "getFormRecordParams", "Lkotlin/Function0;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/CardOperationModel$FormRecordParams;", "mEnableShowDeleteMenu", "", "mDeleteMenuClickListener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkRecordAdapter$OnDeleteMenuClickListener;", "mActionMode", "Landroid/view/ActionMode;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getLayoutId", "setFormRecordParams", "", "setLinkField", "linkField", "record", "setLinkRecordList", "linkRecordList", "onBindViewHolder", "holder", "position", "setOnDeleteMenuClickListener", "listener", "enableShowDeleteMenu", "enable", "startActionMode", "view", "Landroid/view/View;", "highlightBorder", "linkRecordId", "", "destroyCustomMenuIfNeed", "getItemCount", "ViewHolder", "OnDeleteMenuClickListener", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LinkRecordAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gp4.h f207718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fp4.d f207719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cp4.a f207720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends cp4.a> f207721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<? extends CardOperationModel.FormRecordParams> f207722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f207723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f207724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActionMode f207725h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkRecordAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkRecordAdapter;Landroid/view/View;)V", "titleView", "Lcom/bytedance/ee/bear/bitable/card/view/title/BitableCardTitleView;", "highlightBorder", "getHighlightBorder", "()Landroid/view/View;", "setHighlightBorder", "(Landroid/view/View;)V", "setData", "", "record", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/STRecord;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BitableCardTitleView f207726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f207727b;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            super(r100);
            BitableCardTitleView r101 = (BitableCardTitleView) r100.findViewById(R.id.link_record_title);
            this.f207726a = r101;
            this.f207727b = r100.findViewById(R.id.highlight_border);
            r101.setDefaultTitle(r101.getResources().getString(R.string.Doc_Block_UnnamedRecord));
            int r102 = h18.e.f483540a;
            r101.setTypeface(h18.e.b(r101.getContext(), Typeface.DEFAULT.getStyle()));
            r101.setTitleSize(r101.getResources().getDimensionPixelSize(R.dimen.bitable_field_link_title_size));
        }
    }

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public int getLayoutId() {
        return R.layout.bitable_card_link_rv_item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f207721d.size();
    }

    public LinkRecordAdapter(gp4.h r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f207718a = r100;
        this.f207721d = new ArrayList();
        this.f207722e = LinkRecordAdapter$getFormRecordParams$1.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 >= getItemCount()) goto L10;
        cp4.a r103 = (cp4.a) ListProtector.get(this.f207721d, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "record");
        r102.f207726a.setRecordTitle(r103.f464637d);
        View r104 = r102.itemView;
        r104.setOnClickListener(new m0(this, r104, r103));
        r104.setOnLongClickListener(new n0(this, r102, r103));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(getLayoutId(), r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
