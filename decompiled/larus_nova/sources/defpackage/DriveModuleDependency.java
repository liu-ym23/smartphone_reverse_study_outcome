package defpackage;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ybb.a;
import yzb.b;

/* JADX INFO: loaded from: classes42.dex */
@ClaymoreImpl(a.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"LDriveModuleDependency;", "Lcom/ss/android/lark/drive/dependency/IDriveModuleDependency;", "<init>", "()V", "isPrimaryHost", "", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveModuleDependency implements a {
    public DriveModuleDependency() {
    }

    public boolean isPrimaryHost() {
        User r100 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();
        if (r100 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Tenant r101 = r100.tenant;
        if (r101 == null) goto L7;
        String r102 = r101.tenantId;
    L8:
        int r103 = com.ss.android.lark.passport.signinsdk_api.contants.a.f438069a;
        if (Intrinsics.areEqual(r102, "1") != true) goto L11;
        return true;
    L7:
        r102 = null;
    L11:
        return false;
    }
}
