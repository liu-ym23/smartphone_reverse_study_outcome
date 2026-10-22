package com.bytedance.ee.bear.edit.component;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.edit.component.richtexteditor.plugin.RichTextEditModePlugin;
import com.bytedance.ee.bear.edit.component.richtexteditor.plugin.RichTextEditorPlugin;

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

    public void setDoubleCLickListener(a r1) {
    }

    public void onCancelEdit() {
        b r0 = this.mEditModeDelegate;
        if (r0 == null) goto L6;
        RichTextEditModePlugin.access$100(((RichTextEditModePlugin.a) r0).a).b(new JSONObject());
        return;
    }

    public void onClickPublish() {
        c r0 = this.mSubmitDelegate;
        if (r0 == null) goto L6;
        RichTextEditorPlugin.a(((pa5.a) r0).a);
        return;
    }

    public void onEnterEditMode() {
        b r0 = this.mEditModeDelegate;
        if (r0 == null) goto L6;
        RichTextEditModePlugin.access$000(((RichTextEditModePlugin.a) r0).a).b(new JSONObject());
        return;
    }

    public RichTextEditorViewModel() {
        this.mContentChanged = new MutableLiveData();
    }

    public MutableLiveData<String> getContentChanged() {
        return this.mContentChanged;
    }

    public b getEditModeDelegate() {
        return this.mEditModeDelegate;
    }

    public String getRichTextContent() {
        return this.mRichTextContent;
    }

    public c getSubmitDelegate() {
        return this.mSubmitDelegate;
    }

    public void onDoubleClick() {
        onEnterEditMode();
    }

    public void setEditModeDelegate(b r1) {
        this.mEditModeDelegate = r1;
    }

    public void setRichTextContent(String r1) {
        this.mRichTextContent = r1;
    }

    public void setSubmitDelegate(c r1) {
        this.mSubmitDelegate = r1;
    }
}
