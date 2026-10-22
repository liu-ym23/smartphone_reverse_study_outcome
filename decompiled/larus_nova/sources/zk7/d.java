package zk7;

import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILuckyDogCommonSettingsService.Channel f572661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f572662b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f572661a, r101.f572661a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f572662b, r101.f572662b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        ILuckyDogCommonSettingsService.Channel r100 = this.f572661a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.f572662b;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L11:
        return ((r102 + r104) * 31) + 0;
    L9:
        r104 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "SettingsByKeyData(channel=" + this.f572661a + ", keys=" + this.f572662b + ", callback=null)";
    }

    public d(ILuckyDogCommonSettingsService.Channel r100, List r101) {
        this.f572661a = r100;
        this.f572662b = r101;
    }
}
