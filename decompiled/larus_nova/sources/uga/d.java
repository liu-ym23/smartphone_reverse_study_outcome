package uga;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes33.dex */
public final class d extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f550073b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550074a;

    public static final class a implements CoroutineContext.Key<d> {
        public a() {
        }
    }

    static {
        f550073b = new a();
    }

    public d(String r100) {
        super(f550073b);
        this.f550074a = r100;
    }
}
