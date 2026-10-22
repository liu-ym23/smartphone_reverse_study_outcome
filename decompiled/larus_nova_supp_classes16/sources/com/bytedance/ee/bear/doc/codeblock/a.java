package com.bytedance.ee.bear.doc.codeblock;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CodeLanguageSelectionAdapter.ViewHolder a;
    public final /* synthetic */ CodeLanguageSelectionAdapter b;

    public a(CodeLanguageSelectionAdapter.ViewHolder r1, CodeLanguageSelectionAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        String r4 = this.a.a.getText().toString();
        this.a.b.setVisibility(0);
        CodeLanguageSelectionAdapter.a r0 = this.b.c;
        if (r0 == null) goto L5;
        r0.onSelectCodeLanguage(r4);
    L5:
        CodeLanguageSelectionAdapter r1 = this.b;
        r1.b = r4;
        r1.notifyDataSetChanged();
    }
}
