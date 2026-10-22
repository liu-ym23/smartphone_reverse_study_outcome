package com.obric.assistant.spi.dora;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 22\u00020\u0001:\u00012J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH&J\u0018\u0010\u000e\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&JF\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH&J2\u0010!\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u0003H&J&\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u0003H&J\n\u0010+\u001a\u0004\u0018\u00010,H&J\u0014\u0010-\u001a\u0004\u0018\u00010\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H&J&\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u001e2\b\u00100\u001a\u0004\u0018\u00010\u001e2\b\u00101\u001a\u0004\u0018\u00010\u001eH&¨\u00063"}, d2 = {"Lcom/obric/assistant/spi/dora/IObricDoraService;", "", "needHideDoraOwenSetting", "", "needHideDoraProactiveSetting", "needHideDoraKeepAliveBalloon", "doraUseObricLogic", "isDoraKeepAliveEnableForObric", "isDoraNewDeviceManageEnable", "hideDoraVoiceWakeupSettingItems", "", "view", "", "Landroid/view/View;", "showDoraVoiceWakeupSettingItems", "listOf", "disableDoraInLiveTutor", "isObricWakeupModelEngine", "isCurrentMainUser", "isObricSmartNotificationEnable", "openDoraGRecordMinutesPage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "handleDoraGRecordMinutes", "state", "", "mode", "query", "vuiId", "kw", "", "requestId", "source", "handleDoraGRecordMinutesWakeOff", "onMainProcessDoraStarted", "application", "Landroid/app/Application;", "isDoraGOnObric", "getObricContext", "", "roundId", "", "forceUpdateFull", "getPersonalContext", "Lorg/json/JSONObject;", "getDoraObricPlugin", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricDoraService {
    Map<String, String> a(long r100, boolean r101);

    void b(String r100, String r101, String r102);

    JSONObject c();

    void d(Application r100);

    boolean e();

    boolean f(int r100, int r101, int r102, int r103, String r104);

    boolean g();

    boolean h();

    boolean i(Context r100);

    boolean j();

    boolean k();

    void l(List<? extends View> r100);

    boolean m();

    boolean n();

    Object o(Object r100);

    void p(List<? extends View> r100);

    boolean q();

    boolean r();

    boolean s(int r100, int r101, int r102, int r103, String r104, String r105, String r106);

    boolean t();
}
