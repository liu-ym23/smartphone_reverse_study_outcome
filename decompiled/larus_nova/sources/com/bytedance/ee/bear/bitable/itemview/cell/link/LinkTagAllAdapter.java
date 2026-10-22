package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.view.title.BitableCardTitleView;
import com.bytedance.ee.bear.bitable.databinding.BitablePageLinkRvItemBinding;
import com.bytedance.ee.bear.bitable.databinding.BitablePageLinkRvItemV2Binding;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.LinkTagView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.bear.facade.common.widget.InterceptTouchEventLinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004./01B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\u0006\u0010 \u001a\u00020\u0006J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020%H\u0016J\u0006\u0010*\u001a\u00020\u0014J\u001e\u0010+\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140-H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R7\u0010\u0019\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagAllAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagAllAdapter$ViewHolder;", "<init>", "()V", "baseDesign", "", "mLinkRecordList", "", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagItem;", "getMLinkRecordList", "()Ljava/util/List;", "mActionMode", "Landroid/view/ActionMode;", "mDeleteListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "recordId", "", "getMDeleteListener", "()Lkotlin/jvm/functions/Function1;", "setMDeleteListener", "(Lkotlin/jvm/functions/Function1;)V", "mClickListener", "getMClickListener", "setMClickListener", "mEditable", "setData", "linkRecordList", "", "editable", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "destroyCustomMenuIfNeed", "startActionMode", "click", "Lkotlin/Function0;", "Companion", "ViewHolder", "TitleViewHolder", "TagViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LinkTagAllAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f213902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LinkTagItem> f213903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMode f213904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f213905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super String, Unit> f213906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f213907f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagAllAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "highlightBorder", "getHighlightBorder", "()Landroid/view/View;", "setData", "", "record", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagItem;", "safeTitle", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f213908a;

        public abstract void T3(LinkTagItem r100);

        public ViewHolder(InterceptTouchEventLinearLayout r100) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            super(r100);
            this.f213908a = r100.findViewById(R.id.highlight_border);
        }
    }

    public static final class a {
    }

    public static final class b extends ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkTagView f213909b;

        public b(BitablePageLinkRvItemV2Binding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f211009a);
            LinkTagView r101 = r100.f211010b;
            r101.x(BaseTagSize.LARGE);
            this.f213909b = r101;
        }

        @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTagAllAdapter.ViewHolder
        public final void T3(LinkTagItem r100) {
            Intrinsics.checkNotNullParameter(r100, "record");
            LinkTagView r101 = this.f213909b;
            Intrinsics.checkNotNullParameter(r100, "record");
            String r102 = r100.getTitle();
            boolean r103 = false;
            if (r102 != null) goto L5;
        L7:
            if (r102 != null) goto L9;
        L16:
            r102 = this.f213909b.getContext().getString(R.string.Doc_Block_UnnamedRecord);
        L17:
            r101.setText(r102);
            return;
        L9:
            if (r102.length() <= 0) goto L11;
            r103 = true;
        L11:
            if (r103 == true) goto L14;
            r102 = null;
        L14:
            if (r102 == null) goto L16;
        L5:
            if (r102.length() <= 200) goto L7;
            r102 = r102.substring(0, 200);
            goto L7
        }
    }

    public static final class c extends ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BitableCardTitleView f213910b;

        public c(BitablePageLinkRvItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f211007a);
            BitableCardTitleView r101 = r100.f211008b;
            r101.setDefaultTitle(r101.getContext().getResources().getString(R.string.Doc_Block_UnnamedRecord));
            int r102 = h18.e.f483540a;
            r101.setTypeface(h18.e.a(r101.getContext()));
            r101.setTitleSize(r101.getContext().getResources().getDimensionPixelSize(R.dimen.bitable_field_link_title_size));
            this.f213910b = r101;
        }

        @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTagAllAdapter.ViewHolder
        public final void T3(LinkTagItem r100) {
            Intrinsics.checkNotNullParameter(r100, "record");
            BitableCardTitleView r101 = this.f213910b;
            Intrinsics.checkNotNullParameter(r100, "record");
            String r102 = r100.getTitle();
            if (r102 != null) goto L5;
        L7:
            r101.setRecordTitle(r102);
            return;
        L5:
            if (r102.length() <= 200) goto L7;
            r102 = r102.substring(0, 200);
            goto L7
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f213903b).size();
    }

    public LinkTagAllAdapter() {
        this.f213902a = com.bytedance.ee.bear.bitable.c.B();
        this.f213903b = new ArrayList();
        this.f213905d = LinkTagAllAdapter$mDeleteListener$1.INSTANCE;
        this.f213906e = LinkTagAllAdapter$mClickListener$1.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (r101 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L12;
        final LinkTagItem r104 = (LinkTagItem) ListProtector.get(this.f213903b, r101);
        r102.T3(r104);
        r102.itemView.setOnClickListener(new f(this, r104));
        r102.itemView.setOnLongClickListener(new AnonymousClass2(this, r102, r104));
        return;
    L12:
        return;
    L5:
        if (r101 >= getItemCount()) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        boolean r103 = this.f213902a;
        int r104 = R.id.highlight_border;
        if (r103 == false) goto L11;
        View r105 = r102.inflate(R.layout.bitable_page_link_rv_item_v2, null, false);
        if (((LKUIRoundedImageView2) ViewBindings.findChildViewById(r105, R.id.highlight_border)) == null) goto L10;
        r104 = R.id.link_record_tag;
        LinkTagView r106 = (LinkTagView) ViewBindings.findChildViewById(r105, R.id.link_record_tag);
        if (r106 == null) goto L10;
        RecyclerView.ViewHolder r107 = new b(new BitablePageLinkRvItemV2Binding((InterceptTouchEventLinearLayout) r105, r106));
    L16:
        return r107;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r105.getResources().getResourceName(r104)));
    L11:
        View r108 = r102.inflate(R.layout.bitable_page_link_rv_item, null, false);
        if (((LKUIRoundedImageView2) ViewBindings.findChildViewById(r108, R.id.highlight_border)) == null) goto L18;
        r104 = R.id.link_record_title;
        BitableCardTitleView r109 = (BitableCardTitleView) ViewBindings.findChildViewById(r108, R.id.link_record_title);
        if (r109 == null) goto L18;
        r107 = new c(new BitablePageLinkRvItemBinding((InterceptTouchEventLinearLayout) r108, r109));
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r108.getResources().getResourceName(r104)));
    }
}
