package ll9;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import kotlin.jvm.internal.Intrinsics;
import nuc.m2;

/* JADX INFO: loaded from: classes30.dex */
public final class n implements juc.d<NodeType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f509758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f509759b = null;

    public n() {
    }

    static {
        f509758a = new n();
        f509759b = luc.n.a("NodeType", luc.e.f.f510854a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f509759b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        int r101 = r100.decodeInt();
        NodeType[] r102 = NodeType.values();
        NodeType r103 = NodeType.UNKNOWN;
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        NodeType r106 = r102[r105];
        Intrinsics.checkNotNullParameter(r106, "it");
        if (Integer.valueOf(r106.getValue()).intValue() != r101) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L12;
        r105 = r105 + 1;
    L12:
        if (r106 != null) goto L15;
        return r103;
    L15:
        return r106;
    L7:
        r107 = false;
        goto L8
    L11:
        r106 = null;
        goto L12
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        NodeType r102 = (NodeType) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeInt(r102.getValue());
    }
}
