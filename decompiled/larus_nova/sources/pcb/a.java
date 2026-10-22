package pcb;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.SparseArray;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public interface a {

    /* JADX INFO: renamed from: pcb.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC7181a {
        public AbstractC7181a() {
        }

        public abstract b a(Activity r100);

        public static a b(Activity r100) {
            SparseArray<AbstractC7181a> r101 = ocb.b.f522788a;
            int r102 = r100.hashCode();
            SparseArray<a> r103 = ocb.b.f522789b;
            a r104 = r103.get(r102);
            if (r104 != null) goto L8;
            AbstractC7181a r105 = ocb.b.f522788a.get(r100.hashCode());
            if (r105 != null) goto L7;
            r105 = new ocb.b();
        L7:
            r104 = r105.a(r100);
            Log.i("InsetsBseKBH#Provider", "cache " + r100.getClass().getName() + r100.hashCode() + " to keyboardHeightProviders");
            r103.put(r100.hashCode(), r104);
        L8:
            r104.restart();
            return r104;
        }
    }

    void a(ocb.a r100);

    void b(ocb.a r100);

    void c(ocb.a r100);

    void d(ocb.a r100);

    int getKeyboardTop();

    int getVisibleKeyboardHeight();

    boolean isKeyboardShowing();

    int keyBoardRawHeight();

    int keyBoardRawHeightWithOrientation(int r100);

    void onConfigurationChanged(Configuration r100, boolean r101);

    void restart();

    void setDelayedDuration(Long r100);
}
