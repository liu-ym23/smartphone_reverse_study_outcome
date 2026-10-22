package sd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import faceverify.w;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ud6.b f541459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f541460b;

    public b(ud6.b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f541459a = r100;
        this.f541460b = r101;
    }

    @Override // sd6.a
    public final void a(Stack r100, re6.c r101, rd6.d r102) {
        Intrinsics.checkNotNullParameter(r100, "stack");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, w.BLOB_ELEM_IMAGE_RUNTIMEINFO);
        ArrayList r103 = new ArrayList();
        int r104 = this.f541460b;
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
        r100.push(this.f541459a.a(r103));
    }
}
