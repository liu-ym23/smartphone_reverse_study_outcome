package com.bytedance.ee.bear.mindnote.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteSettingFragment extends CompatLandscapeBottomSheetDialogFragment implements sa5.d {
    public static final /* synthetic */ int m = 0;
    public MindNoteSettingViewModel k;
    public final List<SettingNormalImageView> l;

    public class a implements e {
        public final /* synthetic */ MindNoteSettingFragment a;

        public a(MindNoteSettingFragment r1) {
            this.a = r1;
        }
    }

    public final void onDestroyView() {
        this.k.processOnClick("", "");
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public MindNoteSettingFragment() {
        this.l = new ArrayList(4);
    }

    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final boolean onBackPressed() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L12:
        return true;
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onCreate(r2);
        MindNoteSettingViewModel r3 = (MindNoteSettingViewModel) q.a(this, MindNoteSettingViewModel.class);
        this.k = r3;
        r3.getData().observe(this, new com.bytedance.ee.bear.mindnote.setting.a(this));
    }

    public final void onViewCreated(View r6, Bundle r7) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r6, r7);
        ((CommonActionPanelLayout) r6.findViewById(2131364496)).setOnActionListener(new b(this));
        SettingNormalImageView r8 = (SettingNormalImageView) r6.findViewById(2131389053);
        SettingNormalImageView r0 = (SettingNormalImageView) r6.findViewById(2131389056);
        SettingNormalImageView r1 = (SettingNormalImageView) r6.findViewById(2131389051);
        SettingNormalImageView r9 = (SettingNormalImageView) r6.findViewById(2131389052);
        r8.setWrapper(new f("left", new a(this)));
        r0.setWrapper(new f("right", new a(this)));
        r1.setWrapper(new f("default", new a(this)));
        r9.setWrapper(new f("org", new a(this)));
        ((ArrayList) this.l).clear();
        ((ArrayList) this.l).add(r8);
        ((ArrayList) this.l).add(r0);
        ((ArrayList) this.l).add(r1);
        ((ArrayList) this.l).add(r9);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131563648, r3, false);
    }
}
