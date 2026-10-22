package dy9;

import com.larus.uaigc.avatar.instruction.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<ab8.a, Unit> f470552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f470556e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f470552a, r101.f470552a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470553b, r101.f470553b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470554c, r101.f470554c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470555d, r101.f470555d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470556e, r101.f470556e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Function1<ab8.a, Unit> r100 = this.f470552a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.f470553b.hashCode()) * 31) + this.f470554c.hashCode()) * 31) + this.f470555d.hashCode()) * 31;
        String r104 = this.f470556e;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarTemplateModel(avatarTemplateChoose=" + this.f470552a + ", botId=" + this.f470553b + ", chatType=" + this.f470554c + ", recommendFrom=" + this.f470555d + ", cvsId=" + this.f470556e + ')';
    }

    public a(n r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r102, "chatType");
        Intrinsics.checkNotNullParameter("action_bar_template", "recommendFrom");
        this.f470552a = r100;
        this.f470553b = r101;
        this.f470554c = r102;
        this.f470555d = "action_bar_template";
        this.f470556e = r103;
    }
}
