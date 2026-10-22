package ls2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes11.dex */
public class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f510496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f510497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f510498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f510499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f510500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f510501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f510502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Activity f510503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f510504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f510505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f510506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f510507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f510508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f510509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f510510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f510511r;

    public b() {
        this.f510496c = 0L;
        this.f510507n = -1L;
        this.f510508o = Long.valueOf(System.currentTimeMillis());
        this.f510509p = 0L;
        this.f510510q = new Handler(Looper.getMainLooper());
        this.f510511r = String.valueOf(hashCode());
    }

    public final Activity getActivity() {
        return this.f510503j;
    }

    public final Context getContext() {
        return this.f510504k;
    }
}
