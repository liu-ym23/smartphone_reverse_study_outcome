package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f563988a = null;

    static {
        f563988a = new i();
    }

    public i() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof PhotoFaceEntity) == false) goto L9;
        PhotoFaceEntity r101 = (PhotoFaceEntity) r100;
        int r102 = r101.getName().hashCode() + 0;
        FileEntity r103 = r101.getAvatar();
        if (r103 != null) goto L7;
        return r102;
    L7:
        return (r102 * 31) + r103.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
