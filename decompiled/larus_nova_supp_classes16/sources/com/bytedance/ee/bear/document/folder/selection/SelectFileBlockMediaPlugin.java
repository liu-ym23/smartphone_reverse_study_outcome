package com.bytedance.ee.bear.document.folder.selection;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.d;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/folder/selection/SelectFileBlockMediaPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "selectMediaHandler", "Lcom/bytedance/ee/bear/document/folder/selection/SelectFileBlockMediaPlugin$ShowSelectionPanelHandler;", "disposable", "Lio/reactivex/disposables/Disposable;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "ShowSelectionPanelHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectFileBlockMediaPlugin extends DocumentPlugin {
    private static final String BIZ_UTIL_SELECTION_PANEL = "biz.util.selectFileBlockMedia";
    public static final a Companion = null;
    private static final String TAG = "SelectFileBlockMediaPlugin";
    private Disposable disposable;
    private b selectMediaHandler;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<n15.a> {
        public m a;
        public final /* synthetic */ SelectFileBlockMediaPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SelectFileBlockMediaPlugin r1) {
            this.b = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r6, m r7) {
            n15.a r8 = (n15.a) r6;
            this.a = r7;
            int r9 = d.a;
            FragmentActivity r10 = SelectFileBlockMediaPlugin.access$getActivity(this.b);
            FragmentManager r11 = SelectFileBlockMediaPlugin.access$getActivity(this.b).getSupportFragmentManager();
            FileSelectConfig.g r0 = FileSelectConfig.fullScreenAlbumBuilder();
            FileSelectConfig r1 = r0.a;
            r1.showGif = true;
            r1.sourceType = 2;
            r1.showOrigin = true;
            r1.checkedKeepOrigin = true;
            r1.isOriginFile = true;
            r1.mediaType = 2;
            r1.maxSelectImageNum = 99;
            r1.enableImageCompress = true;
            r1.larkAlbumActionType = 2;
            r0.a.fileSelectListener = new com.bytedance.ee.bear.document.folder.selection.a(this.b, this);
            d.a.c(r10, r11, r0.a(), SelectFileBlockMediaPlugin.TAG);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SelectFileBlockMediaPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SelectFileBlockMediaPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(SelectFileBlockMediaPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(SelectFileBlockMediaPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ b access$getSelectMediaHandler$p(SelectFileBlockMediaPlugin r0) {
        return r0.selectMediaHandler;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        b r0 = new b(this);
        r3.put(BIZ_UTIL_SELECTION_PANEL, r0);
        this.selectMediaHandler = r0;
    }

    public static final /* synthetic */ String access$getString(SelectFileBlockMediaPlugin r0, int r1) {
        return r0.getString(r1);
    }

    public static final /* synthetic */ void access$setDisposable$p(SelectFileBlockMediaPlugin r0, Disposable r1) {
        r0.disposable = r1;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        Disposable r3 = this.disposable;
        if (r3 == null) goto L6;
        r3.dispose();
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
}
