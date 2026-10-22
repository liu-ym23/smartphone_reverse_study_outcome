package com.bytedance.badger;

import android.content.Context;
import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.badger.network.u;
import com.bytedance.badger.network.v;
import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import y64.a;
import z64.e;
import z64.g;
import z64.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0016\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\tH&J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&J*\u0010 \u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J \u0010&\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H&J\u0010\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H&J\"\u0010/\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010-H&J&\u0010/\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010-00H&J\u0010\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020\u001bH&J\u0016\u00106\u001a\u00020\t2\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u000bH&J\u0010\u00109\u001a\u00020\t2\u0006\u00108\u001a\u000207H&J\u0010\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u001bH&J \u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u0001002\b\u0010<\u001a\u0004\u0018\u00010\u001bH&¨\u0006>"}, d2 = {"Lcom/bytedance/badger/IBadger;", "Lcom/bytedance/news/common/service/manager/IService;", "Lcom/bytedance/badger/a;", "initParams", XmlPullParser.NO_NAMESPACE, "init", "isInitialized", "Lorg/json/JSONObject;", "config", XmlPullParser.NO_NAMESPACE, "updateConfig", "Lkotlin/Function0;", "listener", "addInitListener", "Landroid/content/Context;", "getContext", "Lcom/bytedance/badger/network/v;", "getNetRequestInterface", "Lcom/bytedance/badger/network/u;", "getLoginHandler", "startBootReport", XmlPullParser.NO_NAMESPACE, "featureId", "Lcom/bytedance/badger/module/BadgerModuleBase;", "badgerModule", "registerBadgerModule", "level", XmlPullParser.NO_NAMESPACE, "tag", "msg", XmlPullParser.NO_NAMESPACE, "tr", "log", "sceneId", "Lz64/h;", "reportMode", "Lz64/g;", "callback", "doBadgerReport", "Lz64/e;", "action", "notifyUserAction", "Lcom/bytedance/badger/data/EventReportEnum;", "eventName", "key", XmlPullParser.NO_NAMESPACE, "value", "recordEvent", XmlPullParser.NO_NAMESPACE, "values", "timestamp", "setServerTS", XmlPullParser.NO_NAMESPACE, "provider", "setServerTSV2Provider", "Ly64/a;", "defaultConfig", "setDefaultConfig", "scene", "updateReport", "path", "getReportHeader", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public interface IBadger extends IService {
    void addInitListener(Function0<Unit> r1);

    void doBadgerReport(int r1, h r2, g r3);

    Context getContext() throws IllegalStateException;

    u getLoginHandler();

    v getNetRequestInterface() throws IllegalStateException;

    Map<String, String> getReportHeader(String r1);

    boolean init(a r1);

    boolean isInitialized();

    void log(int r1, String r2, String r3, Throwable r4);

    void notifyUserAction(e r1);

    void recordEvent(EventReportEnum r1, String r2, Object r3);

    void recordEvent(EventReportEnum r1, Map<String, ? extends Object> r2);

    boolean registerBadgerModule(int r1, BadgerModuleBase r2);

    void setDefaultConfig(a r1);

    void setServerTS(String r1);

    void setServerTSV2Provider(Function0<Long> r1);

    void startBootReport();

    void updateConfig(JSONObject r1);

    void updateReport(String r1);
}
