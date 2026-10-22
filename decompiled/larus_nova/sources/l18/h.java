package l18;

import android.text.TextUtils;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.entity.LKPluginInterceptResult;
import j18.j;
import j18.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i18.d> f507021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<i18.d>> f507022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f507023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hyb.a f507024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f507025e;

    public h(g r100) {
        this.f507025e = new Object();
        this.f507021a = new ArrayList();
        this.f507022b = new HashMap();
        this.f507023c = r100;
        this.f507024d = new p18.b.a(gyb.a.a().subTrace());
    }

    @Override // j18.h
    public final LKPluginInterceptResult a(LKEvent r110) {
        if (r110 != null) goto L6;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"event is null!"});
        return LKPluginInterceptResult.f285534g;
    L6:
        String r100 = r110.f285488a;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"eventName is empty!"});
        return LKPluginInterceptResult.f285534g;
    L10:
        List r101 = (List) ((HashMap) this.f507022b).get(r100);
        if (r101 != null) goto L13;
    L38:
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"no plugin event:" + r100});
        return LKPluginInterceptResult.f285534g;
    L13:
        if (r101.isEmpty() == true) goto L38;
        if (r101.size() <= 1) goto L18;
        Collections.sort(r101);
    L18:
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"intercept event:" + r100 + " plugin size:" + r101.size()});
        ListIterator r102 = r101.listIterator();
    L20:
        if (r102.hasNext() == false) goto L23;
        r102.next();
    L23:
        if (r102.hasPrevious() == false) goto L37;
        i18.d r103 = (i18.d) r102.previous();
        LKPluginInterceptResult r104 = LKPluginInterceptResult.f285534g;
    L29:
        e = move-exception;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"interceptEvent exception." + r103.getClass(), e});
    L31:
        String r105 = r18.b.b(r103);
        if (r104.f285520a == true) goto L34;
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"[" + r100 + "] intercept pass " + r105});
        goto L23
    L34:
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"[" + r100 + "] intercepted by " + r105});
        return r104;
    L26:
        if ((r103 instanceof f) == false) goto L31;
        r104 = ((f) r103).a(r110);     // Catch: Exception -> L29
        goto L31
    L37:
        return LKPluginInterceptResult.f285534g;
    }

    public final boolean b(i18.d r100) {
        if (r100 != null) goto L7;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"invalid plugin parameter!"});
        return false;
    L7:
        if (((ArrayList) this.f507021a).contains(r100) == false) goto L10;
        this.f507024d.w("LKPluginManagerImpl", new Object[]{"plugin already registered!"});
        return false;
    L10:
        d r101 = new d();
        r100.addEvents(r101);
        List<String> r102 = r101.f507019a;
        if (r102 == null) goto L37;
        ArrayList r103 = (ArrayList) r102;
        if (r103.isEmpty() == true) goto L37;
        Object r104 = this.f507025e;
        monitor-enter(r104);
        ((ArrayList) this.f507021a).add(r100);     // Catch: Throwable -> L34
        monitor-exit(r104);     // Catch: Throwable -> L34
        Iterator r105 = r103.iterator();
    L21:
        if (r105.hasNext() == false) goto L32;
        String r106 = (String) r105.next();
        if (TextUtils.isEmpty(r106) == true) goto L24;
        if (((HashMap) this.f507022b).containsKey(r106) == true) goto L28;
        List r107 = new LinkedList();
        ((HashMap) this.f507022b).put(r106, r107);
    L31:
        r107.add(r100);
        goto L21
    L28:
        r107 = (List) ((HashMap) this.f507022b).get(r106);
        if (r107 != null) goto L31;
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"plugin list is null"});
        r107 = new ArrayList();
        ((HashMap) this.f507022b).put(r106, r107);
        goto L31
    L24:
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"event can`t be empty!"});
        goto L21
    L32:
        this.f507024d.d("LKPluginManagerImpl", new Object[]{"register plugin name:".concat(r100.getClass().getName())});
        return true;
    L34:
        th = move-exception;
        throw th;
    L37:
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"empty actions!" + r18.b.b(r100)});
        return false;
    }

    @Override // j18.g
    public final LKPluginHandleResult handleEvent(LKEvent r110) {
        if (r110 != null) goto L6;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"event is null!"});
        return LKPluginHandleResult.f285532g;
    L6:
        String r100 = r110.f285488a;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"eventName is empty!"});
        return LKPluginHandleResult.f285532g;
    L10:
        List r101 = (List) ((HashMap) this.f507022b).get(r100);
        if (r101 != null) goto L13;
    L41:
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"no handle event:" + r100});
        return LKPluginHandleResult.f285532g;
    L13:
        if (r101.isEmpty() == true) goto L41;
        if (r101.size() <= 1) goto L18;
        Collections.sort(r101);
    L18:
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"handle event:" + r100 + " plugin size:" + r101.size()});
        ListIterator r102 = r101.listIterator();
    L20:
        if (r102.hasNext() == false) goto L23;
        r102.next();
    L23:
        if (r102.hasPrevious() == false) goto L40;
        i18.d r103 = (i18.d) r102.previous();
        if (r103.shouldHandleActivityResult() == false) goto L29;
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"event:" + r100 + " registerActivityResult"});
        g r104 = (g) this.f507023c;
        if (((ArrayList) r104.f507020a).contains(r103) == true) goto L29;
        ((ArrayList) r104.f507020a).add(r103);
    L29:
        LKPluginHandleResult r105 = LKPluginHandleResult.f285532g;
        r105 = r103.handleEvent(r110);     // Catch: Exception -> L32
    L34:
        String r106 = r18.b.b(r103);
        if (r105.f285520a == true) goto L37;
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"[" + r100 + "] handle pass " + r106});
        goto L23
    L37:
        this.f507024d.i("LKPluginManagerImpl", new Object[]{"[" + r100 + "] handled by " + r106});
        return r105;
    L32:
        e = move-exception;
        this.f507024d.e("LKPluginManagerImpl", new Object[]{"handleEvent exception." + r103.getClass(), e});
        goto L34
    L40:
        return LKPluginHandleResult.f285532g;
    }
}
