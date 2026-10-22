package cz3;

import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.FadeImageView;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<jy3.c> implements d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f466023g;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void G() {
        View r100 = this.f466023g;
        if (r100 == null) goto L6;
        x54.b.d(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a, az3.a
    public final /* bridge */ /* synthetic */ void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r100) {
        F((com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c) r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void F(com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        View r101 = r100.a(this.f194420c);
        this.f466023g = r101;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new e(this));
    L6:
        if (this.f16804a.f561867e == true) goto L13;
        View r102 = this.f466023g;
        if ((r102 instanceof FadeImageView) == false) goto L10;
        FadeImageView r103 = (FadeImageView) r102;
    L11:
        if (r103 == null) goto L13;
        r103.setImageResource(R.drawable.aos_write_comment_emoji);
        DrawableCompat.setTint(r103.getDrawable(), ContextCompat.getColor(r103.getContext(), R.color.aos_text_reverse2));
        r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L13
    L10:
        r103 = null;
    L13:
        View r104 = this.f466023g;
        if (r104 == null) goto L17;
        x54.b.d(r104);
        return;
    }

    public f(ManagerContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "managerContext");
        Intrinsics.checkNotNullParameter(r101, "tag");
        super(r100, r101);
        H(d.class, this);
        r100.f194415m = this;
    }
}
