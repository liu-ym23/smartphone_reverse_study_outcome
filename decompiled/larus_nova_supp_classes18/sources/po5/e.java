package po5;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonPanelAdapter;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements a {
    public static final e b = null;

    static {
        b = new e();
    }

    public e() {
    }

    public static String b(String r8) {
        String r2 = LarkContext.getApplication().getString(2131889247);
        String r9 = UIHelper.mustacheFormat(2131889247, "num", r8);
        if (r9 == null) goto L17;
        boolean r1 = false;
        if (r9.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L12:
        if (r1 == true) goto L15;
        r9 = null;
    L15:
        if (r9 == null) goto L17;
        return r9;
    L10:
        if (Intrinsics.areEqual(r9, r2) == true) goto L12;
        r1 = true;
        goto L12
    L7:
        r0 = false;
    L17:
        Intrinsics.checkNotNull(r2);
        String r10 = StringsKt.replace$default(r2, "{{num}}", UIHelper.getAppName(), false, 4, null);
        tt5.a.h("TtsChangeSpeedCommand", "assembleSpeedText, format failed, replace manually: " + r10);
        return r10;
    }

    @Override // po5.a
    public final boolean a(mo5.a r14, Map r15) {
        a.a.getClass();
        mo5.g r16 = a.C0291a.a(r14, r15);
        boolean r0 = false;
        if (r16 != null) goto L5;
        return false;
    L5:
        TtsResult r1 = r16.l("TtsChangeSpeedCommand-handleAction");
        if (r1.a() == false) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L14;
        tt5.a.h("TtsChangeSpeedCommand", "handleAction, checkAccess failed: " + r1);
        if (r14 == null) goto L13;
        r14.g(r1);
    L13:
        return false;
    L14:
        no5.a.a.getClass();
        FragmentActivity r2 = no5.a.a();
        if (r2 != null) goto L17;
        return false;
    L17:
        Float r3 = (Float) r16.r().getValue();
        if (r3 == null) goto L20;
        float r4 = r3.floatValue();
    L21:
        ArrayList r5 = new ArrayList();
        CommonMorePanelItemData r6 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("0.75", "<set-?>");
        r6.a = "0.75";
        r6.a(b("0.75"));
        if (r4 != 0.75f) goto L24;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L28;
        r6.d = 2131255020;
        r6.g = com.bytedance.ee.util.ui.n.d(16);
        r6.h = 2131105543;
    L28:
        r5.add(r6);
        CommonMorePanelItemData r8 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("1.0", "<set-?>");
        r8.a = "1.0";
        r8.a(LarkContext.getApplication().getString(2131889246));
        if (r4 != 1.0f) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == false) goto L34;
        r8.d = 2131255020;
        r8.g = com.bytedance.ee.util.ui.n.d(16);
        r8.h = 2131105543;
    L34:
        r5.add(r8);
        CommonMorePanelItemData r10 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("1.25", "<set-?>");
        r10.a = "1.25";
        r10.a(b("1.25"));
        if (r4 != 1.25f) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L40;
        r10.d = 2131255020;
        r10.g = com.bytedance.ee.util.ui.n.d(16);
        r10.h = 2131105543;
    L40:
        r5.add(r10);
        CommonMorePanelItemData r12 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("1.5", "<set-?>");
        r12.a = "1.5";
        r12.a(b("1.5"));
        if (r4 != 1.5f) goto L43;
        boolean r13 = true;
    L44:
        if (r13 == false) goto L46;
        r12.d = 2131255020;
        r12.g = com.bytedance.ee.util.ui.n.d(16);
        r12.h = 2131105543;
    L46:
        r5.add(r12);
        CommonMorePanelItemData r17 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("2.0", "<set-?>");
        r17.a = "2.0";
        r17.a(b("2.0"));
        if (r4 != 2.0f) goto L49;
        r0 = true;
    L49:
        if (r0 == false) goto L51;
        r17.d = 2131255020;
        r17.g = com.bytedance.ee.util.ui.n.d(16);
        r17.h = 2131105543;
    L51:
        r5.add(r17);
        TtsOptionsView r18 = new TtsOptionsView();
        ((BaseUDBottomSheetDialogFragment) r18).r = LarkContext.getApplication().getString(2131889244);
        r18.oa0();
        CommonPanelAdapter r19 = (CommonPanelAdapter) r18.t.getValue();
        r19.a = r5;
        r19.notifyDataSetChanged();
        r18.ra0(new d(r16, r18, r14));
        FragmentManager r110 = r2.getSupportFragmentManager();
        String r111 = TtsOptionsView.class.getName().concat("-ChangeSpeed");
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, r111, r20);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r18, r20) == false) goto L58;
    L56:
        return true;
    L58:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L55:
        r18.show(r110, r111);
        goto L56
    L43:
        r13 = false;
        goto L44
    L37:
        r11 = false;
        goto L38
    L31:
        r9 = false;
        goto L32
    L24:
        r7 = false;
        goto L26
    L20:
        r4 = 1.0f;
        goto L21
    }
}
