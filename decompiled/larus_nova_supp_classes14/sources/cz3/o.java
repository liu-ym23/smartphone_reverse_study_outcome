package cz3;

import android.text.TextUtils;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.utils.AccountUsageHintHelper;
import com.bytedance.awemeopen.apps.framework.utils.h0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements p24.d {
    public final /* synthetic */ CommentMobParameters a;
    public final /* synthetic */ CharSequence b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m d;
    public final /* synthetic */ o14.a e;

    public final void onFail(Exception r2) {
        m r3 = this.d;
        r3.h = false;
        ToastUtils.b(r3.d.a, 2131894300);
    }

    public final void onSuccess(Object r8) {
        o14.b r9 = (o14.b) r8;
        Intrinsics.checkNotNullParameter(r9, "data");
        CommentMobParameters.a r0 = new CommentMobParameters.a();
        CommentMobParameters r1 = this.a;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getAuthorOpenId();
    L6:
        r0.d = r3;
        CommentMobParameters r4 = this.a;
        if (r4 == null) goto L9;
        String r5 = r4.getEnterFrom();
    L10:
        r0.b = r5;
        CommentMobParameters r6 = this.a;
        if (r6 == null) goto L13;
        String r7 = r6.getPreviousPage();
    L14:
        r0.l = r7;
        CommentMobParameters r10 = this.a;
        if (r10 == null) goto L17;
        String r11 = r10.getGroupId();
    L18:
        r0.c = r11;
        CommentMobParameters r12 = this.a;
        if (r12 == null) goto L21;
        String r13 = r12.getImprId();
    L22:
        r0.e = r13;
        CommentMobParameters r14 = this.a;
        if (r14 == null) goto L26;
        String r15 = r14.getClickType();
        if (r15 == null) goto L26;
    L27:
        Intrinsics.checkNotNullParameter(r15, "clickType");
        r0.a = r15;
        CommentMobParameters r16 = this.a;
        if (r16 == null) goto L30;
        JSONObject r17 = r16.getHostExtraParams();
    L31:
        r0.m = r17;
        r0.g = "post_comment";
        String r18 = String.valueOf(this.b);
        Pattern r19 = v04.b.a;
        int r20 = 0;
        if (TextUtils.isEmpty(r18) == false) goto L35;
    L37:
        r0.k = r20;
        r0.n = this.c;
        CommentMobParameters r21 = this.a;
        if (r21 == null) goto L40;
        Map<String, Object> r22 = r21.getExtraParams();
    L41:
        r0.o = r22;
        CommentMobParameters r23 = new CommentMobParameters(r0);
        g r24 = this.d.d.o;
        if (r24 == null) goto L44;
        r24.b(r23);
    L44:
        m r25 = this.d;
        o14.a r26 = this.e;
        r25.getClass();
        o14.c r27 = r9.e();
        if (r27 == null) goto L67;
        o14.a r28 = r27.a();
        if (r28 == null) goto L67;
        if (r26 != null) goto L51;
        int r29 = 1;
    L52:
        r28.a = r29;
        if (r28.o() != null) goto L56;
        d14.a r30 = b14.a.a;
        r28.x(b14.a.a(k34.b.class).b());
    L56:
        if (h0.a(r28.j()) == true) goto L58;
    L66:
        Lazy r31 = AccountUsageHintHelper.a;
        AccountUsageHintHelper.b(r25.d.a);
        goto L67
    L58:
        if (Intrinsics.areEqual(r28.j(), "0") == true) goto L66;
        if (r26 == null) goto L64;
        User r32 = r26.o();
        if (r32 == null) goto L64;
        r2 = r32.t();
    L64:
        if (h0.a(r2) == false) goto L66;
        r28.u(r2);
        goto L66
    L51:
        r29 = 2;
    L67:
        hy3.b r33 = this.d.d.g;
        if (r33 == null) goto L72;
        hy3.c r34 = r33.b;
        if (r34 == null) goto L72;
        r34.c(r23, r9);
    L72:
        final m r35 = this.d;
        r35.i.postDelayed(new n(r35), 500);
        return;
    L40:
        r22 = null;
    L35:
        if (v04.b.a.matcher(r18).find() == false) goto L37;
        r20 = r20 + 1;
        goto L35
    L30:
        r17 = null;
    L26:
        r15 = "";
        goto L27
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public o(CommentMobParameters r1, CharSequence r2, String r3, m r4, o14.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
