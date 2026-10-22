package u10;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedString;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements LiveCall<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call<?> f548266a;

    public final HttpResponse a() {
        SsResponse<?> r100 = this.f548266a.execute();     // Catch: Exception -> L43
        if (r100.body() == null) goto L6;
        Object r101 = r100.body();     // Catch: Exception -> L43
    L10:
        String r102 = "";
        if ((r101 instanceof TypedByteArray) == false) goto L14;
        byte[] r103 = ((TypedByteArray) r101).getBytes();     // Catch: Exception -> L43
    L21:
        Response r104 = r100.raw();     // Catch: Exception -> L43
        if (r104 == null) goto L25;
        String r105 = r104.getReason();     // Catch: Exception -> L43
        if (r105 == null) goto L25;
    L26:
        Response r106 = r100.raw();     // Catch: Exception -> L43
        if (r106 == null) goto L30;
        String r107 = r106.getUrl();     // Catch: Exception -> L43
        if (r107 == null) goto L30;
    L31:
        List<Header> r108 = r100.headers();     // Catch: Exception -> L43
        ArrayList r109 = new ArrayList();     // Catch: Exception -> L43
        Iterator<Header> r110 = r108.iterator();     // Catch: Exception -> L43
    L33:
        if (r110.hasNext() == false) goto L35;
        Header r111 = r110.next();     // Catch: Exception -> L43
        r109.add(new NameValuePair(r111.getName(), r111.getValue()));     // Catch: Exception -> L43
        goto L33
    L35:
        HttpResponse r112 = new HttpResponse().setUrl(r107).setReason(r105).setStatusCode(r100.code()).setHeaders(r109).setBody(r103);     // Catch: Exception -> L43
        if ((r101 instanceof TypedInput) == false) goto L41;
        String r113 = ((TypedInput) r101).mimeType();     // Catch: Exception -> L43
        if (r113 == null) goto L41;
        r102 = r113;
    L41:
        return r112.setMimeType(r102);
    L30:
        r107 = "";
    L25:
        r105 = "";
        goto L26
    L14:
        if ((r101 instanceof TypedInput) == false) goto L20;
        InputStream r114 = ((TypedInput) r101).in();     // Catch: Exception -> L43
        if (r114 == null) goto L19;
        r103 = d.a(r114);     // Catch: Exception -> L43
        if (r103 != null) goto L21;
    L19:
        r103 = "".getBytes(Charsets.UTF_8);     // Catch: Exception -> L43
        goto L21
    L20:
        r103 = "".getBytes(Charsets.UTF_8);     // Catch: Exception -> L43
        goto L21
    L6:
        if (r100.errorBody() == null) goto L8;
        r101 = r100.errorBody();     // Catch: Exception -> L43
        goto L10
    L8:
        r101 = new TypedString("empty");     // Catch: Exception -> L43
    L43:
        e = move-exception;
        throw e;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.LiveCall
    public final void cancel() {
        this.f548266a.cancel();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.LiveCall
    public final /* bridge */ /* synthetic */ HttpResponse execute() {
        return a();
    }

    public c(Call<?> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        this.f548266a = r100;
    }
}
