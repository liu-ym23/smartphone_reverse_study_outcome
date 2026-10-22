package com.ss.android.ugc.route_monitor.impl.route_out.control.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.utils.Logger;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/DialogStyle;", "", "Lorg/json/JSONObject;", "toJsonObject$route_monitor_release", "()Lorg/json/JSONObject;", "toJsonObject", "", "<set-?>", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "text", "getText", "negativeText", "getNegativeText", "positiveText", "getPositiveText", "", "dialogDismissMs", "J", "getDialogDismissMs", "()J", "setDialogDismissMs", "(J)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class DialogStyle {
    public static final a Companion = null;
    private static final DialogStyle defaultAlertDialogStyle = null;
    private static final DialogStyle defaultInterceptDialogStyle = null;
    private long dialogDismissMs;
    private String negativeText;
    private String positiveText;
    private String text;
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        DialogStyle r100 = new DialogStyle();
        r100.title = "提示";
        r100.text = "即将离开抖音，打开其它应用";
        r100.negativeText = "取消";
        r100.positiveText = "立即打开";
        defaultAlertDialogStyle = r100;
        DialogStyle r101 = new DialogStyle();
        r101.title = "风险提示";
        r101.text = "您即将前往第三方应用，抖音无法确保其安全性，请确认是否前往？";
        r101.negativeText = "仍要前往";
        r101.positiveText = "返回";
        r101.dialogDismissMs = 3000;
        defaultInterceptDialogStyle = r101;
    }

    public final JSONObject toJsonObject$route_monitor_release() {
        JSONObject r100 = new JSONObject();
        r100.put("title", this.title);     // Catch: Throwable -> L5
        r100.put("text", this.text);     // Catch: Throwable -> L5
        r100.put("negativeText", this.negativeText);     // Catch: Throwable -> L5
        r100.put("positiveText", this.positiveText);     // Catch: Throwable -> L5
        r100.put("dialogDismissMs", this.dialogDismissMs);     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L7
    }

    public DialogStyle() {
        this.title = "";
        this.text = "";
        this.negativeText = "";
        this.positiveText = "";
    }

    public static final /* synthetic */ DialogStyle access$getDefaultAlertDialogStyle$cp() {
        return defaultAlertDialogStyle;
    }

    public static final /* synthetic */ DialogStyle access$getDefaultInterceptDialogStyle$cp() {
        return defaultInterceptDialogStyle;
    }

    public final long getDialogDismissMs() {
        return this.dialogDismissMs;
    }

    public final String getNegativeText() {
        return this.negativeText;
    }

    public final String getPositiveText() {
        return this.positiveText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public static final /* synthetic */ String access$getNegativeText$p(DialogStyle r100) {
        return r100.negativeText;
    }

    public static final /* synthetic */ String access$getPositiveText$p(DialogStyle r100) {
        return r100.positiveText;
    }

    public static final /* synthetic */ String access$getText$p(DialogStyle r100) {
        return r100.text;
    }

    public static final /* synthetic */ String access$getTitle$p(DialogStyle r100) {
        return r100.title;
    }

    public final void setDialogDismissMs(long r100) {
        this.dialogDismissMs = r100;
    }

    public static final /* synthetic */ void access$setNegativeText$p(DialogStyle r100, String r101) {
        r100.negativeText = r101;
    }

    public static final /* synthetic */ void access$setPositiveText$p(DialogStyle r100, String r101) {
        r100.positiveText = r101;
    }

    public static final /* synthetic */ void access$setText$p(DialogStyle r100, String r101) {
        r100.text = r101;
    }

    public static final /* synthetic */ void access$setTitle$p(DialogStyle r100, String r101) {
        r100.title = r101;
    }
}
