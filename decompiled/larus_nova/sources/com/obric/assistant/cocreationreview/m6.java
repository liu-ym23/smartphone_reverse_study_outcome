package com.obric.assistant.cocreationreview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: classes32.dex */
public final class m6 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f387391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UsageCardTemplateRenderer f387392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EditText f387393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f387394d;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        UsageCardTemplateRenderer.a(this.f387391a, this.f387392b, this.f387393c, this.f387394d);
    }

    public m6(boolean r100, UsageCardTemplateRenderer r101, EditText r102, TextView r103) {
        this.f387391a = r100;
        this.f387392b = r101;
        this.f387393c = r102;
        this.f387394d = r103;
    }
}
