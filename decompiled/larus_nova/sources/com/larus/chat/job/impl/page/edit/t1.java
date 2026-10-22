package com.larus.chat.job.impl.page.edit;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class t1 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f325340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z.b f325341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f325342c;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        EditText r101 = this.f325340a.f325345a.f325048b;
        q1 r102 = new q1(r101.getSelectionStart(), r101.getSelectionEnd());
        this.f325340a.f325347c.invoke(this.f325341b.f325364a, r102);
        if (r100 == null) goto L5;
        String r103 = r100.toString();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f325342c.invoke(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public t1(u1 r100, z.b r101, e r102) {
        this.f325340a = r100;
        this.f325341b = r101;
        this.f325342c = r102;
    }
}
