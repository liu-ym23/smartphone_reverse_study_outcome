package re5;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class e extends s66.d {
    public final String c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[XReadableType.values().length];
            r0[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[XReadableType.String.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[XReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[XReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[XReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public e() {
        this.c = "ccm.setStorageItem";
    }

    public String getName() {
        return this.c;
    }

    public final void e(u66.e r4, s66.d.a r5, XBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TYPE);
        boolean r0 = false;
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r5.a(0, "Context not provided in host");
        return;
    L6:
        String r7 = r4.a;
        t r1 = null;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r7 = null;
    L10:
        t r8 = r4.b;
        if (r8 == null) goto L13;
        r1 = r8;
    L15:
        switch(a.a[r1.getType().ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L23;
        };
    L17:
        r0 = c.a.e(r7, r1.asMap());
        goto L23
    L18:
        r0 = c.a.e(r7, r1.asArray());
        goto L23
    L19:
        r0 = c.a.e(r7, Double.valueOf(r1.asDouble()));
        goto L23
    L20:
        r0 = c.a.e(r7, r1.asString());
        goto L23
    L21:
        r0 = c.a.e(r7, Integer.valueOf(r1.asInt()));
        goto L23
    L22:
        r0 = c.a.e(r7, Boolean.valueOf(r1.asBoolean()));
    L23:
        if (r0 == false) goto L25;
        r5.b(new i66.b(), "");
        return;
    L25:
        r5.a(-3, "Illegal value type");
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException(WikiFolderPushPlugin.DATA);
        goto L15
    }
}
