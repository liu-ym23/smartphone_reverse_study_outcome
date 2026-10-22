package g1b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.log.ILog$Internal$LogRequest;
import com.ss.android.lark.chameleonv2.lkapi.log.LogLevel;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: g1b.a$a, reason: collision with other inner class name */
    public static final class C5977a {
    }

    public final class b extends AbsChameleonHandler<ILog$Internal$LogRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f479629a;

        /* JADX INFO: renamed from: g1b.a$b$a, reason: collision with other inner class name */
        public /* synthetic */ class C5978a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f479630a = null;

            static {
                int[] r100 = new int[LogLevel.values().length];
                r100[LogLevel.INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[LogLevel.WARN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[LogLevel.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f479630a = r100;
            }
        }

        public b() {
            this.f479629a = LKAPIModules.Internal.Log.LogNoReturn.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f479629a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(ILog$Internal$LogRequest r100, Callback r101) {
            ILog$Internal$LogRequest r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            String r103 = "[" + r102.getLogModule() + "] " + r102.getMessage();
            int r104 = r102.getLevel();
            if (r104 != 3) goto L5;
            LogLevel r105 = LogLevel.INFO;
        L12:
            int r106 = C5978a.f479630a[r105.ordinal()];
            if (r106 != 1) goto L15;
            j.e("LK_API_TAG_Log", r103);
            return;
        L15:
            if (r106 == 2) goto L20;
            if (r106 != 3) goto L19;
            j.b("LK_API_TAG_Log", r103);
            return;
        L19:
            throw new NoWhenBranchMatchedException();
        L20:
            j.f("LK_API_TAG_Log", r103);
            return;
        L5:
            if (r104 != 4) goto L7;
            r105 = LogLevel.WARN;
            goto L12
        L7:
            if (r104 == 5) goto L9;
            r105 = LogLevel.INFO;
            goto L12
        L9:
            r105 = LogLevel.ERROR;
            goto L12
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
