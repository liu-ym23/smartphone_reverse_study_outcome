package er3;

import com.bytedance.android.window.shop.widget.popup.entity.WindowPopupActionType;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f473578b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowPopupActionType f473579a;

    public static final class a extends d {
        public a() {
            super(WindowPopupActionType.CLOSE_SELF);
        }
    }

    public static final class b {
        public static d a(f r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            WindowPopupActionType.a r101 = WindowPopupActionType.Companion;
            String r102 = r100.a();
            r101.getClass();
            if (r102 != null) goto L8;
            WindowPopupActionType r103 = null;
        L9:
            if (r103 != null) goto L11;
            return null;
        L11:
            int r104 = e.f473582a[r103.ordinal()];
            if (r104 != 1) goto L14;
            String r105 = r100.c();
            if (r105 != null) goto L29;
            r105 = "";
        L29:
            return new C5805d(r105);
        L14:
            if (r104 == 2) goto L31;
            if (r104 != 3) goto L23;
            Long r106 = r100.b();
            if (r106 == null) goto L20;
            long r107 = r106.longValue();
        L30:
            return new c(r107);
        L20:
            r107 = 2000;
            goto L30
        L23:
            throw new NoWhenBranchMatchedException();
        L31:
            return new a();
        L8:
            r103 = (WindowPopupActionType) WindowPopupActionType.access$getMapping$cp().get(r102);
            goto L9
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f473580c;

        public c(long r100) {
            super(WindowPopupActionType.DELAYED_CLOSE_SELF);
            this.f473580c = r100;
        }
    }

    /* JADX INFO: renamed from: er3.d$d, reason: collision with other inner class name */
    public static final class C5805d extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f473581c;

        public C5805d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            super(WindowPopupActionType.OPEN_SCHEMA);
            this.f473581c = r100;
        }
    }

    static {
    }

    public d(WindowPopupActionType r100) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        this.f473579a = r100;
    }
}
