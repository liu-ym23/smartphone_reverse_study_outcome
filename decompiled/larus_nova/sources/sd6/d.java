package sd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import faceverify.w;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;
import vd6.o;

/* JADX INFO: loaded from: classes28.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f541462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f541463b;

    public d(o r100) {
        int r101 = r100.f554200c;
        Intrinsics.checkNotNullParameter(r100, OnekeyLoginConstants.CU_KEY_OPERATOR);
        this.f541462a = r100;
        this.f541463b = r101;
    }

    @Override // sd6.a
    public final void a(Stack r100, re6.c r101, rd6.d r102) {
        Intrinsics.checkNotNullParameter(r100, "stack");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, w.BLOB_ELEM_IMAGE_RUNTIMEINFO);
        ArrayList r103 = new ArrayList();
        int r104 = this.f541463b;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        if (r100.empty() == true) goto L8;
        ListProtector.add(r103, 0, r100.pop());
        r105 = r105 + 1;
        goto L3
    L8:
        throw new ExprException(105, "execute error " + this.f541462a.f554198a);
    L9:
        r100.push(this.f541462a.a(r103));
    }
}
