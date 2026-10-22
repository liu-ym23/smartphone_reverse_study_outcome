package u18;

import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NotBlank f548320e;

    @Override // u18.a
    public final String b() {
        return this.f548313b.getName() + " is empty";
    }

    @Override // v18.a
    public final boolean check() {
        Object r100 = this.f548314c;
        if ((r100 instanceof String) == false) goto L9;
        ((w18.b) this.f548315d).getClass();
        if (((String) r100).isEmpty() == false) goto L14;
        c(this.f548320e.warning());
        return false;
    L14:
        return true;
    L9:
        if ((r100 instanceof List) == false) goto L16;
        ((w18.b) this.f548315d).getClass();
        if (((List) r100).isEmpty() == false) goto L17;
        c(this.f548320e.warning());
        return false;
    L17:
        return true;
    L16:
        return true;
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548320e.gray();
    }

    public d(Field r100, NotBlank r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548320e = r101;
    }
}
