package u10;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f548275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f548276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f548277c;

    public g(e r100, Function3 r101, long r102) {
        this.f548275a = r100;
        this.f548276b = r101;
        this.f548277c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        HttpResponse r101 = (HttpResponse) r100;
        Function3 r102 = this.f548276b;
        Integer r103 = Integer.valueOf(r101.getStatusCode());
        e r104 = this.f548275a;
        List<NameValuePair> r105 = r101.getHeaders();
        r104.getClass();
        JSONObject r106 = new JSONObject();
        Iterator<NameValuePair> r107 = r105.iterator();
    L4:
        if (r107.hasNext() == false) goto L6;
        NameValuePair r108 = r107.next();
        r106.put(r108.getName(), r108.getValue());
        goto L4
    L6:
        r102.invoke(r103, r106, new String(r101.getBody(), Charsets.UTF_8));
        this.f548275a.f548269c.remove(Long.valueOf(this.f548277c));
    }
}
