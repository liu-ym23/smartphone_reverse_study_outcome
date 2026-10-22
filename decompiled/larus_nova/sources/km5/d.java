package km5;

import android.content.ComponentName;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f504084a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            r100[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f504084a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final ComponentName a(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        int r101 = a.f504084a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return null;
    L17:
        return new ComponentName("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity");
    L18:
        return new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
    L19:
        return new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
    L15:
        return new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
    }
}
