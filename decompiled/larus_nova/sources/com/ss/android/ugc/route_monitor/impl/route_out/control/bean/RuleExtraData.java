package com.ss.android.ugc.route_monitor.impl.route_out.control.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.utils.Logger;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R(\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/RuleExtraData;", "", "Lorg/json/JSONObject;", "toJsonObject$route_monitor_release", "()Lorg/json/JSONObject;", "toJsonObject", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/DialogStyle;", "<set-?>", "dialogStyle", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/DialogStyle;", "getDialogStyle", "()Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/DialogStyle;", "", "toastText", "Ljava/lang/String;", "getToastText", "()Ljava/lang/String;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class RuleExtraData {
    public static final a Companion = null;
    private DialogStyle dialogStyle;
    private String toastText;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final JSONObject toJsonObject$route_monitor_release() {
        JSONObject r100 = new JSONObject();
        DialogStyle r101 = this.dialogStyle;     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        r100.put("dialogStyle", r101.toJsonObject$route_monitor_release());     // Catch: Throwable -> L7
        r100.put("toastText", this.toastText);     // Catch: Throwable -> L7
    L9:
        return r100;
    L7:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L9
    }

    public RuleExtraData() {
        this.toastText = "该链接存在高风险内容，无法打开";
    }

    public final DialogStyle getDialogStyle() {
        return this.dialogStyle;
    }

    public final String getToastText() {
        return this.toastText;
    }

    public static final /* synthetic */ DialogStyle access$getDialogStyle$p(RuleExtraData r100) {
        return r100.dialogStyle;
    }

    public static final /* synthetic */ String access$getToastText$p(RuleExtraData r100) {
        return r100.toastText;
    }

    public static final /* synthetic */ void access$setDialogStyle$p(RuleExtraData r100, DialogStyle r101) {
        r100.dialogStyle = r101;
    }

    public static final /* synthetic */ void access$setToastText$p(RuleExtraData r100, String r101) {
        r100.toastText = r101;
    }
}
