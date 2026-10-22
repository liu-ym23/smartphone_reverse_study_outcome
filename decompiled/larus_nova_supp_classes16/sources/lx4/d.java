package lx4;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final h a;
    public int b;
    public final ArrayList<Document> c;
    public String d;
    public String e;
    public String f;
    public boolean g;

    public d(h r2) {
        Intrinsics.checkNotNullParameter(r2, "mView");
        this.a = r2;
        this.c = new ArrayList();
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = true;
    }

    public final void a(int r5) {
        View r0 = this.a.c;
        Intrinsics.checkNotNull(r0);
        ((TextView) r0.findViewById(2131389261)).setText("总共" + this.c.size() + "篇文档");
        View r1 = this.a.c;
        Intrinsics.checkNotNull(r1);
        ((TextView) r1.findViewById(2131383766)).setText("已经打开过" + r5 + "篇文档");
        this.b = r5;
    }
}
