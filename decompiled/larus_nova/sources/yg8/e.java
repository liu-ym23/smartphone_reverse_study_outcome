package yg8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.timestamp.TimestampCell;
import com.larus.bmhome.chat.trace.i0;
import com.larus.common_ui.dialog.u;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimestampCell f567520a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        int r100 = i0.f310221a;
        TimestampCell r101 = this.f567520a;
        int r102 = TimestampCell.f306540k;
        y r103 = r101.o();
        String r104 = "";
        if (r103 == null) goto L6;
        String r105 = r103.getBotId();
        if (r105 == null) goto L6;
    L7:
        y r106 = this.f567520a.o();
        if (r106 == null) goto L13;
        String r107 = r106.Y1();
        if (r107 == null) goto L13;
        r104 = r107;
    L13:
        JSONObject r108 = TimestampCell.r(r105, r104);
        Intrinsics.checkNotNullParameter(r108, "params");
        i0.a("cancel_edit_chat_name", r108, null);
        return;
    L6:
        r105 = "";
        goto L7
    }

    public e(TimestampCell r100) {
        this.f567520a = r100;
    }
}
