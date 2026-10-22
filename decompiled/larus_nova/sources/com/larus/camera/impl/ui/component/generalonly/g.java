package com.larus.camera.impl.ui.component.generalonly;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class g implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlbumThumbListComponent f322103a;

    public /* synthetic */ g(AlbumThumbListComponent r100) {
        this.f322103a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((RecyclerView) this.f322103a.f322069p.getValue()).scrollToPosition(0);
        return Unit.INSTANCE;
    }
}
