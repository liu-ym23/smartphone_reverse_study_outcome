package k32;

import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h3 f501712t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f501713u;

    public final boolean a() {
        h3 r100 = this.f501712t;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.I0() == null) goto L7;
        return true;
    }

    public d(h3 r100, String r101, String r102, String r103) {
        super(r101, r102, r103);
        this.f501713u = false;
        this.f501712t = r100;
        long r104 = 0;
        if (r100 != null) goto L6;
        ALogger.i("NotifyEffectMessage", "notifyEffectMessage is null");
    L11:
        long r105 = ShareImageDataPlugin.TRANSFER_TIMEOUT;
    L13:
        this.f501699p = r105;
        if (r100 != null) goto L17;
        ALogger.i("NotifyEffectMessage", "notifyEffectMessage is null");
    L20:
        this.f501698o = r104;
        return;
    L17:
        if (r100.M() != null) goto L19;
        ALogger.i("NotifyEffectMessage", "sceneConfig is null");
        goto L20
    L19:
        r104 = r100.M().f();
        goto L20
    L6:
        if (r100.M() != null) goto L9;
        ALogger.i("NotifyEffectMessage", "sceneConfig is null");
        goto L11
    L9:
        if (r100.o1() != 0) goto L12;
        ALogger.i("NotifyEffectMessage", "Server did not dispatch remote priority");
        goto L11
    L12:
        r105 = r100.o1();
        goto L13
    }
}
