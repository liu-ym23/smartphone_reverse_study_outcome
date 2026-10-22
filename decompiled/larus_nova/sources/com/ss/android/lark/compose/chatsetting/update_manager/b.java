package com.ss.android.lark.compose.chatsetting.update_manager;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Hilt_FlowUpdateManagerActivity f417523a;

    public b(Hilt_FlowUpdateManagerActivity r100) {
        this.f417523a = r100;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context r100) {
        Hilt_FlowUpdateManagerActivity r101 = this.f417523a;
        if (r101.f417520a == true) goto L6;
        r101.f417520a = true;
        a r102 = (a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r101)).provideComponent();
        FlowUpdateManagerActivity r103 = (FlowUpdateManagerActivity) UnsafeCasts.unsafeCast(r101);
        r102.x();
        return;
    }
}
