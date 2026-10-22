package com.larus.bmhome.chat.detail.code;

import android.os.Handler;
import android.os.SystemClock;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j0 implements mf9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f302754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f302755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h0 f302756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f302757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f302758e;

    @Override // mf9.d
    public final void onCancel() {
        FLogger.f375446a.i("DeepResearchFetchCodeHelper", "fetch deep research code cancel , id = " + this.f302757d + " curCursor = " + this.f302758e + ", pastTime[" + (SystemClock.elapsedRealtime() - this.f302756c.f302744b) + ']');
        n0 r100 = this.f302756c.f302745c;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // mf9.d
    public final void a(List<Block> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f302754a) >= 2000) goto L5;
        return;
    L5:
        this.f302754a = r101;
        this.f302756c.getClass();
        String r102 = h0.a(r100);
        if (this.f302755b != r102.length()) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        this.f302756c.getClass();
        this.f302755b = h0.a(r100).length();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("fetch deep research code update , id = ");
        r105.append(this.f302757d);
        r105.append(" curCursor = ");
        r105.append(this.f302758e);
        r105.append(", pastTime[");
        r105.append(SystemClock.elapsedRealtime() - this.f302756c.f302744b);
        r105.append("], codeLength[");
        this.f302756c.getClass();
        r105.append(Integer.valueOf(h0.a(r100).length()));
        r105.append(']');
        r104.d("DeepResearchFetchCodeHelper", r105.toString());
        n0 r106 = this.f302756c.f302745c;
        if (r106 == null) goto L15;
        r106.c(h0.a(r100), false);
        return;
    L15:
        return;
    L8:
        r103 = false;
        goto L9
    }

    @Override // mf9.d
    public final void b(final List<Block> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        long r101 = 2000 - (SystemClock.elapsedRealtime() - this.f302754a);
        Handler r102 = (Handler) this.f302756c.f302747e.getValue();
        final String r103 = this.f302757d;
        final int r104 = this.f302758e;
        final h0 r105 = this.f302756c;
        r102.postDelayed(new i0(r103, r104, r105, r100), r101);
    }

    @Override // mf9.d
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("DeepResearchFetchCodeHelper", "fetch deep research code error , id = " + this.f302757d + " curCursor = " + this.f302758e + " code = " + r100 + ", msg = " + r101 + ", pastTime[" + (SystemClock.elapsedRealtime() - this.f302756c.f302744b) + ']');
        n0 r102 = this.f302756c.f302745c;
        if (r102 == null) goto L6;
        r102.a();
        return;
    }

    public j0(h0 r100, String r101, int r102) {
        this.f302756c = r100;
        this.f302757d = r101;
        this.f302758e = r102;
    }
}
