package jq1;

import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.v;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h4 f500024b;

    @Override // jq1.b
    public final List<String> b() {
        return null;
    }

    @Override // jq1.b
    public final long getAgreeMsgId() {
        return 0;
    }

    @Override // jq1.b
    public final o1 getLandscapeAreaCommon() {
        return null;
    }

    @Override // jq1.b
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    @Override // jq1.b
    public final String h() {
        return "";
    }

    @Override // jq1.b
    public final k i() {
        return null;
    }

    @Override // jq1.b
    public final boolean isSelfSendFake() {
        return false;
    }

    @Override // jq1.b
    public final boolean a() {
        return this.f500024b.isOfficialDanmaku();
    }

    @Override // jq1.b
    public final String d() {
        v r100 = this.f500024b.getEffect();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBackgroundColor();
    }

    @Override // jq1.b
    public final CharSequence getChatContent() {
        String r100 = this.f500024b.getChatContent();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // jq1.b
    public final long getMessageId() {
        return this.f500024b.getMessageId();
    }

    @Override // jq1.b
    public final IBaseUser getUserInfo() {
        return this.f500024b.getUserInfo();
    }

    @Override // jq1.b
    public final String c() {
        return b.C6474b.a(this);
    }

    @Override // jq1.b
    public final String e() {
        return b.C6474b.b(this);
    }

    @Override // jq1.b
    public final boolean f() {
        return b.C6474b.c(this);
    }

    @Override // jq1.b
    public final boolean g() {
        return b.C6474b.d(this);
    }

    public f(h4 r100) {
        Intrinsics.checkNotNullParameter(r100, "screenMessage");
        this.f500024b = r100;
    }
}
