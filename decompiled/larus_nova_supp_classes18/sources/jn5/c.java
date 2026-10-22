package jn5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetTabItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface c {

    public interface a extends jn5.a {
        void a(int r1, SheetTabItem r2, int r3);

        void b();

        void c();

        void f(boolean r1);
    }

    void a(boolean r1);

    void b(View r1);

    void c();

    void d(ArrayList<SheetTabItem> r1);

    void e(a r1);

    void f(boolean r1);

    void g();

    Context getContext();

    void h(boolean r1);

    void setDraggable(boolean r1);
}
