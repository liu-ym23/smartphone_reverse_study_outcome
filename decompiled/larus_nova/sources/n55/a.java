package n55;

import android.text.TextUtils;
import com.larus.nova.R;
import i55.f;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static boolean a(f85.a r100) {
        if (r100 == null) goto L6;
        String r101 = ((f85.a.C5868a) r100.f558532a).f558558b;
        tt5.a.h("ImportTypeUtil", "canImport starting...");
        if (f.a(r101) < 101) goto L6;
        return true;
    L6:
        return false;
    }

    public static int b(f85.a r100) {
        if (r100 != null) goto L5;
        return R.string.Doc_Facade_ImportAsDoc;
    L5:
        if (TextUtils.isEmpty(((f85.a.C5868a) r100.f558532a).f558558b) == true) goto L17;
        String r101 = ((f85.a.C5868a) r100.f558532a).f558558b;
        tt5.a.h("ImportTypeUtil", "canImport starting...");
        int r102 = f.a(r101);
        if (r102 != 102) goto L10;
        return R.string.Doc_Facade_ImportAsSheet;
    L10:
        if (r102 != 103) goto L18;
        return R.string.Doc_Facade_ImportAsMindnote;
    L18:
        return R.string.Doc_Facade_ImportAsDoc;
    L17:
        return R.string.Doc_Facade_ImportAsDoc;
    }
}
