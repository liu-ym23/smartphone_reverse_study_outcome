package com.ss.android.ugc.aweme.kiwi.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QIPresenter;", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "<init>", "(Landroid/support/v4/app/Fragment;)V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public abstract class QFragmentPresenter implements QIPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QContext f450893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Query f450894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f450895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f450896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f450897e;

    public abstract void b0(QModel r100);

    public void c0() {
    }

    public final QContext Y() {
        QContext r100 = this.f450893a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("qContext");
    L5:
        return r100;
    }

    public final Query Z() {
        Query r100 = this.f450894b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("query");
    L5:
        return r100;
    }

    public final View a0() {
        View r100 = this.f450895c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void unbind() {
        if (this.f450896d == false) goto L6;
        c0();
        this.f450896d = false;
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final boolean H() {
        return this.f450896d;
    }

    public QFragmentPresenter(Fragment r100) {
        this.f450897e = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void J(QModel r100, View r101, QUIManager r102) {
        this.f450895c = r101;
        QContext r103 = new QContext(r101);
        this.f450893a = r103;
        r103.f450890a = this.f450897e;
        if (r102 == null) goto L8;
        QContext r104 = this.f450893a;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("qContext");
    L7:
        r104.f450891b = r102;
    L8:
        this.f450894b = new Query(r101);
        b0(r100);
        this.f450896d = true;
    }
}
