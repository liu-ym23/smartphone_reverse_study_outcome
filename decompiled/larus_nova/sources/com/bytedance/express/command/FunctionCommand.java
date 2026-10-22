package com.bytedance.express.command;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public final class FunctionCommand implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v97.b f243192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243193b;

    @Override // com.bytedance.express.command.b
    public final Instruction b() {
        return new Instruction(((CommandType.FunctionCommand.getCode() << 14) | (Primitive.STRING.getCode() << 10)) | this.f243193b, this.f243192a.f553811a);
    }

    public FunctionCommand(v97.b r100, int r101) {
        this.f243192a = r100;
        this.f243193b = r101;
    }

    @Override // com.bytedance.express.command.b
    public final void a(Stack<Object> r100, v97.c r101, com.bytedance.express.c r102) {
        ArrayList r103 = new ArrayList();
        int r104 = this.f243193b;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        if (r100.empty() == true) goto L8;
        ListProtector.add(r103, 0, r100.pop());
        r105 = r105 + 1;
        goto L3
    L8:
        throw new ExprException(105, "execute error");
    L9:
        final Object r106 = this.f243192a.a(r103);
        int r107 = com.bytedance.express.util.a.f243211a;
        com.bytedance.express.util.a.a(4, new FunctionCommand$execute$1(this, r106));
        r100.push(r106);
    }
}
