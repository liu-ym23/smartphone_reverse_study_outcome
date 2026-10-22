package gk;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.popup.f;
import com.bytedance.android.ec.hybrid.popup.g;
import com.bytedance.android.ec.hybrid.popup.h;
import com.bytedance.android.ec.hybrid.popup.j;
import com.bytedance.android.ec.hybrid.popup.k;
import com.bytedance.android.ec.hybrid.popup.o;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public class b implements j, k, f, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f481518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f481519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f481520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f481521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ck.b f481522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f481523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f481524g;

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final boolean a() {
        return this.f481524g.a();
    }

    public int c() {
        return this.f481523f.c();
    }

    public boolean d() {
        return this.f481523f.d();
    }

    public boolean e() {
        return this.f481523f.e();
    }

    public int f() {
        return this.f481523f.f();
    }

    public boolean g() {
        return this.f481523f.g();
    }

    public JSONObject getBcm() {
        return this.f481523f.getBcm();
    }

    public String getBtm() {
        return this.f481523f.getBtm();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final h getGroup() {
        return this.f481524g.getGroup();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final int getPriority() {
        return this.f481524g.getPriority();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.j, com.bytedance.android.ec.hybrid.popup.f
    public int getType() {
        return this.f481523f.getType();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.k
    public final int getZIndex() {
        return this.f481524g.getZIndex();
    }

    public int h() {
        return this.f481523f.h();
    }

    public boolean i() {
        return this.f481523f.i();
    }

    public boolean j() {
        return this.f481523f.j();
    }

    public boolean k() {
        return this.f481523f.k();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.j
    public boolean start() {
        Lazy r100 = ECMallLogUtil.f47441a;
        com.bytedance.android.ec.hybrid.log.mall.k.e r101 = com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b;
        ECMallLogUtil.c(r101, this + " start invoked");
        g r102 = this.f481520c;
        if (r102 != null) goto L6;
        ECMallLogUtil.c(r101, this + " have not been attached to task-group");
        return false;
    L6:
        this.f481519b = true;
        View r103 = new View(r102.c().getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.setBackgroundColor(c());
        if (k() == false) goto L9;
    L10:
        r103.setOnClickListener(this);
    L11:
        r103.addOnAttachStateChangeListener(this.f481518a);
        r102.c().addView(r103);
        return true;
    L9:
        if (e() == false) goto L11;
        goto L10
    }

    @Override // com.bytedance.android.ec.hybrid.popup.j
    public long stop() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.f47505b, this + " stop invoked");
        this.f481519b = false;
        if (d() == false) goto L5;
        return 300;
    L5:
        return 0;
    }

    public final String toString() {
        return "Task[ID:" + this.f481521d + " priority:" + getPriority() + " zIndex:" + getZIndex() + " isGlobal:" + a() + ']';
    }

    @Override // com.bytedance.android.ec.hybrid.popup.j
    public final String getId() {
        return this.f481521d;
    }

    @Override // com.bytedance.android.ec.hybrid.popup.j
    public final boolean isActive() {
        return this.f481519b;
    }

    @Override // com.bytedance.android.ec.hybrid.popup.j
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "group");
        this.f481520c = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (e() == false) goto L6;
        this.f481522e.f(this);
        return;
    }

    public b(ck.b r100, o r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "taskConfig");
        Intrinsics.checkNotNullParameter(r102, "popupConfig");
        this.f481524g = r101;
        this.f481522e = r100;
        this.f481523f = r102;
        this.f481518a = new a(this);
        this.f481521d = UUID.randomUUID().toString();
    }
}
