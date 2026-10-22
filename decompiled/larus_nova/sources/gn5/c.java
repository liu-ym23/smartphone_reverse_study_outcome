package gn5;

import android.app.Activity;
import android.graphics.Point;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import iu5.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Point f481805e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f481806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f481807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f481808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f481809d;

    public static final class a {
    }

    static {
    }

    public c(FragmentActivity r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "keywords");
        this.f481806a = r100;
        ArrayList r102 = new ArrayList();
        this.f481807b = r102;
        this.f481809d = new CopyOnWriteArrayList();
        r102.addAll(r101);
        f.a(new b(this));
    }
}
