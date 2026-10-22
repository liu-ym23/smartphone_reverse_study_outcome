package com.larus.office.card.sheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.office.card.databinding.LarusCardSpreadSheetBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes29.dex */
public final class j extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f361655d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f361656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f361657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ChatParam f361658c;

    public static final class a {
    }

    static {
    }

    private final LarusCardSpreadSheetBinding getBinding() {
        return (LarusCardSpreadSheetBinding) this.f361656a.getValue();
    }

    public j(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f361656a = LazyKt.lazy(new c(r100, this));
    }

    public static String b(ArtifactBlock r100, boolean r101) {
        if (r101 == false) goto L4;
        return "aisheet_artifact_progress_card_auto";
    L4:
        Integer r102 = r100.getStatus();
        int r103 = ArtifactStatus.GENERATING.getValue();
        if (r102 != null) goto L8;
    L10:
        Integer r104 = r100.getStatus();
        int r105 = ArtifactStatus.GENERATED.getValue();
        if (r104 != null) goto L14;
    L15:
        Integer r106 = r100.getStatus();
        int r107 = ArtifactStatus.OUTDATED.getValue();
        if (r106 != null) goto L19;
    L20:
        Integer r108 = r100.getStatus();
        int r109 = ArtifactStatus.DELETED.getValue();
        if (r108 != null) goto L24;
    L26:
        return "";
    L24:
        if (r108.intValue() != r109) goto L26;
    L27:
        return "aisheet_artifact_result_card_click";
    L19:
        if (r106.intValue() == r107) goto L27;
    L14:
        if (r104.intValue() == r105) goto L27;
    L8:
        if (r102.intValue() != r103) goto L10;
        return "aisheet_artifact_progress_card_click";
    }

    public final void c(Fragment r100, ArtifactBlock r101, Message r102, String r110, boolean r111) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L7;
        return;
    L7:
        if (LarkConnectorArtifactService.f365709a.a(getContext(), r102, r101) == false) goto L10;
        return;
    L10:
        if (vn9.a.a(r101) == false) goto L13;
        vn9.a.b(getContext());
        return;
    L13:
        if (r111 == true) goto L17;
        pn9.a r103 = pn9.a.f529987a;
        String r104 = r101.getResourceId();
        r103.getClass();
        if (pn9.a.a(r100, r104) == false) goto L17;
        return;
    L17:
        String r105 = b(r101, r111);
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L21;
        r106.h();
        SdkSheetsServiceImpl.f346130a.j(getContext(), r110, r101, r102, r105);
        return;
    }

    public final void a(final Fragment r110, final Block r111, final Message r112, final String r113, int r114, ChatParam r115) {
        Intrinsics.checkNotNullParameter(r111, "block");
        Intrinsics.checkNotNullParameter(r112, "message");
        if (r110 != null) goto L5;
        return;
    L5:
        BlockContent r100 = r111.getContent();
        if (r100 == null) goto L8;
        final ArtifactBlock r101 = r100.getDocBlock();
    L9:
        this.f361658c = r115;
        if (r101 != null) goto L12;
        return;
    L12:
        LarusCardSpreadSheetBinding r116 = getBinding();
        boolean r102 = !LarkConnectorArtifactService.f365709a.c(r112);
        if (r116.f361318a.getWidth() == r114) goto L19;
        View r103 = r116.f361318a;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L18;
        r104.width = r114;
        r103.setLayoutParams(r104);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L19:
        TextView r117 = getBinding().f361332o;
        String r105 = r101.getTitle();
        String r106 = "";
        if (r105 != null) goto L23;
        r105 = "";
    L23:
        r117.setText(r105);
        TextView r118 = getBinding().f361333p;
        String r107 = r101.getTitle();
        if (r107 == null) goto L26;
        r106 = r107;
    L26:
        r118.setText(r106);
        getBinding().f361331n.setText(getContext().getString(R.string.larus_LarkCCM_DoubaoSheets_Card_Sheets_Desc));
        h19.b r119 = h19.b.f483542a;
        CommonFileIconType r108 = CommonFileIconType.AI_SHEET;
        r119.getClass();
        int r120 = h19.b.a(r108);
        getBinding().f361325h.setImageResource(r120);
        getBinding().f361326i.setImageResource(r120);
        getBinding().f361324g.setImageResource(r120);
        Integer r121 = r101.getStatus();
        int r109 = ArtifactStatus.GENERATING.getValue();
        if (r121 != null) goto L30;
    L32:
        int r122 = ArtifactStatus.OUTDATED.getValue();
        if (r121 != null) goto L36;
    L38:
        int r123 = ArtifactStatus.GENERATED.getValue();
        if (r121 != null) goto L42;
    L48:
        e1.o(getBinding().f361323f);
        e1.o(getBinding().f361328k);
        e1.o(getBinding().f361319b);
        e1.o(getBinding().f361327j);
        e1.x(getBinding().f361320c);
    L49:
        final ArtifactBlock r124 = r101;
        e1.d(r116.f361322e, new f(r124, this, r110, r112, r113));
        final ArtifactBlock r125 = r101;
        e1.d(r116.f361318a, new g(this, r110, r125, r112, r113));
        int r126 = qn9.a.f534115a;
        qn9.a.a(getContext(), r101, r112, r113, new d(this, r101, r112, r113));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SheetArtifactBlockCard$mobShowCard$1(r112, this, r101, null), 3, null);
        final ArtifactBlock r127 = r101;
        ExposeXTrackerExtKt.b(this, new e(r112, r111, this, r127, r113));
        return;
    L42:
        if (r121.intValue() != r123) goto L48;
        e1.x(getBinding().f361323f);
        if (r102 == false) goto L46;
        e1.x(getBinding().f361322e);
    L47:
        getBinding().f361321d.setText(getContext().getString(R.string.larus_LarkCCM_DoubaoSheets_SheetsGenerated_Text));
        e1.x(getBinding().f361328k);
        e1.x(getBinding().f361319b);
        e1.x(getBinding().f361330m);
        e1.o(getBinding().f361329l);
        e1.o(getBinding().f361327j);
        e1.o(getBinding().f361320c);
        goto L49
    L46:
        e1.o(getBinding().f361322e);
        goto L47
    L36:
        if (r121.intValue() != r122) goto L38;
        e1.o(getBinding().f361323f);
        e1.o(getBinding().f361322e);
        e1.o(getBinding().f361328k);
        e1.o(getBinding().f361319b);
        e1.o(getBinding().f361330m);
        e1.o(getBinding().f361329l);
        e1.x(getBinding().f361327j);
        e1.o(getBinding().f361320c);
        goto L49
    L30:
        if (r121.intValue() != r109) goto L32;
        e1.x(getBinding().f361323f);
        getBinding().f361321d.setText("AI " + getContext().getString(R.string.larus_aiDoc_writing_hint));
        e1.o(getBinding().f361322e);
        e1.x(getBinding().f361328k);
        e1.x(getBinding().f361319b);
        e1.x(getBinding().f361329l);
        e1.o(getBinding().f361330m);
        e1.o(getBinding().f361327j);
        e1.o(getBinding().f361320c);
        goto L49
    L8:
        r101 = null;
        goto L9
    }
}
