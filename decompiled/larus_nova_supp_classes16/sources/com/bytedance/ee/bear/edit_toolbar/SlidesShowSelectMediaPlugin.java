package com.bytedance.ee.bear.edit_toolbar;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.document.plugin.media.OfficeSelectMediaPlugin;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.api.FileType;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u000e\u0010\f\u001a\u00020\n*\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\rH\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\f\u001a\u00020\n*\b\u0012\u0004\u0012\u00020(0'H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0002J\f\u0010/\u001a\u00020(*\u000200H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/edit_toolbar/SlidesShowSelectMediaPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "pickerOverlayView", "Landroid/view/View;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "safeLogSummary", "Lcom/alibaba/fastjson/JSONObject;", "openImagePicker", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "buildSheetLikeImagePickerConfig", "Lcom/bytedance/ee/bear/fileselector/api/FileSelectConfig;", "pickerContentContainer", "Landroid/view/ViewGroup;", "selectMediaPlugin", "Lcom/bytedance/ee/bear/document/plugin/media/OfficeSelectMediaPlugin;", "showPickerOverlay", "Landroid/widget/FrameLayout;", "createPickerOverlay", "createPickerContentContainer", "resolvePickerContentHeight", "", "createPickerHeaderView", "createBackView", "createTitleView", "dp", "value", "buildFailedJsonData", "getImageSelectListener", "Lcom/bytedance/ee/bear/fileselector/api/SimpleFileSelectListener;", "", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "dismissImagePicker", "removePickerFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getImageSizeCheckListener", "Lcom/bytedance/ee/bear/fileselector/listener/IFileSizeCheckListener;", "toSelectedMediaItem", "Lcom/bytedance/ee/bear/fileselector/bean/FileBean;", "SlidesSelectMediaHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = SlidesShowSelectMediaPlugin.HEADER_HEIGHT_DP)
public final class SlidesShowSelectMediaPlugin extends DocumentPlugin {
    private static final a Companion = null;
    private static final int HEADER_HEIGHT_DP = 48;
    private static final int IMAGE_MAX_SIZE = 20971520;
    private static final String PICKER_CONTENT_CONTAINER_TAG = "SlidesShowSelectMediaPluginPickerContent";
    private static final float PICKER_CONTENT_WEIGHT = 1.0f;
    private static final String PICKER_FRAGMENT_TAG = "SlidesShowSelectMediaPluginPicker";
    private static final int PICKER_PANEL_HEIGHT_DP = 379;
    private static final String TAG = "SlidesShowSelectMediaPlugin";
    private static final float TITLE_TEXT_SIZE_SP = 17.0f;
    private static final long VIDEO_MAX_SIZE = 10737418240L;
    private View pickerOverlayView;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<JSONObject> {
        public final /* synthetic */ SlidesShowSelectMediaPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SlidesShowSelectMediaPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            StringBuilder r0 = new StringBuilder("slidesSelectMledia handle, ");
            r0.append(SlidesShowSelectMediaPlugin.access$safeLogSummary(this.a, (JSONObject) r4));
            tt5.a.h(SlidesShowSelectMediaPlugin.TAG, r0.toString());
            if (r5 != null) goto L5;
            tt5.a.d(SlidesShowSelectMediaPlugin.TAG, "slidesSelectMledia failed, callback is null");
            return;
        L5:
            DocumentPluginHost r6 = (DocumentPluginHost) this.a.getHost();
            FragmentActivity r1 = null;
            if (r6 == null) goto L8;
            FragmentActivity r7 = r6.getActivity();
        L10:
            if ((r7 instanceof FragmentActivity) == false) goto L12;
            r1 = r7;
        L12:
            if (r1 != null) goto L14;
            SlidesShowSelectMediaPlugin r8 = this.a;
            tt5.a.d(SlidesShowSelectMediaPlugin.TAG, "slidesSelectMledia failed, activity is null");
            r5.b(SlidesShowSelectMediaPlugin.access$buildFailedJsonData(r8));
            return;
        L14:
            SlidesShowSelectMediaPlugin.access$openImagePicker(this.a, r1, r5);
            return;
        L8:
            r7 = null;
            goto L10
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SlidesShowSelectMediaPlugin a;

        public c(SlidesShowSelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(SlidesShowSelectMediaPlugin.TAG, "picker header back click");
            SlidesShowSelectMediaPlugin.access$dismissImagePicker(this.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SlidesShowSelectMediaPlugin a;

        public d(SlidesShowSelectMediaPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(SlidesShowSelectMediaPlugin.TAG, "picker outside click");
            SlidesShowSelectMediaPlugin.access$dismissImagePicker(this.a);
        }
    }

    public static final class e extends za5.b {
        public final /* synthetic */ SlidesShowSelectMediaPlugin a;
        public final /* synthetic */ OfficeSelectMediaPlugin b;
        public final /* synthetic */ m c;

        @Override // za5.b, za5.a
        public final void b() {
            tt5.a.h(SlidesShowSelectMediaPlugin.TAG, "onSelectFileCancel");
            SlidesShowSelectMediaPlugin.access$dismissImagePicker(this.a);
        }

        @Override // za5.b, za5.a
        public final void c(List<? extends FileBean> r6) {
            Intrinsics.checkNotNullParameter(r6, "fileList");
            SlidesShowSelectMediaPlugin r1 = this.a;
            OfficeSelectMediaPlugin r2 = this.b;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
            List<? extends FileBean> r7 = r6;     // Catch: Throwable -> L9
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L9
            Iterator<T> r8 = r7.iterator();     // Catch: Throwable -> L9
        L5:
            if (r8.hasNext() == false) goto L7;
            r4.add(SlidesShowSelectMediaPlugin.access$toSelectedMediaItem(r1, (FileBean) r8.next()));     // Catch: Throwable -> L9
            goto L5
        L7:
            tt5.a.h(SlidesShowSelectMediaPlugin.TAG, "onSelectFileBeanList, size=" + r4.size() + ", " + SlidesShowSelectMediaPlugin.access$safeLogSummary(r1, r4));     // Catch: Throwable -> L9
            r2.insertMedias(r4);     // Catch: Throwable -> L9
            SlidesShowSelectMediaPlugin.access$dismissImagePicker(r1);     // Catch: Throwable -> L9
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            m r5 = this.c;
            SlidesShowSelectMediaPlugin r10 = this.a;
            Throwable r11 = Result.exceptionOrNull-impl(r9);
            if (r11 == null) goto L18;
            tt5.a.e(SlidesShowSelectMediaPlugin.TAG, "onSelectFileBeanList failed", r11, false);
            r5.b(SlidesShowSelectMediaPlugin.access$buildFailedJsonData(r10));
            return;
        L18:
            return;
        L9:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }

        public e(SlidesShowSelectMediaPlugin r1, OfficeSelectMediaPlugin r2, m r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f implements bb5.c {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // bb5.c
        public final void a(FileType r3) {
            Intrinsics.checkNotNullParameter(r3, "fileType");
            tt5.a.k(SlidesShowSelectMediaPlugin.TAG, "selected file over size, fileType=" + r3);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final JSONObject buildFailedJsonData() {
        JSONObject r0 = new JSONObject();
        r0.put("code", -1);
        return r0;
    }

    private final void dismissImagePicker() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        removePickerFragment(getUIContainer().getFragmentManager());     // Catch: Throwable -> L7
        View r1 = this.pickerOverlayView;     // Catch: Throwable -> L7
        if (r1 == null) goto L5;
        getUIContainer().m(this, r1);     // Catch: Throwable -> L7
    L5:
        this.pickerOverlayView = null;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L15;
        tt5.a.l(TAG, "dismissImagePicker failed", r3);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public SlidesShowSelectMediaPlugin() {
    }

    private final bb5.c getImageSizeCheckListener() {
        return f.a;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_SlidesShowSelectMediaPlugin_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ JSONObject access$buildFailedJsonData(SlidesShowSelectMediaPlugin r0) {
        return r0.buildFailedJsonData();
    }

    public static final /* synthetic */ void access$dismissImagePicker(SlidesShowSelectMediaPlugin r0) {
        r0.dismissImagePicker();
    }

    private final View createBackView(FragmentActivity r3) {
        ImageView r0 = new ImageView(r3);
        r0.setImageResource(2131254998);
        r0.setImageTintList(ContextCompat.getColorStateList(r3, 2131102418));
        r0.setScaleType(ImageView.ScaleType.CENTER);
        r0.setContentDescription(r3.getString(2131888896));
        r0.setOnClickListener(new c(this));
        return r0;
    }

    private final FrameLayout createPickerContentContainer(FragmentActivity r2) {
        FrameLayout r0 = new FrameLayout(r2);
        r0.setId(View.generateViewId());
        r0.setTag(PICKER_CONTENT_CONTAINER_TAG);
        return r0;
    }

    private final View createPickerHeaderView(FragmentActivity r7) {
        FrameLayout r0 = new FrameLayout(r7);
        r0.setBackgroundColor(ContextCompat.getColor(r7, 2131100548));
        r0.addView(createBackView(r7), new FrameLayout.LayoutParams(dp(r7, HEADER_HEIGHT_DP), dp(r7, HEADER_HEIGHT_DP), 8388611));
        r0.addView(createTitleView(r7), new FrameLayout.LayoutParams(-2, -2, 17));
        return r0;
    }

    private final View createPickerOverlay(FragmentActivity r8) {
        int r0 = dp(r8, PICKER_PANEL_HEIGHT_DP);
        int r1 = dp(r8, HEADER_HEIGHT_DP);
        FrameLayout r2 = new FrameLayout(r8);
        r2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r2.setClickable(true);
        r2.setOnClickListener(new d(this));
        LinearLayout r5 = new LinearLayout(r8);
        r5.setOrientation(1);
        r5.setClickable(true);
        r5.setBackgroundColor(ContextCompat.getColor(r8, 2131100548));
        r2.addView(r5, new FrameLayout.LayoutParams(-1, r0, 80));
        r5.addView(createPickerHeaderView(r8), new LinearLayout.LayoutParams(-1, r1));
        r5.addView(createPickerContentContainer(r8), new LinearLayout.LayoutParams(-1, 0, PICKER_CONTENT_WEIGHT));
        return r2;
    }

    private final View createTitleView(FragmentActivity r3) {
        TextView r0 = new TextView(r3);
        r0.setText(r3.getString(2131887224));
        r0.setTextColor(ContextCompat.getColor(r3, 2131106622));
        r0.setTextSize(2, TITLE_TEXT_SIZE_SP);
        r0.setGravity(17);
        r0.setIncludeFontPadding(false);
        return r0;
    }

    private final void removePickerFragment(FragmentManager r2) {
        Fragment r0 = r2.findFragmentByTag(PICKER_FRAGMENT_TAG);
        if (r0 == null) goto L6;
        r2.beginTransaction().remove(r0).commitNowAllowingStateLoss();
        return;
    }

    private final int resolvePickerContentHeight(FragmentActivity r2) {
        return dp(r2, 331);
    }

    private final String safeLogSummary(JSONObject r3) {
        if (r3 != null) goto L6;
        return "data=null";
    L6:
        return "width=" + r3.getInteger("width") + ", height=" + r3.getInteger("height") + ", mimeType=" + r3.getString("mimeType") + ", hasUrl=" + r3.containsKey("url");
    }

    private final FrameLayout showPickerOverlay(FragmentActivity r2) {
        View r3 = createPickerOverlay(r2);
        this.pickerOverlayView = r3;
        getUIContainer().h(this, r3);
        return (FrameLayout) r3.findViewWithTag(PICKER_CONTENT_CONTAINER_TAG);
    }

    private final SelectedMediaItem toSelectedMediaItem(FileBean r17) {
        h r0 = ay4.d.a();
        String r1 = r17.getPath();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        VFSPath r2 = r0.z(r1);
        int r3 = r17.getWidth();
        int r4 = r17.getHeight();
        if (r17.isVideo() == true) goto L12;
        int[] r5 = g5.a(r2);
        int r6 = r5[0];
        if (r6 <= 0) goto L12;
        int r7 = r5[1];
        if (r7 <= 0) goto L12;
        int r10 = r7;
        int r9 = r6;
    L14:
        return new SelectedMediaItem(r17.getMimeType(), UUID.randomUUID().toString(), r2.getRealPath(), r9, r10, r17.getDuration(), r2.toFile().length(), r2.getName());
    L12:
        r9 = r3;
        r10 = r4;
        goto L14
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.slidesSelectMedia", new b(this));
    }

    private final String safeLogSummary(List<? extends SelectedMediaItem> r10) {
        return CollectionsKt.joinToString$default(r10, null, "items=[", "]", 0, null, AnonymousClass1.INSTANCE, 25, null);
    }

    public static final /* synthetic */ String access$safeLogSummary(SlidesShowSelectMediaPlugin r0, JSONObject r1) {
        return r0.safeLogSummary(r1);
    }

    public static final /* synthetic */ SelectedMediaItem access$toSelectedMediaItem(SlidesShowSelectMediaPlugin r0, FileBean r1) {
        return r0.toSelectedMediaItem(r1);
    }

    private final int dp(FragmentActivity r1, int r2) {
        return (int) (r2 * INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_SlidesShowSelectMediaPlugin_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r1.getResources()).density);
    }

    private final za5.b getImageSelectListener(OfficeSelectMediaPlugin r2, m r3) {
        return new e(this, r2, r3);
    }

    private final void openImagePicker(FragmentActivity r5, m r6) {
        OfficeSelectMediaPlugin r0 = (OfficeSelectMediaPlugin) findPlugin(OfficeSelectMediaPlugin.class);
        if (r0 != null) goto L14;
        tt5.a.d(TAG, "openImagePicker failed, OfficeSelectMediaPlugin is null");
        r6.b(buildFailedJsonData());
        return;
    L14:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        dismissImagePicker();     // Catch: Throwable -> L8
        FrameLayout r3 = showPickerOverlay(r5);     // Catch: Throwable -> L8
        FileSelectConfig r1 = buildSheetLikeImagePickerConfig(r5, r3, r0, r6);     // Catch: Throwable -> L8
        int r4 = com.bytedance.ee.bear.fileselector.d.a;     // Catch: Throwable -> L8
        FileSelectFragment r7 = com.bytedance.ee.bear.fileselector.d.a.b(r5, r1);     // Catch: Throwable -> L8
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_SlidesShowSelectMediaPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(getUIContainer().getFragmentManager().beginTransaction(), r3.getId(), r7, PICKER_FRAGMENT_TAG).commitNowAllowingStateLoss();     // Catch: Throwable -> L8
        tt5.a.h(TAG, "openImagePicker by overlay, fragment=FileSelectFragment");     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L16;
        tt5.a.e(TAG, "openImagePicker failed", r9, false);
        r6.b(buildFailedJsonData());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static final /* synthetic */ String access$safeLogSummary(SlidesShowSelectMediaPlugin r0, List r1) {
        return r0.safeLogSummary(r1);
    }

    public static final /* synthetic */ void access$openImagePicker(SlidesShowSelectMediaPlugin r0, FragmentActivity r1, m r2) {
        r0.openImagePicker(r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_SlidesShowSelectMediaPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.replace(r2, r3, r4);
    }

    private final FileSelectConfig buildSheetLikeImagePickerConfig(FragmentActivity r5, ViewGroup r6, OfficeSelectMediaPlugin r7, m r8) {
        int r9 = resolvePickerContentHeight(r5);
        FileSelectConfig.e r0 = FileSelectConfig.ccmAlbumBuilder();
        FileSelectConfig r1 = r0.a;
        r1.columnCount = 4;
        r1.showGif = false;
        r1.adjustHeightByKeyboard = false;
        r1.ccmPickViewHeight = r9;
        r1.minCcmPickViewHeight = r9;
        r1.showVideo = false;
        r1.maxImageSize = IMAGE_MAX_SIZE;
        r1.maxVideoSize = VIDEO_MAX_SIZE;
        r1.enableImageCompress = true;
        r1.maxSelectImageNum = 1;
        r1.actionType = 1;
        r1.container = r6;
        r0.a.fileSelectListener = getImageSelectListener(r7, r8);
        r0.a.fileCheckListener = getImageSizeCheckListener();
        return r0.a();
    }
}
