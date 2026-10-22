package s2b;

import android.os.Handler;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.e0;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class o implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.service.p f540396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f540397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f540398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<e0> f540399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f540400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AndroidThrottle<MessageInfo> f540401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f540402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<String> f540403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Long> f540404i;

    public static final class a {
    }

    public static final class b implements AndroidThrottle.d<MessageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, MessageInfo> f540405a;

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final Collection<MessageInfo> a() {
            ArrayList r100 = new ArrayList(((HashMap) this.f540405a).values());
            ((HashMap) this.f540405a).clear();
            return r100;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void clear() {
            ((HashMap) this.f540405a).clear();
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final int size() {
            return ((HashMap) this.f540405a).size();
        }

        public b() {
            this.f540405a = new HashMap();
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void put(MessageInfo r100) {
            MessageInfo r101 = r100;
            if (r101 == null) goto L6;
            Map<String, MessageInfo> r102 = this.f540405a;
            HashMap r103 = (HashMap) r102;
            r103.put(r101.getId(), r101);
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f540406a;

        public c(o r100) {
            this.f540406a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (((HashMap) this.f540406a.f540397b.f540405a).isEmpty() == true) goto L9;
            Collection<MessageInfo> r100 = this.f540406a.f540397b.a();     // Catch: Throwable -> L6
            this.f540406a.e(r100, false, null);     // Catch: Throwable -> L6
            this.f540406a.f540401f.b();     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    public abstract boolean d();

    @Override // com.ss.android.lark.biz.im.api.f0
    public final void b() {
        this.f540398c.post(new c(this));
    }

    public o() {
        com.ss.android.lark.im.sdk.service.p r100 = ImSdkService.f();
        Intrinsics.checkNotNullParameter(r100, "messageService");
        this.f540396a = r100;
        b r101 = new b();
        this.f540397b = r101;
        Handler r102 = CoreThreadPool.getNonblockingHandler();
        this.f540398c = r102;
        this.f540399d = new CopyOnWriteArrayList();
        AndroidThrottle.a r103 = new AndroidThrottle.a();
        r103.f285878b = 2000;
        r103.f285879c = 2;
        r103.f285880d = r101;
        r103.f285877a = r102;
        r103.f285881e = new p(this);
        this.f540401f = new AndroidThrottle(r103);
        this.f540403h = new HashSet();
        this.f540404i = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.biz.im.api.f0
    public void c(List<? extends MessageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ArrayList r101 = new ArrayList();
        Iterator<? extends MessageInfo> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L22;
        MessageInfo r103 = r102.next();
        MessageFoldDetail r104 = r103.getMessageFoldDetail();
        if (r104 == null) goto L18;
        if (r104.getFoldId().length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L18;
        Map<String, Long> r106 = this.f540404i;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        Long r108 = (Long) r107.get(r104.getFoldId());
        long r109 = r104.getUpdateTimeMs();
        if (r108 == null) goto L17;
        if (r108.longValue() == r109) goto L4;
    L17:
        this.f540404i.put(r104.getFoldId(), Long.valueOf(r104.getUpdateTimeMs()));
        r101.add(r103);
        goto L4
    L10:
        r105 = false;
    L18:
        String r110 = r103.getId();
        if (this.f540403h.contains(r110) == true) goto L4;
        this.f540403h.add(r110);
        r101.add(r103);
        goto L4
    L22:
        this.f540401f.e(r101);
    }

    public final void e(Collection<? extends MessageInfo> r100, boolean r101, MessageInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        Iterator<e0> r103 = this.f540399d.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        e0 r104 = r103.next();
        CollectionsKt.toList(r100);
        r104.a();
        goto L4
    L6:
        a0.a r105 = new a0.a();
        ArrayList r106 = new ArrayList(r100);
        Intrinsics.checkNotNullParameter(r106, "messages");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f426084a = r106;
        r105.f426085b = this.f540402g;
        r105.f426087d = d();
        r105.f426088e = r101;
        if (r102 == null) goto L9;
        Message r107 = r102.getMessage();
    L10:
        r105.f426089f = r107;
        String r108 = this.f540400e;
        if (r108 == null) goto L13;
        Intrinsics.checkNotNullParameter(r108, "threadId");
        r105.f426086c = r108;
    L13:
        this.f540396a.j6(new a0(r105));
        return;
    L9:
        r107 = null;
        goto L10
    }
}
