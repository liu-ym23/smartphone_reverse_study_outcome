package me5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends i66.a {
    public Boolean a;
    public Integer b;

    public static final class a {
        @JvmStatic
        public static Map a(e r3) {
            Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
            LinkedHashMap r0 = new LinkedHashMap();
            Boolean r1 = r3.a;
            if (r1 == null) goto L5;
            r0.put("isConnected", Boolean.valueOf(r1.booleanValue()));
        L5:
            Integer r4 = r3.getType();
            if (r4 == null) goto L8;
            r0.put(ResourceData.KEY_TYPE, Integer.valueOf(r4.intValue()));
        L8:
            return r0;
        }
    }

    static {
    }

    public e() {
    }

    public final Integer getType() {
        return this.b;
    }
}
