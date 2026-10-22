package nwb;

import com.ss.android.lark.chat.component.task.SetLoginChatterTask;
import com.ss.android.lark.passportc.ffi.KmpOfflineTask;
import com.ss.android.lark.passportc.ffi.KmpOnlineTask;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements com.ss.android.lark.passportc.task.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b> f521020a;

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> f() {
        j0c.b r100 = KmpOfflineTask.f438141a;
        j0c.b r101 = jjb.e.f499403d;
        j0c.b r102 = eeb.c.f472402c;
        return CollectionsKt.listOf(new j0c.b[]{KmpOfflineTask.f438141a, jjb.e.f499403d, eeb.c.f472402c});
    }

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> b() {
        j0c.b r100 = com.ss.android.lark.passportc.task.h.f438500c;
        return CollectionsKt.listOf(com.ss.android.lark.passportc.task.h.f438500c);
    }

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> g() {
        j0c.b r100 = i.f521023a;
        j0c.b r101 = jjb.h.f499426m;
        j0c.b r102 = h.f521022a;
        j0c.b r103 = com.ss.android.lark.passportc.task.h.f438500c;
        j0c.b r104 = KmpOnlineTask.f438149a;
        j0c.b r105 = zoc.b.f573170b;
        j0c.b r106 = SetLoginChatterTask.f414712b;
        j0c.b r107 = wjb.a.f560058a;
        List<j0c.b> r108 = CollectionsKt.mutableListOf(new j0c.b[]{i.f521023a, jjb.h.f499426m, h.f521022a, com.ss.android.lark.passportc.task.h.f438500c, KmpOnlineTask.f438149a, zoc.b.f573170b, SetLoginChatterTask.f414712b, wjb.a.f560058a});
        Iterator<T> r109 = this.f521020a.iterator();
    L4:
        if (r109.hasNext() == false) goto L6;
        r108.addAll(((b) r109.next()).a());
        goto L4
    L6:
        return r108;
    }

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> a() {
        return CollectionsKt.emptyList();
    }

    @Inject
    public f(Set<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "taskOrderInjectors");
        this.f521020a = r100;
    }
}
