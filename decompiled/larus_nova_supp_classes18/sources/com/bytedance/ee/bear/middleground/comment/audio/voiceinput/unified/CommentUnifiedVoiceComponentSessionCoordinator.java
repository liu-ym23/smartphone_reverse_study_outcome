package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "generation", "", "active", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator$Active;", "cleared", "", "acquire", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator$Lease;", "owner", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator$Owner;", "isCurrent", "lease", "release", "", "onCleared", "Owner", "Lease", "Active", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentUnifiedVoiceComponentSessionCoordinator extends ViewModel {
    public static final b Companion = null;
    private a active;
    private boolean cleared;
    private long generation;

    public static final class a {
        public final c a;
        public final d b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Active(lease=" + this.a + ", owner=" + this.b + ')';
        }

        public a(c r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "lease");
            Intrinsics.checkNotNullParameter(r3, "owner");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {
        public final long a;
        public final CommentUnifiedVoiceComponentSessionCoordinator b;

        public c(long r2, CommentUnifiedVoiceComponentSessionCoordinator r4) {
            Intrinsics.checkNotNullParameter(r4, "coordinator");
            this.a = r2;
            this.b = r4;
        }
    }

    public interface d {
        void a();
    }

    static {
        Companion = new b();
    }

    public void onCleared() {
        this.cleared = true;
        this.generation++;
        a r0 = this.active;
        this.active = null;
        StringBuilder r1 = new StringBuilder("[coordinator] cleared, previousLease=");
        if (r0 == null) goto L7;
        c r2 = r0.a;
        if (r2 == null) goto L7;
        Object r3 = Long.valueOf(r2.a);
    L8:
        r1.append(r3);
        tt5.a.h("CommentVoice", r1.toString());
        if (r0 == null) goto L14;
        d r4 = r0.b;
        if (r4 == null) goto L15;
        r4.a();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r3 = "none";
        goto L8
    }

    public CommentUnifiedVoiceComponentSessionCoordinator() {
    }

    public final c acquire(d r8) {
        Intrinsics.checkNotNullParameter(r8, "owner");
        long r1 = this.generation + 1;
        this.generation = r1;
        c r0 = new c(r1, this);
        if (this.cleared == false) goto L6;
        tt5.a.k("CommentVoice", "[coordinator] reject acquire after cleared, lease=" + r0.a);
        return r0;
    L6:
        a r2 = this.active;
        this.active = null;
        if (r2 == null) goto L10;
        tt5.a.h("CommentVoice", "[coordinator] replace lease=" + r2.a.a + " with lease=" + r0.a);
        r2.b.a();
    L10:
        if (this.cleared == false) goto L12;
    L14:
        tt5.a.k("CommentVoice", "[coordinator] acquire superseded, lease=" + r0.a + ", generation=" + this.generation + ", cleared=" + this.cleared);
    L15:
        return r0;
    L12:
        if (this.generation != r0.a) goto L14;
        this.active = new a(r0, r8);
        tt5.a.h("CommentVoice", "[coordinator] acquire lease=" + r0.a);
        goto L15
    }

    public final boolean isCurrent(c r2) {
        Intrinsics.checkNotNullParameter(r2, "lease");
        a r0 = this.active;
        if (r0 == null) goto L5;
        c r1 = r0.a;
    L6:
        if (r1 != r2) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final void release(c r5) {
        Intrinsics.checkNotNullParameter(r5, "lease");
        a r0 = this.active;
        if (r0 == null) goto L5;
        c r1 = r0.a;
    L6:
        if (r1 != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        this.active = null;
    L11:
        tt5.a.h("CommentVoice", "[coordinator] release lease=" + r5.a + ", current=" + r2);
        return;
    L8:
        r2 = false;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
