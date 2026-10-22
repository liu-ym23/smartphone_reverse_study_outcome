package com.bytedance.express.command;

import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class IdentifierCommand extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243194a;

    @Override // com.bytedance.express.command.b
    public final Instruction b() {
        return new Instruction(((CommandType.IdentifierCommand.getCode() << 14) | (Primitive.STRING.getCode() << 10)) | 1, this.f243194a);
    }

    public final String getIdentifier() {
        return this.f243194a;
    }

    public IdentifierCommand(String r100) {
        this.f243194a = r100;
    }

    @Override // com.bytedance.express.command.b
    public final void a(Stack<Object> r100, v97.c r101, com.bytedance.express.c r102) {
        long r103 = System.nanoTime();
        if (Intrinsics.areEqual("null", this.f243194a) == false) goto L5;
        r100.push(null);
    L5:
        final Object r104 = r101.getValue(this.f243194a);
        r102.f243188d += System.nanoTime() - r103;
        int r105 = com.bytedance.express.util.a.f243211a;
        com.bytedance.express.util.a.a(4, new IdentifierCommand$execute$1(this, r104));
        r100.push(r104);
    }
}
