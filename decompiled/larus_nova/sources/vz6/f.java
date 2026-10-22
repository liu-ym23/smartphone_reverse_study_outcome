package vz6;

import android.util.JsonReader;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements s<qz6.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f557724a = null;

    public f() {
    }

    static {
        f557724a = new f();
    }

    @Override // vz6.s
    public final qz6.b a(JsonReader r210, float r211) throws IOException {
        r210.beginObject();
        String r100 = null;
        String r101 = null;
        double r102 = 0.0d;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r112 = 0.0d;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
        boolean r212 = true;
    L4:
        if (r210.hasNext() == false) goto L65;
        String r103 = r210.nextName();
        r103.getClass();
        byte r104 = -1;
        switch(r103.hashCode()) {
            case 102: goto L49;
            case 106: goto L45;
            case 115: goto L41;
            case 116: goto L37;
            case 3261: goto L33;
            case 3452: goto L29;
            case 3463: goto L25;
            case 3543: goto L21;
            case 3664: goto L17;
            case 3684: goto L13;
            case 3710: goto L9;
            default: goto L52;
        };
    L52:
        switch(r104) {
            case 0: goto L64;
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            default: goto L53;
        };
    L54:
        r114 = r210.nextInt();
        goto L4
    L55:
        r112 = r210.nextDouble();
        goto L4
    L56:
        r116 = j.a(r210);
        goto L4
    L57:
        r212 = r210.nextBoolean();
        goto L4
    L58:
        r111 = r210.nextDouble();
        goto L4
    L59:
        r110 = r210.nextDouble();
        goto L4
    L60:
        r115 = j.a(r210);
        goto L4
    L61:
        r100 = r210.nextString();
        goto L4
    L62:
        r102 = r210.nextDouble();
        goto L4
    L63:
        r113 = r210.nextInt();
        goto L4
    L64:
        r101 = r210.nextString();
        goto L4
    L53:
        r210.skipValue();
        goto L4
    L9:
        if (r103.equals("tr") == false) goto L52;
        r104 = 10;
        goto L52
    L13:
        if (r103.equals("sw") == false) goto L52;
        r104 = 9;
        goto L52
    L17:
        if (r103.equals(SRStrategy.KEY_SR_STRATEGY_CONFIG) == false) goto L52;
        r104 = 8;
        goto L52
    L21:
        if (r103.equals(MapBundleKey.MapObjKey.OBJ_OFFSET) == false) goto L52;
        r104 = 7;
        goto L52
    L25:
        if (r103.equals("ls") == false) goto L52;
        r104 = 6;
        goto L52
    L29:
        if (r103.equals("lh") == false) goto L52;
        r104 = 5;
        goto L52
    L33:
        if (r103.equals("fc") == false) goto L52;
        r104 = 4;
        goto L52
    L37:
        if (r103.equals("t") == false) goto L52;
        r104 = 3;
        goto L52
    L41:
        if (r103.equals("s") == false) goto L52;
        r104 = 2;
        goto L52
    L45:
        if (r103.equals(ce.f26395j) == false) goto L52;
        r104 = 1;
        goto L52
    L49:
        if (r103.equals("f") == false) goto L52;
        r104 = 0;
        goto L52
    L65:
        r210.endObject();
        return new qz6.b(r100, r101, r102, r113, r114, r110, r111, r115, r116, r112, r212);
    }
}
