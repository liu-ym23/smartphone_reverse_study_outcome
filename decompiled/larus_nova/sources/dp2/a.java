package dp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livesdk.config.fe0;
import com.bytedance.android.livesdk.config.n11;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f469574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f469576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f469577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f469578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n11.b.a f469579f;

    /* JADX INFO: renamed from: dp2.a$a, reason: collision with other inner class name */
    public static final class C5697a {
    }

    static {
    }

    @Override // dp2.c
    public final cp2.b execute() {
        cp2.b r100 = fp2.b.a();
        T r101 = this.f469578e;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L41;
    L40:
        return r100;
    L41:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L38
        n11.b.a.C1768a r105 = null;
        if (this.f469574a == true) goto L16;
    L25:
        boolean r106 = true;
    L26:
        r100.f464628a = r106;     // Catch: Throwable -> L38
        if (this.f469576c == true) goto L29;
    L35:
        r102 = true;
    L36:
        r100.f464629b = r102;     // Catch: Throwable -> L38
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
        goto L40
    L29:
        if (this.f469577d == true) goto L36;
        boolean r107 = r100.f464629b;     // Catch: Throwable -> L38
        n11.b.a r108 = this.f469579f;     // Catch: Throwable -> L38
        if (r108 == null) goto L34;
        r105 = r108.d();     // Catch: Throwable -> L38
    L34:
        if (a(r107, r105) == false) goto L36;
    L16:
        if (this.f469575b == true) goto L24;
        boolean r109 = r100.f464628a;     // Catch: Throwable -> L38
        n11.b.a r110 = this.f469579f;     // Catch: Throwable -> L38
        if (r110 == null) goto L20;
        n11.b.a.C1768a r111 = r110.c();     // Catch: Throwable -> L38
    L22:
        if (a(r109, r111) == false) goto L24;
    L20:
        r111 = null;
    L24:
        r106 = false;
    L38:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L5:
        if (this.f469579f == null) goto L11;
        if ((r101 instanceof Activity) == false) goto L9;
    L10:
        r103 = true;
        goto L12
    L9:
        if ((r101 instanceof Fragment) == false) goto L11;
        goto L10
    }

    public a(T r100, n11.b.a r101) {
        this.f469578e = r100;
        this.f469579f = r101;
        Boolean r102 = r101.g();
        boolean r103 = false;
        if (r102 == null) goto L5;
        boolean r104 = r102.booleanValue();
    L6:
        this.f469574a = r104;
        Boolean r105 = r101.a();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        this.f469575b = r106;
        Boolean r107 = r101.h();
        if (r107 == null) goto L13;
        boolean r108 = r107.booleanValue();
    L14:
        this.f469576c = r108;
        Boolean r109 = r101.b();
        if (r109 == null) goto L17;
        r103 = r109.booleanValue();
    L17:
        this.f469577d = r103;
        return;
    L13:
        r108 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    public final boolean a(boolean r110, n11.b.a.C1768a r111) {
        if (r111 != null) goto L5;
        List<String> r100 = null;
    L168:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L24
        T r102 = this.f469578e;     // Catch: Throwable -> L24
        if ((r102 instanceof Activity) == false) goto L16;
        if (r102 == null) goto L14;
        String r103 = ((Activity) r102).getClass().getName();     // Catch: Throwable -> L24
    L22:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L24
    L27:
        if (Result.m9455isFailureimpl(r104) == false) goto L29;
        r104 = null;
    L29:
        String r105 = (String) r104;
        if (r100 == null) goto L171;
        Iterator<T> r106 = r100.iterator();
    L33:
        if (r106.hasNext() == false) goto L171;
        String r107 = (String) r106.next();
        if (r105 == null) goto L33;
        if (StringsKt.contains$default(r105, r107, false, 2, null) != true) goto L33;
        r110 = false;
    L171:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L61
        T r109 = this.f469578e;     // Catch: Throwable -> L61
        if ((r109 instanceof Fragment) == false) goto L59;
        String r112 = ((Fragment) r109).getTag();     // Catch: Throwable -> L61
        if (r111 == null) goto L59;
        List<String> r113 = r111.b();     // Catch: Throwable -> L61
        if (r113 == null) goto L59;
        Iterator<T> r114 = r113.iterator();     // Catch: Throwable -> L61
    L47:
        if (r114.hasNext() == false) goto L59;
        String r115 = (String) r114.next();     // Catch: Throwable -> L61
        if (r112 != null) goto L51;
    L54:
        boolean r116 = true;
    L55:
        if (r116 == true) goto L47;
        if (StringsKt.contains$default(r115, r112, false, 2, null) == false) goto L47;
        r110 = false;
        goto L47
    L51:
        if (StringsKt.isBlank(r112) == true) goto L54;
        r116 = false;
    L59:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        if (r111 == null) goto L65;
        List<String> r117 = r111.d();
    L66:
        if (r111 == null) goto L68;
        List<String> r118 = r111.e();
    L69:
        if (r117 != null) goto L169;
    L124:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L126
    L128:
        Map<Integer, String> r119 = fp2.b.f478230a;
        ArrayList r120 = new ArrayList();
        Integer r121 = com.bytedance.android.livesdk.sharedpref.b.K1.getValue();
        ILiveMiniAppService r122 = (ILiveMiniAppService) k.f(ILiveMiniAppService.class);
        if (r122 == null) goto L131;
        boolean r123 = r122.getMiniAppActivityState();
    L132:
        if (r121 != null) goto L135;
    L136:
        if (r121 != null) goto L139;
    L141:
        if (r123 == false) goto L143;
        r120.add("miniApp");
    L143:
        InteractGameContext.Companion r124 = InteractGameContext.Companion;
        r124.getClass();
        boolean r125 = fe0.f120196a.getValue().a();
        InteractGameContext r126 = r124.getContext();
        if (r126 == null) goto L146;
        boolean r127 = r126.getGameFullPanelIsShowing();
    L147:
        if (r127 == false) goto L151;
        if (r125 == false) goto L151;
        boolean r128 = false;
    L152:
        if (r128 == true) goto L154;
        r120.add("miniGame");
    L154:
        IBroadcastService r129 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r129 == null) goto L157;
        r129.broadcastFloatWindowManager();
    L157:
        Iterator r130 = r120.iterator();
    L159:
        if (r130.hasNext() == false) goto L167;
        String r131 = (String) r130.next();
        if (r111 == null) goto L159;
        List<String> r132 = r111.c();
        if (r132 == null) goto L159;
        if (r132.contains(r131) != true) goto L159;
        r110 = false;
        goto L159
    L167:
        return r110;
    L151:
        r128 = true;
        goto L152
    L146:
        r127 = false;
        goto L147
    L139:
        if (r121.intValue() != 2) goto L141;
    L140:
        r120.add("commerceGoodsPage");
        goto L141
    L135:
        if (r121.intValue() == 1) goto L140;
    L131:
        r123 = false;
    L126:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L128
    L169:
        if ((!r117.isEmpty()) != true) goto L124;
        if (r118 == null) goto L124;
        if ((!r118.isEmpty()) != true) goto L124;
        if ((this.f469578e instanceof Fragment) == false) goto L102;
        Iterator<T> r134 = r117.iterator();     // Catch: Throwable -> L126
    L80:
        if (r134.hasNext() == false) goto L102;
        String r135 = (String) r134.next();     // Catch: Throwable -> L126
        if (r105 != null) goto L84;
    L85:
        Fragment r136 = (Fragment) this.f469578e;     // Catch: Throwable -> L126
        if (r136 == null) goto L80;
        String r137 = r136.getTag();     // Catch: Throwable -> L126
        if (r137 == null) goto L80;
        if (StringsKt.contains$default(r137, r135, false, 2, null) != true) goto L80;
    L91:
        Bundle r138 = ((Fragment) this.f469578e).getArguments();     // Catch: Throwable -> L126
        if (r138 == null) goto L80;
        String r139 = r138.getString("url");     // Catch: Throwable -> L126
        if (r139 == null) goto L80;
        Iterator<T> r140 = r118.iterator();     // Catch: Throwable -> L126
    L97:
        if (r140.hasNext() == false) goto L80;
        if (StringsKt.contains$default(r139, (String) r140.next(), false, 2, null) != true) goto L97;
        r110 = false;
        goto L97
    L84:
        if (StringsKt.contains$default(r105, r135, false, 2, null) == true) goto L91;
    L102:
        if ((this.f469578e instanceof Activity) == false) goto L124;
        Iterator<T> r141 = r117.iterator();     // Catch: Throwable -> L126
    L105:
        if (r141.hasNext() == false) goto L124;
        String r142 = (String) r141.next();     // Catch: Throwable -> L126
        if (r105 == null) goto L105;
        if (StringsKt.contains$default(r105, r142, false, 2, null) != true) goto L105;
        Activity r143 = (Activity) this.f469578e;     // Catch: Throwable -> L126
        if (r143 == null) goto L105;
        Intent r144 = r143.getIntent();     // Catch: Throwable -> L126
        if (r144 == null) goto L105;
        Bundle r145 = r144.getExtras();     // Catch: Throwable -> L126
        if (r145 == null) goto L105;
        String r146 = r145.getString("url");     // Catch: Throwable -> L126
        if (r146 == null) goto L105;
        Iterator<T> r147 = r118.iterator();     // Catch: Throwable -> L126
    L120:
        if (r147.hasNext() == false) goto L105;
        if (StringsKt.contains$default(r146, (String) r147.next(), false, 2, null) != true) goto L120;
        r110 = false;
        goto L120
    L68:
        r118 = null;
        goto L69
    L65:
        r117 = null;
    L61:
        th = move-exception;
        Result.Companion r148 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L24
    L16:
        if ((r102 instanceof Fragment) == false) goto L21;
        if (r102 == null) goto L20;
        r103 = ((Fragment) r102).getClass().getName();     // Catch: Throwable -> L24
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");     // Catch: Throwable -> L24
    L21:
        r103 = null;
    L24:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        if ((this.f469578e instanceof Activity) == false) goto L7;
        r100 = r111.a();
        goto L168
    L7:
        r100 = r111.b();
        goto L168
    }
}
