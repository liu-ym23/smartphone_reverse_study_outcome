package y81;

import android.view.View;
import com.bytedance.android.live.base.model.message.m5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends c {
    public static final /* synthetic */ int O = 0;
    public final Integer N;

    /* JADX INFO: renamed from: y81.a$a, reason: collision with other inner class name */
    public static final class C8310a {
    }

    static {
    }

    @Override // y81.b, u81.d
    public final Integer b() {
        return this.N;
    }

    @Override // y81.c, u81.d
    public final void g(w81.a r100) {
        Long r101 = null;
        if (r100 == null) goto L5;
        tlc.d r102 = r100.f558609a;
    L7:
        if ((r102 instanceof m5) == true) goto L9;
        r102 = null;
    L9:
        m5 r103 = (m5) r102;
        StringBuilder r104 = new StringBuilder("process holder binding, status: ");
        if (r103 == null) goto L12;
        r101 = r103.getStatus();
    L12:
        r104.append(r101);
        r104.append(", curStatus: ");
        r104.append(this.f566676l);
        r104.append(", showStatus: ");
        r104.append(this.f566675k);
        ALogger.d("AnchorTrafficSupportHolder", r104.toString());
        if (r103 != null) goto L15;
        return;
    L15:
        Boolean r105 = r100.f558610b;
        if (r105 == null) goto L18;
        boolean r106 = r105.booleanValue();
    L19:
        this.f566665c = r106;
        Long r107 = r103.getStatus();
        if (r107 != null) goto L22;
    L32:
        Long r108 = r103.getStatus();
        if (r108 != null) goto L35;
    L44:
        Long r109 = r103.getStatus();
        int r110 = 0;
        if (r109 != null) goto L47;
    L60:
        i(0);
        return;
    L47:
        if (((int) r109.longValue()) != 1) goto L60;
        if (this.f566675k != 1) goto L60;
        Long r111 = r103.getNumber();
        if (r111 == null) goto L54;
        this.f566677m = (int) r111.longValue();
    L54:
        if (this.f566676l != 2) goto L56;
        this.f566676l = 1;
        p();
    L56:
        Long r112 = r103.getNumber();
        if (r112 == null) goto L59;
        r110 = (int) r112.longValue();
    L59:
        n(r110);
        this.f566676l = 1;
        return;
    L35:
        if (((int) r108.longValue()) != 2) goto L44;
        if (this.f566675k != 1) goto L44;
        this.f566676l = 2;
        Long r113 = r103.getNumber();
        if (r113 == null) goto L43;
        int r114 = (int) r113.longValue();
        if (r114 <= this.f566677m) goto L43;
        this.f566677m = r114;
    L43:
        n(this.f566677m);
        l();
        return;
    L22:
        if (((int) r107.longValue()) != 1) goto L32;
        if (this.f566675k != 0) goto L32;
        if (this.f566679o == true) goto L32;
        this.f566676l = 1;
        m();
        Long r115 = r103.getNumber();
        if (r115 == null) goto L62;
        int r116 = (int) r115.longValue();
        if (r116 <= 0) goto L63;
        this.f566677m = r116;
        return;
    L63:
        return;
    L62:
        return;
    L18:
        r106 = true;
        goto L19
    L5:
        r102 = null;
        goto L7
    }

    public a(DataCenter r100, View r101, int r102, View r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r103, "parentView");
        super(r100, r101, r102, r103);
        this.N = r104;
    }
}
