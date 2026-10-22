package jh9;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpeakerVoice> f499113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpeakerVoice> f499114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<SpeakerVoice> f499115c;

    public f() {
        this(0);
    }

    public static f a(List r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "preloadedVoices");
        Intrinsics.checkNotNullParameter(r101, "currentVoices");
        Intrinsics.checkNotNullParameter(r102, "failedVoices");
        return new f(r100, r101, r102);
    }

    public static /* synthetic */ f b(f r100, List r101, List r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f499113a;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f499114b;
    L9:
        if ((r103 & 4) == 0) goto L11;
        List<SpeakerVoice> r104 = r100.f499115c;
    L12:
        r100.getClass();
        return a(r101, r102, r104);
    L11:
        r104 = null;
        goto L12
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f499113a, r101.f499113a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499114b, r101.f499114b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f499115c, r101.f499115c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f499113a.hashCode() * 31) + this.f499114b.hashCode()) * 31) + this.f499115c.hashCode();
    }

    public final String toString() {
        return "UgcVoiceRepoState(preloadedVoices=" + this.f499113a + ", currentVoices=" + this.f499114b + ", failedVoices=" + this.f499115c + ')';
    }

    public /* synthetic */ f(int r100) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public f(List<SpeakerVoice> r100, List<SpeakerVoice> r101, List<SpeakerVoice> r102) {
        Intrinsics.checkNotNullParameter(r100, "preloadedVoices");
        Intrinsics.checkNotNullParameter(r101, "currentVoices");
        Intrinsics.checkNotNullParameter(r102, "failedVoices");
        this.f499113a = r100;
        this.f499114b = r101;
        this.f499115c = r102;
    }
}
