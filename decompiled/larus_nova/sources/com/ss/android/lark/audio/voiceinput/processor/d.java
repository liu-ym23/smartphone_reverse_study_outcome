package com.ss.android.lark.audio.voiceinput.processor;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.s;

/* JADX INFO: loaded from: classes34.dex */
public interface d {
    String a();

    void b();

    boolean c();

    void d();

    void e();

    void f(ProcessType r100);

    boolean g(g r100, IGetDataCallback<String> r101);

    String getUploadId();

    void h(g r100, VoiceDataProcessDispatcher$onStartRecord$1 r101);

    void i(g r100, String r101, String r102);

    void j(s r100, String r101);

    void onDestroy();
}
