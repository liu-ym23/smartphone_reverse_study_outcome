package u4;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f548635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f548637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f548638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f548639e;

    public static final class a {
    }

    static {
    }

    @Override // u4.b
    public final void cleanup() {
        d r100 = this.f548637c;
        Iterator<Map.Entry<String, ConcurrentHashMap<String, String>>> r101 = r100.f548634a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().clear();
        goto L4
    L6:
        r100.f548634a.clear();
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<h>> g() {
        return (ConcurrentHashMap) this.f548639e.getValue();
    }

    @Override // u4.b
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        com.bytedance.ai.utils.g.f37637a.d("AIStorageItem", "subscribeStorageItem " + r100);
        CopyOnWriteArrayList<h> r101 = g().get(r100.f548640a);
        if (r101 != null) goto L6;
        r101 = new CopyOnWriteArrayList();
        g().put(r100.f548640a, r101);
    L8:
        r101.add(r100);
        g().put(r100.f548640a, r101);
        if (r100.f548642c == false) goto L11;
        c r102 = this.f548638d;
    L12:
        String r103 = r102.a(r100.f548640a, r100.f548641b, null);
        if (r103 == null) goto L20;
        List<String> r104 = new Regex("&").split(r100.f548640a, 0);
        WeakReference<u4.a> r105 = r100.f548643d;
        if (r105 == null) goto L21;
        u4.a r106 = r105.get();
        if (r106 == null) goto L22;
        JsonObject r107 = new JsonObject();
        r107.addProperty("groupID", this.f548636b);
        r107.addProperty("storageID", (String) ListProtector.get(r104, r104.size() - 1));
        r107.addProperty("persistent", Boolean.valueOf(r100.f548642c));
        r107.addProperty("key", r100.f548641b);
        r107.addProperty("value", r103);
        Unit r108 = Unit.INSTANCE;
        r106.onMessageToAIBridge("onDataUpdated", r107);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r102 = this.f548637c;
        goto L12
    L6:
        if (r101.contains(r100) == false) goto L8;
    }

    @Override // u4.b
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriber");
        com.bytedance.ai.utils.g.f37637a.d("AIStorageItem", "unSubscribeStorageItem=" + r100);
        CopyOnWriteArrayList<h> r101 = g().get(r100.f548640a);
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public g(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "groupId");
        this.f548635a = r100;
        this.f548636b = r101;
        this.f548637c = new d();
        this.f548638d = new e();
        this.f548639e = LazyKt.lazy(new f());
    }

    @Override // u4.b
    public final String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "storageId");
        StringBuilder r102 = new StringBuilder("ai_storage_user&");
        if (this.f548635a == false) goto L5;
        String r103 = "shared";
    L6:
        r102.append(r103);
        r102.append(Typography.amp);
        r102.append(r100);
        r102.append(Typography.amp);
        r102.append(r101);
        String r104 = r102.toString();
        com.bytedance.ai.utils.g.f37637a.d("AIStorageItem", "mappingStorage=" + r104);
        return r104;
    L5:
        r103 = BridgePrivilege.PRIVATE;
        goto L6
    }

    @Override // u4.b
    public final String c(String r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r100, "storageId");
        Intrinsics.checkNotNullParameter(r102, "key");
        if (r101 == false) goto L5;
        c r104 = this.f548638d;
    L6:
        String r105 = r104.a(d(this.f548636b, r100), r102, r103);
        com.bytedance.ai.utils.g.f37637a.d("AIStorage", "getStorageItem key " + r102 + " value " + r105);
        return r105;
    L5:
        r104 = this.f548637c;
        goto L6
    }

    @Override // u4.b
    public final void e(String r100, boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r100, "storageId");
        Intrinsics.checkNotNullParameter(r111, "key");
        String r101 = d(this.f548636b, r100);
        if (r110 == false) goto L5;
        c r102 = this.f548638d;
    L6:
        String r103 = r102.a(r101, r111, null);
        if (r110 == false) goto L9;
        c r104 = this.f548638d;
    L10:
        r104.b(r101, r111);
        com.bytedance.ai.utils.g.f37637a.d("AIStorage", "removeStorageItem key " + r101);
        CopyOnWriteArrayList<h> r105 = g().get(r101);
        if (r105 == null) goto L26;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((h) r108).f548641b, r111) == false) goto L14;
        r106.add(r108);
        goto L14
    L18:
        Iterator r109 = r106.iterator();
    L20:
        if (r109.hasNext() == false) goto L39;
        h r113 = (h) r109.next();
        com.bytedance.ai.utils.g.f37637a.d("AIStorage", "removeStorageItem notify  " + r113);
        WeakReference<u4.a> r114 = r113.f548643d;
        if (r114 == null) goto L20;
        u4.a r115 = r114.get();
        if (r115 == null) goto L20;
        JsonObject r116 = new JsonObject();
        r116.addProperty("groupID", this.f548636b);
        r116.addProperty("storageID", r100);
        r116.addProperty("persistent", Boolean.valueOf(r110));
        r116.addProperty("key", r111);
        r116.addProperty("value", r103);
        r116.addProperty("extra", r112);
        Unit r117 = Unit.INSTANCE;
        r115.onMessageToAIBridge("onDataRemoved", r116);
        goto L20
    L39:
        return;
    L26:
        return;
    L9:
        r104 = this.f548637c;
        goto L10
    L5:
        r102 = this.f548637c;
        goto L6
    }

    @Override // u4.b
    public final void f(String r100, boolean r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter("ai_storage_user", "userId");
        Intrinsics.checkNotNullParameter(r100, "storageId");
        Intrinsics.checkNotNullParameter(r111, "key");
        String r101 = d(this.f548636b, r100);
        com.bytedance.ai.utils.g.f37637a.d("AIStorage", "updateStorageItem key " + r111 + " value " + r112);
        if (r110 == false) goto L5;
        c r102 = this.f548638d;
    L7:
        if (r102.a(r101, r111, null) != null) goto L9;
        String r103 = "onDataCreated";
    L10:
        r102.c(r101, r111, r112);
        CopyOnWriteArrayList<h> r104 = g().get(r101);
        if (r104 == null) goto L26;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((h) r107).f548641b, r111) == false) goto L14;
        r105.add(r107);
        goto L14
    L18:
        Iterator r108 = r105.iterator();
    L20:
        if (r108.hasNext() == false) goto L39;
        h r109 = (h) r108.next();
        com.bytedance.ai.utils.g.f37637a.d("AIStorage", "updateStorageItem notify  " + r109);
        WeakReference<u4.a> r114 = r109.f548643d;
        if (r114 == null) goto L20;
        u4.a r115 = r114.get();
        if (r115 == null) goto L20;
        JsonObject r116 = new JsonObject();
        r116.addProperty("groupID", this.f548636b);
        r116.addProperty("storageID", r100);
        r116.addProperty("persistent", Boolean.valueOf(r110));
        r116.addProperty("key", r111);
        r116.addProperty("value", r112);
        r116.addProperty("extra", r113);
        Unit r117 = Unit.INSTANCE;
        r115.onMessageToAIBridge(r103, r116);
        goto L20
    L39:
        return;
    L26:
        return;
    L9:
        r103 = "onDataUpdated";
        goto L10
    L5:
        r102 = this.f548637c;
        goto L7
    }
}
