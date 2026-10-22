package w7a;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.utils.m;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f558593a;

    /* JADX INFO: renamed from: w7a.a$a, reason: collision with other inner class name */
    public static class C8078a extends b {
        public C8078a() {
        }
    }

    public static abstract class b {
        public b() {
        }

        public Typeface a(LynxContext r100, FontFace.TYPE r101, String r102) {
            if (TextUtils.isEmpty(r102) == false) goto L5;
        L17:
            return null;
        L5:
            if (r101 == FontFace.TYPE.LOCAL) goto L17;
            int r103 = r102.indexOf("base64,");
            if (r102.startsWith(fyb.a.KEY_DATA) == false) goto L17;
            if (r103 == (-1)) goto L17;
            return m.c(r100, Base64.decode(r102.substring(r103 + 7), 0));
        L15:
            e = move-exception;
            r100.reportResourceError(30203, r102, LynxResourceModule.FONT_TYPE, e.getMessage());
            goto L17
        }
    }

    public a() {
    }

    static {
        f558593a = new C8078a();
    }

    public static b a(LynxContext r100) {
        if (r100.getFontLoader() == null) goto L7;
        return r100.getFontLoader();
    L7:
        return f558593a;
    }
}
