package rg5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.AskOwnerHelper;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements g {
    public final String a;
    public final int b;
    public final ArrayList<UserInfo> c;

    public static final class a {
    }

    static {
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // rg5.g
    public final ArrayList<UserInfo> K7() {
        return this.c;
    }

    @Override // rg5.g
    public final Flowable<AskOwnerHelper.AskOwnerSendResult> U6(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "notes");
        tt5.a.h("AskOwnerModel", "ask owner");
        Iterator<UserInfo> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setPermission(r3);
        goto L4
    L6:
        int r5 = AskOwnerHelper.a;
        return AskOwnerHelper.a(this.a, this.b, this.c, r4);
    }

    public b(String r2, int r3, ArrayList<UserInfo> r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "invitedUserList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
