package u5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f548752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548753c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f548751a, r101.f548751a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548752b, r101.f548752b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548753c, r101.f548753c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f548751a.hashCode() * 31;
        Integer r101 = this.f548752b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f548753c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UIOperation(operation=" + this.f548751a + ", id=" + this.f548752b + ", value=" + this.f548753c + ')';
    }

    public a(String r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        this.f548751a = r100;
        this.f548752b = r101;
        this.f548753c = r102;
    }
}
