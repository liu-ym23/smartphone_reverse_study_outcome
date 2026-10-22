package d62;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import ylc.f;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements d62.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, a> f467103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<ylc.c> f467104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f467105c;

    public static final class a implements ylc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> f467106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Set<ylc.c>> f467107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f467108c;

        @Override // ylc.b
        public final long getRoomId() {
            return this.f467108c;
        }

        public a(long r100) {
            this.f467108c = r100;
            this.f467106a = new LinkedHashMap();
            this.f467107b = new HashMap();
        }

        @Override // ylc.b
        public final com.ss.ugc.live.sdk.message.wrsc.data.a b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return (com.ss.ugc.live.sdk.message.wrsc.data.a) ((LinkedHashMap) this.f467106a).get(r100);
        }

        @Override // ylc.b
        public final void f(ylc.c r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            Iterator<Map.Entry<String, Set<ylc.c>>> r101 = this.f467107b.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().getValue().remove(r100);
            goto L4
        }

        @Override // ylc.b
        public final void a(String r100, ylc.c r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "listener");
            Set<ylc.c> r102 = this.f467107b.get(r100);
            if (r102 != null) goto L5;
            r102 = new CopyOnWriteArraySet();
            this.f467107b.put(r100, r102);
        L5:
            r102.add(r101);
        }
    }

    public b(long r100) {
        this.f467105c = r100;
        this.f467103a = new LinkedHashMap();
        this.f467104b = new CopyOnWriteArrayList();
    }

    public final a b(long r100) {
        Map<Long, a> r101 = this.f467103a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        a r103 = (a) r102.get(Long.valueOf(r100));
        if (r103 != null) goto L6;
        a r104 = new a(this.f467105c);
        this.f467103a.put(Long.valueOf(r100), r104);
        return r104;
    L6:
        return r103;
    }

    @Override // d62.a
    public final void a(f r110, vlc.c r111) {
        b r100 = this;
        f r101 = r110;
        vlc.c r102 = r111;
        String r103 = "message";
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "logger");
        long r104 = r101.f568364b;
        Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r105 = r101.f568370h;
        if (r104 > 0) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a>> r106 = r105.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L33;
        Map.Entry<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r107 = r106.next();
        String r108 = r107.getKey();
        com.ss.ugc.live.sdk.message.wrsc.data.a r109 = r107.getValue();
        int r112 = zlc.a.f572836a;
        Intrinsics.checkNotNullParameter(r101, r103);
        Intrinsics.checkNotNullParameter(r109, "roomDataSync");
        r109.getClass();
        a r113 = r100.b(r104);
        com.ss.ugc.live.sdk.message.wrsc.data.a r114 = r113.b(r108);
        if (r114 != null) goto L11;
        Intrinsics.checkNotNullParameter(r108, "syncKey");
        Intrinsics.checkNotNullParameter(r109, "syncData");
        r113.f467106a.put(r108, r109);
        com.ss.ugc.live.sdk.msg.utils.a.c(r102, "channel[" + r104 + "], wrds key: " + r108 + " init, update version: " + r109.f458180a);
        String r115 = r103;
    L14:
        boolean r116 = true;
    L16:
        if (r116 == false) goto L31;
        r100 = this;
        Iterator<ylc.c> r117 = r100.f467104b.iterator();
    L19:
        if (r117.hasNext() == false) goto L21;
        r117.next().a(r109);
        goto L19
    L21:
        a r118 = (a) ((LinkedHashMap) r100.f467103a).get(Long.valueOf(r104));
        if (r118 == null) goto L32;
        HashMap<String, Set<ylc.c>> r119 = r118.f467107b;
        if (r119 == null) goto L32;
        Set<ylc.c> r120 = r119.get(r108);
        if (r120 == null) goto L32;
        Iterator<T> r121 = r120.iterator();
    L29:
        if (r121.hasNext() == false) goto L32;
        ((ylc.c) r121.next()).a(r109);
    L32:
        r101 = r110;
        r103 = r115;
        goto L7
    L31:
        r100 = this;
        goto L32
    L11:
        long r122 = r114.f458180a;
        r115 = r103;
        long r123 = r109.f458180a;
        if (r123 <= r122) goto L15;
        Intrinsics.checkNotNullParameter(r108, "syncKey");
        Intrinsics.checkNotNullParameter(r109, "syncData");
        r113.f467106a.put(r108, r109);
        r102 = r111;
        com.ss.ugc.live.sdk.msg.utils.a.c(r102, "channel[" + r104 + "], wrds key: " + r108 + " update, previous version: " + r122 + ", update version: " + r123);
        goto L14
    L15:
        r102 = r111;
        com.ss.ugc.live.sdk.msg.utils.a.c(r102, "channel[" + r104 + "], wrds key: " + r108 + " no need update, previous version: " + r122 + ", update version: " + r123);
        r116 = false;
        goto L16
    }
}
