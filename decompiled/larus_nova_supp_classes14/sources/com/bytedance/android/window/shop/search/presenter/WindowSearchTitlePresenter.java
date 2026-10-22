package com.bytedance.android.window.shop.search.presenter;

import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchTitlePresenter;", "Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter;", "", "resume", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchTitlePresenter extends WindowSearchBasePresenter {
    public WindowSearchViewModel f;
    public EditText g;
    public ImageView h;
    public ImageView i;
    public View j;
    public boolean k;

    public static final class a implements Runnable {
        public final /* synthetic */ WindowSearchTitlePresenter a;

        public a(WindowSearchTitlePresenter r1) {
            this.a = r1;
        }

        public final void a() {
            EditText r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.requestFocus();
        L5:
            QContext r1 = this.a.u();
            Activity r2 = l0.c(r1.c());
            if ((r2 instanceof FragmentActivity) == true) goto L8;
            r2 = null;
        L8:
            if (r2 != null) goto L10;
            r2 = r1.a();
        L10:
            Object r3 = r2.getSystemService("input_method");
            if (r3 == null) goto L15;
            ((InputMethodManager) r3).showSoftInput(this.a.g, 0);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        EditText r0 = this.g;
        if (r0 == null) goto L6;
        r0.postDelayed(new a(this), 300);
        return;
    }

    public WindowSearchTitlePresenter() {
    }

    public static final /* synthetic */ WindowSearchViewModel E(WindowSearchTitlePresenter r1) {
        WindowSearchViewModel r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    @Override // com.bytedance.android.window.shop.search.presenter.WindowSearchBasePresenter
    public final void A(QModel r6) {
        super.A(r6);
        this.f = ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
        this.h = (ImageView) w().b(2131367519).f();
        this.i = (ImageView) w().b(2131367518).f();
        this.j = w().b(2131367521).f();
        ImageView r7 = this.i;
        if (r7 == null) goto L5;
        r7.setVisibility(8);
    L5:
        View r8 = this.j;
        if (r8 == null) goto L8;
        r8.setVisibility(8);
    L8:
        ImageView r9 = this.h;
        ViewGroup.LayoutParams r1 = null;
        if (r9 == null) goto L11;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L13:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r1 = r10;
    L16:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L19;
        r2.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
    L19:
        ImageView r11 = this.h;
        if (r11 == null) goto L22;
        r11.setOnClickListener(new w(this));
    L22:
        ImageView r12 = this.i;
        if (r12 == null) goto L25;
        r12.setOnClickListener(new x(this));
    L25:
        EditText r13 = (EditText) w().b(2131367525).f();
        this.g = r13;
        r13.setHint(ag4.a.d(2131895922));
        EditText r14 = this.g;
        if (r14 == null) goto L28;
        r14.addTextChangedListener(new y(this));
    L28:
        EditText r15 = this.g;
        if (r15 == null) goto L31;
        r15.setOnEditorActionListener(new z(this));
    L31:
        ((TextView) w().b(2131367529).f()).setOnClickListener(new a0(this));
        ((ImageView) w().b(2131367527).f()).setOnClickListener(new b0(this));
        int r16 = com.bytedance.android.ec.window.base.utils.i.a;
        WindowSearchViewModel r17 = this.f;
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        JSONObject r18 = z1.g(r17.getSearchParam().getEntranceInfo());
        WindowSearchViewModel r3 = this.f;
        if (r3 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        com.bytedance.android.ec.window.base.utils.i.e(r18, "othershow", "shop", r3.getAdParams(), "search_middle_ad");
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        WindowSearchViewModel r19 = this.f;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        r19.getSearchContent().b(ECQuickUtilKt.a(u()), new u(this));
        WindowSearchViewModel r20 = this.f;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r20.getSearchHint().b(ECQuickUtilKt.a(u()), new v(this));
        return;
    L11:
        r10 = null;
        goto L13
    }

    public static final void F(WindowSearchTitlePresenter r4, WindowSearchBasePresenter.SearchMode r5) {
        WindowSearchViewModel r0 = r4.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        QLiveData<String> r1 = r0.getSearchHint();
        EditText r2 = r4.g;
        Editable r3 = null;
        if (r2 == null) goto L8;
        CharSequence r6 = r2.getHint();
    L9:
        r1.g(String.valueOf(r6));
        WindowSearchViewModel r7 = r4.f;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        QLiveData<String> r8 = r7.getSearchContent();
        EditText r9 = r4.g;
        if (r9 == null) goto L15;
        r3 = r9.getText();
    L15:
        r8.g(String.valueOf(r3));
        WindowSearchViewModel r10 = r4.f;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r10.getSearchParam().setHistory(false);
        r4.D(r5);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
