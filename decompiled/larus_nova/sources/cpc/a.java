package cpc;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f464753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f464754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Bitmap> f464755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f464756d;

    public abstract boolean a();

    public int b() {
        return 0;
    }

    public abstract void c();

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f464753a});
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f464753a = r100;
        this.f464754b = "";
        this.f464755c = new ArrayList();
        this.f464756d = true;
        new ArrayList();
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f464754b = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(getClass(), r100.getClass()) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f464753a, ((a) r100).f464753a);
    }
}
