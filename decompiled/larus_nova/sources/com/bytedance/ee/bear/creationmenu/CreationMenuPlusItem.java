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
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010 \u001a\u00020\u001b2\b\b\u0001\u0010!\u001a\u00020\u0007H\u0002J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/creationmenu/CreationMenuPlusItem;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMenuItemClickListener", "Lcom/bytedance/ee/bear/creationmenu/CreationMenuPlusItemClickListener;", "mWikiItemClickListener", "Lcom/bytedance/ee/bear/creationmenu/IWikiItemClickListener;", "mMenuKey", "", "mImageView", "Landroid/widget/ImageView;", "mTextView", "Landroid/widget/TextView;", "menuItem", "Lcom/bytedance/ee/bear/content/creation/mvp/SelectCreationMenuItem;", "wikiMenuItem", "Lcom/bytedance/ee/bear/creationmenu/SelectItem;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "initViews", "", "initMenuKey", "menuKey", "initText", "text", "initIconRes", "iconRes", "setMenuItemClickListener", "menuItemClickListener", "setWikiMenuItemClickListener", "Companion", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMenuPlusItem extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f217269h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f217270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f217271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f217272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f217273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SelectCreationMenuItem f217274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f217275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f217276g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationMenuPlusItem f217277a;

        public b(CreationMenuPlusItem r100) {
            this.f217277a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CreationMenuPlusItem r101 = this.f217277a;
            SelectCreationMenuItem r102 = r101.f217274e;
            if (r102 == null) goto L8;
            e r103 = r101.f217270a;
            if (r103 == null) goto L9;
            r103.a(r102);
            return;
        L9:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationMenuPlusItem f217278a;

        public c(CreationMenuPlusItem r100) {
            this.f217278a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CreationMenuPlusItem r101 = this.f217278a;
            g r102 = r101.f217275f;
            if (r102 == null) goto L8;
            f r103 = r101.f217271b;
            if (r103 == null) goto L9;
            r103.a(r102);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public /* synthetic */ CreationMenuPlusItem(Context r100) {
        this(r100, null, 0);
    }

    public final void setMenuItemClickListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItemClickListener");
        this.f217270a = r100;
        b r101 = new b(this);
        this.f217276g = r101;
        setOnClickListener(r101);
    }

    public final void setWikiMenuItemClickListener(f r100) {
        this.f217271b = r100;
        c r101 = new c(this);
        this.f217276g = r101;
        setOnClickListener(r101);
    }

    public CreationMenuPlusItem(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = UIHelper.dp2px(12.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, UIHelper.dp2px(50.0f)));
        setPadding(r103, 0, r103, 0);
        setMinimumWidth(UIHelper.dp2px(162.0f));
        setBackgroundResource(R.drawable.ccm_popupwindow_top_btn);
        setGravity(16);
        this.f217272c = new ImageView(r100);
        int r104 = UIHelper.dp2px(20.0f);
        ViewGroup.LayoutParams r105 = new LinearLayout.LayoutParams(r104, r104);
        View r106 = this.f217272c;
        View r107 = null;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        r106 = null;
    L5:
        addView(r106, r105);
        TextView r108 = new TextView(r100);
        this.f217273d = r108;
        r108.setGravity(16);
        TextView r109 = this.f217273d;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r109 = null;
    L8:
        r109.setTextColor(UDColorUtils.getColor(r100, R.color.text_title));
        TextView r110 = this.f217273d;
        if (r110 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r110 = null;
    L11:
        r110.setTextSize(16.0f);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -1);
        r111.leftMargin = UIHelper.dp2px(12.0f);
        View r112 = this.f217273d;
        if (r112 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L15:
        addView(r107, r111);
        return;
    L14:
        r107 = r112;
        goto L15
    }
}
