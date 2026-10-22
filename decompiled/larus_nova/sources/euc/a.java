package euc;

import java.util.Map;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.u1;
import xwc.f;
import ywc.c;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends AbstractCoroutineContextElement implements u1<Map<String, ? extends String>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C5822a f474182b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f474183a;

    /* JADX INFO: renamed from: euc.a$a, reason: collision with other inner class name */
    public static final class C5822a implements CoroutineContext.Key<a> {
        public C5822a() {
        }
    }

    static {
        f474182b = new C5822a();
    }

    public a() {
        c r100 = f.f565320a;
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.a();
        super(f474182b);
        this.f474183a = r101;
        return;
    L7:
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static void d(Map r100) {
        if (r100 != null) goto L9;
        c r101 = f.f565320a;
        if (r101 == null) goto L8;
        r101.clear();
        return;
    L8:
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    L9:
        c r102 = f.f565320a;
        if (r102 == null) goto L14;
        r102.b(r100);
        return;
    L14:
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    @Override // kotlinx.coroutines.u1
    public final Map<String, ? extends String> updateThreadContext(CoroutineContext r100) {
        c r101 = f.f565320a;
        if (r101 == null) goto L7;
        Map<String, String> r102 = r101.a();
        d(this.f474183a);
        return r102;
    L7:
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    @Override // kotlinx.coroutines.u1
    public final void restoreThreadContext(CoroutineContext r100, Map<String, ? extends String> r101) {
        d(r101);
    }
}
