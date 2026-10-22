package com.bytedance.ee.bear.document.editionmanager.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.editionmanager.EditionListPluginInterface;
import com.bytedance.ee.bear.document.editionmanager.EditionViewModel;
import com.bytedance.ee.bear.document.editionmanager.data.EditionListResult;
import com.bytedance.ee.bear.document.editionmanager.data.VersionMetasBean;
import com.bytedance.ee.bear.document.editionmanager.executor.k;
import com.bytedance.ee.bear.document.editionmanager.panel.EditionListFragment;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DeviceUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import d15.h;
import e15.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import z05.f;
import z05.g;
import z05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionListPlugin extends DocumentPluginV2 implements EditionListPluginInterface {
    private static final String TAG = "EditionListPlugin";
    private View.OnLayoutChangeListener contentLayoutChangeListener;
    private View contentLayoutChangeTarget;
    private AppCompatImageView downIcon;
    private a15.a editionAnalytic;
    private DialogFragment editionListFragment;
    private k mEditionNetExecutor;
    private EditionViewModel mEditionViewModel;
    private View.OnLayoutChangeListener rightLayoutChangeListener;
    private View rightLayoutChangeTarget;
    private TextView titleView;
    private ViewTreeObserver.OnPreDrawListener titleViewLayoutLengthPreDrawListener;
    private boolean titleViewLayoutLengthPreDrawScheduled;
    private View titleViewLayoutLengthPreDrawTarget;

    public class a implements EditionViewModel.a {
        public final /* synthetic */ EditionListPlugin a;

        public a(EditionListPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ TitleBar a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ EditionListPlugin c;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            EditionListPlugin.access$300(this.c);
            EditionListPlugin.access$400(this.c, this.a);
            if (this.b == false) goto L7;
            EditionListPlugin.access$500(this.c, this.a);
            return false;
        L7:
            return false;
        }

        public b(EditionListPlugin r1, TitleBar r2, boolean r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class c implements c15.b {
        public final /* synthetic */ BearUrl a;
        public final /* synthetic */ EditionListPlugin b;

        @Override // c15.b
        public final void onFail() {
            h r0 = (h) EditionListPlugin.access$000(this.b).getViewDelegate();
            r0.a.j.setVisibility(8);
            r0.a.k.setVisibility(0);
            r0.a.i.s();
            r0.a.i.setVisibility(8);
        }

        @Override // c15.b
        public final void a(EditionListResult r3) {
            EditionListPlugin.access$600(this.b, r3, this.a.b);
            EditionListPlugin.access$000(this.b).setPageToken(r3.getPage_token());
            EditionListPlugin.access$000(this.b).setHasMore(r3.isHas_more());
        }

        public c(EditionListPlugin r1, BearUrl r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ void a(EditionListPlugin r0, TitleBar r1, View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        r0.lambda$initView$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void c(EditionListPlugin r0, g r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ void d(EditionListPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void e(EditionListPlugin r0, TitleBar r1, View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        r0.lambda$initView$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void f(EditionListPlugin r0, View r1) {
        r0.lambda$initView$2(r1);
    }

    private void hideTitleLeftContainer() {
        setTitleStatus(false, "");
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void ensureFragment() {
        Bundle r0 = new Bundle();
        r0.putBoolean("isInForseti", ForsetiHelper.s(getHost().getHostFragment()));
        this.editionListFragment = instantiateFragment(EditionListFragment.class, r0);
        if (getFragmentManager() == null) goto L8;
        if (getFragmentManager().isStateSaved() == true) goto L8;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_plugin_EditionListPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(this.editionListFragment, getFragmentManager(), TAG);
    L8:
        if (this.downIcon != null) goto L10;
    L12:
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).c(getDocumentType());
        BaseSelectionPlugin r1 = (BaseSelectionPlugin) findPlugin(BaseSelectionPlugin.class);
        if (r1 == null) goto L16;
        r1.jsClearDocxSelection();
        return;
    L16:
        return;
    L10:
        if (getActivity() == null) goto L12;
        this.downIcon.setImageDrawable(getActivity().getDrawable(2131256076));
        goto L12
    }

    private void removeTitleLayoutListeners() {
        View r0 = this.rightLayoutChangeTarget;
        if (r0 == null) goto L7;
        View.OnLayoutChangeListener r1 = this.rightLayoutChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnLayoutChangeListener(r1);
    L7:
        this.rightLayoutChangeTarget = null;
        this.rightLayoutChangeListener = null;
        View r2 = this.contentLayoutChangeTarget;
        if (r2 == null) goto L12;
        View.OnLayoutChangeListener r3 = this.contentLayoutChangeListener;
        if (r3 == null) goto L12;
        r2.removeOnLayoutChangeListener(r3);
    L12:
        this.contentLayoutChangeTarget = null;
        this.contentLayoutChangeListener = null;
    }

    private void removeTitleViewLayoutLengthPreDrawListener() {
        View r0 = this.titleViewLayoutLengthPreDrawTarget;
        if (r0 != null) goto L5;
    L9:
        this.titleViewLayoutLengthPreDrawTarget = null;
        this.titleViewLayoutLengthPreDrawListener = null;
        this.titleViewLayoutLengthPreDrawScheduled = false;
        return;
    L5:
        if (this.titleViewLayoutLengthPreDrawListener == null) goto L9;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        r1.removeOnPreDrawListener(this.titleViewLayoutLengthPreDrawListener);
        goto L9
    }

    public void handleClick() {
        EditionViewModel r0 = this.mEditionViewModel;
        if (r0 == null) goto L6;
        r0.updateActive(true);
        requestEditionList(null, true);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public void removeFragment() {
        if (this.editionListFragment == null) goto L8;
        if (getFragmentManager() == null) goto L8;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_plugin_EditionListPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.editionListFragment);
    L8:
        if (this.downIcon != null) goto L10;
        return;
    L10:
        if (getActivity() == null) goto L14;
        this.downIcon.setImageDrawable(getActivity().getDrawable(2131254256));
        return;
    }

    private int getDocumentType() {
        if (getDocViewModel() != null) goto L7;
        return -1;
    L7:
        return getDocViewModel().getDocumentTypeValue();
    }

    private void updateCurrEdition() {
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        if (r0.a().isEditionDoc() == false) goto L6;
        g r1 = f.c(r0.a().getToken(), r0.a().getEditionId());
        r0.a().setEditionName(r1.b);
        updateTitle(r1.b);
        return;
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.EditionListPluginInterface
    public void handleEventDelete() {
        hideTitleLeftContainer();
        DocViewModel r0 = ((DocumentPluginHost) getHost()).a();
        String r1 = r0.getToken();
        String r2 = r0.getEditionId();
        Map<String, g> r3 = f.a;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.remove(f.b(r1, r2));
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.EditionListPluginInterface
    public void recoverEdition() {
        if ((getHost() instanceof DocumentPluginHost) == false) goto L9;
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        String r1 = r0.a().getEditionName();
        if (TextUtils.isEmpty(r1) == false) goto L7;
        r1 = "";
    L7:
        setTitleStatus(true, getTitle(r1));
        r0.getDocumentLoader().load();
        return;
    }

    public EditionListPlugin() {
    }

    public EditionViewModel getEditionViewModel() {
        return this.mEditionViewModel;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_plugin_EditionListPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ EditionViewModel access$000(EditionListPlugin r0) {
        return r0.mEditionViewModel;
    }

    public static /* synthetic */ int access$200(EditionListPlugin r0) {
        return r0.getDocumentType();
    }

    public static /* synthetic */ void access$300(EditionListPlugin r0) {
        r0.removeTitleViewLayoutLengthPreDrawListener();
    }

    private int getMeasuredWidthWithMargins(View r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        if (r3.getVisibility() == 8) goto L13;
        int r0 = r3.getMeasuredWidth();
        if ((r3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        return r0 + (r4.getMarginStart() + r4.getMarginEnd());
    L12:
        return r0;
    L13:
        return 0;
    }

    private String getTitle(String r3) {
        HashMap r0 = new HashMap();
        r0.put("version_name", r3);
        return xo5.a.d(getActivity(), 2131889366, r0);
    }

    private int getTitleBarContentWidth(TitleBar r3) {
        BaseTitleBar r4 = r3.getTitleBarLayout();
        if (r4 == null) goto L12;
        if (r4.getWidth() <= 0) goto L7;
        int r0 = r4.getWidth();
    L8:
        if (r0 <= 0) goto L12;
        return Math.max(0, (r0 - r4.getPaddingStart()) - r4.getPaddingEnd());
    L7:
        r0 = r4.getMeasuredWidth();
    L12:
        if (getUIContainer().getContentView().getMeasuredWidth() <= 0) goto L15;
        return getUIContainer().getContentView().getWidth();
    L15:
        return DeviceUtils.getScreenWidth(getContext());
    }

    private int getTitleBarExternalRightInset(TitleBar r2) {
        BaseTitleBar r3 = r2.getTitleBarLayout();
        if (r3 != null) goto L5;
        return 0;
    L5:
        if ((r3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r3.getLayoutParams()).getMarginEnd();
    }

    private void initView(DocumentPluginHost r8) {
        final TitleBar r0 = getTitleBar();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "initView titleBar == null");
        return;
    L6:
        tt5.a.h(TAG, "initView()");
        removeTitleLayoutListeners();
        LinearLayout r1 = r0.getTitleBarLayout().getLeftLayout();
        r0.getTitleBarLayout().f();
        RelativeLayout r2 = r0.getTitleBarLayout().getCenterLayout();
        LinearLayout r3 = (LinearLayout) r1.findViewById(2131388819);
        LinearLayout r4 = r0.getTitleBarLayout().getRightLayout();
        this.titleView = (TextView) r1.findViewById(2131388821);
        String r5 = r8.a().getEditionName();
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r5 = "";
    L9:
        this.titleView.setText(getTitle(r5));
        r2.setVisibility(8);
        r3.setVisibility(4);
        AppCompatImageView r6 = r1.findViewById(2131388820);
        this.downIcon = r6;
        r6.setVisibility(0);
        l.c(this.downIcon, 2131102418);
        scheduleTitleViewLayoutLength(r0, true);
        r3.setOnClickListener(new e15.c(this));
        this.rightLayoutChangeTarget = r4;
        View.OnLayoutChangeListener r7 = new e15.d(this, r0);
        this.rightLayoutChangeListener = r7;
        r4.addOnLayoutChangeListener(r7);
        if (ForsetiHelper.s(r8.c()) == false) goto L13;
        View r9 = getUIContainer().getContentView();
        this.contentLayoutChangeTarget = r9;
        View.OnLayoutChangeListener r10 = new e(this, r0);
        this.contentLayoutChangeListener = r10;
        r9.addOnLayoutChangeListener(r10);
        return;
    }

    private /* synthetic */ void lambda$initView$2(View r1) {
        handleClick();
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r1) {
        if (r1.booleanValue() == false) goto L5;
        ensureFragment();
        return;
    L5:
        removeFragment();
    }

    private void lambda$onAttachToHost$1(g r3) {
        if (this.mEditionViewModel.getCurrEditionId() != null) goto L5;
    L8:
        handleItemClick(getEditorAbility().getDocumentMetadata().getOriginUrl(), r3);
        return;
    L5:
        if (this.mEditionViewModel.getCurrEditionId().equals(r3.f) == false) goto L8;
        removeFragment();
    }

    private void replaceDocumentFragment(String r3) {
        EditionLoadingPlugin r0 = (EditionLoadingPlugin) getHost().findPlugin(EditionLoadingPlugin.class);
        if (r0 == null) goto L6;
        r0.replaceDocumentFragment(r3);
        return;
    }

    private void setTitleViewLayoutLength(TitleBar r7) {
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L6;
        setTitleViewLayoutLengthV2(r7);
        return;
    L6:
        LinearLayout r0 = r7.getTitleBarLayout().getLeftLayout();
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131388819);
        if (getDocViewModel() != null) goto L9;
    L11:
        double r2 = 0.7d;
    L12:
        int r3 = (int) (((double) DeviceUtils.getScreenWidth(getContext())) * r2);
        int r4 = getTitleBarContentWidth(r7);
        LinearLayout r5 = r7.getTitleBarLayout().getRightLayout();
        ImageView r6 = (ImageView) r0.findViewById(2131388820);
        if (r4 <= 0) goto L15;
        r3 = Math.min(r3, Math.max(0, (((r4 - r1.getLeft()) - getMeasuredWidthWithMargins(r5)) - getEffectiveTitleBarExternalRightInset(r7, r4)) - getMeasuredWidthWithMargins(r6)));
    L15:
        r1.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.titleView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.titleView.setMaxWidth(r3);
        return;
    L9:
        if (getDocViewModel().isDocumentType(sbb.e.h) == false) goto L11;
        r2 = 0.6d;
        goto L12
    }

    private void setTitleViewLayoutLengthV2(TitleBar r7) {
        LinearLayout r0 = r7.getTitleBarLayout().getLeftLayout();
        ImageView r1 = (ImageView) r0.findViewById(2131388808);
        ImageView r2 = (ImageView) r0.findViewById(2131388820);
        LinearLayout r3 = r7.getTitleBarLayout().getRightLayout();
        int r4 = getTitleBarContentWidth(r7);
        if (r4 <= 0) goto L5;
    L8:
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) r1.getLayoutParams();
        int r6 = (r1.getMeasuredWidth() + r5.getMarginStart()) + r5.getMarginEnd();
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r2.getLayoutParams();
        int r9 = (r2.getMeasuredWidth() + r8.getMarginStart()) + r8.getMarginEnd();
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r3.getLayoutParams();
        int r11 = (r3.getMeasuredWidth() + r10.getMarginStart()) + r10.getMarginEnd();
        int r12 = getEffectiveTitleBarExternalRightInset(r7, r4);
        this.titleView.setMaxWidth(Math.max(0, (((r4 - r6) - r9) - r11) - r12));
        return;
    L5:
        if (getUIContainer().getContentView().getMeasuredWidth() <= 0) goto L7;
        r4 = getUIContainer().getContentView().getWidth();
        goto L8
    L7:
        r4 = DeviceUtils.getScreenWidth(getContext());
        goto L8
    }

    private void showLeftContainer(TitleBar r2) {
        ((LinearLayout) r2.getTitleBarLayout().getLeftLayout().findViewById(2131388819)).setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        this.editionAnalytic = a15.a.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), getDocumentType());
        this.mEditionNetExecutor = new k((NetService) org.koin.java.a.a(NetService.class));
        EditionViewModel r4 = (EditionViewModel) q.c(r3, EditionViewModel.class, null);
        this.mEditionViewModel = r4;
        r4.getActive().observe(getLifecycleOwner(), new e15.a(this));
        this.mEditionViewModel.setDelegate(new a(this));
        this.mEditionViewModel.setOnItemClickListener(new e15.b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        removeTitleLayoutListeners();
        removeTitleViewLayoutLengthPreDrawListener();
        super.onDetachFromHost(r1);
    }

    public void updateTitle(String r3) {
        TitleBar r0 = getTitleBar();
        if (r3 == null) goto L8;
        TextView r1 = this.titleView;
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        r1.setText(getTitle(r3));
        setTitleViewLayoutLength(r0);
        return;
    L8:
        tt5.a.d(TAG, "updateTitle = null");
    }

    public static /* synthetic */ void access$400(EditionListPlugin r0, TitleBar r1) {
        r0.setTitleViewLayoutLength(r1);
    }

    public static /* synthetic */ void access$500(EditionListPlugin r0, TitleBar r1) {
        r0.showLeftContainer(r1);
    }

    private int getEffectiveTitleBarExternalRightInset(TitleBar r2, int r3) {
        return Math.max(0, getTitleBarExternalRightInset(r2) - Math.max(0, DeviceUtils.getScreenWidth(getContext()) - r3));
    }

    private void handleItemClick(String r6, g r7) {
        tt5.a.h(TAG, "handleItemClick url: " + du5.b.k(r6));     // Catch: Exception -> L13
        if (i.d(r6) == true) goto L6;
        String r8 = com.bytedance.ee.util.io.e.a(r6, "edition_id", r7.f);     // Catch: Exception -> L13
        RouteBean r2 = new RouteBean();     // Catch: Exception -> L13
        FragmentActivity r3 = getActivity();     // Catch: Exception -> L13
        int r4 = lw4.a.g;     // Catch: Exception -> L13
        r2.o = com.bytedance.ee.util.ui.a.a(r3);     // Catch: Exception -> L13
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r8, r2);     // Catch: Exception -> L13
    L8:
        if (TextUtils.isEmpty(this.mEditionViewModel.getCurrEditionId()) == true) goto L10;
        this.editionAnalytic.k("from_version_switch");     // Catch: Exception -> L13
    L11:
        tt5.a.h(TAG, "handleItemClick resultUrl: " + du5.b.k(r8));     // Catch: Exception -> L13
    L15:
        this.mEditionViewModel.updateActive(false);
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).i(getDocumentType(), "saved_version", r7.f, "ccm_docs_version_page_view");
        return;
    L10:
        this.editionAnalytic.k("from_version_source_doc");     // Catch: Exception -> L13
        goto L11
    L6:
        r8 = r6.replaceAll("(edition_id=[^&]*)", "edition_id=" + r7.f);     // Catch: Exception -> L13
        replaceDocumentFragment(r8);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.d(TAG, "handleItemClick()...err: " + e.getMessage());
        goto L15
    }

    private void handleSuccess(EditionListResult r6, String r7) {
        if (r6 != null) goto L5;
    L15:
        tt5.a.d(TAG, "handleSuccess data empty!!");
        EditionViewModel.d r8 = this.mEditionViewModel.getViewDelegate();
        h r9 = (h) r8;
        r9.a(false, new ArrayList());
        Iterator r10 = ((ConcurrentHashMap) f.a).keySet().iterator();
    L17:
        if (r10.hasNext() == false) goto L32;
        String r0 = (String) r10.next();
        if (r0.contains(r7) == false) goto L17;
        ((ConcurrentHashMap) f.a).remove(r0);
        goto L17
    L32:
        return;
    L5:
        if (r6.getVersion_metas() == null) goto L15;
        if (r6.getVersion_metas().size() <= 0) goto L15;
        f.d(r6);
        String r11 = ((VersionMetasBean) ListProtector.get(r6.getVersion_metas(), 0)).getParent_token();
        EditionViewModel.d r1 = this.mEditionViewModel.getViewDelegate();
        boolean r12 = r6.isHas_more();
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((ConcurrentHashMap) f.a).keySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) r3.next();
        if (r4.startsWith(r11) == false) goto L10;
        r2.add((g) ((ConcurrentHashMap) f.a).get(r4));
        goto L10
    L14:
        ((h) r1).a(r12, r2);
        updateCurrEdition();
    }

    private void requestEditionList(String r5, boolean r6) {
        if (r6 == true) goto L5;
        ((h) this.mEditionViewModel.getViewDelegate()).a.i.t();
        tt5.a.h(TAG, "requestEditionListWithPageToken: has not more...");
        return;
    L5:
        BearUrl r7 = getDocumentMetadata().getBearUrl();
        sbb.e r0 = sbb.e.e(r7.a);
        this.mEditionNetExecutor.a(r7.b, r0.b, r5, new c(this, r7));
    }

    private void scheduleTitleViewLayoutLength(TitleBar r3, boolean r4) {
        if (this.titleViewLayoutLengthPreDrawScheduled == false) goto L5;
        return;
    L5:
        BaseTitleBar r0 = r3.getTitleBarLayout();
        if (r0 != null) goto L8;
    L12:
        setTitleViewLayoutLength(r3);
        if (r4 == false) goto L16;
        showLeftContainer(r3);
        return;
    L16:
        return;
    L8:
        if (r0.getViewTreeObserver().isAlive() == false) goto L12;
        this.titleViewLayoutLengthPreDrawScheduled = true;
        this.titleViewLayoutLengthPreDrawTarget = r0;
        this.titleViewLayoutLengthPreDrawListener = new b(this, r3, r4);
        r0.getViewTreeObserver().addOnPreDrawListener(this.titleViewLayoutLengthPreDrawListener);
    }

    private void setTitleStatus(boolean r6, String r7) {
        if (getTitleBar() != null) goto L6;
        tt5.a.d(TAG, "setTitleStatus titleBar == null");
        return;
    L6:
        LinearLayout r0 = getTitleBar().getTitleBarLayout().getLeftLayout();
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131388819);
        this.titleView = (TextView) r0.findViewById(2131388821);
        int r2 = 0;
        if (r6 == false) goto L9;
        int r4 = 0;
    L10:
        r1.setVisibility(r4);
        this.titleView.setText(r7);
        AppCompatImageView r8 = r0.findViewById(2131388820);
        this.downIcon = r8;
        if (r6 == true) goto L14;
        r2 = 8;
    L14:
        r8.setVisibility(r2);
        return;
    L9:
        r4 = 8;
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        if ((r2 instanceof DocumentPluginHost) == false) goto L9;
        DocumentPluginHost r4 = (DocumentPluginHost) r2;
        String r5 = r4.a().getEditionId();
        if (TextUtils.isEmpty(r5) == true) goto L7;
        initView(r4);
    L7:
        this.mEditionViewModel.setCurrEditionId(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        removeTitleLayoutListeners();
        removeTitleViewLayoutLengthPreDrawListener();
        super.onDetachFromUIContainer(r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_plugin_EditionListPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static /* synthetic */ void access$100(EditionListPlugin r0, String r1, boolean r2) {
        r0.requestEditionList(r1, r2);
    }

    public static /* synthetic */ void access$600(EditionListPlugin r0, EditionListResult r1, String r2) {
        r0.handleSuccess(r1, r2);
    }

    private /* synthetic */ void lambda$initView$3(TitleBar r1, View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        int r11 = r5 - r3;
        if (r11 == (r9 - r7)) goto L6;
        tt5.a.h(TAG, "right layout width changed to " + r11);
        scheduleTitleViewLayoutLength(r1, false);
        return;
    }

    private /* synthetic */ void lambda$initView$4(TitleBar r1, View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        int r11 = r5 - r3;
        if (r11 == (r9 - r7)) goto L6;
        tt5.a.h(TAG, "container width changed to " + r11);
        scheduleTitleViewLayoutLength(r1, false);
        return;
    }
}
