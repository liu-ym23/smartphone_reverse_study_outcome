package j6b;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;

/* JADX INFO: loaded from: classes35.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, URLPreviewTemplate> f497553a = null;

    static {
        f497553a = new LruCache(30);
    }

    public static UrlPreviewTemplate a(String r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        URLPreviewTemplate r111 = f497553a.get(r110);
        if (r111 == null) goto L12;
        byte[] r112 = r111.encode();
        URLPreviewTemplate r113 = URLPreviewTemplate.ADAPTER.decode(r112);
        int r100 = a.f497538a;
        if (r113 != null) goto L11;
        return null;
    L11:
        return new UrlPreviewTemplate(r113.root_component_id, a.a(r113.elements, null), r113.image_ids, r113.at_ids, r113.button_ids, r113.richtext_ids, r113.template_id);
    L12:
        return null;
    }
}
