package u85;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.DriveRouteBean;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.ee.bear.i;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.d;
import com.bytedance.ee.bear.route.h;
import g85.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.MutableTriple;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.route.b {
    public final String e(BearUrl r1, RouteBean r2) {
        return null;
    }

    public b(d... r1) {
        super(r1);
    }

    public final boolean b(Context r24, BearUrl r26, RouteBean r27) {
        if (TextUtils.equals(r26.a, e.l.getType()) == false) goto L93;
        tt5.a.h("FileleInterceptor", "dispatchUrl()..." + r26.a);
        if (g(r24, r26, r27) == false) goto L7;
        return true;
    L7:
        if (r27 == null) goto L13;
        String r7 = r27.l;
        String r8 = r27.f;
        String r9 = r27.i;
        Map<String, String> r10 = r27.k;
        if ((r27 instanceof DriveRouteBean) == false) goto L11;
        List<Document> r11 = ((DriveRouteBean) r27).v;
    L12:
        Bundle r12 = r27.e;
    L15:
        if (TextUtils.isEmpty(r9) == false) goto L17;
        r9 = r26.h;
    L17:
        Map<String, String> r13 = r26.d;
        if (r13 == null) goto L20;
        String r14 = r13.get("docId");
    L21:
        if (r27 == null) goto L25;
        Bundle r16 = r27.n;
        if (r16 == null) goto L25;
        boolean r17 = r16.getBoolean("force_single_top", false);
    L26:
        Context r18 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        if (r24 == null) goto L29;
        Context r19 = r24;
    L33:
        String r110 = r26.b;
        ArrayMap<MimeTypeCategory, Boolean> r111 = c.a;
        tt5.a.h("DriveComponent", "generateDriveFileItemEntity() routeIndexObjToken=" + du5.b.i(r110));
        ArrayList r3 = new ArrayList();
        if (r11 != null) goto L36;
        r11 = new ArrayList();
    L36:
        f r112 = o75.b.a().getMimeTypeManager();
        Iterator<Document> r113 = r11.iterator();
        SpaceFileOpenEntity r2 = null;
    L38:
        if (r113.hasNext() == false) goto L43;
        boolean r22 = r17;
        Document r114 = r113.next();
        if (TextUtils.equals(r110, r114.d) == false) goto L42;
        r2 = c.a(r114);
    L42:
        r17 = r22;
        goto L38
    L43:
        boolean r23 = r17;
        if (r2 != null) goto L46;
        tt5.a.k("DriveComponent", "generateDriveFileItemEntity() can't find fileList item from route token， just add token to open");
        SpaceFileOpenEntity r4 = new SpaceFileOpenEntity(r110, "");
        r3.add(r4);
        MutableTriple r5 = new MutableTriple(r3, r4, 0);
    L67:
        ArrayList r1 = (ArrayList) r5.getLeft();
        if (hu5.a.d(r1) == true) goto L73;
        Iterator r6 = r1.iterator();
    L71:
        if (r6.hasNext() == false) goto L73;
        ((BaseOpenEntity) r6.next()).setPreviewFrom(r9);
    L73:
        SpaceFileOpenEntity r20 = (SpaceFileOpenEntity) r5.getMiddle();
        if (r20 == null) goto L80;
        r20.setFileName(r8);
        r20.setUrl(r26.e);
        r20.setOriginUrl(r7);
        r20.setExtra(r10);
        r20.setFeedId(r14);
        r20.setReminderBinder(r12);
        RouteBean r0 = r27;
        if (r0 == null) goto L78;
        Bundle r21 = r0.n;
    L79:
        r20.setExtras(r21);
        r20.setPreviewFrom(r9);
    L81:
        ma5.a r28 = new ma5.a();
        r28.c = r23;
        if (r0 == null) goto L85;
        r28.d = r0.o;
    L85:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.enable.redirect.from.browser.optimization", false) == false) goto L90;
        if (r0 == null) goto L90;
        int r29 = r0.a;
        if (r29 == (-1)) goto L90;
        r28.a = r29;
        r28.b = 0;
    L90:
        ((i) org.koin.java.a.a(i.class)).f(r19, (ArrayList) r5.getLeft(), ((Integer) r5.getRight()).intValue(), r28, null);
        return true;
    L78:
        r21 = null;
        goto L79
    L80:
        r0 = r27;
        goto L81
    L46:
        g85.b r115 = (g85.b) r112;
        Boolean r30 = (Boolean) c.a.get(r115.b(r2.getFileExt(), null).a);
        if (r30 != null) goto L49;
    L66:
        tt5.a.h("DriveComponent", "generateDriveFileItemEntity() isMultiFile is false, ext=" + r2.getFileExt());
        r3.add(r2);
        r5 = new MutableTriple(r3, r2, 0);
        goto L67
    L49:
        if (r30.booleanValue() == false) goto L66;
        int r31 = Math.min(r11.size(), UploadResult.UPLOAD_CACELL);
        Iterator<Document> r32 = r11.iterator();
        int r33 = -1;
    L53:
        if (r32.hasNext() == false) goto L65;
        Document r116 = r32.next();
        String r117 = r2.getFileExt();
        String r34 = r116.F;
        if (r115.c(r117).a.compareTo(r115.c(r34).a) != 0) goto L57;
        boolean r36 = true;
    L58:
        if (r36 == false) goto L53;
        r3.add(c.a(r116));
        if (TextUtils.equals(r2.getFileId(), r116.d) == false) goto L64;
        r33 = r3.size() - 1;
    L64:
        if (r3.size() < r31) goto L53;
    L57:
        r36 = false;
    L65:
        r5 = new MutableTriple(r3, r2, Integer.valueOf(r33));
        goto L67
    L29:
        if (r18 != null) goto L32;
        r18 = eu5.b.a;
    L32:
        r19 = r18;
    L25:
        r17 = false;
        goto L26
    L20:
        r14 = "";
        goto L21
    L11:
        r11 = null;
        goto L12
    L13:
        r7 = "";
        r8 = r7;
        r9 = r8;
        r10 = null;
        r11 = null;
        r12 = null;
        goto L15
    L93:
        return false;
    }
}
