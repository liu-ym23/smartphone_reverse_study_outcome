package o9a;

import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f522496c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IHostApiCallback f522498b;

    public static final class a {
    }

    static {
    }

    public c() {
        this("", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f522497a, r101.f522497a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522498b, r101.f522498b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f522497a.hashCode() * 31;
        IHostApiCallback r101 = this.f522498b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MenuItem(title=" + this.f522497a + ", onClickListener=" + this.f522498b + ')';
    }

    public c(String r100, IHostApiCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f522497a = r100;
        this.f522498b = r101;
    }
}
