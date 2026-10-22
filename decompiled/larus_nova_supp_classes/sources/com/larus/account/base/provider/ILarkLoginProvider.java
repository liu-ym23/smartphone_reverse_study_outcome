package com.larus.account.base.provider;

import android.content.Context;
import android.util.EventsUtils;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.common.account.platform.larkauth.h;
import com.larus.office.base.host.k;
import java.util.Map;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH&JH\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001a"}, d2 = {"Lcom/larus/account/base/provider/ILarkLoginProvider;", XmlPullParser.NO_NAMESPACE, "login", XmlPullParser.NO_NAMESPACE, "activity", "Landroidx/fragment/app/FragmentActivity;", "secUid", XmlPullParser.NO_NAMESPACE, "callback", "Lcom/larus/account/base/api/ILarkLoginCallback;", "updateAuthorizeInfo", "Lcom/larus/account/base/api/ILarkUpdateAuthorizeInfoCallback;", "authorize", "params", XmlPullParser.NO_NAMESPACE, "osType", "terminalType", "completion", "Lkotlin/Function1;", "Lcom/larus/account/base/api/LarkSupplementAuthorizationResult;", "isEnterpriseAccount", XmlPullParser.NO_NAMESPACE, "secUserId", "isLarkAppInstalled", "context", "Landroid/content/Context;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ILarkLoginProvider {
    boolean a(String r1);

    void b(FragmentActivity r1, Map r2, String r3, String r4, k r5);

    void c(FragmentActivity r1, String r2, LoginServiceImpl.c r3);

    void d(FragmentActivity r1, h r2);

    boolean e(Context r1);
}
