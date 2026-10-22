package mnc;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.component.logger.api.LogLevel;
import com.suite.component.logger.api.e;
import com.suite.component.logger.c;
import com.suite.component.logger.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pqb.e f514571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f514572b;

    /* JADX INFO: renamed from: mnc.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6837a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f514573a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[LogLevel.VERBOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[LogLevel.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[LogLevel.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[LogLevel.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f514573a = r100;
        }
    }

    @Override // com.suite.component.logger.api.e
    public final boolean isEnable() {
        return this.f514572b.invoke().booleanValue();
    }

    @Override // com.suite.component.logger.api.e
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        String r101 = d.a(r100);
        if (r101 == null) goto L5;
        r100.b(r100.f460117c + " param:" + r101);
    L5:
        pqb.b.a r102 = pqb.b.f530315a;
        String r103 = pqb.b.a.a(r100.f460116b, r100.f460122h, Integer.valueOf(r100.f460123i));
        if (r103 != null) goto L8;
        r103 = r100.f460116b;
    L8:
        int r104 = C6837a.f514573a[r100.f460115a.ordinal()];
        if (r104 != 1) goto L11;
        this.f514571a.d(r103, r100.f460117c, r100.f460124j);
        return;
    L11:
        if (r104 != 2) goto L13;
        this.f514571a.v(r103, r100.f460117c, r100.f460124j);
        return;
    L13:
        if (r104 != 3) goto L15;
        this.f514571a.i(r103, r100.f460117c, r100.f460124j);
        return;
    L15:
        if (r104 != 4) goto L17;
        this.f514571a.w(r103, r100.f460117c, r100.f460124j);
        return;
    L17:
        if (r104 == 5) goto L19;
        this.f514571a.i(r103, r100.f460117c, r100.f460124j);
        return;
    L19:
        this.f514571a.e(r103, r100.f460117c, r100.f460124j);
    }

    @Override // com.suite.component.logger.api.e
    public final void b(com.suite.component.logger.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public a(pqb.e r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "isEnable");
        this.f514571a = r100;
        this.f514572b = r101;
    }
}
