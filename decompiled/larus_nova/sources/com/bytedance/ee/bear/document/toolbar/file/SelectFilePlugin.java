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
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public class SelectFilePlugin extends DocumentPlugin implements sa5.a {
    private static final long MAX_FILE_SIZE = -2147483648L;
    private static final String SELECT_FILE_NAME = "biz.util.selectFile";
    private static final String TAG = "SelectFilePlugin";
    private Disposable disposable;
    private h routeService;
    private a selectFileHandler;

    public class a implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f222321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectFilePlugin f222322b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(SelectFilePlugin r100) {
            this.f222322b = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            this.f222321a = r101;
            FragmentActivity r103 = ((DocumentPluginHost) this.f222322b.getHost()).getActivity();
            FileSelectConfig.f r104 = FileSelectConfig.filePickerBuilder();
            r104.f226780a.customSendBtnTips = r103.getResources().getString(R.string.Doc_Facade_Upload);
            r104.f226780a.fileSelectListener = new b(this);
            com.bytedance.ee.bear.document.toolbar.file.a r105 = new com.bytedance.ee.bear.document.toolbar.file.a(this);
            FileSelectConfig r106 = r104.f226780a;
            r106.fileCheckListener = r105;
            r106.maxFileSize = -2147483648L;
            FileSelectConfig r107 = r104.a();
            FragmentManager r108 = r103.getSupportFragmentManager();
            int r109 = d.f226786a;
            FileSelectFragment r110 = d.a.c(r103, r108, r107, SelectFilePlugin.TAG);
            if (r110 == null) goto L14;
            Bundle r111 = r110.getArguments();
            if (r111 == null) goto L8;
        L11:
            r111.putBoolean("key_is_function_panel", true);
            return;
        L8:
            if (r110.isAdded() == false) goto L10;
            tt5.a.k(SelectFilePlugin.TAG, "markToolbarFunctionPanel skipped, fragment is already added without arguments");
            return;
        L10:
            r111 = new Bundle();
            r110.setArguments(r111);
            goto L11
        }
    }

    @Override // sa5.a
    public void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public SelectFilePlugin() {
    }

    public static /* synthetic */ Context access$100(SelectFilePlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ a access$300(SelectFilePlugin r100) {
        return r100.selectFileHandler;
    }

    public static /* synthetic */ DocViewModel access$600(SelectFilePlugin r100) {
        return r100.getDocViewModel();
    }

    public static /* synthetic */ Context access$700(SelectFilePlugin r100) {
        return r100.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        a r101 = new a(this);
        this.selectFileHandler = r101;
        r100.put(SELECT_FILE_NAME, r101);
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        this.routeService = (h) org.koin.java.a.a(h.class);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    public static /* synthetic */ Disposable access$502(SelectFilePlugin r100, Disposable r101) {
        r100.disposable = r101;
        return r101;
    }

    private String encodeUrl(String r100, String r101) {
        return "docsource://com.bytedance.net/file/f/" + r100 + "." + r101;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        Disposable r102 = this.disposable;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isDisposed() == true) goto L9;
        this.disposable.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    public static /* synthetic */ String access$400(SelectFilePlugin r100, String r101, String r102) {
        return r100.encodeUrl(r101, r102);
    }
}
