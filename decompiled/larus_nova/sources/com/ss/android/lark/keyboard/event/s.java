package com.ss.android.lark.keyboard.event;

import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f429314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<T> f429315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f429316c;

    public static final class a {
    }

    public interface b {
        void recycle();
    }

    static {
    }

    public final T a() {
        T r100 = this.f429315b.poll();
        if (r100 != null) goto L7;
        r100 = this.f429314a.invoke();
        int r101 = this.f429316c;
        if (r101 >= 3) goto L7;
        this.f429316c = r101 + 1;
    L7:
        return r100;
    }

    public s(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "constructor");
        this.f429314a = r100;
        this.f429315b = new LinkedList();
    }
}
