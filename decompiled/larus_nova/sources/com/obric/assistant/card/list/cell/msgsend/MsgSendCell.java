package com.obric.assistant.card.list.cell.msgsend;

import android.content.Context;
import com.obric.assistant.card.list.cell.AppEntityCell;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oca.b;
import oca.j0;
import vca.a;
import xc8.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/card/list/cell/msgsend/MsgSendCell;", "Lcom/obric/assistant/card/list/cell/AppEntityCell;", "Lcom/obric/assistant/card/list/cell/msgsend/MsgSendCellState;", "Lcom/obric/assistant/card/layout/item/MsgSendBox;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "box", "getBox", "()Lcom/obric/assistant/card/layout/item/MsgSendBox;", "setBox", "(Lcom/obric/assistant/card/layout/item/MsgSendBox;)V", "createBox", "Lcom/larus/bmhome/chat/cell/MessageBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MsgSendCell extends AppEntityCell<a, j0> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f386499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j0 f386500k;

    @Override // com.obric.assistant.card.list.cell.AppEntityCell
    public final b r() {
        j0 r100 = this.f386500k;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("box");
        return null;
    L7:
        return r100;
    }

    public MsgSendCell() {
        this.f386499j = "MsgSendCell";
    }

    @Override // com.obric.assistant.card.list.cell.AppEntityCell
    public final String s() {
        return this.f386499j;
    }

    @Override // com.obric.assistant.card.list.cell.AppEntityCell
    public final h o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        j0 r101 = new j0(r100);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f386500k = r101;
        return r101;
    }
}
