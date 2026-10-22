package com.bytedance.badger;

import android.content.Context;
import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.badger.network.v;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096\u0001J!\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J!\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0019H\u0096\u0001J+\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\u0011\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0096\u0001J#\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010(H\u0096\u0001J'\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010(0\u0015H\u0096\u0001J\u0019\u0010/\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0096\u0001J\u0011\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0096\u0001J\u0011\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0013H\u0096\u0001J\u0017\u00107\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0003H\u0096\u0001J\t\u00108\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010;\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u000109H\u0096\u0001J\u0011\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0013H\u0096\u0001J\t\u0010>\u001a\u00020\u0019H\u0096\u0001JU\u0010F\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u0002052\u001c\u0010D\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130B0Aj\u0002`C2\u001c\u0010E\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130B0Aj\u0002`CH\u0096\u0001J\t\u0010G\u001a\u00020\u0019H\u0096\u0001J\u0019\u0010K\u001a\u00020\u00042\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u000205H\u0096\u0001¨\u0006N"}, d2 = {"Lcom/bytedance/badger/Badger;", "Lcom/bytedance/badger/IBadger;", "Lcom/bytedance/badger/network/u;", "Lkotlin/Function0;", "", "listener", "addInitListener", "", "sceneId", "Lz64/h;", "reportMode", "Lz64/g;", "callback", "doBadgerReport", "Landroid/content/Context;", "getContext", "getLoginHandler", "Lcom/bytedance/badger/network/v;", "getNetRequestInterface", "", "path", "", "getReportHeader", "Lcom/bytedance/badger/a;", "initParams", "", "init", "isInitialized", "level", "tag", "msg", "", "tr", "log", "Lz64/e;", "action", "notifyUserAction", "Lcom/bytedance/badger/data/EventReportEnum;", "eventName", "key", "", "value", "recordEvent", "values", "featureId", "Lcom/bytedance/badger/module/BadgerModuleBase;", "badgerModule", "registerBadgerModule", "Ly64/a;", "defaultConfig", "setDefaultConfig", "timestamp", "setServerTS", "", ShortVideoSegments.KEY_PROP_PROVIDER, "setServerTSV2Provider", "startBootReport", "Lorg/json/JSONObject;", "config", "updateConfig", "scene", "updateReport", "checkUnfinishedTasks", "url", "requestStartTime", "", "Lkotlin/Pair;", "Lcom/bytedance/badger/network/Headers;", "requestHeaders", "responseHeaders", "handleResponse", "invalidateRecord", "Lz64/f;", "request", "delayMs", "sendFollowUpRequest", "<init>", "()V", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public final class Badger implements IBadger, com.bytedance.badger.network.u {
    public static final Badger INSTANCE = null;
    private final /* synthetic */ IBadger $$delegate_0;
    private final /* synthetic */ com.bytedance.badger.network.u $$delegate_1;

    @Override // com.bytedance.badger.IBadger
    public void addInitListener(Function0<Unit> r100) {
        this.$$delegate_0.addInitListener(r100);
    }

    @Override // com.bytedance.badger.network.u
    public boolean checkUnfinishedTasks() {
        return this.$$delegate_1.checkUnfinishedTasks();
    }

    @Override // com.bytedance.badger.IBadger
    public void doBadgerReport(int r100, z64.h r101, z64.g r102) {
        this.$$delegate_0.doBadgerReport(r100, r101, r102);
    }

    @Override // com.bytedance.badger.IBadger
    public Context getContext() throws IllegalStateException {
        return this.$$delegate_0.getContext();
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.network.u getLoginHandler() {
        return this.$$delegate_0.getLoginHandler();
    }

    @Override // com.bytedance.badger.IBadger
    public v getNetRequestInterface() throws IllegalStateException {
        return this.$$delegate_0.getNetRequestInterface();
    }

    @Override // com.bytedance.badger.IBadger
    public Map<String, String> getReportHeader(String r100) {
        return this.$$delegate_0.getReportHeader(r100);
    }

    @Override // com.bytedance.badger.network.u
    public void handleResponse(String r100, long r101, List<Pair<String, String>> r110, List<Pair<String, String>> r111) {
        this.$$delegate_1.handleResponse(r100, r101, r110, r111);
    }

    @Override // com.bytedance.badger.IBadger
    public boolean init(a r100) {
        return this.$$delegate_0.init(r100);
    }

    @Override // com.bytedance.badger.network.u
    public boolean invalidateRecord() {
        return this.$$delegate_1.invalidateRecord();
    }

    @Override // com.bytedance.badger.IBadger
    public boolean isInitialized() {
        return this.$$delegate_0.isInitialized();
    }

    @Override // com.bytedance.badger.IBadger
    public void log(int r100, String r101, String r102, Throwable r103) {
        this.$$delegate_0.log(r100, r101, r102, r103);
    }

    @Override // com.bytedance.badger.IBadger
    public void notifyUserAction(z64.e r100) {
        this.$$delegate_0.notifyUserAction(r100);
    }

    @Override // com.bytedance.badger.IBadger
    public void recordEvent(EventReportEnum r100, String r101, Object r102) {
        this.$$delegate_0.recordEvent(r100, r101, r102);
    }

    @Override // com.bytedance.badger.IBadger
    public void recordEvent(EventReportEnum r100, Map<String, ? extends Object> r101) {
        this.$$delegate_0.recordEvent(r100, r101);
    }

    @Override // com.bytedance.badger.IBadger
    public boolean registerBadgerModule(int r100, BadgerModuleBase r101) {
        return this.$$delegate_0.registerBadgerModule(r100, r101);
    }

    @Override // com.bytedance.badger.network.u
    public void sendFollowUpRequest(z64.f r100, long r101) {
        this.$$delegate_1.sendFollowUpRequest(r100, r101);
    }

    @Override // com.bytedance.badger.IBadger
    public void setDefaultConfig(y64.a r100) {
        this.$$delegate_0.setDefaultConfig(r100);
    }

    @Override // com.bytedance.badger.IBadger
    public void setServerTS(String r100) {
        this.$$delegate_0.setServerTS(r100);
    }

    @Override // com.bytedance.badger.IBadger
    public void setServerTSV2Provider(Function0<Long> r100) {
        this.$$delegate_0.setServerTSV2Provider(r100);
    }

    @Override // com.bytedance.badger.IBadger
    public void startBootReport() {
        this.$$delegate_0.startBootReport();
    }

    @Override // com.bytedance.badger.IBadger
    public void updateConfig(JSONObject r100) {
        this.$$delegate_0.updateConfig(r100);
    }

    @Override // com.bytedance.badger.IBadger
    public void updateReport(String r100) {
        this.$$delegate_0.updateReport(r100);
    }

    static {
        INSTANCE = new Badger();
    }

    private Badger() {
        Lazy r100 = BadgerKt.f199017b;
        KProperty[] r101 = BadgerKt.f199016a;
        KProperty r102 = r101[0];
        this.$$delegate_0 = (IBadger) r100.getValue();
        KProperty r103 = r101[0];
        this.$$delegate_1 = ((IBadger) r100.getValue()).getLoginHandler();
    }
}
