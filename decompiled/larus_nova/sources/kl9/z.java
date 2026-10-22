package kl9;

import com.larus.multitask_management.api.data.TaskKey;
import kotlin.jvm.internal.Intrinsics;
import nuc.m2;

/* JADX INFO: loaded from: classes30.dex */
public final class z implements juc.d<TaskKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f504024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f504025b = null;

    public z() {
    }

    static {
        f504024a = new z();
        f504025b = luc.n.a("TaskKey", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f504025b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        String r101 = r100.decodeString();
        TaskKey[] r102 = TaskKey.values();
        TaskKey r103 = TaskKey.UNDEFINED;
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        TaskKey r106 = r102[r105];
        Intrinsics.checkNotNullParameter(r106, "it");
        if (Intrinsics.areEqual(r106.getValue(), r101) == true) goto L9;
        r105 = r105 + 1;
    L9:
        if (r106 != null) goto L12;
        return r103;
    L12:
        return r106;
    L8:
        r106 = null;
        goto L9
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        TaskKey r102 = (TaskKey) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102.getValue());
    }
}
