package com.bytedance.ee.bear.sheet.attachment;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AttachmentViewModel extends ViewModel implements g45.a, VcKeyboardChangeEventProducer {
    private static final String ATTACHMENT_PANEL_NAME = "sheetAttachmentList";
    private static final String TAG = "AttachmentViewModel";
    private final MutableLiveData<Boolean> active;
    private final MutableLiveData<List<AttachmentModelList.AttachmentModel>> attachmentList;
    private boolean copyable;
    private a delegate;
    private boolean isVCFollow;
    private int panelHeight;

    public interface a {
        void a(AttachmentModelList.AttachmentModel r1);
    }

    public String getPanelName() {
        return ATTACHMENT_PANEL_NAME;
    }

    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r1, g45.a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r1, g45.a r2) {
    }

    public void closeAttachmentPanel() {
        this.active.setValue(Boolean.FALSE);
    }

    public void openAttachmentPanel() {
        if (((Boolean) this.active.getValue()).booleanValue() == true) goto L6;
        this.active.setValue(Boolean.TRUE);
        return;
    }

    public AttachmentViewModel() {
        this.attachmentList = new MutableLiveData();
        this.active = new MutableLiveData(Boolean.FALSE);
        this.isVCFollow = false;
        this.copyable = false;
    }

    public LiveData<Boolean> getActive() {
        return this.active;
    }

    public MutableLiveData<List<AttachmentModelList.AttachmentModel>> getAttachmentList() {
        return this.attachmentList;
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    }

    public boolean isCopyable() {
        return this.copyable;
    }

    public boolean isVCFollow() {
        return this.isVCFollow;
    }

    public int getPanelHeight(Context r1) {
        return this.panelHeight;
    }

    public void notifyPanelHeightChange(int r1) {
        this.panelHeight = r1;
    }

    public void requestNotFocus(Context r2) {
        this.attachmentList.setValue(new ArrayList());
    }

    public void selectAttachmentItem(AttachmentModelList.AttachmentModel r2) {
        a r0 = this.delegate;
        if (r0 == null) goto L5;
        r0.a(r2);
        return;
    L5:
        tt5.a.d(TAG, "selectAttachment, delegate is null");
    }

    public void setCopyable(boolean r1) {
        this.copyable = r1;
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }

    public void setVCFollow(boolean r1) {
        this.isVCFollow = r1;
    }
}
