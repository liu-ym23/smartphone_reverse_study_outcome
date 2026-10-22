package o5a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends o5a.a {

    public class a implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f522133a;

        public a(e r100) {
            this.f522133a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 == 6) goto L15;
            if (r101 == 2) goto L15;
            if (r101 == 3) goto L15;
            if (r101 == 4) goto L15;
            if (r101 == 5) goto L15;
            if (r101 == 0) goto L15;
            return false;
        L15:
            if (this.f522133a.c("confirm") == false) goto L17;
            HashMap r103 = new HashMap();
            r103.put("value", this.f522133a.f522108h.getText().toString());
            this.f522133a.q("confirm", r103);
        L17:
            if (r101 == 5) goto L20;
            this.f522133a.w(false);
            return true;
        L20:
            return false;
        }
    }

    public class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f522134a;

        @Override // o5a.d.a
        public final void a() {
            this.f522134a.e();
        }

        public b(e r100) {
            this.f522134a = r100;
        }
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final View a(Context r100) {
        super.a(r100);
        this.f522108h.setOnEditorActionListener(new a(this));
        this.f522108h.setOnAfterDrawListener(new b(this));
        this.f522108h.setOnTouchListener(null);
        this.f522108h.setImeOptions(6);
        this.f522108h.setLines(1);
        this.f522108h.setSingleLine(true);
        this.f522108h.setHorizontallyScrolling(true);
        return this.f522108h;
    }

    public e(Context r100, int r101, String r102) {
        super(r100, r101, r102);
    }
}
