package ny3;

import com.bytedance.awemeopen.apps.framework.utils.k0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends ux3.a<my3.b, Object> {
    public long c;
    public boolean d;

    public static final class a implements p24.c {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onFail(Exception r2) {
            ux3.b r3 = (ux3.b) this.a.b;
            if (r3 == null) goto L6;
            new RuntimeException();
            r3.a();
            return;
        }

        public final void onSuccess(Object r5) {
            o14.f r6 = (o14.f) r5;
            Intrinsics.checkNotNullParameter(r6, "data");
            boolean r1 = false;
            this.a.a(r6, false);
            d r0 = this.a;
            List r7 = r6.g();
            boolean r2 = this.a.d;
            ux3.b r3 = (ux3.b) r0.b;
            if (r3 == null) goto L13;
            List r4 = r7;
            if (r4 != null) goto L7;
        L8:
            r1 = true;
        L9:
            if (r1 == false) goto L11;
            r3.r6();
            return;
        L11:
            r3.g();
            r3.m(TypeIntrinsics.asMutableList(r7), r2);
            return;
        L7:
            if (r4.isEmpty() == false) goto L9;
        }
    }

    public d() {
    }

    public final void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "awemeId");
        ux3.b r1 = (ux3.b) this.b;
        if (r1 == null) goto L6;
        r1.showLoading();
    L6:
        if (((my3.b) this.a) == null) goto L9;
        a r7 = new a(this);
        Intrinsics.checkNotNullParameter(r9, "awemeId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        d14.a r0 = b14.a.a;
        b14.a.a(p24.e.class).k2(y54.a.a(), r9, 0, r7);
        return;
    }

    public final void a(o14.f r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "data");
        List r0 = r11.g();
        if (r0 == null) goto L15;
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        o14.a r2 = (o14.a) r1.next();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r2.c() * 1000), "<set-?>");
        List r3 = r2.replyComments;
        if (r3 == null) goto L7;
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L7;
        o14.a r5 = (o14.a) r4.next();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r5.c() * 1000), "<set-?>");
    L15:
        List r6 = r11.g();
        boolean r7 = false;
        if (r6 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == true) goto L31;
        this.c = r11.e();
        if (r12 == true) goto L26;
        r7 = r11.f();
        goto L31
    L26:
        if (r11.f() == false) goto L31;
        if (this.d == false) goto L31;
        r7 = true;
    L31:
        this.d = r7;
        return;
    L18:
        if (r6.isEmpty() == true) goto L21;
        r8 = false;
        goto L22
    }
}
