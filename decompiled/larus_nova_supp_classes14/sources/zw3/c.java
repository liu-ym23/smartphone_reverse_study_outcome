package zw3;

import com.bytedance.applog.log.g$b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements g$b {
    public final /* synthetic */ b a;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        if (this.a.e.getLong("app_log_last_config_time", 0) > 0) goto L6;
        return null;
    L6:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r1.put("appId", this.a.n.j);     // Catch: Throwable -> L38
        long r5 = this.a.e.getLong("session_interval", 0);     // Catch: Throwable -> L38
        String r9 = "--";
        if (r5 <= 0) goto L11;
        String r6 = r5 + "ms";     // Catch: Throwable -> L38
    L12:
        r2.put("后台会话时长", r6);     // Catch: Throwable -> L38
        long r7 = this.a.e.getLong("batch_event_interval", 0);     // Catch: Throwable -> L38
        if (r7 <= 0) goto L15;
        String r8 = r7 + "ms";     // Catch: Throwable -> L38
    L16:
        r2.put("事件上报周期", r8);     // Catch: Throwable -> L38
        long r10 = this.a.e.getLong("abtest_fetch_interval", 0);     // Catch: Throwable -> L38
        if (r10 <= 0) goto L19;
        String r11 = r10 + "ms";     // Catch: Throwable -> L38
    L20:
        r2.put("AB实验更新周期", r11);     // Catch: Throwable -> L38
        r2.put("全埋点", this.a.e.getBoolean("bav_log_collect", false));     // Catch: Throwable -> L38
        r2.put("AB实验", this.a.e.getBoolean("bav_ab_config", false));     // Catch: Throwable -> L38
        r2.put("实时埋点事件", this.a.e.getString("real_time_events", "[]"));     // Catch: Throwable -> L38
        r2.put("禁止采集手机详情", this.a.e.getBoolean("forbid_report_phone_detail_info", false));     // Catch: Throwable -> L38
        long r12 = this.a.e.getLong("fetch_interval", 0);     // Catch: Throwable -> L38
        if (r12 <= 0) goto L23;
        r9 = r12 + "ms";     // Catch: Throwable -> L38
    L23:
        r2.put("服务端配置更新周期", r9);     // Catch: Throwable -> L38
        int r13 = this.a.e.getInt("content_encode_method", 0);     // Catch: Throwable -> L38
        boolean r14 = true;
        if (r13 == 0) goto L31;
        if (r13 != 1) goto L27;
        String r15 = "ZSTD";
    L32:
        r2.put("日志压缩方式", r15);     // Catch: Throwable -> L38
        r2.put("LogBack配置", this.a.e.getString("log_back", ""));     // Catch: Throwable -> L38
        if (this.a.e.getLong("max_pack_size", 0) > 0) goto L36;
        r14 = false;
    L36:
        r2.put("包大小限制", r14);     // Catch: Throwable -> L38
        r2.put("包最大体积", this.a.e.getLong("max_pack_size", 0));     // Catch: Throwable -> L38
        r2.put("忽略分级", this.a.e.getBoolean("ignore_event_priority", false));     // Catch: Throwable -> L38
        r1.put("config", r2);     // Catch: Throwable -> L38
        goto L37
    L27:
        if (r13 == 2) goto L29;
        r15 = "UNKNOWN";
        goto L32
    L29:
        r15 = "ZSTD+DICT";
        goto L32
    L31:
        r15 = "GZIP";
        goto L32
    L19:
        r11 = "--";
        goto L20
    L15:
        r8 = "--";
        goto L16
    L11:
        r6 = "--";
    L37:
        return r1;
    }

    public c(b r1) {
        this.a = r1;
    }
}
