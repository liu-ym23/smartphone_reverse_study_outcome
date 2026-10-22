package v99;

import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.IEnterKeyBehaviorService;
import com.ss.android.lark.biz.im.api.extension.keyboard.config.EnterKeyBehavior;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes29.dex */
public final class p implements yxa.b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f553860a = null;

        static {
            int[] r100 = new int[EnterKeyAction.values().length];
            r100[EnterKeyAction.SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f553860a = r100;
        }
    }

    public p() {
    }

    @Override // yxa.b
    public final yxa.a a() {
        IEnterKeyBehaviorService r100 = (IEnterKeyBehaviorService) ServiceManager.get().getService(IEnterKeyBehaviorService.class);
        if (r100 == null) goto L5;
        EnterKeyAction r101 = r100.a();
    L6:
        if (r101 != null) goto L8;
        int r102 = -1;
    L10:
        if (r102 != 1) goto L12;
        EnterKeyBehavior r103 = EnterKeyBehavior.SEND;
    L14:
        return new yxa.a(r103);
    L12:
        r103 = EnterKeyBehavior.NEWLINE;
        goto L14
    L8:
        r102 = a.f553860a[r101.ordinal()];
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
