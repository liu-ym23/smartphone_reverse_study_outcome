package com.ss.android.lark.compose.chatsetting.quit;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_QuitGroupActivity f417478a;

    public a(Hilt_QuitGroupActivity r100) {
        this.f417478a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_QuitGroupActivity r101 = this.f417478a;
        if (r101.f417477a == true) goto L6;
        r101.f417477a = true;
        b r102 = (b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        QuitGroupActivity r103 = (QuitGroupActivity) UnsafeCasts.unsafeCast(r101);
        r102.v();
        return;
    }
}
