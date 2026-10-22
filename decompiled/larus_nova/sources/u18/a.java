package u18;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a implements v18.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f548313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f548314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w18.a f548315d;

    public abstract String b();

    @Override // v18.a
    public final String a() {
        return this.f548312a;
    }

    public final void c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f548312a = b();
    L5:
        Log.w("FieldChecker", this.f548312a);
    }

    public a(Field r100, Object r101, w18.a r102) {
        this.f548313b = r100;
        this.f548314c = r101;
        this.f548315d = r102;
    }
}
