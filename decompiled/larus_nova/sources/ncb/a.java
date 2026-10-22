package ncb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f518679a = null;

    static {
        OPMonitorLevel r100 = OPMonitorLevel.NORMAL;
        new a(10002, r100, "native_receive_invoke");
        new a(10003, r100, "native_callback_invoke");
        new a(10004, r100, "native_invoke_start");
        new a(10005, r100, "native_invoke_result");
        new a(10006, r100, "native_pm_invoke_start");
        new a(10007, r100, "native_pm_invoke_result");
        new a(10008, r100, "plugin_silent_checker");
        new a(10009, r100, "plugin_paramtype_checker");
        f518679a = new a(10010, r100, "plugin_input_checker");
    }

    public a(int r100, OPMonitorLevel r101, String r102) {
        super("client.open_platform.api.common", r100, r101, r102);
    }
}
