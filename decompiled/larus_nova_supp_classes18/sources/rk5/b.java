package rk5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.bytedance.ee.bear.list.thumbnail.e;
import com.bytedance.ee.bear.list.thumbnail.j;
import com.bytedance.ee.bear.list.thumbnail.k;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a() {
        a r0 = this.a;
        if (r0.h.isEmpty() == false) goto L6;
        return;
    L6:
        if (((Boolean) r0.b.invoke()).booleanValue() == true) goto L12;
        Iterator<T> r1 = r0.h.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        a.d r2 = (a.d) r1.next();
        r0.f.remove(r2);
        r0.g.remove(r2);
        goto L9
    L11:
        r0.h.clear();
        return;
    L12:
        int r3 = r0.k;
        List r4 = CollectionsKt.take(r0.h.values(), 20);
        List r5 = r4;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        r0.h.remove(((a.b) r6.next()).a);
        goto L14
    L17:
        if ((!r0.h.isEmpty()) == false) goto L19;
        r0.l.postDelayed(r0.i, 32);
    L19:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r8 = r5.iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        a.b r9 = (a.b) r8.next();
        r7.add(new OfficeThumbnailUrlRepository.i(r9.b, r9.d, r9.e));
        goto L21
    L23:
        OfficeThumbnailUrlRepository r10 = r0.a;
        final c r11 = new c(r0, r3, r4);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "requests");
        Intrinsics.checkNotNullParameter(r11, "callback");
        ArrayList r12 = new ArrayList();
        Iterator r13 = r7.iterator();
    L25:
        if (r13.hasNext() == false) goto L30;
        Object r14 = r13.next();
        Document r15 = ((OfficeThumbnailUrlRepository.i) r14).a;
        Intrinsics.checkNotNullParameter(r15, "document");
        if (com.bytedance.ee.bear.list.thumbnail.b.a(r15) == false) goto L25;
        r12.add(r14);
        goto L25
    L30:
        if (r12.isEmpty() == false) goto L32;
        OfficeThumbnailUrlRepository.b r16 = OfficeThumbnailUrlRepository.g.a;
    L37:
        r0.j = r16;
        Iterator r17 = r5.iterator();
    L39:
        if (r17.hasNext() == false) goto L53;
        r0.g.put(((a.b) r17.next()).a, r16);
        goto L39
    L53:
        return;
    L32:
        NetService.f r18 = new NetService.f("/space/api/box/file/cdn_url/");
        ((NetService.e) r18).c = 1;
        ((NetService.e) r18).j = OfficeThumbnailUrlRepository.c(r12).toString();
        NetService r19 = r10.a;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r21 = r12.iterator();
    L34:
        if (r21.hasNext() == false) goto L36;
        r20.add(OfficeThumbnailUrlRepository.c.b(((OfficeThumbnailUrlRepository.i) r21.next()).a));
        goto L34
    L36:
        r16 = new OfficeThumbnailUrlRepository.d(r19.Vc(new OfficeThumbnailUrlRepository.e(r20)).a(r18).map(new com.bytedance.ee.bear.list.thumbnail.d(r10, r12)).onErrorReturn(new e(r12, r10)).subscribe(new j(r11), new k(r11)));
        goto L37
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
