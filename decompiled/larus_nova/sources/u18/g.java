package u18;

import com.larksuite.framework.apiplugin.validator.format.Prefix;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes24.dex */
public final class g extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Prefix f548323e;

    @Override // u18.a
    public final String b() {
        return this.f548313b.getName() + " is not startWith " + this.f548323e.value();
    }

    @Override // v18.a
    public final boolean check() {
        if ((this.f548314c instanceof String) == false) goto L8;
        w18.a r100 = this.f548315d;
        String r101 = this.f548323e.value();
        String r102 = (String) this.f548314c;
        ((w18.b) r100).getClass();
        if (r102.startsWith(r101) == true) goto L10;
        c(this.f548323e.warning());
        return false;
    L10:
        return true;
    L8:
        return true;
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548323e.gray();
    }

    public g(Field r100, Prefix r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548323e = r101;
    }
}
