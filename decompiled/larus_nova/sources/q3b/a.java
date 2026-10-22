package q3b;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531556a = 0;

    static {
    }

    public static void a(Content r100, Content r101) {
        Intrinsics.checkNotNullParameter(r100, "oldContent");
        Intrinsics.checkNotNullParameter(r101, "newContent");
        AudioContent r102 = null;
        if ((r100 instanceof AudioContent) == false) goto L5;
        AudioContent r103 = (AudioContent) r100;
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if ((r101 instanceof AudioContent) == false) goto L11;
        r102 = (AudioContent) r101;
    L11:
        if (r102 != null) goto L14;
        return;
    L14:
        if (r103.isRecognizeFinished() == true) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == true) goto L21;
        return;
    L21:
        if (r102.isRecognizeFinished() == true) goto L25;
        Log.i("AudioTextStableResultGuard", "keep finished audio text");
        r102.setRecognizedText(r103.getRecognizedText());
        r102.setRecognizedRichText(r103.getRecognizedRichText());
        r102.setRecognizeFinished(r103.isRecognizeFinished());
        r102.setAudio2TextStartTime(r103.getAudio2TextStartTime());
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r103.getRecognizedText()) == true) goto L18;
        r104 = true;
        goto L19
    L5:
        r103 = null;
        goto L6
    }
}
