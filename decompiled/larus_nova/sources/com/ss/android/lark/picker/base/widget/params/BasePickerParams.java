package com.ss.android.lark.picker.base.widget.params;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/params/BasePickerParams;", "", "<init>", "()V", "mRequiredList", "", "", "getMRequiredList", "()Ljava/util/List;", "setMRequiredList", "(Ljava/util/List;)V", "enableSpotLight", "", "getEnableSpotLight", "()Z", "setEnableSpotLight", "(Z)V", "enableSearchHistory", "getEnableSearchHistory", "setEnableSearchHistory", "shouldShowSelectedView", "getShouldShowSelectedView", "setShouldShowSelectedView", "tagName4Spotlight", "getTagName4Spotlight", "()Ljava/lang/String;", "setTagName4Spotlight", "(Ljava/lang/String;)V", "requiredList", "setSpotLight", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePickerParams {
    private boolean enableSearchHistory;
    private boolean enableSpotLight;
    private List<String> mRequiredList;
    private boolean shouldShowSelectedView;
    private String tagName4Spotlight;

    public BasePickerParams() {
        this.mRequiredList = new ArrayList();
        this.shouldShowSelectedView = true;
    }

    public final boolean enableSearchHistory() {
        return this.enableSearchHistory;
    }

    public final boolean enableSpotLight() {
        return this.enableSpotLight;
    }

    public final boolean getEnableSearchHistory() {
        return this.enableSearchHistory;
    }

    public final boolean getEnableSpotLight() {
        return this.enableSpotLight;
    }

    public final List<String> getMRequiredList() {
        return this.mRequiredList;
    }

    public final boolean getShouldShowSelectedView() {
        return this.shouldShowSelectedView;
    }

    public final String getTagName4Spotlight() {
        return this.tagName4Spotlight;
    }

    public final List<String> requiredList() {
        return this.mRequiredList;
    }

    public final boolean shouldShowSelectedView() {
        return this.shouldShowSelectedView;
    }

    public final String tagName4Spotlight() {
        return this.tagName4Spotlight;
    }

    public final void setEnableSearchHistory(boolean r100) {
        this.enableSearchHistory = r100;
    }

    public final void setEnableSpotLight(boolean r100) {
        this.enableSpotLight = r100;
    }

    public final void setMRequiredList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mRequiredList = r100;
    }

    public final void setShouldShowSelectedView(boolean r100) {
        this.shouldShowSelectedView = r100;
    }

    public final void setSpotLight(boolean r100) {
        this.enableSpotLight = r100;
    }

    public final void setTagName4Spotlight(String r100) {
        this.tagName4Spotlight = r100;
    }
}
