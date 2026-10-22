package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordFooterContainerBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterContainerBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterContainerBinding;", "mData", "getMData", "()Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "setMData", "(Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;)V", "mHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getMHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setMHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "setData", "", "data", "handler", "getTargetFooter", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/FooterChild;", "onParentVerticalScroll", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordFooterContainer extends FrameLayout implements gv4.b<ItemViewRecordFooterData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordFooterContainerBinding f214184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ItemViewRecordFooterData f214185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gv4.a f214186c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f214187a = null;

        static {
            f214187a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public final BitableItemViewRecordFooterContainerBinding getBinding() {
        return this.f214184a;
    }

    public final ItemViewRecordFooterData getMData() {
        return this.f214185b;
    }

    public final gv4.a getMHandler() {
        return this.f214186c;
    }

    public ItemViewRecordFooterContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final FooterChild a(ItemViewRecordFooterData r100) {
        if (r100.getVisible() == true) goto L6;
        return null;
    L6:
        if (r100.getShouldShowSubmitView() == false) goto L10;
        return this.f214184a.f210914d;
    L10:
        if (r100.getShouldShowBottomSwitchView() == false) goto L16;
        if (Intrinsics.areEqual(r100.getShouldShowCommentView(), Boolean.FALSE) == false) goto L16;
        return this.f214184a.f210913c;
    L16:
        if (r100.getShouldShowBottomSwitchView() == false) goto L20;
        return this.f214184a.f210912b;
    L20:
        if (r100.getShouldShowBottomSwitchView() == true) goto L26;
        if (Intrinsics.areEqual(r100.getShouldShowCommentView(), Boolean.TRUE) == false) goto L26;
        return this.f214184a.f210915e;
    L26:
        if (r100.getShouldShowBottomSwitchView() == false) goto L28;
    L33:
        return null;
    L28:
        if (Intrinsics.areEqual(r100.getShouldShowCommentView(), Boolean.FALSE) == false) goto L33;
        if (r100.getButtonList().size() <= 0) goto L33;
        return this.f214184a.f210915e;
    }

    public final void setMData(ItemViewRecordFooterData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214185b = r100;
    }

    public final void setMHandler(gv4.a r100) {
        this.f214186c = r100;
    }

    public ItemViewRecordFooterContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_record_footer_container, this);
        int r102 = R.id.child1;
        ItemViewRecordFooterChild1 r103 = (ItemViewRecordFooterChild1) ViewBindings.findChildViewById(this, R.id.child1);
        if (r103 == null) goto L13;
        r102 = R.id.child2;
        ItemViewRecordFooterChild2 r104 = (ItemViewRecordFooterChild2) ViewBindings.findChildViewById(this, R.id.child2);
        if (r104 == null) goto L13;
        r102 = R.id.child3;
        ItemViewRecordFooterChild3 r105 = (ItemViewRecordFooterChild3) ViewBindings.findChildViewById(this, R.id.child3);
        if (r105 == null) goto L13;
        r102 = R.id.child4;
        ItemViewRecordFooterChild4 r106 = (ItemViewRecordFooterChild4) ViewBindings.findChildViewById(this, R.id.child4);
        if (r106 == null) goto L13;
        this.f214184a = new BitableItemViewRecordFooterContainerBinding(this, r103, r104, r105, r106);
        this.f214185b = new ItemViewRecordFooterData();
        setOnClickListener(a.f214187a);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public final void b(ItemViewRecordFooterData r100, gv4.a r101) {
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterContainer.setData", null, null, null, 14);
        if (r100 == null) goto L11;
        this.f214185b = r100;
        this.f214186c = r101;
        FooterChild r102 = a(r100);
        if (r102 == null) goto L7;
        r102.iq(r100, (t) r101);
    L7:
        BitableItemViewRecordFooterContainerBinding r103 = this.f214184a;
        Iterator r104 = CollectionsKt.listOf(new FooterChild[]{r103.f210912b, r103.f210913c, r103.f210914d, r103.f210915e}).iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        FooterChild r105 = (FooterChild) r104.next();
        com.bytedance.ee.bear.bitable.m.z(r105, Intrinsics.areEqual(r105, r102));
        goto L9
    L14:
        return;
    L11:
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterContainer.setData error path. FooterContainerData is Empty.", null, Boolean.TRUE, null, 10);
    }
}
