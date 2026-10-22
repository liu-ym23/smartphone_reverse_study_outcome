package com.bytedance.ee.bear.office.export.docs.bridge;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.log.Log;
import hk5.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/office/export/docs/bridge/OfficeBridgePlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "<init>", "()V", "uuid", "", "callbackMap", "", "Lcom/bytedance/ee/bear/office/export/bridge/PluginHostCallback;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onResume", "onDetachFromHost", "Companion", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBridgePlugin extends BasePluginV2 {
    public static final a Companion = null;
    private static final String TAG = "OfficeBridgePlugin";
    private final Map<String, hk5.a> callbackMap;
    private String uuid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeBridgePlugin() {
        this.callbackMap = new LinkedHashMap();
    }

    public void onAttachToHost(PluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r6);
        Fragment r0 = r6.getHostFragment();
        if (r0 == null) goto L7;
        Bundle r1 = r0.getArguments();
        if (r1 == null) goto L7;
        String r2 = r1.getString("plugin_host_callback_key");
    L8:
        this.uuid = r2;
        Log.i(TAG, "onAttachToHost, uuid = " + this.uuid);
        String r3 = this.uuid;
        if (r3 == null) goto L14;
        ConcurrentHashMap<String, hk5.a> r4 = b.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        hk5.a r5 = b.a.get(r3);
        Log.i(TAG, "onAttachToHost, callback = " + r5);
        if (r5 == null) goto L15;
        this.callbackMap.clear();
        this.callbackMap.put(r3, r5);
        r5.onAttachToHost(r6);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public void onDetachFromHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        String r3 = this.uuid;
        if (r3 == null) goto L6;
        b.a(r3);
        return;
    }

    public void onResume(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onResume(r2);
        Fragment r3 = r2.getHostFragment();
        if (r3 == null) goto L7;
        Bundle r4 = r3.getArguments();
        if (r4 == null) goto L7;
        String r5 = r4.getString("plugin_host_callback_key");
    L8:
        this.uuid = r5;
        if (r5 == null) goto L16;
        ConcurrentHashMap<String, hk5.a> r0 = b.a;
        Intrinsics.checkNotNullParameter(r5, "key");
        if (b.a.get(r5) != null) goto L17;
        hk5.a r1 = this.callbackMap.get(r5);
        if (r1 == null) goto L18;
        b.b(r5, r1);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
