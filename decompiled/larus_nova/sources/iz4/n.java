package iz4;

import android.app.Activity;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f496664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f496665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VFSPath f496666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f496667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hz4.a f496668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f496669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f496670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f496671h;

    public n(FragmentActivity r100, WebView r101, VFSPath r102, MutableLiveData r103, fz4.x r104) {
        Intrinsics.checkNotNullParameter(r100, "targetActivity");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        Intrinsics.checkNotNullParameter(r103, "isActive");
        Intrinsics.checkNotNullParameter(r104, "listener");
        this.f496664a = r100;
        this.f496665b = r101;
        this.f496666c = r102;
        this.f496667d = r103;
        this.f496668e = r104;
    }
}
