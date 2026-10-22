package vy2;

import com.lynx.tasm.LynxEnv;
import org.json.JSONObject;
import py2.k;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f557573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f557574k;

    public b() {
        this.f557574k = "";
        this.f531014c = "lynx";
    }

    @Override // py2.k, ny2.a
    public final void b(JSONObject r100) {
        super.b(r100);
        bz2.e.f(r100, "template_state", this.f557573j);
        bz2.e.i(r100, "lynx_version", LynxEnv.inst().getLynxVersion());
        bz2.e.i(r100, "page_version", this.f557574k);
    }
}
