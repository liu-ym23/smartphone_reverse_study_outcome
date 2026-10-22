package oi0;

import com.bytedance.android.livesdkapi.model.SeiAppData;

/* JADX INFO: loaded from: classes46.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7057a f523343a = null;

    /* JADX INFO: renamed from: oi0.a$a, reason: collision with other inner class name */
    public static final class C7057a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C7057a f523344a = null;

        public C7057a() {
        }

        static {
            f523344a = new C7057a();
        }
    }

    static {
        f523343a = C7057a.f523344a;
    }

    void onCreate();

    void onDestroy();

    void onSeiUpdated(SeiAppData r100);

    void w0(boolean r100);
}
