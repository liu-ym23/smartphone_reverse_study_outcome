package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "", "<init>", "()V", "toString", "", "Hide", "Show", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState$Hide;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState$Show;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ShortcutViewState {

    public static final class a extends ShortcutViewState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f299845a = null;

        static {
            f299845a = new a();
        }

        public a() {
            super(null);
        }
    }

    public static final class b extends ShortcutViewState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f299846a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f299846a, ((b) r100).f299846a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f299846a.hashCode();
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.ShortcutViewState
        public final String toString() {
            return "Show(uri=" + this.f299846a + ')';
        }

        public b(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            super(null);
            this.f299846a = r100;
        }
    }

    private ShortcutViewState() {
    }

    public /* synthetic */ ShortcutViewState(DefaultConstructorMarker r100) {
        this();
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
