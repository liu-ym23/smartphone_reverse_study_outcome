package com.ss.android.lark.auditsdk.v2;

import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: classes34.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r110, Context r111, ValidateResult r112, Integer r113, Integer r114, Integer r115, PolicyModel r116, DialogInterface.OnDismissListener r210, int r211) {
            if ((r211 & 4) == 0) goto L5;
            Integer r100 = null;
        L7:
            if ((r211 & 16) == 0) goto L9;
            Integer r101 = null;
        L11:
            if ((r211 & 32) == 0) goto L13;
            Integer r102 = null;
        L15:
            if ((r211 & 64) == 0) goto L17;
            PolicyModel r117 = null;
        L19:
            if ((r211 & 256) == 0) goto L21;
            DialogInterface.OnDismissListener r118 = null;
        L22:
            r110.b(r111, r112, r100, null, r101, r102, r117, false, r118);
            return;
        L21:
            r118 = r210;
            goto L22
        L17:
            r117 = r116;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    void a(ValidateResult r100, AuthorizationServiceV2.AuthorizationType r101);

    void b(Context r100, ValidateResult r101, Integer r102, String r103, Integer r104, Integer r105, PolicyModel r106, boolean r107, DialogInterface.OnDismissListener r108);

    ValidateResult c(boolean r100);

    void d(ValidateResult r100, PolicyModel r101);

    PolicyModel e();

    boolean isAuthorizationPassed(ValidateResult r100);
}
