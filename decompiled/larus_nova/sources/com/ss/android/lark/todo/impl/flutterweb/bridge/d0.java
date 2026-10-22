package com.ss.android.lark.todo.impl.flutterweb.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f444171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f444172c;

    public final String toString() {
        return "TodoShareTaskDetailChat(type='" + this.f444170a + "', chatId='" + this.f444171b + "', threadId=" + this.f444172c + ')';
    }

    public final String getType() {
        return this.f444170a;
    }

    public d0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        this.f444170a = r100;
        this.f444171b = r101;
        this.f444172c = r102;
    }
}
