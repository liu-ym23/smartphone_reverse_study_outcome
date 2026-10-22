package zab;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.desktopmode.base.FragmentParams;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final <T extends FragmentParams> void a(DesktopCompatFragment<T> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        g r101 = f.b(r100);
        if (r101 == null) goto L7;
        r101.g(null);
        return;
    L7:
        r100.finish();
    }

    public static final <T extends FragmentParams> void b(DesktopCompatFragment<T> r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r102, "result");
        if (r100 != null) goto L5;
        return;
    L5:
        g r103 = f.b(r100);
        if (r103 == null) goto L8;
        r103.c(r101, r102);
        return;
    L8:
        FragmentActivity r104 = r100.getActivity();
        if (r104 == null) goto L11;
        Intent r105 = new Intent();
        r105.putExtras(r102);
        Unit r106 = Unit.INSTANCE;
        r104.setResult(r101, r105);
    L11:
        r100.finish();
    }
}
