package iz4;

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
    public final Context f496630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f496631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WebView f496632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hz4.a f496633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VFSPath f496634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Boolean> f496635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f496636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f496637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f496638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CCMWatermarkManager f496639j;

    public a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f496639j = new CCMWatermarkManager();
        this.f496630a = r100.f496664a.getApplicationContext();
        this.f496631b = r100.f496664a;
        this.f496632c = r100.f496665b;
        this.f496633d = r100.f496668e;
        this.f496634e = r100.f496666c;
        this.f496635f = r100.f496667d;
        this.f496636g = r100.f496669f;
        this.f496637h = r100.f496670g;
        this.f496638i = r100.f496671h;
    }
}
