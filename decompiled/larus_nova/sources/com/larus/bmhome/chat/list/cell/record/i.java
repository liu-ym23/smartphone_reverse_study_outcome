package com.larus.bmhome.chat.list.cell.record;

import com.larus.common_ui.dialog.p0;
import java.util.Map;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordCardCell f305779a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        RecordCardCell r100 = this.f305779a;
        Map<String, Long> r101 = RecordCardCell.f305742m;
        r100.f305750i.a("click record card confirm");
    }

    public i(RecordCardCell r100) {
        this.f305779a = r100;
    }
}
