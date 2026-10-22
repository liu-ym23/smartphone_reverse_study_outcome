package com.bytedance.ee.bear.mindnote.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class MindNoteSettingFragment extends CompatLandscapeBottomSheetDialogFragment implements sa5.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f234454m = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MindNoteSettingViewModel f234455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<SettingNormalImageView> f234456l;

    public class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MindNoteSettingFragment f234457a;

        public a(MindNoteSettingFragment r100) {
            this.f234457a = r100;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f234455k.processOnClick("", "");
        super.onDestroyView();
    }

    public MindNoteSettingFragment() {
        this.f234456l = new ArrayList(4);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        MindNoteSettingViewModel r101 = (MindNoteSettingViewModel) q.a(this, MindNoteSettingViewModel.class);
        this.f234455k = r101;
        r101.getData().observe(this, new com.bytedance.ee.bear.mindnote.setting.a(this));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        ((CommonActionPanelLayout) r100.findViewById(R.id.bottom_panel)).setOnActionListener(new b(this));
        SettingNormalImageView r102 = (SettingNormalImageView) r100.findViewById(R.id.tool_left_view_img);
        SettingNormalImageView r103 = (SettingNormalImageView) r100.findViewById(R.id.tool_right_view_img);
        SettingNormalImageView r104 = (SettingNormalImageView) r100.findViewById(R.id.tool_bilateral_view_img);
        SettingNormalImageView r105 = (SettingNormalImageView) r100.findViewById(R.id.tool_down_view_img);
        r102.setWrapper(new f("left", new a(this)));
        r103.setWrapper(new f("right", new a(this)));
        r104.setWrapper(new f("default", new a(this)));
        r105.setWrapper(new f("org", new a(this)));
        ((ArrayList) this.f234456l).clear();
        ((ArrayList) this.f234456l).add(r102);
        ((ArrayList) this.f234456l).add(r103);
        ((ArrayList) this.f234456l).add(r104);
        ((ArrayList) this.f234456l).add(r105);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.mindnote_setting_fragment, r101, false);
    }
}
