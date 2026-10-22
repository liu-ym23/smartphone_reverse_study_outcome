package e7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f471263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471264b;

    public a(Chat r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "rootMsgId");
        this.f471263a = r100;
        this.f471264b = r101;
    }
}
