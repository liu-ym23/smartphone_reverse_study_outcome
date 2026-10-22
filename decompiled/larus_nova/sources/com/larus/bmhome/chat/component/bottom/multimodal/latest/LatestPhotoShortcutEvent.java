package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutEvent;", "", "<init>", "()V", "toString", "", "QueryLatestPhoto", "UserStartInteract", "UserStopInteract", "UserConsumed", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutEvent$QueryLatestPhoto;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutEvent$UserConsumed;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutEvent$UserStartInteract;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutEvent$UserStopInteract;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LatestPhotoShortcutEvent {

    public static final class a extends LatestPhotoShortcutEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f299831a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f299831a, ((a) r100).f299831a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f299831a.hashCode();
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutEvent
        public final String toString() {
            return "QueryLatestPhoto(context=" + this.f299831a + ')';
        }

        public final Context getContext() {
            return this.f299831a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(null);
            this.f299831a = r100;
        }
    }

    public static final class b extends LatestPhotoShortcutEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f299832a = null;

        static {
            f299832a = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends LatestPhotoShortcutEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f299833a = null;

        static {
            f299833a = new c();
        }

        public c() {
            super(null);
        }
    }

    public static final class d extends LatestPhotoShortcutEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f299834a = null;

        static {
            f299834a = new d();
        }

        public d() {
            super(null);
        }
    }

    private LatestPhotoShortcutEvent() {
    }

    public /* synthetic */ LatestPhotoShortcutEvent(DefaultConstructorMarker r100) {
        this();
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
