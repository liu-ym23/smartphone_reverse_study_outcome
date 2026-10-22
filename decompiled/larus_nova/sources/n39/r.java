package n39;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public interface r {
    void displayAsrText(Pair<String, String> r100);

    void startVoiceInput(Function1<? super String, Unit> r100);

    void stopVoiceInput(Function1<? super Integer, Unit> r100);
}
