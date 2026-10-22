package lt7;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.SkeletonAdapter;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f510678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter f510679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SkeletonAdapter f510680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f510681d;

    /* JADX INFO: renamed from: lt7.a$a, reason: collision with other inner class name */
    public static class C6735a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.Adapter f510682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView f510683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f510684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f510685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f510686e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f510687f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f510688g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f510689h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f510690i;

        public C6735a(RecyclerView r100) {
            this.f510684c = true;
            this.f510685d = 10;
            this.f510686e = R.layout.layout_default_item_skeleton;
            this.f510688g = 1000;
            this.f510689h = 20;
            this.f510690i = true;
            this.f510683b = r100;
            this.f510687f = ContextCompat.getColor(r100.getContext(), R.color.shimmer_color);
        }
    }

    public final void a() {
        this.f510678a.setAdapter(this.f510679b);
    }

    public final void b() {
        this.f510678a.setAdapter(this.f510680c);
        if (this.f510678a.isComputingLayout() == false) goto L5;
        return;
    L5:
        if (this.f510681d == false) goto L9;
        this.f510678a.setLayoutFrozen(true);
        return;
    }

    public a(C6735a r100) {
        this.f510678a = r100.f510683b;
        this.f510679b = r100.f510682a;
        SkeletonAdapter r101 = new SkeletonAdapter();
        this.f510680c = r101;
        r101.f274012a = r100.f510685d;
        r101.f274013b = r100.f510686e;
        r101.f274015d = r100.f510684c;
        r101.f274014c = r100.f510687f;
        r101.f274017f = r100.f510689h;
        r101.f274016e = r100.f510688g;
        this.f510681d = r100.f510690i;
    }
}
