package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o extends com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<String[]> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f212006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EditText f212007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f212008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String[] f212009l;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f212010a;

        public a(o r100) {
            this.f212010a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.f212010a.f212007j, null);     // Catch: Throwable -> L4
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
        String[] r100 = this.f212008k;
        String r101 = this.f212007j.getText().toString();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        String[] r102 = {r101};
    L7:
        return !Arrays.equals(r100, r102);
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final String[] c() {
        String r100 = this.f212007j.getText().toString();
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return new String[]{r100};
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public final View getView() {
        return this.f212006i;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void g(String[] r100) {
        this.f212009l = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final void h(String[] r100) {
        String[] r101 = r100;
        this.f212008k = r101;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        String r104 = r101[0];
    L28:
        if (r104 != null) goto L30;
    L33:
        if (r102 == true) goto L36;
        this.f212007j.setText(r104);
        this.f212007j.requestFocus();
        return;
    L36:
        return;
    L30:
        if (r104.length() == 0) goto L33;
        r102 = false;
        goto L33
    L14:
        String[] r105 = this.f212009l;
        if (r105 != null) goto L17;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L27;
        if (r105 == null) goto L27;
        r104 = (String) ArraysKt.getOrNull(r105, 0);
    L27:
        r104 = null;
        goto L28
    L17:
        if (r105.length != 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L23;
        r106 = false;
        goto L24
    L19:
        r107 = false;
        goto L20
    L5:
        if (r101.length != 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L11;
        r103 = false;
        goto L12
    L7:
        r108 = false;
        goto L8
    }

    public o(Context r100, FilterFieldOption r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        EFieldType r102 = null;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_number_filter_value_view, null);
        this.f212006i = r103;
        EditText r104 = (EditText) r103.findViewById(R.id.input_et);
        this.f212007j = r104;
        if (r101 == null) goto L6;
        r102 = r101.getValueFieldType();
    L6:
        if (r102 != EFieldType.PHONE) goto L8;
        r104.setInputType(3);
    L8:
        r104.post(new a(this));
    }
}
