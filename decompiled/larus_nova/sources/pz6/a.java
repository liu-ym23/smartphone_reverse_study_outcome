package pz6;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import qz6.h;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<String> f531116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<h<String>, Typeface> f531117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Typeface> f531118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AssetManager f531119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f531120e;

    public a(Drawable.Callback r100) {
        this.f531116a = new h();
        this.f531117b = new HashMap();
        this.f531118c = new HashMap();
        this.f531120e = ".ttf";
        if ((r100 instanceof View) == true) goto L6;
        this.f531119d = null;
        return;
    L6:
        this.f531119d = ((View) r100).getContext().getAssets();
    }
}
