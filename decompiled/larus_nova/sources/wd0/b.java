package wd0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import tf0.e;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f559270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f559271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f559272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f559273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f559274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IVoiceLiveTheme f559275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f559276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f559277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends e> f559278i;

    public b() {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("LiveBgRenderContext(room=");
        IRoom r101 = this.f559271b;
        if (r101 == null) goto L5;
        String r102 = r101.getTitle();
    L6:
        r100.append(r102);
        r100.append(", scene=");
        r100.append(this.f559272c);
        r100.append(", uiLayout=");
        r100.append(this.f559273d);
        r100.append(", isPlayerShow=");
        r100.append(this.f559274e);
        r100.append(", theme=");
        r100.append(this.f559275f);
        r100.append(", hideBg=");
        r100.append(this.f559276g);
        r100.append(", layoutOrientation=");
        r100.append(this.f559277h);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }
}
