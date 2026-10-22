package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f209646a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.chameleon.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C3019a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f209647a = null;

        static {
            int[] r100 = new int[BitableSubType.values().length];
            r100[BitableSubType.BaseRecord.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[BitableSubType.BaseAdd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[BitableSubType.BaseMain.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[BitableSubType.BaseApp.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[BitableSubType.Unknown.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f209647a = r100;
        }
    }

    static {
    }

    public a() {
    }

    public static b a(PluginHost r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (b) r100.getHostAbilityOrNull(b.class);
    }

    public static /* synthetic */ void d(ChameleonPluginHost r100, String r101) {
        c(r100, r101, System.currentTimeMillis());
    }

    public static void b(ChameleonPluginHost r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        b r103 = a(r100);
        if (r103 == null) goto L6;
        r103.ge(r101, r102);
        return;
    }

    public static void c(PluginHost r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        b r103 = a(r100);
        if (r103 == null) goto L6;
        r103.jg(r101, r102);
        return;
    }
}
