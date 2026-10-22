package com.ss.android.ugc.aweme.kiwi.presenter;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/presenter/QGroupPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QIPresenter;", "<init>", "()V", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public class QGroupPresenter implements QIPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<QIPresenter> f450898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f450899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f450900c;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void unbind() {
        if (this.f450900c == false) goto L11;
        Iterator<QIPresenter> r100 = this.f450898a.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        r100.next().unbind();
        goto L6
    L8:
        this.f450900c = false;
        return;
    }

    public QGroupPresenter() {
        this.f450898a = new ArrayList();
        this.f450899b = new ArrayList();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final boolean H() {
        return this.f450900c;
    }

    public final void a(QIPresenter r100) {
        this.f450898a.add(r100);
        this.f450899b.add(0);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter
    public final void J(QModel r100, View r101, QUIManager r102) {
        int r103 = this.f450898a.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L16;
        Integer r105 = (Integer) ListProtector.get(this.f450899b, r104);
        if (r105 != null) goto L8;
    L10:
        QIPresenter r106 = (QIPresenter) ListProtector.get(this.f450898a, r104);
        View r107 = r101.findViewById(((Number) ListProtector.get(this.f450899b, r104)).intValue());
        if (r107 == null) goto L15;
        r106.J(r100, r107, r102);
    L13:
        r104 = r104 + 1;
        goto L3
    L15:
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    L8:
        if (r105.intValue() != 0) goto L10;
        ((QIPresenter) ListProtector.get(this.f450898a, r104)).J(r100, r101, r102);
        goto L13
    L16:
        this.f450900c = true;
    }
}
