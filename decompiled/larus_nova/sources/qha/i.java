package qha;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarHolderBinding;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarSkillHolderBinding;
import com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i extends BaseActionBarHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricItemPhoneOperationActionbarHolderBinding f533033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f533034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t1 f533035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f533036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObricActionBarSegmentCell f533037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObricItemCustomActionbarNormalHolderBinding f533038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f533039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObricItemPhoneOperationActionbarSkillHolderBinding f533040h;

    public static final class a {
    }

    static {
    }

    public final void U3(RoundConstraintLayout r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f533033a.f389599b.getChildAt(0) != r100) goto L7;
        return;
    L7:
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L10;
        ViewGroup r102 = (ViewGroup) r101;
    L11:
        if (r102 == null) goto L13;
        r102.removeView(r100);
    L13:
        this.f533033a.f389599b.removeAllViews();
        this.f533033a.f389599b.addView(r100);
        return;
    L10:
        r102 = null;
        goto L11
    }

    public i(ObricItemPhoneOperationActionbarHolderBinding r100, t1 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "defaultClickCallback");
        super(r100.f389598a);
        this.f533033a = r100;
        this.f533034b = LayoutInflater.from(r100.f389598a.getContext());
        this.f533035c = r101;
        this.f533036d = r102;
    }
}
