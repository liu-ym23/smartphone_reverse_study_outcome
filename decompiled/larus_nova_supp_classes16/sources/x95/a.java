package x95;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends FrameLayout {
    public final ConstraintLayout a;
    public final SpaceEmptyState b;

    /* JADX INFO: renamed from: x95.a$a, reason: collision with other inner class name */
    public static final class C0323a {
    }

    public static final class b implements h95.b {
        public final /* synthetic */ a a;

        @Override // h95.b
        public final void a() {
            this.a.getClass();
            ConstraintLayout.LayoutParams r0 = this.a.a.getLayoutParams();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            r0.verticalBias = 0.4f;
            this.a.b.setImageSizeResource(2131165486);
            this.a.b.getImageView().requestLayout();
            this.a.b.setTitleTextAppearance(2131953909);
        }

        @Override // h95.b
        public final void b() {
            this.a.getClass();
            ConstraintLayout.LayoutParams r0 = this.a.a.getLayoutParams();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            r0.verticalBias = 0.55f;
            this.a.b.setImageSizeResource(2131165487);
            this.a.b.getImageView().requestLayout();
            this.a.b.setTitleTextAppearance(2131953912);
        }

        public b(a r1) {
            this.a = r1;
        }
    }

    static {
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        LayoutInflater.from(r2).inflate(2131560212, this);
        this.a = findViewById(2131370293);
        this.b = findViewById(2131370254);
    }

    public final void setDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        SpaceEmptyState r0 = this.b;
        if (r0 == null) goto L6;
        r0.setDesc(r2);
        return;
    }

    public final void setImage(int r2) {
        this.b.setImageRes(Integer.valueOf(kac.a.b(r2)));
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        SpaceEmptyState r0 = this.b;
        if (r0 == null) goto L6;
        r0.setTitle(r2);
        return;
    }

    public final void a(ViewOwner r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "viewOwner");
        DriveBlockViewSwitchManager r0 = new DriveBlockViewSwitchManager(r3);
        if (r4 != null) goto L5;
    L7:
        r0.a(new b(this));
        return;
    L5:
        if (r4.intValue() != 2004) goto L7;
        this.b.setTitle(getContext().getString(2131889026));
        goto L7
    }
}
