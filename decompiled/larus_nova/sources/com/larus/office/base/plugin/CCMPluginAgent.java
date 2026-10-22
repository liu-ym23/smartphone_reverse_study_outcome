package com.larus.office.base.plugin;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginError;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginIds;
import h0b.d;
import h0b.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@ClaymoreImpl(d.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0002¨\u0006\r"}, d2 = {"Lcom/larus/office/base/plugin/CCMPluginAgent;", "Lcom/ss/android/lark/ccm_api/ICCMPluginAgent;", "<init>", "()V", "installPlugin", "", "pluginPackageName", "", "pluginUpdateCallback", "Lcom/ss/android/lark/ccm_api/ICCMPluginUpdateCallback;", "loadTTOffice", "callback", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMPluginAgent implements d {
    public static final a Companion = null;
    private static final String TAG = "CCMPluginAgent";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements OfficeSDKPluginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f360691a;

        @Override // com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback
        public final void onSuccess() {
            w55.a r100 = (w55.a) this.f360691a;
            r100.f558321a.getClass();
            tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "checkInstallPlugin() onSuccess");
            r100.f558321a.f558325a.d();
        }

        public b(e r100) {
            this.f360691a = r100;
        }

        @Override // com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback
        public final void onFailure(OfficeSDKPluginError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            e r101 = this.f360691a;
            w55.a r102 = (w55.a) r101;
            r102.a(r100.getCode(), r100.getMessage());
        }

        @Override // com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginCallback
        public final void onProgress(int r100) {
            w55.a r101 = (w55.a) this.f360691a;
            if (r100 != 100) goto L5;
            r101.f558321a.getClass();
            tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "checkInstallPlugin() onProgressUpdate progress=" + r100);
            return;
        L5:
            r101.getClass();
        }
    }

    static {
        Companion = new a();
    }

    public CCMPluginAgent() {
    }

    private final void loadTTOffice(e r100) {
        ((w55.a) r100).f558321a.getClass();
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "checkInstallPlugin() onStart");
        wm9.a.f560365a.loadPlugin(OfficeSDKPluginIds.TT_OFFICE, new b(r100));
    }

    @Override // h0b.d
    public void installPlugin(String r100, e r101) {
        if (r101 != null) goto L6;
        FLogger.f375446a.e(TAG, "installPlugin callback is null, pluginPackageName=" + r100);
        return;
    L6:
        FLogger.f375446a.i(TAG, "installPlugin: " + r100);
        if (Intrinsics.areEqual(r100, OfficeSDKPluginIds.TT_OFFICE) == false) goto L9;
        loadTTOffice(r101);
        return;
    L9:
        ((w55.a) r101).a(-10002, "Unsupported OfficeSDK plugin: " + r100);
    }
}
