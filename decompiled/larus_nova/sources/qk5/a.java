package qk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements gk5.c {

    /* JADX INFO: renamed from: qk5.a$a, reason: collision with other inner class name */
    public static final class C7351a {
    }

    static {
    }

    public a() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r100, JSONObject r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        PhoneHelper.a(r100, new b(r102));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        nk5.b.c(r102, th);
    }
}
