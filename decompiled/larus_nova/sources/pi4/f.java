package pi4;

import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import java.util.LinkedHashMap;
import ki4.h0;
import ki4.r;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li4.u;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements ki4.g<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f529335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f529336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ki4.e<r> f529337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Long, Long, Long> f529338d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f529339a = null;

        static {
            int[] r100 = new int[MediaType.values().length];
            r100[MediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f529339a = r100;
        }
    }

    @Override // ki4.g
    public final li4.m a(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queryParam");
        MediaType r101 = r100.f503628a;
        int r102 = a.f529339a[r101.ordinal()];
        if (r102 != 1) goto L5;
        li4.m r103 = new li4.n(this.f529335a, this.f529336b, this.f529337c);
        Function2<Long, Long, Long> r104 = this.f529338d;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r104, "getDateBlock");
        r103.f509346q = r104;
    L14:
        return r103;
    L5:
        if (r102 != 2) goto L10;
        r103 = new u(this.f529335a, this.f529336b, this.f529337c);
        Function2<Long, Long, Long> r105 = this.f529338d;
        if (r105 == null) goto L14;
        Intrinsics.checkNotNullParameter(r105, "getDateBlock");
        r103.f509346q = r105;
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public f(boolean r100, ki4.e.a r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r101, "cursorParseFilter");
        this.f529335a = r100;
        this.f529336b = false;
        this.f529337c = r101;
        this.f529338d = r102;
        new LinkedHashMap();
    }
}
