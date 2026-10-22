package com.larus.doc.sdk.impl.generalbiz.rewrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import n39.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0015J\u0018\u0010\u001c\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u001dJ,\u0010\u001e\u001a\u00020\b2$\u0010\u001f\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\b0 J,\u0010!\u001a\u00020\b2$\u0010\u001f\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\b0 J\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010%\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PartialRewriteManager;", "", "<init>", "()V", "delegates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/doc/sdk/api/IPartialRewriteService;", "addDelegate", "", "delegate", "removeDelegate", "enterStreamEditMode", "callback", "Lkotlin/Function1;", "", "enterStreamEditModeIfNeeded", "startStreamEdit", "streamEditTextContent", "text", "endStreamEdit", "cancelStreaming", "", "leaveStreamEditMode", "scene", "", "restoreSelection", "startEdit", "shouldShowBackSegment", "getSelectedText", "Lkotlin/Pair;", "addSelectedTextChangeListener", "listener", "Lkotlin/Function3;", "removeSelectedTextChangeListener", "clearReference", "resetAiEditState", "getRefBlockInfo", "notifyTrackInfoUpdate", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PartialRewriteManager {
    public static final PartialRewriteManager INSTANCE = null;
    private static CopyOnWriteArrayList<l> delegates;

    private PartialRewriteManager() {
    }

    static {
        INSTANCE = new PartialRewriteManager();
        delegates = new CopyOnWriteArrayList();
    }

    public final void clearReference() {
        Iterator<T> r100 = delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).clearReference();
        goto L4
    }

    public final void enterStreamEditModeIfNeeded() {
        Iterator<T> r100 = delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).enterStreamEditIfNeeded();
        goto L4
    }

    public final String getRefBlockInfo() {
        l r100 = (l) CollectionsKt.lastOrNull(delegates);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRefBlockInfo();
    }

    public final Pair<String, String> getSelectedText() {
        l r100 = (l) CollectionsKt.lastOrNull(delegates);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSelectedText();
    }

    public final void notifyTrackInfoUpdate() {
        Iterator<T> r100 = delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).notifyTrackInfoUpdated();
        goto L4
    }

    public final void resetAiEditState() {
        Iterator<T> r100 = delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).resetAiEditState();
        goto L4
    }

    public final boolean shouldShowBackSegment() {
        l r100 = (l) CollectionsKt.lastOrNull(delegates);
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.shouldShowBackSegment();
    }

    public final void startEdit() {
        Iterator<T> r100 = delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).handleActionBarPaste();
        goto L4
    }

    public final void startStreamEdit() {
        Iterator<T> r100 = delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l) r100.next()).startStreamEdit();
        goto L4
    }

    public final void addDelegate(l r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        if (delegates.contains(r100) == true) goto L6;
        delegates.add(r100);
        return;
    }

    public final void addSelectedTextChangeListener(Function3<? super String, ? super String, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        l r101 = (l) CollectionsKt.lastOrNull(delegates);
        if (r101 == null) goto L6;
        r101.addSelectedTextChangeListener(r100);
        return;
    }

    public final void endStreamEdit(boolean r100) {
        Iterator<T> r101 = delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((l) r101.next()).endStreamEdit(r100);
        goto L4
    }

    public final void enterStreamEditMode(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Iterator<T> r101 = delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((l) r101.next()).enterStreamEditMode(r100);
        goto L4
    }

    public final void removeDelegate(l r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        if (delegates.contains(r100) == false) goto L6;
        delegates.remove(r100);
        return;
    }

    public final void removeSelectedTextChangeListener(Function3<? super String, ? super String, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        l r101 = (l) CollectionsKt.lastOrNull(delegates);
        if (r101 == null) goto L6;
        r101.removeSelectedTextChangeListener(r100);
        return;
    }

    public final void streamEditTextContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Iterator<T> r101 = delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((l) r101.next()).streamEditTextContent(r100);
        goto L4
    }

    public final void leaveStreamEditMode(int r100, boolean r101) {
        Iterator<T> r102 = delegates.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).leaveStreamEditMode(r100, r101);
        goto L4
    }
}
