package kotlinx.coroutines.internal;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f504939a = null;

    static {
        f504939a = new b0(ErrorCode.CLOSED);
    }

    public static final <S extends y<S>> Object a(S r100, long r101, Function2<? super Long, ? super S, ? extends S> r102) {
    L3:
        if (r100.f504984c >= r101) goto L5;
    L8:
        AtomicReferenceFieldUpdater r103 = e.f504941a;
        Object r104 = r103.get(r100);
        b0 r105 = f504939a;
        if (r104 == r105) goto L10;
        S r106 = (S) ((e) r104);
        if (r106 != null) goto L13;
        r106 = r102.invoke(Long.valueOf(r100.f504984c + 1), r100);
    L16:
        if (r103.compareAndSet(r100, null, r106) == true) goto L17;
        if (r103.get(r100) == null) goto L16;
        boolean r107 = false;
    L21:
        if (r107 == false) goto L3;
        if (r100.d() == false) goto L13;
        r100.e();
        goto L13
    L17:
        r107 = true;
    L13:
        r100 = (Object) r106;
        goto L3
    L10:
        return r105;
    L5:
        if (r100.d() == true) goto L8;
        return r100;
    }
}
