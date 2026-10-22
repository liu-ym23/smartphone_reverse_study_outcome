package mwb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteWaveBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {
    public static final /* synthetic */ int G = 0;
    public final View A;
    public final View B;
    public final View C;
    public final TextView D;
    public final View E;
    public final View F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f516007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f516008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f516009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f516010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f516011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f516012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmAINotePanelGestureInterceptLayout f516013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f516014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmAINoteWaveBarView f516015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f516016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f516017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f516018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f516019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MmAINoteWaveBarView f516020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f516021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f516022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f516023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f516024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f516025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f516026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f516027v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f516028w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f516029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f516030y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final View f516031z;

    public static final class a {
    }

    static {
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f516006a = r100;
        View r101 = r100.findViewById(R.id.aiNoteOverlayRoot);
        if (r101 == null) goto L127;
        this.f516007b = (FrameLayout) r101;
        View r102 = r100.findViewById(R.id.aiNoteScrim);
        if (r102 == null) goto L125;
        this.f516008c = r102;
        View r103 = r100.findViewById(R.id.aiNoteSheetContainer);
        if (r103 == null) goto L123;
        this.f516009d = (FrameLayout) r103;
        View r104 = r100.findViewById(R.id.aiNoteContentLayout);
        if (r104 == null) goto L121;
        this.f516010e = (FrameLayout) r104;
        View r105 = r100.findViewById(R.id.aiNoteRoot);
        if (r105 == null) goto L119;
        this.f516011f = (ViewGroup) r105;
        View r106 = r100.findViewById(R.id.aiNoteHeaderDragArea);
        if (r106 == null) goto L117;
        this.f516012g = r106;
        View r107 = r100.findViewById(R.id.aiNoteContentGestureHost);
        if (r107 == null) goto L115;
        this.f516013h = (MmAINotePanelGestureInterceptLayout) r107;
        View r108 = r100.findViewById(R.id.aiNoteEditorContainer);
        if (r108 == null) goto L113;
        this.f516014i = (FrameLayout) r108;
        View r109 = r100.findViewById(R.id.aiNoteWaveBarView);
        if (r109 == null) goto L111;
        this.f516015j = (MmAINoteWaveBarView) r109;
        View r110 = r100.findViewById(R.id.aiNoteDurationView);
        if (r110 == null) goto L109;
        this.f516016k = (TextView) r110;
        View r111 = r100.findViewById(R.id.aiNoteTrialTag);
        if (r111 == null) goto L107;
        this.f516017l = r111;
        View r112 = r100.findViewById(R.id.aiNoteTitleContainer);
        if (r112 == null) goto L105;
        this.f516018m = r112;
        View r113 = r100.findViewById(R.id.aiNoteHeaderWaveBarAndDuration);
        if (r113 == null) goto L103;
        this.f516019n = r113;
        View r114 = r100.findViewById(R.id.aiNoteHeaderWaveBarView);
        if (r114 == null) goto L101;
        this.f516020o = (MmAINoteWaveBarView) r114;
        View r115 = r100.findViewById(R.id.aiNoteHeaderDurationView);
        if (r115 == null) goto L99;
        this.f516021p = (TextView) r115;
        View r116 = r100.findViewById(R.id.aiNoteBottomBar);
        if (r116 == null) goto L97;
        this.f516022q = r116;
        View r117 = r100.findViewById(R.id.aiNoteWaveBarAndDuration);
        if (r117 == null) goto L95;
        this.f516023r = r117;
        View r118 = r100.findViewById(R.id.aiNoteSubtitleMissingTip);
        if (r118 == null) goto L93;
        this.f516024s = (TextView) r118;
        View r119 = r100.findViewById(R.id.aiNoteMarkThrottleTip);
        if (r119 == null) goto L91;
        this.f516025t = (TextView) r119;
        View r120 = r100.findViewById(R.id.aiNoteClose);
        if (r120 == null) goto L89;
        this.f516026u = r120;
        View r121 = r100.findViewById(R.id.aiNoteCameraAction);
        if (r121 == null) goto L87;
        this.f516027v = r121;
        View r122 = r100.findViewById(R.id.aiNoteCameraIcon);
        if (r122 == null) goto L85;
        this.f516028w = r122;
        View r123 = r100.findViewById(R.id.aiNoteCameraText);
        if (r123 == null) goto L83;
        this.f516029x = (TextView) r123;
        View r124 = r100.findViewById(R.id.aiNoteSaveActionSpacer);
        if (r124 == null) goto L81;
        this.f516030y = r124;
        View r125 = r100.findViewById(R.id.aiNoteMiddleSpacer);
        if (r125 == null) goto L79;
        this.f516031z = r125;
        View r126 = r100.findViewById(R.id.aiNoteRightSpacer);
        if (r126 == null) goto L77;
        this.A = r126;
        View r127 = r100.findViewById(R.id.aiNoteMarkAction);
        if (r127 == null) goto L75;
        this.B = r127;
        View r128 = r100.findViewById(R.id.aiNoteMarkIcon);
        if (r128 == null) goto L73;
        this.C = r128;
        View r129 = r100.findViewById(R.id.aiNoteMarkText);
        if (r129 == null) goto L71;
        this.D = (TextView) r129;
        View r130 = r100.findViewById(R.id.aiNoteSaveSwitchContainer);
        if (r130 == null) goto L69;
        this.E = r130;
        View r131 = r100.findViewById(R.id.aiNoteSaveSwitch);
        if (r131 == null) goto L67;
        this.F = r131;
        return;
    L67:
        throw new IllegalStateException("Required view not found, id=2131362356, type=".concat(View.class.getSimpleName()));
    L69:
        throw new IllegalStateException("Required view not found, id=2131362357, type=".concat(View.class.getSimpleName()));
    L71:
        throw new IllegalStateException("Required view not found, id=2131362349, type=".concat(TextView.class.getSimpleName()));
    L73:
        throw new IllegalStateException("Required view not found, id=2131362348, type=".concat(View.class.getSimpleName()));
    L75:
        throw new IllegalStateException("Required view not found, id=2131362347, type=".concat(View.class.getSimpleName()));
    L77:
        throw new IllegalStateException("Required view not found, id=2131362353, type=".concat(View.class.getSimpleName()));
    L79:
        throw new IllegalStateException("Required view not found, id=2131362351, type=".concat(View.class.getSimpleName()));
    L81:
        throw new IllegalStateException("Required view not found, id=2131362355, type=".concat(View.class.getSimpleName()));
    L83:
        throw new IllegalStateException("Required view not found, id=2131362337, type=".concat(TextView.class.getSimpleName()));
    L85:
        throw new IllegalStateException("Required view not found, id=2131362336, type=".concat(View.class.getSimpleName()));
    L87:
        throw new IllegalStateException("Required view not found, id=2131362335, type=".concat(View.class.getSimpleName()));
    L89:
        throw new IllegalStateException("Required view not found, id=2131362338, type=".concat(View.class.getSimpleName()));
    L91:
        throw new IllegalStateException("Required view not found, id=2131362350, type=".concat(TextView.class.getSimpleName()));
    L93:
        throw new IllegalStateException("Required view not found, id=2131362361, type=".concat(TextView.class.getSimpleName()));
    L95:
        throw new IllegalStateException("Required view not found, id=2131362365, type=".concat(View.class.getSimpleName()));
    L97:
        throw new IllegalStateException("Required view not found, id=2131362334, type=".concat(View.class.getSimpleName()));
    L99:
        throw new IllegalStateException("Required view not found, id=2131362344, type=".concat(TextView.class.getSimpleName()));
    L101:
        throw new IllegalStateException("Required view not found, id=2131362346, type=MmAINoteWaveBarView");
    L103:
        throw new IllegalStateException("Required view not found, id=2131362345, type=".concat(View.class.getSimpleName()));
    L105:
        throw new IllegalStateException("Required view not found, id=2131362363, type=".concat(View.class.getSimpleName()));
    L107:
        throw new IllegalStateException("Required view not found, id=2131362364, type=".concat(View.class.getSimpleName()));
    L109:
        throw new IllegalStateException("Required view not found, id=2131362341, type=".concat(TextView.class.getSimpleName()));
    L111:
        throw new IllegalStateException("Required view not found, id=2131362366, type=MmAINoteWaveBarView");
    L113:
        throw new IllegalStateException("Required view not found, id=2131362342, type=".concat(FrameLayout.class.getSimpleName()));
    L115:
        throw new IllegalStateException("Required view not found, id=2131362339, type=MmAINotePanelGestureInterceptLayout");
    L117:
        throw new IllegalStateException("Required view not found, id=2131362343, type=".concat(View.class.getSimpleName()));
    L119:
        throw new IllegalStateException("Required view not found, id=2131362354, type=".concat(ViewGroup.class.getSimpleName()));
    L121:
        throw new IllegalStateException("Required view not found, id=2131362340, type=".concat(FrameLayout.class.getSimpleName()));
    L123:
        throw new IllegalStateException("Required view not found, id=2131362360, type=".concat(FrameLayout.class.getSimpleName()));
    L125:
        throw new IllegalStateException("Required view not found, id=2131362359, type=".concat(View.class.getSimpleName()));
    L127:
        throw new IllegalStateException("Required view not found, id=2131362352, type=".concat(FrameLayout.class.getSimpleName()));
    }
}
