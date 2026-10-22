package d8a;

import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes32.dex */
public abstract class b {

    public interface a {
        void onFailed(String r100);

        void onSuccess(byte[] r100);
    }

    public b() {
    }

    public abstract void loadTemplate(String r100, a r101);

    public void loadTemplate(String r100, a r101, LynxContext r102) {
        loadTemplate(r100, r101);
    }
}
