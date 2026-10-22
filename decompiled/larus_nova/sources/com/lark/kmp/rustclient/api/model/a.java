package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Command f282465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f282466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StreamDataSource f282467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.lark.kmp.server.pb.improto.Command f282468d;

    public final Command a() {
        if (this.f282468d != null) goto L6;
        return this.f282465a;
    L6:
        return Command.POST_GATEWAY;
    }

    public a(Command r100, String r101, StreamDataSource r102, com.lark.kmp.server.pb.improto.Command r103) {
        this.f282465a = r100;
        this.f282466b = r101;
        this.f282467c = r102;
        this.f282468d = r103;
    }
}
