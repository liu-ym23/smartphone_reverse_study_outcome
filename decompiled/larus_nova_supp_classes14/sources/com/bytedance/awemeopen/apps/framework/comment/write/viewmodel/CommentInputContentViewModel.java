package com.bytedance.awemeopen.apps.framework.comment.write.viewmodel;

import android.text.Editable;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b+\u0010,J\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fR$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u001f\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001d8\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010 R%\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010#0\u001d8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010 R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001d8\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010 R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentInputContentViewModel;", "Landroidx/lifecycle/ViewModel;", "", "aid", "replyCommentCid", "getSaveKey", "Landroid/text/Editable;", "content", "", "putContent", "getContent", "Lq14/a;", "emoji", "putEmoji", "resetAweme", "", "isAfterPublish", "removeRecord", "Landroidx/collection/LruCache;", "Lfz3/a;", "commentHistoryMap", "Landroidx/collection/LruCache;", "Lo14/a;", "currentReplyComment", "Lo14/a;", "getCurrentReplyComment", "()Lo14/a;", "setCurrentReplyComment", "(Lo14/a;)V", "Landroidx/lifecycle/MutableLiveData;", "isKeyboardPanelShow", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "contentLiveData", "getContentLiveData", "", "publishContentLiveData", "getPublishContentLiveData", "", "publishSuccessLiveData", "getPublishSuccessLiveData", "lastAwemeId", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentInputContentViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String JOINT = ":";
    private static final String KEY = "CommentInputContentViewModel";
    private LruCache<String, fz3.a> commentHistoryMap;
    private final MutableLiveData<Editable> contentLiveData;
    private o14.a currentReplyComment;
    private final MutableLiveData<Boolean> isKeyboardPanelShow;
    private String lastAwemeId;
    private final MutableLiveData<List<o14.a>> publishContentLiveData;
    private final MutableLiveData<Integer> publishSuccessLiveData;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static CommentInputContentViewModel a(ViewModelStoreOwner r2) {
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
            return (CommentInputContentViewModel) new ViewModelProvider(r2, r1).get(CommentInputContentViewModel.KEY, CommentInputContentViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final CommentInputContentViewModel get(ViewModelStoreOwner r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public CommentInputContentViewModel() {
        this.commentHistoryMap = new LruCache(20);
        this.isKeyboardPanelShow = new MutableLiveData();
        this.contentLiveData = new MutableLiveData();
        this.publishContentLiveData = new MutableLiveData();
        this.publishSuccessLiveData = new MutableLiveData();
    }

    public final MutableLiveData<Editable> getContentLiveData() {
        return this.contentLiveData;
    }

    public final o14.a getCurrentReplyComment() {
        return this.currentReplyComment;
    }

    public final MutableLiveData<List<o14.a>> getPublishContentLiveData() {
        return this.publishContentLiveData;
    }

    public final MutableLiveData<Integer> getPublishSuccessLiveData() {
        return this.publishSuccessLiveData;
    }

    public final MutableLiveData<Boolean> isKeyboardPanelShow() {
        return this.isKeyboardPanelShow;
    }

    public final Editable getContent(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        o14.a r1 = this.currentReplyComment;
        if (r1 == null) goto L14;
        String r2 = r1.cid;
    L15:
        fz3.a r4 = (fz3.a) this.commentHistoryMap.get(getSaveKey(r3, r2));
        if (r4 != null) goto L18;
        return null;
    L18:
        return r4.a;
    L14:
        r2 = null;
        goto L15
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public final void resetAweme(String r3) {
        if (Intrinsics.areEqual(this.lastAwemeId, r3) == true) goto L6;
        this.currentReplyComment = null;
        this.contentLiveData.setValue(null);
        this.lastAwemeId = r3;
        return;
    }

    public final void setCurrentReplyComment(o14.a r1) {
        this.currentReplyComment = r1;
    }

    private final String getSaveKey(String r4, String r5) {
        boolean r1 = true;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return "";
    L8:
        if (r5 != null) goto L10;
    L13:
        if (r1 == false) goto L15;
        return r4;
    L15:
        if (Intrinsics.areEqual(r5, "0") == false) goto L18;
        return r4;
    L18:
        return r4 + ':' + r5;
    L10:
        if (r5.length() == 0) goto L13;
        r1 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void putContent(String r5, Editable r6) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        o14.a r3 = this.currentReplyComment;
        if (r3 == null) goto L14;
        String r4 = r3.cid;
    L15:
        String r7 = getSaveKey(r5, r4);
        fz3.a r8 = (fz3.a) this.commentHistoryMap.get(r7);
        if (r8 == null) goto L18;
        r8.a = r6;
    L24:
        this.contentLiveData.setValue(r6);
        return;
    L18:
        if (r6 != null) goto L20;
    L21:
        r0 = true;
    L22:
        if (r0 == true) goto L24;
        this.commentHistoryMap.put(r7, new fz3.a(r6, null));
        goto L24
    L20:
        if (r6.length() != 0) goto L22;
    L14:
        r4 = null;
        goto L15
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void putEmoji(String r4, q14.a r5) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        o14.a r1 = this.currentReplyComment;
        if (r1 == null) goto L13;
        String r2 = r1.cid;
    L14:
        String r6 = getSaveKey(r4, r2);
        fz3.a r3 = (fz3.a) this.commentHistoryMap.get(r6);
        if (r3 == null) goto L17;
        r3.b = r5;
        return;
    L17:
        if (r5 == null) goto L21;
        this.commentHistoryMap.put(r6, new fz3.a(null, r5));
        return;
    L21:
        return;
    L13:
        r2 = null;
        goto L14
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void removeRecord(String r3, boolean r4) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L16;
        if (r4 == false) goto L16;
        LruCache<String, fz3.a> r5 = this.commentHistoryMap;
        o14.a r1 = this.currentReplyComment;
        if (r1 == null) goto L14;
        String r2 = r1.cid;
    L15:
        r5.remove(getSaveKey(r3, r2));
        goto L16
    L14:
        r2 = null;
    L16:
        this.currentReplyComment = null;
        this.contentLiveData.setValue(null);
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
