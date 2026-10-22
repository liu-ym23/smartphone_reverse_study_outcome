package qha;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.nova.R;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarSkillHolderBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l extends BaseActionBarHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricItemPhoneOperationActionbarSkillHolderBinding f533047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f533048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f533049c;

    public static final class a {
    }

    static {
    }

    public final void U3(boolean r100) {
        ViewGroup.LayoutParams r101 = this.f533047a.f389602c.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        if (r100 == false) goto L5;
        r102.startToEnd = -1;
        r102.startToStart = 0;
        r102.setMarginStart(this.itemView.getContext().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_20, this.itemView.getContext(), R.dimen.larus_dp_20)));
    L6:
        this.f533047a.f389602c.setLayoutParams(r102);
        return;
    L5:
        r102.startToEnd = -1;
        r102.startToStart = 0;
        r102.setMarginStart(0);
        goto L6
    }

    public l(ObricItemPhoneOperationActionbarSkillHolderBinding r100, t1 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "defaultClickCallback");
        super(r100.f389600a);
        this.f533047a = r100;
        this.f533048b = r101;
        this.f533049c = r102;
    }
}
