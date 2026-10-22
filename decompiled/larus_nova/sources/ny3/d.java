package ny3;

import com.bytedance.awemeopen.apps.framework.utils.k0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends ux3.a<my3.b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f521196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f521197d;

    public static final class a implements p24.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f521198a;

        public a(d r100) {
            this.f521198a = r100;
        }

        @Override // r34.e
        public final void onFail(Exception r100) {
            ux3.b r101 = (ux3.b) this.f521198a.f547816b;
            if (r101 == null) goto L6;
            new RuntimeException();
            r101.a();
            return;
        }

        @Override // r34.e
        public final void onSuccess(o14.f r100) {
            o14.f r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            boolean r102 = false;
            this.f521198a.a(r101, false);
            d r103 = this.f521198a;
            List<o14.a> r104 = r101.g();
            boolean r105 = this.f521198a.f521197d;
            ux3.b r106 = (ux3.b) r103.f547816b;
            if (r106 == null) goto L13;
            List<o14.a> r107 = r104;
            if (r107 != null) goto L7;
        L8:
            r102 = true;
        L9:
            if (r102 == false) goto L11;
            r106.r6();
            return;
        L11:
            r106.g();
            r106.m(TypeIntrinsics.asMutableList(r104), r105);
            return;
        L7:
            if (r107.isEmpty() == false) goto L9;
        }
    }

    public d() {
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        ux3.b r101 = (ux3.b) this.f547816b;
        if (r101 == null) goto L6;
        r101.showLoading();
    L6:
        if (((my3.b) this.f547815a) == null) goto L9;
        a r102 = new a(this);
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        d14.a r103 = b14.a.f16924a;
        ((p24.e) b14.a.a(p24.e.class)).k2(y54.a.a(), r100, 0, r102);
        return;
    }

    public final void a(o14.f r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        List<o14.a> r100 = r110.g();
        if (r100 == null) goto L15;
        Iterator<o14.a> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L15;
        o14.a r102 = r101.next();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r102.c() * 1000), "<set-?>");
        List<o14.a> r103 = r102.replyComments;
        if (r103 == null) goto L7;
        Iterator<o14.a> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L7;
        o14.a r105 = r104.next();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter(k0.a(y54.a.a(), r105.c() * 1000), "<set-?>");
    L15:
        List<o14.a> r106 = r110.g();
        boolean r107 = false;
        if (r106 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == true) goto L31;
        this.f521196c = r110.e();
        if (r111 == true) goto L26;
        r107 = r110.f();
        goto L31
    L26:
        if (r110.f() == false) goto L31;
        if (this.f521197d == false) goto L31;
        r107 = true;
    L31:
        this.f521197d = r107;
        return;
    L18:
        if (r106.isEmpty() == true) goto L21;
        r108 = false;
        goto L22
    }
}
