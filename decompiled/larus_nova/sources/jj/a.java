package jj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.window.shop.home.presenter.r0;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public interface a {

    /* JADX INFO: renamed from: jj.a$a, reason: collision with other inner class name */
    public static final class C6443a {
        public static void a(a r100, String r101, Activity r102) {
            Intrinsics.checkNotNullParameter(r102, "fromAct");
            if (r101 != null) goto L6;
            return;
        L6:
            if (StringsKt.startsWith$default(r101, "http", false, 2, null) == false) goto L8;
            b(r100, r101, r102, null, 28);
            return;
        L8:
            r100.openSchema(r102, r101);
        }

        public static /* synthetic */ void b(a r100, String r101, Activity r102, String r103, int r110) {
            if ((r110 & 4) == 0) goto L5;
            r103 = "";
        L5:
            String r104 = r103;
            if ((r110 & 16) == 0) goto L8;
            boolean r105 = true;
        L9:
            r100.e(r101, r102, r104, false, r105);
            return;
        L8:
            r105 = false;
            goto L9
        }
    }

    void a(Context r100, String r101, Bundle r102);

    @Deprecated(message = "only for dy")
    void b(Activity r100);

    void c(Activity r100);

    void d(String r100, Activity r101);

    void e(String r100, Activity r101, String r102, boolean r103, boolean r104);

    void f(Context r100, String r101, r0.a r102);

    void openSchema(Context r100, String r101);
}
