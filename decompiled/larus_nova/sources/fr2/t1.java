package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;

/* JADX INFO: loaded from: classes11.dex */
public final class t1 implements hr2.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t1 f478539b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f478540c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedStreamIndex f478541a;

    public static final class a {
        public a() {
        }
    }

    static {
        f478540c = new a();
        f478539b = new t1(LiveWrappedStreamIndex.STREAM_INDEX_MAIN);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478541a;
    }

    public t1(LiveWrappedStreamIndex r100) {
        this.f478541a = r100;
    }
}
