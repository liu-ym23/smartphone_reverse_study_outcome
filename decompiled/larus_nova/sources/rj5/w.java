package rj5;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements com.bytedance.ee.bear.more.protocol3.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f538117a;

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        if (this.f538117a.f538115c.isVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f538117a.f538115c.a().isCurrentEnable("ccm.mobile.move_myaibtn_to_moremenu") == false) goto L7;
        return true;
    }

    public w(v r100) {
        this.f538117a = r100;
    }
}
