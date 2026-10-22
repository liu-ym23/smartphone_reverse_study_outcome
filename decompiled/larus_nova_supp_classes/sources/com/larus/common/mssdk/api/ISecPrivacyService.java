package com.larus.common.mssdk.api;

import android.content.Context;
import android.util.EventsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import r09.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\u0017"}, d2 = {"Lcom/larus/common/mssdk/api/ISecPrivacyService;", XmlPullParser.NO_NAMESPACE, "initPrivacy", XmlPullParser.NO_NAMESPACE, "base", "Landroid/content/Context;", "isPrivacyProcess", XmlPullParser.NO_NAMESPACE, "updateIsFirstStartMark", "isFirstStart", "registerPrivacyReceiver", "context", "checkFirstStartAsyncTaskInit", "taskName", XmlPullParser.NO_NAMESPACE, "isFirstInstallStarting", "checkAgreed", "notifyAgree", "result", "sendKillMySelfBroadcast", "privacyNotifyStartEventDelay", "privacyUpdateIsFirstStartMark", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ISecPrivacyService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Lazy<ISecPrivacyService> b = null;

        public a() {
        }

        static {
            a = new a();
            b = LazyKt.lazy(new b());
        }

        public static ISecPrivacyService a() {
            return b.getValue();
        }
    }

    static {
        a = a.a;
    }

    boolean a();

    void b(Context r1);

    void c(Context r1);

    void d();

    void e();

    boolean f(String r1);

    void g(Context r1);

    boolean h();

    void i(boolean r1);

    boolean j();
}
