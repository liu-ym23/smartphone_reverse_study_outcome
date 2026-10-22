package tqb;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder;
import com.ss.android.lark.lynxkit.host.LarkLynxCloseSource;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a implements ILarkLynxHostHolder, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkLynxHostParams f547235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarkLynxHostOptions f547236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f547237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f547238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ILarkLynxContainer f547239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f547240f;

    public void d() {
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public void destroy() {
        if (this.f547237c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        c r100 = this.f547240f;
        if (r100 == null) goto L8;
        r100.K40(LarkLynxCloseSource.PROGRAMMATIC);
    L11:
        this.f547240f = null;
        this.f547239e = null;
        return;
    L8:
        ILarkLynxContainer r101 = this.f547239e;
        if (r101 == null) goto L11;
        r101.destroy();
        goto L11
    }

    @Override // tqb.g
    public final boolean f() {
        if (this.f547238d == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        this.f547238d = false;
        return r100;
    L5:
        if (this.f547236b.getRenderOnCreateView() == true) goto L8;
        r100 = false;
        goto L9
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final boolean isDestroyed() {
        return this.f547237c.get();
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public void load() {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r100 = this.f547239e;
        if (r100 != null) goto L9;
        this.f547238d = true;
        return;
    L9:
        this.f547238d = false;
        int r101 = b.f547241a;
        b.c(r100, this.f547235a);
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final ILarkLynxContainer getContainer() {
        return this.f547239e;
    }

    @Override // tqb.g
    public final void a(ILarkLynxContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (this.f547239e != r100) goto L6;
        this.f547239e = null;
        return;
    }

    @Override // tqb.g
    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        if (this.f547240f != r100) goto L6;
        this.f547240f = null;
        return;
    }

    public void c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f547240f = r100;
    }

    @Override // tqb.g
    public final void e(ILarkLynxContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f547239e = r100;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r101 = this.f547239e;
        if (r101 == null) goto L28;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        if (r104.getValue() == null) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
        r102.put(r104.getKey(), r104.getValue());
        goto L9
    L13:
        r105 = false;
        goto L14
    L16:
        LinkedHashMap r106 = new LinkedHashMap(MapsKt.mapCapacity(r102.size()));
        Iterator r107 = r102.entrySet().iterator();
    L18:
        if (r107.hasNext() == false) goto L20;
        Map.Entry r108 = (Map.Entry) r107.next();
        Object r109 = r108.getKey();
        Object r110 = r108.getValue();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Any");
        r106.put(r109, r110);
        goto L18
    L20:
        r101.updateData(r106, this.f547235a.getLynxViewShareData());
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateGlobalProps(String r100) {
        Intrinsics.checkNotNullParameter(r100, "globalPropsJson");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r101 = this.f547239e;
        if (r101 == null) goto L9;
        r101.updateGlobalData(r100);
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateShareData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "shareData");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r101 = this.f547239e;
        if (r101 == null) goto L9;
        r101.updateShareData(new HashMap(r100));
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r101 = this.f547239e;
        if (r101 == null) goto L9;
        r101.updateData(r100, this.f547235a.getLynxViewShareData());
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalProps");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r101 = this.f547239e;
        if (r101 == null) goto L9;
        r101.updateGlobalData(r100);
        return;
    }

    public a(LarkLynxHostParams r100, LarkLynxHostOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "options");
        this.f547235a = r100;
        this.f547236b = r101;
        this.f547237c = new AtomicBoolean(false);
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L6;
        List<? extends Object> r102 = CollectionsKt.emptyList();
    L9:
        sendEvent(r100, r102);
        return;
    L6:
        if ((r101 instanceof List) == false) goto L8;
        r102 = CollectionsKt.filterNotNull((Iterable) r101);
        goto L9
    L8:
        r102 = CollectionsKt.listOf(r101);
        goto L9
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void updateSize(int r100, int r101) {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r102 = this.f547239e;
        if (r102 == null) goto L9;
        r102.updateSize(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void sendEvent(String r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        ILarkLynxContainer r102 = this.f547239e;
        if (r102 == null) goto L9;
        r102.sendGlobalEventToJS(r100, r101);
        return;
    }
}
