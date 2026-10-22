package com.larus.bmhome.chat.component.ext;

import com.larus.bmhome.chat.trace.ChatMessageTrace;
import com.larus.common_ui.dialog.u;
import com.larus.im.bean.message.Message;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Message> f300682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f300683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f300684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f300685d;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        ChatMessageTrace r100 = ChatMessageTrace.f310037a;
        ChatMessageTrace.d(this.f300682a, this.f300683b, this.f300684c, false, "cancel_btn_click", this.f300685d);
    }

    public b(List<Message> r100, String r101, Integer r102, JSONObject r103) {
        this.f300682a = r100;
        this.f300683b = r101;
        this.f300684c = r102;
        this.f300685d = r103;
    }
}
