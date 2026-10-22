package k6b;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponents;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import j6b.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f501978a = null;

    static {
        f501978a = new b();
    }

    public b() {
    }

    public static void a(UrlCardPreviewEntity r100, ArrayList r101, HashMap r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "urlPreviewEntity");
        Intrinsics.checkNotNullParameter(r101, "templateList");
        Intrinsics.checkNotNullParameter(r102, "previewEntityNoTemplate");
        Intrinsics.checkNotNullParameter(r103, "previewId");
        UrlPreviewBody r104 = r100.getPreviewBody();
        if (r104 == null) goto L5;
        UrlPreviewComponents r105 = r104.getUrlPreviewComponents();
    L6:
        if (r105 == null) goto L8;
        return;
    L8:
        UrlPreviewBody r106 = r100.getPreviewBody();
        if (r106 == null) goto L20;
        Map<String, UrlPreviewState> r107 = r106.getStates();
        if (r107 == null) goto L28;
        Iterator<Map.Entry<String, UrlPreviewState>> r108 = r107.entrySet().iterator();
    L14:
        if (r108.hasNext() == false) goto L29;
        Map.Entry<String, UrlPreviewState> r109 = r108.next();
        String r110 = r109.getKey();
        UrlPreviewState r111 = r109.getValue();
        if (r111 == null) goto L14;
        LruCache<String, URLPreviewTemplate> r112 = l.f497553a;
        if (l.a(r111.getTemplateId()) != null) goto L14;
        r101.add(r111.getTemplateId());
        r102.put(r103, r100);
        goto L14
    L29:
        return;
    L28:
        return;
    L20:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
