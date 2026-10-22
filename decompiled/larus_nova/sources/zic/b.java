package zic;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public abstract class b implements yic.a, Comparable<b>, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yic.b f572356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ViewGroup, List<View>> f572357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHandler f572358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f572359d;

    @Override // yic.a
    public final void c() {
    }

    @Override // yic.a
    public final void d() {
    }

    @Override // yic.a
    public final void e() {
    }

    @Override // yic.a
    public final void getLayerType() {
    }

    @Override // yic.a
    public final void i() {
    }

    public Context getContext() {
        yic.b r100 = this.f572356a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public b() {
        this.f572357b = new HashMap();
        this.f572358c = new WeakHandler(this);
    }

    @Override // yic.a
    public final boolean a() {
        return this.f572359d;
    }

    @Override // yic.a
    public final void b(boolean r100) {
        this.f572359d = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(b r100) {
        if (r100 != null) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // yic.a
    public void f(c r100) {
        this.f572356a = r100;
        Context r101 = getContext();
        if (r101 == null) goto L6;
        LayoutInflater.from(r101);
    L6:
        getContext();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        int r101 = r100.what;
        if (r101 != 100) goto L20;
        this.f572358c.removeMessages(100);
        yic.b r102 = this.f572356a;
        if (r102 != null) goto L7;
    L9:
        Iterator r103 = ((HashMap) this.f572357b).entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L18;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r104.getValue() == null) goto L11;
        Iterator r105 = ((List) r104.getValue()).iterator();
    L16:
        if (r105.hasNext() == false) goto L11;
        UIUtils.detachFromParent((View) r105.next());
        goto L16
    L18:
        ((HashMap) this.f572357b).clear();
        return;
    L7:
        if (r102.a() == false) goto L9;
        this.f572358c.sendEmptyMessageDelayed(100, 300);
        return;
    L20:
        if (r101 != 101) goto L37;
        yic.b r106 = this.f572356a;
        if (r106 != null) goto L24;
    L26:
        Object r107 = r100.obj;
        if ((r107 instanceof View) == false) goto L39;
        UIUtils.detachFromParent((View) r107);
        return;
    L39:
        return;
    L24:
        if (r106.a() == false) goto L26;
        this.f572358c.sendMessageDelayed(r100, 300);
        return;
    }
}
