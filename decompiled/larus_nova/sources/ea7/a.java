package ea7;

import com.bytedance.express.command.FunctionCommand;
import com.bytedance.express.command.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static b a(List<com.bytedance.express.command.b> r100) {
        Stack r101 = new Stack();
        Iterator<com.bytedance.express.command.b> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L22;
        com.bytedance.express.command.b r103 = r102.next();
        b r104 = new b(r103);
        if ((r103 instanceof d) == false) goto L9;
        int r105 = ((d) r103).f243203b;
    L12:
        int r106 = r105;
    L13:
        if (r106 <= 0) goto L18;
        b r107 = (b) r101.get(r101.size() - r106);
        if (r104.f471627b != null) goto L17;
        r104.f471627b = new ArrayList();
    L17:
        r104.f471627b.add(r107);
        r106 = r106 - 1;
    L18:
        if (r105 <= 0) goto L20;
        r101.pop();
        r105 = r105 - 1;
        goto L18
    L20:
        r101.push(r104);
        goto L4
    L9:
        if ((r103 instanceof FunctionCommand) == false) goto L11;
        r105 = ((FunctionCommand) r103).f243193b;
        goto L12
    L11:
        r105 = 0;
        goto L12
    L22:
        if (r101.size() != 1) goto L26;
        return (b) r101.pop();
    L26:
        throw new IllegalArgumentException("could not build command tree");
    }
}
