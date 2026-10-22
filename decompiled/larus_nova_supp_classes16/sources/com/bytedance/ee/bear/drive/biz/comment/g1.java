package com.bytedance.ee.bear.drive.biz.comment;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g1 implements com.bytedance.ee.bear.lark.dependency.c0.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ MentionUserState b;
    public final /* synthetic */ String c;
    public final /* synthetic */ a1 d;

    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onCancel() {
        tt5.a.h("DriveCommentWrapper", "goToProfileHalfScreen - onCancel, userId: " + this.a + ", userState: " + this.b);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.ee.bear.drive.biz.comment.DriveCommentWrapper$7] */
    @Override // com.bytedance.ee.bear.lark.dependency.c0.a
    public final void onConfirm() {
        tt5.a.h("DriveCommentWrapper", "goToProfileHalfScreen - onConfirm, userId: " + this.a + ", userState: " + this.b);
        MentionUserState r0 = this.b;
        if (r0 != MentionUserState.NO_PERMISSION_SHARABLE) goto L15;
        final a1 r1 = this.d;
        final String r2 = this.a;
        String r3 = this.c;
        if (r1.c != null) goto L7;
        tt5.a.d("DriveCommentWrapper", "requestPermission, mComment is null, targetUserId: " + r2);
        return;
    L7:
        Toast.cancel();
        FragmentActivity r5 = r1.b;
        if (r5 == null) goto L13;
        String r6 = r5.getString(2131887340);
        String r7 = UIHelper.mustacheFormat(r6, "username", r3);
        if (TextUtils.equals(r6, r7) == false) goto L12;
        tt5.a.k("DriveCommentWrapper", "requestPermission, loading format parse failed.");
        r7 = r7.replaceFirst(Pattern.quote("{{username}}"), r3);
    L12:
        Toast.showText(r1.b, r7, 1);
    L13:
        r1.c.g(r2, new DriveCommentWrapper$7(r1, r2));
        return;
    L15:
        if (r0 != MentionUserState.NO_PERMISSION_UNSHARABLE_ASK_OWNER) goto L17;
        a1 r4 = this.d;
        Object[] r8 = {this.a};
        ArrayList r9 = new ArrayList(1);
        Object r10 = r8[0];
        Objects.requireNonNull(r10);
        r9.add(r10);
        a1.d(r4, Collections.unmodifiableList(r9));
        return;
    L17:
        tt5.a.d("DriveCommentWrapper", "goToProfileHalfScreen - onConfirm, invalid userState, userId: " + this.a + ", userState: " + this.b);
    }

    public g1(a1 r1, String r2, MentionUserState r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
