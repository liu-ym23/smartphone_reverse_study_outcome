package cz3;

import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.FadeImageView;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<jy3.c> implements d {
    public View g;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void G() {
        View r0 = this.g;
        if (r0 == null) goto L6;
        x54.b.d(r0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a, az3.a
    public final /* bridge */ /* synthetic */ void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r1) {
        F((com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c) r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void F(com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c r4) {
        Intrinsics.checkNotNullParameter(r4, "viewProvider");
        View r5 = r4.a(this.c);
        this.g = r5;
        if (r5 == null) goto L6;
        r5.setOnClickListener(new e(this));
    L6:
        if (this.a.e == true) goto L13;
        View r6 = this.g;
        if ((r6 instanceof FadeImageView) == false) goto L10;
        FadeImageView r7 = (FadeImageView) r6;
    L11:
        if (r7 == null) goto L13;
        r7.setImageResource(2131231637);
        DrawableCompat.setTint(r7.getDrawable(), ContextCompat.getColor(r7.getContext(), 2131100341));
        r7.setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L13
    L10:
        r7 = null;
    L13:
        View r8 = this.g;
        if (r8 == null) goto L17;
        x54.b.d(r8);
        return;
    }

    public f(ManagerContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "managerContext");
        Intrinsics.checkNotNullParameter(r3, "tag");
        super(r2, r3);
        H(d.class, this);
        r2.m = this;
    }
}
