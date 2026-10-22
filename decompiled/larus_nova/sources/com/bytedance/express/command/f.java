package com.bytedance.express.command;

import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public final class f<T> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f243204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Primitive f243205b;

    @Override // com.bytedance.express.command.b
    public final Instruction b() {
        int r100 = ((CommandType.ValueCommand.getCode() << 14) | (this.f243205b.getCode() << 10)) | 1;
        Object r101 = this.f243204a;
        if (r101 != null) goto L6;
        r101 = "null";
    L6:
        return new Instruction(r100, r101);
    }

    public f(T r100, Primitive r101) {
        this.f243204a = r100;
        this.f243205b = r101;
    }

    @Override // com.bytedance.express.command.b
    public final void a(Stack<Object> r100, v97.c r101, com.bytedance.express.c r102) {
        r100.push(this.f243204a);
    }
}
