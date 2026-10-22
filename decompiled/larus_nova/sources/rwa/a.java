package rwa;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import yzb.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539730a = 0;

    /* JADX INFO: renamed from: rwa.a$a, reason: collision with other inner class name */
    public static final class C7546a {
        @JvmStatic
        public static swa.a a() {
            long r100 = -1;
            User r101 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();     // Catch: NumberFormatException -> L17
            if (r101 == null) goto L9;
            String r102 = r101.getTenantId();     // Catch: NumberFormatException -> L17
            if (r102 == null) goto L9;
            long r103 = CastLongProtector.parseLong(r102);     // Catch: NumberFormatException -> L17
        L24:
            User r104 = ((b) LarkContext.spiByDwarf(b.class)).getForegroundUser();     // Catch: NumberFormatException -> L21
            if (r104 == null) goto L16;
            String r105 = r104.userId;     // Catch: NumberFormatException -> L21
            if (r105 == null) goto L16;
            r100 = CastLongProtector.parseLong(r105);     // Catch: NumberFormatException -> L21
        L19:
            swa.a r106 = new swa.a();
            r106.f543748i = r103;
            r106.f543749j = r100;
            return r106;
        L16:
            r100 = 0;
        L18:
            Log.e("AuthorizationEventCreatorV2", "Failed to get operatorTenantId or operatorUid");
        L9:
            r103 = 0;
        L17:
            r103 = -1;
            goto L18
        }

        @JvmStatic
        public static swa.a b() {
            swa.a r100 = a();
            r100.f543742c = 16;
            Intrinsics.checkNotNullParameter("IM_MSG_FILE_PREVIEW", "entityOperate");
            r100.f543746g = "IM_MSG_FILE_PREVIEW";
            r100.b(EntityDomain.EntityDomainIM);
            Intrinsics.checkNotNullParameter("IM_MSG_FILE", "entityType");
            r100.f543744e = "IM_MSG_FILE";
            r100.c(FileBizDomain.FileBizDomainIM);
            Intrinsics.checkNotNullParameter("PointKey_IM_MSG_FILE_PREVIEW", "pointKey");
            r100.f543743d = "PointKey_IM_MSG_FILE_PREVIEW";
            return r100;
        }
    }

    static {
    }
}
