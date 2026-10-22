package com.bytedance.awemeopen.domain.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements q34.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentListDomain f198258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f198259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f198260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f198261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f198262e;

    @Override // q34.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        CommentListDomain r101 = this.f198258a;
        String r102 = this.f198259b;
        String r103 = this.f198260c;
        int r104 = this.f198261d;
        b r105 = this.f198262e;
        r101.getClass();
        CommentListDomain.b(r102, r103, r104, r105, null);
    }

    public d(CommentListDomain r100, String r101, String r102, int r103, b r104) {
        this.f198258a = r100;
        this.f198259b = r101;
        this.f198260c = r102;
        this.f198261d = r103;
        this.f198262e = r104;
    }
}
