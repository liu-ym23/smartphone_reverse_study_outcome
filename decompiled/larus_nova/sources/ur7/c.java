package ur7;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.FieldDefinition;

/* JADX INFO: loaded from: classes22.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.cronutils.model.definition.a f551383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CronFieldName f551384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tr7.a f551385c;

    public com.cronutils.model.definition.a a() {
        this.f551383a.c(new FieldDefinition(this.f551384b, this.f551385c.a(), false));
        return this.f551383a;
    }

    public c(com.cronutils.model.definition.a r100, CronFieldName r101) {
        zr7.a.b(r100, "ParserBuilder must not be null");
        this.f551383a = r100;
        zr7.a.b(r101, "CronFieldName must not be null");
        this.f551384b = r101;
        tr7.a r102 = new tr7.a();
        r102.b(r101);
        this.f551385c = r102;
    }

    public c b(int r100, int r101) {
        tr7.a r102 = this.f551385c;
        r102.f547312c = r100;
        r102.f547313d = r101;
        return this;
    }
}
