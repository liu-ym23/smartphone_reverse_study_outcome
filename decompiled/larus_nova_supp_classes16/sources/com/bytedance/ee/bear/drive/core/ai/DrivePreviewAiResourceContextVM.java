package com.bytedance.ee.bear.drive.core.ai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t75.d;
import t75.f;
import t75.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0011J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0011J\u001c\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J\u0016\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\rJ\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#J\u000e\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0018J\u0006\u00104\u001a\u00020\u0011J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\rH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00110\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00110\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00180\u00180\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiResourceContextVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mutableSnapshot", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiResourceSnapshot;", "kotlin.jvm.PlatformType", "snapshot", "Landroidx/lifecycle/LiveData;", "getSnapshot", "()Landroidx/lifecycle/LiveData;", "mutableSelectionText", "", "selectionText", "getSelectionText", "mutableConsumerEnabled", "", "consumerEnabledLiveData", "getConsumerEnabledLiveData", "mutableCaptureEnabled", "captureEnabledLiveData", "getCaptureEnabledLiveData", "mutableGeneration", "", "generationLiveData", "getGenerationLiveData", "consumerEnabled", "loadReady", "permissionReadable", "value", "currentGeneration", "getCurrentGeneration", "()J", "setConsumerEnabled", "", "enabled", "setLoadReady", "ready", "setPermissionReadable", "readable", "updateSelections", "clientGeneration", "selections", "", "Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiSelection;", "updateSelectionText", "selectedText", "clearSelections", RectColorView.RectColorType.TYPE_CLEAR, "isCurrentGeneration", "generation", "isCaptureEnabled", "invalidateSelections", "updateCaptureEnabled", "updateSnapshot", "newValue", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewAiResourceContextVM extends ViewModel {
    private final LiveData<Boolean> captureEnabledLiveData;
    private boolean consumerEnabled;
    private final LiveData<Boolean> consumerEnabledLiveData;
    private long currentGeneration;
    private final LiveData<Long> generationLiveData;
    private boolean loadReady;
    private final MutableLiveData<Boolean> mutableCaptureEnabled;
    private final MutableLiveData<Boolean> mutableConsumerEnabled;
    private final MutableLiveData<Long> mutableGeneration;
    private final MutableLiveData<String> mutableSelectionText;
    private final MutableLiveData<f> mutableSnapshot;
    private boolean permissionReadable;
    private final LiveData<String> selectionText;
    private final LiveData<f> snapshot;

    private final void invalidateSelections() {
        long r0 = this.currentGeneration + 1;
        this.currentGeneration = r0;
        this.mutableGeneration.setValue(Long.valueOf(r0));
        updateSnapshot(new f(this.currentGeneration, 2));
        updateSelectionText("");
    }

    public final void clearSelections() {
        updateSnapshot(new f(this.currentGeneration, 2));
        updateSelectionText("");
    }

    public final boolean isCaptureEnabled() {
        if (this.consumerEnabled == true) goto L5;
    L9:
        return false;
    L5:
        if (this.loadReady == false) goto L9;
        if (this.permissionReadable == false) goto L9;
        return true;
    }

    public DrivePreviewAiResourceContextVM() {
        MutableLiveData<f> r0 = new MutableLiveData(new f(0, 3));
        this.mutableSnapshot = r0;
        this.snapshot = r0;
        MutableLiveData<String> r1 = new MutableLiveData(null);
        this.mutableSelectionText = r1;
        this.selectionText = r1;
        Boolean r2 = Boolean.FALSE;
        MutableLiveData<Boolean> r3 = new MutableLiveData(r2);
        this.mutableConsumerEnabled = r3;
        this.consumerEnabledLiveData = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData(r2);
        this.mutableCaptureEnabled = r4;
        this.captureEnabledLiveData = r4;
        MutableLiveData<Long> r5 = new MutableLiveData(0L);
        this.mutableGeneration = r5;
        this.generationLiveData = r5;
    }

    private final void updateCaptureEnabled() {
        boolean r0 = isCaptureEnabled();
        if (Intrinsics.areEqual(this.mutableCaptureEnabled.getValue(), Boolean.valueOf(r0)) == true) goto L6;
        this.mutableCaptureEnabled.setValue(Boolean.valueOf(r0));
        return;
    }

    public final void clear() {
        invalidateSelections();
    }

    public final LiveData<Boolean> getCaptureEnabledLiveData() {
        return this.captureEnabledLiveData;
    }

    public final LiveData<Boolean> getConsumerEnabledLiveData() {
        return this.consumerEnabledLiveData;
    }

    public final long getCurrentGeneration() {
        return this.currentGeneration;
    }

    public final LiveData<Long> getGenerationLiveData() {
        return this.generationLiveData;
    }

    public final LiveData<String> getSelectionText() {
        return this.selectionText;
    }

    public final LiveData<f> getSnapshot() {
        return this.snapshot;
    }

    private final void updateSelectionText(String r2) {
        if (Intrinsics.areEqual(this.mutableSelectionText.getValue(), r2) == true) goto L6;
        this.mutableSelectionText.setValue(r2);
        return;
    }

    private final void updateSnapshot(f r2) {
        if (Intrinsics.areEqual(this.mutableSnapshot.getValue(), r2) == true) goto L6;
        this.mutableSnapshot.setValue(r2);
        return;
    }

    public final boolean isCurrentGeneration(long r4) {
        if (r4 != this.currentGeneration) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setConsumerEnabled(boolean r3) {
        if (this.consumerEnabled != r3) goto L5;
        return;
    L5:
        this.consumerEnabled = r3;
        this.mutableConsumerEnabled.setValue(Boolean.valueOf(r3));
        if (r3 == true) goto L8;
        invalidateSelections();
    L8:
        updateCaptureEnabled();
    }

    public final void setLoadReady(boolean r2) {
        if (this.loadReady != r2) goto L5;
        return;
    L5:
        this.loadReady = r2;
        if (r2 == true) goto L8;
        invalidateSelections();
    L8:
        updateCaptureEnabled();
    }

    public final void setPermissionReadable(boolean r2) {
        if (this.permissionReadable != r2) goto L5;
        return;
    L5:
        this.permissionReadable = r2;
        if (r2 == true) goto L8;
        invalidateSelections();
    L8:
        updateCaptureEnabled();
    }

    public final void updateSelectionText(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "selectedText");
        if (isCurrentGeneration(r2) == true) goto L5;
        return;
    L5:
        if (isCaptureEnabled() == false) goto L10;
        updateSelectionText(r4);
        return;
    }

    public final void updateSelections(long r8, List<g> r10) {
        Intrinsics.checkNotNullParameter(r10, "selections");
        if (isCurrentGeneration(r8) == true) goto L5;
        return;
    L5:
        if (isCaptureEnabled() == false) goto L36;
        long r9 = this.currentGeneration;
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L28;
        Object r1 = r11.next();
        g r2 = (g) r1;
        boolean r4 = false;
        if (r2.b.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L26;
        d r5 = r2.a;
        int r6 = r5.a;
        if (r6 > 0) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L26;
        r4 = true;
        goto L26
    L18:
        if (r5.b < r6) goto L20;
        r7 = true;
    L26:
        if (r4 == false) goto L9;
        r0.add(r1);
        goto L9
    L13:
        r3 = false;
        goto L14
    L28:
        updateSnapshot(new f(r9, r0));
        return;
    }
}
