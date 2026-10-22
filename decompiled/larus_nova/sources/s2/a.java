package s2;

import com.bytedance.ai.widget.cache.b;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateBundle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import q2.c;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f540206e;

    @Override // q2.c, w2.d
    public final Object a(String r100, Continuation<? super TemplateBundle> r101) {
        UriProtector.getQueryParameter(UriProtector.parse(r100), "forest_session_id");
        return this.f540206e.c(r101);
    }

    public a(b r100, String r101, boolean r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        super(r101, r102, r103, r104);
        this.f540206e = r100;
    }
}
