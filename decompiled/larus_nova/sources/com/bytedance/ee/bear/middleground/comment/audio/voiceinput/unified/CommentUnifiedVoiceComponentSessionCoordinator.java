package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "generation", "", "active", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator$Active;", "cleared", "", "acquire", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator$Lease;", "owner", "Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentSessionCoordinator$Owner;", "isCurrent", "lease", "release", "", "onCleared", "Owner", "Lease", "Active", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentUnifiedVoiceComponentSessionCoordinator extends ViewModel {
    public static final b Companion = null;
    private a active;
    private boolean cleared;
    private long generation;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f230589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f230590b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f230589a, r101.f230589a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f230590b, r101.f230590b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f230589a.hashCode() * 31) + this.f230590b.hashCode();
        }

        public final String toString() {
            return "Active(lease=" + this.f230589a + ", owner=" + this.f230590b + ')';
        }

        public a(c r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "lease");
            Intrinsics.checkNotNullParameter(r101, "owner");
            this.f230589a = r100;
            this.f230590b = r101;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f230591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CommentUnifiedVoiceComponentSessionCoordinator f230592b;

        public c(long r100, CommentUnifiedVoiceComponentSessionCoordinator r101) {
            Intrinsics.checkNotNullParameter(r101, "coordinator");
            this.f230591a = r100;
            this.f230592b = r101;
        }
    }

    public interface d {
        void a();
    }

    static {
        Companion = new b();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.cleared = true;
        this.generation++;
        a r100 = this.active;
        this.active = null;
        StringBuilder r101 = new StringBuilder("[coordinator] cleared, previousLease=");
        if (r100 == null) goto L7;
        c r102 = r100.f230589a;
        if (r102 == null) goto L7;
        Object r103 = Long.valueOf(r102.f230591a);
    L8:
        r101.append(r103);
        tt5.a.h("CommentVoice", r101.toString());
        if (r100 == null) goto L14;
        d r104 = r100.f230590b;
        if (r104 == null) goto L15;
        r104.a();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r103 = "none";
        goto L8
    }

    public CommentUnifiedVoiceComponentSessionCoordinator() {
    }

    public final c acquire(d r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        long r101 = this.generation + 1;
        this.generation = r101;
        c r102 = new c(r101, this);
        if (this.cleared == false) goto L6;
        tt5.a.k("CommentVoice", "[coordinator] reject acquire after cleared, lease=" + r102.f230591a);
        return r102;
    L6:
        a r103 = this.active;
        this.active = null;
        if (r103 == null) goto L10;
        tt5.a.h("CommentVoice", "[coordinator] replace lease=" + r103.f230589a.f230591a + " with lease=" + r102.f230591a);
        r103.f230590b.a();
    L10:
        if (this.cleared == false) goto L12;
    L14:
        tt5.a.k("CommentVoice", "[coordinator] acquire superseded, lease=" + r102.f230591a + ", generation=" + this.generation + ", cleared=" + this.cleared);
    L15:
        return r102;
    L12:
        if (this.generation != r102.f230591a) goto L14;
        this.active = new a(r102, r100);
        tt5.a.h("CommentVoice", "[coordinator] acquire lease=" + r102.f230591a);
        goto L15
    }

    public final boolean isCurrent(c r100) {
        Intrinsics.checkNotNullParameter(r100, "lease");
        a r101 = this.active;
        if (r101 == null) goto L5;
        c r102 = r101.f230589a;
    L6:
        if (r102 != r100) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final void release(c r100) {
        Intrinsics.checkNotNullParameter(r100, "lease");
        a r101 = this.active;
        if (r101 == null) goto L5;
        c r102 = r101.f230589a;
    L6:
        if (r102 != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        this.active = null;
    L11:
        tt5.a.h("CommentVoice", "[coordinator] release lease=" + r100.f230591a + ", current=" + r103);
        return;
    L8:
        r103 = false;
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
