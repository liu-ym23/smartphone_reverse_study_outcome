package f36;

import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements et3.c.InterfaceC5817c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f475401a;

    public d(b r100) {
        this.f475401a = r100;
    }

    @Override // et3.c.InterfaceC5817c
    public final void dropFrame(JSONObject r100) {
        String.format(new String(), Arrays.copyOf(new Object[]{"get dropFrame data from callBack:%s", r100.toString()}, 2));
        this.f475401a.f475393a.dropFrame(r100);
    }
}
