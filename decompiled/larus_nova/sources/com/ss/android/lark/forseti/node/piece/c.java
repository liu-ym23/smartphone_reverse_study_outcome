package com.ss.android.lark.forseti.node.piece;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes36.dex */
public final class c<O> implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiNodePiece f424568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f424569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f424570c;

    public c(ForsetiNodePiece r100, Fragment r101, String r102) {
        this.f424568a = r100;
        this.f424569b = r101;
        this.f424570c = r102;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object r100) {
        ActivityResult r101 = (ActivityResult) r100;
        ForsetiNodePiece.b r102 = this.f424568a.f424549r.pollFirst();
        if (r102 == null) goto L7;
        int r103 = r102.f424559b;
        this.f424569b.onActivityResult(r103, r101.getResultCode(), r101.getData());
        ForsetiNodePiece.e(this.f424568a, this.f424570c);
        return;
    }
}
