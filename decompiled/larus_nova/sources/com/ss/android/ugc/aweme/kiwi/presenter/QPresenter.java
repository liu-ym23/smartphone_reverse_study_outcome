package com.ss.android.ugc.aweme.kiwi.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QIPresenter;", "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public abstract class QPresenter implements QIPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public QContext f450901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Query f450902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f450903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f450904d;

    public QPresenter() {
    }

    public abstract void A(QModel r100);

    public void C() {
    }

    public final QContext u() {
        QContext r100 = this.f450901a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("qContext");
    L5:
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void unbind() {
        if (this.f450904d == false) goto L6;
        C();
        this.f450904d = false;
        return;
    }

    public final Query w() {
        Query r100 = this.f450902b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("query");
    L5:
        return r100;
    }

    public final View y() {
        View r100 = this.f450903c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final boolean H() {
        return this.f450904d;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void J(QModel r100, View r101, QUIManager r102) {
        this.f450903c = r101;
        QContext r103 = new QContext(r101);
        this.f450901a = r103;
        if (r102 == null) goto L5;
        r103.f450891b = r102;
    L5:
        this.f450902b = new Query(r101);
        A(r100);
        this.f450904d = true;
    }
}
