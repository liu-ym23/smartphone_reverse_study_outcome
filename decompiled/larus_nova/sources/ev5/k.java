package ev5;

import android.util.LruCache;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, Pattern> f474256c;

    public k() {
        super("is_match_with");
        this.f474256c = new LruCache(30);
    }

    @Override // ev5.q
    public final boolean b(String r100, String r101, boolean r102) {
        Pattern r103 = this.f474256c.get(r101);
        if (r103 != null) goto L6;
        r103 = PatternProtector.compile(r101);
        this.f474256c.put(r101, r103);
    L6:
        return r103.matcher(r100).find();
    }
}
