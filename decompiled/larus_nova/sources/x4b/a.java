package x4b;

import com.larksuite.framework.utils.CollectionUtils;
import f5b.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class a<T extends f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f562457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f562458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f562459c;

    public a() {
        this.f562457a = new ArrayList();
        this.f562458b = new ArrayList();
        this.f562459c = new ArrayList();
    }

    public a(List<T> r100, List<Integer> r101, List<Integer> r102) {
        ArrayList r103 = new ArrayList();
        this.f562457a = r103;
        ArrayList r104 = new ArrayList();
        this.f562458b = r104;
        ArrayList r105 = new ArrayList();
        this.f562459c = r105;
        CollectionUtils.resetToList(r103, r100);
        CollectionUtils.resetToList(r104, r101);
        CollectionUtils.resetToList(r105, r102);
    }
}
