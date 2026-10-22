package f36;

import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements et3.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f475400a;

    public c(b r100) {
        this.f475400a = r100;
    }

    @Override // et3.c.d
    public final void fpsCallBack(double r100) {
        String.format(new String(), Arrays.copyOf(new Object[]{"get fps from callBack:%s", String.valueOf(r100)}, 2));
        this.f475400a.f475393a.f475403b = r100;
    }
}
