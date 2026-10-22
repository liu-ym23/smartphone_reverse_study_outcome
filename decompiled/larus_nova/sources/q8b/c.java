package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.handler.MatchRegulate;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface c extends b {

    public static final class a {
        public static boolean a(c r110, DecisionData.Action r111) {
            Intrinsics.checkNotNullParameter(r111, "action");
            Intrinsics.checkNotNullParameter(r111, "action");
            String r100 = r111.getName();
            String r101 = r111.getParams().get("policyType");
            m8b.c r112 = com.ss.android.lark.conditional.access.network.model.response.a.b(r111);
            Iterator<T> r113 = r110.getRules().iterator();
        L3:
            boolean r102 = false;
            if (r113.hasNext() == false) goto L54;
            i r103 = (i) r113.next();
            MatchRegulate r104 = r103.f532061a.f532060b;
            int[] r105 = b.a.f532051a;
            int r106 = r105[r104.ordinal()];
            if (r106 == 1) goto L15;
            if (r106 == 2) goto L14;
            if (r106 != 3) goto L13;
            if (r100 == null) goto L14;
            boolean r107 = false;
        L16:
            int r108 = r105[r103.f532062b.f532060b.ordinal()];
            if (r108 == 1) goto L26;
            if (r108 == 2) goto L25;
            if (r108 != 3) goto L24;
            if (r101 == null) goto L25;
            boolean r109 = false;
        L27:
            int r114 = r105[r103.f532063c.f532060b.ordinal()];
            if (r114 == 1) goto L37;
            if (r114 == 2) goto L36;
            if (r114 != 3) goto L35;
            if (r112.f512539a == null) goto L36;
        L38:
            if (r107 == false) goto L3;
            if (r109 == false) goto L3;
            if (r102 == false) goto L3;
            return true;
        L35:
            throw new NoWhenBranchMatchedException();
        L36:
            r102 = true;
            goto L38
        L37:
            r102 = Intrinsics.areEqual(r103.f532063c.f532059a, r112.f512539a);
            goto L38
        L24:
            throw new NoWhenBranchMatchedException();
        L25:
            r109 = true;
            goto L27
        L26:
            r109 = Intrinsics.areEqual(r103.f532062b.f532059a, r101);
            goto L27
        L13:
            throw new NoWhenBranchMatchedException();
        L14:
            r107 = true;
            goto L16
        L15:
            r107 = Intrinsics.areEqual(r103.f532061a.f532059a, r100);
            goto L16
        L54:
            return false;
        }
    }

    void a(InternalSecurityAction r100);

    String c();
}
