package com.ss.android.lark.locationmessage.message;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements ListenerParams.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationMessageCell.LocationMessageViewHolder f431312a;

    public c(LocationMessageCell.LocationMessageViewHolder r100) {
        this.f431312a = r100;
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void a(Exception r100) {
        this.f431312a.mLoadingProgress.setVisibility(8);
    }

    @Override // com.ss.android.lark.image.entity.ListenerParams.b
    public final void b(Object r100, Object r101, DataSource r102, boolean r103) {
        this.f431312a.mLoadingProgress.setVisibility(8);
    }
}
