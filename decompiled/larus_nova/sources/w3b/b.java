package w3b;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.DataPreLoaderType;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements d<ChatMessageResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558217b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return String.format("ChatWindowPreLoadTask_chatId:%s_showPosition:%s", Arrays.copyOf(new Object[]{this.f558216a, String.valueOf(this.f558217b)}, 2));
    }

    @Override // w3b.d
    public final DataPreLoaderType type() {
        return DataPreLoaderType.CHAT_WINDOW;
    }

    public b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f558216a = r100;
        this.f558217b = r101;
    }
}
