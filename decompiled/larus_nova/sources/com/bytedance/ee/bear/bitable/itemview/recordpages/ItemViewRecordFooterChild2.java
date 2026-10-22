package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordFooterChild2Binding;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterChild2;", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/FooterChild;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild2Binding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordFooterChild2Binding;", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordFooterChild2 extends FooterChild {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordFooterChild2Binding f214173a;

    public final BitableItemViewRecordFooterChild2Binding getBinding() {
        return this.f214173a;
    }

    public ItemViewRecordFooterChild2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ItemViewRecordFooterChild2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_record_footer_child2, this);
        int r102 = R.id.next_record;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.next_record);
        if (r103 == null) goto L13;
        r102 = R.id.pre_record;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.pre_record);
        if (r104 == null) goto L13;
        r102 = R.id.record_index;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.record_index);
        if (r105 == null) goto L13;
        r102 = R.id.switch_card_view;
        if (((UDShadowLayout) ViewBindings.findChildViewById(this, R.id.switch_card_view)) == null) goto L13;
        this.f214173a = new BitableItemViewRecordFooterChild2Binding(this, r103, r104, r105);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    @Override // gv4.b
    public final void iq(Object r100, t r101) {
        ItemViewRecordFooterData r102 = (ItemViewRecordFooterData) r100;
        if (r102 == null) goto L14;
        com.bytedance.ee.bear.bitable.itemview.util.l.a("ItemViewRecordFooterChild2.setData", null, null, null, 14);
        this.f214173a.f210897d.setText(r102.getIndexText());
        TextView r103 = this.f214173a.f210897d;
        String r104 = r102.getIndexText();
        boolean r105 = false;
        if (r104 != null) goto L7;
    L12:
        com.bytedance.ee.bear.bitable.m.z(r103, r105);
        this.f214173a.f210896c.setOnClickListener(new g(r101));
        this.f214173a.f210896c.setEnabled(r102.enableScrollLeft());
        this.f214173a.f210895b.setOnClickListener(new h(r101));
        this.f214173a.f210895b.setEnabled(r102.enableScrollRight());
        return;
    L7:
        if (r104.length() <= 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 != true) goto L12;
        r105 = true;
        goto L12
    L9:
        r106 = false;
        goto L10
    }
}
