package nsa;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f520430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f520431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f520432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f520433d;

    public b() {
        this.f520430a = new ArrayList();
        this.f520431b = false;
        this.f520432c = "";
        this.f520433d = 0;
    }

    public final void a(String r100) {
        if (this.f520430a.isEmpty() == false) goto L5;
        this.f520430a.add(r100);
        return;
    L5:
        ArrayList<String> r101 = this.f520430a;
        if (TextUtils.equals(r100, (CharSequence) ListProtector.get(r101, r101.size() - 1)) == true) goto L10;
        this.f520430a.add(r100);
        return;
    }
}
