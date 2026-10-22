package k4b;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Function1<f5b.b, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f501771a;

    public c(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "userIdList");
        this.f501771a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(f5b.b r100) {
        f5b.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "p1");
        Map<String, String> r102 = this.f501771a;
        ChatChatter r103 = r101.getMessageSender();
        if (r103 == null) goto L5;
        String r104 = r103.getId();
    L7:
        return Boolean.valueOf(r102.containsKey(r104));
    L5:
        r104 = null;
        goto L7
    }
}
