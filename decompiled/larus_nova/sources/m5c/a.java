package m5c;

import androidx.lifecycle.MutableLiveData;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f512249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f512250b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<j5c.a> f512251c = null;

    static {
        MutableLiveData<Boolean> r100 = new MutableLiveData(Boolean.FALSE);
        f512249a = r100;
        f512250b = r100;
        new MutableLiveData();
        f512251c = new LinkedHashSet();
    }

    public static void a(boolean r100) {
        f512249a.setValue(Boolean.valueOf(r100));
        Iterator<T> r101 = f512251c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((j5c.a) r101.next()).a();
        goto L4
    }
}
