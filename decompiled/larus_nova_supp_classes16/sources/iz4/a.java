package iz4;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements b {
    public final Context a;
    public final Activity b;
    public final WebView c;
    public final hz4.a d;
    public final VFSPath e;
    public final MutableLiveData<Boolean> f;
    public final int g;
    public final int h;
    public final int i;
    public final CCMWatermarkManager j;

    public a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.j = new CCMWatermarkManager();
        this.a = r2.a.getApplicationContext();
        this.b = r2.a;
        this.c = r2.b;
        this.d = r2.e;
        this.e = r2.c;
        this.f = r2.d;
        this.g = r2.f;
        this.h = r2.g;
        this.i = r2.h;
    }
}
