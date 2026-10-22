package com.bytedance.ee.bear.drive.core.ai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t75.d;
import t75.f;
import t75.g;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0011J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0011J\u001c\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J\u0016\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\rJ\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#J\u000e\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0018J\u0006\u00104\u001a\u00020\u0011J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\rH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00110\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00110\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00180\u00180\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiResourceContextVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mutableSnapshot", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiResourceSnapshot;", "kotlin.jvm.PlatformType", "snapshot", "Landroidx/lifecycle/LiveData;", "getSnapshot", "()Landroidx/lifecycle/LiveData;", "mutableSelectionText", "", "selectionText", "getSelectionText", "mutableConsumerEnabled", "", "consumerEnabledLiveData", "getConsumerEnabledLiveData", "mutableCaptureEnabled", "captureEnabledLiveData", "getCaptureEnabledLiveData", "mutableGeneration", "", "generationLiveData", "getGenerationLiveData", "consumerEnabled", "loadReady", "permissionReadable", "value", "currentGeneration", "getCurrentGeneration", "()J", "setConsumerEnabled", "", "enabled", "setLoadReady", "ready", "setPermissionReadable", "readable", "updateSelections", "clientGeneration", "selections", "", "Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiSelection;", "updateSelectionText", "selectedText", "clearSelections", "clear", "isCurrentGeneration", "generation", "isCaptureEnabled", "invalidateSelections", "updateCaptureEnabled", "updateSnapshot", "newValue", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        long r100 = this.currentGeneration + 1;
        this.currentGeneration = r100;
        this.mutableGeneration.setValue(Long.valueOf(r100));
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
        long r100 = 0;
        MutableLiveData<f> r101 = new MutableLiveData(new f(r100, 3));
        this.mutableSnapshot = r101;
        this.snapshot = r101;
        MutableLiveData<String> r102 = new MutableLiveData(null);
        this.mutableSelectionText = r102;
        this.selectionText = r102;
        Boolean r103 = Boolean.FALSE;
        MutableLiveData<Boolean> r104 = new MutableLiveData(r103);
        this.mutableConsumerEnabled = r104;
        this.consumerEnabledLiveData = r104;
        MutableLiveData<Boolean> r105 = new MutableLiveData(r103);
        this.mutableCaptureEnabled = r105;
        this.captureEnabledLiveData = r105;
        MutableLiveData<Long> r106 = new MutableLiveData(0L);
        this.mutableGeneration = r106;
        this.generationLiveData = r106;
    }

    private final void updateCaptureEnabled() {
        boolean r100 = isCaptureEnabled();
        if (Intrinsics.areEqual(this.mutableCaptureEnabled.getValue(), Boolean.valueOf(r100)) == true) goto L6;
        this.mutableCaptureEnabled.setValue(Boolean.valueOf(r100));
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

    private final void updateSelectionText(String r100) {
        if (Intrinsics.areEqual(this.mutableSelectionText.getValue(), r100) == true) goto L6;
        this.mutableSelectionText.setValue(r100);
        return;
    }

    private final void updateSnapshot(f r100) {
        if (Intrinsics.areEqual(this.mutableSnapshot.getValue(), r100) == true) goto L6;
        this.mutableSnapshot.setValue(r100);
        return;
    }

    public final boolean isCurrentGeneration(long r100) {
        if (r100 != this.currentGeneration) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setConsumerEnabled(boolean r100) {
        if (this.consumerEnabled != r100) goto L5;
        return;
    L5:
        this.consumerEnabled = r100;
        this.mutableConsumerEnabled.setValue(Boolean.valueOf(r100));
        if (r100 == true) goto L8;
        invalidateSelections();
    L8:
        updateCaptureEnabled();
    }

    public final void setLoadReady(boolean r100) {
        if (this.loadReady != r100) goto L5;
        return;
    L5:
        this.loadReady = r100;
        if (r100 == true) goto L8;
        invalidateSelections();
    L8:
        updateCaptureEnabled();
    }

    public final void setPermissionReadable(boolean r100) {
        if (this.permissionReadable != r100) goto L5;
        return;
    L5:
        this.permissionReadable = r100;
        if (r100 == true) goto L8;
        invalidateSelections();
    L8:
        updateCaptureEnabled();
    }

    public final void updateSelectionText(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "selectedText");
        if (isCurrentGeneration(r100) == true) goto L5;
        return;
    L5:
        if (isCaptureEnabled() == false) goto L10;
        updateSelectionText(r101);
        return;
    }

    public final void updateSelections(long r100, List<g> r110) {
        Intrinsics.checkNotNullParameter(r110, "selections");
        if (isCurrentGeneration(r100) == true) goto L5;
        return;
    L5:
        if (isCaptureEnabled() == false) goto L36;
        long r101 = this.currentGeneration;
        ArrayList r102 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L9:
        if (r111.hasNext() == false) goto L28;
        Object r103 = r111.next();
        g r104 = (g) r103;
        boolean r105 = false;
        if (r104.f544893b.length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L26;
        d r107 = r104.f544892a;
        int r108 = r107.f544885a;
        if (r108 > 0) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == true) goto L24;
        r107 = null;
    L24:
        if (r107 == null) goto L26;
        r105 = true;
        goto L26
    L18:
        if (r107.f544886b < r108) goto L20;
        r109 = true;
    L26:
        if (r105 == false) goto L9;
        r102.add(r103);
        goto L9
    L13:
        r106 = false;
        goto L14
    L28:
        updateSnapshot(new f(r101, r102));
        return;
    }
}
