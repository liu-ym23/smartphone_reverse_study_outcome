package rs8;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.c2;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f539136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f539137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f539138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f539139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f539140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MessageActionBarAlign f539141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ActionStyle f539142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f539143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<View, Unit> f539144k;

    public n() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f539134a, r101.f539134a) == true) goto L12;
        return false;
    L12:
        if (this.f539135b == r101.f539135b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539136c, r101.f539136c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f539137d, r101.f539137d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f539138e, r101.f539138e) == true) goto L24;
        return false;
    L24:
        if (this.f539139f == r101.f539139f) goto L27;
        return false;
    L27:
        if (this.f539140g == r101.f539140g) goto L30;
        return false;
    L30:
        if (this.f539141h == r101.f539141h) goto L33;
        return false;
    L33:
        if (this.f539142i == r101.f539142i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f539143j, r101.f539143j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f539144k, r101.f539144k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f539134a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((((((((((((r101 * 31) + this.f539135b) * 31) + this.f539136c.hashCode()) * 31) + this.f539137d.hashCode()) * 31) + this.f539138e.hashCode()) * 31) + this.f539139f) * 31) + this.f539140g) * 31) + this.f539141h.hashCode()) * 31) + this.f539142i.hashCode()) * 31) + this.f539143j.hashCode()) * 31) + this.f539144k.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "LottieAction(actionBarKey=" + this.f539134a + ", id=" + this.f539135b + ", description=" + this.f539136c + ", imageAssetFolder=" + this.f539137d + ", lottieFile=" + this.f539138e + ", repeatCount=" + this.f539139f + ", repeatMode=" + this.f539140g + ", messageActionBarAlign=" + this.f539141h + ", style=" + this.f539142i + ", accessibilityContent=" + this.f539143j + ", onClick=" + this.f539144k + ')';
    }

    @Override // rs8.g
    public final String a() {
        return this.f539134a;
    }

    @Override // rs8.g
    public final MessageActionBarAlign b() {
        return this.f539141h;
    }

    @Override // rs8.g
    public final Function1<View, Unit> c() {
        return this.f539144k;
    }

    @Override // rs8.g
    public final String d() {
        return this.f539143j;
    }

    @Override // rs8.g
    public final CharSequence getDescription() {
        return this.f539136c;
    }

    @Override // rs8.g
    public final int getId() {
        return this.f539135b;
    }

    @Override // rs8.g
    public final ActionStyle getStyle() {
        return this.f539142i;
    }

    public n(MessageActionBarAlign r100, String r101, c2 r102) {
        ActionStyle r103 = ActionStyle.NORMAL;
        Intrinsics.checkNotNullParameter("", "description");
        Intrinsics.checkNotNullParameter("", "imageAssetFolder");
        Intrinsics.checkNotNullParameter("lottie/text_msg_voice_playing.json", "lottieFile");
        Intrinsics.checkNotNullParameter(r100, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r103, "style");
        Intrinsics.checkNotNullParameter(r101, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f539134a = "tts";
        this.f539135b = R.id.msg_action_re_tts;
        this.f539136c = "";
        this.f539137d = "";
        this.f539138e = "lottie/text_msg_voice_playing.json";
        this.f539139f = -1;
        this.f539140g = 1;
        this.f539141h = r100;
        this.f539142i = r103;
        this.f539143j = r101;
        this.f539144k = r102;
    }
}
