package s73;

import android.util.Pair;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<String, Boolean> f540923a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static /* synthetic */ WireFrameSchemaInfo b(c r110, String r111, WireFrameSchemaInfo r112, Integer r113, String r114, boolean r115, float r116, int r117, boolean r118) {
        return r110.a(r111, r112, r113, r114, r115, r116, r117, null, r118);
    }

    public final WireFrameSchemaInfo a(String r210, WireFrameSchemaInfo r211, Integer r212, String r213, boolean r214, float r215, int r216, String r217, boolean r218) {
        boolean r100 = false;
        b.f540922a = false;
        if (r211 == null) goto L5;
        String r101 = r211.getPreferMainPicUrl();
    L6:
        if (r101 == null) goto L8;
        String r102 = r211.getPreferMainPicUrl();
    L9:
        this.f540923a = new Pair(r102, Boolean.FALSE);
        if (r211 == null) goto L23;
        String r103 = r211.getInsertPicUrl();
        if (r103 == null) goto L23;
        String r104 = a2.d(r103);
        if (r104 == null) goto L23;
        Float r105 = r211.getInsertPicScale();
        if (r105 == null) goto L18;
        float r106 = r105.floatValue();
    L20:
        if (r106 <= 1.0f) goto L22;
        r100 = true;
    L22:
        this.f540923a = new Pair(r104, Boolean.valueOf(r100));
        goto L23
    L18:
        r106 = 1.0f;
    L23:
        if (r212 == null) goto L40;
        if (r214 == true) goto L40;
        if (b.a(new s73.a(String.valueOf(r212.intValue()), r213, Float.valueOf(r215), r217, r218)) == false) goto L40;
        if (r211 != null) goto L29;
        WireFrameSchemaInfo r107 = new WireFrameSchemaInfo(null, null, null, null, null, null, 0, 0, 0, null, null, null, 0.0f, 0, 16383, null);
    L30:
        r107.setHalPdpOptimizeStyle(1);
        float r108 = ECSettingKeys.A0().c();
        if (r108 > 0.0f) goto L34;
        r108 = r215;
    L34:
        r107.setHalfPdpHeadScaleParam(r108);
        if (r216 <= 0) goto L37;
        int r109 = r216;
    L38:
        r107.setHalPdpHeadSpace(r109);
        return r107;
    L37:
        int r110 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r109 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(ECSettingKeys.A0().f()));
        goto L38
    L29:
        r107 = r211;
    L40:
        return r211;
    L8:
        r102 = r210;
        goto L9
    L5:
        r101 = null;
        goto L6
    }
}
