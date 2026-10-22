package com.bytedance.express.command;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v97.e f243202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243203b;

    @Override // com.bytedance.express.command.b
    public final Instruction b() {
        return new Instruction(((CommandType.OperateCommand.getCode() << 14) | (Primitive.STRING.getCode() << 10)) | this.f243203b, this.f243202a.f553812a);
    }

    public d(v97.e r100) {
        this(r100, r100.f553814c);
    }

    public d(v97.e r100, int r101) {
        this.f243202a = r100;
        this.f243203b = r101;
    }

    @Override // com.bytedance.express.command.b
    public final void a(Stack<Object> r100, v97.c r101, com.bytedance.express.c r102) {
        ArrayList r103 = new ArrayList();
        int r104 = this.f243203b;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        if (r100.empty() == true) goto L8;
        ListProtector.add(r103, 0, r100.pop());
        r105 = r105 + 1;
        goto L3
    L8:
        throw new ExprException(105, "execute error " + this.f243202a.f553812a);
    L9:
        r100.push(this.f243202a.a(r103));
    }
}
