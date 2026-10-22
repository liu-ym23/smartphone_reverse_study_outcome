package ng2;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519050b;

    public a() {
        this(0);
    }

    public a(int r100) {
        Intrinsics.checkNotNullParameter("直播公告是展示在个人页等位置的公告信息，经常更新公告可以帮助粉丝了解你的的开播计划，准时来观看", SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter("https://www.google.com.hk/webhp?hl=zh-CN&sourceid=cnhp&gws_rd=ssl", "url");
        this.f519049a = "直播公告是展示在个人页等位置的公告信息，经常更新公告可以帮助粉丝了解你的的开播计划，准时来观看";
        this.f519050b = "https://www.google.com.hk/webhp?hl=zh-CN&sourceid=cnhp&gws_rd=ssl";
    }
}
