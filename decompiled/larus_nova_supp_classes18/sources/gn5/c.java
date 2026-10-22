package gn5;

import android.app.Activity;
import android.graphics.Point;
import androidx.fragment.app.FragmentActivity;
import iu5.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static Point e;
    public final Activity a;
    public final List<String> b;
    public long c;
    public final List<String> d;

    public static final class a {
    }

    static {
    }

    public c(FragmentActivity r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "keywords");
        this.a = r2;
        ArrayList r4 = new ArrayList();
        this.b = r4;
        this.d = new CopyOnWriteArrayList();
        r4.addAll(r3);
        f.a(new b(this));
    }
}
