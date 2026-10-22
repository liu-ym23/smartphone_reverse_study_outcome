package com.larus.audio.call.mgr;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes24.dex */
public abstract class MajorState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f289171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f289172b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/call/mgr/MajorState$CheckResult;", "", "move", "", "dispatch", "<init>", "(Ljava/lang/String;IZZ)V", "getMove", "()Z", "getDispatch", EffectConstants.NORMAL, "INTERCEPT", "UNDISPATCH", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckResult extends Enum<CheckResult> {
        public static final CheckResult INTERCEPT = null;
        public static final CheckResult NORMAL = null;
        public static final CheckResult UNDISPATCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckResult[] f289173a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289174b = null;
        private final boolean dispatch;
        private final boolean move;

        public static EnumEntries<CheckResult> getEntries() {
            return f289174b;
        }

        static {
            CheckResult r100 = new CheckResult(EffectConstants.NORMAL, 0, true, true);
            NORMAL = r100;
            CheckResult r101 = new CheckResult("INTERCEPT", 1, false, false);
            INTERCEPT = r101;
            CheckResult r102 = new CheckResult("UNDISPATCH", 2, true, false);
            UNDISPATCH = r102;
            CheckResult[] r103 = {r100, r101, r102};
            f289173a = r103;
            f289174b = EnumEntriesKt.enumEntries(r103);
        }

        public static CheckResult[] values() {
            return (CheckResult[]) f289173a.clone();
        }

        public final boolean getDispatch() {
            return this.dispatch;
        }

        public final boolean getMove() {
            return this.move;
        }

        public static CheckResult valueOf(String r100) {
            return (CheckResult) r27.a.a(CheckResult.class, r100);
        }

        public CheckResult(String r100, int r101, boolean r102, boolean r103) {
            super(r100, r101);
            this.move = r102;
            this.dispatch = r103;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/call/mgr/MajorState$From;", "", "<init>", "(Ljava/lang/String;I)V", "ASR", "TTS_ENDED", "PLAY_COMPLETE", "RESUME", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum From extends Enum<From> {
        public static final From ASR = null;
        public static final From PLAY_COMPLETE = null;
        public static final From RESUME = null;
        public static final From TTS_ENDED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ From[] f289175a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289176b = null;

        public static EnumEntries<From> getEntries() {
            return f289176b;
        }

        static {
            From r100 = new From("ASR", 0);
            ASR = r100;
            From r101 = new From("TTS_ENDED", 1);
            TTS_ENDED = r101;
            From r102 = new From("PLAY_COMPLETE", 2);
            PLAY_COMPLETE = r102;
            From r103 = new From("RESUME", 3);
            RESUME = r103;
            From[] r104 = {r100, r101, r102, r103};
            f289175a = r104;
            f289176b = EnumEntriesKt.enumEntries(r104);
        }

        public static From[] values() {
            return (From[]) f289175a.clone();
        }

        public static From valueOf(String r100) {
            return (From) r27.a.a(From.class, r100);
        }

        public From(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/mgr/MajorState$InterruptType;", "", MessageIndication.STATUS_INTERRUPT, "", "<init>", "(Ljava/lang/String;IZ)V", "getInterrupt", "()Z", "NOTHING", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "AUTO", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InterruptType extends Enum<InterruptType> {
        public static final InterruptType AUTO = null;
        public static final InterruptType NOTHING = null;
        public static final InterruptType USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InterruptType[] f289177a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289178b = null;
        private final boolean interrupt;

        public static EnumEntries<InterruptType> getEntries() {
            return f289178b;
        }

        static {
            InterruptType r100 = new InterruptType("NOTHING", 0, false);
            NOTHING = r100;
            InterruptType r101 = new InterruptType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, true);
            USER = r101;
            InterruptType r102 = new InterruptType("AUTO", 2, true);
            AUTO = r102;
            InterruptType[] r103 = {r100, r101, r102};
            f289177a = r103;
            f289178b = EnumEntriesKt.enumEntries(r103);
        }

        public static InterruptType[] values() {
            return (InterruptType[]) f289177a.clone();
        }

        public final boolean getInterrupt() {
            return this.interrupt;
        }

        public static InterruptType valueOf(String r100) {
            return (InterruptType) r27.a.a(InterruptType.class, r100);
        }

        public InterruptType(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.interrupt = r102;
        }
    }

    public static final class a extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f289179c = null;

        static {
            f289179c = new a();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Connecting";
        }

        public a() {
            super(1, WsConstants.KEY_CONNECTION);
        }
    }

    public static final class b extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f289180c = null;

        static {
            f289180c = new b();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Ending";
        }

        public b() {
            super(18, "Ending");
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final CheckResult a(MajorState r100) {
            Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
            if ((r100 instanceof h) == false) goto L7;
            return CheckResult.INTERCEPT;
        L7:
            return super.a(r100);
        }
    }

    public static final class c extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f289181c = null;

        static {
            f289181c = new c();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Invalid";
        }

        public c() {
            super(-1, "invalid");
        }
    }

    public static final class d extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final From f289182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final InterruptType f289183d;

        @Override // com.larus.audio.call.mgr.MajorState
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f289182c == r101.f289182c) goto L12;
            return false;
        L12:
            if (this.f289183d == r101.f289183d) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final int hashCode() {
            return (this.f289182c.hashCode() * 31) + this.f289183d.hashCode();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Listening(from=" + this.f289182c + ", interruptType=" + this.f289183d + ')';
        }

        public d(From r100, InterruptType r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, "interruptType");
            super(3, "listening");
            this.f289182c = r100;
            this.f289183d = r101;
        }
    }

    public static final class e extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f289184c = null;

        static {
            f289184c = new e();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "ListeningAndSpeaking";
        }

        public e() {
            super(17, "listening_and_speaking");
        }
    }

    public static final class f extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f289185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f289186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f289187e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f289188f;

        public f() {
            int r100 = 0;
            this(r100, r100, null, 15);
        }

        public /* synthetic */ f(int r100, int r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = -1;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = -1;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102, null);
        }

        public f(int r100, int r101, String r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r102, "errorMsgDetail");
            super(6, BuyNowCloseMethod.NETWORK_ERROR);
            this.f289185c = r100;
            this.f289186d = r101;
            this.f289187e = r102;
            this.f289188f = r103;
        }
    }

    public static final class g extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MajorState f289189c;

        @Override // com.larus.audio.call.mgr.MajorState
        public final int hashCode() {
            return this.f289189c.hashCode();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Paused(prev=" + this.f289189c + ')';
        }

        public g(MajorState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            super(7, "paused");
            if ((r100 instanceof g) == false) goto L5;
            r100 = ((g) r100).f289189c;
        L5:
            this.f289189c = r100;
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final CheckResult a(MajorState r100) {
            Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
            if ((r100 instanceof g) == false) goto L7;
            return CheckResult.UNDISPATCH;
        L7:
            return super.a(r100);
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (g.class == r100.getClass()) goto L12;
            return false;
        L12:
            return Intrinsics.areEqual(this.f289189c, ((g) r100).f289189c);
        }
    }

    public static final class h extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f289190c = null;

        static {
            f289190c = new h();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Speaking";
        }

        public h() {
            super(5, "speaking");
        }
    }

    public static class i extends MajorState {

        public static final class a extends i {
            @Override // com.larus.audio.call.mgr.MajorState.i, com.larus.audio.call.mgr.MajorState
            public final String toString() {
                return "DeepThinking";
            }

            public a() {
                super(SubtitleListUpdateType.DEEP_THINKING);
            }
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public String toString() {
            return "Thinking";
        }

        public /* synthetic */ i() {
            this(SubtitleListUpdateType.THINKING);
        }

        public i(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            super(4, r100);
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final CheckResult a(MajorState r100) {
            Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
            if ((r100 instanceof d) == false) goto L11;
            d r101 = (d) r100;
            if (r101.f289182c != From.PLAY_COMPLETE) goto L11;
            if (r101.f289183d.getInterrupt() == true) goto L11;
            return CheckResult.INTERCEPT;
        L11:
            return super.a(r100);
        }
    }

    public static final class j extends MajorState {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f289191c = null;

        static {
            f289191c = new j();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Waiting";
        }

        public j() {
            super(2, "waiting");
        }
    }

    public int hashCode() {
        return (this.f289171a * 31) + this.f289172b.hashCode();
    }

    public String toString() {
        String r100 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public CheckResult a(MajorState r100) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);
        if (Intrinsics.areEqual(this, r100) == false) goto L7;
        return CheckResult.INTERCEPT;
    L7:
        if ((this instanceof f) == true) goto L13;
        if ((r100 instanceof c) == false) goto L13;
        return CheckResult.INTERCEPT;
    L13:
        return CheckResult.NORMAL;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MajorState) == true) goto L8;
        return false;
    L8:
        MajorState r101 = (MajorState) r100;
        if (this.f289171a == r101.f289171a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f289172b, r101.f289172b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public MajorState(int r100, String r101) {
        this.f289171a = r100;
        this.f289172b = r101;
    }
}
