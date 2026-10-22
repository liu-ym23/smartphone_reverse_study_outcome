package rn9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.office.card.databinding.LarusCardBitableBinding;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f538714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f538715b;

    public static final class a {
    }

    static {
    }

    private final LarusCardBitableBinding getBinding() {
        return (LarusCardBitableBinding) this.f538714a.getValue();
    }

    public g(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f538714a = LazyKt.lazy(new b(r100, this));
    }

    public static String b(ArtifactBlock r100) {
        Integer r101 = r100.getStatus();
        int r102 = ArtifactStatus.GENERATING.getValue();
        if (r101 != null) goto L6;
    L8:
        int r103 = ArtifactStatus.GENERATED.getValue();
        if (r101 != null) goto L12;
    L13:
        int r104 = ArtifactStatus.OUTDATED.getValue();
        if (r101 != null) goto L17;
    L18:
        int r105 = ArtifactStatus.DELETED.getValue();
        if (r101 != null) goto L22;
    L24:
        return "";
    L22:
        if (r101.intValue() != r105) goto L24;
    L25:
        return "bitable_artifact_result_card_click";
    L17:
        if (r101.intValue() == r104) goto L25;
    L12:
        if (r101.intValue() == r103) goto L25;
    L6:
        if (r101.intValue() != r102) goto L8;
        return "bitable_artifact_progress_card_click";
    }

    public final void a(final Fragment r110, final Block r111, final Message r112, final String r113, final String r114, int r115) {
        Intrinsics.checkNotNullParameter(r111, "block");
        Intrinsics.checkNotNullParameter(r112, "message");
        BlockContent r100 = r111.getContent();
        if (r100 == null) goto L49;
        final ArtifactBlock r101 = r100.getDocBlock();
        if (r101 == null) goto L50;
        LarusCardBitableBinding r102 = getBinding();
        if (r102.f361272a.getWidth() == r115) goto L14;
        View r103 = r102.f361272a;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        r104.width = r115;
        r103.setLayoutParams(r104);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        h19.b r116 = h19.b.f483542a;
        Integer r105 = r101.getSubResourceType();
        if (r105 != null) goto L18;
    L20:
        CommonFileIconType r106 = CommonFileIconType.BITABLE;
    L21:
        r116.getClass();
        int r117 = h19.b.a(r106);
        r102.f361279h.setImageResource(r117);
        r102.f361281j.setImageResource(r117);
        r102.f361280i.setImageResource(r117);
        TextView r118 = r102.f361285n;
        String r107 = r101.getTitle();
        String r108 = "";
        if (r107 != null) goto L24;
        r107 = "";
    L24:
        r118.setText(r107);
        TextView r119 = r102.f361286o;
        String r109 = r101.getTitle();
        if (r109 == null) goto L28;
        r108 = r109;
    L28:
        r119.setText(r108);
        r102.f361284m.setText(getContext().getString(R.string.larus_Bitable_Doubao_InChat_Artifact_Base_Desc));
        Integer r120 = r101.getStatus();
        int r121 = ArtifactStatus.GENERATING.getValue();
        if (r120 != null) goto L32;
    L34:
        int r122 = ArtifactStatus.OUTDATED.getValue();
        if (r120 != null) goto L38;
    L40:
        int r123 = ArtifactStatus.GENERATED.getValue();
        if (r120 != null) goto L44;
    L46:
        e1.o(r102.f361278g);
        e1.o(r102.f361283l);
        e1.o(r102.f361275d);
        e1.o(r102.f361274c);
        e1.o(r102.f361273b);
        e1.o(r102.f361282k);
        e1.x(r102.f361276e);
    L47:
        e1.d(r102.f361272a, new c(this, r110, r101, r112, r113, r114));
        ExposeXTrackerExtKt.b(this, new d(r112, r111, this, r101, r113));
        return;
    L44:
        if (r120.intValue() != r123) goto L46;
        e1.x(r102.f361278g);
        r102.f361277f.setText(getContext().getString(R.string.larus_Bitable_Doubao_InChat_Artifact_BaseGenerated_Desc));
        e1.x(r102.f361283l);
        e1.x(r102.f361275d);
        e1.x(r102.f361274c);
        e1.o(r102.f361273b);
        e1.o(r102.f361282k);
        e1.o(r102.f361276e);
        goto L47
    L38:
        if (r120.intValue() != r122) goto L40;
        e1.o(r102.f361278g);
        e1.o(r102.f361283l);
        e1.o(r102.f361275d);
        e1.o(r102.f361274c);
        e1.o(r102.f361273b);
        e1.x(r102.f361282k);
        e1.o(r102.f361276e);
        goto L47
    L32:
        if (r120.intValue() != r121) goto L34;
        e1.x(r102.f361278g);
        r102.f361277f.setText("AI " + getContext().getString(R.string.larus_aiDoc_writing_hint));
        e1.x(r102.f361283l);
        e1.x(r102.f361275d);
        e1.x(r102.f361273b);
        e1.o(r102.f361274c);
        e1.o(r102.f361282k);
        e1.o(r102.f361276e);
        goto L47
    L18:
        if (r105.intValue() != 5) goto L20;
        r106 = CommonFileIconType.BITABLE_APP;
        goto L21
    L50:
        return;
    }
}
