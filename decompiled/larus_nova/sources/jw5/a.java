package jw5;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;

/* JADX INFO: loaded from: classes19.dex */
public interface a extends pd6.a {
    void Q1(FlowAsrCancelReason r100);

    qw5.a getConfig();

    String getTaskId();

    void h();

    void release();

    void start();

    void stop();

    void v2(b r100);
}
