package s22;

import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface b {
    IMEmoji a(String r100);

    void b(String r100, Function1<? super String, Unit> r101);

    List<IMEmoji> getEmojiList();
}
