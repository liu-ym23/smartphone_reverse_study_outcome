package yz4;

import android.content.res.Resources;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.ability.IAIChatInputPlugin;
import com.bytedance.ee.bear.document.ai.docai.CcmDocAIScene;
import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements a {
    @Inject
    public c() {
    }

    @Override // yz4.a
    public final void a(Resources.Theme r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        Intrinsics.checkNotNullParameter(r3, "tag");
    }

    @Override // yz4.a
    public final void d(CcmDocAIScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // yz4.a
    public final void f() {
    }

    @Override // yz4.a
    public final void h(PluginHost r1) {
    }

    @Override // yz4.a
    public final n b(PluginHost r2) {
        return new n(new n.a[0]);
    }

    @Override // yz4.a
    public final n e(CcmDocAIScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return new n(new n.a[0]);
    }

    @Override // yz4.a
    public final n g(CcmDocAIScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return new n(new n.a[0]);
    }

    @Override // yz4.a
    public final void c(DocumentPluginHost r4, boolean r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        WeakHashMap<PluginHost, Boolean> r0 = d.a;
        Intrinsics.checkNotNullParameter(r4, "host");
        IAIChatInputPlugin r1 = (IAIChatInputPlugin) r4.findPlugin(IAIChatInputPlugin.class);
        if (r1 != null) goto L7;
        tt5.a.k("OfficeCommentVoiceBarBridge", "IAIChatInputPlugin missing, showing=" + r5);
        return;
    L7:
        WeakHashMap<PluginHost, Boolean> r2 = d.a;
        monitor-enter(r2);
        if (r5 == true) goto L11;
        Boolean r6 = r2.remove(r4);     // Catch: Throwable -> L27
        if (r6 != null) goto L18;
        monitor-exit(r2);
        return;
    L18:
        if (r6.booleanValue() == true) goto L20;
    L22:
        boolean r7 = false;
    L23:
        monitor-exit(r2);
        tt5.a.h("OfficeCommentVoiceBarBridge", "set chat input visibility, visible=" + r7);
        r1.setChatInputVisibility(r7);
        return;
    L20:
        if (r1.isActionBarVisible() == false) goto L22;
        r7 = true;
        goto L23
    L11:
        if (r2.containsKey(r4) == false) goto L14;
        monitor-exit(r2);
        return;
    L14:
        r2.put(r4, Boolean.valueOf(r1.isActionBarVisible()));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }
}
