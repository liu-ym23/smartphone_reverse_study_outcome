package com.obric.miniapp.calendar.proxy.function;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes33.dex */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/miniapp/calendar/proxy/function/SystemAppletMethod;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SystemAppletMethod {
    public static final a Companion = null;
    public static final String METHOD_ADD_PACKAGE_DATABASE_OBSERVER = "addAIPackageDatabaseObserver";
    public static final String METHOD_CREATE_OR_UPDATE_ALARM = "createOrUpdateAlarm";
    public static final String METHOD_DELETE_ALARM = "deleteAlarm";
    public static final String METHOD_GET_AI_PACKAGE_INFO = "getAIPackageInfo";
    public static final String METHOD_GET_ALARM_IDS = "getAlarmIds";
    public static final String METHOD_GET_ALARM_JSON_BY_ID = "getAlarmJsonById";
    public static final String METHOD_GET_FEATURES = "getFeatures";
    public static final String METHOD_GET_SYNC_ENABLE = "getSyncEnable";
    public static final String METHOD_REGISTER_ALARM_TTS_MESSENGER = "registerAlarmTtsMessenger";
    public static final String METHOD_UNREGISTER_ALARM_TTS_MESSENGER = "unregisterAlarmTtsMessenger";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f397605a = null;

        static {
            f397605a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f397605a;
    }
}
