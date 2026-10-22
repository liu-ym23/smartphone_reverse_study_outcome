package com.bytedance.ee.bear.bitable.celleditor.editor;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0010\u001a\u00020\fJ$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/BaseEditorFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "contentView", "Landroid/view/View;", "contentViewLp", "Landroid/widget/FrameLayout$LayoutParams;", "autoDismiss", "", "dimAmount", "onRequestDismiss", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Landroid/widget/FrameLayout$LayoutParams;ZZLkotlin/jvm/functions/Function0;)V", "dismissed", "markDismissed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onBackPressed", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseEditorFragment extends Fragment implements sa5.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f209328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout.LayoutParams f209329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f209330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f209331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f209332h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseEditorFragment f209333a;

        public a(BaseEditorFragment r100) {
            this.f209333a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f209333a.f209331g.invoke();
        }
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        if (this.f209332h == true) goto L6;
        this.f209332h = true;
        this.f209331g.invoke();
        return true;
    L6:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.f209332h == true) goto L5;
        this.f209332h = true;
        this.f209331g.invoke();
    L5:
        super.onDestroy();
    }

    public BaseEditorFragment(View r100, FrameLayout.LayoutParams r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r102, "onRequestDismiss");
        this.f209328d = r100;
        this.f209329e = r101;
        this.f209330f = true;
        this.f209331g = r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = requireContext();
        FrameLayout r104 = new FrameLayout(r103);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.f209330f == false) goto L5;
        View r105 = new View(r103);
        r105.setOnClickListener(new a(this));
        r104.addView(r105, new FrameLayout.LayoutParams(-1, -1));
    L5:
        ViewParent r106 = this.f209328d.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L8;
        ViewGroup r107 = (ViewGroup) r106;
    L9:
        if (r107 == null) goto L12;
        r107.removeView(this.f209328d);
    L12:
        if (this.f209329e != null) goto L14;
        this.f209329e = new FrameLayout.LayoutParams(-1, -2);
    L14:
        FrameLayout.LayoutParams r108 = this.f209329e;
        if (r108 == null) goto L17;
        r108.gravity = 80;
    L17:
        r104.addView(this.f209328d, r108);
        return r104;
    L8:
        r107 = null;
        goto L9
    }
}
