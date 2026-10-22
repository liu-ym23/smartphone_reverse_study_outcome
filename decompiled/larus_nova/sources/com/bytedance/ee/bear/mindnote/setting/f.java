package com.bytedance.ee.bear.mindnote.setting;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f234467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f234468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f234469c;

    public String getType() {
        return this.f234469c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e r101 = this.f234467a;
        if (r101 == null) goto L8;
        String r102 = this.f234468b;
        String r103 = this.f234469c;
        MindNoteSettingViewModel r104 = ((MindNoteSettingFragment.a) r101).f234457a.f234455k;
        if (r104 == null) goto L9;
        r104.processOnClick(r102, r103);
        return;
    L9:
        return;
    }

    public f(String r100, MindNoteSettingFragment.a r101) {
        this.f234468b = r100;
        this.f234469c = "structure";
        this.f234467a = r101;
    }
}
