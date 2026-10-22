package wbb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;

/* JADX INFO: loaded from: classes35.dex */
public interface d {

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OnUpdateProgressListener f559032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IGetDataCallback<T> f559033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f559034c;

        public a(OnUpdateProgressListener r100, IGetDataCallback<T> r101, String r102) {
            this.f559032a = r100;
            this.f559033b = r101;
            this.f559034c = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f559035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f559036b;

        public b(String r100, boolean r101) {
            this.f559035a = r100;
            this.f559036b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f559037a;

        public c(boolean r100) {
            this.f559037a = r100;
        }
    }
}
