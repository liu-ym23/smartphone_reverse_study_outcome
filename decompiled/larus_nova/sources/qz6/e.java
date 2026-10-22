package qz6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f535375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f535376b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("KeyPath{keys=");
        r100.append(this.f535375a);
        r100.append(",resolved=");
        if (this.f535376b == null) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append('}');
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    public e(e r100) {
        this.f535375a = new ArrayList(r100.f535375a);
        this.f535376b = r100.f535376b;
    }

    public e(String... r100) {
        this.f535375a = Arrays.asList(r100);
    }

    public final boolean a(String r100, int r101) {
        if (r101 < this.f535375a.size()) goto L6;
        return false;
    L6:
        if (r101 != (this.f535375a.size() - 1)) goto L8;
        boolean r102 = true;
    L9:
        String r103 = (String) ListProtector.get(this.f535375a, r101);
        if (r103.equals("**") == false) goto L12;
        if (r102 == false) goto L28;
    L30:
        boolean r104 = false;
    L31:
        if (r104 == true) goto L33;
        if (r102 == false) goto L42;
        return true;
    L42:
        int r105 = r101 + 1;
        if (r105 >= (this.f535375a.size() - 1)) goto L46;
        return false;
    L46:
        return ((String) ListProtector.get(this.f535375a, r105)).equals(r100);
    L33:
        if (r101 != (this.f535375a.size() - 2)) goto L35;
    L38:
        return true;
    L35:
        if (r101 != (this.f535375a.size() - 3)) goto L50;
        List<String> r106 = this.f535375a;
        if (((String) ListProtector.get(r106, r106.size() - 1)).equals("**") == true) goto L38;
        return false;
    L50:
        return false;
    L28:
        if (((String) ListProtector.get(this.f535375a, r101 + 1)).equals(r100) == false) goto L30;
        r104 = true;
        goto L31
    L12:
        if (r103.equals(r100) == false) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r102 == false) goto L20;
    L23:
        if (r107 == false) goto L49;
        return true;
    L49:
        return false;
    L20:
        if (r101 != (this.f535375a.size() - 2)) goto L47;
        List<String> r108 = this.f535375a;
        if (((String) ListProtector.get(r108, r108.size() - 1)).equals("**") == true) goto L23;
        return false;
    L47:
        return false;
    L14:
        if (r103.equals("*") == true) goto L17;
        r107 = false;
        goto L18
    L8:
        r102 = false;
        goto L9
    }

    public final int b(String r100, int r101) {
        if (r100.equals("__container") == false) goto L6;
        return 0;
    L6:
        if (((String) ListProtector.get(this.f535375a, r101)).equals("**") == true) goto L9;
        return 1;
    L9:
        if (r101 != (this.f535375a.size() - 1)) goto L12;
        return 0;
    L12:
        if (((String) ListProtector.get(this.f535375a, r101 + 1)).equals(r100) == false) goto L15;
        return 2;
    L15:
        return 0;
    }

    public final boolean c(String r100, int r101) {
        if (r100.equals("__container") == false) goto L6;
        return true;
    L6:
        if (r101 < this.f535375a.size()) goto L9;
        return false;
    L9:
        if (((String) ListProtector.get(this.f535375a, r101)).equals(r100) == false) goto L11;
    L16:
        return true;
    L11:
        if (((String) ListProtector.get(this.f535375a, r101)).equals("**") == true) goto L16;
        if (((String) ListProtector.get(this.f535375a, r101)).equals("*") == true) goto L16;
        return false;
    }

    public final boolean d(String r100, int r101) {
        if (r100.equals("__container") == false) goto L6;
        return true;
    L6:
        if (r101 >= (this.f535375a.size() - 1)) goto L8;
        return true;
    L8:
        if (((String) ListProtector.get(this.f535375a, r101)).equals("**") == true) goto L13;
        return false;
    L13:
        return true;
    }
}
