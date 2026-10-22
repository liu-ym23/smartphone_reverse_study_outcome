package com.larus.bmhome.view;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class a implements e6a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f315607a;

    public /* synthetic */ a(int r100) {
        this.f315607a = r100;
    }

    @Override // e6a.d
    public final Object getValue() {
        int r100 = this.f315607a;
        int r101 = BaseTextAnswerActionButton.f315380a;
        return new PorterDuffColorFilter(r100, PorterDuff.Mode.SRC_ATOP);
    }
}
