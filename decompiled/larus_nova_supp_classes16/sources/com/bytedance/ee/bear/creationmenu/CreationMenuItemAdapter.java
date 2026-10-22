package com.bytedance.ee.bear.creationmenu;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B'\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u001e\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuItem;", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter$ViewHolder;", "items", "", "isWideItem", "", "isNarrowItem", "<init>", "(Ljava/util/List;ZZ)V", "listener", "Lkotlin/Function2;", "Landroid/view/View;", "", "setOnItemClickListener", "convert", "helper", "item", "Companion", "ViewHolder", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMenuItemAdapter extends BaseQuickAdapter<com.bytedance.ee.bear.creationmenu.a, ViewHolder> {
    public final boolean a;
    public final boolean b;
    public Function2<? super com.bytedance.ee.bear.creationmenu.a, ? super View, Unit> c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter$ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter;Landroid/view/View;)V", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        public ViewHolder(CreationMenuItemAdapter r1, View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void convert(BaseViewHolder r5, Object r6) {
        ViewHolder r7 = (ViewHolder) r5;
        com.bytedance.ee.bear.creationmenu.a r8 = (com.bytedance.ee.bear.creationmenu.a) r6;
        Intrinsics.checkNotNullParameter(r7, "helper");
        View r0 = ((RecyclerView.ViewHolder) r7).itemView;
        if (r8 == null) goto L7;
        boolean r2 = true;
        if (r8.e != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        float r1 = 1.0f;
    L11:
        r0.setAlpha(r1);
        String r3 = null;
        if (this.b == true) goto L18;
        if (r8 == null) goto L15;
        String r4 = r8.c;
    L16:
        r7.setText(2131367830, r4);
        r7.setTextColor(2131367830, UDColorUtils.getColor(LarkContext.getApplication(), 2131106622));
        goto L18
    L15:
        r4 = null;
    L18:
        if (this.a == false) goto L22;
        if (r8 == null) goto L21;
        r3 = r8.d;
    L21:
        r7.setText(2131367829, r3);
        r7.setTextColor(2131367829, UDColorUtils.getColor(LarkContext.getApplication(), 2131106607));
    L22:
        if (r8 == null) goto L24;
        r7.setImageResource(2131367828, r8.b);
    L24:
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new b(r8, this, r7));
        return;
    L10:
        r1 = 0.5f;
    L7:
        r2 = false;
        goto L8
    }

    public CreationMenuItemAdapter(List<com.bytedance.ee.bear.creationmenu.a> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        if (r3 == false) goto L5;
        int r0 = 2131559931;
    L8:
        super(r0, r2);
        this.a = r3;
        this.b = r4;
        return;
    L5:
        if (r4 == false) goto L7;
        r0 = 2131559930;
        goto L8
    L7:
        r0 = 2131559932;
        goto L8
    }
}
