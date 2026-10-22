package zh0;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f572128a;

    public d(c r100) {
        this.f572128a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        JSONObject r102 = new JSONObject();
        this.f572128a.getClass();
        r102.put("speaking", false);
        this.f572128a.f572126c.c1("radio_sei", r102, 1, false, true);
    }
}
