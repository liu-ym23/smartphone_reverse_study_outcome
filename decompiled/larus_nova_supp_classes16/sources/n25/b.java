package n25;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final String a = null;
    public static final String[] b = null;

    static {
        a = Charset.defaultCharset().name();
        b = new String[]{"\"{{ user_id }}\"", "\"{{ sz }}\"", "\"{{ host }}\"", "\"{{ ws_server }}\"", "\"{{ language }}\"", "\"{{ user_agent }}\"", "\"{{ suid }}\"", "\"{{ tenant_id }}\"", "\"{{ department_id }}\"", "\"{{ ws_ticket }}\"", "\"{{ can_create_sheet }}\"", "\"{{ app_config }}\"", "{{client_vars|safe}}"};
    }
}
