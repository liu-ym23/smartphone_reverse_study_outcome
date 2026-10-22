package com.bytedance.locallife.groupon.session;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class d implements com.bytedance.locallife.groupon.session.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f258810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f258811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<com.bytedance.locallife.groupon.session.a> f258812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f258813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Object> f258814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Object> f258815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Object> f258816g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f258817a = null;

        static {
            int[] r100 = new int[SessionParamsType.values().length];
            r100[SessionParamsType.TRACK_PARAMS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SessionParamsType.SCHEMA_PARAMS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SessionParamsType.EXTRA_PARAMS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f258817a = r100;
        }
    }

    static {
    }

    public Map<String, Object> l() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final String getParentSessionId() {
        return this.f258811b;
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final String getSessionId() {
        return this.f258810a;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f258810a = r100;
        this.f258812c = new ArrayList();
        this.f258813d = new HashMap();
        this.f258814e = new HashMap();
        this.f258815f = new HashMap();
        this.f258816g = new HashMap();
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final HashMap<String, Object> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        HashMap<String, Object> r101 = new HashMap();
        if (TextUtils.equals(r100, this.f258810a) == false) goto L5;
        r101.putAll(this.f258816g);
    L11:
        return r101;
    L5:
        Iterator<T> r102 = this.f258812c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        HashMap<String, Object> r103 = ((com.bytedance.locallife.groupon.session.a) r102.next()).a(r100);
        if ((!r103.isEmpty()) == false) goto L7;
        r101.putAll(this.f258816g);
        r101.putAll(r103);
        goto L7
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final com.bytedance.locallife.groupon.session.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        if (TextUtils.equals(r100, this.f258810a) == false) goto L5;
        return this;
    L5:
        int r101 = this.f258812c.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        com.bytedance.locallife.groupon.session.a r103 = ((com.bytedance.locallife.groupon.session.a) ListProtector.get(this.f258812c, r102)).b(r100);
        if (r103 != null) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return r103;
    L11:
        return null;
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final void c(String r100) {
        this.f258811b = r100;
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final boolean e(com.bytedance.locallife.groupon.session.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (TextUtils.isEmpty(r100.getParentSessionId()) == false) goto L6;
        r100.c(this.f258810a);
    L6:
        if (TextUtils.equals(this.f258810a, r100.getParentSessionId()) == false) goto L19;
        ArrayList<com.bytedance.locallife.groupon.session.a> r101 = this.f258812c;
        if (r101 == null) goto L18;
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        if (TextUtils.equals(this.f258810a, ((com.bytedance.locallife.groupon.session.a) r103).getSessionId()) == false) goto L11;
    L17:
        if (((com.bytedance.locallife.groupon.session.a) r103) == null) goto L18;
        return true;
    L15:
        r103 = null;
    L18:
        this.f258812c.add(r100);
        return true;
    L19:
        int r104 = this.f258812c.size();
        int r105 = 0;
    L20:
        if (r105 >= r104) goto L25;
        if (((com.bytedance.locallife.groupon.session.a) ListProtector.get(this.f258812c, r105)).e(r100) == true) goto L23;
        r105 = r105 + 1;
        goto L20
    L23:
        return true;
    L25:
        return false;
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final HashMap<String, Object> f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        HashMap<String, Object> r101 = new HashMap();
        this.f258813d.putAll(l());
        if (TextUtils.equals(r100, this.f258810a) == false) goto L5;
        r101.putAll(this.f258813d);
        r101.putAll(this.f258814e);
        r101.putAll(this.f258815f);
    L11:
        r101.toString();
        return r101;
    L5:
        Iterator<T> r102 = this.f258812c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        HashMap<String, Object> r103 = ((com.bytedance.locallife.groupon.session.a) r102.next()).f(r100);
        if ((!r103.isEmpty()) == false) goto L7;
        r101.putAll(this.f258813d);
        r101.putAll(this.f258814e);
        r101.putAll(this.f258815f);
        r101.putAll(r103);
        goto L7
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final HashMap<String, Object> g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        HashMap<String, Object> r101 = new HashMap();
        if (TextUtils.equals(r100, this.f258810a) == false) goto L5;
        r101.putAll(this.f258815f);
    L11:
        return r101;
    L5:
        Iterator<T> r102 = this.f258812c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        HashMap<String, Object> r103 = ((com.bytedance.locallife.groupon.session.a) r102.next()).g(r100);
        if ((!r103.isEmpty()) == false) goto L7;
        r101.putAll(this.f258815f);
        r101.putAll(r103);
        goto L7
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final Object get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f258813d.putAll(l());
        if (this.f258813d.containsKey(r100) == false) goto L6;
        return this.f258813d.get(r100);
    L6:
        if (this.f258814e.containsKey(r100) == false) goto L9;
        return this.f258814e.get(r100);
    L9:
        if (this.f258815f.containsKey(r100) == false) goto L12;
        return this.f258815f.get(r100);
    L12:
        if (this.f258816g.containsKey(r100) == true) goto L19;
        return null;
    L19:
        return this.f258816g.get(r100);
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final HashMap<String, Object> h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        HashMap<String, Object> r101 = new HashMap();
        this.f258813d.putAll(l());
        if (TextUtils.equals(r100, this.f258810a) == false) goto L5;
        r101.putAll(this.f258813d);
    L11:
        return r101;
    L5:
        Iterator<T> r102 = this.f258812c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        HashMap<String, Object> r103 = ((com.bytedance.locallife.groupon.session.a) r102.next()).h(r100);
        if ((!r103.isEmpty()) == false) goto L7;
        r101.putAll(this.f258813d);
        r101.putAll(r103);
        goto L7
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final com.bytedance.locallife.groupon.session.a j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Iterator<T> r101 = this.f258812c.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (TextUtils.equals(r100, ((com.bytedance.locallife.groupon.session.a) r102).getSessionId()) == false) goto L4;
    L9:
        com.bytedance.locallife.groupon.session.a r103 = (com.bytedance.locallife.groupon.session.a) r102;
        if (r103 == null) goto L13;
        this.f258812c.remove(r103);
        return r103;
    L13:
        int r104 = this.f258812c.size();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L19;
        com.bytedance.locallife.groupon.session.a r106 = ((com.bytedance.locallife.groupon.session.a) ListProtector.get(this.f258812c, r105)).j(r100);
        if (r106 != null) goto L17;
        r105 = r105 + 1;
        goto L14
    L17:
        return r106;
    L19:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final HashMap<String, Object> k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        HashMap<String, Object> r101 = new HashMap();
        if (TextUtils.equals(r100, this.f258810a) == false) goto L5;
        r101.putAll(this.f258814e);
    L11:
        return r101;
    L5:
        Iterator<T> r102 = this.f258812c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        HashMap<String, Object> r103 = ((com.bytedance.locallife.groupon.session.a) r102.next()).k(r100);
        if ((!r103.isEmpty()) == false) goto L7;
        r101.putAll(this.f258814e);
        r101.putAll(r103);
        goto L7
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final void i(String r100, HashMap<String, Object> r101, SessionParamsType r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (TextUtils.equals(r100, this.f258810a) == false) goto L14;
        int r103 = b.f258817a[r102.ordinal()];
        if (r103 != 1) goto L7;
        this.f258814e.putAll(r101);
        return;
    L7:
        if (r103 != 2) goto L9;
        this.f258815f.putAll(r101);
        return;
    L9:
        if (r103 == 3) goto L11;
        this.f258813d.putAll(r101);
        return;
    L11:
        this.f258816g.putAll(r101);
        return;
    L14:
        Iterator<T> r104 = this.f258812c.iterator();
    L16:
        if (r104.hasNext() == false) goto L23;
        ((com.bytedance.locallife.groupon.session.a) r104.next()).i(r100, r101, r102);
        goto L16
    }

    @Override // com.bytedance.locallife.groupon.session.a
    public final void d(String r100, String r101, Object r102, SessionParamsType r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r103, "type");
        if (TextUtils.equals(r100, this.f258810a) == false) goto L14;
        int r104 = b.f258817a[r103.ordinal()];
        if (r104 != 1) goto L7;
        this.f258814e.put(r101, r102);
        return;
    L7:
        if (r104 != 2) goto L9;
        this.f258815f.put(r101, r102);
        return;
    L9:
        if (r104 == 3) goto L11;
        this.f258813d.put(r101, r102);
        return;
    L11:
        this.f258816g.put(r101, r102);
        return;
    L14:
        Iterator<T> r105 = this.f258812c.iterator();
    L16:
        if (r105.hasNext() == false) goto L23;
        ((com.bytedance.locallife.groupon.session.a) r105.next()).d(r100, r101, r102, r103);
        goto L16
    }
}
