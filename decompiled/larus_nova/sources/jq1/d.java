package jq1;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f500022b;

    @Override // jq1.b
    public final boolean a() {
        return false;
    }

    @Override // jq1.b
    public final List<String> b() {
        return null;
    }

    @Override // jq1.b
    public final String d() {
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
    public final CharSequence getChatContent() {
        String r100 = this.f500022b.getChatContent();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // jq1.b
    public final long getMessageId() {
        return this.f500022b.getMessageId();
    }

    @Override // jq1.b
    public final IBaseUser getUserInfo() {
        return this.f500022b.getUserInfo();
    }

    @Override // jq1.b
    public final boolean isSelfSendFake() {
        return this.f500022b.isInsert();
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

    public d(r r100) {
        Intrinsics.checkNotNullParameter(r100, "audioChatMessage");
        this.f500022b = r100;
    }
}
