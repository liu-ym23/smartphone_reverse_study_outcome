package dv5;

import com.bytedance.express.command.b;
import com.bytedance.ruler.base.models.ExprException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import v97.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public a() {
    }

    public static Object a(List r100, c r101, com.bytedance.express.c r102) {
        Stack<Object> r103 = new Stack();
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        ((b) r104.next()).a(r103, r101, r102);
        goto L4
    L7:
        if (r103.size() != 1) goto L11;
        return r103.pop();
    L11:
        throw new ExprException(107, "execute end, but stack has more than one element");
    }
}
