package va8;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.view.actionbar.custom.actionbarpanel.CustomActionBarPanel;
import com.larus.bmhome.view.resourcebar.ResourceBar;
import com.larus.common_ui.view.ChatInputInnerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f553948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f553949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f553950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f553951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f553952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f553953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f553954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f553955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f553956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f553957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f553958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f553959l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f553948a, r101.f553948a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553949b, r101.f553949b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553950c, r101.f553950c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f553951d, r101.f553951d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f553952e, r101.f553952e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f553953f, r101.f553953f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f553954g, r101.f553954g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f553955h, r101.f553955h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f553956i, r101.f553956i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f553957j, r101.f553957j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f553958k, r101.f553958k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f553959l, r101.f553959l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f553948a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        View r104 = this.f553949b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f553950c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        View r110 = this.f553951d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        View r113 = this.f553952e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        View r116 = this.f553953f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        View r119 = this.f553954g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        View r122 = this.f553955h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        View r125 = this.f553956i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        View r128 = this.f553957j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        View r131 = this.f553958k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        View r134 = this.f553959l;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatInputUIViewSet(inputDelegateView=" + this.f553948a + ", inputTextView=" + this.f553949b + ", actionSendView=" + this.f553950c + ", actionEntranceView=" + this.f553951d + ", actionEntranceIconView=" + this.f553952e + ", speakAreaView=" + this.f553953f + ", actionSpeakView=" + this.f553954g + ", actionInputView=" + this.f553955h + ", actionMenuEntranceView=" + this.f553956i + ", actionMenuEntranceIconView=" + this.f553957j + ", resourceItemView=" + this.f553958k + ", actionBarPanelView=" + this.f553959l + ')';
    }

    public b(View r100, View r101, AppCompatImageView r102, View r103, AppCompatImageView r104, ChatInputInnerView r105, View r106, AppCompatImageView r107, View r108, AppCompatImageView r110, ResourceBar r111, CustomActionBarPanel r112) {
        this.f553948a = r100;
        this.f553949b = r101;
        this.f553950c = r102;
        this.f553951d = r103;
        this.f553952e = r104;
        this.f553953f = r105;
        this.f553954g = r106;
        this.f553955h = r107;
        this.f553956i = r108;
        this.f553957j = r110;
        this.f553958k = r111;
        this.f553959l = r112;
    }
}
