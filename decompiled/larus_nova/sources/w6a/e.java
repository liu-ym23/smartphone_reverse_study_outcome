package w6a;

import android.view.ViewGroup;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxUI f558448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f558449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f558450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UIGroup f558451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s6a.a f558452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s6a.a f558453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s6a.a f558454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s6a.a f558455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f558456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f558457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f558458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<String, LynxKeyframeAnimator.e> f558459l;

    public final boolean a() {
        if (this.f558457j == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f558458k == true) goto L8;
        return false;
    }

    public e(LynxUI r100) {
        this.f558449b = 0;
        this.f558450c = null;
        this.f558451d = null;
        this.f558457j = false;
        this.f558458k = false;
        this.f558448a = r100;
        this.f558459l = new HashMap();
    }
}
