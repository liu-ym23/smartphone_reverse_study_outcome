package cr5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public boolean b;
    public final ConcurrentHashMap<String, d> c;

    /* JADX INFO: renamed from: cr5.a$a, reason: collision with other inner class name */
    public static final class C0225a {
    }

    static {
    }

    public a() {
        this.a = "WikiChainPushManager#" + Integer.toHexString(hashCode());
        this.c = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [cr5.b] */
    public final void a(String r6, String r7, String r8, d.a r9) {
        Intrinsics.checkNotNullParameter(r7, "synergyUuid");
        Intrinsics.checkNotNullParameter(r8, "tagSuffix");
        Intrinsics.checkNotNullParameter(r9, "pushHandler");
        if (this.b == true) goto L6;
        tt5.a.h(this.a, "registerChainPush fail, chainPushEnable=false, spaceId=" + r6 + ", treeModel=" + Integer.toHexString(r9.hashCode()));
        return;
    L6:
        if (r6 != null) goto L9;
        tt5.a.k(this.a, "registerChainPush fail, spaceId=null, treeModel=" + Integer.toHexString(r9.hashCode()));
        return;
    L9:
        VirtualNode.Companion.getClass();
        VirtualNode[] r0 = VirtualNode.a.b();
        boolean r2 = false;
        int r3 = 0;
    L11:
        if (r3 >= 5) goto L16;
        if (Intrinsics.areEqual(r0[r3].getSpaceId(), r6) == true) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        r2 = true;
    L16:
        if (r2 == false) goto L20;
        tt5.a.h(this.a, "registerChainPush fail, spaceId is virtual, spaceId=" + r6 + ", treeModel=" + Integer.toHexString(r9.hashCode()));
        return;
    L20:
        if (this.c.containsKey(r6) == false) goto L23;
        tt5.a.k(this.a, "registerChainPush fail, current spaceId is already register, spaceId=" + r6 + ", treeModel=" + Integer.toHexString(r9.hashCode()));
        return;
    L23:
        final d r1 = new d(r6, r9, r7, r8);
        this.c.put(r6, r1);
        tt5.a.h(r1.a, "WikiPush attach. ");
        r1.c = CoreThreadPool.getSerialTaskHandler();
        r1.b = new b(r1);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).Cd(r6, r1.b);
        tt5.a.h(this.a, "registerChainPush success, spaceId=" + r6 + ", treeModel=" + Integer.toHexString(r9.hashCode()));
    }
}
