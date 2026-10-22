package uu2;

import android.graphics.Bitmap;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements su2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, C7935a> f551734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f551735b = null;

    /* JADX INFO: renamed from: uu2.a$a, reason: collision with other inner class name */
    public static final class C7935a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f551736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Disposable f551737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f551738c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7935a) == false) goto L12;
            C7935a r101 = (C7935a) r100;
            if (Intrinsics.areEqual(this.f551736a, r101.f551736a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f551737b, r101.f551737b) == true) goto L10;
            return false;
        L10:
            if (this.f551738c == r101.f551738c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            Bitmap r100 = this.f551736a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Disposable r104 = this.f551737b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            boolean r106 = this.f551738c;
            ?? r107 = r106;
            if (r106 == false) goto L13;
            r107 = 1;
        L13:
            return r105 + r107;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LoadStatus(bitmap=" + this.f551736a + ", dataSource=" + this.f551737b + ", isLoading=" + this.f551738c + ")";
        }

        public C7935a() {
            this.f551736a = null;
            this.f551737b = null;
            this.f551738c = false;
        }
    }

    public a() {
    }

    static {
        f551735b = new a();
        f551734a = new LinkedHashMap();
    }

    @Override // su2.a
    public final void release(long r100) {
        Map<Long, C7935a> r101 = f551734a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        C7935a r103 = (C7935a) r102.get(Long.valueOf(r100));
        if (r103 == null) goto L7;
        Disposable r104 = r103.f551737b;
        if (r104 == null) goto L7;
        r104.dispose();
    L7:
        r101.remove(Long.valueOf(r100));
    }
}
