package cz3;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<Object> implements l {
    public my3.d g;
    public boolean h;
    public final Handler i;

    public static final class a extends jy3.d {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        @Override // jy3.d
        public final void a(CharSequence r18, CommentMobParameters r19) {
            m r5 = this.a;
            r5.getClass();
            String r1 = StringsKt.trim(String.valueOf(r18)).toString();
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            ToastUtils.b(r5.d.a, 2131894298);
            return;
        L11:
            int r3 = String.valueOf(r18).length();
            int r4 = com.bytedance.awemeopen.apps.framework.comment.write.utils.b.a;
            if (r3 <= 100) goto L15;
            ToastUtils.b(r5.d.a, 2131894299);
            return;
        L15:
            if (r5.h == true) goto L69;
            r5.h = true;
            if (r5.d.b.g.containsKey("is_card_mode") == true) goto L20;
        L22:
            boolean r6 = false;
        L23:
            CommentInputContentViewModel r7 = (CommentInputContentViewModel) r5.d.q.getValue();
            String r8 = null;
            if (r7 == null) goto L26;
            o14.a r9 = r7.getCurrentReplyComment();
        L27:
            if (r9 != null) goto L29;
            String r12 = null;
            String r13 = null;
        L50:
            if (r5.g == null) goto L68;
            hy3.b r10 = r5.d.g;
            if (r10 == null) goto L59;
            hy3.c r11 = r10.b;
            if (r11 == null) goto L59;
            r14.c r14 = r11.a();
            if (r14 == null) goto L59;
            String r15 = r14.c();
            if (r15 == null) goto L59;
        L60:
            String r16 = r15;
            String r17 = String.valueOf(r18);
            Activity r20 = r5.d.b.getActivity();
            int r110 = com.bytedance.awemeopen.bizmodels.user.a.a;
            if (r6 == false) goto L63;
            Map r21 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_card_mode", CommentScene.COMMENTSCENE_NO_AWEME)});
        L64:
            com.bytedance.awemeopen.bizmodels.user.f r111 = new com.bytedance.awemeopen.bizmodels.user.f(r20, "comment", r21);
            o r112 = new o(r19, r18, r8, r5, r9);
            Intrinsics.checkNotNullParameter(r16, "awemeId");
            Intrinsics.checkNotNullParameter(r17, "commentStr");
            Intrinsics.checkNotNullParameter(r111, "loginConfig");
            Intrinsics.checkNotNullParameter(r112, "callback");
            d14.a r22 = b14.a.a;
            b14.a.a(p24.e.class).z(y54.a.a(), r16, r12, r13, r17, r111, r112);
            return;
        L63:
            r21 = new LinkedHashMap();
        L59:
            r15 = "";
            goto L60
        L68:
            return;
        L29:
            String r23 = r9.i();
            if (r23 != null) goto L32;
        L35:
            boolean r24 = true;
        L36:
            if (r24 == false) goto L38;
        L44:
            String r25 = r9.cid;
            User r113 = r9.o();
            if (r113 == null) goto L47;
            String r114 = r113.u();
        L48:
            r13 = null;
            r12 = r25;
            r8 = r114;
            goto L50
        L47:
            r114 = null;
            goto L48
        L38:
            if (Intrinsics.areEqual(r9.i(), "0") == true) goto L44;
            String r26 = r9.i();
            String r115 = r9.cid;
            User r116 = r9.o();
            if (r116 == null) goto L43;
            r8 = r116.u();
        L43:
            r12 = r26;
            r13 = r115;
            goto L50
        L32:
            if (r23.length() == 0) goto L35;
            r24 = false;
            goto L36
        L26:
            r9 = null;
            goto L27
        L20:
            if (Intrinsics.areEqual(r5.d.b.g.get("is_card_mode"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L22;
            r6 = true;
            goto L23
        L69:
            return;
        L5:
            if (r1.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void E() {
        this.g = new my3.d();
        a r0 = new a(this);
        g r1 = this.d.o;
        if (r1 == null) goto L6;
        r1.g(r0);
        return;
    }

    public m(ManagerContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "managerContext");
        Intrinsics.checkNotNullParameter(r3, "tag");
        super(r2, r3);
        H(l.class, this);
        r2.p = this;
        this.i = new Handler(Looper.getMainLooper());
    }
}
