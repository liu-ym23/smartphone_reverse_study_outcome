package com.bytedance.ee.bear.mindnote.setting;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public e a;
    public String b;
    public String c;

    public String getType() {
        return this.c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        e r4 = this.a;
        if (r4 == null) goto L8;
        String r0 = this.b;
        String r1 = this.c;
        MindNoteSettingViewModel r5 = ((MindNoteSettingFragment.a) r4).a.k;
        if (r5 == null) goto L9;
        r5.processOnClick(r0, r1);
        return;
    L9:
        return;
    }

    public f(String r1, MindNoteSettingFragment.a r2) {
        this.b = r1;
        this.c = "structure";
        this.a = r2;
    }
}
