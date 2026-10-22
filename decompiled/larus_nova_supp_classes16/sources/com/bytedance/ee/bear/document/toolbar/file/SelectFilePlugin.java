package com.bytedance.ee.bear.document.toolbar.file;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.d;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.route.h;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectFilePlugin extends DocumentPlugin implements sa5.a {
    private static final long MAX_FILE_SIZE = -2147483648L;
    private static final String SELECT_FILE_NAME = "biz.util.selectFile";
    private static final String TAG = "SelectFilePlugin";
    private Disposable disposable;
    private h routeService;
    private a selectFileHandler;

    public class a implements i<Void> {
        public m a;
        public final /* synthetic */ SelectFilePlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(SelectFilePlugin r1) {
            this.b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            Void r7 = (Void) r5;
            this.a = r6;
            FragmentActivity r8 = ((DocumentPluginHost) this.b.getHost()).getActivity();
            FileSelectConfig.f r9 = FileSelectConfig.filePickerBuilder();
            r9.a.customSendBtnTips = r8.getResources().getString(2131887846);
            r9.a.fileSelectListener = new b(this);
            com.bytedance.ee.bear.document.toolbar.file.a r0 = new com.bytedance.ee.bear.document.toolbar.file.a(this);
            FileSelectConfig r1 = r9.a;
            r1.fileCheckListener = r0;
            r1.maxFileSize = SelectFilePlugin.MAX_FILE_SIZE;
            FileSelectConfig r10 = r9.a();
            FragmentManager r2 = r8.getSupportFragmentManager();
            int r3 = d.a;
            FileSelectFragment r11 = d.a.c(r8, r2, r10, SelectFilePlugin.TAG);
            if (r11 == null) goto L14;
            Bundle r12 = r11.getArguments();
            if (r12 == null) goto L8;
        L11:
            r12.putBoolean("key_is_function_panel", true);
            return;
        L8:
            if (r11.isAdded() == false) goto L10;
            tt5.a.k(SelectFilePlugin.TAG, "markToolbarFunctionPanel skipped, fragment is already added without arguments");
            return;
        L10:
            r12 = new Bundle();
            r11.setArguments(r12);
            goto L11
        }
    }

    @Override // sa5.a
    public void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SelectFilePlugin() {
    }

    public static /* synthetic */ Context access$100(SelectFilePlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ a access$300(SelectFilePlugin r0) {
        return r0.selectFileHandler;
    }

    public static /* synthetic */ DocViewModel access$600(SelectFilePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ Context access$700(SelectFilePlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        a r0 = new a(this);
        this.selectFileHandler = r0;
        r3.put(SELECT_FILE_NAME, r0);
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super.onAttachToHost(r1);
        this.routeService = (h) org.koin.java.a.a(h.class);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ Disposable access$502(SelectFilePlugin r0, Disposable r1) {
        r0.disposable = r1;
        return r1;
    }

    private String encodeUrl(String r3, String r4) {
        return "docsource://com.bytedance.net/file/f/" + r3 + "." + r4;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        Disposable r3 = this.disposable;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isDisposed() == true) goto L9;
        this.disposable.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static /* synthetic */ String access$400(SelectFilePlugin r0, String r1, String r2) {
        return r0.encodeUrl(r1, r2);
    }
}
