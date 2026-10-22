package wo7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f560525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f560526b;

    public final void b() {
        int[] r100 = this.f560525a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length == 0) goto L29;
        ArrayList r101 = new ArrayList();
        int[] r102 = this.f560525a;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L16;
        int r106 = r102[r105];
        if (r106 <= 0) goto L14;
        if (r106 >= 12) goto L14;
        r101.add(Integer.valueOf(r106));
    L14:
        r105 = r105 + 1;
        goto L8
    L16:
        if (r101.size() != 0) goto L18;
        this.f560525a = null;
        return;
    L18:
        this.f560525a = new int[r101.size()];
    L20:
        if (r104 >= r101.size()) goto L30;
        this.f560525a[r104] = ((Integer) ListProtector.get(r101, r104)).intValue();
        r104 = r104 + 1;
        goto L20
    L30:
        return;
    }

    public a() {
        this.f560525a = new int[0];
        this.f560526b = true;
    }

    public static int[] a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L17:
        return null;
    L5:
        if (TextUtils.isEmpty(",") == true) goto L17;
        String[] r101 = r100.split(",");
        if (r101.length != 0) goto L10;
        return null;
    L10:
        int[] r102 = new int[r101.length];
        int r103 = 0;
    L12:
        if (r103 >= r101.length) goto L16;
        r102[r103] = CastIntegerProtector.parseInt(r101[r103]);     // Catch: Throwable -> L15
        r103 = r103 + 1;
    L15:
        return null;
    L16:
        return r102;
    }
}
