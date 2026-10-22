package com.ss.videoarch.liveplayer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.videoarch.liveplayer.log.LiveLoggerService;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveLoggerService f459558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f459559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, d> f459560c;

    public class a implements LSPreconnManager.PreconnResultCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f459561a;

        public a(o r100) {
            this.f459561a = r100;
        }

        @Override // com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager.PreconnResultCallBack
        public void onConnected(LSPreconnManager.PreconnResultCallBack.PreconnResult r100) {
            if (o.access$000(this.f459561a) != null) goto L5;
            return;
        L5:
            com.ss.videoarch.liveplayer.log.c.i("VLDNSParse", "PreconnResultCallBack, host: " + r100.host + "ip: " + r100.f459727ip + " ret: " + r100.ret);
            o.access$000(this.f459561a).Pb = r100.ret;
            o.access$000(this.f459561a).Qb = r100.host;
            o.access$000(this.f459561a).Rb = r100.f459727ip;
        }
    }

    public class b implements q.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f459562a;

        public b(o r100) {
            this.f459562a = r100;
        }

        @Override // com.ss.videoarch.liveplayer.q.b
        public void onDNSParsed(String r110, String r111, String r112, String r113, p.a r114) {
            if (o.access$300(this.f459562a).containsKey(r113) == true) goto L6;
            com.ss.videoarch.liveplayer.log.c.e("VLDNSParse", "No host record: " + r113);
            return;
        L6:
            List<c> r100 = ((d) o.access$300(this.f459562a).get(r113)).f459564b;
            int r101 = 0;
        L7:
            ArrayList r102 = (ArrayList) r100;
            if (r101 >= r102.size()) goto L13;
            c r103 = (c) ListProtector.get(r102, r101);
            if (r103 == null) goto L12;
            r103.onDNSParsed(r110, r111, r112, r113, r114);
        L12:
            r101 = r101 + 1;
            goto L7
        L13:
            o.access$400(this.f459562a, r113);
        }
    }

    public interface c {
        void onDNSParsed(String r100, String r101, String r102, String r103, p.a r104);
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f459563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f459564b;

        public d(o r100, q r101, c r102) {
            ArrayList r103 = new ArrayList();
            this.f459564b = r103;
            this.f459563a = r101;
            r103.add(r102);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f459565a = null;

        private e() {
        }

        static {
            f459565a = new o(null);
        }

        public static /* synthetic */ o access$200() {
            return f459565a;
        }
    }

    private o() {
        this.f459558a = null;
        this.f459559b = new Object();
        this.f459560c = new HashMap();
        a r100 = new a(this);
        LSPreconnManager.inst().setPreconnResultCallBack(r100);
    }

    public static o inst() {
        return e.access$200();
    }

    public /* synthetic */ o(a r100) {
        this();
    }

    public static /* synthetic */ LiveLoggerService access$000(o r100) {
        return r100.f459558a;
    }

    public static /* synthetic */ HashMap access$300(o r100) {
        return r100.f459560c;
    }

    private void unregisterCallback(String r100) {
        if (this.f459560c.containsKey(r100) == true) goto L5;
        return;
    L5:
        ((ArrayList) this.f459560c.get(r100).f459564b).clear();
    }

    public static /* synthetic */ void access$400(o r100, String r101) {
        r100.unregisterCallback(r101);
    }

    private void registerCallback(String r100, c r101) {
        if (this.f459560c.containsKey(r100) == true) goto L5;
        return;
    L5:
        ((ArrayList) this.f459560c.get(r100).f459564b).add(r101);
    }

    public void parsePlayDNS(p r100, c r101) {
        if (this.f459558a != null) goto L5;
        this.f459558a = r100.getDNSParserData().f459573b;
    L5:
        String r102 = r100.getHost();
        Object r103 = this.f459559b;
        monitor-enter(r103);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (this.f459560c.containsKey(r102) == false) goto L10;
        registerCallback(r102, r101);     // Catch: Throwable -> L17
        q r104 = this.f459560c.get(r102).f459563a;     // Catch: Throwable -> L17
        q.b r105 = r104.getCallBack();     // Catch: Throwable -> L17
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L17
        r104.init(r100, r105);
        if (cnc.a.isInitialized() == false) goto L15;
        cnc.a.addHighPriorityTask(r104);
        return;
    L15:
        cnc.b.addExecuteTask(r104);
        return;
    L10:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParse", "New for: " + r102 + "-->" + this.f459560c.size());     // Catch: Throwable -> L17
        q r106 = new q();     // Catch: Throwable -> L17
        b r107 = new b(this);     // Catch: Throwable -> L17
        this.f459560c.put(r102, new d(this, r106, r101));     // Catch: Throwable -> L17
        r104 = r106;
        r105 = r107;
        goto L11
    }
}
