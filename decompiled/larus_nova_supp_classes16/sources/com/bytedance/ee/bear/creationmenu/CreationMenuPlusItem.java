package com.bytedance.ee.bear.creationmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010 \u001a\u00020\u001b2\b\b\u0001\u0010!\u001a\u00020\u0007H\u0002J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationMenuPlusItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMenuItemClickListener", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuPlusItemClickListener;", "mWikiItemClickListener", "Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;", "mMenuKey", "", "mImageView", "Landroid/widget/ImageView;", "mTextView", "Landroid/widget/TextView;", "menuItem", "Lcom/bytedance/ee/bear/content/creation/mvp/SelectCreationMenuItem;", "wikiMenuItem", "Lcom/bytedance/ee/bear/creationmenu/SelectItem;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "initViews", "", "initMenuKey", "menuKey", "initText", "text", "initIconRes", "iconRes", "setMenuItemClickListener", "menuItemClickListener", "setWikiMenuItemClickListener", "Companion", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMenuPlusItem extends LinearLayout {
    public static final /* synthetic */ int h = 0;
    public e a;
    public f b;
    public ImageView c;
    public TextView d;
    public SelectCreationMenuItem e;
    public g f;
    public View.OnClickListener g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CreationMenuPlusItem a;

        public b(CreationMenuPlusItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CreationMenuPlusItem r3 = this.a;
            SelectCreationMenuItem r0 = r3.e;
            if (r0 == null) goto L8;
            e r4 = r3.a;
            if (r4 == null) goto L9;
            r4.a(r0);
            return;
        L9:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CreationMenuPlusItem a;

        public c(CreationMenuPlusItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CreationMenuPlusItem r3 = this.a;
            g r0 = r3.f;
            if (r0 == null) goto L8;
            f r4 = r3.b;
            if (r4 == null) goto L9;
            r4.a(r0);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public /* synthetic */ CreationMenuPlusItem(Context r3) {
        this(r3, null, 0);
    }

    public final void setMenuItemClickListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItemClickListener");
        this.a = r2;
        b r3 = new b(this);
        this.g = r3;
        setOnClickListener(r3);
    }

    public final void setWikiMenuItemClickListener(f r1) {
        this.b = r1;
        c r2 = new c(this);
        this.g = r2;
        setOnClickListener(r2);
    }

    public CreationMenuPlusItem(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        int r8 = UIHelper.dp2px(12.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, UIHelper.dp2px(50.0f)));
        setPadding(r8, 0, r8, 0);
        setMinimumWidth(UIHelper.dp2px(162.0f));
        setBackgroundResource(2131232574);
        setGravity(16);
        this.c = new ImageView(r5);
        int r0 = UIHelper.dp2px(20.0f);
        ViewGroup.LayoutParams r1 = new LinearLayout.LayoutParams(r0, r0);
        View r2 = this.c;
        View r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        r2 = null;
    L5:
        addView(r2, r1);
        TextView r4 = new TextView(r5);
        this.d = r4;
        r4.setGravity(16);
        TextView r9 = this.d;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r9 = null;
    L8:
        r9.setTextColor(UDColorUtils.getColor(r5, 2131106622));
        TextView r10 = this.d;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r10 = null;
    L11:
        r10.setTextSize(16.0f);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -1);
        r11.leftMargin = UIHelper.dp2px(12.0f);
        View r12 = this.d;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L15:
        addView(r3, r11);
        return;
    L14:
        r3 = r12;
        goto L15
    }
}
