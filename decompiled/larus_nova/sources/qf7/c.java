package qf7;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;

/* JADX INFO: loaded from: classes22.dex */
public interface c extends lf7.a {
    void a(ClipboardManager r100, ClipData r101, Token r102) throws SensitiveAPIException;

    ClipData d(ClipboardManager r100, Token r101) throws SensitiveAPIException;
}
