package vz6;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static rz6.l a(JsonReader r110, com.bytedance.lottie.d r111) throws IOException {
        if (r110.peek() != JsonToken.BEGIN_OBJECT) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        r110.beginObject();
    L8:
        rz6.e r101 = null;
        rz6.g r102 = null;
        rz6.d r103 = null;
        rz6.m<PointF, PointF> r104 = null;
        rz6.b r112 = null;
        rz6.b r113 = null;
        rz6.b r114 = null;
    L10:
        if (r110.hasNext() == false) goto L63;
        String r105 = r110.nextName();
        r105.getClass();
        byte r115 = -1;
        switch(r105.hashCode()) {
            case 97: goto L43;
            case 111: goto L39;
            case 112: goto L35;
            case 114: goto L31;
            case 115: goto L27;
            case 3242: goto L23;
            case 3656: goto L19;
            case 3676: goto L15;
            default: goto L46;
        };
    L46:
        switch(r115) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L53;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L48;
            default: goto L47;
        };
    L48:
        r113 = c.a(r110, r111, false);
        goto L10
    L49:
        r111.a("Lottie doesn't support 3D layers.");
        goto L52
    L50:
        r114 = c.a(r110, r111, false);
        goto L10
    L51:
        r102 = new rz6.g(l.a(r110, r111, 1.0f, q.f557733a));
    L52:
        r112 = c.a(r110, r111, false);
        goto L10
    L53:
        r104 = a.b(r110, r111);
        goto L10
    L54:
        r103 = c.b(r110, r111);
        goto L10
    L55:
        r110.beginObject();
    L57:
        if (r110.hasNext() == false) goto L62;
        if (r110.nextName().equals(ce.f26396k) == true) goto L60;
        r110.skipValue();
        goto L57
    L60:
        r101 = a.a(r110, r111);
        goto L57
    L62:
        r110.endObject();
        goto L10
    L47:
        r110.skipValue();
        goto L10
    L15:
        if (r105.equals(SRStrategy.KEY_SR_OPEN) == false) goto L46;
        r115 = 7;
        goto L46
    L19:
        if (r105.equals("rz") == false) goto L46;
        r115 = 6;
        goto L46
    L23:
        if (r105.equals("eo") == false) goto L46;
        r115 = 5;
        goto L46
    L27:
        if (r105.equals("s") == false) goto L46;
        r115 = 4;
        goto L46
    L31:
        if (r105.equals("r") == false) goto L46;
        r115 = 3;
        goto L46
    L35:
        if (r105.equals("p") == false) goto L46;
        r115 = 2;
        goto L46
    L39:
        if (r105.equals("o") == false) goto L46;
        r115 = 1;
        goto L46
    L43:
        if (r105.equals(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY) == false) goto L46;
        r115 = 0;
        goto L46
    L63:
        if (r100 == false) goto L65;
        r110.endObject();
    L65:
        if (r101 != null) goto L67;
        r101 = new rz6.e();
    L67:
        if (r102 != null) goto L69;
        r102 = new rz6.g(new xz6.d(1.0f, 1.0f));
    L69:
        rz6.g r106 = r102;
        if (r103 != null) goto L73;
        r103 = new rz6.d();
    L73:
        return new rz6.l(r101, r104, r106, r112, r103, r113, r114);
    L5:
        r100 = false;
        goto L6
    }
}
