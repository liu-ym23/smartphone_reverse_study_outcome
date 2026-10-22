package u18;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larksuite.framework.apiplugin.validator.format.Pattern;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pattern f548322e;

    @Override // u18.a
    public final String b() {
        return this.f548313b.getName() + " is not matched regex: " + this.f548322e.value();
    }

    @Override // v18.a
    public final boolean check() {
        if ((this.f548314c instanceof String) == false) goto L15;
        w18.a r100 = this.f548315d;
        String r101 = this.f548322e.value();
        String r102 = (String) this.f548314c;
        ((w18.b) r100).getClass();
        if (r102 == null) goto L11;
        if (r101 == null) goto L11;
        boolean r103 = PatternProtector.compile(r101).matcher(r102).matches();     // Catch: Exception -> L9
    L12:
        if (r103 == true) goto L15;
        c(this.f548322e.warning());
        return false;
    L9:
        e = move-exception;
        Log.e("InternalRuleProvider", "isPattern exception :" + e);
    L11:
        r103 = true;
    L15:
        return true;
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548322e.gray();
    }

    public f(Field r100, Pattern r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548322e = r101;
    }
}
