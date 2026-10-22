package com.obric.assistant.spi.dora;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001JG\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0096\u0001J3\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0096\u0001J\t\u0010!\u001a\u00020\u0005H\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J\t\u0010#\u001a\u00020\u0005H\u0096\u0001J\t\u0010$\u001a\u00020\u0005H\u0096\u0001J\t\u0010%\u001a\u00020\u0005H\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J\t\u0010'\u001a\u00020\u0005H\u0096\u0001J\t\u0010(\u001a\u00020\u0005H\u0096\u0001J\t\u0010)\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0096\u0001J\u0011\u0010-\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020.H\u0096\u0001J\u0019\u0010/\u001a\u00020\u001d2\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0096\u0001J'\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\f2\b\u00103\u001a\u0004\u0018\u00010\f2\b\u00104\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u00065"}, d2 = {"Lcom/obric/assistant/spi/dora/ObricDoraDelegate;", "Lcom/obric/assistant/spi/dora/IObricDoraService;", "<init>", "()V", "disableDoraInLiveTutor", "", "doraUseObricLogic", "getDoraObricPlugin", "", PerfLog.PARAM_KEY_CONTEXT_ID, "getObricContext", "", "", "roundId", "", "forceUpdateFull", "getPersonalContext", "Lorg/json/JSONObject;", "handleDoraGRecordMinutes", "state", "", "mode", "query", "vuiId", "kw", "requestId", "source", "handleDoraGRecordMinutesWakeOff", "hideDoraVoiceWakeupSettingItems", "", "view", "", "Landroid/view/View;", "isCurrentMainUser", "isDoraGOnObric", "isDoraKeepAliveEnableForObric", "isDoraNewDeviceManageEnable", "isObricSmartNotificationEnable", "isObricWakeupModelEngine", "needHideDoraKeepAliveBalloon", "needHideDoraOwenSetting", "needHideDoraProactiveSetting", "onMainProcessDoraStarted", "application", "Landroid/app/Application;", "openDoraGRecordMinutesPage", "Landroid/content/Context;", "showDoraVoiceWakeupSettingItems", "listOf", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraDelegate implements IObricDoraService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricDoraDelegate f392872b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricDoraService f392873a;

    static {
        f392872b = new ObricDoraDelegate();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final Map<String, String> a(long r100, boolean r101) {
        return this.f392873a.a(r100, r101);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final void b(String r100, String r101, String r102) {
        this.f392873a.b(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final JSONObject c() {
        return this.f392873a.c();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final void d(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f392873a.d(r100);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean e() {
        return this.f392873a.e();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean f(int r100, int r101, int r102, int r110, String r111) {
        return this.f392873a.f(r100, r101, r102, r110, r111);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean g() {
        return this.f392873a.g();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean h() {
        return this.f392873a.h();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f392873a.i(r100);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean j() {
        return this.f392873a.j();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean k() {
        return this.f392873a.k();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final void l(List<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f392873a.l(r100);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean m() {
        return this.f392873a.m();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean n() {
        return this.f392873a.n();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final Object o(Object r100) {
        return this.f392873a.o(r100);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final void p(List<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "listOf");
        this.f392873a.p(r100);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean q() {
        return this.f392873a.q();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean r() {
        return this.f392873a.r();
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean s(int r100, int r110, int r111, int r112, String r113, String r114, String r115) {
        return this.f392873a.s(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.obric.assistant.spi.dora.IObricDoraService
    public final boolean t() {
        return this.f392873a.t();
    }

    private ObricDoraDelegate() {
        IObricDoraService r100 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricDoraServiceImpl();
    L5:
        this.f392873a = r100;
    }
}
