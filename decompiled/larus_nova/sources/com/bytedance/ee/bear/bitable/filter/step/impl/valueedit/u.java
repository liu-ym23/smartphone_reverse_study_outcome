package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class u extends com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<Object> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f212024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EditText f212025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f212026k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f212027a;

        public a(u r100) {
            this.f212027a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.f212027a.f212025j, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final boolean b() {
        Object r100 = this.f212026k;
        if ((r100 instanceof String) == false) goto L5;
        String r101 = (String) r100;
    L6:
        if (r101 == null) goto L10;
        boolean r102 = TextUtils.equals(r101, this.f212025j.getText());
    L9:
        return !r102;
    L10:
        r102 = Intrinsics.areEqual(r100, c());
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final Object c() {
        String r100 = this.f212025j.getText().toString();
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return new String[]{r100};
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final View getView() {
        return this.f212024i;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void h(Object r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof List) == false) goto L10;
        if ((!((Collection) r100).isEmpty()) == false) goto L10;
        this.f212026k = ListProtector.get((List) r100, 0);
    L18:
        Object r101 = this.f212026k;
        if ((r101 instanceof String) == false) goto L22;
        EditText r102 = this.f212025j;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.String");
        r102.setText((String) r101);
        this.f212025j.requestFocus();
        return;
    L22:
        return;
    L10:
        if ((r100 instanceof Object[]) == false) goto L18;
        Object[] r103 = (Object[]) r100;
        if (r103.length != 0) goto L14;
        boolean r104 = true;
    L16:
        if ((!r104) == false) goto L18;
        this.f212026k = r103[0];
        goto L18
    L14:
        r104 = false;
        goto L16
    }

    public u(Context r100, FilterFieldOption r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_text_filter_value_view, null);
        this.f212024i = r102;
        EditText r103 = (EditText) r102.findViewById(R.id.input_et);
        this.f212025j = r103;
        r103.post(new a(this));
    }
}
