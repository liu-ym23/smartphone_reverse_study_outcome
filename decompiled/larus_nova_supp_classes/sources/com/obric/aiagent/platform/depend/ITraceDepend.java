package com.obric.aiagent.platform.depend;

import android.os.Bundle;
import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&JU\u0010\u000f\u001a\u00020\u00032K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0011H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\u001c\u0010\u0019\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/platform/depend/ITraceDepend;", XmlPullParser.NO_NAMESPACE, "report", XmlPullParser.NO_NAMESPACE, "event", XmlPullParser.NO_NAMESPACE, "params", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "enableETVerify", "getSessionId", "getDeviceId", "getInstallId", "getSsid", "awaitTraceId", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "did", "iid", "ssid", "getUserID", "getUUID", "addCommonParams", XmlPullParser.NO_NAMESPACE, "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ITraceDepend {
    public static final Companion a = null;

    static {
        a = Companion.b;
    }

    void a(Bundle r1);
}
