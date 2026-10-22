package tla;

import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Object, HashMap<String, float[]>> f546676a;

    public d() {
        this.f546676a = new HashMap();
    }

    public final float a(Object r100, String r101) {
        if (this.f546676a.containsKey(r100) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap<String, float[]> r102 = this.f546676a.get(r100);
        if (r102 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r102.containsKey(r101) == false) goto L17;
        float[] r103 = r102.get(r101);
        if (r103 != null) goto L14;
        return Float.NaN;
    L14:
        if (r103.length <= 0) goto L17;
        return r103[0];
    }
}
