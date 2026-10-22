package com.bytedance.ee.bear.middleground.docsdk.v2;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectedMediaItem;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class SDKV2SelectImgPlugin extends AbsEditorSdkPlugin {
    private static final String TAG = "SDKV2SelectImgPlugin";
    private m selectMediaCallback;
    private final i45.c selectMediaModule;

    public class a implements i45.a {
        public final /* synthetic */ SDKV2SelectImgPlugin a;

        public final boolean b() {
            return false;
        }

        public FragmentActivity getActivity() {
            return this.a.getHost().getActivity();
        }

        public a(SDKV2SelectImgPlugin r1) {
            this.a = r1;
        }

        public final Disposable a(List<SelectedMediaItem> r3) {
            if (SDKV2SelectImgPlugin.access$000(this.a) == null) goto L5;
            SDKV2SelectImgPlugin.access$000(this.a).b(SDKV2SelectImgPlugin.access$100(this.a, r3));
            return null;
        L5:
            tt5.a.d(SDKV2SelectImgPlugin.TAG, "insertMedias(): failed cause selectMediaCallback is null ");
            return null;
        }

        public final void c(JSONObject r3) {
            SDKV2SelectImgPlugin.access$200(this.a, "window.lark.biz.util.cancelFromImageSelector", r3);
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ SDKV2SelectImgPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SDKV2SelectImgPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            SDKV2SelectImgPlugin.access$002(this.a, r2);
        }
    }

    public class c implements i<Void> {
        public final /* synthetic */ SDKV2SelectImgPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(SDKV2SelectImgPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            SDKV2SelectImgPlugin.access$002(this.a, r2);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SDKV2SelectImgPlugin() {
        this.selectMediaModule = new i45.c(new a(this));
    }

    public static /* synthetic */ m access$000(SDKV2SelectImgPlugin r0) {
        return r0.selectMediaCallback;
    }

    private JSONObject buildJsonData(List<SelectedMediaItem> r6) {
        JSONArray r0 = new JSONArray();
        Iterator<SelectedMediaItem> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        SelectedMediaItem r1 = r7.next();
        JSONObject r2 = new JSONObject();
        r2.put("uuid", r1.getUuid());
        r2.put("width", Integer.valueOf(r1.getWidth()));
        r2.put("height", Integer.valueOf(r1.getHeight()));
        r2.put("src", r1.getMediaFile());
        r0.add(r2);
        goto L4
    L6:
        JSONObject r8 = new JSONObject();
        r8.put("code", 0);
        r8.put("thumbs", r0);
        return r8;
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.util.selectMedia", new c(this));
        r3.put("biz.util.selectImage", new b(this));
    }

    public void onAttachToHost(EditorSdkPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.selectMediaModule.b.a();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((EditorSdkPluginHost) r1);
    }

    public static /* synthetic */ m access$002(SDKV2SelectImgPlugin r0, m r1) {
        r0.selectMediaCallback = r1;
        return r1;
    }

    public static /* synthetic */ JSONObject access$100(SDKV2SelectImgPlugin r0, List r1) {
        return r0.buildJsonData(r1);
    }

    public void onDetachFromUIContainer(EditorSdkPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.selectMediaModule.b.b();
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }

    public static /* synthetic */ void access$200(SDKV2SelectImgPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }
}
