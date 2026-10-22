package mh2;

import android.graphics.Bitmap;
import android.widget.TextView;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f513903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f513904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f513905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f513906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextView f513907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f513908f;

    public e(List r100, String r101, float r102, float r103, TextView r104, boolean r105) {
        this.f513903a = r100;
        this.f513904b = r101;
        this.f513905c = r102;
        this.f513906d = r103;
        this.f513907e = r104;
        this.f513908f = r105;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        HashMap<String, WeakReference<Bitmap>> r102 = q.f513935a;
        q.c(this.f513903a, this.f513904b, this.f513905c, this.f513906d, this.f513907e, this.f513908f);
    }
}
