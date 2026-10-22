package com.bytedance.lighten.core.utils;

import android.view.View;
import com.facebook.drawee.view.DraweeHolder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes20.dex */
public final class TagCompat {

    public static class TagMap extends HashMap<String, Object> {
        public TagMap(String r100, Object r101, a r102) {
            put(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public static Object a(View r100) {
        Object r101 = r100.getTag();
        if ((r101 instanceof TagMap) == false) goto L7;
        Object r102 = ((TagMap) r101).get("DraweeHolder");
        if (r102 == null) goto L7;
        return r102;
    L7:
        return null;
    }

    public static void b(View r100, DraweeHolder r101) {
        Object r102 = r100.getTag();
        if ((r102 instanceof TagMap) == false) goto L5;
        ((TagMap) r102).put("DraweeHolder", r101);
        return;
    L5:
        r100.setTag(new TagMap("DraweeHolder", r101, null));
    }
}
