package km5;

import android.content.ComponentName;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final ComponentName a(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L19;
        if (r3 == 3) goto L18;
        if (r3 == 4) goto L17;
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
