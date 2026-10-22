package j7c;

import android.view.View;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;

/* JADX INFO: loaded from: classes38.dex */
public abstract class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f497664a = null;

        static {
            int[] r100 = new int[PageLoadingStatus.values().length];
            r100[PageLoadingStatus.LOADING_NEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PageLoadingStatus.LOADING_NEXT_FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PageLoadingStatus.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f497664a = r100;
        }
    }

    public e() {
    }

    public static void a(View r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 0;
    L5:
        r100.setVisibility(r102);
        return;
    L4:
        r102 = 8;
        goto L5
    }
}
