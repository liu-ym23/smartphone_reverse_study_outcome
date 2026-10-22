package com.ss.android.lark.mergeforward;

import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import kotlin.Unit;
import y9c.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.mergeforward.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5129a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f431881a = null;

        static {
            int[] r100 = new int[Chat.Type.values().length];
            r100[Chat.Type.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Chat.Type.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f431881a = r100;
        }
    }

    static {
    }

    public static String a(MergeForwardContent r100) {
        StringBuilder r101 = new StringBuilder();
        Chat.Type r102 = r100.getType();
        if (r102 != null) goto L6;
        r102 = Chat.Type.UNKNOWN;
    L6:
        if (TextUtils.isEmpty(r100.getQuasiTitle()) == true) goto L11;
        String r103 = r100.getQuasiTitle();
        if (r103 != null) goto L23;
        return "";
    L23:
        return r103;
    L11:
        int r104 = C5129a.f431881a[r102.ordinal()];
        if (r104 != 1) goto L14;
        String r105 = r100.getP2pCreatorName();
        String r106 = r100.getP2pPartnerName();
        r101.append(r105);
        if (TextUtils.isEmpty(r106) == true) goto L20;
        r101.append(d.h(R.string.Lark_Legacy_MergeForwardAnd));
        r101.append(r106);
    L20:
        r101.append(d.h(R.string.Lark_Legacy_MergeForwardTitleSuffix));
    L22:
        return r101.toString();
    L14:
        if (r104 == 2) goto L16;
        Unit r107 = Unit.INSTANCE;
        goto L22
    L16:
        r101.append(d.h(R.string.Lark_Legacy_GroupChatHistory));
        goto L22
    }
}
