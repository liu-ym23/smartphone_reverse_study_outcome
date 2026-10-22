package com.larus.bmhome.music.player;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements a.InterfaceC4089a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f312948a;

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void FK() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Lf() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Lr() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void OK() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Pe(float r100, boolean r101) {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void UY() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void f20() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void hideLoadingView() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void mP(int r100, boolean r101) {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void showLoadingView() {
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void F6() {
        a.InterfaceC4089a.C4090a.b();
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final CoroutineScope getScope() {
        return GlobalScope.INSTANCE;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final Context getViewContext() {
        return this.f312948a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContext");
        this.f312948a = r100;
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void GP(Map<String, String> r100) {
        a.InterfaceC4089a.C4090a.d(r100);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void Ij(Map<String, String> r100) {
        a.InterfaceC4089a.C4090a.c(r100);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void eb(Map<String, String> r100) {
        a.InterfaceC4089a.C4090a.a(r100);
    }

    @Override // com.larus.bmhome.music.player.a.InterfaceC4089a
    public final void r30(String r100, Map<String, String> r101) {
        a.InterfaceC4089a.C4090a.e(r100, r101);
    }
}
