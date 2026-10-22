package n35;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f516962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f516963b;

    public n(m r100, m0 r101) {
        this.f516962a = r100;
        this.f516963b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        tt5.a.h(this.f516962a.f516956b, "docResourceDataSaveSuccess");
        m0 r102 = this.f516963b;
        String r103 = r102.f501550k;
        this.f516962a.getClass();
        String r104 = r102.f501541b;
        boolean r105 = false;
        if (TextUtils.isEmpty(r104) == false) goto L5;
    L9:
        if (r105 == false) goto L16;
        tt5.a.h(this.f516962a.f516956b, du5.b.g(r103) + " setDocDataCached");
        List<r> r106 = l.f516953a;
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNullParameter(r103, "objToken");
        Iterator r107 = ((ArrayList) l.f516953a).iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        ((r) r107.next()).j(r103);
        goto L12
    L14:
        a05.d.a(r103, "client_vars_size", String.valueOf(this.f516963b.f501542c.length()));
    L16:
        if (lbb.a.a(r103) == false) goto L20;
        tt5.a.h(this.f516962a.f516956b, du5.b.g(r103) + HttpClient.ENDFLAG + this.f516963b.f501541b);
        return;
    L20:
        return;
    L5:
        if (StringsKt.contains$default(r104, "CLIENT_VARS", false, 2, null) == false) goto L9;
        if (TextUtils.isEmpty(r102.f501542c) == true) goto L9;
        r105 = true;
        goto L9
    }
}
