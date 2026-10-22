package wj0;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f559931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TalkRoomBaseDynamicEmoji f559932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559933c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (this.f559931a == r101.f559931a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f559932b, r101.f559932b) == true) goto L10;
        return false;
    L10:
        if (this.f559933c == r101.f559933c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = this.f559931a * 31;
        TalkRoomBaseDynamicEmoji r101 = this.f559932b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f559933c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TalkRoomEmojiEvent(state=" + this.f559931a + ", emoji=" + this.f559932b + ", interceptStopSound=" + this.f559933c + ")";
    }

    public e(TalkRoomBaseDynamicEmoji r100) {
        Intrinsics.checkNotNullParameter(r100, "emoji");
        this.f559931a = 2;
        this.f559932b = r100;
        this.f559933c = false;
    }
}
