package uvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static final a A = null;
    public static final a B = null;
    public static final a C = null;
    public static final a D = null;
    public static final a E = null;
    public static final a F = null;
    public static final a G = null;
    public static final a H = null;
    public static final a I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f551864J = null;
    public static final a K = null;
    public static final a L = null;
    public static final a M = null;
    public static final a N = null;
    public static final a O = null;
    public static final a P = null;
    public static final a Q = null;
    public static final a R = null;
    public static final a S = null;
    public static final a T = null;
    public static final a U = null;
    public static final a V = null;
    public static final a W = null;
    public static final a X = null;
    public static final a Y = null;
    public static final a Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f551865a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final a f551866a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f551867b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final a f551868b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f551869c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final a f551870c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f551871d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a f551872d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f551873e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final a f551874e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f551875f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f551876g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f551877h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f551878i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f551879j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f551880k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f551881l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f551882m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f551883n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f551884o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f551885p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f551886q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f551887r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f551888s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f551889t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f551890u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f551891v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f551892w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f551893x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f551894y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f551895z = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f551896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f551897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f551898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f551899d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f551896a, r101.f551896a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f551897b, r101.f551897b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f551898c, r101.f551898c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f551899d, r101.f551899d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f551896a.hashCode() * 31) + this.f551897b.hashCode()) * 31) + this.f551898c.hashCode()) * 31) + this.f551899d.hashCode();
        }

        public final String toString() {
            return "Source(id=" + this.f551896a + ", label=" + this.f551897b + ", hint=" + this.f551898c + ", expected=" + this.f551899d + ')';
        }

        public a(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "label");
            Intrinsics.checkNotNullParameter(r102, "hint");
            Intrinsics.checkNotNullParameter(r103, "expected");
            this.f551896a = r100;
            this.f551897b = r101;
            this.f551898c = r102;
            this.f551899d = r103;
        }
    }

    static {
        f551865a = new a("minutes-office-sdk-recording-activity", "OfficeSDK Recording Activity", "Hosts the OfficeSDK recording page", "minutes-office-sdk-recording-page");
        f551867b = new a("minutes-office-sdk-recording-page", "OfficeSDK Recording Page", "Current page is an active OfficeSDK recording", "minutes-office-sdk-recording-page");
        f551869c = new a("minutes-office-sdk-recording-title", "Recording Title", "Tap to edit the recording title", "minutes-office-sdk-recording-title-input");
        f551871d = new a("minutes-office-sdk-recording-title-input", "Recording Title Input", "Edit the recording title", "minutes-office-sdk-recording-title");
        f551873e = new a("minutes-office-sdk-recording-tabs", "Recording Content Tabs", "Switch between transcript and summary content", "minutes-office-sdk-subtitle-page|minutes-office-sdk-summary-page");
        f551875f = new a("minutes-office-sdk-subtitle-tab", "Realtime Transcript Tab", "Tap to show realtime recording transcript", "minutes-office-sdk-subtitle-page");
        f551876g = new a("minutes-office-sdk-summary-tab", "Realtime Summary Tab", "Tap to show realtime recording summary", "minutes-office-sdk-summary-page");
        f551877h = new a("minutes-office-sdk-summary-new-indicator", "New Summary Indicator", "Shows that realtime summary has new content", "minutes-office-sdk-summary-new-indicator");
        f551878i = new a("minutes-office-sdk-subtitle-page", "Realtime Transcript Page", "Shows realtime recording transcript", "minutes-office-sdk-subtitle-page");
        f551879j = new a("minutes-office-sdk-subtitle-list", "Realtime Transcript List", "Shows realtime transcript rows", "minutes-office-sdk-subtitle-list");
        f551880k = new a("minutes-office-sdk-subtitle-speaker", "Transcript Speaker", "Shows the speaker for a transcript row", "minutes-office-sdk-subtitle-list");
        f551881l = new a("minutes-office-sdk-subtitle-time", "Transcript Time", "Shows the timestamp for a transcript row", "minutes-office-sdk-subtitle-list");
        f551882m = new a("minutes-office-sdk-subtitle-content", "Transcript Content", "Shows the spoken content for a transcript row", "minutes-office-sdk-subtitle-list");
        f551883n = new a("minutes-office-sdk-subtitle-back-to-bottom", "Back to Latest Transcript", "Tap to scroll to the latest transcript", "minutes-office-sdk-subtitle-list");
        f551884o = new a("minutes-office-sdk-summary-page", "Realtime Summary Page", "Shows realtime recording summary", "minutes-office-sdk-summary-page");
        f551885p = new a("minutes-office-sdk-recording-duration", "Recording Duration", "Shows the current recording duration", "minutes-office-sdk-recording-duration");
        f551886q = new a("minutes-office-sdk-recording-wave", "Recording Wave", "Shows the current recording audio activity", "minutes-office-sdk-recording-wave");
        f551887r = new a("minutes-office-sdk-recording-pause-resume", "Pause or Resume Recording", "Tap to pause or resume the current recording", "minutes-office-sdk-recording-page");
        f551888s = new a("minutes-office-sdk-recording-stop", "Stop Recording", "Tap to stop the current recording", "minutes-office-sdk-end-window-activity");
        f551889t = new a("minutes-office-sdk-recording-language", "Recording Language Settings", "Tap to open recording language settings", "minutes-office-sdk-language-panel");
        f551890u = new a("minutes-office-sdk-recording-audio-save", "Recording Audio Save Settings", "Tap to open audio save settings", "minutes-office-sdk-audio-save-panel");
        f551891v = new a("minutes-office-sdk-recording-ai-interpretation", "Recording AI Interpretation", "Tap to open AI interpretation settings", "minutes-office-sdk-ai-interpretation-panel");
        f551892w = new a("minutes-office-sdk-recording-share", "Share Recording", "Tap to share the current recording", "minutes-office-sdk-share-sheet");
        f551893x = new a("minutes-office-sdk-language-panel", "Recording Language Panel", "Shows spoken and translation language settings", "minutes-office-sdk-language-panel");
        f551894y = new a("minutes-office-sdk-language-panel-close", "Close Recording Language Panel", "Tap to close recording language settings", "minutes-office-sdk-recording-page");
        f551895z = new a("minutes-office-sdk-spoken-language-entry", "Spoken Language Entry", "Tap to choose the spoken language", "minutes-office-sdk-spoken-language-panel");
        A = new a("minutes-office-sdk-spoken-language-current", "Current Spoken Language", "Shows the current spoken language", "minutes-office-sdk-spoken-language-entry");
        B = new a("minutes-office-sdk-spoken-language-item", "Spoken Language Option", "Tap to select a spoken language", "minutes-office-sdk-spoken-language-panel");
        C = new a("minutes-office-sdk-spoken-language-selected", "Selected Spoken Language", "Shows the selected spoken language", "minutes-office-sdk-spoken-language-panel");
        D = new a("minutes-office-sdk-translate-language-entry", "Translation Language Entry", "Tap to choose the translation language", "minutes-office-sdk-translate-language-panel");
        E = new a("minutes-office-sdk-translate-language-current", "Current Translation Language", "Shows the current translation language", "minutes-office-sdk-translate-language-entry");
        F = new a("minutes-office-sdk-translate-language-item", "Translation Language Option", "Tap to select a translation language", "minutes-office-sdk-translate-language-panel");
        G = new a("minutes-office-sdk-translate-language-selected", "Selected Translation Language", "Shows the selected translation language", "minutes-office-sdk-translate-language-panel");
        H = new a("minutes-office-sdk-spoken-language-panel", "Spoken Language Panel", "Shows available spoken languages", "minutes-office-sdk-spoken-language-panel");
        I = new a("minutes-office-sdk-spoken-language-list", "Spoken Language List", "Shows selectable spoken languages", "minutes-office-sdk-spoken-language-list");
        f551864J = new a("minutes-office-sdk-spoken-language-back", "Back from Spoken Language Panel", "Tap to return to recording language settings", "minutes-office-sdk-language-panel");
        K = new a("minutes-office-sdk-translate-language-panel", "Translation Language Panel", "Shows available translation languages", "minutes-office-sdk-translate-language-panel");
        L = new a("minutes-office-sdk-translate-language-list", "Translation Language List", "Shows selectable translation languages", "minutes-office-sdk-translate-language-list");
        M = new a("minutes-office-sdk-translate-language-back", "Back from Translation Language Panel", "Tap to return to recording language settings", "minutes-office-sdk-language-panel");
        N = new a("minutes-office-sdk-bilingual-switch", "Bilingual Transcript Switch", "Toggle bilingual transcript display", "minutes-office-sdk-translate-language-panel");
        O = new a("minutes-office-sdk-audio-save-panel", "Audio Save Settings Panel", "Shows audio save choices", "minutes-office-sdk-audio-save-panel");
        P = new a("minutes-office-sdk-audio-save-panel-close", "Close Audio Save Settings", "Tap to close audio save settings", "minutes-office-sdk-recording-page");
        Q = new a("minutes-office-sdk-audio-save-option", "Save Recording Audio", "Tap to save recording audio", "minutes-office-sdk-audio-save-panel");
        R = new a("minutes-office-sdk-audio-save-selected", "Save Recording Audio Selected", "Shows that recording audio will be saved", "minutes-office-sdk-audio-save-panel");
        S = new a("minutes-office-sdk-audio-not-save-option", "Do Not Save Recording Audio", "Tap to avoid saving recording audio", "minutes-office-sdk-audio-save-panel");
        T = new a("minutes-office-sdk-audio-not-save-selected", "Do Not Save Recording Audio Selected", "Shows that only the transcript will be saved", "minutes-office-sdk-audio-save-panel");
        U = new a("minutes-office-sdk-ai-interpretation-panel", "AI Interpretation Panel", "Shows AI interpretation language and controls", "minutes-office-sdk-ai-interpretation-panel");
        V = new a("minutes-office-sdk-ai-interpretation-panel-close", "Close AI Interpretation Panel", "Tap to close AI interpretation settings", "minutes-office-sdk-recording-page");
        W = new a("minutes-office-sdk-ai-interpretation-start", "Start AI Interpretation", "Tap to start AI interpretation", "minutes-office-sdk-recording-page");
        X = new a("minutes-office-sdk-ai-interpretation-stop", "Stop AI Interpretation", "Tap to stop AI interpretation", "minutes-office-sdk-recording-page");
        Y = new a("minutes-office-sdk-recording-float", "Recording Float Window", "Tap to restore the full recording page", "minutes-office-sdk-recording-page");
        Z = new a("minutes-office-sdk-recording-float-pause-resume", "Float Window Pause or Resume", "Tap to pause or resume recording from the float window", "minutes-office-sdk-recording-float");
        f551866a0 = new a("minutes-office-sdk-recording-float-duration", "Float Window Recording Duration", "Shows the current recording duration in the float window", "minutes-office-sdk-recording-float-duration");
        f551868b0 = new a("minutes-office-sdk-recording-float-wave", "Float Window Recording Wave", "Shows recording audio activity in the float window", "minutes-office-sdk-recording-float-wave");
        f551870c0 = new a("minutes-office-sdk-end-window-activity", "OfficeSDK End Window Activity", "Hosts the OfficeSDK recording end window", "minutes-office-sdk-end-window-page");
        f551872d0 = new a("minutes-office-sdk-end-window-page", "OfficeSDK End Window Page", "Shows the completed recording end window", "minutes-office-sdk-end-window-page");
        f551874e0 = new a("minutes-office-sdk-end-window-close", "Close OfficeSDK End Window", "Tap to close the recording end window", "minutes-office-sdk-source-page");
    }
}
