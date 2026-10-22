package lz4;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f511366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WebView f511367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kz4.a f511368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VFSPath f511369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Boolean> f511370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f511371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f511372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f511373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CCMWatermarkManager f511374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f511375k;

    public a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f511374j = new CCMWatermarkManager();
        this.f511365a = r100.f511400a.getApplicationContext();
        this.f511366b = r100.f511400a;
        this.f511367c = r100.f511401b;
        this.f511368d = r100.f511404e;
        this.f511369e = r100.f511402c;
        this.f511370f = r100.f511403d;
        this.f511371g = r100.f511406g;
        this.f511372h = r100.f511407h;
        this.f511373i = r100.f511408i;
        this.f511375k = r100.f511405f;
    }
}
