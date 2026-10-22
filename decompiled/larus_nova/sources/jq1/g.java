package jq1;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdkapi.message.OfficialCommentConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q5 f500025b;

    @Override // jq1.b
    public final boolean a() {
        return this.f500025b.a();
    }

    @Override // jq1.b
    public final List<String> b() {
        return this.f500025b.b();
    }

    @Override // jq1.b
    public final String d() {
        OfficialCommentConfig r100 = this.f500025b.getOfficialCommentConfig();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBackgroundColor();
    }

    @Override // jq1.b
    public final long getAgreeMsgId() {
        return this.f500025b.getAgreeMsgId();
    }

    @Override // jq1.b
    public final CharSequence getChatContent() {
        VSShowChatMessageCommentRoleConfig r100 = this.f500025b.G0();
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.getCharactorName();
        if (r102 == null) goto L6;
    L7:
        String r103 = this.f500025b.getChatContent();
        if (r103 == null) goto L12;
        r101 = r103;
    L12:
        return r102.concat(r101);
    L6:
        r102 = "";
        goto L7
    }

    @Override // jq1.b
    public final o1 getLandscapeAreaCommon() {
        return this.f500025b.getLandscapeAreaCommon();
    }

    @Override // jq1.b
    public final j0 getMedal() {
        return this.f500025b.getMedal();
    }

    @Override // jq1.b
    public final long getMessageId() {
        return this.f500025b.getMessageId();
    }

    @Override // jq1.b
    public final IBaseUser getUserInfo() {
        return this.f500025b.getUserInfo();
    }

    @Override // jq1.b
    public final String h() {
        VSShowChatMessageCommentRoleConfig r100 = this.f500025b.G0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCharactorName();
    }

    @Override // jq1.b
    public final k i() {
        VSShowChatMessageCommentRoleConfig r100 = this.f500025b.G0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCharactorAvatar();
    }

    @Override // jq1.b
    public final boolean isSelfSendFake() {
        return this.f500025b.isSelfSendFake();
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

    public g(q5 r100) {
        Intrinsics.checkNotNullParameter(r100, "showChatMessage");
        this.f500025b = r100;
    }
}
