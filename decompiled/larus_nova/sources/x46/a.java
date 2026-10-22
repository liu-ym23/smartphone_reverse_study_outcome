package x46;

import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.tools.prefetch.PrefetchRequest;
import com.bytedance.ies.tools.prefetch.c;
import com.bytedance.ies.tools.prefetch.l;
import com.bytedance.ies.tools.prefetch.v;
import com.bytedance.ies.tools.prefetch.x;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.ies.tools.prefetch.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f562442b;

    /* JADX INFO: renamed from: x46.a$a, reason: collision with other inner class name */
    public static final class C8194a implements l {
        @Override // com.bytedance.ies.tools.prefetch.l
        public final List<PrefetchProcess> getCacheByScheme(String r100) {
            a r101 = a.f562442b;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getCacheByScheme(r100);
        }

        @Override // com.bytedance.ies.tools.prefetch.l
        public final PrefetchProcess a(PrefetchRequest r100, x r101) {
            a r102 = a.f562442b;
            if (r102 == null) goto L5;
            PrefetchProcess r103 = r102.a(r100, r101);
        L6:
            if (r103 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            return r103;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.ies.tools.prefetch.l
        public final PrefetchProcess b(PrefetchRequest r100, x r101) {
            a r102 = a.f562442b;
            if (r102 == null) goto L5;
            PrefetchProcess r103 = r102.b(r100, r101);
        L6:
            if (r103 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            return r103;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b extends com.bytedance.ies.tools.prefetch.a<a> {
        public b() {
        }
    }

    static {
    }

    public a(String r100, v r101, c r102) {
        super(r100, r101, r102);
    }
}
