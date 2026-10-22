package u18;

import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes24.dex */
public final class h extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LKRequiredParam f548324e;

    @Override // u18.a
    public final String b() {
        return this.f548313b.getName() + " is required ";
    }

    @Override // v18.a
    public final boolean check() {
        w18.a r100 = this.f548315d;
        Object r101 = this.f548314c;
        ((w18.b) r100).getClass();
        if (r101 != null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        c(this.f548324e.warning());
        return false;
    L9:
        return true;
    L5:
        r102 = false;
        goto L6
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548324e.gray();
    }

    public h(Field r100, LKRequiredParam r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548324e = r101;
    }
}
