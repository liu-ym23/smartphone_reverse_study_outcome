package l18;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.entity.LKPluginInterceptResult;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a implements j18.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f507012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f507013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f507014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p18.a f507015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p18.b.a f507016e;

    @Override // j18.b
    public abstract /* synthetic */ Context getContext();

    @Override // j18.b
    public final void getParent() {
    }

    @Override // j18.b
    public final void c() {
        ((ArrayList) this.f507014c.f507020a).clear();
    }

    @Override // j18.b
    public final i18.c getBridgeContext() {
        if (this.f507015d != null) goto L6;
        this.f507016e.i("LKCoreTarget", new Object[]{"build bridge context"});
        this.f507015d = new p18.a(this);
    L6:
        return this.f507015d;
    }

    public a() {
        p18.b.a r100 = new p18.b.a(gyb.a.a().subTrace());
        this.f507016e = r100;
        g r101 = new g();
        this.f507014c = r101;
        h r102 = new h(r101);
        r102.f507024d = r100;
        this.f507012a = r102;
        new ArrayList();
        this.f507013b = new c();
    }

    @Override // j18.h
    public final LKPluginInterceptResult a(LKEvent r100) {
        h r101 = this.f507012a;
        if (r101 == null) goto L9;
        return r101.a(r100);
    L6:
        e = move-exception;
        this.f507016e.e("LKCoreTarget", new Object[]{"interceptEvent exception", e});
    L9:
        return LKPluginInterceptResult.f285534g;
    }

    @Override // j18.b
    public final void d(i18.d r100) {
        ((ArrayList) this.f507014c.f507020a).remove(r100);
    }

    @Override // j18.g
    public final LKPluginHandleResult handleEvent(LKEvent r100) {
        h r101 = this.f507012a;
        if (r101 == null) goto L9;
        return r101.handleEvent(r100);
    L6:
        e = move-exception;
        this.f507016e.e("LKCoreTarget", new Object[]{"handleEvent exception", e});
    L9:
        return LKPluginHandleResult.f285532g;
    }

    @Override // j18.b
    public final LKBasePluginResult sendEvent(LKEvent r110) {
        r110.e(this);
        this.f507013b.getClass();
        if (r110.f285490c != null) goto L5;
        ((p18.b.a) c.a(r110)).i("LKEventDispatcher", new Object[]{"source node is null"});
        boolean r100 = false;
    L6:
        if (r100 == true) goto L8;
        ((p18.b.a) c.a(r110)).i("LKEventDispatcher", new Object[]{"invalid event."});
        return LKBasePluginResult.f285519f;
    L8:
        String r101 = r110.f285488a;
        if (TextUtils.isEmpty(r101) == false) goto L11;
        ((p18.b.a) c.a(r110)).e("LKEventDispatcher", new Object[]{"eventName is empty!"});
        return LKBasePluginResult.f285519f;
    L11:
        j18.b r102 = r110.f285490c;
        ArrayList r103 = new ArrayList();
    L12:
        if (r102 == null) goto L15;
        r103.add(r102);
        r102.getParent();
        r102 = null;
        goto L12
    L15:
        if (r103.isEmpty() == false) goto L17;
        ((p18.b.a) c.a(r110)).e("LKEventDispatcher", new Object[]{"target list is empty!"});
        return LKBasePluginResult.f285519f;
    L17:
        int r104 = r103.size();
        p18.b.a r105 = (p18.b.a) c.a(r110);
        r105.i("LKEventDispatcher", new Object[]{"event: " + r101 + " targetList size:" + r104});
        int r106 = r104 + (-1);
    L19:
        if (r106 < 0) goto L28;
        j18.h r107 = (j18.h) ListProtector.get(r103, r106);
        LKBasePluginResult r111 = r107.a(r110);     // Catch: Exception -> L25
        if (r111.f285520a == false) goto L27;
        r105.i("LKEventDispatcher", new Object[]{"intercept:" + r107.getClass().getName()});     // Catch: Exception -> L25
    L56:
        return r111;
    L27:
        r106 = r106 - 1;
    L25:
        e = move-exception;
        r105.i("LKEventDispatcher", new Object[]{"dispatch intercept exception", e});
        goto L27
    L28:
        int r108 = 0;
    L29:
        if (r108 >= r104) goto L38;
        j18.h r109 = (j18.h) ListProtector.get(r103, r108);
        r111 = r109.handleEvent(r110);     // Catch: Exception -> L35
        if (r111.f285520a == false) goto L37;
        r105.i("LKEventDispatcher", new Object[]{"success handle:" + r109.getClass().getName()});     // Catch: Exception -> L35
    L37:
        r108 = r108 + 1;
    L35:
        e = move-exception;
        r105.e("LKEventDispatcher", new Object[]{"dispatch handle exception", e});
        goto L37
    L38:
        r105.i("LKEventDispatcher", new Object[]{"[" + r101 + "] handled by nobody"});
        return LKBasePluginResult.f285519f;
    L5:
        r100 = true;
        goto L6
    }
}
