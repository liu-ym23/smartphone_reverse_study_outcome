package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f563983a = null;

    static {
        f563983a = new d0();
    }

    public d0() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof GroupChatEntity) == false) goto L12;
        GroupChatEntity r101 = (GroupChatEntity) r100;
        int r102 = r101.getName().hashCode() + 0;
        List<ContactEntity> r103 = r101.getContacts();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        FileEntity r104 = r101.getAvatar();
        if (r104 != null) goto L10;
        return r102;
    L10:
        return (r102 * 31) + r104.hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
