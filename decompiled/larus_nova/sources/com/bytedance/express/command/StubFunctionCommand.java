package com.bytedance.express.command;

import com.bytedance.ruler.base.models.ExprException;
import java.util.Stack;

/* JADX INFO: loaded from: classes19.dex */
public final class StubFunctionCommand implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FunctionCommand f243198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f243199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f243200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ev5.d f243201d;

    @Override // com.bytedance.express.command.b
    public final Instruction b() {
        return new Instruction(((CommandType.FunctionCommand.getCode() << 14) | (Primitive.STRING.getCode() << 10)) | this.f243200c, this.f243199b);
    }

    public StubFunctionCommand(String r100, int r101, ev5.d r102) {
        this.f243199b = r100;
        this.f243200c = r101;
        this.f243201d = r102;
    }

    @Override // com.bytedance.express.command.b
    public final void a(Stack<Object> r100, v97.c r101, com.bytedance.express.c r102) {
        int r103 = com.bytedance.express.util.a.f243211a;
        com.bytedance.express.util.a.a(5, new StubFunctionCommand$execute$1(this));
        if (this.f243198a != null) goto L11;
        ev5.d r104 = this.f243201d;
        v97.b r105 = r104.f474255a.get(this.f243199b);
        if (r105 != null) goto L7;
        r105 = r101.a(this.f243199b);
    L7:
        if (r105 == null) goto L9;
        this.f243198a = new FunctionCommand(r105, this.f243200c);
        goto L11
    L9:
        com.bytedance.express.util.a.a(6, new StubFunctionCommand$execute$2(this));
        throw new ExprException(109, "function name = " + this.f243199b);
    L11:
        FunctionCommand r106 = this.f243198a;
        if (r106 == null) goto L15;
        r106.a(r100, r101, r102);
        return;
    }
}
