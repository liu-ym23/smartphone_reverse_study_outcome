package cu0;

import android.content.Context;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.fansclub.panel.FansClubPanelTypes;
import com.bytedance.android.live.profit.fansclub.panel.d;
import com.bytedance.android.live.profit.fansclub.panel.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import vy0.c;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements e<C5588b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f465413a;

    public static final class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f465414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f465415b;

        @Override // com.bytedance.android.live.profit.fansclub.p
        public final void show() {
            ((c) f.a(c.class)).j1(this.f465414a, this.f465415b);
        }

        public a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "schema");
            this.f465414a = r100;
            this.f465415b = r101;
        }
    }

    /* JADX INFO: renamed from: cu0.b$b, reason: collision with other inner class name */
    public static final class C5588b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f465416a;

        public C5588b() {
            this.f465416a = "";
        }
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f465413a = r100;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final d a(FansClubEntranceParams r100) {
        Intrinsics.checkNotNullParameter(r100, "entranceParams");
        return new C5588b();
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final boolean b(int r100, FansClubEntranceParams r101) {
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        if (r100 != FansClubPanelTypes.Redirect.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final p c(int r100, FansClubEntranceParams r101, d r102) {
        C5588b r103 = (C5588b) r102;
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        Intrinsics.checkNotNullParameter(r103, "panelParams");
        return new a(this.f465413a, r103.f465416a);
    }
}
