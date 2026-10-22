package zaa;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.obric.assistant.activation.presentation.contract.ipc.VoiceInteractionSessionController;

/* JADX INFO: loaded from: classes32.dex */
public interface a {
    void a(int r100, int r101, boolean r102, AssistStructure r103, AssistContent r104);

    void b(long r100, VoiceInteractionSessionController r101);

    void c(Bitmap r100);

    void d(Bundle r100, int r101);

    void e(long r100);
}
