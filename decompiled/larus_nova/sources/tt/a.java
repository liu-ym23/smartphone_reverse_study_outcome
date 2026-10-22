package tt;

import android.view.View;
import com.bytedance.android.gamecp.base.gamedetail.h0;
import com.bytedance.ies.sve_core.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements i {

    /* JADX INFO: renamed from: tt.a$a, reason: collision with other inner class name */
    public static final class C7770a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f547496b;

        public C7770a(String r100, View r101, h0 r102) {
            Intrinsics.checkNotNullParameter(r102, "fmpWidgetTraceBean");
            this.f547495a = r100;
            this.f547496b = r101;
        }
    }

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public a() {
    }
}
