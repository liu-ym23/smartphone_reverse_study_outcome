package com.bytedance.applet.impl.dialog;

import android.content.DialogInterface;
import androidx.lifecycle.ViewModel;
import com.bytedance.applet.impl.n0;
import com.bytedance.applet.impl.o0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\tH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applet/impl/dialog/AppletInputDialogCallbackStore;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "callbacks", "", "", "Lcom/bytedance/applet/impl/dialog/AppletInputDialogCallbackStore$Callbacks;", "register", "", "requestId", "value", "contains", "", "take", "onCleared", "Callbacks", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletInputDialogCallbackStore extends ViewModel {
    private final Map<String, a> callbacks;

    public static final class a {
        public final Function1<String, Unit> a;
        public final Function0<Unit> b;
        public final DialogInterface.OnCancelListener c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Function0<Unit> r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            DialogInterface.OnCancelListener r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Callbacks(onConfirm=" + this.a + ", onCancel=" + this.b + ", onCanceledOnTouchOutside=" + this.c + ')';
        }

        public a(n0 r2, o0 r3, DialogInterface.OnCancelListener r4) {
            Intrinsics.checkNotNullParameter(r2, "onConfirm");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public void onCleared() {
        this.callbacks.clear();
    }

    public AppletInputDialogCallbackStore() {
        this.callbacks = new LinkedHashMap();
    }

    public final boolean contains(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        return this.callbacks.containsKey(r2);
    }

    public final a take(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        return this.callbacks.remove(r2);
    }

    public final void register(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.callbacks.put(r2, r3);
    }
}
