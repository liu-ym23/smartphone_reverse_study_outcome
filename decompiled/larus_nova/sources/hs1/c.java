package hs1;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T extends Widget> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f486945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f486946c;

    public /* synthetic */ c() {
        throw null;
    }

    public c(String r100, Class<T> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        this.f486944a = r100;
        this.f486945b = r101;
        this.f486946c = r102;
    }
}
