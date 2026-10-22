package com.bytedance.speech.speechengine;

import android.content.Context;
import android.view.SurfaceView;
import com.bytedance.bpea.basics.Cert;

/* JADX INFO: loaded from: classes22.dex */
public interface SpeechEngine {

    public interface SpeechListener {
        void onSpeechMessage(int r100, byte[] r101, int r102);
    }

    long createEngine();

    void destroyEngine();

    void destroyEngine(long r100);

    int feedAudio(long r100, byte[] r101, int r102);

    int feedAudio(byte[] r100, int r101);

    int fetchResult(int r100, byte[] r101);

    int fetchResult(long r100, byte[] r101);

    String fetchResult(int r100);

    String getVersion();

    String getVersion(long r100);

    int initEngine();

    int initEngine(long r100);

    boolean isEngineSupported(String r100);

    int processAudio(byte[] r100, int r101, boolean r102);

    int resetEngine();

    int resetEngine(long r100);

    int sendDirective(int r100, String r101);

    int sendDirective(int r100, String r101, Cert r102);

    int sendDirective(long r100, int r101, String r102);

    int sendDirective(long r100, int r101, String r102, Cert r103);

    void setContext(Context r100);

    void setListener(SpeechListener r100);

    void setOptionBoolean(long r100, String r101, boolean r102);

    void setOptionBoolean(String r100, boolean r101);

    void setOptionDouble(String r100, double r101);

    void setOptionInt(long r100, String r101, int r102);

    void setOptionInt(String r100, int r101);

    void setOptionString(long r100, String r101, String r102);

    void setOptionString(String r100, String r101);

    void setRemoteView(SurfaceView r100);
}
