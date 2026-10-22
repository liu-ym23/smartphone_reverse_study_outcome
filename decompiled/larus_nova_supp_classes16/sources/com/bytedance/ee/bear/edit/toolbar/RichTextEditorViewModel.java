package com.bytedance.ee.bear.edit.toolbar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RichTextEditorViewModel extends ViewModel {
    private final MutableLiveData<String> mContentChanged;
    private a mDoubleCLickListener;
    private b mEditModeDelegate;
    private String mRichTextContent;
    private c mSubmitDelegate;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public b getEditModeDelegate() {
        return null;
    }

    public c getSubmitDelegate() {
        return null;
    }

    public void onCancelEdit() {
    }

    public void onClickPublish() {
    }

    public void onEnterEditMode() {
    }

    public void setDoubleCLickListener(a r1) {
    }

    public void setEditModeDelegate(b r1) {
    }

    public void setSubmitDelegate(c r1) {
    }

    public RichTextEditorViewModel() {
        this.mContentChanged = new MutableLiveData();
    }

    public MutableLiveData<String> getContentChanged() {
        return this.mContentChanged;
    }

    public String getRichTextContent() {
        return this.mRichTextContent;
    }

    public void onDoubleClick() {
        onEnterEditMode();
    }

    public void setRichTextContent(String r1) {
        this.mRichTextContent = r1;
    }
}
