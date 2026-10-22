package u1c;

import com.ss.android.lark.biz.im.api.e1;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.ss.android.lark.profile_office.shareprofile.ProfileForwardContent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
@ConvertMessageParamsHandler
public final class a implements g<ProfileForwardContent> {
    public a() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 4;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g
    public final Object a(IForwardContent r100) {
        ProfileForwardContent r101 = (ProfileForwardContent) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        e1.a r103 = new e1.a();
        r103.A = r101.f438863a;
        r103.C = r101.f438864b;
        r103.B = r101.f438865c;
        r102.add(r103);
        return r102;
    }
}
