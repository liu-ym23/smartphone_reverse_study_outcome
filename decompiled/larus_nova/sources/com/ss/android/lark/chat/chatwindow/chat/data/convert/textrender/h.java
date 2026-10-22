package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends AbsTextLayoutCacheStore {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f412477e;

    public static final class a {
    }

    static {
    }

    public h() {
        this.f412477e = 60;
    }

    public static int i(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r100) {
        Object[] r101 = new Object[36];
        r101[0] = r100.f412402a;
        int r102 = 1;
        r101[1] = r100.f412404b;
        r101[2] = Boolean.valueOf(r100.f412406c);
        r101[3] = Boolean.valueOf(r100.f412408d);
        r101[4] = Boolean.valueOf(r100.f412410e);
        r101[5] = Boolean.valueOf(r100.f412412f);
        r101[6] = Boolean.valueOf(r100.f412414g);
        r101[7] = Boolean.valueOf(r100.f412415h);
        r101[8] = Boolean.valueOf(r100.f412416i);
        r101[9] = Boolean.valueOf(r100.f412418k);
        r101[10] = r100.f412419l;
        r101[11] = Boolean.valueOf(r100.f412420m);
        ResultType r103 = r100.f412421n.getResult();
        if (r103 != ResultType.ALLOW) goto L5;
    L8:
        r101[12] = Integer.valueOf(r102);
        r101[13] = Boolean.valueOf(r100.f412422o);
        r101[14] = r100.f412423p;
        r101[15] = Boolean.valueOf(r100.f412425r);
        r101[16] = Boolean.valueOf(r100.f412426s);
        r101[17] = r100.f412427t;
        Boolean r104 = Boolean.FALSE;
        r101[18] = r104;
        r101[19] = r100.f412429v;
        r101[20] = Boolean.valueOf(r100.f412430w);
        r101[21] = Integer.valueOf(r100.f412431x);
        r101[22] = Integer.valueOf(r100.f412432y);
        r101[23] = r100.B;
        r101[24] = Boolean.valueOf(r100.D);
        r101[25] = Boolean.valueOf(r100.E);
        r101[26] = Boolean.valueOf(r100.F);
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b.InterfaceC4800b r105 = r100.G;
        if (r105 == null) goto L11;
        Integer r106 = r105.a();
    L12:
        r101[27] = r106;
        r101[28] = Boolean.valueOf(r100.f412401J);
        r101[29] = Boolean.valueOf(r100.K);
        r101[30] = Integer.valueOf(r100.L);
        r101[31] = Integer.valueOf(r100.M);
        r101[32] = r104;
        r101[33] = 0;
        r101[34] = 0;
        r101[35] = Boolean.valueOf(r100.O);
        return Objects.hash(r101);
    L11:
        r106 = null;
        goto L12
    L5:
        if (r103 == ResultType.NULL) goto L8;
        r102 = r103.hashCode();
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore
    public final AbsTextLayoutCacheStore.b f(TextLayoutRender.e r100) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r101 = r100.f412449c;
        long r102 = System.currentTimeMillis();
        if (j(r101) == true) goto L5;
        int r103 = Objects.hash(new Object[]{Integer.valueOf(r100.f412453d.hashCode()), Integer.valueOf(i(r101))});
        Log.d("TextLayoutCacheStore", "obtainParseCacheKey: hash cost: " + (System.currentTimeMillis() - r102));
        String r104 = r101.f412423p;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        return new AbsTextLayoutCacheStore.b(r104, r103);
    L5:
        return AbsTextLayoutCacheStore.f412436d;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore
    public final AbsTextLayoutCacheStore.b g(TextLayoutRender.g r100) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r101 = r100.f412449c;
        long r102 = System.currentTimeMillis();
        if (j(r101) == true) goto L5;
        int r103 = Objects.hash(new Object[]{Integer.valueOf(r100.f412454d.hashCode()), Integer.valueOf(i(r101))});
        Log.d("TextLayoutCacheStore", "obtainRenderCacheKey: hash cost: " + (System.currentTimeMillis() - r102));
        String r104 = r101.f412423p;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        return new AbsTextLayoutCacheStore.b(r104, r103);
    L5:
        return AbsTextLayoutCacheStore.f412436d;
    }

    public final boolean j(com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r100) {
        if (this.f412477e == 0) goto L17;
        String r101 = r100.f412423p;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return true;
    L13:
        if (r100.P == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L17:
        return true;
    }
}
