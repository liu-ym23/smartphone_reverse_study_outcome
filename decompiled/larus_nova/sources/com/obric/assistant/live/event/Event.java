package com.obric.assistant.live.event;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/live/event/Event;", "", "<init>", "()V", "Destroy", UserChangedCallback.CHANGE_TYPE_UPDATE, "Lcom/obric/assistant/live/event/Event$Destroy;", "Lcom/obric/assistant/live/event/Event$Update;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Event {

    public static final class a extends Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObricInteractionScene f390069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ObricState f390070b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f390069a == r101.f390069a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f390070b, r101.f390070b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f390069a.hashCode() * 31) + this.f390070b.hashCode();
        }

        public final String toString() {
            return "Destroy(scene=" + this.f390069a + ", state=" + this.f390070b + ')';
        }

        public a(ObricInteractionScene r100, ObricState r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "state");
            super(null);
            this.f390069a = r100;
            this.f390070b = r101;
        }
    }

    public static final class b extends Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObricInteractionScene f390071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ObricState f390072b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f390071a == r101.f390071a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f390072b, r101.f390072b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f390071a.hashCode() * 31) + this.f390072b.hashCode();
        }

        public final String toString() {
            return "Update(scene=" + this.f390071a + ", state=" + this.f390072b + ')';
        }

        public b(ObricInteractionScene r100, ObricState r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "state");
            super(null);
            this.f390071a = r100;
            this.f390072b = r101;
        }
    }

    private Event() {
    }

    public /* synthetic */ Event(DefaultConstructorMarker r100) {
        this();
    }
}
