package l0;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.c;
import java.util.HashMap;
import java.util.Map;
import m0.h;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<String> f506832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<h<String>, Typeface> f506833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Typeface> f506834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AssetManager f506835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f506836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506837f;

    public a(Drawable.Callback r100, c r101) {
        this.f506832a = new h();
        this.f506833b = new HashMap();
        this.f506834c = new HashMap();
        this.f506837f = ".ttf";
        this.f506836e = r101;
        if ((r100 instanceof View) == true) goto L6;
        this.f506835d = null;
        return;
    L6:
        this.f506835d = ((View) r100).getContext().getAssets();
    }
}
