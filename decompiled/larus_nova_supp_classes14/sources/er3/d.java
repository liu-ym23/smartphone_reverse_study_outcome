package er3;

import com.bytedance.android.window.shop.widget.popup.entity.WindowPopupActionType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d {
    public static final /* synthetic */ int b = 0;
    public final WindowPopupActionType a;

    public static final class a extends d {
        public a() {
            super(WindowPopupActionType.CLOSE_SELF);
        }
    }

    public static final class b {
        public static d a(f r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            WindowPopupActionType.a r1 = WindowPopupActionType.Companion;
            String r2 = r3.a();
            r1.getClass();
            if (r2 != null) goto L8;
            WindowPopupActionType r4 = null;
        L9:
            if (r4 != null) goto L11;
            return null;
        L11:
            int r0 = e.a[r4.ordinal()];
            if (r0 != 1) goto L14;
            String r5 = r3.c();
            if (r5 != null) goto L29;
            r5 = "";
        L29:
            return new C0119d(r5);
        L14:
            if (r0 == 2) goto L31;
            if (r0 != 3) goto L23;
            Long r6 = r3.b();
            if (r6 == null) goto L20;
            long r7 = r6.longValue();
        L30:
            return new c(r7);
        L20:
            r7 = 2000;
            goto L30
        L23:
            throw new NoWhenBranchMatchedException();
        L31:
            return new a();
        L8:
            r4 = (WindowPopupActionType) WindowPopupActionType.access$getMapping$cp().get(r2);
            goto L9
        }
    }

    public static final class c extends d {
        public final long c;

        public c(long r2) {
            super(WindowPopupActionType.DELAYED_CLOSE_SELF);
            this.c = r2;
        }
    }

    /* JADX INFO: renamed from: er3.d$d, reason: collision with other inner class name */
    public static final class C0119d extends d {
        public final String c;

        public C0119d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "schema");
            super(WindowPopupActionType.OPEN_SCHEMA);
            this.c = r2;
        }
    }

    static {
    }

    public d(WindowPopupActionType r2) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        this.a = r2;
    }
}
