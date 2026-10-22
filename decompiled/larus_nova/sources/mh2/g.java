package mh2;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes10.dex */
public final class g<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f513911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f513912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f513913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f513914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextView f513915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f513916f;

    public g(List r100, String r101, float r102, float r103, TextView r104, boolean r105) {
        this.f513911a = r100;
        this.f513912b = r101;
        this.f513913c = r102;
        this.f513914d = r103;
        this.f513915e = r104;
        this.f513916f = r105;
    }

    @Override // java.util.concurrent.Callable
    public final SpannableStringBuilder call() {
        HashMap<String, WeakReference<Bitmap>> r100 = q.f513935a;
        return q.c(this.f513911a, this.f513912b, this.f513913c, this.f513914d, this.f513915e, this.f513916f);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
