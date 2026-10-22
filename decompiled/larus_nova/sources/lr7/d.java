package lr7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.textra.JavaFontManager;
import com.lynx.textra.TTText;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import kr7.t;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f510434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, Integer> f510435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JavaFontManager f510436c;

    public d() {
        ArrayList<c> r100 = new ArrayList();
        this.f510434a = r100;
        r100.add(null);
        this.f510435b = new Hashtable();
        this.f510436c = TTText.mFontManager;
    }

    public final int a(t r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Integer r101 = (Integer) ((Hashtable) this.f510435b).get(r100);
        if (r101 != null) goto L8;
        int r102 = -1;
    L9:
        if (r102 == (-1)) goto L11;
        return r102;
    L11:
        this.f510434a.add(r100);
        int r103 = this.f510434a.size() - 1;
        ((Hashtable) this.f510435b).put(r100, Integer.valueOf(r103));
        return r103;
    L8:
        r102 = r101.intValue();
        goto L9
    }

    public final c b(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.f510434a.size()) goto L7;
        return null;
    L7:
        return (c) ListProtector.get(this.f510434a, r100);
    }
}
