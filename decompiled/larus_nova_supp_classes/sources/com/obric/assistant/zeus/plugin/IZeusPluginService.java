package com.obric.assistant.zeus.plugin;

import android.content.Context;
import android.util.EventsUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0003H&J\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0016H¦@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\u000bH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH&¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/zeus/plugin/IZeusPluginService;", XmlPullParser.NO_NAMESPACE, "init", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "afterPrivacy", "getUploadFilePaths", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "isPluginInstalled", XmlPullParser.NO_NAMESPACE, "pluginPackageName", "installFromDownloadDir", "preInstallPlugin", "hostApkPath", "timeoutMS", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPreInstallData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitPluginInstall", "Lkotlin/Pair;", "isPluginPreInstalled", "hostPkgVersionCode", "isProtocolVersionCheckerEnabled", "setProtocolVersionCheckerEnabled", "enable", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IZeusPluginService {
    boolean a();

    List<String> b(Context r1);

    boolean c(String r1);

    void d(Context r1);

    boolean e();

    void f();

    Object g(String r1, long r2, Continuation<? super Unit> r4);

    void init(Context r1);
}
