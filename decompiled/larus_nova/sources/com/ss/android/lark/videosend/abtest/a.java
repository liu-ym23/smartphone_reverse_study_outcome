package com.ss.android.lark.videosend.abtest;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends iua.a<Boolean> {

    /* JADX INFO: renamed from: com.ss.android.lark.videosend.abtest.a$a, reason: collision with other inner class name */
    public static final class C5378a {
    }

    static {
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("messenger_video_passthrough", "send raw video");
    }

    public a() {
    }

    @Override // iua.a
    public final Boolean getDefault() {
        return Boolean.TRUE;
    }
}
