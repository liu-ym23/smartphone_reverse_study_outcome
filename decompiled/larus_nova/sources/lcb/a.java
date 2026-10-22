package lcb;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import java.util.HashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<String, a> f508620j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f508621k = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f508622i;

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "DefaultDomainConfigHandler";
    }

    static {
        f508620j = new HashMap();
        f508621k = new Object();
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return this.f508622i;
    }

    public a(String r100) {
        this.f508622i = r100;
    }
}
