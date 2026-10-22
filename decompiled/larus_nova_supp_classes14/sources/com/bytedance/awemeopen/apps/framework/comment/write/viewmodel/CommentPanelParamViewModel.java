package com.bytedance.awemeopen.apps.framework.comment.write.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R*\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0013\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006&"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentPanelParamViewModel;", "Landroidx/lifecycle/ViewModel;", "", "isCurrentCommentTab", "", "onAwemeChange", "", "getTabMobName", "Landroidx/lifecycle/MutableLiveData;", "commentListFragmentState", "Landroidx/lifecycle/MutableLiveData;", "getCommentListFragmentState", "()Landroidx/lifecycle/MutableLiveData;", "setCommentListFragmentState", "(Landroidx/lifecycle/MutableLiveData;)V", "", "tabVisible", "getTabVisible", "setTabVisible", "currentPagerType", "I", "getCurrentPagerType", "()I", "setCurrentPagerType", "(I)V", "quickEmojiCommentIsShowed", "Z", "getQuickEmojiCommentIsShowed", "()Z", "setQuickEmojiCommentIsShowed", "(Z)V", "miniPanelIsShowed", "getMiniPanelIsShowed", "setMiniPanelIsShowed", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentPanelParamViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String KEY = "CommentPanalParamViewModel";
    private MutableLiveData<String> commentListFragmentState;
    private int currentPagerType;
    private boolean miniPanelIsShowed;
    private boolean quickEmojiCommentIsShowed;
    private MutableLiveData<Integer> tabVisible;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static CommentPanelParamViewModel a(ViewModelStoreOwner r2) {
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
            return (CommentPanelParamViewModel) new ViewModelProvider(r2, r1).get(CommentPanelParamViewModel.KEY, CommentPanelParamViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final CommentPanelParamViewModel get(ViewModelStoreOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public final void onAwemeChange() {
        this.quickEmojiCommentIsShowed = false;
        this.miniPanelIsShowed = false;
    }

    public final String getTabMobName() {
        int r0 = this.currentPagerType;
        if (r0 != 0) goto L5;
    L10:
        return "comment_tab";
    L5:
        if (r0 == 1) goto L10;
        if (r0 == 5) goto L9;
        return null;
    L9:
        return "review_tab";
    }

    public final boolean isCurrentCommentTab() {
        int r0 = this.currentPagerType;
        if (r0 == 1) goto L8;
        if (r0 == 0) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public CommentPanelParamViewModel() {
        this.commentListFragmentState = new MutableLiveData();
        this.tabVisible = new MutableLiveData();
    }

    public final MutableLiveData<String> getCommentListFragmentState() {
        return this.commentListFragmentState;
    }

    public final int getCurrentPagerType() {
        return this.currentPagerType;
    }

    public final boolean getMiniPanelIsShowed() {
        return this.miniPanelIsShowed;
    }

    public final boolean getQuickEmojiCommentIsShowed() {
        return this.quickEmojiCommentIsShowed;
    }

    public final MutableLiveData<Integer> getTabVisible() {
        return this.tabVisible;
    }

    public final void setCommentListFragmentState(MutableLiveData<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commentListFragmentState = r2;
    }

    public final void setCurrentPagerType(int r1) {
        this.currentPagerType = r1;
    }

    public final void setMiniPanelIsShowed(boolean r1) {
        this.miniPanelIsShowed = r1;
    }

    public final void setQuickEmojiCommentIsShowed(boolean r1) {
        this.quickEmojiCommentIsShowed = r1;
    }

    public final void setTabVisible(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabVisible = r2;
    }
}
