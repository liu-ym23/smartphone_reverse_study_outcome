package com.bytedance.ee.bear.sheet.attachment;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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
        void a(AttachmentModelList.AttachmentModel r100);
    }

    @Override // g45.a
    public String getPanelName() {
        return ATTACHMENT_PANEL_NAME;
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeActive(g45.d r100, g45.a r101) {
    }

    @Override // g45.a
    public /* bridge */ /* synthetic */ void onBecomeInactive(g45.d r100, g45.a r101) {
    }

    public void closeAttachmentPanel() {
        this.active.setValue(Boolean.FALSE);
    }

    public void openAttachmentPanel() {
        if (this.active.getValue().booleanValue() == true) goto L6;
        this.active.setValue(Boolean.TRUE);
        return;
    }

    public AttachmentViewModel() {
        this.attachmentList = new MutableLiveData();
        this.active = new MutableLiveData(Boolean.FALSE);
        this.isVCFollow = false;
        this.copyable = false;
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        return this.active;
    }

    public MutableLiveData<List<AttachmentModelList.AttachmentModel>> getAttachmentList() {
        return this.attachmentList;
    }

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ALWAYS_HIDE;
    }

    public boolean isCopyable() {
        return this.copyable;
    }

    public boolean isVCFollow() {
        return this.isVCFollow;
    }

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        return this.panelHeight;
    }

    public void notifyPanelHeightChange(int r100) {
        this.panelHeight = r100;
    }

    @Override // g45.a
    public void requestNotFocus(Context r100) {
        this.attachmentList.setValue(new ArrayList());
    }

    public void selectAttachmentItem(AttachmentModelList.AttachmentModel r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L5;
        r101.a(r100);
        return;
    L5:
        tt5.a.d(TAG, "selectAttachment, delegate is null");
    }

    public void setCopyable(boolean r100) {
        this.copyable = r100;
    }

    public void setDelegate(a r100) {
        this.delegate = r100;
    }

    public void setVCFollow(boolean r100) {
        this.isVCFollow = r100;
    }
}
