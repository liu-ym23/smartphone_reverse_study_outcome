package hd5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.d0;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.util.io.e;
import dd5.i1;
import dd5.s1;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lc5.f;
import lc5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Ref.ObjectRef<String> a;
    public final /* synthetic */ d0 b;

    public a(Ref.ObjectRef<String> r1, d0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        SpaceMakeCopyToSpaceResult r11 = (SpaceMakeCopyToSpaceResult) r10;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.pricing.recordsnumandgantt.fe") == false) goto L11;
        SpaceMakeCopyToSpaceResult.Data r0 = (SpaceMakeCopyToSpaceResult.Data) ((Result) r11).data;
        if (r0 == null) goto L7;
        String r1 = r0.getUrl();
    L8:
        String r2 = e.a(r1, "from", "create_suite_copy");
        SpaceMakeCopyToSpaceResult.Data r3 = (SpaceMakeCopyToSpaceResult.Data) ((Result) r11).data;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r2);
        r3.setUrl(r2);
        goto L11
    L7:
        r1 = null;
    L11:
        s1 r4 = s1.a.a;
        SpaceMakeCopyToSpaceResult.Data r5 = (SpaceMakeCopyToSpaceResult.Data) ((Result) r11).data;
        if (r5 == null) goto L14;
        r5.getObjToken();
    L14:
        SpaceMakeCopyToSpaceResult.Data r12 = (SpaceMakeCopyToSpaceResult.Data) ((Result) r11).data;
        if (r12 == null) goto L17;
        r12.getUrl();
    L17:
        String r13 = (String) this.a.element;
        Iterator<WeakReference<i1>> r14 = r4.f.iterator();
    L19:
        if (r14.hasNext() == false) goto L25;
        WeakReference<i1> r6 = r14.next();
        if (r6 == null) goto L19;
        if (r6.get() == null) goto L19;
        r6.get().m4();
        goto L19
    L25:
        f.a r15 = f.a;
        d r7 = (d) org.koin.java.a.c(d.class, null, null, 6);
        d0 r8 = this.b;
        String r9 = r8.h;
        if (r9 != null) goto L28;
        String r16 = "";
    L29:
        String r17 = r8.g;
        if (r17 != null) goto L32;
        String r18 = "";
    L33:
        int r19 = r8.getType();
        String r20 = this.b.b;
        if (r20 != null) goto L36;
        String r21 = "";
    L37:
        f.a.H(new o(r7, r16, r18, "succeed", r19, r21));
        return;
    L36:
        r21 = r20;
        goto L37
    L32:
        r18 = r17;
        goto L33
    L28:
        r16 = r9;
        goto L29
    }
}
