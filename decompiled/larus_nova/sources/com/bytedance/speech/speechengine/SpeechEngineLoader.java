package com.bytedance.speech.speechengine;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.speech.speechengine.bridge.SpeechBridge;
import com.bytedance.speech.speechengine.bridge.SpeechEngineBridge;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class SpeechEngineLoader {
    public static final String[] COMMON_LIB_ARRAY = null;
    public static final String[] PLUGIN_LIB_ARRAY = null;
    public static final String[] SDK_LIB_ARRAY = null;
    public PluginAdapter adapter;
    public State state;

    public interface PluginAdapter {
        boolean loadFromHost(String r100);

        boolean loadFromPlugin(String r100);
    }

    public static final enum State extends Enum<State> {
        public static final /* synthetic */ State[] $VALUES = null;
        public static final State PLUGIN_LOADED = null;
        public static final State PLUGIN_NOT_EXIST = null;
        public static final State UNKNOWN = null;

        static {
            State r100 = new State("UNKNOWN", 0);
            UNKNOWN = r100;
            State r101 = new State("PLUGIN_NOT_EXIST", 1);
            PLUGIN_NOT_EXIST = r101;
            State r102 = new State("PLUGIN_LOADED", 2);
            PLUGIN_LOADED = r102;
            $VALUES = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b implements PluginAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpeechEngineLoader f270318a;

        public b(SpeechEngineLoader r100) {
            this.f270318a = r100;
        }

        @JvmStatic
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.bytedance.speech.speechengine.SpeechEngineLoader.PluginAdapter
        public final boolean loadFromHost(String r100) {
            if (SpeechEngineLoader.access$000(this.f270318a) == State.UNKNOWN) goto L10;
            return true;
        L10:
            a(r100);     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            th.printStackTrace();
            return false;
        }

        @Override // com.bytedance.speech.speechengine.SpeechEngineLoader.PluginAdapter
        public final boolean loadFromPlugin(String r100) {
            if (SpeechEngineLoader.access$000(this.f270318a) != State.UNKNOWN) goto L5;
            a(r100);     // Catch: Throwable -> L10
            return true;
        L10:
            th = move-exception;
            th.printStackTrace();
            return false;
        L5:
            if (SpeechEngineLoader.access$000(this.f270318a) != State.PLUGIN_LOADED) goto L15;
            return true;
        L15:
            return false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SpeechEngineLoader f270319a = null;

        static {
            f270319a = new SpeechEngineLoader(null);
        }
    }

    public synchronized SpeechBridge createBridge() {
        monitor-enter(this);
        load();     // Catch: Throwable -> L15
        if (this.state == State.PLUGIN_LOADED) goto L19;
    L12:
        SpeechEngineBridge r100 = new SpeechEngineBridge();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r100;
    L19:
        Class r101 = INVOKEVIRTUAL_com_bytedance_speech_speechengine_SpeechEngineLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(getClass().getClassLoader(), "com.bytedance.speech.speechengine.bridge.SpeechPluginBridge");     // Catch: Exception -> L10 Throwable -> L15
        if (r101 == null) goto L12;
        SpeechBridge r102 = (SpeechBridge) r101.newInstance();     // Catch: Exception -> L10 Throwable -> L15
        monitor-exit(this);
        return r102;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized State getState() {
        monitor-enter(this);
        State r100 = this.state;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized State load() {
        monitor-enter(this);
        int r100 = 0;
        if (this.state != State.UNKNOWN) goto L13;
        String[] r101 = COMMON_LIB_ARRAY;     // Catch: Throwable -> L38
        int r102 = r101.length;     // Catch: Throwable -> L38
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L13;
        String r104 = r101[r103];     // Catch: Throwable -> L38
        if (this.adapter.loadFromHost(r104) == false) goto L11;
        r103 = r103 + 1;     // Catch: Throwable -> L38
        goto L6
    L11:
        throw new UnsatisfiedLinkError("SpeechEngine load host library: " + r104 + " failed!");     // Catch: Throwable -> L38
    L13:
        if (this.state == State.PLUGIN_LOADED) goto L26;
        String[] r105 = PLUGIN_LIB_ARRAY;     // Catch: Throwable -> L38
        if (r105.length == 0) goto L26;
        int r106 = r105.length;     // Catch: Throwable -> L38
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L22;
        if (this.adapter.loadFromPlugin(r105[r107]) == false) goto L20;
        r107 = r107 + 1;     // Catch: Throwable -> L38
        goto L17
    L20:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L26;
        this.state = State.PLUGIN_LOADED;     // Catch: Throwable -> L38
        goto L26
    L22:
        r108 = true;
    L26:
        if (this.state != State.UNKNOWN) goto L35;
        String[] r109 = SDK_LIB_ARRAY;     // Catch: Throwable -> L38
        int r110 = r109.length;     // Catch: Throwable -> L38
    L28:
        if (r100 >= r110) goto L34;
        String r111 = r109[r100];     // Catch: Throwable -> L38
        if (this.adapter.loadFromHost(r111) == false) goto L33;
        r100 = r100 + 1;     // Catch: Throwable -> L38
        goto L28
    L33:
        throw new UnsatisfiedLinkError("SpeechEngine load host library: " + r111 + " failed!");     // Catch: Throwable -> L38
    L34:
        this.state = State.PLUGIN_NOT_EXIST;     // Catch: Throwable -> L38
    L35:
        State r112 = this.state;     // Catch: Throwable -> L38
        monitor-exit(this);
        return r112;
    L38:
        th = move-exception;
        throw th;
    }

    static {
        COMMON_LIB_ARRAY = new String[]{"audio_fingerprint_sdk"};
        SDK_LIB_ARRAY = new String[]{"speechengine"};
        PLUGIN_LIB_ARRAY = new String[]{"speechepg"};
    }

    public SpeechEngineLoader() {
        this.state = State.UNKNOWN;
        this.adapter = new b(this);
    }

    public static SpeechEngineLoader getInstance() {
        return c.f270319a;
    }

    public /* synthetic */ SpeechEngineLoader(a r100) {
        this();
    }

    public static /* synthetic */ State access$000(SpeechEngineLoader r100) {
        return r100.state;
    }

    public synchronized void setAdapter(PluginAdapter r100) {
        monitor-enter(this);
        if (r100 == null) goto L8;
        this.adapter = r100;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L8:
        throw new NullPointerException("SpeechEngineLoader plugin adapter can't be null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_bytedance_speech_speechengine_SpeechEngineLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
