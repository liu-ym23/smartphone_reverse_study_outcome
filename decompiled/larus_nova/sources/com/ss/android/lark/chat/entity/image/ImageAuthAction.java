package com.ss.android.lark.chat.entity.image;

import com.larksuite.framework.utils.CollectionUtils;
import java.io.Serializable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chat/entity/image/ImageAuthAction;", "Ljava/io/Serializable;", "<init>", "()V", "authSet", "Ljava/util/HashSet;", "Lcom/ss/android/lark/chat/entity/image/ImageAuthType;", "Lkotlin/collections/HashSet;", "getAuthSet", "()Ljava/util/HashSet;", "setAuthSet", "(Ljava/util/HashSet;)V", "previewAction", "Lkotlin/Function0;", "", "getPreviewAction", "()Lkotlin/jvm/functions/Function0;", "setPreviewAction", "(Lkotlin/jvm/functions/Function0;)V", "shareAction", "getShareAction", "setShareAction", "previewNormalAction", "getPreviewNormalAction", "setPreviewNormalAction", "shareNormalAction", "getShareNormalAction", "setShareNormalAction", "isAccessAuth", "", "handleAction", "handleNormalAction", "isPreViewAuthDisable", "isShareAuthDisable", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageAuthAction implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Function0<Unit> f415200a;
    private HashSet<ImageAuthType> authSet;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Function0<Unit> f415201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Function0<Unit> f415202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient Function0<Unit> f415203d;

    public final void handleAction() {
        if (this.authSet.contains(ImageAuthType.SHARE_AUTH) == false) goto L6;
        this.f415201b.invoke();
        return;
    L6:
        if (this.authSet.contains(ImageAuthType.PREVIEW_AUTH) == false) goto L10;
        this.f415200a.invoke();
        return;
    }

    public final void handleNormalAction() {
        this.f415202c.invoke();
        this.f415203d.invoke();
    }

    public final boolean isAccessAuth() {
        return CollectionUtils.isEmpty(this.authSet);
    }

    public final boolean isPreViewAuthDisable() {
        return this.authSet.contains(ImageAuthType.PREVIEW_AUTH);
    }

    public final boolean isShareAuthDisable() {
        return this.authSet.contains(ImageAuthType.SHARE_AUTH);
    }

    public ImageAuthAction() {
        this.authSet = new HashSet();
        this.f415200a = ImageAuthAction$previewAction$1.INSTANCE;
        this.f415201b = ImageAuthAction$shareAction$1.INSTANCE;
        this.f415202c = ImageAuthAction$previewNormalAction$1.INSTANCE;
        this.f415203d = ImageAuthAction$shareNormalAction$1.INSTANCE;
    }

    public final HashSet<ImageAuthType> getAuthSet() {
        return this.authSet;
    }

    public final Function0<Unit> getPreviewAction() {
        return this.f415200a;
    }

    public final Function0<Unit> getPreviewNormalAction() {
        return this.f415202c;
    }

    public final Function0<Unit> getShareAction() {
        return this.f415201b;
    }

    public final Function0<Unit> getShareNormalAction() {
        return this.f415203d;
    }

    public final void setAuthSet(HashSet<ImageAuthType> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.authSet = r100;
    }

    public final void setPreviewAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f415200a = r100;
    }

    public final void setPreviewNormalAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f415202c = r100;
    }

    public final void setShareAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f415201b = r100;
    }

    public final void setShareNormalAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f415203d = r100;
    }
}
