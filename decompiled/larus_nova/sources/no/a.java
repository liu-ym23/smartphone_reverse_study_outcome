package no;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519880a;

    public abstract void a(View r100, T r101);

    public abstract T b(String r100);

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        this.f519880a = r100;
    }
}
