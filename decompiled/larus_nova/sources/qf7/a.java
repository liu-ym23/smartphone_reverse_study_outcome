package qf7;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f532746a = null;

    static {
        f532746a = new a();
    }

    public a() {
    }

    @Override // qf7.c
    public final ClipData d(ClipboardManager r100, Token r101) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "token");
        rf7.a.a(r101, new of7.b(CollectionsKt.listOf(AtomicInfoDef.CLIPBOARD_MANAGER_GET_PRIMARY_CLIP)));
        lf7.b r102 = d.f509087a;
        Intrinsics.checkNotNullParameter(this, "this");
        lf7.a r103 = d.a(DataType.CLIPBOARD);
        if ((r103 instanceof c) == false) goto L5;
        c r104 = (c) r103;
    L7:
        return r104.d(r100, r101);
    L5:
        r104 = new b();
        goto L7
    }

    @Override // qf7.c
    public final void a(ClipboardManager r100, ClipData r101, Token r102) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "clip");
        Intrinsics.checkNotNullParameter(r102, "token");
        rf7.a.a(r102, new of7.b(CollectionsKt.listOf(AtomicInfoDef.CLIPBOARD_MANAGER_SET_PRIMARY_CLIP)));
        lf7.b r103 = d.f509087a;
        Intrinsics.checkNotNullParameter(this, "this");
        lf7.a r104 = d.a(DataType.CLIPBOARD);
        if ((r104 instanceof c) == false) goto L5;
        c r105 = (c) r104;
    L6:
        r105.a(r100, r101, r102);
        return;
    L5:
        r105 = new b();
        goto L6
    }
}
