package com.bytedance.ee.bear.more.pageview2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.m;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.toast.c;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.HashMap;
import sj5.d;
import tj5.e;
import tj5.f;

/* JADX INFO: loaded from: classes18.dex */
public class PageViewFragment extends CompatLandscapeBottomSheetDialogFragment {
    public static final /* synthetic */ int B = 0;
    public final a A;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f234716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f234717l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PageViewModel f234718m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f234719n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f234720o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f234721p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f234722q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f234723r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f234724s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PageviewUIHolder f234725t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public HashMap<String, Serializable> f234726u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f234727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f234728w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Runnable f234729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c f234730y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Disposable f234731z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageViewFragment f234732a;

        @Override // java.lang.Runnable
        public final void run() {
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        L24:
            return;
        L3:
            if (this.f234732a.isResumed() == false) goto L17;
            PageViewFragment r100 = this.f234732a;     // Catch: Throwable -> L14
            int r101 = PageViewFragment.B;     // Catch: Throwable -> L14
            Dialog r102 = r100.getDialog();     // Catch: Throwable -> L14
            View r103 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.a(r102);     // Catch: Throwable -> L14
            if (r103 == null) goto L21;
            BottomSheetBehavior<View> r104 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.b(r102);     // Catch: Throwable -> L14
            if (r104 == null) goto L22;
            int r105 = r103.getHeight();     // Catch: Throwable -> L14
            if (r105 <= 0) goto L23;
            r104.setPeekHeight(r105);     // Catch: Throwable -> L14
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        }

        public a(PageViewFragment r100) {
            this.f234732a = r100;
        }
    }

    public class b {
        public PageviewItemView A;
        public PageviewItemView B;
        public PageviewItemView C;
        public PageviewItemView D;
        public final /* synthetic */ PageViewFragment E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f234733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UDAvatar f234734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f234735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f234736d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public UDAvatar f234737e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f234738f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TextView f234739g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f234740h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ViewGroup f234741i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public TextView f234742j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public TextView f234743k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public TextView f234744l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public View f234745m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public TextView f234746n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public TextView f234747o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public TextView f234748p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public View f234749q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public TextView f234750r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public View f234751s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public TextView f234752t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public View f234753u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public ImageView f234754v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public SpaceEmptyState f234755w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public PageviewTextView f234756x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public PageviewTextView f234757y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public PageviewTextView f234758z;

        public final void b() {
            m.e(this.E.f234729x);
            c r100 = this.E.f234730y;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            PageViewFragment r101 = this.E;
            r101.f234729x = null;
            r101.f234730y = null;
        }

        public final void c() {
            if (this.f234746n.getVisibility() == 8) goto L5;
        L9:
            this.f234741i.setVisibility(0);
            return;
        L5:
            if (this.f234748p.getVisibility() != 8) goto L9;
            if (this.f234752t.getVisibility() != 8) goto L9;
            this.f234741i.setVisibility(8);
        }

        public final String a(int r100) {
            if (r100 >= 1000) goto L6;
            return String.valueOf(r100);
        L6:
            if (r100 >= 1000000) goto L9;
            return String.valueOf(r100 / 1000) + n.x(this.E.getContext(), R.string.CreationMobile_Common_Units_thousand);
        L9:
            return String.valueOf(r100 / 1000000) + n.x(this.E.getContext(), R.string.CreationMobile_Common_Units_million);
        }

        public b(PageViewFragment r100, View r101) {
            this.E = r100;
            TextView r102 = (TextView) r101.findViewById(R.id.title);
            this.f234733a = (TextView) r101.findViewById(R.id.subtitle1_value);
            this.f234734b = (UDAvatar) r101.findViewById(R.id.subtitle1_img);
            this.f234742j = (TextView) r101.findViewById(R.id.title_subhead_1);
            this.f234738f = r101.findViewById(R.id.subtitle_creator_container);
            this.f234736d = (TextView) r101.findViewById(R.id.subtitle_creator_value);
            this.f234737e = (UDAvatar) r101.findViewById(R.id.subtitle_creator_img);
            this.f234739g = (TextView) r101.findViewById(R.id.subtitle_last_modified_value);
            this.f234740h = r101.findViewById(R.id.subtitle_last_modified_container);
            this.f234735c = (TextView) r101.findViewById(R.id.subtitle2_value);
            this.f234741i = (ViewGroup) r101.findViewById(R.id.title_subhead_2_container);
            this.f234743k = (TextView) r101.findViewById(R.id.title_subhead_2);
            this.f234746n = (TextView) r101.findViewById(R.id.subtitle3);
            this.f234744l = (TextView) r101.findViewById(R.id.subtitle3_value);
            this.f234745m = r101.findViewById(R.id.subtitle3_divider);
            this.f234748p = (TextView) r101.findViewById(R.id.subtitle4);
            this.f234747o = (TextView) r101.findViewById(R.id.subtitle4_value);
            this.f234749q = r101.findViewById(R.id.subtitle4_divider);
            this.f234752t = (TextView) r101.findViewById(R.id.subtitle5);
            this.f234750r = (TextView) r101.findViewById(R.id.subtitle5_value);
            this.f234751s = r101.findViewById(R.id.subtitle5_divider);
            this.f234754v = (ImageView) r101.findViewById(R.id.leftIconIV);
            this.f234753u = r101.findViewById(R.id.reloading);
            this.f234755w = (SpaceEmptyState) r101.findViewById(R.id.empty_state);
            this.f234756x = (PageviewTextView) r101.findViewById(R.id.item_text_1);
            this.f234757y = (PageviewTextView) r101.findViewById(R.id.operation_detail_item);
            this.f234758z = (PageviewTextView) r101.findViewById(R.id.item_text_2);
            this.A = (PageviewItemView) r101.findViewById(R.id.item_ret_1);
            this.B = (PageviewItemView) r101.findViewById(R.id.item_ret_2);
            this.C = (PageviewItemView) r101.findViewById(R.id.item_ret_3);
            this.D = (PageviewItemView) r101.findViewById(R.id.item_ret_4);
        }
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void W90() {
        tt5.a.h("PageViewFragment", "onFloatDismiss");
        d r100 = this.f234719n;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    public PageViewFragment() {
        this.f234727v = true;
        this.f234728w = true;
        this.A = new a(this);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f234731z;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        b r101 = this.f234716k;
        if (r101 == null) goto L9;
        r101.b();
        return;
    }

    public final void da0(PageviewUIHolder r100) {
        PageviewUIHolder r101 = this.f234725t;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = r100.f234507d;
        if (r102 != null) goto L8;
        r102 = getContext().getString(R.string.Lark_Legacy_ProfileInfoPlaceholder);
    L8:
        r101.f234507d = r102;
        PageviewUIHolder r103 = this.f234725t;
        String r104 = r100.f234508e;
        if (r104 != null) goto L11;
        r104 = getContext().getString(R.string.Lark_Legacy_ProfileInfoPlaceholder);
    L11:
        r103.f234508e = r104;
        if (TextUtils.isEmpty(this.f234725t.f234504a) == false) goto L14;
    L19:
        boolean r105 = true;
    L20:
        this.f234728w = r105;
        b r106 = this.f234716k;
        if (r106 != null) goto L23;
        return;
    L23:
        if (r105 == false) goto L29;
        if (this.f234727v == false) goto L27;
        r106.f234753u.setVisibility(4);
    L27:
        this.f234716k.f234755w.setVisibility(8);
        this.f234716k.f234744l.setText(this.f234725t.f234507d);
        this.f234716k.f234747o.setText(this.f234725t.f234508e);
        return;
    L29:
        if (this.f234727v == false) goto L31;
        r106.f234753u.setVisibility(0);
        r106.f234755w.setVisibility(8);
        return;
    L31:
        r106.f234753u.setVisibility(8);
        r106.f234755w.setVisibility(0);
        return;
    L14:
        if (TextUtils.isEmpty(this.f234725t.f234507d) == false) goto L19;
        if (TextUtils.isEmpty(this.f234725t.f234508e) == false) goto L19;
        r105 = false;
        goto L20
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f234717l = ((i0) org.koin.java.a.a(i0.class)).a();
        Bundle r101 = getArguments();
        if (r101 != null) goto L5;
        tt5.a.d("PageViewFragment", "getArguments() == null");
    L13:
        PageViewModel r102 = (PageViewModel) ViewModelProviders.of(getActivity()).get(PageViewModel.class);
        this.f234718m = r102;
        r102.getPageViewResult().observe(this, new tj5.a(this));
        if (this.f234725t != null) goto L20;
        this.f234728w = true;
        return;
    L20:
        return;
    L5:
        this.f234720o = r101.getInt("documentType");
        this.f234721p = r101.getString("token");
        this.f234722q = r101.getBoolean("isDocV2");
        this.f234723r = r101.getBoolean("isShowViewHistory");
        this.f234725t = (PageviewUIHolder) r101.getParcelable("titleHolder");
        this.f234724s = (String) r101.getParcelable("docName");
        Serializable r103 = r101.getSerializable("extraParams");     // Catch: Exception -> L11
        if (r103 != null) goto L9;
        tt5.a.h("PageViewFragment", "initBundle, extraParams doesn't exist.");     // Catch: Exception -> L11
    L17:
        goto L13
    L9:
        HashMap<String, Serializable> r104 = (HashMap) r103;     // Catch: Exception -> L11
        this.f234726u = r104;     // Catch: Exception -> L11
        tt5.a.h("PageViewFragment", "initBundle, extraParams: " + r104);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.i("PageViewFragment", "newInstance, deserialize extraParams error", e);
        goto L13
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        super.onDismiss(r100);     // Catch: Throwable -> L7
        d r101 = this.f234719n;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.onDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final void Z90(WindowManager.LayoutParams r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.height = n.p(getActivity()) - BaseBottomSheetDialogFragment.f216377j;
    L5:
        if (r101 == true) goto L8;
        j.e(this.A);
        j.c(this.A);
        return;
    L8:
        return;
    L4:
        r100.height = -1;
        goto L5
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        final b r102 = new b(this, r100);
        this.f234716k = r102;
        r102.A.setTitle(n.x(getContext(), R.string.Doc_Doc_ReaderCount));
        r102.B.setTitle(n.x(getContext(), R.string.Doc_Doc_ReadingCount));
        r102.C.setTitle(n.x(getContext(), R.string.CreationMobile_Stats_Basic_comments));
        r102.D.setTitle(n.x(getContext(), R.string.Doc_More_ThumbUpCount));
        r102.f234756x.setTitle(n.x(getContext(), R.string.LarkCCM_Docs_ViewHistory_Menu_Mob));
        r102.f234756x.setImageResource(R.drawable.ud_icon_visible_outlined);
        r102.f234758z.setTitle(n.x(getContext(), R.string.CreationMobile_Common_PrivacySettings_tab));
        r102.f234758z.setImageResource(R.drawable.ud_icon_setting_outlined);
        r102.f234758z.f234772d.setVisibility(4);
        r102.f234756x.setOnClickListener(new tj5.b(r102));
        r102.f234758z.setOnClickListener(new tj5.c(r102));
        this.f234716k.f234753u.setOnClickListener(new tj5.d(r102));
        r102.f234755w.setPrimaryClickListener(new e(r102));
        r102.f234754v.setOnClickListener(new f(r102));
        PageviewUIHolder r103 = this.f234725t;
        int r104 = 0;
        if (r103 != null) goto L5;
    L16:
        r102.f234741i.setVisibility(8);
    L17:
        r102.c();
        PageviewUIHolder r105 = this.f234725t;
        if (r105 != null) goto L20;
    L22:
        boolean r106 = this.f234722q;
        HashMap<String, Serializable> r107 = this.f234726u;
        tt5.a.h("PageViewFragment", "initOperationItem operationEnable=" + r106);
        HashMap r108 = new HashMap();
        r108.put("token", this.f234721p);
        r108.put("obj_type", Integer.valueOf(this.f234720o));
        if (r107 == null) goto L25;
        r108.put(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY, r107.get(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY));
    L25:
        PageviewTextView r109 = r102.f234757y;
        if (r106 == true) goto L29;
        r104 = 8;
    L29:
        r109.setVisibility(r104);
        r102.f234757y.setTitle(getString(R.string.CreationMobile_Activity_Tab));
        r102.f234757y.setImageResource(R.drawable.icon_operation_record_outlined);
        r102.f234757y.setOnClickListener(new com.bytedance.ee.bear.more.pageview2.a(r102, r108));
        if (this.f234723r == true) goto L33;
        this.f234716k.f234756x.setVisibility(8);
        return;
    L33:
        return;
    L20:
        if (r105.f234509f == true) goto L22;
        r102.D.setVisibility(8);
        goto L22
    L5:
        if (TextUtils.isEmpty(r103.f234504a) == true) goto L16;
        r102.f234741i.setVisibility(0);
        this.f234716k.f234743k.setText(this.f234725t.f234504a);
        if (TextUtils.isEmpty(this.f234725t.f234505b) == true) goto L10;
        int r110 = 0;
    L11:
        this.f234716k.f234746n.setVisibility(r110);
        this.f234716k.f234744l.setVisibility(r110);
        this.f234716k.f234745m.setVisibility(r110);
        this.f234716k.f234746n.setText(this.f234725t.f234505b);
        if (TextUtils.isEmpty(this.f234725t.f234506c) == true) goto L14;
        int r111 = 0;
    L15:
        this.f234716k.f234748p.setVisibility(r111);
        this.f234716k.f234747o.setVisibility(r111);
        this.f234716k.f234749q.setVisibility(r111);
        this.f234716k.f234748p.setText(this.f234725t.f234506c);
        da0(this.f234725t);
        goto L17
    L14:
        r111 = 8;
        goto L15
    L10:
        r110 = 8;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.pageview_layout_fragment, r101, false);
    }
}
