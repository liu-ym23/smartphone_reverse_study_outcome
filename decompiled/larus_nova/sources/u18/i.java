package u18;

import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public final class i extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StringEnum f548325e;

    @Override // u18.a
    public final String b() {
        return this.f548313b.getName() + " is not in string enum";
    }

    @Override // v18.a
    public final boolean check() {
        Object r100 = this.f548314c;
        if ((r100 instanceof String) == false) goto L18;
        w18.a r101 = this.f548315d;
        String[] r102 = this.f548325e.values();
        String r103 = (String) this.f548314c;
        ((w18.b) r101).getClass();
        if (r102 == null) goto L13;
        int r104 = r102.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        if (r102[r105].equalsIgnoreCase(r103) == true) goto L13;
        r105 = r105 + 1;
        goto L7
    L12:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L51;
        c(this.f548325e.warning());
        return false;
    L51:
        return true;
    L13:
        r106 = true;
        goto L14
    L18:
        if ((r100 instanceof List) == false) goto L51;
        w18.a r107 = this.f548315d;
        String[] r108 = this.f548325e.values();
        List r109 = (List) this.f548314c;
        ((w18.b) r107).getClass();
        if (r109 == null) goto L47;
        if (r108 == null) goto L47;
        Iterator r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L33;
        Object r111 = r110.next();
        if ((r111 instanceof String) == true) goto L24;
        StringBuilder r112 = new StringBuilder("type of v is invalid:");
        if (r111 != null) goto L30;
        String r113 = null;
    L31:
        r112.append(r113);
        Log.i("InternalRuleProvider", r112.toString());
    L46:
        boolean r114 = false;
    L48:
        if (r114 == true) goto L51;
        c(this.f548325e.warning());
        return false;
    L30:
        r113 = r111.getClass().getName();
        goto L31
    L33:
        if (w18.b.a(r109) == true) goto L46;
        Iterator r115 = r109.iterator();
    L37:
        if (r115.hasNext() == false) goto L47;
        String r116 = (String) r115.next();
        int r117 = r108.length;
        int r118 = 0;
    L39:
        if (r118 >= r117) goto L44;
        if (r108[r118].equalsIgnoreCase(r116) == true) goto L42;
        r118 = r118 + 1;
        goto L39
    L42:
        boolean r119 = true;
    L45:
        if (r119 == true) goto L37;
    L44:
        r119 = false;
    L47:
        r114 = true;
        goto L48
    }

    @Override // v18.a
    public final boolean isGray() {
        return this.f548325e.gray();
    }

    public i(Field r100, StringEnum r101, Object r102, w18.a r103) {
        super(r100, r102, r103);
        this.f548325e = r101;
    }
}
