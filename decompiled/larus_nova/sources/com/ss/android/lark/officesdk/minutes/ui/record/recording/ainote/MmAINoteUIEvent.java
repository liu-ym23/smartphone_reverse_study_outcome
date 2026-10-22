package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class MmAINoteUIEvent implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class CreateMarkAINote extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Source f436027a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteUIEvent$CreateMarkAINote$Source;", "", "<init>", "(Ljava/lang/String;I)V", "Panel", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Source extends Enum<Source> {
            public static final Source Panel = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Source[] f436028a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f436029b = null;

            public static EnumEntries<Source> getEntries() {
                return f436029b;
            }

            static {
                Source r100 = new Source();
                Panel = r100;
                Source[] r101 = {r100};
                f436028a = r101;
                f436029b = EnumEntriesKt.enumEntries(r101);
            }

            public Source() {
                super("Panel", 0);
            }

            public static Source[] values() {
                return (Source[]) f436028a.clone();
            }

            public static Source valueOf(String r100) {
                return (Source) r27.a.a(Source.class, r100);
            }
        }

        public CreateMarkAINote() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CreateMarkAINote) == true) goto L9;
            return false;
        L9:
            if (this.f436027a == ((CreateMarkAINote) r100).f436027a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436027a.hashCode();
        }

        public final String toString() {
            return "CreateMarkAINote(source=" + this.f436027a + ')';
        }

        public CreateMarkAINote(int r100) {
            Source r101 = Source.Panel;
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f436027a = r101;
        }
    }

    public static final class a extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436030a = null;

        static {
            f436030a = new a();
        }

        public a() {
        }
    }

    public static final class b extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f436031a = null;

        static {
            f436031a = new b();
        }

        public b() {
        }
    }

    public static final class c extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f436032a = null;

        static {
            f436032a = new c();
        }

        public c() {
        }
    }

    public static final class d extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436033a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f436033a == ((d) r100).f436033a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436033a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchClick(checked=" + this.f436033a + ')';
        }

        public d(boolean r100) {
            this.f436033a = r100;
        }
    }

    public static final class e extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436034a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f436034a == ((e) r100).f436034a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436034a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchEditorFocusChanged(focused=" + this.f436034a + ')';
        }

        public e(boolean r100) {
            this.f436034a = r100;
        }
    }

    public static final class f extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436035a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f436035a == ((f) r100).f436035a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436035a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchKeyboardVisibilityChanged(visible=" + this.f436035a + ')';
        }

        public f(boolean r100) {
            this.f436035a = r100;
        }
    }

    public static final class g extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436036a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f436036a == ((g) r100).f436036a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436036a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SaveSwitchPanelVisibilityChanged(visible=" + this.f436036a + ')';
        }

        public g(boolean r100) {
            this.f436036a = r100;
        }
    }

    public static final class h extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f436037a = null;

        static {
            f436037a = new h();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            h r101 = (h) r100;
            return true;
        }

        public final int hashCode() {
            return 1868780381;
        }

        public final String toString() {
            return "SaveSwitchTooltipClose";
        }

        public h() {
        }
    }

    public static final class i extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f436038a = null;

        static {
            f436038a = new i();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            i r101 = (i) r100;
            return true;
        }

        public final int hashCode() {
            return -1022656626;
        }

        public final String toString() {
            return "SaveSwitchTooltipDismissed";
        }

        public i() {
        }
    }

    public static final class j extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f436039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f436040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f436041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f436042d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (this.f436039a == r101.f436039a) goto L12;
            return false;
        L12:
            if (this.f436040b == r101.f436040b) goto L15;
            return false;
        L15:
            if (this.f436041c == r101.f436041c) goto L18;
            return false;
        L18:
            if (this.f436042d == r101.f436042d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f436039a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f436040b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            int r104 = 1231;
            if (this.f436041c == false) goto L5;
            int r105 = 1231;
        L6:
            int r106 = (r103 + r105) * 31;
            if (this.f436042d == true) goto L11;
            r104 = 1237;
        L11:
            return r106 + r104;
        L5:
            r105 = 1237;
            goto L6
        }

        public final String toString() {
            return "Show(duration=" + this.f436039a + ", meetingStartTime=" + this.f436040b + ", expandImmediately=" + this.f436041c + ", isWavePlaying=" + this.f436042d + ')';
        }

        public j(long r100, long r101, boolean r102, boolean r103) {
            this.f436039a = r100;
            this.f436040b = r101;
            this.f436041c = r102;
            this.f436042d = r103;
        }
    }

    public static final class k extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436043a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            if (this.f436043a == ((k) r100).f436043a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436043a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SubtitleNavigationResult(success=" + this.f436043a + ')';
        }

        public k(boolean r100) {
            this.f436043a = r100;
        }
    }

    public static final class l extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f436044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f436045b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (this.f436044a == r101.f436044a) goto L12;
            return false;
        L12:
            if (this.f436045b == r101.f436045b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f436044a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f436045b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "UpdateDuration(duration=" + this.f436044a + ", meetingStartTime=" + this.f436045b + ')';
        }

        public l(long r100, long r101) {
            this.f436044a = r100;
            this.f436045b = r101;
        }
    }

    public static final class m extends MmAINoteUIEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436046a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.f436046a == ((m) r100).f436046a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436046a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "UpdateWaveAnimation(isPlaying=" + this.f436046a + ')';
        }

        public m(boolean r100) {
            this.f436046a = r100;
        }
    }

    public MmAINoteUIEvent() {
    }
}
