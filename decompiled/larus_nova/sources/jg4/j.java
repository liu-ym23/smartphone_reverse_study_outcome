package jg4;

import android.graphics.Rect;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class j implements d, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f498985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f498986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<com.bytedance.component.lyric.model.b> f498987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f498988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.component.lyric.model.b> f498989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f498990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Float> f498991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Rect> f498992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Rect> f498993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f498994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f498995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f498996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LyricsDisplayConfig f498997m;

    public final boolean a() {
        a r100 = this.f498990f;
        if (r100 == null) goto L5;
        float r101 = r100.f498983f;
    L6:
        if (r100 != null) goto L8;
    L12:
        return false;
    L8:
        if (r100.f498980c != (this.f498989e.size() - 1)) goto L12;
        if (r101 < 1.0f) goto L12;
        return true;
    L5:
        r101 = 0.0f;
        goto L6
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append(super.toString());
        r100.append("\n");
        r100.append(this.f498994j);
        r100.append("\n");
        r100.append(this.f498995k);
        r100.append("\n");
        r100.append(this.f498996l);
        r100.append("\n\nsize:");
        List<com.bytedance.component.lyric.model.b> r101 = this.f498987c;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append("\n\ndrawNode:");
        r100.append(this.f498990f);
        r100.append("\nsize:");
        r100.append(this.f498989e.size());
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public void b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
    }

    public final boolean c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (Intrinsics.areEqual(this.f498994j, r100.f498994j) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f498988d != r100.f498988d) goto L11;
        if (Intrinsics.areEqual(this.f498996l, r100.f498996l) == false) goto L11;
        if (Intrinsics.areEqual(this.f498995k, r100.f498995k) == false) goto L11;
        return true;
    }

    public void d(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
    }

    @Override // jg4.d
    public final void e(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
    }

    @Override // jg4.d
    public final void g(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r100, "request");
    }

    public void i(j r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
    }

    @Override // jg4.d
    public void h(j r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
    }

    public j(String r100, String r101, String r102, LyricsDisplayConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "config");
        this.f498994j = r100;
        this.f498995k = r101;
        this.f498996l = r102;
        this.f498997m = r103;
        this.f498985a = new CompositeDisposable();
        this.f498988d = 3;
        this.f498989e = new CopyOnWriteArrayList();
        this.f498991g = new LinkedHashMap();
        this.f498992h = new LinkedHashMap();
        this.f498993i = new LinkedHashMap();
    }
}
