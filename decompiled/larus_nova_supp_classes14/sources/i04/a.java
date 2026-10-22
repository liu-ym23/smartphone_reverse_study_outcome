package i04;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog;
import com.bytedance.awemeopen.domain.user.login.onekey.OneKeyLogin;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements PhoneNumberLoginDialog.b {
    public final /* synthetic */ c24.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map<String, String> c;

    public final void a() {
        this.a.a();
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        int r2 = com.bytedance.awemeopen.bizmodels.user.a.a;
        String r3 = com.bytedance.awemeopen.bizmodels.user.a.a(this.b);
        Map<String, String> r4 = this.c;
        boolean r5 = false;
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L12:
        r1.X0(r3, "no", "other_aweme_account", r5);
        return;
    L10:
        if (Intrinsics.areEqual(this.c.get("is_card_mode"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L12;
        r5 = true;
        goto L12
    L5:
        if (r4.containsKey("is_card_mode") != true) goto L7;
        r6 = true;
        goto L8
    }

    public final void onCancel() {
        this.a.cancel();
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        int r2 = com.bytedance.awemeopen.bizmodels.user.a.a;
        String r3 = com.bytedance.awemeopen.bizmodels.user.a.a(this.b);
        Map<String, String> r4 = this.c;
        boolean r5 = false;
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L12:
        r1.X0(r3, "mix", "cancel", r5);
        return;
    L10:
        if (Intrinsics.areEqual(this.c.get("is_card_mode"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L12;
        r5 = true;
        goto L12
    L5:
        if (r4.containsKey("is_card_mode") != true) goto L7;
        r6 = true;
        goto L8
    }

    public final void onConfirm() {
        this.a.confirm();
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        int r2 = com.bytedance.awemeopen.bizmodels.user.a.a;
        String r3 = com.bytedance.awemeopen.bizmodels.user.a.a(this.b);
        Map<String, String> r4 = this.c;
        boolean r5 = false;
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L12:
        r1.X0(r3, "yes", "immediate_relevance", r5);
        return;
    L10:
        if (Intrinsics.areEqual(this.c.get("is_card_mode"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L12;
        r5 = true;
        goto L12
    L5:
        if (r4.containsKey("is_card_mode") != true) goto L7;
        r6 = true;
        goto L8
    }

    public a(OneKeyLogin.login.handler.1.a r1, String r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
