package jza;

import android.content.Context;
import com.ss.android.lark.biz.officesdk.im.file.FlowFilePreviewData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    FlowFilePreviewData a(String r100, String r101, String r102, String r103, Message r104, Chat r105);

    boolean b(Context r100, Message r101, Chat r102);

    void c(Context r100, FlowFilePreviewData r101, Function0<Unit> r102);

    void d(FlowFilePreviewData r100);
}
