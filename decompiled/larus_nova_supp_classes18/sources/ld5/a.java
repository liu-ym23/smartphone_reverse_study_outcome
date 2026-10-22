package ld5;

import androidx.lifecycle.MutableLiveData;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Queue<Object> a = null;
    public static final MutableLiveData<Object> b = null;
    public static final MutableLiveData<Boolean> c = null;
    public static final MutableLiveData<Boolean> d = null;

    public a() {
    }

    static {
        a = new LinkedList();
        b = new MutableLiveData();
        c = new MutableLiveData();
        d = new MutableLiveData();
    }

    public static void a() {
        tt5.a.h("SpaceGuideManager", "destroy()...");
        ((LinkedList) a).clear();
        b.setValue(null);
        MutableLiveData<Boolean> r0 = c;
        Boolean r1 = Boolean.FALSE;
        r0.setValue(r1);
        d.setValue(r1);
    }
}
