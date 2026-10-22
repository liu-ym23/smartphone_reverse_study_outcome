package qz2;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.l;
import com.lynx.tasm.LynxEnv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends NativeCommon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f535292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f535293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f535295d;

    public b() {
        this.f535293b = "";
        this.f535294c = LynxEnv.inst().getLynxVersion();
        this.containerType = "lynx";
    }

    @Override // com.bytedance.android.monitorV2.entity.NativeCommon, fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        super.fillInJsonObject(r100);
        l.n(r100, "template_state", this.f535292a);
        l.q(r100, "lynx_version", this.f535294c);
        l.q(r100, "page_version", this.f535293b);
    }
}
