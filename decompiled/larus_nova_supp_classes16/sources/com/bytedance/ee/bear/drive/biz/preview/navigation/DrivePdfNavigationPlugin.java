package com.bytedance.ee.bear.drive.biz.preview.navigation;

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
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import i75.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t45.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001c\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J \u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/navigation/DrivePdfNavigationPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "urlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "parseInitOffset", "", "fragmentMap", "", "", "parseInitPage", "", "map", "stringToArray", "", "getUrlFragmentMap", "url", "scrollToPosition", "pageNumber", "offset", "isValidOffset", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePdfNavigationPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String TAG = "DrivePdfNavigationPlugin";
    private c urlHelper;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePdfNavigationPlugin a;
        public final /* synthetic */ String b;

        public b(DrivePdfNavigationPlugin r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            Integer r7 = (Integer) r6;
            if (r7 == null) goto L21;
        L13:
            e = move-exception;
            tt5.a.d(DrivePdfNavigationPlugin.TAG, "error:" + e.getMessage());
            return;
        L6:
            if (r7.intValue() != 2) goto L18;
            Map r8 = DrivePdfNavigationPlugin.access$getUrlFragmentMap(this.a, this.b);     // Catch: Exception -> L13
            if (r8 == null) goto L19;
            DrivePdfNavigationPlugin r2 = this.a;     // Catch: Exception -> L13
            int r3 = DrivePdfNavigationPlugin.access$parseInitPage(r2, r8);     // Catch: Exception -> L13
            if (r3 == (-1)) goto L20;
            int r4 = r3 + 1;     // Catch: Exception -> L13
            float r9 = DrivePdfNavigationPlugin.access$parseInitOffset(r2, r8);     // Catch: Exception -> L13
            tt5.a.h(DrivePdfNavigationPlugin.TAG, "onAttachToUIContainer: pageNumber:" + r4 + " offset:" + r9);     // Catch: Exception -> L13
            DrivePdfNavigationPlugin.access$scrollToPosition(r2, r4, r9);     // Catch: Exception -> L13
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isValidOffset(float r6) {
        double r0 = r6;
        if (0.0d <= r0) goto L5;
        return false;
    L5:
        if (r0 > 1.0d) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DrivePdfNavigationPlugin() {
    }

    private final Map<String, String> getUrlFragmentMap(String r2) {
        c r0 = this.urlHelper;
        if (r0 == null) goto L9;
        BearUrl r3 = r0.Z(r2);
        if (r3 == null) goto L9;
        String r4 = r3.p;
        if (r4 == null) goto L9;
        return h.o(r4);
    L9:
        return null;
    }

    private final float parseInitOffset(Map<String, String> r4) {
        double[] r5 = stringToArray(r4);     // Catch: Exception -> L7
        if (r5 == null) goto L12;
        return (float) r5[1];
    L12:
        return -1.0f;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "parseInitOffset error:" + e.getMessage());
        return -1.0f;
    }

    private final int parseInitPage(Map<String, String> r4) {
        String r5 = r4.get("page_number");     // Catch: Exception -> L7
        if (r5 == null) goto L12;
        return CastIntegerProtector.parseInt(r5);
    L12:
        return -1;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "parseInitPage error:" + e.getMessage());
        return -1;
    }

    private final double[] stringToArray(Map<String, String> r11) {
        String r12 = r11.get("bbox");     // Catch: Exception -> L15
        if (r12 == null) goto L21;
        String r4 = StringsKt.trim(r12, new char[]{'[', ']'});     // Catch: Exception -> L15
        if (r4 == null) goto L22;
        List r13 = StringsKt.split$default(r4, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L15
        if (r13 == null) goto L23;
        List r14 = r13;     // Catch: Exception -> L15
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Exception -> L15
        Iterator r16 = r14.iterator();     // Catch: Exception -> L15
    L11:
        if (r16.hasNext() == false) goto L13;
        r1.add(Double.valueOf(CastDoubleProtector.parseDouble((String) r16.next())));     // Catch: Exception -> L15
        goto L11
    L13:
        return CollectionsKt.toDoubleArray(r1);
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L15:
        e = move-exception;
        tt5.a.d(TAG, "stringToArray: error:" + e.getMessage());
        return null;
    }

    public static final /* synthetic */ Map access$getUrlFragmentMap(DrivePdfNavigationPlugin r0, String r1) {
        return r0.getUrlFragmentMap(r1);
    }

    public static final /* synthetic */ float access$parseInitOffset(DrivePdfNavigationPlugin r0, Map r1) {
        return r0.parseInitOffset(r1);
    }

    public static final /* synthetic */ int access$parseInitPage(DrivePdfNavigationPlugin r0, Map r1) {
        return r0.parseInitPage(r1);
    }

    private final void scrollToPosition(int r3, float r4) {
        tt5.a.h(TAG, "send scroll to position msg pageNumber is " + r3 + " offset:" + r4);
        if (r3 >= 0) goto L5;
        return;
    L5:
        MutableLiveData<DrivePdfState.V2Offset> r0 = ((DriveConfigurationVM) viewModel(DriveConfigurationVM.class)).getLastPreviewConfig();
        DrivePdfState.V2Offset r1 = new DrivePdfState.V2Offset();
        r1.pageNumber = r3;
        if (isValidOffset(r4) == false) goto L8;
        r1.pageOffsetTop = r4;
    L8:
        r0.postValue(r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin
    public void onAttachToUIContainer(DrivePluginHost r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        BaseOpenEntity r5 = r3.c.getOpenEntity();
        if ((r5 instanceof SpaceFileOpenEntity) == false) goto L5;
        SpaceFileOpenEntity r6 = (SpaceFileOpenEntity) r5;
    L6:
        if (r6 == null) goto L9;
        String r7 = r6.getOriginUrl();
        if (r7 == null) goto L9;
    L10:
        this.urlHelper = (c) r3.getUserComponent().a(c.class);
        ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new b(this, r7));
        return;
    L9:
        r7 = "";
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$scrollToPosition(DrivePdfNavigationPlugin r0, int r1, float r2) {
        r0.scrollToPosition(r1, r2);
    }
}
