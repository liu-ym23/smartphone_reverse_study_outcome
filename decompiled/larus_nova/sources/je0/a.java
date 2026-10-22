package je0;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498785a;

    public a(int r100) {
        this.f498785a = r100;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        int r106 = this.f498785a;
        if (r103 == null) goto L5;
        int r107 = r103.length();
    L6:
        int r108 = (r106 - r107) + (r105 - r104);
        if (r108 <= 0) goto L18;
        CharSequence r109 = null;
        if (r108 < (r102 - r101)) goto L13;
        return null;
    L13:
        if (r100 == null) goto L16;
        r109 = r100.subSequence(r101, r108 + r101);
    L16:
        return String.valueOf(r109).concat("...");
    L18:
        return "...";
    L5:
        r107 = 0;
        goto L6
    }
}
