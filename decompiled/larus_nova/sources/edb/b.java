package edb;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final UrlPreviewComponent a(PreviewHangPoint r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UrlCardPreviewEntity r101 = r100.getUrlCardPreviewEntity();
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        UrlPreviewBody r103 = r101.getPreviewBody();
        if (r103 == null) goto L37;
        String r104 = r103.getCurrentStateId();
        if (r104 == null) goto L40;
        UrlPreviewTemplate r105 = r101.getPreviewBody().getTemplates().get(r104);
        if (r105 != null) goto L13;
        return null;
    L13:
        Map<String, UrlPreviewComponent> r106 = r105.getElements();
        if (r106 == null) goto L38;
        Collection<UrlPreviewComponent> r107 = r106.values();
        if (r107 == null) goto L39;
        Iterator<T> r108 = r107.iterator();
    L19:
        if (r108.hasNext() == false) goto L31;
        Object r109 = r108.next();
        UrlPreviewComponent r110 = (UrlPreviewComponent) r109;
        if (r110 == null) goto L23;
        Type r111 = r110.getType();
    L25:
        if (r111 != Type.DOC_IMAGE) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == false) goto L19;
        r102 = r109;
        goto L31
    L27:
        r112 = false;
        goto L28
    L23:
        r111 = null;
    L31:
        return (UrlPreviewComponent) r102;
    L39:
        return null;
    L38:
        return null;
    L40:
        return null;
    L37:
        return null;
    }
}
