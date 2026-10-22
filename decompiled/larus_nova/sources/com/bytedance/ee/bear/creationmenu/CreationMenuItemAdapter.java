package com.bytedance.ee.bear.creationmenu;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B'\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u001e\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuItem;", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter$ViewHolder;", "items", "", "isWideItem", "", "isNarrowItem", "<init>", "(Ljava/util/List;ZZ)V", "listener", "Lkotlin/Function2;", "Landroid/view/View;", "", "setOnItemClickListener", "convert", "helper", MapController.ITEM_LAYER_TAG, "Companion", "ViewHolder", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMenuItemAdapter extends BaseQuickAdapter<com.bytedance.ee.bear.creationmenu.a, ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f217266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f217267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super com.bytedance.ee.bear.creationmenu.a, ? super View, Unit> f217268c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter$ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/creationmenu/CreationMenuItemAdapter;Landroid/view/View;)V", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        public ViewHolder(CreationMenuItemAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            super(r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, com.bytedance.ee.bear.creationmenu.a r101) {
        ViewHolder r102 = (ViewHolder) r100;
        com.bytedance.ee.bear.creationmenu.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "helper");
        View r104 = r102.itemView;
        if (r103 == null) goto L7;
        boolean r105 = true;
        if (r103.f217285e != true) goto L7;
    L8:
        if (r105 == false) goto L10;
        float r106 = 1.0f;
    L11:
        r104.setAlpha(r106);
        String r107 = null;
        if (this.f217267b == true) goto L18;
        if (r103 == null) goto L15;
        String r108 = r103.f217283c;
    L16:
        r102.setText(R.id.content_item_title, r108);
        r102.setTextColor(R.id.content_item_title, UDColorUtils.getColor(LarkContext.getApplication(), R.color.text_title));
        goto L18
    L15:
        r108 = null;
    L18:
        if (this.f217266a == false) goto L22;
        if (r103 == null) goto L21;
        r107 = r103.f217284d;
    L21:
        r102.setText(R.id.content_item_text, r107);
        r102.setTextColor(R.id.content_item_text, UDColorUtils.getColor(LarkContext.getApplication(), R.color.text_caption));
    L22:
        if (r103 == null) goto L24;
        r102.setImageResource(R.id.content_item_icon, r103.f217282b);
    L24:
        r102.itemView.setOnClickListener(new b(r103, this, r102));
        return;
    L10:
        r106 = 0.5f;
    L7:
        r105 = false;
        goto L8
    }

    public CreationMenuItemAdapter(List<com.bytedance.ee.bear.creationmenu.a> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        if (r101 == false) goto L5;
        int r103 = R.layout.content_create_menu_item_androidpad;
    L8:
        super(r103, r100);
        this.f217266a = r101;
        this.f217267b = r102;
        return;
    L5:
        if (r102 == false) goto L7;
        r103 = R.layout.content_create_menu_item;
        goto L8
    L7:
        r103 = R.layout.content_create_menu_item_androidpad_normal;
        goto L8
    }
}
