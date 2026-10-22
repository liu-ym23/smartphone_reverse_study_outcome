package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ActionPanelUIUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f414100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f414101b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f414102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f414103b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f414102a, r101.f414102a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f414103b, r101.f414103b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f414102a.hashCode() * 31) + this.f414103b.hashCode();
        }

        public final String toString() {
            return "UIViews(itemContainer=" + this.f414102a + ", popupContainer=" + this.f414103b + ')';
        }

        public a(RecyclerView r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "itemContainer");
            Intrinsics.checkNotNullParameter(r101, "popupContainer");
            this.f414102a = r100;
            this.f414103b = r101;
        }
    }

    public final Context getContext() {
        return this.f414100a;
    }

    public ActionPanelUIUtil(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f414100a = r100;
        this.f414101b = LazyKt.lazy(new ActionPanelUIUtil$partialLabelPaint$2(this));
    }
}
