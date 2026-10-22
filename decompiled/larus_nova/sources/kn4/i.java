package kn4;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements l.b {

    public class a implements l.c {
        public a() {
        }

        @Override // kn4.l.c
        public final String getDocumentDefaultName(Context r100, int r101) {
            tt5.a.h("DefaultAtExtraDependency", "getDocumentDefaultName ignore");
            return r100.getResources().getString(R.string.Doc_Facade_UntitledDocument);
        }
    }

    public class b implements l.a {
        public b() {
        }

        @Override // kn4.l.a
        public final Drawable a(Context r100, String r101, String r102, int r103) {
            tt5.a.h("DefaultAtExtraDependency", "loadDrawable ignore");
            return new ColorDrawable();
        }
    }

    public i() {
    }

    @Override // kn4.l.b
    public final l.a b() {
        return new b();
    }

    @Override // kn4.l.b
    public final l.c c() {
        return new a();
    }

    @Override // kn4.l.b
    public final void a(FrameLayout r100) {
        tt5.a.h("DefaultAtExtraDependency", "updateWatermarkForDialog ignore");
    }
}
