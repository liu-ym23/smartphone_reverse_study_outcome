package em5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a<T> extends cpc.a {
    public final String e;
    public ArrayList<T> f;

    public boolean a() {
        if (this.f.size() >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int b() {
        return this.f.size();
    }

    public final void c() {
        this.f.clear();
        d(this.e);
        ((ArrayList) ((cpc.a) this).c).clear();
    }

    public final void e(ArrayList<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedItems");
        this.f = r2;
        if (r2.isEmpty() == false) goto L6;
        c();
        return;
    }

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "defaultStr");
        super(r2);
        this.e = r3;
        this.f = new ArrayList();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        ((cpc.a) this).b = r3;
        ((cpc.a) this).d = true;
    }
}
