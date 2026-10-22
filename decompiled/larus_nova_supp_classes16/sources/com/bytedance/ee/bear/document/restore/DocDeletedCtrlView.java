package com.bytedance.ee.bear.document.restore;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J0\u0010\u001f\u001a\u00020\u00172&\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\b\u0010 \u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\u0017H\u0002J\b\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u0017H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedCtrlView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/IDocDeletedView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewModel", "Lcom/bytedance/ee/bear/document/restore/DocDeletedViewModel;", "docDeletedView", "Lcom/bytedance/ee/bear/document/restore/DocDeletedView;", "delegate", "Lcom/bytedance/ee/bear/IDocDeletedView$ViewDelegate;", "reportCommonParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "init", "", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "url", "setDelegate", "setTitleBarVisible", "visible", "", "setReportCommonParams", "params", "setBackIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setBackListener", "listener", "Landroid/view/View$OnClickListener;", "setBackIconVisible", "addToParent", "parent", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup$LayoutParams;", "show", "desc", "resId", "", "hide", "initView", "bindView", "bindListener", "Companion", "Provider", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedCtrlView extends FrameLayout implements com.bytedance.ee.bear.b {
    public LifecycleOwner a;
    public DocDeletedViewModel b;
    public DocDeletedView c;
    public com.bytedance.ee.bear.b.a d;
    public HashMap<String, Object> e;

    public static final class a {
    }

    public static final class b implements com.bytedance.ee.bear.c {
        public b() {
        }

        public final DocDeletedCtrlView a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return new DocDeletedCtrlView(r3, null);
        }
    }

    static {
    }

    public final void show() {
        setVisibility(0);
    }

    public final void hide() {
        setVisibility(8);
    }

    public void setBackIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        DocDeletedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setBackIcon(r2);
        return;
    }

    public void setBackIconVisible(boolean r2) {
        DocDeletedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setBackIconVisible(r2);
        return;
    }

    public void setBackListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        DocDeletedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setBackListener(r2);
        return;
    }

    public void setDelegate(com.bytedance.ee.bear.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.d = r2;
    }

    public void setReportCommonParams(HashMap<String, Object> r1) {
        this.e = r1;
    }

    public void setTitleBarVisible(boolean r2) {
        DocDeletedView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setTitleBarVisible(r2);
        return;
    }

    public DocDeletedCtrlView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public final void a(ViewGroup r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != null) goto L5;
        r2.addView(this);
        return;
    L5:
        r2.addView(this, r3);
    }

    public final void show(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        DocDeletedView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setDesc(r2);
    L5:
        DocDeletedView r4 = this.c;
        if (r4 == null) goto L8;
        r4.setImageRes(r3);
    L8:
        setVisibility(0);
    }

    public final void b(ViewModelStoreOwner r3, LifecycleOwner r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "url");
        tt5.a.h("DocDeletedCtrlView", "DocDeletedCtrlView.init");
        this.a = r4;
        DocDeletedViewModel r6 = (DocDeletedViewModel) new ViewModelProvider(r3).get(DocDeletedViewModel.class);
        r6.init(r5);
        this.b = r6;
        DocDeletedView r7 = new DocDeletedView(getContext(), null);
        addView(r7);
        this.c = r7;
        DocDeletedViewModel r8 = this.b;
        if (r8 == null) goto L9;
        LifecycleOwner r9 = this.a;
        if (r9 == null) goto L9;
        r8.getCanRestore().observe(r9, new com.bytedance.ee.bear.document.restore.b(this));
        r8.getRestore().observe(r9, new c(this));
    L9:
        DocDeletedView r10 = this.c;
        if (r10 == null) goto L12;
        r10.setDelegate(new com.bytedance.ee.bear.document.restore.a(this));
    L12:
        DocDeletedViewModel r11 = this.b;
        if (r11 == null) goto L16;
        r11.checkFileCanRestore();
        return;
    }
}
