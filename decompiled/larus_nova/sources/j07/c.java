package j07;

import com.bytedance.lynx.media.view.BaseMediaView;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f496822a;

    public final int a() {
        BaseMediaView r100 = this.f496822a.f496817b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getDuration();
    }

    public c(b r100) {
        this.f496822a = r100;
    }
}
