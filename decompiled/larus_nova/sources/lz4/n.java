package lz4;

import android.app.Activity;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f511400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f511401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VFSPath f511402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f511403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kz4.a f511404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f511405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f511406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f511407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f511408i;

    public n(FragmentActivity r100, WebView r101, VFSPath r102, MutableLiveData r103, jz4.i r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "targetActivity");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        Intrinsics.checkNotNullParameter(r103, "isActive");
        Intrinsics.checkNotNullParameter(r104, "listener");
        this.f511400a = r100;
        this.f511401b = r101;
        this.f511402c = r102;
        this.f511403d = r103;
        this.f511404e = r104;
        this.f511405f = r105;
    }
}
