package com.larus.receive.impl.handler;

import android.content.Context;
import android.content.Intent;
import com.larus.minor.api.IMinorService;
import com.larus.receive.contract.ReceiveTextDelivery;
import com.larus.receive.contract.ReceiveTextDiffContract;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements com.larus.receive.impl.handler.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f367374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.receive.contract.a.C4480a f367375b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367376a = null;

        static {
            int[] r100 = new int[ReceiveTextDelivery.values().length];
            r100[ReceiveTextDelivery.FILL_INPUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReceiveTextDelivery.AUTO_SEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f367376a = r100;
        }
    }

    static {
    }

    public c() {
    }

    @Override // com.larus.receive.impl.handler.b
    public final String getName() {
        return "ReceiveTextHandler";
    }

    @Override // com.larus.receive.impl.handler.b
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("handle, hasText:");
        String r103 = this.f367374a;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        r102.append(!r104);
        r102.append(", currentPage:landing");
        r101.i("ReceiveTextHandler", r102.toString());
        com.larus.receive.contract.a.C4480a r105 = this.f367375b;
        String r106 = this.f367374a;
        if (r106 != null) goto L12;
    L15:
        boolean r107 = true;
    L17:
        if (r107 == true) goto L19;
    L20:
        if (r105 != null) goto L23;
    L21:
        this.f367374a = null;
        this.f367375b = null;
        return;
    L23:
        int r108 = qs9.a.f534692a;
        String r109 = this.f367374a;
        if (r109 != null) goto L26;
        r109 = "";
    L26:
        ReceiveTextDelivery r110 = r105.f367370a;
        Pair[] r111 = new Pair[5];
        r111[0] = TuplesKt.to("argPreviousPage", "landing");
        int r112 = b.f367376a[r110.ordinal()];
        if (r112 == 1) goto L32;
        if (r112 != 2) goto L31;
        String r113 = "share_to_chat_text";
    L33:
        r111[1] = TuplesKt.to(r113, r109);
        r111[2] = TuplesKt.to("enter_method", "selfshare_open");
        r111[3] = TuplesKt.to("enter_from", "selfshare_open");
        r111[4] = TuplesKt.to("ignore_same_page_check", Boolean.TRUE);
        qs9.a.a(r100, f.c(r111));
        this.f367374a = null;
        this.f367375b = null;
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r113 = "input_text";
        goto L33
    L19:
        if (IMinorService.f359156a.a() == false) goto L21;
    L12:
        if (r106.length() == 0) goto L15;
        r107 = false;
        goto L17
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.larus.receive.impl.handler.b
    public final boolean b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        com.larus.receive.contract.a.C4480a r101 = null;
        this.f367374a = null;
        this.f367375b = null;
        if (ArraysKt.contains(new String[]{"android.intent.action.SEND"}, r100.getAction()) == true) goto L5;
        return false;
    L5:
        this.f367374a = r100.getStringExtra("android.intent.extra.TEXT");
        ReceiveTextDiffContract r102 = ReceiveTextDiffContract.f367368b;
        String r103 = r100.getAction();
        String r104 = r100.getType();
        String r105 = this.f367374a;
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        boolean r107 = !r106;
        List r108 = qs9.a.b(r100);
        if (r108 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        com.larus.receive.contract.a r110 = r102.a(new ps9.a(r103, r104, r107, !r109));
        if ((r110 instanceof com.larus.receive.contract.a.C4480a) == false) goto L22;
        r101 = (com.larus.receive.contract.a.C4480a) r110;
    L22:
        this.f367375b = r101;
        if (r101 == null) goto L26;
        return true;
    L26:
        return false;
    L15:
        if (r108.isEmpty() == true) goto L18;
        r109 = false;
        goto L19
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    }
}
