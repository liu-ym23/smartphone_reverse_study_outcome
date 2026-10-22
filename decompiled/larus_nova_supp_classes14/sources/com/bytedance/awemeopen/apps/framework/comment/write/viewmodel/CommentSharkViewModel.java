package com.bytedance.awemeopen.apps.framework.comment.write.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b'\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010!\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$¨\u0006-"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentSharkViewModel;", "Landroidx/lifecycle/ViewModel;", "", "time", "", "isValue", "", "onAwemeChange", "onParamChange", "(Ljava/lang/Long;)V", "onClickInput", "onKeyboardPanelShowTime", "onPublishTime", "getClickCommentDuration", "getPublishDuration", "resetPublishParam", "resetClickCommentParam", "startAwemeTime", "J", "getStartAwemeTime", "()J", "setStartAwemeTime", "(J)V", "clickInputTime", "getClickInputTime", "setClickInputTime", "panelShowTime", "getPanelShowTime", "setPanelShowTime", "publishTime", "getPublishTime", "setPublishTime", "isFirstClickInput", "Z", "()Z", "setFirstClickInput", "(Z)V", "isKeyboardShow", "setKeyboardShow", "isFirstPublish", "setFirstPublish", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentSharkViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "CommentSharkViewModel";
    private long clickInputTime;
    private boolean isFirstClickInput;
    private boolean isFirstPublish;
    private boolean isKeyboardShow;
    private long panelShowTime;
    private long publishTime;
    private long startAwemeTime;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static CommentSharkViewModel a(ViewModelStoreOwner r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            if ((r2 instanceof Fragment) == false) goto L10;
            Fragment r0 = (Fragment) r2;
            if (r0.isDetached() == false) goto L7;
            return null;
        L7:
            if (r0.getContext() != null) goto L10;
            return null;
        L10:
            ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
            r1.getClass();
            return (CommentSharkViewModel) new ViewModelProvider(r2, r1).get(CommentSharkViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final CommentSharkViewModel get(ViewModelStoreOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    private final boolean isValue(long r4) {
        if (r4 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getClickCommentDuration() {
        if (isValue(this.clickInputTime) == true) goto L5;
        return 0;
    L5:
        if (isValue(this.startAwemeTime) == false) goto L12;
        long r3 = this.clickInputTime - this.startAwemeTime;
        if (r3 >= 0) goto L10;
        return 0;
    L10:
        return r3;
    L12:
        return 0;
    }

    public final long getPublishDuration() {
        if (isValue(this.publishTime) == true) goto L5;
        return 0;
    L5:
        if (isValue(this.panelShowTime) == false) goto L12;
        long r3 = this.publishTime - this.panelShowTime;
        if (r3 >= 0) goto L10;
        return 0;
    L10:
        return r3;
    L12:
        return 0;
    }

    public final void onAwemeChange() {
        this.startAwemeTime = 0;
        resetClickCommentParam();
        resetPublishParam();
    }

    public final void onClickInput() {
        if (this.isFirstClickInput == false) goto L5;
        this.clickInputTime = System.currentTimeMillis();
    L5:
        this.isFirstClickInput = false;
    }

    public final void onKeyboardPanelShowTime() {
        if (this.isKeyboardShow == false) goto L5;
        this.panelShowTime = System.currentTimeMillis();
    L5:
        this.isKeyboardShow = false;
    }

    public final void onPublishTime() {
        if (this.isFirstPublish == false) goto L5;
        this.publishTime = System.currentTimeMillis();
    L5:
        this.isFirstPublish = false;
    }

    public final void resetClickCommentParam() {
        this.clickInputTime = 0;
        this.isFirstClickInput = true;
    }

    public final void resetPublishParam() {
        this.panelShowTime = 0;
        this.publishTime = 0;
        this.isKeyboardShow = true;
        this.isFirstPublish = true;
    }

    public CommentSharkViewModel() {
        this.isFirstClickInput = true;
        this.isKeyboardShow = true;
        this.isFirstPublish = true;
    }

    public final long getClickInputTime() {
        return this.clickInputTime;
    }

    public final long getPanelShowTime() {
        return this.panelShowTime;
    }

    public final long getPublishTime() {
        return this.publishTime;
    }

    public final long getStartAwemeTime() {
        return this.startAwemeTime;
    }

    public final boolean isFirstClickInput() {
        return this.isFirstClickInput;
    }

    public final boolean isFirstPublish() {
        return this.isFirstPublish;
    }

    public final boolean isKeyboardShow() {
        return this.isKeyboardShow;
    }

    public final void onParamChange(Long r3) {
        if (r3 == null) goto L4;
        long r0 = r3.longValue();
    L5:
        this.startAwemeTime = r0;
        return;
    L4:
        r0 = 0;
        goto L5
    }

    public final void setClickInputTime(long r1) {
        this.clickInputTime = r1;
    }

    public final void setFirstClickInput(boolean r1) {
        this.isFirstClickInput = r1;
    }

    public final void setFirstPublish(boolean r1) {
        this.isFirstPublish = r1;
    }

    public final void setKeyboardShow(boolean r1) {
        this.isKeyboardShow = r1;
    }

    public final void setPanelShowTime(long r1) {
        this.panelShowTime = r1;
    }

    public final void setPublishTime(long r1) {
        this.publishTime = r1;
    }

    public final void setStartAwemeTime(long r1) {
        this.startAwemeTime = r1;
    }
}
