package s0;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static n0.l a(JsonReader r210, LottieComposition r211) throws IOException {
        boolean r110 = false;
        if (r210.peek() != JsonToken.BEGIN_OBJECT) goto L5;
        boolean r111 = true;
    L6:
        if (r111 == false) goto L8;
        r210.beginObject();
    L8:
        n0.b r100 = null;
        n0.e r112 = null;
        n0.g r113 = null;
        n0.d r114 = null;
        n0.b r115 = null;
        n0.m<PointF, PointF> r116 = null;
        n0.b r117 = null;
    L10:
        if (r210.hasNext() == false) goto L72;
        String r101 = r210.nextName();
        r101.getClass();
        byte r102 = -1;
        switch(r101.hashCode()) {
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
        switch(r102) {
            case 0: goto L63;
            case 1: goto L62;
            case 2: goto L61;
            case 3: goto L53;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L48;
            default: goto L47;
        };
    L47:
        r210.skipValue();
    L71:
        r110 = false;
        goto L10
    L48:
        r115 = c.a(r210, r211, r110);
        goto L71
    L49:
        r211.addWarning("Lottie doesn't support 3D layers.");
        goto L53
    L50:
        r117 = c.a(r210, r211, r110);
        goto L71
    L51:
        r113 = new n0.g(l.a(r210, r211, 1.0f, q.f540003a));
    L53:
        n0.b r103 = c.a(r210, r211, r110);
        if (r103.f516565a.isEmpty() == false) goto L56;
        n0.b r104 = r103;
        r103.f516565a.add((v0.a<V>) new v0.a(r211, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(r211.getEndFrame())));
    L60:
        r100 = r104;
        goto L71
    L56:
        r104 = r103;
        if (((v0.a) ListProtector.get(r104.f516565a, 0)).f552275b != 0) goto L60;
        ListProtector.set(r104.f516565a, 0, new v0.a(r211, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(r211.getEndFrame())));
        goto L60
    L61:
        r116 = a.b(r210, r211);
        goto L71
    L62:
        r114 = c.b(r210, r211);
        goto L71
    L63:
        r210.beginObject();
    L65:
        if (r210.hasNext() == false) goto L70;
        if (r210.nextName().equals(ce.f26396k) == true) goto L68;
        r210.skipValue();
        goto L65
    L68:
        r112 = a.a(r210, r211);
        goto L65
    L70:
        r210.endObject();
        goto L71
    L15:
        if (r101.equals(SRStrategy.KEY_SR_OPEN) == false) goto L46;
        r102 = 7;
        goto L46
    L19:
        if (r101.equals("rz") == false) goto L46;
        r102 = 6;
        goto L46
    L23:
        if (r101.equals("eo") == false) goto L46;
        r102 = 5;
        goto L46
    L27:
        if (r101.equals("s") == false) goto L46;
        r102 = 4;
        goto L46
    L31:
        if (r101.equals("r") == false) goto L46;
        r102 = 3;
        goto L46
    L35:
        if (r101.equals("p") == false) goto L46;
        r102 = 2;
        goto L46
    L39:
        if (r101.equals("o") == false) goto L46;
        r102 = 1;
        goto L46
    L43:
        if (r101.equals(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY) == false) goto L46;
        r102 = 0;
        goto L46
    L72:
        if (r111 == false) goto L74;
        r210.endObject();
    L74:
        if (r112 != null) goto L76;
        r112 = new n0.e();
    L76:
        n0.e r105 = r112;
        if (r113 != null) goto L79;
        r113 = new n0.g(new v0.d(1.0f, 1.0f));
    L79:
        n0.g r106 = r113;
        if (r114 != null) goto L83;
        r114 = new n0.d();
    L83:
        return new n0.l(r105, r116, r106, r100, r114, r115, r117);
    L5:
        r111 = false;
        goto L6
    }
}
