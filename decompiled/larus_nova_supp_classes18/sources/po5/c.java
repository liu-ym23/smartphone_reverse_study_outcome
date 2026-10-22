package po5;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonPanelAdapter;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements a {
    public static final c b = null;

    static {
        b = new c();
    }

    public c() {
    }

    @Override // po5.a
    public final boolean a(mo5.a r13, Map r14) {
        a.a.getClass();
        mo5.g r15 = a.C0291a.a(r13, r14);
        if (r15 != null) goto L5;
        return false;
    L5:
        TtsResult r1 = r15.l("TtsChangeSpeakerCommand-handleAction");
        if (r1.a() == false) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L15;
        tt5.a.k("TtsChangeSpeakerCommand", "handleAction, checkAccess failed: " + r1);
        if (r13 == null) goto L14;
        r13.g(r1);
    L14:
        return false;
    L15:
        List r2 = (List) r15.c().getValue();
        if (r2 != null) goto L18;
    L64:
        tt5.a.k("TtsChangeSpeakerCommand", "handleAction, toneBeanList is null or empty.");
        if (r13 == null) goto L67;
        r13.g(new TtsResult(TtsResult.ModelCode.TONE_LIST_INVALID));
    L67:
        return false;
    L18:
        if ((!r2.isEmpty()) == true) goto L21;
        r2 = null;
    L21:
        if (r2 == null) goto L64;
        no5.a.a.getClass();
        FragmentActivity r3 = no5.a.a();
        if (r3 != null) goto L25;
        return false;
    L25:
        TtsToneBean r4 = (TtsToneBean) r15.v().getValue();
        if (r4 == null) goto L28;
        String r5 = r4.getToneId();
    L29:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r2.iterator();
    L31:
        if (r7.hasNext() == false) goto L58;
        TtsToneBean r8 = (TtsToneBean) r7.next();
        String r9 = r8.getToneId();
        if (r9 == null) goto L31;
        if (r9.length() <= 0) goto L37;
        boolean r10 = true;
    L38:
        if (r10 == true) goto L41;
        r9 = null;
    L41:
        if (r9 == null) goto L31;
        String r11 = r8.getToneName();
        if (r11 == null) goto L31;
        if (r11.length() <= 0) goto L48;
        boolean r12 = true;
    L49:
        if (r12 == true) goto L52;
        r11 = null;
    L52:
        if (r11 == null) goto L31;
        CommonMorePanelItemData r16 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r16.a = r9;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r16.c = r11;
        if (Intrinsics.areEqual(r5, r9) == false) goto L57;
        r16.d = 2131255020;
        r16.g = com.bytedance.ee.util.ui.n.d(16);
        r16.h = 2131105543;
    L57:
        r6.add(r16);
        goto L31
    L48:
        r12 = false;
        goto L49
    L37:
        r10 = false;
        goto L38
    L58:
        TtsOptionsView r0 = new TtsOptionsView();
        ((BaseUDBottomSheetDialogFragment) r0).r = LarkContext.getApplication().getString(2131889245);
        r0.oa0();
        CommonPanelAdapter r17 = (CommonPanelAdapter) r0.t.getValue();
        r17.a = r6;
        r17.notifyDataSetChanged();
        r0.ra0(new b(r2, r13, r0, r15));
        FragmentManager r18 = r3.getSupportFragmentManager();
        String r19 = TtsOptionsView.class.getName().concat("-ChangeTone");
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r19, r20);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r18, r0, r20) == false) goto L69;
    L63:
        return true;
    L69:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L68
    L62:
        r0.show(r18, r19);
        goto L63
    L28:
        r5 = null;
        goto L29
    }
}
