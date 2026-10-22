package com.lynx.markdown;

import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.textra.JavaFontManager;
import com.lynx.textra.TTText;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Drawable> f381436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, Integer> f381437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JavaFontManager f381438c;

    public h() {
        ArrayList<Drawable> r100 = new ArrayList();
        this.f381436a = r100;
        r100.add(null);
        this.f381437b = new Hashtable();
        this.f381438c = TTText.mFontManager;
    }

    public final Drawable a(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.f381436a.size()) goto L7;
        return null;
    L7:
        return (Drawable) ListProtector.get(this.f381436a, r100);
    }
}
