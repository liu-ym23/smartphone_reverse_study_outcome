package com.bytedance.speech.speechaudio;

import com.bytedance.speech.speechaudio.bridge.SpeechBridge;
import com.mammon.audiosdk.bridge.SAMICoreBridge;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public class SpeechEngineLoader {

    /* JADX INFO: renamed from: com.bytedance.speech.speechaudio.SpeechEngineLoader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$speech$speechaudio$SpeechAudioLoader$State = null;

        static {
            int[] r100 = new int[SpeechAudioLoader.State.values().length];
            $SwitchMap$com$bytedance$speech$speechaudio$SpeechAudioLoader$State = r100;
            r100[SpeechAudioLoader.State.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$speech$speechaudio$SpeechAudioLoader$State[SpeechAudioLoader.State.PLUGIN_LOADED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$speech$speechaudio$SpeechAudioLoader$State[SpeechAudioLoader.State.PLUGIN_NOT_EXIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface PluginAdapter extends CommonPluginAdapter {
        @Override // com.bytedance.speech.speechaudio.CommonPluginAdapter
        boolean loadFromHost(String r100);

        @Override // com.bytedance.speech.speechaudio.CommonPluginAdapter
        boolean loadFromPlugin(String r100);
    }

    public static class SpeechEngineLoaderHolder {
        static SpeechEngineLoader INSTANCE;

        private SpeechEngineLoaderHolder() {
        }

        static {
            INSTANCE = new SpeechEngineLoader();
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
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
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public synchronized SpeechBridge createBridge() {
        monitor-enter(this);
        SpeechBridge r100 = SpeechAudioLoader.getInstance().createBridge();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized SAMICoreBridge createSAMICoreBridge() {
        monitor-enter(this);
        SAMICoreBridge r100 = SpeechAudioLoader.getInstance().createSAMICoreBridge();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized State getState() {
        monitor-enter(this);
        State r100 = ConvertState(SpeechAudioLoader.getInstance().getState());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized State load() {
        monitor-enter(this);
        State r100 = ConvertState(SpeechAudioLoader.getInstance().load());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public SpeechEngineLoader() {
        SpeechAudioLoader.getInstance().getState();
    }

    public static SpeechEngineLoader getInstance() {
        return SpeechEngineLoaderHolder.INSTANCE;
    }

    private State ConvertState(SpeechAudioLoader.State r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$bytedance$speech$speechaudio$SpeechAudioLoader$State[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L13;
        if (r101 == 3) goto L11;
        return State.UNKNOWN;
    L11:
        return State.PLUGIN_NOT_EXIST;
    L13:
        return State.PLUGIN_LOADED;
    L15:
        return State.UNKNOWN;
    }

    public synchronized void setAdapter(PluginAdapter r100) {
        monitor-enter(this);
        SpeechAudioLoader.getInstance().setAdapter(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
