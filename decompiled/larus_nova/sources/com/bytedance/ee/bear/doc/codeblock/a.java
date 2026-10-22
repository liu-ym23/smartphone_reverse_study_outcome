package com.bytedance.ee.bear.doc.codeblock;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CodeLanguageSelectionAdapter.ViewHolder f217780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CodeLanguageSelectionAdapter f217781b;

    public a(CodeLanguageSelectionAdapter.ViewHolder r100, CodeLanguageSelectionAdapter r101) {
        this.f217780a = r100;
        this.f217781b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f217780a.f217763a.getText().toString();
        this.f217780a.f217764b.setVisibility(0);
        CodeLanguageSelectionAdapter.a r102 = this.f217781b.f217762c;
        if (r102 == null) goto L5;
        r102.onSelectCodeLanguage(r101);
    L5:
        CodeLanguageSelectionAdapter r103 = this.f217781b;
        r103.f217761b = r101;
        r103.notifyDataSetChanged();
    }
}
