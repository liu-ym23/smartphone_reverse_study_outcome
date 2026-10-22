package cu0;

import android.content.Context;
import android.net.Uri;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.fansclub.panel.FansClubPanelTypes;
import com.bytedance.android.live.profit.fansclub.panel.d;
import com.bytedance.android.live.profit.fansclub.panel.e;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vy0.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements e<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f465408a;

    /* JADX INFO: renamed from: cu0.a$a, reason: collision with other inner class name */
    public static final class C5587a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f465409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f465410b;

        @Override // com.bytedance.android.live.profit.fansclub.p
        public final void show() {
            a(null);
        }

        public final void a(Function1<? super Uri, ? extends Uri> r100) {
            if (UriProtector.getQueryParameterNames(this.f465410b).contains("height") == true) goto L5;
            Uri r101 = this.f465410b.buildUpon().appendQueryParameter("height", String.valueOf(500)).build();
        L6:
            if (r100 == null) goto L11;
            Uri r102 = r100.invoke(r101);
            if (r102 == null) goto L11;
            r101 = r102;
        L11:
            ((vy0.b) f.a(c.class)).U0(this.f465409a, r101, null);
            return;
        L5:
            r101 = this.f465410b;
            goto L6
        }

        public C5587a(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "uri");
            this.f465409a = r100;
            this.f465410b = r101;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x0 f465411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x0 f465412b;

        public b() {
            this.f465411a = new x0(Uri.EMPTY);
            this.f465412b = new x0(Uri.EMPTY);
        }
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f465408a = r100;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final d a(FansClubEntranceParams r100) {
        Intrinsics.checkNotNullParameter(r100, "entranceParams");
        return new b();
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final boolean b(int r100, FansClubEntranceParams r101) {
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        if (r100 != FansClubPanelTypes.Lynx.ordinal()) goto L5;
    L8:
        return true;
    L5:
        if (r100 == FansClubPanelTypes.Web.ordinal()) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final p c(int r100, FansClubEntranceParams r101, d r102) {
        b r103 = (b) r102;
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        Intrinsics.checkNotNullParameter(r103, "panelParams");
        if (r100 != FansClubPanelTypes.Lynx.ordinal()) goto L6;
        return new C5587a(this.f465408a, r103.f465411a.c());
    L6:
        if (r100 == FansClubPanelTypes.Web.ordinal()) goto L11;
        return null;
    L11:
        return new C5587a(this.f465408a, x6.a.b(r103.f465412b.toString()).buildUpon().appendQueryParameter("type", "popup").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom").build());
    }
}
