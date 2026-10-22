package x95;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f562979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpaceEmptyState f562980b;

    /* JADX INFO: renamed from: x95.a$a, reason: collision with other inner class name */
    public static final class C8206a {
    }

    public static final class b implements h95.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f562981a;

        @Override // h95.b
        public final void a() {
            this.f562981a.getClass();
            ViewGroup.LayoutParams r100 = this.f562981a.f562979a.getLayoutParams();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) r100).verticalBias = 0.4f;
            this.f562981a.f562980b.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
            this.f562981a.f562980b.getImageView().requestLayout();
            this.f562981a.f562980b.setTitleTextAppearance(R.style.UDText_Body1);
        }

        @Override // h95.b
        public final void b() {
            this.f562981a.getClass();
            ViewGroup.LayoutParams r100 = this.f562981a.f562979a.getLayoutParams();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) r100).verticalBias = 0.55f;
            this.f562981a.f562980b.setImageSizeResource(R.dimen.ccm_emptystate_image_size_small);
            this.f562981a.f562980b.getImageView().requestLayout();
            this.f562981a.f562980b.setTitleTextAppearance(R.style.UDText_Caption1);
        }

        public b(a r100) {
            this.f562981a = r100;
        }
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.drive_permission_view, this);
        this.f562979a = (ConstraintLayout) findViewById(R.id.drive_permission_container);
        this.f562980b = (SpaceEmptyState) findViewById(R.id.drive_content);
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        SpaceEmptyState r101 = this.f562980b;
        if (r101 == null) goto L6;
        r101.setDesc(r100);
        return;
    }

    public final void setImage(int r100) {
        this.f562980b.setImageRes(Integer.valueOf(kac.a.b(r100)));
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        SpaceEmptyState r101 = this.f562980b;
        if (r101 == null) goto L6;
        r101.setTitle(r100);
        return;
    }

    public final void a(ViewOwner r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "viewOwner");
        DriveBlockViewSwitchManager r102 = new DriveBlockViewSwitchManager(r100);
        if (r101 != null) goto L5;
    L7:
        r102.a(new b(this));
        return;
    L5:
        if (r101.intValue() != 2004) goto L7;
        this.f562980b.setTitle(getContext().getString(R.string.LarkCCM_Docs_DLP_OrgSecurityDetection_Desc));
        goto L7
    }
}
