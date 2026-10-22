package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Object> f429273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Spannable f429274b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public i(List<Object> r100, Spannable r101) {
        this.f429273a = r100;
        this.f429274b = r101;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Log.i("SpannableBuilderCompat", "execute removeSpanOnReplace, result count is " + this.f429273a.size());
        List<Object> r104 = this.f429273a;
        Spannable r105 = this.f429274b;
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r105.removeSpan(r106.next());
        goto L4
    L6:
        this.f429274b.removeSpan(this);
    }
}
