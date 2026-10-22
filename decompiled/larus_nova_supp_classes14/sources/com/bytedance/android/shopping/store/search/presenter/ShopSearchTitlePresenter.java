package com.bytedance.android.shopping.store.search.presenter;

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
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchTitlePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "", "resume", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchTitlePresenter extends ShopSearchBasePresenter {
    public EditText f;
    public ImageView g;
    public ImageView h;
    public View i;
    public boolean j;

    public static final class a implements Runnable {
        public final /* synthetic */ ShopSearchTitlePresenter a;

        public a(ShopSearchTitlePresenter r1) {
            this.a = r1;
        }

        public final void a() {
            EditText r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.requestFocus();
        L5:
            QContext r1 = this.a.u();
            Activity r2 = com.bytedance.android.ec.core.utils.l0.c(r1.c());
            if ((r2 instanceof FragmentActivity) == true) goto L8;
            r2 = null;
        L8:
            if (r2 != null) goto L10;
            r2 = r1.a();
        L10:
            Object r3 = r2.getSystemService("input_method");
            if (r3 == null) goto L15;
            ((InputMethodManager) r3).showSoftInput(this.a.f, 0);
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
        EditText r0 = this.f;
        if (r0 == null) goto L6;
        r0.postDelayed(new a(this), 300);
        return;
    }

    public ShopSearchTitlePresenter() {
    }

    public final void A(QModel r8) {
        this.g = (ImageView) w().b(2131367519).f();
        this.h = (ImageView) w().b(2131367518).f();
        this.i = w().b(2131367521).f();
        Lazy r9 = ECAppInfoService.a;
        JSONObject r1 = null;
        if (we.a.a == true) goto L10;
        ImageView r10 = this.h;
        if (r10 == null) goto L7;
        r10.setVisibility(0);
    L7:
        View r11 = this.i;
        if (r11 == null) goto L26;
        r11.setVisibility(0);
    L26:
        ImageView r12 = this.g;
        if (r12 == null) goto L29;
        r12.setOnClickListener(new f0(this));
    L29:
        ImageView r13 = this.h;
        if (r13 == null) goto L32;
        r13.setOnClickListener(new g0(this));
    L32:
        this.f = (EditText) w().b(2131367525).f();
        List<SearchSuggestWord> r14 = E().getSearchParam().getSearchSuggestWords();
        if (r14 == null) goto L37;
        SearchSuggestWord r15 = (SearchSuggestWord) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L37;
        String r16 = r15.getWord();
    L38:
        EditText r2 = this.f;
        if (r2 == null) goto L49;
        if (r16 != null) goto L42;
    L45:
        boolean r5 = true;
    L46:
        if (r5 == false) goto L48;
        r16 = ag4.a.d(2131895925);
    L48:
        r2.setHint(r16);
        goto L49
    L42:
        if (r16.length() == 0) goto L45;
        r5 = false;
    L49:
        EditText r17 = this.f;
        if (r17 == null) goto L52;
        r17.addTextChangedListener(new h0(this));
    L52:
        EditText r18 = this.f;
        if (r18 == null) goto L55;
        r18.setOnEditorActionListener(new i0(this));
    L55:
        ((TextView) w().b(2131367529).f()).setOnClickListener(new j0(this));
        View r19 = y().findViewById(2131371063);
        if (E().getSearchParam().isSplitMode() == false) goto L59;
        ExtensionsKt.visible(r19);
        r19.setOnClickListener(new d0(this));
    L59:
        if (E().getSearchParam().isSplitMode() == false) goto L64;
        View r20 = y().findViewById(2131367527);
        if (r20 == null) goto L63;
        d2.d(r20, com.bytedance.android.shopping.extensions.b.b(7), 0, com.bytedance.android.shopping.extensions.b.b(0), 0);
    L63:
        View r21 = y().findViewById(2131367520);
        d2.d(r21, 0, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8));
        r21.setPadding(0, 0, 0, 0);
        d2.d(y().findViewById(2131367517), 0, 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
    L64:
        ((ImageView) w().b(2131367527).f()).setOnClickListener(new e0(this));
        int r22 = com.bytedance.android.ec.store.utils.h.a;
        String r23 = E().getSearchParam().getEntranceInfo();
        if ((!StringsKt.isBlank(r23)) == true) goto L68;
        r23 = null;
    L68:
        if (r23 == null) goto L70;
        r1 = z1.g(r23);
    L70:
        com.bytedance.android.ec.store.utils.h.d(r1, "othershow", "shop", E().getAdParams(), "search_middle_ad");
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        E().getSearchContent().b(ECQuickUtilKt.a(u()), new a0(this));
        E().getSearchHint().b(ECQuickUtilKt.a(u()), new b0(this));
        E().getInitSearchText().b(ECQuickUtilKt.a(u()), new c0(this));
        E().getSearchHint().g(E().getSearchParam().getSearchHint());
        E().getInitSearchText().g(E().getSearchParam().getInitSearchText());
        return;
    L37:
        r16 = null;
        goto L38
    L10:
        ImageView r24 = this.h;
        if (r24 == null) goto L13;
        r24.setVisibility(8);
    L13:
        View r25 = this.i;
        if (r25 == null) goto L16;
        r25.setVisibility(8);
    L16:
        ImageView r26 = this.g;
        if (r26 == null) goto L19;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
    L21:
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r27 = null;
    L23:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L26;
        r28.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
        goto L26
    L19:
        r27 = null;
        goto L21
    }

    public static final void G(ShopSearchTitlePresenter r3, ShopSearchBasePresenter.SearchMode r4) {
        QLiveData<String> r0 = r3.E().getSearchHint();
        EditText r1 = r3.f;
        Editable r2 = null;
        if (r1 == null) goto L5;
        CharSequence r5 = r1.getHint();
    L6:
        r0.g(String.valueOf(r5));
        QLiveData<String> r6 = r3.E().getSearchContent();
        EditText r7 = r3.f;
        if (r7 == null) goto L9;
        r2 = r7.getText();
    L9:
        r6.g(String.valueOf(r2));
        r3.E().getSearchParam().setHistory(false);
        r3.F(r4);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
