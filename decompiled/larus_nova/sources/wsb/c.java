package wsb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static final String a(Locale r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getLanguage() + '_' + r100.getCountry();
    }

    public static final ErrorResult b(Throwable r100) {
        if ((r100 instanceof ErrorResult) == false) goto L6;
        return (ErrorResult) r100;
    L6:
        if ((r100 instanceof Exception) == false) goto L8;
        Exception r101 = (Exception) r100;
    L12:
        if (r100 == null) goto L15;
        String r102 = r100.getMessage();
        if (r102 == null) goto L15;
    L17:
        return new ErrorResult(r102, r101);
    L15:
        r102 = "";
        goto L17
    L8:
        if (r100 == null) goto L10;
        r101 = new Exception(r100);
        goto L12
    L10:
        r101 = null;
        goto L12
    }
}
