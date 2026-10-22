package ep2;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473423a;

    public c() {
        this.f473423a = "rule_tag_app_enter_front";
    }

    @Override // ep2.d
    public final String d() {
        return this.f473423a;
    }

    @Override // ep2.d
    public final boolean e(Object r100) {
        if (fp2.b.b() != LiveMode.AUDIO) goto L5;
        return true;
    L5:
        return false;
    }
}
