package dw3;

import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.PermissionApplyBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends jc8.a {
    public final String g() {
        return "PermissionApplyBlockBizModel";
    }

    public final int l() {
        int r0 = j.a;
        return j.c0;
    }

    public final boolean e(jc8.a r3) {
        BlockContent r0 = ((jc8.a) this).a.getContent();
        String r1 = null;
        if (r0 == null) goto L7;
        PermissionApplyBlock r2 = r0.getPermissionApplyBlock();
        if (r2 == null) goto L7;
        String r4 = r2.permissionData;
    L8:
        if (r3 == null) goto L17;
        Block r5 = r3.a;
        if (r5 == null) goto L17;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L17;
        PermissionApplyBlock r7 = r6.getPermissionApplyBlock();
        if (r7 == null) goto L17;
        r1 = r7.permissionData;
    L17:
        return Intrinsics.areEqual(r4, r1);
    L7:
        r4 = null;
        goto L8
    }

    public a(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
