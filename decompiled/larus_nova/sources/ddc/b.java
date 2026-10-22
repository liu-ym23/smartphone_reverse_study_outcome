package ddc;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.DocImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;
import ova.d;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f468039a = 0;

    public static final class a {
        public a() {
        }

        public static final PhotoItem a(JSONObject r110) {
            int r100 = b.f468039a;
            String r101 = JSONObjectProtectorUtils.getString(r110, "type");
            if (r101 == null) goto L23;
            int r102 = r101.hashCode();
            if (r102 == (-1134673157)) goto L20;
            if (r102 == 116079) goto L16;
            if (r102 != 110541305) goto L23;
            if (r101.equals("token") == false) goto L23;
            PhotoItem r103 = new PhotoItem();
            r103.setType(7);
            r103.setImageKey(JSONObjectProtectorUtils.getString(r110, "value"));
            r103.setLoadModel(new DocImage(r103.getImageKey()));
            return r103;
        L16:
            if (r101.equals("url") == false) goto L23;
            PhotoItem r104 = new PhotoItem();
            r104.setType(2);
            r104.setImageKey(JSONObjectProtectorUtils.getString(r110, "value"));
            r104.setLoadModel(r104.getImageKey());
            return r104;
        L20:
            if (r101.equals(com.bytedance.android.ec.core.event.a.KEY_KEY_ID) == false) goto L23;
            PhotoItem r105 = new PhotoItem();
            r105.setType(4);
            List r106 = StringsKt.split$default(JSONObjectProtectorUtils.getString(r110, "value"), new char[]{Typography.amp}, false, 0, 6, null);
            String r107 = (String) ListProtector.get(r106, 0);
            String r111 = (String) ListProtector.get(r106, 1);
            r105.setImageKey(StringsKt.removePrefix(r107, "key="));
            r105.setEntityId(StringsKt.removePrefix(r111, "id="));
            r105.setLoadModel(AvatarImage.Builder.obtain(r105.getImageKey(), r105.getEntityId(), 640, 640).build());
            return r105;
        L23:
            return null;
        }
    }

    static {
        new a();
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Intrinsics.checkNotNullParameter(r101, "appLink");
        return true;
    }

    public b() {
    }

    @Override // ova.p
    public final boolean a(Context r110, AppLink r111) {
        Intrinsics.checkNotNullParameter(r111, "appLink");
        boolean r100 = false;
        if (r110 != null) goto L6;
        return false;
    L6:
        if ((r110 instanceof Activity) == true) goto L8;
        return false;
    L8:
        String r101 = r111.f408912a;
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return false;
    L17:
        String r103 = r111.f408912a;
        Uri r104 = UriProtector.parse(r103);
        String r105 = UriProtector.getQueryParameter(r104, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        if (r105 != null) goto L20;
        return false;
    L20:
        String r106 = UriProtector.getQueryParameter(r104, "position");
        if (r106 == null) goto L25;
        Integer r107 = StringsKt.toIntOrNull(r106);
        if (r107 == null) goto L25;
        int r108 = r107.intValue();
    L26:
        boolean r109 = r104.getBooleanQueryParameter("ocr", false);
        boolean r112 = r104.getBooleanQueryParameter(SVGRenderEngine.SAVE, false);
        boolean r113 = r104.getBooleanQueryParameter("qrcode", false);
        boolean r114 = r104.getBooleanQueryParameter("edit", false);
        boolean r115 = r104.getBooleanQueryParameter("translate", false);
        Log.i("PhotoPickerAppLinkHandler", "handle url " + r103 + ", files = " + r105 + ", position = " + r108);
        ArrayList r116 = new ArrayList();
        JSONArray r117 = new JSONArray(r105);     // Catch: Exception -> L33
        int r118 = r117.length();     // Catch: Exception -> L33
        int r119 = 0;
    L28:
        if (r119 >= r118) goto L35;
        PhotoItem r120 = a.a(JSONArrayProtectorUtils.getJSONObject(r117, r119));     // Catch: Exception -> L33
        if (r120 == null) goto L32;
        r116.add(r120);     // Catch: Exception -> L33
    L32:
        r119 = r119 + 1;
    L35:
        if ((!r116.isEmpty()) == false) goto L41;
        int r121 = k.f446736a;
        k.c r122 = k.a.a(new ArrayList(CollectionsKt.take(r116, 20)), r108, null);
        r122.i(r109);
        r122.l(r112);
        r122.f446737a.putBoolean("show_qr_code", r113);
        if (r112 == false) goto L40;
        if (r114 == false) goto L40;
        r100 = true;
    L40:
        r122.f446737a.putBoolean("show_edit", r100);
        r122.o(r115);
        r122.r((Activity) r110);
    L41:
        return true;
    L33:
        Log.e("PhotoPickerAppLinkHandler", "Parse JSON failed for ".concat(r105));
    L25:
        r108 = 0;
        goto L26
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    }
}
