package lz4;

import android.app.Activity;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public final Activity a;
    public final WebView b;
    public final VFSPath c;
    public final MutableLiveData<Boolean> d;
    public final kz4.a e;
    public final boolean f;
    public int g;
    public int h;
    public int i;

    public n(FragmentActivity r2, WebView r3, VFSPath r4, MutableLiveData r5, jz4.i r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "targetActivity");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Intrinsics.checkNotNullParameter(r5, "isActive");
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
