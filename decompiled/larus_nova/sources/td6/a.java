package td6;

import com.bytedance.lark.express.exception.ExprException;
import faceverify.w;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;
import rd6.d;
import re6.c;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public a() {
    }

    public static Object a(List r100, c r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "commands");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, w.BLOB_ELEM_IMAGE_RUNTIMEINFO);
        Stack r103 = new Stack();
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        ((sd6.a) r104.next()).a(r103, r101, r102);
        goto L4
    L7:
        if (r103.size() != 1) goto L11;
        return r103.pop();
    L11:
        throw new ExprException(107, "execute end, but stack has more than one element");
    }
}
