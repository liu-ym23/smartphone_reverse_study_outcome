package suc;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes42.dex */
public final class b implements suc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f543612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f543613b;

    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: renamed from: suc.b$b, reason: collision with other inner class name */
    public class C7659b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543614a;

        @Override // suc.b.a
        public final boolean a() {
            return !this.f543614a.f543612a.canScrollHorizontally(-1);
        }

        @Override // suc.b.a
        public final boolean b() {
            return !this.f543614a.f543612a.canScrollHorizontally(1);
        }

        public C7659b(b r100) {
            this.f543614a = r100;
        }
    }

    public class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543615a;

        @Override // suc.b.a
        public final boolean a() {
            return !this.f543615a.f543612a.canScrollVertically(-1);
        }

        @Override // suc.b.a
        public final boolean b() {
            return !this.f543615a.f543612a.canScrollVertically(1);
        }

        public c(b r100) {
            this.f543615a = r100;
        }
    }

    @Override // suc.a
    public final boolean a() {
        if (this.f543613b.a() == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // suc.a
    public final boolean b() {
        if (this.f543613b.b() == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // suc.a
    public final View getView() {
        return this.f543612a;
    }

    public b(RecyclerView r100) {
        this.f543612a = r100;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        boolean r102 = r101 instanceof LinearLayoutManager;
        if (r102 == false) goto L5;
    L9:
        if (r102 == false) goto L11;
        int r103 = ((LinearLayoutManager) r101).getOrientation();
    L12:
        if (r103 != 0) goto L14;
        this.f543613b = new C7659b(this);
        return;
    L14:
        this.f543613b = new c(this);
        return;
    L11:
        r103 = ((StaggeredGridLayoutManager) r101).getOrientation();
        goto L12
    L5:
        if ((r101 instanceof StaggeredGridLayoutManager) == true) goto L9;
        throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
    }
}
