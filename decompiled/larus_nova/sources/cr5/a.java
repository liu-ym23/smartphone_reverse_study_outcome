package cr5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f465081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, d> f465082c;

    /* JADX INFO: renamed from: cr5.a$a, reason: collision with other inner class name */
    public static final class C5575a {
    }

    static {
    }

    public a() {
        this.f465080a = "WikiChainPushManager#" + Integer.toHexString(hashCode());
        this.f465082c = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [cr5.b] */
    public final void a(String r100, String r101, String r102, d.a r103) {
        Intrinsics.checkNotNullParameter(r101, "synergyUuid");
        Intrinsics.checkNotNullParameter(r102, "tagSuffix");
        Intrinsics.checkNotNullParameter(r103, "pushHandler");
        if (this.f465081b == true) goto L6;
        tt5.a.h(this.f465080a, "registerChainPush fail, chainPushEnable=false, spaceId=" + r100 + ", treeModel=" + Integer.toHexString(r103.hashCode()));
        return;
    L6:
        if (r100 != null) goto L9;
        tt5.a.k(this.f465080a, "registerChainPush fail, spaceId=null, treeModel=" + Integer.toHexString(r103.hashCode()));
        return;
    L9:
        VirtualNode.Companion.getClass();
        VirtualNode[] r104 = VirtualNode.a.b();
        boolean r105 = false;
        int r106 = 0;
    L11:
        if (r106 >= 5) goto L16;
        if (Intrinsics.areEqual(r104[r106].getSpaceId(), r100) == true) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        r105 = true;
    L16:
        if (r105 == false) goto L20;
        tt5.a.h(this.f465080a, "registerChainPush fail, spaceId is virtual, spaceId=" + r100 + ", treeModel=" + Integer.toHexString(r103.hashCode()));
        return;
    L20:
        if (this.f465082c.containsKey(r100) == false) goto L23;
        tt5.a.k(this.f465080a, "registerChainPush fail, current spaceId is already register, spaceId=" + r100 + ", treeModel=" + Integer.toHexString(r103.hashCode()));
        return;
    L23:
        final d r107 = new d(r100, r103, r101, r102);
        this.f465082c.put(r100, r107);
        tt5.a.h(r107.f465086a, "WikiPush attach. ");
        r107.f465088c = CoreThreadPool.getSerialTaskHandler();
        r107.f465087b = new b(r107);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).Cd(r100, r107.f465087b);
        tt5.a.h(this.f465080a, "registerChainPush success, spaceId=" + r100 + ", treeModel=" + Integer.toHexString(r103.hashCode()));
    }
}
