package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class g implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436204a = null;

        static {
            f436204a = new a();
        }

        public final String toString() {
            return "AIInterpretationClick";
        }

        public a() {
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f436205a = null;

        static {
            f436205a = new b();
        }

        public final String toString() {
            return "AIInterpretationHeadsetDialogDismissed";
        }

        public b() {
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f436206a = null;

        static {
            f436206a = new c();
        }

        public final String toString() {
            return "AIInterpretationSwitchTipRequested";
        }

        public c() {
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f436207a = null;

        static {
            f436207a = new d();
        }

        public final String toString() {
            return "AudioSaveBoardingShown";
        }

        public d() {
        }
    }

    public static final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f436208a = null;

        static {
            f436208a = new e();
        }

        public e() {
        }
    }

    public static final class f extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f436209a = null;

        static {
            f436209a = new f();
        }

        public f() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g$g, reason: collision with other inner class name */
    public static final class C5206g extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmRecordingAutoSaveDecisionScene f436210a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5206g) == true) goto L9;
            return false;
        L9:
            if (this.f436210a == ((C5206g) r100).f436210a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436210a.hashCode();
        }

        public final String toString() {
            return "AutoSaveDialogClosed(scene=" + this.f436210a + ')';
        }

        public C5206g(MmRecordingAutoSaveDecisionScene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f436210a = r100;
        }
    }

    public static final class h extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final POIInfo f436211a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436211a, ((h) r100).f436211a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436211a.hashCode();
        }

        public final String toString() {
            return "ChooseLocation(poiInfo=" + this.f436211a + ')';
        }

        public h(POIInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "poiInfo");
            this.f436211a = r100;
        }
    }

    public static final class i extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f436212a = null;

        static {
            f436212a = new i();
        }

        public final String toString() {
            return "LanguageClick";
        }

        public i() {
        }
    }

    public static final class j extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f436213a = null;

        static {
            f436213a = new j();
        }

        public final String toString() {
            return "PauseResumeClick";
        }

        public j() {
        }
    }

    public static final class k extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f436214a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436214a, ((k) r100).f436214a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436214a.hashCode();
        }

        public final String toString() {
            return "RegisterLocationMapContainer";
        }

        public k(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            this.f436214a = r100;
        }
    }

    public static final class l extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f436215a = null;

        static {
            f436215a = new l();
        }

        public final String toString() {
            return "RequestLocation";
        }

        public l() {
        }
    }

    public static final class m extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g f436216a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436216a, ((m) r100).f436216a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436216a.hashCode();
        }

        public final String toString() {
            return "SelectAIInterpretationLanguage(language=" + this.f436216a + ')';
        }

        public m(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f436216a = r100;
        }
    }

    public static final class n extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g f436218b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L8;
            return false;
        L8:
            n r101 = (n) r100;
            if (this.f436217a == r101.f436217a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f436218b, r101.f436218b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f436217a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f436218b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "SetAIInterpretationEnabled(enabled=" + this.f436217a + ", language=" + this.f436218b + ')';
        }

        public n(boolean r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r101) {
            Intrinsics.checkNotNullParameter(r101, "language");
            this.f436217a = r100;
            this.f436218b = r101;
        }
    }

    public static final class o extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436219a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L9;
            return false;
        L9:
            if (this.f436219a == ((o) r100).f436219a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436219a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetAudioSaveType(isSave=" + this.f436219a + ')';
        }

        public o(boolean r100) {
            this.f436219a = r100;
        }
    }

    public static final class p extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436220a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L9;
            return false;
        L9:
            if (this.f436220a == ((p) r100).f436220a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436220a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetBilingual(enabled=" + this.f436220a + ')';
        }

        public p(boolean r100) {
            this.f436220a = r100;
        }
    }

    public static final class q extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h f436221a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436221a, ((q) r100).f436221a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436221a.hashCode();
        }

        public final String toString() {
            return "SetSpokenLanguage(language=" + this.f436221a + ')';
        }

        public q(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f436221a = r100;
        }
    }

    public static final class r extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h f436222a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436222a, ((r) r100).f436222a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436222a.hashCode();
        }

        public final String toString() {
            return "SetTranslateLanguage(language=" + this.f436222a + ')';
        }

        public r(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f436222a = r100;
        }
    }

    public static final class s extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f436223a = null;

        static {
            f436223a = new s();
        }

        public final String toString() {
            return "StopRecordingClick";
        }

        public s() {
        }
    }

    public static final class t extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmRecordingUITab f436224a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L9;
            return false;
        L9:
            if (this.f436224a == ((t) r100).f436224a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436224a.hashCode();
        }

        public final String toString() {
            return "SwitchTab(tab=" + this.f436224a + ')';
        }

        public t(MmRecordingUITab r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
            this.f436224a = r100;
        }
    }

    public static final class u extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f436225a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436225a, ((u) r100).f436225a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436225a.hashCode();
        }

        public final String toString() {
            return "UnregisterLocationMapContainer";
        }

        public u(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            this.f436225a = r100;
        }
    }

    public static final class v extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f436227b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L8;
            return false;
        L8:
            v r101 = (v) r100;
            if (Intrinsics.areEqual(this.f436226a, r101.f436226a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f436227b, r101.f436227b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f436226a.hashCode() * 31) + this.f436227b.hashCode();
        }

        public final String toString() {
            return "UpdateTitle(oldTitle=" + this.f436226a + ", title=" + this.f436227b + ')';
        }

        public v(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "oldTitle");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f436226a = r100;
            this.f436227b = r101;
        }
    }

    public g() {
    }
}
