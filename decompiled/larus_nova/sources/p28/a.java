package p28;

import android.view.View;
import com.larksuite.framework.ui.flowlayout.FlowLayout;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f527464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f527465b;

    public abstract View a(FlowLayout r100, Object r101);

    public a(List<T> r100) {
        this.f527465b = new HashSet();
        this.f527464a = r100;
    }
}
