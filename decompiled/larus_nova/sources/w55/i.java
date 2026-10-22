package w55;

import com.bytedance.ee.plugin.common.log.ILog;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements ILog {
    public i() {
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public final void d(String r100) {
        tt5.a.b("PluginLog", r100);
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public final void e(Throwable r100) {
        tt5.a.f("PluginLog", r100, false);
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public final void i(String r100) {
        tt5.a.h("PluginLog", r100);
    }

    @Override // com.bytedance.ee.plugin.common.log.ILog
    public final void e(String r100) {
        tt5.a.d("PluginLog", r100);
    }
}
