package gya;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.statistics.PerfLog;
import f5b.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface a<C extends Content> {

    /* JADX INFO: renamed from: gya.a$a, reason: collision with other inner class name */
    public static final class C6083a {
        public static void a(Context r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "messageInfo");
        }

        public static void b(com.bytedance.lark.pb.basic.v1.Content r100, BaseTextContent r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "pbContent");
            Intrinsics.checkNotNullParameter(r101, "baseTextContent");
            Intrinsics.checkNotNullParameter(r102, "messageId");
        }
    }

    MessageType a();

    boolean b();

    boolean c();

    String d(Context r100, C r101);

    C e(Entity r100, Message r101, com.bytedance.lark.pb.basic.v1.Content r102, TranslateInfo r103);

    String f(Context r100, C r101);

    C g(Entity r100, Message r101, com.bytedance.lark.pb.basic.v1.Content r102);

    String h(Context r100, b r101);

    void i(com.bytedance.lark.pb.basic.v1.Content r100, BaseTextContent<?> r101, String r102, Entity r103);
}
