package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f563998a = null;

    static {
        f563998a = new s();
    }

    public s() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof UserProfileEntity) == false) goto L11;
        UserProfileEntity r101 = (UserProfileEntity) r100;
        int r102 = (((r101.getProfileKey().hashCode() + 0) * 31) + r101.getProfileValue().hashCode()) * 31;
        if (r101.isFromAutoLearn() == false) goto L7;
        int r103 = 1231;
    L9:
        return r102 + r103;
    L7:
        r103 = 1237;
        goto L9
    L11:
        throw new IllegalStateException("Check failed.".toString());
    }
}
