package com.ss.android.lark.chameleon;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u001e\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H&J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u001e\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&J(\u0010\u0002\u001a\u00020\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleon/IChameleonApi;", "", "open", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "bizPlugins", "", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "getChameleonFragment", "Landroidx/fragment/app/Fragment;", "openByForseti", "sourceFragment", "style", "Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions$DestinationStyle;", "preloadWebview", "destroyWebview", "Landroid/webkit/WebView;", "loadResource", "callback", "Lcom/ss/android/lark/chameleon/ChameleonResourceLoadCallback;", "getChameleonJsRuntime", "Lcom/ss/android/lark/chameleon/AbsChameleonJsRuntime;", "url", "", "bizType", "Lcom/ss/android/lark/chameleon/ChameleonBizType;", "canOpen", "", "targetUrl", "extraParams", "Landroid/os/Bundle;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChameleonApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean canOpen$default(IChameleonApi r100, String r101, Bundle r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.canOpen(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canOpen");
        }

        public static /* synthetic */ void preloadWebview$default(IChameleonApi r100, ChameleonConfig r101, WebView r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.preloadWebview(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadWebview");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fragment getChameleonFragment$default(IChameleonApi r100, Context r101, ChameleonConfig r102, List r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.getChameleonFragment(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChameleonFragment");
        }

        public static /* synthetic */ boolean open$default(IChameleonApi r100, Context r101, String r102, Bundle r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.open(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void open$default(IChameleonApi r100, Context r101, ChameleonConfig r102, List r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.open(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openByForseti$default(IChameleonApi r100, Fragment r101, ForsetiNavOptions.DestinationStyle r102, ChameleonConfig r103, List r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.openByForseti(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openByForseti");
        }
    }

    boolean canOpen(String r100, Bundle r101);

    Fragment getChameleonFragment(Context r100, ChameleonConfig r101, List<? extends AbsChameleonPlugin> r102);

    AbsChameleonJsRuntime getChameleonJsRuntime(Context r100, String r101, ChameleonBizType r102);

    void loadResource(ChameleonConfig r100, ChameleonResourceLoadCallback r101);

    void open(Context r100, ChameleonConfig r101, List<? extends AbsChameleonPlugin> r102);

    boolean open(Context r100, String r101, Bundle r102);

    void openByForseti(Fragment r100, ForsetiNavOptions.DestinationStyle r101, ChameleonConfig r102, List<? extends AbsChameleonPlugin> r103);

    void preloadWebview(ChameleonConfig r100, WebView r101);
}
