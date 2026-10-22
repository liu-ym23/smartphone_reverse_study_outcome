package com.bytedance.ee.bear.drive.preload.pdf;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import i75.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/drive/preload/pdf/DrivePdfPositionPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "fileId", "", "isEnable", "", "urlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "parseInitPageNum", "", "parseInitPage", "saveRunnable", "Ljava/lang/Runnable;", "getLastPreviewConfig", "Lkotlin/Pair;", "", "handleEnter", "handleSave", "savePreviewPosition", "position", DrivePdfPositionPlugin.OFFSET, "scrollToPosition", DrivePdfPositionPlugin.PAGE, "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePdfPositionPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String DEFAULT_VALUE = "{}";
    private static final String KEY_PDF_POSITION_CONFIG = "pdf_position_config";
    private static final String OFFSET = "offset";
    private static final String PAGE = "page";
    private static final long SAVE_INTERVAL = 200;
    private static final String TAG = "DrivePdfPositionPlugin";
    private String fileId;
    private boolean isEnable;
    private final Runnable saveRunnable;
    private String url;
    private t45.c urlHelper;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePdfPositionPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public b(DrivePdfPositionPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            Integer r7 = (Integer) r6;
            DrivePdfPositionPlugin r0 = this.a;
            DriveViewModel r1 = this.b.c;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == true) goto L17;
            DriveViewModel r4 = this.b.c;
            if (r4 == null) goto L13;
            String r5 = r4.getFileName();
            if (r5 == null) goto L13;
        L15:
            if (h.k(com.bytedance.ee.util.io.a.c(r5)) == false) goto L17;
            boolean r8 = true;
        L18:
            DrivePdfPositionPlugin.access$setEnable$p(r0, r8);
            DrivePdfPositionPlugin r9 = this.a;
            if (DrivePdfPositionPlugin.access$parseInitPageNum(r9, r9.getUrl()) != (-1)) goto L24;
            DrivePdfPositionPlugin r10 = this.a;
            if (DrivePdfPositionPlugin.access$parseInitPage(r10, r10.getUrl()) != (-1)) goto L24;
            boolean r11 = false;
        L25:
            if (r7 != null) goto L28;
            return;
        L28:
            if (r7.intValue() != 2) goto L43;
            DriveViewModel r12 = this.b.c;
            if (r12 == null) goto L39;
            LiveData<Integer> r13 = r12.livePreviewType();
            if (r13 == null) goto L39;
            Integer r14 = (Integer) r13.getValue();
            if (r14 == null) goto L39;
            if (r14.intValue() != 3) goto L39;
            r2 = true;
        L39:
            if (r2 == true) goto L44;
            if (r11 == true) goto L45;
            DrivePdfPositionPlugin.access$handleEnter(this.a);
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L24:
            r11 = true;
        L13:
            r5 = "";
        L17:
            r8 = false;
            goto L18
        L5:
            if (r1.isVCFollowMode() != true) goto L7;
            r3 = true;
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DrivePdfPositionPlugin a;

        public c(DrivePdfPositionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.intValue() != 4) goto L9;
            DrivePdfPositionPlugin.access$handleEnter(this.a);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePdfPositionPlugin b;

        public d(DrivePluginHost r1, DrivePdfPositionPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            StringBuilder r0 = new StringBuilder("receive currentOffset changed ");
            r0.append((DrivePdfState.V2Offset) r3);
            r0.append(" host.driveViewModel?.livePreviewType() is ");
            DriveViewModel r4 = this.a.c;
            if (r4 == null) goto L7;
            LiveData<Integer> r5 = r4.livePreviewType();
            if (r5 == null) goto L7;
            Integer r6 = (Integer) r5.getValue();
        L8:
            r0.append(r6);
            tt5.a.b(DrivePdfPositionPlugin.TAG, r0.toString());
            j.e(DrivePdfPositionPlugin.access$getSaveRunnable$p(this.b));
            j.d(DrivePdfPositionPlugin.access$getSaveRunnable$p(this.b), 200);
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ DrivePdfPositionPlugin a;

        public e(DrivePdfPositionPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DrivePdfPositionPlugin.access$handleSave(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void handleEnter() {
        if (this.isEnable == false) goto L8;
        int r0 = ((Number) getLastPreviewConfig(this.fileId).getFirst()).intValue();
        float r1 = ((Number) getLastPreviewConfig(this.fileId).getSecond()).floatValue();
        tt5.a.h(TAG, " handleEnter lastPreviewPage  is " + r0 + " lastPreviewOffset is " + r1);
        if (r0 < 0) goto L9;
        scrollToPosition(r0, r1);
        return;
    L9:
        return;
    }

    private final void handleSave() {
        if (this.isEnable == false) goto L17;
        DriveBlockPreviewVM.BlockState r0 = (DriveBlockPreviewVM.BlockState) ((DriveBlockPreviewVM) viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().getValue();
        if (r0 != null) goto L7;
    L8:
        DrivePdfState.V2Offset r1 = (DrivePdfState.V2Offset) ((DriveConfigurationVM) viewModel(DriveConfigurationVM.class)).getCurrentV2Offset().getValue();
        if (r1 == null) goto L11;
        int r2 = r1.pageNumber;
    L12:
        if (r1 == null) goto L14;
        float r3 = r1.pageOffsetTop;
    L15:
        tt5.a.h(TAG, " handleSave page is " + r2 + " offset is " + r3 + " save to storage");
        savePreviewPosition(this.fileId, r2, r3);
        return;
    L14:
        r3 = 0.0f;
        goto L15
    L11:
        r2 = 0;
        goto L12
    L7:
        if (r0 == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L8;
        return;
    }

    public DrivePdfPositionPlugin() {
        this.fileId = "";
        this.url = "";
        this.saveRunnable = new e(this);
    }

    public final String getUrl() {
        return this.url;
    }

    public static final /* synthetic */ Runnable access$getSaveRunnable$p(DrivePdfPositionPlugin r0) {
        return r0.saveRunnable;
    }

    public static final /* synthetic */ void access$handleEnter(DrivePdfPositionPlugin r0) {
        r0.handleEnter();
    }

    public static final /* synthetic */ void access$handleSave(DrivePdfPositionPlugin r0) {
        r0.handleSave();
    }

    private final Pair<Integer, Float> getLastPreviewConfig(String r6) {
        JSONObject r1 = new JSONObject(ay4.b.d("drive", 6).getString(KEY_PDF_POSITION_CONFIG, DEFAULT_VALUE));     // Catch: Exception -> L5
        return new Pair(Integer.valueOf(JSONObjectProtectorUtils.getInt(r1, du5.b.g(r6))), Float.valueOf((float) JSONObjectProtectorUtils.getDouble(r1, du5.b.g(r6) + "_offset")));
    L5:
        tt5.a.d(TAG, "getLastPreviewPosition failed");
        return new Pair(-1, Float.valueOf(-1.0f));
    }

    private final int parseInitPage(String r4) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.enterprise_drive_anchor_link") == true) goto L5;
        return -1;
    L5:
        t45.c r0 = this.urlHelper;
        Integer r2 = null;
        if (r0 == null) goto L8;
        BearUrl r5 = r0.Z(r4);
    L9:
        if (r5 != null) goto L21;
    L17:
        if (r2 != null) goto L19;
        return -1;
    L19:
        return r2.intValue();
    L21:
        String r6 = r5.p;     // Catch: Exception -> L16
        if (r6 == null) goto L17;
        String r7 = (String) ((HashMap) h.o(r6)).get("page_number");     // Catch: Exception -> L16
        if (r7 == null) goto L17;
        r2 = Integer.valueOf(CastIntegerProtector.parseInt(r7));     // Catch: Exception -> L16
        goto L17
    L8:
        r5 = null;
        goto L9
    }

    private final int parseInitPageNum(String r3) {
        t45.c r0 = this.urlHelper;
        Integer r1 = null;
        if (r0 == null) goto L5;
        BearUrl r4 = r0.Z(r3);
    L6:
        if (r4 != null) goto L19;
    L14:
        if (r1 != null) goto L16;
        return -1;
    L16:
        return r1.intValue();
    L19:
        Map<String, String> r5 = r4.d;     // Catch: Exception -> L13
        if (r5 == null) goto L14;
        String r6 = r5.get(PAGE);     // Catch: Exception -> L13
        if (r6 == null) goto L14;
        r1 = Integer.valueOf(CastIntegerProtector.parseInt(r6));     // Catch: Exception -> L13
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        j.e(this.saveRunnable);
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ int access$parseInitPage(DrivePdfPositionPlugin r0, String r1) {
        return r0.parseInitPage(r1);
    }

    public static final /* synthetic */ int access$parseInitPageNum(DrivePdfPositionPlugin r0, String r1) {
        return r0.parseInitPageNum(r1);
    }

    public static final /* synthetic */ void access$setEnable$p(DrivePdfPositionPlugin r0, boolean r1) {
        r0.isEnable = r1;
    }

    private final void scrollToPosition(int r3, float r4) {
        tt5.a.h(TAG, "send scroll to page msg page is " + r3 + " offset is " + r4);
        MutableLiveData<DrivePdfState.V2Offset> r0 = ((DriveConfigurationVM) viewModel(DriveConfigurationVM.class)).getLastPreviewConfig();
        DrivePdfState.V2Offset r1 = new DrivePdfState.V2Offset();
        r1.pageNumber = r3;
        r1.pageOffsetTop = r4;
        r0.postValue(r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin
    public void onAttachToUIContainer(DrivePluginHost r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        this.urlHelper = (t45.c) r3.getUserComponent().a(t45.c.class);
        DriveViewModel r5 = r3.c;
        SpaceFileOpenEntity r0 = null;
        if (r5 == null) goto L5;
        BaseOpenEntity r6 = r5.getOpenEntity();
    L7:
        if ((r6 instanceof SpaceFileOpenEntity) == false) goto L9;
        r0 = (SpaceFileOpenEntity) r6;
    L9:
        String r7 = "";
        if (r0 == null) goto L13;
        String r1 = r0.getOriginUrl();
        if (r1 == null) goto L13;
    L14:
        this.url = r1;
        DriveViewModel r2 = r3.c;
        if (r2 == null) goto L20;
        String r8 = r2.getFileId();
        if (r8 == null) goto L20;
        r7 = r8;
    L20:
        this.fileId = r7;
        ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new b(this, r3));
        DriveViewModel r9 = r3.c;
        if (r9 == null) goto L25;
        LiveData<Integer> r10 = r9.livePreviewType();
        if (r10 == null) goto L25;
        r10.observe(getLifecycleOwner(), new c(this));
    L25:
        ((DriveConfigurationVM) viewModel(DriveConfigurationVM.class)).getCurrentV2Offset().observe(getLifecycleOwner(), new d(r3, this));
        return;
    L13:
        r1 = "";
        goto L14
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    private final void savePreviewPosition(String r6, int r7, float r8) {
        JSONObject r4 = new JSONObject(ay4.b.d("drive", 6).getString(KEY_PDF_POSITION_CONFIG, DEFAULT_VALUE));     // Catch: Exception -> L5
        r4.put(du5.b.g(r6), r7);     // Catch: Exception -> L5
        r4.put(du5.b.g(r6) + "_offset", Float.valueOf(r8));     // Catch: Exception -> L5
        ay4.b.d("drive", 6).putString(KEY_PDF_POSITION_CONFIG, r4.toString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(TAG, "savePreviewPosition failed", e, false);
    }
}
