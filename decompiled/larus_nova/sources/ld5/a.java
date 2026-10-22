package ld5;

import androidx.lifecycle.MutableLiveData;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Queue<Object> f508692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Object> f508693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f508694c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f508695d = null;

    public a() {
    }

    static {
        f508692a = new LinkedList();
        f508693b = new MutableLiveData();
        f508694c = new MutableLiveData();
        f508695d = new MutableLiveData();
    }

    public static void a() {
        tt5.a.h("SpaceGuideManager", "destroy()...");
        ((LinkedList) f508692a).clear();
        f508693b.setValue(null);
        MutableLiveData<Boolean> r100 = f508694c;
        Boolean r101 = Boolean.FALSE;
        r100.setValue(r101);
        f508695d.setValue(r101);
    }
}
