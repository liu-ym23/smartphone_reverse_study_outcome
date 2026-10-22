package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public class w0 extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<PromptContent.SuggestItem> f305729e;

    @Override // xc8.b
    public int d() {
        return 0;
    }

    public w0(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "promptMessage");
        super(r100);
        this.f305729e = CollectionsKt.emptyList();
    }
}
