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

/* JADX INFO: loaded from: classes16.dex */
public final class c implements a {
    @Inject
    public c() {
    }

    @Override // yz4.a
    public final void a(Resources.Theme r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "tag");
    }

    @Override // yz4.a
    public final void d(CcmDocAIScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // yz4.a
    public final void f() {
    }

    @Override // yz4.a
    public final void h(PluginHost r100) {
    }

    @Override // yz4.a
    public final n b(PluginHost r100) {
        return new n(new n.a[0]);
    }

    @Override // yz4.a
    public final n e(CcmDocAIScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return new n(new n.a[0]);
    }

    @Override // yz4.a
    public final n g(CcmDocAIScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return new n(new n.a[0]);
    }

    @Override // yz4.a
    public final void c(DocumentPluginHost r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakHashMap<PluginHost, Boolean> r102 = d.f569540a;
        Intrinsics.checkNotNullParameter(r100, "host");
        IAIChatInputPlugin r103 = (IAIChatInputPlugin) r100.findPlugin(IAIChatInputPlugin.class);
        if (r103 != null) goto L7;
        tt5.a.k("OfficeCommentVoiceBarBridge", "IAIChatInputPlugin missing, showing=" + r101);
        return;
    L7:
        WeakHashMap<PluginHost, Boolean> r104 = d.f569540a;
        monitor-enter(r104);
        if (r101 == true) goto L11;
        Boolean r105 = r104.remove(r100);     // Catch: Throwable -> L27
        if (r105 != null) goto L18;
        monitor-exit(r104);
        return;
    L18:
        if (r105.booleanValue() == true) goto L20;
    L22:
        boolean r106 = false;
    L23:
        monitor-exit(r104);
        tt5.a.h("OfficeCommentVoiceBarBridge", "set chat input visibility, visible=" + r106);
        r103.setChatInputVisibility(r106);
        return;
    L20:
        if (r103.isActionBarVisible() == false) goto L22;
        r106 = true;
        goto L23
    L11:
        if (r104.containsKey(r100) == false) goto L14;
        monitor-exit(r104);
        return;
    L14:
        r104.put(r100, Boolean.valueOf(r103.isActionBarVisible()));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }
}
