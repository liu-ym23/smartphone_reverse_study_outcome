package n25;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f516700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f516701b = null;

    static {
        f516700a = Charset.defaultCharset().name();
        f516701b = new String[]{"\"{{ user_id }}\"", "\"{{ sz }}\"", "\"{{ host }}\"", "\"{{ ws_server }}\"", "\"{{ language }}\"", "\"{{ user_agent }}\"", "\"{{ suid }}\"", "\"{{ tenant_id }}\"", "\"{{ department_id }}\"", "\"{{ ws_ticket }}\"", "\"{{ can_create_sheet }}\"", "\"{{ app_config }}\"", "{{client_vars|safe}}"};
    }
}
