package wnb;

import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f560486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f560487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f560488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f560489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Chat f560490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChatChatter f560491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f560492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q4b.a f560493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<String, Unit> f560494i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f560486a, r101.f560486a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560487b, r101.f560487b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f560488c, r101.f560488c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f560489d, r101.f560489d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f560490e, r101.f560490e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f560491f, r101.f560491f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f560492g, r101.f560492g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f560493h, r101.f560493h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f560494i, r101.f560494i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Fragment r100 = this.f560486a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FragmentActivity r104 = this.f560487b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        EditText r107 = this.f560488c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f560489d.hashCode()) * 31;
        Chat r110 = this.f560490e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ChatChatter r113 = this.f560491f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        v r116 = this.f560492g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        q4b.a r119 = this.f560493h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Function1<String, Unit> r122 = this.f560494i;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "IMInputInnerPluginEnv(host=" + this.f560486a + ", activity=" + this.f560487b + ", editText=" + this.f560488c + ", chatId=" + this.f560489d + ", chat=" + this.f560490e + ", chatter=" + this.f560491f + ", chatContainer=" + this.f560492g + ", messageSender=" + this.f560493h + ", removeMessage=" + this.f560494i + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f560487b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Fragment r100, FragmentActivity r101, EditText r102, String r103, Chat r104, ChatChatter r105, v r106, q4b.a r107, Function1<? super String, Unit> r110) {
        Intrinsics.checkNotNullParameter(r103, "chatId");
        this.f560486a = r100;
        this.f560487b = r101;
        this.f560488c = r102;
        this.f560489d = r103;
        this.f560490e = r104;
        this.f560491f = r105;
        this.f560492g = r106;
        this.f560493h = r107;
        this.f560494i = r110;
    }
}
