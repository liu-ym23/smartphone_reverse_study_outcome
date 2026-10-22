package com.bytedance.ies.argus.plugin;

import android.app.Application;
import com.bytedance.ies.argus.base.ArgusEnv;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends ISecurePlugin<SecLinkPluginHandler> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public final boolean c() {
    L25:
        e = move-exception;
        int r100 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.b("SecLinkPlugin", "init secLink error: " + e, null, 12);
    L28:
        if (cr7.a.f465093b != null) goto L34;
        return false;
    L34:
        return true;
    L4:
        if (cr7.a.f465093b == null) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L28;
        Lazy<ArgusEnv> r102 = ArgusEnv.f245917d;     // Catch: Exception -> L25
        r06.a.C7412a r103 = ArgusEnv.b.a().a();     // Catch: Exception -> L25
        if (r103 == null) goto L11;
        String r104 = r103.f535468a;     // Catch: Exception -> L25
    L12:
        r06.a r105 = ArgusEnv.b.a().f245918a;     // Catch: Exception -> L25
        if (r105 == null) goto L15;
        Application r106 = r105.f535465d;     // Catch: Exception -> L25
    L16:
        r06.a.C7412a r107 = ArgusEnv.b.a().a();     // Catch: Exception -> L25
        if (r107 == null) goto L19;
        String r108 = r107.f535469b;     // Catch: Exception -> L25
    L20:
        if (r104 == null) goto L28;
        if (r106 == null) goto L28;
        if (r108 == null) goto L28;
        StringCompanionObject r109 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L25
        String r110 = String.format("https://%s", Arrays.copyOf(new Object[]{"seclink.bytedance.com"}, 1));     // Catch: Exception -> L25
        gr7.a.C6060a r111 = new gr7.a.C6060a();     // Catch: Exception -> L25
        r111.f482375a = r104;     // Catch: Exception -> L25
        r111.f482376b = "cn";     // Catch: Exception -> L25
        r111.f482377c = r110;     // Catch: Exception -> L25
        cr7.a.b(r106, new gr7.a(r111));     // Catch: Exception -> L25
        goto L28
    L19:
        r108 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    L6:
        r101 = false;
        goto L7
    }

    public e() {
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public final Class<SecLinkPluginHandler> b() {
        return SecLinkPluginHandler.class;
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public final SecurePluginType d() {
        return SecurePluginType.SEC_LINK;
    }

    @Override // com.bytedance.ies.argus.plugin.ISecurePlugin
    public final SecLinkPluginHandler a(String r100) {
        return new SecLinkPluginHandler(SecurePluginType.SEC_LINK, r100);
    }
}
