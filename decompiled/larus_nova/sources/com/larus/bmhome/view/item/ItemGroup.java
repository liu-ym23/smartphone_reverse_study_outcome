package com.larus.bmhome.view.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\r¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/item/ItemGroup;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "singleSelectOn", "view", "Lcom/larus/bmhome/view/item/ItemTextSelector;", "allSelectOff", "updateChildViewBackground", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemGroup extends LinearLayout {
    public final void c() {
        ArrayList r100 = new ArrayList();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        int r103 = 1;
        if (r102 >= r101) goto L14;
        View r104 = getChildAt(r102);
        if ((r104 instanceof ItemTextView) == false) goto L13;
        if (r104.getVisibility() == 0) goto L11;
        r103 = 0;
    L11:
        if (r103 == 0) goto L13;
        r100.add(r104);
    L13:
        r102 = r102 + 1;
        goto L3
    L14:
        int r105 = r100.size();
        if (r105 != 0) goto L18;
        e1.o(this);
        return;
    L18:
        int r106 = c.b(R.attr.larus_bg_item_selector_only, getContext(), R.drawable.larus_bg_item_selector_only);
        int r107 = c.b(R.attr.larus_bg_item_selector_first, getContext(), R.drawable.larus_bg_item_selector_first);
        int r108 = c.b(R.attr.larus_bg_item_selector_middle, getContext(), R.drawable.larus_bg_item_selector_middle);
        int r109 = c.b(R.attr.larus_bg_item_selector_last, getContext(), R.drawable.larus_bg_item_selector_last);
        if (r105 != 1) goto L21;
        ((ItemTextView) ListProtector.get(r100, 0)).setBackgroundResource(r106);
        return;
    L21:
        ((ItemTextView) CollectionsKt.first(r100)).setBackgroundResource(r107);
        int r110 = r105 - 1;
    L22:
        if (r103 >= r110) goto L24;
        ((ItemTextView) ListProtector.get(r100, r103)).setBackgroundResource(r108);
        r103 = r103 + 1;
        goto L22
    L24:
        ((ItemTextView) CollectionsKt.last(r100)).setBackgroundResource(r109);
    }

    public ItemGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a(r100, null);
    }

    public final void b(ItemTextSelector r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator<View> r101 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        View r102 = r101.next();
        r102.setSelected(Intrinsics.areEqual(r102, r100));
        goto L4
    }

    public ItemGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        setOrientation(1);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.background, android.R.attr.divider, android.R.attr.radius, android.R.attr.showDividers});
        setBackgroundResource(r102.getResourceId(0, c.b(R.attr.larus_bg_setting_group, r100, R.drawable.larus_bg_setting_group)));
        setShowDividers(r102.getInt(3, 2));
        setDividerDrawable(ContextCompat.getDrawable(r100, r102.getResourceId(1, c.b(R.attr.larus_bg_divider, r100, R.drawable.larus_bg_divider))));
        r102.recycle();
    }

    public ItemGroup(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        a(r100, r101);
    }
}
