package com.edu.onetex.latex;

import androidx.camera.video.AudioStats;
import com.edu.onetex.html.HtmlNodeCustomViewGenerator;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002@AB\t\b\u0002¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007J\t\u0010\u0010\u001a\u00020\tH\u0082 J\u0011\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082 J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0082 J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0082 J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0082 J\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020#J\u000e\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020#J\u000e\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'J\u000e\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020#0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020'0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u00020\r2\u0006\u00105\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00100\u001a\u0004\b6\u00102R*\u0010\u001d\u001a\u00020\r2\u0006\u00105\u001a\u00020\r8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lcom/edu/onetex/latex/LaTeXEngine;", "", "", "latexContent", "getSpeechText", "parseContent", "errorMsg", "", "errorCode", "", "onParseError", "tag", "content", "", "isError", "onReceiveLog", "nInit", "Lcom/edu/onetex/latex/OneTexConfiguration;", "configuration", "nSetConfig", "Lcom/edu/onetex/latex/LaTeXParam;", "latexParam", "nCanParseLaTeX", "Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "customViewGenerator", "", "nParseHtml", "nGetSpeechText", "init", "asyncParse", "setAsyncParse", "setConfig", "latex", "canParseLaTeX", "release", "Lcom/edu/onetex/latex/LaTeXEngine$b;", "listener", "addOnParseErrorListener", "removeOnParseErrorListener", "Lcom/edu/onetex/latex/LaTeXEngine$a;", "logger", "addLogger", "removeLogger", "", "onParseErrorListeners", "Ljava/util/List;", "loggers", "debugMode", "Z", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "<set-?>", "isInitialized", "getAsyncParse", "setAsyncParse$onetex_release", "Lcom/edu/onetex/latex/OneTexConfiguration;", "getConfiguration", "()Lcom/edu/onetex/latex/OneTexConfiguration;", "setConfiguration", "(Lcom/edu/onetex/latex/OneTexConfiguration;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class LaTeXEngine {
    public static final LaTeXEngine INSTANCE = null;
    private static volatile boolean asyncParse;
    private static OneTexConfiguration configuration;
    private static boolean debugMode;
    private static volatile boolean isInitialized;
    private static final List<a> loggers = null;
    private static final List<b> onParseErrorListeners = null;

    /* JADX INFO: loaded from: classes22.dex */
    public interface a {
        void a();
    }

    public interface b {
        void a(String r100, String r101, int r102);
    }

    private LaTeXEngine() {
    }

    private final native boolean nCanParseLaTeX(LaTeXParam r100);

    private final native String nGetSpeechText(String r100);

    private final native void nInit();

    private final native long[] nParseHtml(LaTeXParam r100, HtmlNodeCustomViewGenerator r101);

    private final native void nSetConfig(OneTexConfiguration r100);

    public final synchronized void release() {
        monitor-enter(this);
        isInitialized = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        INSTANCE = new LaTeXEngine();
        onParseErrorListeners = new ArrayList();
        loggers = new ArrayList();
    }

    public final void init() {
        nInit();
        isInitialized = true;
    }

    public final boolean getAsyncParse() {
        return asyncParse;
    }

    public final OneTexConfiguration getConfiguration() {
        return configuration;
    }

    public final boolean getDebugMode() {
        return debugMode;
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    @JvmStatic
    public static final String getSpeechText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "latexContent");
        String r101 = INSTANCE.nGetSpeechText(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101;
    }

    public final void addLogger(a r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        List<a> r101 = loggers;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final void addOnParseErrorListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<b> r101 = onParseErrorListeners;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    public final boolean canParseLaTeX(String r110) {
        Intrinsics.checkNotNullParameter(r110, "latex");
        return nCanParseLaTeX(new LaTeXParam(r110, new zs7.a(100.0f, 1), new zs7.a(20.0f, 1), 0.0f, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null, 0, 0, false, false, null, false, 8184, null));
    }

    public final void removeLogger(a r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        loggers.remove(r100);
    }

    public final void removeOnParseErrorListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        onParseErrorListeners.remove(r100);
    }

    public final void setAsyncParse(boolean r100) {
        asyncParse = r100;
    }

    public final void setAsyncParse$onetex_release(boolean r100) {
        asyncParse = r100;
    }

    public final void setConfig(OneTexConfiguration r100) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        configuration = r100;
        nSetConfig(r100);
    }

    public final void setConfiguration(OneTexConfiguration r100) {
        configuration = r100;
    }

    public final void setDebugMode(boolean r100) {
        debugMode = r100;
    }

    @JvmStatic
    public static final void onParseError(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parseContent");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Iterator<b> r103 = onParseErrorListeners.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().a(r100, r101, r102);
        goto L4
    }

    @JvmStatic
    public static final void onReceiveLog(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "content");
        Iterator<a> r103 = loggers.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        a r104 = r103.next();
        if (r102 == true) goto L7;
        r104.a();
        goto L4
    L7:
        r104.a();
        goto L4
    }
}
