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
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J0\u0010\u001f\u001a\u00020\u00172&\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\b\u0010 \u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\u0017H\u0002J\b\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u0017H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedCtrlView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/IDocDeletedView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewModel", "Lcom/bytedance/ee/bear/document/restore/DocDeletedViewModel;", "docDeletedView", "Lcom/bytedance/ee/bear/document/restore/DocDeletedView;", "delegate", "Lcom/bytedance/ee/bear/IDocDeletedView$ViewDelegate;", "reportCommonParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "init", "", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "url", "setDelegate", "setTitleBarVisible", "visible", "", "setReportCommonParams", "params", "setBackIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setBackListener", "listener", "Landroid/view/View$OnClickListener;", "setBackIconVisible", "addToParent", "parent", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup$LayoutParams;", "show", SocialConstants.PARAM_APP_DESC, "resId", "", "hide", "initView", "bindView", "bindListener", "Companion", "Provider", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedCtrlView extends FrameLayout implements com.bytedance.ee.bear.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleOwner f221411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DocDeletedViewModel f221412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DocDeletedView f221413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.b.a f221414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, Object> f221415e;

    public static final class a {
    }

    public static final class b implements com.bytedance.ee.bear.c {
        public b() {
        }

        @Override // com.bytedance.ee.bear.c
        public final DocDeletedCtrlView a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new DocDeletedCtrlView(r100, null);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.b
    public final void show() {
        setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.b
    public final void hide() {
        setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.b
    public void setBackIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        DocDeletedView r101 = this.f221413c;
        if (r101 == null) goto L6;
        r101.setBackIcon(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.b
    public void setBackIconVisible(boolean r100) {
        DocDeletedView r101 = this.f221413c;
        if (r101 == null) goto L6;
        r101.setBackIconVisible(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.b
    public void setBackListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        DocDeletedView r101 = this.f221413c;
        if (r101 == null) goto L6;
        r101.setBackListener(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.b
    public void setDelegate(com.bytedance.ee.bear.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f221414d = r100;
    }

    @Override // com.bytedance.ee.bear.b
    public void setReportCommonParams(HashMap<String, Object> r100) {
        this.f221415e = r100;
    }

    @Override // com.bytedance.ee.bear.b
    public void setTitleBarVisible(boolean r100) {
        DocDeletedView r101 = this.f221413c;
        if (r101 == null) goto L6;
        r101.setTitleBarVisible(r100);
        return;
    }

    public DocDeletedCtrlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public final void a(ViewGroup r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != null) goto L5;
        r100.addView(this);
        return;
    L5:
        r100.addView(this, r101);
    }

    @Override // com.bytedance.ee.bear.b
    public final void show(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        DocDeletedView r102 = this.f221413c;
        if (r102 == null) goto L5;
        r102.setDesc(r100);
    L5:
        DocDeletedView r103 = this.f221413c;
        if (r103 == null) goto L8;
        r103.setImageRes(r101);
    L8:
        setVisibility(0);
    }

    public final void b(ViewModelStoreOwner r100, LifecycleOwner r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "url");
        tt5.a.h("DocDeletedCtrlView", "DocDeletedCtrlView.init");
        this.f221411a = r101;
        DocDeletedViewModel r103 = (DocDeletedViewModel) new ViewModelProvider(r100).get(DocDeletedViewModel.class);
        r103.init(r102);
        this.f221412b = r103;
        DocDeletedView r104 = new DocDeletedView(getContext(), null);
        addView(r104);
        this.f221413c = r104;
        DocDeletedViewModel r105 = this.f221412b;
        if (r105 == null) goto L9;
        LifecycleOwner r106 = this.f221411a;
        if (r106 == null) goto L9;
        r105.getCanRestore().observe(r106, new com.bytedance.ee.bear.document.restore.b(this));
        r105.getRestore().observe(r106, new c(this));
    L9:
        DocDeletedView r107 = this.f221413c;
        if (r107 == null) goto L12;
        r107.setDelegate(new com.bytedance.ee.bear.document.restore.a(this));
    L12:
        DocDeletedViewModel r108 = this.f221412b;
        if (r108 == null) goto L16;
        r108.checkFileCanRestore();
        return;
    }
}
