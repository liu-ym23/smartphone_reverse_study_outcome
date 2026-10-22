package lx4;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.list.dto.Document;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f511176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f511177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Document> f511178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f511179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f511180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f511181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f511182g;

    public d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "mView");
        this.f511176a = r100;
        this.f511178c = new ArrayList();
        this.f511179d = "";
        this.f511180e = "";
        this.f511181f = "";
        this.f511182g = true;
    }

    public final void a(int r100) {
        View r101 = this.f511176a.f511186c;
        Intrinsics.checkNotNull(r101);
        ((TextView) r101.findViewById(R.id.total)).setText("总共" + this.f511178c.size() + "篇文档");
        View r102 = this.f511176a.f511186c;
        Intrinsics.checkNotNull(r102);
        ((TextView) r102.findViewById(R.id.readed)).setText("已经打开过" + r100 + "篇文档");
        this.f511177b = r100;
    }
}
