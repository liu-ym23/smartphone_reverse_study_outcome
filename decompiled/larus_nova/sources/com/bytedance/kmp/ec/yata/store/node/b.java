package com.bytedance.kmp.ec.yata.store.node;

import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public static final class a {
        public static void b(b r100, Function1<? super b, Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "visitor");
            Iterator<b> r102 = r100.getChildren().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().q(r101);
            goto L4
        L6:
            r101.invoke(r100);
        }

        public static void c(b r100, Function1<? super b, Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "visitor");
            if ((r100 instanceof g) == false) goto L5;
            r101.invoke(r100);
            return;
        L5:
            Iterator<b> r102 = r100.getChildren().iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            r102.next().n(r101);
            goto L7
        L9:
            r101.invoke(r100);
        }

        public static void d(b r100, Function1<? super b, Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "visitor");
            r101.invoke(r100);
            Iterator<b> r102 = r100.getChildren().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().h(r101);
            goto L4
        }

        public static void a(b r100, b r101, int r102) {
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getParent() == null) goto L7;
            YaTaLog.b("INode", "child.parent!=null");
        L7:
            b r103 = r100;
        L8:
            Intrinsics.checkNotNull(r103);
            if (r103.getParent() == null) goto L13;
            r103 = r103.getParent();
            if (Intrinsics.areEqual(r103, r101) == false) goto L8;
            YaTaLog.b("INode", "node == child");
            goto L8
        L13:
            r101.g(r100);
            if (r102 != r100.getChildren().size()) goto L17;
            r100.getChildren().add(r101);
            return;
        L17:
            if (r102 >= r100.getChildren().size()) goto L19;
            ListProtector.set(r100.getChildren(), r102, r101);
            return;
        L19:
            String r104 = YaTaLog.f251436a;
            YaTaLog.b("INode", "adoptChild index: " + r102 + ", children.size: " + r100.getChildren().size());
        }
    }

    void g(b r100);

    List<b> getChildren();

    String getKey();

    b getParent();

    void h(Function1<? super b, Unit> r100);

    void n(Function1<? super b, Unit> r100);

    void q(Function1<? super b, Unit> r100);
}
