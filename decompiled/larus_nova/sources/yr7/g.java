package yr7;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronFieldName f568921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FieldConstraints f568922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f568923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f568924d;

    public final String toString() {
        return "CronParserField{field=" + this.f568921a + '}';
    }

    public g(CronFieldName r100, FieldConstraints r101, boolean r102) {
        zr7.a.b(r100, "CronFieldName must not be null");
        this.f568921a = r100;
        zr7.a.b(r101, "FieldConstraints must not be null");
        this.f568922b = r101;
        this.f568923c = new h(r101);
        this.f568924d = r102;
    }
}
