package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class h extends QFragmentPresenter implements IHybridListViewHolder {

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadStatus r3 = (LoadStatus) r2;
            if (r3 == null) goto L7;
            this.a.e0(r3);
            return;
        }
    }

    static {
    }

    public final boolean C3() {
        return false;
    }

    public final void D() {
    }

    public final void D1(Long r1) {
    }

    public final void K() {
    }

    public abstract QLiveData<LoadStatus> d0();

    public final void g1(int r1, int r2, double r3) {
    }

    public final void m1(int r1, double r2) {
    }

    public final void o() {
    }

    public final void onHide() {
    }

    public final void onRelease() {
    }

    public final void onShow() {
    }

    public h(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public void b0(QModel r3) {
        LoadMoreStatusView r4 = Z().b(2131387793).f();
        e0((LoadStatus) d0().a());
        d0().b(ECQuickUtilKt.a(Y()), new b(this));
    }

    public final void e0(LoadStatus r5) {
        if (r5 == null) goto L11;
        int r6 = i.a[r5.ordinal()];
        if (r6 != 1) goto L8;
        Z().b(2131387793).f().setVisibility(8);
        return;
    L8:
        if (r6 != 2) goto L10;
        LoadMoreStatusView r7 = Z().b(2131387793).f();
        r7.setVisibility(0);
        r7.a();
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
        return;
    L10:
        if (r6 != 3) goto L11;
        Z().b(2131387793).f().b();
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
        UIUtils.displayToast(Y().c(), 2131913855);
        return;
    L11:
        Z().b(2131387793).f().b();
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
    }
}
