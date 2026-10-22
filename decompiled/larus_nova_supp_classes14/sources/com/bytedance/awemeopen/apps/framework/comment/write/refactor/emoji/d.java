package com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.comment.emoji.OnlineSmallEmojiResManager;
import com.bytedance.awemeopen.apps.framework.comment.emoji.model.OnlineSmallEmojiResInfo;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiExtParams;
import com.bytedance.awemeopen.emojires.EmojiValueRes;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a {
    public final /* synthetic */ EmojiGifPresenter a;

    public d(EmojiGifPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.d.a
    public final void a(int r12) {
        boolean r0 = false;
        if (r12 != 0) goto L58;
        EmojiGifPresenter r13 = this.a;
        com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a r2 = r13.n;
        if (r2 != null) goto L54;
        if (r2 != null) goto L54;
        if (r13.l == null) goto L54;
        if (r13.k != null) goto L19;
        CommentMentionEditText r3 = (CommentMentionEditText) r13.h.getValue();
        if (r3 == null) goto L16;
        int r4 = r13.f.m;
        vy3.a r5 = new vy3.a(r3, r13);
    L17:
        r13.k = r5;
        goto L19
    L16:
        r5 = null;
    L19:
        if (r13.o != null) goto L43;
        OnlineSmallEmojiResManager r6 = OnlineSmallEmojiResManager.i;
        int r7 = ((LinkedHashMap) r6.d.getValue()).size();
        if (r6.c() == true) goto L23;
        ArrayList r8 = new ArrayList();
    L42:
        r13.o = r8;
        goto L43
    L23:
        ArrayList r9 = new ArrayList();
        if (((LinkedHashMap) r6.d.getValue()).size() <= 0) goto L41;
        Iterator r10 = ((LinkedHashMap) r6.d.getValue()).entrySet().iterator();
        int r11 = 0;
    L28:
        if (r10.hasNext() == false) goto L36;
        Map.Entry r14 = (Map.Entry) r10.next();
        if (r11 >= 0) goto L32;
    L34:
        r11 = r11 + 1;
        if (r11 < (0 + r7)) goto L28;
    L32:
        if (r11 >= (0 + r7)) goto L34;
        m44.b r15 = new m44.b();
        r15.c = (String) r14.getKey();
        String r16 = (String) r14.getValue();
        StringBuilder r17 = new StringBuilder("file://");
        OnlineSmallEmojiResInfo r18 = r6.a;
        Intrinsics.checkNotNull(r18);
        r17.append(r18.getPicFileDirPath());
        r17.append(File.separator);
        r17.append(r16);
        r15.b = r17.toString();
        r9.add(r15);
    L36:
        int r19 = r7 - r9.size();
        if (r19 <= 0) goto L41;
        int r20 = 0;
    L39:
        if (r20 >= r19) goto L41;
        r9.add(new m44.b());
        r20 = r20 + 1;
    L41:
        r8 = r9;
    L43:
        List<Object> r21 = r13.o;
        if (r21 != null) goto L46;
    L50:
        y54.a.a();
        v04.a.a().getClass();
        r13.o = EmojiValueRes.getRecEmojiList();
    L51:
        EmojiChooseParams r22 = new EmojiChooseParams();
        r22.isBuildSmallEmojis = true;
        r22.enableSmallEmojiSendBtn = true;
        r22.isBuildSelfEmojis = true;
        r22.isLandscape = r13.f.e;
        r22.commentRecEmoji = r13.o;
        vy3.a r23 = r13.k;
        Intrinsics.checkNotNull(r23);
        LinearLayout r24 = r13.l;
        Intrinsics.checkNotNull(r24);
        com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a r25 = new com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a(r23, r24, new c(r13), r22);
        r13.n = r25;
        LinearLayout r110 = r13.l;
        if (r110 == null) goto L54;
        View r26 = r25.b;
        Intrinsics.checkNotNull(r26);
        r110.addView(r26);
        goto L54
    L46:
        if (r21.size() != 0) goto L48;
        boolean r27 = true;
    L49:
        if (r27 == false) goto L51;
    L48:
        r27 = false;
    L54:
        EmojiGifPresenter r111 = this.a;
        com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a r28 = r111.n;
        ez3.e r112 = r111.E();
        if (r112 == null) goto L58;
        r112.h();
    L58:
        if (this.a.n == null) goto L80;
        EmojiExtParams r113 = new EmojiExtParams();
        EmojiGifPresenter r29 = this.a;
        iy3.a<?> r30 = r29.f.f;
        if (r30 == null) goto L63;
        String r31 = r30.a;
        if (r31 == null) goto L63;
    L64:
        r113.setAwemeId(r31);
        String r32 = r29.f.j;
        if (r32 != null) goto L67;
        r32 = "";
    L67:
        r113.setEnterFrom(r32);
        String r33 = r29.f.l;
        if (r33 != null) goto L70;
    L71:
        r0 = true;
    L72:
        if (r0 == true) goto L74;
        r113.setForceLandingTypeKey(r29.f.l);
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r114 = r29.f;
        r114.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r114.l = "";
    L74:
        Unit r115 = Unit.INSTANCE;
        return;
    L70:
        if (r33.length() != 0) goto L72;
    L63:
        r31 = "";
        goto L64
    }
}
