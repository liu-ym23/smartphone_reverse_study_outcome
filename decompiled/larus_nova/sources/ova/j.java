package ova;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.lark.log.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements Comparable<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526972a;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f526972a});
    }

    public j(String r100) {
        if (r100 == null) goto L11;
        if (r100.matches("[0-9]+(\\.[0-9]+)*") == false) goto L9;
        this.f526972a = r100;
        return;
    L9:
        throw new IllegalArgumentException("Invalid version format");
    L11:
        throw new IllegalArgumentException("Version can not be null");
    }

    public final int a(j r100) {
        if (r100 != null) goto L5;
        return 1;
    L5:
        String[] r101 = this.f526972a.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r102 = r100.f526972a.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r103 = Math.max(r101.length, r102.length);
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L27;
    L18:
        e = move-exception;
        NumberFormatException e100 = e;
        int r105 = 0;
    L20:
        Log.e("Version", e100);
    L21:
        int r106 = 0;
    L22:
        if (r105 < r106) goto L23;
        if (r105 > r106) goto L25;
        r104 = r104 + 1;
        goto L6
    L25:
        Integer r107 = 1;
    L28:
        if (r107 != null) goto L30;
        return 0;
    L30:
        return r107.intValue();
    L23:
        r107 = -1;
        goto L28
    L8:
        if (r104 >= r101.length) goto L11;
        r105 = CastIntegerProtector.parseInt(r101[r104]);     // Catch: NumberFormatException -> L18
    L32:
    L16:
        e100 = e;
        goto L20
    L13:
        if (r104 >= r102.length) goto L21;
        r106 = CastIntegerProtector.parseInt(r102[r104]);     // Catch: NumberFormatException -> L16
        goto L22
    L11:
        r105 = 0;
        goto L32
    L27:
        r107 = null;
        goto L28
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(j r100) {
        return a(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (j.class == r100.getClass()) goto L12;
        return false;
    L12:
        if (a((j) r100) == 0) goto L16;
        return false;
    L16:
        return true;
    }
}
