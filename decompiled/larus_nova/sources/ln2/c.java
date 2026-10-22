package ln2;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements ln2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f509995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f509996b;

    public interface a {
        boolean a();

        boolean b();
    }

    public class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f509997a;

        @Override // ln2.c.a
        public final boolean a() {
            return !this.f509997a.f509995a.canScrollHorizontally(-1);
        }

        @Override // ln2.c.a
        public final boolean b() {
            return !this.f509997a.f509995a.canScrollHorizontally(1);
        }

        public b(c r100) {
            this.f509997a = r100;
        }
    }

    /* JADX INFO: renamed from: ln2.c$c, reason: collision with other inner class name */
    public class C6717c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f509998a;

        @Override // ln2.c.a
        public final boolean a() {
            return !this.f509998a.f509995a.canScrollVertically(-1);
        }

        @Override // ln2.c.a
        public final boolean b() {
            return !this.f509998a.f509995a.canScrollVertically(1);
        }

        public C6717c(c r100) {
            this.f509998a = r100;
        }
    }

    @Override // ln2.b
    public final boolean a() {
        if (this.f509996b.a() == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ln2.b
    public final boolean b() {
        if (this.f509996b.b() == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ln2.b
    public final View getView() {
        return this.f509995a;
    }

    public c(RecyclerView r100) {
        this.f509995a = r100;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        boolean r102 = r101 instanceof LinearLayoutManager;
        if (r102 == false) goto L5;
    L9:
        if (r102 == false) goto L11;
        int r103 = ((LinearLayoutManager) r101).getOrientation();
    L12:
        if (r103 != 0) goto L14;
        this.f509996b = new b(this);
        return;
    L14:
        this.f509996b = new C6717c(this);
        return;
    L11:
        r103 = ((StaggeredGridLayoutManager) r101).getOrientation();
        goto L12
    L5:
        if ((r101 instanceof StaggeredGridLayoutManager) == true) goto L9;
        throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
    }
}
