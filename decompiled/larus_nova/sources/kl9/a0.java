package kl9;

import com.larus.multitask_management.api.data.TaskPriority;
import kotlin.jvm.internal.Intrinsics;
import nuc.m2;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 implements juc.d<TaskPriority> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f503867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f503868b = null;

    public a0() {
    }

    static {
        f503867a = new a0();
        f503868b = luc.n.a("TaskPriority", luc.e.f.f510854a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f503868b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        int r101 = r100.decodeInt();
        TaskPriority[] r102 = TaskPriority.values();
        TaskPriority r103 = TaskPriority.UNDEFINED;
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        TaskPriority r106 = r102[r105];
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
        TaskPriority r102 = (TaskPriority) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeInt(r102.getValue());
    }
}
