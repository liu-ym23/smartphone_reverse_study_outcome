package oc5;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final MutableLiveData<Boolean> a;

    public static class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public d() {
        this.a = new MutableLiveData(Boolean.FALSE);
        ((ue5.a) org.koin.java.a.a(ue5.a.class)).b(new oc5.a(this));
    }
}
