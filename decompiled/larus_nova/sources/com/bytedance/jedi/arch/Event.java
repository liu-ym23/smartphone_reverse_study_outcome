package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J+\u0010\f\u001a\u00020\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\r\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/jedi/arch/Event;", ExifInterface.GPS_DIRECTION_TRUE, "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "hasBeenHandled", "", "getHasBeenHandled", "()Z", "setHasBeenHandled", "(Z)V", "checkHandled", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "consumeContent", "()Ljava/lang/Object;", "peekContent", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public class Event<T> {
    private final T content;
    private boolean hasBeenHandled;

    public final T consumeContent() {
        if (this.hasBeenHandled == false) goto L5;
        return null;
    L5:
        this.hasBeenHandled = true;
        return peekContent();
    }

    public final boolean getHasBeenHandled() {
        return this.hasBeenHandled;
    }

    public final T peekContent() {
        return this.content;
    }

    public Event(T r100) {
        this.content = r100;
    }

    public void checkHandled(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (this.hasBeenHandled == false) goto L5;
        return;
    L5:
        this.hasBeenHandled = true;
        r100.invoke(peekContent());
    }

    public final void setHasBeenHandled(boolean r100) {
        this.hasBeenHandled = r100;
    }
}
