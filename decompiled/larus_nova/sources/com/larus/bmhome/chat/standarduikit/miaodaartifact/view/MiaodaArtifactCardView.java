package com.larus.bmhome.chat.standarduikit.miaodaartifact.view;

import android.content.Context;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.mainbot.impl.databinding.LarusCodeArtifactBlockItemFileBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import h19.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nm8.a;
import nm8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/view/MiaodaArtifactCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/view/MiaodaArtifactCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/view/MiaodaArtifactCardViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusCodeArtifactBlockItemFileBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusCodeArtifactBlockItemFileBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiaodaArtifactCardView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f309526b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309527a;

    private final LarusCodeArtifactBlockItemFileBinding getBinding() {
        return (LarusCodeArtifactBlockItemFileBinding) this.f309527a.getValue();
    }

    public MiaodaArtifactCardView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f309527a = LazyKt.lazy(new a(r100, this));
        setBackgroundResource(R.drawable.larus_bg_gaokao_8_radius);
    }

    public final void R5(c r100, final om8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        Integer r102 = r100.f519605b;
        if (r102 == null) goto L5;
        setBackgroundResource(r102.intValue());
    L5:
        ImageView r103 = getBinding().f358543b;
        b r104 = b.f483542a;
        CommonFileIconType r105 = CommonFileIconType.MIAODA;
        r104.getClass();
        r103.setImageResource(b.a(r105));
        getBinding().f358544c.setText(r100.f519604a);
        e1.d(getBinding().f358542a, new nm8.b(r101));
        r101.b();
    }
}
