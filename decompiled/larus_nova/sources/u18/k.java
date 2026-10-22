package u18;

import com.larksuite.framework.apiplugin.validator.format.Valid;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes24.dex */
public final class k extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Valid f548327e;

    @Override // u18.a
    public final String b() {
        return this.f548327e.warning();
    }

    @Override // v18.a
    public final boolean check() {
        return this.f548327e.value();
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548327e.gray();
    }

    public k(Field r100, Valid r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548327e = r101;
    }
}
