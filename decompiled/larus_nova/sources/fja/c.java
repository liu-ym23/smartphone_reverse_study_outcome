package fja;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f477520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f477521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RunMode f477522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RepeatMode f477523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends bja.a<?>> f477524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<View> f477525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f477526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f477527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f477528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f477529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f477530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f477531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f477532m;

    public c() {
        this.f477521b = 60.0f;
        this.f477522c = RunMode.PARALLEL;
        this.f477523d = RepeatMode.NORMAL;
        this.f477524e = CollectionsKt.emptyList();
        this.f477527h = -1;
        this.f477528i = 1.0f;
        this.f477531l = true;
    }

    public final void a(boolean r100) {
        WeakReference<View> r101 = this.f477525f;
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        Iterator<T> r102 = this.f477524e.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        bja.a r103 = (bja.a) r102.next();
        r103.f19257d = false;
        if (r100 == false) goto L11;
        float r104 = 0.0f;
    L12:
        r103.f19264k = r104;
        r103.f19255b = -1;
        r103.f19256c = -1;
        goto L7
    L11:
        r104 = r103.f19264k;
        goto L12
    L13:
        this.f477526g = 0;
        this.f477527h = -1;
        this.f477528i = 1.0f;
        this.f477529j = 0;
        this.f477530k = 0;
    }
}
