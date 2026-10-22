package z8b;

import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.contact.base.entity.bean.ContactAvatarSourceStrategy;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InvitationInfo f570972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InvitationInfo f570973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ErrorResult f570974c;

    public a() {
    }

    public static a a(GetContactTokenResponse r100, ContactAvatarSourceStrategy r101) {
        if (r100 == null) goto L4;
        a r102 = new a();
        r102.f570972a = InvitationInfo.parseFromPb(r100.qr_code, r101);
        r102.f570973b = InvitationInfo.parseFromPb(r100.link, r101);
        return r102;
    L4:
        return new a();
    }
}
